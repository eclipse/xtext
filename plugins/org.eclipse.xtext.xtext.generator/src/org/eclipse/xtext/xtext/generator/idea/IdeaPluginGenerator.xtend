/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.idea

import com.google.common.collect.LinkedHashMultimap
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Singleton
import com.google.inject.name.Names
import java.io.InputStream
import java.util.Arrays
import java.util.Collections
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.antlr.runtime.Token
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Action
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.parser.antlr.LexerBindings
import org.eclipse.xtext.service.LanguageSpecific
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess.BindingFactory
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TextFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

class IdeaPluginGenerator extends AbstractXtextGeneratorFragment {
	@Inject extension XtextGeneratorNaming
	@Inject extension XbaseUsageDetector
	@Inject ContentAssistGrammarNaming caNaming
	
	@Inject
	extension IdeaPluginExtension
	
	@Inject
	extension IdeaPluginClassNames
	
	@Inject
	extension GrammarAccessExtensions
	
	@Inject
	FileAccessFactory fileAccessFactory
	
	Set<String> libraries = newHashSet();
	
	@Accessors
	boolean deployable = true

	def addLibrary(String library) {
		libraries.add(library)
	}

	override generate() {
		if (!projectConfig.ideaPlugin.enabled)
			return;
		val fileExtension = language.getFileExtensions().head
		val grammar = language.grammar

		val bindFactory = new BindingFactory();
		bindFactory.addTypeToType('org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider'.typeRef, grammar.antlrTokenFileProvider)
		bindFactory.addTypeToType('org.eclipse.xtext.parser.antlr.Lexer'.typeRef, grammar.getPsiInternalLexer)
		bindFactory.addConfiguredBinding("RuntimeLexer", '''
			binder.bind(«Lexer».class)
				.annotatedWith(«Names».named(«LexerBindings».RUNTIME))
				.to(«grammar.psiInternalLexer».class);
		''')
		bindFactory.addTypeToType('com.intellij.lang.PsiParser'.typeRef, grammar.psiParser)
		bindFactory.addTypeToType('org.eclipse.xtext.idea.parser.TokenTypeProvider'.typeRef, grammar.tokenTypeProvider)
		bindFactory.addTypeToType('com.intellij.lang.ParserDefinition'.typeRef, grammar.parserDefinition)
		bindFactory.addTypeToTypeSingleton('org.eclipse.xtext.idea.lang.IElementTypeProvider'.typeRef, grammar.elementTypeProvider)
		bindFactory.addTypeToType('org.eclipse.xtext.idea.facet.AbstractFacetConfiguration'.typeRef, grammar.facetConfiguration)
		bindFactory.addTypeToInstance('com.intellij.facet.FacetTypeId'.typeRef, '''«grammar.facetType».TYPEID''')
		bindFactory.addTypeToType('org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser'.typeRef, caNaming.getParserClass(grammar))
		bindFactory.addConfiguredBinding('ContentAssistLexer',
			'''binder.bind(«'org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer'.typeRef».class).annotatedWith(«Names».named(«'org.eclipse.xtext.ide.LexerIdeBindings'.typeRef».CONTENT_ASSIST)).to(«caNaming.getLexerClass(grammar)».class);''')
		if (grammar.inheritsXbase) {
			bindFactory.addTypeToType('org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider'.typeRef, 'org.eclipse.xtext.idea.common.types.StubBasedTypeScopeProvider'.typeRef)
			bindFactory.addTypeToType(new TypeReference('org.eclipse.xtext.xbase.typesystem.internal', 'IFeatureScopeTracker.Provider'), 'org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider'.typeRef)
			bindFactory.addConfiguredBinding('LanguageSpecificPsiModelAssociations', '''
				binder.bind(«"org.eclipse.xtext.psi.IPsiModelAssociations".typeRef».class)
					.annotatedWith(«LanguageSpecific».class)
					.to(«"org.eclipse.xtext.idea.common.types.DerivedMemberAwarePsiModelAssociations".typeRef».class);
			''')
			bindFactory.addTypeToType('org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration'.typeRef, 'org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration'.typeRef)
			bindFactory.addTypeToType('org.eclipse.xtext.idea.formatting.BlockFactory'.typeRef, 'org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory'.typeRef)
			bindFactory.addTypeToType('org.eclipse.xtext.idea.formatting.ChildAttributesProvider'.typeRef, 'org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider'.typeRef)
			bindFactory.addTypeToType('org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider'.typeRef, 'org.eclipse.xtext.xbase.idea.bracketmatching.XbaseBracePairProvider'.typeRef)
			bindFactory.addTypeToType('org.eclipse.xtext.idea.findusages.IReferenceSearcher'.typeRef, 'org.eclipse.xtext.xbase.idea.findusages.JvmElementAwareReferenceSearcher'.typeRef)
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider'.typeRef, 'org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigProvider'.typeRef)
			bindFactory.addTypeToType('org.eclipse.xtext.idea.findusages.WordsScannerProvider'.typeRef, new TypeReference('org.eclipse.xtext.xbase.idea.findusages', 'XbaseWordsScanner.XbaseWordsScannerProvider'))
		}

		bindFactory.contributeTo(language.ideaGenModule)

		#[
			grammar.compileStandaloneSetup,
			grammar.compileIdeaSetup,
			grammar.compileCompletionContributor,
			grammar.compileFileType,
			grammar.compileFacetConfiguration,
			grammar.compileColorSettingsPage
		].forEach[
			writeTo(projectConfig.ideaPlugin.src)
		]

