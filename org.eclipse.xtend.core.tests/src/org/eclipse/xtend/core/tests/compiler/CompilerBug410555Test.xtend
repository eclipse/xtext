/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug410555Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			interface SAMInterface {
				def void test()
			}
			class BugSAM {
				new(SAMInterface e) {
				}
				def static void main(String[] args) {
					// seems ok
					new BugSAM([|])
				}
			}
			class BugSAM2 extends BugSAM {
				new() {
					super([|])
				}
			}
		''', '''
			@SuppressWarnings("all")
			public interface SAMInterface {
			  void test();
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class BugSAM2 extends BugSAM {
				new() {
					super([|])
				}
			}
			interface SAMInterface {
				def void test()
			}
			class BugSAM {
				new(SAMInterface e) {
				}
				def static void main(String[] args) {
					// seems ok
					new BugSAM([|])
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugSAM2 extends BugSAM {
			  public BugSAM2() {
			    super(new SAMInterface() {
			      public void test() {
			      }
			    });
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class BugSAM {
				new(SAMInterface e) {
				}
				new() {
					this [|]
				}
				def static void main(String[] args) {
					new BugSAM([|])
				}
			}
			interface SAMInterface {
				def void test()
			}
			class BugSAM2 extends BugSAM {
				new() {
					super([|])
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugSAM {
			  public BugSAM(final SAMInterface e) {
			  }
			
			  public BugSAM() {
			    this(new SAMInterface() {
			      public void test() {
			      }
			    });
			  }
			
			  public static void main(final String[] args) {
			    final SAMInterface _function = new SAMInterface() {
			      public void test() {
			      }
			    };
			    new BugSAM(_function);
			  }
			}
		''')
	}
}