/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import org.junit.Test

import static org.eclipse.xtext.util.JavaVersion.*

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class NewLanguageFeaturesCompilerTest extends AbstractOutputComparingCompilerTests {
	
	@Test def void testOverride() throws Exception {
		'''
			{ val x = #['a', '', 'c'].filter[!empty] }
		'''.compilesTo('''
		    final org.eclipse.xtext.xbase.lib.Functions.Function1<String, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function1<String, Boolean>() {
		      @Override
		      public Boolean apply(final String it) {
		        boolean _isEmpty = it.isEmpty();
		        return Boolean.valueOf((!_isEmpty));
		      }
		    };
		    final Iterable<String> x = org.eclipse.xtext.xbase.lib.IterableExtensions.<String>filter(java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList("a", "", "c")), _function);
		''', JAVA6 -> JAVA7)
	}
	
	@Test def void testSwitchOverString() throws Exception {
		'''
			{
				val x = switch('foo') {
					case 'a': 1
					case 'b' + 'c': 2
					default: 3
				}
			}
		'''.compilesTo('''
		    int _switchResult = (int) 0;
		    final String _switchValue = "foo";
		    switch (_switchValue) {
		      case "a":
		        _switchResult = 1;
		        break;
		      case ("b" + "c"):
		        _switchResult = 2;
		        break;
		      default:
		        _switchResult = 3;
		        break;
		    }
		    final int x = _switchResult;
		''', JAVA7 -> JAVA8)
	}
	
	@Test def void testUnderscoreInNumericLiteral() throws Exception {
		'''
			{
				val x = 123_456_789
			}
		'''.compilesTo('''
		    final int x = 123_456_789;
		''', JAVA7 -> JAVA8)
	}
	
	@Test def void testNewThread() throws Exception {
		'''
			new Thread [| ]
		'''.compilesTo('''
			final Runnable _function = () -> {
			};
			Thread _thread = new Thread(_function);
			return _thread;
		''', JAVA8)
	}
	
	@Test def void testBasicForLoop_8() {
		'''
			{
				[| for (;;) {} ]
			}
		'''.compilesTo('''
		    final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = () -> {
		      for (;;) {
		      }
		    };
		    return _function;
		''', JAVA8)
	}
	
	@Test def void testBasicForLoop_10() {
		'''
			{
				val i = 0
				for ([| i ].apply, [| i ].apply; i < 10;) {
					
				}
			}
		'''.compilesTo('''
		    final int i = 0;
		    for (((org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>) () -> {
		      return Integer.valueOf(i);
		    }).apply(), ((org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>) () -> {
		      return Integer.valueOf(i);
		    }).apply(); (i < 10);) {
		    }
		''', JAVA8)
	}

	@Test def void testBug410797_01() throws Exception {
		'''
			{ val boolean bug = #[true, false, true].reduce[a,b|a && b] }
		'''.compilesTo('''
		    final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean> _function = (Boolean a, Boolean b) -> {
		      return Boolean.valueOf(((a).booleanValue() && (b).booleanValue()));
		    };
		    final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true))), _function);
		''', JAVA8)
	}
	
	@Test def void testImplicitReferenceToMultitype() throws Exception {
		'''
			((null as Iterable<java.util.List<Object>>) + (null as Iterable<java.util.Set<Object>>)).forEach[ size ]
		'''.compilesTo('''
			Iterable<java.util.Collection<Object>> _plus = com.google.common.collect.Iterables.<java.util.Collection<Object>>concat(((Iterable<java.util.List<Object>>) null), ((Iterable<java.util.Set<Object>>) null));
			final java.util.function.Consumer<java.util.Collection<Object>> _function = (java.util.Collection<Object> it) -> {
			  it.size();
			};
			_plus.forEach(_function);
		''', JAVA8)
	}
	
	@Test def void testImplicitReferenceToSynonym_01() throws Exception {
		'''
			(null as Iterable<String[]>).forEach[ reverse ]
		'''.compilesTo('''
			final java.util.function.Consumer<String[]> _function = (String[] it) -> {
			  org.eclipse.xtext.xbase.lib.ListExtensions.<String>reverse(((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)));
			};
			((Iterable<String[]>) null).forEach(_function);
		''', JAVA8)
	}
	
	@Test def void testBlockHasNoSuperfluousBraces_03() throws Exception {
		'''
			{ var (int)=>void fun = [ int i | new Object() new Object() ] }
		'''.compilesTo('''
		    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<Integer> _function = (Integer i) -> {
		      new Object();
		      new Object();
		    };
		    org.eclipse.xtext.xbase.lib.Procedures.Procedure1<? super Integer> fun = _function;
		''', JAVA8)
	}
	
	@Test def void testExceptionOnClosure() throws Exception {
		'''
			{val java.beans.VetoableChangeListener x = []}
		'''.compilesTo('''
		    final java.beans.VetoableChangeListener _function = (java.beans.PropertyChangeEvent it) -> {
		    };
		    final java.beans.VetoableChangeListener x = _function;
		''', JAVA8)
	}
	
}