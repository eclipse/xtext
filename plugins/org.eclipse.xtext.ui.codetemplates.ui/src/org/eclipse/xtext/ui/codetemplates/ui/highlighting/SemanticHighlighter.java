/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.ui.evaluator.EvaluatedTemplate;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SemanticHighlighter implements ISemanticHighlightingCalculator {

	@Inject
	private LanguageRegistry registry;
	
	public void provideHighlightingFor(XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getContents().isEmpty())
			return;
		Codetemplates templates = (Codetemplates) resource.getContents().get(0);
		Grammar grammar = templates.getLanguage();
		if (grammar != null && !grammar.eIsProxy()) {
			TemplateBodyHighlighter highlighter = getHighlighter(grammar);
			if (highlighter != null) {
				for(Codetemplate template: templates.getTemplates()) {
					if (template.getBody() != null) {
						final EvaluatedTemplate evaluatedTemplate = new EvaluatedTemplate(template);
						highlighter.provideHighlightingFor(evaluatedTemplate.getMappedString(), new IHighlightedPositionAcceptor() {
							public void addPosition(int offset, int length, String... id) {
								int beginOffset = evaluatedTemplate.getOriginalOffset(offset);
								int endOffset = evaluatedTemplate.getOriginalOffset(offset + length);
								int fixedLength = endOffset - beginOffset;
								acceptor.addPosition(beginOffset, fixedLength, id);
							}
						});
					}
				}
			}
		}
	}

	protected TemplateBodyHighlighter getHighlighter(Grammar grammar) {
		return registry.getTemplateBodyHighlighter(grammar);
	}

}
