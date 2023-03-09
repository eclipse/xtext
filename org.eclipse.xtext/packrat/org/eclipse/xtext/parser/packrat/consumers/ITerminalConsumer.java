/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITerminalConsumer {

	/**
	 * Scan the configured input source for a consumable terminal at the current offset.
	 * If it can be found, create a configured parsed token and increase the offset of the input.
	 */
	int consume(String feature, boolean isMany, boolean isBoolean, AbstractElement element, ISequenceMatcher notMatching, boolean optional);

	/**
	 * Scan the configured input source for a consumable terminal at the current offset.
	 * If it can be found, do nothing but increase the offset of the input.
	 */
	int consume();

	/**
	 * Scan the configured input source for a consumable terminal at the current offset.
	 * If it can be found, do nothing but increase the offset of the input.
	 */
	int consume(ISequenceMatcher notMatching);

	void setHidden(boolean hidden);

	boolean isHidden();

}