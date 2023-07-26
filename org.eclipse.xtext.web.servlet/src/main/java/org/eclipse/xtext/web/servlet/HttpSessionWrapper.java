/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.servlet;

import jakarta.servlet.http.HttpSession;

import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * Provides access to the information stored in a {@link HttpSession}.
 */
public class HttpSessionWrapper implements ISession {
	private final HttpSession session;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Object key) {
		return (T) session.getAttribute(key.toString());
	}

	@Override
	public <T> T get(Object key, Function0<? extends T> factory) {
		synchronized (session) {
			T sessionValue = get(key);
			if (sessionValue != null) {
				return sessionValue;
			} else {
				T factoryValue = factory.apply();
				put(key, factoryValue);
				return factoryValue;
			}
		}
	}

	@Override
	public void put(Object key, Object value) {
		session.setAttribute(key.toString(), value);
	}

	@Override
	public void remove(Object key) {
		session.removeAttribute(key.toString());
	}

	public HttpSessionWrapper(HttpSession session) {
		this.session = session;
	}

	public HttpSession getSession() {
		return session;
	}
}
