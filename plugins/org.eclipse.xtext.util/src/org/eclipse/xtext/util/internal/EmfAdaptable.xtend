/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.internal

import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.emf.common.notify.impl.AdapterImpl

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Active(EmfAdaptableProcessor)
annotation EmfAdaptable {
}

class EmfAdaptableProcessor extends AbstractClassProcessor {
	
	override doRegisterGlobals(ClassDeclaration annotatedClass, extension RegisterGlobalsContext context) {
		context.registerClass(annotatedClass.getAdapterClassName)
	}
	
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		annotatedClass.addMethod('findInEmfObject') [
			addParameter('emfObject', Notifier.newTypeReference)
			returnType = annotatedClass.newTypeReference
			static = true
			body = '''
				for («Adapter» adapter : emfObject.eAdapters()) {
					if (adapter instanceof «annotatedClass.adapterClassName») {
						return ((«annotatedClass.adapterClassName») adapter).get();
					}
				}
				return null;
			'''
		]
		annotatedClass.addMethod('attachToEmfObject') [
			addParameter('emfObject', Notifier.newTypeReference)
			returnType = primitiveVoid
			body = '''
				«annotatedClass.simpleName» result = findInEmfObject(emfObject);
				if (result != null)
					throw new IllegalStateException("The given EMF object already contains an adapter for «annotatedClass.simpleName»");
				«annotatedClass.adapterClassName» adapter = new «annotatedClass.adapterClassName»(this);
				emfObject.eAdapters().add(adapter);
			'''
		]
		val adapterClass = findClass(annotatedClass.adapterClassName)
		adapterClass.extendedClass = AdapterImpl.newTypeReference
		adapterClass.addField('element') [
			type = annotatedClass.newTypeReference
		]
		adapterClass.addConstructor[
			addParameter('element', annotatedClass.newTypeReference)
			body = '''
				this.element = element;
			'''
		]
		adapterClass.addMethod('get') [
			returnType = annotatedClass.newTypeReference
			body = '''
				return this.element;
			'''
		]
		adapterClass.addMethod('isAdapterForType') [
			addParameter("object", Object.newTypeReference)
			returnType = primitiveBoolean
			body = '''
				return object == «annotatedClass».class;
			'''
		]
	}
	
	def String getAdapterClassName(ClassDeclaration declaration) {
		return declaration.qualifiedName+'.'+declaration.simpleName+"Adapter"
	}
	
}