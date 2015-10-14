/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import com.google.common.collect.Iterators
import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.UnorderedGroup
import org.eclipse.xtext.generator.LineSeparatorHarmonizer
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.parser.antlr.postProcessing.SuppressWarningsProcessor
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrParserSplitter
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.BacktrackingGuardForUnorderedGroupsRemover
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SyntacticPredicateFixup
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.UnorderedGroupsSplitter

abstract class AbstractAntlrGeneratorFragment2 extends AbstractGeneratorFragment2 {
	@Inject @Accessors(PROTECTED_GETTER) AntlrToolFacade antlrTool
	@Inject @Accessors(PROTECTED_GETTER) AntlrCodeQualityHelper codeQualityHelper
	@Inject @Accessors(PROTECTED_GETTER) LineSeparatorHarmonizer newLineNormalizer
	@Inject @Accessors(PROTECTED_GETTER) CodeConfig codeConfig

	@Accessors AntlrOptions options = new AntlrOptions
	val antlrParams = <String>newArrayList

	def void addAntlrParam(String param) {
		antlrParams.add(param)
	}

	def String[] getAntlrParams() {
		var params = Lists.newArrayList(antlrParams)
		// setting the default conversion timeout to 100secs.
		// There seem to be no practical situations where the NFA conversion would hang,
		// so Terence suggested here [1] to remove the option all together
		// [1] - http://antlr.1301665.n2.nabble.com/Xconversiontimeout-td5294411.html
		if (!params.contains("-Xconversiontimeout")) {
			params.add(0, "-Xconversiontimeout")
			params.add(1, "100000")
		}
		return params
	}

