/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.internal.DiagnosticProducer;
import org.eclipse.xtext.crossref.internal.Linker;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinker extends Linker {

	protected void setDefaultValue(EObject obj, EReference ref, DiagnosticProducer producer) {
		if ((obj instanceof TypeRef) && (XtextPackage.TYPE_REF__METAMODEL == ref.getFeatureID())) {
			final TypeRef typeRef = (TypeRef) obj;
			final Grammar grammar = GrammarUtil.getGrammar(typeRef);
			final AbstractMetamodelDeclaration defaultMetaModel = GrammarUtil.findDefaultMetaModel(grammar, false);
			if (defaultMetaModel != null)
				typeRef.setMetamodel(defaultMetaModel);
			else
				producer.addDiagnostic("No default meta model is defined. Use qualified types.");
		}
		else {
			super.setDefaultValue(obj, ref, producer);
		}
	}

}
