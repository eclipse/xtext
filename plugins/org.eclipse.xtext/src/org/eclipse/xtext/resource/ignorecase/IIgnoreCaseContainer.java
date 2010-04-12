/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IIgnoreCaseContainer extends IContainer {
	
	/**
	 * @return all matching {@link IEObjectDescription} in this container. Returns never <code>null</code>.
	 */
	Iterable<IEObjectDescription> findAllEObjectsIgnoreCase(EClass type, String name);

	/**
	 * a reusable instance representing an empty ignore case container
	 */
	IContainer Null = new IIgnoreCaseContainer() {

		public Iterable<IEObjectDescription> findAllEObjects(EClass type) {
			return Iterables.emptyIterable();
		}
		public Iterable<IEObjectDescription> findAllEObjects(EClass type, String name) {
			return Iterables.emptyIterable();
		}
		public IResourceDescription getResourceDescription(URI uri) {
			return null;
		}
		public Iterable<IResourceDescription> getResourceDescriptions() {
			return Iterables.emptyIterable();
		}
		public Iterable<IEObjectDescription> findAllEObjectsIgnoreCase(EClass type, String name) {
			return Iterables.emptyIterable();
		}
	};
}
