/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface NfaFactory<NFA extends Nfa<STATE>, STATE, TOKEN> {

	NFA create(TOKEN start, TOKEN stop);

	STATE createState(NFA nfa, TOKEN token);

	void setFollowers(NFA nfa, STATE owner, Iterable<STATE> followers);
}
