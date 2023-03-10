/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class RefreshHierarchyAction extends Action {

	private final AbstractHierarchyViewPart hierarchyViewPart;

	public RefreshHierarchyAction(AbstractHierarchyViewPart hierarchyViewPart) {
		this.hierarchyViewPart = hierarchyViewPart;
		setText("Refresh");
		setToolTipText("Refresh");
		setImageDescriptor(XtextPluginImages.DESC_REFRESH);
		setHoverImageDescriptor(XtextPluginImages.DESC_REFRESH);
	}

	@Override
	public void run() {
		hierarchyViewPart.refresh(new NullProgressMonitor());
	}
}
