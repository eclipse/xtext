/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Stable;
import org.eclipse.xtext.crossref.impl.AbstractScope;

/**
 * 
 * A scope represents a hierarchical container containing
 * {@link IScopedElement}s.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Stable(since="0.7.0", subClass=AbstractScope.class)
public interface IScope {
	
    /**
     * The <code>NULLSCOPE</code> to be returned by the most outer scope
     */
    public final static IScope NULLSCOPE = new AbstractScope(){
    	
    	@Override
    	public Iterable<IScopedElement> getAllContents() {
    		return Collections.emptyList();
    	}

		public Iterable<IScopedElement> getContents() {
			return Collections.emptyList();
		}

		public IScope getOuterScope() {
			return NULLSCOPE;
		}
		
		@Override
		public IScopedElement getScopedElement(EObject element) {
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
    Iterable<IScopedElement> getContents();
    
    /**
     * 
     * @return an {@link Iterable} of {@link IScopedElement}s contained in this scope and it's outer scope (see {@link IScope#getOuterScope()}), 
     * where the elements from an outer scope follows the one from it's inner scope
     */
    Iterable<IScopedElement> getAllContents();
    
    /**
     * returns the {@link IScopedElement} for a given {@link EObject} in the most inner {@link IScope}
     * That is, if this scope does not contain a corresponding {@link IScopedElement} the outer scope is asked.
     * 
     * @param element
     * @return the corresponding {@link IScopedElement} or <code>null</code> if neither this scope nor it's parents contain an {@link IScopedElement} corresponding to the passed {@link EObject}
     */
    IScopedElement getScopedElement(EObject element);
    
}
