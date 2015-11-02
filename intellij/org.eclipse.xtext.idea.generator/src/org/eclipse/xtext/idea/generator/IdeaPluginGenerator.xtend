/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator

import com.google.common.collect.LinkedHashMultimap
import com.google.inject.Guice
import com.google.inject.Inject
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xpand2.output.Output
import org.eclipse.xpand2.output.OutputImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.NewlineNormalizer
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.idea.generator.parser.antlr.GrammarAccessExtensions
import org.eclipse.xtext.idea.generator.parser.antlr.XtextIDEAGeneratorExtensions

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment.*

@Deprecated
class IdeaPluginGenerator extends Xtend2GeneratorFragment {
	
	private static String META_INF_PLUGIN = "META_INF_PLUGIN"
	
	private static String META_INF_PLUGIN_GEN = "META_INF_PLUGIN_GEN"
	
	private static String PLUGIN = "PLUGIN"
	
	private String encoding
	
	private String fileExtension
	
	private Set<String> libraries = newHashSet();
	
	@Accessors
	private String ideaProjectName
	
	@Accessors
	private String runtimeProjectName
	
	@Accessors
	private String ideaProjectPath
	
	@Accessors
	private String runtimeProjectPath
	
	@Accessors
	private boolean deployable = true
	
	@Inject
	extension GrammarAccess
	
	@Inject
	extension IdeaPluginExtension
	
	@Inject
	extension IdeaPluginClassNames
	
	@Inject
	extension GrammarAccessExtensions
	
	@Inject
	extension XtextIDEAGeneratorExtensions
	
	@Accessors
	boolean srcGenOnly = false
	
	override generate(LanguageConfig config, XpandExecutionContext ctx) {
		fileExtension = config.getFileExtensions(config.grammar).head
		
		Guice.createInjector(createModule(config.grammar)).injectMembers(this);
		generate(config.grammar, new Xtend2ExecutionContext(ctx));
	}
	
