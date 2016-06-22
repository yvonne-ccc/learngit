package com.topsec.tam.api;

import com.topsec.tap.collector.base.domain.task.*;
import com.topsec.tam.api.exception.TamException;

public interface AgentTaskApi {

	//public Task getTask(String id);

	public TaskDetail createTask(TaskDetail task) throws TamException;
	
	public TaskDetail getTask(String protocol, String objId, String uuid) throws TamException;
	
	public void delTask(String protocol, String objId, String uuid) throws TamException;
}
