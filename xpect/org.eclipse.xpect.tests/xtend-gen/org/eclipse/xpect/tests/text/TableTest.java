package org.eclipse.xpect.tests.text;

import org.eclipse.xpect.text.Canvas;
import org.eclipse.xpect.text.ICanvas;
import org.eclipse.xpect.text.Table;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TableTest {
  private Table newTable() {
    return new Table();
  }
  
  @Test
  public void test1by1() {
    final Table table = this.newTable();
    Table.Cell _cell = table.getCell(0, 0);
    _cell.setText("X");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("X");
    _builder.newLine();
    this.operator_tripleEquals(table, _builder);
  }
  
  @Test
  public void test2by3() {
    final Table table = this.newTable();
    Table.Cell _cell = table.getCell(0, 0);
    _cell.setText("a");
    Table.Cell _cell_1 = table.getCell(0, 1);
    _cell_1.setText("b");
    Table.Cell _cell_2 = table.getCell(0, 2);
    _cell_2.setText("c");
    Table.Cell _cell_3 = table.getCell(1, 0);
    _cell_3.setText("d");
    Table.Cell _cell_4 = table.getCell(1, 1);
    _cell_4.setText("e");
    Table.Cell _cell_5 = table.getCell(1, 2);
    _cell_5.setText("f");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a-b-c$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("d-e-f");
    _builder.newLine();
    this.operator_tripleEquals(table, _builder);
  }
  
  @Test
  public void test2by3Long() {
    final Table table = this.newTable();
    Table.Cell _cell = table.getCell(0, 0);
    _cell.setText("a1");
    Table.Cell _cell_1 = table.getCell(0, 1);
    _cell_1.setText("b12");
    Table.Cell _cell_2 = table.getCell(0, 2);
    _cell_2.setText("c123");
    Table.Cell _cell_3 = table.getCell(1, 0);
    _cell_3.setText("d1234");
    Table.Cell _cell_4 = table.getCell(1, 1);
    _cell_4.setText("e12345");
    Table.Cell _cell_5 = table.getCell(1, 2);
    _cell_5.setText("f123456");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a1----b12----c123$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("d1234-e12345-f123456");
    _builder.newLine();
    this.operator_tripleEquals(table, _builder);
  }
  
  @Test
  public void test2by3LongTrimmed() {
    final Table table = this.newTable();
    table.setMaxCellWidth(3);
    Table.Cell _cell = table.getCell(0, 0);
    _cell.setText("a1");
    Table.Cell _cell_1 = table.getCell(0, 1);
    _cell_1.setText("b12");
    Table.Cell _cell_2 = table.getCell(0, 2);
    _cell_2.setText("c123");
    Table.Cell _cell_3 = table.getCell(1, 0);
    _cell_3.setText("d1234");
    Table.Cell _cell_4 = table.getCell(1, 1);
    _cell_4.setText("e12345");
    Table.Cell _cell_5 = table.getCell(1, 2);
    _cell_5.setText("f123456");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a1--b12-c12$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("d12-e12-f12");
    _builder.newLine();
    this.operator_tripleEquals(table, _builder);
  }
  
  @Test
  public void test2by3BorderAndSeparators() {
    final Table table = this.newTable();
    Table.Cell _cell = table.getCell(0, 0);
    _cell.setText("a1");
    Table.Cell _cell_1 = table.getCell(0, 1);
    _cell_1.setText("b12");
    Table.Cell _cell_2 = table.getCell(0, 2);
    _cell_2.setText("c123");
    Table.Cell _cell_3 = table.getCell(1, 0);
    _cell_3.setText("d1234");
    Table.Cell _cell_4 = table.getCell(1, 1);
    _cell_4.setText("e12345");
    Table.Cell _cell_5 = table.getCell(1, 2);
    _cell_5.setText("f123456");
    table.setSeparatorCrossingBackground("+");
    table.setRowSeparatorBackground("=");
    table.setColumnSeparatorBackground("|");
    table.setBorder(1);
    Table.RowSeparator _bottomBorder = table.getBottomBorder();
    _bottomBorder.setHeight(3);
    Table.ColumnSeparator _rightBorder = table.getRightBorder();
    _rightBorder.setWidth(2);
    Table.Row _row = table.getRow(0);
    Table.RowSeparator _bottomSeparator = _row.getBottomSeparator();
    _bottomSeparator.setBackground("#");
    Table.Column _column = table.getColumn(0);
    Table.ColumnSeparator _rightSeparator = _column.getRightSeparator();
    _rightSeparator.setBackground("@");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("+=====+======+=======++$");
    _builder.newLine();
    _builder.append("|a1---@b12---|c123---||$");
    _builder.newLine();
    _builder.append("+#####+######+#######++$");
    _builder.newLine();
    _builder.append("|d1234@e12345|f123456||$");
    _builder.newLine();
    _builder.append("+=====+======+=======++$");
    _builder.newLine();
    _builder.append("+=====+======+=======++$");
    _builder.newLine();
    _builder.append("+=====+======+=======++");
    _builder.newLine();
    this.operator_tripleEquals(table, _builder);
  }
  
  public void operator_tripleEquals(final Table table, final Object o2) {
    final ICanvas canvas = Canvas.create('-', "$\n");
    table.paint(canvas);
    String _string = o2.toString();
    String _trim = _string.trim();
    String _string_1 = canvas.toString();
    String _trim_1 = _string_1.trim();
    Assert.assertEquals(_trim, _trim_1);
  }
}
