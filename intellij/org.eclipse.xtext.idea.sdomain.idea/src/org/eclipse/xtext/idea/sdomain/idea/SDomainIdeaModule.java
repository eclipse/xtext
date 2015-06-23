/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea;

import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.idea.build.IdeaOutputConfigurationProvider;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacetConfiguration;
import org.eclipse.xtext.idea.sdomain.idea.facet.SDomainFacetType;

public class SDomainIdeaModule extends AbstractSDomainIdeaModule {
	public Class<? extends AbstractFacetConfiguration> bindAbstractFacetConfiguration() {
		return SDomainFacetConfiguration.class;
	}

	public Class<? extends AbstractFacetType<AbstractFacetConfiguration>> bindAbstractFacetType() {
		return SDomainFacetType.class;
	}

	public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return IdeaOutputConfigurationProvider.class;
	}
}
