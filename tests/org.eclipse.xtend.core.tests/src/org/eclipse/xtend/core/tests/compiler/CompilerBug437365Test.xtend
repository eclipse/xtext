/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			    List<String> _get = arrayOfList[0];
			    String _string = new String();
			    _get.add(_string);
			    List<String> _get_1 = arrayOfList[0];
			    final String a = _get_1.get(0);
			    InputOutput.<String>println(a);
			  }
			}
		''')
	}
	
	
}