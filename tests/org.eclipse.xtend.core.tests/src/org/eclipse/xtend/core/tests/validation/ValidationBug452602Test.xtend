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
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ValidationBug452602Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val c = parser.parse('''
			class Test {
			    val String attrName
			    new(String s) {
			    	attrName = s
			    }
			    
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
			class Test {
			    val String attrName
			    new(String s) {
			    	attrName = s
			    }
			    
			    def boolean test(Object o) {
			        val x = o as Test
			        if ((o as Test).attrName != x.attrName) 
			        	return false 
			        return true
			    }
			}
		''')
		c.assertWarning(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.CONSTANT_BOOLEAN_CONDITION, "Constant condition is always false");
	}
	
	@Test def void test_03() {
		val c = parser.parse('''
			class Test {
			    val String attrName
			    val String attrName2
			    new(String s1, String s2) {
			    	attrName = s1
			    	attrName2 = s2
			    }
			    
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