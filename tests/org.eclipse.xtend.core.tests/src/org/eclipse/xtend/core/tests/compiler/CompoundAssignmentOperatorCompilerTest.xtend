/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test
import org.junit.Ignore

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class CompoundAssignmentOperatorCompilerTest extends AbstractXtendCompilerTest {

	@Test def void test_1() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {

				def foo() {
					var i = 2
					i += i *= 2
					i
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _multiplyAssign = i = _i_1 *= 2;
			      i = _i += _multiplyAssign;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_2() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {

				def foo() {
					var i = 2
					i *= i += 2
					i
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _add = i = _i_1 += 2;
			      i = _i *= _add;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_3() {
		'''
			class Foo {

				def foo() {
					var i = 2
					i += i *= 2
					i
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _multiply = i = (_i_1 * 2);
			      i = (_i + _multiply);
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_4() {
		'''
			class Foo {

				def foo() {
					var i = 2
					i *= i += 2
					i
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _plus = i = (_i_1 + 2);
			      i = (_i * _plus);
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_5() {
		'''
			import static extension compound.IntCompoundExtensions.*

			class Foo {

				def foo() {
					var i = 2
					i *= i -= 2
					i
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _minus = i = (_i_1 - 2);
			      i = _i *= _minus;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_6() {
		'''
			import static extension compound.IntCompoundExtensions.*

			class Foo {

				def foo() {
					var i = 2
					i -= i *= 2
					i
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _multiplyAssign = i = _i_1 *= 2;
			      i = (_i - _multiplyAssign);
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_7() {
		'''
			import static extension compound.IntCompoundExtensions.*

			class Foo {
			
				def foo() {
					var i = 2
					i *= i /= i -= 2
					i
				}
			
			}
		'''.assertCompilesTo(
		'''
			import compound.IntCompoundExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _i_2 = i;
			      int _minus = i = (_i_2 - 2);
			      int _divideAssign = i = IntCompoundExtensions.operator_divideAssign(_i_1, _minus);
			      i = _i *= _divideAssign;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_8() {
		'''
			import static extension compound.IntCompoundExtensions.*

			class Foo {
			
				def foo() {
					var i = 2
					i *= i %= i -= 2
					i
				}
			
			}
		'''.assertCompilesTo(
		'''
			import compound.IntCompoundExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _i_2 = i;
			      int _minus = i = (_i_2 - 2);
			      int _modulo = i = IntCompoundExtensions.operator_modulo(_i_1, _minus);
			      i = _i *= _modulo;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_9() {
		'''
			class Foo {
			
				def foo() {
					var i = 2
					i *= 2
					i
				}
			
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      i = (_i * 2);
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_10() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
			
				def foo() {
					var i = 2
					i *= 2
					i
				}
			
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      i = _i *= 2;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void test_11() {
		'''
			class Foo {
			
				def foo() {
					var i = 2
					i += (3 + (i *= 2))
					i
				}
			
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _multiply = i = (_i_1 * 2);
			      int _plus = (3 + _multiply);
			      i = (_i + _plus);
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void test_12() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
			
				def foo() {
					var i = 2
					i += (3 + (i *= 2))
					i
				}
			
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    int _xblockexpression = (int) 0;
			    {
			      int i = 2;
			      int _i = i;
			      int _i_1 = i;
			      int _multiplyAssign = i = _i_1 *= 2;
			      int _plus = (3 + _multiplyAssign);
			      i = _i += _plus;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Ignore
	@Test def void test_13() {
		'''
			class Foo {
				var i = 2
				def foo() {
					i += 2
				}
			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  private int i = 2;
			  
			  public int foo() {
			  	// method body is bogus, the field should be assigned somewhere in this code
			    int _i = this.i;
			    return (_i + 2);
			  }
			}
		''')
	}
}
