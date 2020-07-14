/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial API and implementation
 */
public class EvaluationContext {
	@Inject
	private IBatchTypeResolver typeResolver;

	private RecursionGuard<EObject> visiting = new RecursionGuard<EObject>();

	private Map<Resource, IResolvedTypes> resolvedTypesPerResource = new HashMap<>();

	private Stack<IResolvedTypes> resolvedTypesStack = new Stack<IResolvedTypes>();

	public boolean tryNext(XExpression expression) {
		if (visiting.tryNext(expression)) {
			resolveTypes(expression);
			return true;
		}
		return false;
	}

	public void addResolvedTypes(Resource resource, IResolvedTypes resolvedTypes) {
		resolvedTypesPerResource.put(resource, resolvedTypes);
	}

	private void resolveTypes(XExpression expression) {
		Resource resource = expression.eResource();
		IResolvedTypes resolvedTypes = resolvedTypesPerResource.get(resource);
		if (resolvedTypes == null) {
			resolvedTypes = typeResolver.resolveTypes(expression);
			resolvedTypesPerResource.put(resource, resolvedTypes);
		}
		resolvedTypesStack.push(resolvedTypes);
	}

	public IResolvedTypes getResolvedTypes() {
		return resolvedTypesStack.peek();
	}

	public void done(final XExpression expression) {
		resolvedTypesStack.pop();
		visiting.done(expression);
	}
}
