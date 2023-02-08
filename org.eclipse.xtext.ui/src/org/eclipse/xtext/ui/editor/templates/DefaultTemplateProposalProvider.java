/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class DefaultTemplateProposalProvider extends AbstractTemplateProposalProvider {

	private TemplateStore templateStore;
	private ContextTypeRegistry registry;
	private ContextTypeIdHelper helper;
	
	@Inject
	public DefaultTemplateProposalProvider(TemplateStore templateStore, org.eclipse.jface.text.templates.ContextTypeRegistry registry, ContextTypeIdHelper helper) {
		this.templateStore = templateStore;
		this.registry = registry;
		this.helper = helper;
	}

	@Override
	protected void createTemplates(TemplateContext templateContext, ContentAssistContext context, ITemplateAcceptor acceptor) {
		TemplateContextType contextType = templateContext.getContextType();
		Template[] templates = templateStore.getTemplates(contextType.getId());
		for (Template template : templates) {
			if (!acceptor.canAcceptMoreTemplates())
				return;
			if (validate(template, templateContext)) {
				acceptor.accept(createProposal(template, templateContext, context, getImage(template), getRelevance(template)));
			}
		}
	}

	@Override
	protected TemplateContextType[] getContextTypes(final ContentAssistContext context) {
		final Set<TemplateContextType> result = Sets.newLinkedHashSet();
		IFollowElementAcceptor acceptor = createFollowElementAcceptor(result);
		List<AbstractElement> grammarElements = context.getFirstSetGrammarElements();
		for(AbstractElement element: grammarElements)
			acceptor.accept(element);
		return result.toArray(new TemplateContextType[result.size()]);
	}

	protected IFollowElementAcceptor createFollowElementAcceptor(final Collection<TemplateContextType> result) {
		return new FollowElementAcceptor(result);
	}

	public Image getImage(Template template) {
		ImageRegistry registry = Activator.getDefault().getImageRegistry();
		ImageDescriptor descriptor = registry.getDescriptor("defaultoutlinenode.gif");
		if (descriptor == null) {
			descriptor = Activator.getImageDescriptor("icons/defaultoutlinenode.gif"); //$NON-NLS-1$
			registry.put("defaultoutlinenode.gif", descriptor);
		}
		return registry.get("defaultoutlinenode.gif");
	}

	public int getRelevance(Template template) {
		return 90;
	}
	
	public class FollowElementAcceptor extends XtextSwitch<Boolean> implements IFollowElementAcceptor {

		private final Collection<TemplateContextType> result;

		public FollowElementAcceptor(Collection<TemplateContextType> result) {
			this.result = result;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseKeyword(Keyword object) {
			addContextType(object);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseRuleCall(RuleCall object) {
			doSwitch(object.getRule());
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseParserRule(ParserRule object) {
			addContextType(object);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseAssignment(Assignment object) {
			accept(object.getTerminal());
			return Boolean.TRUE;
		}

		@Override
		public void accept(AbstractElement element) {
			doSwitch(element);
		}
		
		protected void addContextType(ParserRule rule) {
			addContextType(helper.getId(rule));
		}

		protected void addContextType(Keyword keyword) {
			addContextType(helper.getId(keyword));
		}

		protected void addContextType(String id) {
			TemplateContextType contextType = registry.getContextType(id);
			if (contextType != null)
				result.add(contextType);
		}
	}

}
