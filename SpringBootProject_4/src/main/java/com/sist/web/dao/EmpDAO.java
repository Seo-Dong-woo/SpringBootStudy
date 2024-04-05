package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

import com.sist.web.entity.*;
/*
 *   GetMapping/PostMapping/PutMapping/DeleteMapping
 *   	 |			|			|			|
 *    데이터 검색	 데이터 읽기, 	  Insert	  Delete => CRUD
 *   ==> RestFul
 */
public interface EmpDAO extends JpaRepository<Emp, Integer> {
	// findAll
	public Emp findByEmpno(int empno);
	// public List<Emp> findByEnameContaining(String ename)             LIKE문장
}
