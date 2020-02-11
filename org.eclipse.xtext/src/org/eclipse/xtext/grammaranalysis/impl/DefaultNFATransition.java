/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultNFATransition extends AbstractNFATransition<DefaultNFAState, DefaultNFATransition> {

	public DefaultNFATransition(DefaultNFAState source, DefaultNFAState target, boolean ruleCall,
			AbstractElement loopCenter) {
		super(source, target, ruleCall, loopCenter);
	}
}