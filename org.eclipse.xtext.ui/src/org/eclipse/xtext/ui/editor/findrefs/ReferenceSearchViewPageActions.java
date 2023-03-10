/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.util.CollectionBasedAcceptor;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Iterables;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ReferenceSearchViewPageActions {

	public static class ShowNext extends Action {

		private ReferenceSearchViewPage page;

		public ShowNext(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_showNextMatch);
			setImageDescriptor(XtextPluginImages.DESC_SEARCH_NEXT);
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
			this.page = page;
		}

		@Override
		public void run() {
			page.getViewer().collapseAll();
		}
	}

	public static class Copy extends Action {
		private ReferenceSearchViewPage page;

		public Copy(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_copy);
			ImageDescriptor img = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_COPY);
			setImageDescriptor(img);
			setAccelerator(SWT.COMMAND | 'c');
			this.page = page;
		}

		@Override
		public void run() {
			TreeViewer viewer = page.getViewer();
			Clipboard clipboard = new Clipboard(viewer.getControl().getDisplay());
			
			ITreeSelection selection = page.getViewer().getStructuredSelection();
			@SuppressWarnings("unchecked")
			Object data = selection.toList().stream()
				.map(sel -> page.getLabelProvider().getText(sel))
				.collect(joining(System.lineSeparator()));
			clipboard.setContents(new Object[] {data}, new Transfer[]{TextTransfer.getInstance()});
			clipboard.dispose();
		}
	}

	public static class RemoveSelectedMatchesAction extends Action {
		private ReferenceSearchViewPage page;
		private ISearchResult searchResult;

		public RemoveSelectedMatchesAction(ReferenceSearchViewPage page) {
			super(Messages.ReferenceSearchViewPageActions_removeSelectedMatches);
			ImageDescriptor img = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE);
			setImageDescriptor(img);
			setAccelerator(SWT.DEL);
			this.page = page;
		}
		
		public void setSearchResult(ISearchResult searchResult) {
			this.searchResult = searchResult;
		}

		@Override
		public void run() {
			TreeViewer viewer = page.getViewer();
			ITreeSelection selection = viewer.getStructuredSelection();
			ReferenceSearchViewTreeNode[] removedNodes = Iterables.toArray(
					Iterables.filter(selection.toList(), ReferenceSearchViewTreeNode.class),
					ReferenceSearchViewTreeNode.class);
			page.getContentProvider().remove(removedNodes);
			
			if (searchResult instanceof ReferenceSearchResult) {
				List<IReferenceDescription> descriptions = new ArrayList<IReferenceDescription>();
				IAcceptor<IReferenceDescription> acceptor = CollectionBasedAcceptor.of(descriptions);
				for (ReferenceSearchViewTreeNode removedNode : removedNodes) {
					removedNode.collectReferenceDescriptions(acceptor);
				}
				IReferenceDescription[] descriptionsArray = descriptions.toArray(new IReferenceDescription[descriptions.size()]);
				((ReferenceSearchResult) searchResult).remove(descriptionsArray);
			}
			viewer.refresh();
		}
	}
}
