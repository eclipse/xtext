/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class LanguageConfig extends CompositeGeneratorFragment {

	private Grammar grammar;

	public void setUri(String uri) {
		XtextResourceSet rs = new XtextResourceSet();
		Resource resource = rs.getResource(URI.createURI(uri), true);
		if (resource.getContents().isEmpty()) {
			throw new IllegalArgumentException("Couldn't load grammar for '" + uri + "'.");
		}
		grammar = (Grammar) resource.getContents().get(0);
	}

	/**
	 * @return
	 */
	public Grammar getGrammar() {
		return grammar;
	}
	
}
