/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.generator.trace.ILocationData

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Active(TracedProcessor)
annotation Traced {
	String tracingSugarFieldName = '_traceExtensions' 
	boolean useForDebugging = false
}

class TracedProcessor extends AbstractMethodProcessor {
	
	override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		val useForDebugging = annotatedMethod.findAnnotation(Traced.findTypeGlobally).getBooleanValue("useForDebugging")
		val traceSugar = TracingSugar.newTypeReference
		val templateClient = StringConcatenationClient.newTypeReference
		val nodeType = IGeneratorNode.newTypeReference
		val eobjectType = EObject.newTypeReference
		
		val clazz = annotatedMethod.declaringType as MutableClassDeclaration
		val field = clazz.declaredFields.findFirst[
			traceSugar.isAssignableFrom(type)
		]
		if (field === null) {
			annotatedMethod.addError('''@«Traced.simpleName» methods can only declared in a class with a field of type «TracingSugar»''')
			return;
		}
		val traceParam = annotatedMethod.parameters.findFirst[eobjectType.isAssignableFrom(type)]
		if (traceParam === null) {
			annotatedMethod.addError('''@«Traced.simpleName» methods need at least one parameter of type «EObject».''')
			return;			
		}
		clazz.addMethod('_'+annotatedMethod.simpleName) [
			for (p : annotatedMethod.parameters) {
				addParameter(p.simpleName, p.type)
			}
			returnType = templateClient
			body = annotatedMethod.body
		]
		annotatedMethod.returnType = nodeType
		annotatedMethod.body = '''
			«ILocationData» _location = this.«field.simpleName».location(«traceParam.simpleName»);
			«CompositeGeneratorNode» _traceNode = this.«field.simpleName».trace(_location, «useForDebugging»);
			this.«field.simpleName».appendTemplate(_traceNode, _«annotatedMethod.simpleName»(«annotatedMethod.parameters.join(',')[simpleName]»));
			return _traceNode;
		'''
	}
	
}