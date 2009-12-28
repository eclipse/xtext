/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.core.DefaultStyledLabelProvider;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextStyledLabelProvider extends DefaultStyledLabelProvider {
	private SemanticHighlightingConfiguration semanticHighlightingConfiguration = new SemanticHighlightingConfiguration();

	StyledString styled_string(ParserRule parserRule) {
		if (GrammarUtil.isDatatypeRule(parserRule)) {
			return createStyledString(parserRule, createXtextStyleAdapterStyler(semanticHighlightingConfiguration
					.dataTypeRule()));
		}
		return createStyledString(parserRule);
	}

}
