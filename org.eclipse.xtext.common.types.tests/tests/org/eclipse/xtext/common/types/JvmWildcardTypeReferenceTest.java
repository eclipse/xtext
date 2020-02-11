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
public class JvmWildcardTypeReferenceTest extends Assert {

	private JvmWildcardTypeReference typeArgument;

	@Before
	public void setUp() throws Exception {
		typeArgument = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
	}
	
	@Test public void testGetIdentifier_01() {
		assertEquals("?", typeArgument.getIdentifier());
	}
	
	@Test public void testGetIdentifier_02() {
		JvmUpperBound upperBoundWithoutTypeRef = TypesFactory.eINSTANCE.createJvmUpperBound();
		typeArgument.getConstraints().add(upperBoundWithoutTypeRef);
		assertEquals("?", typeArgument.getIdentifier());
	}
	
}
