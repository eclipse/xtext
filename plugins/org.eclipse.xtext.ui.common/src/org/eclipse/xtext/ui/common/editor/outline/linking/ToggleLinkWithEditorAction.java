/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.linking;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.core.XtextUIMessages;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ToggleLinkWithEditorAction extends Action {

	private final XtextContentOutlinePage outlinePage;

	public ToggleLinkWithEditorAction(XtextContentOutlinePage outlinePage) {
		super(XtextUIMessages.getString("ToggleLinkWithEditorAction.label")); //$NON-NLS-1$
		this.outlinePage = outlinePage;
		setChecked(isLinkingEnabled());
		setToolTipText(XtextUIMessages.getString("ToggleLinkWithEditorAction.toolTip")); //$NON-NLS-1$
		setDescription(XtextUIMessages.getString("ToggleLinkWithEditorAction.description")); //$NON-NLS-1$
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