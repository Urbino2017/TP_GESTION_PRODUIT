/**
 * 
 */
package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

/**
 * @author ahoad
 *
 */
@WebServlet(name = "cs", urlPatterns = { "*.php" })
public class ControlerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591947576274559955L;
	IProduitDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl(); // Utilisation d'un couple fort pour cause de manipulation de la classe et non
										// de l'interface
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Syntaxe de lecture du motCle par l'attribut path
		
		String path=request.getServletPath(); 
		// Test au chargement de la page
		if (path.equals( "/index.php")) {
			request.getRequestDispatcher( "JSP/produits.jsp").forward(request, response);	
		}else if (path.equals( "/chercher.php")) {
			// Recuperation du parametre de la requete qui est le mot clé ici
			String motCle = request.getParameter( "motCle"); 
			// Crreation d'un objet de type modele à manipuler
			ProduitModel model= new ProduitModel(); 
			model.setMotCle(motCle);
			List<Produit> produits = metier.produitsParMC( "%"+motCle+"%"); 	
			model.setProduits(produits);
			request.setAttribute( "model", model);
			request.getRequestDispatcher( "JSP/produits.jsp").forward(request, response);
			
		}else if (path.equals( "/Saisie.php")) {
			request.setAttribute( "produit", new Produit()); // Recuperation d'une donnée par defaut avant toute action effectuée la page saisie
			request.getRequestDispatcher( "JSP/SaisieProduit.jsp").forward(request, response);	
		}
		else if (path.equals( "/SaveProduit.php")&&(request.getMethod().equals( "POST"))) {
			// Lecture des données
			String des = request.getParameter( "designation"); 
			double prix = Double.parseDouble( request.getParameter( "prix")); // Je lis la donnée saisie dans prix puis je la convertie en double
			int quantite = Integer.parseInt( request.getParameter( "quantite")); 
			Produit p = metier.save( new Produit(des, prix, quantite)); 
			// Stockage du produit dans l'objet request
			request.setAttribute( "produit", p);
			// Confirmation de saisie
			request.getRequestDispatcher( "JSP/Confirmation.jsp").forward(request, response);	
		}else if (path.equals( "/Supprime.php")) {
			// Recuperation du parametre id de la requette
			Long id= Long.parseLong( request.getParameter( "id")); 
			metier.deleteProduit(id);
			//request.getRequestDispatcher( "JSP/produits.jsp").forward(request, response);	
			/* Difference entre forward et redirect
			 *  Forward: Le client envoie une requette vers le contener web, requette reçu par le controler, qui a son tour va à la recherche de la reponse et par la suite repond au client
			 *  NB: Une seule reuete en mise en jeu
			 *  
			 *  Redirect: Lorsque le client envoie la requette, la redirect ne repond pas directement au client mais lui fournit une adresse par laquelle ce dernier passera pour se solutionner
			 */
			
			response.sendRedirect( "chercher.php?motCle=");
		}
		else if ( path.equals( "/Edit.php")) {
			// Recuperation du paramètre id de la requete
			Long id = Long.parseLong( request.getParameter( "id")); 
			Produit p = metier.getProduit(id); 
			request.setAttribute( "produit", p);
			request.getRequestDispatcher( "JSP/EditProduit.jsp").forward(request, response);	
		}
		else if (path.equals( "/UpdateProduit.php")&&(request.getMethod().equals( "POST"))) {
			// Lecture des données
			Long id = Long.parseLong( request.getParameter( "id")); 
			String des = request.getParameter( "designation"); 
			double prix = Double.parseDouble( request.getParameter( "prix")); // Je lis la donnée saisie dans prix puis je la convertie en double
			int quantite = Integer.parseInt( request.getParameter( "quantite")); 
			Produit p = new Produit(des, prix, quantite); 
			p.setId(id);// J'aurai pu l'eviter mais dommage que je n'ai pas un contructeur contenant l'id
			// Stockage du produit dans l'objet request
			
			metier.update(p); 
			request.setAttribute( "produit", p);
			// Confirmation de saisie
			request.getRequestDispatcher( "JSP/Confirmation.jsp").forward(request, response);	
		}
		else {
			response.sendError( Response.SC_NOT_FOUND);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
