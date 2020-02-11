/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
