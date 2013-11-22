/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug421999Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def m(java.util.List<String> list) {
					return list.sortBy(e|e)
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<String> m(final List<String> list) {
			    final Function1<String,String> _function = new Function1<String,String>() {
			      public String apply(final String e) {
			        return e;
			      }
			    };
			    return IterableExtensions.<String, String>sortBy(list, _function);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def java.util.List<String> m(java.util.List<String> list) {
					return list.sortBy(e|e)
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<String> m(final List<String> list) {
			    final Function1<String,String> _function = new Function1<String,String>() {
			      public String apply(final String e) {
			        return e;
			      }
			    };
			    return IterableExtensions.<String, String>sortBy(list, _function);
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def m(java.util.List<String> list) {
					list.sortBy(e|e)
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<String> m(final List<String> list) {
			    final Function1<String,String> _function = new Function1<String,String>() {
			      public String apply(final String e) {
			        return e;
			      }
			    };
			    List<String> _sortBy = IterableExtensions.<String, String>sortBy(list, _function);
			    return _sortBy;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def java.util.List<String> m(java.util.List<String> list) {
					list.sortBy(e|e)
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<String> m(final List<String> list) {
			    final Function1<String,String> _function = new Function1<String,String>() {
			      public String apply(final String e) {
			        return e;
			      }
			    };
			    List<String> _sortBy = IterableExtensions.<String, String>sortBy(list, _function);
			    return _sortBy;
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import org.eclipse.emf.ecore.EClass
			import org.eclipse.emf.ecore.EObject
			import org.eclipse.emf.ecore.resource.ResourceSet
			import org.eclipse.xtext.EcoreUtil2
			import org.eclipse.xtext.naming.QualifiedName
			import org.eclipse.xtext.resource.IEObjectDescription
			import org.eclipse.xtext.xbase.lib.Pair
			
			class Dummy {
				
				def private <T extends EObject> T resolve(IEObjectDescription it, ResourceSet resourceSet) {
				}
				
				def <T extends EObject> Iterable<Pair<QualifiedName, T>> getVisibleIEObjectDescriptionByTypeAndCondition(
					ResourceSet resourceSet,
					EClass type,
					(IEObjectDescription)=>boolean p) {
					val c = <IEObjectDescription>newArrayList
					c.map[eod|
						eod.qualifiedName -> resolve(eod, resourceSet)]
				}
				
			}
		''', '''
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EClass;
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.eclipse.xtext.naming.QualifiedName;
			import org.eclipse.xtext.resource.IEObjectDescription;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class Dummy {
			  private <T extends EObject> T resolve(final IEObjectDescription it, final ResourceSet resourceSet) {
			    return null;
			  }
			  
			  public <T extends EObject> Iterable<Pair<QualifiedName,T>> getVisibleIEObjectDescriptionByTypeAndCondition(final ResourceSet resourceSet, final EClass type, final Function1<? super IEObjectDescription,? extends Boolean> p) {
			    List<Pair<QualifiedName,T>> _xblockexpression = null;
			    {
			      final ArrayList<IEObjectDescription> c = CollectionLiterals.<IEObjectDescription>newArrayList();
			      final Function1<IEObjectDescription,Pair<QualifiedName,T>> _function = new Function1<IEObjectDescription,Pair<QualifiedName,T>>() {
			        public Pair<QualifiedName,T> apply(final IEObjectDescription eod) {
			          QualifiedName _qualifiedName = eod.getQualifiedName();
			          T _resolve = Dummy.this.<T>resolve(eod, resourceSet);
			          Pair<QualifiedName,T> _mappedTo = Pair.<QualifiedName, T>of(_qualifiedName, _resolve);
			          return _mappedTo;
			        }
			      };
			      List<Pair<QualifiedName,T>> _map = ListExtensions.<IEObjectDescription, Pair<QualifiedName,T>>map(c, _function);
			      _xblockexpression = (_map);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
}
