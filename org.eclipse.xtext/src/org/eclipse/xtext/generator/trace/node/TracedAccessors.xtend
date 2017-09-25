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
@Active(TracedAccessorsProcessor)
annotation TracedAccessors {
	Class<? extends EFactory>[] value
}

class TracedAccessorsProcessor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		annotatedClass.extendedClass = TracingSugar.newTypeReference()
		val iterableType = Iterable.newTypeReference(newWildcardTypeReference)
		val annotationType = TracedAccessors.newTypeReference
		val factories = annotatedClass.findAnnotation(annotationType.type)?.getClassArrayValue("value")
		if (factories === null) {
			return;
		}
		for (f : factories.map[type].filter(InterfaceDeclaration)) {
			for (t: f.declaredMethods.filter[simpleName.startsWith('create') && parameters.empty].map[returnType]) {
				for (getter : t.allResolvedMethods.filter[ isSupportedGetter].filter[!iterableType.isAssignableFrom(declaration.returnType)]) {
					val rt = getter.resolvedReturnType
					if (TYPES_WITH_GOOD_TO_STRING.contains(rt.type.simpleName.toLowerCase)) {
						annotatedClass.addMethod(getter.tracerName) [
							returnType = IGeneratorNode.newTypeReference()
							addParameter('target', t)
							body = '''
								«EStructuralFeature» feature = target.eClass().getEStructuralFeature("«getter.featureName»");
								«ILocationData» location = this.location(target, feature, -1);
								«CompositeGeneratorNode» trace = this.trace(location);
								this.append(trace, target.«getter.declaration.simpleName»());
								return trace;
							'''
						]
						annotatedClass.addMethod(getter.tracerName) [
							returnType = IGeneratorNode.newTypeReference()
							addParameter('target', t)
							addParameter('useForDebugging', Boolean.TYPE.newTypeReference())
							body = '''
								«EStructuralFeature» feature = target.eClass().getEStructuralFeature("«getter.featureName»");
								«ILocationData» location = this.location(target, feature, -1);
								«CompositeGeneratorNode» trace = this.trace(location, useForDebugging);
								this.append(trace, target.«getter.declaration.simpleName»());
								return trace;
							'''
						]
					} 
					annotatedClass.addMethod(getter.tracerName) [
						returnType = IGeneratorNode.newTypeReference
						addParameter('target', t)
						val stringProvider = Function.newTypeReference(rt, string)
						addParameter('stringProvider', stringProvider)
						body = '''
							«EStructuralFeature» feature = target.eClass().getEStructuralFeature("«getter.featureName»");
							«ILocationData» location = this.location(target, feature, -1);
							«CompositeGeneratorNode» trace = this.trace(location);
							this.append(trace, stringProvider.apply(target.«getter.declaration.simpleName»()));
							return trace;
						'''
					]
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
	
	static val TYPES_WITH_GOOD_TO_STRING = #{'string','boolean','int','long','integer'}
	
	def boolean isSupportedGetter(ResolvedMethod it) {
		if (!declaration.parameters.empty)
			return false
		if (declaration.static)
			return false
		val n = declaration.simpleName
		if (declaration.declaringType.qualifiedName == Object.name)
			return false
		return n.startsWith('get') || n.startsWith('is')
	}
}