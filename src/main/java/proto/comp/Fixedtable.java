package proto.comp;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.ext.Scope;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.XulElement;

public class Fixedtable extends XulElement {

	private int _fixedTop, _fixedRight, _fixedBottom, _fixedLeft;
	private ListModel _model;
	private Tablerow _selectedRow;
	private Tablecolumns _tablecolumns;
	private Collection<Tablerow> _tablerows = new ArrayList<Tablerow>();

	static {
		addClientEvent(Fixedtable.class, Events.ON_SELECT, CE_IMPORTANT);
	}

	public int getFixedTop() {
		return _fixedTop;
	}

	public void setFixedTop(int fixedtop) {
		if (_fixedTop != fixedtop) {
			_fixedTop = fixedtop;
			smartUpdate("fixedTop", _fixedTop);
		}
	}

	public int getFixedBottom() {
		return _fixedBottom;
	}

	public void setFixedBottom(int fixedbottom) {
		if (_fixedBottom != fixedbottom) {
			_fixedBottom = fixedbottom;
			smartUpdate("fixedBottom", _fixedBottom);
		}
	}

	public int getFixedRight() {
		return _fixedRight;
	}

	public void setFixedRight(int fixedright) {
		if (_fixedRight != fixedright) {
			_fixedRight = fixedright;
			smartUpdate("fixedRight", _fixedRight);
		}
	}

	public int getFixedLeft() {
		return _fixedLeft;
	}

	public void setFixedLeft(int fixedleft) {
		if (_fixedLeft != fixedleft) {
			_fixedLeft = fixedleft;
			smartUpdate("fixedLeft", _fixedLeft);
		}
	}

	public Tablerow getSelectedRow() {
		return _selectedRow;
	}

	public void setSelectedRow(Tablerow selectedRow) {
		if (_selectedRow != selectedRow) {
			if (_selectedRow != null)
				toggleRowSelection(_selectedRow);
			if (selectedRow != null)
				toggleRowSelection(selectedRow);
		}
	}

	public void toggleRowSelection(Tablerow tablerow) {
		if (tablerow.isSelected()) {
			tablerow.setSelectedDirectly(false);
			_selectedRow = null;
		} else {
			_selectedRow.setSelectedDirectly(false);
			tablerow.setSelectedDirectly(true);
			_selectedRow = tablerow;
		}
		smartUpdate("selectedRow", _selectedRow);
	}

	public Tablecolumns getColumns() {
		return _tablecolumns;
	}

	public Collection<Tablerow> getRows() {
		return _tablerows;
	}

	@Override
	public void beforeChildAdded(Component child, Component insertBefore) {
		if (child instanceof Tablecolumns)
			_tablecolumns = (Tablecolumns) child;
		else if (child instanceof Tablerow)
			_tablerows.add((Tablerow) child);
		else
			throw new UiException("Unsupported child: " + child);
		super.beforeChildAdded(child, insertBefore);
	}

	@Override
	public void service(AuRequest request, boolean everError) {
		if (Events.ON_SELECT.equals(request.getCommand())) {
			System.out.println(request);
		} else
			super.service(request, everError);
	}

	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
			throws java.io.IOException {
		super.renderProperties(renderer);
		if (_fixedTop != 0)
			render(renderer, "fixedTop", _fixedTop);
		if (_fixedRight != 0)
			render(renderer, "fixedRight", _fixedRight);
		if (_fixedBottom != 0)
			render(renderer, "fixedBottom", _fixedBottom);
		if (_fixedLeft != 0)
			render(renderer, "fixedLeft", _fixedLeft);
		render(renderer, "selectedRow", _selectedRow);
	}
}