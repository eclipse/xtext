/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ToggleSortingAction extends AbstractToggleAction {

	public static final String PREFERENCE_KEY = "sort";

	private TreeViewer treeViewer;

	@Inject
	private ViewerSorter viewerSorter;
	
	@Inject@Named(Constants.LANGUAGE_NAME)
	protected String languageName;
	
	public ToggleSortingAction() {
		setText(XtextUIMessages.LexicalSortingAction_label);
		setToolTipText(XtextUIMessages.LexicalSortingAction_tooltip);
		setDescription(XtextUIMessages.LexicalSortingAction_description);
		setImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO);
		setDisabledImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO_DISABLED);
	}
	
	@Override
	public void activate(OutlinePage outlinePage) {	
		super.activate(outlinePage);
		this.treeViewer = outlinePage.getTreeViewer();
	}
	
	@Override
	protected void stateChanged(boolean newState) {
		if(newState)
			treeViewer.setSorter(viewerSorter);
		else 
			treeViewer.setSorter(null);
	}

	@Override
	public String getPreferenceKey() {
		return languageName + "." + PREFERENCE_KEY;
	}
}
