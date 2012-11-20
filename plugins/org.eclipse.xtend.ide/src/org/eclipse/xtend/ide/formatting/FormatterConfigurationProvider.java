/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.IFormatterConfigurationProvider;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public final class FormatterConfigurationProvider implements IFormatterConfigurationProvider {

	@Inject
	private IStorage2UriMapper mapper;

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Inject
	private XtendFormatterConfigKeys keys;

	public IConfigurationValues getFormatterConfiguration(Resource resource) {
		IProject project = findProject(resource);
		IPreferenceStore store = preferenceStoreAccess.getContextPreferenceStore(project);
		return new PreferenceStoreBasedConfigurationValues(keys, store);
	}

	private IProject findProject(Resource resource) {
		if (resource.getURI().isPlatform()) {
			Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(resource.getURI());
			for (Pair<IStorage, IProject> pair : storages) {
				//TODO investigate if there is a possibility, that we can have more than one project
				if (pair.getSecond() != null) {
					return pair.getSecond();
				}
			}
		}
		return null;
	}

}