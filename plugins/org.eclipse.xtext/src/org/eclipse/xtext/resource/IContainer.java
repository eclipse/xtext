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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IContainer {
	
	/**
	 * @return the {@link IResourceDescription} contained in this container. The result is never
	 * <code>null</code>.
	 */
	Iterable<IResourceDescription> getResourceDescriptions();

	/**
	 * @return the {@link IResourceDescription} for the given URI, or null is this container does 
	 * not contain such an {@link IResourceDescription}.
	 */
	IResourceDescription getResourceDescription(URI uri);

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	interface Manager {

		/**
		 * @return returns the container for a given {@link IResourceDescription}. The result is never
		 * <code>null</code>.
		 */
		IContainer getContainer(IResourceDescription desc);

		/**
		 * @return a sorted list of all {@link IContainer}, which are visible from the given {@link IResourceDescription}.
		 * In an Java environment this would correspond to the list of classpath entries. The list includes the 
		 * container that contains the given resource description. This implies that it is never empty.
		 */
		List<IContainer> getVisibleContainers(IResourceDescription desc);

	}
}
