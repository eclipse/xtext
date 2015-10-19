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
import java.util.Collection
import java.util.HashMap
import java.util.Map
import org.antlr.runtime.CharStream
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.Token
import org.antlr.runtime.TokenSource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Group
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter
import org.eclipse.xtext.conversion.impl.IgnoreCaseIDValueConverter
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.parser.ITokenToStringConverter
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource
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
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer
import org.eclipse.xtext.parsetree.reconstr.impl.IgnoreCaseKeywordSerializer
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector

class XtextAntlrGeneratorFragment2 extends AbstractAntlrGeneratorFragment2 {
	@Accessors
	boolean debugGrammar
	
	@Accessors
	Boolean combinedGrammar = null
	
	@Accessors
	boolean removeBacktrackingGuards
	
	int lookaheadThreshold
	
	@Accessors
	boolean partialParsing

	@Inject AntlrGrammarGenerator productionGenerator
	@Inject AntlrContentAssistGrammarGenerator contentAssistGenerator
	@Inject AntlrDebugGrammarGenerator debugGenerator

	@Inject FileAccessFactory fileFactory

	@Inject GrammarNaming productionNaming
	@Inject ContentAssistGrammarNaming contentAssistNaming
	
	@Inject extension GrammarAccessExtensions grammarUtil
	@Inject extension SyntheticTerminalDetector

	override protected doGenerate() {
		new KeywordHelper(grammar, options.ignoreCase, grammarUtil)
		new CombinedGrammarMarker(isCombinedGrammar).attachToEmfObject(grammar)
		generateProductionGrammar
		if (projectConfig.genericIde.srcGen != null)
			generateContentAssistGrammar
		if (debugGrammar)
			generateDebugGrammar
		
		generateProductionParser.writeTo(projectConfig.runtime.srcGen)
		generateAntlrTokenFileProvider.writeTo(projectConfig.runtime.srcGen)
		generateContentAssistParser.writeTo(projectConfig.genericIde.srcGen)
		if (!isCombinedGrammar) {
			generateProductionTokenSource.writeTo(projectConfig.runtime.srcGen)
			generateContentAssistTokenSource.writeTo(projectConfig.genericIde.srcGen)
		}
		addRuntimeBindingsAndImports
		addUiBindingsAndImports
	}
	
	def void setLookaheadThreshold(String lookaheadThreshold) {
		this.lookaheadThreshold = Integer.parseInt(lookaheadThreshold)
	}
	
	protected def generateProductionGrammar() {
		val extension naming = productionNaming
		val fsa = projectConfig.runtime.srcGen
		
		productionGenerator.generate(grammar, options, fsa)
		
		runAntlr(grammar.parserGrammar, grammar.lexerGrammar, fsa)
		
		simplifyUnorderedGroupPredicatesIfRequired(grammar, fsa, grammar.internalParserClass)
		splitParserAndLexerIfEnabled(fsa, grammar.internalParserClass, grammar.lexerClass)
		normalizeTokens(fsa, grammar.lexerGrammar.tokensFileName)
		suppressWarnings(fsa, grammar.internalParserClass, grammar.lexerClass)
		normalizeLineDelimiters(fsa, grammar.internalParserClass, grammar.lexerClass)
	}
	
	protected def generateContentAssistGrammar() {
		val extension naming = contentAssistNaming
		val fsa = projectConfig.genericIde.srcGen
		
		contentAssistGenerator.generate(grammar, options, fsa)
		
		runAntlr(grammar.parserGrammar, grammar.lexerGrammar, fsa)
		
		simplifyUnorderedGroupPredicatesIfRequired(grammar, fsa, grammar.internalParserClass)
		splitParserAndLexerIfEnabled(fsa, grammar.internalParserClass, grammar.lexerClass)
		normalizeTokens(fsa, grammar.lexerGrammar.tokensFileName)
		suppressWarnings(fsa, grammar.internalParserClass, grammar.lexerClass)
		normalizeLineDelimiters(fsa, grammar.lexerClass, grammar.internalParserClass)
		if (removeBacktrackingGuards) {
			removeBackTrackingGuards(fsa, grammar.internalParserClass, lookaheadThreshold)
		}
	}
	
