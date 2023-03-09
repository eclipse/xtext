/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.inject.Inject;

/**
 * This API can be used by other templates to generate code that has hard
 * references to grammar rules/elements
 * 
 * @author Moritz Eysholdt
 */
@Deprecated(forRemoval = true)
public class GrammarAccess {
	@Inject
	private Naming naming;

	/**
	 * Returns the invocation of the element accessor method as full qualified
	 * Java statement. Example: return
	 * FowlerDslTestLanguageGrammarAccess.INSTANCE.prStatemachine().ele1AssignmentStates()
	 * 
	 * @param ele the element
	 * @return The java statement
	 */
	public String gaFullAccessor(AbstractElement ele) {
		return gaSimpleName(GrammarUtil.getGrammar(ele)) + ".INSTANCE." + gaRuleElementAccessor(ele);
	}

	/**
	 * Converts an arbitary string to a valid Java identifier. The string is
	 * split up along the the characters that are not valid as Java identifiers.
	 * The first character of each segment is made upper case which leads to a
	 * camel-case style.
	 * 
	 * @param text the string
	 * @param uppercaseFirst whether the first character of the returned
	 * identifier should be uppercase or lowercase
	 * @return the java identifier
	 */
	public String toJavaIdentifier(String text, boolean uppercaseFirst) {
		return GrammarAccessUtil.toJavaIdentifier(text, Boolean.valueOf(uppercaseFirst));
	}

	/**
	 * Creates an identifier for a Rule which is a valid Java identifier and
	 * unique within the Rule's grammar.
	 * 
	 * @param rule the Rule
	 * @return the identifier
	 */
	public String gaRuleIdentifyer(AbstractRule rule) {
		String plainName = RuleNames.getRuleNames(rule).getUniqueRuleName(rule);
		return toJavaIdentifier(plainName, true);
	}

	/**
	 * Creates an identifier for an AbstractElement which is a valid Java
	 * identifier and which is unique within the element's rule. The identifier
	 * tries to be as human-readable as possible.
	 * 
	 * @param element the element
	 * @return the element's identifier
	 */
	public String gaElementIdentifyer(AbstractElement element) {
		return GrammarAccessUtil.getUniqueElementName(element);
	}

	/**
	 * Returns the fully qualified Java class name of a GrammarAccess
	 * implementation for a grammar.
	 * 
	 * @param grammar the grammar
	 * @return the GrammarAccess' fully qualified Java class name
	 */
	public String gaFQName(Grammar grammar) {
		return GrammarAccessUtil.getGrammarAccessFQName(grammar, naming);
	}

	/**
	 * Returns the simple Java class name of a {@link GrammarAccess} implementation for
	 * a {@link Grammar}. The simple class name is defined as the class' name without
	 * any package names.
	 * 
	 * @param grammar the grammar
	 * @return the GrammarAccess' simple class name
	 */
	public String gaSimpleName(Grammar grammar) {
		return naming.toSimpleName(gaFQName(grammar));
	}

	/**
	 * Returns the method name for accessing a rule via a {@link GrammarAccess}
	 * implementation.
	 * 
	 * @param rule the rule for which the accessor method is needed
	 * @return the method's name.
	 */
	public String gaRuleAccessMethodName(AbstractRule rule) {
		return "get" + gaRuleIdentifyer(rule) + "Rule";
	}

	/**
	 * Returns the method name for accessing a rule's content via a
	 * ParseRuleAccess implementation.
	 * 
	 * @param rule the rule for which the accessor method is needed
	 * @return the method's name.
	 */
	public String gaRuleElementsMethodName(AbstractRule rule) {
		return "get" + gaRuleIdentifyer(rule) + "Access";
	}

	/**
	 * Returns the method name for accessing an element via a GrammarAccess
	 * implementation.
	 * 
	 * @param element the element for which the accessor method is needed
	 * @return the method's name.
	 */
	public String gaElementAccessMethodeName(AbstractElement element) {
		return "get" + gaElementIdentifyer(element);
	}

	/**
	 * Returns the simple class name of a rule's facade. A GrammarAccess
	 * implementation has a facade for each parser rule, which contains the
	 * methods for accessing the rule's elements.
	 * 
	 * @param rule ruleName
	 * @return the simple class name
	 */
	public String gaRuleAccesorClassName(AbstractRule rule) {
		return gaRuleIdentifyer(rule) + "Elements";
	}

	/**
	 * Returns the invocation of the rule accessor method as Java statement.
	 * 
	 * @param rule the rule
	 * @return The java statement
	 */
	public String gaRuleAccessor(AbstractRule rule) {
		return gaRuleAccessMethodName(rule) + "()";
	}

	/**
	 * Returns the invocation of the rule's content accessor method as Java
	 * statement.
	 * 
	 * @param rule the rule
	 * @return The java statement
	 */
	public String gaElementsAccessor(AbstractRule rule) {
		return gaRuleElementsMethodName(rule) + "()";
	}

	/**
	 * Returns the invocation of the element accessor method as Java statement.
	 * The called method is implemented by the rule's facade. Example:
	 * ele1AssignmentStates()
	 * 
	 * @param ele the element
	 * @return The java statement
	 */
	public String gaElementAccessor(AbstractElement ele) {
		return gaElementAccessMethodeName(ele) + "()";
	}

	/**
	 * Returns the invocation of the element accessor method for a GrammarAccess
	 * as Java statement. Example: prStatemachine().ele1AssignmentStates()
	 * 
	 * @param ele the element
	 * @return The java statement
	 */
	public String gaRuleElementAccessor(AbstractElement ele) {
		return gaElementsAccessor(GrammarUtil.containingRule(ele)) + "." + gaElementAccessor(ele);
	}

	/**
	 * Returns the invocation of an element or rule accessor, including the
	 * .getType() call. Example1: getFooRule().getType() Example2:
	 * getBarRule().getFooAction().getType()
	 */
	public String gaTypeAccessor(TypeRef ele) {
		EObject cnt = ele.eContainer();
		if (cnt instanceof AbstractElement) {
			return gaRuleElementAccessor((AbstractElement) cnt) + ".getType()";
		} else if (cnt instanceof AbstractRule) {
			return gaRuleAccessor((AbstractRule) cnt) + ".getType()";
		} else {
			return ("<error: unknown type " + ele.eContainer().eClass().getName()) + ">";
		}
	}

	/**
	 * Returns the invocation of an element or rule accessor. Example1:
	 * getFooRule() Example2: getBarRule().getFooAction()
	 */
	public String gaAccessor(EObject ele) {
		if (ele instanceof AbstractElement) {
			return gaRuleElementAccessor((AbstractElement) ele);
		} else if (ele instanceof AbstractRule) {
			return gaRuleAccessor((AbstractRule) ele);
		} else {
			return "<error: unknown type " + ele.eClass().getName() + ">";
		}
	}

	public String grammarFragmentToStr(EObject ele, String prefix) {
		return GrammarAccessUtil.serialize(ele, prefix);
	}
}
