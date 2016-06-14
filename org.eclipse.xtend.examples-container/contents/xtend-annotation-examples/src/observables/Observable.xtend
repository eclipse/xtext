/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package observables

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import java.lang.annotation.Target
import java.lang.annotation.ElementType

/**
 * Adds a getter and setter method for all fields
 * Adds PropertyChangeSupport to this class and informs all listeners on change.
 */
@Target(ElementType.TYPE)
@Active(ObservableCompilationParticipant)
annotation Observable {
}

class ObservableCompilationParticipant extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
		// For every field in a class annotated with @Observable, we generate a getter and a setter.
		// Additionally, the setter will fire change events. 
		for (f : clazz.declaredFields) {
			val fieldName = f.simpleName
			val fieldType = f.type

			clazz.addMethod('get' + fieldName.toFirstUpper) [
				returnType = fieldType
				body = '''return this.«fieldName»;'''
				primarySourceElement = f
			]

			clazz.addMethod('set' + fieldName.toFirstUpper) [
				addParameter(fieldName, fieldType)
				body = '''
					«fieldType» _oldValue = this.«fieldName»;
					this.«fieldName» = «fieldName»;
					_propertyChangeSupport.firePropertyChange("«fieldName»", _oldValue, «fieldName»);
				'''
				primarySourceElement = f
			]
			f.markAsRead
		}

		// generated field to hold listeners, addPropertyChangeListener() and removePropertyChangeListener() 
		val changeSupportType = PropertyChangeSupport.newTypeReference
		clazz.addField("_propertyChangeSupport") [
			type = changeSupportType
			initializer = '''new «changeSupportType»(this)'''
			primarySourceElement = clazz
		]

		val propertyChangeListener = PropertyChangeListener.newTypeReference
		clazz.addMethod("addPropertyChangeListener") [
			addParameter("listener", propertyChangeListener)
			body = '''this._propertyChangeSupport.addPropertyChangeListener(listener);'''
			primarySourceElement = clazz
		]
		clazz.addMethod("removePropertyChangeListener") [
			addParameter("listener", propertyChangeListener)
			body = '''this._propertyChangeSupport.removePropertyChangeListener(listener);'''
			primarySourceElement = clazz
		]
	}
}
