/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class TypeAwareReferenceProposalCreator extends ReferenceProposalCreator {

	@Override
	public void lookupCrossReference(EObject model, EReference reference, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter, final Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		if (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(getEReferenceType(model, reference))) {
			super.lookupCrossReference(model, reference, acceptor, filter, new Function<IEObjectDescription, ICompletionProposal>() {

				public ICompletionProposal apply(IEObjectDescription from) {
					ICompletionProposal result = proposalFactory.apply(from);
					if (result instanceof ConfigurableCompletionProposal) {
						String flags = from.getUserData("flags");
						if (flags != null) {
							boolean inner = "true".equals(from.getUserData("inner"));
							int modifiers = Integer.parseInt(flags);
							((ConfigurableCompletionProposal) result).setImage(computeImage(inner, modifiers));
						}
					}
					return result;
				}
				
			});
		} else {
			super.lookupCrossReference(model, reference, acceptor, filter, proposalFactory);
		}
	}
	
	protected Image computeImage(boolean isInnerType, int modifiers) {
		return JavaPlugin.getImageDescriptorRegistry().get(
				JavaElementImageProvider.getTypeImageDescriptor(isInnerType, false, modifiers, false));
	}
	
	protected EClass getEReferenceType(EObject context, EReference reference) {
		return reference.getEReferenceType();
	}
}
