/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.grammarAccess

import com.google.common.collect.Maps
import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.ibm.icu.text.Transliterator
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CompoundElement
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.RuleNames
import org.eclipse.xtext.TypeRef
import org.eclipse.xtext.UnorderedGroup
import org.eclipse.xtext.XtextRuntimeModule
import org.eclipse.xtext.formatting.ILineSeparatorInformation
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions

import static extension java.lang.Character.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*

/**
 * This API can be used by other templates to generate code
 * that has hard references to grammar rules/elements 
 * @author Moritz Eysholdt
 */
class GrammarAccessExtensions {
	
	val Map<String, ISerializer> xtextSerializerByLineDelimiter = Maps.newHashMapWithExpectedSize(2)
	
	val transliterator = Transliterator.getInstance('Any-Name')
	
	@Inject CodeConfig codeConfig
	
	@Inject extension XtextGeneratorNaming
	
	/**
	 * Returns a reference to the GrammarAccess implementation for a grammar.
	 */
	def TypeReference getGrammarAccess(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage + '.services.' + GrammarUtil.getSimpleName(grammar) + 'GrammarAccess')
	}
	
	/**
	 * Returns the invocation of the element accessor method as fully qualified Java statement.
	 * Example: return FowlerDslTestLanguageGrammarAccess.INSTANCE.prStatemachine().ele1AssignmentStates()
	 */	
	def StringConcatenationClient gaFullAccessor(AbstractElement ele) {
		'''«ele.grammar.grammarAccess».INSTANCE.«ele.gaRuleElementAccessor»'''
	}

	/**
	 * Converts an arbitary string to a valid Java identifier.
	 * The string is split up along the the characters that are not valid as java 
	 * identifier. The first character of each segments is made upper case which 
	 * leads to a camel-case style.
	 * @param text the string
	 * @param uppercaseFirst whether the first character of the returned identifier should be uppercase or lowercase
	 */
	def String toJavaIdentifier(String text, boolean uppercaseFirst) {
		try {
			return toJavaIdentifierSegment(text, true, uppercaseFirst)
		} catch (Throwable t) {
			t.printStackTrace()
			return '%_FAILURE_(' + text + ')%'
		}
	}

	private def String toJavaIdentifier(List<String> text, boolean uppercaseFirst) {
		val i = text.iterator
		val b = new StringBuilder(toJavaIdentifierSegment(i.next(), true, uppercaseFirst))
		while (i.hasNext) {
			b.append(toJavaIdentifierSegment(i.next, false, true))
		}
		return b.toString
	}

	private def String toJavaIdentifierSegment(String text, boolean isFirst, boolean uppercaseFirst) {
		val r = toJavaIdentifierSegmentInt(text, isFirst, uppercaseFirst)
		if (r.length > 0) {
			return r
		}
		val builder = new StringBuilder
		for (c : text.toCharArray) {
			val n = getUnicodeName(c)
			if (n != null)
				builder.append(n + ' ')
		}
		return toJavaIdentifierSegmentInt(builder.toString.toLowerCase.trim, isFirst, true)
	}

	/**
	 * Returns the Unicode string name for a character.
	 */
	def String getUnicodeName(char character) {
		val transliterated = transliterator.transliterate(String.valueOf(character))
		return transliterated.substring('\\N{'.length, transliterated.length - '}'.length)
	}

	private def String toJavaIdentifierSegmentInt(String text, boolean isFirst, boolean uppercaseFirst) {
		var start = isFirst
		var up = true
		val builder = new StringBuilder
		for (c : text.toCharArray) {
			val valid = if (start) c.isJavaIdentifierStart else c.isJavaIdentifierPart
			if (valid) {
				if (start)
					builder.append(if (uppercaseFirst) c.toUpperCase else c.toLowerCase)
				else
					builder.append(if (up) c.toUpperCase else c)
				up = false
				start = false
			} else
				up = true
		}
		return builder.toString
	}
		
	/** 
	 * Creates an identifier for a Rule which is a valid Java identifier and unique within 
	 * the Rule's grammar and its super grammars.
	 */
	def String gaRuleIdentifier(AbstractRule rule) {
		val plainName = RuleNames.getRuleNames(rule).getUniqueRuleName(rule);
		return toJavaIdentifier(plainName, true);
	}
	
	/** 
	 * Creates an identifier for a Rule which is a valid Java identifier and unique within 
	 * the grammar that defines the rule.
	 */
	def String gaBaseRuleIdentifier(AbstractRule rule) {
		rule.name.toJavaIdentifier(true)
	}
		
	/**
	 * Creates an identifier for an AbstractElement which is a valid Java identifier and
	 * which is unique whithin the element's rule. The identifier tries to be as 
	 * human-readable as possible.
	 */
	def String gaElementIdentifier(AbstractElement element) {
		try {
			if (element === null)
				return 'null'
			val result = new ArrayList<String>
			result.addAll(element.elementDescription)
			result.add(element.elementTypeDescription)
			result.add(element.elementPath)
			return toJavaIdentifier(result, true)
		} catch (Throwable t) {
			t.printStackTrace()
			return 'failure'
		}
	}

	private def List<String> getElementDescription(AbstractElement element) {
		val result = new ArrayList<String>
		var container = element
		while (container !== null) {
			result.addAll(0, container.singleElementDescription)
			val eContainer = container.eContainer
			container = if (eContainer instanceof AbstractElement) eContainer else null
		}
		return result
	}

	private def List<String> getSingleElementDescription(AbstractElement ele) {
		val r = new ArrayList<String>(2)
		switch ele {
			Keyword:
				r += ele.value
			Assignment:
				r += ele.feature
			RuleCall:
				r += ele.rule.name
			Action: {
				if (ele.type?.classifier !== null)
					r += ele.type.classifier.name
				if (!ele.feature.nullOrEmpty)
					r += ele.feature
			}
			CrossReference:
				if (ele.type?.classifier !== null)
					r += ele.type.classifier.name
			EnumLiteralDeclaration:
				r += ele.enumLiteral.name
		}
		return r
	}

	private def String getElementTypeDescription(AbstractElement ele) {
		if (ele instanceof RuleCall)
			ele.rule.eClass.name + 'Call'
		else
			ele.eClass.name
	}

	private def String getElementPath(AbstractElement ele) {
		var EObject obj = ele;
		val result = new StringBuilder
		while (!(obj.eContainer instanceof AbstractRule) && obj.eContainer !== null) {
			val eContainer = obj.eContainer
			result.insert(0, eContainer.eContents.indexOf(obj))
			result.insert(0, '_')
			obj = eContainer
		}
		return result.toString
	}
	
	/**
	 * Returns the method name for accessing a rule via a GrammarAccess implementation.
	 */
	def String gaRuleAccessMethodName(AbstractRule rule) {
		'get' + rule.gaRuleIdentifier + 'Rule'
	}
	
	/**
	 * Returns the method name for accessing a rule via a GrammarAccess implementation.
	 */
	def String gaBaseRuleAccessMethodName(AbstractRule rule) {
		'get' + rule.gaBaseRuleIdentifier + 'Rule'
	}
		
	/**
	 * Returns the method name for accessing a rule's content via a ParserRuleAccess implementation.
	 */
	def String gaRuleElementsMethodName(AbstractRule rule) {
		'get' + rule.gaRuleIdentifier + 'Access'
	}
	
	/**
	 * Returns the method name for accessing a rule's content via a ParserRuleAccess implementation.
	 */
	def String gaBaseRuleElementsMethodName(AbstractRule rule) {
		'get' + rule.gaBaseRuleIdentifier + 'Access'
	}
	
	/**
	 * Returns the method name for accessing an element via a GrammarAccess implementation.
	 */
	def String gaElementAccessMethodName(AbstractElement element) {
		'get' + element.gaElementIdentifier
	}
	
	/**
	 * Returns the simple class name of a rule's facade. A GrammarAccess implementation has
	 * a facade for each parser rule, which contains the methods for accessing the rule's elements.
	 */	
	def String gaRuleAccessorClassName(AbstractRule rule) {
		rule.gaRuleIdentifier + 'Elements'
	}
	
	/**
	 * Returns the simple class name of a rule's facade. A GrammarAccess implementation has
	 * a facade for each parser rule, which contains the methods for accessing the rule's elements.
	 */	
	def String gaBaseRuleAccessorClassName(AbstractRule rule) {
		rule.gaBaseRuleIdentifier + 'Elements'
	}
		
	/**
	 * Returns the invocation of the rule accessor method as Java statement.
	 */	
	def String gaRuleAccessor(AbstractRule rule) {
		rule.gaRuleAccessMethodName + '()'
	}
	
	/**
	 * Returns the invocation of the rule accessor method as Java statement.
	 */	
	def String gaBaseRuleAccessor(AbstractRule rule) {
		rule.gaBaseRuleAccessMethodName + '()'
	}
	
	/**
	 * Returns the invocation of the rule's content accessor method as Java statement.
	 */	
	def String gaElementsAccessor(AbstractRule rule) {
		rule.gaRuleElementsMethodName + '()'
	}
	
	/**
	 * Returns the invocation of the rule's content accessor method as Java statement.
	 */	
	def String gaBaseElementsAccessor(AbstractRule rule) {
		rule.gaBaseRuleElementsMethodName + '()'
	}
		
	/**
	 * Returns the invocation of the element accessor method as Java statement.
	 * The called method is implemented by the rule's facade.
	 * Example: ele1AssignmentStates()
	 */	
	def String gaElementAccessor(AbstractElement ele){
		ele.gaElementAccessMethodName + '()'
	}
		
	/**
	 * Returns the invocation of the element accessor method for a GrammarAccess 
	 * as Java statement.
	 * Example: prStatemachine().ele1AssignmentStates()
	 */	
	def String gaRuleElementAccessor(AbstractElement ele) {
		ele.containingRule.gaElementsAccessor + '.' + ele.gaElementAccessor
	}
	
	/**
	 * Returns the invocation of an element or rule accessor, including the .getType() call.
	 * Example1: getFooRule().getType()
	 * Example2: getBarRule().getFooAction().getType()
	 */
	def String gaTypeAccessor(TypeRef ele) {
		switch cnt: ele.eContainer {
			AbstractElement: cnt.gaRuleElementAccessor + '.getType()'
			AbstractRule: cnt.gaRuleAccessor + '.getType()'
			default: '<error: unknown type ' + ele.eContainer.eClass.name + '>'
		};
	}
	/**
	 * Returns the invocation of an element or rule accessor.
	 * Example1: getFooRule()
	 * Example2: getBarRule().getFooAction()
	 */
	def String gaAccessor(EObject ele) {
		switch ele {
			AbstractElement: ele.gaRuleElementAccessor
			AbstractRule: ele.gaRuleAccessor
			default: '<error: unknown type ' + ele.eClass.name + '>'
		}
	}
	
	def String grammarFragmentToString(EObject ele, String prefix) {
		var String s
		try {
			val options = SaveOptions.newBuilder.format.options
			s = serializer.serialize(ele, options)
		} catch (Exception e) {
			s = e.toString
		}
		s = prefix + s.trim.replaceAll('(\\r?\\n)', '$1' + prefix).replaceAll('/\\*', '/ *').replaceAll('\\*/', '* /')
		return s
	}
	
	dispatch def grammarElementIdentifier(EObject it) {
		"Unsupported : grammarElementIdentifier for: " + toString
	}

	dispatch def grammarElementIdentifier(AbstractRule it) {
		gaRuleIdentifier
	}

	dispatch def String grammarElementIdentifier(AbstractElement it) {
		containingRule.grammarElementIdentifier + '_' +  gaElementIdentifier
	}

	dispatch def grammarElementAccess(EObject it) {
		"Unsupported : grammarElementAccess for: " + toString
	}

	dispatch def grammarElementAccess(AbstractRule it) {
		gaRuleAccessor
	}

	dispatch def grammarElementAccess(AbstractElement it) {
		gaRuleElementAccessor
	}

	def List<String> initialHiddenTokens(Grammar it) {
		if (definesHiddenTokens) {
			return hiddenTokens.map[ruleName].toList
		}
		if (usedGrammars.size == 1) {
			return initialHiddenTokens(usedGrammars.head)
		}
		emptyList
	}

	def ruleName(AbstractRule rule) {
		val result = RuleNames.getRuleNames(rule).getAntlrRuleName(rule);
		return result;
	}

	def entryRuleName(ParserRule rule) {
		val result = RuleNames.getRuleNames(rule).getAntlrRuleName(rule);
		return 'entry' + result.toFirstUpper;
	}

	def isCalled(AbstractRule rule, Grammar grammar) {
		val allRules = grammar.allRules
		allRules.indexOf(rule) == 0 || allRules.map [
			GrammarUtil.containedRuleCalls(it)
		].flatten.exists[ruleCall | ruleCall.rule == rule]
	}

	def definesUnorderedGroups(ParserRule it, AntlrOptions options) {
		options.backtrack && !eAllContentsAsList.typeSelect(UnorderedGroup).empty
	}

	dispatch def mustBeParenthesized(AbstractElement it) { true }

	dispatch def mustBeParenthesized(Keyword it) { predicated() || firstSetPredicated || cardinality != null }

	dispatch def mustBeParenthesized(RuleCall it) { predicated() || firstSetPredicated || cardinality != null }
	
	dispatch def boolean predicated(AbstractElement it) {
		predicated
	}
	
	dispatch def boolean predicated(Assignment it) {
		predicated || terminal.predicated()
	}
	
	dispatch def boolean predicated(RuleCall it) {
		predicated || {
			val group  = rule.alternatives
			if (group instanceof Group) {
				group.elements.head.predicated()
			} else {
				false
			}
		}
	}

	def AbstractElement predicatedElement(AbstractElement it) {
		return AntlrGrammarGenUtil.getPredicatedElement(it)
	}

	def localVar(Assignment it, AbstractElement terminal) {
		'lv_' + feature + '_' + containingParserRule.contentsAsList.indexOf(it) + '_' +
			eAllContentsAsList.indexOf(terminal)
	}

	dispatch def localVar(RuleCall it) {
		'this_' + rule.name + '_' + containingParserRule.contentsAsList.indexOf(it)
	}

	dispatch def localVar(AbstractElement it) {
		val rule = containingParserRule
		val index = rule.contentsAsList.indexOf(it)
		'otherlv_' + index
	}

	dispatch def localVar(EnumLiteralDeclaration it) {
		'enumLiteral_' + containingEnumRule.alternatives.contentsAsList.indexOf(it)
	}

	dispatch def List<AbstractElement> contentsAsList(ParserRule it) {
		alternatives.contentsAsList
	}

	dispatch def List<AbstractElement> contentsAsList(AbstractElement it) {
		newArrayList(it)
	}

	dispatch def List<AbstractElement> contentsAsList(CompoundElement it) {
		elements.map[contentsAsList].flatten.toList
	}

	dispatch def List<AbstractElement> contentsAsList(UnorderedGroup it) {
		val result = <AbstractElement>newArrayList(it)
		result += elements.map[contentsAsList].flatten.toList
		result
	}

	def setOrAdd(Action it) {
		if(operator == '+=') 'add' else 'set'
	}

	def setOrAdd(Assignment it) {
		if(operator == '+=') 'add' else 'set'
	}

	def toStringLiteral(AbstractElement it) {
		switch it {
			RuleCall case rule != null: '''"«rule.name»"'''
			Keyword: '''"«value.toStringInAntlrAction»"'''
			default:
				"null"
		}
	}

	private def ISerializer getSerializer() {
		val delimiter = codeConfig.lineDelimiter
		var result = xtextSerializerByLineDelimiter.get(delimiter)
		if (result != null) {
			return result
		}
		val injector = Guice.createInjector(new LineSeparatorModule[delimiter])
		result = injector.getInstance(ISerializer)
		xtextSerializerByLineDelimiter.put(delimiter, result)
		return result;
	}

	@FinalFieldsConstructor
	protected static class LineSeparatorModule extends XtextRuntimeModule {
		
		val ILineSeparatorInformation lineSeparatorInformation;

		override configure(Binder binder) {
			// avoid duplicate registration of the validator
			val compound = getBindings()
			compound.configure(binder)
		}

		def ILineSeparatorInformation bindILineSeparatorInformation() {
			return lineSeparatorInformation;
		}
	}
	
}
