package org.eclipse.xtext.generator.trace.internal;

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
