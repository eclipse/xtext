/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EclipsePreferencesProvider implements IPreferenceValuesProvider {
	
	private final static Logger log = Logger.getLogger(EclipsePreferencesProvider.class);
	@Inject IPreferenceStoreAccess access;
	
	public IPreferenceValues getPreferenceValues(Resource context) {
		final IProject project = getProject(context);
		final IPreferenceStore store = project != null ?
			access.getContextPreferenceStore(project) :
			access.getPreferenceStore();
		
		@SuppressWarnings("deprecation")
		final Map<String, String> computingMap = new MapMaker().makeComputingMap(
				new Function<String, String>() {
					public String apply(String input) {
						return store.getString(input);
					}
				});
		
		return new IPreferenceValues() {
			public String getPreference(PreferenceKey key) {
				try {
					final String string = computingMap.get(key.getId());
					return org.eclipse.jface.preference.IPreferenceStore.STRING_DEFAULT_DEFAULT.equals(string) ? key.getDefaultValue() : string;
				} catch (Exception e) {
					log.error("Error getting preference for key '"+key.getId()+"'.", e);
					return key.getDefaultValue();
				}
			}
		};
	}

	private IProject getProject(Resource resource) {
		URI uri = resource.getURI();
		if (uri.isPlatformResource()) {
			final IProject project = getWorkspaceRoot().getProject(uri.segment(1));
			if (project.isAccessible())
				return project;
		}
		return null;
	}

	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

}
