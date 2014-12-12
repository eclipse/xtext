/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import static com.google.common.collect.Lists.*;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeNodeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;
import org.eclipse.xtext.ui.util.DisplayRunHelper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Anton Kosyakov - Added registering of a context menu
 */
public class OutlinePage extends ContentOutlinePage implements ISourceViewerAware {

	private static final String MENU_ID = "org.eclipse.xtext.ui.outline";

	private static final Logger LOG = Logger.getLogger(OutlinePage.class);

	private static final String CONTEXT_MENU_ID = "OutlinePageContextMenu";

	@Inject
	private OutlineNodeLabelProvider labelProvider;
	
	@Inject
	private BusyLabelProvider busyLabelProvider;

	@Inject
	private OutlineNodeContentProvider contentProvider;

	@Inject
	private IOutlineTreeProvider treeProvider;

	@Inject
	private OutlineFilterAndSorter filterAndSorter;

	@Inject
	private IOutlineContribution.Composite contribution;

	private IXtextModelListener modelListener;

	private ITextInputListener textInputListener;

	private IXtextDocument xtextDocument;

	private ISourceViewer sourceViewer;

	@Inject
	private OutlineRefreshJob refreshJob;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		configureTree();
		configureModelListener();
		configureActions();
		refreshJob.setOutlinePage(this);
		configureContextMenu();
	}

	protected void configureTree() {
		TreeViewer treeViewer = getTreeViewer();
		contentProvider.setFilterAndSorter(filterAndSorter);
		treeViewer.setUseHashlookup(true);
		// access EMF's image registry now, since it needs a UI-thread.
		ExtendedImageRegistry.getInstance();
		if (treeProvider instanceof IOutlineTreeProvider.Background) {
			showBusyStatus();
			new Job("Initializing Outline") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						initializeTreeContent();
						return Status.OK_STATUS;
					} catch (Throwable e) {
						LOG.error("Error initializing outline", e);
						return Status.OK_STATUS; 
					}
				}
				
			}.schedule();
		} else {
			initializeTreeContent();
		}
	}
	
	/**
	 * @since 2.8
	 */
	protected void showBusyStatus() {
		TreeViewer treeViewer = getTreeViewer();
		treeViewer.setLabelProvider(busyLabelProvider);
		treeViewer.setContentProvider(new TreeNodeContentProvider());
		treeViewer.setInput(new TreeNode[] { new TreeNode("Loading...") });
	}

	/**
	 * @since 2.4
	 */
	protected void initializeTreeContent() {
		List<IOutlineNode> initiallyExpandedNodes = xtextDocument
				.readOnly(new IUnitOfWork<List<IOutlineNode>, XtextResource>() {
					@Override
					public List<IOutlineNode> exec(XtextResource resource) throws Exception {
						return getInitiallyExpandedNodes();
					}
				});
		refreshViewer(initiallyExpandedNodes.get(0), initiallyExpandedNodes, Collections.<IOutlineNode> emptySet());
	}

	protected List<IOutlineNode> getInitiallyExpandedNodes() {
		IOutlineNode rootNode = treeProvider.createRoot(xtextDocument);
		List<IOutlineNode> result = newArrayList(rootNode);
		addChildren(Collections.singletonList(rootNode), result, getDefaultExpansionLevel());
		return result;
	}

	protected int getDefaultExpansionLevel() {
		return 1;
	}

	protected void addChildren(List<IOutlineNode> nodes, List<IOutlineNode> allChildren, int depth) {
		if (depth > 1) {
			for (IOutlineNode node : nodes) {
				List<IOutlineNode> children = node.getChildren();
				allChildren.addAll(children);
				addChildren(children, allChildren, depth - 1);
			}
		}
	}

	protected void configureModelListener() {
		if (xtextDocument != null) { // possibly disposed in the meantime
			modelListener = new IXtextModelListener() {
				@Override
				public void modelChanged(XtextResource resource) {
					try {
						scheduleRefresh();
					} catch (Throwable t) {
						LOG.error("Error refreshing outline", t);
					}
				}
	
			};
			xtextDocument.addModelListener(modelListener);
		}
	}

	protected void configureActions() {
		contribution.register(this);
	}

	/**
	 * @since 2.4
	 */
	protected void configureContextMenu() {
		MenuManager menuManager = new MenuManager(CONTEXT_MENU_ID, CONTEXT_MENU_ID);
		menuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		menuManager.setRemoveAllWhenShown(true);
		
		Menu contextMenu = menuManager.createContextMenu(getTreeViewer().getTree());
		getTreeViewer().getTree().setMenu(contextMenu);
		getSite().registerContextMenu(MENU_ID, menuManager, getTreeViewer());
	}
	
	@Override
	public void dispose() {
		contribution.deregister(this);
		sourceViewer.removeTextInputListener(textInputListener);
		if (modelListener != null) {
			xtextDocument.removeModelListener(modelListener);
			modelListener = null;
		}
		contentProvider.dispose();
		super.dispose();
	}

	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
		IDocument document = sourceViewer.getDocument();
		xtextDocument = XtextDocumentUtil.get(document);
		Assert.isNotNull(xtextDocument);
		configureTextInputListener();
	}

	/**
	 * @since 2.0
	 */
	protected void configureTextInputListener() {
		textInputListener = new ITextInputListener() {
			@Override
			public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
				try {
					if (xtextDocument != null && modelListener != null)
						xtextDocument.removeModelListener(modelListener);
					xtextDocument = XtextDocumentUtil.get(newInput);
					if (xtextDocument != null && modelListener != null) {
						xtextDocument.addModelListener(modelListener);
						scheduleRefresh();
					}
				} catch (Throwable t) {
					LOG.error("Error refreshing outline", t);
				}
			}

			@Override
			public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
			}
		};
		sourceViewer.addTextInputListener(textInputListener);
	}

	public ISourceViewer getSourceViewer() {
		return sourceViewer;
	}

	public IXtextDocument getXtextDocument() {
		return xtextDocument;
	}

	protected OutlineRefreshJob getRefreshJob() {
		return refreshJob;
	}

	public void scheduleRefresh() {
		refreshJob.cancel();
		refreshJob.schedule();
	}

	@Override
	public TreeViewer getTreeViewer() {
		return super.getTreeViewer();
	}

	public IOutlineTreeProvider getTreeProvider() {
		return treeProvider;
	}

	/**
	 * @since 2.2
	 */
	public OutlineFilterAndSorter getFilterAndSorter() {
		return filterAndSorter;
	}

	protected void refreshViewer(final IOutlineNode rootNode, final Collection<IOutlineNode> nodesToBeExpanded,
			final Collection<IOutlineNode> selectedNodes) {
		DisplayRunHelper.runAsyncInDisplayThread(new Runnable() {
			@Override
			public void run() {
				try {
					TreeViewer treeViewer = getTreeViewer();
					if (!treeViewer.getTree().isDisposed()) {
						if (treeViewer.getLabelProvider() != labelProvider) {
							if (treeViewer.getInput() != null && treeViewer.getContentProvider() != null)
								treeViewer.setInput(null);
							treeViewer.setLabelProvider(labelProvider);
						}
						if (treeViewer.getContentProvider() != contentProvider) {
							if (treeViewer.getInput() != null && treeViewer.getContentProvider() != null)
								treeViewer.setInput(null);
							treeViewer.setContentProvider(contentProvider);
						}
						treeViewer.setInput(rootNode);
						treeViewer.expandToLevel(1);
						treeViewer.setExpandedElements(Iterables.toArray(nodesToBeExpanded, IOutlineNode.class));
						treeViewer.setSelection(new StructuredSelection(Iterables.toArray(selectedNodes,
								IOutlineNode.class)));
						ISelectionProvider selectionProvider = sourceViewer.getSelectionProvider();
						selectionProvider.setSelection(selectionProvider.getSelection());
						treeUpdated();
					}
				} catch (Throwable t) {
					LOG.error("Error refreshing outline", t);
				}
			}
		});
	}

	/**
	 * For testing.
	 */
	protected void treeUpdated() {
	}
	
	/**
	 * A label provider used for showing the busy status. It relies on {@link TreeNode}s to retrieve the text content.
	 * @since 2.8
	 */
	protected static class BusyLabelProvider extends AbstractLabelProvider {
		@Override
		public String doGetText(Object element) {
			if (element instanceof TreeNode) {
				TreeNode node = (TreeNode) element;
				return String.valueOf(node.getValue());
			}
			return super.getText(element);
		}
		@Override
		protected Object getDefaultImage() {
			URL imgUrl = Activator.getDefault().getBundle().getEntry("icons/defaultoutlinenode.gif");
			if (imgUrl != null)
				return ImageDescriptor.createFromURL(imgUrl);
			return null;
		}
	}

}
