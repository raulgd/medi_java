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

	//fetch all articles and load them in the articles list
	//call the search service and load the article list
	articleController.search('', function ()
	{
		//on success
		articleList = '<div class="list-group" id="inventory-list">';
		for (var i in articleController.articles)
		{
			a = articleController.articles[i];
			amounts = "";
			if (a.amount === 0)
			{
				amounts = "0 items";
			}
			else if (a.amount === 1)
			{
				amounts = "1 item";
			}
			else
			{
				amounts = a.amount + " items";
			}
			comments = "";
			if (a.comments !== null)
			{
				comments = a.comments;
			}
			articleItem =
							'<div class="list-group-item" id="article-' + a.article_id + '">'
							+ '<div class="row-content">'
							+ '<div class="least-content" id="article-amount-' + a.article_id + '">'
							+ amounts + '<br/>'
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
		//on error
		$("#error-content").text(errorThrown);
		$("#error-panel").show();
	});
});

/*************************************************
 * On Search
 *************************************************/
$("#searchField").keydown(function (e)
{
	if (e.which == 13)
	{
		e.preventDefault();

		//remove all articles from the list
		for (var i in articleController.articles)
		{
			$("#article-" + i.article_id).remove();
		}

		//call the search service and load the article list
		articleController.search($("#searchField").val(), function ()
		{
			//on success
			articleList = '<div class="list-group" id="inventory-list">';
			for (var i in articleController.articles)
			{
				a = articleController.articles[i];
				amounts = "";
				if (a.amount === 0)
				{
					amounts = "0 items";
				}
				else if (a.amount === 1)
				{
					amounts = "1 item";
				}
				else
				{
					amounts = a.amount + " items";
				}
				comments = "";
				if (a.comments !== null)
				{
					comments = a.comments;
				}
				articleItem =
								'<div class="list-group-item" id="article-' + a.article_id + '">'
								+ '<div class="row-content">'
								+ '<div class="least-content" id="article-amount-' + a.article_id + '">'
								+ amounts + '<br/>'
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
			//on error
			$("#error-content").text(errorThrown);
			$("#error-panel").show();
		});

		return false;
	}
});

/*************************************************
 * On add Article button click
 *************************************************/
$("#addArticleBtn").click(function ()
{

});
/*************************************************
 * On article title click
 *************************************************/
function article_edit(article_id)
{

}

/*************************************************
 * On article form Save/close button click
 *************************************************/
$("#saveArticle").click(function ()
{

});
$("#closeArticle").click(function ()
{

});
/*************************************************
 * On add amount icon click
 *************************************************/
function amount_add(article_id)
{

}

/*************************************************
 * On add amount form save/close button click
 *************************************************/
$("#addAmountSave").click(function ()
{

});
$("#addAmountClose").click(function ()
{

});
/*************************************************
 * On remove amount icon click
 *************************************************/
function amount_remove(article_id)
{

}

/*************************************************
 * On remove amount form save/close button click
 *************************************************/
$("#removeAmountSave").click(function ()
{

});
$("#removeAmountClose").click(function ()
{

});
