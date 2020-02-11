/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextCrossReferenceSerializer extends CrossReferenceSerializer {

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if (reference == XtextPackage.eINSTANCE.getGrammar_UsedGrammars())
			return ((Grammar) object).getName();
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Metamodel()) {
			AbstractMetamodelDeclaration casted = (AbstractMetamodelDeclaration) object;
			return casted.getAlias();
		}
		if (reference == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage())
			return ((EPackage) object).getNsURI();
		if (object instanceof AbstractRule) {
			if (reference == XtextPackage.eINSTANCE.getRuleCall_Rule()) {
				if (((RuleCall)context).isExplicitlyCalled()) {
					return super.getUnconvertedLinkText(object, reference, context);
				}
			}
			return ((AbstractRule) object).getName();
		}
		return super.getUnconvertedLinkText(object, reference, context);
	}
}
