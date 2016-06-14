/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug456883Test extends AbstractXtendCompilerTest {
	@Test
	def test_01() {
		assertCompilesTo('''
			import java.util.ArrayList
			
			class XtendCompilationError {
			    new() {
			        new ArrayList() => [
			            val finalValue = 1
			            add(
			                new Object() {
			                    override toString() {
			                        return "" + finalValue // ERROR
			                    }
			                })
			        ]
			    }
			}
		''', '''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class XtendCompilationError {
			  public XtendCompilationError() {
			    ArrayList<Object> _arrayList = new ArrayList<Object>();
			    final Procedure1<ArrayList<Object>> _function = new Procedure1<ArrayList<Object>>() {
			      public void apply(final ArrayList<Object> it) {
			        final int finalValue = 1;
			        it.add(
			          new Object() {
			            public String toString() {
			              return ("" + Integer.valueOf(finalValue));
			            }
			          });
			      }
			    };
			    ObjectExtensions.<ArrayList<Object>>operator_doubleArrow(_arrayList, _function);
			  }
			}
		''')
	}
	
}