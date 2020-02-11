/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.action.Action
import org.eclipse.xtext.ui.internal.XtextPluginImages

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class RefreshHierarchyAction extends Action {

	val AbstractHierarchyViewPart hierarchyViewPart

	new(AbstractHierarchyViewPart hierarchyViewPart) {
		this.hierarchyViewPart = hierarchyViewPart
		text = 'Refresh'
		toolTipText = 'Refresh'
		imageDescriptor = XtextPluginImages.DESC_REFRESH
		hoverImageDescriptor = XtextPluginImages.DESC_REFRESH
	}

	override run() {
		hierarchyViewPart.refresh(new NullProgressMonitor)
	}

}
