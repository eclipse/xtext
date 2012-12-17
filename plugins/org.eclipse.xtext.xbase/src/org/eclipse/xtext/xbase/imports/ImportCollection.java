/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * Provides access to all imported types in an XtendFile. Namespace imports are ignored.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportCollection {

	private Set<JvmDeclaredType> plainImports = newLinkedHashSet();

	private Set<JvmDeclaredType> staticImports = newLinkedHashSet();

	private Set<JvmDeclaredType> staticExtensionImports = newLinkedHashSet();

	public ImportCollection() {
	}

	public ImportCollection(XImportSection section) {
		if (section != null) {
			for (XImportDeclaration importDeclaration : section.getImportDeclarations()) {
				JvmType importedType = importDeclaration.getImportedType();
				if (importedType instanceof JvmDeclaredType && !importedType.eIsProxy()) {
					getSet(importDeclaration).add((JvmDeclaredType) importedType);
				}
			}
		}
	}

	public Set<JvmDeclaredType> getImportedTypes() {
		return plainImports;
	}

	public Set<JvmDeclaredType> getStaticImports() {
		return staticImports;
	}

	public Set<JvmDeclaredType> getExtensionImports() {
		return staticExtensionImports;
	}

	protected Set<JvmDeclaredType> getSet(XImportDeclaration importDeclaration) {
		if (importDeclaration.isStatic())
			if (importDeclaration.isExtension())
				return staticExtensionImports;
			else
				return staticImports;
		else
			return plainImports;
	}
}
