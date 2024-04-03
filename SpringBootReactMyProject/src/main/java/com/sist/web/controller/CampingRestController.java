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
@CrossOrigin("*")
public class CampingRestController {
	@Autowired
	private CampingDAO dao;
	
//	@GetMapping("/camping/list_react")
//	public Map camping_list(int page)
//	{
//		System.out.println("page: " + page);
//		int rowSize=12;
//		int start=(rowSize*page)-rowSize;
//		List<Camping> list=dao.campingListData(start);
//		Map map=new HashMap();
//		int totalpage=dao.campingListTotalPage();
//		final int BLOCK=10;
//		int startPage=((page-1)/BLOCK*BLOCK)+1;
//		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
//		if(endPage>totalpage)
//			endPage=totalpage;
//		
//		map.put("curpage", page);
//		map.put("totalpage", totalpage);
//		map.put("startPage", startPage);
//		map.put("endPage", endPage);
//		map.put("list", list);
//		
//		return map;
//	}
//	
//	@GetMapping("/camping/detail_react")
//	public Map campingDetailData(int mno)
//	{
//		Map map=new HashMap();
//		Camping vo=dao.findByMno(mno);
//		map.put("vo", vo);
//		return map;
//	}
	
	@GetMapping("/camping/list/{page}")
	public ResponseEntity<Map> camping_list(@PathVariable("page") int page){
		Map map=new HashMap();
		try
		{
			int rowSize=20;
			int start=(rowSize*page)-(rowSize);
			List<Camping> cList=dao.campingListData(start);
			int count=(int)dao.count();
			map.put("cList", cList);
			map.put("count", count);
			map.put("curpage", page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PostMapping("/camping/find/{page}/{loc}")
	public ResponseEntity<Map> camping_find(
			@PathVariable("page") int page, @PathVariable("loc") String loc)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize*page)-rowSize;
			List<Camping> cList=dao.campingFindData(loc, start);
			int count=dao.campingFindCount(loc);
			map.put("cList", cList);
			map.put("count", count);
			map.put("curpage", page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/camping/detail/{mno}")
	public ResponseEntity<Camping> camping_detail(@PathVariable("mno") int mno)
	{
		Camping camping=new Camping();
		try
		{
			camping=dao.findByMno(mno);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(camping, HttpStatus.OK);
	}
}
