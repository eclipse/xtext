/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug457333Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.Map
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			
			class XtendPlugin implements (String)=>void {
			
				override apply(String project) {
					#[''].forEach [ sourceSet |
						create('', Object) [
							conventionMapping(
								#{
									"classpath" -> [|sourceSet.charAt(0)],
									"bootClasspath" -> [|sourceSet.charAt(0)]
								})
						]
					]
				}
				
				static def void conventionMapping(Object task, Map<String, ? extends Function0<?>> mappings) {
				}
				
				def <T> void create(String s, Class<? extends T> c, Action<? super T> a) {}
				
				def <T> void all(Action<T> action) {}
				
				interface Action<T> {
					def void exec(T t)
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Map;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Pair;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class XtendPlugin implements Procedure1<String> {
			  public interface Action<T extends Object> {
			    public abstract void exec(final T t);
			  }
			  
			  @Override
			  public void apply(final String project) {
			    final Consumer<String> _function = (String sourceSet) -> {
			      final XtendPlugin.Action<Object> _function_1 = (Object it) -> {
			        final Function0<Character> _function_2 = () -> {
			          return Character.valueOf(sourceSet.charAt(0));
			        };
			        Pair<String, Function0<Character>> _mappedTo = Pair.<String, Function0<Character>>of("classpath", _function_2);
			        final Function0<Character> _function_3 = () -> {
			          return Character.valueOf(sourceSet.charAt(0));
			        };
			        Pair<String, Function0<Character>> _mappedTo_1 = Pair.<String, Function0<Character>>of("bootClasspath", _function_3);
			        XtendPlugin.conventionMapping(it, 
			          Collections.<String, Function0<Character>>unmodifiableMap(CollectionLiterals.<String, Function0<Character>>newHashMap(_mappedTo, _mappedTo_1)));
			      };
			      this.<Object>create("", Object.class, _function_1);
			    };
			    Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("")).forEach(_function);
			  }
			  
			  public static void conventionMapping(final Object task, final Map<String, ? extends Function0<?>> mappings) {
			  }
			  
			  public <T extends Object> void create(final String s, final Class<? extends T> c, final XtendPlugin.Action<? super T> a) {
			  }
			  
			  public <T extends Object> void all(final XtendPlugin.Action<T> action) {
			  }
			}
		''')
	}
	
}