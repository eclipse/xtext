package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.util.Strings;

public class CharSequenceBasedTraceRegionProvider implements ITraceRegionProvider, CharSequence {

	private final CharSequence delegate;

	public CharSequenceBasedTraceRegionProvider(CharSequence delegate) {
		this.delegate = delegate;
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
		int lines = Strings.countLineBreaks(delegate);
		URI uri = URI.createURI("file:/tmp");
		ILocationData locationData = new LocationData(0, delegate.length(), 0, lines, uri, "foo");
		AbstractTraceRegion result = new TraceRegion(0, delegate.length(), 0, lines, locationData, null);
		return result;
	}

}
