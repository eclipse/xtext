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
 */
public interface IScope {
	
    /**
     * The <code>NULLSCOPE</code> to be returned by the most outer scope
     */
    public final static IScope NULLSCOPE = new IScope() {
		
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

		public IEObjectDescription getContentByName(String name) {
			return null;
		}
    };
    
    /**
     * @return the outer scope, returns {@link IScope#NULLSCOPE} if this scope is the most outer scope.
     */
    IScope getOuterScope();

    /**
     * @return an {@link Iterable} of {@link IScopedElement}s contained in this scope only
     */
    Iterable<IEObjectDescription> getContents();
    
    /**
     * @return an {@link Iterable} of {@link IScopedElement}s contained in this scope and it's outer scope
     * (see {@link IScope#getOuterScope()}), where the elements from an outer scope follows the one from it's inner scope
     */
    Iterable<IEObjectDescription> getAllContents();
    
    /**
     * a deep search for the element with the given name
     */
    IEObjectDescription getContentByName(String name);
    
    /**
     * a deep search for the element with the given object
     */
    IEObjectDescription getContentByEObject(EObject object);
    
}
