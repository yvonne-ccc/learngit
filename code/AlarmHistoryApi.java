package com.topsec.tam.api;

import com.topsec.tap.query.util.TapQuery;
import com.topsec.tam.api.domain.AlarmHistory;
import com.topsec.tam.api.exception.TamException;
import java.util.List;

public interface AlarmHistoryApi {
		/**
		 * 查询出所有对象
		 * 
		 * @return
		 * @throws TamException
		 */
		List<AlarmHistory> queryAllAlarmHistorys();
			
    /**
     * 根据uuid查找对象
     *
     * @param uuid uuid
     * @return 对象
     */
    AlarmHistory getAlarmHistoryByUuid(String uuid);

    /**
     * 创建对象
     *
     * @param alarmHistory 对象
     * @return 创建后的对象，有uuid值
     * @throws TamException 异常
     */
    AlarmHistory createAlarmHistory(AlarmHistory alarmHistory) throws TamException;

    /**
     * 修改对象
     *
     * @param alarmHistory 对象
     * @return 修改后的对象
     * @throws TamException 异常
     */
    AlarmHistory modifyAlarmHistory(AlarmHistory alarmHistory) throws TamException;

    /**
     * 删除对象
     *
     * @param alarmHistory 对象
     * @throws TamException 异常
     */
    void deleteAlarmHistory(AlarmHistory alarmHistory) throws TamException;
    
   /**
     * 删除对象
     *
     * @param uuid uuid
     * @throws TamException 异常
     */
    void deleteAlarmHistoryByUuid(String uuid) throws TamException;

 		/**
     * 按TapPage 条件进行查询
     *
     * @param tapQuery
     * @return
     */
    List<AlarmHistory> queryAlarmHistory(TapQuery tapQuery);
}
