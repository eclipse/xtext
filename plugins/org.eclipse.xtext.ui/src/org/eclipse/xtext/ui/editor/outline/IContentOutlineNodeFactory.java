/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IStateAccess;

import com.google.inject.ImplementedBy;

/**
 * @author Michael Clay - Initial contribution and API
 */
@ImplementedBy(DefaultContentOutlineNodeFactory.class)
public interface IContentOutlineNodeFactory {

	ContentOutlineNode create(IStateAccess<XtextResource> resourceAccess, EObject semanticNode, ContentOutlineNode outlineParentNode);

}
