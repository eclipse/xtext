package org.eclipse.xtext.idea.generator

import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import java.util.Set
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xpand2.output.Output
import org.eclipse.xpand2.output.OutputImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.idea.generator.parser.antlr.GrammarAccessExtensions
import org.eclipse.xtext.idea.generator.parser.antlr.XtextIDEAGeneratorExtensions

import static extension org.eclipse.xtext.GrammarUtil.*

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
	
	@Accessors
	private boolean typesIntegrationRequired = false
	
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
	
	override generate(Grammar grammar, Xtend2ExecutionContext ctx) {
//		for (rule:grammar.rules) {
//			ctx.writeFile(Generator::SRC_GEN, grammar.getPsiElementPath(rule), grammar.compilePsiElement(rule))
//			ctx.writeFile(Generator::SRC_GEN, grammar.getPsiElementImplPath(rule), grammar.compilePsiElementImpl(rule))	
//		}
		ctx.installOutlets(ideaProjectPath, encoding)
		
		var outlet_src = ctx.srcOutlet.name
		var outlet_src_gen = ctx.srcGenOutlet.name
		
		val bindFactory = new BindFactory();
		bindFactory.addTypeToType('com.intellij.openapi.fileTypes.SyntaxHighlighter', grammar.syntaxHighlighterName)
		bindFactory.addTypeToType('com.intellij.lexer.Lexer', grammar.lexerName)
		bindFactory.addTypeToType('com.intellij.lang.PsiParser', grammar.psiParserName)
		bindFactory.addTypeToType('org.eclipse.xtext.idea.parser.TokenTypeProvider', grammar.tokenTypeProviderName)
		bindFactory.addTypeToType('com.intellij.lang.ParserDefinition', grammar.parserDefinitionName)
		bindFactory.addTypeToTypeSingleton('org.eclipse.xtext.idea.lang.IElementTypeProvider', grammar.elementTypeProviderName)
		
		if (typesIntegrationRequired) {
			bindFactory.addTypeToType('org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory', 'org.eclipse.xtext.idea.types.access.StubTypeProviderFactory')
			bindFactory.addTypeToType('org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider', 'org.eclipse.xtext.idea.types.StubBasedTypeScopeProvider')
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator', 'org.eclipse.xtext.idea.jvmmodel.PsiJvmModelAssociator')
			bindFactory.addTypeToTypeSingleton('org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex', 'org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex')
			bindFactory.addTypeToType('org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider', 'org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider')
		}
		val bindings = bindFactory.bindings
		
		ctx.writeFile(outlet_src, grammar.standaloneSetupIdea.toJavaPath, grammar.compileStandaloneSetup)
		ctx.writeFile(outlet_src, grammar.ideaModuleName.toJavaPath, grammar.compileIdeaModule)
		ctx.writeFile(outlet_src_gen, grammar.languageName.toJavaPath, grammar.compileLanguage)
		ctx.writeFile(outlet_src_gen, grammar.fileTypeName.toJavaPath, grammar.compileFileType)
		ctx.writeFile(outlet_src_gen, grammar.fileTypeFactoryName.toJavaPath, grammar.compileFileTypeFactory)
		ctx.writeFile(outlet_src_gen, grammar.fileImplName.toJavaPath, grammar.compileFileImpl)
		ctx.writeFile(outlet_src_gen, grammar.lexerName.toJavaPath, grammar.compileLexer)
		ctx.writeFile(outlet_src_gen, grammar.tokenTypeProviderName.toJavaPath, grammar.compileTokenTypeProvider)
		ctx.writeFile(outlet_src_gen, grammar.elementTypeProviderName.toJavaPath, grammar.compileElementTypeProvider)
		ctx.writeFile(outlet_src_gen, grammar.parserDefinitionName.toJavaPath, grammar.compileParserDefinition)
		ctx.writeFile(outlet_src_gen, grammar.syntaxHighlighterName.toJavaPath, grammar.compileSyntaxHighlighter)
		ctx.writeFile(outlet_src_gen, grammar.syntaxHighlighterFactoryName.toJavaPath, grammar.compileSyntaxHighlighterFactory)
		ctx.writeFile(outlet_src_gen, grammar.abstractIdeaModuleName.toJavaPath, grammar.compileGuiceModuleIdeaGenerated(bindings))
		ctx.writeFile(outlet_src_gen, grammar.extensionFactoryName.toJavaPath, grammar.compileExtensionFactory)
		ctx.writeFile(outlet_src_gen, grammar.buildProcessParametersProviderName.toJavaPath, grammar.compileBuildProcessParametersProvider)
		ctx.writeFile(outlet_src_gen, grammar.codeBlockModificationListenerName.toJavaPath, grammar.compileCodeBlockModificationListener)
		ctx.writeFile(outlet_src_gen, grammar.elementDescriptionProviderName.toJavaPath, grammar.compileElementDescriptionProvider)
		ctx.writeFile(outlet_src_gen, grammar.psiParserName.toJavaPath, grammar.compilePsiParser)
		if (typesIntegrationRequired) {
			ctx.writeFile(outlet_src_gen, grammar.jvmTypesElementFinderName.toJavaPath, grammar.compileJvmTypesElementFinder)
			ctx.writeFile(outlet_src_gen, grammar.jvmTypesShortNamesCacheName.toJavaPath, grammar.compileJvmTypesShortNamesCache)
			ctx.writeFile(outlet_src_gen, grammar.jvmElementsReferencesSearch.toJavaPath, grammar.compileJvmElementsReferencesSearch)
		}
		
		var output = new OutputImpl();
		output.addOutlet(PLUGIN, ideaProjectPath);
		output.addOutlet(META_INF_PLUGIN, ideaProjectPath + "/META-INF");
		
		if (deployable) {
			output.writeFile(PLUGIN, '''«grammar.name.toSimpleName» Launch Intellij.launch''', grammar.compileLaunchIntellij)
			output.writeFile(META_INF_PLUGIN, "plugin.xml", grammar.compilePluginXml)
		}
		output.writeFile(PLUGIN, ".project", grammar.compileProjectXml)
		output.writeFile(PLUGIN, ".classpath", grammar.compileClasspathXml)
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

		import «Arrays.name»;
		import «List.name»;
		
		import com.intellij.compiler.server.BuildProcessParametersProvider;
		import com.intellij.ide.plugins.PluginManager;
		import com.intellij.openapi.extensions.PluginId;
		
		public class «grammar.buildProcessParametersProviderName.toSimpleName» extends BuildProcessParametersProvider {
		
			public List<String> getClassPath() {
				String path = PluginManager.getPlugin(PluginId.getId("«grammar.languageID»")).getPath().getPath();
				return Arrays.asList(
					path + "/bin", 
					path + "/../«runtimeProjectPath»/bin"
				);
			}
		
		}
	'''
	
	def compileCodeBlockModificationListener(Grammar grammar) '''
		package «grammar.codeBlockModificationListenerName.toPackageName»;
		
		«IF typesIntegrationRequired»
		import com.intellij.psi.impl.PsiTreeChangeEventImpl;
		«ENDIF»
		import com.intellij.psi.util.PsiModificationTracker;
		import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
		import «grammar.languageName»;
		
		public class «grammar.codeBlockModificationListenerName.toSimpleName» extends BaseXtextCodeBlockModificationListener {
		
			public «grammar.codeBlockModificationListenerName.toSimpleName»(PsiModificationTracker psiModificationTracker) {
				super(«grammar.languageName.toSimpleName».INSTANCE, psiModificationTracker);
			}
			«IF typesIntegrationRequired»

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
	
	def compilePsiParser(Grammar grammar) '''
		package «grammar.psiParserName.toPackageName»;
		
		import java.io.IOException;
		
		import org.antlr.runtime.ANTLRReaderStream;
		import org.antlr.runtime.TokenSource;
		import org.antlr.runtime.TokenStream;
		import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
		import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
		import org.eclipse.xtext.xbase.lib.Exceptions;
		import «grammar.elementTypeProviderName»;
		import «grammar.psiInternalLexerName»;
		import «grammar.psiInternalParserName»;
		
		import com.google.inject.Inject;
		import com.intellij.lang.PsiBuilder;
		import com.intellij.util.text.CharSequenceReader;
		
		public class «grammar.psiParserName.toSimpleName» extends AbstractXtextPsiParser {
			
			@Inject 
			private «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider;
		
			@Override
			protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
				return new «grammar.psiInternalParserName.toSimpleName»(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);
			}
		
			@Override
			protected TokenSource createTokenSource(PsiBuilder builder) {
				try {
					CharSequence originalText = builder.getOriginalText();
					CharSequenceReader reader = new CharSequenceReader(originalText);
					return new «grammar.psiInternalLexerName.toSimpleName»(new ANTLRReaderStream(reader));
				} catch (IOException e) {
					throw Exceptions.sneakyThrow(e);
				}
			}
		
		}
	'''
	
	def compileJvmTypesShortNamesCache(Grammar grammar) '''
		package «grammar.jvmTypesShortNamesCacheName.toPackageName»;
		
		import com.intellij.openapi.project.Project;
		import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;
		import «grammar.languageName»;
		
		class «grammar.jvmTypesShortNamesCacheName.toSimpleName» extends JvmTypesShortNamesCache {
		
			public «grammar.jvmTypesShortNamesCacheName.toSimpleName»(Project project) {
				super(«grammar.languageName.toSimpleName».INSTANCE, project);
			}
		
		}
	'''
	
	def compileJvmElementsReferencesSearch(Grammar grammar) '''
		package «grammar.jvmElementsReferencesSearch.toPackageName»;

		import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;
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
		import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;
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
	
	def addOutlet(Output output, String outletName, String path) {
		output.addOutlet(new Outlet(false, getEncoding(), outletName, false, path))
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
	
	def setFileExtensions(String fileExtensions) {
		this.fileExtension = fileExtensions.split("\\s*,\\s*").head
	}
	
	def void setEncoding(String encoding) {
		this.encoding = encoding
	}
	
	def compileClasspathXml(Grammar grammar) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<classpath>
			<classpathentry kind="src" path="src"/>
			<classpathentry kind="src" path="src-gen"/>
			<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6"/>
			<classpathentry combineaccessrules="false" exported="true" kind="src" path="/org.eclipse.xtext.idea"/>
			«IF typesIntegrationRequired»
			<classpathentry combineaccessrules="false" exported="true" kind="src" path="/org.eclipse.xtext.xbase.idea"/>
			«ENDIF»
			«IF runtimeProjectName != ideaProjectName»
			<classpathentry combineaccessrules="false" exported="true" kind="src" path="/«runtimeProjectName»"/>
			«ENDIF»
			<classpathentry kind="output" path="bin"/>
		</classpath>
	'''
	
	def compileProjectXml(Grammar grammar) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<projectDescription>
			<name>«ideaProjectName»</name>
			<comment></comment>
			<projects>
			</projects>
			<buildSpec>
				<buildCommand>
					<name>org.eclipse.jdt.core.javabuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
			</buildSpec>
			<natures>
				<nature>org.eclipse.jdt.core.javanature</nature>
			</natures>
		</projectDescription>
	'''
	
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
			<depends optional="true">org.eclipse.xtext.idea</depends>

			<extensions defaultExtensionNs="com.intellij">
				<buildProcess.parametersProvider implementation="«grammar.buildProcessParametersProviderName»"/>
				«IF typesIntegrationRequired»
				
				<java.elementFinder implementation="«grammar.jvmTypesElementFinderName»"/>
				<java.shortNamesCache implementation="«grammar.jvmTypesShortNamesCacheName»"/>
				«ENDIF»
		
				<stubIndex implementation="org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex"/>
				«IF typesIntegrationRequired»
				<stubIndex implementation="org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex"/>
				«ENDIF»
		
				<psi.treeChangePreprocessor implementation="«grammar.codeBlockModificationListenerName»"/>
				«IF typesIntegrationRequired»

				<referencesSearch implementation="«grammar.jvmElementsReferencesSearch»"/>
				«grammar.compileExtension('targetElementEvaluator', 'org.eclipse.xtext.idea.jvmmodel.codeInsight.PsiJvmTargetElementEvaluator')»
				«ENDIF»
		
				<fileTypeFactory implementation="«grammar.fileTypeFactoryName»"/>
				<stubElementTypeHolder class="«grammar.elementTypeProviderName»"/>
				«grammar.compileExtension('lang.ast.factory', 'org.eclipse.xtext.idea.lang.BaseXtextASTFactory')»
				«grammar.compileExtension('lang.parserDefinition', grammar.parserDefinitionName)»
				«grammar.compileExtension('lang.findUsagesProvider', 'org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider')»
				«grammar.compileExtension('lang.refactoringSupport', 'org.eclipse.xtext.idea.refactoring.BaseXtextRefactoringSupportProvider')»
		      	<lang.syntaxHighlighterFactory key="«grammar.languageID»" implementationClass="«grammar.syntaxHighlighterFactoryName»" />
		      	«grammar.compileExtension('annotator', 'org.eclipse.xtext.idea.annotation.IssueAnnotator')»
		      	<elementDescriptionProvider implementation="«grammar.elementDescriptionProviderName»" order="first"/>
			</extensions>
		
		</idea-plugin>
	'''
	
	def compileExtension(Grammar grammar, String extensionPointId, String implementationClass) '''
		<«extensionPointId» language="«grammar.languageID»"
								factoryClass="«grammar.extensionFactoryName»"
								implementationClass="«implementationClass»"/>
	'''
	
	def compileLaunchIntellij(Grammar grammar)'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.jdt.launching.localJavaApplication">
			<stringAttribute key="bad_container_name" value="/«ideaProjectName»/«grammar.name.toSimpleName.toLowerCase»_launch_intellij.launch"/>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
				<listEntry value="/«ideaProjectName»"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
				<listEntry value="4"/>
			</listAttribute>
			<booleanAttribute key="org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD" value="false"/>
			<stringAttribute key="org.eclipse.jdt.launching.JRE_CONTAINER" value="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.launching.macosx.MacOSXType/Java SE 6 [1.6.0_65-b14-462]"/>
			<stringAttribute key="org.eclipse.jdt.launching.MAIN_TYPE" value="com.intellij.idea.Main"/>
			<stringAttribute key="org.eclipse.jdt.launching.PROJECT_ATTR" value="«ideaProjectName»"/>
			<stringAttribute key="org.eclipse.jdt.launching.VM_ARGUMENTS" value="-Xmx2g -XX:MaxPermSize=320m -Didea.plugins.path=${INTELLIJ_IDEA_PLUGINS} -Didea.home.path=${INTELLIJ_IDEA} -Didea.ProcessCanceledException=disabled -Dcompiler.process.debug.port=-1"/>
		</launchConfiguration>
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
		
			public void createFileTypes(@NotNull FileTypeConsumer consumer) {
				consumer.consume(«grammar.fileTypeName».INSTANCE, «grammar.fileTypeName».DEFAULT_EXTENSION);
			}
		
		}
	'''
	
	def compileFileType(Grammar grammar)'''
		package «grammar.fileTypeName.toPackageName»;
		
		import javax.swing.Icon;
		
		import com.intellij.openapi.fileTypes.LanguageFileType;
		import org.jetbrains.annotations.NonNls;
		
		public final class «grammar.fileTypeName.toSimpleName» extends LanguageFileType {
		
			public static final «grammar.fileTypeName.toSimpleName» INSTANCE = new «grammar.fileTypeName.toSimpleName»();
			
			@NonNls 
			public static final String DEFAULT_EXTENSION = "«fileExtension»";
		
			private «grammar.fileTypeName.toSimpleName»() {
				super(«grammar.languageName.toSimpleName».INSTANCE);
			}
		
			public String getDefaultExtension() {
				return DEFAULT_EXTENSION;
			}
		
			public String getDescription() {
				return "«grammar.simpleName» files";
			}
		
			public Icon getIcon() {
				return null;
			}
		
			public String getName() {
				return "«grammar.simpleName»";
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
		import org.eclipse.xtext.psi.PsiNamedEObject;
		import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
		import org.eclipse.xtext.psi.stubs.PsiNamedEObjectType;
		import org.eclipse.xtext.psi.stubs.XtextFileElementType;
		import org.eclipse.xtext.psi.stubs.XtextFileStub;
		import «grammar.fileImplName»;
		
		import com.intellij.psi.stubs.IStubElementType;
		import com.intellij.psi.tree.IElementType;
		import com.intellij.psi.tree.IFileElementType;
		import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
		import «grammar.grammarAccessName»;
		
		public class «grammar.elementTypeProviderName.toSimpleName» implements IElementTypeProvider {

			public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<«grammar.fileImplName.toSimpleName»>>(«grammar.languageName.toSimpleName».INSTANCE);
		
			public static final IElementType NAME_TYPE = new IElementType("NAME", «grammar.languageName.toSimpleName».INSTANCE);
		
			public static final IElementType EOBJECT_TYPE = new IElementType("EOBJECT_TYPE", «grammar.languageName.toSimpleName».INSTANCE);
		
			public static final IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> NAMED_EOBJECT_TYPE = new PsiNamedEObjectType("NAMED_EOBJECT", «grammar.languageName.toSimpleName».INSTANCE);
		
			public static final IElementType CROSS_REFERENCE_TYPE = new IElementType("CROSS_REFERENCE", «grammar.languageName.toSimpleName».INSTANCE);
		
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
		
			public IFileElementType getFileType() {
				return FILE_TYPE;
			}
		
			public IElementType getObjectType() {
				return EOBJECT_TYPE;
			}
		
			public IElementType getCrossReferenceType() {
				return CROSS_REFERENCE_TYPE;
			}
		
			public IElementType getNameType() {
				return NAME_TYPE;
			}
		
			public IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> getNamedObjectType() {
				return NAMED_EOBJECT_TYPE;
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
		
			public IGrammarAwareElementType findElementType(EObject grammarElement) {
				return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
			}
		
		}
	'''
	
	def compileTokenTypeProvider(Grammar grammar)'''
		package «grammar.tokenTypeProviderName.toPackageName»;
		
		import static «grammar.psiInternalParserName».*;
		
		import org.eclipse.xtext.idea.parser.TokenTypeProvider;
		import «grammar.languageName»;
		
		import com.google.inject.Singleton;
		import com.intellij.psi.tree.IElementType;
		import com.intellij.psi.tree.TokenSet;
		
		@Singleton public class «grammar.tokenTypeProviderName.toSimpleName» implements TokenTypeProvider {
		
			private static final IElementType[] tokenTypes = new IElementType[tokenNames.length];
			
			static {
				for (int i = 0; i < tokenNames.length; i++) {
					tokenTypes[i] = new IndexedElementType(tokenNames[i], i, «grammar.languageName.toSimpleName».INSTANCE);
				}
			}
			
			private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[RULE_WS]);
			private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT], tokenTypes[RULE_ML_COMMENT]);
			private static final TokenSet STRING_TOKENS = TokenSet.create(tokenTypes[RULE_STRING]);
		
		    public int getAntlrType(IElementType iElementType) {
		        return ((IndexedElementType)iElementType).getLocalIndex();
		    }
		    
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
	
	def compileLexer(Grammar grammar)'''
		package «grammar.lexerName.toPackageName»;
		
		import org.antlr.runtime.ANTLRStringStream;
		import org.antlr.runtime.Lexer;
		import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;
		import «grammar.antlrLexerName»;
		
		public class «grammar.lexerName.toSimpleName» extends AbstractAntlrDelegatingIdeaLexer {
		
			@Override
			public Lexer createAntlrLexer(String text) {
				return new «grammar.antlrLexerName.toSimpleName»(new ANTLRStringStream(text));
			}
		
		}
	'''
	
	def compileSyntaxHighlighterFactory(Grammar grammar)'''
		package «grammar.syntaxHighlighterFactoryName.toPackageName»;
		
		import org.jetbrains.annotations.NotNull;
		
		import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
		import com.intellij.openapi.fileTypes.SyntaxHighlighter;
		
		public class «grammar.syntaxHighlighterFactoryName.toSimpleName» extends SingleLazyInstanceSyntaxHighlighterFactory {
			
		    @NotNull
		    protected SyntaxHighlighter createHighlighter() {
		        return «grammar.languageName.toSimpleName».INSTANCE.getInstance(SyntaxHighlighter.class);
		    }
		
		}
	'''
	
	def compileSyntaxHighlighter(Grammar grammar)'''
		package «grammar.syntaxHighlighterName.toPackageName»;
		
		import org.eclipse.xtext.idea.parser.TokenTypeProvider;
		import org.jetbrains.annotations.NotNull;
		import «grammar.antlrLexerName»;
		
		import com.google.inject.Inject;
		import com.google.inject.Provider;
		import com.intellij.lexer.Lexer;
		import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
		import com.intellij.openapi.editor.colors.TextAttributesKey;
		import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
		import com.intellij.psi.tree.IElementType;
		
		public class «grammar.syntaxHighlighterName.toSimpleName» extends SyntaxHighlighterBase {
		
			@Inject TokenTypeProvider tokenTypeProvider;
			@Inject Provider<Lexer> lexerProvider; 
		
		    @NotNull
		    public Lexer getHighlightingLexer() {
		        return lexerProvider.get();
		    }
		
		    @NotNull
		    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		        if (tokenTypeProvider.getStringLiteralTokens().contains(tokenType)) {
		            return pack(DefaultLanguageHighlighterColors.STRING);
		        }
				if (tokenTypeProvider.getIElementType(«grammar.antlrLexerName.toSimpleName».RULE_SL_COMMENT) == tokenType) {
					return pack(DefaultLanguageHighlighterColors.LINE_COMMENT);
				}
				if (tokenTypeProvider.getIElementType(«grammar.antlrLexerName.toSimpleName».RULE_ML_COMMENT) == tokenType) {
					return pack(DefaultLanguageHighlighterColors.BLOCK_COMMENT);
				}
		        String myDebugName = tokenType.toString();
				if (myDebugName.matches("^'.*\\w.*'$")) {
					return pack(DefaultLanguageHighlighterColors.KEYWORD);
		        }
		        return new TextAttributesKey[0];
		    }
		
		}
	'''
	
	def compileParserDefinition(Grammar grammar)'''
		package «grammar.parserDefinitionName.toPackageName»;
		
		«IF !grammar.eAllContents.filter(CrossReference).filter[assigned].empty»
		import org.eclipse.xtext.psi.impl.PsiEObjectReference;
		«ENDIF»
		import «grammar.elementTypeProviderName»;
		import «grammar.fileImplName»;
		import «grammar.superParserDefinitionName»;
		«IF grammar.eAllContents.filter(RuleCall).filter[assigned && containingAssignment.feature == 'name'].exists[ nameRuleCall |
			!grammar.eAllContents.filter(RuleCall).filter[rule.eAllContents.exists[it == nameRuleCall]].empty
		]»
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
		
			public PsiFile createFile(FileViewProvider viewProvider) {
				return new «grammar.fileImplName.toSimpleName»(viewProvider);
			}
		
			@Override
			@SuppressWarnings("rawtypes")
			public PsiElement createElement(ASTNode node) {
				IElementType elementType = node.getElementType();
				«FOR nameRuleCall:grammar.eAllContents.filter(RuleCall).filter[assigned && containingAssignment.feature == 'name'].toIterable»
				«FOR ruleCall:grammar.eAllContents.filter(RuleCall).filter[rule.eAllContents.exists[it == nameRuleCall]].toIterable»
				if (elementType == elementTypeProvider.get«ruleCall.grammarElementIdentifier»ElementType()) {
					return new PsiNamedEObjectImpl(node, elementTypeProvider.get«nameRuleCall.grammarElementIdentifier»ElementType());
				}
				«ENDFOR»
				«ENDFOR»
				«FOR crossReference:grammar.eAllContents.filter(CrossReference).filter[assigned].toIterable»
				if (elementType == elementTypeProvider.get«crossReference.grammarElementIdentifier»ElementType()) {
					return new PsiEObjectReference(node);
				}
				«ENDFOR»
				return super.createElement(node);
			}
		
		}
	'''

}