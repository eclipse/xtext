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
 * Production Rule
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface Production<ELEMENT, TOKEN> {

	Iterable<ELEMENT> getAlternativeChildren(ELEMENT ele);

	ELEMENT getParent(ELEMENT ele);

	Iterable<ELEMENT> getSequentialChildren(ELEMENT ele);

	TOKEN getToken(ELEMENT owner);

	Iterable<ELEMENT> getUnorderedChildren(ELEMENT ele);

	boolean isMany(ELEMENT ele);

	boolean isOptional(ELEMENT ele);

	ELEMENT getRoot();
}
