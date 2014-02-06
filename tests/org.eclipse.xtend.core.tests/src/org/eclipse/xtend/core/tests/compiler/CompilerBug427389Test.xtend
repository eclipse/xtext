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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug427389Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_427389_01() {
		assertCompilesTo("
			abstract class C<T> {
				def final m(T it)'''
					«FOR  it : m2»
						
					«ENDFOR»
				'''
				def abstract Iterable<Pair<? extends D, Class<? extends E<?>>>> m2(T it) 
			}
			class D {}
			class E<T> {}
		", '''
			import org.eclipse.xtend2.lib.StringConcatenation;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public abstract class C<T extends Object> {
			  public final CharSequence m(final T it) {
			    StringConcatenation _builder = new StringConcatenation();
			    {
			      Iterable<Pair<? extends D,Class<? extends E<?>>>> _m2 = this.m2(it);
			      for(final Pair<? extends D, Class<? extends E<?>>> it_1 : _m2) {
			        _builder.append("\t");
			        _builder.newLine();
			      }
			    }
			    return _builder;
			  }
			  
			  public abstract Iterable<Pair<? extends D,Class<? extends E<?>>>> m2(final T it);
			}
		''')
	}
	
}