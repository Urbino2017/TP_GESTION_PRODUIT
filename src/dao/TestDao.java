/**
 * 
 */
package dao;

import java.util.List;

import metier.entities.Produit;

/**
 * @author ahoad
 *
 */
public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProduitDaoImpl dao = new ProduitDaoImpl();

//		Produit p1 = dao.save(new Produit("HP 6580", 900, 45));
//		Produit p2 = dao.save(new Produit("Imprimante Epson 760", 1000, 15));
//
//		System.out.println(" Produit 1 " + p1.toString());
//		System.out.println(" Produit 2 " + p2.toString());
		System.out.println(
				"-------------------------Test liste Produits---------------------------------------------------");

		System.out.println("Cherchons des produits");
		List<Produit> prods = dao.produitsParMC( "%H%");
		for (Produit p : prods) {
			System.out.println(p.toString());
		}
	}

}
