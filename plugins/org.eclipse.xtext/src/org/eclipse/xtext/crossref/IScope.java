/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.Collections;

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
    	
    };
    
    IScope getParent();
    
    Iterable<IScopedElement> getContents();
    
    Iterable<IScopedElement> getAllContents();
    
}
