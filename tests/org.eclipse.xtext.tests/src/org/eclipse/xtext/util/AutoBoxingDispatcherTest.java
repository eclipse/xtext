/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import junit.framework.TestCase;


/**
 * @author koehnlein - Initial contribution and API
 */
public class AutoBoxingDispatcherTest extends TestCase {

	public void testPrimitiveToObject() throws Exception {
		PolymorphicDispatcher<Boolean> dispatcher = PolymorphicDispatcher.<Boolean>createForSingleTarget("methodWithObjectParameter", this);
		assertTrue(dispatcher.invoke(true));
	}
	
	public void testObjectToPrimitive() throws Exception {
		PolymorphicDispatcher<Boolean> dispatcher = PolymorphicDispatcher.<Boolean>createForSingleTarget("methodWithPrimitiveParameter", this);
		assertTrue(dispatcher.invoke(Boolean.TRUE));
	}
	
	@SuppressWarnings("unused")
	private boolean methodWithPrimitiveParameter(boolean param) {
		return true;
	}

	@SuppressWarnings("unused")
	private Boolean methodWithObjectParameter(Boolean param) {
		return Boolean.TRUE;
	}
}
