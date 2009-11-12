/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.linker;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.example.ecoredsl.EcoreDsl;
import org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.impl.ScopedElement;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameScopeProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslScopeProvider extends QualifiedNameScopeProvider {

	@Inject
	private IValueConverterService valueConverterService;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference.getEType()
				.equals(EcorePackage.eINSTANCE.getEClassifier())) {
			EcoreDsl ecoreDsl = (EcoreDsl) context.eResource().getResourceSet()
					.getEObject(
							context.eResource().getURI().appendFragment("/"),
							true);
			final Collection<EClassifier> allClassifiers = new ArrayList<EClassifier>();
			for (ReferencedMetamodel referencedMetamodel : ecoreDsl
					.getMetamodelDeclarations()) {
				if (referencedMetamodel.getEPackage() != null) {
					allClassifiers.addAll(referencedMetamodel.getEPackage()
							.getEClassifiers());
				}
			}
			allClassifiers.addAll(ecoreDsl.getPackage().getEClassifiers());
			return createClassifierScope(allClassifiers);
		}
		if (EcorePackage.Literals.EPACKAGE == reference.getEReferenceType()) {
			Resource resource = context.eResource();
			EcoreDsl ecoreDsl = (EcoreDsl) resource.getResourceSet()
					.getEObject(resource.getURI().appendFragment("/"), true);
			return createEPackageScope(ecoreDsl);
		}
		return super.getScope(context, reference);
	}

	private IScope createEPackageScope(final EcoreDsl ecoreDsl) {
		IScope current = new SimpleScope(IScope.NULLSCOPE, Iterables.transform(
				Iterables.filter(EPackage.Registry.INSTANCE.values(), EPackage.class),
				new Function<Object, IScopedElement>() {
					public IScopedElement apply(Object param) {
						return ScopedElement.create(valueConverterService.toString(((EPackage) param)
								.getNsURI(), "STRING"), (EObject) param);
					}
				}));
		return current;
	}

	private SimpleScope createClassifierScope(Iterable<EClassifier> classifiers) {
		return new SimpleScope(IScope.NULLSCOPE, Iterables.transform(
				classifiers, new Function<EClassifier, IScopedElement>() {
					public IScopedElement apply(EClassifier param) {
						return ScopedElement.create(param.getName(), param);
					}
				}));
	}

}