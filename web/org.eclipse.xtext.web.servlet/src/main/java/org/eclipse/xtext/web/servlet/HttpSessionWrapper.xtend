/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import javax.servlet.http.HttpSession
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.web.server.ISession

/**
 * Provides access to the information stored in a {@link HttpSession}.
 */
@FinalFieldsConstructor
@Accessors
class HttpSessionWrapper implements ISession {
	
	val HttpSession session
	
	override <T> get(Object key) {
		session.getAttribute(key.toString) as T
	}
	
	override <T> get(Object key, ()=>T factory) {
		synchronized (session) {
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
		session.setAttribute(key.toString, value)
	}
	
	override remove(Object key) {
		session.removeAttribute(key.toString)
	}
	
}