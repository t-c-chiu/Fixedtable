/* TestComposer.java

		Purpose:
                
		Description:
                
		History:
				Tue Jan 29 09:53:03 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package test.ctrl;

import proto.comp.Fixedtable;
import proto.comp.Tablecell;
import proto.comp.Tablerow;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;

public class TestComposer extends SelectorComposer {

	@Wire
	private Fixedtable table;
	@Wire
	private Grid grid;

	@Listen("onClick = #addChild")
	public void addChild() {
		Tablerow row = new Tablerow();
		int count = table.getRows().size() + 1;
		for (int i = 1; i <= 10; i++)
			row.appendChild(new Tablecell(count + "-" + i));
		table.appendChild(row);
	}

	@Listen("onClick = #addLeft")
	public void addLeft() {
		table.setFixedLeft(table.getFixedLeft() + 1);
	}

	@Listen("onClick = #addRight")
	public void addRight() {
		table.setFixedRight(table.getFixedRight() + 1);
	}

	@Listen("onClick = #addTop")
	public void addTop() {
		table.setFixedTop(table.getFixedTop() + 1);
	}

	@Listen("onClick = #addBottom")
	public void addBottom() {
		table.setFixedBottom(table.getFixedBottom() + 1);
	}
}