	override generate(Grammar grammar, Xtend2ExecutionContext ctx) {
		ctx.installOutlets(ideaProjectPath, encoding, naming.lineDelimiter)
		
		var outlet_src_gen = ctx.srcGenOutlet.name
		
		var outlet_src = if(srcGenOnly) outlet_src_gen else ctx.srcOutlet.name
		
		val bindFactory = new BindFactory();
		bindFactory.addTypeToType('org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider', grammar.antlrTokenFileProvider)
		bindFactory.addTypeToType('org.eclipse.xtext.parser.antlr.Lexer', grammar.getPsiInternalLexerName)
		bindFactory.addConfiguredBinding("RuntimeLexer",
					"binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class)"+
					".annotatedWith(com.google.inject.name.Names.named(" +
					"org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME" +
					")).to(" + grammar.getPsiInternalLexerName + ".class)")
		bindFactory.addTypeToType('com.intellij.lang.PsiParser', grammar.psiParserName)
		bindFactory.addTypeToType('org.eclipse.xtext.idea.parser.TokenTypeProvider', grammar.tokenTypeProviderName)
		bindFactory.addTypeToType('com.intellij.lang.ParserDefinition', grammar.parserDefinitionName)
		bindFactory.addTypeToTypeSingleton('org.eclipse.xtext.idea.lang.IElementTypeProvider', grammar.elementTypeProviderName)
		bindFactory.addTypeToType('org.eclipse.xtext.idea.facet.AbstractFacetConfiguration', grammar.facetConfiguration)
		bindFactory.addTypeToInstance('com.intellij.facet.FacetTypeId', grammar.facetTypeName+'.TYPEID')
		
		if (grammar.doesUseXbase) {
			bindFactory.addTypeToType('org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider', 'org.eclipse.xtext.idea.common.types.StubBasedTypeScopeProvider')
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider', 'org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider')
			bindFactory.addConfiguredBinding('LanguageSpecificPsiModelAssociations', 
					'binder.bind(org.eclipse.xtext.psi.IPsiModelAssociations.class).' + 
					'annotatedWith(org.eclipse.xtext.service.LanguageSpecific.class).' + 
					'to(org.eclipse.xtext.idea.common.types.DerivedMemberAwarePsiModelAssociations.class)')
			bindFactory.addTypeToType('org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration', 'org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration')
			bindFactory.addTypeToType('org.eclipse.xtext.idea.formatting.BlockFactory', 'org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory')
			bindFactory.addTypeToType('org.eclipse.xtext.idea.formatting.ChildAttributesProvider', 'org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider')
			bindFactory.addTypeToType('org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider', 'org.eclipse.xtext.xbase.idea.bracketmatching.XbaseBracePairProvider')
			bindFactory.addTypeToType('org.eclipse.xtext.idea.findusages.IReferenceSearcher', 'org.eclipse.xtext.xbase.idea.findusages.JvmElementAwareReferenceSearcher')
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider', 'org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigProvider')
			bindFactory.addTypeToType('org.eclipse.xtext.idea.findusages.WordsScannerProvider', 'org.eclipse.xtext.xbase.idea.findusages.XbaseWordsScanner.XbaseWordsScannerProvider')
		}
		val bindings = bindFactory.bindings

		ctx.writeFile(outlet_src, grammar.standaloneSetupIdea.toJavaPath, grammar.compileStandaloneSetup)
		ctx.writeFile(outlet_src, grammar.ideaSetup.toXtendPath, grammar.compileIdeaSetup)
		ctx.writeFile(outlet_src, grammar.ideaModuleName.toJavaPath, grammar.compileIdeaModule)
		ctx.writeFile(outlet_src, grammar.completionContributor.toXtendPath, grammar.compileCompletionContributor)
		ctx.writeFile(outlet_src_gen, '''META-INF/services/«ISetup.name»''', grammar.compileServicesISetup)
		ctx.writeFile(outlet_src_gen, grammar.abstractCompletionContributor.toJavaPath, grammar.compileAbstractCompletionContributor)
		ctx.writeFile(outlet_src_gen, grammar.languageName.toJavaPath, grammar.compileLanguage)
		ctx.writeFile(outlet_src, grammar.fileTypeName.toXtendPath, grammar.compileFileType)
		ctx.writeFile(outlet_src_gen, grammar.abstractFileTypeName.toJavaPath, grammar.compileAbstractFileType)
		ctx.writeFile(outlet_src_gen, grammar.fileTypeFactoryName.toJavaPath, grammar.compileFileTypeFactory)
		ctx.writeFile(outlet_src_gen, grammar.fileImplName.toJavaPath, grammar.compileFileImpl)
		ctx.writeFile(outlet_src_gen, grammar.tokenTypeProviderName.toJavaPath, grammar.compileTokenTypeProvider)
		ctx.writeFile(outlet_src_gen, grammar.elementTypeProviderName.toJavaPath, grammar.compileElementTypeProvider)
		ctx.writeFile(outlet_src_gen, grammar.parserDefinitionName.toJavaPath, grammar.compileParserDefinition)
		ctx.writeFile(outlet_src_gen, grammar.syntaxHighlighterFactoryName.toJavaPath, grammar.compileSyntaxHighlighterFactory)
		ctx.writeFile(outlet_src_gen, grammar.semanticHighlightVisitorName.toJavaPath, grammar.compileSemanticHighlightVisitor)
		ctx.writeFile(outlet_src_gen, grammar.abstractIdeaModuleName.toJavaPath, grammar.compileGuiceModuleIdeaGenerated(bindings))
		ctx.writeFile(outlet_src_gen, grammar.extensionFactoryName.toJavaPath, grammar.compileExtensionFactory)
		ctx.writeFile(outlet_src_gen, grammar.codeBlockModificationListenerName.toJavaPath, grammar.compileCodeBlockModificationListener)
		ctx.writeFile(outlet_src_gen, grammar.psiParserName.toJavaPath, grammar.compilePsiParser)
		ctx.writeFile(outlet_src_gen, grammar.antlrTokenFileProvider.toJavaPath, grammar.compileAntlrTokenFileProvider)
		ctx.writeFile(outlet_src_gen, grammar.pomDeclarationSearcherName.toJavaPath, grammar.compilePomDeclarationSearcher)
		ctx.writeFile(outlet_src_gen, grammar.facetTypeName.toJavaPath, grammar.compileFacetType)
		ctx.writeFile(outlet_src, grammar.facetConfiguration.toJavaPath, grammar.compileFacetConfiguration)
		ctx.writeFile(outlet_src_gen, grammar.baseColorSettingsPage.toJavaPath, grammar.compileBaseColorSettingsPage)
		ctx.writeFile(outlet_src, grammar.colorSettingsPage.toXtendPath, grammar.compileColorSettingsPage)
		
		var output = new OutputImpl();
		output.addOutlet(PLUGIN, false, ideaProjectPath);
		output.addOutlet(META_INF_PLUGIN, false, ideaProjectPath + "/META-INF");
		output.addOutlet(META_INF_PLUGIN_GEN, true, ideaProjectPath + "/META-INF");
		
		if (deployable) {
			output.writeFile(META_INF_PLUGIN, "plugin.xml", grammar.compilePluginXml)
			output.writeFile(META_INF_PLUGIN_GEN, "plugin_gen.xml", grammar.compilePluginGenXml)
		}
	}
	


	
	def CharSequence compileGuiceModuleIdeaGenerated(Grammar grammar, Set<Binding> bindings) '''
		package «grammar.abstractIdeaModuleName.toPackageName»;
		
		public class «grammar.abstractIdeaModuleName.toSimpleName» extends org.eclipse.xtext.idea.DefaultIdeaModule {
			
			«FOR it : bindings»
				«IF !value.provider && value.statements.isEmpty»
					// contributed by «contributedBy»
					«IF key.singleton»@org.eclipse.xtext.service.SingletonBinding«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
					public «IF value.expression==null»Class<? extends «key.type»>«ELSE»«key.type»«ENDIF» «bindMethodName(it)»() {
						return «IF value.expression!=null»«value.expression»«ELSE»«value.typeName».class«ENDIF»;
					}
				«ELSEIF value.statements.isEmpty»
					// contributed by «contributedBy»
					«IF key.singleton»@org.eclipse.xtext.service.SingletonBinding«IF key.eagerSingleton»(eager=true)«ENDIF»«ENDIF»
					public «IF value.expression==null»Class<? extends com.google.inject.Provider<«key.type»>>«ELSE»com.google.inject.Provider<«key.type»>«ENDIF» «bindMethodName(it)»() {
						return «IF value.expression!=null»«value.expression»«ELSE»«value.typeName».class«ENDIF»;
					}
				«ELSE»
					// contributed by «contributedBy»
					public void «bindMethodName(it)»(com.google.inject.Binder binder) {
						«FOR statement : value.statements»
						«statement»«IF !statement.endsWith(";")»;«ENDIF»
						«ENDFOR»
					}
				«ENDIF»
			«ENDFOR»
			
			
		}
	'''
	
