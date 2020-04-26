/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.StaticFeatureDescriptionWithTypeLiteralReceiver;

public class XbaseIdeContentProposalPriorities extends IdeContentProposalPriorities {
	@Override
	public int getCrossRefPriority(IEObjectDescription objectDesc, ContentAssistEntry entry) {
		if (entry != null) {
			if (objectDesc instanceof SimpleIdentifiableElementDescription) {
				if (!"this".equals(entry.getProposal()) && !"super".equals(entry.getProposal())) {
					return adjustPriority(entry, getCrossRefPriority() + 70);
				}
			} else if (objectDesc instanceof StaticFeatureDescriptionWithTypeLiteralReceiver) {
				return adjustPriority(entry, getCrossRefPriority() + 60);
			} else if (objectDesc instanceof IIdentifiableElementDescription) {
				JvmIdentifiableElement element = ((IIdentifiableElementDescription) objectDesc).getElementOrProxy();
				if (element instanceof JvmField) {
					return adjustPriority(entry, getCrossRefPriority() + 50);
				} else if (element instanceof JvmExecutable) {
					return adjustPriority(entry, getCrossRefPriority() + 20);
				}
			}
		}
		return super.getCrossRefPriority(objectDesc, entry);
	}

	public int getTypeRefPriority(ITypeDescriptor typeDesc, ContentAssistEntry entry) {
		return adjustPriority(entry, getCrossRefPriority());
	}
}
