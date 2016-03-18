/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import com.google.inject.Inject
import javax.inject.Provider
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.findReferences.IReferenceFinder
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess
import org.eclipse.xtext.findReferences.TargetURICollector
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors(PUBLIC_SETTER, PROTECTED_GETTER)
abstract class AbstractHierarchyBuilder implements HierarchyBuilder {

	IResourceAccess resourceAccess

	IResourceDescriptions indexData

	@Inject
	IReferenceFinder referenceFinder

	@Inject
	TargetURICollector targetURICollector

	@Inject
	Provider<TargetURIs> targetURIProvider

	@Inject
	HierarchyNodeLocationProvider hierarchyNodeLocationProvider

	@Inject
	IResourceServiceProvider.Registry resourceServiceProviderRegistry

}
