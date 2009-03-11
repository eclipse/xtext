/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import static org.eclipse.xtext.util.CollectionUtils.addAll;
import static org.eclipse.xtext.util.CollectionUtils.filter;
import static org.eclipse.xtext.util.CollectionUtils.map;
import static org.eclipse.xtext.util.CollectionUtils.switchContent;

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
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Strings;

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
		addAll(exactMatches, filter(importedMetamodels,
				new Filter<AbstractMetamodelDeclaration>() {
					public boolean accept(AbstractMetamodelDeclaration param) {
						return alias.equals(param.getAlias());
					}
				}));
	}

	private static void filterMetamodelsInScope(final String alias, IScope scope,
			final List<AbstractMetamodelDeclaration> generatedMetamodels,
			final List<AbstractMetamodelDeclaration> importedMetamodels) {
		switchContent(filter(map(scope.getAllContents(), new Function<IScopedElement, AbstractMetamodelDeclaration>() {
			public AbstractMetamodelDeclaration exec(IScopedElement param) {
				return (AbstractMetamodelDeclaration) param.element();
			}
		}), new Filter<AbstractMetamodelDeclaration>() {
			public boolean accept(AbstractMetamodelDeclaration param) {
				return metamodelAliasMatches(param, alias);
			}
		}), generatedMetamodels, importedMetamodels, new Filter<AbstractMetamodelDeclaration>() {
			public boolean accept(AbstractMetamodelDeclaration param) {
				return param instanceof GeneratedMetamodel;
			}
		});
	}

	private static boolean metamodelAliasMatches(AbstractMetamodelDeclaration metamodelDeclaration, String text) {
		return text.equals(Strings.emptyIfNull(metamodelDeclaration.getAlias()));
	}

}
