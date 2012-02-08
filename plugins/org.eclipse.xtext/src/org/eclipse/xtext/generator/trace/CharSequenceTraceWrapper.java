/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class CharSequenceTraceWrapper {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	public CharSequence wrapWithTraceData(CharSequence sequence, EObject origin) {
		ITextRegion location = locationInFileProvider.getSignificantTextRegion(origin);
		return wrapWithTraceData(sequence, origin.eResource().getURI(), location.getOffset(), location.getLength());
	}
	
	public CharSequence wrapWithTraceData(CharSequence sequence, URI originResourceURI, int originOffset, int originLength) {
		if (!originResourceURI.isPlatformResource()) {
			throw new IllegalArgumentException("URI has to be a platform resource uri but was: " + originResourceURI+ ". Use #wrapWithTraceData(CharSequence, URI, String, int, int) instead.");
		}
		return wrapWithTraceData(sequence, originResourceURI, originResourceURI.segment(2), originOffset, originLength);
	}
	
	public CharSequence wrapWithTraceData(CharSequence sequence, URI originURI, @Nullable String originProject, int originOffset, int originLength) {
		return new CharSequenceBasedTraceRegionProvider(sequence, originURI, originProject, originOffset, originLength);
	}
	
	protected static class CharSequenceBasedTraceRegionProvider implements ITraceRegionProvider, CharSequence {

		private final CharSequence delegate;
		private final URI originURI;
		private final String originProject;
		private final int originOffset;
		private final int originLength;

		public CharSequenceBasedTraceRegionProvider(CharSequence delegate, URI originURI, @Nullable String originProject,
				int originOffset, int originLength) {
			this.delegate = delegate;
			this.originURI = originURI;
			this.originProject = originProject;
			this.originOffset = originOffset;
			this.originLength = originLength;
		}

		public int length() {
			return delegate.length();
		}

		public char charAt(int index) {
			return delegate.charAt(index);
		}

		public CharSequence subSequence(int start, int end) {
			return delegate.subSequence(start, end);
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		public List<AbstractTraceRegion> getTraceRegions(final int relativeOffset, @Nullable AbstractTraceRegion parent) {
			AbstractTraceRegion result = new TraceRegion(relativeOffset, delegate.length(), originOffset, originLength, parent, originURI, originProject) {
				{
					// initialize children
					if (delegate instanceof ITraceRegionProvider) {
						((ITraceRegionProvider) delegate).getTraceRegions(relativeOffset, this);
					}
				}
			};
			return Collections.singletonList(result);
		}

	}
	
}
