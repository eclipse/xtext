/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class DefaultCallHierarchyViewPart extends AbstractCallHierarchyViewPart {

	@Inject
	private HierarchyLabelProvider hierarchyLabelProvider;

	@Inject
	private LocationTableLabelProvider locationLabelProvider;

	@Override
	protected IBaseLabelProvider createHierarchyLabelProvider() {
		return new DelegatingStyledCellLabelProvider(hierarchyLabelProvider);
	}

	@Override
	protected IBaseLabelProvider createLocationLabelProvider() {
		return locationLabelProvider;
	}
}
