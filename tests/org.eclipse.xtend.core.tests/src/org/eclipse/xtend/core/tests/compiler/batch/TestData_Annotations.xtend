/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler.batch

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

@Active(_TESTDATA_InternalClassProcessor)
annotation _TESTDATA_InternalClassAnnotation {
}

class _TESTDATA_InternalClassProcessor extends AbstractClassProcessor {
	
	override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
		context.registerClass(annotatedClass.qualifiedName+".InternalClass")
	}
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		findClass(annotatedClass.qualifiedName+".InternalClass") => [
			addField("myField") [
				type = string
			]
		]
	}
	
	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val tF = annotatedClass.compilationUnit.filePath.targetFolder
		tF.append("/Test.txt").contents = '''
			Hello
		'''
	}
	
}