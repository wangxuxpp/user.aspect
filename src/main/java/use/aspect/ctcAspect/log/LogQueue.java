package use.aspect.ctcAspect.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import use.aspect.ctcAspect.log.bean.LogInfo;
import use.aspect.ctcAspect.log.bean.LogSaveInterface;

public class LogQueue implements Runnable{

	private boolean enable = true;
	private int logQueueSize = 2048;
	private ArrayBlockingQueue<LogInfo> queue = null;
	private LogSaveInterface fService = null;
	private ExecutorService pool = Executors.newSingleThreadExecutor();

	protected final Logger log = LoggerFactory.getLogger(LogQueue.class);
	
	public LogQueue(int size , boolean isStart)
	{
		logQueueSize = size;
		queue = new ArrayBlockingQueue<LogInfo>(logQueueSize);
		if(isStart)
		{
			executeThread();
		}
	}
	
	public void executeThread()
	{
		pool.execute(this);
	}
	
	public int getLogQueueSize() {
		return logQueueSize;
	}

	public ArrayBlockingQueue<LogInfo> getQueue() {
		return queue;
	}

	public void setQueue(ArrayBlockingQueue<LogInfo> queue) {
		this.queue = queue;
	}	
	
	public void put(LogInfo value)
	{
		try
		{
			queue.offer(value);
		}catch(Exception er){
			log.error("压入日志错误，错误信息："+er.getMessage());
		}
	}
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public LogSaveInterface getFService() {
		return fService;
	}
	public void setFService(LogSaveInterface service) {
		fService = service;
	}
	public void close()
	{
		enable = false;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(enable)
		{
			LogInfo r = null;
			try {
				r = queue.take();
				if(r != null && fService != null)
				{
					try
					{
						fService.saveLog(r);
					}catch(Exception er)
					{
						log.error("调用保存日志错误，错误信息："+er.getMessage());
					}
				}
			} catch (Exception e) {
			}
			
		}
	}
	
}
