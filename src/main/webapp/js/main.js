/**
 *
 * This defines the methods needed for the interactions on button clicks, opening and closing modals, header clicks
 * and other main.jsp page interactions
 *
 */

/*************************************************
 * On page load
 *************************************************/
$(document).ready(function ()
{
	// This command is used to initialize some elements and make them work properly
	$.material.init();

	//call the search service and load the article list
	articleController.search('', function ()
	{
		//on success
		articleList = '<div class="list-group" id="inventory-list">';
		for (var i in articleController.articles)
		{
			a = articleController.articles[i];
			amounts = amount_suffix(a.amount);
			comments = "";
			if (a.comments !== null)
			{
				comments = a.comments;
			}
			articleItem =
							'<div class="list-group-item" id="article-' + a.article_id + '">'
							+ '<div class="row-content">'
							+ '<div class="least-content" id="article-amount-' + a.article_id + '">' + amounts + '<br/>'
							+ '<div class="icon-preview">'
							+ '<a href="#" data-toggle="modal" data-target="#addAmountModal" onClick="amount_add(' + a.article_id + ')"><i class="mdi-content-add"></i></a> &nbsp; &nbsp;'
							+ '<a href="#" data-toggle="modal" data-target="#removeAmountModal" onClick="amount_remove(' + a.article_id + ')"><i class="mdi-content-remove"></i></a>'
							+ '</div>'
							+ '</div>'
							+ '<h4 class="list-group-item-heading"><a href="#" data-toggle="modal" data-target="#articleModal" id="article-title-' + a.article_id + '" onClick="article_edit(' + a.article_id + ')"> ' + a.name + ' </a></h4>'
							+ '<p class="list-group-item-text" id="article-content-' + a.article_id + '">' + a.formula + ' ' + a.volume + '<br/>Usage: ' + a.usage_id.name + '<br/>By ' + a.brand_id.name + ' <br/> ' + comments + ' </p>'
							+ '</div>'
							+ '<div class="list-group-separator-full"></div>'
							+ '</div>';
			articleList += articleItem;
		}
		articleList += "</div>";
		$("#inventory-list").replaceWith(articleList);
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#medi-alert-text').text('There was an error loading the article list');
		}
		else
		{
			$('#medi-alert-text').text(xhr.responseJSON.error);
		}
		$('#medi-alert').removeClass('collapse');
	});
});

//set the amount suffix of item or items
function amount_suffix(amount)
{
	amounts = "";
	if (amount == 0)
	{
		amounts = "0 items";
	}
	else if (amount == 1)
	{
		amounts = "1 item";
	}
	else
	{
		amounts = amount + " items";
	}
	return amounts;
}

/*************************************************
 * On Search
 *************************************************/
$("#searchField").keydown(function (e)
{
	if (e.which == 13)
	{
		e.preventDefault();

		//remove all articles from the list
		$('#inventory-list').replaceWith('<div class="list-group" id="inventory-list"></div>');

		//call the search service and load the article list
		articleController.search($("#searchField").val(), function ()
		{
			//on success
			articleList = '<div class="list-group" id="inventory-list">';
			for (var i in articleController.articles)
			{
				a = articleController.articles[i];
				amounts = amount_suffix(a.amount);
				comments = "";
				if (a.comments !== null)
				{
					comments = a.comments;
				}
				articleItem =
								'<div class="list-group-item" id="article-' + a.article_id + '">'
								+ '<div class="row-content">'
								+ '<div class="least-content" id="article-amount-' + a.article_id + '">' + amounts + '<br/>'
								+ '<div class="icon-preview">'
								+ '<a href="#" data-toggle="modal" data-target="#addAmountModal" onClick="amount_add(' + a.article_id + ')"><i class="mdi-content-add"></i></a> &nbsp; &nbsp;'
								+ '<a href="#" data-toggle="modal" data-target="#removeAmountModal" onClick="amount_remove(' + a.article_id + ')"><i class="mdi-content-remove"></i></a>'
								+ '</div>'
								+ '</div>'
								+ '<h4 class="list-group-item-heading"><a href="#" data-toggle="modal" data-target="#articleModal" id="article-title-' + a.article_id + '" onClick="article_edit(' + a.article_id + ')"> ' + a.name + ' </a></h4>'
								+ '<p class="list-group-item-text" id="article-content-' + a.article_id + '">' + a.formula + ' ' + a.volume + '<br/>Usage: ' + a.usage_id.name + '<br/>By ' + a.brand_id.name + ' <br/> ' + comments + ' </p>'
								+ '</div>'
								+ '<div class="list-group-separator-full"></div>'
								+ '</div>';
				articleList += articleItem;
			}
			articleList += "</div>";
			$("#inventory-list").replaceWith(articleList);
		}, function (xhr, status, errorThrown)
		{
			if (xhr.responseJSON.error == undefined)
			{
				$('#medi-alert-text').text('There was an error loading the article list');
			}
			else
			{
				$('#medi-alert-text').text(xhr.responseJSON.error);
			}
			$('#medi-alert').removeClass('collapse');
		});

		return false;
	}
});

