/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class PreferenceStoreAccessImpl implements IPreferenceStoreAccess {

	public IPreferenceStore getPreferenceStore() {
		lazyInitialize();
		Activator activator = Activator.getDefault();
		if (activator != null)
			return new ChainedPreferenceStore(new IPreferenceStore[] {
					getWritablePreferenceStore(),
					activator.getPreferenceStore(), 
					EditorsUI.getPreferenceStore() });
		return new ChainedPreferenceStore(new IPreferenceStore[] {
				getWritablePreferenceStore(),
				EditorsUI.getPreferenceStore() });
	}

	public IPreferenceStore getContextPreferenceStore(Object context) {
		lazyInitialize();
		// may be null on shutdown
		Activator activator = Activator.getDefault();
		if (activator != null)
			return new ChainedPreferenceStore(new IPreferenceStore[] { 
					getWritablePreferenceStore(context),
					activator.getPreferenceStore(),
					EditorsUI.getPreferenceStore()});
		return new ChainedPreferenceStore(new IPreferenceStore[] { 
				getWritablePreferenceStore(context),
				EditorsUI.getPreferenceStore()});
	}

	@SuppressWarnings("deprecation")
	public IPreferenceStore getWritablePreferenceStore() {
		lazyInitialize();
		FixedScopedPreferenceStore result = new FixedScopedPreferenceStore(new InstanceScope(), getQualifier());
		result.setSearchContexts(new IScopeContext[] {
			new InstanceScope(),
			new ConfigurationScope()
		});
		return result;
	}

	@SuppressWarnings("deprecation")
	public IPreferenceStore getWritablePreferenceStore(Object context) {
		lazyInitialize();
		IProject project = getProject(context);
		if (project == null) {
			return getWritablePreferenceStore();
		}
		ProjectScope projectScope = new ProjectScope(project);
		FixedScopedPreferenceStore result = new FixedScopedPreferenceStore(projectScope, getQualifier());
		result.setSearchContexts(new IScopeContext[] {
			projectScope,
			new InstanceScope(),
			new ConfigurationScope()
		});
		return result;
	}
	
	/**
	 * @since 2.6
	 */
	/* @Nullable */
	protected IProject getProject(Object context) {
		if (context instanceof IFileEditorInput) {
			return ((IFileEditorInput) context).getFile().getProject();
		}
		if (context instanceof IProject) {
			return (IProject) context;
		}
		return null;
	}

	private String qualifier;

	@Inject
	public void setLanguageNameAsQualifier(@Named(Constants.LANGUAGE_NAME) String languageName) {
		this.qualifier = languageName;
	}

	protected String getQualifier() {
		return qualifier;
	}

	private boolean initialized = false;
	
	@Inject
	private IPreferenceStoreInitializer.CompositeImpl initializer;

	protected void lazyInitialize() {
		if (!initialized) {
			initialized = true;
			initializer.initialize(this);
		}
	}

}
