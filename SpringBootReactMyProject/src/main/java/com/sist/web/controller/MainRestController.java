package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
	@Autowired
	private Goods1DAO gDao;
	
	@Autowired
	private CampingDAO cDao;
	
//	@GetMapping("/main")
//	public ResponseEntity<Map> main_data(){
//		Map map=new HashMap();
//		try
//		{
//			List<Food> fList=fDao.foodMainListData();
//			Food foodOne=fDao.foodMainOneData();
//			List<Recipe> rList=rDao.recipeMainListData();
//			map.put("fList", fList);
//			map.put("rList", rList);
//			map.put("mFood", foodOne);
//		}catch(Exception ex)
//		{
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(map, HttpStatus.OK);
//	}
	
	@GetMapping("/main")
	public ResponseEntity<Map> main_data(){
		Map map=new HashMap();
		try
		{
			List<Camping> cList=cDao.campingMainData();
			List<Goods1> gList=gDao.goods1MainData();
			map.put("cList", cList);
			map.put("gList", gList);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
//	@GetMapping("/goods1/main_react")
//	public Map goods1MainData()
//	{
//		Map map=new HashMap();
//		List<Goods1> list=dao.goods1MainData();
//		List<Camping> cList=cDao.campingMainData();
//		map.put("list", list);
//		map.put("cList", cList);
//		return map;
//	}
}
