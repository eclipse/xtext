/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui;

import com.google.inject.Binder;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;
import org.eclipse.xtext.xbase.ui.editor.copyqualifiedname.XbaseCopyQualifiedNameService;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;
import org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.eclipse.xtext.xbase.ui.validation.XbaseIssueSeveritiesProvider;

/** 
 * Use this class to register components to be used within the IDE.
 */
public class XbaseUiModule extends AbstractXbaseUiModule {

	public XbaseUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return XbaseHighlightingConfiguration.class;
	}

	@Override
	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider() {
		return XbaseHoverDocumentationProvider.class;
	}

	public Class<? extends IssueSeveritiesProvider> bindIssueSeverityServiceProvider() {
		return XbaseIssueSeveritiesProvider.class;
	}

	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return XbaseLabelProvider.class;
	}

	@Override
	public void configureResourceUIServiceLabelProvider(Binder binder) {
		binder.bind(ILabelProvider.class).annotatedWith(ResourceServiceDescriptionLabelProvider.class).to(
			XbaseDescriptionLabelProvider.class);
	}

	@Override
	public Class<? extends CopyQualifiedNameService> bindCopyQualifiedNameService() {
		return XbaseCopyQualifiedNameService.class;
	}

	@Override
	public Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return OptimizingFeatureScopeTrackerProvider.class;
	}
}