	protected def runAntlr(AntlrGrammar parserGrammar, AntlrGrammar lexerGrammar, IXtextGeneratorFileSystemAccess fsa) {
		val encoding = codeConfig.encoding
		val lexerGrammarFile = '''«fsa.path»/«lexerGrammar.grammarFileName»'''
		val lexerAntlrParams = newArrayList(antlrParams)
		lexerAntlrParams += "-fo" 
		val lexerOutputDir = lexerGrammarFile.substring(0, lexerGrammarFile.lastIndexOf('/'))
		lexerAntlrParams += lexerOutputDir
		if (!isCombinedGrammar) {
			antlrTool.runWithEncodingAndParams(lexerGrammarFile, encoding,  lexerAntlrParams)
			cleanupLexerTokensFile(lexerGrammar, KeywordHelper.getHelper(grammar), fsa)
		}
		
		val parserGrammarFile = '''«fsa.path»/«parserGrammar.grammarFileName»'''
		val parserAntlrParams = newArrayList(antlrParams)
		parserAntlrParams += "-fo" 
		parserAntlrParams += parserGrammarFile.substring(0, parserGrammarFile.lastIndexOf('/'))
		if (!isCombinedGrammar) {
			parserAntlrParams += "-lib"
			parserAntlrParams += lexerOutputDir
		}
		antlrTool.runWithEncodingAndParams(parserGrammarFile, encoding,  parserAntlrParams)
		if (!isCombinedGrammar) {
			cleanupParserTokensFile(lexerGrammar, parserGrammar, KeywordHelper.getHelper(grammar), fsa)
		}
	}
	
	def isCombinedGrammar() {
		combinedGrammar == null && !options.backtrackLexer && !options.ignoreCase || combinedGrammar == Boolean.TRUE
	}
	
	protected def generateDebugGrammar() {
		val fsa = projectConfig.runtime.srcGen
		debugGenerator.generate(grammar, options, fsa)
	}
	
