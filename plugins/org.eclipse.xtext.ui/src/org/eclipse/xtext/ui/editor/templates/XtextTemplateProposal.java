/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension4;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextTemplateProposal extends TemplateProposal implements ICompletionProposalExtension4 {

	public XtextTemplateProposal(Template template, TemplateContext context, IRegion region, Image image) {
		super(template, context, region, image);
	}
	
	public XtextTemplateProposal(Template template, TemplateContext context, IRegion region, Image image, int relevance) {
		super(template, context, region, image, relevance);
	}
	
	public boolean isAutoInsertable() {
		return getTemplate().isAutoInsertable();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || !(obj instanceof XtextTemplateProposal))
			return false;
		XtextTemplateProposal other = (XtextTemplateProposal) obj;
		
		return getTemplate().equals(other.getTemplate());
	}
	
	@Override
	public int hashCode() {
		return getTemplate().hashCode();
	}
	
	@Override
	public String getAdditionalProposalInfo() {
		try {
		    TemplateContext context = getContext();
			context.setReadOnly(true);
			TemplateBuffer templateBuffer;
			try {
				Template template = getTemplate();
				if (context instanceof XtextTemplateContext) {
					templateBuffer= ((XtextTemplateContext)context).evaluateForDisplay(template);
				} else {
					templateBuffer= context.evaluate(template);
				}
			} catch (TemplateException e) {
				return null;
			}
			return templateBuffer.getString();
	    } catch (BadLocationException e) {
			return null;
		}
	}
}