		#[
			grammar.compileServicesISetup,
			grammar.compileAbstractCompletionContributor,
			grammar.compileLanguage,
			grammar.compileAbstractFileType(fileExtension),
			grammar.compileFileTypeFactory,
			grammar.compileFileImpl,
			grammar.compileTokenTypeProvider,
			grammar.compileElementTypeProvider,
			grammar.compileParserDefinition,
			grammar.compileSyntaxHighlighterFactory,
			grammar.compileSemanticHighlightVisitor,
			grammar.compileExtensionFactory,
			grammar.compileCodeBlockModificationListener,
			grammar.compilePsiParser,
			grammar.compileAntlrTokenFileProvider,
			grammar.compilePomDeclarationSearcher,
			grammar.compileFacetType,
			grammar.compileBaseColorSettingsPage
		].forEach[
			writeTo(projectConfig.ideaPlugin.srcGen)
		]

		if (deployable) {
			val pluginXml = grammar.compilePluginXml
			if (!projectConfig.ideaPlugin.metaInf.isFile(pluginXml.path)) {
				pluginXml.writeTo(projectConfig.ideaPlugin.metaInf)
			}
			grammar.compilePluginGenXml.writeTo(projectConfig.ideaPlugin.metaInf)
		}
	}
	
	def iml() {
		".iml"
	}
	
	def compileExtensionFactory(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.extensionFactory, '''
			public class «grammar.extensionFactory.simpleName» implements «"com.intellij.openapi.extensions.ExtensionFactory".typeRef» {
				@Override
				public Object createInstance(«String» factoryArgument, «String» implementationClass) {
					«Class»<?> clazz;
					try {
						clazz = «Class».forName(implementationClass);
					} catch («ClassNotFoundException» e) {
						throw new «IllegalArgumentException»("Couldn't load "+implementationClass, e);
					}
					return «grammar.ideaLanguage».INSTANCE.<Object> getInstance(clazz);
				}
			}
		''')
	}
	def compileCodeBlockModificationListener(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.codeBlockModificationListener, '''
			public class «grammar.codeBlockModificationListener.simpleName» extends «"org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener".typeRef» {
			
				public «grammar.codeBlockModificationListener.simpleName»(«"com.intellij.psi.util.PsiModificationTracker".typeRef» psiModificationTracker) {
					super(«grammar.ideaLanguage».INSTANCE, psiModificationTracker);
				}
				«IF grammar.inheritsXbase»
					protected boolean hasJavaStructuralChanges(«"com.intellij.psi.impl.PsiTreeChangeEventImpl".typeRef» event) {
						return true;
					}
				«ENDIF»
			
			}
		''')
	}
	
	def compilePomDeclarationSearcher(Grammar it) {
		fileAccessFactory.createJavaFile(pomDeclarationSearcher, '''
			public class «pomDeclarationSearcher.simpleName» extends «"org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher".typeRef» {

				public «pomDeclarationSearcher.simpleName»() {
					super(«grammar.ideaLanguage».INSTANCE);
				}
			}
		''')
	}
	
	def compilePsiParser(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.psiParser, '''
			public class «grammar.psiParser.simpleName» extends «"org.eclipse.xtext.idea.parser.AbstractXtextPsiParser".typeRef» {

				«IF !grammar.initialHiddenTokens.empty»
				private static final «Set»<«String»> INITIAL_HIDDEN_TOKENS = new «HashSet»<«String»>(«Arrays».asList(«FOR hidden:grammar.initialHiddenTokens SEPARATOR ', '»"«hidden»"«ENDFOR»));
				«ELSE»
				private static final «Set»<«String»> INITIAL_HIDDEN_TOKENS = «Collections».emptySet();
				«ENDIF»

				@«Inject» 
				private «grammar.grammarAccess» grammarAccess;

				@«Inject» 
				private «grammar.elementTypeProvider» elementTypeProvider;

				@«Override»
				protected «"org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser".typeRef» createParser(«"com.intellij.lang.PsiBuilder".typeRef» builder, «"org.antlr.runtime.TokenStream".typeRef» tokenStream) {
					return new «grammar.psiInternalParser»(builder, tokenStream, elementTypeProvider, grammarAccess);
				}

				@«Override»
				protected «Set»<«String»> getInitialHiddenTokens() {
					return INITIAL_HIDDEN_TOKENS;
				}
			}
		''')
	}
		
	def compileAntlrTokenFileProvider(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.antlrTokenFileProvider, '''
			public class «grammar.antlrTokenFileProvider.simpleName» implements «IAntlrTokenFileProvider» {
				@«Override»
				public «InputStream» getAntlrTokenFile() {
					«ClassLoader» classLoader = getClass().getClassLoader();
			    	return classLoader.getResourceAsStream("«grammar.tokens»");
				}
			}
		''')
	}
	def compilePluginXml(Grammar grammar) {
		fileAccessFactory.createTextFile("plugin.xml", '''
			<idea-plugin version="2" xmlns:xi="http://www.w3.org/2001/XInclude">
				<id>«grammar.ideaBasePackage»</id>
				<name>«grammar.simpleName» Support</name>
				<description>
			      This plugin enables smart editing of «grammar.simpleName» files.
				</description>
				<version>1.0.0</version>
				<vendor>My Company</vendor>
			
				<idea-version since-build="131"/>
				<depends>org.eclipse.xtext.idea</depends>
			
				<xi:include href="plugin_gen.xml" xpointer="xpointer(/idea-plugin/*)"/>
			</idea-plugin>
		''')
	}
	
	def compilePluginGenXml(Grammar grammar){
		fileAccessFactory.createTextFile("plugin_gen.xml", '''
			<idea-plugin version="2">
				<extensions defaultExtensionNs="org.eclipse.xtext.idea">
					«FOR generatedMetamodel:grammar.metamodelDeclarations.filter(GeneratedMetamodel)»
						<package
							uri="«generatedMetamodel.EPackage.nsURI»"
							class="«grammar.namespace».«generatedMetamodel.name».«generatedMetamodel.name.toFirstUpper»Package"
						/>
				    «ENDFOR»
					<resourceFactory 
						type="«language.fileExtensions.head»"
						class="org.eclipse.xtext.resource.IResourceFactory"
						factoryClass="«grammar.extensionFactory»"
					/>
					<resourceServiceProvider
						uriExtension="«language.fileExtensions.head»"
						class="org.eclipse.xtext.idea.resource.IResourceIdeaServiceProvider"
						factoryClass="«grammar.extensionFactory»"
					/>

					<lang.setup
						language="«grammar.languageID»"
						implementationClass="«grammar.ideaSetup»"
					/>
				</extensions>

				<extensions defaultExtensionNs="com.intellij">
					<psi.treeChangePreprocessor implementation="«grammar.codeBlockModificationListener»"/>
			
					<fileTypeFactory implementation="«grammar.fileTypeFactory»"/>
					<stubElementTypeHolder class="«grammar.elementTypeProvider»"/>
					«grammar.compileExtension('lang.ast.factory', 'org.eclipse.xtext.idea.lang.BaseXtextASTFactory'.typeRef)»
					«grammar.compileExtension('lang.parserDefinition', grammar.parserDefinition)»
					«grammar.compileExtension('lang.findUsagesProvider', 'org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider'.typeRef)»
					«grammar.compileExtension('lang.refactoringSupport', 'org.eclipse.xtext.idea.refactoring.BaseXtextRefactoringSupportProvider'.typeRef)»
					«grammar.compileExtension('lang.namesValidator', 'com.intellij.lang.refactoring.NamesValidator'.typeRef)»
					<lang.syntaxHighlighterFactory key="«grammar.languageID»" implementationClass="«grammar.syntaxHighlighterFactory»" />
					«grammar.compileExtension('lang.braceMatcher', 'com.intellij.lang.PairedBraceMatcher'.typeRef)»
					«grammar.compileExtension('annotator', 'org.eclipse.xtext.idea.annotation.IssueAnnotator'.typeRef)»
					<completion.contributor language="«grammar.languageID»" implementationClass="«grammar.completionContributor»"/>
					<pom.declarationSearcher implementation="«grammar.pomDeclarationSearcher»"/>

					«grammar.compileExtension('lang.psiStructureViewFactory', 'com.intellij.lang.PsiStructureViewFactory'.typeRef)»
					<facetType implementation="«grammar.facetType»"/>
			      	«grammar.compileExtension('lang.documentationProvider', 'org.eclipse.xtext.idea.documentation.IdeaDocumentationProvider'.typeRef)»
					<colorSettingsPage implementation="«grammar.colorSettingsPage»"/>
					<highlightVisitor implementation="«grammar.semanticHighlightVisitor»"/>

					«grammar.compileExtension('lang.formatter', 'com.intellij.formatting.FormattingModelBuilder'.typeRef)»
					«grammar.compileExtension('lang.commenter', 'com.intellij.lang.CodeDocumentationAwareCommenter'.typeRef)»
				</extensions>
			</idea-plugin>
		''')
	}
	
	def compileExtension(Grammar grammar, String extensionPointId, TypeReference implementationClass) '''
		<«extensionPointId» 
			language="«grammar.languageID»"
			factoryClass="«grammar.extensionFactory»"
			implementationClass="«implementationClass»"
		/>
	'''
	
	def compileFileImpl(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.fileImpl, '''
			public final class «grammar.fileImpl.simpleName» extends «"org.eclipse.xtext.psi.impl.BaseXtextFile".typeRef» {
			
				public «grammar.fileImpl.simpleName»(«"com.intellij.psi.FileViewProvider".typeRef» viewProvider) {
					super(viewProvider, «grammar.ideaLanguage».INSTANCE);
				}
			
				@Override
				public «"com.intellij.openapi.fileTypes.FileType".typeRef» getFileType() {
					return «grammar.fileType».INSTANCE;
				}
			}
		''')
	}
	def compileFileTypeFactory(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.fileTypeFactory, '''
			public class «grammar.fileTypeFactory.simpleName» extends «"com.intellij.openapi.fileTypes.FileTypeFactory".typeRef» {
			
				@Override
				public void createFileTypes(@«"org.jetbrains.annotations.NotNull".typeRef» «"com.intellij.openapi.fileTypes.FileTypeConsumer".typeRef» consumer) {
					consumer.consume(«grammar.fileType».INSTANCE, «grammar.abstractFileType».DEFAULT_EXTENSION);
				}
			
			}
		''')
	}
	
	def compileAbstractFileType(Grammar grammar, String fileExtension) {
		fileAccessFactory.createJavaFile(grammar.abstractFileType, '''
			public class «grammar.abstractFileType.simpleName» extends «"com.intellij.openapi.fileTypes.LanguageFileType".typeRef» {
			
				@«"org.jetbrains.annotations.NonNls".typeRef» 
				public static final String DEFAULT_EXTENSION = "«fileExtension»";
			
				protected «grammar.abstractFileType.simpleName»(final «"com.intellij.lang.Language".typeRef» language) {
					super(language);
				}
			
				@Override
				public String getDefaultExtension() {
					return DEFAULT_EXTENSION;
				}
			
				@Override
				public String getDescription() {
					return "«grammar.simpleName» files";
				}
			
				@Override
				public «"javax.swing.Icon".typeRef» getIcon() {
					return «"org.eclipse.xtext.idea.Icons".typeRef».DSL_FILE_TYPE;
				}
			
				@Override
				public String getName() {
					return "«grammar.simpleName»";
				}
			
			}
		''')
	}
	
	def compileFileType(Grammar grammar) {
		fileAccessFactory.createXtendFile(grammar.fileType, '''
			class «grammar.fileType.simpleName» extends «grammar.abstractFileType» {
				public static final «grammar.fileType.simpleName» INSTANCE = new «grammar.fileType.simpleName»()
				
				new() {
					super(«grammar.ideaLanguage».INSTANCE)
				}
			}
		''')
	}
	
	def compileLanguage(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.ideaLanguage, '''
			public final class «grammar.ideaLanguage.simpleName» extends «"org.eclipse.xtext.idea.lang.AbstractXtextLanguage".typeRef» {
			
				public static final «grammar.ideaLanguage.simpleName» INSTANCE = new «grammar.ideaLanguage.simpleName»();
			
				private «grammar.ideaLanguage.simpleName»() {
					super("«grammar.languageId»");
				}

			}
		''')
	}
	
	def compileStandaloneSetup(Grammar grammar) {
		fileAccessFactory.createXtendFile(grammar.ideaStandaloneSetup, '''
			class «grammar.ideaStandaloneSetup.simpleName» extends «grammar.runtimeGenSetup» {
				override createInjector() {
					val runtimeModule = new «grammar.runtimeModule»()
					val ideaModule = new «grammar.ideaModule»()
					val mergedModule = «Modules2».mixin(runtimeModule, ideaModule)
					return «Guice».createInjector(mergedModule)
				}
			}
		''')
	}
		
	def compileIdeaSetup(Grammar grammar) {
		fileAccessFactory.createXtendFile(grammar.ideaSetup, '''
			class «grammar.ideaSetup.simpleName» implements «ISetup» {
			
				override createInjectorAndDoEMFRegistration() {
					«"org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries".typeRef».ensureInitialized
					new «grammar.ideaStandaloneSetup»().createInjector
				}
			
			}
		''')
	}
	
	def compileElementTypeProvider(Grammar grammar) {
		val file = fileAccessFactory.createJavaFile(grammar.elementTypeProvider)
		file.importType("org.eclipse.xtext.idea.lang.IElementTypeProvider".typeRef)
		file.importType("org.eclipse.xtext.psi.stubs.XtextFileElementType".typeRef)
		file.importType("org.eclipse.xtext.psi.stubs.XtextFileStub".typeRef)
		file.importType("org.eclipse.xtext.psi.tree.IGrammarAwareElementType".typeRef)
		file.importType("com.intellij.psi.tree.IFileElementType".typeRef)
		
		file.content = '''
			public class «grammar.elementTypeProvider.simpleName» implements IElementTypeProvider {

				public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<«grammar.fileImpl»>>(«grammar.ideaLanguage».INSTANCE);

				private static final «Map»<«EObject», IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new «HashMap»<«EObject», IGrammarAwareElementType>();

				private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
					GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
					return grammarAwareElementType;
				}
			
				private static final «grammar.grammarAccess» GRAMMAR_ACCESS = «grammar.ideaLanguage».INSTANCE.getInstance(«grammar.grammarAccess».class);
				«FOR rule:grammar.allNonTerminalRules»

				private static class «rule.grammarElementIdentifier»Factory {
					public static IGrammarAwareElementType create«rule.grammarElementIdentifier»ElementType() {
						return new IGrammarAwareElementType("«rule.grammarElementIdentifier»_ELEMENT_TYPE", «grammar.ideaLanguage».INSTANCE, GRAMMAR_ACCESS.«rule.gaRuleAccessor»);
					}
					«FOR element:rule.eAllContents.filter(AbstractElement).toIterable»
					public static IGrammarAwareElementType create«element.grammarElementIdentifier»ElementType() {
						return new IGrammarAwareElementType("«element.grammarElementIdentifier»_ELEMENT_TYPE", «grammar.ideaLanguage».INSTANCE, GRAMMAR_ACCESS.«rule.gaElementsAccessor».«element.gaElementAccessor»);
					}
					«ENDFOR»
				}

				public static final IGrammarAwareElementType «rule.grammarElementIdentifier»_ELEMENT_TYPE = associate(«rule.grammarElementIdentifier»Factory.create«rule.grammarElementIdentifier»ElementType());
				«FOR element:rule.eAllContents.filter(AbstractElement).toIterable»

				public static final IGrammarAwareElementType «element.grammarElementIdentifier»_ELEMENT_TYPE = associate(«rule.grammarElementIdentifier»Factory.create«element.grammarElementIdentifier»ElementType());
				«ENDFOR»
				«ENDFOR»
			
				@Override
				public IFileElementType getFileType() {
					return FILE_TYPE;
				}
			
				@Override
				public IGrammarAwareElementType findElementType(«EObject» grammarElement) {
					return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
				}
				«FOR rule:grammar.allNonTerminalRules»
				
				public IGrammarAwareElementType get«rule.grammarElementIdentifier»ElementType() {
					return «rule.grammarElementIdentifier»_ELEMENT_TYPE;
				}
				«FOR element:rule.eAllContents.filter(AbstractElement).toIterable»
				
				public IGrammarAwareElementType get«element.grammarElementIdentifier»ElementType() {
					return «element.grammarElementIdentifier»_ELEMENT_TYPE;
				}
				«ENDFOR»
				«ENDFOR»
			
			}
		'''
		return file
	}
	
	def compileTokenTypeProvider(Grammar grammar) {
		val tokenSet = "com.intellij.psi.tree.TokenSet".typeRef
		val iElementType = "com.intellij.psi.tree.IElementType".typeRef
		val indexedElementType = "IndexedElementType" // no typeRef is used here as 'IndexedElementType' is inner class of 'TokenTypeProvider'
		return fileAccessFactory.createJavaFile(grammar.tokenTypeProvider, '''
			@«Singleton»
			public class «grammar.tokenTypeProvider.simpleName» implements «"org.eclipse.xtext.idea.parser.TokenTypeProvider".typeRef» {
			
				private static final String[] TOKEN_NAMES = new «grammar.psiInternalParser»(null).getTokenNames();
			
				private static final «iElementType»[] tokenTypes = new «iElementType»[TOKEN_NAMES.length];
				
				static {
					for (int i = 0; i < TOKEN_NAMES.length; i++) {
						tokenTypes[i] = new «indexedElementType»(TOKEN_NAMES[i], i, «grammar.ideaLanguage».INSTANCE);
					}
				}
			
				«IF grammar.allTerminalRules.exists[name == 'WS']»
					private static final «tokenSet» WHITESPACE_TOKENS = «tokenSet».create(tokenTypes[«grammar.psiInternalParser».RULE_WS]);
				«ELSE»
					private static final «tokenSet» WHITESPACE_TOKENS = «tokenSet».EMPTY;
				«ENDIF»
				«IF grammar.allTerminalRules.exists[name == 'SL_COMMENT'] && grammar.allTerminalRules.exists[name == 'ML_COMMENT']»
					private static final «tokenSet» COMMENT_TOKENS = «tokenSet».create(tokenTypes[«grammar.psiInternalParser».RULE_SL_COMMENT], tokenTypes[«grammar.psiInternalParser».RULE_ML_COMMENT]);
				«ELSEIF grammar.allTerminalRules.exists[name == 'SL_COMMENT']»
					private static final «tokenSet» COMMENT_TOKENS = «tokenSet».create(tokenTypes[«grammar.psiInternalParser».RULE_SL_COMMENT]);
				«ELSEIF grammar.allTerminalRules.exists[name == 'ML_COMMENT']»
					private static final «tokenSet» COMMENT_TOKENS = «tokenSet».create(tokenTypes[«grammar.psiInternalParser».RULE_ML_COMMENT]);
				«ELSE»
					private static final «tokenSet» COMMENT_TOKENS = «tokenSet».EMPTY;
				«ENDIF»
				«IF grammar.allTerminalRules.exists[name == 'STRING']»
					private static final «tokenSet» STRING_TOKENS = «tokenSet».create(tokenTypes[«grammar.psiInternalParser».RULE_STRING]);
				«ELSE»
					private static final «tokenSet» STRING_TOKENS = «tokenSet».EMPTY;
				«ENDIF»
			
				@Override
			    public int getAntlrType(«iElementType» iElementType) {
			        return (iElementType instanceof «indexedElementType») ? ((«indexedElementType») iElementType).getLocalIndex() : «Token».INVALID_TOKEN_TYPE;
			    }
			    
			    @Override
			    public «iElementType» getIElementType(int antlrType) {
			    	return tokenTypes[antlrType];
			    }
			
				@Override
				public «tokenSet» getWhitespaceTokens() {
					return WHITESPACE_TOKENS;
				}
			
				@Override
				public «tokenSet» getCommentTokens() {
					return COMMENT_TOKENS;
				}
			
				@Override
				public «tokenSet» getStringLiteralTokens() {
					return STRING_TOKENS;
				}
			
			}
		''')
	}
	
	def compileSyntaxHighlighterFactory(Grammar grammar) {
		val syntaxHighlighter = "com.intellij.openapi.fileTypes.SyntaxHighlighter".typeRef
		val lazySyntaxHighlighter = "com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory".typeRef
		return fileAccessFactory.createJavaFile(grammar.syntaxHighlighterFactory, '''
			public class «grammar.syntaxHighlighterFactory.simpleName» extends «lazySyntaxHighlighter» {
				
				@Override
			    @«"org.jetbrains.annotations.NotNull".typeRef»
			    protected «syntaxHighlighter» createHighlighter() {
			        return «grammar.ideaLanguage».INSTANCE.getInstance(«syntaxHighlighter».class);
			    }
			}
		''')
	}
	
	def compileSemanticHighlightVisitor(Grammar grammar) {
		return fileAccessFactory.createJavaFile(grammar.semanticHighlightVisitor, '''
			public class «grammar.semanticHighlightVisitor.simpleName» extends «"org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor".typeRef» {
				public «grammar.semanticHighlightVisitor.simpleName»() {
					«grammar.ideaLanguage».INSTANCE.injectMembers(this);
				}
			}
		''')
	}
	
	def compileParserDefinition(Grammar grammar) {
		val namedGrammarElement = grammar.namedGrammarElements
		return fileAccessFactory.createJavaFile(grammar.parserDefinition, '''
			public class «grammar.parserDefinition.simpleName» extends «grammar.superParserDefinition» {
			
				@«Inject» 
				private «grammar.elementTypeProvider» elementTypeProvider;
			
				@Override
				public «"com.intellij.psi.PsiFile".typeRef» createFile(«"com.intellij.psi.FileViewProvider".typeRef» viewProvider) {
					return new «grammar.fileImpl»(viewProvider);
				}
			
				@Override
				@SuppressWarnings("rawtypes")
				public «"com.intellij.psi.PsiElement".typeRef» createElement(«"com.intellij.lang.ASTNode".typeRef» node) {
					«"com.intellij.psi.tree.IElementType".typeRef» elementType = node.getElementType();
					Boolean hasSemanticElement = node.getUserData(«"org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder".typeRef».HAS_SEMANTIC_ELEMENT_KEY);
					if (hasSemanticElement != null && hasSemanticElement) {
						«FOR namedElementType:namedGrammarElement.keySet»
						if (elementType == elementTypeProvider.get«namedElementType»ElementType()) {
							return new «"org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl".typeRef»(node,
								«FOR nameType:namedGrammarElement.get(namedElementType) SEPARATOR ','»
								elementTypeProvider.get«nameType»ElementType()
								«ENDFOR»
							) {};
						}
						«ENDFOR»
					}
					return super.createElement(node);
				}
			
			}
		''')
	}

	protected def getCrossReferences(Grammar grammar) {
		grammar.allNonTerminalRules.map[
			eAllContents.filter(CrossReference).filter[assigned].toIterable
		].flatten
	}
	
	protected def getNamedGrammarElements(Grammar grammar) {
		val namedGrammarElements = LinkedHashMultimap.<String, String>create
		for (nameRuleCall : grammar.nameRuleCalls) {
			val nameRuleCallIdentifier = nameRuleCall.grammarElementIdentifier
			for (ruleCall : grammar.getRuleCallsWithName(nameRuleCall)) {
				namedGrammarElements.put(ruleCall.grammarElementIdentifier, nameRuleCallIdentifier)
				for (action : ruleCall.rule.eAllContents.filter(Action).toIterable) {
					namedGrammarElements.put(action.grammarElementIdentifier, nameRuleCallIdentifier)
				}
			}
		}
		namedGrammarElements
	}
	
	protected def getRuleCallsWithName(Grammar grammar, RuleCall nameRuleCall) {
		grammar.allNonTerminalRules.map[getRuleCallsWithName(nameRuleCall)].flatten
	}
	
	protected def getRuleCallsWithName(EObject element, RuleCall nameRuleCall) {
		element.eAllContents.filter(RuleCall).filter [
			rule.eAllContents.exists[it == nameRuleCall]
		].toIterable
	}
	
	protected def getNameRuleCalls(Grammar grammar) {
		grammar.allNonTerminalRules.map[nameRuleCalls].flatten
	}
	
	protected def getNameRuleCalls(EObject element) {
		element.eAllContents.filter(RuleCall).filter [
			assigned && containingAssignment.feature == 'name'
		].toIterable
	}
	
	def compileAbstractCompletionContributor(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.abstractCompletionContributor, '''
			public class «grammar.abstractCompletionContributor.simpleName» extends «grammar.completionContributorSuperClass» {
				public «grammar.abstractCompletionContributor.simpleName»(«"org.eclipse.xtext.idea.lang.AbstractXtextLanguage".typeRef» lang) {
					super(lang);
				}
			}
		''')
	}
	
	def JavaFileAccess compileCompletionContributor(Grammar grammar) {
		fileAccessFactory.createXtendFile(grammar.completionContributor, '''
			class «grammar.completionContributor.simpleName» extends «grammar.abstractCompletionContributor» {
				new() {
					this(«grammar.ideaLanguage».INSTANCE)
				}
				
				new(«"org.eclipse.xtext.idea.lang.AbstractXtextLanguage".typeRef» lang) {
					super(lang)
					//custom rules here
				}
			}
		''')
	}
	def TextFileAccess compileServicesISetup(Grammar grammar) {
		fileAccessFactory.createTextFile(
		'''META-INF/services/«ISetup.name»''', '''
			«grammar.runtimeSetup»
		''')
	}
	
	def JavaFileAccess compileFacetConfiguration(Grammar grammar) {
		val file = fileAccessFactory.createXtendFile(grammar.facetConfiguration)
		file.importType("com.intellij.openapi.components.PersistentStateComponent".typeRef)
		file.importType("com.intellij.openapi.components.State".typeRef)
		file.importType("com.intellij.openapi.components.Storage".typeRef)
		file.importType("com.intellij.openapi.components.StoragePathMacros".typeRef)
		file.importType("com.intellij.openapi.components.StorageScheme".typeRef)
		if (grammar.inheritsXbase) {
			file.importType("org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration".typeRef)	
			file.importType("org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState".typeRef)	
		} else {
			file.importType("org.eclipse.xtext.idea.facet.AbstractFacetConfiguration".typeRef)	
			file.importType("org.eclipse.xtext.idea.facet.GeneratorConfigurationState".typeRef)
		}
		file.content = '''
			@State(name = "«grammar.name»Generator", storages = #[
					@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
					@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
							+ "/«grammar.simpleName»GeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)])
			class «grammar.facetConfiguration.simpleName» extends «IF grammar.inheritsXbase»XbaseFacetConfiguration implements PersistentStateComponent<XbaseGeneratorConfigurationState>«ELSE»AbstractFacetConfiguration implements PersistentStateComponent<GeneratorConfigurationState>«ENDIF»{
			
			}
		'''
		return file
	}
	
	def JavaFileAccess compileFacetType(Grammar grammar) {
		val faceTypeId = "com.intellij.facet.FacetTypeId".typeRef("com.intellij.facet.Facet".typeRef(grammar.facetConfiguration))
		return fileAccessFactory.createJavaFile(grammar.facetType, '''
			public class «grammar.facetType.simpleName» extends «"org.eclipse.xtext.idea.facet.AbstractFacetType".typeRef(grammar.facetConfiguration)» {
			
				public static final «faceTypeId» TYPEID = new «faceTypeId»("«grammar.name»");
			
				public «grammar.facetType.simpleName»() {
					super(TYPEID, "«grammar.name»", "«grammar.simpleName»");
					«grammar.ideaLanguage».INSTANCE.injectMembers(this);
				}
			}
		''')
	}
	
	def JavaFileAccess compileBaseColorSettingsPage(Grammar grammar) {
		fileAccessFactory.createJavaFile(grammar.baseColorSettingsPage, '''
			public class «grammar.baseColorSettingsPage.simpleName» extends «"org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage".typeRef» {
				
				public «grammar.baseColorSettingsPage.simpleName»() {
					«grammar.ideaLanguage».INSTANCE.injectMembers(this);
				}
			
				@Override
				public String getDisplayName() {
					return «grammar.ideaLanguage».INSTANCE.getDisplayName();
				}
			}
		''')
	}
	
	def JavaFileAccess compileColorSettingsPage(Grammar grammar) {
		fileAccessFactory.createXtendFile(grammar.colorSettingsPage, '''
			class «grammar.colorSettingsPage.simpleName» extends «grammar.baseColorSettingsPage» {
			}
		''')
	}
}
