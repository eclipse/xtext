/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmptyPackageAwareGrammarAccessFragment extends AbstractGeneratorFragment {

	private static final Logger log = Logger.getLogger(EmptyPackageAwareGrammarAccessFragment.class);

	@Override
	protected String getTemplate() {
		return GrammarAccessFragment.class.getName().replaceAll("\\.", "::");
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IGrammarAccess.class.getName(), GrammarAccessUtil.getGrammarAccessFQName(grammar))
			.getBindings();
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[] { GrammarUtil.getNamespace(grammar), GrammarUtil.getNamespace(grammar) + ".services" };
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		
		final ResourceSaveIndicator isSaving = new ResourceSaveIndicator();
		// create a defensive clone
		Grammar copy = deepCopy(grammar, isSaving);
		ResourceSet set = copy.eResource().getResourceSet();
		
		// save grammar model
		String xmiPath = GrammarUtil.getClasspathRelativePathToXmi(copy);
		Resource resource = set.createResource(
				URI.createURI(ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath() + "/" + xmiPath), 
				ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		addAllGrammarsToResource(resource, copy, new HashSet<Grammar>());
		isSaving.set(Boolean.TRUE);
		try {
			resource.save(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			isSaving.set(Boolean.FALSE);
		}
	}
	
	public Grammar deepCopy(Grammar grammar, ResourceSaveIndicator isSaving) {
		ResourceSet cloneInto = new ResourceSetImpl();
		// substitute the resource factory for ecore-files
		cloneInto.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				FragmentFakingEcoreResourceFactoryImpl.ECORE_SUFFIX, new FragmentFakingEcoreResourceFactoryImpl(isSaving));
		// clone it
		ResourceSet set = EcoreUtil2.clone(cloneInto, grammar.eResource().getResourceSet());
		// get the copy of the grammar and use this one
		Grammar copy = (Grammar) set.getResource(grammar.eResource().getURI(), true).getContents().get(0);
		return copy;
	}

	public void addAllGrammarsToResource(Resource resource, Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return;
		resource.getContents().add(grammar);
		replaceResourceURIsWithNsURIs(grammar, resource.getResourceSet());
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			addAllGrammarsToResource(resource, usedGrammar, visitedGrammars);
		}
	}

	public void replaceResourceURIsWithNsURIs(Grammar grammar, ResourceSet set) {
		for (AbstractMetamodelDeclaration metamodelDecl : grammar.getMetamodelDeclarations()) {
			EPackage pack = metamodelDecl.getEPackage();
			Resource packResource = pack.eResource();
			if (!packResource.getURI().equals(pack.getNsURI())) {
				ResourceSet packResourceSet = packResource.getResourceSet();
				if (packResourceSet != null && packResourceSet.equals(set)) {
					EPackage topMost = pack;
					// we need to be aware of empty subpackages
					while(topMost.getESuperPackage() != null && topMost.getESuperPackage().eResource() == topMost.eResource())
						topMost = topMost.getESuperPackage();
					if (packResource.getContents().contains(topMost) && packResource.getContents().size() == 1) {
						if (!topMost.getEClassifiers().isEmpty())
							packResource.setURI(URI.createURI(topMost.getNsURI()));
						else
							moveSubpackagesToNewResource(topMost, set);
					}
				}
			}
		}
	}
	
	public void moveSubpackagesToNewResource(EPackage pack, ResourceSet set) {
		for(int i = pack.getESubpackages().size() - 1; i >= 0; i--) {
			EPackage sub = pack.getESubpackages().get(i);
			if (sub.eResource() == pack.eResource()) {
				if (sub.getEClassifiers().isEmpty()) {
					moveSubpackagesToNewResource(sub, set);
				} else {
					Resource resource = set.createResource(
							URI.createURI("___temp___." + FragmentFakingEcoreResourceFactoryImpl.ECORE_SUFFIX), 
							ContentHandler.UNSPECIFIED_CONTENT_TYPE);
					resource.setURI(URI.createURI(sub.getNsURI()));
					resource.getContents().add(sub);
					pack.getESubpackages().remove(i);
				}
			}
		}
	}
}
