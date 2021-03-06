package com.wst.mango.admin.service;

import java.util.List;

import com.wst.mango.admin.model.SysConfig;
import com.wst.mango.core.service.CurdService;

/**
 * 系统配置管理
 * @author Wst
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
