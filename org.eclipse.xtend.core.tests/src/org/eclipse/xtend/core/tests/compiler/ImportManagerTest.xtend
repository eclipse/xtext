/*******************************************************************************
 * Copyright (c) 2020 Harald Fassler and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Harald Fassler - Initial contribution and API
 */
class ImportManagerTest extends AbstractXtendCompilerTest {

	@Test
	def testNoUnusedImport() {
		val xtendFiles = files(false, '''
			package douglas.adams.hitchhikers.guide
			
			class DeepThought {
				def theAnswer() {
					return 42
				}
			}
		''', '''
			package douglas.adams.hitchhikers.guide
			
			class AfterSevenPointFiveMillionYears {
				
				def void tellIt() {
					System.out.println(new DeepThought().theAnswer());
				}
			}
		''')
		// because both classes reside in the same package, no import statement is needed
		assertFilesCompileTo(xtendFiles, '''
			package douglas.adams.hitchhikers.guide;
			
			@SuppressWarnings("all")
			public class DeepThought {
			  public int theAnswer() {
			    return 42;
			  }
			}
		''', '''
			package douglas.adams.hitchhikers.guide;
			
			@SuppressWarnings("all")
			public class AfterSevenPointFiveMillionYears {
			  public void tellIt() {
			    System.out.println(new DeepThought().theAnswer());
			  }
			}
		''')
	}
	
	@Test
	def testRegularImport() {
		assertCompilesTo('''
			package org.eclipse.xtend.example
			class SillySingletonSet {
				def void foo() {
					val bars = java.util.Collections.singleton("bar")
				}
			}
		''', '''
			package org.eclipse.xtend.example;
			
			import java.util.Collections;
			import java.util.Set;
			
			@SuppressWarnings("all")
			public class SillySingletonSet {
			  public void foo() {
			    final Set<String> bars = Collections.<String>singleton("bar");
			  }
			}
		''')
	}
}
