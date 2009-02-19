/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import static org.eclipse.xtext.EcoreUtil2.*;
import static org.eclipse.xtext.GrammarUtil.*;
import static org.eclipse.xtext.XtextPackage.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Strings;

public class EcoreGeneratorFragment extends AbstractGeneratorFragment {

	private static Logger log = Logger.getLogger(EcoreGeneratorFragment.class);

	{
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("genmodel"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel",
					new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		GenModelPackage.eINSTANCE.getGenAnnotation();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] {"org.eclipse.emf.ecore", "org.eclipse.emf.common"};
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		List<GeneratedMetamodel> typeSelect = org.eclipse.xtext.EcoreUtil2.typeSelect(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		Set<String> exportedPackages = new LinkedHashSet<String>();
		for (GeneratedMetamodel generatedMetamodel : typeSelect) {
			exportedPackages.add(Strings.skipLastToken(getGeneratedEPackageName(grammar, generatedMetamodel.getEPackage()),"."));
		}
		return exportedPackages.toArray(new String[exportedPackages.size()]);
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		List<GeneratedMetamodel> list = typeSelect(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		List<EPackage> packs = collect(list, GENERATED_METAMODEL__EPACKAGE, EPackage.class);
		String path = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.SRC_GEN).getPath();
		generateEcoreJavaClasses(packs, getNamespace(grammar), path, grammar);
	}

	private final XtextResourceSet rs = new XtextResourceSet();

	public void setGenModel(String uri) {
		try {
			rs.getResource(URI.createURI(uri), true);
		} catch (Exception e) {
			log.error("Couldn't find genmodel for uri '"+uri+"'");
			throw new RuntimeException(e);
		}
	}

	public void setGenModels(String uris) {
		if ("".equals(uris))
			return;
		String[] strings = uris.split(",");
		for (String string : strings) {
			setGenModel(string.trim());
		}
	}

	private Collection<? extends GenPackage> getUsedGenPackages() {
		List<GenPackage> result = new ArrayList<GenPackage>();
		TreeIterator<Object> iterator = EcoreUtil.getAllContents(rs, true);
		while (iterator.hasNext()) {
			Object next = iterator.next();
			if (next instanceof GenPackage)
				result.add((GenPackage) next);
		}
		return result;
	}

	public void generateEcoreJavaClasses(Collection<? extends EPackage> packs, String basePackage, final String uri,
			final Grammar grammar) throws ConfigurationException {

		ResourceSet rs = new ResourceSetImpl();
		Resource res2 = rs.createResource(URI.createFileURI(new File(uri + "/" + grammar.getName().replace('.', '/') + ".ecore").getAbsolutePath()));

		GenModel genModel = GenModelPackage.eINSTANCE.getGenModelFactory().createGenModel();
		Resource res = rs.createResource(URI.createFileURI(new File(uri + "/" + grammar.getName().replace('.', '/') + ".genmodel").getAbsolutePath()));
		genModel.initialize(packs);

		genModel.setModelDirectory(uri);

		// genModel.setModelDirectory(modelProjectName);

		genModel.setValidateModel(false);
		genModel.setForceOverwrite(true);
		genModel.setCanGenerate(true);
		genModel.setFacadeHelperClass(null);
		genModel.setBundleManifest(false);
		genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);

		for (GenPackage genPackage : genModel.getGenPackages()) {
			genPackage.setBasePackage(basePackage);
		}
		genModel.getUsedGenPackages().addAll(getUsedGenPackages());

		genModel.reconcile();
		Generator generator = new Generator();
		generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
				new GeneratorAdapterFactory.Descriptor() {
					public GeneratorAdapterFactory createAdapterFactory() {
						return new GenModelGeneratorAdapterFactory() {

							@Override
							public Adapter createGenClassAdapter() {
								return new GenClassGeneratorAdapter(this) {
									@Override
									protected OutputStream createOutputStream(URI workspacePath) throws Exception {

										return getURIConverter().createOutputStream(workspacePath);
									}

									@Override
									protected URI toURI(String pathName) {
										return URI.createFileURI(uri);
									}
								};
							}

							@Override
							public Adapter createGenPackageAdapter() {
								return new GenPackageGeneratorAdapter(this) {
									@Override
									protected URI toURI(String pathName) {
										return URI.createFileURI(uri);
									}

									@Override
									protected OutputStream createOutputStream(URI workspacePath) throws Exception {
										return getURIConverter().createOutputStream(workspacePath);
									}

								};
							}
						};
					}
				});
		generator.setInput(genModel);
		Diagnostic diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor());

		// write genmodel
		res.getContents().add(genModel);
		res2.getContents().addAll(EcoreUtil.copyAll(packs));
		try {
			res2.save(null);
			res.save(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		if (diagnostic.getSeverity() != Diagnostic.OK)
			// TODO choose loglevel that matches the severity of the diagnostic
			log.info(diagnostic);
	}

	public static String getGeneratedEPackageName(Grammar g, EPackage pack) {
		return GrammarUtil.getNamespace(g) + "." + pack.getName() + "." + Strings.toFirstUpper(pack.getName())
				+ "Package";
	}
}
