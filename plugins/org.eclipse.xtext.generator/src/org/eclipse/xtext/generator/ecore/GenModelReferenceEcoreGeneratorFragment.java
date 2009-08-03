/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import static org.eclipse.xtext.EcoreUtil2.collect;
import static org.eclipse.xtext.EcoreUtil2.typeSelect;
import static org.eclipse.xtext.XtextPackage.GENERATED_METAMODEL__EPACKAGE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sebastian Zarnekow
 */
public class GenModelReferenceEcoreGeneratorFragment extends AbstractEcoreGeneratorFragment {

	private static Logger log = Logger.getLogger(GenModelReferenceEcoreGeneratorFragment.class);

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);

		List<GeneratedMetamodel> list = typeSelect(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
		List<EPackage> packs = collect(list, GENERATED_METAMODEL__EPACKAGE, EPackage.class);
		if (!packs.isEmpty()) {
			ResourceSet rs = new XtextResourceSet();
			Copier copier = new EcoreUtil.Copier();
			copyGeneratedMetamodelsTo(grammar.getUsedGrammars(), rs, copier);
			List<EPackage> copies = new ArrayList<EPackage>(packs.size());
			for (EPackage pack : packs) {
				copies.add((EPackage) copier.copy(pack));
			}
			copier.copyReferences();

			String xmiPath;
			if (getXmiModelDirectory() == null || "".equals(getXmiModelDirectory()))
				xmiPath = ctx.getOutput().getOutlet(org.eclipse.xtext.generator.Generator.SRC_GEN).getPath() + "/"
						+ grammar.getName().substring(0, grammar.getName().lastIndexOf('.')).replace('.', '/');
			else
				xmiPath = getXmiModelDirectory();
			generateEcoreJavaClasses(rs, copies, getBasePackage(grammar), xmiPath, grammar);
		}
	}

	private String referencedGenModel;
	private boolean skipGenerate = false;

	public String getReferencedGenModel() {
		return referencedGenModel;
	}
	
	public void setReferencedGenModel(String referencedGenModel) {
		if ("".equals(referencedGenModel))
			return;
		this.referencedGenModel = referencedGenModel;
	}

	public void generateEcoreJavaClasses(ResourceSet rs, Collection<? extends EPackage> packs,
			final String basePackage, final String xmiPath, final Grammar grammar)
			throws ConfigurationException {
		Resource ecoreResource;
		Resource genModelResource = null;
		String modelName = grammar.getName().substring(grammar.getName().lastIndexOf('.') + 1);
		try {
			String prefix = new File(xmiPath).getCanonicalPath() + "/" + modelName;
			URI ecoreResourceURI = URI.createFileURI(prefix + ".ecore");
			ecoreResource = rs.createResource(ecoreResourceURI, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
			ecoreResource.getContents().addAll(packs);
			ecoreResource.save(null);
			if (getReferencedGenModel() != null) {
				URI genModelURI = URI.createURI(getReferencedGenModel());
				genModelResource = rs.getResource(genModelURI, true);
				if (genModelURI.isPlatform()) {
					genModelURI = EcorePlugin.resolvePlatformResourcePath(
							genModelURI.toPlatformString(true));
					ecoreResourceURI = ecoreResourceURI.deresolve(genModelURI, true, true, true);
					rs.getURIConverter().getURIMap().put(ecoreResourceURI.resolve(genModelResource.getURI()), ecoreResourceURI);
					ecoreResource.setURI(ecoreResourceURI);
				}
			}
		}
		catch (IOException e1) {
			throw new IllegalStateException("Couldn't compute canonical path for "
					+ new File(xmiPath).getAbsolutePath());
		}

		if (genModelResource == null)
			return;
		
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		genModel.initialize(packs);

		for (GenPackage genPackage : genModel.getGenPackages()) {
			if (packs.contains(genPackage.getEcorePackage()))
				genPackage.setBasePackage(basePackage);
		}
		
		try {
			genModelResource.save(null);
		}
		catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		if (!skipGenerate) {
			genModel.setCanGenerate(true);
			genModel.setFacadeHelperClass(null);
			genModel.reconcile();
			doGenerate(genModel);
		}
	}

	public void setSkipGenerate(boolean skipGenerate) {
		this.skipGenerate = skipGenerate;
	}

	public boolean isSkipGenerate() {
		return skipGenerate;
	}

}

