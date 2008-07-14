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
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractRootPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,
		IWorkbenchPropertyPage {
	public static ILanguageDescriptor language = null;
	private IWorkbench workbench;
	private IAdaptable element;

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
		return language.getId();
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return ServiceRegistry.getService(language, org.eclipse.xtext.ui.service.IPreferenceStore.class)
				.getPersitablePreferenceStore();
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
}
