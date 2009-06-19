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
import org.eclipse.xtext.generator.IGeneratorFragment;

/**
 * An {@link IGeneratorFragment} to create a grammar access class for an Xtext language.
 *  
 * @author koehnlein
 */
public class GrammarAccessFragment extends AbstractGeneratorFragment {

	private final Logger log = Logger.getLogger(GrammarAccessFragment.class);

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
		// create a defensive clone
		ResourceSet setImpl = EcoreUtil2.clone(new ResourceSetImpl(),grammar.eResource().getResourceSet());
		grammar = (Grammar) setImpl.getResource(grammar.eResource().getURI(), true).getContents().get(0);
		
		// save grammar model
		String xmiPath = GrammarUtil.getClasspathRelativePathToXmi(grammar);
		Resource resource = setImpl.createResource(URI.createURI(ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath()
				+ "/" + xmiPath));
		addAllGrammarsToResource(resource, grammar, new HashSet<Grammar>());
		try {
			resource.save(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	private void addAllGrammarsToResource(Resource resource, Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return;
		resource.getContents().add(grammar);
		replaceResourceURIsWithNsURIs(grammar);
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			addAllGrammarsToResource(resource, usedGrammar, visitedGrammars);
		}
	}

	private void replaceResourceURIsWithNsURIs(Grammar grammar) {
		for (AbstractMetamodelDeclaration metamodelDecl : grammar.getMetamodelDeclarations()) {
			EPackage generatedPackage = metamodelDecl.getEPackage();
			Resource packResource = generatedPackage.eResource();
			packResource.setURI(URI.createURI(generatedPackage.getNsURI()));
		}
	}
}
