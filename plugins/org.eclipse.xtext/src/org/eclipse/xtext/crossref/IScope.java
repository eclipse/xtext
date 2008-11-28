/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.Collections;

import org.eclipse.xtext.util.Pair;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <T>
 */
public interface IScope<T> {
	
    public final static IScope<?> NULLSCOPE = new IScope<Object>(){

		public Iterable<Pair<String,Object>> getAllContents() {
			return Collections.emptyList();
		}

		public Iterable<Pair<String,Object>> getContents() {
			return Collections.emptyList();
		}

		@SuppressWarnings("unchecked")
		public IScope<Object> getParent() {
			return (IScope<Object>) NULLSCOPE;
		}
    	
    };
    
	IScope<T> getParent();
    Iterable<Pair<String,T>> getContents();
    Iterable<Pair<String,T>> getAllContents();
}
