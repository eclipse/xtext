/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.EclipseSourceFolderProvider;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.JDTAwareSourceFolderProvider;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.resource.IContainer;

/**
 * Use this class to register components to be used within the IDE.
 */
public class BuilderTestLanguageUiModule extends org.eclipse.xtext.builder.tests.ui.AbstractBuilderTestLanguageUiModule {
	public BuilderTestLanguageUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IContainer.Manager> bindIContainer$Manager() {
		return org.eclipse.xtext.resource.containers.StateBasedContainerManager.class;
	}
	
	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return DelegatingBuilderParticipant.class;
	}

	@Override
	public void configureBuilderPreferenceStoreInitializer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class).to(org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.Initializer.class);
	}
	
	public Class<? extends EclipseSourceFolderProvider> bindEclipseSourceFolderProvider() {
		return JDTAwareSourceFolderProvider.class;
	}
	
	@Override
	public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
        return EclipseOutputConfigurationProvider.class;	
    }	
    	
    public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {	
        return EclipseResourceFileSystemAccess2.class;	
    }
}
