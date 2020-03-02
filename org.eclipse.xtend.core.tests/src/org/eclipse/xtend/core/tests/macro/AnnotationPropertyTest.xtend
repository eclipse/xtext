/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class AnnotationPropertyTest extends AbstractActiveAnnotationTest {
	
	@Test def void testAnnotationProperty_1() {
		'''
			@org.eclipse.xtend.core.tests.macro.ToAnno()
			class C {
				
			}
		'''.assertCompilesTo('''
			MULTIPLE FILES WERE GENERATED
			
			File 1 : /myProject/xtend-gen/C.java
			
			import org.eclipse.xtend.core.tests.macro.ToAnno;
			
			@ToAnno
			@SuppressWarnings("all")
			public class C {
			}
			
			File 2 : /myProject/xtend-gen/CAnno.java
			
			@SuppressWarnings("all")
			public @interface CAnno {
			  /**
			   * Best building strategy game ever
			   */
			  public int anno() default 1602;
			}
			
		''')
	}
	
	@Test def void testAnnotationProperty_2() {
		'''
			@org.eclipse.xtend.core.tests.macro.ToAnno(defaultValue=false)
			class C {
				
			}
		'''.assertCompilesTo('''
			MULTIPLE FILES WERE GENERATED
			
			File 1 : /myProject/xtend-gen/C.java
			
			import org.eclipse.xtend.core.tests.macro.ToAnno;
			
			@ToAnno(defaultValue = false)
			@SuppressWarnings("all")
			public class C {
			}
			
			File 2 : /myProject/xtend-gen/CAnno.java
			
			@SuppressWarnings("all")
			public @interface CAnno {
			  /**
			   * Best building strategy game ever
			   */
			  public int anno();
			}
			
		''')
	}
}

@Active(ToAnnoProcessor)
@Target(TYPE)
annotation ToAnno {
	boolean defaultValue = true;
}

class ToAnnoProcessor extends AbstractClassProcessor {
	
	override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
		super.doRegisterGlobals(annotatedClass, context)
		context.registerAnnotationType(annotatedClass.generatedAnnotationName)
	}
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		super.doTransform(annotatedClass, context)
		val annotationType = annotatedClass.generatedAnnotationName.findTypeGlobally as MutableAnnotationTypeDeclaration
		annotationType.addAnnotationTypeElement("anno") [
			it |
			docComment = "Best building strategy game ever"
			type =  Integer.TYPE.newTypeReference()
			if (annotatedClass.findAnnotation(ToAnno.findTypeGlobally).getBooleanValue("defaultValue")) {
				defaultValueExpression = '''1602'''
			}
		]
	}
	
	def generatedAnnotationName(ClassDeclaration decl) {
		decl.qualifiedName+"Anno"
	}
	
}