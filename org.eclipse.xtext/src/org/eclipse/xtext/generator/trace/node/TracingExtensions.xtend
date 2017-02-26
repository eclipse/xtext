/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import java.util.function.Function
import org.eclipse.emf.ecore.EFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod
import org.eclipse.xtext.generator.trace.ILocationData

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Active(TracingExtensionsProcessor)
annotation TracingExtensions {
	Class<? extends EFactory>[] value
}

class TracingExtensionsProcessor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		val eobjectType = EObject.newTypeReference()
		annotatedClass.extendedClass = TracingSugar.newTypeReference()
		val annotationType = findTypeGlobally(TracingExtensions)
		val factories = annotatedClass.findAnnotation(annotationType)?.getClassArrayValue("value")
		if (factories === null) {
			return;
		}
		for (f : factories.map[type].filter(InterfaceDeclaration)) {
			for (t: f.declaredMethods.filter[simpleName.startsWith('create') && parameters.empty].map[returnType]) {
				for (getter : t.allResolvedMethods.filter[ isGetter]) {
					val rt = getter.resolvedReturnType
					if (allowedLowerCaseTypeNames.contains(rt.type.simpleName.toLowerCase)) {
						annotatedClass.addMethod(getter.tracerName) [
							returnType = IGeneratorNode.newTypeReference()
							addParameter('target', t)
							body = '''
								«EStructuralFeature» feature = target.eClass().getEStructuralFeature("«getter.featureName»");
								«ILocationData» location = this.location(target, feature, -1);
								«CompositeGeneratorNode» trace = this.startTrace(location);
								this.append(trace, target.«getter.declaration.simpleName»());
								return trace;
							'''
						]
					} else if (eobjectType.isAssignableFrom(rt)) {
						annotatedClass.addMethod(getter.tracerName) [
							returnType = IGeneratorNode.newTypeReference
							addParameter('target', t)
							val stringProvider = Function.newTypeReference(rt, string)
							addParameter('stringProvider', stringProvider)
							body = '''
								«EStructuralFeature» feature = target.eClass().getEStructuralFeature("«getter.featureName»");
								«ILocationData» location = this.location(target, feature, -1);
								«CompositeGeneratorNode» trace = this.startTrace(location);
								this.append(trace, stringProvider.apply(target.«getter.declaration.simpleName»()));
								return trace;
							'''
						]
					}
				}
			}
		}
	}

	def String tracerName(ResolvedMethod m) {
		'_'+m.featureName
	}
	
	def String featureName(ResolvedMethod m) {
		val n = m.declaration.simpleName
		val skip = if (n.startsWith('get')) 3 else 2
		m.declaration.simpleName.substring(skip).toFirstLower
	}
	
	static val allowedLowerCaseTypeNames = #{'string','boolean','int','long','integer'}
	
	def boolean isGetter(ResolvedMethod it) {
		if (!declaration.parameters.empty)
			return false
		if (declaration.static)
			return false
		val n = it.declaration.simpleName
		return n.startsWith('get') || n.startsWith('is')
	}
}