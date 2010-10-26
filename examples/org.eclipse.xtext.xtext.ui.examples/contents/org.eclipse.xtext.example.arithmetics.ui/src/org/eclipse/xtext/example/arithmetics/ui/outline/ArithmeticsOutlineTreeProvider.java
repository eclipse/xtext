/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.outline;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

/**
 * customization of the default outline structure
 * 
 */
public class ArithmeticsOutlineTreeProvider extends DefaultOutlineTreeProvider {

	protected void _createChildren(IOutlineNode parentNode, Module module) {
		for(Definition definition : EcoreUtil2.typeSelect(module.eContents(), Definition.class)) {
			createNode(parentNode, definition);
		}
	}

	protected boolean _isLeaf(Definition definition) {
		return true;
	}
	
}
