/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*

class XtendOnelinersFormatterTest extends AbstractXtendFormatterTest {
	
	@Test def void formatEmptyMethod1() {
		assertFormatted('''
			class C {
				def m() {
				}
			}
		''')
	}
	
	@Test def void formatEmptyMethod2() {
		assertFormatted([
			put(keepOneLineMethods, true)
		],'''
			class C {
				def m() {
				}
			}
		''')
	}
	
	@Test def void formatEmptyMethod3() {
		assertFormatted('''
			class C {
				def m() {
				}
			}
		''',
		'''
			class C {
				def m() {}
			}
		''')
	}
	
	@Test def void formatEmptyMethod4() {
		assertFormatted([
			put(keepOneLineMethods, true)
		]
		,'''
			class C {
				def m() {}
			}
		''',
		'''
			class C {
				def m() {          }
			}
		''')
	}
	
	@Test def void formatMethodWithJustAComment1() {
	assertFormatted('''
		class C {
			def m() {
				/*foo*/
			}
		}
	''')
	}
	
	@Test def void formatMethodWithJustAComment2() {
		assertFormatted([
			put(keepOneLineMethods, true)
		],'''
			class C {
				def m() {
					/*foo*/
				}
			}
		''')
	}
	
	@Ignore("Another manifestation of Bug 415950")
	@Test def void formatMethodWithJustAComment3() {
		assertFormatted('''
			class C {
				def m() {
					/*foo*/
				}
			}
		''',
		'''
			class C {
				def m() { /*foo*/ }
			}
		''')
	}
	
	@Test def void formatMethodWithJustAComment4() {
		assertFormatted([
			put(keepOneLineMethods, true)
		]
		,'''
			class C {
				def m() { /*foo*/ }
			}
		''','''
			class C {
				def m() {     /*foo*/          }
			}
		''')
	}
	
	@Test def void formatMethodWithOneExpression1() {
		assertFormatted('''
			class C {
				def m() {
					"Foo"
				}
			}
		''')
	}
	
	@Test def void formatMethodWithOneExpression2() {
		assertFormatted([
			put(keepOneLineMethods, true)
		],'''
			class C {
				def m() {
					"Foo"
				}
			}
		''')
	}
	
	@Test def void formatMethodWithOneExpression3() {
		assertFormatted('''
			class C {
				def m() {
					"Foo"
				}
			}
		''',
		'''
			class C {
				def m() {"Foo"}
			}
		''')
	}
	
	@Test def void formatMethodWithOneExpression4() {
		assertFormatted([
			put(keepOneLineMethods, true)
		]
		,'''
			class C {
				def m() { "Foo" }
			}
		''','''
			class C {
				def m() {       "Foo"     }
			}
		''')
	}
	
	@Test def void formatMethodWithTryCatchExpression() {
		assertFormatted([
			put(keepOneLineMethods, true)
		]
		,'''
			class C {
				def m() {
					try {
						"Foo"
					} catch (Exception e) {
						"Bar"
					}
				}
			}
		''','''
			class C {
				def m() {try{"Foo"} catch (Exception e) {"Bar"} }
			}
		''')
	}
	
	@Test def void formatMethodWithTwoExpressions1() {
		assertFormatted('''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		''')
	}
	
	@Test def void formatMethodWithTwoExpressions2() {
		assertFormatted([
			put(keepOneLineMethods, true)
		],'''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		''')
	}
	
	@Test def void formatMethodWithTwoExpressions3() {
		assertFormatted('''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		''',
		'''
			class C {
				def m() {println(this) "Foo"}
			}
		''')
	}
	
	@Test def void formatMethodWithTwoExpressions4() {
		assertFormatted([
			put(keepOneLineMethods, true)
		]
		,'''
			class C {
				def m() {
					println(this)
					"Foo"
				}
			}
		''',
		'''
			class C {
				def m() {     println(this)      "Foo"     }
			}
		''')
	}
}