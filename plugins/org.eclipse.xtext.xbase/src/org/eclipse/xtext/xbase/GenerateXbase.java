package org.eclipse.xtext.xbase;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.emf.mwe2.ecore.EcoreGenerator;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.builder.BuilderIntegrationFragment;
import org.eclipse.xtext.generator.formatting2.Formatter2Fragment;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.generator.parser.antlr.DebugAntlrGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment;
import org.eclipse.xtext.generator.resourceFactory.ResourceFactoryFragment;
import org.eclipse.xtext.generator.scoping.ImportNamespacesScopingFragment;
import org.eclipse.xtext.generator.serializer.SerializerFragment;
import org.eclipse.xtext.generator.types.TypesGeneratorFragment;
import org.eclipse.xtext.generator.validation.JavaValidatorFragment;
import org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment;
import org.eclipse.xtext.idea.generator.IdeaPluginGenerator;
import org.eclipse.xtext.idea.generator.parser.antlr.XtextAntlrIDEAGeneratorFragment;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment;
import org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment;
import org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment;
import org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noreference This class is not intended to be referenced by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
final class GenerateXbase {
	/**
	 * Can't use MWE2 because of circular dependencies
	 */
	public static void main(String[] args) {
		final String projectName = "org.eclipse.xtext.xbase";
		final String runtimeProject = "../" + projectName;
		final String uiProject = runtimeProject + ".ui";
		final boolean backtrack = false;
		final boolean memoize = false;
		final String lineDelimiter = "\n";
		
		final String ideaProjectName = projectName + ".idea";
		final String ideaProjectPath = "../../intellij/" + ideaProjectName;

		new StandaloneSetup() {{
			// the maven archetype contains a template file called .project
			setIgnoreBrokenProjectFiles(true);
			setPlatformUri(runtimeProject + "/../..");
			setScanClassPath(true);
		}};
		
		final XtextResourceSet xtypeResourceSet = new XtextResourceSet();
		new StandaloneSetup() {{
			setResourceSet(xtypeResourceSet);
			addRegisterEcoreFile("platform:/resource/org.eclipse.xtext.common.types/model/JavaVMTypes.ecore");
			addRegisterEcoreFile("platform:/resource/" + projectName + "/model/Xtype.ecore");
		}};

		final XtextResourceSet xbaseResourceSet = new XtextResourceSet();
		new StandaloneSetup() {{
			setResourceSet(xbaseResourceSet);
			addRegisterEcoreFile("platform:/resource/org.eclipse.xtext.common.types/model/JavaVMTypes.ecore");
			addRegisterEcoreFile("platform:/resource/" + projectName + "/model/Xtype.ecore");
			addRegisterEcoreFile("platform:/resource/" + projectName + "/model/Xbase.ecore");
		}};
		
		final XtextResourceSet xannotationsResourceSet = new XtextResourceSet();
		new StandaloneSetup() {{
			setResourceSet(xannotationsResourceSet);
			addRegisterEcoreFile("platform:/resource/org.eclipse.xtext.common.types/model/JavaVMTypes.ecore");
			addRegisterEcoreFile("platform:/resource/" + projectName + "/model/Xtype.ecore");
			addRegisterEcoreFile("platform:/resource/" + projectName + "/model/Xbase.ecore");
			addRegisterEcoreFile("platform:/resource/" + projectName + "/model/XAnnotations.ecore");
		}};

		final AntlrOptions antlrOptions = new AntlrOptions();
		antlrOptions.setBacktrack(backtrack);
		antlrOptions.setMemoize(memoize);
		
		final Generator generator = new Generator() {{
			setPathRtProject(runtimeProject);
			setPathUiProject(uiProject);
			setProjectNameRt(projectName);
			setProjectNameUi(projectName + ".ui");
			setLineDelimiter(lineDelimiter);

			addLanguage(new LanguageConfig() {{
				String fileExtensions = "___xtype";
				
				setForcedResourceSet(xtypeResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/Xtype.xtext");
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment());
				addFragment(new SerializerFragment());
				addFragment(new Formatter2Fragment());
				addFragment(new JavaBasedContentAssistFragment());
				XtextAntlrGeneratorFragment antlr = new XtextAntlrGeneratorFragment();
				antlr.setOptions(antlrOptions);
				addFragment(antlr);
				
				addFragment(createIdeaPluginProject(projectName, runtimeProject, ideaProjectName, ideaProjectPath, fileExtensions));
				addFragment(createXtextAntlrIDEAGeneratorFragment(ideaProjectPath));
			}});
			addLanguage(new LanguageConfig() {{
				String fileExtensions = "___xbase";
				
				setForcedResourceSet(xbaseResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/Xbase.xtext");
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment());
				addFragment(new SerializerFragment());
				ResourceFactoryFragment resourceFactory = new ResourceFactoryFragment();
				resourceFactory.setFileExtensions(fileExtensions);
				addFragment(resourceFactory);
				XtextAntlrGeneratorFragment antlr = new XtextAntlrGeneratorFragment();
				antlr.setOptions(antlrOptions);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(antlr);
				DebugAntlrGeneratorFragment antlrDebug = new DebugAntlrGeneratorFragment();
				antlrDebug.setOptions(antlrOptions);
				addFragment(antlrDebug);
				JavaValidatorFragment validator = new JavaValidatorFragment();
				validator.setInheritImplementation(false);
				addFragment(validator);
				addFragment(new ImportNamespacesScopingFragment());
				addFragment(new TypesGeneratorFragment());
				XbaseGeneratorFragment xbase = new XbaseGeneratorFragment();
				xbase.setGenerateXtendInferrer(false);
				xbase.setUseInferredJvmModel(false);
				xbase.setJdtTypeHierarchy(false);
				addFragment(xbase);
				addFragment(new BuilderIntegrationFragment());
				addFragment(new Formatter2Fragment());
				addFragment(new QuickfixProviderFragment());
				LabelProviderFragment label = new LabelProviderFragment();
				label.setGenerateStub(false);
				addFragment(label);
				addFragment(new OutlineTreeProviderFragment());
				addFragment(new JavaBasedContentAssistFragment());
				XtextAntlrUiGeneratorFragment antlrUI = new XtextAntlrUiGeneratorFragment();
				antlrUI.setOptions(antlrOptions);
				antlrUI.addAntlrParam("-Xconversiontimeout");
				antlrUI.addAntlrParam("10000");
				addFragment(antlrUI);
				
				addFragment(createIdeaPluginProject(projectName, runtimeProject, ideaProjectName, ideaProjectPath, fileExtensions));
				addFragment(createXtextAntlrIDEAGeneratorFragment(ideaProjectPath));
			}});
			addLanguage(new LanguageConfig() {{
				String fileExtensions = "___xbasewithannotations";
				
				setForcedResourceSet(xannotationsResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/annotations/XbaseWithAnnotations.xtext");
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment());
				addFragment(new SerializerFragment());
				ResourceFactoryFragment resourceFactory = new ResourceFactoryFragment();
				resourceFactory.setFileExtensions(fileExtensions);
				addFragment(resourceFactory);
				XtextAntlrGeneratorFragment antlr = new XtextAntlrGeneratorFragment();
				antlr.setOptions(antlrOptions);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(antlr);
				DebugAntlrGeneratorFragment antlrDebug = new DebugAntlrGeneratorFragment();
				antlrDebug.setOptions(antlrOptions);
				addFragment(antlrDebug);
				addFragment(new JavaValidatorFragment());
				addFragment(new ImportNamespacesScopingFragment());
				addFragment(new TypesGeneratorFragment());
				XbaseGeneratorFragment xbase = new XbaseGeneratorFragment();
				xbase.setGenerateXtendInferrer(false);
				xbase.setUseInferredJvmModel(false);
				xbase.setJdtTypeHierarchy(false);
				addFragment(xbase);
				addFragment(new BuilderIntegrationFragment());
				addFragment(new Formatter2Fragment());
				addFragment(new QuickfixProviderFragment());
				LabelProviderFragment label = new LabelProviderFragment();
				label.setGenerateXtendStub(true);
				addFragment(label);
				addFragment(new OutlineTreeProviderFragment());
				addFragment(new JavaBasedContentAssistFragment());
				XtextAntlrUiGeneratorFragment antlrUI = new XtextAntlrUiGeneratorFragment();
				antlrUI.setOptions(antlrOptions);
				antlrUI.addAntlrParam("-Xconversiontimeout");
				antlrUI.addAntlrParam("10000");
				addFragment(antlrUI);
				
				addFragment(createIdeaPluginProject(projectName, runtimeProject, ideaProjectName, ideaProjectPath, fileExtensions));
				addFragment(createXtextAntlrIDEAGeneratorFragment(ideaProjectPath));
			}});
		}};
		
		generator.preInvoke();
		
		new DirectoryCleaner() {{
			setDirectory(runtimeProject + "/emf-gen");
		}}.invoke(null);
		
		new EcoreGenerator() {{
			setGenModel("platform:/resource/" + projectName + "/model/Xbase.genmodel");
			addSrcPath("platform:/resource/" + projectName + "/src");
			addSrcPath("platform:/resource/org.eclipse.xtext.common.types/src");
			setLineDelimiter(lineDelimiter);
		}}.invoke(null);
		
		new DirectoryCleaner() {{
			setDirectory(uiProject + "/src-gen");
		}}.invoke(null);
		
		new DirectoryCleaner() {{
			setDirectory(runtimeProject + "/src-gen");
		}}.invoke(null);
		
		new DirectoryCleaner() {{
			setDirectory(ideaProjectPath + "/src-gen");
		}}.invoke(null);
		
		generator.invoke(null);
		generator.postInvoke();
		Logger.getLogger(GenerateXbase.class).info("Done."); 
	}

	protected static IdeaPluginGenerator createIdeaPluginProject(
			String runtimeProjectName, 
			String runtimeProjectPath,
			String ideaProjectName, 
			String ideaProjectPath, 
			String fileExtensions) {
		IdeaPluginGenerator ideaPluginGenerator = new IdeaPluginGenerator();
		ideaPluginGenerator.setDeployable(false);
		ideaPluginGenerator.setRuntimeProjectName(runtimeProjectName);
		ideaPluginGenerator.setRuntimeProjectPath(runtimeProjectPath);
		ideaPluginGenerator.setIdeaProjectName(ideaProjectName);
		ideaPluginGenerator.setIdeaProjectPath(ideaProjectPath);
		ideaPluginGenerator.setFileExtensions(fileExtensions);
		return ideaPluginGenerator;
	}

	protected static XtextAntlrIDEAGeneratorFragment createXtextAntlrIDEAGeneratorFragment(String ideaProjectPath) {
		XtextAntlrIDEAGeneratorFragment antlrIdeaGeneratorFragment = new XtextAntlrIDEAGeneratorFragment();
		antlrIdeaGeneratorFragment.setIdeaProjectPath(ideaProjectPath);
		return antlrIdeaGeneratorFragment;
	}
}
