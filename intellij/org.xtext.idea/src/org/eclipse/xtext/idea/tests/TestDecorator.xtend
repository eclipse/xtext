package org.eclipse.xtext.idea.tests

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

@Active(TestDecoratorProcessor)
annotation TestDecorator {
}

class TestDecoratorProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		val delegate = findDeclaredField('delegate')
		if (delegate == null) {
			addWarning("Delegate is not declared")
		}
		for (declaredMethod : delegate.type.allResolvedMethods.map[declaration].filter [
			simpleName.startsWith('test')
		]) {
			addMethod(declaredMethod.simpleName) [
				body = '''delegate.«declaredMethod.simpleName»();'''
				exceptions = declaredMethod.exceptions
			]
		}
	}

}
