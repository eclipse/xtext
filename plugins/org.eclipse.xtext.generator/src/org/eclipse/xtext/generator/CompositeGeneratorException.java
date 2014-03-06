/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.6
 */
public class CompositeGeneratorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<Exception> exceptions = Lists.newArrayList();

	void addException(Exception e) {
		exceptions.add(e);
	}

	public Iterable<Exception> getExceptions() {
		return Iterables.unmodifiableIterable(exceptions);
	}

	public boolean hasExceptions() {
		return exceptions.size() != 0;
	}
}