/*************************************************
 * Clear the article form
 *************************************************/
function clear_article_form()
{
	$('#name').val('');
	$('#formula').val('');
	$('#volume').val('');
	$('#brand').replaceWith('<select class="form-control" id="brand"><option value="" selected></option></select>');
	$('#usage').replaceWith('<select class="form-control" id="usage"><option value="" selected></option></select>');
	$('#comments').val('');
	$('#article-alert').addClass('collapse');
}

/*************************************************
 * Load brands and usages into the form
 *************************************************/
function load_brands(selected)
{
	//clear the select
	$('#brand').replaceWith('<select class="form-control" id="brand"><option value="" selected></option></select>');

	//load the brands into the select
	articleController.getBrands(function ()
	{
		brandSelect = '<select class="form-control" id="brand">';
		for (var i in articleController.brands)
		{
			b = articleController.brands[i];
			brandSelect += '<option value="' + b.brand_id + '">' + b.name + '</option>';
		}
		brandSelect += '</select>';
		$('#brand').replaceWith(brandSelect);
		if (selected == 0)
		{
			$('#brand').val('1');
		}
		else
		{
			$('#brand').val(selected.brand_id);
		}
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#article-alert-text').text('There was an error loading the brands');
		}
		else
		{
			$('#article-alert-text').text(xhr.responseJSON.error);
		}
		$('#article-alert').removeClass('collapse');
	});
}

function load_usages(selected)
{
	//clear the select
	$('#usage').replaceWith('<select class="form-control" id="usage"><option value="" selected></option></select>');

	articleController.getUsages(function ()
	{
		usageSelect = '<select class="form-control" id="usage">';
		for (var i in articleController.usages)
		{
			u = articleController.usages[i];
			usageSelect += '<option value="' + u.usage_id + '">' + u.name + '</option>';
		}
		usageSelect += '</select>';
		$('#usage').replaceWith(usageSelect);
		if (selected == 0)
		{
			$('#usage').val('1');
		}
		else
		{
			$('#usage').val(selected.usage_id);
		}
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#article-alert-text').text('There was an error loading the usages');
		}
		else
		{
			$('#article-alert-text').text(xhr.responseJSON.error);
		}
		$('#article-alert').removeClass('collapse');
	});
}

/*************************************************
 * On add Article button click
 *************************************************/
$("#addArticleBtn").click(function ()
{
	//clear the form
	clear_article_form();

	//load brands and usages
	load_brands(0);
	load_usages(0);

	//show the form
	$('#articleModal').modal('show');

	//validate the form to default
	$('#articleForm').validator('validate');
});

/*************************************************
 * On article title click
 *************************************************/
function article_edit(article_id)
{
	articleController.get(article_id, function (obj)
	{
		//clear the form
		clear_article_form();

		articleController.selectedArticle = obj;
		$('#name').val(obj.name);
		$('#formula').val(obj.formula);
		$('#volume').val(obj.volume);
		load_brands(obj.brand_id);
		load_usages(obj.usage_id);
		$('#comments').val(obj.comments);

		//show the form
		$('#articleModal').modal('show');

		//validate the form to default
		$('#articleForm').validator('validate');
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#article-alert-text').text('There was an error loading the article data');
		}
		else
		{
			$('#article-alert-text').text(xhr.responseJSON.error);
		}
		$('#article-alert').removeClass('collapse');
	});
}

/*************************************************
 * On article form Save/close button click
 *************************************************/
