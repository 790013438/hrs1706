package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Dept;

/**
 * �������ҵ��ӿ�
 * @author ���
 *
 */
public interface DeptService {
	
	/**
	 * ɾ������
	 * @param no ���ű��
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	boolean removeDeptByNo(Integer no);

	/**
	 * �г����в���
	 * @return ���沿�Ŷ�����б�����
	 */
	List<Dept> listAllDepts();
}
