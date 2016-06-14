/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.xtend.impl

import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendInterface
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CustomNestedClassesTest extends CustomClassesTest {
	
	override protected clazz(String string) throws Exception {
		return file('''class C { «string» }''').getXtendTypes().get(0).members.head as XtendClass;
	}
	
	override protected interfaze(String string) throws Exception {
		return file('''class C { «string» }''').getXtendTypes().get(0).members.head as XtendInterface;
	}
	
	override protected enumeration(String string) throws Exception {
		return file('''class C { «string» }''').getXtendTypes().get(0).members.head as XtendEnum;
	}
	
	override protected annotationType(String string) throws Exception {
		return file('''class C { «string» }''').getXtendTypes().get(0).members.head as XtendAnnotationType;
	}
	
	@Test override testInterfaceFinalAndStatic() {
		assertFalse(interfaze('''interface Foo {}''').final)
		assertTrue(interfaze('''interface Foo {}''').static)
	}
	
	@Test override testEnumFinalAndStatic() {
		assertTrue(enumeration('''enum Foo {}''').static)
		assertTrue(enumeration('''enum Foo {}''').final)
	}
	
	@Test override testAnnotationTypeStaticAndFinal() {
		assertTrue(annotationType('''static annotation Foo {}''').static)
		assertFalse(annotationType('''final annotation Foo {}''').final)
	}
	
}