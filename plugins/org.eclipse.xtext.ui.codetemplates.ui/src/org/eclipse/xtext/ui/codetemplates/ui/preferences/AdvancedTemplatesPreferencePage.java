package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplatePersistenceData;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.ISyntheticResourceProvider;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialModelEditor;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.SourceViewerHandle;
import org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage;

import com.google.inject.Inject;

public class AdvancedTemplatesPreferencePage extends XtextTemplatePreferencePage {

	@Inject
	private EditTemplateDialogFactory factory;
	
	@Inject
	private TemplatesLanguageConfiguration configuration;

	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject
	private ISyntheticResourceProvider resourceProvider;
	
	private PartialModelEditor partialEditor;
	
	@Inject
	public AdvancedTemplatesPreferencePage(IPreferenceStore preferenceStore,
			ContextTypeRegistry registry, TemplateStore templateStore) {
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
			TemplateContextType contextType = getContextTypeRegistry().getContextType(template.getContextTypeId());
			String prefix = 
				"templates for " + grammarAccess.getGrammar().getName() +
				"'" + name + "'" + " for " + getContextTypeForGrammar(contextType) + ">>";
			String editablePart = template.getPattern();
			String suffix = "";
			partialEditor.updateModel(prefix, editablePart, suffix);
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
		SourceViewerHandle handle = configuration.getSourceViewerHandleFactory().create(parent, resourceProvider);
		partialEditor = handle.createPartialEditor();
		configuration.getHighlightingHelper().install(handle.getConfiguration(), handle.getViewer());
		return handle.getViewer();
	}
	
	@Override
	public void dispose() {
		configuration.getHighlightingHelper().uninstall();
		super.dispose();
	}

}
