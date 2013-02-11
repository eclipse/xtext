package org.eclipse.xtext.ui.editor.preferences;

/**
 * Copyright (c) 2012 Cloudsmith Inc. and other contributors, as listed below.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cloudsmith
 * 
 */

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.ui.editor.preferences.PreferenceStoreAccessImpl;

/**
 * This specialization of the PreferenceStoreAccessImpl makes use of a ProjectAwareScopedPreferenceStore to deal with
 * writing project scope preferences.
 * @since 2.4
 * 
 */
public class ProjectAwarePreferenceStoreAccess extends PreferenceStoreAccessImpl {
	@Override
	public IPreferenceStore getWritablePreferenceStore() {
		lazyInitialize();
		ProjectAwareScopedPreferenceStore result = new ProjectAwareScopedPreferenceStore(new InstanceScope(),
				getQualifier());
		result.setSearchContexts(new IScopeContext[] { new InstanceScope(), new ConfigurationScope() });
		return result;
	}

	@Override
	public IPreferenceStore getWritablePreferenceStore(Object context) {
		lazyInitialize();
		if (context instanceof IFileEditorInput) {
			context = ((IFileEditorInput) context).getFile().getProject();
		}
		if (context instanceof IProject) {
			ProjectScope projectScope = new ProjectScope((IProject) context);
			ProjectAwareScopedPreferenceStore result = new ProjectAwareScopedPreferenceStore(projectScope,
					getQualifier());
			result.setSearchContexts(new IScopeContext[] { projectScope, new InstanceScope(), new ConfigurationScope() });
			return result;
		}
		return getWritablePreferenceStore();
	}

}
