/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class DefaultHierarchyRoot implements IHierarchyRoot {
	private final List<IHierarchyNode> roots = new ArrayList<>();

	public List<IHierarchyNode> getRoots() {
		return roots;
	}
}
