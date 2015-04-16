/**
 *
 * This defines all REST calls to the articles, brands and usages documents
 *
 */

/******************************************
 * AJAX calls
 ******************************************/

var articleController =
				{
					//the articles list
					"articles": [],
					//the current selected for editing or amount operations
					"selectedArticle": null,
					//the list of brands
					"brands": [],
					//the list of usages
					"usages": [],
					/**
					 * Search for articles
					 *
					 * @param {string} search
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 */
					"search": function (search, successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/articles/search=" + search,
											"type": "GET",
											"dataType": "json",
											"success": function (obj)
											{
												//load the articles into the list
												articleController.articles = obj;
												successCallback();
											},
											"error": function (xhr, status, errorThrown)
											{
												articleController.articles = [];
												errorCallback(xhr, status, errorThrown);
											}
										});
					},
					/**
					 * Get an article
					 *
					 * @param {number} id
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 */
					"get": function (id, successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/articles/" + id,
											"type": "GET",
											"dataType": "json",
											"success": function (obj)
											{
												successCallback(obj);
											},
											"error": function (xhr, status, errorThrown)
											{
												errorCallback(xhr, status, errorThrown);
											}
										});
					},
					/**
					 * Create an article
					 *
					 * @param {object} article
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 * @returns {object}
					 */
					"create": function (article, successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/articles",
											"type": "POST",
											"dataType": "json",
											"contentType": "application/json",
											"data": JSON.stringify(article),
											"success": function (obj)
											{
												successCallback(obj);
											},
											"error": function (xhr, status, errorThrown)
											{
												errorCallback(xhr, status, errorThrown);
											}
										});
					},
					/**
					 * Edits an article
					 *
					 * @param {number} id
					 * @param {object} article
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 * @returns {object}
					 */
					"edit": function (id, article, successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/articles/" + id,
											"type": "PUT",
											"dataType": "json",
											"contentType": "application/json",
											"data": JSON.stringify(article),
											"success": function (obj)
											{
												successCallback(obj);
											},
											"error": function (xhr, status, errorThrown)
											{
												errorCallback(xhr, status, errorThrown);
											}
										});
					},
					/**
					 * Get the brand list
					 *
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 * @returns {object}
					 */
					"getBrands": function (successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/brands",
											"type": "GET",
											"dataType": "json",
											"success": function (obj)
											{
												//load the articles into the list
												articleController.brands = obj;
												successCallback();
											},
											"error": function (xhr, status, errorThrown)
											{
												articleController.brands = [];
												errorCallback(xhr, status, errorThrown);
											}
										});
					},
					/**
					 * Get the usage list
					 *
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 * @returns {object}
					 */
					"getUsages": function (successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/usages",
											"type": "GET",
											"dataType": "json",
											"success": function (obj)
											{
												//load the articles into the list
												articleController.usages = obj;
												successCallback();
											},
											"error": function (xhr, status, errorThrown)
											{
												articleController.usages = [];
												errorCallback(xhr, status, errorThrown);
											}
										});
					}
				};