package org.eclipse.xtext.xbase;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe2.ecore.EcoreGenerator;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.resourceFactory.ResourceFactoryFragment2;
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2;
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2;
import org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ui.contentAssist.ContentAssistFragment2;
import org.eclipse.xtext.xtext.generator.ui.labeling.LabelProviderFragment2;
import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2;
import org.eclipse.xtext.xtext.generator.ui.quickfix.QuickfixProviderFragment2;
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
		final String xbaseGenModel = "platform:/resource/" + projectName + "/model/Xbase.genmodel";
		
		final AntlrOptions antlrOptions = new AntlrOptions();
		antlrOptions.setBacktrack(backtrack);
		antlrOptions.setMemoize(memoize);
		
		final XtextGenerator generator = new XtextGenerator() {{
			setConfiguration(new DefaultGeneratorModule() {{
				setProject(new StandardProjectConfig() {{
					setRootPath(root);
					setBaseName(projectName);
					getEclipsePlugin().setEnabled(true);
				}});
				setCode(new CodeConfig() {{
					setEncoding("ISO-8859-1");
					setLineDelimiter(lineDelimiter);
					setFileHeader(fileHeader);
					setPreferXtendStubs(false);
				}});
			}});

			addLanguage(new XtextGeneratorLanguage() {{
				String fileExtensions = "___xtype";
				
				setGrammarUri("classpath:/org/eclipse/xtext/xbase/Xtype.xtext");
				getStandaloneSetup().addLoadedResource(xbaseGenModel);
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment2());
				addFragment(new SerializerFragment2() {{ setGenerateSupportForDeprecatedContextObject(true); }} );
				addFragment(new Formatter2Fragment2());
				XtextAntlrGeneratorFragment2 antlr = new XtextAntlrGeneratorFragment2();
				addFragment(new ContentAssistFragment2());
				antlr.setOptions(antlrOptions);
				addFragment(antlr);
			}});
			addLanguage(new XtextGeneratorLanguage() {{
				String fileExtensions = "___xbase";
				
				setGrammarUri("classpath:/org/eclipse/xtext/xbase/Xbase.xtext");
				getStandaloneSetup().addLoadedResource(xbaseGenModel);
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment2());
				addFragment(new SerializerFragment2() {{ setGenerateSupportForDeprecatedContextObject(true); }} );
				addFragment(new ResourceFactoryFragment2());
				XtextAntlrGeneratorFragment2 antlr = new XtextAntlrGeneratorFragment2();
				antlr.setDebugGrammar(true);
				antlr.setOptions(antlrOptions);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(antlr);
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
				addFragment(new QuickfixProviderFragment2());
				LabelProviderFragment2 label = new LabelProviderFragment2();
				label.setGenerateStub(false);
				addFragment(label);
				addFragment(new OutlineTreeProviderFragment2());
				addFragment(new ContentAssistFragment2());
			}});
			addLanguage(new XtextGeneratorLanguage() {{
				String fileExtensions = "___xbasewithannotations";
				
				setGrammarUri("classpath:/org/eclipse/xtext/xbase/annotations/XbaseWithAnnotations.xtext");
				getStandaloneSetup().addLoadedResource(xbaseGenModel);
				setFileExtensions(fileExtensions);
				addFragment(new GrammarAccessFragment2());
				addFragment(new SerializerFragment2() {{ setGenerateSupportForDeprecatedContextObject(true); }} );
				addFragment(new ResourceFactoryFragment2());
				XtextAntlrGeneratorFragment2 antlr = new XtextAntlrGeneratorFragment2();
				antlr.setOptions(antlrOptions);
				antlr.setDebugGrammar(true);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(antlr);
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
				addFragment(new QuickfixProviderFragment2());
				LabelProviderFragment2 label = new LabelProviderFragment2();
				label.setGenerateStub(false);
				addFragment(label);
				addFragment(new OutlineTreeProviderFragment2());
				addFragment(new ContentAssistFragment2());
			}});
		}};
		
		generator.preInvoke();
		
		new DirectoryCleaner() {{
			setDirectory(runtimeProject + "/emf-gen");
		}}.invoke(null);
		
		new EcoreGenerator() {{
			setGenModel(xbaseGenModel);
			addSrcPath("platform:/resource/" + projectName + "/src");
			addSrcPath("platform:/resource/org.eclipse.xtext.common.types/src");
			setLineDelimiter(lineDelimiter);
		}}.invoke(null);
		
		generator.invoke(null);
		generator.postInvoke();
		Logger.getLogger(GenerateXbase.class).info("Done."); 
	}

}
