/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class PostfixOperatorCompilerTest extends AbstractXtendCompilerTest {

	@Test def void test_1() {
		'''
			class Foo {

				def foo() {
					var i = 2
					i++
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
			      _xblockexpression = i++;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_2() {
		'''
			class Foo {

				def foo() {
					var i = 2
					val j = i++
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
			      final int j = i++;
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
					val j = i++ + i
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
			      int _plusPlus = i++;
			      final int j = (_plusPlus + i);
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
					i--
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
			      _xblockexpression = i--;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_5() {
		'''
			class Foo {

				def foo() {
					var i = 2
					val j = i--
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
			      final int j = i--;
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_6() {
		'''
			class Foo {

				def foo() {
					var i = 2
					val j = i-- - i
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
			      int _minusMinus = i--;
			      final int j = (_minusMinus - i);
			      _xblockexpression = i;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_7() {
		'''
			class Foo {

				def foo() {
					var Integer i = 2
					i++
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public Integer foo() {
			    Integer _xblockexpression = null;
			    {
			      Integer i = Integer.valueOf(2);
			      _xblockexpression = i++;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void test_8() {
		'''
			class Foo {

				def foo() {
					var i = 2 as double
					i++
				}

			}
		'''.assertCompilesTo(
		'''
			@SuppressWarnings("all")
			public class Foo {
			  public double foo() {
			    double _xblockexpression = (double) 0;
			    {
			      double i = ((double) 2);
			      _xblockexpression = i++;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
}