/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ValidationBug452602Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val c = parser.parse('''
			@Data
			class Test {
			    String attrName
			    
			    def boolean test(Object o) {
			        val x = o as Test
			        if (attrName != x.attrName) 
			        	return false 
			        return true
			    }
			}
		''')
		c.assertNoIssues;
	}
	
	@Test def void test_02() {
		val c = parser.parse('''
			@Data
			class Test {
			    String attrName
			    String attrName2
			    
			    def boolean test() {
			        if (attrName === attrName2) 
			        	return false 
			        return true
			    }
			}
		''')
		c.assertNoIssues;
	}
	
}