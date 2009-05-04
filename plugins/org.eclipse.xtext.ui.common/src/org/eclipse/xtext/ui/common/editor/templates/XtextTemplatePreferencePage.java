package org.eclipse.xtext.ui.common.editor.templates;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class XtextTemplatePreferencePage extends TemplatePreferencePage {

//	private final static Logger log = Logger.getLogger(XtextTemplatePreferencePage.class);

	@Inject
	public XtextTemplatePreferencePage(@Named(Constants.LANGUAGE_NAME) String languageName, IPreferenceStore preferenceStore,
			ContextTypeRegistry registry, TemplateStore templateStore) {
		setPreferenceStore(preferenceStore);
		setContextTypeRegistry(registry);
		setTemplateStore(templateStore);
	}
}