	def bindMethodName(Binding it) {
		val prefix = if (!it.value.provider && it.value.statements.isEmpty) 
			'bind' 
		else {
			if (it.value.statements.isEmpty)
				'provide'
			else 
				'configure'
		}
		val suffix = if (value.expression!=null && !value.provider) 'ToInstance' else ''
		return prefix + simpleMethodName(key.type) + suffix
	}
	
	def private simpleMethodName(String qn) {
		qn.replaceAll('<','\\.').replaceAll('>','\\.').split('\\.').filter(e|e.matches('[A-Z].*')).join('$');
	}
	
	def compileExtensionFactory(Grammar grammar) '''
		package «grammar.extensionFactoryName.toPackageName»;
		
		import «grammar.languageName»;
		
		import com.intellij.openapi.extensions.ExtensionFactory;
		
		public class «grammar.extensionFactoryName.toSimpleName» implements ExtensionFactory {

			@Override
			public Object createInstance(final String factoryArgument, final String implementationClass) {
				Class<?> clazz;
				try {
					clazz = Class.forName(implementationClass);
				} catch (ClassNotFoundException e) {
					throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
				}
				return «grammar.languageName.toSimpleName».INSTANCE.<Object> getInstance(clazz);
			}

		}
	'''
	
	def compileCodeBlockModificationListener(Grammar grammar) '''
		package «grammar.codeBlockModificationListenerName.toPackageName»;
		
		«IF grammar.doesUseXbase()»
		import com.intellij.psi.impl.PsiTreeChangeEventImpl;
		«ENDIF»
		import com.intellij.psi.util.PsiModificationTracker;
		import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
		import «grammar.languageName»;
		
		public class «grammar.codeBlockModificationListenerName.toSimpleName» extends BaseXtextCodeBlockModificationListener {
		
			public «grammar.codeBlockModificationListenerName.toSimpleName»(PsiModificationTracker psiModificationTracker) {
				super(«grammar.languageName.toSimpleName».INSTANCE, psiModificationTracker);
			}
			«IF grammar.doesUseXbase()»

			protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
				return true;
			}
			«ENDIF»
		
		}
	'''
	
	def compilePomDeclarationSearcher(Grammar it) '''
		package «pomDeclarationSearcherName.toPackageName»;

		import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
		import «languageName»;
		
		public class «pomDeclarationSearcherName.toSimpleName» extends AbstractXtextPomDeclarationSearcher {
		
			public «pomDeclarationSearcherName.toSimpleName»() {
				super(«languageName.toSimpleName».INSTANCE);
			}
		
		}
	'''
	
	def compilePsiParser(Grammar grammar) '''
		package «grammar.psiParserName.toPackageName»;
		
		«IF grammar.initialHiddenTokens.empty»
		import static java.util.Collections.emptySet;
		
		«ELSE»
		import java.util.Arrays;
		import java.util.HashSet;
		«ENDIF»
		import java.util.Set;
		
		import org.antlr.runtime.TokenStream;
		import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
		import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
		import «grammar.elementTypeProviderName»;
		import «grammar.psiInternalParserName»;
		import «grammar.gaFQName»;
		
		import com.google.inject.Inject;
		import com.intellij.lang.PsiBuilder;
		
		public class «grammar.psiParserName.toSimpleName» extends AbstractXtextPsiParser {

			«IF !grammar.initialHiddenTokens.empty»
				private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList(«FOR hidden:grammar.initialHiddenTokens SEPARATOR ', '»"«hidden»"«ENDFOR»));
			«ELSE»
				private static final Set<String> INITIAL_HIDDEN_TOKENS = emptySet();
			«ENDIF»

			@Inject 
			private «grammar.gaSimpleName» grammarAccess;
		
			@Inject 
			private «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider;
		
			@Override
			protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
				return new «grammar.psiInternalParserName.toSimpleName»(builder, tokenStream, elementTypeProvider, grammarAccess);
			}

			@Override
			protected Set<String> getInitialHiddenTokens() {
				return INITIAL_HIDDEN_TOKENS;
			}
		
		}
	'''
	
