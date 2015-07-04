package br.com.calcard.calsystem.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calintegrador.motorFraude.exception.IntegracaoFraudeException;
import br.com.calcard.calsystem.service.facade.PropostaServiceFacade;

public class JobTaskService extends QuartzJobBean {

	private PropostaServiceFacade propostaServiceFacade;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		String nomeJob = context.getJobDetail().getKey().getName();

		if (nomeJob.equals(JobService.JOB_ATUALIZA_STATUS_FRAUDE_PROPOSTA))
			this.doAtualizarStatusPropostaMotorFraude();

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

	private void doAtualizarStatusPropostaMotorFraude() {

		try {
			this.propostaServiceFacade.doAtualizarStatusPropostaMotorFraude();
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (IntegracaoFraudeException e) {
			e.printStackTrace();
		}

	}

	public PropostaServiceFacade getPropostaServiceFacade() {
		return propostaServiceFacade;
	}

	public void setPropostaServiceFacade(
			PropostaServiceFacade propostaServiceFacade) {
		this.propostaServiceFacade = propostaServiceFacade;
	}

}
