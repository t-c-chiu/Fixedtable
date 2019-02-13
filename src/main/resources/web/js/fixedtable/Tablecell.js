/* Tablecell.js

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 14:56:36 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.

*/
(function () {
fixedtable.Tablecell = zk.$extends(zul.LabelImageWidget, {
	colspan: 1,
	rowspan: 1,
	$define: {
		colspan: function (colspan) {
			var n = this.$n();
			if (n)
				n.colspan = colspan;
		},
		rowspan: function (rowspan) {
			var n = this.$n();
			if (n)
				n.rowspan = rowspan;
		}
	},
	domAttrs_: function () {
		var attrs = this.$supers('domAttrs_', arguments);
		if (this._colspan > 1)
			attrs += ' colspan=' + this._colspan;
		if (this._rowspan > 1)
			attrs += ' rowspan=' + this._rowspan;
		return attrs;
	}
});
})();