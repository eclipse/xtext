/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.ITextRegionWithLineInformation

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors
@FinalFieldsConstructor
class DefaultHierarchyNodeReference implements IHierarchyNodeReference {
	val String text
	@Delegate
	val ITextRegionWithLineInformation textRegion
	val Object navigationElement
}
