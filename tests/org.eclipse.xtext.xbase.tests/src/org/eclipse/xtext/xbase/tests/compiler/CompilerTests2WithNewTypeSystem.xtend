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
	
	@Test def void testAbstractIterator() throws Exception {
		'''
			{
				var com.google.common.collect.AbstractIterator<String> iter = [| return null ]
				return iter
			}
		'''.compilesTo('''
			final com.google.common.collect.AbstractIterator<String> _function = new com.google.common.collect.AbstractIterator<String>() {
			    @Override
			    protected String computeNext() {
			      return null;
			    }
			  };
			com.google.common.collect.AbstractIterator<String> iter = _function;
			return iter;
		''')
	}
	
}