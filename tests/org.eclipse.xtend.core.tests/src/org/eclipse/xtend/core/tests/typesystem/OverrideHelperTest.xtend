/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper
import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class OverrideHelperTest extends AbstractXtendTestCase {
	
	@Inject
	extension OverrideHelper overrideHelper
	
	@Inject
	extension IJvmModelAssociations
	
	@Test def checkFindOverriddenOperation_01() {
		val xtendFile = fileWithErrors('''
			package foo

			import java.util.List
			import java.util.Map
			import java.util.Set
			
			class Foo extends Bar {
				
				override bar(List<Object> list, 
					Map<Object, Object> map,
					var List<Object> blabla = null
					Set<Object> set
				) {
					super.bar(list, map, set)
				}
				
			}
			
			class Bar {
				def void bar(List<Object> list, 
					Map<Object, Object> map, 
					Set<Object> set
				) {
					
				}
			}
		''')
		
		val operation = xtendFile.xtendTypes.head.members.filter(XtendFunction).head.getPrimaryJvmElement as JvmOperation
		assertNull(operation.findOverriddenOperation)
	}
	
	@Test def checkFindOverriddenOperation_02() {
		val xtendFile = file('''
			package foo

			import java.util.List
			import java.util.Map
			import java.util.Set
			
			class Foo extends Bar {
				
				override bar(List<Object> list, 
					Map<Object, Object> map,
					Set<Object> set
				) {
					super.bar(list, map, set)
				}
				
			}
			
			class Bar {
				def void bar(List<Object> list, 
					Map<Object, Object> map, 
					Set<Object> set
				) {
					
				}
			}
		''')
		
		val operation = xtendFile.xtendTypes.head.members.filter(XtendFunction).head.getPrimaryJvmElement as JvmOperation
		assertNotNull(operation.findOverriddenOperation)
	}
	
	@Test def checkFindOverriddenOperation_03() {
		val xtendFile = file('''
			package foo

			import java.util.Map
			
			class Foo implements Bar {

				override bar(Map<?, ?> map) {}

			}
			
			interface Bar {
				def void bar(Map<?, ?> map)
			}
		''')
		
		val operation = xtendFile.xtendTypes.head.members.filter(XtendFunction).head.getPrimaryJvmElement as JvmOperation
		assertNotNull(operation.findOverriddenOperation)
	}
	
	@Test def checkFindOverriddenOperation_04() {
		val xtendFile = file('''
			package foo
			
			class Foo implements Bar {
			
				override bar(T<?> map) {
				}
			
			}
			
			interface Bar {
				def void bar(T<?> map)
			}

			class T<E extends CharSequence> {}
		''')
		
		val operation = xtendFile.xtendTypes.head.members.filter(XtendFunction).head.getPrimaryJvmElement as JvmOperation
		assertNotNull(operation.findOverriddenOperation)
	}
	
}