package org.eclipse.xtext.xbase;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.emf.mwe2.ecore.EcoreGenerator;
import org.eclipse.xtext.generator.adapter.FragmentAdapter;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.generator.parser.antlr.DebugAntlrGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment;
import org.eclipse.xtext.generator.resourceFactory.ResourceFactoryFragment;
import org.eclipse.xtext.generator.serializer.SerializerFragment;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment;
import org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment;
import org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.WizardConfig;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2;
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2;
import org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2;
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2;
import org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2;

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
		final String root = "..";
		final String projectName = "org.eclipse.xtext.xbase";
		final String runtimeProject = root + "/" + projectName;
		final boolean backtrack = false;
		final boolean memoize = false;
		final String lineDelimiter = "\n";
		final String fileHeader = "/*******************************************************************************\n" +
			" * Copyright (c) 2010-${year} itemis AG (http://www.itemis.eu) and others.\n" +
			" * All rights reserved. This program and the accompanying materials\n" +
			" * are made available under the terms of the Eclipse Public License v1.0\n" +
			" * which accompanies this distribution, and is available at\n" +
			" * http://www.eclipse.org/legal/epl-v10.html\n" +
			" *******************************************************************************/";
		
		new StandaloneSetup() {{
			// the maven archetype contains a template file called .project
			setIgnoreBrokenProjectFiles(true);
			setPlatformUri(root + "/..");
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
		
		final XtextGenerator generator = new XtextGenerator() {{
			setConfiguration(new DefaultGeneratorModule() {{
				setProject(new WizardConfig() {{
					setRootPath(root);
					setBaseName(projectName);
					setEclipseEditor(true);
				}});
				setCode(new CodeConfig() {{
					setEncoding("ISO-8859-1");
					setLineDelimiter(lineDelimiter);
					setFileHeader(fileHeader);
					setPreferXtendStubs(false);
				}});
			}});

			addLanguage(new LanguageConfig2() {{
				String fileExtensions = "___xtype";
				
				setResourceSet(xtypeResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/Xtype.xtext");
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment2());
				addFragment(new FragmentAdapter(new SerializerFragment()));
				addFragment(new Formatter2Fragment2());
				addFragment(new FragmentAdapter(new JavaBasedContentAssistFragment()));
				XtextAntlrGeneratorFragment antlr = new XtextAntlrGeneratorFragment();
				antlr.setOptions(antlrOptions);
				addFragment(new FragmentAdapter(antlr));
			}});
			addLanguage(new LanguageConfig2() {{
				String fileExtensions = "___xbase";
				
				setResourceSet(xbaseResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/Xbase.xtext");
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment2());
				addFragment(new FragmentAdapter(new SerializerFragment()));
				ResourceFactoryFragment resourceFactory = new ResourceFactoryFragment();
				resourceFactory.setFileExtensions(fileExtensions);
				addFragment(new FragmentAdapter(resourceFactory));
				XtextAntlrGeneratorFragment antlr = new XtextAntlrGeneratorFragment();
				antlr.setOptions(antlrOptions);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(new FragmentAdapter(antlr));
				DebugAntlrGeneratorFragment antlrDebug = new DebugAntlrGeneratorFragment();
				antlrDebug.setOptions(antlrOptions);
				addFragment(new FragmentAdapter(antlrDebug));
				ValidatorFragment2 validator = new ValidatorFragment2();
				validator.setInheritImplementation(false);
				addFragment(validator);
				addFragment(new ImportNamespacesScopingFragment2());
				addFragment(new TypesGeneratorFragment2());
				XbaseGeneratorFragment2 xbase = new XbaseGeneratorFragment2();
				xbase.setGenerateXtendInferrer(false);
				xbase.setUseInferredJvmModel(false);
				xbase.setJdtTypeHierarchy(false);
				addFragment(xbase);
				addFragment(new BuilderIntegrationFragment2());
				addFragment(new Formatter2Fragment2());
				addFragment(new FragmentAdapter(new QuickfixProviderFragment()));
				LabelProviderFragment label = new LabelProviderFragment();
				label.setGenerateStub(false);
				addFragment(new FragmentAdapter(label));
				addFragment(new OutlineTreeProviderFragment2());
				addFragment(new FragmentAdapter(new JavaBasedContentAssistFragment()));
				XtextAntlrUiGeneratorFragment antlrUI = new XtextAntlrUiGeneratorFragment();
				antlrUI.setOptions(antlrOptions);
				antlrUI.addAntlrParam("-Xconversiontimeout");
				antlrUI.addAntlrParam("10000");
				addFragment(new FragmentAdapter(antlrUI));
			}});
			addLanguage(new LanguageConfig2() {{
				String fileExtensions = "___xbasewithannotations";
				
				setResourceSet(xannotationsResourceSet);
				setUri("classpath:/org/eclipse/xtext/xbase/annotations/XbaseWithAnnotations.xtext");
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment2());
				addFragment(new FragmentAdapter(new SerializerFragment()));
				ResourceFactoryFragment resourceFactory = new ResourceFactoryFragment();
				resourceFactory.setFileExtensions(fileExtensions);
				addFragment(new FragmentAdapter(resourceFactory));
				XtextAntlrGeneratorFragment antlr = new XtextAntlrGeneratorFragment();
				antlr.setOptions(antlrOptions);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(new FragmentAdapter(antlr));
				DebugAntlrGeneratorFragment antlrDebug = new DebugAntlrGeneratorFragment();
				antlrDebug.setOptions(antlrOptions);
				addFragment(new FragmentAdapter(antlrDebug));
				addFragment(new ValidatorFragment2());
				addFragment(new ImportNamespacesScopingFragment2());
				addFragment(new TypesGeneratorFragment2());
				XbaseGeneratorFragment2 xbase = new XbaseGeneratorFragment2();
				xbase.setGenerateXtendInferrer(false);
				xbase.setUseInferredJvmModel(false);
				xbase.setJdtTypeHierarchy(false);
				addFragment(xbase);
				addFragment(new BuilderIntegrationFragment2());
				addFragment(new Formatter2Fragment2());
				addFragment(new FragmentAdapter(new QuickfixProviderFragment()));
				LabelProviderFragment label = new LabelProviderFragment();
				label.setGenerateXtendStub(true);
				addFragment(new FragmentAdapter(label));
				addFragment(new OutlineTreeProviderFragment2());
				addFragment(new FragmentAdapter(new JavaBasedContentAssistFragment()));
				XtextAntlrUiGeneratorFragment antlrUI = new XtextAntlrUiGeneratorFragment();
				antlrUI.setOptions(antlrOptions);
				antlrUI.addAntlrParam("-Xconversiontimeout");
				antlrUI.addAntlrParam("10000");
				addFragment(new FragmentAdapter(antlrUI));
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
		
		generator.invoke(null);
		generator.postInvoke();
		Logger.getLogger(GenerateXbase.class).info("Done."); 
	}

}
