/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Singleton
import org.eclipse.jface.viewers.BaseLabelProvider
import org.eclipse.jface.viewers.ITableLabelProvider
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocation

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
class LocationTableLabelProvider extends BaseLabelProvider implements ITableLabelProvider {

	override getColumnImage(Object element, int columnIndex) {
		null
	}

	override getColumnText(Object location, int columnIndex) {
		if (location instanceof HierarchyNodeLocation) {
			switch columnIndex {
				case 0:
					return '' + (location.lineNumber + 1)
				case 1:
					return location.text
			}
		}
		return ''
	}

}
