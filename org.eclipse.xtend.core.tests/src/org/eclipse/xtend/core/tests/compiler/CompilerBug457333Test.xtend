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
class CompilerBug457333Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
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
		''', '''
			import java.util.Collections;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Pair;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class XtendPlugin implements Procedure1<String> {
			  public interface Action<T extends Object> {
			    public abstract void exec(final T t);
			  }
			  
			  public void apply(final String project) {
			    final Procedure1<String> _function = new Procedure1<String>() {
			      public void apply(final String sourceSet) {
			        final XtendPlugin.Action<Object> _function = new XtendPlugin.Action<Object>() {
			          public void exec(final Object it) {
			            final Function0<Character> _function = new Function0<Character>() {
			              public Character apply() {
			                return Character.valueOf(sourceSet.charAt(0));
			              }
			            };
			            Pair<String, Function0<Character>> _mappedTo = Pair.<String, Function0<Character>>of("classpath", _function);
			            final Function0<Character> _function_1 = new Function0<Character>() {
			              public Character apply() {
			                return Character.valueOf(sourceSet.charAt(0));
			              }
			            };
			            Pair<String, Function0<Character>> _mappedTo_1 = Pair.<String, Function0<Character>>of("bootClasspath", _function_1);
			            XtendPlugin.conventionMapping(it, 
			              Collections.<String, Function0<Character>>unmodifiableMap(CollectionLiterals.<String, Function0<Character>>newHashMap(_mappedTo, _mappedTo_1)));
			          }
			        };
			        XtendPlugin.this.<Object>create("", Object.class, _function);
			      }
			    };
			    IterableExtensions.<String>forEach(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("")), _function);
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