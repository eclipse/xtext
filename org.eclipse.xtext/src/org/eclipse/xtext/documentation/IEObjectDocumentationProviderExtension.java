/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.nodemodel.INode;

/**
 * <p>
 * Allows to access the nodes that contain the documentation of an {@link EObject}
 * and are considered by the {@link IEObjectDocumentationProvider}.
 * </p>
 * <p>
 * The custom documentation provider may use a list of syntax elements to compute the
 * actual documentation string, e.g. C# style documentation like this
 * <pre>
 * /// First line
 * /// second line
 * </pre>
 * would return the documentation string
 * <pre>
 * First line
 * second line
 * </pre>
 * even though both lines are single line nodes.
 * </p>
 * <p>
 * The method {@link #getDocumentationNodes(EObject)} allows to retrieve all nodes
 * that contributed text to this documentation string. The primary use case is to be
 * able to trace from the concrete source syntax to a possibly generated target file.
 * </p>
 * <p>
 * The default implementation {@link MultiLineCommentDocumentationProvider}
 * uses only a single node, the closest multi line comment for a given {@link EObject}.
 * </p>
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public interface IEObjectDocumentationProviderExtension {

	/**
	 * Returns the list of all nodes that were used to compute the
	 * {@link IEObjectDocumentationProvider#getDocumentation(EObject) documentation}
	 * for the given object.
	 * @return a list of nodes or an empty list if the documentation was synthesized
	 * or derived from an external location.
	 */
	List<INode> getDocumentationNodes(EObject object);
	
}
