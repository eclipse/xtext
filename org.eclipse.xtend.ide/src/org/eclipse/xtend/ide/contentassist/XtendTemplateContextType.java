/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.xtext.ui.editor.templates.CrossReferenceTemplateVariableResolver;
import org.eclipse.xtext.xbase.ui.templates.XbaseTemplateContextType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendTemplateContextType extends XbaseTemplateContextType {

	@Override
	public void setCrossReferenceResolver(CrossReferenceTemplateVariableResolver resolver) {
		// don't register the CrossReferenceTemplateVariableResolver for Xtend
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=462917
	}
	
}
