/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test
import org.junit.Ignore

@Active(TestDecoratorProcessor)
annotation TestDecorator {
}

class TestDecoratorProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
		val delegate = cls.findDeclaredField('delegate')
		if (delegate == null) {
			cls.addWarning("Delegate is not declared")
			return
		}
		val atTest = context.findTypeGlobally(Test)
		val atIgnore = context.findTypeGlobally(Ignore)
		delegate.markAsRead
		delegate.type.allResolvedMethods
			.map[declaration]
			.filter [findAnnotation(atTest) !== null && findAnnotation(atIgnore) === null]
			.filter[cls.findDeclaredMethod(simpleName) == null]
			.sortBy[simpleName]
			.forEach[declaredMethod|
				cls.addMethod(declaredMethod.simpleName) [
					body = '''delegate.«declaredMethod.simpleName»();'''
					exceptions = declaredMethod.exceptions
				]
			]
	}

}
