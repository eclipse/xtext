/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SortOutlineContribution extends AbstractToggleOutlineContribution {
	public static final String PREFERENCE_KEY = "ui.outline.sort2";

	private TreeViewer treeViewer;

	private OutlineFilterAndSorter outlineFilterAndSorter;
	
	@Inject 
	private IComparator comparator;
	
	@Override
	public String getPreferenceKey() {
		return PREFERENCE_KEY;
	}

	@Override
	protected void stateChanged(boolean newState) {
		if(treeViewer != null && !treeViewer.getTree().isDisposed()) {
			treeViewer.getControl().setRedraw(false);
			try {
				treeViewer.refresh();
			} finally {
				treeViewer.getControl().setRedraw(true);
			}
		}
	}

	public static class DefaultComparator implements IComparator {
		@Inject 
		private IPreferenceStoreAccess preferenceStoreAccess;
		
		@Override
		public int compare(IOutlineNode o1, IOutlineNode o2) {
			int category1 = getCategory(o1);
			int category2 = getCategory(o2);
			if(category1 != category2)
				return category1-category2;
			return o1.getText().toString().compareTo(o2.getText().toString());
		}

		@Override
		public boolean isEnabled() {
			return preferenceStoreAccess.getPreferenceStore().getBoolean(PREFERENCE_KEY);
		}
		
		public int getCategory(IOutlineNode node) {
			return 0;
		}
	}		

	@Override
	protected void configureAction(Action action) {
		action.setText(XtextUIMessages.LexicalSortingAction_label);
		action.setToolTipText(XtextUIMessages.LexicalSortingAction_tooltip);
		action.setDescription(XtextUIMessages.LexicalSortingAction_description);
		action.setImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO);
		action.setDisabledImageDescriptor(XtextPluginImages.DESC_ALPHAB_SORT_CO_DISABLED);
	}

	@Override
	public void register(OutlinePage outlinePage) {
		super.register(outlinePage);
		outlineFilterAndSorter = outlinePage.getFilterAndSorter();
		this.treeViewer = outlinePage.getTreeViewer();
		outlineFilterAndSorter.setComparator(comparator);
	}
	
	@Override
	public void deregister(OutlinePage outlinePage) {
		outlineFilterAndSorter = null;
		treeViewer = null;
		super.deregister(outlinePage);
	}
}
