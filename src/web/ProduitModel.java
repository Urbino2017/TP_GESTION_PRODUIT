/**
 * 
 */
package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

/**
 * @author ahoad
 * Cette classe permet gerer la saisie des mots cl�s l'hors d'une recherche
 */
public class ProduitModel {
	// Deux attributs importantes: Le mot � saisir et la liste � retourner
	private String motCle; 
	private List<Produit> produits = new ArrayList<>();
	/**
	 * @return the motCle
	 */
	public String getMotCle() {
		return motCle;
	}
	/**
	 * @param motCle the motCle to set
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	/**
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}
	/**
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	} 

}
