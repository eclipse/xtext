/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class LocationInResource extends AbstractLocationInResource {

	private final URI srcRelativeResourceURI;
	private final int offset;
	private final int length;
	private final int lineNumber;
	private final int endLineNumber;

	public LocationInResource(int offset, int length, int lineNumber, int endLineNumber, URI srcRelativeResourceURI, AbstractTrace trace) {
		super(trace);
		this.offset = offset;
		this.length = length;
		this.lineNumber = lineNumber;
		this.endLineNumber = endLineNumber;
		this.srcRelativeResourceURI = srcRelativeResourceURI;
	}
	
	@Override
	/* @Nullable */
	public URI getSrcRelativeResourceURI() {
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
