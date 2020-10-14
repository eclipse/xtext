/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(DomainmodelInjectorProvider)
class DomainmodelParsingTest{

	@Inject extension ParseHelper<DomainModel>
	@Inject extension ValidationTestHelper
	@Inject extension IJvmModelAssociations

	@Test def void testParsing() throws Exception {
		val model = '''
			package example {
			  entity MyEntity {
			    property : String
			  }
			}
		'''.parse

		val pack = model.elements.head as PackageDeclaration
		Assert.assertEquals("example", pack.name)

		val entity = pack.elements.head as Entity
		Assert.assertEquals("MyEntity", entity.name)

		val property = entity.features.head as Property
		Assert.assertEquals("property", property.name)
		Assert.assertEquals("java.lang.String", property.type.identifier)
	}

	@Test def void testJvmTypeReferencesValidator() throws Exception {
		'''
			import java.util.List
			package example {
			  entity MyEntity {
			    p : List<int>
			  }
			}
		'''.parse.assertError(
			TypesPackage.Literals.JVM_TYPE_REFERENCE,
			IssueCodes.INVALID_USE_OF_TYPE,
			"The primitive 'int' cannot be a type argument"
		)
	}

	@Test def void testParsingAndLinking() throws Exception {
		'''
			package example {
			  entity MyEntity {
			    property : String
			    op foo(String s) : String {
			    	this.property = s
			    	return s.toUpperCase
			    }
			  }
			}
		'''.parse.assertNoErrors
	}

	@Test def void testParsingAndLinkingWithImports() throws Exception {
		'''
			import java.util.List
			package example {
			  entity MyEntity {
			    p : List<String>
			  }
			}
		'''.parse.assertNoErrors
	}

	@Test def void testReturnTypeInference() throws Exception {
		val model = '''
			package example {
			  entity MyEntity {
			    property : String
			    op foo(String s) {
			    	return property.toUpperCase + s
			    }
			  }
			}
		'''.parse
		val pack = model.elements.head as PackageDeclaration
		val entity = pack.elements.head as Entity
		val op = entity.features.last as Operation
		val method = op.jvmElements.head as JvmOperation
		Assert.assertEquals("String", method.returnType.simpleName)
	}
}
