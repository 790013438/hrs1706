package com.qfedu.persistence;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;

/**
 * Ա�����ݷ��ʶ���ӿ�
 * @author ���
 *
 */
public interface EmpDao extends BaseDao<Emp, Integer> {

	/**
	 * ���ݲ��ű�Ų��Ҹò�������Ա��
	 * @param no ���ű��
	 * @param page ҳ��
	 * @param size ҳ���С
	 * @return ��ҳ������
	 */
	PageBean<Emp> findEmpsByDept(Dept dept, int page, int size);
}
