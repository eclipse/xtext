/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy;

import org.eclipse.xtext.ide.editor.navigation.INavigatable;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * Represents a reference between parent and child nodes. Each reference is backed up with a region and a text. 
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public interface IHierarchyNodeReference extends INavigatable, ITextRegionWithLineInformation {
	String getText();
}
