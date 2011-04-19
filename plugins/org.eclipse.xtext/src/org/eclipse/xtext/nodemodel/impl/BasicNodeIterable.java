package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.util.ReversedBidiIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public class BasicNodeIterable implements BidiIterable<AbstractNode> {
	private final AbstractNode startWith;

	protected BasicNodeIterable(AbstractNode startWith) {
		this.startWith = startWith;
	}

	public BidiIterator<AbstractNode> iterator() {
		return new BasicNodeIterator(startWith);
	}
	
	public BidiIterable<AbstractNode> reverse() {
		return new BidiIterable<AbstractNode>() {

			public BidiIterator<AbstractNode> iterator() {
				BidiIterator<AbstractNode> delegate = BasicNodeIterable.this.iterator(); 
				return new ReversedBidiIterator<AbstractNode>(delegate);
			}

			public BidiIterable<AbstractNode> reverse() {
				return BasicNodeIterable.this;
			}
		};
	}
}