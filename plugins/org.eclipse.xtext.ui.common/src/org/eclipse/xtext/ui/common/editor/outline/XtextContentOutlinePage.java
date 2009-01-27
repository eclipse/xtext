/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.StatefulService;
import org.eclipse.xtext.ui.common.editor.outline.impl.ContentOutlineNodeAdapter;
import org.eclipse.xtext.ui.common.editor.outline.impl.ContentOutlineNodeAdapterFactory;
import org.eclipse.xtext.ui.common.editor.outline.impl.EditorSelectionChangedListener;
import org.eclipse.xtext.ui.common.editor.outline.impl.LazyVirtualContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.outline.impl.LinkingHelper;
import org.eclipse.xtext.ui.common.editor.outline.impl.OutlineSelectionChangedListener;
import org.eclipse.xtext.ui.common.editor.outline.impl.ToggleLinkWithEditorAction;
import org.eclipse.xtext.ui.core.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

/**
 * @author Peter Friese - Initial contribution and API
 */
@StatefulService
public class XtextContentOutlinePage extends LazyVirtualContentOutlinePage implements ISourceViewerAware {

	static final Logger logger = Logger.getLogger(XtextContentOutlinePage.class);

	private ISourceViewer sourceViewer;
	private OutlineSelectionChangedListener outlineSelectionChangedListener;
	private EditorSelectionChangedListener editorSelectionChangedListener;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		configureViewer();
		configureProviders();
		configureDocument();
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		registerToolbarActions(getSite().getActionBars());
	}

	@Override
	public void dispose() {
		outlineSelectionChangedListener.uninstall(this);
		outlineSelectionChangedListener = null;
		editorSelectionChangedListener.uninstall(sourceViewer.getSelectionProvider());
		editorSelectionChangedListener = null;
		super.dispose();
	}

	private void registerToolbarActions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		if (toolBarManager != null) {
			toolBarManager.add(new ToggleLinkWithEditorAction(this));
		}
	}

	private void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(2);
	}

	@Inject
	private ILazyTreeProvider provider;

	private void configureProviders() {
		getTreeViewer().setContentProvider(provider);
		getTreeViewer().setLabelProvider(provider);
	}

	private void configureDocument() {
		if (sourceViewer != null) {
			IDocument document = sourceViewer.getDocument();
			IXtextDocument xtextDocument = XtextDocumentUtil.get(document);
			xtextDocument.addModelListener(new IXtextModelListener() {
				public void modelChanged(XtextResource resource) {
					if (logger.isDebugEnabled())
						logger.debug("Document has been changed. Triggering update of outline.");
					runInSWTThread(new Runnable() {
						public void run() {
							TreeViewer viewer = getTreeViewer();
							IDocument document = sourceViewer.getDocument();
							internalSetInput(XtextDocumentUtil.get(document));
							viewer.refresh();
						}
					});
				}
			});
			internalSetInput(xtextDocument);
		}
	}

	/**
	 * Runs the runnable in the SWT thread. (Simply runs the runnable if the
	 * current thread is the UI thread, otherwise calls the runnable in
	 * asyncexec.)
	 */
	public void runInSWTThread(Runnable runnable) {
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(runnable);
		}
		else {
			runnable.run();
		}
	}

	private void internalSetInput(IXtextDocument xtextDocument) {
		TreeViewer tree = getTreeViewer();
		if (tree != null) {
			Object[] expandedElements = tree.getExpandedElements();
			tree.setInput(xtextDocument);
			tree.setExpandedElements(expandedElements);
		}
	}

	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
		getOutlineSelectionListener().install(this);
		getEditorSelectionChangedListener().install(sourceViewer.getSelectionProvider());
	}

	public ISourceViewer getSourceViewer() {
		return sourceViewer;
	}

	private OutlineSelectionChangedListener getOutlineSelectionListener() {
		if (outlineSelectionChangedListener == null) {
			outlineSelectionChangedListener = new OutlineSelectionChangedListener(this);
		}
		return outlineSelectionChangedListener;
	}

	private EditorSelectionChangedListener getEditorSelectionChangedListener() {
		if (editorSelectionChangedListener == null) {
			editorSelectionChangedListener = new EditorSelectionChangedListener(this);
		}
		return editorSelectionChangedListener;
	}

	public boolean isLinkingEnabled() {
		return LinkingHelper.isLinkingEnabled();
	}

	public void setLinkingEnabled(boolean enabled) {
		LinkingHelper.setLinkingEnabled(enabled);
	}

	public IXtextDocument getDocument() {
		return XtextDocumentUtil.get(getSourceViewer());
	}

	public void synchronizeOutlinePage() {
		getDocument().readOnly(new UnitOfWork<Object>() {
			public Object exec(XtextResource resource) throws Exception {
				int caretOffset = getSourceViewer().getTextWidget().getCaretOffset();

				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				CompositeNode rootNode = parseResult.getRootNode();
				AbstractNode currentNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, caretOffset);
				synchronizeOutlinePage(currentNode);
				return null;
			}
		});
	}

	private boolean shouldSynchronizeOutlinePage() {
		return isLinkingEnabled();
	}

	public void synchronizeOutlinePage(AbstractNode node) {
		ISelection selection = StructuredSelection.EMPTY;

		if (shouldSynchronizeOutlinePage()) {
			if (node != null) {
				EObject nearestSemanticObject = NodeUtil.getNearestSemanticObject(node);

				CompositeNode compositeNode = node instanceof CompositeNode ? (CompositeNode) node : node.getParent();
				EObject astElement = NodeUtil.getASTElementForRootNode(compositeNode);
				if (astElement != null) {
					ContentOutlineNodeAdapter adapter = (ContentOutlineNodeAdapter) ContentOutlineNodeAdapterFactory.INSTANCE
							.adapt(astElement, ContentOutlineNode.class);
					if (adapter != null) {
						ContentOutlineNode contentOutlineNode = adapter.getContentOutlineNode();
						if (contentOutlineNode != null) {
							selection = new StructuredSelection(contentOutlineNode);
						}
					}
				}
			}
			outlineSelectionChangedListener.uninstall(this);
			this.setSelection(selection, true);
			outlineSelectionChangedListener.install(this);
		}
	}

	public void setSelection(ISelection selection, boolean reveal) {
		getTreeViewer().setSelection(selection, reveal);
	}

}
