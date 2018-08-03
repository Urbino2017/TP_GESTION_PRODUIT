/**
 * 
 */
package metier.entities;

import java.io.Serializable;

/**
 * @author ahoad
 * La création des classes implique que je joue le rôle de developpeur 
 *
 */
public class Produit implements Serializable{
	// Declaration des attributs de la classe Produit
	
	private Long id; 
	private String designation; 
	private double prix; 
	private int quantite;
	
	/**
	 * Constructeur par defaut de la classe Produit
	 */
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param designation
	 * @param prix
	 * @param quantite
	 * Le parametre de l'id produit n'a pas été generé car il considéré comme autoincrement depuis notre base de donnée
	 */
	public Produit(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
// Declaration des Getters et Setters
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", quantite=" + quantite + "]";
	} 

}
