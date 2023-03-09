/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.StaticFeatureDescriptionWithTypeLiteralReceiver;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseContentProposalPriorities extends ContentProposalPriorities {

	@Override
	public void adjustCrossReferencePriority(ICompletionProposal proposal, String prefix) {
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurableProposal = (ConfigurableCompletionProposal) proposal;
			Object desc = configurableProposal.getAdditionalData(XbaseProposalProvider.DESCRIPTION_KEY);
			if (desc instanceof SimpleIdentifiableElementDescription) {
				if (!"this".equals(configurableProposal.getReplacementString())
						&& !"super".equals(configurableProposal.getReplacementString())) {
					adjustPriority(proposal, prefix, 570);
					return;
				}
			} else if (desc instanceof StaticFeatureDescriptionWithTypeLiteralReceiver) {
				adjustPriority(proposal, prefix, 560);
				return;
			} else if (desc instanceof IIdentifiableElementDescription) {
				JvmIdentifiableElement identifiableElement = ((IIdentifiableElementDescription) desc).getElementOrProxy();
				if (identifiableElement instanceof JvmField) {
					adjustPriority(proposal, prefix, 550);
					return;
				} else if (identifiableElement instanceof JvmExecutable) {
					adjustPriority(proposal, prefix, 520);
					return;
				}
			}
		}
		super.adjustCrossReferencePriority(proposal, prefix);
	}
}
