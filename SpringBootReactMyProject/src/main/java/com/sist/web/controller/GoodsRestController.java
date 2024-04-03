package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin("*")
public class GoodsRestController {
	@Autowired
	private Goods1DAO dao;
	
	@Autowired
	private CampingDAO cDao;
	
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
//		
//	@GetMapping("/goods1/list_react")
//	public Map goods1ListData(int page)
//	{
//		System.out.println("page: " + page);
//		int rowSize=9;
//		int start=(rowSize*page)-rowSize;
//		List<Goods1> list=dao.goods1ListData(start);
//		Map map=new HashMap();
//		int totalpage=dao.goods1ListTotalPage();
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
//	@GetMapping("/goods1/detail_react")
//	public Map goods1DetailData(int gno)
//	{
//		Map map=new HashMap();
//		Goods1 vo=dao.findByGno(gno);
//		map.put("vo", vo);
//		return map;
//	}
	
	@GetMapping("/goods1/list/{page}")
	public ResponseEntity<Map> goods1_list(@PathVariable("page") int page){
		Map map=new HashMap();
		try
		{
			int rowSize=20;
			int start=(rowSize*page)-(rowSize);
			List<Goods1> gList=dao.goods1ListData(start);
			int count=(int)dao.count();
			map.put("gList", gList);
			map.put("count", count);
			map.put("curpage", page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/goods1/detail/{gno}")
	public ResponseEntity<Goods1> goods1_detail(@PathVariable("gno") int gno)
	{
		Goods1 goods1=new Goods1();
		try
		{
			goods1=dao.findByGno(gno);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(goods1, HttpStatus.OK);
	}
}
