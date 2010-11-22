package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BasicNodeIterable implements BidiIterable<AbstractNode> {
	private final AbstractNode startWith;

	protected BasicNodeIterable(AbstractNode startWith) {
		this.startWith = startWith;
	}

	public BidiIterator<AbstractNode> iterator() {
		return new BasicNodeIterator(startWith);
	}
}