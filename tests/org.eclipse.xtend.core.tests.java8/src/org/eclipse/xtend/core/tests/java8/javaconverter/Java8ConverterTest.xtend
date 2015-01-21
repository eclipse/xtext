/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.javaconverter

import org.junit.Test
import org.eclipse.xtend.core.tests.javaconverter.JavaConverterTest

/**
 * @author dhuebner - Initial contribution and API
 */
class Java8ConverterTest extends JavaConverterTest {

	@Test def void testDiamondOperator() throws Exception {
		assertEquals('''
		def List<?> foo(){
			var List<String> x=new ArrayList() 
			return new ArrayList() 
		}'''.toString, '''
		public List<?> foo() {
			List<String> x = new ArrayList<>();
			return new ArrayList<>();
		}'''.toXtendClassBodyDeclr)
	}
}