/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("rawtypes")
public interface INFATransition<S extends INFAState, T extends INFATransition> {
	int getPrecedence();

	S getSource();

	S getTarget();

	boolean isRuleCall();

	AbstractElement getLoopCenter();
}
