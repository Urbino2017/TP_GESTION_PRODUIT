/**
 * 
 */
package dao;

import java.util.List;

import metier.entities.Produit;

/**
 * @author ahoad
 * La creation d'une interface veut dire que je joue le r�le de concepteur 
 */
public interface IProduitDao {
	
	/**
	 * @param p
	 * @return Cette methode permet de creer non seulement un produit mais aussi de renvoyer des informations 
	 *  li� au produit lors de sa cr�ation 
	 */
	public Produit save( Produit p); 
	/**
	 * @param mc
	 * @return Cette methode permet de chercher un produit passant par un mot cl� en revoyant une liste de produit trouver 
	 */
	public List<Produit> produitsParMC( String mc);  
	
	/**
	 * @param id
	 * @return Cette methode permet de consulter un produit (nb: D'ou son type de retour est de type produit) 
	 */
	public Produit getProduit( Long id); 
	
	/**
	 * @param p
	 * @return Cette methode permet de faire la mise � jour d'un produit 
	 */
	public Produit update( Produit p); 
	
	public void deleteProduit( Long id); 
}
