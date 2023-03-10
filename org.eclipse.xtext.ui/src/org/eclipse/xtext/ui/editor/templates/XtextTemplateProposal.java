/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
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

	@Override
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
					templateBuffer = ((XtextTemplateContext) context).evaluateForDisplay(template);
				} else {
					templateBuffer = context.evaluate(template);
				}
			} catch (TemplateException e) {
				return null;
			}
			return templateBuffer.getString();
		} catch (BadLocationException e) {
			return null;
		}
	}

	@Override
	public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
		IDocument document = viewer.getDocument();
		// ImportsVariableResolver may add imports, so start a rewrite session if possible. 
		// This will compound all document changes in one Undo entry.
		if (document instanceof IDocumentExtension4) {
			IDocumentExtension4 docExt4 = (IDocumentExtension4) document;
			DocumentRewriteSession session = docExt4.startRewriteSession(DocumentRewriteSessionType.UNRESTRICTED);
			super.apply(viewer, trigger, stateMask, offset);
			if (session != null) {
				docExt4.stopRewriteSession(session);
			}
		} else {
			super.apply(viewer, trigger, stateMask, offset);
		}
	}
}
