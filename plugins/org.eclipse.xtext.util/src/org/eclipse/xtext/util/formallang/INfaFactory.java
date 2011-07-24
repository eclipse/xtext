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
public interface INfaFactory<STATE, ITERABLE extends Iterable<? extends STATE>, TOKEN> {

	INfaAdapter<STATE, ITERABLE> createNfa(Iterable<STATE> startStates, Iterable<STATE> stopStates);

	STATE createEndState(TOKEN token);

	STATE createStartState(TOKEN token);

	STATE createState(TOKEN token);

	void setFollowers(STATE owner, Iterable<STATE> followers);
}
