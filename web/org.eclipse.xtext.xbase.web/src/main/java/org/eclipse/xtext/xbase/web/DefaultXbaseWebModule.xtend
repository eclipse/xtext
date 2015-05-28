/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web

import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalCreator
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider
import org.eclipse.xtext.xbase.web.contentassist.DummyTypesProposalProvider
import org.eclipse.xtext.xbase.web.contentassist.ITypesProposalProvider
import org.eclipse.xtext.xbase.web.contentassist.XbaseCrossrefProposalCreator
import org.eclipse.xtext.xbase.web.contentassist.XbaseWebContentProposalPriorities
import org.eclipse.xtext.xbase.web.contentassist.XbaseWebContentProposalProvider

class DefaultXbaseWebModule extends AbstractGenericModule {
	
	def Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTrackerProvider() {
		OptimizingFeatureScopeTrackerProvider
	}
	
	def Class<? extends WebContentProposalProvider> bindWebContentProposalProvider() {
		XbaseWebContentProposalProvider
	}
	
	def Class<? extends CrossrefProposalCreator> bindCrossrefProposalCreator() {
		XbaseCrossrefProposalCreator
	}
	
	def Class<? extends WebContentProposalPriorities> bindWebContentProposalPriorities() {
		XbaseWebContentProposalPriorities
	}
	
	def Class<? extends ITypesProposalProvider> bindITypesProposalProvider() {
		DummyTypesProposalProvider
	}
	
}
