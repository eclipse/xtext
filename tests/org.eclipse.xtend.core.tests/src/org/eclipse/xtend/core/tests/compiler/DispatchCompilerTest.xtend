/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class DispatchCompilerTest extends AbstractXtendCompilerTest {
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=410329
	 */
	@Test
	def testExtensionParameters() {
		assertCompilesTo('''
			class C {
				def dispatch m(extension String s) {
					4.substring
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class C {
			  protected String _m(@Extension final String s) {
			    String _substring = s.substring(4);
			    return _substring;
			  }
			  
			  public String m(final String s) {
			    {
			      return _m(s);
			    }
			  }
			}
		''')
	}
	
}
