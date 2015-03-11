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
class CompilerBug445487Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<Lexer> lexerProvider= [return new InternalXtendLexer(null)]
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<Lexer> lexerProvider = new Provider<Lexer>() {
			    public Lexer get() {
			      return new InternalXtendLexer(null);
			    }
			  };
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<? super Lexer> lexerProvider= [return new InternalXtendLexer(null)]
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<? super Lexer> lexerProvider = new Provider<Lexer>() {
			    public Lexer get() {
			      return new InternalXtendLexer(null);
			    }
			  };
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<? extends Lexer> lexerProvider= [return new InternalXtendLexer(null)]
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<? extends Lexer> lexerProvider = new Provider<Lexer>() {
			    public Lexer get() {
			      return new InternalXtendLexer(null);
			    }
			  };
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<Lexer> lexerProvider= [|return new InternalXtendLexer(null)] as Provider<Lexer> 
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<Lexer> lexerProvider = ((Provider<Lexer>) new Provider<Lexer>() {
			      public Lexer get() {
			        return new Function0<InternalXtendLexer>() {
			          public InternalXtendLexer apply() {
			            return new InternalXtendLexer(null);
			          }
			        }.apply();
			      }
			  });
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<Lexer> lexerProvider= [|return new InternalXtendLexer(null)] as ()=>Lexer
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<Lexer> lexerProvider = new Provider<Lexer>() {
			      public Lexer get() {
			        return ((Function0<? extends Lexer>) new Function0<InternalXtendLexer>() {
			          public InternalXtendLexer apply() {
			            return new InternalXtendLexer(null);
			          }
			        }).apply();
			      }
			  };
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<Lexer> lexerProvider= [return new InternalXtendLexer(null)] as Provider<Lexer> 
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<Lexer> lexerProvider = ((Provider<Lexer>) new Provider<Lexer>() {
			      public Lexer get() {
			        return new Function1<Object, InternalXtendLexer>() {
			          public InternalXtendLexer apply(final Object it) {
			            return new InternalXtendLexer(null);
			          }
			        }.apply(null);
			      }
			  });
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			import com.google.inject.Provider
			import org.antlr.runtime.Lexer
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
			class C {
				Provider<Lexer> lexerProvider= [return new InternalXtendLexer(null)] as ()=>Lexer
			}
		''', '''
			import com.google.inject.Provider;
			import org.antlr.runtime.Lexer;
			import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  private Provider<Lexer> lexerProvider = new Provider<Lexer>() {
			      public Lexer get() {
			        return ((Function0<? extends Lexer>) new Function0<Lexer>() {
			            public Lexer apply() {
			              return new Function1<Object, InternalXtendLexer>() {
			                public InternalXtendLexer apply(final Object it) {
			                  return new InternalXtendLexer(null);
			                }
			              }.apply(null);
			            }
			        }).apply();
			      }
			  };
			}
		''')
	}
	
}