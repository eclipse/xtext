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
class CompilerBug451814Test extends AbstractXtendCompilerTest {
	@Test
	def test_01() {
		assertCompilesTo('''
			import com.google.common.io.LineReader
			class C {
				def m() {
					var counter = 0
					var LineReader reader = null
					return counter == 0 && reader.readLine !== null
				}
			}
		''', '''
			import com.google.common.io.LineReader;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean m() {
			    try {
			      int counter = 0;
			      LineReader reader = null;
			      return ((counter == 0) && (reader.readLine() != null));
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import com.google.common.io.LineReader
			class C {
				def void m() {
					var counter = 0
					var LineReader reader = null
					if (counter == 0 && reader.readLine != null) {
					}
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import com.google.common.io.LineReader;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    try {
			      int counter = 0;
			      LineReader reader = null;
			      if (((counter == 0) && (!Objects.equal(reader.readLine(), null)))) {
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import com.google.common.io.LineReader
			class C {
				def void m() {
					var counter = 0
					var LineReader reader = null
					while (counter == 0 && reader.readLine != null) {
					}
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import com.google.common.io.LineReader;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    try {
			      int counter = 0;
			      LineReader reader = null;
			      while (((counter == 0) && (!Objects.equal(reader.readLine(), null)))) {
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import com.google.common.io.LineReader
			class C {
				def void m() {
					var LineReader reader = null
					do {} while (reader.readLine != null)
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import com.google.common.io.LineReader;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    try {
			      LineReader reader = null;
			      do {
			      } while((!Objects.equal(reader.readLine(), null)));
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
}