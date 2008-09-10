/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IProposalsProvider;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractProposalsProvider implements IProposalsProvider {

	@Inject
	public IServiceScope languageDescriptor;

	private ContributionContextTypeRegistry templateContextTypeRegistry;
	private ContributionTemplateStore templateStore;

	public synchronized ContextTypeRegistry getTemplateContextRegistry() {
		if (templateContextTypeRegistry == null) {
			ContributionContextTypeRegistry registry = new ContributionContextTypeRegistry();
			registerContextTypes(registry);
			templateContextTypeRegistry = registry;
		}
		return templateContextTypeRegistry;
	}

	protected abstract void registerContextTypes(ContributionContextTypeRegistry registry);

	protected String getTemplateStorePreferenceKey() {
		return languageDescriptor.getId() + ".custom_code_templates";
	}

	public TemplateStore getTemplateStore() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if (templateStore == null) {
			templateStore = new ContributionTemplateStore(getTemplateContextRegistry(), store,
					getTemplateStorePreferenceKey());
			try {
				templateStore.load();
			}
			catch (IOException e) {
			}
			templateStore.startListeningForPreferenceChanges();
		}
		return templateStore;
	}

	public abstract ICompletionContext computeContext(IEditorModel model, ITextViewer viewer, int offset);

	public abstract List<ICompletionProposal> getProposals(ICompletionContext context);

	public List<ICompletionProposal> getTemplateProposals(ICompletionContext context) {
		TemplateContextType templateContextType = context.getTemplateContextType();
		String id = templateContextType.getId();
		TemplateContext templateContext = context.getTemplateContext();

		Template[] templates = getTemplateStore().getTemplates(id);
		List<ICompletionProposal> matches = new ArrayList<ICompletionProposal>();
		for (int i = 0; i < templates.length; i++) {
			matches.add(new TemplateProposal(templates[i], templateContext, context.getRegion(), null, 1));
		}
		return matches;
	}

	public final List<ICompletionProposal> getAllProposals(IEditorModel model, ITextViewer viewer, int offset) {
		ICompletionContext completionContext = computeContext(model, viewer, offset);
		return getProposals(completionContext);
	}

}
