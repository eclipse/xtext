/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide

import com.google.inject.Binder
import org.eclipse.xtext.ide.DefaultIdeModule
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.xbase.ide.contentassist.ClasspathBasedIdeTypesProposalProvider
import org.eclipse.xtext.xbase.ide.contentassist.IIdeTypesProposalProvider
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalPriorities
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalProvider
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeCrossrefProposalProvider
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider

/**
 * Default Guice bindings for the generic IDE contributions of the Xbase languages.
 */
class DefaultXbaseIdeModule extends DefaultIdeModule {
	
	protected static val classpathScanner = new ClasspathScanner
	
	def void configureClasspathScanner(Binder binder) {
		binder.bind(ClasspathScanner).toInstance(classpathScanner)
	}
	
	def Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTrackerProvider() {
		OptimizingFeatureScopeTrackerProvider
	}
	
	def Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		XbaseIdeContentProposalProvider
	}
	
	def Class<? extends IdeCrossrefProposalProvider> bindIdeCrossrefProposalProvider() {
		XbaseIdeCrossrefProposalProvider
	}
	
	def Class<? extends IIdeTypesProposalProvider> bindIIdeTypesProposalProvider() {
		ClasspathBasedIdeTypesProposalProvider
	}
	
	def Class<? extends IdeContentProposalPriorities> bindIdeContentProposalPriorities() {
		XbaseIdeContentProposalPriorities
	}
	
	def Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		XbaseHighlightingCalculator
	}
	
}