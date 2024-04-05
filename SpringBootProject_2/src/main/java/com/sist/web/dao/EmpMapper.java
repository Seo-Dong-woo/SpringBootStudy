package com.sist.web.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
public interface EmpMapper {
	/*
	 *  <select id="empListData" resultType="EmpVO">  id=메소드명 resultType=리턴형
			SELECT * FROM emp
		</select>
	 */
	public List<EmpVO> empListData();
}
