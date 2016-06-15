/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ReferenceSearchViewPageActions {

	public static class ShowNext extends Action {

		private ReferenceSearchViewPage page;

		public ShowNext(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_showNextMatch);
			setImageDescriptor(XtextPluginImages.DESC_SEARCH_NEXT);
			setToolTipText(Messages.ReferenceSearchViewPageActions_showNextMatch_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			new TreeViewerNavigator(page).navigateNext(true);
		}
	}

	public static class ShowPrevious extends Action {

		private ReferenceSearchViewPage page;

		public ShowPrevious(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_showPreviousMatch);
			setImageDescriptor(XtextPluginImages.DESC_SEARCH_PREVIOUS);
			setToolTipText(Messages.ReferenceSearchViewPageActions_showPreviousMatch_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			new TreeViewerNavigator(page).navigateNext(false);
		}
	}
	
	public static class ExpandAll extends Action {
		private ReferenceSearchViewPage page;

		public ExpandAll(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_expandAll);
			setImageDescriptor(XtextPluginImages.DESC_EXPAND_ALL);
			setToolTipText(Messages.ReferenceSearchViewPageActions_expandAll_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			page.getViewer().expandAll();
		}
	}

	public static class CollapseAll extends Action {
		private ReferenceSearchViewPage page;

		public CollapseAll(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_collapseAll);
			setImageDescriptor(XtextPluginImages.DESC_COLLAPSE_ALL);
			setToolTipText(Messages.ReferenceSearchViewPageActions_collapseAll_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			page.getViewer().collapseAll();
		}
	}
}
