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
		<link href="css/main_style.css" rel="stylesheet">
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
            <li><a href="#" data-toggle="modal" data-target="#articleModal">Add Article</a></li>
						<form class="navbar-form navbar-left">
							<input type="text" class="form-control col-lg-8" placeholder="Search">
						</form>
          </ul>
					<ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:void(0)">Logout</a></li>
					</ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


		<!-- The GitHub link -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="list-group" id="inventory-list">
						<div class="list-group-item">
							<div class="row-content">
								<div class="least-content">
									25 items<br/>
									<div class="icon-preview">
										<a href="#" data-toggle="modal" data-target="#addAmountModal"><i class="mdi-content-add"></i></a>&nbsp;&nbsp;
										<a href="#" data-toggle="modal" data-target="#removeAmountModal"><i class="mdi-content-remove"></i></a>
									</div>
								</div>
								<h4 class="list-group-item-heading"><a href="#" data-toggle="modal" data-target="#articleModal">Tile with a label</a></h4>
								<p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus.</p>
							</div>
						</div>
						<div class="list-group-separator-full"></div>
						<div class="list-group-item">
							<div class="row-content">
								<div class="least-content">
									25 items<br/>
									<div class="icon-preview">
										<a href="#" data-toggle="modal" data-target="#addAmountModal"><i class="mdi-content-add"></i></a>&nbsp;&nbsp;
										<a href="#" data-toggle="modal" data-target="#removeAmountModal"><i class="mdi-content-remove"></i></a>
									</div>
								</div>
								<h4 class="list-group-item-heading"><a href="#" data-toggle="modal" data-target="#articleModal">Tile with a label</a></h4>
								<p class="list-group-item-text">Maecenas sed diam eget risus varius blandit.</p>
							</div>
						</div>
						<div class="list-group-separator-full"></div>
						<div class="list-group-item">
							<div class="row-content">
								<div class="least-content">
									25 items<br/>
									<div class="icon-preview">
										<a href="#" data-toggle="modal" data-target="#addAmountModal"><i class="mdi-content-add"></i></a>&nbsp;&nbsp;
										<a href="#" data-toggle="modal" data-target="#removeAmountModal"><i class="mdi-content-remove"></i></a>
									</div>
								</div>
								<h4 class="list-group-item-heading"><a href="#" data-toggle="modal" data-target="#articleModal">Tile with a label</a></h4>
								<p class="list-group-item-text">Maecenas sed diam eget risus varius blandit.</p>
							</div>
						</div>
						<div class="list-group-separator-full"></div>
					</div>
				</div>
			</div>
		</div>

		<!-- article modal -->
		<div class="modal" id="articleModal">
			<div class="modal-dialog">
        <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
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
									<label for="volume" class="col-lg-2 control-label">Volume</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="volume" placeholder="Volume">
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
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save</button>
					</div>
        </div>
			</div>
		</div>

		<!-- Add amount modal -->
		<div class="modal" id="addAmountModal">
			<div class="modal-dialog">
        <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title">Add articles to inventory</h4>
					</div>
					<div class="modal-body">
						<br/>
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label for="add-amount" class="col-lg-2 control-label">Amount</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="add-amount" placeholder="Amount">
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save</button>
					</div>
        </div>
			</div>
		</div>

		<!-- Remove amount modal -->
		<div class="modal" id="removeAmountModal">
			<div class="modal-dialog">
        <div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title">Remove articles from inventory</h4>
					</div>
					<div class="modal-body">
						<br/>
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label for="remove-amount" class="col-lg-2 control-label">Amount</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" id="remove-amount" placeholder="Amount">
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save</button>
					</div>
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
