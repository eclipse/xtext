/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class CompilerBug440006Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			
			class Test {
				def test() {
					«"'''«FOR i:#{1..2}»«i»«ENDFOR»'''"»
				}
			}
		''', '''
			import java.util.Collections;
			import org.eclipse.xtend2.lib.StringConcatenation;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IntegerRange;
			
			@SuppressWarnings("all")
			public class Test {
			  public CharSequence test() {
			    StringConcatenation _builder = new StringConcatenation();
			    {
			      IntegerRange _upTo = new IntegerRange(1, 2);
			      for(final IntegerRange i : Collections.<IntegerRange>unmodifiableSet(CollectionLiterals.<IntegerRange>newHashSet(_upTo))) {
			        _builder.append(i);
			      }
			    }
			    return _builder;
			  }
			}
		''')
	}
	
	@Test
	def test_012() {
		assertCompilesTo('''
			
			class Test {
				def test() {
					«"'''«FOR i:#[1..2]»«i»«ENDFOR»'''"»
				}
			}
		''', '''
			import java.util.Collections;
			import org.eclipse.xtend2.lib.StringConcatenation;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IntegerRange;
			
			@SuppressWarnings("all")
			public class Test {
			  public CharSequence test() {
			    StringConcatenation _builder = new StringConcatenation();
			    {
			      IntegerRange _upTo = new IntegerRange(1, 2);
			      for(final IntegerRange i : Collections.<IntegerRange>unmodifiableList(CollectionLiterals.<IntegerRange>newArrayList(_upTo))) {
			        _builder.append(i);
			      }
			    }
			    return _builder;
			  }
			}
		''')
	}
	
}
