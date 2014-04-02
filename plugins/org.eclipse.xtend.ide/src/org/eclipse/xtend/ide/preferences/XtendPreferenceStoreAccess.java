/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.FixedScopedPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.PreferenceStoreAccessImpl;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class XtendPreferenceStoreAccess extends PreferenceStoreAccessImpl {

	@Override
	public IPreferenceStore getPreferenceStore() {
		IPreferenceStore store = super.getPreferenceStore();
		FixedScopedPreferenceStore jdtStore = new FixedScopedPreferenceStore(new InstanceScope(), JavaCore.PLUGIN_ID);
		jdtStore.setSearchContexts(new IScopeContext[] {
				new InstanceScope(),
				new ConfigurationScope()
		});
		return new ChainedPreferenceStore(new IPreferenceStore[] {
			store,
			jdtStore
		});
	}
	
	@Override
	public IPreferenceStore getContextPreferenceStore(Object context) {
		IProject project = getProject(context);
		if (project == null) return getPreferenceStore();
		IPreferenceStore store = super.getPreferenceStore();
		ProjectScope projectScope = new ProjectScope(project);
		FixedScopedPreferenceStore jdtStore = new FixedScopedPreferenceStore(projectScope, JavaCore.PLUGIN_ID);
		jdtStore.setSearchContexts(new IScopeContext[] {
				projectScope,
				new InstanceScope(),
				new ConfigurationScope()
		});
		return new ChainedPreferenceStore(new IPreferenceStore[] {
			store,
			jdtStore
		});
	}
}
