/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

/**
 * Provides means to store information that can be accessed for subsequent requests.
 * This allows to improve the server performance by avoiding duplicate computations,
 * and to share resources across multiple service requests.
 */
interface ISession {

	/**
	 * Get the stored information for the given key. Returns {@code null} if nothing
	 * is associated with that key.
	 */	
	def <T> T get(Object key)
	
	/**
	 * Get the stored information for the given key, creating it if it is not present yet.
	 * The check for presence of the information and the invocation of the factory are
	 * done in an atomic block, thus the session store may be accessed from multiple threads.
	 */
	def <T> T get(Object key, ()=>T factory)
	
	/**
	 * Add the given information to this session store, overwriting any previously stored
	 * information for that key.
	 */
	def void put(Object key, Object value)
	
	/**
	 * Remove the information stored with the given key.
	 */
	def void remove(Object key)
	
	/**
	 * A default implementation that stores nothing.
	 */
	static class NullImpl implements ISession {
		override <T> get(Object key) {}
		override <T> get(Object key, ()=>T factory) {factory.apply()}
		override put(Object key, Object value) {}
		override remove(Object key) {}
	}
	
}