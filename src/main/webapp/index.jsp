<!DOCTYPE html>
<%
	/**
	 * If there was an error in logging in, set the variable to reflect the error in the page
	 */
	String errorMsg = "";
	String hasError = "";
	String btnStyle = "btn-primary";
	if (request.getParameter("error") != null)
	{
		switch (Integer.parseInt(request.getParameter("error")))
		{
			case 1:
				errorMsg = "<div class=\"alert alert-danger alert-login\"><strong>Incorrect e-mail address or password</strong></div>";
				break;
			case 2:
				errorMsg = "<div class=\"alert alert-danger alert-login\"><strong>Your session has expired</strong></div>";
				break;
			default:
				errorMsg = "<div class=\"alert alert-danger alert-login\"><strong>Login Error</strong></div>";
		}
	}
	//set the error style for the form fields
	if (!errorMsg.equals(""))
	{
		hasError = "has-error";
		btnStyle = "btn-danger";
	}

	//check, if the user has a session, redirect him to main.jsp
	if (request.getSession(false) != null)
	{
		if (request.getSession(false).getAttribute("user") != null)
		{
			response.sendRedirect(getServletContext().getContextPath() + "/main.jsp");
		}
	}
%>
<html>
	<head>
		<meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
			Medi - The Medical Inventory Web Application
    </title>
		<link href="${appRoot}/css/bootstrap.min.css" rel="stylesheet">
		<link href="${appRoot}/css/roboto.min.css" rel="stylesheet">
		<link href="${appRoot}/css/material.min.css" rel="stylesheet">
		<link href="${appRoot}/css/ripples.min.css" rel="stylesheet">
		<link href="${appRoot}/css/style.css" rel="stylesheet">
	</head>
	<body class="home">
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Medi</a>
        </div>
      </div>
    </nav>

		<!-- The jumbotron banner -->
		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h1>Medical <span class="em-text">Inventory</span></h1>
						<p>A cool inventory made with material design</p>
					</div>
					<div class="col-md-4">
						<div class="well bs-component">
							<form class="form-horizontal" method="post" action="${appRoot}/login" data-toggle="validator" role="form">
								<fieldset>
									<legend>Login</legend>
									<%= errorMsg %>
									<div class="form-group <%= hasError %>">
										<div class="col-lg-10">
											<input type="email" data-error="the email address is invalid" name="email" class="form-control floating-label" id="email" placeholder="e-Mail" required>
										</div>
									</div>
									<div class="form-group <%= hasError %>">
										<div class="col-lg-10">
											<input type="password" name="password" class="form-control floating-label" id="password" placeholder="Password" required>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-10 col-lg-offset-6">
											<button type="submit" class="btn <%= btnStyle %>">Enter</button>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- The GitHub link -->
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-1">
					<h1>Get the source code of this demo at GitHub <a href="https://github.com/raulgd/medi" target="_blank"><img class="octocat" src="img/githublogo.png" /></a></h1>
				</div>
			</div>
		</div>

    <!-- Bootstrap core JavaScript placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${appRoot}/js/bootstrap.min.js"></script>
		<script src="${appRoot}/js/ripples.min.js"></script>
		<script src="${appRoot}/js/material.min.js"></script>
		<script src="${appRoot}/js/validator.min.js"></script>
		<script>
			$(document).ready(function () {
				// This command is used to initialize some elements and make them work properly
				$.material.init();
			});
		</script>
	</body>
</html>
