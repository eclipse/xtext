/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class CompilerXtendIssue230Test extends AbstractXtendCompilerTest {
	
	@Test def void testIssue230() {
		assertCompilesTo("
		package b
		
		import org.eclipse.xtend.lib.annotations.Accessors
		
		class MyTest {
			
			@Accessors
			static class A1 {String name}
			@Accessors
			static class A2 {String name}
			
			def doItWithNumber(Object n) '''
			«IF n instanceof A1»
				A1: «n.name»
			«ELSEIF n instanceof A2»
				A2: «n.name»
			«ELSE»
				Else: «n»
			«ENDIF»
			'''
		}
		", '''
		package b;
		
		import org.eclipse.xtend.lib.annotations.Accessors;
		import org.eclipse.xtend2.lib.StringConcatenation;
		import org.eclipse.xtext.xbase.lib.Pure;
		
		@SuppressWarnings("all")
		public class MyTest {
		  @Accessors
		  public static class A1 {
		    private String name;
		
		    @Pure
		    public String getName() {
		      return this.name;
		    }
		
		    public void setName(final String name) {
		      this.name = name;
		    }
		  }
		
		  @Accessors
		  public static class A2 {
		    private String name;
		
		    @Pure
		    public String getName() {
		      return this.name;
		    }
		
		    public void setName(final String name) {
		      this.name = name;
		    }
		  }
		
		  public CharSequence doItWithNumber(final Object n) {
		    StringConcatenation _builder = new StringConcatenation();
		    {
		      if ((n instanceof MyTest.A1)) {
		        _builder.append("A1: ");
		        _builder.append(((MyTest.A1)n).name);
		        _builder.newLineIfNotEmpty();
		      } else {
		        if ((n instanceof MyTest.A2)) {
		          _builder.append("A2: ");
		          _builder.append(((MyTest.A2)n).name);
		          _builder.newLineIfNotEmpty();
		        } else {
		          _builder.append("Else: ");
		          _builder.append(n);
		          _builder.newLineIfNotEmpty();
		        }
		      }
		    }
		    return _builder;
		  }
		}
		''')
	}
	
}