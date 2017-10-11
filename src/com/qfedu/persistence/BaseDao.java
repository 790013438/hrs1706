package com.qfedu.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * ͨ�����ݷ��ʶ���ӿ�
 * @author ���
 *
 * @param <E> ʵ������
 * @param <K> ��ʶ�ֶ�����
 */
public interface BaseDao <E, K extends Serializable> {
	
	/**
	 * ����
	 * @param ʵ�����
	 * @return ����ɹ�����true���򷵻�false
	 */
	K save(E entity);
	
	/**
	 * ɾ��
	 * @param id ��ʶ�ֶ�
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	boolean deleteById(K id);
	
	/**
	 * ����
	 * @param entity ʵ�����
	 * @return ���³ɹ�����true���򷵻�false
	 */
	E update(E entity);
	
	/**
	 * ��ѯ
	 * @param id ��ʶ�ֶ�
	 * @return �����null
	 */
	E findById(K id);
	
	/**
	 * ��ѯ����
	 * @return ���������б�����
	 */
	List<E> findAll();
}
