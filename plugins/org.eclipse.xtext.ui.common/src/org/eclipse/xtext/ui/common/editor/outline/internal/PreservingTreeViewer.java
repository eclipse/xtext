/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.internal;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class PreservingTreeViewer extends TreeViewer {

	public PreservingTreeViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void preservingSelection(Runnable updateCode) {
		Object[] expandedElements = null;
		expandedElements = getExpandedElements();
		super.preservingSelection(updateCode);
		setExpandedElements(expandedElements);
	}

}
