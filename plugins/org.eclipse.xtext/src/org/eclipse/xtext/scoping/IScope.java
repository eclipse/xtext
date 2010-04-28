/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * 
 * A scope represents a hierarchical container containing
 * {@link IScopedElement}s.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill - Contribution to Bug 309764
 */
public interface IScope {
	
    /**
     * The <code>NULLSCOPE</code> to be returned by the most outer scope
     */
    final IScope NULLSCOPE = new IScope() {
		
    	public Iterable<IEObjectDescription> getAllContents() {
    		return Collections.emptyList();
    	}

		public Iterable<IEObjectDescription> getContents() {
			return Collections.emptyList();
		}

		public IScope getOuterScope() {
			return NULLSCOPE;
		}

		public IEObjectDescription getContentByEObject(EObject object) {
			return null;
		}
		
		public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
			return Collections.emptyList();
		}

		public IEObjectDescription getContentByName(String name) {
			return null;
		}
    };
    
    /**
     * @return the outer scope, returns {@link IScope#NULLSCOPE} if this scope is the most outer scope.
     */
    IScope getOuterScope();

    /**
     * @return an {@link Iterable} of {@link IEObjectDescription}s directly contained in this scope.
     * @throws UnsupportedOperationException if the scope cannot be enumerated.
     */
    Iterable<IEObjectDescription> getContents();
    
    /**
     * @return an {@link Iterable} of {@link IEObjectDescription}s contained in this scope and it's outer scope
     * @throws UnsupportedOperationException if the scope or an outer scope cannot be enumerated.
     */
    Iterable<IEObjectDescription> getAllContents();
    
    /**
     * a deep search for the element with the given name
     */
    IEObjectDescription getContentByName(String name);
    
    /**
     * @return an {@link IEObjectDescription} that represents the first element from {@link IScope#getAllContentsByEObject(EObject)} or null
     */
    IEObjectDescription getContentByEObject(EObject object);
    
    /**
     * A deep search for the elements pointing to the given object.
     * @return an {@link Iterable} of {@link IEObjectDescription}s that matches the given object ordered by the occurrence in this scope and it's following outer scope 
     */
    Iterable<IEObjectDescription> getAllContentsByEObject(EObject object);
    
}
