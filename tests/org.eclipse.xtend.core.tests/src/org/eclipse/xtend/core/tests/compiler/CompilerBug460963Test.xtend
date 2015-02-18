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
class CompilerBug460963Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.List
			import java.util.Set
			class C {
			    def Set<String> m(List<String> list) {
			    	newHashSet(list)
			    }
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Set<String> m(final List<String> list) {
			    return CollectionLiterals.<String>newHashSet(((String[])Conversions.unwrapArray(list, String.class)));
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import java.util.List
			import java.util.Set
			class C {
			    def Set<List<String>> m(List<String> list) {
			    	newHashSet(list)
			    }
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public Set<List<String>> m(final List<String> list) {
			    return CollectionLiterals.<List<String>>newHashSet(list);
			  }
			}
		''')
	}
	
}