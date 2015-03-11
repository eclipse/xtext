/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
