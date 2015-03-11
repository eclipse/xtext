/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package mypackage

import java.util.List
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

/**
 * @author efftinge - Initial contribution and API
 */
@Active(Processor)
annotation Annotation {
}

class Processor extends AbstractClassProcessor {
	
	override doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, extension RegisterGlobalsContext context) {
		context.registerInterface("mypackage.ShouldNotExist")
	}
	
	override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {
		throw new IllegalStateException("Same project, should not be called.")
	}
	
	override doTransform(List<? extends MutableClassDeclaration> annotatedClasses, extension TransformationContext context) {
		throw new IllegalStateException("Same project, should not be called.")
	}
	
}