package org.eclipse.xtext.xbase.idea;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.idea.generator.IdeaPluginGenerator;
import org.eclipse.xtext.idea.generator.parser.antlr.XtextAntlrIDEAGeneratorFragment;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @noreference This class is not intended to be referenced by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
final class GenerateXbase {
	/**
	 * Can't use MWE2 because of circular dependencies
	 */
	public static void main(String[] args) {
		final String projectName = "org.eclipse.xtext.xbase";
		final String ideaProjectName = projectName + ".idea";
		final String ideaProject = "../" + ideaProjectName;
		final String runtimeProject = ideaProject + "/../../plugins/" + projectName;
		final boolean backtrack = false;
		final boolean memoize = false;
		final String lineDelimiter = "\n";
		final String encoding = "UTF-8";

		new StandaloneSetup() {{
			// the maven archetype contains a template file called .project
			setIgnoreBrokenProjectFiles(true);
			setPlatformUri(runtimeProject + "/..");
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
			setPathRtProject(ideaProject);
			setProjectNameRt(ideaProjectName);
			setLineDelimiter(lineDelimiter);

			addLanguage(new LanguageConfig() {{
				setForcedResourceSet(xtypeResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/Xtype.xtext");
				setFileExtensions("___xtype");
				
				IdeaPluginGenerator ideaPluginGenerator = new IdeaPluginGenerator();
				ideaPluginGenerator.setPathIdeaPluginProject(ideaProject);
				ideaPluginGenerator.setPathRuntimePluginProject(runtimeProject);
				ideaPluginGenerator.setFileExtensions("___xtype");
				ideaPluginGenerator.setEncoding(encoding);
				addFragment(ideaPluginGenerator);
				
				XtextAntlrIDEAGeneratorFragment antlrIdeaGeneratorFragment = new XtextAntlrIDEAGeneratorFragment();
				antlrIdeaGeneratorFragment.setPathIdeaPluginProject(ideaProject);
				antlrIdeaGeneratorFragment.setEncoding(encoding);
				addFragment(antlrIdeaGeneratorFragment);
			}});
			addLanguage(new LanguageConfig() {{
				setForcedResourceSet(xbaseResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/Xbase.xtext");
				setFileExtensions("___xbase");
				
				IdeaPluginGenerator ideaPluginGenerator = new IdeaPluginGenerator();
				ideaPluginGenerator.setPathIdeaPluginProject(ideaProject);
				ideaPluginGenerator.setPathRuntimePluginProject(runtimeProject);
				ideaPluginGenerator.setFileExtensions("___xbase");
				ideaPluginGenerator.setEncoding(encoding);
				addFragment(ideaPluginGenerator);
				
				XtextAntlrIDEAGeneratorFragment antlrIdeaGeneratorFragment = new XtextAntlrIDEAGeneratorFragment();
				antlrIdeaGeneratorFragment.setPathIdeaPluginProject(ideaProject);
				antlrIdeaGeneratorFragment.setEncoding(encoding);
				addFragment(antlrIdeaGeneratorFragment);
			}});
			addLanguage(new LanguageConfig() {{
				setForcedResourceSet(xannotationsResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/annotations/XbaseWithAnnotations.xtext");
				setFileExtensions("___xbasewithannotations");
				
				IdeaPluginGenerator ideaPluginGenerator = new IdeaPluginGenerator();
				ideaPluginGenerator.setPathIdeaPluginProject(ideaProject);
				ideaPluginGenerator.setPathRuntimePluginProject(runtimeProject);
				ideaPluginGenerator.setFileExtensions("___xbasewithannotations");
				ideaPluginGenerator.setEncoding(encoding);
				addFragment(ideaPluginGenerator);
				
				XtextAntlrIDEAGeneratorFragment antlrIdeaGeneratorFragment = new XtextAntlrIDEAGeneratorFragment();
				antlrIdeaGeneratorFragment.setPathIdeaPluginProject(ideaProject);
				antlrIdeaGeneratorFragment.setEncoding(encoding);
				addFragment(antlrIdeaGeneratorFragment);
			}});
		}};
		
		generator.preInvoke();
		
		new DirectoryCleaner() {{
			setDirectory(projectName + "/src-gen");
		}}.invoke(null);
		
		generator.invoke(null);
		generator.postInvoke();
		Logger.getLogger(GenerateXbase.class).info("Done."); 
	}
}
