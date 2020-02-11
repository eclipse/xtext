/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class XtextMetamodelReferenceHelper {

	static List<EObject> findBestMetamodelForType(TypeRef context, final String alias, String typeName, IScope scope) {
		final List<AbstractMetamodelDeclaration> generatedMetamodels = new ArrayList<AbstractMetamodelDeclaration>();
		final List<AbstractMetamodelDeclaration> importedMetamodels = new ArrayList<AbstractMetamodelDeclaration>();
		filterMetamodelsInScope(alias, scope, generatedMetamodels, importedMetamodels);
		final List<AbstractMetamodelDeclaration> exactMatches = new ArrayList<AbstractMetamodelDeclaration>();
		filterExactMatches(alias, importedMetamodels, exactMatches);
		List<EObject> result = findReferencedMetamodelWithType(typeName, exactMatches);
		if (result != null)
			return result;
		result = findReferencedMetamodelWithType(typeName, importedMetamodels);
		if (result != null)
			return result;
		result = findSingleElementInCollections(alias, generatedMetamodels);
		if (result != null)
			return result;
		result = findSingleElementInCollections(alias, importedMetamodels);
		if (result != null)
			return result;
		return Collections.emptyList();
	}

	private static List<EObject> findSingleElementInCollections(final String alias,
			final List<AbstractMetamodelDeclaration> candidates) {
		final List<AbstractMetamodelDeclaration> exactMatches = new ArrayList<AbstractMetamodelDeclaration>();
		filterExactMatches(alias, candidates, exactMatches);
		if (exactMatches.size() == 1)
			return Collections.singletonList((EObject) exactMatches.get(0));
		if (candidates.size() == 1)
			return Collections.singletonList((EObject) candidates.get(0));
		return null;
	}

	private static List<EObject> findReferencedMetamodelWithType(String typeName, List<AbstractMetamodelDeclaration> candidates) {
		AbstractMetamodelDeclaration result = null;
		for (AbstractMetamodelDeclaration metamodel : candidates) {
			if (metamodel instanceof ReferencedMetamodel) {
				EPackage pack = metamodel.getEPackage();
				if (pack != null) {
					final EClassifier classifier = pack.getEClassifier(typeName);
					if (classifier != null) {
						if (result == null)
							result = metamodel;
						else
							return Collections.emptyList();
					}
				}
			}
		}
		if (result != null)
			return Collections.<EObject>singletonList(result);
		return null;
	}

	private static void filterExactMatches(final String alias,
			final List<AbstractMetamodelDeclaration> importedMetamodels,
			final List<AbstractMetamodelDeclaration> exactMatches) {
		Iterables.addAll(exactMatches, Iterables.filter(importedMetamodels,
				new Predicate<AbstractMetamodelDeclaration>() {
					@Override
					public boolean apply(AbstractMetamodelDeclaration param) {
						return alias.equals(param.getAlias());
					}
				}));
	}

	private static void filterMetamodelsInScope(final String alias, IScope scope,
			final List<AbstractMetamodelDeclaration> generatedMetamodels,
			final List<AbstractMetamodelDeclaration> importedMetamodels) {
		Iterable<AbstractMetamodelDeclaration> all = Iterables.filter(Iterables.transform(scope.getAllElements(), new Function<IEObjectDescription, AbstractMetamodelDeclaration>() {
			@Override
			public AbstractMetamodelDeclaration apply(IEObjectDescription param) {
				return (AbstractMetamodelDeclaration) param.getEObjectOrProxy();
			}
		}), new Predicate<AbstractMetamodelDeclaration>() {
			@Override
			public boolean apply(AbstractMetamodelDeclaration param) {
				return metamodelAliasMatches(param, alias);
			}
		});
		for(AbstractMetamodelDeclaration decl: all) {
			if (decl instanceof GeneratedMetamodel)
				generatedMetamodels.add(decl);
			else
				importedMetamodels.add(decl);
		}
	}

	private static boolean metamodelAliasMatches(AbstractMetamodelDeclaration metamodelDeclaration, String text) {
		return text.equals(Strings.emptyIfNull(metamodelDeclaration.getAlias()));
	}

}
