/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.CompositeEValidator;
import org.xpect.services.NullResourceDescriptions;
import org.xpect.services.XpectFragmentProvider;
import org.xpect.services.XpectValueConverter;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectRuntimeModule extends AbstractXpectRuntimeModule {

	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return XpectFragmentProvider.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XpectValueConverter.class;
	}

	public void configureEObjectValidator(Binder binder) {
		binder.bind(Boolean.class).annotatedWith(Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(Boolean.FALSE);
	}

	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(IResourceDescriptions.class).to(NullResourceDescriptions.class);
	}

	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(IResourceDescriptions.class)
				.annotatedWith(com.google.inject.name.Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
				.to(NullResourceDescriptions.class);
	}

}
