/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmUpperBoundTest extends Assert {

	private JvmUpperBound upperBound;

	@Before
	public void setUp() throws Exception {
		upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
	}
	
	@Test public void testGetIdentifier_01() {
		assertNull(upperBound.getIdentifier());
	}
}
