package br.com.topBalada.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class JobTaskService extends QuartzJobBean {

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		// String nomeJob = context.getJobDetail().getKey().getName();

		// try {
		//
		// JobArquivoTask jobArquivoTask = new JobArquivoTask();
		//
		// jobArquivoTask.setJob(jobService.getJobByNome());
		//
		// Thread thread = new Thread(jobArquivoTask);
		// thread.start();
		//
		// } catch (Exception e) {
		// System.err.println(e);
		// }

	}

}
