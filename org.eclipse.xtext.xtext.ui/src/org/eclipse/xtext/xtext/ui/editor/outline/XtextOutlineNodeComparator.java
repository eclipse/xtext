/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtextOutlineNodeComparator extends SortOutlineContribution.DefaultComparator {
	@Override
	public int getCategory(IOutlineNode node) {
		if (node instanceof EObjectNode
				&& ((EObjectNode) node).getEClass().getEAllSuperTypes().contains(XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION))
			return -10;
		return 0;
	}

}
