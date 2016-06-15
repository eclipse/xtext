/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import org.eclipse.jface.action.Action
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder.CallHierarchyType
import org.eclipse.xtext.ui.internal.XtextPluginImages

/**
 * @author kosyakov - Initial contribution and API
 */
class SetHierarchyTypeAction extends Action {

	@Accessors
	val CallHierarchyType hierarchyType
	val AbstractCallHierarchyViewPart callHierarchyViewPart

	new(CallHierarchyType hierarchyType, AbstractCallHierarchyViewPart callHierarchyViewPart) {
		super('', AS_RADIO_BUTTON)
		this.hierarchyType = hierarchyType
		this.callHierarchyViewPart = callHierarchyViewPart
		switch hierarchyType {
			case CALLEE: {
				text = 'Show Callee Hierarchy'
				toolTipText = 'Show Callee Hierarchy'
				imageDescriptor = XtextPluginImages.DESC_CH_CALLEES
				hoverImageDescriptor = XtextPluginImages.DESC_CH_CALLEES
			}
			default: {
				text = 'Show Caller Hierarchy'
				toolTipText = 'Show Caller Hierarchy'
				imageDescriptor = XtextPluginImages.DESC_CH_CALLERS
				hoverImageDescriptor = XtextPluginImages.DESC_CH_CALLERS
			}
		}
	}

	override run() {
		callHierarchyViewPart.callHierarchyType = hierarchyType
	}

}
