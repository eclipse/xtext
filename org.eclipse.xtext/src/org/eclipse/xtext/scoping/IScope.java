/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * <p>A scope defines which elements {@link IEObjectDescription} can be seen in a certain area within a model/program.</p>
 * <p>In other words: A scope is a kind of container structure that provides access to all objects that can be reached
 * from a given {@link org.eclipse.emf.ecore.EReference reference}. These objects may be invalid from a semantic point
 * of view, e.g. a scope may expose private fields of a class if there is no better candidate. This allows for
 * better error messages instead of broken cross references.</p>
 * 
 * <p>Scopes are used to resolve cross references during linking, content assist, serialization of models, etc.</p>
 * 
 * <p>Scopes are constructed and provided by an {@link IScopeProvider} for a given pair of a 
 * {@link org.eclipse.emf.ecore.EObject context object} and a {@link org.eclipse.emf.ecore.EReference cross reference}.</p>
 * 
 * <p>Clients can use several different query operations to select elements from a scope.
 * They are free to filter the result further to a set of valid or interesting elements depending on the actual use case.
 * A linker may want to create links to invalid objects to provide better error messages while content assist should filter these
 * instances.</p>
 * <ul>
 * <li>Query by {@link QualifiedName name}: Scopes can be queried by name. Implementations should answer this query fast.</li>
 * <li>Query by {@link EObject object}: Scopes can be queried by objects. Implementations should consider the 
 * {@link org.eclipse.emf.common.util.URI uri} of the object, too.</li>
 * <li>Wildcard query: All elements of the scope should be returned.</li>
 * </ul>
 * <p>Each concrete query can be used to obtain a single element (which is usually the first that matches the criteria) or all
 * elements from the scope that are suitable. The wildcard query can be used to obtain the complete content of a scope.</p>
 * 
 * <p>Scopes are usually nested (see {@link org.eclipse.xtext.scoping.impl.AbstractScope#getParent() AbstractScope#getParent} 
 * and {@link IEObjectDescription descriptions} from nested scopes can shadow descriptions
 * from parent scopes. Usually the {@link IEObjectDescription#getName() name} of a {@link IEObjectDescription description} 
 * is used as the shadowing criteria.</p>
 * 
 * <p>Clients should usually inherit from {@link org.eclipse.xtext.scoping.impl.AbstractScope AbstractScope} to implement
 * own scopes.</p> 
 * 
 * <p>Clients are free to extend the interface and introduce further query operations like prefix search or fuzzy
 * name matching.</p>
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface IScope {

	/**
	 * Find the first description that matches the given name.
	 * 
	 * @param name the name of the to-be-found element. May not be <code>null</code>.
	 * @return the first element that matches the {@link QualifiedName name}. May be <code>null</code>.
	 */
	IEObjectDescription getSingleElement(QualifiedName name);
	
	/**
	 * Find all descriptions that match the given name.
	 * 
	 * @param name the name of the to-be-found elements. May not be <code>null</code>.
	 * @return all elements that match the {@link QualifiedName name}. Never <code>null</code>.
	 */
	Iterable<IEObjectDescription> getElements(QualifiedName name);
	
	/**
	 * Find the first description that matches the given instance.
	 * 
	 * @param object the instance whose description should be obtained. May not be <code>null</code>.
	 * @return the first element that matches the {@link EObject instance}. May be <code>null</code>.
	 */
	IEObjectDescription getSingleElement(EObject object);
	
	/**
	 * Find all descriptions that match the given instance.
	 * 
	 * @param object the instance whose descriptions should be obtained. May not be <code>null</code>.
	 * @return all elements that match the {@link EObject instance}. Never <code>null</code>.
	 */
	Iterable<IEObjectDescription> getElements(EObject object);

	/**
	 * Obtain all elements from the scope. Implementors a free to throw an {@link UnsupportedOperationException}
	 * if the scope cannot be enumerated.
	 * 
	 * @return all elements of the scope. Never <code>null</code>.
	 * @throws UnsupportedOperationException if the scope cannot be enumerated.
	 */
	Iterable<IEObjectDescription> getAllElements();

	/**
	 * a NO-OP implementation.
	 */
	public final static IScope NULLSCOPE = new IScope() {

		@Override
		public IEObjectDescription getSingleElement(QualifiedName name) {
			return null;
		}

		@Override
		public Iterable<IEObjectDescription> getElements(QualifiedName name) {
			return Collections.emptyList();
		}

		@Override
		public IEObjectDescription getSingleElement(EObject object) {
			return null;
		}

		@Override
		public Iterable<IEObjectDescription> getElements(EObject object) {
			return Collections.emptyList();
		}

		@Override
		public Iterable<IEObjectDescription> getAllElements() {
			return Collections.emptyList();
		}
		
		@Override
		public String toString() {
			return "NULLSCOPE";
		}
	};

}
