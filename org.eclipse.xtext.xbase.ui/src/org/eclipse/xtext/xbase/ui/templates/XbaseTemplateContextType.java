/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.templates;

import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextType;

import com.google.inject.Inject;

/**
 * Provides a convenience base type for <code>XbaseTemplateContextType's</code> preconfigured with several handy Xbase
 * <code>TemplateVariableResolver</code> .
 *
 * @author Dennis Hübner (dhubner) - Initial contribution and API
 * 
 * @since 2.7
 */
public class XbaseTemplateContextType extends XtextTemplateContextType {

	/**
	 * @since 2.7
	 */
	@Inject
	public void setImportsResolver(ImportsVariableResolver resolver) {
		addResolver(resolver);
	}
}
