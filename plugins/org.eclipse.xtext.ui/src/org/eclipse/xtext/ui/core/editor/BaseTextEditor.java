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
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.xtext.ui.core.editor.infrastructure.XtextModelManager;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;
import org.eclipse.xtext.ui.core.language.LanguageDescriptorFactory;
import org.eclipse.xtext.ui.core.language.LanguageServiceFactory;
import org.eclipse.xtext.ui.core.preferences.XtextDefaultsInitializer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BaseTextEditor extends TextEditor {
	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$
	private IPreferenceStore xtextPreferenceStore;

	@Override
	public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
		super.setInitializationData(cfig, propertyName, data);
		LanguageDescriptor languageDescriptor = initializeLanguageDescriptor();
		// try plain text editor if problem occurs
		if (languageDescriptor != null) {
			xtextPreferenceStore = LanguageServiceFactory.getInstance().getPreferenceStore(languageDescriptor);
			XtextModelManager manager = new XtextModelManager(languageDescriptor);
			XtextDefaultsInitializer.initializeDefaults(xtextPreferenceStore);
			ChainedPreferenceStore chainedPreferenceStore = new ChainedPreferenceStore(new IPreferenceStore[] {
					getPreferenceStore(), xtextPreferenceStore });

			setSourceViewerConfiguration(new XtextSourceViewerConfiguration(manager, chainedPreferenceStore, this));
		}
		else {
			CoreLog.logError(EditorMessages.getFormattedString("BaseTextEditor.NoLanguageDescriptor", //$NON-NLS-1$
					this.getConfigurationElement().getNamespaceIdentifier()), new IllegalStateException());
		}
		setDocumentProvider(new TextFileDocumentProvider());
	}

	private LanguageDescriptor initializeLanguageDescriptor() {
		String namespace = this.getConfigurationElement().getNamespaceIdentifier();
		LanguageDescriptor langDescr = LanguageDescriptorFactory.createLanguageDescriptor(namespace);
		return langDescr;
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
