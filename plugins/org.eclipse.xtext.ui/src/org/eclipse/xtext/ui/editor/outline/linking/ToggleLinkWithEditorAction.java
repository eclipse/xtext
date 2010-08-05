/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.linking;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public class ToggleLinkWithEditorAction extends Action implements IPropertyChangeListener, IPartListener {

	private final XtextContentOutlinePage outlinePage;

	public ToggleLinkWithEditorAction(XtextContentOutlinePage outlinePage) {
		super(XtextUIMessages.ToggleLinkWithEditorAction_label);
		this.outlinePage = outlinePage;
		setChecked(isLinkingEnabled());
		setToolTipText(XtextUIMessages.ToggleLinkWithEditorAction_toolTip);
		setDescription(XtextUIMessages.ToggleLinkWithEditorAction_description);
		setImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR);
		setDisabledImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR_DISABLED);
		registerPropertyChangeListener();
	}

	protected void registerPropertyChangeListener() {
		Activator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		// partlistener required to cleanup and de-register this propertychange listener instance
		outlinePage.getSite().getPage().addPartListener(this);
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

	public void propertyChange(PropertyChangeEvent event) {
		if (LinkingHelper.TOGGLE_LINK_WITH_EDITOR_ACTION_IS_CHECKED.equals(event.getProperty())) {
			Boolean checked = (Boolean) event.getNewValue();
			setChecked(checked);
			setLinkingEnabled(checked);
		}

	}

	public void partActivated(IWorkbenchPart part) {
		if (equalsEditorOrOutlinePart(part) && isLinkingEnabled() && outlinePage.getEditor()!=null) {
			outlinePage.synchronizeOutlinePage();
		}
	}

	public void partBroughtToTop(IWorkbenchPart part) {
	}

	public void partClosed(IWorkbenchPart part) {
		if (equalsEditorOrOutlinePart(part)) {
			Activator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
			outlinePage.getSite().getPage().removePartListener(this);
		}
	}

	public void partDeactivated(IWorkbenchPart part) {
	}

	public void partOpened(IWorkbenchPart part) {
	}

	protected boolean equalsEditorOrOutlinePart(IWorkbenchPart part) {
		return outlinePage.getEditor().equals(part) || outlinePage.equals(part.getAdapter(IContentOutlinePage.class));
	}

}