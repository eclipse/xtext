/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.xbase.ui.templates.XbaseTemplateProposalProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class TemplateProposalProvider extends XbaseTemplateProposalProvider {

	@Inject
	public TemplateProposalProvider(TemplateStore templateStore, ContextTypeRegistry registry,
			ContextTypeIdHelper helper) {
		super(templateStore, registry, helper);
	}
	
	@Override
	public Image getImage(Template template) {
		return JavaPlugin.getImageDescriptorRegistry().get(JavaPluginImages.DESC_OBJS_TEMPLATE);
	}

}
