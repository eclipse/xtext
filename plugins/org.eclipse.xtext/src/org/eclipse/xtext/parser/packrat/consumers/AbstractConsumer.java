/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractConsumer {

	protected final IParsedTokenAcceptor acceptor;
	protected final ICharSequenceWithOffset input;
	protected final RecoveryStateHolder recoveryStateHolder;

	protected AbstractConsumer(ICharSequenceWithOffset input, IParsedTokenAcceptor tokenAcceptor,
			RecoveryStateHolder recoveryStateHolder) {
		this.input = input;
		this.acceptor = tokenAcceptor;
		this.recoveryStateHolder = recoveryStateHolder;
	}

	protected final int getOffset() {
		return input.getOffset();
	}

	public void announceLevelFinished() {
		recoveryStateHolder.announceLevelFinished();
	}

	public void announceNextLevel() {
		recoveryStateHolder.announceNextLevel();
	}

	public void announceNextPath() {
		recoveryStateHolder.announceNextPath();
	}

	public void announceNextStep() {
		recoveryStateHolder.announceNextStep();
	}

}