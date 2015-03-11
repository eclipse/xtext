/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Fields<T> extends TestScenario {

	@SuppressWarnings("unused")
	private T privateT;
	
	List<T> defaultListT;
	
	protected String protectedString;
	
	public int publicInt;
	
	protected static String protectedStaticString;
	
	volatile int volatileInt;

	transient int transientInt;
	
	public static class Inner extends TestScenario {
		
		public Fields<String> innerFields;
		
	}
	
}
