/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.internal.AbstractDecoratingDiagnosticProducer;
import org.eclipse.xtext.crossref.internal.DiagnosticProducer;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.resource.XtextResource.Diagnostic;
import org.eclipse.xtext.resource.metamodel.Xtext2EcoreTransformer;
import org.eclipse.xtext.service.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinker extends Linker {

	@Inject
	private IScopeProvider scopeProvider;
	
	@Override
	protected DiagnosticProducer decorateDiagnosticProducer(final DiagnosticProducer producer) {
		return new AbstractDecoratingDiagnosticProducer(super.decorateDiagnosticProducer(producer)) {
			private boolean filter = false;

			public void addDefaultDiagnostic() {
				if (!filter)
					super.addDefaultDiagnostic();
			}

			public void addDiagnostic(String message) {
				if (!filter)
					super.addDiagnostic(message);
			}

			public void setTarget(EObject object, EStructuralFeature feature) {
				super.setTarget(object, feature);
				// we don't want to mark generated types as errors unless generation fails
				filter = feature == XtextPackage.eINSTANCE.getTypeRef_Type() &&
					((TypeRef) object).getMetamodel() instanceof GeneratedMetamodel;
			}

		};
	}

	protected void setDefaultValueImpl(EObject obj, EReference ref, DiagnosticProducer producer) {
		if (XtextPackage.eINSTANCE.getTypeRef_Metamodel() == ref) {
			final TypeRef typeRef = (TypeRef) obj;
			final String typeRefName = GrammarUtil.getTypeRefName(typeRef);
			final List<EObject> metamodels = XtextMetamodelReferenceHelper.findBestMetamodelForType(
					typeRef, "", typeRefName, scopeProvider.getScope(typeRef, ref));
			if (metamodels.isEmpty() || metamodels.size() > 1)
				producer.addDiagnostic("Cannot find meta model for type '" + typeRefName + "'");
			else
				typeRef.setMetamodel((AbstractMetamodelDeclaration) metamodels.get(0));
		} else {
			super.setDefaultValueImpl(obj, ref, producer);
		}
	}

	@Override
	protected void beforeEnsureIsLinked(EObject obj, EReference ref, DiagnosticProducer producer) {
		if (XtextPackage.eINSTANCE.getTypeRef_Type() == ref) {
			final TypeRef typeRef = (TypeRef) obj;
			if (typeRef.getMetamodel() == null)
				setDefaultValue(obj, XtextPackage.eINSTANCE.getTypeRef_Metamodel(), producer);
		} else
			super.beforeEnsureIsLinked(obj, ref, producer);
	}

	@Override
	public List<Diagnostic> linkModel(EObject model) {
		List<Diagnostic> result = super.linkModel(model);
		// TODO: fill results from metamodel transformation
		// transformer should use diagnostics producer
		if (result.isEmpty() && model.eResource().getErrors().isEmpty()) {
			Grammar grammar = (Grammar) model;
			Xtext2EcoreTransformer.doTransform(grammar);
		}
		return result;
	}
	
	
	

}
