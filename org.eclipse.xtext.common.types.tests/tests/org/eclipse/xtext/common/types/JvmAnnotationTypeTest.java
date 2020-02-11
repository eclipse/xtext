/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Before;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnnotationTypeTest extends JvmDeclaredTypeTest {

	private JvmAnnotationType annotationType;

	@Before
	public void setUp() throws Exception {
		annotationType = TypesFactory.eINSTANCE.createJvmAnnotationType();
	}
	
	@Override
	protected JvmAnnotationType getObjectUnderTest() {
		return annotationType;
	}
	
}
