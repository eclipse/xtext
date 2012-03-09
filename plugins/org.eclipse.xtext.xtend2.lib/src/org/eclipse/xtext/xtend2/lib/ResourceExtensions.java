/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.lib;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This is an extension library for {@link Resource EMF resources}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated
public class ResourceExtensions {

	/**
	 * Returns all the contents of the {@code resource} as an {@link Iterable}.
	 * 
	 * @param resource
	 *            the resource whose contents should be traversed. May not be <code>null</code>.
	 * @return an iterable that yields all the contents of the resource. Never <code>null</code>.
	 */
	/**
	 * @deprecated use {@link org.eclipse.xtext.xbase.lib.IteratorExtensions#toIterable(Iterator)}
	 */
	@Deprecated
	public static Iterable<EObject> allContentsIterable(final Resource resource) {
		if (resource == null)
			throw new NullPointerException("resource");
		return new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
	}
}
