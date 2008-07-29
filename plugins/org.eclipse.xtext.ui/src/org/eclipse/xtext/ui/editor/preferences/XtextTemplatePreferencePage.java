/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IProposalsProvider;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextTemplatePreferencePage extends TemplatePreferencePage implements IWorkbenchPreferencePage {
	
	@Inject
	private IProposalsProvider templateProvider;
	
	@Inject
	private IServiceScope languageDescriptor;
	
	public XtextTemplatePreferencePage() {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}
	
	@Override
	public void init(IWorkbench workbench) {
		super.init(workbench);
		setTemplateStore(templateProvider.getTemplateStore());
		setContextTypeRegistry(templateProvider.getTemplateContextRegistry());
	}
	
}
