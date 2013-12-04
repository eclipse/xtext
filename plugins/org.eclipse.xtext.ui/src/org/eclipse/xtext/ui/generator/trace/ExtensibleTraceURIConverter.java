/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContributionRegistry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * An extension of the {@link DefaultTraceURIConverter} that allows to use
 * {@link TraceURIConverterContribution contributions} to resolve trace URIs.
 * 
 * The available contributions are used before the behavior of the {@link DefaultTraceURIConverter}
 * is used to resolve the URIs.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Holger Schill
 */
public class ExtensibleTraceURIConverter extends DefaultTraceURIConverter {

	public static class CompositeContribution implements TraceURIConverterContribution {

		private ImmutableList<? extends TraceURIConverterContribution> contributions;

		public CompositeContribution(ImmutableList<? extends TraceURIConverterContribution> contributions) {
			this.contributions = contributions;
		}

		@Nullable
		public URI getURIForTrace(XtextResource context) {
			for(int i = 0, size = contributions.size(); i < size; i++) {
				URI result = contributions.get(i).getURIForTrace(context);
				if (result != null) {
					return result;
				}
			}
			return null;
		}

		@Nullable
		public URI getURIForTrace(URI uri) {
			for(int i = 0, size = contributions.size(); i < size; i++) {
				URI result = contributions.get(i).getURIForTrace(uri);
				if (result != null) {
					return result;
				}
			}
			return null;
		}
		
	}
	public static final class NullContribution implements TraceURIConverterContribution {

		@Nullable
		public URI getURIForTrace(XtextResource context) {
			return null;
		}

		@Nullable
		public URI getURIForTrace(URI uri) {
			return null;
		}
		
	}
	
	private TraceURIConverterContribution contribution;
	
	@Inject
	private void initializeContribution(SharedStateContributionRegistry registry) {
		contribution = getContribution(registry.getContributedInstances(TraceURIConverterContribution.class));
	}
	
	private TraceURIConverterContribution getContribution(ImmutableList<? extends TraceURIConverterContribution> allContributions) {
		switch(allContributions.size()) {
			case 0: return new NullContribution();
			case 1: return allContributions.get(0);
			default: return new CompositeContribution(allContributions);
		}
	}

	@Override
	public URI getURIForTrace(XtextResource context) {
		URI result = contribution.getURIForTrace(context);
		if (result != null) {
			return result;
		}
		return super.getURIForTrace(context);
		
	}

	@Override
	public URI getURIForTrace(URI uri) {
		URI result = contribution.getURIForTrace(uri);
		if (result != null) {
			return result;
		}
		return super.getURIForTrace(uri);
	}

	
}
