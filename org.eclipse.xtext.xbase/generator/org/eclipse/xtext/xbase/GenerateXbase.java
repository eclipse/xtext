/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe2.ecore.EcoreGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
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
		final String uiProject = System.getProperty("uiProject", root + "/../xtext-eclipse/" + projectName + ".ui");	
		final boolean backtrack = false;
		final boolean memoize = false;
		final String lineDelimiter = "\n";
		final String fileHeader = "/*******************************************************************************\n" +
			" * Copyright (c) 2010, ${year} itemis AG (http://www.itemis.eu) and others.\n" +
			" * This program and the accompanying materials are made available under the\n" + 
			" * terms of the Eclipse Public License 2.0 which is available at\n" + 
			" * http://www.eclipse.org/legal/epl-2.0.\n" + 
			" * \n" + 
			" * SPDX-License-Identifier: EPL-2.0\n" +
			" *******************************************************************************/";
		final String xbaseGenModel = "platform:/resource/" + projectName + "/model/Xbase.genmodel";
		
		final AntlrOptions antlrOptions = new AntlrOptions();
		antlrOptions.setBacktrack(backtrack);
		antlrOptions.setMemoize(memoize);
		
		@SuppressWarnings("deprecation")
		final XtextGenerator generator = new XtextGenerator() {{
			setConfiguration(new DefaultGeneratorModule() {{
				setProject(new StandardProjectConfig() {{
					setRootPath(root);
					setBaseName(projectName);
					setCreateEclipseMetaData(true);
					BundleProjectConfig eclipsePlugin = getEclipsePlugin();
					eclipsePlugin.setEnabled(true);
					eclipsePlugin.setRoot(uiProject);
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
				addReferencedResource(xbaseGenModel);
				setFileExtensions(fileExtensions);
				setGenerateXtendStubs(true);
				addFragment(new GrammarAccessFragment2());
				addFragment(new SerializerFragment2() {{ setGenerateSupportForDeprecatedContextEObject(true); setGenerateXtendStub(false); }} );
				addFragment(new Formatter2Fragment2());
				XtextAntlrGeneratorFragment2 antlr = new XtextAntlrGeneratorFragment2();
				ContentAssistFragment2 contentAssistFragment2 = new ContentAssistFragment2();
				contentAssistFragment2.setGenerateXtendStub(false);
				addFragment(contentAssistFragment2);
				antlr.setOptions(antlrOptions);
				addFragment(antlr);
			}});
			addLanguage(new XtextGeneratorLanguage() {{
				String fileExtensions = "___xbase";
				
				setGrammarUri("classpath:/org/eclipse/xtext/xbase/Xbase.xtext");
				addReferencedResource(xbaseGenModel);
				setFileExtensions(fileExtensions);
				setGenerateXtendStubs(true);
				addFragment(new GrammarAccessFragment2());
				addFragment(new SerializerFragment2() {{ setGenerateSupportForDeprecatedContextEObject(true); setGenerateXtendStub(false); }} );
				addFragment(new ResourceFactoryFragment2());
				XtextAntlrGeneratorFragment2 antlr = new XtextAntlrGeneratorFragment2();
				antlr.setDebugGrammar(true);
				antlr.setOptions(antlrOptions);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(antlr);
				ValidatorFragment2 validator = new ValidatorFragment2();
				validator.setInheritImplementation(false);
				validator.setGenerateXtendStub(false);
				validator.setGeneratePropertyPage(false);
				validator.setGenerateDeprecationValidation(false);
				addFragment(validator);
				ImportNamespacesScopingFragment2 scoping = new ImportNamespacesScopingFragment2();
				scoping.setGenerateXtendStub(false);
				addFragment(scoping);
				addFragment(new TypesGeneratorFragment2());
				XbaseGeneratorFragment2 xbase = new XbaseGeneratorFragment2();
				xbase.setGenerateXtendInferrer(false);
				xbase.setUseInferredJvmModel(false);
				xbase.setJdtTypeHierarchy(false);
				addFragment(xbase);
				addFragment(new BuilderIntegrationFragment2());
				addFragment(new Formatter2Fragment2());
				QuickfixProviderFragment2 quickfixProviderFragment2 = new QuickfixProviderFragment2();
				quickfixProviderFragment2.setGenerateXtendStub(false);
				addFragment(quickfixProviderFragment2);
				LabelProviderFragment2 label = new LabelProviderFragment2();
				label.setGenerateStub(false);
				addFragment(label);
				OutlineTreeProviderFragment2 outlineTreeProviderFragment2 = new OutlineTreeProviderFragment2();
				outlineTreeProviderFragment2.setGenerateXtendStub(false);
				addFragment(outlineTreeProviderFragment2);
				ContentAssistFragment2 contentAssistFragment2 = new ContentAssistFragment2();
				contentAssistFragment2.setGenerateXtendStub(false);
				addFragment(contentAssistFragment2);
			}});
			addLanguage(new XtextGeneratorLanguage() {{
				String fileExtensions = "___xbasewithannotations";
				
				setGrammarUri("classpath:/org/eclipse/xtext/xbase/annotations/XbaseWithAnnotations.xtext");
				addReferencedResource(xbaseGenModel);
				setFileExtensions(fileExtensions);
				setGenerateXtendStubs(true);
				addFragment(new GrammarAccessFragment2());
				addFragment(new SerializerFragment2() {{ setGenerateSupportForDeprecatedContextEObject(true); setGenerateXtendStub(false); }} );
				addFragment(new ResourceFactoryFragment2());
				XtextAntlrGeneratorFragment2 antlr = new XtextAntlrGeneratorFragment2();
				antlr.setOptions(antlrOptions);
				antlr.setDebugGrammar(true);
				antlr.addAntlrParam("-Xconversiontimeout");
				antlr.addAntlrParam("10000");
				addFragment(antlr);
				ValidatorFragment2 validator = new ValidatorFragment2();
				validator.setGenerateXtendStub(false);
				validator.setGeneratePropertyPage(false);
				validator.setGenerateDeprecationValidation(false);
				addFragment(validator);
				ImportNamespacesScopingFragment2 scoping = new ImportNamespacesScopingFragment2();
				scoping.setGenerateXtendStub(false);
				addFragment(scoping);
				addFragment(new TypesGeneratorFragment2());
				XbaseGeneratorFragment2 xbase = new XbaseGeneratorFragment2();
				xbase.setGenerateXtendInferrer(false);
				xbase.setUseInferredJvmModel(false);
				xbase.setJdtTypeHierarchy(false);
				addFragment(xbase);
				addFragment(new BuilderIntegrationFragment2());
				addFragment(new Formatter2Fragment2());
				QuickfixProviderFragment2 quickfixProviderFragment2 = new QuickfixProviderFragment2();
				quickfixProviderFragment2.setGenerateXtendStub(false);
				addFragment(quickfixProviderFragment2);
				LabelProviderFragment2 label = new LabelProviderFragment2();
				label.setGenerateStub(false);
				addFragment(label);
				OutlineTreeProviderFragment2 outlineTreeProviderFragment2 = new OutlineTreeProviderFragment2();
				outlineTreeProviderFragment2.setGenerateXtendStub(false);
				addFragment(outlineTreeProviderFragment2);
				ContentAssistFragment2 contentAssistFragment2 = new ContentAssistFragment2();
				contentAssistFragment2.setGenerateXtendStub(false);
				addFragment(contentAssistFragment2);
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
		new AbstractWorkflowComponent2() {
			@Override
			protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
				new File(runtimeProject, "plugin.properties").delete();
			}
		}.invoke(null);
		Logger.getLogger(GenerateXbase.class).info("Done."); 
	}

}
