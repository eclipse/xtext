/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.junit.Assert
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class TestProperSourceFolderMapping extends AbstractActiveAnnotationTest {
	
	/**
	 * checks that the configured target folder matches what is used by the generator.
	 * I.e. in case of xtend it is xtend-gen
	 */
	@Test def void testChangeGeneratedJava() {
		'''
			@org.eclipse.xtend.core.tests.macro.__GeneratedSourceModifingAnnotation
			class MyClass {}
		'''.compile[]
	}
}

@Active(__GeneratedSourceModifingAnnotationProcessor)
annotation __GeneratedSourceModifingAnnotation {}

class __GeneratedSourceModifingAnnotationProcessor extends AbstractClassProcessor {
	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val targetFolder = annotatedClass.compilationUnit.filePath.targetFolder
		Assert.assertTrue(targetFolder.lastSegment == "xtend-gen")
	}
}