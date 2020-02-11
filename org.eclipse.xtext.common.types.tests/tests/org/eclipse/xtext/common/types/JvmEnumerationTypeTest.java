/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl;
import org.junit.Before;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmEnumerationTypeTest extends JvmDeclaredTypeTest {

	private JvmEnumerationTypeImpl enumerationType;

	@Before
	public void setUp() throws Exception {
		enumerationType = (JvmEnumerationTypeImpl) TypesFactory.eINSTANCE.createJvmEnumerationType();
	}
	
	@Override
	protected JvmEnumerationTypeImpl getObjectUnderTest() {
		return enumerationType;
	}
	
}
