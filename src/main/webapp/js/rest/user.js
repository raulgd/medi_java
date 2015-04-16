/**
 *
 * This defines all REST calls to the user document
 *
 */

/******************************************
 * AJAX calls
 ******************************************/

var userController =
				{
					//the current logged in user
					"user": null,
					/**
					 * Get the logged in user information
					 *
					 * @param {function} successCallback
					 * @param {function} errorCallback
					 */
					"get": function (successCallback, errorCallback)
					{
						$.ajax(
										{
											"url": appRoot + "/rest/user",
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