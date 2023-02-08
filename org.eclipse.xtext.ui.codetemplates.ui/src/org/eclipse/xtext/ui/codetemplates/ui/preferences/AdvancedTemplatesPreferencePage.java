/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.text.templates.TemplatePersistenceData;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AdvancedTemplatesPreferencePage extends XtextTemplatePreferencePage {

	@Inject
	private EditTemplateDialogFactory factory;
	
	@Inject
	private TemplatesLanguageConfiguration configuration;

	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject
	private TemplateResourceProvider resourceProvider;
	
	private EmbeddedEditorModelAccess partialEditor;
	
	@Inject
	public AdvancedTemplatesPreferencePage(IPreferenceStore preferenceStore,
			org.eclipse.jface.text.templates.ContextTypeRegistry registry, TemplateStore templateStore) {
		super(preferenceStore, registry, templateStore);
	}
	
	@Override
	protected Template editTemplate(Template template, boolean edit, boolean isNameModifiable) {
		IEditTemplateDialog dialog = factory.createDialog(template, edit, isNameModifiable, getShell());
		if (dialog.open() == Window.OK) {
			return dialog.getTemplate();
		}
		return null;
	}
	
	@Override
	protected void updateViewerInput() {
		IStructuredSelection selection= (IStructuredSelection) getTableViewer().getSelection();
		if (selection.size() == 1) {
			TemplatePersistenceData data= (TemplatePersistenceData) selection.getFirstElement();
			Template template= data.getTemplate();
			String name = template.getName();
			TemplateContextType contextType = ((ContextTypeRegistry)getContextTypeRegistry()).getContextType(template.getContextTypeId());
			if (contextType != null) {
				String prefix = 
						"templates for " + grammarAccess.getGrammar().getName() +
						"'" + name + "'" + " for " + getContextTypeForGrammar(contextType) + ">>";
				String editablePart = template.getPattern();
				String suffix = "";
				partialEditor.updateModel(prefix, editablePart, suffix);
			} else {
				partialEditor.updateModel("", template.getPattern(), "");
			}
		} else {
			partialEditor.updateModel("", "", "");
		}
	}

	protected String getContextTypeForGrammar(TemplateContextType contextType) {
		String result = contextType.getName();
		if (result.startsWith("Keyword "))
			result = result.substring("Keyword ".length());
		return result;
	}
	
	@Override
	protected SourceViewer createViewer(Composite parent) {
		EmbeddedEditor handle = configuration.getEmbeddedEditorFactory().newEditor(resourceProvider).readOnly().withParent(parent);
		partialEditor = handle.createPartialEditor(true);
		return handle.getViewer();
	}
}
