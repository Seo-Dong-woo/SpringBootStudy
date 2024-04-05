package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
	@Autowired
	private FoodDAO fDao;
	/*
	 *   Rest API => 클라이언트와 서버 간의 통신에 필요한 정보를 제공
	 *   => 유지보수
	 *   	=> 상태 코드(정상 수행, 에러 발생 시 => 확인) 응답 => 클라이언트 전송
	 *   	=> public Map food_list...
	 *   	=> 상태 코드 전송
	 *   		ResponseEntity<Map> => 실무에서는 거의 사용법
	 *   	=> get => ?키=값
	 *   	=> /값/값... PathVariable => 값인지 폴더인지
	 */
	
	@GetMapping("/food/list/{page}")
	public ResponseEntity<Map> food_list(@PathVariable("page") int page){
		Map map=new HashMap();
		try
		{
			int rowSize=20;
			int start=(rowSize*page)-(rowSize);
			List<Food> fList=fDao.foodListData(start);
			int count=(int)fDao.count();
			map.put("fList", fList);
			map.put("count", count);
			map.put("curpage", page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PostMapping("/food/find/{page}/{address}")
	public ResponseEntity<Map> food_find(
			@PathVariable("page") int page, @PathVariable("address") String address)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=20;
			int start=(rowSize*page)-rowSize;
			List<Food> fList=fDao.foodFindData(address,start);
			int count=fDao.foodFindCount(address);
			map.put("fList", fList);
			map.put("count", count);
			map.put("curpage", page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/food/detail/{fno}")
	public ResponseEntity<Food> food_detail(@PathVariable("fno") int fno)
	{
		Food food=new Food();
		try
		{
			food=fDao.findByFno(fno);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(food, HttpStatus.OK);
	}
}
