/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.transformer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;
import org.eclipse.xtext.util.concurrent.IStateAccess;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface ISemanticModelTransformer {

	IContentOutlineNode transformSemanticModel(EObject semanticModel);

	void setResourceAccess(IStateAccess<XtextResource> document);

}