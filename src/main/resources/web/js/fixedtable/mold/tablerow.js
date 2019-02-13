/* tablerow.js

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 14:54:59 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.

*/
function (out) {
	out.push('<tr ', this.domAttrs_(), '>');
	for (var w = this.firstChild; w; w = w.nextSibling)
		w.redraw(out);
	out.push('</tr>');
}