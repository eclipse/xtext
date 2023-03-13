/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class AnnotationWithNestedEnumProcessorTest extends AbstractActiveAnnotationTest {
	@Test def void testBug487559_01() {
		'''
		import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum
		
		@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum
		class Client {
			
		}
		'''.compile [
			assertTrue(allProblems.map[message].join(", "), allProblems.empty)
		]
	}
	@Test def void testBug487559_02() {
		'''
		import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum
		
		@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum
		class Client {
			
		}
		@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum(VALUE2)
		class Client2 {
			
		}
	'''.assertCompilesTo('''
	MULTIPLE FILES WERE GENERATED
	
	File 1 : /myProject/xtend-gen/Client.java
	
	import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;
	
	@AnnotationWithNestedEnum
	@SuppressWarnings("all")
	public class Client {
	}
	
	File 2 : /myProject/xtend-gen/Client2.java
	
	import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;
	
	@AnnotationWithNestedEnum(AnnotationWithNestedEnum.NestedEnum.VALUE2)
	@SuppressWarnings("all")
	public class Client2 {
	}
	
	File 3 : /myProject/xtend-gen/Client2Interface.java
	
	import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;
	
	@AnnotationWithNestedEnum(value = AnnotationWithNestedEnum.NestedEnum.VALUE2)
	@SuppressWarnings("all")
	public interface Client2Interface {
	}
	
	File 4 : /myProject/xtend-gen/ClientInterface.java
	
	import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;
	
	@AnnotationWithNestedEnum(value = AnnotationWithNestedEnum.NestedEnum.VALUE)
	@SuppressWarnings("all")
	public interface ClientInterface {
	}
	
	''')
	}
}