/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler.output;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class CompilerTraceTest2 extends CompilerTraceTest {

	@Override
	@Test
	public void testStaticFeatureCall_04() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Collections.<Object>em#ptyL#ist();\n" + 
				"return _emptyList;", 
				"java::util::Collections::#emptyList#");
	}
	
	@Override
	@Test
	public void testConstructorCall_04() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _arrayList = new Array#List<#Object>();\n" +
				"return _arrayList;", 
				"new #java.util.ArrayList#");
	}
	
	@Override
	@Test
	public void testConstructorCall_09() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _arrayList = new Array#List<#Object>(5);\n" +
				"return _arrayList;", 
				"((new #java.util.ArrayList#(5)))");
	}
	
}
