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
public interface ISequenceAcceptor extends ISyntacticSequenceAcceptor {
	void acceptComment(AbstractRule rule, String token, ILeafNode node);

	void acceptWhitespace(AbstractRule rule, String token, ILeafNode node);
}
