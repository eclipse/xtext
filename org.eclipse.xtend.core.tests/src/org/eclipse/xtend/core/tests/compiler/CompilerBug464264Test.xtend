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
class CompilerBug464264Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.List
			class C {
				def m(I i, List<CharSequence> list) {
					i.strings += list.map[it as String]
					list.map[it]
				}
				interface I {
					def List<String> getStrings()
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.Iterables;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			    public abstract List<String> getStrings();
			  }
			  
			  public List<CharSequence> m(final C.I i, final List<CharSequence> list) {
			    List<CharSequence> _xblockexpression = null;
			    {
			      List<String> _strings = i.getStrings();
			      final Function1<CharSequence, String> _function = new Function1<CharSequence, String>() {
			        public String apply(final CharSequence it) {
			          return ((String) it);
			        }
			      };
			      List<String> _map = ListExtensions.<CharSequence, String>map(list, _function);
			      Iterables.<String>addAll(_strings, _map);
			      final Function1<CharSequence, CharSequence> _function_1 = new Function1<CharSequence, CharSequence>() {
			        public CharSequence apply(final CharSequence it) {
			          return it;
			        }
			      };
			      _xblockexpression = ListExtensions.<CharSequence, CharSequence>map(list, _function_1);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import java.util.List
			class C {
				def m(List<? super CharSequence> res, Iterable<? extends Object> obj) { 
					res += obj.map[""]
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.Iterables;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final List<? super CharSequence> res, final Iterable<?> obj) {
			    final Function1<Object, String> _function = new Function1<Object, String>() {
			      public String apply(final Object it) {
			        return "";
			      }
			    };
			    Iterable<? extends CharSequence> _map = IterableExtensions.map(obj, _function);
			    return Iterables.addAll(res, _map);
			  }
			}
		''')
	}
	
}