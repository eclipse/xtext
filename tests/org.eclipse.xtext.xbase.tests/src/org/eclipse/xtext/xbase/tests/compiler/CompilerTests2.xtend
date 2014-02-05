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
			boolean _hasNext = treeIt.hasNext();
			boolean _while = _hasNext;
			while (_while) {
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
			  if (!_matched) {
			    if (_name instanceof CharSequence) {
			      _matched=true;
			      _switchResult = it.getName();
			    }
			  }
			  if (!_matched) {
			    _switchResult = "noname";
			  }
			  _xblockexpression = _switchResult;
			}
			return _xblockexpression;
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
			if (!_matched) {
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
			if (!_matched) {
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
			if (!_matched) {
			  if (x instanceof String) {
			    if (com.google.common.base.Objects.equal(x, "a")) {
			      _matched=true;
			      _switchResult = "blabla";
			    }
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
			if (!_matched) {
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
			if (!_matched) {
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
			}
			return _switchResult;
		'''
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
			return null;
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
			final java.util.List<Integer> i = java.util.Collections.<Integer>unmodifiableList(com.google.common.collect.Lists.<Integer>newArrayList(_xifexpression));
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
			return null;
		'''
		)
	}
	
	@Test def void testBasicForLoop_4() {
		'''
			{
				for (val i = 1;;) {}
				for (val i = 1;;) {}
			}
		'''.compilesTo(
		'''
			for (final int i = 1;;) {
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
					for (val i = 1;;) {}
				}
				{
					for (val i = 1;;) {}
				}
			}
		'''.compilesTo(
		'''
			for (final int i = 1;;) {
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
			    return i;
			  }
			}.apply(), new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {
			  public Integer apply() {
			    return i;
			  }
			}.apply(); (i < 10);) {
			}
		'''
		)
	}

	@Test def void testBug410797_01() throws Exception {
		'''
			{ val boolean bug = #[true, false, true].reduce[a,b|a && b] }
		'''.compilesTo('''
			final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean>() {
			  public Boolean apply(final Boolean a, final Boolean b) {
			    boolean _and = false;
			    if (!(a).booleanValue()) {
			      _and = false;
			    } else {
			      _and = (b).booleanValue();
			    }
			    return Boolean.valueOf(_and);
			  }
			};
			final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(com.google.common.collect.Lists.<Boolean>newArrayList(true, false, true)), _function);
		''')
	}
}

