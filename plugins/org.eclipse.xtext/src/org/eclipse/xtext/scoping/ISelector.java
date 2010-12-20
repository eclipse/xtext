/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * A selector marks a query criteria for a {@link IScope scope}. Default criterias
 * are {@link SelectByName select by name} and {@link SelectByEObject select by object}.
 * Furthermore there exists a {@link #SELECT_ALL noop selector} which will return every scope element. 
 * These use cases are supported case sensitive and case insensitive by all implementations
 * of the {@link IScope scope} interface that are part of Xtext. Clients are free
 * to invent own query criterias for specific use cases.
 * As scopes are usually nested, the {@link ISelector} is passed from scope to scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface ISelector {
	
	/**
	 * Constant that can be used to indicate that all elements should be returned.
	 */
	public final static ISelector SELECT_ALL = new ISelector() {};
	
	/**
	 * Scopes might check for this type in order to perform optimized filtering.
	 */
	class SelectByName implements ISelector {

		private QualifiedName qualifiedName;

		public SelectByName(QualifiedName qualifiedName) {
			this.qualifiedName = qualifiedName;
		}
		
		public QualifiedName getName() {
			return qualifiedName;
		}
		
		@Override
		public String toString() {
			return "by name '"+qualifiedName+"'";
		}
	}
	
	/**
	 * Scopes might check for this type in order to perform optimized filtering.
	 */
	class SelectByEObject implements ISelector {
		
		private EObject eObject;
		private URI uri;
		
		public SelectByEObject(EObject eObject) {
			this.eObject = eObject;
			this.uri = EcoreUtil.getURI(eObject);
		}
		
		public EObject getEObject() {
			return eObject;
		}
		
		public URI getUri() {
			return uri;
		}
		
	}
}
