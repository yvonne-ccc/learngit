package com.topsec.tam.api;

import com.topsec.tam.api.domain.AlarmStatistics;
import com.topsec.tam.api.exception.TamException;
import com.topsec.tap.query.util.TapQuery;

import java.util.List;

public interface AlarmStatisticsApi {
	/**
	 * 查询出所有对象
	 * 
	 * @return
	 * @throws TamException
	 */
	List<AlarmStatistics> queryAllAlarmStat();

	/**
	 * 根据uuid查找对象
	 * 
	 * @param uuid
	 *            uuid
	 * @return 对象
	 */
	AlarmStatistics getAlarmStatByUuid(String uuid);

	/**
	 * 按TapPage 条件进行查询
	 * 
	 * @param tapQuery
	 * @return
	 */
	List<AlarmStatistics> queryAlarmStat(TapQuery tapQuery);
}
