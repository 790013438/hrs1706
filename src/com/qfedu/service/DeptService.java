package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Dept;

/**
 * 部门相关业务接口
 * @author 骆昊
 *
 */
public interface DeptService {
	
	/**
	 * 删除部门
	 * @param no 部门编号
	 * @return 删除成功返回true否则返回false
	 */
	boolean removeDeptByNo(Integer no);

	/**
	 * 列出所有部门
	 * @return 保存部门对象的列表容器
	 */
	List<Dept> listAllDepts();
}
