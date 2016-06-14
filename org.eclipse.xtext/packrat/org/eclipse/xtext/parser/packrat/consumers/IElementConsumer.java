/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IElementConsumer {

	/**
	 * Scan the configured input source for a consumable element at the current offset.
	 */
	int consume() throws Exception;

}
