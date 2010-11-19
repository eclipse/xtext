/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * An ISelector is used to select IEObjectDescriptions from an {@link IScope}.
 * As scopes are usually nested, the ISelector is passed from scope to scope,
 * thus being applied before the shadowing semantic of the nested scopes apply.
 * 
 * Some common selections, like find by name, need to be implemented in an optimized way.
 * Therefore some scopes and also the index, don'T just apply the selector,
 * but cast for special types in order to do an optimized preselect (see {@link org.eclipse.xtext.scoping.impl.MultimapBasedScope}
 * for example. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ISelector {
	
	/**
	 * is called by each scope in the scope hierarchy to perform scope local selection/filtering of elements.
	 */
	public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements);
	
	/**
	 * no-op selector
	 */
	public final static ISelector SELECT_ALL = new ISelector(){
		public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
			return elements;
		}};
	
		
	
	/**
	 * Scopes might check for this type in order to perform optimized filtering.
	 * Note that the contract for indexes based on the name is, that they are indexed
	 * using the lower case version of names, in order to support both case sensitive as well as case insensitive languages.
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	class SelectByName extends DelegatingSelector implements Predicate<IEObjectDescription> {

		private QualifiedName qualifiedName;
		private boolean ignoreCase = false;

		@Override
		public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
			return super.applySelector(filter(elements, this));
		}
		
		public SelectByName(QualifiedName qualifiedName) {
			this(qualifiedName,false);
		}
		
		public SelectByName(QualifiedName qualifiedName, boolean ignoreCase) {
			this.qualifiedName = qualifiedName;
			this.ignoreCase  = ignoreCase;
		}
		
		public QualifiedName getName() {
			return qualifiedName;
		}

		public boolean apply(IEObjectDescription input) {
			if (ignoreCase) {
				return qualifiedName.equalsIgnoreCase(input.getName()); 
			} else {
				return qualifiedName.equals(input.getName());
			}
		}
		
		@Override
		public String toString() {
			return "by name '"+qualifiedName+"'"+(ignoreCase?" ignorecase ":"")+getDelegateSelectors();
		}
	}
	
	/**
	 * Scopes might check for this type in order to perform optimized filtering.
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	class SelectByEObject extends DelegatingSelector implements Predicate<IEObjectDescription> {
		
		private EObject eObject;
		private URI uri;
		
		public SelectByEObject(EObject eObject) {
			this.eObject = eObject;
			this.uri = EcoreUtil.getURI(eObject);
		}
		
		@Override
		public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
			return super.applySelector(filter(elements, this));
		}
		
		public boolean apply(IEObjectDescription input) {
			return uri.equals(input.getEObjectURI());
		}
		
		public EObject getEObject() {
			return eObject;
		}
		
		public URI getUri() {
			return uri;
		}
	}
	
	class DelegatingSelector implements ISelector {
		
		private List<ISelector> delegates = newArrayList();
		
		public List<ISelector> getDelegateSelectors() {
			return delegates;
		}

		public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
			for (ISelector selector : delegates) {
				elements = selector.applySelector(elements);
			}
			return elements;
		}

		public void addDelegate(ISelector selector) {
			this.delegates.add(selector);
		}
	}
}
