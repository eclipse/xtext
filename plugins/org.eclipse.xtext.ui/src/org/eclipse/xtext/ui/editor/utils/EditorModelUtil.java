/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.utils;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class EditorModelUtil {
	public static AbstractNode findLeafNodeAtOffset(AbstractNode parseTreeRootNode, int offset) {
		for (TreeIterator<EObject> treeIter = parseTreeRootNode.eAllContents(); treeIter.hasNext();) {
			EObject eO = treeIter.next();
			if (eO instanceof AbstractNode) {
				AbstractNode ln = (AbstractNode) eO;
				if (ln.getOffset() + ln.length() >= offset) {
					if (ln.getOffset() <= offset) {
						if (ln instanceof LeafNode)
							return ln;
						else
							return findLeafNodeAtOffset(ln, offset);
					}
				}
			}
		}
		return null;
	}

}
