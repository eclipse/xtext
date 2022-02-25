/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.parser.packrat.consumers;

import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;


public final class TerminalsANY_OTHERConsumer extends AbstractRuleAwareTerminalConsumer {

	public TerminalsANY_OTHERConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected int doConsume() {
		return consumeWildcard$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeWildcard$1() {
		return readAnyChar();
	}
	
}
