package br.com.topBalada.listener;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.calcard.calframework.exception.DAOException;
import br.com.topBalada.service.JobService;

public class LoadListener {

	private JobService jobService;

	@Autowired
	public LoadListener(JobService jobService) {

		this.jobService = jobService;

	}

	public void init() throws SchedulerException, DAOException {

		this.doCarregarParametrosGlobais();

		this.doInicializarJobs();
	}

	private void doCarregarParametrosGlobais() throws DAOException {

	}

	private void doInicializarJobs() throws SchedulerException {

		jobService.doInicializarJobs();

	}

}
