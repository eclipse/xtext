/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendOutlinePage extends OutlinePage {

	@Override
	protected List<IOutlineNode> getInitiallyExpandedNodes() {
		IOutlineNode rootNode = getTreeProvider().createRoot(getXtextDocument());
		List<IOutlineNode> result = newArrayList(rootNode);
		for(IOutlineNode firstLevelNode: rootNode.getChildren()) 
			if(firstLevelNode instanceof EObjectNode) 
				result.add(firstLevelNode);
		return result;
	}
}
