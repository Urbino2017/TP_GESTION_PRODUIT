<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Liste des Produits</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-10 col-md-offset-1">
	<div class="panel panel-primary">
	  <div class="panel-heading">Recherche des produits</div>
	  <div class="panel-body">
	    <form action="chercher.php" method="get">
	    	Mot Clé: <input type="text" name="motCle" value="${model.motCle }"/> <!-- La valeur du value me permet de garder la valeur de recherche dans la zone de recherche -->
	    	<button type="submit" class="btn btn-primary">Chercher</button>
	    </form>
	    <table class="table table-striped">
	    	<tr>
	    	<th>ID</th><th>DESIGNATION</th><th>PRIX</th><th>QUANTITE</th>
	    	</tr>
<!-- ${model.produits}: On demande à jstl de nous chercher dans le context i.e dans l'objet request un attribut qui s'appelle model qui contient une liste s'appelle produits.
On lui donne un nom de variable p i.e pour chaque produit p dans la liste des produits qui se trouvent dans le modele-->
	    	
	    	<c:forEach items="${model.produits}" var="p">
	    		<tr>
	    			<td>${p.id}</td>
	    			<td>${p.designation}</td>
	    			<td>${p.prix}</td>
	    			<td>${p.quantite}</td>
	    			<td><a onclick="return confirm('Êtes-vous sûre de la suppression?')" href="Supprime.php?id=${p.id }">Supprimer</a></td>
	    			<td><a href="Edit.php?id=${p.id }">Edit</a></td>
	    		</tr>
	    	</c:forEach>
	    </table>
	  </div>
	</div>
</div>
<script type="application/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="application/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>