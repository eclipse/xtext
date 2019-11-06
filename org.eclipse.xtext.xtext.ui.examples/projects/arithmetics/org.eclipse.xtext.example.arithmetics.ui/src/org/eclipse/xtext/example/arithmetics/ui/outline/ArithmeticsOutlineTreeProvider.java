/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.outline;

import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

import com.google.common.collect.Iterables;

/**
 * Customization of the default outline structure.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
public class ArithmeticsOutlineTreeProvider extends DefaultOutlineTreeProvider {

	public void _createChildren(IOutlineNode parentNode,
			org.eclipse.xtext.example.arithmetics.arithmetics.Module module) {
		Iterables.filter(module.eContents(), Definition.class).forEach((d) -> createNode(parentNode, d));
	}

	public boolean _isLeaf(Definition definition) {
		return true;
	}
}
