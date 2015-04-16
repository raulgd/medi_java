<!DOCTYPE html>
<%@include file="/WEB-INF/jspf/sessionCheck.jspf" %>
<html>
	<head>
		<meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
			Medi - The Medical Inventory Web Application
    </title>
		<script>
			//load the appRoot so the application can be released with any prefixed URL
			var appRoot = '${appRoot}';
		</script>
		<link href="${appRoot}/css/bootstrap.min.css" rel="stylesheet">
		<link href="${appRoot}/css/roboto.min.css" rel="stylesheet">
		<link href="${appRoot}/css/material.min.css" rel="stylesheet">
		<link href="${appRoot}/css/ripples.min.css" rel="stylesheet">
		<link href="${appRoot}/css/main_style.css" rel="stylesheet">
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
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#" id="addArticleBtn" data-toggle="modal" data-target="#articleModal">Add Article</a></li>
						<form class="navbar-form navbar-left">
							<input type="text" id="searchField" class="form-control col-lg-8" placeholder="Search">
						</form>
          </ul>
					<ul class="nav navbar-nav navbar-right">
            <li><a href="${appRoot}/logout">Logout</a></li>
					</ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

		<!-- The inventory list -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="list-group" id="inventory-list">
					</div>
				</div>
			</div>
		</div>

		<!-- article modal -->
		<div class="modal" id="articleModal">
			<div class="modal-dialog">
        <div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Save an article</h4>
					</div>
					<div class="modal-body">
						<br/>
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label for="name" class="col-lg-2 control-label">Name</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="name" placeholder="Name">
									</div>
								</div>
								<div class="form-group">
									<label for="formula" class="col-lg-2 control-label">Formula</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="formula" placeholder="Formula">
									</div>
								</div>
								<div class="form-group">
									<label for="volume" class="col-lg-2 control-label">Volume</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="volume" placeholder="Volume">
									</div>
								</div>
								<div class="form-group">
									<label for="brand" class="col-lg-2 control-label">Brand</label>
									<div class="col-lg-10">
										<select class="form-control" id="brand">
											<option selected>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="usage" class="col-lg-2 control-label">Usage</label>
									<div class="col-lg-10">
										<select class="form-control" id="usage">
											<option selected>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="comments" class="col-lg-2 control-label">Comments</label>
									<div class="col-lg-10">
										<textarea class="form-control" rows="7" id="comments"></textarea>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="closeArticle">Close</button>
						<button type="button" class="btn btn-primary" id="saveArticle">Save</button>
					</div>
        </div>
			</div>
		</div>

		<!-- Add amount modal -->
		<div class="modal" id="addAmountModal">
			<div class="modal-dialog">
        <div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Add articles to inventory</h4>
					</div>
					<div class="modal-body">
						<br/>
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label for="add-amount" class="col-lg-2 control-label">Amount</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="amountAdd" placeholder="Amount">
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" id="addAmountClose" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" id="addAmountSave" class="btn btn-primary">Save</button>
					</div>
        </div>
			</div>
		</div>

		<!-- Remove amount modal -->
		<div class="modal" id="removeAmountModal">
			<div class="modal-dialog">
        <div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Remove articles from inventory</h4>
					</div>
					<div class="modal-body">
						<br/>
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label for="remove-amount" class="col-lg-2 control-label">Amount</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="amountRemove" placeholder="Amount">
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" id="removeAmountClose" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" id="removeAmountSave" class="btn btn-primary">Save</button>
					</div>
        </div>
			</div>
		</div>

    <!-- Bootstrap core JavaScript placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${appRoot}/js/bootstrap.min.js"></script>
		<script src="${appRoot}/js/ripples.min.js"></script>
		<script src="${appRoot}/js/material.min.js"></script>
		<script src="${appRoot}/js/validator.min.js"></script>

		<!-- All the needed Medi scripts -->
		<script src="${appRoot}/js/rest/articles.js"></script>
		<script src="${appRoot}/js/rest/inventory.js"></script>
		<script src="${appRoot}/js/rest/user.js"></script>
		<script src="${appRoot}/js/main.js"></script>

	</body>
</html>
