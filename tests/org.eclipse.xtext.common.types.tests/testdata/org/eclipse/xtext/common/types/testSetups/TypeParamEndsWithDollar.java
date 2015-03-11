/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeParamEndsWithDollar<B$> {

	<A$> void function1(A$ a) {}
	
	<A$$$> void function2(A$$$ a, B$ b) {}
	
	<$> void function3($ a) {}
	
}
