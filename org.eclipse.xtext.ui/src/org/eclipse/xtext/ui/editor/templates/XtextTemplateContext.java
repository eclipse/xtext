/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateTranslator;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * Represents an extended version of class {@link DocumentTemplateContext} to provide additional Xtext related information and services for
 * resolving a <code>Template</code>. Furthermore it fixes the indentation of the applied template.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextTemplateContext extends DocumentTemplateContext {

	private final ContentAssistContext contentAssistContext;

	private final IScopeProvider scopeProvider;

	public XtextTemplateContext(TemplateContextType type, IDocument document, Position position, ContentAssistContext contentAssistContext,
			IScopeProvider scopeProvider) {
		super(type, document, position);
		this.contentAssistContext = contentAssistContext;
		this.scopeProvider = scopeProvider;
	}

	/**
	 * @return the contentAssistContext
	 */
	public ContentAssistContext getContentAssistContext() {
		return contentAssistContext;
	}

	/**
	 * @return the linkingCandidatesService
	 */
	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	@Override
	public TemplateBuffer evaluate(Template template) throws BadLocationException, TemplateException {
		if (!canEvaluate(template))
			return null;

		TemplateTranslator translator = createTemplateTranslator();
		TemplateBuffer buffer = translator.translate(template);

		getContextType().resolve(buffer, this);

		return buffer;
	}

	/**
	 * @since 2.3
	 */
	public TemplateBuffer evaluateForDisplay(Template template) throws BadLocationException, TemplateException {
		if (!canEvaluate(template))
			return null;

		TemplateTranslator translator = new TemplateTranslator();
		TemplateBuffer buffer = translator.translate(template);

		getContextType().resolve(buffer, this);

		return buffer;
	}

	protected TemplateTranslator createTemplateTranslator() {
		try {
			int offset = getStart();
			IRegion lineRegion = getDocument().getLineInformationOfOffset(offset);
			String line = getDocument().get(lineRegion.getOffset(), lineRegion.getLength());
			String lineDelimiter = getDocument() instanceof IDocumentExtension4
					? ((IDocumentExtension4) getDocument()).getDefaultLineDelimiter()
					: null;
			int i = 0;
			while (i < line.length() && Character.isWhitespace(line.charAt(i))) {
				i++;
			}
			if (i != 0)
				return new IndentationAwareTemplateTranslator(line.substring(0, i), lineDelimiter);
			return new IndentationAwareTemplateTranslator("", lineDelimiter);
		} catch (BadLocationException ex) {
			return new TemplateTranslator();
		}
	}

	public static class IndentationAwareTemplateTranslator extends TemplateTranslator {

		private final String indentation;
		private final String lineDelimiter;

		public IndentationAwareTemplateTranslator(String indentation, String lineDelimiter) {
			this.indentation = indentation;
			this.lineDelimiter = lineDelimiter == null ? System.lineSeparator() : lineDelimiter;
		}

		@Override
		public TemplateBuffer translate(Template template) throws TemplateException {
			return translate(template.getPattern());
		}

		@Override
		public TemplateBuffer translate(String string) throws TemplateException {
			return super.translate(string.replaceAll("(\r\n?)|(\n)", lineDelimiter + indentation));
		}
	}

}