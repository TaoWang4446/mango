package com.wst.mango.admin.service;

import java.util.List;

import com.wst.mango.admin.model.SysDept;
import com.wst.mango.core.service.CurdService;

/**
 * 机构管理
 * @author Wst
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
