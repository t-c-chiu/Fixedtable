/**
 *
 * Base naming rule:
 * The stuff start with "_" means private , end with "_" means protect ,
 * others mean public.
 *
 * All the member field should be private.
 *
 * Life cycle: (It's very important to know when we bind the event)
 * A widget will do this by order :
 * 1. $init
 * 2. set attributes (setters)
 * 3. rendering mold (@see mold/fixedtable.js )
 * 4. call bind_ to bind the event to dom .
 *
 * this.deskop will be assigned after super bind_ is called,
 * so we use it to determine whether we need to update view
 * manually in setter or not.
 * If this.desktop exist , means it's after mold rendering.
 *
 */
(function () {

fixedtable.Fixedtable = zk.$extends(zul.Widget, {
	_fixedTop: 0,
	_fixedRight: 0,
	_fixedBottom: 0,
	_fixedLeft: 0,
	$define: {
		fixedTop: function (fixedTop) {
			if (this.desktop)
				this.rerender();
		},
		fixedRight: function (fixedRight) {
			if (this.desktop)
				this.rerender();
		},
		fixedBottom: function (fixedBottom) {
			if (this.desktop)
				this.rerender();
		},
		fixedLeft: function (fixedLeft) {
			if (this.desktop)
				this.rerender();
		}
	},
	bind_: function () {
		this.$supers('bind_', arguments);
		this._initTableWidth();
		this._initStickyCells();
		this._adjustBorder();
	},
	_initTableWidth: function () {
		var columns = this._getTablecolumns();
		if (columns) {
			var width = 0;
			for (var column = columns.firstChild; column; column = column.nextSibling)
				width += jq(column.$n()).width();
			jq(this.$n('table')).width(width);
		}
	},
	_initStickyCells: function () {
		var tablerows = this._getTablerows(),
			bottomRows = [],
			stickyTop = 0,
			stickyBottom = 0;
		for (var i = 0; i < tablerows.length; i++) {
			var tablerow = tablerows[i],
				cells = jq(tablerow.$n()).children(),
				leftCells = cells.slice(0, this.getFixedLeft()),
				rightCells = cells.slice(cells.length - this.getFixedRight(), cells.length),
				stickyLeft = 0,
				stickyRight = 0;
			leftCells.addClass(this.$s('fixed-left'));
			for (var j = 0; j < leftCells.length; j++) {
				var cell = jq(leftCells[j]);
				cell.css('left', stickyLeft);
				stickyLeft += leftCells[j].getBoundingClientRect().width;
			}
			rightCells.addClass(this.$s('fixed-right'));
			for (var k = rightCells.length - 1; k >= 0; k--) {
				var cell = jq(rightCells[k]);
				cell.css('right', stickyRight);
				stickyRight += rightCells[k].getBoundingClientRect().width;
			}
			if (i < this.getFixedTop()) {
				cells.addClass(this.$s('fixed-top'));
				cells.css('top', stickyTop);
				stickyTop += tablerow.$n().getBoundingClientRect().height;
			}
			if (tablerows.length - i <= this.getFixedBottom()) {
				bottomRows.push(tablerow);
			}
		}
		for (var i = bottomRows.length - 1; i >= 0; i--) {
			var cells = jq(bottomRows[i]).children();
			cells.addClass(this.$s('fixed-bottom'));
			cells.css('bottom', stickyBottom);
			stickyBottom += bottomRows[i].$n().getBoundingClientRect().height;
		}
	},
	_adjustBorder: function (tablerows) {
		var fixedTop = this.getFixedTop();
		if (fixedTop) {
			var tablerows = this._getTablerows();
			jq(tablerows[fixedTop - 1].$n()).children().css('border-bottom', '1px solid');
			jq(tablerows[fixedTop].$n()).children().css('border-top', 'none');
		}
	},
	_getTablerows: function () {
		var tablerows = [],
			child = this.firstChild;
		while (child) {
			if (child.$instanceof(fixedtable.Tablerow))
				tablerows.push(child);
			child = child.nextSibling;
		}
		return tablerows;
	},
	_getTablecolumns: function () {
		var firstChild = this.firstChild;
		return firstChild.$instanceof(fixedtable.Tablecolumns) ? firstChild : null;
	},
	onChildAdded_: function () {
		this.rerender();
	},
	onChildRemoved_: function () {
		this.rerender();
	},
	_select: function (row, mouseKey) {
		this.setSelectedRow(row);
		this.fire('onSelect', {selectedRow: this._selectedRow, reference: row, which: mouseKey});
	},
	setSelectedRow: function (row) {
		if (row != this._selectedRow) {
			var previousSelectedRow = this._selectedRow;
			if (previousSelectedRow)
				previousSelectedRow.setSelected(false);
			if (row)
				row.setSelected(true);
			this._selectedRow = row;
		}
	},
	getSelectedRow: function () {
		return this._selectedRow;
	}
});
})();