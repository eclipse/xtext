/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug459920Test extends AbstractXtendCompilerTest {
	
	@Test def regression_01() {
		'''
			import org.eclipse.xtext.util.concurrent.IUnitOfWork
			import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
			import org.eclipse.emf.ecore.resource.Resource
			import org.eclipse.emf.ecore.resource.ResourceSet
			import org.eclipse.xtext.util.CancelIndicator
			class Main {
			    def <R, P extends Resource> R exec(IUnitOfWork<R, P> work, P param) {
					if (work instanceof CancelableUnitOfWork<?,?>) {
						work.cancelIndicator = if (param === null)
							[ true ]
						else
							param.resourceSet.newCancelIndiciator
					}
					work.exec(param)
				}
				def CancelIndicator newCancelIndiciator(ResourceSet rs) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.emf.ecore.resource.Resource;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.eclipse.xtext.util.CancelIndicator;
			import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
			import org.eclipse.xtext.util.concurrent.IUnitOfWork;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Main {
			  public <R extends Object, P extends Resource> R exec(final IUnitOfWork<R, P> work, final P param) {
			    try {
			      R _xblockexpression = null;
			      {
			        if ((work instanceof CancelableUnitOfWork<?, ?>)) {
			          CancelIndicator _xifexpression = null;
			          if ((param == null)) {
			            final CancelIndicator _function = new CancelIndicator() {
			              public boolean isCanceled() {
			                return true;
			              }
			            };
			            _xifexpression = _function;
			          } else {
			            ResourceSet _resourceSet = param.getResourceSet();
			            _xifexpression = this.newCancelIndiciator(_resourceSet);
			          }
			          ((CancelableUnitOfWork<?, ?>)work).setCancelIndicator(_xifexpression);
			        }
			        _xblockexpression = work.exec(param);
			      }
			      return _xblockexpression;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			  
			  public CancelIndicator newCancelIndiciator(final ResourceSet rs) {
			    return null;
			  }
			}
		''')
	}
	
	@Test def test_01() {
		'''
			class Main {
			    def C pc() {
			    	null
			    }
			    def D pd() {
				    null
			    }
			    def A create if (flag) pc else pd p(String label, int num, boolean flag) {
			        name = label
			        number = num
			        count = num
			    }
				interface Named {
				    def String getName()
				    def void setName(String name)
				}
				interface A extends Named {
				    def int getNumber()
				    def void setNumber(int n)
				}
				interface B extends Named {
				    def int getCount()
				    def void setCount(int c)
				}
				interface C extends A, B {
				}
				interface D extends A, B {
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.HashMap;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Main {
			  public interface Named {
			    public abstract String getName();
			    
			    public abstract void setName(final String name);
			  }
			  
			  public interface A extends Main.Named {
			    public abstract int getNumber();
			    
			    public abstract void setNumber(final int n);
			  }
			  
			  public interface B extends Main.Named {
			    public abstract int getCount();
			    
			    public abstract void setCount(final int c);
			  }
			  
			  public interface C extends Main.A, Main.B {
			  }
			  
			  public interface D extends Main.A, Main.B {
			  }
			  
			  public Main.C pc() {
			    return null;
			  }
			  
			  public Main.D pd() {
			    return null;
			  }
			  
			  public Main.A p(final String label, final int num, final boolean flag) {
			    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(label, num, flag);
			    final Main.Named _result;
			    synchronized (_createCache_p) {
			      if (_createCache_p.containsKey(_cacheKey)) {
			        return _createCache_p.get(_cacheKey);
			      }
			      Main.Named _xifexpression = null;
			      if (flag) {
			        _xifexpression = this.pc();
			      } else {
			        _xifexpression = this.pd();
			      }
			      _result = ((Main.A)_xifexpression);
			      _createCache_p.put(_cacheKey, (Main.A)_result);
			    }
			    _init_p(_result, label, num, flag);
			    return (Main.A)_result;
			  }
			  
			  private final HashMap<ArrayList<?>, Main.A> _createCache_p = CollectionLiterals.newHashMap();
			  
			  private void _init_p(final Main.Named it, final String label, final int num, final boolean flag) {
			    it.setName(label);
			    ((Main.A)it).setNumber(num);
			    ((Main.B)it).setCount(num);
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class Main {
			    def C pc() {
			    	null
			    }
			    def D pd() {
				    null
			    }
			    def create if (flag) pc else pd p(String label, int num, boolean flag) {
			        name = label
			        number = num
			        count = num
			    }
				interface Named {
				    def String getName()
				    def void setName(String name)
				}
				interface A extends Named {
				    def int getNumber()
				    def void setNumber(int n)
				}
				interface B extends Named {
				    def int getCount()
				    def void setCount(int c)
				}
				interface C extends A, B {
				}
				interface D extends A, B {
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.HashMap;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Main {
			  public interface Named {
			    public abstract String getName();
			    
			    public abstract void setName(final String name);
			  }
			  
			  public interface A extends Main.Named {
			    public abstract int getNumber();
			    
			    public abstract void setNumber(final int n);
			  }
			  
			  public interface B extends Main.Named {
			    public abstract int getCount();
			    
			    public abstract void setCount(final int c);
			  }
			  
			  public interface C extends Main.A, Main.B {
			  }
			  
			  public interface D extends Main.A, Main.B {
			  }
			  
			  public Main.C pc() {
			    return null;
			  }
			  
			  public Main.D pd() {
			    return null;
			  }
			  
			  public Main.Named p(final String label, final int num, final boolean flag) {
			    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(label, num, flag);
			    final Main.Named _result;
			    synchronized (_createCache_p) {
			      if (_createCache_p.containsKey(_cacheKey)) {
			        return _createCache_p.get(_cacheKey);
			      }
			      Main.Named _xifexpression = null;
			      if (flag) {
			        _xifexpression = this.pc();
			      } else {
			        _xifexpression = this.pd();
			      }
			      _result = _xifexpression;
			      _createCache_p.put(_cacheKey, _result);
			    }
			    _init_p(_result, label, num, flag);
			    return _result;
			  }
			  
			  private final HashMap<ArrayList<?>, Main.Named> _createCache_p = CollectionLiterals.newHashMap();
			  
			  private void _init_p(final Main.Named it, final String label, final int num, final boolean flag) {
			    it.setName(label);
			    ((Main.A)it).setNumber(num);
			    ((Main.B)it).setCount(num);
			  }
			}
		''')
	}
	
	@Ignore("AbstractStringBuilder may not be referenced")
	@Test def test_03() {
		'''
			class Main {
			    def create if (sync) new StringBuffer else new StringBuilder p(String value, boolean sync) {
			        append(value) // since append(String) is defined in AbstractStringBuilder, this should link to append(CharSequence)
			    }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.HashMap;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Main {
			  public Object p(final String value, final boolean sync) {
			    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(value, sync);
			    final Object _result;
			    synchronized (_createCache_p) {
			      if (_createCache_p.containsKey(_cacheKey)) {
			        return _createCache_p.get(_cacheKey);
			      }
			      AbstractStringBuilder _xifexpression = null; <-- should be Object
			      if (sync) {
			        _xifexpression = new StringBuffer();
			      } else {
			        _xifexpression = new StringBuilder();
			      }
			      _result = _xifexpression;
			      _createCache_p.put(_cacheKey, _result);
			    }
			    _init_p(_result, value, sync);
			    return _result;
			  }
			  
			  private final HashMap<ArrayList<?>, Object> _createCache_p = CollectionLiterals.newHashMap();
			  
			  private void _init_p(final Object it, final String value, final boolean sync) {
			    it.append(value); // missing cast to Appendable also missing try catch for IOException
			  }
			}
		''')
	}
	
}