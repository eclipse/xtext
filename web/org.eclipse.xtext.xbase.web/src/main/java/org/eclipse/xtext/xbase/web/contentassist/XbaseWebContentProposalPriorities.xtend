/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.contentassist

import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult.Entry
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription
import org.eclipse.xtext.xbase.scoping.batch.StaticFeatureDescriptionWithTypeLiteralReceiver
import org.eclipse.xtext.xbase.web.scoping.ITypeDescriptor

class XbaseWebContentProposalPriorities extends WebContentProposalPriorities {
	
	override getCrossRefPriority(IEObjectDescription objectDesc, Entry entry) {
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
		return super.getCrossRefPriority(objectDesc, entry)
	}
	
	def getTypeRefPriority(ITypeDescriptor typeDesc, Entry entry) {
		adjustPriority(entry, crossRefPriority)
	}
	
}