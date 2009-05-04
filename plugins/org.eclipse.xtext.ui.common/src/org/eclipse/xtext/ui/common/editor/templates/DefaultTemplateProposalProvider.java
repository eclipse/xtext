/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.templates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.ui.common.internal.Activator;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.util.XtextSwitch;

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
	private Image image;
	
	@Inject
	public DefaultTemplateProposalProvider(TemplateStore templateStore, ContextTypeRegistry registry) {
		this.templateStore = templateStore;
		this.registry = registry;
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
	protected TemplateContextType[] getContextTypes(ContentAssistContext context) {
		Set<AbstractElement> set = ParseTreeUtil.getElementSetValidFromOffset(context.getRootNode(), context.getLastCompleteNode(), context.getOffset());
		final Set<TemplateContextType> result = new HashSet<TemplateContextType>();
		XtextSwitch<Object> switch1 = new XtextSwitch<Object>() {
			public Object caseAlternatives(Alternatives object) {
				for (AbstractElement alt : object.getGroups()) {
					doSwitch(alt);
				}
				return null;
			};
			
			public Object caseGroup(Group group) {
				Iterator<AbstractElement> iter = group.getTokens().iterator();
				AbstractElement current = null;
				do {
					current = iter.next();
					doSwitch(current);
				} while ((GrammarUtil.isOptionalCardinality(current) || current instanceof Action) && iter.hasNext());
				return null;
			};
			
			@Override
			public Object caseAssignment(Assignment object) {
				doSwitch(object.getTerminal());
				return null;
			}
			
			public Object caseRuleCall(RuleCall object) {
				if (object.getRule() instanceof ParserRule) {
					result.add(registry.getContextType(XtextTemplateContextTypeRegistry.getId((ParserRule) object.getRule())));
				}
				doSwitch(object.getRule().getAlternatives());
				return null;
			};
			
			@Override
			public Object caseKeyword(Keyword object) {
				result.add(registry.getContextType(XtextTemplateContextTypeRegistry.getId(object)));
				return null;
			}
		};
		for (AbstractElement element : set) {
			switch1.doSwitch(element);
		}
		result.remove(null);
		return result.toArray(new TemplateContextType[result.size()]);
	}

	public Image getImage(Template template) {
		if (image == null) {
			ImageDescriptor imageDescriptor = Activator.getImageDescriptor("icons/defaultoutlinenode.gif");
			image = imageDescriptor.createImage();
		}
		return image;
	}
	
	public int getRelevance(Template template) {
		return 90;
	}


}
