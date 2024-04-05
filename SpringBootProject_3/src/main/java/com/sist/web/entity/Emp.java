package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.*;

@Entity
@Data
public class Emp {
	@Id
	private int empno;
	private int sal, deptno, mgr, comm;
	private String ename, job;
	private String hiredate;
}
