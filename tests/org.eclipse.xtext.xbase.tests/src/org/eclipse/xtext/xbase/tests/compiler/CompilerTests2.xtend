/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import org.junit.Test

class CompilerTests2 extends AbstractOutputComparingCompilerTests {

	@Test def void testVariableDeclaration() throws Exception {
		'''
			{
				val x = 42
			}
		'''.compilesTo('''
			final int x = 42;
		''')
	}
		
	@Test def void testVariableDeclaration1() throws Exception {
		'''
			{
				val a = 'foo'
				val x = a
			}
		'''.compilesTo('''
			final String a = "foo";
			final String x = a;
		''')
	}
	
	@Test def void testVariableDeclaration2() throws Exception {
		'''
			{
				val x = 'foo'.toUpperCase
			}
		'''.compilesTo('''
			final String x = "foo".toUpperCase();
		''')
	}
		
	@Test def void testBug367144() throws Exception {
		'''
			foo::bar::SubOfClassWithStatics::MY_STATIC_FIELD
		'''.compilesTo('''
			return foo.bar.SubOfClassWithStatics.MY_STATIC_FIELD;
		''')
	}
	
	@Test def void testBug367144_1() throws Exception {
		'''
			foo::bar::SubOfClassWithStatics::MY_STATIC_METHOD
		'''.compilesTo('''
			String _MY_STATIC_METHOD = foo.bar.SubOfClassWithStatics.MY_STATIC_METHOD();
			return _MY_STATIC_METHOD;
		''')
	}
	
	@Test def void testBug371321_1() throws Exception {
		'''
			try {
				'foo'.length
			} catch (RuntimeException assert) {
				assert.printStackTrace
			}
		'''.compilesTo('''
			int _xtrycatchfinallyexpression = (int) 0;
			try {
			  int _length = "foo".length();
			  _xtrycatchfinallyexpression = _length;
			} catch (final Throwable _t) {
			  if (_t instanceof RuntimeException) {
			    final RuntimeException assert_ = (RuntimeException)_t;
			    assert_.printStackTrace();
			  } else {
			    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);
			  }
			}
			return _xtrycatchfinallyexpression;
		''')
	}
	
	@Test def void testBug371321_2() throws Exception {
		'''
			for (assert : 'foo'.toCharArray) {
				println(assert)
			}
		'''.compilesTo('''
			char[] _charArray = "foo".toCharArray();
			for (final char assert_ : _charArray) {
			  org.eclipse.xtext.xbase.lib.InputOutput.<Character>println(Character.valueOf(assert_));
			}
		''')
	}
	
	@Test def void testNewThread() throws Exception {
		'''
			new Thread [| ]
		'''.compilesTo('''
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure0() {
			    public void apply() {
			    }
			  };
			Thread _thread = new Thread(new Runnable() {
			    public void run() {
			      _function.apply();
			    }
			});
			return _thread;
		''')
	}
}