/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug342021Test extends AbstractXtendCompilerTest {
	
	@Test
	def testIfExpression_01() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m(String s) {
					if (true) 
						[|<Object>newArrayList().iterator]
					else
						newArrayList(s).toArray
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final String s) {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xifexpression = _function;
			    } else {
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList(s).toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test
	def testIfExpression_02() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					return if (true) 
						[|<Object>newArrayList().iterator]
					else
						newArrayList('').toArray
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xifexpression = _function;
			    } else {
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	@Test
	def testIfExpression_03() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					if (true) 
						return [|<Object>newArrayList().iterator]
					else
						return newArrayList('').toArray
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      return _function;
			    } else {
			      return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			  }
			}
		''')
	}
	@Test
	def testIfExpression_04() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					if (true) 
						return [|<Object>newArrayList().iterator]
					else
						newArrayList('').toArray
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Object[] _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      return _function;
			    } else {
			      _xifexpression = CollectionLiterals.<String>newArrayList("").toArray();
			    }
			    return (Iterable<Object>)Conversions.doWrapArray(_xifexpression);
			  }
			}
		''')
	}
	@Test
	def testIfExpression_05() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					if (true) 
						[|<Object>newArrayList().iterator]
					else
						return newArrayList('').toArray
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xifexpression = _function;
			    } else {
			      return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test
	def testIfExpression_06() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m(String s) {
					if (true) 
						{ [| { <Object>newArrayList().iterator } ] }
					else
						{ { newArrayList(s).toArray } }
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final String s) {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xifexpression = _function;
			    } else {
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList(s).toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	@Test
	def testIfExpression_07() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					return { 
						if (true) 
							{ [|<Object>newArrayList().iterator] }
						else
							{ newArrayList('').toArray }
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xifexpression = _function;
			    } else {
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	@Test
	def testIfExpression_08() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					{
						if (true) 
							{ return { [|<Object>newArrayList().iterator] } }
						else
							{ return { { newArrayList('') } .toArray } }
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      return _function;
			    } else {
			      return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			  }
			}
		''')
	}
	@Test
	def testIfExpression_09() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					if (true) 
						{ return { [|<Object>newArrayList().iterator] } }
					else
						{ newArrayList('').toArray }
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Object[] _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      return _function;
			    } else {
			      _xifexpression = CollectionLiterals.<String>newArrayList("").toArray();
			    }
			    return (Iterable<Object>)Conversions.doWrapArray(_xifexpression);
			  }
			}
		''')
	}
	@Test
	def testIfExpression_10() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					if (true) 
						{ [|<Object>newArrayList().iterator] }
					else
						{ return newArrayList('').toArray }
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xifexpression = _function;
			    } else {
			      return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test
	def testIfExpression_11() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m(String s) {
					toString
					if (true) {
						toString;
						[|<Object>newArrayList().iterator]
					} else {
						toString
						newArrayList(s).toArray
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final String s) {
			    Iterable<Object> _xblockexpression = null;
			    {
			      this.toString();
			      Iterable<Object> _xifexpression = null;
			      if (true) {
			        Iterable<Object> _xblockexpression_1 = null;
			        {
			          this.toString();
			          final Iterable<Object> _function = new Iterable<Object>() {
			            public Iterator<Object> iterator() {
			              return CollectionLiterals.<Object>newArrayList().iterator();
			            }
			          };
			          _xblockexpression_1 = _function;
			        }
			        _xifexpression = _xblockexpression_1;
			      } else {
			        Object[] _xblockexpression_2 = null;
			        {
			          this.toString();
			          _xblockexpression_2 = CollectionLiterals.<String>newArrayList(s).toArray();
			        }
			        _xifexpression = (Iterable<Object>)Conversions.doWrapArray(_xblockexpression_2);
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	@Test
	def testIfExpression_12() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					toString
					return {
						toString
						if (true) {
							toString;
							[|<Object>newArrayList().iterator]
						} else {
							toString
							newArrayList('').toArray
						}
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    this.toString();
			    Iterable<Object> _xblockexpression = null;
			    {
			      this.toString();
			      Iterable<Object> _xifexpression = null;
			      if (true) {
			        Iterable<Object> _xblockexpression_1 = null;
			        {
			          this.toString();
			          final Iterable<Object> _function = new Iterable<Object>() {
			            public Iterator<Object> iterator() {
			              return CollectionLiterals.<Object>newArrayList().iterator();
			            }
			          };
			          _xblockexpression_1 = _function;
			        }
			        _xifexpression = _xblockexpression_1;
			      } else {
			        Object[] _xblockexpression_2 = null;
			        {
			          this.toString();
			          _xblockexpression_2 = CollectionLiterals.<String>newArrayList("").toArray();
			        }
			        _xifexpression = (Iterable<Object>)Conversions.doWrapArray(_xblockexpression_2);
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	@Test
	def testIfExpression_13() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					toString
					if (true) {
						toString 
						return [|<Object>newArrayList().iterator]
					} else {
						toString
						return newArrayList('').toArray
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    this.toString();
			    if (true) {
			      this.toString();
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      return _function;
			    } else {
			      this.toString();
			      return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			  }
			}
		''')
	}
	@Test
	def testIfExpression_14() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					toString
					if (true) {
						toString
						return [|<Object>newArrayList().iterator]
					} else {
						toString
						newArrayList('').toArray
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Object[] _xblockexpression = null;
			    {
			      this.toString();
			      Object[] _xifexpression = null;
			      if (true) {
			        this.toString();
			        final Iterable<Object> _function = new Iterable<Object>() {
			          public Iterator<Object> iterator() {
			            return CollectionLiterals.<Object>newArrayList().iterator();
			          }
			        };
			        return _function;
			      } else {
			        Object[] _xblockexpression_1 = null;
			        {
			          this.toString();
			          _xblockexpression_1 = CollectionLiterals.<String>newArrayList("").toArray();
			        }
			        _xifexpression = _xblockexpression_1;
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return (Iterable<Object>)Conversions.doWrapArray(_xblockexpression);
			  }
			}
		''')
	}
	@Test
	def testIfExpression_15() {
		assertCompilesTo('''
			class C {
				def Iterable<Object> m() {
					{
						toString
					}
					if (true) {
						{
							toString
						}
						[|<Object>newArrayList().iterator]
					} else {
						{
							toString
						}
						return newArrayList('').toArray
					}
				}
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xblockexpression = null;
			    {
			      this.toString();
			      Iterable<Object> _xifexpression = null;
			      if (true) {
			        Iterable<Object> _xblockexpression_1 = null;
			        {
			          this.toString();
			          final Iterable<Object> _function = new Iterable<Object>() {
			            public Iterator<Object> iterator() {
			              return CollectionLiterals.<Object>newArrayList().iterator();
			            }
			          };
			          _xblockexpression_1 = _function;
			        }
			        _xifexpression = _xblockexpression_1;
			      } else {
			        this.toString();
			        return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchExpression_01() {
		assertCompilesTo('''
			class C {
			    def Iterable<Object> m(Object o) {
				  switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	default: newArrayList('').toArray
				  }
			    }
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      _switchResult = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchExpression_02() {
		assertCompilesTo('''
			class C {
			    def Iterable<Object> m(Object o) {
				  switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	String: return newArrayList('').toArray
				  }
			    }
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchExpression_03() {
		assertCompilesTo('''
			class C {
			    def Iterable<Object> m(Object o) {
				  return switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	String: newArrayList('').toArray
				  	default: null
				  }
			    }
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        _switchResult = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			      }
			    }
			    if (!_matched) {
			      _switchResult = null;
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchExpression_04() {
		assertCompilesTo('''
			class C {
			    def Iterable<Object> m(Object o) {
				  return switch o {
				    Boolean: return [|<Object>newArrayList().iterator]
				  	String: newArrayList('').toArray
				  	default: emptyList
				  }
			    }
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      return _function;
			    }
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        _switchResult = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			      }
			    }
			    if (!_matched) {
			      _switchResult = CollectionLiterals.<Object>emptyList();
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testTryCatchExpression_01() {
		assertCompilesTo('''
			class C {
			    def Iterable<Object> m(Object o) {
				  try {
				  	[|<Object>newArrayList().iterator]
				  } catch(Exception e) {
				  	newArrayList('').toArray
				  }
			    }
			}
		''', '''
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _xtrycatchfinallyexpression = null;
			    try {
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _xtrycatchfinallyexpression = _function;
			    } catch (final Throwable _t) {
			      if (_t instanceof Exception) {
			        _xtrycatchfinallyexpression = (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			      } else {
			        throw Exceptions.sneakyThrow(_t);
			      }
			    }
			    return _xtrycatchfinallyexpression;
			  }
			}
		''')
	}
	
	@Test
	def testNestedIfInSwitchExpression_01() {
		assertCompilesTo('''
			class C {
			    def Iterable<Object> m(Object o, boolean b) {
				  switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	default: {
				  		if (b)
				  			return newArrayList('').toArray
				  		else
				  			return #{}
				  	}
				  }
			    }
			}
		''', '''
			import java.util.Collections;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o, final boolean b) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = new Iterable<Object>() {
			        public Iterator<Object> iterator() {
			          return CollectionLiterals.<Object>newArrayList().iterator();
			        }
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (b) {
			        return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			      } else {
			        return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
}