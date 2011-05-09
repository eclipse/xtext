/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IHiddenTokenAcceptor extends IUnassignedTokenSequenceAcceptor {

	public abstract class HiddenTokensDelegator extends UnassignedTokenDelegator implements IHiddenTokenAcceptor {

		public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
			delegate().acceptComment(rule, token, node);
		}

		public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
			delegate().acceptWhitespace(rule, token, node);
		}

		@Override
		protected abstract IHiddenTokenAcceptor delegate();
	}

	void acceptComment(AbstractRule rule, String token, ILeafNode node);

	void acceptWhitespace(AbstractRule rule, String token, ILeafNode node);
}
