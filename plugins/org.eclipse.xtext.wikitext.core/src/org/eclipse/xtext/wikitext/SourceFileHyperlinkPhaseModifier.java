/*******************************************************************************
 * Copyright (c) 2009 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.wikitext;

import org.eclipse.mylyn.wikitext.core.parser.markup.PatternBasedElement;
import org.eclipse.mylyn.wikitext.core.parser.markup.PatternBasedElementProcessor;

/**
 * Detect a hyperlink to source code <tt>${org.eclipse.xtext/src/org.eclipse.xtext.crossref.IScope}</tt>
 * 
 * @author David Green
 * @author Peter Friese
 */
public class SourceFileHyperlinkPhaseModifier extends PatternBasedElement {

	private static final String PACKAGE_PART = "(?:[a-z][a-zA-Z0-9]*)"; //$NON-NLS-1$

	private static final String CLASS_PART = "(?:[A-Z][a-zA-Z0-9_$]*)+"; //$NON-NLS-1$

	private static final String FQN_PART = PACKAGE_PART + "(?:\\." + PACKAGE_PART + ")*\\.(" + CLASS_PART + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	@Override
	protected String getPattern(int groupOffset) {
		// ${org.eclipse.xtext/src/org.eclipse.xtext.crossref.IScope}
		return "\\$\\{([^/]+/src/)(" + FQN_PART + ")\\}"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	protected int getPatternGroupCount() {
		return 3;
	}

	@Override
	protected PatternBasedElementProcessor newProcessor() {
		return new HyperlinkReplacementTokenProcessor();
	}

	private static class HyperlinkReplacementTokenProcessor extends PatternBasedElementProcessor {
		@Override
		public void emit() {
			String projectPath = group(1);
			String fqn = group(2);
			String className = group(3);

			builder.link("http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.tmf/org.eclipse.xtext/plugins/" //$NON-NLS-1$
					+ projectPath + fqn.replace('.', '/') + ".java?root=Modeling_Project&view=co", className); //$NON-NLS-1$
		}
	}

}