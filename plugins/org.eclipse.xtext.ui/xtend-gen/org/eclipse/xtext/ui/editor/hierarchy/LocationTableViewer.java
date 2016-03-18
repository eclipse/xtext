/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Collections;
import java.util.List;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class LocationTableViewer extends TableViewer {
  @FinalFieldsConstructor
  public static class ColumnDescription {
    private final String header;
    
    private final ColumnLayoutData data;
    
    public ColumnDescription(final String header, final ColumnLayoutData data) {
      super();
      this.header = header;
      this.data = data;
    }
  }
  
  public LocationTableViewer(final Composite parent) {
    super(parent);
    ArrayContentProvider _arrayContentProvider = new ArrayContentProvider();
    this.setContentProvider(_arrayContentProvider);
    final TableLayout layout = new TableLayout();
    Table _table = this.getTable();
    _table.setLayout(layout);
    Table _table_1 = this.getTable();
    _table_1.setHeaderVisible(true);
    List<LocationTableViewer.ColumnDescription> _columnDescriptions = this.getColumnDescriptions();
    Iterable<Pair<Integer, LocationTableViewer.ColumnDescription>> _indexed = IterableExtensions.<LocationTableViewer.ColumnDescription>indexed(_columnDescriptions);
    final Procedure1<Pair<Integer, LocationTableViewer.ColumnDescription>> _function = new Procedure1<Pair<Integer, LocationTableViewer.ColumnDescription>>() {
      @Override
      public void apply(final Pair<Integer, LocationTableViewer.ColumnDescription> it) {
        LocationTableViewer.ColumnDescription _value = it.getValue();
        layout.addColumnData(_value.data);
        LocationTableViewer.ColumnDescription _value_1 = it.getValue();
        Integer _key = it.getKey();
        LocationTableViewer.this.createColumn(_value_1, (_key).intValue());
      }
    };
    IterableExtensions.<Pair<Integer, LocationTableViewer.ColumnDescription>>forEach(_indexed, _function);
  }
  
  protected void createColumn(final LocationTableViewer.ColumnDescription columnDescription, final int index) {
    Table _table = this.getTable();
    final TableColumn column = new TableColumn(_table, SWT.NONE, index);
    column.setResizable(columnDescription.data.resizable);
    column.setText(columnDescription.header);
  }
  
  protected List<LocationTableViewer.ColumnDescription> getColumnDescriptions() {
    ColumnWeightData _columnWeightData = new ColumnWeightData(60);
    LocationTableViewer.ColumnDescription _columnDescription = new LocationTableViewer.ColumnDescription("Line", _columnWeightData);
    ColumnWeightData _columnWeightData_1 = new ColumnWeightData(300);
    LocationTableViewer.ColumnDescription _columnDescription_1 = new LocationTableViewer.ColumnDescription("Call", _columnWeightData_1);
    return Collections.<LocationTableViewer.ColumnDescription>unmodifiableList(CollectionLiterals.<LocationTableViewer.ColumnDescription>newArrayList(_columnDescription, _columnDescription_1));
  }
}
