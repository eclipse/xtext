/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hyperlinking;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.ui.navigation.TypeLiteralAwareHyperlinkHelper;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Redirects hyperlinks to the source elements if the referenced target is
 * an inferred element.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendHyperlinkHelper extends TypeLiteralAwareHyperlinkHelper {

	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		Set<EObject> sourceElements = associations.getSourceElements(to);
		if(sourceElements.isEmpty()) { 
			super.createHyperlinksTo(from, region, to, acceptor);
		} else { 
			for(EObject sourceElement: sourceElements) {
				super.createHyperlinksTo(from, region, sourceElement, acceptor);
			}
		}
	}
	
	@Override
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		if (!createMultipleHyperlinks) {
			return super.createHyperlinksByOffset(resource, offset, createMultipleHyperlinks);
		}
		List<IHyperlink> links = Lists.newArrayList();
		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
		
		createMultipleHyperlinksByOffset(resource, offset, acceptor);
		if (!links.isEmpty())
			return Iterables.toArray(links, IHyperlink.class);
		return null;
	}
	
	protected void createMultipleHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		INode crossRefNode = getEObjectAtOffsetHelper().getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (crossRefNode == null)
			return;
		EObject crossLinkedEObject = getEObjectAtOffsetHelper().getCrossReferencedElement(crossRefNode);
		if (crossLinkedEObject != null && !crossLinkedEObject.eIsProxy()) {
			EObject containedElementAt = getEObjectAtOffsetHelper().resolveContainedElementAt(resource, offset);
			if (containedElementAt instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall casted = (XAbstractFeatureCall) containedElementAt;
				if (casted.getFeature() == crossLinkedEObject) {
					IFeatureLinkingCandidate candidate = typeResolver.resolveTypes(casted).getLinkingCandidate(casted);
					if (candidate instanceof IAmbiguousLinkingCandidate) {
						createAmbiguousLinks(resource, crossRefNode, ((IAmbiguousLinkingCandidate) candidate).getAlternatives(), acceptor);
					} else {
						createHyperlinksTo(resource, crossRefNode, crossLinkedEObject, acceptor);
					}
				}
			} else if (containedElementAt instanceof XConstructorCall) {
				XConstructorCall casted = (XConstructorCall) containedElementAt;
				if (casted.getConstructor() == crossLinkedEObject) {
					IConstructorLinkingCandidate candidate = typeResolver.resolveTypes(casted).getLinkingCandidate(casted);
					if (candidate instanceof IAmbiguousLinkingCandidate) {
						createAmbiguousLinks(resource, crossRefNode, ((IAmbiguousLinkingCandidate) candidate).getAlternatives(), acceptor);
					} else {
						createHyperlinksTo(resource, crossRefNode, crossLinkedEObject, acceptor);
					}
				}
			}
			
		}
	}

	private void createAmbiguousLinks(XtextResource resource, INode crossRefNode,
			List<? extends ILinkingCandidate> alternatives, IHyperlinkAcceptor acceptor) {
		for(ILinkingCandidate alternative: alternatives) {
			createHyperlinksTo(resource, crossRefNode, alternative.getFeature(), acceptor);
		}
	}
}
