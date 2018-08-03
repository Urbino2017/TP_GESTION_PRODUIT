<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Enregistrement de Porduits</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-8 col-md-offset-2 col-xs-12">
	<div class="panel panel-primary">
	  <div class="panel-heading">Edit d'un nouveau produit</div>
	  <div class="panel-body">
	    <form action="UpdateProduit.php" method="post">
	       <div class="form-group">
	    		<label class="control-label">ID</label>
	    		<input type="hidden" name="id" class="form-control" value="${produit.id }"/>
	    		<label>${produit.id }</label>
	    		<span></span>
	    	</div>
	    	<div class="form-group">
	    		<label class="control-label">Designation</label>
	    		<input type="text" name="designation" class="form-control" value="${produit.designation }"/>
	    		<span></span>
	    	</div>
	    	<div class="form-group">
	    		<label class="control-label">Prix</label>
	    		<input type="text" name="prix" class="form-control" value="${produit.prix }"/>
	    		<span></span>
	    	</div>
	    	<div class="form-group">
	    		<label class="control-label">Quantite</label>
	    		<input type="text" name="quantite" class="form-control" value="${produit.quantite }"/>
	    		<span></span>
	    	</div>
	    	<div>
	    		<button type="submit" class="btn btn-primary">Update</button>
	    	</div>
	    </form>
	    
	  </div>
	</div>
</div>
<script type="application/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="application/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>