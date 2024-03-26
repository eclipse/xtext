/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test

/**
 * @author Didier Vojtisek - Initial contribution and API
 */
class InsertParameterTest extends AbstractActiveAnnotationTest {

	@Test def void testInsertIndex0() {
		'''
			@org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno(classRef=String) 
			class MyStringHelper {
				
				static def String concat(String stringParam_1) {
				  		_self.concat(stringParam_1) 
				  	}
				  	static def String concat2(String stringParam_1, String stringParam_2) {
				  		_self + stringParam_1 + stringParam_2
				  	}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno;
			
			@InsertParameterMiniHelperAnno(classRef = String.class)
			@SuppressWarnings("all")
			public class MyStringHelper {
			  public static String concat(final String _self, final String stringParam_1) {
			    return _self.concat(stringParam_1);
			  }
			
			  public static String concat2(final String _self, final String stringParam_1, final String stringParam_2) {
			    return ((_self + stringParam_1) + stringParam_2);
			  }
			}
		''')
	}

	@Test def void testInsertIndex1() {
		'''
			@org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno(classRef=String, position=1) 
			class MyStringHelper {
				
				static def String concat(String stringParam_1) {
				  		_self.concat(stringParam_1) 
				  	}
				  	static def String concat2(String stringParam_1, String stringParam_2) {
				  		_self + stringParam_1 + stringParam_2
				  	}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno;
			
			@InsertParameterMiniHelperAnno(classRef = String.class, position = 1)
			@SuppressWarnings("all")
			public class MyStringHelper {
			  public static String concat(final String stringParam_1, final String _self) {
			    return _self.concat(stringParam_1);
			  }
			
			  public static String concat2(final String stringParam_1, final String _self, final String stringParam_2) {
			    return ((_self + stringParam_1) + stringParam_2);
			  }
			}
		''')
	}

	@Test def void testInsertIndexOutOfBound() {
		'''
			@org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno(classRef=String, position=2) 
			class MyStringHelper {
				
				static def String concat(String stringParam_1) {
				  		_self.concat(stringParam_1) 
				  	}
				  	static def String concat2(String stringParam_1, String stringParam_2) {
				  		_self + stringParam_1 + stringParam_2
				  	}
			}
		'''.compile [
			val problems = allProblems
			assertEquals(problems.map[message].toString, 1, problems.size)
			val messageJava = '''Error during annotation processing:
				org.eclipse.emf.common.util.AbstractEList$BasicIndexOutOfBoundsException: index=2, size=1
			'''.toString
			if (problems.head.message.startsWith(messageJava)) {
				fail('''
					Expected the following problem message:
					
					«messageJava»
					
					But got:
					
					«problems.head.message»
				''')
			}
		]
	}

}

@Active(InsertParameterMiniHelperAnnoProcessor)
annotation InsertParameterMiniHelperAnno {
	Class<?> classRef;
	int position = 0;
}

class InsertParameterMiniHelperAnnoProcessor extends AbstractClassProcessor {
	override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
		val annotClassName = clazz.annotations.findFirst [ a |
			a.annotationTypeDeclaration.simpleName == InsertParameterMiniHelperAnno.simpleName && a.getClassValue("classRef") !== null
		]?.getClassValue("classRef")
		val position = clazz.annotations.findFirst [ a |
			a.annotationTypeDeclaration.simpleName == InsertParameterMiniHelperAnno.simpleName
		].getIntValue("position")
		for (m : clazz.declaredMethods) {
			m.addParameter(position, "_self", annotClassName)
		}
	}
}
