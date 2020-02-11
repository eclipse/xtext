/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package lazy

import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * Adds a lazy getter and an initializer method.
 */
@Target(ElementType.FIELD)
@Active(LazyProcessor)
annotation Lazy {
}

class LazyProcessor extends AbstractFieldProcessor {

	override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {
		if (field.type.primitive)
			field.addError("Fields with primitives are not supported by @Lazy")
			
		if (field.initializer === null)
			field.addError("A lazy field must have an initializer.")
		
		field.declaringType.addMethod('_init' + field.simpleName) [
			visibility = Visibility.PRIVATE
			returnType = field.type
			// reassign the initializer expression to be the init method's body
			// this automatically removes the expression as the field's initializer
			body = field.initializer
			primarySourceElement = field
		]

		// add a getter method which lazily initializes the field
		field.declaringType.addMethod('get' + field.simpleName.toFirstUpper) [
			field.markAsRead
			returnType = field.type
			body = '''
				if («field.simpleName»==null)
				  «field.simpleName» = _init«field.simpleName»();
				return «field.simpleName»;
			'''
			primarySourceElement = field
		]
	}

}
