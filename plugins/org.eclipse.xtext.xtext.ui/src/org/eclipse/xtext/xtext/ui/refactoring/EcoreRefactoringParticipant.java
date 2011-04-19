/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class EcoreRefactoringParticipant extends AbstractProcessorBasedRenameParticipant {

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Override
	protected List<IRenameElementContext> createRenameElementContexts(IRenameElementContext triggeringContext) {
		if (triggeringContext.getTargetElementEClass() == XtextPackage.Literals.PARSER_RULE)
			return super.createRenameElementContexts(triggeringContext);
		else
			return null;
	}

	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {
		if (originalTarget instanceof ParserRule) {
			TypeRef returnType = ((ParserRule) originalTarget).getType();
			if (returnType != null && returnType.getMetamodel() != null && returnType.getClassifier() != null
					&& !Strings.isEmpty(returnType.getClassifier().getName())) {
				URI ePackageFileURI = findEPackageFileURI(returnType.getMetamodel());
				if (ePackageFileURI != null) {
					EObject classifierProxy = EcoreFactory.eINSTANCE.create(returnType.getClassifier().eClass());
					URI eClassFileURI = ePackageFileURI.trimFragment().appendFragment(
							ePackageFileURI.fragment() + "/" + returnType.getClassifier().getName());
					((InternalEObject) classifierProxy).eSetProxyURI(eClassFileURI);
					getStatus().addWarning(
							"Renaming EClass '" + returnType.getClassifier().getName()
									+ "' in ecore file. Please rerun the Ecore generator.");
					return singletonList(classifierProxy);
				}
			}
		}
		return null;
	}

	private URI findEPackageFileURI(AbstractMetamodelDeclaration metamodel) {
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			if (Strings.equal("ecore", resourceDescription.getURI().fileExtension())) {
				for (IEObjectDescription eObjectDescription : resourceDescription
						.getExportedObjectsByType(EcorePackage.Literals.EPACKAGE)) {
					if (Strings.equal(metamodel.getEPackage().getNsURI(), eObjectDescription.getQualifiedName()
							.getFirstSegment())) {
						return eObjectDescription.getEObjectURI();
					}
				}
			}
		}
		if (metamodel instanceof ReferencedMetamodel)
			getStatus().addError("Referenced metamodel " + metamodel.getEPackage() + " is not indexed");
		return null;
	}

}
