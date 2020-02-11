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
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultNFAState extends
		AbstractNFAState<DefaultNFAState, DefaultNFATransition> {

	public DefaultNFAState(AbstractElement element,
			NFABuilder<DefaultNFAState, DefaultNFATransition> builder) {
		super(element, builder);
	}
}