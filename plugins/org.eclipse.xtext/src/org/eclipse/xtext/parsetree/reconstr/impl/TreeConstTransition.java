package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;

public class TreeConstTransition extends
		AbstractNFATransition<TreeConstState, TreeConstTransition> {

	public TreeConstTransition(TreeConstState source, TreeConstState target, boolean ruleCall) {
		super(source, target, ruleCall);
	}

}
