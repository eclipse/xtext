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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.resource.metamodel.ErrorAcceptor.ErrorCode;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @see http://wiki.eclipse.org/Xtext/Documentation#Meta-Model_Inference
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
			boolean isRuleCallAllowed) {
		this(classifierInfos);
		this.currentTypes.add(newType);
		this.isRuleCallAllowed = isRuleCallAllowed;
	}

	public void addFeature(Assignment assignment) throws TransformationException {
		String featureName = assignment.getFeature();
		boolean isMultivalue = GrammarUtil.isMultipleAssignment(assignment);
		boolean isContainment = true;
		EClassifierInfo featureTypeInfo;

		if (GrammarUtil.isBooleanAssignment(assignment)) {
			featureTypeInfo = getEClassifierInfoOrThrowException("ecore::EBoolean", assignment);
			isMultivalue = false;
		}
		else {
			String featureTypeName = getTerminalTypeName(assignment.getTerminal());
			isContainment = !(assignment.getTerminal() instanceof CrossReference);
			featureTypeInfo = getEClassifierInfoOrThrowException(featureTypeName, assignment);
		}

		addFeature(featureName, featureTypeInfo, isMultivalue, isContainment, assignment);
	}

	public void addFeature(String featureName, EClassifierInfo featureTypeInfo, boolean isMultivalue,
			boolean isContainment, EObject parserElement) throws TransformationException {
		for (EClassifierInfo type : currentTypes)
			type.addFeature(featureName, featureTypeInfo, isMultivalue, isContainment, parserElement);
	}

	private String getTerminalTypeName(AbstractElement terminal) {
		if (terminal instanceof RuleCall) {
			RuleCall featureRuleCall = (RuleCall) terminal;
			AbstractRule featureTypeRule = GrammarUtil.calledRule(featureRuleCall);
			return GrammarUtil.getReturnTypeName(featureTypeRule);
		}
		else if (terminal instanceof CrossReference) {
			CrossReference crossReference = (CrossReference) terminal;
			return GrammarUtil.getQualifiedName(crossReference.getType());
		}
		else if (terminal instanceof Keyword)
			return "ecore::EString";
		else {
			// terminal is ParenthesizedElement
			// must be either: alternative of lexer rules and keywords or
			// alternative of parser rules
			return getCompatibleTypeNameOfAlternatives((Alternatives) terminal);
		}
	}

	private String getCompatibleTypeNameOfAlternatives(AbstractElement element) {
		if (element instanceof Alternatives) {
			Alternatives alternative = (Alternatives) element;
			Set<String> typeNames = new HashSet<String>();
			for (AbstractElement group : alternative.getGroups())
				typeNames.add(getCompatibleTypeNameOfAlternatives(group));
			return eClassifierInfos.getCompatibleTypeNameOf(typeNames);
		}
		else if (element instanceof Group) {
			Group group = (Group) element;
			if (group.getAbstractTokens().size() != 1)
				throw new IllegalArgumentException("Group must have exactly one element.");
			return getCompatibleTypeNameOfAlternatives(group.getAbstractTokens().get(0));
		}
		else if (element instanceof RuleCall) {
			AbstractRule calledRule = GrammarUtil.calledRule((RuleCall) element);
			return GrammarUtil.getReturnTypeName(calledRule);
		}
		else if (element instanceof Keyword) {
			return "ecore::EString";
		}
		else
			throw new IllegalArgumentException("Terminal has no type");
	}

	private EClassifierInfo getEClassifierInfoOrThrowException(String typeName, AbstractElement parserElement)
			throws TransformationException {
		EClassifierInfo featureTypeInfo = eClassifierInfos.getInfo(typeName);
		if (featureTypeInfo == null) {
			throw new TransformationException(ErrorCode.NoSuchTypeAvailable, "Cannot resolve type " + typeName,
					parserElement);
		}
		return featureTypeInfo;
	}

	public Xtext2ECoreInterpretationContext spawnContextForGroup() {
		Xtext2ECoreInterpretationContext result = new Xtext2ECoreInterpretationContext(currentTypes, eClassifierInfos,
				isRuleCallAllowed);
		return result;
	}

	public Xtext2ECoreInterpretationContext spawnContextWithCalledRule(EClassifierInfo newType, EObject parserElement)
			throws TransformationException {
		if (!isRuleCallAllowed)
			throw new TransformationException(ErrorCode.MoreThanOneTypeChangeInOneRule,
					"Cannot change type twice within a rule", parserElement);

		return new Xtext2ECoreInterpretationContext(newType, eClassifierInfos, false);
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

	public EClassifierInfo getCurrentCompatibleType() {
		return eClassifierInfos.getCompatibleTypeOf(currentTypes);
	}

	public Xtext2ECoreInterpretationContext spawnContextWithReferencedType(EClassifierInfo referencedType, EObject parserElement) {
		return new Xtext2ECoreInterpretationContext(referencedType, eClassifierInfos, false);
	}

}
