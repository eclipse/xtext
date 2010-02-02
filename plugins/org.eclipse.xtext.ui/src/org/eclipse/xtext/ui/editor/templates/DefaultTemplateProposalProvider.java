/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementCalculator;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class DefaultTemplateProposalProvider extends AbstractTemplateProposalProvider {

	private TemplateStore templateStore;
	private XtextTemplateContextTypeRegistry registry;
	private Image image;
	@Inject
	private IFollowElementCalculatorForTemplates followElementCalculator;
	
	@Inject
	public DefaultTemplateProposalProvider(TemplateStore templateStore, XtextTemplateContextTypeRegistry registry) {
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
	protected TemplateContextType[] getContextTypes(final ContentAssistContext context) {
		final Set<TemplateContextType> result = new LinkedHashSet<TemplateContextType>();
		FollowElementAcceptor acceptor = createFollowElementAcceptor(result);
		acceptor.addRootElementIfNecessary(context);
		followElementCalculator.calculateValidElements(context.getRootNode(), context.getLastCompleteNode(), context.getReplaceRegion().getOffset(), acceptor);
		return result.toArray(new TemplateContextType[result.size()]);
	}

	private FollowElementAcceptor createFollowElementAcceptor(final Collection<TemplateContextType> result) {
		return new FollowElementAcceptor(result);
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
	
	protected class FollowElementAcceptor implements IFollowElementCalculator.IFollowElementAcceptor {
		protected final Collection<TemplateContextType> result;

		protected FollowElementAcceptor(Collection<TemplateContextType> result) {
			this.result = result;
		}

		protected void addRootElementIfNecessary(ContentAssistContext context) {
			if (context.getRootNode().getOffset() >= context.getReplaceRegion().getOffset()) {
				if (context.getRootNode().getGrammarElement() instanceof ParserRule) {
					addContextType((ParserRule)context.getRootNode().getGrammarElement());
				}
			}
		}

		public void accept(AbstractElement element) {
			if (element instanceof RuleCall) {
				addContextType((RuleCall)element);
			} else if (element instanceof Keyword){
				addContextType((Keyword)element);
			}
		}

		protected void addContextType(RuleCall call) {
			if (call.getRule() instanceof ParserRule)
				addContextType((ParserRule)call.getRule());
		}

		protected void addContextType(Keyword keyword) {
			addContextType(registry.getId(keyword));
		}

		protected void addContextType(ParserRule rule) {
			addContextType(registry.getId(rule));
		}

		protected void addContextType(String id) {
			TemplateContextType contextType = registry.getContextType(id);
			if (contextType != null)
				result.add(contextType);
		}
	}


}
