/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.outline.linking.ToggleLinkWithEditorAction;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface IActionBarContributor {
	
	void init(IToolBarManager toolBarmanager, XtextContentOutlinePage outlinePage);
	
	public class DefaultActionBarContributor implements IActionBarContributor {
		private IToolBarManager toolBarManager;
		private XtextContentOutlinePage outlinePage;

		protected void add(Action action) {
			toolBarManager.add(action);
		}
		
		protected XtextContentOutlinePage getOutlinePage() {
			return outlinePage;
		}
		
		protected void addDefaultActions() {
			add(new ToggleLinkWithEditorAction(getOutlinePage()));
			add(new LexicalSortingAction(getOutlinePage()));
		}
		
		protected void addToolbarActions() {
			addDefaultActions();
		}
		
		public void init(IToolBarManager toolBarManager, XtextContentOutlinePage outlinePage) {
			this.toolBarManager = toolBarManager;
			this.outlinePage = outlinePage;
			addToolbarActions();
		}
		
	}
}