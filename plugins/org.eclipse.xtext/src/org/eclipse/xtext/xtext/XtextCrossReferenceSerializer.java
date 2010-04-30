/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;
import org.eclipse.xtext.util.SimpleAttributeResolver;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextCrossReferenceSerializer extends CrossReferenceSerializer {

	private final SimpleAttributeResolver<EObject, String> aliasResolver;

	public XtextCrossReferenceSerializer() {
		super();
		aliasResolver = SimpleAttributeResolver.newResolver(String.class, "alias");
	}

	@Override
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		if (reference == XtextPackage.eINSTANCE.getGrammar_UsedGrammars())
			return ((Grammar) object).getName();
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Metamodel())
			return aliasResolver.getValue(object);
		if (reference == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage())
			return ((EPackage) object).getNsURI();
		if (object instanceof AbstractRule)
			return ((AbstractRule) object).getName();
		return super.getUnconvertedLinkText(object, reference, context);
	}
}
