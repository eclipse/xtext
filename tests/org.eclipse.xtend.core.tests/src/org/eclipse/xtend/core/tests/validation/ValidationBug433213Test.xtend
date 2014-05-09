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
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XBlockExpression
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValidationBug433213Test extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			class C {
				def m() {
					new Object {
						def <T> T m2() {}
					}
				}
			}
		''')
		val c = file.xtendTypes.head
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val anon = body.expressions.head as AnonymousClass
		val m2 = anon.members.head as XtendFunction
		val returnType = m2.returnType
		val t = returnType.type
		assertNotNull('notNull', t)
		assertFalse('t.eIsProxy', t.eIsProxy)
		helper.assertNoErrors(file)
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			class C {
				def <T> m() {
					new Object {
						def T m2() {}
					}
				}
			}
		''')
		val c = file.xtendTypes.head
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val anon = body.expressions.head as AnonymousClass
		val m2 = anon.members.head as XtendFunction
		val returnType = m2.returnType
		val t = returnType.type
		assertNotNull('notNull', t)
		assertFalse('t.eIsProxy', t.eIsProxy)
		helper.assertNoErrors(file)
	}
	
	@Test def void test_03() {
		val file = parser.parse('''
			class C {
				def m() {
					new Object {
						def m2() {
							new Object {
								def <T> T m3() {}
							}
						}
					}
				}
			}
		''')
		val c = file.xtendTypes.head
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val anon = body.expressions.head as AnonymousClass
		val m2 = anon.members.head as XtendFunction
		val body2 = m2.expression as XBlockExpression
		val anon2 = body2.expressions.head as AnonymousClass
		val m3 = anon2.members.head as XtendFunction
		val returnType = m3.returnType
		val t = returnType.type
		assertNotNull('notNull', t)
		assertFalse('t.eIsProxy', t.eIsProxy)
		helper.assertNoErrors(file)
	}
	
	@Test def void test_04() {
		val file = parser.parse('''
			class C {
				def m() {
					new Object {
						def <T> m2() {
							new Object {
								def T m3() {}
							}
						}
					}
				}
			}
		''')
		val c = file.xtendTypes.head
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val anon = body.expressions.head as AnonymousClass
		val m2 = anon.members.head as XtendFunction
		val body2 = m2.expression as XBlockExpression
		val anon2 = body2.expressions.head as AnonymousClass
		val m3 = anon2.members.head as XtendFunction
		val returnType = m3.returnType
		val t = returnType.type
		assertNotNull('notNull', t)
		assertFalse('t.eIsProxy', t.eIsProxy)
		helper.assertNoErrors(file)
	}
	
	@Test def void test_05() {
		val file = parser.parse('''
			class C {
				def <T> m() {
					new Object {
						def m2() {
							new Object {
								def T m3() {}
							}
						}
					}
				}
			}
		''')
		val c = file.xtendTypes.head
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val anon = body.expressions.head as AnonymousClass
		val m2 = anon.members.head as XtendFunction
		val body2 = m2.expression as XBlockExpression
		val anon2 = body2.expressions.head as AnonymousClass
		val m3 = anon2.members.head as XtendFunction
		val returnType = m3.returnType
		val t = returnType.type
		assertNotNull('notNull', t)
		assertFalse('t.eIsProxy', t.eIsProxy)
		helper.assertNoErrors(file)
	}
	
	@Test def void test_06() {
		val file = parser.parse('''
			class C {
				def <K> m() {
					new Object {
						def <V> m2() {
							new java.util.AbstractMap<K, V> {
								def Entry<K, V> m() {}
								override entrySet() {}
							}
						}
					}
				}
			}
		''')
		val c = file.xtendTypes.head
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val anon = body.expressions.head as AnonymousClass
		val m2 = anon.members.head as XtendFunction
		val body2 = m2.expression as XBlockExpression
		val anon2 = body2.expressions.head as AnonymousClass
		val m3 = anon2.members.head as XtendFunction
		val returnType = m3.returnType
		val t = returnType.type
		assertNotNull('notNull', t)
		assertFalse('t.eIsProxy', t.eIsProxy)
		helper.assertNoErrors(file)
	}
	
}