/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorInput;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(JavaClassPathResourceForIEditorInputFactory.class)
public interface IResourceForEditorInputFactory {
	Resource createResource(IEditorInput input);
}
