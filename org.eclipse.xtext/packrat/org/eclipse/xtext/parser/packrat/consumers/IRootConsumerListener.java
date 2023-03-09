/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IRootConsumerListener {

	void afterNonTerminalBegin(INonTerminalConsumer nonTerminalConsumer, INonTerminalConsumerConfiguration configuration);
	void beforeNonTerminalEnd(INonTerminalConsumer nonTerminalConsumer, int result, INonTerminalConsumerConfiguration configuration);
	void handleException(NonTerminalConsumer nonTerminalConsumer, Exception e, INonTerminalConsumerConfiguration configuration);

}
