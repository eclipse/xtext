/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug342021Test extends AbstractXtendCompilerTest {
	
	@Test def testIfExpression_01() {
		'''
			class C {
				def Iterable<Object> m(String s) {
					if (true) 
						[|<Object>newArrayList().iterator]
					else
						newArrayList(s).toArray
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final String s) {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xifexpression = _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(s);
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def testIfExpression_02() {
		'''
			class C {
				def Iterable<Object> m() {
					return if (true) 
						[|<Object>newArrayList().iterator]
					else
						newArrayList('').toArray
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xifexpression = _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def testIfExpression_03() {
		'''
			class C {
				def Iterable<Object> m() {
					if (true) 
						return [|<Object>newArrayList().iterator]
					else
						return newArrayList('').toArray
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      return _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			  }
			}
		''')
	}
	
	@Test def testIfExpression_04() {
		'''
			class C {
				def Iterable<Object> m() {
					if (true) 
						return [|<Object>newArrayList().iterator]
					else
						newArrayList('').toArray
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Object[] _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      return _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      _xifexpression = _newArrayList.toArray();
			    }
			    return (Iterable<Object>)Conversions.doWrapArray(_xifexpression);
			  }
			}
		''')
	}
	
	@Test def testIfExpression_05() {
		'''
			class C {
				def Iterable<Object> m() {
					if (true) 
						[|<Object>newArrayList().iterator]
					else
						return newArrayList('').toArray
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xifexpression = _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def testIfExpression_06() {
		'''
			class C {
				def Iterable<Object> m(String s) {
					if (true) 
						{ [| { <Object>newArrayList().iterator } ] }
					else
						{ { newArrayList(s).toArray } }
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final String s) {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xifexpression = _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(s);
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def testIfExpression_07() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xifexpression = _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      _xifexpression = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def testIfExpression_08() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      return _function;
			    } else {
			      return (Iterable<Object>)Conversions.doWrapArray(CollectionLiterals.<String>newArrayList("").toArray());
			    }
			  }
			}
		''')
	}
	
	@Test def testIfExpression_09() {
		'''
			class C {
				def Iterable<Object> m() {
					if (true) 
						{ return { [|<Object>newArrayList().iterator] } }
					else
						{ newArrayList('').toArray }
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Object[] _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      return _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      _xifexpression = _newArrayList.toArray();
			    }
			    return (Iterable<Object>)Conversions.doWrapArray(_xifexpression);
			  }
			}
		''')
	}
	
	@Test def testIfExpression_10() {
		'''
			class C {
				def Iterable<Object> m() {
					if (true) 
						{ [|<Object>newArrayList().iterator] }
					else
						{ return newArrayList('').toArray }
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    Iterable<Object> _xifexpression = null;
			    if (true) {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xifexpression = _function;
			    } else {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def testIfExpression_11() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
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
			          final Iterable<Object> _function = () -> {
			            ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			            return _newArrayList.iterator();
			          };
			          _xblockexpression_1 = _function;
			        }
			        _xifexpression = _xblockexpression_1;
			      } else {
			        Object[] _xblockexpression_2 = null;
			        {
			          this.toString();
			          ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(s);
			          _xblockexpression_2 = _newArrayList.toArray();
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
	
	@Test def testIfExpression_12() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
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
			          final Iterable<Object> _function = () -> {
			            ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			            return _newArrayList.iterator();
			          };
			          _xblockexpression_1 = _function;
			        }
			        _xifexpression = _xblockexpression_1;
			      } else {
			        Object[] _xblockexpression_2 = null;
			        {
			          this.toString();
			          ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			          _xblockexpression_2 = _newArrayList.toArray();
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
	
	@Test def testIfExpression_13() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m() {
			    this.toString();
			    if (true) {
			      this.toString();
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      return _function;
			    } else {
			      this.toString();
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			  }
			}
		''')
	}
	
	@Test def testIfExpression_14() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
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
			        final Iterable<Object> _function = () -> {
			          ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			          return _newArrayList.iterator();
			        };
			        return _function;
			      } else {
			        Object[] _xblockexpression_1 = null;
			        {
			          this.toString();
			          ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			          _xblockexpression_1 = _newArrayList.toArray();
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
	
	@Test def testIfExpression_15() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
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
			          final Iterable<Object> _function = () -> {
			            ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			            return _newArrayList.iterator();
			          };
			          _xblockexpression_1 = _function;
			        }
			        _xifexpression = _xblockexpression_1;
			      } else {
			        this.toString();
			        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			        return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def testSwitchExpression_01() {
		'''
			class C {
			    def Iterable<Object> m(Object o) {
				  switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	default: newArrayList('').toArray
				  }
			    }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			      _switchResult = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test def testSwitchExpression_02() {
		'''
			class C {
			    def Iterable<Object> m(Object o) {
				  switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	String: return newArrayList('').toArray
				  }
			    }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			        return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test def testSwitchExpression_03() {
		'''
			class C {
			    def Iterable<Object> m(Object o) {
				  return switch o {
				    Boolean: [|<Object>newArrayList().iterator]
				  	String: newArrayList('').toArray
				  	default: null
				  }
			    }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			        _switchResult = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
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
	
	@Test def testSwitchExpression_04() {
		'''
			class C {
			    def Iterable<Object> m(Object o) {
				  return switch o {
				    Boolean: return [|<Object>newArrayList().iterator]
				  	String: newArrayList('').toArray
				  	default: emptyList
				  }
			    }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      return _function;
			    }
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			        _switchResult = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
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
	
	@Test def testTryCatchExpression_01() {
		'''
			class C {
			    def Iterable<Object> m(Object o) {
				  try {
				  	[|<Object>newArrayList().iterator]
				  } catch(Exception e) {
				  	newArrayList('').toArray
				  }
			    }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o) {
			    Iterable<Object> _xtrycatchfinallyexpression = null;
			    try {
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _xtrycatchfinallyexpression = _function;
			    } catch (final Throwable _t) {
			      if (_t instanceof Exception) {
			        final Exception e = (Exception)_t;
			        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			        _xtrycatchfinallyexpression = (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
			      } else {
			        throw Exceptions.sneakyThrow(_t);
			      }
			    }
			    return _xtrycatchfinallyexpression;
			  }
			}
		''')
	}
	
	@Test def testNestedIfInSwitchExpression_01() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.Collections;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Object> m(final Object o, final boolean b) {
			    Iterable<Object> _switchResult = null;
			    boolean _matched = false;
			    if (o instanceof Boolean) {
			      _matched=true;
			      final Iterable<Object> _function = () -> {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        return _newArrayList.iterator();
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (b) {
			        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("");
			        return (Iterable<Object>)Conversions.doWrapArray(_newArrayList.toArray());
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