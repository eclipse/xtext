/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.ProfilePreferencePage;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileConfigurationBlock;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class FormatterPreferencePage extends ProfilePreferencePage {
	private static final String PREF_PAGE_ID = "org.eclipse.xtend.core.Xtend.formatter";
	private static final String PROP_PAGE_ID = PREF_PAGE_ID + ".propertyPage";

	@Inject
	private FormatterConfigurationBlock.Factory factory;

	@Override
	protected ProfileConfigurationBlock createConfigurationBlock(PreferencesAccess access) {
		return factory.create(getProject(), access, "id");
	}

	@Override
	protected String getPreferencePageID() {
		return PREF_PAGE_ID;
	}

	@Override
	protected String getPropertyPageID() {
		return PROP_PAGE_ID;
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
	}

}
