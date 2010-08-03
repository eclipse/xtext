/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.linking;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ToggleLinkWithEditorAction extends Action {

	private final XtextContentOutlinePage outlinePage;

	public ToggleLinkWithEditorAction(XtextContentOutlinePage outlinePage) {
		super(XtextUIMessages.ToggleLinkWithEditorAction_label);
		this.outlinePage = outlinePage;
		setChecked(isLinkingEnabled());
		setToolTipText(XtextUIMessages.ToggleLinkWithEditorAction_toolTip);
		setDescription(XtextUIMessages.ToggleLinkWithEditorAction_description); 
		setImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR);
		setDisabledImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR_DISABLED);
	}

	protected boolean isLinkingEnabled() {
		return outlinePage.isLinkingEnabled();
	}

	protected void setLinkingEnabled(boolean enabled) {
		outlinePage.setLinkingEnabled(enabled);
	}

	@Override
	public void run() {
		setLinkingEnabled(isChecked());
		if (isLinkingEnabled()) {
			outlinePage.synchronizeOutlinePage();
		}
	}

}