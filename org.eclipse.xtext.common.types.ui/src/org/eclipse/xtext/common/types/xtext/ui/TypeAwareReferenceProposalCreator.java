/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeAwareReferenceProposalCreator extends ReferenceProposalCreator {

	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getWrappedFactory(EObject model, EReference reference,
			final Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		if (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(getEReferenceType(model, reference))) {
			return new Function<IEObjectDescription, ICompletionProposal>() {
	
				@Override
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
			};
		}
		return super.getWrappedFactory(model, reference, proposalFactory);
	}
	
	protected Image computeImage(boolean isInnerType, int modifiers) {
		return JavaPlugin.getImageDescriptorRegistry().get(
				JavaElementImageProvider.getTypeImageDescriptor(
						isInnerType, 
						Flags.isAnnotation(modifiers) || Flags.isInterface(modifiers), 
						modifiers, 
						false /* don't use light icons */));
	}
	
	protected EClass getEReferenceType(EObject context, EReference reference) {
		return reference.getEReferenceType();
	}
}
