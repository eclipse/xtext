/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.actions;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManagerOverrides;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DeclarativeActionBarContributorTest extends TestCase {
	
	class SampleAction extends Action {
		public SampleAction(XtextContentOutlinePage page) {
		}
	}
	
	class SampleDeclarativeActionBarContributor extends DeclarativeActionBarContributor {
		protected void addDefaultActions() {};
		Action addSomeToolbarAction(XtextContentOutlinePage page) {
			return new SampleAction(page);
		}
		public Action addSecondSomeToolbarAction(XtextContentOutlinePage page) {
			return new SampleAction(page);
		}
	}
	
	class MockedToolBarManager implements IToolBarManager {
		
		private List<IContributionItem> contributionItems = new ArrayList<IContributionItem>();

		public void add(IAction action) {
			add(new ActionContributionItem(action));
		}

		public void add(IContributionItem item) {
			contributionItems.add(item);
		}

		public void appendToGroup(String groupName, IAction action) {
		}

		public void appendToGroup(String groupName, IContributionItem item) {
		}

		public IContributionItem find(String id) {
			return null;
		}

		public IContributionItem[] getItems() {
			return contributionItems.toArray(new IContributionItem[contributionItems.size()]);
		}

		public IContributionManagerOverrides getOverrides() {
			return null;
		}

		public void insertAfter(String id, IAction action) {
		}

		public void insertAfter(String id, IContributionItem item) {
		}

		public void insertBefore(String id, IAction action) {
		}

		public void insertBefore(String id, IContributionItem item) {
		}

		public boolean isDirty() {
			return false;
		}

		public boolean isEmpty() {
			return false;
		}

		public void markDirty() {
		}

		public void prependToGroup(String groupName, IAction action) {
		}

		public void prependToGroup(String groupName, IContributionItem item) {
		}

		public IContributionItem remove(String id) {
			return null;
		}

		public IContributionItem remove(IContributionItem item) {
			return null;
		}

		public void removeAll() {
			
		}

		public void update(boolean force) {
		}
		
	}
	
	public void testAddActions() {
		IToolBarManager toolBarManager = new MockedToolBarManager();
		DeclarativeActionBarContributor actionBarContributor = new SampleDeclarativeActionBarContributor();
		XtextContentOutlinePage outlinePage = new XtextContentOutlinePage();
		
		actionBarContributor.init(toolBarManager, outlinePage);
		IContributionItem[] items = toolBarManager.getItems();
		assertEquals(2, items.length);
	}

}
