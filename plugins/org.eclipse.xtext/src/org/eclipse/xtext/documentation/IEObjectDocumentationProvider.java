/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

import com.google.inject.ImplementedBy;

/**
 * Returns a documentation string for an EObject.
 * There exists an extension interface for the documentation provider:
 * <ul>
 * <li>{@link IEObjectDocumentationProviderExtension} allows to query the nodes that yield the documentation</li>
 * </ul>
 * 
 * @author Christoph Kulla - Initial contribution and API
 */
@ImplementedBy(MultiLineCommentDocumentationProvider.class)
public interface IEObjectDocumentationProvider {

	/**
	 * returns the documentation or <code>null</code> if no documentation is attached to the given {@link EObject}.
	 */
	public String getDocumentation (EObject o);

}
