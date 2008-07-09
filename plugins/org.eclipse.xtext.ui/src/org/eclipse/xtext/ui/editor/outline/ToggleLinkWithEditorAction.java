/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.editor.BaseTextEditor;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class ToggleLinkWithEditorAction extends Action {

    BaseTextEditor editor;

    public ToggleLinkWithEditorAction(BaseTextEditor editor) {
        super("Lin&k with Editor");
        boolean isLinkingEnabled = Activator.getDefault().getPreferenceStore().getBoolean(
                "ToggleLinkWithEditorAction.isChecked"); //$NON-NLS-1$
        setChecked(isLinkingEnabled);
        this.editor = editor;
        setToolTipText("Link with Editor");
        setDescription("Link with active editor");
        setImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR);
        setDisabledImageDescriptor(XtextPluginImages.DESC_LINK_WITH_EDITOR_DISABLED);
    }

    public void run() {
		Activator.getDefault().getPreferenceStore().setValue("ToggleLinkWithEditorAction.isChecked", isChecked()); //$NON-NLS-1$
		if (isChecked()) {
			editor.synchronizeOutlinePage();
		}
	}
}