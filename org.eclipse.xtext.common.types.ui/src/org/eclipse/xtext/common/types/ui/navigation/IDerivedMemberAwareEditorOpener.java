/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.navigation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IMember;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;

/**
 * Extension to the {@link org.eclipse.xtext.ui.editor.IURIEditorOpener} that
 * is aware of an {@link IMember} which is the actual navigation target.
 * @see org.eclipse.xtext.ui.editor.IURIEditorOpener
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IDerivedMemberAwareEditorOpener extends IURIEditorOpener {

	/**
	 * Open the resource with the given {@link URI} and navigate to the element
	 * that yields the given {@code member}.
	 * @see #open(URI, boolean)
	 */
	IEditorPart open(URI uri, IMember member, boolean select);
	
}
