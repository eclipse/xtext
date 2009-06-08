/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.outline.linking.ToggleHelper;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractOutlineAction extends Action {

	private final XtextContentOutlinePage outlinePage;

	public AbstractOutlineAction(String text, XtextContentOutlinePage outlinePage) {
		super(text);
		this.outlinePage = outlinePage;

		boolean checked = ToggleHelper.isToggleEnabled(getToggleId());
		valueChanged(checked, false);
	}
	
	protected abstract String getToggleId();
	
	protected XtextContentOutlinePage getOutlinePage() {
		return outlinePage;
	}

	@Override
	public final void run() {
		valueChanged(isChecked(), true);
	}

	private void valueChanged(final boolean checkedState, boolean store) {
		setChecked(checkedState);
		performAction(checkedState);
		if (store) {
			ToggleHelper.setToggleEnabled(getToggleId(), checkedState);
		}
	}

	protected abstract void performAction(final boolean checkedState);
	
}
