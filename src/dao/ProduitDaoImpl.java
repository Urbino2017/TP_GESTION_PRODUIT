/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

/**
 * @author ahoad
 *
 */
public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		// 1. Etablissement de la connexion avant la creation de tout produit

		Connection connection = SingletonConnection.getConnection();

		// 2. Preparation de la requette

		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO PRODUITS ( DESIGNATION, PRIX, QUANTITE) VALUE (?,?,?)");
			// 3. Transmission des valeurs parametres (i.e les poitns d'interrogations) de
			// la requette

			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());

			// 3. Excecution de la requette
			ps.executeUpdate();

			// Creation d'une second requette afin de recuper l'id du produit
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
			ResultSet rs = ps2.executeQuery();

			// Effectuons une traitement sur l'enregistrement
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		// 0. Creation d'une liste de produits

		List<Produit> produits = new ArrayList<>();
		// 1. Etablissement de la connexion avant la creation de tout produit
		Connection connection = SingletonConnection.getConnection();

		try {
			// 2. Preparation de la requette
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			// 3. Transmission des valeurs aux parametres(Ici il s'agit d'un seul parametre
			// qui est la designation) de la requette
			ps.setString(1, mc);

			// 4. Excecution de la requette
			ResultSet rs = ps.executeQuery();
			// 5. Traitement sur l'enregistrement encours
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				// Ajout du produit à la liste
				produits.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public Produit getProduit(Long id) {
		// 0. Recherchons du produit

		Produit p = null;
		// 1. Etablissement de la connexion avant la creation de tout produit
		Connection connection = SingletonConnection.getConnection();

		try {
			// 2. Preparation de la requette
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE id=?");
			// 3. Transmission des valeurs aux parametres(Ici il s'agit d'un seul parametre
			// est l'id du produit) de la requette

			ps.setLong(1, id);

			// 4. Excecution de la requette
			ResultSet rs = ps.executeQuery();
			// 5. Traitement sur l'enregistrement encours
			if (rs.next()) {
				p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit update(Produit p) {
		// 1. Etablissement de la connexion avant la creation de tout produit

		Connection connection = SingletonConnection.getConnection();

		// 2. Preparation de la requette

		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE PRODUITS SET DESIGNATION =?, PRIX =?, QUANTITE =? WHERE ID =?");
			// 3. Transmission des valeurs parametres (i.e les poitns d'interrogations) de
			// la requette

			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());

			// 3. Excecution de la requette
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		// 1. Etablissement de la connexion avant la creation de tout produit

		Connection connection = SingletonConnection.getConnection();

		// 2. Preparation de la requette

		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
			// 3. Transmission des valeurs parametres (i.e les poitns d'interrogations) de
			// la requette

			ps.setLong(1, id);

			// 3. Excecution de la requette
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
