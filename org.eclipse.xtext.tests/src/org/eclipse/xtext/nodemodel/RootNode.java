/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;

class RootNode extends org.eclipse.xtext.nodemodel.impl.RootNode {
	@Override
	protected void basicSetCompleteContent(String completeContent) {
		super.basicSetCompleteContent(completeContent);
	}
	@Override
	protected AbstractNode basicGetFirstChild() {
		return super.basicGetFirstChild();
	}
}