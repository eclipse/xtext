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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface INonTerminalConsumer {

	void consumeAsRoot(IRootConsumerListener listener);

	int consume(String feature, boolean isMany, boolean isDatatype, boolean isBoolean, AbstractElement element, boolean optional) throws Exception;

	boolean isDefiningHiddens();

}