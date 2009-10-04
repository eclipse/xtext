/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.hyperlinking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Wrapper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HyperlinkHelper implements IHyperlinkHelper {

	protected static class HyperlinkAcceptor implements IHyperlinkAcceptor {

		private final List<IHyperlink> links;

		HyperlinkAcceptor(List<IHyperlink> links) {
			this.links = links;
		}
		
		public void accept(IHyperlink hyperlink) {
			if (hyperlink != null)
				links.add(hyperlink);
		}
		
	}
	
	@Inject
	private ILinkingService linkingService;
	
	@Inject
	private ILabelProvider labelProvider;
	
	@Inject
	private Provider<XtextHyperlink> hyperlinkProvider;

	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		IParseResult parseResult = resource.getParseResult();
		Assert.isNotNull(parseResult);
		AbstractNode abstractNode = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(), offset);
		final Wrapper<Region> location = Wrapper.wrap(new Region(abstractNode.getOffset(), abstractNode.getLength()));
		List<EObject> crossLinkedEObjects = findCrossLinkedEObject(abstractNode, location);
		if (crossLinkedEObjects.isEmpty())
			return null;
		List<IHyperlink> links = new ArrayList<IHyperlink>();
		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
		for (EObject crossReffed : crossLinkedEObjects) {
			if (!links.isEmpty() && !createMultipleHyperlinks)
				break;
			createHyperlinksTo(resource, location.get(), crossReffed, acceptor);
		}
		return links.toArray(new IHyperlink[links.size()]);
	}
	
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		final URIConverter uriConverter = from.getResourceSet().getURIConverter();
		final String hyperlinkText = labelProvider.getText(to);
		final URI uri = EcoreUtil.getURI(to);
		final URI normalized = uriConverter.normalize(uri);
		
		XtextHyperlink result = hyperlinkProvider.get();
		result.setHyperlinkRegion(region);
		result.setURI(normalized);
		result.setHyperlinkText(hyperlinkText);
		acceptor.accept(result);
	}

	protected List<EObject> findCrossLinkedEObject(AbstractNode node, Wrapper<Region> location) {
		AbstractNode nodeToCheck = node;
		while(nodeToCheck != null && !(nodeToCheck.getGrammarElement() instanceof Assignment)) {
			if (nodeToCheck.getGrammarElement() instanceof CrossReference) {
				EObject semanticModel = NodeUtil.getNearestSemanticObject(nodeToCheck);
				EReference eReference = GrammarUtil.getReference((CrossReference) nodeToCheck.getGrammarElement(),
						semanticModel.eClass());
				try {
					if (location != null)
						location.set(new Region(nodeToCheck.getOffset(), nodeToCheck.getLength()));
					return linkingService.getLinkedObjects(semanticModel, eReference, nodeToCheck);
				} catch (IllegalNodeException ex) {
					return Collections.emptyList();
				}
			}
			nodeToCheck = nodeToCheck.getParent();
		}
		return Collections.emptyList();
	}
}
