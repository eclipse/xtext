/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;

/**
 * @author Heiko Behrens - Initial contribution and API
 * 
 */
public class Xtext2ECoreInterpretationContext {
	private EClassifierInfos eClassifierInfos;

	Set<EClassifierInfo> currentTypes = new HashSet<EClassifierInfo>();
	boolean isRuleCallAllowed = true;

	private Xtext2ECoreInterpretationContext(EClassifierInfos classifierInfos) {
		super();
		this.eClassifierInfos = classifierInfos;
	}

	public Xtext2ECoreInterpretationContext(EClassifierInfos eClassifierInfos, EClassifierInfo currentType) {
		this(eClassifierInfos);
		currentTypes.add(currentType);
	}

	private Xtext2ECoreInterpretationContext(Collection<EClassifierInfo> currentTypes,
			EClassifierInfos classifierInfos, boolean isRuleCallAllowed) {
		this(classifierInfos);
		this.currentTypes.addAll(currentTypes);
		this.isRuleCallAllowed = isRuleCallAllowed;
	}

	public Xtext2ECoreInterpretationContext(EClassifierInfo newType, EClassifierInfos classifierInfos,
			boolean isRuleCallAllowed2) {
		this(classifierInfos);
		this.currentTypes.add(newType);
	}

	public void addFeature(Assignment assignment) throws TransformationException {
		String featureName = assignment.getFeature();
		boolean isMultivalue = GrammarUtil.isMultipleAssignment(assignment);
		EClassifierInfo featureTypeInfo;

		if (GrammarUtil.isBooleanAssignment(assignment)) {
			featureTypeInfo = getEClassifierInfoOrThrowException("ecore::EBoolean", assignment);
			isMultivalue = false;
		}
		else {
			RuleCall featureRuleCall = (RuleCall) assignment.getTerminal();
			AbstractRule featureTypeRule = GrammarUtil.calledRule(featureRuleCall);
			String featureTypeName = GrammarUtil.getReturnTypeName(featureTypeRule);
			featureTypeInfo = getEClassifierInfoOrThrowException(featureTypeName, assignment);

		}

		for (EClassifierInfo type : currentTypes)
			type.addFeature(featureName, featureTypeInfo, isMultivalue);
	}

	private EClassifierInfo getEClassifierInfoOrThrowException(String typeName, AbstractElement parserElement)
			throws TransformationException {
		EClassifierInfo featureTypeInfo = eClassifierInfos.getInfo(typeName);
		if (featureTypeInfo == null) {
			throw new TransformationException("Cannot resolve type " + typeName, parserElement);
		}
		return featureTypeInfo;
	}

	public Xtext2ECoreInterpretationContext spawnContextForGroup() {
		Xtext2ECoreInterpretationContext result = new Xtext2ECoreInterpretationContext(currentTypes, eClassifierInfos,
				isRuleCallAllowed);
		return result;
	}

	public Xtext2ECoreInterpretationContext spawnContextWith(EClassifierInfo newType) {
		if (!isRuleCallAllowed)
			throw new IllegalStateException("Cannot change type twice within a rule");

		Xtext2ECoreInterpretationContext result = new Xtext2ECoreInterpretationContext(newType, eClassifierInfos,
				isRuleCallAllowed);
		return result;
	}

	public Xtext2ECoreInterpretationContext mergeSpawnedContexts(List<Xtext2ECoreInterpretationContext> contexts) {
		Xtext2ECoreInterpretationContext result = new Xtext2ECoreInterpretationContext(eClassifierInfos);
		// result's current types is union of all groups' types
		// result's isRuleCallAllowed is false if any group's value is false
		for (Xtext2ECoreInterpretationContext context : contexts) {
			result.currentTypes.addAll(context.currentTypes);
			result.isRuleCallAllowed &= context.isRuleCallAllowed;
		}
		return result;
	}

}
