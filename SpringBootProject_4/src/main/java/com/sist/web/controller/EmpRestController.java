package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.dao.*;

@RestController
// 외부에서 포트가 다른 상태로 접근
@CrossOrigin(origins = "*")
public class EmpRestController {
	@Autowired
	private EmpDAO dao;
	
	/*
	// 생성자 주입 방식
	public EmpRestController(EmpDAO dao)
	{
		this.dao=dao;
	}
	*/
	
	@GetMapping("/emp/list")
	public ResponseEntity<List<Emp>> empAllData(){
		List<Emp> list=new ArrayList<Emp>();
		try {
			list=dao.findAll();
		}catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/emp/detail/{empno}") // ~/7788
	public ResponseEntity<Emp> empDetailData(@PathVariable("empno") int empno)
	{
		Emp emp=new Emp();
		try
		{
			emp=dao.findByEmpno(empno);
		}catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	//@PutMapping
	
	//@DeleteMapping
}
