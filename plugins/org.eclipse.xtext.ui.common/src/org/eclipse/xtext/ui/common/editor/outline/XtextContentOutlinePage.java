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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.StatefulService;
import org.eclipse.xtext.ui.core.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

/**
 * An outline page for Xtext based editors.
 * 
 * @author Peter Friese - Initial contribution and API
 */
@StatefulService
public class XtextContentOutlinePage extends ContentOutlinePage implements IContentOutlinePage, ISourceViewerAware {

	static final Logger logger = Logger.getLogger(XtextContentOutlinePage.class);
	private ISourceViewer sourceViewer;
	private OutlineSelectionChangedListener outlineSelectionChangedListener;
	private EditorSelectionChangedListener editorSelectionChangedListener;

	public XtextContentOutlinePage() {
		if (logger.isDebugEnabled())
			logger.debug("Creating content outline page. Outline instance [" + this.toString() + "]");
	}
	
	@Override
	public void dispose() {
		outlineSelectionChangedListener.uninstall(this);
		outlineSelectionChangedListener = null;
		editorSelectionChangedListener.uninstall(sourceViewer.getSelectionProvider());
		editorSelectionChangedListener = null;
		super.dispose();
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
							viewer.refresh();
						}
					});
				}
			});
			internalSetInput(xtextDocument);
		}
	}

	private void configureProviders() {
		TreeViewer viewer = getTreeViewer();
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		XtextContentOutlineProvider provider = new XtextContentOutlineProvider(composedAdapterFactory);
		viewer.setContentProvider(provider);
		viewer.setLabelProvider(provider);
	}

	private void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(3);
		viewer.setUseHashlookup(true);
	}

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

	private void registerToolbarActions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		if (toolBarManager != null) {
			 toolBarManager.add(new ToggleLinkWithEditorAction(this));
			// toolBarManager.add(new XtextOutlineSortingAction(this));
		}
	}

	private void internalSetInput(IXtextDocument xtextDocument) {
		if (getTreeViewer() != null) {
			getTreeViewer().setInput(xtextDocument);
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
	
	public boolean isLinkingEnabled() {
		return LinkingHelper.isLinkingEnabled();
	}
	
	public void setLinkingEnabled(boolean enabled) {
		LinkingHelper.setLinkingEnabled(enabled);
	}

	public void synchronizeOutlinePage(AbstractNode node) {
		ISelection selection = StructuredSelection.EMPTY;

		if (shouldSynchronizeOutlinePage()) {
			if (node != null && node instanceof LeafNode) {
				CompositeNode compositeNode = node.getParent();
				EObject astElement = NodeUtil.getASTElementForRootNode(compositeNode);
				if (astElement != null) {
					URI uri = EcoreUtil.getURI(astElement);
					selection = new StructuredSelection(uri);
				}
			}
			outlineSelectionChangedListener.uninstall(this);
			this.setSelection(selection);
			outlineSelectionChangedListener.install(this);
		}
	}
	
}
