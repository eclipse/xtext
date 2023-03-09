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
public interface ProductionFactory<ELEMENT, TOKEN> {

	ELEMENT createForAlternativeChildren(boolean many, boolean optional, Iterable<ELEMENT> children);

	ELEMENT createForSequentialChildren(boolean many, boolean optional, Iterable<ELEMENT> children);

	ELEMENT createForToken(boolean many, boolean optional, TOKEN token);

	ELEMENT createForUnordertedChildren(boolean many, boolean optional, Iterable<ELEMENT> children);
}
