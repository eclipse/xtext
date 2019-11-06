/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.example.arithmetics.arithmetics.Import;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeDelegatingScopeProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * This class contains custom scoping description.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class ArithmeticsScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == ArithmeticsPackage.Literals.IMPORT__MODULE) {
			return super.getGlobalScope(context.eResource(), reference);
		}
		Module module = EcoreUtil2.getContainerOfType(context, Module.class);
		IScope result = IScope.NULLSCOPE;
		for (Import i : module.getImports()) {
			if (!i.getModule().eIsProxy()) {
				result = getModuleScope(context, reference, i.getModule(), result);
			}
		}
		result = getModuleScope(context, reference, module, result);
		return getDefinitionScope(context, reference, result);
	}

	private IScope getModuleScope(EObject context, EReference reference, Module module, IScope parent) {
		Iterable<Definition> allDefinitions = IterableExtensions.filter(module.getStatements(), Definition.class);
		if (context instanceof FunctionCall) {
			Iterable<Definition> matchingDefs = IterableExtensions.filter(allDefinitions, (d) -> ((FunctionCall) context).getArgs().size() == d.getArgs().size());
			return Scopes.scopeFor(matchingDefs, parent);
		} else {
			return Scopes.scopeFor(allDefinitions, parent);
		}
	}

	private IScope getDefinitionScope(EObject context, EReference reference, IScope parent) {
		Definition containingDef = EcoreUtil2.getContainerOfType(context, Definition.class);
		if (containingDef == null) {
			return parent;
		}
		return Scopes.scopeFor(containingDef.getArgs(), parent);
	}

}