	def compileAntlrTokenFileProvider(Grammar grammar) '''
		package «grammar.antlrTokenFileProvider.toPackageName»;

		import java.io.InputStream;
		import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
		
		public class «grammar.antlrTokenFileProvider.toSimpleName» implements IAntlrTokenFileProvider {
			
			@Override
			public InputStream getAntlrTokenFile() {
				ClassLoader classLoader = getClass().getClassLoader();
		    	return classLoader.getResourceAsStream("«grammar.tokens»");
			}
		}
	'''
	
	def iml() {
		ideaProjectPath + ".iml"
	}
	
	def addOutlet(Output output, String outletName, boolean overwrite, String path) {
		val outlet = new Outlet(false, getEncoding(), outletName, overwrite, path)
		outlet.addPostprocessor(new NewlineNormalizer(naming.lineDelimiter))
		output.addOutlet(outlet)
	}
	
	def writeFile(Output output, String outletName, String filename, CharSequence contents) {
		output.openFile(filename, outletName);
		output.write(contents.toString);
		output.closeFile();
	}
	
	def getEncoding() {
		if (encoding != null) {
			return encoding;
		}
		return System::getProperty("file.encoding");
	}
	
	def addLibrary(String library) {
		libraries.add(library)
	}
	
	def void setEncoding(String encoding) {
		this.encoding = encoding
	}
	
	def compilePluginXml(Grammar grammar)'''
		<idea-plugin version="2" xmlns:xi="http://www.w3.org/2001/XInclude">
			<id>«ideaProjectName»</id>
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
	'''
	
	def compilePluginGenXml(Grammar grammar)'''
		<idea-plugin version="2">
			<extensions defaultExtensionNs="org.eclipse.xtext.idea">
				«FOR generatedMetamodel:grammar.metamodelDeclarations.filter(GeneratedMetamodel)»
				<package uri="«generatedMetamodel.EPackage.nsURI»"
						 class="«grammar.namespace».«generatedMetamodel.name».«generatedMetamodel.name.toFirstUpper»Package"/>
			    «ENDFOR»
				<resourceFactory type="«fileExtension»"
								 class="org.eclipse.xtext.resource.IResourceFactory"
								 factoryClass="«grammar.extensionFactoryName»"/>
				<resourceServiceProvider uriExtension="«fileExtension»"
										 class="org.eclipse.xtext.idea.resource.IResourceIdeaServiceProvider"
										 factoryClass="«grammar.extensionFactoryName»"/>

				<lang.setup language="«grammar.languageID»"
							implementationClass="«grammar.ideaSetup»"/>
			</extensions>

			<extensions defaultExtensionNs="com.intellij">
				<psi.treeChangePreprocessor implementation="«grammar.codeBlockModificationListenerName»"/>
		
				<fileTypeFactory implementation="«grammar.fileTypeFactoryName»"/>
				<stubElementTypeHolder class="«grammar.elementTypeProviderName»"/>
				«grammar.compileExtension('lang.ast.factory', 'org.eclipse.xtext.idea.lang.BaseXtextASTFactory')»
				«grammar.compileExtension('lang.parserDefinition', grammar.parserDefinitionName)»
				«grammar.compileExtension('lang.findUsagesProvider', 'org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider')»
				«grammar.compileExtension('lang.refactoringSupport', 'org.eclipse.xtext.idea.refactoring.BaseXtextRefactoringSupportProvider')»
				«grammar.compileExtension('lang.namesValidator', 'com.intellij.lang.refactoring.NamesValidator')»
		      	<lang.syntaxHighlighterFactory key="«grammar.languageID»" implementationClass="«grammar.syntaxHighlighterFactoryName»" />
				«grammar.compileExtension('lang.braceMatcher', 'com.intellij.lang.PairedBraceMatcher')»
		      	«grammar.compileExtension('annotator', 'org.eclipse.xtext.idea.annotation.IssueAnnotator')»
		      	<completion.contributor language="«grammar.languageID»" implementationClass="«grammar.completionContributor»"/>
		      	<pom.declarationSearcher implementation="«grammar.pomDeclarationSearcherName»"/>

		      	«grammar.compileExtension('lang.psiStructureViewFactory', 'com.intellij.lang.PsiStructureViewFactory')»
		      	«grammar.compileExtension('lang.documentationProvider', 'org.eclipse.xtext.idea.documentation.IdeaDocumentationProvider')»
				<facetType implementation="«grammar.facetTypeName»"/>
				<colorSettingsPage implementation="«grammar.colorSettingsPage»"/>
				<highlightVisitor implementation="«grammar.semanticHighlightVisitorName»"/>

				«grammar.compileExtension('lang.formatter', 'com.intellij.formatting.FormattingModelBuilder')»
				«grammar.compileExtension('lang.commenter', 'com.intellij.lang.CodeDocumentationAwareCommenter')»
			</extensions>
		</idea-plugin>
	'''
	
