/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import java.io.IOException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,
		IWorkbenchPropertyPage {

	@Inject
	private IServiceScope languageDescriptor;

	private IWorkbench workbench;
	private IAdaptable element;

	private String languageName;

	public void init(IWorkbench workbench) {
		this.workbench = workbench;
	}

	protected IWorkbench getWorkbench() {
		return workbench;
	}

	public void setElement(IAdaptable element) {
		this.element = element;
	}

	public IAdaptable getElement() {
		return element;
	}

	public boolean isPropertyPage() {
		return element != null;
	}

	public String qualifiedName() {
		return languageDescriptor.getId();
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		org.eclipse.xtext.ui.service.IPreferenceStore service = ServiceRegistry.getService(getLanguageDescriptor(),
				org.eclipse.xtext.ui.service.IPreferenceStore.class);
		if (service != null)
			return service.getPersitablePreferenceStore();
		return new ScopedPreferenceStore(new InstanceScope(), "org.eclipse.xtext.ui");
	}

	@Override
	public boolean performOk() {
		boolean retVal = super.performOk();
		if (getPreferenceStore() instanceof IPersistentPreferenceStore)
			try {
				((IPersistentPreferenceStore) getPreferenceStore()).save();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		return retVal;
	}

	/**
	 * @return
	 */
	protected IServiceScope getLanguageDescriptor() {
		return languageDescriptor;
	}

	protected String getLanguageName() {
		if (this.languageName == null) {
			this.languageName = GrammarUtil.getName(ServiceRegistry.getService(getLanguageDescriptor(),
					IGrammarAccess.class).getGrammar());
		}
		return this.languageName;
	}

}
