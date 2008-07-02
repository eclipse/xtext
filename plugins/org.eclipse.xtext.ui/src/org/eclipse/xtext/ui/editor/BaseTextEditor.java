/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProviderFactory;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.IPreferenceStore;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BaseTextEditor extends TextEditor implements IEditorModelProvider {
	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$
	private IEditorModel model;
	private XtextContentOutlinePage outlinePage;
	protected boolean selectionSetFromOutline;
	private ProjectionSupport projectionSupport;

	@Inject
	private ILanguageDescriptor languageDescriptor;

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
			CoreLog.logError(EditorMessages.getFormattedString("BaseTextEditor.NoLanguageDescriptor", //$NON-NLS-1$
					this.getConfigurationElement().getNamespaceIdentifier()), new IllegalStateException());
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		// Error marker
		IResource resource = getResource();
		if (resource != null && isEditable() && getModel() != null) {
			getModel().addModelListener(new XtextProblemMarkerCreator(resource));
		}
	}

	private IResource getResource() {
		Object adapter = getEditorInput().getAdapter(IResource.class);
		if (adapter != null)
			return (IResource) adapter;
		return null;
	}

	public ILanguageDescriptor getLanguageDescriptor() {
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

	/**
	 * Selection changed listener for the outline view.
	 */
	protected ISelectionChangedListener selectionChangedListener = new ISelectionChangedListener() {

		public void selectionChanged(SelectionChangedEvent event) {
			selectionSetFromOutline = false;
			doSelectionChanged(event);
			selectionSetFromOutline = true;
		}
	};
	private ProjectionAnnotationModel annotationModel;

	private void doSelectionChanged(SelectionChangedEvent selectionChangedEvent) {
		// IStructuredSelection selection = (IStructuredSelection)
		// selectionChangedEvent.getSelection();

		if (!isActivePart() && Activator.getActivePage() != null) {
			Activator.getActivePage().bringToTop(this);
		}

		// AntElementNode selectedXmlElement = (AntElementNode)selection.
		// getFirstElement();
		// if(selectedXmlElement != null) {
		// setSelection(selectedXmlElement, !isActivePart());
		// }
	}

	private boolean isActivePart() {
		IWorkbenchPart part = getActivePart();
		return part != null && part.equals(this);
	}

	private IWorkbenchPart getActivePart() {
		IWorkbenchWindow window = getSite().getWorkbenchWindow();
		IPartService service = window.getPartService();
		return service.getActivePart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IContentOutlinePage.class)) {
			return getOutlinePage();
		}
		return super.getAdapter(adapter);
	}

	private Object getOutlinePage() {
		if (outlinePage == null) {
			outlinePage = new XtextContentOutlinePage(this);
			outlinePage.addPostSelectionChangedListener(selectionChangedListener);
			setOutlinePageInput();
		}
		return outlinePage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#createActions()
	 */
	@Override
	protected void createActions() {
		super.createActions();
		Action action = new ContentAssistAction(EditorMessages.getResourceBundle(), "ContentAssistProposal.", this);//$NON-NLS-1$
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction("ContentAssistProposal", action);//$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$

		action = new TextOperationAction(EditorMessages.getResourceBundle(), "Format.", this, ISourceViewer.FORMAT); //$NON-NLS-1$
		action.setActionDefinitionId(Activator.PLUGIN_ID + ".FormatAction");
		setAction("Format", action); //$NON-NLS-1$
		markAsStateDependentAction("Format", true); //$NON-NLS-1$
		markAsSelectionDependentAction("Format", true); //$NON-NLS-1$

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createSourceViewer
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.jface.text.source.IVerticalRuler, int)
	 */
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// overwrite superclass implementation to allow folding
		ISourceViewer projectionViewer = new ProjectionViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);
		getSourceViewerDecorationSupport(projectionViewer);
		return projectionViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createPartControl
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$

		projectionSupport.install();
		projectionViewer.doOperation(ProjectionViewer.TOGGLE);
		annotationModel = projectionViewer.getProjectionAnnotationModel();

	}
}
