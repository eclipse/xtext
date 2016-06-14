/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import java.util.List;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.6
 */
public class FirstSetComputer {

	public static List<AbstractElement> getFirstSet(AbstractElement element) {
		return org.eclipse.xtext.xtext.generator.parser.antlr.FirstSetComputer.getFirstSet(element);
	}
}
