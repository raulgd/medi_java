<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
			Medi - The Medical Inventory Web Application
    </title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/roboto.min.css" rel="stylesheet">
		<link href="css/material.min.css" rel="stylesheet">
		<link href="css/ripples.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
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
							<form class="form-horizontal" method="post" action="login">
								<fieldset>
									<legend>Login</legend>
									<div class="form-group">
										<div class="col-lg-10">
											<input type="email" class="form-control floating-label" id="email" placeholder="Email">
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-10">
											<input type="password" class="form-control floating-label" id="password" placeholder="Password">
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-10 col-lg-offset-6">
											<button type="submit" class="btn btn-primary">Enter</button>
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
		<script src="js/bootstrap.min.js"></script>
		<script src="js/ripples.min.js"></script>
		<script src="js/material.min.js"></script>
		<script>
			$(document).ready(function () {
				// This command is used to initialize some elements and make them work properly
				$.material.init();
			});
		</script>
	</body>
</html>
