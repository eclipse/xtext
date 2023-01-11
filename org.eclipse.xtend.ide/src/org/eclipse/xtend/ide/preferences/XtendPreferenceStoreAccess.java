/*******************************************************************************
 * Copyright (c) 2014, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.PreferenceConstants;
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
		FixedScopedPreferenceStore jdtStore = new FixedScopedPreferenceStore(InstanceScope.INSTANCE, JavaCore.PLUGIN_ID);
		jdtStore.setSearchContexts(new IScopeContext[] {
				InstanceScope.INSTANCE,
				ConfigurationScope.INSTANCE
		});
		return new ChainedPreferenceStore(new IPreferenceStore[] {
			store,
			jdtStore,
			PreferenceConstants.getPreferenceStore()
		});
	}
	
	@Override
	public IPreferenceStore getContextPreferenceStore(Object context) {
		IProject project = getProject(context);
		if (project == null) return getPreferenceStore();
		IPreferenceStore store = super.getContextPreferenceStore(context);
		ProjectScope projectScope = new ProjectScope(project);
		FixedScopedPreferenceStore jdtStore = new FixedScopedPreferenceStore(projectScope, JavaCore.PLUGIN_ID);
		jdtStore.setSearchContexts(new IScopeContext[] {
				projectScope,
				InstanceScope.INSTANCE,
				ConfigurationScope.INSTANCE
		});
		return new ChainedPreferenceStore(new IPreferenceStore[] {
			store,
			jdtStore,
			PreferenceConstants.getPreferenceStore()
		});
	}
}
