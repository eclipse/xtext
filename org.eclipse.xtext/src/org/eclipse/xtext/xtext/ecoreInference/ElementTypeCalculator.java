/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
final class ElementTypeCalculator extends XtextSwitch<Set<EClassifier>> implements Function<AbstractElement, Set<EClassifier>>{

	private final EClassifierInfos classifierInfos;

	ElementTypeCalculator(EClassifierInfos classifierInfos) {
		this.classifierInfos = classifierInfos;
	}

	@Override
	public Set<EClassifier> caseKeyword(Keyword object) {
		EDataType eString = GrammarUtil.findEString(GrammarUtil.getGrammar(object));
		if (eString != null)
			return Collections.singleton(eString);
		// nowhere imported - use the instance from the registry
		return Collections.singleton(EcorePackage.Literals.ESTRING);
	}

	@Override
	public Set<EClassifier> caseTypeRef(TypeRef object) {
		if (object.getClassifier() == null) {
			if (object.getMetamodel() == null || object.getMetamodel().getEPackage() == null)
				return null;
			String name = GrammarUtil.getTypeRefName(object);
			if (Strings.isEmpty(name))
				return null;
			EClassifierInfo info = classifierInfos.getInfo(object.getMetamodel(), name);
			if (info != null)
				object.setClassifier(info.getEClassifier());
		}
		return Collections.singleton(object.getClassifier());
	}

	@Override
	public Set<EClassifier> caseAbstractRule(AbstractRule object) {
		if (object.getType() != null)
			return doSwitch(object.getType());
		return null;
	}

	@Override
	public Set<EClassifier> caseCompoundElement(CompoundElement object) {
		// since we do not allow unassigned rule calls and
		// actions, it is safe to use the same logic for
		// unordered groups as for groups
		if (object.getElements().size() != 1)
			return null;
		return doSwitch(object.getElements().get(0));
	}
	
	@Override
	public Set<EClassifier> caseRuleCall(RuleCall ruleCall) {
		if (ruleCall.getRule() != null)
			return doSwitch(ruleCall.getRule());
		return null;
	}

	@Override
	public Set<EClassifier> caseAlternatives(Alternatives object) {
		Set<EClassifier> types = Sets.newLinkedHashSet();
		for (AbstractElement group : object.getElements())
			types.addAll(doSwitch(group));
		return types;
	}

	@Override
	public Set<EClassifier> caseCrossReference(CrossReference object) {
		return doSwitch(object.getType());
	}

	@Override
	public Set<EClassifier> apply(AbstractElement param) {
		return doSwitch(param);
	}
}