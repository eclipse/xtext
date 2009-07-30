/**
 * 
 */
package org.eclipse.xtext.grammaranalysis.impl;


public class DefaultNFATransition extends
		AbstractNFATransition<DefaultNFAState, DefaultNFATransition> {

	public DefaultNFATransition(DefaultNFAState source, DefaultNFAState target,
			boolean ruleCall) {
		super(source, target, ruleCall);
	}
}