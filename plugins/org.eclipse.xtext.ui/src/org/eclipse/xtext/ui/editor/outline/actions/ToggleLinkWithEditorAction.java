/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ToggleLinkWithEditorAction extends AbstractToggleAction {

	public static final String PREFERENCE_KEY = "ui.outline.linkWithEditor";

	@Inject 
	private OutlineWithEditorLinker outlineWithEditorLinker; 
	
	public ToggleLinkWithEditorAction() {
		setText(XtextUIMessages.ToggleLinkWithEditorAction_label);
		setToolTipText(XtextUIMessages.ToggleLinkWithEditorAction_toolTip);
		setDescription(XtextUIMessages.ToggleLinkWithEditorAction_description);
		setImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR);
		setDisabledImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR_DISABLED);
	}

	@Override
	public void activate(OutlinePage outlinePage) {
		super.activate(outlinePage);
		outlineWithEditorLinker.activate(outlinePage);
		outlineWithEditorLinker.setLinkingEnabled(isPropertySet());
	}
	
	@Override
	public void deactivate() {
		outlineWithEditorLinker.deactivate();
	}
	
	@Override
	protected void stateChanged(boolean newState) {
		outlineWithEditorLinker.setLinkingEnabled(newState);
	}

	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

}
