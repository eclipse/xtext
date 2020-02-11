/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author dhuebner - Initial contribution and API
 */
public class CallableThrowsExceptions {

	// constructors
	public CallableThrowsExceptions() throws UnsupportedOperationException {
	}

	public CallableThrowsExceptions(boolean rethrow) throws RuntimeException, Exception {
		this();
	}

	public <E extends Exception> CallableThrowsExceptions(E ex) throws E {
		this();
		throw ex;
	}

	//methods
	public void throwsExceptions() throws UnsupportedOperationException {
	}

	public void throwsExceptions(boolean rethrow) throws RuntimeException, Exception {
		this.throwsExceptions();
	}

	public <E extends Exception> void throwsExceptions(E ex) throws E {
		this.throwsExceptions();
	}

}
