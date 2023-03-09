/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.ImplementedBy;

/**
 * Interface for providing output configurations with a given context. The context may,
 * for example, include specific settings of the IDE project in which a resource is contained.
 * 
 * @since 2.9
 */
@ImplementedBy(OutputConfigurationProvider.class)
public interface IContextualOutputConfigurationProvider2 {
	
	/**
	 * Return the output configurations that are applicable to the given resource.
	 */
	Set<OutputConfiguration> getOutputConfigurations(ResourceSet context);
	
}