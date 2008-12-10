/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Filter;
import org.eclipse.xtext.util.FilteringIterator;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextMetamodelReferenceHelper {

	public static List<EObject> findBestMetamodelForType(TypeRef context, EReference ref, final String alias,
			String typeName, IScope scope) {
		final List<AbstractMetamodelDeclaration> generatedMetamodels = new ArrayList<AbstractMetamodelDeclaration>();
		final List<AbstractMetamodelDeclaration> importedMetamodels = new ArrayList<AbstractMetamodelDeclaration>();
		filterMetamodelsInScope(alias, scope, generatedMetamodels, importedMetamodels);
		final List<AbstractMetamodelDeclaration> exactMatches = new ArrayList<AbstractMetamodelDeclaration>();
		filterExactMatches(alias, importedMetamodels, exactMatches);
		List<EObject> result = findMetamodelWithType(typeName, exactMatches);
		if (result != null)
			return result;
		result = findMetamodelWithType(typeName, importedMetamodels);
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

	private static List<EObject> findMetamodelWithType(String typeName, List<AbstractMetamodelDeclaration> candidates) {
		AbstractMetamodelDeclaration result = null;
		for (AbstractMetamodelDeclaration exactMatch : candidates) {
			final EClassifier classifier = findEClassifier(typeName, exactMatch);
			if (classifier != null) {
				if (result == null)
					result = exactMatch;
				else
					return Collections.emptyList();
			}
		}
		if (result != null)
			return Collections.singletonList((EObject) result);
		return null;
	}

	public static EClassifier findEClassifier(String typeName, AbstractMetamodelDeclaration metamodel) {
		if (metamodel == null || metamodel instanceof GeneratedMetamodel)
			return null;
		try {
			final EPackage pack = GrammarUtil.loadEPackage((ReferencedMetamodel) metamodel);
			if (pack != null) {
				return pack.getEClassifier(typeName);
			}
		}
		catch (RuntimeException ex) {
			if (ex.getCause() instanceof IOException) {
				// invalid url
			} else {
				throw ex;
			}
		}
		return null;
	}

	private static void filterExactMatches(final String alias,
			final List<AbstractMetamodelDeclaration> importedMetamodels,
			final List<AbstractMetamodelDeclaration> exactMatches) {
		CollectionUtils.addAll(exactMatches, new FilteringIterator<AbstractMetamodelDeclaration>(importedMetamodels,
				new Filter<AbstractMetamodelDeclaration>() {
					public boolean matches(AbstractMetamodelDeclaration param) {
						return alias.equals(param.getAlias());
					}
				}));
	}

	private static void filterMetamodelsInScope(final String alias, IScope scope,
			final List<AbstractMetamodelDeclaration> generatedMetamodels,
			final List<AbstractMetamodelDeclaration> importedMetamodels) {
		CollectionUtils.switchContent(new FilteringIterator<AbstractMetamodelDeclaration>(CollectionUtils.map(scope
				.getAllContents(), new Function<IScopedElement, AbstractMetamodelDeclaration>() {
			public AbstractMetamodelDeclaration exec(IScopedElement param) {
				return (AbstractMetamodelDeclaration) param.element();
			}
		}), new Filter<AbstractMetamodelDeclaration>() {
			public boolean matches(AbstractMetamodelDeclaration param) {
				return metaModelAliasMatches(param, alias);
			}
		}), generatedMetamodels, importedMetamodels, new Filter<AbstractMetamodelDeclaration>() {
			public boolean matches(AbstractMetamodelDeclaration param) {
				return param instanceof GeneratedMetamodel;
			}
		});
	}

	private static boolean metaModelAliasMatches(AbstractMetamodelDeclaration metamodelDeclaration, String text) {
		return Strings.isEmpty(text) || text.equals(metamodelDeclaration.getAlias());
	}
	
	public static String getTypeRefName(TypeRef typeRef) {
		if (typeRef.getType() != null)
			return typeRef.getType().getName();
		final NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(typeRef);
		if (nodeAdapter != null) {
			final CompositeNode node = nodeAdapter.getParserNode();
			final List<LeafNode> leafNodes = node.getLeafNodes();
			for (int i = leafNodes.size() - 1; i >= 0; i++) {
				final LeafNode leaf = leafNodes.get(i);
				if (!leaf.isHidden())
					return leaf.getText();
			}
		}
		return null;
	}

}
