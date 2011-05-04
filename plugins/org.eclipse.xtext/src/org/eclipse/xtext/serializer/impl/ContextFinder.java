/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.serializer.IContextFinder;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextFinder implements IContextFinder {

	protected List<IConstraintContext> constraintContexts;

	protected Map<Pair<EObject, EClass>, IConstraint> constraints;

	@Inject
	protected IGrammarAccess grammarAccess;

	@Inject
	protected IGrammarConstraintProvider grammarConstraintProvider;

	protected Iterable<EObject> findContexts(EObject semanitcObject) {
		EClass cls = semanitcObject.eClass();
		Set<EObject> result = Sets.newHashSet();
		for (IConstraintContext cc : constraintContexts)
			for (IConstraint c : cc.getConstraints())
				if (c.getType() == cls) {
					result.add(cc.getContext());
					break;
				}
		return result;
	}

	public Iterable<EObject> findContextsByContents(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		initConstraints();
		// TODO: actually validate if the constraints match
		if (contextCandidates == null)
			return findContexts(semanitcObject);
		EClass cls = semanitcObject.eClass();
		Set<EObject> result = Sets.newHashSet();
		for (EObject candidate : contextCandidates)
			if (getConstraint(candidate, cls) != null)
				result.add(candidate);
		return result;
	}

	public Iterable<EObject> findContextsByContentsAndContainer(EObject semanitcObject,
			Iterable<EObject> contextCandidates) {
		return findContextsByContents(semanitcObject, contextCandidates);
	}

	protected IConstraint getConstraint(EObject context, EClass type) {
		return constraints.get(Tuples.create(context, type));
	}

	protected void initConstraints() {
		if (constraintContexts == null) {
			constraints = Maps.newHashMap();
			constraintContexts = grammarConstraintProvider.getConstraints(grammarAccess.getGrammar());
			//			System.out.println(Joiner.on("\n").join(constraintContexts));
			for (IConstraintContext ctx : constraintContexts)
				for (IConstraint constraint : ctx.getConstraints())
					constraints.put(Tuples.create(ctx.getContext(), constraint.getType()), constraint);
		}
	}

}
