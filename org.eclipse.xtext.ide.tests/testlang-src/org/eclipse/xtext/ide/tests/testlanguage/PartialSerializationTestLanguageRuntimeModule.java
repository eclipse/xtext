/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.tests.testlanguage.ide.serializer.PartialSerializationTestLanguageReferenceUpdater;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ide.tests.testlanguage.scoping.PartialSerializationTestLanguageValueConverter;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class PartialSerializationTestLanguageRuntimeModule extends AbstractPartialSerializationTestLanguageRuntimeModule {

	@Override
	public void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(
			LiveShadowedResourceDescriptions.class);
	}
	
	public Class<? extends IReferenceUpdater> bindCleanupStrategy() {
		return PartialSerializationTestLanguageReferenceUpdater.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return PartialSerializationTestLanguageValueConverter.class;
	}
	
}
