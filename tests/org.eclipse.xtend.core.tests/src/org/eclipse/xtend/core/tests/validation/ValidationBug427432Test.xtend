/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class ValidationBug427432Test extends AbstractXtendTestCase {
	
	@Inject 
	extension ValidationTestHelper
	
	@Inject 
	extension ParseHelper<XtendFile>
	
	@Test def void finalInstanceField() {
		'''
			class Foo {
			
				val x = 1
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}
	
	@Test def void finalInstanceField_2() {
		'''
			class Foo {
			
				val int x
				
				new() {
					x = 1
				}
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void finalInstanceField_3() {
		'''
			class Foo {
			
				val int x = bar()
			
				def bar() {
					1
				}
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void notFinalInstanceField() {
		'''
			class Foo {
			
				var x = 1
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void finalStaticField() {
		'''
			class Foo {
			
				static val x = 1
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}
	
	@Test def void finalStaticField_2() {
		'''
			import org.eclipse.xtend.core.tests.validation.Bar
			
			class Foo {
			
				def foo() {
					switch y : 1 {
						case Bar.STATIC_FINAL_WITH_CONSTANT_INITIALIZATION: 1
						case Bar.STATIC_FINAL_WITH_CONSTANT_INITIALIZATION: 1
					}
				}
			
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}
	
	@Test def void notFinalStaticField() {
		'''
			class Foo {
			
				static int x = 1
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void notFinalStaticField_2() {
		'''
			import org.eclipse.xtend.core.tests.validation.Bar
			
			class Foo {
			
				def foo() {
					switch y : 1 {
						case Bar.NOT_FINAL_STATIC_WITH_CONSTANT_INITIALIZATION: 1
						case Bar.NOT_FINAL_STATIC_WITH_CONSTANT_INITIALIZATION: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void finalStaticFieldWithNotConstantInitialization() {
		'''
			class Foo {
			
				static val x = bar
			
				def foo() {
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
				
				static def bar() {
					1
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void finalStaticFieldWithNotConstantInitialization_2() {
		'''
			import org.eclipse.xtend.core.tests.validation.Bar
			
			class Foo {
			
				def foo() {
					switch y : 1 {
						case Bar.STATIC_FINAL_WITH_NOT_CONSTANT_INITIALIZATION: 1
						case Bar.STATIC_FINAL_WITH_NOT_CONSTANT_INITIALIZATION: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void finalStaticFieldWithoutInitialization() {
		'''
			import org.eclipse.xtend.core.tests.validation.Bar
			
			class Foo {
			
				def foo() {
					switch y : 1 {
						case Bar.STATIC_FINAL_WITHOUT_INITIALIZATION: 1
						case Bar.STATIC_FINAL_WITHOUT_INITIALIZATION: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void finalVariable() {
		'''
			class Foo {
			
				def foo() {
					val x = 1
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}
	
	@Test def void finalVariableWithNotConstantInitialization() {
		'''
			class Foo {
			
				def foo() {
					val x = bar
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
				def bar() {
					1
				}
			
			}
		'''.parse.assertNoErrors
	}
	
	@Test def void notFinalVariable() {
		'''
			class Foo {
			
				def foo() {
					var int x
					switch y : 1 {
						case x: 1
						case x: 1
					}
				}
			
			}
		'''.parse.assertNoErrors
	}
	
}