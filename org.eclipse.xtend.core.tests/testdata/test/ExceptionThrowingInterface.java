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
 interface ExceptionThrowingInterface {

	 void ioException() throws IOException ;
	
	 <E extends IOException> void generifiedIoException() throws E;

	 void runtimeException() throws RuntimeException ;

	 <E extends RuntimeException> void generifiedRuntimeException() throws E ;
	
	 void nullPointerException() throws NullPointerException ;

	 void throwable() throws Throwable ;

	 void noException() ;
}
