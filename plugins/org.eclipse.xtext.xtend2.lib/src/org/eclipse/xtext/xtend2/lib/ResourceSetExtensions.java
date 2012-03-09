/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.lib;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * This is an extension library for {@link ResourceSet EMF resource sets}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated
public class ResourceSetExtensions {

	/**
	 * Returns all the contents of the {@code resourceSet} as an {@link Iterable}.
	 * 
	 * @param resourceSet
	 *            the resourceSet whose contents should be traversed. May not be <code>null</code>.
	 * @return an iterable that yields all the contents of the resourceSet. Never <code>null</code>.
	 */
	/**
	 * @deprecated use {@link org.eclipse.xtext.xbase.lib.IteratorExtensions#toIterable(Iterator)}
	 */
	@Deprecated
	public static Iterable<Notifier> allContentsIterable(final ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new NullPointerException("resourceSet");
		return new Iterable<Notifier>() {
			public Iterator<Notifier> iterator() {
				return resourceSet.getAllContents();
			}
		};
	}
}
