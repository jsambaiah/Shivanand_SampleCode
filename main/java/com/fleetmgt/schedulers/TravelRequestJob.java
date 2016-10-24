/**
 * 
 */
package com.fleetmgt.schedulers;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Shivanand Amalyal
 *
 */
public class TravelRequestJob extends QuartzJobBean {

	private PNRTask pnrTask;

	public PNRTask getPnrTask() {
		return pnrTask;
	}

	public void setPnrTask(PNRTask pnrTask) {
		this.pnrTask = pnrTask;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("In the TravelRequestJob");
		pnrTask.printTask();
		

	}

}
