/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelFindReferenceHandler extends FindReferencesHandler {

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Inject
	private JdtReferenceFinder jdtReferenceFinder;
	@Inject
	private OverrideHelper overrideHelper;

	@Override
	protected void findReferences(EObject target) {
		ReferenceQueryExecutor queryExecutor = getQueryExecutor(target);
		if (queryExecutor != null) {
			Iterable<IJavaElement> javaElements = getJavaElements(target);
			if (size(javaElements) > 0) {
				jdtReferenceFinder.run(queryExecutor.getLabel(target), javaElements);
			} else {
				queryExecutor.execute();
			}
		}
	}

	public Iterable<IJavaElement> getJavaElements(EObject target) {
		Set<EObject> jvmElements;
		if(isJvmElement(target))
			jvmElements = singleton(target);
		else 
			jvmElements = associations.getJvmElements(target);
		jvmElements = filterJvmElements(jvmElements);
		if (!jvmElements.isEmpty()) {
			List<IJavaElement> javaElements = newArrayList();
			for (EObject jvmElement : jvmElements) {
				if (jvmElement instanceof JvmIdentifiableElement) {
					IJavaElement javaElement = javaElementFinder
							.findExactElementFor((JvmIdentifiableElement) jvmElement);
					if (javaElement != null)
						javaElements.add(javaElement);
				}
			}
			return javaElements;
		}
		return emptyList();
	}
	
	protected Set<EObject> filterJvmElements(Set<EObject> unfiltered) {
		Set<EObject> filtered = newLinkedHashSet();
		for (EObject element : unfiltered) {
			if (isAcceptedElement(element)) {
				filtered.add(element);
			}
		}
		return filtered;
	}
	
	protected boolean isAcceptedElement(EObject jvmElement) {
		if (jvmElement instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) jvmElement;
			if (!associations.isPrimaryJvmElement(op) && overrideHelper.findOverriddenOperation(op) != null) {
				return false;
			}
		}
		return true;
	}

	protected boolean isJvmElement(EObject target) {
		return target.eClass().getEPackage() == TypesPackage.eINSTANCE; 
	}
}
