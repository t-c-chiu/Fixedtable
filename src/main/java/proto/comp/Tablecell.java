/* Tablecell.java

		Purpose:

		Description:

		History:
				Mon Jan 28 14:54:26 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package proto.comp;

import java.io.IOException;

import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.LabelImageElement;

public class Tablecell extends LabelImageElement {
	private int _colspan = 1, _rowspan = 1;

	public Tablecell() {
	}

	public Tablecell(String label) {
		super(label);
	}

	public Tablecell(String label, String image) {
		super(label, image);
	}

	public Fixedtable getTable() {
		return ((Tablerow) getParent()).getTable();
	}

	public int getColspan() {
		return _colspan;
	}

	public void setColspan(int colspan) {
		if (_colspan != colspan) {
			_colspan = colspan;
			smartUpdate("colsapn", _colspan);
		}
	}

	public int getRowspan() {
		return _rowspan;
	}

	public void setRowspan(int rowspan) {
		if (_rowspan != rowspan) {
			_rowspan = rowspan;
			smartUpdate("rowspan", _rowspan);
		}
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		if (_colspan != 1)
			render(renderer, "colspan", _colspan);
		if (_rowspan != 1)
			render(renderer, "rowspan", _rowspan);
	}
}
