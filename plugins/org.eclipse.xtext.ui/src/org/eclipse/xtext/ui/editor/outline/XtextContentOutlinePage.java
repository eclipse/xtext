/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.IXtextEditorAware;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.outline.actions.ContentOutlineNodeAdapter;
import org.eclipse.xtext.ui.editor.outline.actions.IActionBarContributor;
import org.eclipse.xtext.ui.editor.outline.actions.IContentOutlineNodeAdapterFactory;
import org.eclipse.xtext.ui.editor.outline.linking.EditorSelectionChangedListener;
import org.eclipse.xtext.ui.editor.outline.linking.LinkingHelper;
import org.eclipse.xtext.ui.editor.outline.linking.OutlineSelectionChangedListener;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.util.TextLocation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * An outline page for Xtext resources.
 * 
 * This class is not intended to be subclassed. It is designed to be configured with a domain specific combined label
 * and content provider (which is automatically injected to the {@link #provider} field).
 * 
 * The outline page can synchronize itself with the associated editor. Selections made in the outline will be propagated
 * to the editor at any time, whereas the synchronization from the editor to the outline can be controlled by the user
 * using the "Link with Editor" button.
 * 
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public class XtextContentOutlinePage extends ContentOutlinePage implements ISourceViewerAware, IXtextEditorAware {
	static final Logger logger = Logger.getLogger(XtextContentOutlinePage.class);

	protected static class DelegatorLabelProvider extends DelegatingStyledCellLabelProvider implements ILabelProvider {

		public DelegatorLabelProvider(IStyledLabelProvider labelProvider) {
			super(labelProvider);
		}

		public String getText(Object element) {
			StyledString styledText = getStyledText(element);
			return (styledText != null) ? styledText.getString() : null;
		}
	}
	
	@Inject
	private IOutlineTreeProvider contentProvider;

	@Inject
	private ContentOutlineNodeLabelProvider labelProvider;

	/**
	 * @deprecation see {@link IContentOutlineNodeAdapterFactory}
	 */
	@Deprecated
	@Inject(optional=true)
	private IContentOutlineNodeAdapterFactory outlineNodeAdapterFactory;

	@Inject
	private IActionBarContributor actionbarContributor;
	
	@Inject
	private IContentOutlineNodeComparer nodeComparer;

	private XtextEditor editor;
	private ISourceViewer sourceViewer;

	private OutlineSelectionChangedListener outlineSelectionChangedListener;
	private EditorSelectionChangedListener editorSelectionChangedListener;

	private IXtextModelListener modelListener;

	private Menu contextMenu;
	private static final String contextMenuID = "xtextOutlineContextMenu";

	private ViewerSorter sorter;

	public XtextContentOutlinePage() {
		sorter = createSorter();
	}

	protected ViewerSorter createSorter() {
		return new TreePathViewerSorter();
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		configureViewer();
		configureContextMenu();
		configureProviders();
		configureDocument();
		registerToolbarActions(getSite().getActionBars());
	}

	protected void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(getAutoExpandLevel());
		viewer.setUseHashlookup(false);
		viewer.setComparer(nodeComparer);
	}

	protected int getAutoExpandLevel() {
		return 2;
	}

	protected void configureContextMenu() {
		MenuManager manager = new MenuManager(contextMenuID, contextMenuID);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		contextMenu = manager.createContextMenu(getTreeViewer().getTree());
		getTreeViewer().getTree().setMenu(contextMenu);

		IPageSite site = getSite();
		// TODO: remove on next API change
		if(outlineNodeAdapterFactory != null)
			Platform.getAdapterManager().registerAdapters(outlineNodeAdapterFactory, IContentOutlineNode.class);
		site.registerContextMenu(Activator.PLUGIN_ID + ".outline", manager, getTreeViewer()); //$NON-NLS-1$
	}
	
	protected void fillContextMenu(IMenuManager menu) {
		menu.add(new Separator(IContextMenuConstants.GROUP_ADDITIONS));
	}

	protected void configureProviders() {
		getTreeViewer().setContentProvider(contentProvider);
		getTreeViewer().setLabelProvider(new DelegatorLabelProvider(labelProvider));
	}

	protected void configureDocument() {
		if (sourceViewer != null) {
			IDocument document = sourceViewer.getDocument();
			IXtextDocument xtextDocument = XtextDocumentUtil.get(document);

			// TODO: it would be better to have NodeContentAdapter update the
			// parts of the outline model that need updates instead of
			// installing a model listener.
			installModelListener();

			internalSetInput(xtextDocument, true);
		}
	}

	private void installModelListener() {
		if (sourceViewer != null) {
			IDocument document = sourceViewer.getDocument();
			IXtextDocument xtextDocument = XtextDocumentUtil.get(document);
			if (xtextDocument != null) {
				if (modelListener == null) {
					modelListener = new IXtextModelListener() {
						public void modelChanged(XtextResource resource) {
							if (logger.isDebugEnabled()) {
								logger.debug("Document has been changed. Triggering update of outline.");
							}
							refresh();
						}
					};
				}
				xtextDocument.addModelListener(modelListener);
			}
		}
	}

	private void uninstallModelListener() {
		if (sourceViewer != null) {
			IDocument document = sourceViewer.getDocument();
			IXtextDocument xtextDocument = XtextDocumentUtil.get(document);
			if (xtextDocument != null) {
				xtextDocument.removeModelListener(modelListener);
			}
		}
	}

	public IXtextDocument getDocument() {
		return XtextDocumentUtil.get(getSourceViewer());
	}

	protected void registerToolbarActions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		if (actionbarContributor != null) {
			actionbarContributor.init(toolBarManager, this);
		}
	}

	@Override
	public void dispose() {
		outlineSelectionChangedListener.uninstall(this);
		outlineSelectionChangedListener = null;
		editorSelectionChangedListener.uninstall(sourceViewer.getSelectionProvider());
		editorSelectionChangedListener = null;
		uninstallModelListener();
		if (editor != null) {
			editor.outlinePageClosed();
			editor = null;
		}
		contentProvider.dispose();
		contentProvider = null;
		super.dispose();
	}

	/**
	 * Runs the runnable in the SWT thread. (Simply runs the runnable if the current thread is the UI thread, otherwise
	 * calls the runnable in asyncexec.)
	 */
	protected void runInSWTThread(Runnable runnable) {
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(runnable);
		} else {
			runnable.run();
		}
	}

	private void internalSetInput(IXtextDocument xtextDocument, boolean initial) {
		TreeViewer tree = getTreeViewer();
		if (tree != null) {
			Object[] expandedElements = null;
			expandedElements = tree.getExpandedElements();

			tree.setInput(xtextDocument);

			if (expandedElements != null && expandedElements.length > 0)
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

	public void setEditor(XtextEditor editor) {
		this.editor = editor;
	}

	public XtextEditor getEditor() {
		return editor;
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

	public void setSelection(ISelection selection, boolean reveal) {
		if (getTreeViewer() != null) {
			getTreeViewer().setSelection(selection, reveal);
		}
	}

	public void synchronizeOutlinePage() {
		getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) throws Exception {
				if (resource != null) {
					Point selection = getSourceViewer().getTextWidget().getSelection();
					EObject eObject = EObjectAtOffsetHelper.resolveContainedElementAt(resource, selection.x,
							new TextLocation());
					synchronizeOutlinePage(eObject);
				}
			}
		});
	}

	public void synchronizeOutlinePage(EObject eObject) {
		if (isLinkingEnabled()) {
			IContentOutlineNode mostSignificantOutlineNode = findMostSignificantOutlineNode(eObject);
			if (mostSignificantOutlineNode != null) {
				outlineSelectionChangedListener.uninstall(this);
				this.setSelection(new StructuredSelection(mostSignificantOutlineNode), true);
				outlineSelectionChangedListener.install(this);
			}
		}
	}

	protected IContentOutlineNode findMostSignificantOutlineNode(EObject eObject) {
		if (eObject != null) {
			ContentOutlineNodeAdapter adapter = (ContentOutlineNodeAdapter) EcoreUtil.getAdapter(eObject.eAdapters(),
					IContentOutlineNode.class);
			if (adapter != null) {
				IContentOutlineNode contentOutlineNode = adapter.getContentOutlineNode();
				if (contentOutlineNode != null) {
					return contentOutlineNode;
				}
			} else {
				return findMostSignificantOutlineNode(eObject.eContainer());
			}
		}
		return null;
	}

	public void setSorted(boolean sorted) {
		if (getTreeViewer() != null) {
			if (sorted) {
				getTreeViewer().setSorter(sorter);
			} else {
				getTreeViewer().setSorter(null);
			}
		}
	}

	public void enableFilter(ViewerFilter filter) {
		if (getTreeViewer() != null) {
			ViewerFilter[] filters = getTreeViewer().getFilters();
			for (ViewerFilter viewerFilter : filters) {
				if (viewerFilter.equals(filter)) {
					return;
				}
			}
			getTreeViewer().addFilter(filter);
		}
	}

	public void disableFilter(ViewerFilter filter) {
		if (getTreeViewer() != null) {
			getTreeViewer().removeFilter(filter);
		}
	}

	protected void refresh() {
		runInSWTThread(new Runnable() {
			public void run() {
				TreeViewer tv = getTreeViewer();
				if (tv != null) {
					IDocument document = sourceViewer.getDocument();
					internalSetInput(XtextDocumentUtil.get(document), false);
					tv.refresh();
				}
			}
		});
	}
	
}
