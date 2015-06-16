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
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xpand2.output.Output
import org.eclipse.xpand2.output.OutputImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.CrossReference
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

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment.*
import org.eclipse.emf.ecore.EObject

class IdeaPluginGenerator extends Xtend2GeneratorFragment {
	
	private static String META_INF_PLUGIN = "META_INF_PLUGIN"
	
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
	
	override generate(LanguageConfig config, XpandExecutionContext ctx) {
		fileExtension = config.getFileExtensions(config.grammar).head
		
		Guice.createInjector(createModule(config.grammar)).injectMembers(this);
		generate(config.grammar, new Xtend2ExecutionContext(ctx));
	}
	
	override generate(Grammar grammar, Xtend2ExecutionContext ctx) {
//		for (rule:grammar.rules) {
//			ctx.writeFile(Generator::SRC_GEN, grammar.getPsiElementPath(rule), grammar.compilePsiElement(rule))
//			ctx.writeFile(Generator::SRC_GEN, grammar.getPsiElementImplPath(rule), grammar.compilePsiElementImpl(rule))	
//		}
		ctx.installOutlets(ideaProjectPath, encoding, naming.lineDelimiter)
		
		var outlet_src = ctx.srcOutlet.name
		var outlet_src_gen = ctx.srcGenOutlet.name
		
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
		
		if (grammar.doesUseXbase) {
			bindFactory.addTypeToType('org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider', 'org.eclipse.xtext.xbase.idea.types.StubBasedTypeScopeProvider')
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator', 'org.eclipse.xtext.xbase.idea.jvmmodel.PsiJvmModelAssociator')
			bindFactory.addTypeToTypeSingleton('org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex', 'org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex')
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider', 'org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider')
			bindFactory.addTypeToTypeSingleton('com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider', 'org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmDeclaredTypeHierarchyProvider')
			bindFactory.addTypeToTypeSingleton('com.intellij.ide.hierarchy.call.JavaCallHierarchyProvider', 'org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallHierarchyProvider')
		}
		val bindings = bindFactory.bindings
		
		ctx.writeFile(outlet_src, grammar.standaloneSetupIdea.toJavaPath, grammar.compileStandaloneSetup)
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
		ctx.writeFile(outlet_src_gen, grammar.abstractIdeaModuleName.toJavaPath, grammar.compileGuiceModuleIdeaGenerated(bindings))
		ctx.writeFile(outlet_src_gen, grammar.extensionFactoryName.toJavaPath, grammar.compileExtensionFactory)
		ctx.writeFile(outlet_src_gen, grammar.buildProcessParametersProviderName.toJavaPath, grammar.compileBuildProcessParametersProvider)
		ctx.writeFile(outlet_src_gen, grammar.codeBlockModificationListenerName.toJavaPath, grammar.compileCodeBlockModificationListener)
		ctx.writeFile(outlet_src_gen, grammar.elementDescriptionProviderName.toJavaPath, grammar.compileElementDescriptionProvider)
		ctx.writeFile(outlet_src_gen, grammar.psiParserName.toJavaPath, grammar.compilePsiParser)
		ctx.writeFile(outlet_src_gen, grammar.antlrTokenFileProvider.toJavaPath, grammar.compileAntlrTokenFileProvider)
		ctx.writeFile(outlet_src_gen, grammar.pomDeclarationSearcherName.toJavaPath, grammar.compilePomDeclarationSearcher)
		if (grammar.doesUseXbase) {
			ctx.writeFile(outlet_src_gen, grammar.jvmTypesElementFinderName.toJavaPath, grammar.compileJvmTypesElementFinder)
			ctx.writeFile(outlet_src_gen, grammar.jvmTypesShortNamesCacheName.toJavaPath, grammar.compileJvmTypesShortNamesCache)
			ctx.writeFile(outlet_src_gen, grammar.jvmElementsReferencesSearch.toJavaPath, grammar.compileJvmElementsReferencesSearch)
			ctx.writeFile(outlet_src_gen, grammar.callReferenceProcessorName.toJavaPath, grammar.compileCallReferenceProcessor)
		}
		
		var output = new OutputImpl();
		output.addOutlet(PLUGIN, false, ideaProjectPath);
		output.addOutlet(META_INF_PLUGIN, false, ideaProjectPath + "/META-INF");
		
		if (deployable) {
			output.writeFile(META_INF_PLUGIN, "plugin.xml", grammar.compilePluginXml)
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
	
	def compileBuildProcessParametersProvider(Grammar grammar) '''
		package «grammar.buildProcessParametersProviderName.toPackageName»;

		import java.io.File;
		import java.util.ArrayList;
		import java.util.List;
		
		import com.intellij.compiler.server.BuildProcessParametersProvider;
		import com.intellij.ide.plugins.PluginManager;
		import com.intellij.openapi.extensions.PluginId;
		
		public class «grammar.buildProcessParametersProviderName.toSimpleName» extends BuildProcessParametersProvider {
		
			@Override
			public List<String> getClassPath() {
				PluginId pluginId = PluginId.getId("«ideaProjectName»");
				File pluginFolder = PluginManager.getPlugin(pluginId).getPath();

				List<String> result = new ArrayList<String>();

				File libFolder = new File(pluginFolder, "lib");
				if (libFolder.exists()) {
					for (File file : libFolder.listFiles()) {
						result.add(file.getAbsolutePath());
					}
				}

				File classesFolder = new File(pluginFolder, "classes");
				if (classesFolder.exists()) {
					result.add(classesFolder.getAbsolutePath());
				}

				return result;
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
	
	def compileElementDescriptionProvider(Grammar grammar) '''
		package «grammar.elementDescriptionProviderName.toPackageName»;
		
		import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
		import «grammar.languageName»;
		
		public class «grammar.elementDescriptionProviderName.toSimpleName» extends BaseXtextElementDescriptionProvider {
		
			public «grammar.elementDescriptionProviderName.toSimpleName»() {
				super(«grammar.languageName.toSimpleName».INSTANCE);
			}
		
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
	
	def compileCallReferenceProcessor(Grammar it) '''
		package «callReferenceProcessorName.toPackageName»;
		
		import «languageName»;
		import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;
		
		public class «callReferenceProcessorName.toSimpleName» extends JvmExecutableCallReferenceProcessor {
		
			public «callReferenceProcessorName.toSimpleName»() {
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
	
	def compileJvmTypesShortNamesCache(Grammar grammar) '''
		package «grammar.jvmTypesShortNamesCacheName.toPackageName»;
		
		import com.intellij.openapi.project.Project;
		import org.eclipse.xtext.xbase.idea.types.JvmTypesShortNamesCache;
		import «grammar.languageName»;
		
		class «grammar.jvmTypesShortNamesCacheName.toSimpleName» extends JvmTypesShortNamesCache {
		
			public «grammar.jvmTypesShortNamesCacheName.toSimpleName»(Project project) {
				super(«grammar.languageName.toSimpleName».INSTANCE, project);
			}
		
		}
	'''
	
	def compileJvmElementsReferencesSearch(Grammar grammar) '''
		package «grammar.jvmElementsReferencesSearch.toPackageName»;

		import org.eclipse.xtext.xbase.idea.search.JvmElementsReferencesSearch;
		import «grammar.languageName»;
		
		public class «grammar.jvmElementsReferencesSearch.toSimpleName» extends JvmElementsReferencesSearch {
		
			public «grammar.jvmElementsReferencesSearch.toSimpleName»() {
				super(«grammar.languageName.toSimpleName».INSTANCE);
			}
		
		}
	'''
	
	def compileJvmTypesElementFinder(Grammar grammar) '''
		package «grammar.jvmTypesElementFinderName.toPackageName»;
		
		import com.intellij.openapi.project.Project;
		import org.eclipse.xtext.xbase.idea.types.psi.JvmTypesElementFinder;
		import «grammar.languageName»;
		
		public class «grammar.jvmTypesElementFinderName.toSimpleName» extends JvmTypesElementFinder {
		
			public «grammar.jvmTypesElementFinderName.toSimpleName»(Project project) {
				super(«grammar.languageName.toSimpleName».INSTANCE, project);
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
		<idea-plugin version="2">
			<id>«ideaProjectName»</id>
			<name>«grammar.simpleName» Support</name>
			<description>
		      This plugin enables smart editing of «grammar.simpleName» files.
			</description>
			<version>1.0.0</version>
			<vendor>My Company</vendor>
		
			<idea-version since-build="131"/>
			<depends>org.eclipse.xtext.idea</depends>
			«IF grammar.doesUseXbase() && ideaProjectName != 'org.eclipse.xtext.xbase.idea'»
			<depends>org.eclipse.xtext.xbase.idea</depends>
			«ENDIF»

			<extensions defaultExtensionNs="com.intellij">
				<buildProcess.parametersProvider implementation="«grammar.buildProcessParametersProviderName»"/>
				«IF grammar.doesUseXbase()»
				
				<java.elementFinder implementation="«grammar.jvmTypesElementFinderName»" order="first, before java"/>
				<java.shortNamesCache implementation="«grammar.jvmTypesShortNamesCacheName»"/>
				«ENDIF»
		
				<stubIndex implementation="org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex"/>
				«IF grammar.doesUseXbase()»
				<stubIndex implementation="org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex"/>
				«ENDIF»
		
				<psi.treeChangePreprocessor implementation="«grammar.codeBlockModificationListenerName»"/>
				«IF grammar.doesUseXbase()»

				<referencesSearch implementation="«grammar.jvmElementsReferencesSearch»"/>
				«ENDIF»
		
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
		      	<elementDescriptionProvider implementation="«grammar.elementDescriptionProviderName»" order="first"/>
		      	<pom.declarationSearcher implementation="«grammar.pomDeclarationSearcherName»"/>

		      	«grammar.compileExtension('lang.psiStructureViewFactory', 'com.intellij.lang.PsiStructureViewFactory')»
				«IF grammar.doesUseXbase()»

				«grammar.compileExtension('typeHierarchyProvider', 'com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider')»
				«grammar.compileExtension('callHierarchyProvider', 'com.intellij.ide.hierarchy.call.JavaCallHierarchyProvider')»
				<hierarchy.referenceProcessor implementation="«grammar.callReferenceProcessorName»"/>
				«ENDIF»
			</extensions>
		
		</idea-plugin>
	'''
	
	def compileExtension(Grammar grammar, String extensionPointId, String implementationClass) '''
		<«extensionPointId» language="«grammar.languageID»"
								factoryClass="«grammar.extensionFactoryName»"
								implementationClass="«implementationClass»"/>
	'''
	
	def compilePsiElement(Grammar grammar, AbstractRule rule)'''
		package «grammar.psiPackageName»;
		«IF rule.hasMultipleAssigment»
		
		import java.util.List;
		«ENDIF»
		
		import com.intellij.psi.«rule.psiElementSuperClassName»;
		
		public interface «rule.psiElementClassName» extends «rule.psiElementSuperClassName» {
			«FOR assignment:rule.assignmentsWithoutName»
			
			«assignment.typeName» «assignment.getter»();
			
			void «assignment.setter»(«assignment.typeName» «assignment.feature»);
			«ENDFOR»
		
		}
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
		
		import com.google.inject.Injector;
		
		public final class «grammar.languageName.toSimpleName» extends AbstractXtextLanguage {
		
			public static final «grammar.languageName.toSimpleName» INSTANCE = new «grammar.languageName.toSimpleName»();
		
			private Injector injector;
		
			private «grammar.languageName.toSimpleName»() {
				super("«grammar.languageID»");
				this.injector = new «grammar.standaloneSetupIdea»().createInjectorAndDoEMFRegistration();
				
			}
		
			@Override
			protected Injector getInjector() {
				return injector;
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
		«IF !grammar.doesUseXbase»
		import org.eclipse.xtext.psi.stubs.XtextFileElementType;
		«ENDIF»
		import org.eclipse.xtext.psi.stubs.XtextFileStub;
		import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
		«IF grammar.doesUseXbase»
		import org.eclipse.xtext.xbase.idea.types.stubs.XtypeFileElementType;
		«ENDIF»
		
		import com.intellij.psi.tree.IFileElementType;
		
		public class «grammar.elementTypeProviderName.toSimpleName» implements IElementTypeProvider {

			public static final IFileElementType FILE_TYPE = new «IF grammar.doesUseXbase»XtypeFileElementType«ELSE»XtextFileElementType«ENDIF»<XtextFileStub<«grammar.fileImplName.toSimpleName»>>(«grammar.languageName.toSimpleName».INSTANCE);

			private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

			private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
				GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
				return grammarAwareElementType;
			}
		
			private static final «grammar.grammarAccessName.toSimpleName» GRAMMAR_ACCESS = «grammar.languageName.toSimpleName».INSTANCE.getInstance(«grammar.grammarAccessName.toSimpleName».class);
			«FOR rule:grammar.allRules»

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
			«FOR rule:grammar.allRules»
			
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
		        return ((IndexedElementType)iElementType).getLocalIndex();
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
		
		public class «grammar.syntaxHighlighterFactoryName.toSimpleName» extends SingleLazyInstanceSyntaxHighlighterFactory {
			
			@Override
		    @NotNull
		    protected SyntaxHighlighter createHighlighter() {
		        return «grammar.languageName.toSimpleName».INSTANCE.getInstance(SyntaxHighlighter.class);
		    }
		
		}
	'''
	
	def compileParserDefinition(Grammar grammar) {
		val crossReferences = grammar.crossReferences
		val namedGrammarElement = grammar.namedGrammarElements
		
		'''
			package «grammar.parserDefinitionName.toPackageName»;
			
			«IF !crossReferences.empty»
				import org.eclipse.xtext.psi.impl.PsiEObjectReference;
			«ENDIF»
			import «grammar.elementTypeProviderName»;
			import «grammar.fileImplName»;
			import «grammar.superParserDefinitionName»;
			«IF !namedGrammarElement.empty»
				import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;
			«ENDIF»
			
			import «Inject.name»;
			import com.intellij.lang.ASTNode;
			import com.intellij.psi.FileViewProvider;
			import com.intellij.psi.PsiElement;
			import com.intellij.psi.PsiFile;
			import com.intellij.psi.tree.IElementType;
			
			public class «grammar.parserDefinitionName.toSimpleName» extends «grammar.superParserDefinitionName.toSimpleName» {
			
				@Inject 
				private «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider;
			
				@Override
				public PsiFile createFile(FileViewProvider viewProvider) {
					return new «grammar.fileImplName.toSimpleName»(viewProvider);
				}
			
				@Override
				@SuppressWarnings("rawtypes")
				public PsiElement createElement(ASTNode node) {
					IElementType elementType = node.getElementType();
					«FOR namedElementType:namedGrammarElement.keySet»
					if (elementType == elementTypeProvider.get«namedElementType»ElementType()) {
						return new PsiNamedEObjectImpl(node,
							«FOR nameType:namedGrammarElement.get(namedElementType) SEPARATOR ','»
							elementTypeProvider.get«nameType»ElementType()
							«ENDFOR»
						);
					}
					«ENDFOR»
					«FOR crossReference : crossReferences»
					if (elementType == elementTypeProvider.get«crossReference.grammarElementIdentifier»ElementType()) {
						return new PsiEObjectReference(node);
					}
					«ENDFOR»
					return super.createElement(node);
				}
			
			}
		'''
	}
	
	protected def getCrossReferences(Grammar grammar) {
		grammar.allRules.map[
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
		grammar.allRules.map[getRuleCallsWithName(nameRuleCall)].flatten
	}
	
	protected def getRuleCallsWithName(EObject element, RuleCall nameRuleCall) {
		element.eAllContents.filter(RuleCall).filter [
			rule.eAllContents.exists[it == nameRuleCall]
		].toIterable
	}
	
	protected def getNameRuleCalls(Grammar grammar) {
		grammar.allRules.map[nameRuleCalls].flatten
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

}
