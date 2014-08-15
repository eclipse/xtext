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
			    Either<Integer, Boolean>.RightProjection _right = this.either.right();
			    return _right.get();
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
			    Either<Integer, Boolean>.LeftProjection _left = this.either.left();
			    return _left.get();
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
			    Either<Integer, Boolean>.RightProjection _right = it.right();
			    final Function<Integer, Boolean> _function = new Function<Integer, Boolean>() {
			      public Boolean apply(final Integer it) {
			        int _intValue = it.intValue();
			        return Boolean.valueOf((_intValue == 0));
			      }
			    };
			    return _right.on(_function);
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
			    Either<Integer, Boolean>.LeftProjection _left = it.left();
			    Either<Integer, Boolean> _either = _left.either();
			    return _either.right();
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
			import java.util.Iterator;
			
			@SuppressWarnings("all")
			public class EitherTest {
			  public Integer m(final Either<Integer, Boolean> it) {
			    Either<Integer, Boolean>.LeftProjection _left = it.left();
			    Iterator<Integer> _iterator = _left.iterator();
			    return _iterator.next();
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
			      public String apply(final Boolean it) {
			        return it.toString();
			      }
			    };
			    Either<Integer, String> _map = it.<String>map(_function);
			    return _map.swap();
			  }
			}
		''')
	}
	
}