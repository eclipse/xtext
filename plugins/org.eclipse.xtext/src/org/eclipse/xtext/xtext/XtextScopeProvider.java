/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.impl.SimpleCachingScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextScopeProvider extends DefaultScopeProvider {

	@Override
	protected IScope createScope(Resource resource, EClass type) {
		if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass()))
			return new XtextMetaModelReferenceScope(resource, type);
		
		if (resource.getContents().size() != 1)
			throw new IllegalArgumentException("resource is not as expected: contents.size == "
					+ resource.getContents().size() + " but expected: 1");
		EObject firstContent = resource.getContents().get(0);
		if (!(firstContent instanceof Grammar))
			throw new IllegalArgumentException("resource does not contain a grammar, but: " + firstContent);
		return createScope((Grammar) firstContent, type);
	}

	protected IScope createScope(Grammar g, EClass type) {
		Grammar superGrammar = GrammarUtil.getSuperGrammar(g);
		IScope parent;
		if (superGrammar != null)
			parent = createScope(superGrammar, type);
		else
			parent = IScope.NULLSCOPE;
		return new SimpleCachingScope(parent, g.eResource(), type);
	}

}