$("#saveArticle").click(function ()
{
	//if selected article is null, then create
	if (articleController.selectedArticle === null)
	{
		var article =
						{
							"amount": 0,
							"name": $('#name').val(),
							"formula": $('#formula').val(),
							"volume": $('#volume').val(),
							"comments": $('#comments').val(),
							"brand_id": null,
							"usage_id": null
						};
		selectedBrand = $('#brand').val();
		selectedUsage = $('#usage').val();

		for (var i in articleController.brands)
		{
			a = articleController.brands[i];
			if (selectedBrand == a.brand_id)
			{
				article.brand_id = a;
				break;
			}
		}
		for (var i in articleController.usages)
		{
			u = articleController.usages[i];
			if (selectedUsage == u.usage_id)
			{
				article.usage_id = u;
				break;
			}
		}

		articleController.create(article, function ()
		{
			$('#articleModal').modal('hide');
		}, function (xhr, status, errorThrown)
		{
			if (xhr.responseJSON.error == undefined)
			{
				$('#article-alert-text').text('There was an error saving the article');
			}
			else
			{
				$('#article-alert-text').text(xhr.responseJSON.error);
			}
			$('#article-alert').removeClass('collapse');
		});
	}
	//if selected article present, then edit
	else
	{
		article = articleController.selectedArticle;
		article.name = $('#name').val();
		article.formula = $('#formula').val();
		article.volume = $('#volume').val();
		article.comments = $('#comments').val();

		selectedBrand = $('#brand').val();
		selectedUsage = $('#usage').val();

		for (var i in articleController.brands)
		{
			a = articleController.brands[i];
			if (selectedBrand == a.brand_id)
			{
				article.brand_id = a;
				break;
			}
		}
		for (var i in articleController.usages)
		{
			u = articleController.usages[i];
			if (selectedUsage == u.usage_id)
			{
				article.usage_id = u;
				break;
			}
		}

		articleController.edit(article.article_id, article, function (obj)
		{
			$('#articleModal').modal('hide');
			amounts = amount_suffix(obj.amount);
			articleItem =
							'<div class="list-group-item" id="article-' + obj.article_id + '">'
							+ '<div class="row-content">'
							+ '<div class="least-content" id="article-amount-' + obj.article_id + '">' + amounts + '<br/>'
							+ '<div class="icon-preview">'
							+ '<a href="#" data-toggle="modal" data-target="#addAmountModal" onClick="amount_add(' + obj.article_id + ')"><i class="mdi-content-add"></i></a> &nbsp; &nbsp;'
							+ '<a href="#" data-toggle="modal" data-target="#removeAmountModal" onClick="amount_remove(' + obj.article_id + ')"><i class="mdi-content-remove"></i></a>'
							+ '</div>'
							+ '</div>'
							+ '<h4 class="list-group-item-heading"><a href="#" data-toggle="modal" data-target="#articleModal" id="article-title-' + obj.article_id + '" onClick="article_edit(' + obj.article_id + ')"> ' + obj.name + ' </a></h4>'
							+ '<p class="list-group-item-text" id="article-content-' + obj.article_id + '">' + obj.formula + ' ' + obj.volume + '<br/>Usage: ' + obj.usage_id.name + '<br/>By ' + obj.brand_id.name + ' <br/> ' + obj.comments + ' </p>'
							+ '</div>'
							+ '<div class="list-group-separator-full"></div>'
							+ '</div>';
			$('#article-' + obj.article_id).replaceWith(articleItem);
		}, function (xhr, status, errorThrown)
		{
			if (xhr.responseJSON.error == undefined)
			{
				$('#article-alert-text').text('There was an error saving the article');
			}
			else
			{
				$('#article-alert-text').text(xhr.responseJSON.error);
			}
			$('#article-alert').removeClass('collapse');
		});
	}
	return false;
});

$("#closeArticle").click(function ()
{
	articleController.selectedArticle = null;
	$('#articleModal').modal('hide');
	clear_article_form();
});

/*************************************************
 * On add amount icon click
 *************************************************/
function amount_add(article_id)
{
	articleController.get(article_id, function (obj)
	{
		articleController.selectedArticle = obj;
		$('#addAmountModal').modal('show');
		$('#addArticleForm').validator('validate');
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#addamount-alert-text').text('There was an error loading the article amount');
		}
		else
		{
			$('#addamount-alert-text').text(xhr.responseJSON.error);
		}
		$('#addamount-alert').removeClass('collapse');
	});
}

