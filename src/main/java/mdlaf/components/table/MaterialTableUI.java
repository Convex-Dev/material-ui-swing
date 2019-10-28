package mdlaf.components.table;

import mdlaf.utils.*;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTableUI extends BasicTableUI {


	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		//table = (JTable) c;
		table.setOpaque (UIManager.getBoolean("Table.opaque"));
		table.setSelectionForeground (UIManager.getColor ("Table.selectionForeground"));
		table.setBackground (UIManager.getColor ("Table.background"));
		table.setForeground (UIManager.getColor ("Table.foreground"));
		table.setFont (UIManager.getFont ("Table.font"));
		table.setBorder (UIManager.getBorder ("Table.border"));
		table.setGridColor (UIManager.getColor ("Table.gridColor"));
		table.setSelectionBackground (UIManager.getColor ("Table.selectionBackground"));
		table.setFocusable (UIManager.getBoolean ("Table.focusable"));
		table.setRowHeight(UIManager.getInt("Table[row].height"));
		table.getTableHeader ().setResizingAllowed (true);
		int rowHeight = UIManager.getInt ("Table.rowHeight");
		if (rowHeight > 0) {
			table.setRowHeight (rowHeight);
		}else {
			table.setRowHeight (table.getRowHeight () + 25);
		}

		this.setDefaultCellRenderWithType(table);

		table.setDefaultEditor(Object.class, new MaterialTableCellEditor());
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//settingIconToTable();
	}

	@Override
	protected void uninstallDefaults() {
		super.uninstallDefaults();

		table.setSelectionForeground (null);
		table.setBackground (null);
		table.setForeground (null);
		table.setFont (null);
		table.setBorder (null);
		table.setSelectionBackground (null);

		table.removeEditor();
		//table.setDefaultRenderer(Object.class, null);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	public void update(Graphics g, JComponent c) {
		super.update(g, c);
		//settingIconToTable();
	}

	 //This method setting a MaterialCellRender at the particular class
	 // With this class not working correctly the color alternate in the Jtable
	protected void setDefaultCellRenderWithType(JTable table) {
		if(table == null){
			throw new IllegalArgumentException("Table is null");
		}

		table.setDefaultRenderer(Object.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(String.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Integer.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Double.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Float.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Boolean.class, new MaterialTableCellRenderer());
	}
}
