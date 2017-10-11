package com.qfedu.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * 通用数据访问对象接口
 * @author 骆昊
 *
 * @param <E> 实体类型
 * @param <K> 标识字段类型
 */
public interface BaseDao <E, K extends Serializable> {
	
	/**
	 * 保存
	 * @param 实体对象
	 * @return 保存成功返回true否则返回false
	 */
	K save(E entity);
	
	/**
	 * 删除
	 * @param id 标识字段
	 * @return 删除成功返回true否则返回false
	 */
	boolean deleteById(K id);
	
	/**
	 * 更新
	 * @param entity 实体对象
	 * @return 更新成功返回true否则返回false
	 */
	E update(E entity);
	
	/**
	 * 查询
	 * @param id 标识字段
	 * @return 对象或null
	 */
	E findById(K id);
	
	/**
	 * 查询所有
	 * @return 保存对象的列表容器
	 */
	List<E> findAll();
}
