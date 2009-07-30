package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;

public class TreeConstState extends AbstractNFAState<TreeConstState, TreeConstTransition> {

	public TreeConstState(AbstractElement element,
			NFABuilder<TreeConstState, TreeConstTransition> builder) {
		super(element, builder);
	}

}
