/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CharSequenceTraceWrapper {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject
	private IProjectConfigProvider projectConfigProvider;
	
	public CharSequence wrapWithTraceData(CharSequence sequence, EObject origin) {
		ITextRegionWithLineInformation location = (ITextRegionWithLineInformation) locationInFileProvider.getSignificantTextRegion(origin);
		AbsoluteURI absoluteURI = new AbsoluteURI(origin.eResource().getURI());
		IProjectConfig projectConfig = projectConfigProvider.getProjectConfig(EcoreUtil2.getResourceSet(origin));
		SourceRelativeURI sourceRelativeURI = absoluteURI.deresolve(projectConfig);
		return wrapWithTraceData(sequence, sourceRelativeURI, location.getOffset(), location.getLength(), location.getLineNumber(), location.getEndLineNumber());
	}
	
	public CharSequence wrapWithTraceData(CharSequence sequence, SourceRelativeURI originResourceURI, int originOffset, int originLength, int originLineNumber, int originEndLineNumber) {
		return wrapWithTraceData(sequence, originResourceURI, originResourceURI.getURI().segment(1), originOffset, originLength, originLineNumber, originEndLineNumber);
	}
	
	public CharSequence wrapWithTraceData(CharSequence sequence, SourceRelativeURI originURI, String originProject, int originOffset, int originLength, int originLineNumber, int originEndLineNumber) {
		return new CharSequenceBasedTraceRegionProvider(sequence, originURI, originOffset, originLength, originLineNumber, originEndLineNumber);
	}
	
	protected static class CharSequenceBasedTraceRegionProvider implements ITraceRegionProvider, CharSequence {

		private final CharSequence delegate;
		private final SourceRelativeURI originURI;
		private final int originOffset;
		private final int originLength;
		private final int originLineNumber;
		private final int originEndLineNumber;

		public CharSequenceBasedTraceRegionProvider(CharSequence delegate, SourceRelativeURI originURI,
				int originOffset, int originLength, int originLineNumber, int originEndLineNumber) {
			this.delegate = delegate;
			this.originURI = originURI;
			this.originOffset = originOffset;
			this.originLength = originLength;
			this.originLineNumber = originLineNumber;
			this.originEndLineNumber = originEndLineNumber;
		}

		@Override
		public int length() {
			return delegate.length();
		}

		@Override
		public char charAt(int index) {
			return delegate.charAt(index);
		}

		@Override
		public CharSequence subSequence(int start, int end) {
			return delegate.subSequence(start, end);
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		@Override
		public AbstractTraceRegion getTraceRegion() {
			ILocationData locationData = new LocationData(originOffset, originLength, originLineNumber, originEndLineNumber, originURI);
			AbstractTraceRegion result = new TraceRegion(0, delegate.length(), 0, Strings.countLineBreaks(delegate), true, locationData, null);
			return result;
		}

	}
	
}
