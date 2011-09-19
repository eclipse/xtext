/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InitializerWithConstructor extends TestScenario {

	protected InitializerWithConstructor(String unused) {
		super();
	}
	
	static {
		@SuppressWarnings("unused")
		int i = 0;
		i++;
	}
	
	{
		@SuppressWarnings("unused")
		int i = 0;
		i++;
	}
}
