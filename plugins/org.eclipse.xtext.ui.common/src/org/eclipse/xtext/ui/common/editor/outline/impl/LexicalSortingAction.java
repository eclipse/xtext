/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.internal.Activator;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;

public class LexicalSortingAction extends Action {

	private final XtextContentOutlinePage outlinePage;

	public LexicalSortingAction(XtextContentOutlinePage outlinePage) {
		super("Sort");
		setText("Sort");
		setToolTipText("Sort");
		setDescription("Sort");
		setImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO);
		setDisabledImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO_DISABLED);

		this.outlinePage = outlinePage;

		boolean checked = Activator.getDefault().getPreferenceStore().getBoolean("LexicalSortingAction.isChecked"); //$NON-NLS-1$
		valueChanged(checked, false);
	}

	@Override
	public void run() {
		valueChanged(isChecked(), true);
	}

	private void valueChanged(final boolean on, boolean store) {
		setChecked(on);

		outlinePage.setSorted(on);

		if (store) {
			Activator.getDefault().getPreferenceStore().setValue("LexicalSortingAction.isChecked", on); //$NON-NLS-1$
		}
	}
}