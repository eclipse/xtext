/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.navigation;

/**
 * Represents an instance that can be opened in an editor.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public interface INavigatable {
	/**
	 * <p>
	 * Returns an instance containing enough information to identify an editor that should be opened and a region that
	 * should be revealed.
	 * </p>
	 * <p>
	 * Typical navigation elements are resource, object and reference descriptions.
	 * </p>
	 * <p>
	 * Avoid usage of resource sets, resources and eobjects as navigation elements, since it can lead to memory leaks.
	 * </p>
	 */
	Object getNavigationElement();
}
