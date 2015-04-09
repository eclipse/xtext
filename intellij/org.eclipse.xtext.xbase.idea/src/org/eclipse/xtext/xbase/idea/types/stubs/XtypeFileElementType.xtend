/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.stubs

import com.google.inject.Inject
import com.intellij.lang.Language
import com.intellij.psi.stubs.IndexSink
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.psi.stubs.ExportedObject
import org.eclipse.xtext.psi.stubs.XtextFileElementType
import org.eclipse.xtext.psi.stubs.XtextFileStub

/**
 * @author kosyakov - Initial contribution and API
 */
class XtypeFileElementType<T extends XtextFileStub<?>> extends XtextFileElementType<T> {

	@Inject
	JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex

	new(Language language) {
		super(language)
	}

	override protected indexExportedObject(ExportedObject exportedObject, extension IndexSink sink) {
		super.indexExportedObject(exportedObject, sink)
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_DECLARED_TYPE, exportedObject.EClass)) {
			jvmDeclaredTypeShortNameIndex.key.occurrence(exportedObject.qualifiedName.lastSegment)
		}
	}

}