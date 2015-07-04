package br.com.calcard.calsystem.listener;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.service.JobService;
import br.com.calcard.calsystem.service.ParametroService;

public class LoadListener {

	private JobService jobService;

	private ParametroService parametroGlobalService;

	@Autowired
	public LoadListener(ParametroService parametroGlobalService,
			JobService jobService) {
		this.parametroGlobalService = parametroGlobalService;
		this.jobService = jobService;

	}

	public void init() throws SchedulerException, DAOException {

		this.doCarregarParametrosGlobais();

		this.doInicializarJobs();
	}

	private void doCarregarParametrosGlobais() throws DAOException {

		parametroGlobalService.doCarregarParametrosGlobais();

	}

	private void doInicializarJobs() throws SchedulerException {

		jobService.doInicializarJobs();

	}

}
