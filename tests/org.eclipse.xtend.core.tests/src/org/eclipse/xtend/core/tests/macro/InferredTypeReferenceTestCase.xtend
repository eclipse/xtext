/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test

import static org.eclipse.xtend.core.tests.macro.MutableAssert.*
import static org.junit.Assert.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class InferredTypeReferencesTestCase extends AbstractActiveAnnotationTest {

	@Test def void checkInferredTypeReferences() {
		'''
			@«InferredTypeReferencesCheck.name» 
			class Foo {
			
				val foo = "foo"
			
			}
			
			interface Bar {
			
			}
		'''.assertCompilesTo(
			'''
				MULTIPLE FILES WERE GENERATED
				
				File 1 : Bar.java
				
				@SuppressWarnings("all")
				public interface Bar<T> {
				}
				
				File 2 : Foo.java
				
				import org.eclipse.xtend.core.tests.macro.InferredTypeReferencesCheck;
				
				@InferredTypeReferencesCheck
				@SuppressWarnings("all")
				public class Foo<T> {
				  private final String foo = "foo";
				  
				  public <T> String bar();
				  
				  private String bar2;
				}
				
			''')
	}

}

@Active(InferredTypeReferencesCheckProcessor)
annotation InferredTypeReferencesCheck {
}

class InferredTypeReferencesCheckProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		val type = findDeclaredField('foo').type
		assertTrue(type.inferred)

		assertThrowable(IllegalArgumentException, "Cannot use inferred type as extended class.") [ |
			extendedClass = type
		]
		assertThrowable(IllegalArgumentException, "Cannot use inferred type as implemented interface.") [ |
			implementedInterfaces = implementedInterfaces + #[type]
		]

		addMethod('bar') [
			returnType = type
			assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
				addParameter('bar', type)
			]
			assertThrowable(IllegalArgumentException, "Cannot use inferred type as exception type.") [ |
				exceptions = type
			]
			assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
				addTypeParameter('T', type)
			]
			addTypeParameter('T') => [
				assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
					upperBounds = upperBounds + #[type]
				]
			]
		]

		addField('bar2') [ field |
			field.type = type
		]

		findInterface('Bar') => [
			assertThrowable(IllegalArgumentException, "Cannot use inferred type as extended interface.") [ |
				extendedInterfaces = extendedInterfaces + #[type]
			]
			assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
				addTypeParameter('T', type)
			]
			addTypeParameter('T') => [
				assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
					upperBounds = upperBounds + #[type]
				]
			]
		]

		assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
			addTypeParameter('T', type)
		]
		addTypeParameter('T') => [
			assertThrowable(IllegalArgumentException, "Cannot use inferred type as parameter type.") [ |
				upperBounds = upperBounds + #[type]
			]
		]
	}

}
