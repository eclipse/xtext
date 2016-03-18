/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy

import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.swt.widgets.Composite
import org.eclipse.xtext.ui.editor.hierarchy.LocationTableViewer

/**
 * @author kosyakov - Initial contribution and API
 */
class AssociationLocationTableViewer extends LocationTableViewer {

	new(Composite parent) {
		super(parent)
	}

	override getColumnDescriptions() {
		#[
			new ColumnDescription('Line', new ColumnWeightData(60)),
			new ColumnDescription('Property', new ColumnWeightData(300))
		]
	}

}
