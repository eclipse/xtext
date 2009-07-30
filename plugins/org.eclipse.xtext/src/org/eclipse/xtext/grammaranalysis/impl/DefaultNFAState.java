/**
 * 
 */
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;

public class DefaultNFAState extends
		AbstractNFAState<DefaultNFAState, DefaultNFATransition> {

	public DefaultNFAState(AbstractElement element,
			NFABuilder<DefaultNFAState, DefaultNFATransition> builder) {
		super(element, builder);
	}
}