/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.xbase.lib.Pure;

public class MockServiceContext implements IServiceContext {
	private Map<String, String> parameters;

	@Accessors
	private ISession session;

	@Override
	public Set<String> getParameterKeys() {
		return Collections.unmodifiableSet(parameters.keySet());
	}

	@Override
	public String getParameter(String key) {
		return parameters.get(key);
	}

	public MockServiceContext(Map<String, String> parameters, ISession session) {
		this.parameters = parameters;
		this.session = session;
	}

	@Pure
	public ISession getSession() {
		return session;
	}
}
