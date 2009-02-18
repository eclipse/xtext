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
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.impl.ScopedElement;
import org.eclipse.xtext.crossref.impl.SimpleCachingScope;
import org.eclipse.xtext.crossref.impl.SimpleScope;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Function;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextScopeProvider extends DefaultScopeProvider {

	@Inject
	private IValueConverterService valueConverterService;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Type()) {
			if (context instanceof TypeRef) {
				final TypeRef typeRef = (TypeRef) context;
				final AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
				if (metaModel != null) {
					EPackage pack = metaModel.getEPackage();
					if (pack != null)
						return createClassifierScope(pack.getEClassifiers());
				} else {
					return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
				}
			} else if (context instanceof CrossReference || context instanceof ParserRule) {
				return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
			}
			return IScope.NULLSCOPE;
		}
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
			if (decl.getEPackage() != null)
				CollectionUtils.addAll(allClassifiers, decl.getEPackage().getEClassifiers());
		}
		return createClassifierScope(allClassifiers);
	}

	@Override
	protected IScope createScope(Resource resource, EClass type) {
		if (resource.getContents().size() < 1)
			throw new IllegalArgumentException("resource is not as expected: contents.size == "
					+ resource.getContents().size() + " but expected: >= 1");
		final EObject firstContent = resource.getContents().get(0);
		if (!(firstContent instanceof Grammar))
			throw new IllegalArgumentException("resource does not contain a grammar, but: " + firstContent);
		return createScope((Grammar) firstContent, type);
	}

	protected IScope createScope(final Grammar grammar, EClass type) {
		if (EcorePackage.Literals.EPACKAGE == type) {
			return createEPackageScope(grammar);
		} else if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass())) {
			return new SimpleCachingScope(IScope.NULLSCOPE, grammar.eResource(), type) {
				@Override
				protected Iterator<AbstractMetamodelDeclaration> getRelevantContent(Resource resource) {
					return grammar.getMetamodelDeclarations().iterator();
				}

				@Override
				protected String getNameFeature(EClass type) {
					if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass())) {
						return XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_Alias().getName();
					}
					return super.getNameFeature(type);
				}
			};
		}
		final Grammar superGrammar = grammar.getSuperGrammar();
		final IScope parent = superGrammar != null ? createScope(superGrammar, type): IScope.NULLSCOPE;
		return new SimpleCachingScope(parent, grammar.eResource(), type) {
			@Override
			protected Iterator<EObject> getRelevantContent(Resource resource) {
				return CollectionUtils.join(Collections.singleton(grammar).iterator(), EcoreUtil.<EObject>getAllContents(grammar, true)).iterator();
			}
		};
	}

	private IScope createEPackageScope(final Grammar grammar) {
		final Grammar superGrammar = grammar.getSuperGrammar();
		final IScope parent = superGrammar != null ? createEPackageScope(superGrammar):
			new StringScope(EPackage.Registry.INSTANCE.keySet(), valueConverterService);
		return new SimpleCachingScope(parent, grammar.eResource(), EcorePackage.Literals.EPACKAGE) {
			@Override
			protected Iterator<EPackage> getRelevantContent(Resource resource) {
				return EcoreUtil2.collect(grammar.getMetamodelDeclarations(), XtextPackage.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE, EPackage.class).iterator();
			}

			@Override
			protected String convertValue(String value, EObject object) {
				return valueConverterService.toString(value, "STRING");
			}

			@Override
			protected String getNameFeature(EClass type) {
				return EcorePackage.Literals.EPACKAGE__NS_URI.getName();
			}

		};
	}

}
