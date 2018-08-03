<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Confirmation Produits</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-8 col-md-offset-2 col-xs-12">
	<div class="panel panel-primary">
	  <div class="panel-heading">Confirmation des infos sur le nouveau produit cr�e:</div>
	  <div class="panel-body">
	    <div class="form-group">
	    	<label>ID:</label>
	    	<label>${produit.id}</label>
	    </div>
	    
	    <div class="form-group">
	    	<label>D�signation:</label>
	    	<label>${produit.designation}</label>
	    </div>	
	    <div class="form-group">
	    	<label>Prix:</label>
	    	<label>${produit.prix}</label>
	    </div>	
	    <div class="form-group">
	    	<label>Quantit�:</label>
	    	<label>${produit.quantite}</label>
	    </div>	
	  </div>
	</div>
</div>
<script type="application/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="application/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>