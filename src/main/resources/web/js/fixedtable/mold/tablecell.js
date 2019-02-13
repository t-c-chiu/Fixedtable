/* tablecell.js

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 14:55:04 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.

*/
function (out) {
	out.push('<td', this.domAttrs_(), '>', this.domContent_());
	for (var w = this.firstChild; w; w = w.nextSibling)
		w.redraw(out);
	out.push('</td>');
}