/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.templates.TemplateContextType;

/**
 * Strategy interface for computing template proposals matching the given <code>TemplateContextType</code> and
 * <code>IContentAssistContext</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public interface ITemplateContentAssistProcessor extends IContentAssistProcessor {

	/**
	 * @param contextType the context type that can handle template expansion for the given contentAssistContext (must not be null)
	 */
	void setContextType(TemplateContextType contextType);
	
	/**
	 * @param contentAssistContext the current context of the content assist proposal request (must not be null)
	 */
	void setContentAssistContext(IContentAssistContext contentAssistContext);
	
}
