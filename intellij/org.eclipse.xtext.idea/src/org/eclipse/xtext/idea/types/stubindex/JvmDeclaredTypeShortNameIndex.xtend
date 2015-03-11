/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.types.stubindex

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import org.eclipse.xtext.psi.impl.BaseXtextFile

class JvmDeclaredTypeShortNameIndex extends StringStubIndexExtension<BaseXtextFile> {
	
	public static StubIndexKey<String, BaseXtextFile> KEY = StubIndexKey.<String, BaseXtextFile>createIndexKey("JvmDeclaredTypeShortNameIndex");
	
	override getKey() {
		KEY
	}

}