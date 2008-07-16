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
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author Peter Friese - Initial contribution and API
 */
class XtextOutlineSortingAction extends Action {

    private final XtextContentOutlinePage outline;

    public XtextOutlineSortingAction(XtextContentOutlinePage outline) {
        super();
        this.outline = outline;
        setText(XtextUIMessages.getString("XtextOutlineSortingAction.label")); //$NON-NLS-1$
        setImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO);
        setDisabledImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO_DISABLED);
        setToolTipText(XtextUIMessages.getString("XtextOutlineSortingAction.tooltip")); //$NON-NLS-1$
        setDescription(XtextUIMessages.getString("XtextOutlineSortingAction.description")); //$NON-NLS-1$
        setChecked(getSorting());
    }

    public void run() {
        setChecked(isChecked());
        valueChanged(isChecked());
    }

    private void valueChanged(boolean on) {
        setSorting(on);
        outline.sort(on);
    }

    private boolean getSorting() {
        return Activator.getDefault().getPreferenceStore().getBoolean(
                XtextContentOutlinePage.XTEXT_CONTENT_OUTLINE_PAGE_SORTING_ACTION_IS_CHECKED);
    }

    private void setSorting(boolean on) {
        Activator.getDefault().getPreferenceStore().setValue(
                XtextContentOutlinePage.XTEXT_CONTENT_OUTLINE_PAGE_SORTING_ACTION_IS_CHECKED, on);
    }

}