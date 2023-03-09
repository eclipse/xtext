/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.service;

/**
 * @since 2.8
 */
public class OperationCanceledError extends Error {
	private static final long serialVersionUID = 3488104742236941451L;

	public OperationCanceledError(RuntimeException cause) {
		super(cause);
	}

	public RuntimeException getWrapped() {
		return (RuntimeException) getCause();
	}
}
