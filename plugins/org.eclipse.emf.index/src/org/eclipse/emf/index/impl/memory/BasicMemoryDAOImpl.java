/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class BasicMemoryDAOImpl<T> {

    protected Set<T> store;
    
    protected IIndexStore indexStore;
	
	protected BasicMemoryDAOImpl(IIndexStore indexStore) {
		this.indexStore = indexStore; 
		this.store = new HashSet<T>();
	}
	
	public void store(T element) {
		store.add(element);
	}
	
	public void delete(T element) {
		store.remove(element);
	}
	
	protected abstract class Query implements IGenericQuery<T> {

		protected abstract boolean matches(T object);

		/**
		 * @return an empty list if the scope is specified but empty
		 *   null it the scope is unspecified
		 */
		protected Collection<T> scope() {
			return store;
		}

		public T executeSingleResult() {
			Collection<T> queryScope = scope();
			if (queryScope != null)
				for (T candidate : queryScope) {
					if (matches(candidate)) {
						return candidate;
					}
				}
			return null;
		}

		public List<T> executeListResult() {
			List<T> result = null;
			Collection<T> queryScope = scope();
			if (queryScope != null) {
				for (T candidate : scope()) {
					if (matches(candidate)) {
						if (result == null) {
							result = new ArrayList<T>();
						}
						result.add(candidate);
					}
				}
			}
			return result;
		}

	}
}
