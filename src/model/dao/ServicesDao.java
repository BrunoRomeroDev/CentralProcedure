package model.dao;

public interface ServicesDao {

		void execProcedurePMSV_ACESSO(Integer chapa, String intruso);
		void ConsultaAcesso(Integer chapa);
		void execProcedurePMSV_SESSAO(Integer chapa);

}
