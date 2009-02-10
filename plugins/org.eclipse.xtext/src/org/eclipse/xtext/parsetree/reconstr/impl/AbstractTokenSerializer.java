/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractTokenSerializer implements ITokenSerializer {

	public void serialize(IAbstractToken firstToken, OutputStream out) throws IOException {

	}

}
