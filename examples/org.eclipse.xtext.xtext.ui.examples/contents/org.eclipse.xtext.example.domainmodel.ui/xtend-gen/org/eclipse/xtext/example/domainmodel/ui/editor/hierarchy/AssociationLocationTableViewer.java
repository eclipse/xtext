/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import java.util.Collections;
import java.util.List;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.hierarchy.LocationTableViewer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AssociationLocationTableViewer extends LocationTableViewer {
  public AssociationLocationTableViewer(final Composite parent) {
    super(parent);
  }
  
  @Override
  public List<LocationTableViewer.ColumnDescription> getColumnDescriptions() {
    ColumnWeightData _columnWeightData = new ColumnWeightData(60);
    LocationTableViewer.ColumnDescription _columnDescription = new LocationTableViewer.ColumnDescription("Line", _columnWeightData);
    ColumnWeightData _columnWeightData_1 = new ColumnWeightData(300);
    LocationTableViewer.ColumnDescription _columnDescription_1 = new LocationTableViewer.ColumnDescription("Property", _columnWeightData_1);
    return Collections.<LocationTableViewer.ColumnDescription>unmodifiableList(CollectionLiterals.<LocationTableViewer.ColumnDescription>newArrayList(_columnDescription, _columnDescription_1));
  }
}
