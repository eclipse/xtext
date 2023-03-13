/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package test;

import java.io.IOException;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExceptionThrowing {

	public void ioException() throws IOException {
	}
	
	public <E extends IOException> void generifiedIoException() throws E {
	}

	public void runtimeException() throws RuntimeException {
	}

	public <E extends RuntimeException> void generifiedRuntimeException() throws E {
	}
	
	public void nullPointerException() throws NullPointerException {
	}

	public void throwable() throws Throwable {
	}

	public void noException() {
	}
}
