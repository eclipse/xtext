/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextTemplatePreferencePage extends TemplatePreferencePage {

	@Inject
	public XtextTemplatePreferencePage(IPreferenceStore preferenceStore, ContextTypeRegistry registry, TemplateStore templateStore) {
		setPreferenceStore(preferenceStore);
		setContextTypeRegistry(registry);
		setTemplateStore(templateStore);
	}

	@Override
	protected boolean isShowFormatterSetting() {
		return false;
	}
}
