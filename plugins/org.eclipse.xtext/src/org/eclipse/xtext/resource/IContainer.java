/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IContainer {
	
	/**
	 * @return the {@link IResourceDescription} contained in this container. The result is never
	 * <code>null</code>. The result may be a cached view on the actual content of the underlying resources.
	 */
	Iterable<IResourceDescription> getResourceDescriptions();

	/**
	 * @return the {@link IResourceDescription} for the given URI, or null is this container does 
	 * not contain such an {@link IResourceDescription}. The result may be a cached view on the actual content of the underlying resource.
	 */
	IResourceDescription getResourceDescription(URI uri);
	
	/**
	 * @return all matching {@link IEObjectDescription} in this container. Returns never <code>null</code>.
	 */
	Iterable<IEObjectDescription> findAllEObjects(EClass type);

	/**
	 * @return all matching {@link IEObjectDescription} in this container. Returns never <code>null</code>.
	 */
	Iterable<IEObjectDescription> findAllEObjects(EClass type, String name);

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	@ImplementedBy(SimpleResourceDescriptionsBasedContainerManager.class)
	interface Manager {

		/**
		 * @return returns the container for a given {@link IResourceDescription}. The result is never
		 * <code>null</code>.
		 */
		IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions);

		/**
		 * @return a sorted list of all {@link IContainer}, which are visible from the given {@link IResourceDescription}.
		 * In an Java environment this would correspond to the list of classpath entries. The list includes the 
		 * container that contains the given resource description. This implies that it is never empty.
		 */
		List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions);

	}
	
}