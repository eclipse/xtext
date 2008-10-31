/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ui.core.XtextUIMessages;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.core.internal.Activator;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextEditor extends TextEditor implements IExecutableExtension {

	private static final Logger log = Logger.getLogger(XtextEditor.class);

	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$

	@Inject
	private XtextSourceViewerConfiguration sourceViewerConfiguration;

	@Inject(optional = true)
	private IContentOutlinePage outlinePage;

	private IServiceScope scope;

	public boolean isEditorSelectionUpdating;

	public boolean isOutlineSelectionUpdating;

	// TODO private IFoldingUpdater foldingSupport;

	public XtextEditor() {
		log.debug("Creating Xtext Editor. Instance: [" + this.toString() + "]");
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
		super.setInitializationData(config, propertyName, data);
		String id = config.getAttribute("id");
		scope = ServiceScopeFactory.get(id);
		if (scope == null) {
			throw new IllegalStateException("scope " + data + " has not been registered.");
		}
		ServiceRegistry.injectServices(scope, this);
	}

	public IServiceScope getScope() {
		return scope;
	}

	/**
	 * This listener listens to selections in the outline and will update the
	 * editor selection accordingly.
	 */
	private final class OutlineSelectionChangedListener extends AbstractSelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			updateSelection(event);
		}

		protected void updateSelection(SelectionChangedEvent event) {
			ISelection sel = event.getSelection();
			if (sel instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) sel;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof URI) {
					final URI uri = (URI) firstElement;
					getDocument().readOnly(new UnitOfWork<Object>() {
						public Object exec(XtextResource resource) throws Exception {
							EObject astNode = resource.getResourceSet().getEObject(uri, true);
							NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(astNode);
							CompositeNode parserNode = nodeAdapter.getParserNode();

							AbstractNode selectionNode = findSelectionNode(parserNode);
							int offset = selectionNode.getOffset();
							int length = selectionNode.getLength();

							getSourceViewer().revealRange(offset, length);
							getSourceViewer().setSelectedRange(offset, length);

							return null;
						}
					});

				}
			}
		}
		
		private AbstractNode findSelectionNode(CompositeNode startNode) {
			EList<AbstractNode> leafNodes = startNode.getChildren();
			AbstractNode keywordNode = null;
			AbstractNode idNode = null;
			for (AbstractNode leafNode : leafNodes) {
				EObject grammarElement = leafNode.getGrammarElement();
				if (grammarElement instanceof RuleCall) {
					RuleCall ruleCall = (RuleCall) grammarElement;
					String ruleName = ruleCall.getName();
					if (idNode == null && ruleName.equals("ID")) {
						idNode = leafNode;
					}
				}
				else if (grammarElement instanceof Keyword) {
					if (keywordNode == null) {
						keywordNode = leafNode;
					}
				}
			}

			if (idNode != null) {
				return idNode;
			}
			else if (keywordNode != null) {
				return keywordNode;
			}
			else {
				return startNode;
			}
		}
	}

	/**
	 * This listener listens to selections in the text editor and will update
	 * the outline selection accordingly.
	 */
	private final class EditorSelectionChangedListener extends AbstractSelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			handleSelectionChangedSourcePage(event);
		}

		protected void handleSelectionChangedSourcePage(SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if (!selection.isEmpty() && selection instanceof ITextSelection) {

				final ITextSelection textSel = (ITextSelection) selection;

				getDocument().readOnly(new UnitOfWork<Object>() {
					public CompositeNode exec(XtextResource resource) throws Exception {
						IParseResult parseResult = resource.getParseResult();
						Assert.isNotNull(parseResult);
						CompositeNode rootNode = parseResult.getRootNode();

						// Get the current element from the offset
						int offset = textSel.getOffset();
						AbstractNode node = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, offset);

						// Synchronize the outline page
						synchronizeOutlinePage(node);

						return null;
					}
				});

			}
		}
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
		return true;
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
			outlineSelectionChangedListener.uninstall(outlinePage);
			outlinePage.setSelection(selection);
			outlineSelectionChangedListener.install(outlinePage);
		}
	}

	public IXtextDocument getDocument() {
		return XtextDocumentUtil.get(getSourceViewer());
	}

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		log.debug("doSetInput:" + input);
		log.debug("Editor instance is [" + this.toString() + "]");
		super.doSetInput(input);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		log.debug("init:" + input);
		if (!(input instanceof IURIEditorInput))
			throw new IllegalArgumentException("Can only handle IURIEditorInputs");

		// do document provider setup
		setDocumentProvider(new XtextDocumentProvider());

		// source viewer setup
		setSourceViewerConfiguration(sourceViewerConfiguration);

		// NOTE: Outline CANNOT be initialized here, since we do not have access
		// to the source viewer yet (it will be created later).

		super.init(site, input);
	}

	public IResource getResource() {
		Object adapter = getEditorInput().getAdapter(IResource.class);
		if (adapter != null) {
			return (IResource) adapter;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IContentOutlinePage.class)) {
			return getContentOutlinePage();
		}
		return super.getAdapter(adapter);
	}

	private IContentOutlinePage getContentOutlinePage() {
		if (outlinePage != null) {
			if (outlinePage instanceof ISourceViewerAware) {
				((ISourceViewerAware) outlinePage).setSourceViewer(getSourceViewer());
			}
			getOutlineSelectionChangedListener().install(outlinePage);
			getEditorSelectionChangedListener().install(getSelectionProvider());
		}
		return outlinePage;
	}

	private OutlineSelectionChangedListener outlineSelectionChangedListener;

	private OutlineSelectionChangedListener getOutlineSelectionChangedListener() {
		if (outlineSelectionChangedListener == null) {
			outlineSelectionChangedListener = new OutlineSelectionChangedListener();
		}
		return outlineSelectionChangedListener;
	}

	private EditorSelectionChangedListener editorSelectionChangedListener;

	private EditorSelectionChangedListener getEditorSelectionChangedListener() {
		if (editorSelectionChangedListener == null) {
			editorSelectionChangedListener = new EditorSelectionChangedListener();
		}
		return editorSelectionChangedListener;
	}

	@Override
	protected void createActions() {
		super.createActions();
		Action action = null;
		if (getSourceViewerConfiguration().getContentFormatter(getSourceViewer()) != null) {
			action = new TextOperationAction(XtextUIMessages.getResourceBundle(), "Format.", this, ISourceViewer.FORMAT); //$NON-NLS-1$
			action.setActionDefinitionId(Activator.PLUGIN_ID + ".FormatAction");
			setAction("Format", action); //$NON-NLS-1$
			markAsStateDependentAction("Format", true); //$NON-NLS-1$
			markAsSelectionDependentAction("Format", true); //$NON-NLS-1$
		}

		// Creates an build-in "click an ruler annotation, marks corresponding
		// text" - action
		SelectMarkerRulerAction markerAction = new XtextMarkerRulerAction(XtextUIMessages.getResourceBundle(),
				"XtextSelectAnnotationRulerAction.", this, getVerticalRuler()); //$NON-NLS-1$
		setAction(ITextEditorActionConstants.RULER_CLICK, markerAction);
	}

	/**
	 * @return true if content assist is available
	 * 
	 */
	public boolean isContentAssistAvailable() {
		return getSourceViewerConfiguration().getContentAssistant(getSourceViewer()) != null;
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		log.debug("Creating Xtext source viewer.");
		// overwrite superclass implementation to allow folding
		fAnnotationAccess = createAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());
		ISourceViewer projectionViewer = new ProjectionViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);
		getSourceViewerDecorationSupport(projectionViewer);
		return projectionViewer;
	}

	private ProjectionSupport projectionSupport;

	@Override
	public void createPartControl(Composite parent) {

		super.createPartControl(parent);
		// We need ProjectionViewer to support Folding
		ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); //$NON-NLS-1$
		projectionSupport.install();
		// TODO Folding stuff
	}

	@Override
	public void dispose() {
		super.dispose();
		if (projectionSupport != null) {
			projectionSupport.dispose();
		}
		if (outlineSelectionChangedListener != null) {
			outlineSelectionChangedListener.uninstall(outlinePage);
			outlineSelectionChangedListener = null;
		}
		if (editorSelectionChangedListener != null) {
			editorSelectionChangedListener.uninstall(getSelectionProvider());
			editorSelectionChangedListener = null;
		}
		if (outlinePage != null) {
			outlinePage = null;
		}
	}

	// @Override
	// protected String[] collectContextMenuPreferencePages() {
	// String[] ids = super.collectContextMenuPreferencePages();
	// String[] more = new String[ids.length + 4];
	// // NOTE: preference page at index 0 will be opened, see
	// // PreferencesUtil.createPreferenceDialogOn
	// String languageId = languageDescriptor.getId();
	//		more[0] = languageId + ".editor"; //$NON-NLS-1$
	// more[1] = languageId;
	//		more[2] = languageId + ".editor.templates"; //$NON-NLS-1$
	//		more[3] = languageId + ".editor.syntaxcoloring"; //$NON-NLS-1$
	// System.arraycopy(ids, 0, more, 4, ids.length);
	// return more;
	// }
}
