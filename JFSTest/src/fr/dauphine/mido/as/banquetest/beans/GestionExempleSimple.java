package fr.dauphine.mido.as.banquetest.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@ManagedBean
@SessionScoped
public class GestionExempleSimple implements Serializable {
	static final long serialVersionUID = 1L;
	Integer id = null;
	String libelle = null;

	public GestionExempleSimple() {
	}

	public String getResponse() {
		String retour = null;
		ExempleSimple exempleSimple = new ExempleSimple();
		exempleSimple.setId(getId());
		exempleSimple.setLibelle(getLibelle());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFTest");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(exempleSimple);
		et.commit();
		exempleSimple = em.find(ExempleSimple.class, getId());
		retour = "insertion ok";
		return retour;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}