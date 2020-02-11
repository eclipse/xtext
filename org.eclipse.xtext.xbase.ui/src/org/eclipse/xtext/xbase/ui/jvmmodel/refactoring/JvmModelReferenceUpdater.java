/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringCrossReferenceSerializer.RefTextEvaluator;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelReferenceUpdater extends DefaultReferenceUpdater {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	
	@Inject
	@LinkingScopeProviderBinding
	private IScopeProvider linkingScopeProvider; 
	
	@Override
	protected void createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		if (!isInferredJvmModelElement(referringElement))
			super.createReferenceUpdate(referringElement, referringResourceURI, reference, indexInList,
					newTargetElement, updateAcceptor);
	}

	protected boolean isInferredJvmModelElement(EObject element) {
		EObject rootContainer = EcoreUtil.getRootContainer(element);
		return !isEmpty(jvmModelAssociations.getSourceElements(rootContainer));
	}

	/**
	 * @since 2.4
	 */
	protected static enum ReferenceSyntax {
		EXPLICIT_GET, EXPLICIT_SET, EXPLICIT_IS, SET_BY_ASSIGNMENT, OTHER;
	}

	/**
	 * @since 2.4
	 */
	protected ReferenceSyntax getReferenceSyntax(EObject referringElement, EReference reference, int indexInList) {
		if (reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
			if (referringElement instanceof XAssignment) 
				return ReferenceSyntax.SET_BY_ASSIGNMENT;
			List<INode> nodes = NodeModelUtils.findNodesForFeature(referringElement, reference);
			int index = Math.max(indexInList, 0);
			if (nodes.size() < index)
				return null;
			INode oldNode = nodes.get(index);
			String referenceText = oldNode.getText().trim();
			return getReferenceSyntax(referenceText);
		}
		return null;
	}

	protected ReferenceSyntax getReferenceSyntax(String referenceText) {
		if (referenceText.startsWith("get") && referenceText.length() > 3) 
			return ReferenceSyntax.EXPLICIT_GET;
		else if (referenceText.startsWith("set") && referenceText.length() > 3) 
			return ReferenceSyntax.EXPLICIT_SET;
		else if (referenceText.startsWith("is") && referenceText.length() > 2) 
			return ReferenceSyntax.EXPLICIT_IS;
		else
			return ReferenceSyntax.OTHER;
	}

	/**
	 * Preserves the syntax of method calls if the target is refactored.
	 * 
	 * @since 2.4
	 */
	@Override
	protected RefTextEvaluator getRefTextEvaluator(final EObject referringElement, URI referringResourceURI,
			final EReference reference, int indexInList, EObject newTargetElement) {
		final ReferenceSyntax oldReferenceSyntax = getReferenceSyntax(referringElement, reference, indexInList);
		if (oldReferenceSyntax == null)
			return super.getRefTextEvaluator(referringElement, referringResourceURI, reference, indexInList,
					newTargetElement);
		return new RefTextEvaluator() {

			@Override
			public boolean isValid(IEObjectDescription newTarget) {
				IScope scope = linkingScopeProvider.getScope(referringElement, reference);
				IEObjectDescription element = scope.getSingleElement(newTarget.getName());
				// TODO here we need to simulate linking with the new name instead of the old name
				if(element instanceof IIdentifiableElementDescription) {
					IIdentifiableElementDescription casted = (IIdentifiableElementDescription) element;
					if(!casted.isVisible() || !casted.isValidStaticState())
						return false;
				}
				return element != null 
							&& element.getEObjectURI() != null 
							&& element.getEObjectURI().equals(newTarget.getEObjectURI());
			}

			@Override
			public boolean isBetterThan(String newText, String currentText) {
				ReferenceSyntax newSyntax = getReferenceSyntax(newText);
				ReferenceSyntax currentSyntax = getReferenceSyntax(currentText);
				// prefer the one with the same syntax as before
				if (newSyntax == oldReferenceSyntax && currentSyntax != oldReferenceSyntax)
					return true;
				else if (newSyntax != oldReferenceSyntax && currentSyntax == oldReferenceSyntax)
					return false;
				else
					// in doubt shorter is better
					return newText.length() < currentText.length();
			}
		};
	}
	
	protected IScopeProvider getLinkingScopeProvider() {
		return linkingScopeProvider;
	}
}
