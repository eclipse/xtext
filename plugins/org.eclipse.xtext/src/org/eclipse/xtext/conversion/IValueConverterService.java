/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IValueConverterService {

	public Object toValue(String string, String lexerRule, AbstractNode node) throws ValueConverterException;

	public String toString(Object value, String lexerRule);

}
