/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.internal;

import org.eclipse.xtext.generator.trace.SourceRelativeURI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class LocationInResource extends AbstractLocationInResource {

	private final SourceRelativeURI srcRelativeResourceURI;
	private final int offset;
	private final int length;
	private final int lineNumber;
	private final int endLineNumber;

	public LocationInResource(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI srcRelativeResourceURI, AbstractTrace trace) {
		super(trace);
		this.offset = offset;
		this.length = length;
		this.lineNumber = lineNumber;
		this.endLineNumber = endLineNumber;
		this.srcRelativeResourceURI = srcRelativeResourceURI;
	}
	
	@Override
	public SourceRelativeURI getSrcRelativeResourceURI() {
		return srcRelativeResourceURI;
	}

	@Override
	protected int getOffset() {
		return offset;
	}

	@Override
	protected int getLength() {
		return length;
	}

	@Override
	protected int getLineNumber() {
		return lineNumber;
	}

	@Override
	protected int getEndLineNumber() {
		return endLineNumber;
	}

}
