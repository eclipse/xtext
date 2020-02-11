/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A composite exception is used to collect all problems that
 * were encountered during a generator execution. It may contain non fatal
 * {@link GeneratorWarning warnings}, too.
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.6
 */
@Deprecated
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
