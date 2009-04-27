/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

import com.google.inject.Inject;

/**
 * Provides a convenience base type for <code>TemplateContextType's</code> preconfigured with several handy
 * Xtext <code>TemplateVariableResolver</code> .
 *
 * @author Michael Clay - Initial contribution and API
 */
public class XtextTemplateContextType extends TemplateContextType {

	public XtextTemplateContextType() {
		addDefaultTemplateVariables();
	}
	
	@Inject
	public void setCrossReferenceResolver(CrossReferenceTemplateVariableResolver resolver) {
		addResolver(resolver);
	}

	protected void addDefaultTemplateVariables() {
		addResolver(new GlobalTemplateVariables.WordSelection());
		addResolver(new GlobalTemplateVariables.LineSelection());
		addResolver(new GlobalTemplateVariables.Date());
		addResolver(new GlobalTemplateVariables.Year());
		addResolver(new GlobalTemplateVariables.Time());
		addResolver(new GlobalTemplateVariables.Dollar());
		addResolver(new GlobalTemplateVariables.User());
		addResolver(new GlobalTemplateVariables.Cursor());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof TemplateContextType))
			return false;
		if (obj == this)
			return true;
		TemplateContextType contextType = (TemplateContextType) obj;
		return getId().equals(contextType.getId());
	}
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}

}
