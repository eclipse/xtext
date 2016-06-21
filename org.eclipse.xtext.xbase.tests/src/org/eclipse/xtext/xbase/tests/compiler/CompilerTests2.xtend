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

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=424279
	 */
	@Test def void testBug_424279() throws Exception {
		'''
			{
				val treeIt = <CharSequence>newArrayList.iterator;
				while (treeIt.hasNext) {
					val o = treeIt.next;
					if (o instanceof java.util.List<?>) {
						return o;
					} else {
						return o;
					}
				}
				return null;
			}
		'''.compilesTo('''
			java.util.ArrayList<CharSequence> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<CharSequence>newArrayList();
			final java.util.Iterator<CharSequence> treeIt = _newArrayList.iterator();
			while (treeIt.hasNext()) {
			  {
			    final CharSequence o = treeIt.next();
			    if ((o instanceof java.util.List<?>)) {
			      return o;
			    } else {
			      return o;
			    }
			  }
			}
			return null;
		''')
	}
	
	@Test def void testAbstractIterator() throws Exception {
		'''
			{
				var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ]
				return iter
			}
		'''.compilesTo('''
			final com.google.common.collect.AbstractIterator<String> _function = new com.google.common.collect.AbstractIterator<String>() {
			  @Override
			  protected String computeNext() {
			    return this.endOfData();
			  }
			};
			com.google.common.collect.AbstractIterator<String> iter = _function;
			return iter;
		''')
	}

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
			  _xtrycatchfinallyexpression = "foo".length();
			} catch (final Throwable _t) {
			  if (_t instanceof RuntimeException) {
			    final RuntimeException assert_ = (RuntimeException)_t;
			    assert_.printStackTrace();
			  } else {
			    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);
			  }
			}
			return Integer.valueOf(_xtrycatchfinallyexpression);
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
			final Runnable _function = new Runnable() {
			  public void run() {
			  }
			};
			Thread _thread = new Thread(_function);
			return _thread;
		''')
	}
	
	@Test def void testForLoop_01() throws Exception {
		'''
			for(int i: 1..2) { i.toString }
		'''.compilesTo('''
			org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);
			for (final int i : _upTo) {
			  Integer.valueOf(i).toString();
			}
		''')
	}
	
	@Test def void testForLoop_02() throws Exception {
		'''
			for(Integer i: 1..2) { i.toString }
		'''.compilesTo('''
			org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);
			for (final Integer i : _upTo) {
			  i.toString();
			}
		''')
	}
	
	@Test def void testForLoop_03() throws Exception {
		'''
			for(i: 1..2) { i.toString }
		'''.compilesTo('''
			org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);
			for (final Integer i : _upTo) {
			  i.toString();
			}
		''')
	}
	
	@Test def void testForLoop_04() throws Exception {
		'''
			for(i: null as int[]) { i.toString }
		'''.compilesTo('''
			for (final int i : ((int[]) null)) {
			  Integer.valueOf(i).toString();
			}
		''')
	}
	
	@Test def void testForLoop_05() throws Exception {
		'''
			for(i: null as Integer[]) { i.toString }
		'''.compilesTo('''
			for (final Integer i : ((Integer[]) null)) {
			  i.toString();
			}
		''')
	}
	
	@Test def void testForLoop_06() throws Exception {
		'''
			for(Integer i: null as int[]) { i.toString }
		'''.compilesTo('''
			for (final Integer i : ((int[]) null)) {
			  i.toString();
			}
		''')
	}
	
	@Test def void testForLoop_07() throws Exception {
		'''
			for(int i: null as Integer[]) { i.toString }
		'''.compilesTo('''
			for (final int i : ((Integer[]) null)) {
			  Integer.valueOf(i).toString();
			}
		''')
	}
	
	@Test def void testForLoop_08() throws Exception {
		'''
			for(Integer i: null as int[]) { i.toString }
		'''.compilesTo('''
			for (final Integer i : ((int[]) null)) {
			  i.toString();
			}
		''')
	}
	
	@Test def void testForLoop_09() throws Exception {
		'''
			for(int i: null as Integer[]) { i.toString }
		'''.compilesTo('''
			for (final int i : ((Integer[]) null)) {
			  Integer.valueOf(i).toString();
			}
		''')
	}
	
	@Test def void testForLoop_10() throws Exception {
		'''
			for(int i: newArrayList) { i.toString }
		'''.compilesTo('''
			java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();
			for (final int i : _newArrayList) {
			  Integer.valueOf(i).toString();
			}
		''')
	}
	
	@Test def void testForLoop_11() throws Exception {
		'''
			for(Integer i: newArrayList) { i.toString }
		'''.compilesTo('''
			java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();
			for (final Integer i : _newArrayList) {
			  i.toString();
			}
		''')
	}
	
	@Test def void testForLoop_12() throws Exception {
		'''
			for(double d: <Integer>newArrayList) { d.toString }
		'''.compilesTo('''
			java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();
			for (final double d : _newArrayList) {
			  Double.valueOf(d).toString();
			}
		''')
	}
	
	@Test def void testForLoop_13() throws Exception {
		'''
			for(double d: null as int[]) { d.toString }
		'''.compilesTo('''
			for (final double d : ((int[]) null)) {
			  Double.valueOf(d).toString();
			}
		''')
	}
	
	@Test def void testForLoop_14() throws Exception {
		'''
			for(double d: null as Integer[]) { d.toString }
		'''.compilesTo('''
			for (final double d : ((Integer[]) null)) {
			  Double.valueOf(d).toString();
			}
		''')
	}
	
	@Test def void testNullSafe_01() throws Exception {
		'''
			('foo'.toUpperCase as CharSequence)?.subSequence(0,2)
		'''.compilesTo('''
			String _upperCase = "foo".toUpperCase();
			CharSequence _subSequence = null;
			if (((CharSequence) _upperCase)!=null) {
			  _subSequence=((CharSequence) _upperCase).subSequence(0, 2);
			}
			return _subSequence;
		''')
	}
	
	@Test def void testSwitch() throws Exception {
		'''
			{
				val it = String
				switch name {
					CharSequence : name
					default : 'noname'
				}
			}
		'''.compilesTo('''
			String _xblockexpression = null;
			{
			  final Class<String> it = String.class;
			  String _switchResult = null;
			  String _name = it.getName();
			  boolean _matched = false;
			  if (_name instanceof CharSequence) {
			    _matched=true;
			    _switchResult = it.getName();
			  }
			  if (!_matched) {
			    _switchResult = "noname";
			  }
			  _xblockexpression = _switchResult;
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testSwitchScopes_Bug470586_01() {
		// make sure that scopes are closed correctly during the compilation
		// so that the variables created for lambdas do not have the same name
		// see https://github.com/eclipse/xtext/pull/987#issuecomment-206718312
		'''
			{
				val list = #["1", "2"]
				list.forEach[
					val res = switch it {
						CharSequence : it
					}
				]
				list.forEach[
					println(it)
				]
			}
		'''.compilesTo('''
			final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("1", "2"));
			final java.util.function.Consumer<String> _function = new java.util.function.Consumer<String>() {
			  public void accept(final String it) {
			    String _switchResult = null;
			    boolean _matched = false;
			    if (it instanceof CharSequence) {
			      _matched=true;
			      _switchResult = it;
			    }
			    final String res = _switchResult;
			  }
			};
			list.forEach(_function);
			final java.util.function.Consumer<String> _function_1 = new java.util.function.Consumer<String>() {
			  public void accept(final String it) {
			    org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);
			  }
			};
			list.forEach(_function_1);
		''')
	}

	@Test def void testSwitchScopes_Bug470586_02() {
		'''
			{
				val list = #["1", "2"]
				list.forEach[
					val res = switch it {
						CharSequence : it
						default : ''
					}
				]
				list.forEach[
					println(it)
				]
			}
		'''.compilesTo('''
			final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("1", "2"));
			final java.util.function.Consumer<String> _function = new java.util.function.Consumer<String>() {
			  public void accept(final String it) {
			    String _switchResult = null;
			    boolean _matched = false;
			    if (it instanceof CharSequence) {
			      _matched=true;
			      _switchResult = it;
			    }
			    if (!_matched) {
			      _switchResult = "";
			    }
			    final String res = _switchResult;
			  }
			};
			list.forEach(_function);
			final java.util.function.Consumer<String> _function_1 = new java.util.function.Consumer<String>() {
			  public void accept(final String it) {
			    org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);
			  }
			};
			list.forEach(_function_1);
		''')
	}
	
		@Test def void testSwitchScopes_Bug470586_03() {
		'''
			{
				val list = #["1", "2"]
				list.forEach[
					val res = switch it {
						String, CharSequence : it
						default : ''
					}
				]
				list.forEach[
					println(it)
				]
			}
		'''.compilesTo('''
			final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("1", "2"));
			final java.util.function.Consumer<String> _function = new java.util.function.Consumer<String>() {
			  public void accept(final String it) {
			    String _switchResult = null;
			    boolean _matched = false;
			    if (it instanceof String) {
			      _matched=true;
			    }
			    if (!_matched) {
			      if (it instanceof CharSequence) {
			        _matched=true;
			      }
			    }
			    if (_matched) {
			      _switchResult = it;
			    }
			    if (!_matched) {
			      _switchResult = "";
			    }
			    final String res = _switchResult;
			  }
			};
			list.forEach(_function);
			final java.util.function.Consumer<String> _function_1 = new java.util.function.Consumer<String>() {
			  public void accept(final String it) {
			    org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);
			  }
			};
			list.forEach(_function_1);
		''')
	}
	
	@Test def void testFallThroughSwitch() {
		'''
			{
				switch x : 1 {
					case 1,
					case 2:
						'lalala'
				}
			}
		'''.compilesTo(
		'''
			String _switchResult = null;
			final int x = 1;
			switch (x) {
			  case 1:
			  case 2:
			    _switchResult = "lalala";
			    break;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_2() {
		'''
			{
				switch x : 'lalala' {
					case 'a',
					case 'b',
					case 'c':
						'lalala'
				}
			}
		'''.compilesTo(
		'''
			String _switchResult = null;
			final String x = "lalala";
			boolean _matched = false;
			if (com.google.common.base.Objects.equal(x, "a")) {
			  _matched=true;
			}
			if (!_matched) {
			  if (com.google.common.base.Objects.equal(x, "b")) {
			    _matched=true;
			  }
			}
			if (!_matched) {
			  if (com.google.common.base.Objects.equal(x, "c")) {
			    _matched=true;
			  }
			}
			if (_matched) {
			  _switchResult = "lalala";
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_3() {
		'''
			{
				switch x : 1 {
					case 1,
					case 2,
					default:
						'lalala'
				}
			}
		'''.compilesTo(
		'''
			String _switchResult = null;
			final int x = 1;
			switch (x) {
			  case 1:
			  case 2:
			  default:
			    _switchResult = "lalala";
			    break;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_4() {
		'''
			{
				switch x : 'lalala' {
					case 'a',
					case 'b',
					default:
						'lalala'
				}
			}
		'''.compilesTo(
		'''
			String _switchResult = null;
			final String x = "lalala";
			boolean _matched = false;
			if (com.google.common.base.Objects.equal(x, "a")) {
			  _matched=true;
			}
			if (!_matched) {
			  if (com.google.common.base.Objects.equal(x, "b")) {
			    _matched=true;
			  }
			}
			if (_matched) {
			  _switchResult = "lalala";
			}
			if (!_matched) {
			  _switchResult = "lalala";
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_5() {
		'''
			{
				switch x : 1 {
					case 1:
						'blabla'
					case 2,
					default:
						'lalala'
				}
			}
		'''.compilesTo(
		'''
			String _switchResult = null;
			final int x = 1;
			switch (x) {
			  case 1:
			    _switchResult = "blabla";
			    break;
			  case 2:
			  default:
			    _switchResult = "lalala";
			    break;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_6() {
		'''
			{
				switch x : new Object {
					String case 'a':
						'blabla'
					Integer case 1,
					case 2,
					default:
						'lalala'
				}
			}
		'''.compilesTo(
		'''
			String _switchResult = null;
			Object _object = new Object();
			final Object x = _object;
			boolean _matched = false;
			if (x instanceof String) {
			  if (com.google.common.base.Objects.equal(x, "a")) {
			    _matched=true;
			    _switchResult = "blabla";
			  }
			}
			if (!_matched) {
			  if (x instanceof Integer) {
			    if (com.google.common.base.Objects.equal(x, 1)) {
			      _matched=true;
			    }
			  }
			  if (!_matched) {
			    if (com.google.common.base.Objects.equal(x, 2)) {
			      _matched=true;
			    }
			  }
			  if (_matched) {
			    _switchResult = "lalala";
			  }
			}
			if (!_matched) {
			  _switchResult = "lalala";
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_7() {
		'''
			{
				switch x : 'lalala' as Object { 
					String, Integer case 1: 0
					Integer, default: 1
				}
			}
		'''.compilesTo(
		'''
			int _switchResult = (int) 0;
			final Object x = ((Object) "lalala");
			boolean _matched = false;
			if (x instanceof String) {
			  _matched=true;
			}
			if (!_matched) {
			  if (x instanceof Integer) {
			    if (com.google.common.base.Objects.equal(x, 1)) {
			      _matched=true;
			    }
			  }
			}
			if (_matched) {
			  _switchResult = 0;
			}
			if (!_matched) {
			  if (x instanceof Integer) {
			    _matched=true;
			    _switchResult = 1;
			  }
			}
			if (!_matched) {
			  _switchResult = 1;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testFallThroughSwitch_8() {
		'''
			{
				switch x : 1 as Object {
					Integer,
					Double: x
				}
			}
		'''.compilesTo(
		'''
			Number _switchResult = null;
			final Object x = ((Object) Integer.valueOf(1));
			boolean _matched = false;
			if (x instanceof Integer) {
			  _matched=true;
			}
			if (!_matched) {
			  if (x instanceof Double) {
			    _matched=true;
			  }
			}
			if (_matched) {
			  _switchResult = ((Number)x);
			}
			return ((Number)_switchResult);
		'''
		//TODO there's an unnecessary cast here
		)
	}
	
	@Test def void testEmptySwitch() {
		'''
			{
				switch 1 {
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final int _switchValue = 1;
			switch (_switchValue) {
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_2() {
		'''
			{
				switch 1 {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final int _switchValue = 1;
			switch (_switchValue) {
			  default:
			    _switchResult = null;
			    break;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_3() {
		'''
			{
				switch Object {
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Class<Object> Object = Object.class;
			boolean _matched = false;
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_4() {
		'''
			{
				switch Object {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Class<Object> Object = Object.class;
			boolean _matched = false;
			if (!_matched) {
			  _switchResult = null;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_5() {
		'''
			{
				switch Thread.State.NEW {
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Thread.State _switchValue = Thread.State.NEW;
			if (_switchValue != null) {
			  switch (_switchValue) {
			    default:
			      break;
			  }
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_6() {
		'''
			{
				switch Thread.State.NEW {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Thread.State _switchValue = Thread.State.NEW;
			if (_switchValue != null) {
			  switch (_switchValue) {
			    default:
			      _switchResult = null;
			      break;
			  }
			} else {
			  _switchResult = null;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_7() {
		'''
			{
				switch Thread.State x : Thread.State.NEW {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Thread.State x = Thread.State.NEW;
			if (x != null) {
			  switch (x) {
			    default:
			      _switchResult = null;
			      break;
			  }
			} else {
			  _switchResult = null;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_8() {
		'''
			{
				switch (Thread.State x : Thread.State.NEW) {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Thread.State x = Thread.State.NEW;
			if (x != null) {
			  switch (x) {
			    default:
			      _switchResult = null;
			      break;
			  }
			} else {
			  _switchResult = null;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_9() {
		'''
			{
				switch Object x : Thread.State.NEW {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Object x = Thread.State.NEW;
			boolean _matched = false;
			if (!_matched) {
			  _switchResult = null;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testEmptySwitch_10() {
		'''
			{
				switch (Object x : Thread.State.NEW) {
					default: {
					}
				}
			}
		'''.compilesTo(
		'''
			Object _switchResult = null;
			final Object x = Thread.State.NEW;
			boolean _matched = false;
			if (!_matched) {
			  _switchResult = null;
			}
			return _switchResult;
		'''
		)
	}
	
	@Test def void testBasicForLoop_0() {
		'''
			{
				for (var i = 0; i < 10; i = i + 1) {
				}
			}
		'''.compilesTo(
		'''
			for (int i = 0; (i < 10); i = (i + 1)) {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_toJavaWhile_0() {
		'''
			{
				for (var i = if (true) { 1 }; i < 10; i = i + 1) {
				}
			}
		'''.compilesTo(
		'''
			int _xifexpression = (int) 0;
			if (true) {
			  _xifexpression = 1;
			}
			int i = _xifexpression;
			boolean _while = (i < 10);
			while (_while) {
			  i = (i + 1);
			  _while = (i < 10);
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_1() {
		'''
			{
				for (;;) {
				}
			}
		'''.compilesTo(
		'''
			for (;;) {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_toJavaWhile_1() {
		'''
			{
				for (for (;;) {};;) {
				}
			}
		'''.compilesTo(
		'''
			for (;;) {
			}
			boolean _while = true;
			while (_while) {
			  _while = true;
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_2() {
		'''
			{
				for (val i = 0; i < 10;) {
					if (i == 2) {
						return true;
					}
				}
			}
		'''.compilesTo(
		'''
			for (final int i = 0; (i < 10);) {
			  if ((i == 2)) {
			    return Boolean.valueOf(true);
			  }
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_toJavaWhile_2() {
		'''
			{
				for (val i = #[if(true) {1} else {2}]; i.head < 10;) {
					if (i.head == 2) {
						return true;
					}
				}
			}
		'''.compilesTo(
		'''
			int _xifexpression = (int) 0;
			if (true) {
			  _xifexpression = 1;
			} else {
			  _xifexpression = 2;
			}
			final java.util.List<Integer> i = java.util.Collections.<Integer>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList(Integer.valueOf(_xifexpression)));
			Integer _head = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);
			boolean _lessThan = ((_head).intValue() < 10);
			boolean _while = _lessThan;
			while (_while) {
			  Integer _head_1 = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);
			  boolean _equals = ((_head_1).intValue() == 2);
			  if (_equals) {
			    return Boolean.valueOf(true);
			  }
			  Integer _head_2 = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);
			  boolean _lessThan_1 = ((_head_2).intValue() < 10);
			  _while = _lessThan_1;
			}
			return null;
		'''
		)
	}
	
	@Test def void testBasicForLoop_3() {
		'''
			{
				for (val i = 0; i < 10;) {
					return true
				}
			}
		'''.compilesTo(
		'''
			for (final int i = 0; (i < 10);) {
			  return Boolean.valueOf(true);
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_4() {
		'''
			{
				for (var i = 1; i < 10;) {}
				for (val i = 1;;) {}
			}
		'''.compilesTo(
		'''
			for (int i = 1; (i < 10);) {
			}
			for (final int i = 1;;) {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_5() {
		'''
			{
				{
					for (var i = 1;i < 10;) {}
				}
				{
					for (val i = 1;;) {}
				}
			}
		'''.compilesTo(
		'''
			for (int i = 1; (i < 10);) {
			}
			for (final int i = 1;;) {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_6() {
		'''
			{
				if (true) {
					for (;;) {}
				}
			}
		'''.compilesTo(
		'''
			if (true) {
			  for (;;) {
			  }
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_7() {
		'''
			{
				try {
					for (;;) {}
				} finally {
				}
			}
		'''.compilesTo(
		'''
			try {
			  for (;;) {
			  }
			} finally {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_8() {
		'''
			{
				[| for (;;) {} ]
			}
		'''.compilesTo(
		'''
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure0() {
			  public void apply() {
			    for (;;) {
			    }
			  }
			};
			return _function;
		'''
		)
	}
	
	@Test def void testBasicForLoop_9() {
		'''
			{
				{
					{
						{
							for (;;) {}
						}
					}
				}
			}
		'''.compilesTo(
		'''
			for (;;) {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_10() {
		'''
			{
				val i = 0
				for ([| i ].apply, [| i ].apply; i < 10;) {
					
				}
			}
		'''.compilesTo(
		'''
			final int i = 0;
			for (new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {
			  public Integer apply() {
			    return Integer.valueOf(i);
			  }
			}.apply(), new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {
			  public Integer apply() {
			    return Integer.valueOf(i);
			  }
			}.apply(); (i < 10);) {
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_11() {
		'''
			{
				for (val i = 0, val j = 0; i < 10;) {
					
				}
			}
		'''.compilesTo(
		'''
			final int i = 0;
			final int j = 0;
			boolean _while = (i < 10);
			while (_while) {
			  _while = (i < 10);
			}
		'''
		)
	}
	
	@Test def void testBasicForLoop_12() {
		'''
			{
				for (var i = 0; i != 10; i += 1) {
					
				}
			}
		'''.compilesTo(
		'''
			int i = 0;
			boolean _while = (i != 10);
			while (_while) {
			  int _i = i;
			  i = (_i + 1);
			  _while = (i != 10);
			}
		'''
		)
	}
	
	@Test def void testWhileLoopWithConstantCondition_01() {
		'''
			while (newArrayList('').empty || 2 == (1 << 1)) {
				return ''
			}
		'''.compilesTo(
		'''
			while ((org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("").isEmpty() || (2 == (1 << 1)))) {
			  return "";
			}
			return null;
		'''
		)
	}
	
	@Test def void testWhileLoopWithConstantCondition_02() {
		'''
			while (2 == (1 << 1)) {
				return ''
			}
		'''.compilesTo(
		'''
			while ((2 == (1 << 1))) {
			  return "";
			}
		'''
		)
	}
	
	@Test def void testSynchronizedBlock_1() {
		'''
			{
				val x = new Integer(1)
				synchronized(x) {}
			}
		'''.compilesTo(
		'''
			Object _xblockexpression = null;
			{
			  final Integer x = new Integer(1);
			  Object _xsynchronizedexpression = null;
			  synchronized (x) {
			    _xsynchronizedexpression = null;
			  }
			  _xblockexpression = _xsynchronizedexpression;
			}
			return _xblockexpression;
		'''
		)
	}
	
	@Test def void testSynchronizedBlock_2() {
		'''
			{
				val x = new Integer(1)
				val y = synchronized(x) 1
			}
		'''.compilesTo(
		'''
			final Integer x = new Integer(1);
			int _xsynchronizedexpression = (int) 0;
			synchronized (x) {
			  _xsynchronizedexpression = 1;
			}
			final int y = _xsynchronizedexpression;
		'''
		)
	}
	
	@Test def void testSynchronizedBlock_3() {
		'''
			{
				val x = new Integer(1)
				val y = synchronized(x) {
					{
						{
							val i = 1
							val j = 2
							i + j
						}
					}
				}
			}
		'''.compilesTo(
		'''
			final Integer x = new Integer(1);
			int _xsynchronizedexpression = (int) 0;
			synchronized (x) {
			  int _xblockexpression = (int) 0;
			  {
			    final int i = 1;
			    final int j = 2;
			    _xblockexpression = (i + j);
			  }
			  _xsynchronizedexpression = _xblockexpression;
			}
			final int y = _xsynchronizedexpression;
		'''
		)
	}

	@Test def void testBug410797_01() throws Exception {
		'''
			{ val boolean bug = #[true, false, true].reduce[a,b|a && b] }
		'''.compilesTo('''
			final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean>() {
			  public Boolean apply(final Boolean a, final Boolean b) {
			    return Boolean.valueOf(((a).booleanValue() && (b).booleanValue()));
			  }
			};
			final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true))), _function);
		''')
	}
	
	@Test def void testBug434224_01() {
		'''
			{
				val bar = new Object
				if (bar instanceof Byte) {
					bar as char
				}
			}
		'''.compilesTo('''
			char _xblockexpression = (char) 0;
			{
			  final Object bar = new Object();
			  char _xifexpression = (char) 0;
			  if ((bar instanceof Byte)) {
			    _xifexpression = ((char) ((Byte) bar).byteValue());
			  }
			  _xblockexpression = _xifexpression;
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug434224_02() {
		'''
			{
				switch bar : new Object {
					Byte: bar as char
				}
			}
		'''.compilesTo('''
			char _switchResult = (char) 0;
			Object _object = new Object();
			final Object bar = _object;
			boolean _matched = false;
			if (bar instanceof Byte) {
			  _matched=true;
			  _switchResult = ((char) ((Byte) bar).byteValue());
			}
			return _switchResult;
		''')
	}
	
	@Test def void testBug433573_01() {
		'''
			{
				val Number element = null
				if(element instanceof Double) {
					val Iterable<? extends Number> i = #[element]
				}
			}
		'''.compilesTo('''
			final Number element = null;
			if ((element instanceof Double)) {
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(element));
			}
		''')
	}
	
	@Test def void testBug433573_02() {
		'''
			{
				val Number element = null
				switch element {
					Double: {
						val Iterable<? extends Number> i = #[element]
					}
				}
			}
		'''.compilesTo('''
			final Number element = null;
			boolean _matched = false;
			if (element instanceof Double) {
			  _matched=true;
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(element));
			}
		''')
	}
	
	@Test def void testBug433573_03() {
		'''
			{
				val Number element = null
				if(element instanceof Double) {
					val Iterable<? extends Number> i = #{element}
				}
			}
		'''.compilesTo('''
			final Number element = null;
			if ((element instanceof Double)) {
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(element));
			}
		''')
	}
	
	@Test def void testBug433573_04() {
		'''
			{
				val Number element = null
				switch element {
					Double: {
						val Iterable<? extends Number> i = #{element}
					}
				}
			}
		'''.compilesTo('''
			final Number element = null;
			boolean _matched = false;
			if (element instanceof Double) {
			  _matched=true;
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(element));
			}
		''')
	}
	
	@Test def void testBug433573_05() {
		'''
			{
				val Object element = null
				if(element instanceof Double) {
					val Iterable<? extends Number> i = #[element]
				}
			}
		'''.compilesTo('''
			final Object element = null;
			if ((element instanceof Double)) {
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(((Number)element)));
			}
		''')
	}
	
	@Test def void testBug433573_06() {
		'''
			{
				val Object element = null
				switch element {
					Double: {
						val Iterable<? extends Number> i = #[element]
					}
				}
			}
		'''.compilesTo('''
			final Object element = null;
			boolean _matched = false;
			if (element instanceof Double) {
			  _matched=true;
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(((Number)element)));
			}
		''')
	}
	
	@Test def void testBug433573_07() {
		'''
			{
				val Object element = null
				if(element instanceof Double) {
					val Iterable<? extends Number> i = #{element}
				}
			}
		'''.compilesTo('''
			final Object element = null;
			if ((element instanceof Double)) {
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(((Number)element)));
			}
		''')
	}
	
	@Test def void testBug433573_08() {
		'''
			{
				val Object element = null
				switch element {
					Double: {
						val Iterable<? extends Number> i = #{element}
					}
				}
			}
		'''.compilesTo('''
			final Object element = null;
			boolean _matched = false;
			if (element instanceof Double) {
			  _matched=true;
			  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(((Number)element)));
			}
		''')
	}
	
	@Test def void testBug466974_01() {
		'''
			{
				var i = 0
				Math.max( i = i + 1, if (i == 1) { 1 } else { 2 })
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _i = i = (i + 1);
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Math.max(_i, _xifexpression);
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_02() {
		'''
			{
				var i = 0
				Math.max(if (i == 1) { 1 } else { 2 }, i = i + 1)
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Math.max(_xifexpression, i = (i + 1));
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_03() {
		'''
			{
				var i = 0
				Math.max({ i = i + 1 }, if (i == 1) { 1 } else { 2 })
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _i = i = (i + 1);
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Math.max(_i, _xifexpression);
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_04() {
		'''
			{
				var i = 0
				Math.max(if (i == 1) { 1 } else { 2 }, { i = i + 1 })
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Math.max(_xifexpression, i = (i + 1));
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_05() {
		'''
			{
				var i = 0
				{i = i + 1}.compareTo(if (i == 1) { 1 } else { 2 })
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _i = i = (i + 1);
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Integer.valueOf(_i).compareTo(Integer.valueOf(_xifexpression));
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_06() {
		'''
			{
				var i = 0
				{if (i == 1) { 1 } else { 2 }}.compareTo(i = i + 1)
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Integer.valueOf(_xifexpression).compareTo(Integer.valueOf(i = (i + 1)));
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_07() {
		'''
			{
				var i = 0
				{{i = i + 1}}.compareTo(if (i == 1) { 1 } else { 2 })
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _i = i = (i + 1);
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Integer.valueOf(_i).compareTo(Integer.valueOf(_xifexpression));
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_08() {
		'''
			{
				var i = 0
				{if (i == 1) { 1 } else { 2 }}.compareTo({i = i + 1})
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int _xifexpression = (int) 0;
			  if ((i == 1)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  _xblockexpression = Integer.valueOf(_xifexpression).compareTo(Integer.valueOf(i = (i + 1)));
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_09() {
		'''
			{
				var i = 0
				Math.max(i = i + 1, 2)
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  _xblockexpression = Math.max(i = (i + 1), 2);
			}
			return _xblockexpression;
		''')
	}
	
	@Test def void testBug466974_10() {
		'''
			{
				var i = 0
				{i = i + 1}.compareTo(2)
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  _xblockexpression = Integer.valueOf(i = (i + 1)).compareTo(Integer.valueOf(2));
			}
			return _xblockexpression;
		''')
	}

	@Test def void testBug489037_NestedAssignment_1() {
		// this does not require argument preparation
		'''
			{
				var i = 0
				var j = 0
				j=i=0;
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int j = 0;
			  _xblockexpression = j = (i = 0);
			}
			return _xblockexpression;
		''')
	}

	@Test def void testBug489037_NestedAssignment_2() {
		// this requires argument preparation
		'''
			{
				var i = 0
				var n = 1
				n=i=(if (i==0) 1 else 2)
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int n = 1;
			  int _xifexpression = (int) 0;
			  if ((i == 0)) {
			    _xifexpression = 1;
			  } else {
			    _xifexpression = 2;
			  }
			  int _i = (i = _xifexpression);
			  _xblockexpression = n = _i;
			}
			return _xblockexpression;
		''')
	}

	@Test def void testBug489037_NestedAssignment_3() {
		// this requires argument preparation
		'''
			{
				var i = 0
				var n = 1
				n=i=switch(i) {
					default: 2
				}
			}
		'''.compilesTo('''
			int _xblockexpression = (int) 0;
			{
			  int i = 0;
			  int n = 1;
			  int _switchResult = (int) 0;
			  switch (i) {
			    default:
			      _switchResult = 2;
			      break;
			  }
			  int _i = (i = _switchResult);
			  _xblockexpression = n = _i;
			}
			return _xblockexpression;
		''')
	}

}