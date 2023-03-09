/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide;

import com.google.inject.Binder;
import org.eclipse.xtext.common.types.descriptions.ClasspathScanner;
import org.eclipse.xtext.ide.DefaultIdeModule;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.xbase.ide.contentassist.ClasspathBasedIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.IIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalPriorities;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeCrossrefProposalProvider;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;

/**
 * Default Guice bindings for the generic IDE contributions of the Xbase
 * languages.
 */
public class DefaultXbaseIdeModule extends DefaultIdeModule {
	public void configureClasspathScanner(Binder binder) {
		binder.bind(ClasspathScanner.class);
	}

	public Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTrackerProvider() {
		return OptimizingFeatureScopeTrackerProvider.class;
	}

	public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return XbaseIdeContentProposalProvider.class;
	}

	public Class<? extends IdeCrossrefProposalProvider> bindIdeCrossrefProposalProvider() {
		return XbaseIdeCrossrefProposalProvider.class;
	}

	public Class<? extends IIdeTypesProposalProvider> bindIIdeTypesProposalProvider() {
		return ClasspathBasedIdeTypesProposalProvider.class;
	}

	public Class<? extends IdeContentProposalPriorities> bindIdeContentProposalPriorities() {
		return XbaseIdeContentProposalPriorities.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return XbaseHighlightingCalculator.class;
	}
}
