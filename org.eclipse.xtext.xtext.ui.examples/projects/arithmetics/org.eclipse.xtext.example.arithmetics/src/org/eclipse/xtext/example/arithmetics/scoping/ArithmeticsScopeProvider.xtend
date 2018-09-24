/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall
import org.eclipse.xtext.example.arithmetics.arithmetics.Module
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeDelegatingScopeProvider

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class ArithmeticsScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	override getScope(EObject context, EReference reference) {
		if (reference === ArithmeticsPackage.Literals.IMPORT__MODULE) {
			return super.getGlobalScope(context.eResource, reference)
		}
		val module = EcoreUtil2.getContainerOfType(context, Module)
		var result = IScope.NULLSCOPE
		for (import : module.imports) {
			if (!import.module.eIsProxy)
				result = getModuleScope(context, reference, import.module, result)
		}
		result = getModuleScope(context, reference, module, result)
		return getDefinitionScope(context, reference, result)
	}

	def getModuleScope(EObject context, EReference reference, Module module, IScope parent) {
		val allDefinitions = module.statements.filter(Definition)
		if (context instanceof FunctionCall) {
			return Scopes.scopeFor(allDefinitions.filter[context.args.size == args.size], parent)
		} else {
			return Scopes.scopeFor(allDefinitions, parent)
		}
	}

	def getDefinitionScope(EObject context, EReference reference, IScope parent) {
		val containingDef = EcoreUtil2.getContainerOfType(context, Definition)
		if (containingDef === null) {
			return parent
		}
		return Scopes.scopeFor(containingDef.args, parent)
	}

}
