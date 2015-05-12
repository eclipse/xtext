/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription

@FinalFieldsConstructor
class CrossrefProposalCreator implements (IEObjectDescription) => ContentAssistResult.Entry {
	
	@Accessors(PROTECTED_GETTER)
	val ContentAssistContext contentAssistContext
	@Accessors(PROTECTED_GETTER)
	val IQualifiedNameConverter qualifiedNameConverter

	override apply(IEObjectDescription candidate) {
		if (candidate === null)
			return null
		return new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, contentAssistContext.prefix) => [
			proposal = qualifiedNameConverter.toString(candidate.name)
			description = candidate.getEClass.name
		]
	}
	
}
