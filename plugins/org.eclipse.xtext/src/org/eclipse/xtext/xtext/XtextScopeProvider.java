/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.impl.ScopedElement;
import org.eclipse.xtext.crossref.impl.SimpleCachingScope;
import org.eclipse.xtext.crossref.impl.SimpleScope;
import org.eclipse.xtext.resource.metamodel.IDeclaredMetamodelAccess;
import org.eclipse.xtext.resource.metamodel.DeclaredMetamodelAccessFactory;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextScopeProvider extends DefaultScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Type()) {
			if (context instanceof TypeRef) {
				final TypeRef typeRef = (TypeRef) context;
				final AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
				if (metaModel != null) {
					return createClassifierScope(DeclaredMetamodelAccessFactory.getAccessTo(metaModel).getEClassifiers());
				} else if (metaModel == null) {
					return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
				}
			} else if (context instanceof CrossReference || context instanceof ParserRule) {
				return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
			} 
			return IScope.NULLSCOPE;
		} else 
			return super.getScope(context, reference);
	}

	private SimpleScope createClassifierScope(Iterable<EClassifier> classifiers) {
		return new SimpleScope(IScope.NULLSCOPE, 
				CollectionUtils.map(classifiers, new Function<EClassifier, IScopedElement>() {
					public IScopedElement exec(EClassifier param) {
						return ScopedElement.create(param.getName(), param);
					}
				}));
	}
	
	protected IScope createReferencedPackagesScope(Grammar g) {
		final Collection<EClassifier> allClassifiers = new ArrayList<EClassifier>();
		for(AbstractMetamodelDeclaration decl: g.getMetamodelDeclarations()) {
			final IDeclaredMetamodelAccess access = DeclaredMetamodelAccessFactory.getAccessTo(decl);
			CollectionUtils.addAll(allClassifiers, access.getEClassifiers());
		}
		return createClassifierScope(allClassifiers);
	}
	
	@Override
	protected IScope createScope(Resource resource, EClass type) {
		if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass()))
			return new XtextMetamodelReferenceScope(resource, type);
		
		if (resource.getContents().size() != 1)
			throw new IllegalArgumentException("resource is not as expected: contents.size == "
					+ resource.getContents().size() + " but expected: 1");
		final EObject firstContent = resource.getContents().get(0);
		if (!(firstContent instanceof Grammar))
			throw new IllegalArgumentException("resource does not contain a grammar, but: " + firstContent);
		return createScope((Grammar) firstContent, type);
	}

	protected IScope createScope(Grammar g, EClass type) {
		final Grammar superGrammar = GrammarUtil.getSuperGrammar(g);
		final IScope parent = superGrammar != null ? createScope(superGrammar, type): IScope.NULLSCOPE;
		return new SimpleCachingScope(parent, g.eResource(), type);
	}

}
