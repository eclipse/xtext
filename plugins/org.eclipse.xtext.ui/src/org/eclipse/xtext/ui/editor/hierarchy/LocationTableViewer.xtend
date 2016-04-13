/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ColumnLayoutData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.TableLayout
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.TableColumn
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class LocationTableViewer extends TableViewer {

	new(Composite parent) {
		super(parent)
		contentProvider = new ArrayContentProvider

		val layout = new TableLayout
		table.layout = layout
		table.headerVisible = true
		columnDescriptions.indexed.forEach[
			layout.addColumnData(value.data)
			createColumn(value, key)
		]
	}

	protected def void createColumn(ColumnDescription columnDescription, int index) {
		val column = new TableColumn(table, SWT.NONE, index)
		column.resizable = columnDescription.data.resizable
		column.text = columnDescription.header
	}

	protected def getColumnDescriptions() {
		#[
			new ColumnDescription('Line', new ColumnWeightData(60)),
			new ColumnDescription('Call', new ColumnWeightData(300))
		]
	}

	@FinalFieldsConstructor
	static class ColumnDescription {
		val String header
		val ColumnLayoutData data
	}

}
