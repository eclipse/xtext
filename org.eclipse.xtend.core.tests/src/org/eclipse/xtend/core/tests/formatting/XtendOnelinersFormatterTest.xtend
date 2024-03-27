/*******************************************************************************
 * Copyright (c) 2014, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendOnelinersFormatterTest extends AbstractFormatterTest {

	@Test def formatEmptyMethod1() {
		assertUnformattedEqualsFormatted('''
			class C {
				def m() {
				}
			}
		''')
	}

	@Test def formatEmptyMethod2() {
		'''
			class C {
				def m() {
				}
			}
		'''.assertUnformattedEqualsFormatted[put(keepOneLineMethods, true)]
	}

	@Test def formatEmptyMethod3() {
		'''
			class C {
				def m() {}
			}
		'''.assertFormattedTo(
		'''
			class C {
				def m() {
				}
			}
		''', [put(keepOneLineMethods, false)])
	}

	@Test def formatEmptyMethod4() {
		'''
			class C {
				def m() {          }
			}
		'''.assertFormattedTo('''
			class C {
				def m() {}
			}
		''', [put(keepOneLineMethods, true)])
	}

	@Test def formatMethodWithJustAComment1() {
		assertUnformattedEqualsFormatted('''
			class C {
				def m() {
					/*foo*/
				}
			}
		''')
	}

	@Test def formatMethodWithJustAComment2() {
		'''
			class C {
				def m() {
					/*foo*/
				}
			}
		'''.assertUnformattedEqualsFormatted[put(keepOneLineMethods, true)]
	}

	@Ignore("Another manifestation of Bug 415950")
	@Test def formatMethodWithJustAComment3() {
		'''
			class C {
				def m() { /*foo*/ }
			}
		'''.assertFormattedTo(
		'''
			class C {
				def m() {
					/*foo*/
				}
			}
		''')
	}

	@Test def formatMethodWithJustAComment4() {
		'''
			class C {
				def m() {     /*foo*/          }
			}
		'''.assertFormattedTo('''
			class C {
				def m() { /*foo*/ }
			}
		''', [put(keepOneLineMethods, true)])
	}

	@Test def formatMethodWithOneExpression1() {
		assertUnformattedEqualsFormatted('''
			class C {
				def m() {
					"Foo"
				}
			}
		''')
	}

	@Test def formatMethodWithOneExpression2() {
		'''
			class C {
				def m() {
					"Foo"
				}
			}
		'''.assertUnformattedEqualsFormatted[put(keepOneLineMethods, true)]
	}

	@Test def formatMethodWithOneExpression3() {
		'''
			class C {
				def m() {"Foo"}
			}
		'''.assertFormattedTo('''
			class C {
				def m() {
					"Foo"
				}
			}
		''', [put(keepOneLineMethods, false)])
	}

	@Test def formatMethodWithOneExpression4() {
		'''
			class C {
				def m() {       "Foo"     }
			}
		'''.assertFormattedTo('''
			class C {
				def m() { "Foo" }
			}
		''', [put(keepOneLineMethods, true)])
	}

	@Test def formatMethodWithTryCatchExpression() {
		'''
			class C {
				def m() {try{"Foo"} catch (Exception e) {"Bar"} }
			}
		'''.assertFormattedTo('''
			class C {
				def m() {
					try {
						"Foo"
					} catch (Exception e) {
						"Bar"
					}
				}
			}
		''', [put(keepOneLineMethods, true)])
	}

	@Test def formatMethodWithTwoExpressions1() {
		assertUnformattedEqualsFormatted('''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		''')
	}

	@Test def formatMethodWithTwoExpressions2() {
		'''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		'''.assertUnformattedEqualsFormatted[put(keepOneLineMethods, true)]
	}

	@Test def formatMethodWithTwoExpressions3() {
		'''
			class C {
				def m() {println(this) "Foo"}
			}
		'''.assertFormattedTo('''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		''')
	}

	@Test def formatMethodWithTwoExpressions4() {
		'''
			class C {
				def m() {     println(this)      "Foo"     }
			}
		'''.assertFormattedTo('''
		class C {
			def m() {
				println(this)
				"Foo"
			}
		}
		''', [put(keepOneLineMethods, true)])
	}
}