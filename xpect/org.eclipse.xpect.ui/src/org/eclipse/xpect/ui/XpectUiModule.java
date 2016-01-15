/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xpect.ui.highlighting.XpectTokenDefProvider;
import org.eclipse.xpect.ui.highlighting.XpectTokenToAttributeMapper;
import org.eclipse.xpect.ui.scoping.ClasspathOrJdtBasedTypeScopeProvider;
import org.eclipse.xpect.ui.scoping.ClasspathOrJdtBasedTypeScopeProviderFactory;
import org.eclipse.xpect.ui.services.XpectEObjectAtOffsetHelper;
import org.eclipse.xpect.ui.services.XpectMultiLineTerminalsEditStrategyFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XpectUiModule extends AbstractXpectUiModule {
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

	@Override
	public Class<? extends AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return ClasspathOrJdtBasedTypeScopeProvider.class;
	}
	
	public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return ClasspathOrJdtBasedTypeScopeProviderFactory.class;
	}

	public Class<? extends MultiLineTerminalsEditStrategy.Factory> bindMultiLineTerminalsEditStrategyFactory() {
		return XpectMultiLineTerminalsEditStrategyFactory.class;
	}

	public Class<? extends EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		return XpectEObjectAtOffsetHelper.class;
	}

}
