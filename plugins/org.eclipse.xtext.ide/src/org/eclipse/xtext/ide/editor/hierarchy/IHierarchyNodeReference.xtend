/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import org.eclipse.xtext.ide.editor.navigation.INavigatable
import org.eclipse.xtext.util.ITextRegionWithLineInformation

/**
 * Represents a reference between parent and child nodes. Each reference is backed up with a region and a text. 
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
interface IHierarchyNodeReference extends INavigatable, ITextRegionWithLineInformation {
	def String getText()
}
