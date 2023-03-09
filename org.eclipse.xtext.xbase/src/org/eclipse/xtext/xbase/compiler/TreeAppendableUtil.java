/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.ILocationInFileProviderExtension;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;

public class TreeAppendableUtil {
	@Inject
	private ILocationInFileProvider locationProvider;

	public ITreeAppendable traceSignificant(ITreeAppendable appendable, EObject source) {
		return traceSignificant(appendable, source, false);
	}

	public ITreeAppendable traceSignificant(ITreeAppendable appendable, EObject source, boolean useForDebugging) {
		if (appendable instanceof TreeAppendable) {
			return ((TreeAppendable) appendable).trace(source,
					ILocationInFileProviderExtension.RegionDescription.SIGNIFICANT, useForDebugging);
		} else {
			ITextRegionWithLineInformation it = (ITextRegionWithLineInformation) locationProvider
					.getSignificantTextRegion(source);
			if (it != null && it != ITextRegion.EMPTY_REGION) {
				return appendable.trace(new LocationData(it.getOffset(), it.getLength(), it.getLineNumber(),
						it.getEndLineNumber(), null), useForDebugging);
			} else {
				return appendable;
			}
		}
	}

	public ITreeAppendable traceWithComments(ITreeAppendable appendable, EObject source) {
		if (appendable instanceof TreeAppendable) {
			return ((TreeAppendable) appendable).trace(source,
					ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS, false);
		} else {
			final ITextRegionWithLineInformation it;
			if (locationProvider instanceof ILocationInFileProviderExtension) {
				ILocationInFileProviderExtension locationInFileProviderExtension = (ILocationInFileProviderExtension) locationProvider;
				it = (ITextRegionWithLineInformation) locationInFileProviderExtension.getTextRegion(source,
						ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS);
			} else {
				it = (ITextRegionWithLineInformation) locationProvider.getFullTextRegion(source);
			}
			if (it != null && it != ITextRegion.EMPTY_REGION) {
				return appendable.trace(new LocationData(it.getOffset(), it.getLength(), it.getLineNumber(),
						it.getEndLineNumber(), null));
			} else {
				return appendable;
			}
		}
	}
}
