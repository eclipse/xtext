/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;

/**
 * Language dependent configuration for the 'import' related things.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultImportsConfiguration implements IImportsConfiguration {

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	public XImportSection getImportSection(XtextResource resource) {
		for (Iterator<EObject> i = resource.getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof XImportSection)
				return (XImportSection) next;
		}
		return null;
	}

	public Iterable<JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource) {
		final List<JvmDeclaredType> locallyDefinedTypes = newArrayList();
		for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) next;
				locallyDefinedTypes.add(declaredType);
				addInnerTypes(declaredType, new IAcceptor<JvmDeclaredType>() {
					public void accept(JvmDeclaredType t) {
						locallyDefinedTypes.add(t);
					}
				});
				i.prune();
			}
			if(next instanceof XExpression) {
				i.prune();
			}
		}
		return locallyDefinedTypes;
	}
	
	public JvmDeclaredType getContextJvmDeclaredType(EObject model) {
		if(model != null) {
			JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(model);
			if(logicalContainer != null) 
				return EcoreUtil2.getContainerOfType(logicalContainer, JvmDeclaredType.class);
			EObject currentElement = model;
			do {
				for(EObject jvmElement: associations.getJvmElements(currentElement)) {
					if(jvmElement instanceof JvmDeclaredType) 
						return (JvmDeclaredType) jvmElement;
				}
				currentElement = currentElement.eContainer();
			} while (currentElement != null);
		}
		return null;
	}

	protected void addInnerTypes(JvmDeclaredType containerType, IAcceptor<? super JvmDeclaredType> result) {
		for (JvmMember member : containerType.getMembers()) {
			if (member instanceof JvmDeclaredType) {
				result.accept((JvmDeclaredType) member);
				addInnerTypes((JvmDeclaredType) member, result);
			}
		}
	}
	
	public Set<String> getImplicitlyImportedPackages(XtextResource resource) {
		Set<String> implicitlyImportedPackages = newHashSetWithExpectedSize(2);
		implicitlyImportedPackages.add("java.lang");
		return implicitlyImportedPackages;
	}

	public int getImportSectionOffset(XtextResource resource) {
		if(resource.getParseResult() != null && resource.getParseResult().getRootNode() != null) {
			List<EObject> pathToImportSection = findPathToImportSection();
			if(pathToImportSection != null) {
				INode node = findPreviousNode(resource.getParseResult().getRootNode(), pathToImportSection);
				if(node != null)
					return node.getTotalEndOffset();
			}
		}
		return 0;
	}

	protected INode findPreviousNode(ICompositeNode node, List<EObject> pathToImportSection) {
		if(pathToImportSection.isEmpty() || node.getGrammarElement() != pathToImportSection.get(0)) 
			return null;
		INode currentNode = null;
		ICompositeNode currentParentNode = node;
		int currentDepth = 0;
		OUTER: while(currentDepth < pathToImportSection.size() - 1) {
			++currentDepth;
			EObject expectedRuleCall = pathToImportSection.get(currentDepth);
			AbstractRule ruleInGrammar = GrammarUtil.containingRule(expectedRuleCall);
			for(INode childNode: currentParentNode.getChildren()) {
				EObject elementInNode = childNode.getGrammarElement();
				if(elementInNode != null) {
					for(Iterator<EObject> i = ruleInGrammar.eAllContents(); i.hasNext();) {
						EObject nextInGrammar = i.next();
						if(nextInGrammar == expectedRuleCall) {
							currentParentNode = (ICompositeNode) childNode;
							continue OUTER;
						}
						if(nextInGrammar == elementInNode) {
							break;
						}
					}
				}
				currentNode = childNode;
			}
		}
		return currentNode;
	}
	
	protected List<EObject> findPathToImportSection() {
		EList<AbstractRule> rules = grammarAccess.getGrammar().getRules();
		if(!rules.isEmpty() && rules.get(0) instanceof ParserRule) {
			LinkedList<EObject> pathToImportSection = newLinkedList();
			if(internalFindPathToImportSection(pathToImportSection, new HashSet<ParserRule>(), rules.get(0))) {
 				return pathToImportSection;
 			}
		}
		return null;
	}
	
	protected boolean internalFindPathToImportSection(LinkedList<EObject> pathToImportSection, 
			Set<ParserRule> seenRules, EObject ruleOrRuleCall) {
		ParserRule rule = null;
		EClassifier returnType = null;
		if(ruleOrRuleCall instanceof ParserRule) 
			rule = (ParserRule) ruleOrRuleCall;
		else 
			rule = (ParserRule) ((RuleCall) ruleOrRuleCall).getRule();
		if(seenRules.contains(rule))
			return false;
		seenRules.add(rule);
		pathToImportSection.addLast(ruleOrRuleCall);
		returnType = rule.getType().getClassifier();
		if(returnType instanceof EClass 
				&& XtypePackage.Literals.XIMPORT_SECTION.isSuperTypeOf((EClass) returnType)) {
			return true;
		}
		for(RuleCall containedRuleCall: GrammarUtil.containedRuleCalls(rule)) {
			if(containedRuleCall.getRule() instanceof ParserRule) 
				if(internalFindPathToImportSection(pathToImportSection, seenRules, containedRuleCall)) {
					return true;
				}
		}
		pathToImportSection.removeLast();
		return false;
	}
}
