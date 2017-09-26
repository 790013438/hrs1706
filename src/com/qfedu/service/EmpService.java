package com.qfedu.service;

import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

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
	PageBean<EmpDto> listAllEmpsByDeptNo(Integer no, int page, int size);

	/**
	 * ����Ա����Ų�ѯԱ��
	 * @param no Ա�����
	 * @return Ա�������null
	 */
	Emp getEmpByNo(int no);
}
