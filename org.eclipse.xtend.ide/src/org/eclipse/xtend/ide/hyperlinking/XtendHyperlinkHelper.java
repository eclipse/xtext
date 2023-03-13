/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.hyperlinking;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jface.text.Region;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ISuspiciouslyOverloadedCandidate;
import org.eclipse.xtext.xbase.ui.navigation.JvmImplementationOpener;
import org.eclipse.xtext.xbase.ui.navigation.XbaseHyperLinkHelper;
import org.eclipse.xtext.xbase.ui.navigation.XbaseImplementatorsHyperlink;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Customized hyperlinker for Xtend source files.
 * 
 * First and foremost, it redirects hyperlinks to the source elements if the referenced target is an inferred element.
 * That means, all contributing dispatch methods are available on hyperlink requests.
 * 
 * This implementation also provides hyperlinks to all ambiguous candidates if a feature or constructor call was
 * resolved to multiple equally valid features.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Navigation to all ambiguous candidates.
 */
public class XtendHyperlinkHelper extends XbaseHyperLinkHelper {

	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private IJavaElementFinder javaElementFinder;
	
	@Inject
	private JvmImplementationOpener implOpener;

	/**
	 * This redirects the hyperlinks to all source elements of an inferred element.
	 */
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		Set<EObject> sourceElements = associations.getSourceElements(to);
		if (sourceElements.isEmpty()) {
			super.createHyperlinksTo(from, region, to, acceptor);
		} else {
			for (EObject sourceElement : sourceElements) {
				super.createHyperlinksTo(from, region, sourceElement, acceptor);
			}
		}
	}
	
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		super.createHyperlinksByOffset(resource, offset, acceptor);
		if (canShowMany(acceptor)) {
			final EObject element = getEObjectAtOffsetHelper().resolveElementAt(resource, offset);
			if (element instanceof XtendField) {
				XtendField member = (XtendField) element;
				ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
				if (isNameNode(member, XtendPackage.Literals.XTEND_FIELD__NAME, node) && member.getType()==null) {
					EObject jvmElement = associations.getPrimaryJvmElement(member);
					if (jvmElement instanceof JvmIdentifiableElement) {
						addOpenInferredTypeHyperlink(resource, (JvmIdentifiableElement) jvmElement, node, acceptor);
					}
				}
			}
			if (element instanceof XtendFunction) {
				XtendFunction member = (XtendFunction) element;
				ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
				if (isNameNode(member, XtendPackage.Literals.XTEND_FUNCTION__NAME, node)) {
					EObject jvmElement = associations.getPrimaryJvmElement(member);
					if (jvmElement instanceof JvmIdentifiableElement) {
						JvmIdentifiableElement identifiableElement = (JvmIdentifiableElement) jvmElement;
						if (member.getReturnType()==null) {
							addOpenInferredTypeHyperlink(resource, identifiableElement, node, acceptor);
						}
						IJavaElement javaElement = javaElementFinder.findExactElementFor(identifiableElement);
						if (sourceViewer != null && javaElement != null 
								&& (javaElement.getElementType() == IJavaElement.METHOD 
								&& canBeOverridden((IMethod) javaElement))) {
							Region region = new Region(node.getOffset(), node.getLength());
							acceptor.accept(new XbaseImplementatorsHyperlink(javaElement, region, sourceViewer, implOpener));
						}
					}
				}
			}
		}
	}

	@Override
	protected void createHyperlinksForCrossRef(XtextResource resource, INode crossRefNode,
			IHyperlinkAcceptor acceptor) {
		EObject crossLinkedEObject = getEObjectAtOffsetHelper().getCrossReferencedElement(crossRefNode);
		if (crossLinkedEObject != null && !crossLinkedEObject.eIsProxy()) {
			EObject containedElementAt = getEObjectAtOffsetHelper().resolveContainedElementAt(resource,
					crossRefNode.getOffset());
			if (containedElementAt instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall casted = (XAbstractFeatureCall) containedElementAt;
				if (casted.getFeature() == crossLinkedEObject) {
					IFeatureLinkingCandidate candidate = getBatchTypeResolver().resolveTypes(casted).getLinkingCandidate(
							casted);
					if (candidate instanceof IAmbiguousLinkingCandidate) {
						createMultipleLinks(resource, crossRefNode,
								((IAmbiguousLinkingCandidate) candidate).getAlternatives(), acceptor);
					} else if (candidate instanceof ISuspiciouslyOverloadedCandidate) {
						ISuspiciouslyOverloadedCandidate castedCandidate = (ISuspiciouslyOverloadedCandidate) candidate;
						createMultipleLinks(
								resource,
								crossRefNode,
								Lists.newArrayList(castedCandidate.getChosenCandidate(),
										castedCandidate.getRejectedCandidate()), acceptor);
					} 
				}
			} else if (containedElementAt instanceof XConstructorCall) {
				XConstructorCall casted = (XConstructorCall) containedElementAt;
				if (casted.getConstructor() == crossLinkedEObject) {
					IConstructorLinkingCandidate candidate = getBatchTypeResolver().resolveTypes(casted)
							.getLinkingCandidate(casted);
					if (candidate instanceof IAmbiguousLinkingCandidate) {
						createMultipleLinks(resource, crossRefNode,
								((IAmbiguousLinkingCandidate) candidate).getAlternatives(), acceptor);
					}
				}
			}
		}
		super.createHyperlinksForCrossRef(resource, crossRefNode, acceptor);
	}

	private void createMultipleLinks(XtextResource resource, INode crossRefNode,
			List<? extends ILinkingCandidate> alternatives, IHyperlinkAcceptor acceptor) {
		for (ILinkingCandidate alternative : alternatives) {
			createHyperlinksTo(resource, crossRefNode, alternative.getFeature(), acceptor);
		}
	}
}
