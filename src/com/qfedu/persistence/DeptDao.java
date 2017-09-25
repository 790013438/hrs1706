package com.qfedu.persistence;

import java.util.List;

import com.qfedu.domain.Dept;

/**
 * �������ݷ��ʶ���ӿ�
 * @author ���
 *
 */
public interface DeptDao {

	/**
	 * ���沿��
	 * @param dept ���Ŷ���
	 * @return ����ɹ�����true���򷵻�false
	 */
	boolean save(Dept dept);
	
	/**
	 * ɾ������
	 * @param no ���ű��
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	boolean deleteByNo(Integer no);
	
	/**
	 * ���²���
	 * @param dept ���Ŷ���
	 * @return ���³ɹ�����true���򷵻�false
	 */
	boolean update(Dept dept);
	
	/**
	 * ���ݲ��ű�Ų�ѯ����
	 * @param no ���ű��
	 * @return ���Ŷ����null
	 */
	Dept findById(Integer no);
	
	/**
	 * ��ѯ���в���
	 * @return ���沿�Ŷ�����б�����
	 */
	List<Dept> findAll();
	
	/**
	 * ��ѯ��������
	 * @param no ���ű��
	 * @return ��������
	 */
	int countEmpByNo(Integer no);
}
