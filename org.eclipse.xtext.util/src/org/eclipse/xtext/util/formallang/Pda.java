/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

/**
 * Push-Down Automation
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface Pda<STATE, STACKITEM> extends Nfa<STATE> {
	STACKITEM getPop(STATE state);

	STACKITEM getPush(STATE state);
}
