/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.ArrayList;
import java.util.List;

class CompositeGeneratorException extends RuntimeException {
	private static final long serialVersionUID = 2875516656439737396L;
	private final List<Exception> exceptions = new ArrayList<>();

	public boolean addException(Exception exception) {
		return exceptions.add(exception);
	}

	public boolean hasExceptions() {
		return !exceptions.isEmpty();
	}

	public List<Exception> getExceptions() {
		return exceptions;
	}
}
