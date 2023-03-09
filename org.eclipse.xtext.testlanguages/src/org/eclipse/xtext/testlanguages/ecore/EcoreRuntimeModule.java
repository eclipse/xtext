/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.ecore;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Default Guice bindings for managing Ecore resources in the context of Xtext.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EcoreRuntimeModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "org.eclipse.emf.ecore.presentation.EcoreEditorID";
	}

	@Override
	protected String getFileExtensions() {
		return "ecore";
	}

	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return EcoreResourceDescriptionStrategy.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return EcoreQualifiedNameProvider.class;
	}

	public void configureIResourceDescriptions(Binder binder) {
		binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
	}

	public void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE))
				.to(LiveShadowedResourceDescriptions.class);
	}

}
