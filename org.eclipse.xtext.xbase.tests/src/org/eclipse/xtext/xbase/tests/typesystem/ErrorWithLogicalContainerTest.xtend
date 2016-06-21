/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.junit.typesystem.Oven
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test
import org.eclipse.xtext.testing.InjectWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseWithLogicalContainerInjectorProvider)
class ErrorWithLogicalContainerTest extends AbstractXbaseTestCase {
	
	@Inject extension Oven
	
	@Test
	def void testErrorModel_01() throws Exception {
		'''
			return s
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_02() throws Exception {
		'''
			retus.toUpperCase
		'''.fireproof
	}
	
}