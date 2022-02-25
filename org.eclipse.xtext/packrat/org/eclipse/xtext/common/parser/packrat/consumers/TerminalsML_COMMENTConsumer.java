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


public final class TerminalsML_COMMENTConsumer extends AbstractRuleAwareTerminalConsumer {

	public TerminalsML_COMMENTConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected int doConsume() {
		return consumeGroup$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeGroup$1() {
		final int marker = mark();
		if (!consumeKeyword$2()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeUntilToken$3()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() {
		return readString("/*");
	}

	protected boolean consumeUntilToken$3() {
		final int marker = mark();
		while(!eof()) {
			if(consumeKeyword$4())
				return true;
			incOffset();
		}
		rollbackTo(marker);
		return false;
	}

	protected boolean consumeKeyword$4() {
		return readString("*/");
	}
	
}
