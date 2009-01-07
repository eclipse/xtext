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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IScope {
	
    public final static IScope NULLSCOPE = new IScope(){

		public Iterable<IScopedElement> getAllContents() {
			return Collections.emptyList();
		}

		public Iterable<IScopedElement> getContents() {
			return Collections.emptyList();
		}

		public IScope getParent() {
			return (IScope) NULLSCOPE;
		}

		public IScopedElement getScopedElement(EObject element) {
			return null;
		}
    	
    };
    
    /**
     * @return the parent scope
     */
    IScope getParent();

    /**
     * @return an Iterable of IScopedElements contained in this scope only
     */
    Iterable<IScopedElement> getContents();
    
    /**
     * 
     * @return an Iterable of IScopedElements contained in this scope and it's parents
     */
    Iterable<IScopedElement> getAllContents();
    
    /**
     * returns the IScopedElement for a given EObject
     * if this scope does not contain an IScopedElement the parent scope is asked.
     * 
     * @param element
     * @return null if neither this scope or it's parents contain an IScopedElement corresponding to the passed EObject
     */
    IScopedElement getScopedElement(EObject element);
    
}
