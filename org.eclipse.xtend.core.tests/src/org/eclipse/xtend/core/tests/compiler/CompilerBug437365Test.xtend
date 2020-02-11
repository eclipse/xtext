/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=437365
 */
class CompilerBug437365Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class Test {
			    def static void main(String[] args) {
			        val java.util.List<String>[] arrayOfList = newArrayOfSize(4);
			        arrayOfList.set(0, new java.util.LinkedList())
			        arrayOfList.get(0).add(new String())
			        val String a = arrayOfList.get(0).get(0)
			        println(a)
			    }	
			}
		''', '''
			import java.util.LinkedList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public static void main(final String[] args) {
			    final List<String>[] arrayOfList = new List[4];
			    LinkedList<String> _linkedList = new LinkedList<String>();
			    arrayOfList[0] = _linkedList;
			    String _string = new String();
			    (arrayOfList[0]).add(_string);
			    final String a = (arrayOfList[0]).get(0);
			    InputOutput.<String>println(a);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class Test {
			    def static void main(String[] args) {
			        val arrayOfList = newArrayOfSize(4);
			        arrayOfList.set(0, new java.util.LinkedList())
			        arrayOfList.get(0).add(new String())
			        val String a = arrayOfList.get(0).get(0)
			        println(a)
			    }	
			}
		''', '''
			import java.util.LinkedList;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public static void main(final String[] args) {
			    final LinkedList<String>[] arrayOfList = new LinkedList[4];
			    LinkedList<String> _linkedList = new LinkedList<String>();
			    arrayOfList[0] = _linkedList;
			    String _string = new String();
			    (arrayOfList[0]).add(_string);
			    final String a = (arrayOfList[0]).get(0);
			    InputOutput.<String>println(a);
			  }
			}
		''')
	}
	
	
}