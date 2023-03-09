/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLocationInFileProvider extends DefaultLocationInFileProvider {

	@Override
	protected boolean useKeyword(Keyword keyword, EObject context) {
		String value = keyword.getValue();
		return value.matches("\\w+");
	}
	
	@Override
	protected EStructuralFeature getIdentifierFeature(EObject obj) {
		if (obj instanceof AbstractMetamodelDeclaration) {
			AbstractMetamodelDeclaration decl = (AbstractMetamodelDeclaration) obj;
			if (decl.getAlias() != null)
				return XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__ALIAS;
			if (decl instanceof GeneratedMetamodel && ((GeneratedMetamodel) decl).getName() != null)
				return XtextPackage.Literals.GENERATED_METAMODEL__NAME;
			return XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE;
		}
		return super.getIdentifierFeature(obj);
	}

}
