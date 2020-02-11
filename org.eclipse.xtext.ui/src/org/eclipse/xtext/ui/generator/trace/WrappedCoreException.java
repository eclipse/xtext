/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WrappedCoreException extends IOException {

	private static final long serialVersionUID = 1L;

	public WrappedCoreException(CoreException e) {
		super(e);
	}
	
	@Override
	public synchronized CoreException getCause() {
		return (CoreException) super.getCause();
	}
}
