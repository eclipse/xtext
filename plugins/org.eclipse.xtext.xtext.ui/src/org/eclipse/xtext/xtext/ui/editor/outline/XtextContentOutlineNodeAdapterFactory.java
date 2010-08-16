/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ui.editor.outline.actions.DefaultContentOutlineNodeAdapterFactory;

/**
 * @author Peter Friese - Initial contribution and API
 * @deprecation see {@link org.eclipse.xtext.ui.editor.outline.actions.IContentOutlineNodeAdapterFactory}.  
 */
@Deprecated
public class XtextContentOutlineNodeAdapterFactory extends DefaultContentOutlineNodeAdapterFactory {

	@SuppressWarnings("rawtypes")
	private static final Class[] types = { ParserRule.class, Grammar.class };

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return types;
	}

}
