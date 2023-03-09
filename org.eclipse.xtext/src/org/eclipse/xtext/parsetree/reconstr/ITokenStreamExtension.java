/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.ParserRule;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
public interface ITokenStreamExtension extends ITokenStream {

	void init(ParserRule startRule);

}