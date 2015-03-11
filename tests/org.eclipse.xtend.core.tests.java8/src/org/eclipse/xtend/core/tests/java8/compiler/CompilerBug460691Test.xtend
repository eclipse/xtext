/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug460691Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug460691Test {
	
	@Test override test_01() {
		'''
			class C implements java.util.Comparator<String> {
			    override compare(String s1, String s2) {
			    	return s1.compareTo(s2)
			    }
			}
		'''.assertCompilesTo('''
			import java.util.Comparator;
			
			@SuppressWarnings("all")
			public class C implements Comparator<String> {
			  @Override
			  public int compare(final String s1, final String s2) {
			    return s1.compareTo(s2);
			  }
			}
		''')
	}
	
}