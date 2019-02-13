/* Tablerow.js

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 14:56:27 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.

*/
(function () {
fixedtable.Tablerow = zk.$extends(zul.Widget, {
	_selectable: true,
	$define: {
		value: null,
		selected: function (selected) {
			var n = this.$n();
			if (n)
				jq(n).toggleClass(this.$s('selected'), selected);
		},
		disabled: function (disabled) {
			var n = this.$n();
			if (n)
				jq(n).toggleClass(this.$s('disabled'), disabled);
		},
		selectable: function (selectable) {

		}
	},
	bind_: function () {
		this.$supers('bind_', arguments);
		this._adjustBorder();
	},
	unbind_: function () {
		this.$supers('unbind_', arguments);
	},
	_adjustBorder: function () {
		var fixedLeft = this.parent.getFixedLeft();
		if (fixedLeft) {
			var children = jq(this.$n()).children();
			children.eq(fixedLeft - 1).css('border-right', '1px solid');
			children.eq(fixedLeft).css('border-left', 'none');
		}
	},
	doSelect_: function (event) {
		if (this._selectable && !this._disabled && !this._selected) {
			this._getTable()._select(this, event.which);
		}
	},
	_getTable: function () {
		return this.parent;
	}
});
})();