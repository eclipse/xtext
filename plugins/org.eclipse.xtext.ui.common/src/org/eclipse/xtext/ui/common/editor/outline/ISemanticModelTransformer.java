/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface ISemanticModelTransformer {

	ContentOutlineNode transformSemanticModel(EObject semanticModel);

	//TODO SE: this is never used, is it necessary?
//	void transformSemanticNode(EObject semanticNode, ContentOutlineNode outlineParentNode);

	void setSorted(boolean on);

	void enableFilter(IOutlineFilter filterSpec);

	void disableFilter(IOutlineFilter filterSpec);

}