	def compileExtension(Grammar grammar, String extensionPointId, String implementationClass) '''
		<«extensionPointId» language="«grammar.languageID»"
								factoryClass="«grammar.extensionFactoryName»"
								implementationClass="«implementationClass»"/>
	'''
	
	def compileFileImpl(Grammar grammar)'''
		package «grammar.psiImplPackageName»;
		
		import org.eclipse.xtext.psi.impl.BaseXtextFile;
		import «grammar.fileTypeName»;
		import «grammar.languageName»;
		
		import com.intellij.openapi.fileTypes.FileType;
		import com.intellij.psi.FileViewProvider;
		
		public final class «grammar.fileImplName.toSimpleName» extends BaseXtextFile {
		
			public «grammar.fileImplName.toSimpleName»(FileViewProvider viewProvider) {
				super(viewProvider, «grammar.languageName.toSimpleName».INSTANCE);
			}
		
			@Override
			public FileType getFileType() {
				return «grammar.fileTypeName.toSimpleName».INSTANCE;
			}
		
		}
	'''
	
	def compileFileTypeFactory(Grammar grammar)'''
		package «grammar.fileTypeFactoryName.toPackageName»;
		
		import com.intellij.openapi.fileTypes.FileTypeConsumer;
		import com.intellij.openapi.fileTypes.FileTypeFactory;
		import org.jetbrains.annotations.NotNull;
		
		public class «grammar.fileTypeFactoryName.toSimpleName» extends FileTypeFactory {
		
			@Override
			public void createFileTypes(@NotNull FileTypeConsumer consumer) {
				consumer.consume(«grammar.fileTypeName».INSTANCE, «grammar.abstractFileTypeName».DEFAULT_EXTENSION);
			}
		
		}
	'''
	
	def compileAbstractFileType(Grammar grammar)'''
		package «grammar.abstractFileTypeName.toPackageName»;
		
		import javax.swing.Icon;
		
		import org.eclipse.xtext.idea.Icons;
		import org.jetbrains.annotations.NonNls;
		
		import com.intellij.lang.Language;
		import com.intellij.openapi.fileTypes.LanguageFileType;
		
		public class «grammar.abstractFileTypeName.toSimpleName» extends LanguageFileType {
		
			@NonNls 
			public static final String DEFAULT_EXTENSION = "«fileExtension»";
		
			protected «grammar.abstractFileTypeName.toSimpleName»(final Language language) {
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
			public Icon getIcon() {
				return Icons.DSL_FILE_TYPE;
			}
		
			@Override
			public String getName() {
				return "«grammar.simpleName»";
			}
		
		}
	'''
	
	def compileFileType(Grammar grammar)'''
		package «grammar.fileTypeName.toPackageName»;
		
		class «grammar.fileTypeName.toSimpleName» extends «grammar.abstractFileTypeName.toSimpleName» {
		
			public static final «grammar.fileTypeName.toSimpleName» INSTANCE = new «grammar.fileTypeName.toSimpleName»()
			
			new() {
				super(«grammar.languageName.toSimpleName».INSTANCE)
			}
		
		}
	'''
	
	def compileLanguage(Grammar grammar)'''
		package «grammar.languageName.toPackageName»;
		
		import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
		
		public final class «grammar.languageName.toSimpleName» extends AbstractXtextLanguage {
		
			public static final «grammar.languageName.toSimpleName» INSTANCE = new «grammar.languageName.toSimpleName»();
		
			private «grammar.languageName.toSimpleName»() {
				super("«grammar.languageID»");
			}

		}
	'''
	
	def compileStandaloneSetup(Grammar grammar) '''
		package «grammar.standaloneSetupIdea.toPackageName»;
		
		import org.eclipse.xtext.util.Modules2;
		import «naming.setupImpl(grammar)»;
		
		import com.google.inject.Guice;
		import com.google.inject.Injector;
		import com.google.inject.Module;
		
		public class «grammar.standaloneSetupIdea.toSimpleName» extends «naming.toSimpleName(naming.setupImpl(grammar))» {
		
		    @Override
		    public Injector createInjector() {
		        Module runtimeModule = new «naming.guiceModuleRt(grammar)»();
		        Module ideaModule = new «grammar.ideaModuleName»();
		        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
		        return Guice.createInjector(mergedModule);
		    }
		
		}
	'''
	
