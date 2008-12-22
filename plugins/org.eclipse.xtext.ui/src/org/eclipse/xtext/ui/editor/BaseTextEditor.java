/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.apache.log4j.Logger;
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
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;
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
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IFoldingStructureProvider;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.ui.service.utils.PropertiesResolver;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 */
public class BaseTextEditor extends TextEditor implements IEditorModelProvider {

	private abstract class AbstractSelectionChangedListener implements ISelectionChangedListener {

		public void install(final ISelectionProvider selectionProvider) {
			if (selectionProvider != null) {
				if (selectionProvider instanceof IPostSelectionProvider) {
					final IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
					provider.addPostSelectionChangedListener(this);
				}
				else {
					selectionProvider.addSelectionChangedListener(this);
				}
			}
		}

		public void uninstall(final ISelectionProvider selectionProvider) {
			if (selectionProvider != null) {
				if (selectionProvider instanceof IPostSelectionProvider) {
					final IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
					provider.removePostSelectionChangedListener(this);
				}
				else {
					selectionProvider.removeSelectionChangedListener(this);
				}
			}
		}

	}

	/**
	 * This listener listens to selections in the text editor and will update
	 * the outline selection accordingly.
	 */
	private final class EditorSelectionChangedListener extends AbstractSelectionChangedListener {
		public void selectionChanged(final SelectionChangedEvent event) {
			handleSelectionChangedSourcePage(event);
		}

		protected void handleSelectionChangedSourcePage(final SelectionChangedEvent event) {
			final ISelection selection = event.getSelection();
			if (!selection.isEmpty() && selection instanceof ITextSelection) {

				final ITextSelection textSel = (ITextSelection) selection;

				// Get the current element from the offset
				final int offset = textSel.getOffset();
				final AbstractNode node = ParseTreeUtil.getLastCompleteNodeByOffset(model.getParseTreeRootNode(),
						offset);

				// Synchronize the outline page
				synchronizeOutlinePage(node);
			}
		}
	}

	/**
	 * This listener listens to selections in the outline and will update the
	 * editor selection accordingly.
	 */
	private final class OutlineSelectionChangedListener extends AbstractSelectionChangedListener {

		public void selectionChanged(final SelectionChangedEvent event) {
			updateSelection(event);
		}

		public void updateSelection(final SelectionChangedEvent event) {
			final ISelection sel = event.getSelection();
			if (sel instanceof IStructuredSelection) {
				final IStructuredSelection structuredSelection = (IStructuredSelection) sel;
				final Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof EObject) {
					final EObject astNode = (EObject) firstElement;
					final NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(astNode);
					final CompositeNode parserNode = nodeAdapter.getParserNode();

					final AbstractNode selectionNode = findSelectionNode(parserNode);
					final int offset = selectionNode.getOffset();
					final int length = selectionNode.getLength();

					getSourceViewer().revealRange(offset, length);
					getSourceViewer().setSelectedRange(offset, length);
				}
			}
		}

