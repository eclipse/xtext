/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.name.Names
import java.io.InputStream
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.parser.ITokenToStringConverter
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.parser.antlr.LexerBindings
import org.eclipse.xtext.parser.antlr.LexerProvider
import org.eclipse.xtext.parser.antlr.UnorderedGroupHelper
import org.eclipse.xtext.parser.antlr.XtextTokenStream
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*

class XtextAntlrGeneratorFragment2 extends AbstractAntlrGeneratorFragment2 {
	
	@Accessors
	boolean debugGrammar

	@Inject AntlrGrammarGenerator productionGenerator
	@Inject AntlrDebugGrammarGenerator debugGenerator

	@Inject CodeConfig codeConfig
	
	@Inject FileAccessFactory fileFactory

	@Inject extension GrammarNaming productionNaming
	@Inject extension GrammarAccessExtensions

	override protected doGenerate() {
		generateProductionGrammar
		if (debugGrammar) {
			generateDebugGrammar
		}
		generateXtextParser.writeTo(projectConfig.runtime.srcGen)
		generateAntlrTokenFileProvider.writeTo(projectConfig.runtime.srcGen)
		addBindingsAndImports
	}
	
	protected def generateProductionGrammar() {
		val fsa = projectConfig.runtime.srcGen
		productionGenerator.generate(grammar, options, fsa)
		
		val encoding = codeConfig.encoding
		val grammarFileName = '''«productionNaming.getGrammarClass(grammar).path».g'''
		val absoluteGrammarFileName = '''«fsa.path»/«grammarFileName»'''
		addAntlrParam('-fo')
		addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf('/')))
		antlrTool.runWithEncodingAndParams(absoluteGrammarFileName, encoding, antlrParams)
		
		simplifyUnorderedGroupPredicatesIfRequired(grammar, fsa, grammar.internalParserClass)
		splitParserAndLexerIfEnabled(fsa, grammar.lexerClass, grammar.internalParserClass)
		normalizeTokens(fsa, grammar.tokenFileName)
		#[grammar.internalParserClass, grammar.lexerClass].forEach[
			suppressWarnings(fsa, it)
			normalizeLineDelimiters(fsa, it)
		]
	}
	
	protected def generateDebugGrammar() {
		val fsa = projectConfig.runtime.srcGen
		debugGenerator.generate(grammar, options, fsa)
	}
	
	def JavaFileAccess generateXtextParser() {
		val file = fileFactory.createGeneratedJavaFile(grammar.parserClass)
		file.content = '''
			public class «grammar.parserClass.simpleName» extends «AbstractAntlrParser» {
			
				@«Inject»
				private «grammar.grammarAccess» grammarAccess;

				@Override
				protected void setInitialHiddenTokens(«XtextTokenStream» tokenStream) {
					tokenStream.setInitialHiddenTokens(«FOR hidden : grammar.initialHiddenTokens SEPARATOR ", "»"«hidden»"«ENDFOR»);
				}
			
				@Override
				protected «grammar.internalParserClass» createParser(«XtextTokenStream» stream) {
					return new «grammar.internalParserClass»(stream, getGrammarAccess());
				}
			
				@Override 
				protected String getDefaultRuleName() {
					return "«grammar.allParserRules.head.originalElement.name»";
				}
			
				public «grammar.grammarAccess» getGrammarAccess() {
					return this.grammarAccess;
				}
			
				public void setGrammarAccess(«grammar.grammarAccess» grammarAccess) {
					this.grammarAccess = grammarAccess;
				}
			}
		'''
		file
	}
	
	def JavaFileAccess generateAntlrTokenFileProvider() {
		val file = fileFactory.createGeneratedJavaFile(grammar.getAntlrTokenFileProviderClass)
		file.content = '''
			public class «grammar.antlrTokenFileProviderClass.simpleName» implements «IAntlrTokenFileProvider» {
			
				@Override
				public «InputStream» getAntlrTokenFile() {
					«ClassLoader» classLoader = getClass().getClassLoader();
					return classLoader.getResourceAsStream("«grammar.tokenFileName»");
				}
			}
		'''
		file
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (getOptions().isBacktrackLexer()) {
			issues.addError("This fragment does not support the option 'backtracking' for the lexer. Use 'org.eclipse.xtext.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment2' instead");
		}
		if (getOptions().isIgnoreCase()) {
			issues.addError("This fragment does not support the option 'ignorecase'. Use 'org.eclipse.xtext.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment2' instead");
		}
	}
	
	def addBindingsAndImports() {
		if (projectConfig.runtime.manifest !== null) {
			projectConfig.runtime.manifest=>[
				exportedPackages += #[
					grammar.parserPackage,
					grammar.internalParserPackage
				]
				requiredBundles += "org.antlr.runtime"
			]
		}
		val rtBindings = new GuiceModuleAccess.BindingFactory()
			.addTypeToType(IParser.typeRef, grammar.parserClass)
			.addTypeToType(ITokenToStringConverter.typeRef,AntlrTokenToStringConverter.typeRef)
			.addTypeToType(IAntlrTokenFileProvider.typeRef, grammar.antlrTokenFileProviderClass)
			.addTypeToType(Lexer.typeRef, grammar.lexerClass)
			.addTypeToType(ITokenDefProvider.typeRef, AntlrTokenDefProvider.typeRef)
			.addTypeToProviderInstance(grammar.lexerClass, '''«LexerProvider».create(«grammar.lexerClass».class)''')
			.addConfiguredBinding("RuntimeLexer", '''
					binder.bind(«Lexer».class)
						.annotatedWith(«Names».named(«LexerBindings».RUNTIME))
						.to(«grammar.lexerClass».class);
				'''
			)
		if (containsUnorderedGroup(grammar))
			rtBindings.addTypeToType(IUnorderedGroupHelper.typeRef, UnorderedGroupHelper.typeRef);
		rtBindings.contributeTo(language.runtimeGenModule)
		
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(
				"org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper".typeRef, 
				"org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper".typeRef
			)
			.addConfiguredBinding("HighlightingLexer", '''
				binder.bind(«Lexer».class)
					.annotatedWith(«Names».named(org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING))
					.to(«grammar.lexerClass».class);
			''')
			.addConfiguredBinding("HighlightingTokenDefProvider", '''
				binder.bind(«ITokenDefProvider».class)
					.annotatedWith(«Names».named(org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING))
					.to(«AntlrTokenDefProvider».class);
			''')
			.contributeTo(language.eclipsePluginGenModule)
	}

}