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
class CompilerBug462845Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug462845Test {
	
	@Test override test_01() {
		'''
			import java.util.Iterator
			class C {
				new() {
					val Iterable<String> iter = [ null ]
					new Iterator<String>() {
						Iterator<String> delegate = iter.iterator
						override hasNext() {
							delegate.hasNext
						}
						override next() {
							delegate.next
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;

			@SuppressWarnings("all")
			public class C {
			  public C() {
			    abstract class __C_1 implements Iterator<String> {
			      Iterator<String> delegate;
			    }
			    
			    final Iterable<String> _function = () -> {
			      return null;
			    };
			    final Iterable<String> iter = _function;
			    new __C_1() {
			      {
			        delegate = iter.iterator();
			      }
			      @Override
			      public boolean hasNext() {
			        return this.delegate.hasNext();
			      }
			      
			      @Override
			      public String next() {
			        return this.delegate.next();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test override test_02() {
		'''
			import java.util.Iterator
			class C {
				def m() {
					val Iterable<String> iter = [ null ]
					new Iterator<String>() {
						Iterator<String> delegate = iter.iterator
						override hasNext() {
							delegate.hasNext
						}
						override next() {
							delegate.next
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterator<String> m() {
			    abstract class __C_1 implements Iterator<String> {
			      Iterator<String> delegate;
			    }
			    
			    __C_1 _xblockexpression = null;
			    {
			      final Iterable<String> _function = () -> {
			        return null;
			      };
			      final Iterable<String> iter = _function;
			      _xblockexpression = new __C_1() {
			        {
			          delegate = iter.iterator();
			        }
			        @Override
			        public boolean hasNext() {
			          return this.delegate.hasNext();
			        }
			        
			        @Override
			        public String next() {
			          return this.delegate.next();
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test override test_03() {
		'''
			import java.util.Iterator
			class C {
				def static m() {
					val Iterable<String> iter = [ null ]
					new Iterator<String>() {
						Iterator<String> delegate = iter.iterator
						override hasNext() {
							delegate.hasNext
						}
						override next() {
							delegate.next
						}
						override remove() {}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;
			
			@SuppressWarnings("all")
			public class C {
			  public static Iterator<String> m() {
			    abstract class __C_1 implements Iterator<String> {
			      Iterator<String> delegate;
			    }
			    
			    __C_1 _xblockexpression = null;
			    {
			      final Iterable<String> _function = () -> {
			        return null;
			      };
			      final Iterable<String> iter = _function;
			      _xblockexpression = new __C_1() {
			        {
			          delegate = iter.iterator();
			        }
			        @Override
			        public boolean hasNext() {
			          return this.delegate.hasNext();
			        }
			        
			        @Override
			        public String next() {
			          return this.delegate.next();
			        }
			        
			        @Override
			        public void remove() {
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test override test_04() {
		'''
			import java.util.Iterator
			class C {
				def void m() {
					val Iterable<String> iter = [ null ]
					new Iterator<String>() {
						Iterator<String> delegate = iter.iterator
						override hasNext() {
							delegate.hasNext
						}
						override next() {
							delegate.next
						}
						override remove() {}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    abstract class __C_1 implements Iterator<String> {
			      Iterator<String> delegate;
			    }
			    
			    final Iterable<String> _function = () -> {
			      return null;
			    };
			    final Iterable<String> iter = _function;
			    new __C_1() {
			      {
			        delegate = iter.iterator();
			      }
			      @Override
			      public boolean hasNext() {
			        return this.delegate.hasNext();
			      }
			      
			      @Override
			      public String next() {
			        return this.delegate.next();
			      }
			      
			      @Override
			      public void remove() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test override test_05() {
		'''
			import java.util.Iterator
			class C {
				val iterator = {
					val Iterable<String> iter = [ null ]
					new Iterator<String>() {
						Iterator<String> delegate = iter.iterator
						override hasNext() {
							delegate.hasNext
						}
						override next() {
							delegate.next
						}
						override remove() {}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C {
			  private final Iterator<String> iterator = new Function0<Iterator<String>>() {
			    public Iterator<String> apply() {
			      abstract class __C_1 implements Iterator<String> {
			        Iterator<String> delegate;
			      }
			      
			      __C_1 _xblockexpression = null;
			      {
			        final Iterable<String> _function = () -> {
			          return null;
			        };
			        final Iterable<String> iter = _function;
			        _xblockexpression = new __C_1() {
			          {
			            delegate = iter.iterator();
			          }
			          @Override
			          public boolean hasNext() {
			            return this.delegate.hasNext();
			          }
			          
			          @Override
			          public String next() {
			            return this.delegate.next();
			          }
			          
			          @Override
			          public void remove() {
			          }
			        };
			      }
			      return _xblockexpression;
			    }
			  }.apply();
			}
		''')
	}
	
}