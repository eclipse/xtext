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
class CompilerBug441096Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class C {
				@Accessors(PUBLIC_GETTER) String string
				def dispatch void m(Void expr, String seq) {
				}
				def dispatch void m(Void expr, StringBuilder seq) {
				}
				def void m(I i) {
				}
				val x = new I {
					override m() {
					}
				}
				interface I {
					def void m();
				}
			}
		''', '''
			import java.util.Arrays;
			import org.eclipse.xtend.lib.annotations.AccessorType;
			import org.eclipse.xtend.lib.annotations.Accessors;
			import org.eclipse.xtext.xbase.lib.Pure;
			
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			    public abstract void m();
			  }
			  
			  @Accessors(AccessorType.PUBLIC_GETTER)
			  private String string;
			  
			  protected void _m(final Void expr, final String seq) {
			  }
			  
			  protected void _m(final Void expr, final StringBuilder seq) {
			  }
			  
			  public void m(final C.I i) {
			  }
			  
			  private final C.I x = new C.I() {
			    public void m() {
			    }
			  };
			  
			  public void m(final Object expr, final Object seq) {
			    if (expr == null
			         && seq instanceof StringBuilder) {
			      _m((Void)null, (StringBuilder)seq);
			      return;
			    } else if (expr == null
			         && seq instanceof String) {
			      _m((Void)null, (String)seq);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(expr, seq).toString());
			    }
			  }
			  
			  @Pure
			  public String getString() {
			    return this.string;
			  }
			}
		''')
	}
	
}