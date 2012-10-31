/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.xpect.ui.highlighting.XpectTokenDefProvider;
import org.xpect.ui.highlighting.XpectTokenToAttributeMapper;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectUiModule extends org.xpect.ui.AbstractXpectUiModule {
	public XpectUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(ITokenDefProvider.class).annotatedWith(Names.named(LexerUIBindings.HIGHLIGHTING)).to(XpectTokenDefProvider.class);
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return XpectTokenToAttributeMapper.class;
	}

}
