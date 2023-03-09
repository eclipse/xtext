/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * An {@link ISelectable} is something that can be queried for exported object.
 * Thereby it serves as a common abstract super concept for {@link IContainer} and 
 * {@link IResourceDescription}.
 * Furthermore there is an implementation of the {@link org.eclipse.xtext.scoping.IScope IScope} 
 * interface that is based on {@link ISelectable} and vice versa.
 * All implementations of {@link ISelectable} can deal with ignore case and case sensitive queries.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ISelectable {

	/**
	 * Clients may want to check the selectable to skip its processing in case it is empty.
	 * Implementations should be fast and not require expensive precalculation. Selectable may
	 * return <code>false</code> if it is too expensive to compute the actual result.  
	 * @return <code>true</code> if the selectable does not provide any descriptions.
	 */
	boolean isEmpty();
	
	/**
	 * @return all exported elements. May not be <code>null</code>.
	 */
	Iterable<IEObjectDescription> getExportedObjects();
	
	/**
	 * @return all elements which match the given qualified name and type. May not be <code>null</code>.
	 */
	Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase);
	
	/**
	 * @return all elements which match the given type. May not be <code>null</code>.
	 */
	Iterable<IEObjectDescription> getExportedObjectsByType(EClass type);
	
	/**
	 * @return all elements which match the given instance. May not be <code>null</code>.
	 */
	Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object);
	
}
