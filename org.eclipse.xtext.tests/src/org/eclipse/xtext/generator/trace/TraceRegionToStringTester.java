/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.eclipse.xtext.util.ITextRegion;

public class TraceRegionToStringTester extends AbstractTraceRegionToString {
	public static class Location extends LocationData {
		public Location(int offset, int length, SourceRelativeURI path) {
			super(offset, length, 0, 0, path);
		}

		public Location(int offset, int length) {
			this(offset, length, null);
		}
	}

	public static class Region extends TraceRegion {
		public Region(int myOffset, int myLength, Collection<ILocationData> allLocationData,
				AbstractTraceRegion parent) {
			super(myOffset, myLength, 0, 0, true, allLocationData, parent);
		}

		public Region(int myOffset, int myLength, Collection<ILocationData> allLocationData) {
			super(myOffset, myLength, 0, 0, true, allLocationData, null);
		}

		public TraceRegionToStringTester.Region addChild(int myOffset, int myLength,
				List<ILocationData> allLocationData) {
			return new TraceRegionToStringTester.Region(myOffset, myLength,
					allLocationData, this);
		}
	}

	private final SourceRelativeURI uri1 = new SourceRelativeURI("remote1");

	private final SourceRelativeURI uri2 = new SourceRelativeURI("remote2");

	private String localText;

	private String remote1;

	private String remote2;

	private ITextRegion localFrame;

	private TraceRegionToStringTester.Region trace;

	public TraceRegionToStringTester() {
		setShowLegend(false);
	}

	@Override
	protected String getRemoteText(SourceRelativeURI uri) {
		if (Objects.equals(uri, uri1)) {
			return remote1;
		}
		if (Objects.equals(uri, uri2)) {
			return remote2;
		}
		return null;
	}

	@Override
	protected String getLocalTitle() {
		return "local1";
	}

	public SourceRelativeURI getUri1() {
		return uri1;
	}

	public SourceRelativeURI getUri2() {
		return uri2;
	}

	@Override
	public String getLocalText() {
		return localText;
	}

	public void setLocalText(String localText) {
		this.localText = localText;
	}

	public String getRemote1() {
		return remote1;
	}

	public void setRemote1(String remote1) {
		this.remote1 = remote1;
	}

	public String getRemote2() {
		return remote2;
	}

	public void setRemote2(String remote2) {
		this.remote2 = remote2;
	}

	@Override
	public ITextRegion getLocalFrame() {
		return localFrame;
	}

	public void setLocalFrame(ITextRegion localFrame) {
		this.localFrame = localFrame;
	}

	@Override
	public TraceRegionToStringTester.Region getTrace() {
		return trace;
	}

	public void setTrace(TraceRegionToStringTester.Region trace) {
		this.trace = trace;
	}
}
