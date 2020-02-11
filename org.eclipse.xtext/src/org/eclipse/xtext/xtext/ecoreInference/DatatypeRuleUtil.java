/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

/**
 * Utility class to handle data type rules in the Ecore inference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class DatatypeRuleUtil extends XtextSwitch<Boolean>{
	
	static boolean isDatatypeRule(ParserRule rule) {
		DatatypeRuleFinder finder = new DatatypeRuleFinder();
		return finder.doSwitch(rule) && finder.indicatorFound;
	}

	static boolean isValidDatatypeRule(ParserRule rule) {
		return new DatatypeRuleChecker().doSwitch(rule);
	}

	/**
	 * The finder tries to identify if a given ParserRule is to-be-inferred
	 * as a data-type rule.
	 * 
	 * A data type rule is a data type rule if it
	 * <ol>
	 * <li>declares an explicit return type which is an EDataType, or</li>
	 * <li>only calls other data type rules or terminal rules, and</li>
	 * <li>does not contain any assignments or actions, and</li>
	 * <li>consumes input, e.g. in the call graph is at least one element with concrete syntax,
	 *   which may be a keyword or a terminal rule</li>
	 * </ol>
	 * 
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	static class DatatypeRuleFinder extends DatatypeRuleUtil {

		/**
		 * This flag keeps track of potentially visited concrete
		 * syntax elements in the call graph.
		 */
		private boolean indicatorFound;

		@Override
		public Boolean caseTerminalRule(TerminalRule object) {
			indicatorFound = true;
			return super.caseTerminalRule(object);
		}
		
		@Override
		public Boolean caseKeyword(Keyword object) {
			indicatorFound = true;
			return super.caseKeyword(object);
		}

		@Override
		public Boolean caseParserRule(ParserRule object) {
			final TypeRef typeRef = object.getType();
			if (typeRef != null) {
				if (typeRef.getClassifier() != null) {
					boolean result = GrammarUtil.isDatatypeRule(object);
					if (result)
						indicatorFound = true;
					return result;
				}
				if (visitedRules.add(object)) {
					Boolean result = object.getAlternatives() != null && doSwitch(object.getAlternatives());
					if (result) {
						EDataType dataType = GrammarUtil.findEString(GrammarUtil.getGrammar(object));
						if (dataType != null)
							typeRef.setClassifier(dataType);
						else {
							// nowhere imported - use the instance from the registry
							typeRef.setClassifier(EcorePackage.Literals.ESTRING);
						}
					}
					return result;
				} else {
					return getApproximatedResult(object);
				}
			}
			if (!visitedRules.add(object))
				return getApproximatedResult(object);
			Boolean result = (object.getAlternatives() != null && doSwitch(object.getAlternatives()));
			return result; 
		}

		/**
		 * If a rule is visited reentrant, it is is shallow-checked for syntax
		 * elements that indicate a production rule rather than a data type rule.
		 */
		protected Boolean getApproximatedResult(ParserRule object) {
			if (object.getAlternatives() == null)
				return true;
			Iterator<?> contents = EcoreUtil.getAllContents(object.getAlternatives(), true);
			return !Iterators.filter(contents, new Predicate<Object>() {
				@Override
				public boolean apply(Object input) {
					return input instanceof Assignment || input instanceof Action;
				}
			}).hasNext();
		}

	}

	static class DatatypeRuleChecker extends DatatypeRuleFinder {

		@Override
		public Boolean caseParserRule(ParserRule object) {
			if (visitedRules.isEmpty()) {
				visitedRules.add(object);
				return object.getAlternatives() != null && doSwitch(object.getAlternatives());
			}
			final TypeRef typeRef = object.getType();
			if (typeRef == null || typeRef.getClassifier() == null) {
				throw new IllegalStateException("checks are only allowed for linked grammars. Rule: " + object.getName());
			}
			if (!visitedRules.add(object))
				return true;
			Boolean result = GrammarUtil.isDatatypeRule(object);
			return result; 
		}

	}

	/**
	 * A set of visited rules. The visited rules will not be removed from this set
	 * in order to save CPU cylces. This is valid since all rules that traversed
	 * and did not yield 'false' are considered to be data type rule candidates.
	 * If a rule yields false in the call graph, the traversal is immediately stopped
	 * and 'false' is returned. This implies that rules which have been traversed are
	 * potential data type rules if the traversal is still going on.
	 */
	protected final Set<AbstractRule> visitedRules;

	protected DatatypeRuleUtil() {
		this.visitedRules = Sets.newHashSet();
	}

	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseCompoundElement(CompoundElement object) {
		for(AbstractElement element: object.getElements())
			if (!doSwitch(element))
				return false;
		return true;
	}
	
	@Override
	public Boolean caseKeyword(Keyword object) {
		return Boolean.TRUE;
	}

	@Override
	public Boolean caseTerminalRule(TerminalRule object) {
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseAbstractRule(AbstractRule object) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseRuleCall(RuleCall object) {
		return object.getRule() != null && doSwitch(object.getRule());
	}


}
