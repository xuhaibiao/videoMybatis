package com.xu.videorental.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author HaibiaoXu
 * @date Create in 15:01 2019/12/1
 * @modified By
 */
public class GuiUtil {
    /**
     * 表格数据居中
     * @param table
     */

    public static void setTableColumnCenter(JTable table){
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
    }
}
