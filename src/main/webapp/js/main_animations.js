/**
 *
 * This defines the needed methods for the animations in the main page
 *
 */

/*************************************************
 * article list animation methods
 *************************************************/

/**
 * Initialize the inventory list articles so they can be animated
 */
function articleListAnimateInit()
{
	var speed = 1650;
	var container = $('#inventory-list');
	var children = container.children();

	if (!container.hasClass("delay-set"))
	{
		container.addClass("delay-set");

		for (var i = 0; i < children.length; i++)
		{
			var child = children[i];
			var childOffset = child.getBoundingClientRect();
			var offset = childOffset.left * 0.8 + childOffset.top;
			var delay = parseFloat(offset / speed).toFixed(2);

			child.style.webkitTransitionDelay = delay + "s";
			child.style.transitionDelay = delay + "s";
		}
	}
	container.addClass("animating-in");
}

/**
 * Animates the article list with a zoom in or out depending on the animation type
 *
 * @param {string} type in or out
 */
function articleListAnimate(type)
{
	var container = $('#inventory-list');
	var opposite = type == "in" ? "out" : "in";
	container.removeClass("animating-" + opposite);
	container.addClass("animating-" + type);
}