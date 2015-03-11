/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.stubs

import com.intellij.psi.stubs.PsiFileStub
import com.intellij.psi.stubs.PsiFileStubImpl
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.impl.BaseXtextFile

class XtextFileStub<T extends BaseXtextFile> extends PsiFileStubImpl<T> implements PsiFileStub<T> {

	@Accessors
	URI uri

	@Accessors
	List<ExportedObject> exportedObjects

	val XtextFileElementType<?> type

	new(T file, XtextFileElementType<?> type) {
		super(file)
		this.type = type
	}

	override getType() {
		this.type
	}

}
