/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class CompilerTests2WithNewTypeSystem extends AbstractCompilerTests2 {
	
	@Test override void testNewThread() throws Exception {
		'''
			new Thread [| ]
		'''.compilesTo('''
			final Runnable _function = new Runnable() {
			    public void run() {
			    }
			  };
			Thread _thread = new Thread(_function);
			return _thread;
		''')
	}
	
	@Test 
	@Ignore("TODO Produces verbose code")
	override testForLoop_01() throws Exception {
		super.testForLoop_01()
	}
	
	@Test 
	@Ignore("TODO Produces verbose code")
	override testForLoop_06() throws Exception {
		super.testForLoop_06()
	}
	
	@Test 
	@Ignore("TODO Produces verbose code")
	override testForLoop_08() throws Exception {
		super.testForLoop_08()
	}
	
	@Test 
	@Ignore("TODO Type check fails")
	override testForLoop_10() throws Exception {
		super.testForLoop_10()
	}
	
}