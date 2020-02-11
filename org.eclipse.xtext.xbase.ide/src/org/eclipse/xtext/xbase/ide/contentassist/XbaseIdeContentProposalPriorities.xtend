/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist

import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription
import org.eclipse.xtext.xbase.scoping.batch.StaticFeatureDescriptionWithTypeLiteralReceiver
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor

class XbaseIdeContentProposalPriorities extends IdeContentProposalPriorities {
	
	override getCrossRefPriority(IEObjectDescription objectDesc, ContentAssistEntry entry) {
		if (entry !== null) {
			switch objectDesc {
				SimpleIdentifiableElementDescription case entry.proposal != 'this' && entry.proposal != 'super':
					return adjustPriority(entry, crossRefPriority + 70)
				
				StaticFeatureDescriptionWithTypeLiteralReceiver:
					return adjustPriority(entry, crossRefPriority + 60)
	
				IIdentifiableElementDescription : {
					switch objectDesc.elementOrProxy {
						JvmField : {
							return adjustPriority(entry, crossRefPriority + 50)
						}
						JvmExecutable : {
							return adjustPriority(entry, crossRefPriority + 20)
						}
					}
				}
			}
		}
		return super.getCrossRefPriority(objectDesc, entry)
	}
	
	def getTypeRefPriority(ITypeDescriptor typeDesc, ContentAssistEntry entry) {
		adjustPriority(entry, crossRefPriority)
	}
	
}
