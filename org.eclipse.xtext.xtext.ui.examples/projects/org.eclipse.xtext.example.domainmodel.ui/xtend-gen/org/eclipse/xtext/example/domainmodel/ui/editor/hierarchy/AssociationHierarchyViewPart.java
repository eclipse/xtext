/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.xtext.ui.editor.hierarchy.DefaultCallHierarchyViewPart;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AssociationHierarchyViewPart extends DefaultCallHierarchyViewPart {
  @Override
  protected Pair<String, ColumnLayoutData>[] getLocationColumnDescriptions() {
    ColumnWeightData _columnWeightData = new ColumnWeightData(60);
    Pair<String, ColumnLayoutData> _mappedTo = Pair.<String, ColumnLayoutData>of("Line", _columnWeightData);
    ColumnWeightData _columnWeightData_1 = new ColumnWeightData(300);
    Pair<String, ColumnLayoutData> _mappedTo_1 = Pair.<String, ColumnLayoutData>of("Property", _columnWeightData_1);
    return new Pair[] { _mappedTo, _mappedTo_1 };
  }
}
