
/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.documentation.EObjectInComment;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 * @since 2.4
 */
public class MultiLineJavaDocTypeReferenceProvider implements IJavaDocTypeReferenceProvider {

	@Deprecated
	protected String lineDelimiter = System.getProperty("line.separator");
	
	@Inject
	protected IScopeProvider scopeProvider;

	@Inject
	protected IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public List<ReplaceRegion> computeTypeRefRegions(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		computeRegions(regions, leafNodes, LINK_TAG_WITH_SUFFIX, new String[]{"#", " ", "}"});
		computeRegions(regions, leafNodes, SEE_TAG_WITH_SUFFIX, new String[]{"#" , " ", "\r", "\n"});
		return regions;
	}

	@Override
	public List<ReplaceRegion> computeParameterTypeRefRegions(INode node) {
		List<ReplaceRegion> regions = Lists.newArrayList();
		Iterable<ILeafNode> leafNodes = node.getLeafNodes();
		computeRegions(regions, leafNodes, "@param ", new String[]{" ", "-", "\r", "\n"});
		return regions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObjectInComment computeEObjectReferencedInComment(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			INode rootNode = parseResult.getRootNode();
			INode node = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
			EObject semanticObject = NodeModelUtils.findActualSemanticObjectFor(node);
			if(semanticObject != null) {
				EReference reference = getEReference(semanticObject, node, offset);
				if(reference != null) {
					IScope scope = getScope(semanticObject, reference, node, offset);
					List<ReplaceRegion> eObjectReferences = computeTypeRefRegions(node);
					for(ReplaceRegion eObjectReference : eObjectReferences) {
						if(eObjectReference.getOffset() <= offset && offset <= eObjectReference.getEndOffset()) {
							String eObjectReferenceText = eObjectReference.getText();
							if(!Strings.isNullOrEmpty(eObjectReferenceText)) {
								ITextRegion region = new TextRegion(eObjectReference.getOffset(), eObjectReference.getLength());
								IEObjectDescription candidate = getElementFromScope(scope, node, region, eObjectReferenceText);
								if(candidate != null) {
									EObject eObject = candidate.getEObjectOrProxy();
									if(eObject != null) {
										return new EObjectInComment(eObject, region);
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Computes regions between a given string to search and different ends searched by their precedence
	 *
	 * @param regions - List to put new regions in
	 * @param leafNodes - nodes to search in
	 * @param toSearch - String to search
	 * @param end - end with highest precedence
	 * @param optionalEnd - end with lower precedence
	 * @param optionalEnd2 - end with lowest precedence
	 * @deprecated use {@link #computeRegions(List, Iterable, String, String...)}
	 */
	@Deprecated
	protected void computeRegions(List<ReplaceRegion> regions, Iterable<ILeafNode> leafNodes, String toSearch, String end, String optionalEnd, String optionalEnd2) {
		computeRegions(regions, leafNodes, toSearch, new String[]{end, optionalEnd, optionalEnd2});
	}
	
	/**
	 * Computes regions between a given string to search and different ends searched by their precedence
	 *
	 * @param regions - List to put new regions in
	 * @param leafNodes - nodes to search in
	 * @param toSearch - String to search
	 * @param ends - ends in decreasing precedence
	 * @since 2.6
	 */
	protected void computeRegions(List<ReplaceRegion> regions, Iterable<ILeafNode> leafNodes, String toSearch, String... ends) {
		for (ILeafNode leafNode : leafNodes) {
			String text = leafNode.getText();
			int offset = leafNode.getOffset();
			int position = text.indexOf(toSearch);
			int textLength = text.length();
			while (position != -1) {
				int beginIndex = position + toSearch.length();
				// Skip leading whitespaces
				if(Character.isWhitespace(text.charAt(beginIndex))){
					while(beginIndex < textLength && Character.isWhitespace(text.charAt(beginIndex))){
						beginIndex ++;
					}
				}
				int endIndex = -1;
				for (int i = ends.length -1; i >= 0; i--) {
					String end = ends[i];
					int endCandidate = text.indexOf(end, beginIndex);
					if (endCandidate != -1)  {
						if (endIndex == -1) {
							endIndex = endCandidate;
						} else {
							if (endIndex > endCandidate) {
								endIndex = endCandidate;
							}
						}
					}
				}
				if (endIndex == -1) { 
					break;
				} else {
					String simpleName = text.substring(beginIndex, endIndex).replaceAll(" ", "");
					if(simpleName.length() > 0 && simpleName.matches("[0-9a-zA-Z\\.\\$_]*")){
						ReplaceRegion region = new ReplaceRegion(offset + beginIndex, simpleName.length(), simpleName);
						regions.add(region);
					}
				} 
				position = text.indexOf(toSearch, endIndex);
			}
		}
	}

	/**
	 * Returns the {@link EReference} used to calculate the referenced elements in javadoc comments.
	 * This method is intented to be implemented by clients.
	 */
	protected EReference getEReference(EObject eObject, INode node, int offset) {
		return null;
	}

	protected IScope getScope(EObject semanticObject, EReference reference, INode node, int offset) {
		return scopeProvider.getScope(semanticObject, reference);
	}

	protected IEObjectDescription getElementFromScope(IScope scope, INode node, ITextRegion region, String text) {
		return scope.getSingleElement(qualifiedNameConverter.toQualifiedName(text));
	}
}
