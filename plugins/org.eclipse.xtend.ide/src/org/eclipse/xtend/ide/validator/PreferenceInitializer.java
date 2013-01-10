/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Fills the {@link DefaultScope} with default values from the corresponding {@link ConfigurableIssueCodesProvider}
 * @author Dennis Huebner - Initial contribution and API
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private @Inject ConfigurableIssueCodesProvider issueCodes;
	private @Inject @Named(org.eclipse.xtext.Constants.LANGUAGE_NAME) String languageName;

	@Override
	public void initializeDefaultPreferences() {
		IEclipsePreferences node = new DefaultScope().getNode(languageName);
		for (PreferenceKey prefKey : issueCodes.getConfigurableIssueCodes().values()) {
			node.put(prefKey.getId(), prefKey.getDefaultValue());
		}
	}
}
