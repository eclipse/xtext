/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

import com.google.inject.Inject;

/**
 * Provides a convenience base type for <code>TemplateContextType's</code> preconfigured with several handy
 * Xtext <code>TemplateVariableResolver</code> .
 *
 * @author Michael Clay - Initial contribution and API
 */
public class XtextTemplateContextType extends TemplateContextType implements Comparable<TemplateContextType>{

	public XtextTemplateContextType() {
		addDefaultTemplateVariables();
	}
	
	@Inject
	public void setCrossReferenceResolver(CrossReferenceTemplateVariableResolver resolver) {
		addResolver(resolver);
	}
	
	@Inject
	public void setEnumResolver(EnumTemplateVariableResolver resolver) {
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

	@Override
	public int compareTo(TemplateContextType templateContextType) {
		int result = getName().compareTo(templateContextType.getName());
		if (result == 0) {
			return getId().compareTo(templateContextType.getId());
		}
		return result;
	}

}
