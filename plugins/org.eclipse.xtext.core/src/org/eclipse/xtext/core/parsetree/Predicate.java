package org.eclipse.xtext.core.parsetree;

import org.eclipse.xtext.core.parsetree.AbstractParseTreeUpdater.InstanceDescription;


public abstract class Predicate {

	protected InstanceDescription obj;

	public Predicate(InstanceDescription obj) {
		this.obj = obj.newLookaheadDescription();
	}

	public abstract boolean check();

}
