/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProviderFactory;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.editor.preferences.PreferencesQualifiedName;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.IFoldingStructureProvider;
import org.eclipse.xtext.ui.service.IPreferenceStore;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class BaseTextEditor extends TextEditor implements IEditorModelProvider {

	private final class PreferenceStorePropertyChangeListener implements IPropertyChangeListener {
		public void propertyChange(PropertyChangeEvent event) {
			// language dependent preferences starts with language
			// id so check if this event is for current language
			if (event != null && event.getProperty() != null
					&& event.getProperty().startsWith(getLanguageDescriptor().getId())) {
				// syntax highlighting
				if (event.getProperty().startsWith(
						PreferencesQualifiedName.parse(getLanguageDescriptor().getId()).append(
								IPreferenceStore.SYNTAX_COLORER_PREFERENCE_TAG).toString())) {
					if (getSourceViewer() instanceof TextViewer) {
						TextViewer tv = (TextViewer) getSourceViewer();
						tv.invalidateTextPresentation();
					}
				}
			}
		}
	}

	private abstract class AbstractSelectionChangedListener implements ISelectionChangedListener {

		public void install(ISelectionProvider selectionProvider) {
			if (selectionProvider != null) {
				if (selectionProvider instanceof IPostSelectionProvider) {
					IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
					provider.addPostSelectionChangedListener(this);
				}
				else {
					selectionProvider.addSelectionChangedListener(this);
				}
			}
		}

		public void uninstall(ISelectionProvider selectionProvider) {
			if (selectionProvider != null) {
				if (selectionProvider instanceof IPostSelectionProvider) {
					IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
					provider.removePostSelectionChangedListener(this);
				}
				else {
					selectionProvider.removeSelectionChangedListener(this);
				}
			}
		}

	}

	/**
	 * This listener listens to selections in the outline and will update the
	 * editor selection accordingly.
	 */
	private final class OutlineSelectionChangedListener extends AbstractSelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			updateSelection(event);
		}

		public void updateSelection(SelectionChangedEvent event) {
			ISelection sel = event.getSelection();
			if (sel instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) sel;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof EObject) {
					EObject astNode = (EObject) firstElement;
					NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(astNode);
					CompositeNode parserNode = nodeAdapter.getParserNode();

					AbstractNode selectionNode = findSelectionNode(parserNode);
					int offset = selectionNode.getOffset();
					int length = selectionNode.getLength();

					getSourceViewer().revealRange(offset, length);
					getSourceViewer().setSelectedRange(offset, length);
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

				ITextSelection textSel = (ITextSelection) selection;

				// Get the current element from the offset
				int offset = textSel.getOffset();
				AbstractNode node = ParseTreeUtil.getCurrentNodeByOffset(model.getParseTreeRootNode(), offset);

				// Synchronize the outline page
				synchronizeOutlinePage(node);
			}
		}
	}

	public void synchronizeOutlinePage() {
		int caretOffset = getSourceViewer().getTextWidget().getCaretOffset();
		AbstractNode currentNode = ParseTreeUtil.getCurrentNodeByOffset(model.getParseTreeRootNode(), caretOffset);
		synchronizeOutlinePage(currentNode);
	}

	private boolean shouldSynchronizeOutlinePage() {
		return Activator.getDefault().getPreferenceStore().getBoolean("ToggleLinkWithEditorAction.isChecked");
	}

	public void synchronizeOutlinePage(AbstractNode node) {
		ISelection selection = StructuredSelection.EMPTY;

		if (shouldSynchronizeOutlinePage()) {
			outlineSelectionChangedListener.uninstall(outlinePage);
			if (node != null && node instanceof LeafNode) {
				CompositeNode compositeNode = node.getParent();
				EObject astElement = NodeUtil.getASTElementForRootNode(compositeNode);
				if (astElement != null) {
					selection = new StructuredSelection(astElement);
				}
			}
			outlinePage.setSelection(selection);
			outlineSelectionChangedListener.install(outlinePage);
		}
	}

	Log log = LogFactory.getLog(BaseTextEditor.class);

	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$

	protected boolean selectionSetFromOutline;

	private IEditorModel model;
	private XtextContentOutlinePage outlinePage;

	private ProjectionSupport projectionSupport;
	private FoldingUpdater foldingSupport;

	@Inject
	private IServiceScope languageDescriptor;

	private AbstractSelectionChangedListener editorSelectionChangedListener;

	private OutlineSelectionChangedListener outlineSelectionChangedListener;

	@Override
	public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
		super.setInitializationData(cfig, propertyName, data);
		// try plain text editor if problem occurs
		if (languageDescriptor != null) {
			IPreferenceStore xtextPreferenceStore = ServiceRegistry.getService(languageDescriptor,
					IPreferenceStore.class);
			ChainedPreferenceStore chainedPreferenceStore = new ChainedPreferenceStore(
					new org.eclipse.jface.preference.IPreferenceStore[] { getPreferenceStore(),
							xtextPreferenceStore.getPersitablePreferenceStore() });

			// source viewer setup
			setSourceViewerConfiguration(new XtextSourceViewerConfiguration(languageDescriptor, chainedPreferenceStore,
					this));

			// document provider setup
			setDocumentProvider(XtextDocumentProviderFactory.getInstance().getDocumentProvider(languageDescriptor));

		}
		else {
			CoreLog.logError(XtextUIMessages.getFormattedString("BaseTextEditor.NoLanguageDescriptor", //$NON-NLS-1$
					this.getConfigurationElement().getNamespaceIdentifier()), new IllegalStateException());
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		// Error marker
		IResource resource = getResource();
		if (resource != null && isEditable() && getModel() != null) {
			XtextProblemMarkerCreator markerCreator = new XtextProblemMarkerCreator(resource);
			markerCreator.setProgressMonitor(new NullProgressMonitor());
			getModel().addModelListener(markerCreator);
		}
	}

	private IResource getResource() {
		Object adapter = getEditorInput().getAdapter(IResource.class);
		if (adapter != null)
			return (IResource) adapter;
		return null;
	}

	public IServiceScope getLanguageDescriptor() {
		return languageDescriptor;
	}

	public IEditorModel getModel() {
		if (model == null) {
			IDocumentProvider provider = getDocumentProvider();
			if (provider instanceof XtextDocumentProvider) {
				XtextDocumentProvider documentProvider = (XtextDocumentProvider) provider;
				model = documentProvider.getModel(getEditorInput());
			}
		}
		return model;
	}

	private void setOutlinePageInput() {
		if (outlinePage != null) {
			outlinePage.setInput(getModel());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IContentOutlinePage.class)) {
			return getOutlinePage();
		}
		return super.getAdapter(adapter);
	}

	private IContentOutlinePage getOutlinePage() {
		if (outlinePage == null) {
			outlinePage = new XtextContentOutlinePage(this);

			outlineSelectionChangedListener = new OutlineSelectionChangedListener();
			outlineSelectionChangedListener.install(outlinePage);
			editorSelectionChangedListener = new EditorSelectionChangedListener();
			editorSelectionChangedListener.install(getSelectionProvider());

			setOutlinePageInput();
		}
		return outlinePage;
	}

	@Override
	protected void createActions() {
		super.createActions();
		Action action = new ContentAssistAction(XtextUIMessages.getResourceBundle(), "ContentAssistProposal.", this);//$NON-NLS-1$
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction("ContentAssistProposal", action);//$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$

		action = new TextOperationAction(XtextUIMessages.getResourceBundle(), "Format.", this, ISourceViewer.FORMAT); //$NON-NLS-1$
		action.setActionDefinitionId(Activator.PLUGIN_ID + ".FormatAction");
		setAction("Format", action); //$NON-NLS-1$
		markAsStateDependentAction("Format", true); //$NON-NLS-1$
		markAsSelectionDependentAction("Format", true); //$NON-NLS-1$
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// overwrite superclass implementation to allow folding
		fAnnotationAccess = createAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());
		ISourceViewer projectionViewer = new ProjectionViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);
		ServiceRegistry.getService(languageDescriptor, IPreferenceStore.class).getPersitablePreferenceStore()
				.addPropertyChangeListener(new PreferenceStorePropertyChangeListener());
		getSourceViewerDecorationSupport(projectionViewer);
		return projectionViewer;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		// We need ProjectionViewer to support Folding
		ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); //$NON-NLS-1$
		projectionSupport.install();

		// Folding stuff
		IFoldingStructureProvider foldingProvider = ServiceRegistry.getService(languageDescriptor,
				IFoldingStructureProvider.class);
		if (foldingProvider != null) {
			projectionViewer.doOperation(ProjectionViewer.TOGGLE);
			foldingSupport = new FoldingUpdater(foldingProvider);
			foldingSupport.bind(getModel(), projectionViewer);
		}

	}

	@Override
	public void dispose() {
		super.dispose();
		if (projectionSupport != null)
			projectionSupport.dispose();
		if (foldingSupport != null)
			foldingSupport.unbind();
	}
}
