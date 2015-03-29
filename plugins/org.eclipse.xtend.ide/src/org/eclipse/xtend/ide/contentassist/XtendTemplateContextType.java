/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