		private AbstractNode findSelectionNode(final CompositeNode startNode) {
			final EList<AbstractNode> leafNodes = startNode.getChildren();
			AbstractNode keywordNode = null;
			AbstractNode idNode = null;
			for (final AbstractNode leafNode : leafNodes) {
				final EObject grammarElement = leafNode.getGrammarElement();
				if (grammarElement instanceof RuleCall) {
					final RuleCall ruleCall = (RuleCall) grammarElement;
					final String ruleName = ruleCall.getRule().getName();
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

			if (idNode != null)
				return idNode;
			else if (keywordNode != null)
				return keywordNode;
			else
				return startNode;
		}
	}

	private final class PreferenceStorePropertyChangeListener implements IPropertyChangeListener {
		public void propertyChange(final PropertyChangeEvent event) {
			// language dependent preferences starts with language
			// id so check if this event is for current language
			if (event != null
					&& event.getProperty() != null
					&& (event.getProperty().startsWith(getLanguageDescriptor().getId()) || event.getProperty()
							.startsWith("AbstractTextEditor"))) {
				// syntax highlighting
				if (event.getProperty().startsWith(PreferenceConstants.syntaxColorerTag(getLanguageDescriptor()))
						|| event.getProperty().startsWith("AbstractTextEditor")) {
					if (getSourceViewer() instanceof TextViewer) {
						// FIXME notify syntax colorer before viewer refreshing
						final ISyntaxColorer colorer = ServiceRegistry.getService(languageDescriptor,
								ISyntaxColorer.class);
						colorer.clearCache();
						final TextViewer tv = (TextViewer) getSourceViewer();
						tv.invalidateTextPresentation();
					}
				}
			}
		}
	}

	private static final Logger log = Logger.getLogger(BaseTextEditor.class);

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
	public void createPartControl(final Composite parent) {

		super.createPartControl(parent);
		// We need ProjectionViewer to support Folding
		final ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); //$NON-NLS-1$
		projectionSupport.install();
		// Folding stuff
		final IFoldingStructureProvider foldingProvider = ServiceRegistry.getService(languageDescriptor,
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
		if (projectionSupport != null) {
			projectionSupport.dispose();
		}
		if (foldingSupport != null) {
			foldingSupport.unbind();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(final Class adapter) {
		if (adapter.equals(IContentOutlinePage.class))
			return getOutlinePage();
		return super.getAdapter(adapter);
	}

	public IServiceScope getLanguageDescriptor() {
		return languageDescriptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.model.IEditorModelProvider#getModel()
	 * Can return null
	 */
	public IEditorModel getModel() {
		if (model == null) {
			final IDocumentProvider provider = getDocumentProvider();
			if (provider instanceof XtextDocumentProvider) {
				final XtextDocumentProvider documentProvider = (XtextDocumentProvider) provider;
				model = documentProvider.getModel(getEditorInput());
			}
		}
		return model;
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);
		// Preference store
		final ScopedPreferenceStore xtextPreferenceStore = PropertiesResolver.getPreferenceStore();
		final ChainedPreferenceStore chainedPreferenceStore = new ChainedPreferenceStore(
				new org.eclipse.jface.preference.IPreferenceStore[] { xtextPreferenceStore, getPreferenceStore() });
		chainedPreferenceStore.addPropertyChangeListener(new PreferenceStorePropertyChangeListener());

		// source viewer setup
		setSourceViewerConfiguration(new XtextSourceViewerConfiguration(this, chainedPreferenceStore));

		log.warn("Initializing Xtext basic text editor.");

		// Error marker
		final IResource resource = getResource();
		if (resource != null && isEditable() && getModel() != null) {
			final XtextProblemMarkerCreator markerCreator = new XtextProblemMarkerCreator(resource);
			markerCreator.setProgressMonitor(new NullProgressMonitor());
			getModel().addModelListener(markerCreator);
			getModel().addModelListener(
					new TaskTagsMarkerListener(site.getPluginId(), getResource(), new NullProgressMonitor()));
		}
	}

	@Override
	public void setInitializationData(final IConfigurationElement cfig, final String propertyName, final Object data) {
		super.setInitializationData(cfig, propertyName, data);
		// try plain text editor if problem occurs
		if (languageDescriptor != null) {
			// do document provider setup
			setDocumentProvider(XtextDocumentProviderFactory.getInstance().getDocumentProvider(languageDescriptor));
		}
		else {
			log.error(XtextUIMessages.getFormattedString("BaseTextEditor.NoLanguageDescriptor", //$NON-NLS-1$
					getConfigurationElement().getNamespaceIdentifier()), new IllegalStateException());
		}
	}

	public void synchronizeOutlinePage() {
		final int caretOffset = getSourceViewer().getTextWidget().getCaretOffset();
		final AbstractNode currentNode = ParseTreeUtil.getLastCompleteNodeByOffset(model.getParseTreeRootNode(),
				caretOffset);
		synchronizeOutlinePage(currentNode);
	}

	public void synchronizeOutlinePage(final AbstractNode node) {
		ISelection selection = StructuredSelection.EMPTY;

		if (shouldSynchronizeOutlinePage()) {
			outlineSelectionChangedListener.uninstall(outlinePage);
			if (node != null && node instanceof LeafNode) {
				final CompositeNode compositeNode = node.getParent();
				final EObject astElement = NodeUtil.getASTElementForRootNode(compositeNode);
				if (astElement != null) {
					selection = new StructuredSelection(astElement);
				}
			}
			outlinePage.setSelection(selection);
			outlineSelectionChangedListener.install(outlinePage);
		}
	}

	@Override
	protected String[] collectContextMenuPreferencePages() {
		final String[] ids = super.collectContextMenuPreferencePages();
		final String[] more = new String[ids.length + 4];
		// NOTE: preference page at index 0 will be opened, see
		// PreferencesUtil.createPreferenceDialogOn
		final String languageId = languageDescriptor.getId();
		more[0] = languageId + ".editor"; //$NON-NLS-1$
		more[1] = languageId;
		more[2] = languageId + ".editor.templates"; //$NON-NLS-1$
		more[3] = languageId + ".editor.syntaxcoloring"; //$NON-NLS-1$
		System.arraycopy(ids, 0, more, 4, ids.length);
		return more;
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
		final SelectMarkerRulerAction markerAction = new XtextMarkerRulerAction(XtextUIMessages.getResourceBundle(),
				"XtextSelectAnnotationRulerAction.", this, getVerticalRuler()); //$NON-NLS-1$
		setAction(ITextEditorActionConstants.RULER_CLICK, markerAction);
	}

	@Override
	protected ISourceViewer createSourceViewer(final Composite parent, final IVerticalRuler ruler, final int styles) {
		// overwrite superclass implementation to allow folding
		fAnnotationAccess = createAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());
		final ISourceViewer projectionViewer = new ProjectionViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);
		getSourceViewerDecorationSupport(projectionViewer);
		return projectionViewer;
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

	private IResource getResource() {
		final Object adapter = getEditorInput().getAdapter(IResource.class);
		if (adapter != null)
			return (IResource) adapter;
		return null;
	}

	private void setOutlinePageInput() {
		if (outlinePage != null) {
			outlinePage.setInput(getModel());
		}
	}

	private boolean shouldSynchronizeOutlinePage() {
		return Activator.getDefault().getPreferenceStore().getBoolean("ToggleLinkWithEditorAction.isChecked");
	}
}
