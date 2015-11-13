/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext

import java.util.ArrayList
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.XtextAntlrIDEAGeneratorFragment
import org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
import org.eclipse.xtext.xtext.generator.resourceFactory.ResourceFactoryFragment2
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorComparisonFragment
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions

/**
 * @author efftinge - Initial contribution and API
 */
@Accessors
class TestLanguage extends XtextGeneratorLanguage {
	
	org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions parserOptions = new org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions() => [
		classSplitting = true
	]
	
	def void setParserOptions(org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions parserOptions) {
		this.parserOptions = parserOptions
		parserGenerator.options = parserOptions
		ideaParser.options = parserOptions
	}
	
	GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2
	SerializerFragment2 serializer = new SerializerFragment2 => [
		generateStub = false
	]
	ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2
	EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2
	XtextAntlrGeneratorFragment2 parserGenerator = new XtextAntlrGeneratorFragment2  => [
		debugGrammar = true
		options = parserOptions
	]
	XtextAntlrIDEAGeneratorFragment ideaParser = new XtextAntlrIDEAGeneratorFragment => [
		options = parserOptions
	]
	
	IdeaPluginGenerator ideaPlugin = new IdeaPluginGenerator
	
	override protected getImplicitFragments() {
		val result = new ArrayList(super.getImplicitFragments())
		result += parserGenerator
		val comparison = new XtextAntlrGeneratorComparisonFragment
		comparison.setOptions(new AntlrOptions() => [
			it.backtrack = parserGenerator.options.backtrack
			it.backtrackLexer = parserGenerator.options.backtrackLexer
			it.classSplitting = parserGenerator.options.classSplitting
			it.casesPerSpecialStateSwitch = parserGenerator.options.casesPerSpecialStateSwitch.toString
			it.fieldsPerClass = parserGenerator.options.fieldsPerClass.toString
			it.ignoreCase = parserGenerator.options.ignoreCase
			it.k = parserGenerator.options.k
			it.memoize = parserGenerator.options.memoize
			it.optimizeCodeQuality= parserGenerator.options.optimizeCodeQuality
			it.skipUnusedRules = parserGenerator.options.skipUnusedRules
			it.stripAllComments = parserGenerator.options.stripAllComments
		]);
		result += comparison
		result += grammarAccess
		result += emfGenerator
		result += serializer
		result += resourceFactoryFragment
		result += ideaParser
		result += ideaPlugin
		return result
	}
	
}
