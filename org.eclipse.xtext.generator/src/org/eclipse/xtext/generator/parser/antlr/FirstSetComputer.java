/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.util.List;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.6
 */
@Deprecated(forRemoval = true)
public class FirstSetComputer {

	public static List<AbstractElement> getFirstSet(AbstractElement element) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.FirstSetComputer.getFirstSet(element);
	}
}
