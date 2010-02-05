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
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
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
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.StyledLabelProviderAdapter;
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

	/**
	 * The label provider implements the interface {@link ILabelProvider}, because the 
	 * default sorter will use the plain text of the label to compare two items.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected static class LabelProvidingDelegatingStyledCellLabelProvider extends DelegatingStyledCellLabelProvider implements ILabelProvider {

		public LabelProvidingDelegatingStyledCellLabelProvider(IStyledLabelProvider labelProvider) {
			super(labelProvider);
		}

		public String getText(Object element) {
			StyledString styledText = getStyledText(element);
			if (styledText != null)
				return styledText.getString();
			return null;
		}
		
	}
	
	/**
	 * @author Michael Clay - Initial contribution and API
	 */
	protected static class ContentOutlineNodeStyledLabelProvider extends StyledLabelProviderAdapter {
		private final LocalResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

		@Override
		public StyledString getStyledText(Object element) {
			if (element instanceof ContentOutlineNode) {
				ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
				return contentOutlineNode.getStyledString();
			}
			return null;
		}

		@Override
		public Image getImage(Object element) {
			Image image = null;
			if (element instanceof ContentOutlineNode) {
				ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
				image = contentOutlineNode.getImage();
				if (image == null) {
					ImageDescriptor imageDescriptor = contentOutlineNode.getImageDescriptor();
					if (imageDescriptor == null) {
						imageDescriptor = Activator.getImageDescriptor("icons/defaultoutlinenode.gif");
					}
					image = resourceManager.createImage(imageDescriptor);
					contentOutlineNode.setImage(image);
				}
			}
			return image;
		}

		@Override
		public void dispose() {
			super.dispose();
			resourceManager.dispose();
		}

	}
	
	@Inject
	private IOutlineTreeProvider provider;

	@Inject
	private IContentOutlineNodeAdapterFactory outlineNodeFactory;

	@Inject
	private IActionBarContributor actionbarContributor;

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

	private void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(2);
		viewer.setUseHashlookup(false);
	}

	private void configureContextMenu() {
		MenuManager manager = new MenuManager(contextMenuID, contextMenuID);
		manager.setRemoveAllWhenShown(true);
		// manager.addMenuListener(new IMenuListener() {
		// public void menuAboutToShow(IMenuManager m) {
		// contextMenuAboutToShow(m);
		// }
		// });
		contextMenu = manager.createContextMenu(getTreeViewer().getTree());
		getTreeViewer().getTree().setMenu(contextMenu);

		IPageSite site = getSite();
		Platform.getAdapterManager().registerAdapters(outlineNodeFactory, ContentOutlineNode.class);
		site.registerContextMenu(Activator.PLUGIN_ID + ".outline", manager, getTreeViewer()); //$NON-NLS-1$
	}

	protected void configureProviders() {
		Assert.isNotNull(provider, "No ILazyTreeProvider available. Dependency injection broken?");
		getTreeViewer().setContentProvider(provider);
		getTreeViewer().setLabelProvider(new LabelProvidingDelegatingStyledCellLabelProvider(getStyledLabelProvider()));
	}

	protected IStyledLabelProvider getStyledLabelProvider() {
		return new ContentOutlineNodeStyledLabelProvider();
	}

	private void configureDocument() {
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
		provider.dispose();
		provider = null;
		super.dispose();
	}

	/**
	 * Runs the runnable in the SWT thread. (Simply runs the runnable if the current thread is the UI thread, otherwise
	 * calls the runnable in asyncexec.)
	 */
	private void runInSWTThread(Runnable runnable) {
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
				int caretOffset = getSourceViewer().getTextWidget().getCaretOffset();

				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				CompositeNode rootNode = parseResult.getRootNode();
				AbstractNode currentNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, caretOffset);
				synchronizeOutlinePage(currentNode);
			}
		});
	}

	private boolean shouldSynchronizeOutlinePage() {
		return isLinkingEnabled();
	}

	private ContentOutlineNode findMostSignificantOutlineNode(AbstractNode node) {
		if (node != null) {
			CompositeNode compositeNode = node instanceof CompositeNode ? (CompositeNode) node : node.getParent();
			EObject astElement = NodeUtil.getASTElementForRootNode(compositeNode);
			if (astElement != null) {
				ContentOutlineNodeAdapter adapter = (ContentOutlineNodeAdapter) EcoreUtil.getAdapter(astElement
						.eAdapters(), ContentOutlineNode.class);
				if (adapter != null) {
					ContentOutlineNode contentOutlineNode = adapter.getContentOutlineNode();
					if (contentOutlineNode != null) {
						return contentOutlineNode;
					}
				} else {
					CompositeNode parent = node.getParent();
					return findMostSignificantOutlineNode(parent);
				}
			}
		}
		return null;
	}

	public void synchronizeOutlinePage(AbstractNode node) {
		ISelection selection = StructuredSelection.EMPTY;

		if (shouldSynchronizeOutlinePage()) {
			ContentOutlineNode mostSignificantOutlineNode = findMostSignificantOutlineNode(node);
			if (mostSignificantOutlineNode != null) {
				selection = new StructuredSelection(mostSignificantOutlineNode);
			}
			outlineSelectionChangedListener.uninstall(this);
			this.setSelection(selection, true);
			outlineSelectionChangedListener.install(this);
		}
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

	private void refresh() {
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
