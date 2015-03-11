/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug447516Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import org.eclipse.xtext.util.concurrent.IReadAccess
			class C {
				val IReadAccess<String> readAccess = [
					return it.exec('')
				]
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.util.concurrent.IReadAccess;
			import org.eclipse.xtext.util.concurrent.IUnitOfWork;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  private final IReadAccess<String> readAccess = new IReadAccess<String>() {
			    @Override
			    public <T extends Object> T readOnly(final IUnitOfWork<T, String> it) {
			      try {
			        return it.exec("");
			      } catch (Throwable _e) {
			        throw Exceptions.sneakyThrow(_e);
			      }
			    }
			  };
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import org.eclipse.xtext.util.concurrent.IReadAccess
			class C {
				val I<CharSequence> readAccess = [
					return it.apply('')
				]
				
				interface I<P> {
					def <T extends P> T exec((P)=>T arg)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface I<P extends Object> {
			    public abstract <T extends P> T exec(final Function1<? super P, ? extends T> arg);
			  }
			  
			  private final C.I<CharSequence> readAccess = new C.I<CharSequence>() {
			    @Override
			    public <T extends CharSequence> T exec(final Function1<? super CharSequence, ? extends T> it) {
			      return it.apply("");
			    }
			  };
			}
		''')
	}
	
	@Test def test_03() {
		'''
			import org.eclipse.xtext.util.concurrent.IReadAccess
			class C {
				val I<CharSequence, String> i = [
					return $1.apply('')
				]
				
				interface I<P, W extends P> {
					def <T extends P, V extends T> T exec(W w, (P)=>T arg)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface I<P extends Object, W extends P> {
			    public abstract <T extends P, V extends T> T exec(final W w, final Function1<? super P, ? extends T> arg);
			  }
			  
			  private final C.I<CharSequence, String> i = new C.I<CharSequence, String>() {
			    @Override
			    public <T extends CharSequence, V extends T> T exec(final String $0, final Function1<? super CharSequence, ? extends T> $1) {
			      return $1.apply("");
			    }
			  };
			}
		''')
	}
	
}