/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

/**
 * Customization of the default outline structure.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
public class RuleEngineOutlineTreeProvider extends DefaultOutlineTreeProvider {
	@Override
	public void _createChildren(IOutlineNode parentNode, EObject modelElement) {
		if (!(modelElement instanceof Rule)) {
			super._createChildren(parentNode, modelElement);
		}
	}

	@Override
	public boolean _isLeaf(EObject modelElement) {
		if (modelElement instanceof Rule) {
			return true;
		} else {
			return super._isLeaf(modelElement);
		}
	}
}
