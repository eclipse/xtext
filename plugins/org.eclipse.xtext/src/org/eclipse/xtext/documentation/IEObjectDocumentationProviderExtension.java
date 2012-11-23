/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Allows to access the nodes that contain the documentation of an {@link EObject}
 * and are considered by the {@link IEObjectDocumentationProvider}.
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
@NonNullByDefault
public interface IEObjectDocumentationProviderExtension {

	List<INode> getDocumentationNodes(EObject object);
	
//	IDocumentation getDocumentation2(EObject object);
	
}
