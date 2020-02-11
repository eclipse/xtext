/**
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.example.domainmodel.ui.autoedit.FantasticEditStrategyProvider;
import org.eclipse.xtext.example.domainmodel.ui.linking.DomainmodelLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.example.domainmodel.ui.navigation.DomainmodelHyperlinkHelper;
import org.eclipse.xtext.example.domainmodel.ui.outline.FilterOperationsContribution;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class DomainmodelUiModule extends AbstractDomainmodelUiModule {

	public DomainmodelUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return DomainmodelLinkingDiagnosticMessageProvider.class;
	}

	@Override
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return DomainmodelHyperlinkHelper.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return FantasticEditStrategyProvider.class;
	}

	public void configureFilterOperationsOutlineContribution(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("FilterOperationsContribution"))
				.to(FilterOperationsContribution.class);
	}
}
