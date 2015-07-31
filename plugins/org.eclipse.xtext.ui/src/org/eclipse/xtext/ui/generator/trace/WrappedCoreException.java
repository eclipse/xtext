/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	public CoreException getCause() {
		return (CoreException) super.getCause();
	}
}
