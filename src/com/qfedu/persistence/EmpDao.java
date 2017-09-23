package com.qfedu.persistence;

import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

/**
 * Ա�����ݷ��ʶ���ӿ�
 * @author ���
 *
 */
public interface EmpDao {

	/**
	 * ���ݲ��ű�Ų��Ҹò�������Ա��
	 * @param no ���ű��
	 * @param page ҳ��
	 * @param size ҳ���С
	 * @return ��ҳ������
	 */
	PageBean<EmpDto> findEmpsByDeptNo(Integer no, int page, int size);
	
	/**
	 * ����Ա��
	 * @param emp Ա������
	 * @return ����ɹ�����true���򷵻�false
	 */
	boolean save(Emp emp);
	
	/**
	 * ɾ��Ա��
	 * @param no Ա�����
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	boolean deleteByNo(Integer no);
	
	/**
	 * ����Ա��
	 * @param emp Ա������
	 * @return ���³ɹ�����true���򷵻�false
	 */
	boolean update(Emp emp);
	
	/**
	 * ����Ա����Ų���Ա��
	 * @param no Ա�����
	 * @return Ա�������null
	 */
	Emp findByNo(Integer no);
}
