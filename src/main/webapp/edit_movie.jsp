<!DOCTYPE html>
<%@page import="dto.Movie"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
</head>
<body>
	<%
	Movie movie = (Movie) request.getAttribute("movie");
	%>
	<div align="center">
		<h1>Update Movie</h1>
		<form action="edit-movie" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="<%=movie.getId()%>">
			Movie Name: <input type="text" name="name"
				value="<%=movie.getName()%> placeholder=" Movie
				Name" required="required"> <br> <br> Movie
			Language: <select name="language" required="required">
				<option disabled selected value="<%=movie.getLanguage()%>">--Select
					Language--</option>
				<option value="hindi">Hindi</option>
				<option value="punjabi">Punjabi</option>
				<option value="kannada">Kannada</option>
				<option value="telgu">Telgu</option>
				<option value="tamil">Tamil</option>
				<option value="marathi">Marathi</option>
			</select> <br> <br> Rating: <input type="number" name="rating"
				value="<%=movie.getRating()%>"
				placeholder=" Movie
				Ratings" required="required"> <br> <br> Image: <img
				height="75px" width="75px" alt="<%=movie.getPicture()%>"
				src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movie.getPicture())%>">
			required="required"> <br> <br> Genre: <select
				name="genre" required="required">
				<option disabled selected value="<%=movie.getGenre()%>">--Select Genre--</option>
				<option value="comedy">Comedy</option>
				<option value="horror">Horror</option>
				<option value="documentary">Documentary</option>
				<option value="adventure">Adventure</option>
				<option value="survival">Survival</option>
				<option value="thriller">Thriller</option>
				<option value="sci-fi">Sci-Fi</option>
				<option value="action">Action</option>
				<option value="romantic">Romantic</option>
			</select> <br> <br>

			<button>Update</button>
		</form>
	</div>
</body>
</html>