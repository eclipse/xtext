/*******************************************************************************
 * Copyright (c) 2020 Robert Lewis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;

/**
 * @author Robert Lewis - Initial contribution and API
 */
public class BasicNodeIterator extends org.eclipse.xtext.nodemodel.impl.BasicNodeIterator {

	public BasicNodeIterator(AbstractNode startWith) {
		super(startWith);
	}
}