	def JavaFileAccess generateProductionParser() {
		val extension naming = productionNaming
		val file = fileFactory.createGeneratedJavaFile(grammar.parserClass)
		file.content = '''
			public class «grammar.parserClass.simpleName» extends «AbstractAntlrParser» {
			
				@«Inject»
				private «grammar.grammarAccess» grammarAccess;

				@Override
				protected void setInitialHiddenTokens(«XtextTokenStream» tokenStream) {
					tokenStream.setInitialHiddenTokens(«FOR hidden : grammar.initialHiddenTokens SEPARATOR ", "»"«hidden»"«ENDFOR»);
				}
				
				«IF grammar.allTerminalRules.exists[isSyntheticTerminalRule]»
					@Override
					protected «TokenSource» createLexer(«CharStream» stream) {
						return new «grammar.tokenSourceClass»(super.createLexer(stream));
					}
					
					/**
					 * Indentation aware languages do not support partial parsing since the lexer is inherently stateful.
					 * Override and return {@code true} if your terminal splitting is stateless.
					 */
					@Override
					protected boolean isReparseSupported() {
						return false;
					}
				«ENDIF»
			
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
		val extension naming = productionNaming
		val file = fileFactory.createGeneratedJavaFile(grammar.antlrTokenFileProviderClass)
		file.content = '''
			public class «grammar.antlrTokenFileProviderClass.simpleName» implements «IAntlrTokenFileProvider» {
			
				@Override
				public «InputStream» getAntlrTokenFile() {
					«ClassLoader» classLoader = getClass().getClassLoader();
					return classLoader.getResourceAsStream("«grammar.lexerGrammar.tokensFileName»");
				}
			}
		'''
		file
	}
	
	def JavaFileAccess generateProductionTokenSource() {
		val extension naming = productionNaming
		val file = fileFactory.createGeneratedJavaFile(grammar.tokenSourceClass)
		val open = grammar.allTerminalRules.filter[#{"BEGIN", "INDENT", "OPEN"}.contains(name.toUpperCase)]
		val close = grammar.allTerminalRules.filter[#{"END", "DEDENT", "CLOSE"}.contains(name.toUpperCase)]
		file.content = '''
			public class «grammar.tokenSourceClass.simpleName» extends «AbstractIndentationTokenSource» {
			
				public «grammar.tokenSourceClass.simpleName»(«TokenSource» delegate) {
					super(delegate);
				}
			
				@Override
				protected boolean shouldSplitTokenImpl(«Token» token) {
					«IF grammar.allTerminalRules.exists[name.toUpperCase == "WS"]»
						// TODO Review assumption
						return token.getType() == «grammar.internalParserClass».RULE_WS;
					«ELSE»
						// TODO Implement me
						throw new UnsupportedOperationException("Implement me");
					«ENDIF»
				}
			
				@Override
				protected int getBeginTokenType() {
					«IF open.size == 1»
						// TODO Review assumption
						return «grammar.internalParserClass».«open.head.ruleName»;
					«ELSE»
						// TODO Implement me
						throw new UnsupportedOperationException("Implement me");
					«ENDIF»
				}
			
				@Override
				protected int getEndTokenType() {
					«IF close.size == 1»
						// TODO Review assumption
						return «grammar.internalParserClass».«close.head.ruleName»;
					«ELSE»
						// TODO Implement me
						throw new UnsupportedOperationException("Implement me");
					«ENDIF»
				}
			
			}
		'''
		file
	}
	
	def JavaFileAccess generateContentAssistParser() {
		val extension naming = contentAssistNaming
		val file = fileFactory.createGeneratedJavaFile(grammar.parserClass)
		file.content = '''
			public class «grammar.parserClass.simpleName» extends «grammar.getParserSuperClass(partialParsing)» {
			
				@«Inject»
				private «grammar.grammarAccess» grammarAccess;
			
				private «Map»<«AbstractElement», String> nameMappings;
			
				@Override
				protected «grammar.internalParserClass» createParser() {
					«grammar.internalParserClass» result = new «grammar.internalParserClass»(null);
					result.setGrammarAccess(grammarAccess);
					return result;
				}
			
				«IF grammar.allTerminalRules.exists[isSyntheticTerminalRule]»
					@Override
					protected «TokenSource» createLexer(CharStream stream) {
						return new «grammar.tokenSourceClass»(super.createLexer(stream));
					}
					
				«ENDIF»
				@Override
				protected String getRuleName(«AbstractElement» element) {
					if (nameMappings == null) {
						nameMappings = new «HashMap»<«AbstractElement», String>() {
							private static final long serialVersionUID = 1L;
							{
								«FOR element : (grammar.allAlternatives + grammar.allGroups + grammar.allAssignments + grammar.allUnorderedGroups).filter(AbstractElement)»
									put(grammarAccess.«element.grammarElementAccess», "«element.containingRule.contentAssistRuleName»__«element.gaElementIdentifier»«IF element instanceof Group»__0«ENDIF»");
								«ENDFOR»
							}
						};
					}
					return nameMappings.get(element);
				}
			
				@Override
				protected «Collection»<«"org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement".typeRef»> getFollowElements(«grammar.internalParserSuperClass» parser) {
					try {
						«grammar.internalParserClass» typedParser = («grammar.internalParserClass») parser;
						typedParser.«grammar.allParserRules.head.originalElement.entryRuleName»();
						return typedParser.getFollowElements();
					} catch(«RecognitionException» ex) {
						throw new RuntimeException(ex);
					}
				}
			
				@Override
				protected String[] getInitialHiddenTokens() {
					return new String[] { «FOR hidden : grammar.initialHiddenTokens SEPARATOR ", "»"«hidden»"«ENDFOR» };
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
	
	def JavaFileAccess generateContentAssistTokenSource() {
		val extension naming = contentAssistNaming
		val file = fileFactory.createGeneratedJavaFile(grammar.tokenSourceClass)
		val open = grammar.allTerminalRules.filter[#{"BEGIN", "INDENT", "OPEN"}.contains(name.toUpperCase)]
		val close = grammar.allTerminalRules.filter[#{"END", "DEDENT", "CLOSE"}.contains(name.toUpperCase)]
		file.content = '''
			public class «grammar.tokenSourceClass.simpleName» extends «AbstractIndentationTokenSource» {
			
				public «grammar.tokenSourceClass.simpleName»(«TokenSource» delegate) {
					super(delegate);
				}
			
				@Override
				protected boolean shouldSplitTokenImpl(Token token) {
					«IF grammar.allTerminalRules.map[originalElement].exists[name.toUpperCase == "WS"]»
						// TODO Review assumption
						return token.getType() == «grammar.internalParserClass».RULE_WS;
					«ELSE»
						// TODO Implement me
						throw new UnsupportedOperationException("Implement me");
					«ENDIF»
				}
			
				@Override
				protected int getBeginTokenType() {
					«IF open.size == 1»
						// TODO Review assumption
						return «grammar.internalParserClass».«open.head.ruleName»;
					«ELSE»
						// TODO Implement me
						throw new UnsupportedOperationException("Implement me");
					«ENDIF»
				}
			
				@Override
				protected int getEndTokenType() {
					«IF close.size == 1»
						// TODO Review assumption
						return «grammar.internalParserClass».«close.head.ruleName»;
					«ELSE»
						// TODO Implement me
						throw new UnsupportedOperationException("Implement me");
					«ENDIF»
				}
			
				@Override
				protected boolean shouldEmitPendingEndTokens() {
					return false;
				}
			}
		'''
		file
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (options.isBacktrackLexer && isCombinedGrammar)
			issues.addError("A combined grammar cannot have a backtracking lexer")
		if (options.isIgnoreCase && isCombinedGrammar)
			issues.addError("A combined grammar cannot have an ignorecase lexer")
		if (options.isBacktrackLexer && options.isIgnoreCase)
			issues.addError("Backtracking lexer and ignorecase cannot be combined for now.")
	}
	
	def addRuntimeBindingsAndImports() {
		val extension naming = productionNaming
		if (projectConfig.runtime.manifest !== null) {
			projectConfig.runtime.manifest=>[
				exportedPackages += #[
					grammar.lexerClass.packageName,
					grammar.parserClass.packageName,
					grammar.internalParserClass.packageName
				]
				requiredBundles += "org.antlr.runtime"
			]
		}
		val rtBindings = new GuiceModuleAccess.BindingFactory()
			.addTypeToType(IParser.typeRef, grammar.parserClass)
			.addTypeToType(ITokenToStringConverter.typeRef,AntlrTokenToStringConverter.typeRef)
			.addTypeToType(IAntlrTokenFileProvider.typeRef, grammar.antlrTokenFileProviderClass)
			.addTypeToType(grammar.lexerSuperClass, grammar.lexerClass)
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
		if (getOptions().isIgnoreCase()) {
			rtBindings
				.addTypeToType(ITokenSerializer.IKeywordSerializer.typeRef, IgnoreCaseKeywordSerializer.typeRef)
				.addTypeToType(AbstractIDValueConverter.typeRef, IgnoreCaseIDValueConverter.typeRef)
		}
		rtBindings.contributeTo(language.runtimeGenModule)
	
	}
	
	def addUiBindingsAndImports() {
		val extension naming = contentAssistNaming
		if (projectConfig.eclipsePlugin.manifest !== null) {
			projectConfig.eclipsePlugin.manifest=>[
				exportedPackages += #[
					grammar.lexerClass.packageName,
					grammar.parserClass.packageName,
					grammar.internalParserClass.packageName
				]
			]
		}
		val uiBindings = new GuiceModuleAccess.BindingFactory()
			.addTypeToType(
				"org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper".typeRef, 
				"org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper".typeRef
			)
			.addConfiguredBinding("HighlightingLexer", '''
				binder.bind(«Lexer».class)
					.annotatedWith(«Names».named(org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING))
					.to(«productionNaming.getLexerClass(grammar)».class);
			''')
			.addConfiguredBinding("ContentAssistLexer", '''
				binder.bind(«grammar.lexerSuperClass».class)
					.annotatedWith(«Names».named(org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST))
					.to(«grammar.lexerClass».class);
			''')
			.addConfiguredBinding("HighlightingTokenDefProvider", '''
				binder.bind(«ITokenDefProvider».class)
					.annotatedWith(«Names».named(org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING))
					.to(«AntlrTokenDefProvider».class);
			''')
			.addTypeToType(
				"org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory".typeRef,
				"org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory".typeRef
			)
			.addTypeToType(
				"org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser".typeRef,
				grammar.parserClass
			)
			.addConfiguredBinding("ContentAssistLexerProvider", '''
				binder.bind(«grammar.lexerClass».class)
					.toProvider(«LexerProvider».create(«grammar.lexerClass».class));
			''')
		if (partialParsing) {
			uiBindings.addTypeToType(
				"org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory".typeRef, 
				"org.eclipse.xtext.ide.editor.contentassist.antlr.PartialContentAssistContextFactory".typeRef
			)
		}
		uiBindings.contributeTo(language.eclipsePluginGenModule)
	}

}