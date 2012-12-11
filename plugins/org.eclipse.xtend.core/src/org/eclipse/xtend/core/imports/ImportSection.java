/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;

/**
 * Provides access to all imported types in an XtendFile. Namespace imports are ignored.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportSection  {
	
	private Set<JvmDeclaredType> plainImports = newLinkedHashSet();

	private Set<JvmDeclaredType> staticImports = newLinkedHashSet();

	private Set<JvmDeclaredType> staticExtensionImports = newLinkedHashSet();

	public ImportSection() {}
	
	public ImportSection(XtendFile xtendFile) {
		for (XtendImport xtendImport : xtendFile.getImports()) {
			if (xtendImport.getImportedNamespace() == null) {
				JvmType importedType = xtendImport.getImportedType();
				if (importedType instanceof JvmDeclaredType && !importedType.eIsProxy()) {
					getSet(xtendImport).add((JvmDeclaredType) importedType);
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

	protected Set<JvmDeclaredType> getSet(XtendImport xtendImport) {
		if (xtendImport.isStatic())
			if (xtendImport.isExtension())
				return staticExtensionImports;
			else
				return staticImports;
		else
			return plainImports;
	}
}
