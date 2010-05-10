/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import java.io.IOException;

import org.eclipse.xtext.formatting.impl.NodeModelStreamer;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.util.TextLocation;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(NodeModelStreamer.class)
public interface INodeModelStreamer {
	TextLocation feedTokenStream(ITokenStream out, CompositeNode in, int offset, int length) throws IOException;
}
