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
import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.Generator;

public class GrammarAccessFragment extends AbstractGeneratorFragment {

	private final Logger log = Logger.getLogger(GrammarAccessFragment.class);

	@Override
	public Map<String, String> getGuiceBindingsRt(Grammar grammar) {
		return Collections.singletonMap(IGrammarAccess.class.getName(), GrammarAccessUtil.getGrammarAccessFQName(grammar));
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		super.generate(grammar, ctx);
		// save grammar model
		ResourceSet setImpl = grammar.eResource().getResourceSet();
		String xmiPath = GrammarUtil.getClasspathRelativePathToXmi(grammar);
		Resource resource = setImpl.createResource(URI.createURI(ctx.getOutput().getOutlet(Generator.SRC_GEN).getPath() + "/"
				+ xmiPath));
		Grammar grammarToUse = grammar;
		while(grammarToUse != null) {
			resource.getContents().add(grammarToUse);
			for(AbstractMetamodelDeclaration metamodelDecl: grammarToUse.getMetamodelDeclarations()) {
				EPackage generatedPackage = metamodelDecl.getEPackage();
				Resource packResource = generatedPackage.eResource();
				packResource.setURI(URI.createURI(generatedPackage.getNsURI()));
			}
			grammarToUse = grammarToUse.getSuperGrammar();
		}
		try {
			resource.save(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}
