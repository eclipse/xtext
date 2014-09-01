/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * 
 * This class is eagerly created by the injector and serves just to initialize the default preferences.
 * TODO use {@link org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer} and its extension point instead
 * 
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JavaProjectPreferencesInitializer {

	private static Logger log = Logger.getLogger(JavaProjectPreferencesInitializer.class);

	@SuppressWarnings("restriction")
	@Inject
	public void addOwnFileExtensionsToJavaBuildResourceCopyFilter(FileExtensionProvider extensionProvider) {
		@SuppressWarnings("deprecation")
		IScopeContext defaultScope = new DefaultScope();

		// The class org.eclipse.jdt.internal.launching.LaunchingPreferenceInitializer has this very nasty habit 
		// of replacing all RESOURCE_COPY_FILTERs with its own filter. Calling getNode(LaunchingPlugin.ID_PLUGIN) 
		// causes LaunchingPreferenceInitializer to be executed that afterwards we can append our filters safely.    
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=395366
		defaultScope.getNode(org.eclipse.jdt.internal.launching.LaunchingPlugin.ID_PLUGIN);

		IEclipsePreferences dnode = defaultScope.getNode(JavaCore.PLUGIN_ID);
		if (dnode == null)
			return;
		Set<String> filters = Sets.newLinkedHashSet();
		for (String filter : dnode.get(JavaCore.CORE_JAVA_BUILD_RESOURCE_COPY_FILTER, "").split(",")) {
			String trimmed = filter.trim();
			if (!"".equals(trimmed))
				filters.add(trimmed);
		}
		for (String ext : extensionProvider.getFileExtensions())
			filters.add("*." + ext);
		dnode.put(JavaCore.CORE_JAVA_BUILD_RESOURCE_COPY_FILTER, Joiner.on(", ").join(filters));
		try {
			dnode.flush();
		} catch (BackingStoreException e) {
			log.error("Error saving preferences", e);
		}
	}

}
