/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentProviderFactory;
import org.eclipse.xtext.ui.core.editor.model.XtextEditorModel;
import org.eclipse.xtext.ui.core.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BaseTextEditor extends TextEditor {
	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$
	private XtextEditorModel model;
	private XtextContentOutlinePage outlinePage;
	protected boolean selectionSetFromOutline;

	@Override
	public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
		super.setInitializationData(cfig, propertyName, data);
		ILanguageDescriptor languageDescriptor = initializeLanguageDescriptor();
		// try plain text editor if problem occurs
		if (languageDescriptor != null) {
			IPreferenceStoreService xtextPreferenceStore = ServiceRegistry.getService(languageDescriptor,
					IPreferenceStoreService.class);
			ChainedPreferenceStore chainedPreferenceStore = new ChainedPreferenceStore(new IPreferenceStore[] {
					getPreferenceStore(), xtextPreferenceStore.getPersitablePreferenceStore() });

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

	private ILanguageDescriptor initializeLanguageDescriptor() {
		String namespace = this.getConfigurationElement().getNamespaceIdentifier();
		ILanguageDescriptor languageDescriptor = LanguageDescriptorFactory.get("org.eclipse.xtext.reference.ReferenceGrammar");
//		ILanguageDescriptor languageDescriptor = LanguageDescriptorFactory.getByNamespace(namespace);
		return languageDescriptor;
	}

	public XtextEditorModel getModel() {
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
			outlinePage.setPageInput(getModel());
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

	private void doSelectionChanged(SelectionChangedEvent selectionChangedEvent) {
		IStructuredSelection selection = (IStructuredSelection) selectionChangedEvent.getSelection();

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

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
//		if (adapter.equals(IContentOutlinePage.class)) {
//			return getOutlinePage();
//		}
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

	@Override
	protected void createActions() {
		super.createActions();
		Action action = new ContentAssistAction(EditorMessages.getResourceBundle(), "ContentAssistProposal.", this);//$NON-NLS-1$
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction("ContentAssistProposal", action);//$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$
	}
}
