/* Tablecolumns.java

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 11:53:53 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package proto.comp;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zul.impl.XulElement;

public class Tablecolumns extends XulElement {

	public Fixedtable getTable() {
		return (Fixedtable) getParent();
	}

	@Override
	public void beforeChildAdded(Component child, Component insertBefore) {
		if (!(child instanceof Tablecolumn)) {
			throw new UiException("Unsupported child: " + child);
		}
		super.beforeChildAdded(child, insertBefore);
	}
}
