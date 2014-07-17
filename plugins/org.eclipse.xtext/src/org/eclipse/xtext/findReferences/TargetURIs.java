/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;

/**
 * Encapsulate the searched data. Clients may choose to attach more information to the 
 * target URIs by means of {@link #putUserData(Key, Object)}. This information can be obtain
 * in later processing steps to optimize the reference lookup.
 * 
 * If different clients (e.g. different languages) try to share user data, they have to agree on
 * a given {@link Key key}.  
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
@ImplementedBy(TargetURISet.class)
public interface TargetURIs extends Iterable<URI> {

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
	
	<T> T getUserData(Key<T> key);
	
	<T> void putUserData(Key<T> key, T data);
	
	void addURI(URI uri);
	
	void addAllURIs(Iterable<URI> uris);
	
	Collection<URI> getTargetResourceURIs();
	
	Collection<URI> getEObjectURIs(URI resourceURI);
	
	boolean contains(URI uri);
	
	boolean containsResource(URI resourceURI);
	
	boolean isEmpty();
	
	int size();
	
}
