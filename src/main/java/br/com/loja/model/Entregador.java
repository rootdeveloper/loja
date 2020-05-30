package br.com.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import br.com.loja.enums.ModalidadeFrete;

@Entity
@Table(name="entregador")
public class Entregador extends Empresa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
    @Column(name = "modal_frete")
	private ModalidadeFrete modalidadeFrete;

	@Version
	@Column(name = "version")
    private Long version;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModalidadeFrete getModalidadeFrete() {
		return modalidadeFrete;
	}
	
	public void setModalidadeFrete(ModalidadeFrete modalidadeFrete) {
		this.modalidadeFrete = modalidadeFrete;
	}

	public Long getVersion() {
		return version;
	}
}