/*************************************************
 * On add amount form save/close button click
 *************************************************/
$("#addAmountSave").click(function ()
{
	inventoryController.add(articleController.selectedArticle.article_id, $('#amountAdd').val(), function (obj)
	{
		amounts = amount_suffix(obj.amount);
		article_amount = '<div class="least-content" id="article-amount-' + obj.article_id + '">' + amounts + '<br/>'
						+ '<div class="icon-preview">'
						+ '<a href="#" data-toggle="modal" data-target="#addAmountModal" onClick="amount_add(' + obj.article_id + ')"><i class="mdi-content-add"></i></a> &nbsp; &nbsp;'
						+ '<a href="#" data-toggle="modal" data-target="#removeAmountModal" onClick="amount_remove(' + obj.article_id + ')"><i class="mdi-content-remove"></i></a>'
						+ '</div>'
						+ '</div>';
		$('#article-amount-' + obj.article_id).replaceWith(article_amount);
		$('#addAmountModal').modal('hide');
		$('#amountAdd').val('');
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#addamount-alert-text').text('There was an error incrementing the amount');
		}
		else
		{
			$('#addamount-alert-text').text(xhr.responseJSON.error);
		}
		$('#addamount-alert').removeClass('collapse');
	});
	return false;
});

$("#addAmountClose").click(function ()
{
	articleController.selectedArticle = null;
	$('#addAmountModal').modal('hide');
	$('#amountAdd').val('');
	$('#addamount-alert').addClass('collapse');
});

/*************************************************
 * On remove amount icon click
 *************************************************/
function amount_remove(article_id)
{
	articleController.get(article_id, function (obj)
	{
		articleController.selectedArticle = obj;
		$('#removeAmountModal').modal('show');
		$('#removeArticleForm').validator('validate');
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#removeamount-alert-text').text('There wasn an error loading the amount');
		}
		else
		{
			$('#removeamount-alert-text').text(xhr.responseJSON.error);
		}
		$('#removeamount-alert').removeClass('collapse');
	});
}

/*************************************************
 * On remove amount form save/close button click
 *************************************************/
$("#removeAmountSave").click(function ()
{
	inventoryController.substract(articleController.selectedArticle.article_id, $('#amountRemove').val(), function (obj)
	{
		amounts = amount_suffix(obj.amount);
		article_amount = '<div class="least-content" id="article-amount-' + obj.article_id + '">' + amounts + '<br/>'
						+ '<div class="icon-preview">'
						+ '<a href="#" data-toggle="modal" data-target="#addAmountModal" onClick="amount_add(' + obj.article_id + ')"><i class="mdi-content-add"></i></a> &nbsp; &nbsp;'
						+ '<a href="#" data-toggle="modal" data-target="#removeAmountModal" onClick="amount_remove(' + obj.article_id + ')"><i class="mdi-content-remove"></i></a>'
						+ '</div>'
						+ '</div>';
		$('#article-amount-' + obj.article_id).replaceWith(article_amount);
		$('#removeAmountModal').modal('hide');
		$('#amountRemove').val('');
	}, function (xhr, status, errorThrown)
	{
		if (xhr.responseJSON.error == undefined)
		{
			$('#removeamount-alert-text').text('There wasn an error decrementing the amount');
		}
		else
		{
			$('#removeamount-alert-text').text(xhr.responseJSON.error);
		}
		$('#removeamount-alert').removeClass('collapse');
	});
	return false;
});

$("#removeAmountClose").click(function ()
{
	articleController.selectedArticle = null;
	$('#removeAmountModal').modal('hide');
	$('#amountRemove').val('');
	$('#removeamount-alert').addClass('collapse');
});

/*************************************************
 * Alert toggles
 *************************************************/
$('#medi-alert-close').click(function ()
{
	$('#medi-alert').addClass('collapse');
});
$('#article-alert-close').click(function ()
{
	$('#article-alert').addClass('collapse');
});
$('#addamount-alert-close').click(function ()
{
	$('#addamount-alert').addClass('collapse');
});
$('#removeamount-alert-close').click(function ()
{
	$('#removeamount-alert').addClass('collapse');
});