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
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface NfaFactory<P extends Nfa<STATE>, STATE, TOKEN> {

	P create(TOKEN start, TOKEN stop);

	STATE createState(P nfa, TOKEN token);

	void setFollowers(P nfa, STATE owner, Iterable<STATE> followers);
}
