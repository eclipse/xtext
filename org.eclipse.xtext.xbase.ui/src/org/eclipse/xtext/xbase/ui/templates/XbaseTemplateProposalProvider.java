/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.templates;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@Singleton
public class XbaseTemplateProposalProvider extends DefaultTemplateProposalProvider {

	@Inject
	private XbaseTemplateContext.Factory factory;

	public XbaseTemplateProposalProvider(TemplateStore templateStore, ContextTypeRegistry registry,
			ContextTypeIdHelper helper) {
		super(templateStore, registry, helper);
	}

	@Override
	protected TemplateContext doCreateTemplateContext(TemplateContextType contextType, ContentAssistContext context) {
		return factory.create(contextType, context.getDocument(), createPosition(context), context, getScopeProvider());
	}
}
