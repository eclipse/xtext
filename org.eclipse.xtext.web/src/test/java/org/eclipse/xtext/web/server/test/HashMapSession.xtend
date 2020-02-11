/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import java.util.HashMap
import org.eclipse.xtext.web.server.ISession

class HashMapSession implements ISession {
	
	val map = new HashMap<Object, Object>
		
	override <T> get(Object key) {
		map.get(key) as T
	}
	
	override <T> get(Object key, ()=>T factory) {
		synchronized (map) {
			val sessionValue = get(key)
			if (sessionValue !== null) {
				return sessionValue
			} else {
				val factoryValue = factory.apply
				put(key, factoryValue)
				return factoryValue
			}
		}
	}
	
	override put(Object key, Object value) {
		map.put(key, value)
	}
	
	override remove(Object key) {
		map.remove(key)
	}
	
}
