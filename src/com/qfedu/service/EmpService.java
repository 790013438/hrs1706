package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Emp;

/**
 * Ա�����ҵ��ӿ�
 * @author ���
 *
 */
public interface EmpService {
	
	/**
	 * �����Ա��
	 * @param emp Ա������
	 * @return ��ӳɹ�����true���򷵻�false
	 */
	boolean addNewEmp(Emp emp);

	/**
	 * ���ݲ��ű���г���������Ա��
	 * @param no ���ű��
	 * @return ����Ա��������б�����
	 */
	List<Emp> listAllEmpsByDeptNo(Integer no);
}
