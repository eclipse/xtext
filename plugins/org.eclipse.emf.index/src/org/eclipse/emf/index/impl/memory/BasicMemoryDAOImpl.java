/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import static org.eclipse.emf.index.util.CollectionUtils.isNotEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.index.IDAO;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.impl.IndexChangeEventImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class BasicMemoryDAOImpl<T> implements IDAO<T> {

	protected Set<T> store;

	protected IIndexStore indexStore;

	protected BasicMemoryDAOImpl(IIndexStore indexStore) {
		this.indexStore = indexStore;
		this.store = new HashSet<T>();
	}

	public void store(T element) {
		store.add(element);
		indexStore.fireIndexChangedEvent(new IndexChangeEventImpl(element, IndexChangeEvent.Type.ADDED));
	}

	public void delete(T element) {
		store.remove(element);
		indexStore.fireIndexChangedEvent(new IndexChangeEventImpl(element, IndexChangeEvent.Type.REMOVED));
	}

	public void modify(T element, T newValues) {
		if (doModify(element, newValues))
			indexStore.fireIndexChangedEvent(new IndexChangeEventImpl(element, IndexChangeEvent.Type.MODIFIED));
	}

	protected abstract boolean doModify(T element, T newValues);

	protected abstract class Query implements IGenericQuery<T> {

		private static final char ASTERISK = '*';

		protected boolean matchesGlobbing(String testString, String pattern) {
			if (pattern == null)
				return true;
			if (testString == null || "".equals(pattern))
				return false;
			int patternLength = pattern.length();
			if (pattern.charAt(0) == ASTERISK) {
				if (patternLength > 1 && pattern.charAt(patternLength - 1) == ASTERISK) {
					return testString.contains(pattern.substring(1, patternLength - 2));
				}
				return testString.endsWith(pattern.substring(1));
			}
			if (pattern.charAt(patternLength - 1) == ASTERISK) {
				return testString.startsWith(pattern.substring(0, patternLength - 1));
			}
			return testString.equals(pattern);
		}

		protected abstract boolean matches(T object);

		/**
		 * @return an empty list if the scope is specified but empty null it the
		 *         scope is unspecified
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
				for (T candidate : queryScope) {
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

		protected Collection<T> mergeScopes(Collection<T> scope0, Collection<T> scope1) {
			if (scope0 == null) {
				return scope1;
			}
			if (scope1 == null) {
				return scope0;
			}
			if (isNotEmpty(scope0)) {
				if (isNotEmpty(scope1)) {
					List<T> mergedScope = new ArrayList<T>(scope0);
					mergedScope.retainAll(scope1);
					return mergedScope;
				}
				return scope0;
			}
			return scope1;
		}
	}
}
