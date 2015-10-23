/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.arithmetics.arithmetics.Module
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(ArithmeticsInjectorProvider)
class ArithmeticsParsingTest{

	@Inject
	extension ParseHelper<Module> parseHelper
	
	@Inject
	extension ValidationTestHelper validationTestHelper

	@Test 
	def void loadModel() {
		'''
			module test
			def fun(a,b) : a * b;
			fun(2, fun(3,4));
		'''.parse.assertNoErrors
	}

}
