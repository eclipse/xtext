/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class XtendUIValidator extends XbaseUIValidator {

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> packages = super.getEPackages();
		packages.add(XtendPackage.eINSTANCE);
		return packages;
	}

	@Check
	public void checkRestrictedType(XtendImport xtendImport){
		JvmType importedType = xtendImport.getImportedType();
		if(importedType instanceof JvmDeclaredType)
			checkRestrictedType(xtendImport, XtendPackage.Literals.XTEND_IMPORT__IMPORTED_TYPE, (JvmDeclaredType) importedType);
	}
}
