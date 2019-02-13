/* Tablecolumn.java

		Purpose:
                
		Description:
                
		History:
				Mon Jan 28 14:49:30 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package proto.comp;

import org.zkoss.zul.impl.XulElement;

public class Tablecolumn extends XulElement {
	public Fixedtable getTable() {
		return ((Tablecolumns) getParent()).getTable();
	}
}
