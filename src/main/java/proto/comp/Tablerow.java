/* Tablerow.java

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 14:54:18 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package proto.comp;

import java.io.IOException;
import java.util.Collection;

import com.google.common.base.Objects;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

public class Tablerow extends XulElement {
	private Object _value;
	private boolean _selected, _disabled, _selectable = true;

	public Object getValue() {
		return _value;
	}

	public void setValue(Object value) {
		if (!Objects.equal(_value, value)) {
			_value = value;
			smartUpdate("value", _value);
		}
	}

	public boolean isSelected() {
		return _selected;
	}

	public void setSelected(boolean selected) {
		if (_selected != selected) {
			getTable().toggleRowSelection(this);
		}
	}

	public void setSelectedDirectly(boolean selected) {
		_selected = selected;
	}

	public Fixedtable getTable() {
		return (Fixedtable) getParent();
	}

	public Collection<Tablecell> getCells() {
		return getChildren();
	}

	@Override
	public void beforeChildAdded(Component child, Component insertBefore) {
		if (!(child instanceof Tablecell)) {
			throw new UiException("Unsupported child: " + child);
		}
		super.beforeChildAdded(child, insertBefore);
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		render(renderer, "value", _value);
		render(renderer, "selected", _selected);
		render(renderer, "disabled", _disabled);
		if (!_selectable)
			renderer.render("selectable", false);
	}
}
