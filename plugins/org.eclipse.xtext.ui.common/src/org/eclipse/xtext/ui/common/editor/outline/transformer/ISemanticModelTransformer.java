/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.transformer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.filter.IOutlineFilter;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface ISemanticModelTransformer {

	ContentOutlineNode transformSemanticModel(EObject semanticModel);

	void setSorted(boolean on);

	void enableFilter(IOutlineFilter filterSpec);

	void disableFilter(IOutlineFilter filterSpec);

	void setDocument(XtextDocument document);

}