/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.contentassist

import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult.Entry

class DummyTypesProposalProvider implements ITypesProposalProvider {
	
	override createTypeProposals(ContentAssistContext context, EReference typeReference, IValueConverter<String> valueConverter,
			ITypeFilter filter, IAcceptor<Entry> acceptor) {
		acceptor.accept(new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, context.prefix) => [
			proposal = 'Object'
			description = 'java.lang'
		])
		acceptor.accept(new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, context.prefix) => [
			proposal = 'String'
			description = 'java.lang'
		])
	}
	
}