	def compileIdeaSetup(Grammar grammar) '''
		package «grammar.ideaSetup.toPackageName»
		
		import org.eclipse.xtext.ISetup
		import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries
		
		class «grammar.ideaSetup.toSimpleName» implements ISetup {
		
			override createInjectorAndDoEMFRegistration() {
				EcoreGlobalRegistries.ensureInitialized
				new «grammar.standaloneSetupIdea.toSimpleName»().createInjector
			}
		
		}
	'''
	
	def compileIdeaModule(Grammar grammar) '''
		package «grammar.ideaModuleName.toPackageName»;
		
		public class «grammar.ideaModuleName.toSimpleName» extends «grammar.abstractIdeaModuleName.toSimpleName» {
		
		}
	'''
	
	def compileElementTypeProvider(Grammar grammar) '''
		package «grammar.elementTypeProviderName.toPackageName»;
		
		import java.util.HashMap;
		import java.util.Map;
		
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.xtext.idea.lang.IElementTypeProvider;
		import «grammar.fileImplName»;
		import «grammar.grammarAccessName»;
		import org.eclipse.xtext.psi.stubs.XtextFileElementType;
		import org.eclipse.xtext.psi.stubs.XtextFileStub;
		import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
		
		import com.intellij.psi.tree.IFileElementType;
		
		public class «grammar.elementTypeProviderName.toSimpleName» implements IElementTypeProvider {

			public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<«grammar.fileImplName.toSimpleName»>>(«grammar.languageName.toSimpleName».INSTANCE);

			private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

			private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
				GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
				return grammarAwareElementType;
			}
		
			private static final «grammar.grammarAccessName.toSimpleName» GRAMMAR_ACCESS = «grammar.languageName.toSimpleName».INSTANCE.getInstance(«grammar.grammarAccessName.toSimpleName».class);
			«FOR rule:grammar.allNonTerminalRules»

				private static class «rule.grammarElementIdentifier»Factory {
					public static IGrammarAwareElementType create«rule.grammarElementIdentifier»ElementType() {
						return new IGrammarAwareElementType("«rule.grammarElementIdentifier»_ELEMENT_TYPE", «grammar.languageName.toSimpleName».INSTANCE, GRAMMAR_ACCESS.«rule.gaRuleAccessor»);
					}
					«FOR element:rule.eAllContents.filter(AbstractElement).toIterable»
					public static IGrammarAwareElementType create«element.grammarElementIdentifier»ElementType() {
						return new IGrammarAwareElementType("«element.grammarElementIdentifier»_ELEMENT_TYPE", «grammar.languageName.toSimpleName».INSTANCE, GRAMMAR_ACCESS.«rule.gaElementsAccessor».«element.gaElementAccessor»);
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
			public IGrammarAwareElementType findElementType(EObject grammarElement) {
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
	
	def compileTokenTypeProvider(Grammar grammar)'''
		package «grammar.tokenTypeProviderName.toPackageName»;
		
		import static «grammar.psiInternalParserName».*;
		
		import org.eclipse.xtext.idea.parser.TokenTypeProvider;
		import «grammar.languageName»;
		import «grammar.psiInternalParserName»;
		
		import com.google.inject.Singleton;
		import com.intellij.psi.tree.IElementType;
		import com.intellij.psi.tree.TokenSet;
		
		@Singleton public class «grammar.tokenTypeProviderName.toSimpleName» implements TokenTypeProvider {
		
			private static final String[] TOKEN_NAMES = new «grammar.psiInternalParserName.toSimpleName»(null).getTokenNames();
		
			private static final IElementType[] tokenTypes = new IElementType[TOKEN_NAMES.length];
			
			static {
				for (int i = 0; i < TOKEN_NAMES.length; i++) {
					tokenTypes[i] = new IndexedElementType(TOKEN_NAMES[i], i, «grammar.languageName.toSimpleName».INSTANCE);
				}
			}
		
