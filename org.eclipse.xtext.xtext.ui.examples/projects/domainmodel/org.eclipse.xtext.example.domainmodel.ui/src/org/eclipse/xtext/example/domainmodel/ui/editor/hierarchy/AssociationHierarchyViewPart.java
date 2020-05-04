/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.xtext.ui.editor.hierarchy.DefaultCallHierarchyViewPart;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author kosyakov - Initial contribution and API
 */
public class AssociationHierarchyViewPart extends DefaultCallHierarchyViewPart {
	@SuppressWarnings("unchecked")
	@Override
	protected Pair<String, ColumnLayoutData>[] getLocationColumnDescriptions() {
		return new Pair[] { 
			Pair.of("Line", new ColumnWeightData(60)),
			Pair.of("Property", new ColumnWeightData(300)) 
		};
	}
}
