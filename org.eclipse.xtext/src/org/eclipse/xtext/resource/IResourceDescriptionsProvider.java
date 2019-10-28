/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @since 2.9
 */
@ImplementedBy(ResourceDescriptionsProvider.class)
public interface IResourceDescriptionsProvider {
	/**
	 * Provides the resource descriptions for the given resource set.
	 *
	 * @param resourceSet
	 *            the resource set that is currently used.
	 * @return the {@link IResourceDescriptions} according to the usage context.
	 *
	 * @since 2.9
	 */
	IResourceDescriptions getResourceDescriptions(ResourceSet resourceSet);
}
