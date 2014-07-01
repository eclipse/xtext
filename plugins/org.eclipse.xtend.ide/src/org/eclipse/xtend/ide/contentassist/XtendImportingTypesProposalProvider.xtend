/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist

import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.FilteringScope
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.xbase.ui.contentassist.ImportingTypesProposalProvider

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class XtendImportingTypesProposalProvider extends ImportingTypesProposalProvider {
	
	override protected createTextApplier(ContentAssistContext context, IScope typeScope, IQualifiedNameConverter qualifiedNameConverter, IValueConverter<String> valueConverter) {
		val scope = new FilteringScope(typeScope)[name != XtendImportedNamespaceScopeProvider.OLD_PROPERTY_ANNOTATION]
		super.createTextApplier(context, scope, qualifiedNameConverter, valueConverter)
	}
	
}