/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultTemplateProposalProvider extends AbstractTemplateProposalProvider {

	@Override
	protected void createTemplates(TemplateContext templateContext, ContentAssistContext context,
			ITemplateAcceptor acceptor) {
		Template[] templates = getTemplates(templateContext.getContextType().getId());
		for(Template template: templates) {
			if (!acceptor.canAcceptMoreTemplates())
				return;
			if (validate(template, templateContext)) {
				acceptor.accept(createProposal(template, templateContext, context,
						getImage(template), getRelevance(template)));
			}
		}
	}

	@Override
	protected TemplateContextType[] getContextTypes(ContentAssistContext context) {
		return getTemplateContextTypes(context);
	}
	
	public class TemplateContextTypeProvider extends XtextSwitch<Boolean> {
		
		private final ContentAssistContext context;
		
		private final Collection<TemplateContextType> contextTypes;
		
		public TemplateContextTypeProvider(ContentAssistContext context, Collection<TemplateContextType> contextTypes) {
			this.context = context;
			this.contextTypes = contextTypes;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.FALSE;
		}
		
		private void add(TemplateContextType type) {
			if (type != null)
				contextTypes.add(type);
		}
		
		@Override
		public Boolean caseKeyword(Keyword object) {
			 add(getTemplateContextType(object, context));
			 return Boolean.FALSE;
		}
		
		@Override
		public Boolean caseRuleCall(RuleCall object) {
			add(getTemplateContextType(object, context));
			return doSwitch(object.getRule().getAlternatives());
		}
		
		@Override
		public Boolean caseGroup(Group object) {
			Iterator<AbstractElement> iter = object.getTokens().iterator();
			AbstractElement current = iter.next();
			doSwitch(current);
			while((GrammarUtil.isOptionalCardinality(current) || current instanceof Action) &&
					iter.hasNext()) {
				current = iter.next();
				doSwitch(current);
			}
			return Boolean.FALSE;
		}
		
		@Override
		public Boolean caseAssignment(Assignment object) {
			return doSwitch(object.getTerminal());
		}
		
		@Override
		public Boolean caseAlternatives(Alternatives object) {
			for (AbstractElement element: object.getGroups()) {
				doSwitch(element);
			}
			return Boolean.FALSE;
		}
	}
	
	public Image getImage(Template template) {
		return null;
	}

	public int getRelevance(Template template) {
		return 90;
	}
	
	public TemplateContextType[] getTemplateContextTypes(ContentAssistContext context) {
		Collection<TemplateContextType> templateContextTypes = new LinkedHashSet<TemplateContextType>();
		TemplateContextTypeProvider provider = new TemplateContextTypeProvider(context, templateContextTypes);
		for (AbstractElement element : context.getFirstSetGrammarElements()) {
			provider.doSwitch(element);
		}
		return templateContextTypes.toArray(new TemplateContextType[templateContextTypes.size()]);
	}

	/**
	 * Returns the context type that can handle template insertion at the given
	 * region in the viewer's document.
	 * 
	 * @param keyword the <code>Keyword</code> to be completed
	 * @param contentAssistContext the current context of the content assist
	 * @return the context type that can handle template expansion for the given
	 *         location, or <code>null</code> if none exists
	 */
	public TemplateContextType getTemplateContextType(Keyword keyword, ContentAssistContext context) {
		return null;
	}

	/**
	 * Returns the context type that can handle template insertion at the given
	 * region in the viewer's document.
	 * 
	 * @param ruleCall the <code>RuleCall</code>
	 * @param contentAssistContext the current context of the content assist
	 * @return the context type that can handle template expansion for the given
	 *         location, or <code>null</code> if none exists
	 */
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, ContentAssistContext contentAssistContext) {
		return null;
	}
	
	/**
	 * Returns the templates valid for the context type specified by
	 * <code>contextTypeId</code>.
	 * 
	 * @param contextTypeId the context type id
	 * @return the templates valid for this context type id
	 */
	public Template[] getTemplates(String contextId) {
		return null;
	}


}
