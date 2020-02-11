/*******************************************************************************
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy

import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.xtext.ui.editor.hierarchy.DefaultCallHierarchyViewPart

/**
 * @author kosyakov - Initial contribution and API
 */
class AssociationHierarchyViewPart extends DefaultCallHierarchyViewPart {

	override protected getLocationColumnDescriptions() {
		#[
			'Line' -> new ColumnWeightData(60),
			'Property' -> new ColumnWeightData(300)
		]
	}

}
