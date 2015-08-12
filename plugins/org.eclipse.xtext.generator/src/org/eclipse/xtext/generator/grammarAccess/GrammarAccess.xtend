package org.eclipse.xtext.generator.grammarAccess

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.RuleNames
import org.eclipse.xtext.TypeRef
import org.eclipse.xtext.generator.Naming

import static extension org.eclipse.xtext.GrammarUtil.*

/**
 * This API can be used by other templates to generate code
 * that has hard references to grammar rules/elements 
 * @author Moritz Eysholdt
 */
class GrammarAccess {
	
	@Inject Naming naming
	
	/**
	 * Returns the invocation of the element accessor method as full qualified Java statement.
	 * Example: return FowlerDslTestLanguageGrammarAccess.INSTANCE.prStatemachine().ele1AssignmentStates()
	 * @param ele the element
	 * @return The java statement
	 */	
	def String gaFullAccessor(AbstractElement ele) {
		ele.grammar.gaSimpleName() + ".INSTANCE." + ele.gaRuleElementAccessor()
	}

	/**
	 * Converts an arbitary string to a valid Java identifier.
	 * The string is split up along the the characters that are not valid as Java 
	 * identifier. The first character of each segments is made upper case which 
	 * leads to a camel-case style.
	 * @param text the string
	 * @param uppercaseFirst whether the first character of the returned identifier should be uppercase or lowercase
	 * @return the java identifier
	 */
	def String toJavaIdentifier(String text, boolean uppercaseFirst) {
		GrammarAccessUtil.toJavaIdentifier(text, uppercaseFirst)
	}
		
	/** 
	 * Creates an identifier for a Rule which is a valid Java idetifier and unique within 
	 * the Rule's grammar.
	 * @param rule the Rule
	 * @return the identifier
	 */
	def String gaRuleIdentifyer(AbstractRule rule) {
		val plainName = RuleNames.getRuleNames(rule).getUniqueRuleName(rule);
		return toJavaIdentifier(plainName, true);
	}
		
	/**
	 * Creates an identifier for an AbstractElement which is a valid Java identifier and
	 * which is unique whithin the element's rule. The identifier tries to be as 
	 * human-readable as possible.
	 * @param element the element
	 * @return the element's identifier
	 */
	def String gaElementIdentifyer(AbstractElement element) {
		GrammarAccessUtil.getUniqueElementName(element);
	}
	/**
	 * Returns the full qulified Java class name of a GrammarAccess implementation for a grammar.
	 * @param grammar the grammar
	 * @return the GrammarAccess' full qualified Java class name
	 */
	def String gaFQName(Grammar grammar) {
		GrammarAccessUtil.getGrammarAccessFQName(grammar, naming)
	}

	/**
	 * Returns the simple Java class name of a GrammarAccess implementation for a Grammar.
	 * The simple class name is defined as the class' name without any package names.
	 * @param grammar the grammar
	 * @return the GrammarAccess' simple class name
	 */
	def String gaSimpleName(Grammar grammar) {
		naming.toSimpleName(gaFQName(grammar))
	}
	
	/**
	 * Returns the method name for accessing a rule via a GrammarAccess implementation.
	 * @param rule the rule for which the accessor method is needed
	 * @return the method's name.
	 */
	def String gaRuleAccessMethodName(AbstractRule rule) {
		"get" + rule.gaRuleIdentifyer() + "Rule"
	}
		
	/**
	 * Returns the method name for accessing a rule's content via a ParseRuleAccess implementation.
	 * @param rule the rule for which the accessor method is needed
	 * @return the method's name.
	 */
	def String gaRuleElementsMethodName(AbstractRule rule) {
		"get" + rule.gaRuleIdentifyer() + "Access"
	}
	
	/**
	 * Returns the method name for accessing an element via a GrammarAccess implementation.
	 * @param element the element for which the accesor method is needed
	 * @return the method's name.
	 */
	def String gaElementAccessMethodeName(AbstractElement element) {
		"get" + element.gaElementIdentifyer()
	}
	
	/**
	 * Returns the simple class name of a rule's facade. A GrammarAccess implementation has
	 * a facade for each parser rule, which contains the methods for accessing the rule's elements.
	 * @param rule ruleName
	 * @return the simple class name
	 */	
	def String gaRuleAccesorClassName(AbstractRule rule) {
		rule.gaRuleIdentifyer() + "Elements"
	}
		
	/**
	 * Returns the invocation of the rule accessor method as Java statement.
	 * @param rule the rule
	 * @return The java statement
	 */	
	def String gaRuleAccessor(AbstractRule rule) {
		rule.gaRuleAccessMethodName() + "()"
	}
	
	/**
	 * Returns the invocation of the rule's content accessor method as Java statement.
	 * @param rule the rule
	 * @return The java statement
	 */	
	def String gaElementsAccessor(AbstractRule rule) {
		rule.gaRuleElementsMethodName() + "()"
	}
		
	/**
	 * Returns the invocation of the element accessor method as Java statement.
	 * The called method is implemented by the rule's facade.
	 * Example: ele1AssignmentStates()
	 * @param ele the element
	 * @return The java statement
	 */	
	def String gaElementAccessor(AbstractElement ele){
		ele.gaElementAccessMethodeName() + "()";
	}
		
	/**
	 * Returns the invocation of the element accessor method for a GrammarAccess 
	 * as Java statement.
	 * Example: prStatemachine().ele1AssignmentStates()
	 * @param ele the element
	 * @return The java statement
	 */	
	def String gaRuleElementAccessor(AbstractElement ele) {
		ele.containingRule().gaElementsAccessor() + "." + ele.gaElementAccessor();
	}
	
	/**
	 * Returns the invocation of an element or rule accessor, including the .getType() call.
	 * Example1: getFooRule().getType()
	 * Example2: getBarRule().getFooAction().getType()
	 */
	def String gaTypeAccessor(TypeRef ele) {
		switch cnt: ele.eContainer() {
			AbstractElement: cnt.gaRuleElementAccessor() + ".getType()"
			AbstractRule: cnt.gaRuleAccessor() + ".getType()"
			default: "<error: unknown type "+ele.eContainer().eClass.name+">"
		};
	}
	/**
	 * Returns the invocation of an element or rule accessor.
	 * Example1: getFooRule()
	 * Example2: getBarRule().getFooAction()
	 */
	def String gaAccessor(EObject ele) {
		switch ele {
			AbstractElement: ele.gaRuleElementAccessor()
			AbstractRule: ele.gaRuleAccessor() 
			default: "<error: unknown type "+ele.eClass.name+">"
		}
	}
	/*
	 *
	 */
	def String grammarFragmentToStr(EObject ele, String prefix) {
		GrammarAccessUtil.serialize(ele, prefix);
	}
	
}