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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;
import com.google.common.collect.Sets;

/**
 * Please refer to the
 * <a href="https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html#metamodel-inference">documentation</a>
 * for details.
 * 
 * 
 * 
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class Xtext2EcoreInterpretationContext implements EClassifierInfoAccess {

	private final EClassifierInfos eClassifierInfos;

	private final Function<AbstractElement, Set<EClassifier>> classifierCalculator;

	private final Collection<EClassifierInfo> currentTypes = Sets.newLinkedHashSet();

	private boolean isRuleCallAllowed = true;

	private Xtext2EcoreInterpretationContext(EClassifierInfos classifierInfos) {
		super();
		if (classifierInfos == null)
			throw new NullPointerException("classifierInfos may not be null");
		this.eClassifierInfos = classifierInfos;
		this.classifierCalculator = new ElementTypeCalculator(this.eClassifierInfos);
	}

	public Xtext2EcoreInterpretationContext(EClassifierInfos eClassifierInfos, EClassifierInfo currentType) {
		this(eClassifierInfos);
		currentTypes.add(currentType);
	}

	private Xtext2EcoreInterpretationContext(Collection<EClassifierInfo> currentTypes,
			EClassifierInfos classifierInfos, boolean isRuleCallAllowed) {
		this(classifierInfos);
		this.currentTypes.addAll(currentTypes);
		this.isRuleCallAllowed = isRuleCallAllowed;
	}

	public Xtext2EcoreInterpretationContext(EClassifierInfo newType, EClassifierInfos classifierInfos,
			boolean isRuleCallAllowed) {
		this(classifierInfos);
		this.currentTypes.add(newType);
		this.isRuleCallAllowed = isRuleCallAllowed;
	}

	public void addFeature(Assignment assignment) throws TransformationException {
		final String featureName = assignment.getFeature();
		boolean isMultivalue = GrammarUtil.isMultipleAssignment(assignment);
		boolean isContainment = true;
		EClassifierInfoAccess featureTypeInfo;

		if (GrammarUtil.isBooleanAssignment(assignment)) {
			checkNoFragmentRuleCall(assignment.getTerminal());
			EDataType eBoolean = GrammarUtil.findEBoolean(GrammarUtil.getGrammar(assignment));
			EClassifierInfo classifierInfo = getEClassifierInfoOrThrowException(eBoolean, assignment);
			featureTypeInfo = ()->classifierInfo;
			isMultivalue = false;
		}
		else {
			AbstractElement terminal = assignment.getTerminal();
			if (terminal == null) {
				throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot derive type from incomplete assignment.", assignment);
			}
			checkNoFragmentRuleCall(terminal);
			List<EClassifierInfo> classifierInfos = new ArrayList<>();
			for(EClassifier type: getTerminalTypes(terminal)) {
				classifierInfos.add(getEClassifierInfoOrThrowException(type, assignment));
			}
			isContainment = isContainmentAssignment(assignment);
			featureTypeInfo = new EClassifierInfoAccess() {

				@Override
				public Collection<EClassifierInfo> getCurrentTypes() {
					return classifierInfos;
				}
				@Override
				public EClassifierInfo getCurrentCompatibleType() {
					try {
						return eClassifierInfos.getCompatibleTypeOf(classifierInfos);
					} catch(IllegalArgumentException e) {
						return null;
					}
				}
			};
		}
		addFeature(featureName, featureTypeInfo, isMultivalue, isContainment, assignment);
	}
	
	private void checkNoFragmentRuleCall(AbstractElement terminal) throws TransformationException {
		if (GrammarUtil.isEObjectFragmentRuleCall(terminal)) {
			throw new TransformationException(TransformationErrorCode.InvalidFragmentCall, "Cannot call a fragment from an assignment", terminal);
		}
		if (terminal instanceof Alternatives) {
			for(AbstractElement child: ((Alternatives) terminal).getElements()) {
				checkNoFragmentRuleCall(child);
			}
		}
	}

	public boolean isContainmentAssignment(Assignment assignment) {
		// TODO throw TransformationException in case of unexpected terminal
		return new XtextSwitch<Boolean>() {

			@Override
			public Boolean caseAlternatives(Alternatives object) {
				for (AbstractElement group: object.getElements())
					if (doSwitch(group))
						return true;
				return false;
			}

			@Override
			public Boolean caseCrossReference(CrossReference object) {
				return false;
			}

			@Override
			public Boolean caseAbstractElement(AbstractElement object) {
				return true;
			}

		}.doSwitch(assignment.getTerminal());
	}

	public void addFeature(String featureName, EClassifierInfoAccess featureTypeInfo, boolean isMultivalue,
			boolean isContainment, AbstractElement parserElement) throws TransformationException {
		for (EClassifierInfo type : currentTypes)
			type.addFeature(featureName, featureTypeInfo, isMultivalue, isContainment, parserElement);
	}
	
	private Set<EClassifier> getTerminalTypes(AbstractElement terminal) throws TransformationException {
		Set<EClassifier> result = classifierCalculator.apply(terminal);
		if (result == null) {
			final ICompositeNode node = NodeModelUtils.getNode(terminal);
			if (node != null) {
				throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot find type for '" + node.getText().trim() + "'.", terminal);
			}
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, "Cannot find type for " + terminal.eClass().getName(), terminal);
		}
		return result;
	}

	private EClassifierInfo getEClassifierInfoOrThrowException(EClassifier type, AbstractElement parserElement)
			throws TransformationException {
		final EClassifierInfo featureTypeInfo = eClassifierInfos.getInfoOrNull(type);
		if (featureTypeInfo == null) {
			String typeName = "null";
			if (type != null)
				typeName = type.getName();
			throw new TransformationException(TransformationErrorCode.NoSuchTypeAvailable, 
					"Cannot resolve type " + typeName, parserElement);
		}
		return featureTypeInfo;
	}

	public Xtext2EcoreInterpretationContext spawnContextForGroup() {
		Xtext2EcoreInterpretationContext result = new Xtext2EcoreInterpretationContext(currentTypes, eClassifierInfos,
				isRuleCallAllowed);
		return result;
	}

	public Xtext2EcoreInterpretationContext spawnContextWithCalledRule(EClassifierInfo newType, EObject parserElement)
			throws TransformationException {
		if (!isRuleCallAllowed)
			throw new TransformationException(TransformationErrorCode.MoreThanOneTypeChangeInOneRule,
					"Cannot change type twice within a rule", parserElement);

		return new Xtext2EcoreInterpretationContext(newType, eClassifierInfos, false);
	}

	public Xtext2EcoreInterpretationContext mergeSpawnedContexts(List<Xtext2EcoreInterpretationContext> contexts) {
		Xtext2EcoreInterpretationContext result = new Xtext2EcoreInterpretationContext(eClassifierInfos);
		// result's current types is union of all groups' types
		// result's isRuleCallAllowed is false if any group's value is false
		for (Xtext2EcoreInterpretationContext context : contexts) {
			result.currentTypes.addAll(context.currentTypes);
			result.isRuleCallAllowed &= context.isRuleCallAllowed;
		}
		return result;
	}

	public Collection<EClassifierInfo> getCurrentTypes() {
		return currentTypes;
	}
	
	public EClassifierInfo getCurrentCompatibleType() {
		try {
			return eClassifierInfos.getCompatibleTypeOf(currentTypes);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}

	public Xtext2EcoreInterpretationContext spawnContextWithReferencedType(EClassifierInfo referencedType, EObject parserElement) {
		return new Xtext2EcoreInterpretationContext(referencedType, eClassifierInfos, false);
	}

}
