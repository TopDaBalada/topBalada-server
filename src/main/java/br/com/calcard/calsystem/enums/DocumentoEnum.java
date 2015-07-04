package br.com.calcard.calsystem.enums;

public class DocumentoEnum {

	
	public enum StatusDocumentoEnum {

		APROVADO("A"), NEGADO("N"), PENDENTE("P");

		private String codigo;

		private StatusDocumentoEnum(String codigo) {
			this.codigo = codigo;
		}

		public String getCodigo() {
			return codigo;
		}

		@Override
		public String toString() {

			return this.codigo;
		}

	}
	
}
