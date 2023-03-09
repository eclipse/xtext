/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @since 2.29
 */
@Singleton
public class XbaseResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager {
	
	@Inject
	protected IBatchTypeResolver typeResolver;
	@Inject 
	protected IQualifiedNameConverter nameConverter;

	@Override
	protected IResourceDescription createResourceDescription(Resource resource,
			IDefaultResourceDescriptionStrategy strategy) {
		return new XbaseResourceDescription(resource, strategy, getCache(), typeResolver, nameConverter);
	}
}
