/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import java.util.concurrent.ExecutorService;

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.web.example.jetty.contentassist.StatemachineWebContentProposalProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineImageDescriptionProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineSemanticHighlightingCalculator;
import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;

import com.google.inject.Binder;
import com.google.inject.Provider;

/**
 * Use this class to register components to be used within the web application.
 */
public class StatemachineWebModule extends AbstractStatemachineWebModule {
	
	private IResourceBaseProvider resourceBaseProvider;
	
	public StatemachineWebModule(Provider<ExecutorService> executorServiceProvider) {
		super(executorServiceProvider);
	}
	
	public void setResourceBaseProvider(IResourceBaseProvider resourceBaseProvider) {
		this.resourceBaseProvider = resourceBaseProvider;
	}
	
	public void configureResourceBaseProvider(Binder binder) {
		if (resourceBaseProvider != null)
			binder.bind(IResourceBaseProvider.class).toInstance(resourceBaseProvider);
	}
	
	public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		return FileResourceHandler.class;
	}
	
	public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return StatemachineWebContentProposalProvider.class;
	}

	public Class<? extends IImageDescriptionProvider> bindIImageDescriptionProvider() {
		return StatemachineImageDescriptionProvider.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return StatemachineSemanticHighlightingCalculator.class;
	}
	
}
