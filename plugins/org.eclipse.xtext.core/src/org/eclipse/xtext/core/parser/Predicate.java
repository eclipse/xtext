package org.eclipse.xtext.core.parser;

import org.eclipse.xtext.core.parser.AbstractParseTreeRewriter.InstanceDescription;


public abstract class Predicate {

	protected InstanceDescription obj;

	public Predicate(InstanceDescription obj) {
		this.obj = obj.newLookaheadDescription();
	}

	public abstract boolean check();
	
	

}
