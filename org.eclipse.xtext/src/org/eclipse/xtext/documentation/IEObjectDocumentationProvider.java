/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
