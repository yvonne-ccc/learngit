package com.topsec.tam.api;

import com.topsec.tam.api.domain.Alarm;
import com.topsec.tam.api.domain.AlarmHistory;
import com.topsec.tam.api.domain.MoObject;
import com.topsec.tam.api.exception.TamException;
import com.topsec.tap.query.util.TapQuery;
import com.topsec.tap.query.util.TapQueryResult;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AlarmApi {
	/**
	 * 查询出所有对象
	 * 
	 * @return
	 * @throws TamException
	 */
	List<Alarm> queryAllAlarm();

	/**
	 * 根据uuid查找对象
	 * 
	 * @param uuid
	 *            uuid
	 * @return 对象
	 */
	Alarm getAlarmByUuid(String uuid);

	/**
	 * 按TapPage 条件进行查询
	 * 
	 * @param tapQuery
	 * @return
	 */
	TapQueryResult queryAlarm(TapQuery tapQuery);

	/**
	 * 创建告警
	 * 
	 * @param alarm
	 * @return
	 * @throws TamException
	 */
	Alarm createAlarm(Alarm alarm) throws TamException;

	/**
	 * 修改对象
	 * 
	 * @param alarm
	 *            对象
	 * @return 修改后的对象
	 * @throws TamException
	 *             异常
	 */
	Alarm modifyAlarm(Alarm alarm) throws TamException;

	/**
	 * 删除对象
	 * 
	 * @param alarm
	 *            对象
	 * @throws TamException
	 *             异常
	 */
	void deleteAlarm(Alarm alarm) throws TamException;

	/**
	 * 删除对象
	 * 
	 * @param uuid
	 *            uuid
	 * @throws TamException
	 *             异常
	 */
	void deleteAlarmByUuid(String uuid) throws TamException;

	/**
	 * 根据告警查询告警历史
	 * 
	 * @param uuid
	 * @return
	 */
	public List<AlarmHistory> getAlarmHistorysByAlarm(Alarm alarm);

	/**
	 * 查询前N条告警
	 * 
	 * @param n
	 *            条数
	 * @return 告警对象List
	 */
	public List<com.topsec.tam.api.domain.Alarm> getTopNAlarm(int n);

	/**
	 * 查询前N条告警
	 * 
	 * @param n
	 *            条数
	 * @return 告警对象List
	 */
	public List<com.topsec.tam.api.domain.Alarm> getTopNAlarm(
			MoObject moObject, int n);

	/**
	 * 查询出master监控对象自身告警及slave的告警
	 * 
	 * @param masterMoObj
	 * @param n
	 * @return
	 */
	public List<Alarm> getMasterTopNAlarms(String objId, int n);

	/**
	 * 根据realTimeKey查找.
	 * 
	 * @param realTimeKey
	 * @return
	 */
	public com.topsec.tam.api.domain.Alarm getAlarmByRealTimeKey(
			String realTimeKey);

	/**
	 * 按告警级别统计各级别的告警数量
	 * 
	 * @return
	 */
	Map<String, Object> statAlarmCountByLevel();

	/**
	 * 根据对象的UUID查找告警统计,如果uuid为空则查询所有对象,如果uuid为master对象的uuid则查询其所有子对象的告警,
	 * 如果uuid不为master则查询自身告警.
	 * 
	 * @param moObjectUuuid
	 * @return
	 */
	Map<String, Object> statAlarmCountByLevel(String moObjectUuid);

	/**
	 * 根据masterUuuid和defUuid查找告警统计,如果masterUuuid为空则查询结果为空
	 * 如果defUuid为空则查询当前master的所有定义的告警统计. 如果defUuid不为空,则查询当前master的指定定义的告警统计.
	 * 
	 * @param moObjectUuuid
	 * @return
	 */
	Map<String, Object> statAlarmCountByLevel(String masterUuid, String defUuid);

    Map<String, Object> statAlarmCountByLevel(String masterUuid, String defType,String name);


    public List<Alarm> queryAlarm(Date start ,Date end);


    public List<Alarm> queryAlarm(String objId,String defType,String name,Date start,Date end);

    public boolean isAlarm(Alarm alarm);
}
