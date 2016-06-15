/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static java.util.Collections.*;
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
@SuppressWarnings("restriction")
public class EcoreRefactoringParticipant extends AbstractProcessorBasedRenameParticipant {

	/**
	 * Option-flag to disable warnings in this participant
	 * @deprecated use {{@link #setDisableWarning(boolean)} instead
	 */
	@Deprecated
	public static final String ECORE_REFACTORING_PARTICIPANT_SHOW_WARNING_OPTION = "org.eclipse.xtext.xtext.ui.refactoring.EcoreRefactoringParticipant.show.warning.option";


	private static boolean isDisableWarning;

	
	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Override
	protected List<? extends IRenameElementContext> createRenameElementContexts(Object element) {
		if (element instanceof IRenameElementContext
				&& ((IRenameElementContext) element).getTargetElementEClass() == XtextPackage.Literals.PARSER_RULE)
			return super.createRenameElementContexts(element);
		else
			return null;
	}

	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {
		if (originalTarget instanceof ParserRule) {
			TypeRef returnType = ((ParserRule) originalTarget).getType();
			if (returnType != null && returnType.getClassifier() != null
					&& !Strings.isEmpty(returnType.getClassifier().getName())
					&& equal(((ParserRule) originalTarget).getName(), returnType.getClassifier().getName())
					&& returnType.getClassifier().eClass() != null && returnType.getClassifier().getEPackage() != null
					&& !Strings.isEmpty(returnType.getClassifier().getEPackage().getNsURI())) {
				String packageNsURI = returnType.getClassifier().getEPackage().getNsURI();
				QualifiedName classifierQualifiedName = QualifiedName.create(packageNsURI, returnType.getClassifier()
						.getName());
				URI platformResourceURI = findPlatformResourceURI(classifierQualifiedName, EcorePackage.Literals.ECLASS);
				if (platformResourceURI == null) {
					if (returnType.getMetamodel() instanceof ReferencedMetamodel)
						getStatus().add(ERROR, "Return type '{0}' is not indexed.", returnType.getClassifier());
				} else {
					EObject classifierProxy = EcoreFactory.eINSTANCE.create(returnType.getClassifier().eClass());
					((InternalEObject) classifierProxy).eSetProxyURI(platformResourceURI);
					if(!isDisableWarning)
						getStatus().add(WARNING, 
								"Renaming EClass '{0}' in ecore file. Please rerun the Ecore generator.", returnType.getClassifier());
					
					return singletonList(classifierProxy);
				}
			}
		}
		return null;
	}

	private URI findPlatformResourceURI(QualifiedName name, EClass type) {
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			if (Strings.equal("ecore", resourceDescription.getURI().fileExtension())) {
				for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjectsByType(type)) {
					if (name.equals(eObjectDescription.getQualifiedName())) {
						return eObjectDescription.getEObjectURI();
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * For tests only: The warning dialog will block the test on the server 
	 * @noref
	 */
	public static void setDisableWarning(boolean isDisableWarning) {
		EcoreRefactoringParticipant.isDisableWarning = isDisableWarning;
	}

}
