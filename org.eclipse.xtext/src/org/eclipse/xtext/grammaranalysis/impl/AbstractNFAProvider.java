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
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractNFAProvider<S, T> implements
		IGrammarNFAProvider<S, T> {

	protected NFABuilder<S, T> builder = createBuilder();

	protected abstract NFABuilder<S, T> createBuilder();

	@Override
	public S getNFA(AbstractElement element) {
		return builder.getState(element);
	}
}
