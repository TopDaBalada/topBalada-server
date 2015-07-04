package br.com.calcard.calsystem.service;

import java.util.HashMap;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calsystem.service.facade.PropostaServiceFacade;

@Service
public class JobService {

	public static final String JOB_ATUALIZA_STATUS_FRAUDE_PROPOSTA = "ATUALIZA_STATUS_FRAUDE_PROPOSTA";

	private PropostaServiceFacade propostaServiceFacade;

	@Autowired
	public JobService(PropostaServiceFacade propostaServiceFacade) {
		this.propostaServiceFacade = propostaServiceFacade;
	}

	public void doInicializarJobs() {
		this.doIniciarJobAtualizaStatusFraudeProposta();
	}

	private void doIniciarJobAtualizaStatusFraudeProposta() {

		String jobName = JOB_ATUALIZA_STATUS_FRAUDE_PROPOSTA;

		try {

			Scheduler scheduler;

			Map<String, Object> map = new HashMap<String, Object>();
			scheduler = new StdSchedulerFactory().getScheduler();

			map.put("propostaServiceFacade", propostaServiceFacade);

			JobKey jobKey = new JobKey(jobName, jobName);
			JobDetail jobDetail = JobBuilder.newJob(JobTaskService.class)
					.withIdentity(jobKey).setJobData(new JobDataMap(map))
					.build();

			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(jobName, jobName)
					.withSchedule(
							CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
					.build();

			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
