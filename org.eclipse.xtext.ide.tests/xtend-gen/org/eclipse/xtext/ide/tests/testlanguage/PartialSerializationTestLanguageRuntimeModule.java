/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.tests.testlanguage.AbstractPartialSerializationTestLanguageRuntimeModule;
import org.eclipse.xtext.ide.tests.testlanguage.ide.serializer.PartialSerializationTestLanguageReferenceUpdater;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class PartialSerializationTestLanguageRuntimeModule extends AbstractPartialSerializationTestLanguageRuntimeModule {
  @Override
  public void configureIResourceDescriptionsLiveScope(final Binder binder) {
    binder.<IResourceDescriptions>bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(
      LiveShadowedResourceDescriptions.class);
  }
  
  public Class<? extends IReferenceUpdater> bindCleanupStrategy() {
    return PartialSerializationTestLanguageReferenceUpdater.class;
  }
}
