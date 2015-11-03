/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.intellij.openapi.editor.Editor
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel
import org.eclipse.xtext.psi.impl.BaseXtextFile

class XtendFileTreeModel extends XtextFileTreeModel {

	new(BaseXtextFile xtextFile, Editor editor) {
		super(xtextFile, editor)
	//	filters += new SyntheticMemberFilter
		nodeProviders += new XtendShowInheritedNodeProvider
	}

	override getComparator() {
		new XtendTreeElementComparator
	}

}