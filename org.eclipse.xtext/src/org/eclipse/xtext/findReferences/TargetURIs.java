/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Predicate;
import com.google.inject.ImplementedBy;

/**
 * Encapsulate the searched data. Clients may choose to attach more information to the 
 * target URIs by means of {@link #putUserData(Key, Object)}. This information can be obtained
 * in later processing steps to optimize the reference lookup.
 * 
 * If different clients (e.g. different languages) try to share user data, they have to agree on
 * a given {@link Key key}.  
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(TargetURISet.class)
public interface TargetURIs extends Iterable<URI>, Predicate<URI> {

	/**
	 * A user data key with equalitiy semantics on the type of the value and the
	 * logical name of the key.
	 */
	final class Key<T> {
		private final String key;
		private final Class<T> type;

		private Key(String key, Class<T> type) {
			this.key = key;
			this.type = type;
		}

		public static <T> Key<T> from(String key, Class<T> type) {
			return new Key<T>(key, type);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
		
		public String getKey() {
			return key;
		}
		
		Class<T> getType() {
			return type;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key<?> other = (Key<?>) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Key [key=");
			builder.append(key);
			builder.append(", type=");
			builder.append(type);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	/**
	 * Read the user data with the given key. Returns <code>null</code> is no such user data is available.
	 */
	<T> T getUserData(Key<T> key);
	
	/**
	 * Store user data with the given key.
	 */
	<T> void putUserData(Key<T> key, T data);
	
	/**
	 * Add the given uri to this set of targets.
	 */
	void addURI(URI uri);
	
	/**
	 * Adds all the uris to this set of targets.
	 */
	void addAllURIs(Iterable<URI> uris);
	
	/**
	 * Returns the collection of target resource URIs, e.g. URIs without a fragment.
	 */
	Collection<URI> getTargetResourceURIs();
	
	/**
	 * Return all targets that are defined in the given resource.
	 */
	Collection<URI> getEObjectURIs(URI resourceURI);
	
	/**
	 * Returns <code>true</code> if the uri is contained in this set of targets.
	 */
	boolean contains(URI uri);
	
	/**
	 * Returns <code>true</code> if this set of targets contains at least one element from the
	 * given resourceURI.
	 */
	boolean containsResource(URI resourceURI);
	
	/**
	 * Returns <code>true</code> if there is no target URI yet.
	 */
	boolean isEmpty();
	
	/**
	 * Returns the number of known target object URIs.
	 */
	int size();
	
	/**
	 * Returns a {@link Set} view on this resource URIs.
	 */
	Set<URI> asSet();
	
}
