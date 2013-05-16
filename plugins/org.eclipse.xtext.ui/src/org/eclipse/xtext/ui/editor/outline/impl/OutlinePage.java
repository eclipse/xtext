/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import static com.google.common.collect.Lists.*;

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
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.StructuredSelection;
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
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setContentProvider(contentProvider);
		contentProvider.setFilterAndSorter(filterAndSorter);
		treeViewer.setUseHashlookup(true);
		// access EMF's image registry now, since it needs a UI-thread.
		ExtendedImageRegistry.getInstance();
		if(treeProvider instanceof BackgroundOutlineTreeProvider) {
			new Job("Initializing outline") {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					initializeTreeContent();
					return Status.OK_STATUS;
				}
				
			}.schedule();
		} else {
			initializeTreeContent();
		}
	}

	/**
	 * @since 2.4
	 */
	protected void initializeTreeContent() {
		List<IOutlineNode> initiallyExpandedNodes = xtextDocument
				.readOnly(new IUnitOfWork<List<IOutlineNode>, XtextResource>() {
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
		for (IOutlineNode node : nodes) {
			List<IOutlineNode> children = node.getChildren();
			if (depth > 1) {
				allChildren.addAll(children);
				addChildren(children, allChildren, depth - 1);
			}
		}
	}

	protected void configureModelListener() {
		modelListener = new IXtextModelListener() {
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
			public void run() {
				try {
					TreeViewer treeViewer = getTreeViewer();
					if (!treeViewer.getTree().isDisposed()) {
						treeViewer.setInput(rootNode);
						treeViewer.expandToLevel(1);
						treeViewer.setExpandedElements(Iterables.toArray(nodesToBeExpanded, IOutlineNode.class));
						treeViewer.setSelection(new StructuredSelection(Iterables.toArray(selectedNodes,
								IOutlineNode.class)));
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

}
