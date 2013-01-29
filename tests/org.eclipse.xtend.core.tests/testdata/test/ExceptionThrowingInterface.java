/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse  License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