	override void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (!antlrTool.isWorkable) {
			issues.addError("\n\n*ATTENTION*\nIt is highly recommended to use ANTLR's parser generator (get it from 'http://xtext.itemis.com/'). \nAs an alternative to ANTLR you could also use the alternative implementation shipped with Xtext.\nTo do so use the generator fragment 'org.eclipse.xtext.generator.parser.packrat.PackratParserFragment' in your mwe2 file instead.")
		}
	}

	override void generate() {
		checkGrammar()
		doGenerate()
	}

	def protected abstract void doGenerate()

	def protected void checkGrammar() {
		if(!hasProductionRules(getGrammar()))
			throw new IllegalArgumentException("You may not generate an ANTLR parser for a grammar without production rules.")
	}

	def protected boolean hasProductionRules(Grammar grammar) {
		var AbstractRule firstRule = grammar.getRules().get(0)
		return firstRule instanceof ParserRule && !GrammarUtil::isDatatypeRule(firstRule as ParserRule)
	}

	def protected void splitLexerClassFile(IXtextGeneratorFileSystemAccess fsa, TypeReference lexer) {
		val content = fsa.readTextFile(lexer.javaPath).toString
		var AntlrLexerSplitter splitter = new AntlrLexerSplitter(content)
		fsa.generateFile(lexer.javaPath, splitter.transform)
	}

	def protected void splitParserClassFile(IXtextGeneratorFileSystemAccess fsa, TypeReference parser) {
		val content = fsa.readTextFile(parser.javaPath).toString
		val splitter = new AntlrParserSplitter(content, getOptions.fieldsPerClass)
		val extractor = new PartialClassExtractor(splitter.transform, getOptions.methodsPerClass)
		fsa.generateFile(parser.javaPath, extractor.transform)
	}

	def protected void simplifyUnorderedGroupPredicatesIfRequired(Grammar grammar, IXtextGeneratorFileSystemAccess fsa, TypeReference parser) {
		if (containsUnorderedGroup(grammar) || hasParameterizedRules(grammar)) {
			simplifyUnorderedGroupPredicates(fsa, parser)
		}
	}

	def protected boolean hasParameterizedRules(Grammar grammar) {
		for (ParserRule rule : GrammarUtil::allParserRules(grammar)) {
			if (!rule.getParameters().isEmpty()) {
				return true
			}

		}
		return false
	}

	def protected void simplifyUnorderedGroupPredicates(IXtextGeneratorFileSystemAccess fsa, TypeReference parser) {
		val content = fsa.readTextFile(parser.javaPath).toString
		var UnorderedGroupsSplitter splitter = new UnorderedGroupsSplitter(content)
		var String transformed = splitter.transform()
		var SyntacticPredicateFixup fixup = new SyntacticPredicateFixup(transformed)
		transformed = fixup.transform()
		var BacktrackingGuardForUnorderedGroupsRemover remover = new BacktrackingGuardForUnorderedGroupsRemover(transformed)
		var String newContent = remover.transform()
		fsa.generateFile(parser.javaPath, newContent)
	}

	def protected void suppressWarnings(IXtextGeneratorFileSystemAccess fsa, TypeReference type) {
		val content = fsa.readTextFile(type.javaPath).toString
		val newContent = new SuppressWarningsProcessor().process(content)
		fsa.generateFile(type.javaPath, newContent)
	}
	def protected void suppressWarnings(IXtextGeneratorFileSystemAccess fsa, TypeReference... types) {
		types.forEach[suppressWarnings(fsa, it)]
	}

	def protected void normalizeLineDelimiters(IXtextGeneratorFileSystemAccess fsa, TypeReference type) {
		var String content = fsa.readTextFile(type.javaPath).toString
		content = newLineNormalizer.postProcess(fsa.getURI(type.javaPath), content).toString
		// Antlr tries to outsmart us by using a line length that depends on the system
		// line delimiter when it splits a very long String (encoded DFA) into a
		// string concatenation
		// Here we join these lines again.
		content = content.replaceAll("\"\\+(\\r)?\\n\\s+\"", "")
		fsa.generateFile(type.javaPath, content)
	}
	
	def protected void normalizeLineDelimiters(IXtextGeneratorFileSystemAccess fsa, TypeReference... types) {
		types.forEach[normalizeLineDelimiters(fsa, it)]
	}

	def protected void normalizeTokens(IXtextGeneratorFileSystemAccess fsa, String tokenFile) {
		var content = fsa.readTextFile(tokenFile).toString
		content = newLineNormalizer.postProcess(fsa.getURI(tokenFile), content).toString
		val splitted = Strings.split(content, codeConfig.lineDelimiter)
		Collections.sort(splitted)
		content = Strings.concat(codeConfig.lineDelimiter, splitted) + codeConfig.lineDelimiter
		fsa.generateFile(tokenFile, content)
	}

	def protected void splitParserAndLexerIfEnabled(IXtextGeneratorFileSystemAccess fsa, TypeReference lexer, TypeReference parser) {
		improveCodeQuality(fsa, lexer, parser)
		if (getOptions().isClassSplitting()) {
			splitLexerClassFile(fsa, lexer)
			splitParserClassFile(fsa, parser)
		}
	}

	def protected improveCodeQuality(IXtextGeneratorFileSystemAccess fsa, TypeReference lexer, TypeReference parser) {
		var lexerContent = fsa.readTextFile(lexer.javaPath).toString
		lexerContent = codeQualityHelper.stripUnnecessaryComments(lexerContent, options)
		fsa.generateFile(lexer.javaPath, lexerContent)

		var parserContent = fsa.readTextFile(parser.javaPath).toString
		parserContent = codeQualityHelper.stripUnnecessaryComments(parserContent, options)
		parserContent = codeQualityHelper.removeDuplicateBitsets(parserContent, options)
		parserContent = codeQualityHelper.removeDuplicateDFAs(parserContent, options)
		fsa.generateFile(parser.javaPath, parserContent)
	}

	def protected boolean containsUnorderedGroup(Grammar grammar) {
		for (ParserRule rule : GrammarUtil::allParserRules(grammar)) {
			if (Iterators::filter(rule.eAllContents(), UnorderedGroup).hasNext()) {
				return true
			}
		}
		return false
	}
}