			«IF grammar.allTerminalRules.exists[name == 'WS']»
			private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[RULE_WS]);
			«ELSE»
			private static final TokenSet WHITESPACE_TOKENS = TokenSet.EMPTY;
			«ENDIF»
			«IF grammar.allTerminalRules.exists[name == 'SL_COMMENT'] && grammar.allTerminalRules.exists[name == 'ML_COMMENT']»
			private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT], tokenTypes[RULE_ML_COMMENT]);
			«ELSEIF grammar.allTerminalRules.exists[name == 'SL_COMMENT']»
			private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT]);
			«ELSEIF grammar.allTerminalRules.exists[name == 'ML_COMMENT']»
			private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_ML_COMMENT]);
			«ELSE»
			private static final TokenSet COMMENT_TOKENS = TokenSet.EMPTY;
			«ENDIF»
			«IF grammar.allTerminalRules.exists[name == 'STRING']»
			private static final TokenSet STRING_TOKENS = TokenSet.create(tokenTypes[RULE_STRING]);
			«ELSE»
			private static final TokenSet STRING_TOKENS = TokenSet.EMPTY;
			«ENDIF»
		
			@Override
		    public int getAntlrType(IElementType iElementType) {
		        return (iElementType instanceof IndexedElementType) ? ((IndexedElementType) iElementType).getLocalIndex()
		        				: org.antlr.runtime.Token.INVALID_TOKEN_TYPE;
		    }
		    
		    @Override
		    public IElementType getIElementType(int antlrType) {
		    	return tokenTypes[antlrType];
		    }
		
			@Override
			public TokenSet getWhitespaceTokens() {
				return WHITESPACE_TOKENS;
			}
		
			@Override
			public TokenSet getCommentTokens() {
				return COMMENT_TOKENS;
			}
		
			@Override
			public TokenSet getStringLiteralTokens() {
				return STRING_TOKENS;
			}
		
		}
	'''
	
	def compileSyntaxHighlighterFactory(Grammar grammar)'''
		package «grammar.syntaxHighlighterFactoryName.toPackageName»;
		
		import org.jetbrains.annotations.NotNull;
		
		import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
		import com.intellij.openapi.fileTypes.SyntaxHighlighter;
		import «grammar.languageName»;
		
		public class «grammar.syntaxHighlighterFactoryName.toSimpleName» extends SingleLazyInstanceSyntaxHighlighterFactory {
			
			@Override
		    @NotNull
		    protected SyntaxHighlighter createHighlighter() {
		        return «grammar.languageName.toSimpleName».INSTANCE.getInstance(SyntaxHighlighter.class);
		    }
		
		}
	'''
	
	def compileSemanticHighlightVisitor(Grammar grammar) '''
		package «grammar.semanticHighlightVisitorName.toPackageName»;
		
		import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
		import «grammar.languageName»;
		
		public class «grammar.semanticHighlightVisitorName.toSimpleName» extends SemanticHighlightVisitor {
			public «grammar.semanticHighlightVisitorName.toSimpleName»() {
				«grammar.languageName.toSimpleName».INSTANCE.injectMembers(this);
			}
		}
	'''
	
	def compileParserDefinition(Grammar grammar) {
		val EObjectRules = grammar.allRules.filter[EObjectRule].toList
		val namedEObjectRules = EObjectRules.filter[named].toList
		'''
			package «grammar.parserDefinitionName.toPackageName»;
			
			import «grammar.fileImplName»;
			import «grammar.superParserDefinitionName»;
			«IF !EObjectRules.empty»
			import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
			import «grammar.elementTypeProviderName»;
			import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
			«IF !namedEObjectRules.empty»
			import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;
			«ENDIF»
			«ENDIF»
			
			import «Inject.name»;
			import com.intellij.lang.ASTNode;
			import com.intellij.psi.FileViewProvider;
			import com.intellij.psi.PsiElement;
			import com.intellij.psi.PsiFile;
			import com.intellij.psi.tree.IElementType;
			
			public class «grammar.parserDefinitionName.toSimpleName» extends «grammar.superParserDefinitionName.toSimpleName» {
				«IF !EObjectRules.empty»

				@Inject 
				private «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider;
				«ENDIF»
			
				@Override
				public PsiFile createFile(FileViewProvider viewProvider) {
					return new «grammar.fileImplName.toSimpleName»(viewProvider);
				}
				«IF !EObjectRules.empty»

				@Override
				@SuppressWarnings("rawtypes")
				public PsiElement createElement(ASTNode node) {
					Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
					if (hasSemanticElement != null && hasSemanticElement) {
						IElementType elementType = node.getElementType();
						«FOR rule : EObjectRules»
						if (elementType == elementTypeProvider.get«rule.grammarElementIdentifier»ElementType()) {
							«IF namedEObjectRules.contains(rule)»
							return new PsiNamedEObjectImpl(node) {};
							«ELSE»
							return new PsiEObjectImpl(node) {};
							«ENDIF»
						}
						«FOR element : rule.eAllOfType(AbstractElement)»
						«IF element instanceof Action»
						if (elementType == elementTypeProvider.get«element.grammarElementIdentifier»ElementType()) {
							«IF namedEObjectRules.contains(rule)»
							return new PsiNamedEObjectImpl(node) {};
							«ELSE»
							return new PsiEObjectImpl(node) {};
							«ENDIF»
						}
						«ENDIF»
						«IF element instanceof RuleCall»
						«IF element.EObjectRuleCall»
						if (elementType == elementTypeProvider.get«element.grammarElementIdentifier»ElementType()) {
							«IF namedEObjectRules.contains(element.rule)»
							return new PsiNamedEObjectImpl(node) {};
							«ELSE»
							return new PsiEObjectImpl(node) {};
							«ENDIF»
						}
						«ENDIF»
						«ENDIF»
						«ENDFOR»
						«ENDFOR»
						throw new IllegalStateException("Unexpected element type: " + elementType);
					}
					return super.createElement(node);
				}
				«ENDIF»
			
			}
		'''
	}
	
	protected def isNamed(AbstractRule rule) {
		val classifier = rule.type?.classifier
		val feature = if(classifier instanceof EClass) classifier.getEStructuralFeature('name')
		feature instanceof EAttribute && !feature.many && String.isAssignableFrom(feature.EType.instanceClass)
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
	
	def compileAbstractCompletionContributor(Grammar grammar) '''
		package «grammar.completionContributor.toPackageName»;

		import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
		import «grammar.completionContributorSuperClass»;
		
		public class «grammar.abstractCompletionContributor.toSimpleName» extends «grammar.completionContributorSuperClass.toSimpleName» {
			public «grammar.abstractCompletionContributor.toSimpleName»(AbstractXtextLanguage lang) {
				super(lang);
			}
		}
	'''

	def compileCompletionContributor(Grammar grammar) '''
		package «grammar.completionContributor.toPackageName»
		
		import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
		import «grammar.languageName»;
		
		class «grammar.completionContributor.toSimpleName» extends «grammar.abstractCompletionContributor.toSimpleName» {
			new() {
				this(«grammar.languageName.toSimpleName».INSTANCE)
			}
			
			new(AbstractXtextLanguage lang) {
				super(lang)
				//custom rules here
			}
		}
	'''
	
	def compileServicesISetup(Grammar grammar) '''
		«grammar.standaloneSetup»
	'''
	
	def CharSequence compileFacetConfiguration(Grammar grammar) '''
		package «grammar.facetConfiguration.toPackageName»;
		
		import com.intellij.openapi.components.PersistentStateComponent;
		import com.intellij.openapi.components.State;
		import com.intellij.openapi.components.Storage;
		import com.intellij.openapi.components.StoragePathMacros;
		import com.intellij.openapi.components.StorageScheme;
		«IF grammar.doesUseXbase»
			import org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration;
			import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
		«ELSE»
			import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
			import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
		«ENDIF»
		
		@State(name = "«grammar.name»Generator", storages = {
				@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
				@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
						+ "/«grammar.name.toSimpleName»GeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)})
		public class «grammar.facetConfiguration.toSimpleName» extends «IF grammar.doesUseXbase»XbaseFacetConfiguration implements PersistentStateComponent<XbaseGeneratorConfigurationState>«ELSE»AbstractFacetConfiguration implements PersistentStateComponent<GeneratorConfigurationState>«ENDIF»{
		
		}
	'''
	
	def CharSequence compileFacetType(Grammar grammar) '''
		package «grammar.facetTypeName.toPackageName»;
		
		import com.intellij.facet.Facet;
		import com.intellij.facet.FacetTypeId;
		import org.eclipse.xtext.idea.facet.AbstractFacetType;
		
		public class «grammar.facetTypeName.toSimpleName»  extends AbstractFacetType<«grammar.facetConfiguration.toSimpleName»> {
		
			public static final FacetTypeId<Facet<«grammar.facetConfiguration.toSimpleName»>> TYPEID = new FacetTypeId<Facet<«grammar.facetConfiguration.toSimpleName»>>("«grammar.name»");
		
			public «grammar.facetTypeName.toSimpleName»() {
				super(TYPEID, "«grammar.name»", "«grammar.name.toSimpleName»");
				«grammar.languageName».INSTANCE.injectMembers(this);
			}
		
		}
	'''
	
	def CharSequence compileBaseColorSettingsPage(Grammar grammar) '''
		package «grammar.baseColorSettingsPage.toPackageName»;
		
		import «grammar.languageName»;
		import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;
		
		
		public class «grammar.baseColorSettingsPage.toSimpleName» extends AbstractColorSettingsPage {
			
			public «grammar.baseColorSettingsPage.toSimpleName»() {
				«grammar.languageName.toSimpleName».INSTANCE.injectMembers(this);
			}
		
			@Override
			public String getDisplayName() {
				return «grammar.languageName.toSimpleName».INSTANCE.getDisplayName();
			}
		}
	'''
	
	def CharSequence compileColorSettingsPage(Grammar grammar) '''
		package «grammar.colorSettingsPage.toPackageName»
		
		class «grammar.colorSettingsPage.toSimpleName» extends «grammar.baseColorSettingsPage.toSimpleName» {
		}
	'''
	
}
