function (out) {
	out.push('<div ', this.domAttrs_(), '>');
	out.push('<table id="', this.uuid, '-table" class="', this.$s('table'), '">');
	for (var w = this.firstChild; w; w = w.nextSibling)
		w.redraw(out);
	out.push('</table>');
	out.push('</div>');
}