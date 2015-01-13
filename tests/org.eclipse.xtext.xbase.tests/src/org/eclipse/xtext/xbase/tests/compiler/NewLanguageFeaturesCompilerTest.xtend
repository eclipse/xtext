/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import org.junit.Test

import static org.eclipse.xtext.xbase.compiler.JavaVersion.*

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
	
}