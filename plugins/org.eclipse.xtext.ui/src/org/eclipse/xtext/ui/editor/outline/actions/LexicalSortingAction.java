/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

public class LexicalSortingAction extends AbstractOutlineAction {

	public LexicalSortingAction(XtextContentOutlinePage outlinePage) {
		super("Sort", outlinePage);
		setToolTipText("Sort");
		setDescription("Sort");
		setImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO);
		setDisabledImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO_DISABLED);
	}

	@Override
	protected String getToggleId() {
		return "LexicalSortingAction.isChecked";
	}
	
	@Override
	protected void performAction(boolean checkedState) {
		getOutlinePage().setSorted(checkedState);
	}
	
}