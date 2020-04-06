package dominio;

public class DocumentoComercial {

	private String tipoDocumento;
	
	public DocumentoComercial(String unTipoDocumento) {
		this.setTipoDocumento(unTipoDocumento);
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
