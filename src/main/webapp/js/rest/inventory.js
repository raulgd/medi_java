/**
 *
 * This defines all REST calls to the inventory document
 *
 */

/******************************************
 * AJAX calls
 ******************************************/

var inventoryController =
				{
					/**
					 * Add amount of articles
					 *
					 * @param {number} id
					 * @param {amount} amount
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 */
					"add": function (id, amount, successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/inventory/" + id + "/amount+" + amount,
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
					 * Substract amount of articles
					 *
					 * @param {number} id
					 * @param {amount} amount
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 */
					"substract": function (id, amount, successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/inventory/" + id + "/amount-" + amount,
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
					}
				};