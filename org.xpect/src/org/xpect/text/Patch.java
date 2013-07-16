package org.xpect.text;

import java.util.Collection;

/**
 * 
 * @author Moritz Eysholdt
 */
public class Patch implements IPatch {

	private final Collection<IChange> changes;

	public Patch(Collection<IChange> changes) {
		super();
		this.changes = changes;
	}

	public Collection<IChange> getChanges() {
		return changes;
	}

}
