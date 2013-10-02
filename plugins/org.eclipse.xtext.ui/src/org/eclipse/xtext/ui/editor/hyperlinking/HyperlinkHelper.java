/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HyperlinkHelper implements IHyperlinkHelper {

	protected static class HyperlinkAcceptor implements IHyperlinkAcceptor {

		private final List<IHyperlink> links;

		public HyperlinkAcceptor(List<IHyperlink> links) {
			this.links = links;
		}
		
		public void accept(IHyperlink hyperlink) {
			if (hyperlink != null)
				links.add(hyperlink);
		}
		
	}
	
	@Inject
	@HyperlinkLabelProvider
	private ILabelProvider labelProvider;

	@Inject
	private Provider<XtextHyperlink> hyperlinkProvider;
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	protected Provider<XtextHyperlink> getHyperlinkProvider() {
		return hyperlinkProvider;
	}
	
	protected ILabelProvider getLabelProvider() {
		return labelProvider;
	}
	
	/**
	 * @since 2.5
	 */
	protected EObjectAtOffsetHelper getEObjectAtOffsetHelper() {
		return eObjectAtOffsetHelper;
	}
	
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		List<IHyperlink> links = Lists.newArrayList();
		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
		
		createHyperlinksByOffset(resource, offset, acceptor);
		if (!links.isEmpty())
			return Iterables.toArray(links, IHyperlink.class);
		return null;
	}

	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		INode crossRefNode = eObjectAtOffsetHelper.getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (crossRefNode == null)
			return;
		EObject crossLinkedEObject = eObjectAtOffsetHelper.getCrossReferencedElement(crossRefNode);
		if (crossLinkedEObject != null && !crossLinkedEObject.eIsProxy()) {
			createHyperlinksTo(resource, crossRefNode, crossLinkedEObject, acceptor);
		}
	}

	/**
	 * Produces hyperlinks for the given {@code node} which is associated with a cross reference
	 * that points to the referenced {@code target}.
	 * 
	 * @see #createHyperlinksTo(XtextResource, Region, EObject, IHyperlinkAcceptor)
	 * 
	 * @since 2.4
	 */
	protected void createHyperlinksTo(XtextResource resource, INode node, EObject target, IHyperlinkAcceptor acceptor) {
		ITextRegion textRegion = node.getTextRegion();
		Region region = new Region(textRegion.getOffset(), textRegion.getLength());
		createHyperlinksTo(resource, region, target, acceptor);
	}
	
	/**
	 * @deprecated use {@link EObjectAtOffsetHelper#getCrossReferenceNode(XtextResource, org.eclipse.xtext.util.ITextRegion)}
	 */
	@Deprecated
	protected INode getParentNodeWithCrossReference(INode startNode) {
		if(startNode == null)
			return null;
		if(startNode.getGrammarElement() instanceof CrossReference)
			return startNode;
		return getParentNodeWithCrossReference(startNode.getParent());
	}
	
	/**
	 * Produces hyperlinks for the given {@code region} that point to the referenced {@code target}.
	 */
	public void createHyperlinksTo(XtextResource from, Region region, EObject target, IHyperlinkAcceptor acceptor) {
		final URIConverter uriConverter = from.getResourceSet().getURIConverter();
		final String hyperlinkText = labelProvider.getText(target);
		final URI uri = EcoreUtil.getURI(target);
		final URI normalized = uri.isPlatformResource() ? uri : uriConverter.normalize(uri);

		XtextHyperlink result = hyperlinkProvider.get();
		result.setHyperlinkRegion(region);
		result.setURI(normalized);
		result.setHyperlinkText(hyperlinkText);
		acceptor.accept(result);
	}

}
