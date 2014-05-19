/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CharSequenceTraceWrapper {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	public CharSequence wrapWithTraceData(CharSequence sequence, EObject origin) {
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(origin);
		return wrapWithTraceData(sequence, origin.eResource().getURI(), location.getOffset(), location.getLength(), location.getLineNumber(), location.getEndLineNumber());
	}
	
	public CharSequence wrapWithTraceData(CharSequence sequence, URI originResourceURI, int originOffset, int originLength, int originLineNumber, int originEndLineNumber) {
		if (!originResourceURI.isPlatformResource()) {
			throw new IllegalArgumentException("URI has to be a platform resource uri but was: " + originResourceURI+ ". Use #wrapWithTraceData(CharSequence, URI, String, int, int) instead.");
		}
		return wrapWithTraceData(sequence, originResourceURI, originResourceURI.segment(1), originOffset, originLength, originLineNumber, originEndLineNumber);
	}
	
	public CharSequence wrapWithTraceData(CharSequence sequence, URI originURI, /* @Nullable */ String originProject, int originOffset, int originLength, int originLineNumber, int originEndLineNumber) {
		return new CharSequenceBasedTraceRegionProvider(sequence, originURI, originOffset, originLength, originLineNumber, originEndLineNumber);
	}
	
	protected static class CharSequenceBasedTraceRegionProvider implements ITraceRegionProvider, CharSequence {

		private final CharSequence delegate;
		private final URI originURI;
		private final int originOffset;
		private final int originLength;
		private final int originLineNumber;
		private final int originEndLineNumber;

		public CharSequenceBasedTraceRegionProvider(CharSequence delegate, URI originURI,
				int originOffset, int originLength, int originLineNumber, int originEndLineNumber) {
			this.delegate = delegate;
			this.originURI = originURI;
			this.originOffset = originOffset;
			this.originLength = originLength;
			this.originLineNumber = originLineNumber;
			this.originEndLineNumber = originEndLineNumber;
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

		public AbstractTraceRegion getTraceRegion() {
			ILocationData locationData = new LocationData(originOffset, originLength, originLineNumber, originEndLineNumber, originURI);
			AbstractTraceRegion result = new TraceRegion(0, delegate.length(), 0, Strings.countLineBreaks(delegate), locationData, null);
			return result;
		}

	}
	
}
