/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenEnumGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.util.LineFilterOutputStream;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractEcoreGeneratorFragment extends AbstractGeneratorFragment {

	private static final Logger log = Logger.getLogger(AbstractEcoreGeneratorFragment.class);

	{
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("genmodel"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel",
					new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		GenModelPackage.eINSTANCE.getGenAnnotation();
	}
	
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] { "org.eclipse.emf.ecore", "org.eclipse.emf.common" };
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object) getBasePackage(grammar));
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		List<GeneratedMetamodel> typeSelect = org.eclipse.xtext.EcoreUtil2.typeSelect(grammar
				.getMetamodelDeclarations(), GeneratedMetamodel.class);
		Set<String> exportedPackages = new LinkedHashSet<String>();
		for (GeneratedMetamodel generatedMetamodel : typeSelect) {
			final String modelPackage = Strings.skipLastToken(getGeneratedEPackageName(grammar, generatedMetamodel
					.getEPackage()), ".");
			exportedPackages.add(modelPackage);
			exportedPackages.add(modelPackage + ".impl");
			exportedPackages.add(modelPackage + ".util");
		}
		return exportedPackages.toArray(new String[exportedPackages.size()]);
	}

	protected void copyGeneratedMetamodelsTo(List<Grammar> list, ResourceSet rs, Copier copier) {
		List<EPackage> generatedEPackages = new ArrayList<EPackage>(3);
		collectGeneratedMetamodels(generatedEPackages, list, new HashSet<Grammar>());
		Factory factory = new EcoreResourceFactoryImpl();
		for (EPackage copyMe : generatedEPackages) {
			Resource resource = factory.createResource(URI.createURI(copyMe.getNsURI()));
			resource.getContents().add(copier.copy(copyMe));
			rs.getResources().add(resource);
		}
	}

	private void collectGeneratedMetamodels(List<EPackage> generatedEPackages, List<Grammar> grammars, Set<Grammar> visited) {
		for (Grammar g : grammars) {
			if (visited.add(g)) {
				for (AbstractMetamodelDeclaration decl : g.getMetamodelDeclarations()) {
					if (decl instanceof GeneratedMetamodel)
						generatedEPackages.add(decl.getEPackage());
				}
				collectGeneratedMetamodels(generatedEPackages, g.getUsedGrammars(), visited);
			}
		}
	}
	
	protected void doGenerate(GenModel genModel) {
		Generator generator = new Generator();
		generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
				new GeneratorAdapterFactory.Descriptor() {
					public GeneratorAdapterFactory createAdapterFactory() {
						return new GenModelGeneratorAdapterFactory() {

							@Override
							public Adapter createGenEnumAdapter() {
								return new GenEnumGeneratorAdapter(this) {
									@Override
									protected OutputStream createOutputStream(URI workspacePath) throws Exception {
										return AbstractEcoreGeneratorFragment.this.createOutputStream(super
												.createOutputStream(workspacePath), getLineDelimiter());
									}
								};
							}

							@Override
							public Adapter createGenClassAdapter() {
								return new GenClassGeneratorAdapter(this) {
									@Override
									protected OutputStream createOutputStream(URI workspacePath) throws Exception {
										return AbstractEcoreGeneratorFragment.this.createOutputStream(super
												.createOutputStream(workspacePath), getLineDelimiter());
									}
								};
							}

							@Override
							public Adapter createGenPackageAdapter() {
								return new GenPackageGeneratorAdapter(this) {
									@Override
									protected OutputStream createOutputStream(URI workspacePath) throws Exception {
										return AbstractEcoreGeneratorFragment.this.createOutputStream(super
												.createOutputStream(workspacePath), getLineDelimiter());
									}

								};
							}

							@Override
							public Adapter createGenModelAdapter() {
								if (genModelGeneratorAdapter == null) {
									genModelGeneratorAdapter = new GenModelGeneratorAdapter(this) {
										// we handle these ones on our own
										@Override
										protected void generateModelBuildProperties(GenModel genModel,
												org.eclipse.emf.common.util.Monitor monitor) {
										}

										@Override
										protected void generateModelManifest(GenModel genModel,
												org.eclipse.emf.common.util.Monitor monitor) {
										}

										@Override
										protected void generateModelPluginProperties(GenModel genModel,
												org.eclipse.emf.common.util.Monitor monitor) {
										}

										@Override
										protected void generateModelPluginClass(GenModel genModel,
												org.eclipse.emf.common.util.Monitor monitor) {
										}
									};
								}
								return genModelGeneratorAdapter;
							}
						};
					}
				});
		generator.setInput(genModel);
		Diagnostic diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor());

		if (diagnostic.getSeverity() != Diagnostic.OK)
			log.info(diagnostic);
		
		if(isGenerateEdit()) {
			Diagnostic editDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,
					new BasicMonitor());
			if (editDiag.getSeverity() != Diagnostic.OK)
				log.info(editDiag);
		}
		
		if(isGenerateEditor()) {
			Diagnostic editorDiag = generator.generate(genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE,
					new BasicMonitor());
			if (editorDiag.getSeverity() != Diagnostic.OK)
				log.info(editorDiag);
		}
	}

	public OutputStream createOutputStream(OutputStream stream, String lineDelimiter) throws Exception {
		return new LineFilterOutputStream(stream, " * $Id" + "$", lineDelimiter != null ? lineDelimiter : Strings.newLine());
	}

	private String basePackage = null;
	private String xmiModelDirectory = null;
	private boolean generateEdit = false;
	private boolean generateEditor = false;

	public void setBasePackage(String basePackage) {
		if ("".equals(basePackage.trim()))
			return;
		this.basePackage = basePackage;
	}

	public String getBasePackage(Grammar g) {
		if (basePackage == null)
			return GrammarUtil.getNamespace(g);
		return basePackage;
	}

	public String getXmiModelDirectory() {
		return xmiModelDirectory;
	}
	
	public void setXmiModelDirectory(String dir) {
		xmiModelDirectory = dir;
	}

	public String getGeneratedEPackageName(Grammar g, EPackage pack) {
		return getBasePackage(g) + "." + pack.getName() + "." + Strings.toFirstUpper(pack.getName()) + "Package";
	}
	
	/**
	 * If true, the EMF-edit code will be generated as well.
	 * 
	 * @param gen
	 * @see #setEditDirectory(String)
	 * @see #setEditPluginID(String)
	 */
	public void setGenerateEdit(boolean gen) {
		this.generateEdit = gen;
	}
	
	/**
	 * If true, the EMF editor code will be generated as well.
	 * 
	 * @param gen
	 * @see #setEditorDirectory(String)
	 * @see #setEditorPluginID(String)
	 */
	public void setGenerateEditor(boolean gen) {
		this.generateEditor = gen;
	}

	public boolean isGenerateEdit() {
		return generateEdit;
	}

	public boolean isGenerateEditor() {
		return generateEditor;
	}

}
