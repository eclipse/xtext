/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.service;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.core.IImageHelper;
import org.eclipse.xtext.ui.core.PluginImageHelper;
import org.eclipse.xtext.ui.core.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.core.editor.formatting.PreferenceStoreIndentationInformation;
import org.eclipse.xtext.ui.core.editor.preferences.IPreferenceStoreInitializer;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Sebastian Zarnekow
 */
public class UIPluginModule extends AbstractGenericModule {

	private final AbstractUIPlugin plugin;

	public UIPluginModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}
	
	public void configureBracketMatchingAction(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("bracketMatcherAction")).to(org.eclipse.xtext.ui.core.editor.bracketmatching.GoToMatchingBracketAction.class);
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("bracketMatcherPrefernceInitializer")).to(org.eclipse.xtext.ui.core.editor.bracketmatching.BracketMatchingPreferencesInitializer.class);
	}

	public Class<? extends IImageHelper> bindIImageHelper() {
		return PluginImageHelper.class;
	}
	
	public Class<? extends IIndentationInformation> bindIIndentationInformation() {
		return PreferenceStoreIndentationInformation.class;
	}
	
	public IPreferenceStore bindIPreferenceStore() {
		return plugin.getPreferenceStore();
	}
	
}
