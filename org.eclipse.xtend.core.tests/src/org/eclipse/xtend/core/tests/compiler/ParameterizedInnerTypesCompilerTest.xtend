/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
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
class ParameterizedInnerTypesCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  Either<Integer, Boolean> either;
			
			  def m() {
			    either.right().get();
			  }
			}
		''', '''
			import bug417675.Either;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  private Either<Integer, Boolean> either;
			
			  public Boolean m() {
			    return this.either.right().get();
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  Either<Integer, Boolean> either;
			
			  def m() {
			    either.left().get();
			  }
			}
		''', '''
			import bug417675.Either;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  private Either<Integer, Boolean> either;
			
			  public Integer m() {
			    return this.either.left().get();
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  def m(Either<Integer, Boolean> it) {
			    right().on [ intValue == 0 ]
			  }
			}
		''', '''
			import bug417675.Either;
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Boolean m(final Either<Integer, Boolean> it) {
			    final Function<Integer, Boolean> _function = new Function<Integer, Boolean>() {
			      public Boolean apply(final Integer it_1) {
			        int _intValue = it_1.intValue();
			        return Boolean.valueOf((_intValue == 0));
			      }
			    };
			    return it.right().on(_function);
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  def m(Either<Integer, Boolean> it) {
			    left().either().right()
			  }
			}
		''', '''
			import bug417675.Either;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Either<Integer, Boolean>.RightProjection m(final Either<Integer, Boolean> it) {
			    return it.left().either().right();
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  def m(Either<Integer, Boolean> it) {
			    left().iterator().next
			  }
			}
		''', '''
			import bug417675.Either;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Integer m(final Either<Integer, Boolean> it) {
			    return it.left().iterator().next();
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  def m(Either<Integer, Boolean> it) {
			    map [ toString ].swap
			  }
			}
		''', '''
			import bug417675.Either;
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Either<String, Integer> m(final Either<Integer, Boolean> it) {
			    final Function<Boolean, String> _function = new Function<Boolean, String>() {
			      public String apply(final Boolean it_1) {
			        return it_1.toString();
			      }
			    };
			    return it.<String>map(_function).swap();
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  def m() {
			    val either = Either.left('')
			    val String s = either.right().get
			    return either
			  }
			}
		''', '''
			import bug417675.Either;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Either<String, String> m() {
			    final Either<String, String> either = Either.<String, String>left("");
			    final String s = either.right().get();
			    return either;
			  }
			}
		''')
	}
	
	@Test
	def test_08() {
		assertCompilesTo('''
			import bug417675.*
			class EitherTest {
			  def m() {
			    val either = Either.left('')
			    val int i = either.swap().left().iterator().next
			    return either
			  }
			}
		''', '''
			import bug417675.Either;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Either<String, Integer> m() {
			    final Either<String, Integer> either = Either.<String, Integer>left("");
			    final int i = (either.swap().left().iterator().next()).intValue();
			    return either;
			  }
			}
		''')
	}
	
}