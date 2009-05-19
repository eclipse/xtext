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

import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

/**
 * A sample extension to Textile to demonstrate how to extend a markup language
 * 
 * @author David Green
 * @author Peter Friese
 */
public class XtextTextileDialect extends TextileLanguage {

	public XtextTextileDialect() {
		setName("Xtext Textile"); //$NON-NLS-1$
	}

	@Override
	protected void addPhraseModifierExtensions(PatternBasedSyntax phraseModifierSyntax) {
		super.addPhraseModifierExtensions(phraseModifierSyntax);
		phraseModifierSyntax.add(new SourceFileHyperlinkPhaseModifier());
	}
}