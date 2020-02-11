/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AutoBoxingDispatcherTest extends Assert {

	@Test public void testPrimitiveToObject() throws Exception {
		PolymorphicDispatcher<Boolean> dispatcher = PolymorphicDispatcher.<Boolean>createForSingleTarget("methodWithObjectParameter", this);
		assertTrue(dispatcher.invoke(true));
	}
	
	@Test public void testObjectToPrimitive() throws Exception {
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
