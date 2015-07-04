package br.com.topBalada.service;

import org.springframework.stereotype.Service;

@Service
public class JobService {

	public JobService() {

	}

	public void doInicializarJobs() {
		this.doIniciarJobAtualizaStatusFraudeProposta();
	}

	private void doIniciarJobAtualizaStatusFraudeProposta() {

		// String jobName = JOB_ATUALIZA_STATUS_FRAUDE_PROPOSTA;
		//
		// try {
		//
		// Scheduler scheduler;
		//
		// Map<String, Object> map = new HashMap<String, Object>();
		// scheduler = new StdSchedulerFactory().getScheduler();
		//
		// map.put("propostaServiceFacade", propostaServiceFacade);
		//
		// JobKey jobKey = new JobKey(jobName, jobName);
		// JobDetail jobDetail = JobBuilder.newJob(JobTaskService.class)
		// .withIdentity(jobKey).setJobData(new JobDataMap(map))
		// .build();
		//
		// Trigger trigger = TriggerBuilder
		// .newTrigger()
		// .withIdentity(jobName, jobName)
		// .withSchedule(
		// CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
		// .build();
		//
		// scheduler.start();
		// scheduler.scheduleJob(jobDetail, trigger);
		//
		// } catch (SchedulerException e) {
		// e.printStackTrace();
		// }

	}

}
