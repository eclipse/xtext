/*******************************************************************************
 * Copyright (c) 2008 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext2ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.api.IMatchEngine;
import org.eclipse.emf.compare.match.api.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Jan Köhnlein
 * 
 */
public class EcoreModelComparator {

	private Map<String, Object> options;
	private IMatchEngine matchEngine;
	private List<EStructuralFeature> ignoredFeatures = new ArrayList<EStructuralFeature>();

	public EcoreModelComparator() {
		options = new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, Boolean.TRUE);
		matchEngine = new GenericMatchEngine();
	}

	public boolean modelsDiffer(Resource left, Resource right)
			throws InterruptedException {
		boolean modelsDiffer = false;
		MatchModel matchModel = matchEngine.resourceMatch(left, right, options);
		DiffModel diffModel = DiffService.doDiff(matchModel);
		if (diffModel != null) {
			for (DiffElement diffElement : diffModel.getOwnedElements()) {
				modelsDiffer |= checkDiff(diffElement);
			}
		}
		return modelsDiffer;
	}

	public void addIgnoredFeature(EStructuralFeature feature) {
		ignoredFeatures.add(feature);
	}

	private boolean checkDiff(DiffElement diffElement) {
		boolean hasDiff = false;
		if (!ignoreDiff(diffElement)) {
			printDiff(diffElement);
			hasDiff = true;
		}
		for (DiffElement childDiffElement : diffElement.getSubDiffElements()) {
			hasDiff |= checkDiff(childDiffElement);
		}
		return hasDiff;
	}

	private boolean ignoreDiff(DiffElement diffElement) {
		if (diffElement instanceof AttributeChange) {
			return ignoredFeatures.contains(((AttributeChange) diffElement)
					.getAttribute());
		} else if (diffElement instanceof ReferenceChange) {
			return ignoredFeatures.contains(((ReferenceChange) diffElement)
					.getReference());
		}
		return diffElement instanceof DiffGroup;
	}

	private void printDiff(DiffElement diffElement) {
		if (diffElement instanceof AttributeChange) {
			AttributeChange change = (AttributeChange) diffElement;
			EAttribute attribute = change.getAttribute();
			System.err.println("Detected attribute difference: "
					+ attribute.getName());
			System.err.println("\t" + change.getLeftElement());
			System.err.println("\t" + change.getRightElement());
		} else if (diffElement instanceof ReferenceChange) {
			ReferenceChange change = (ReferenceChange) diffElement;
			EReference reference = change.getReference();
			System.err.println("Detected reference difference: "
					+ reference.getName());
			System.err.println("\t" + change.getLeftElement());
			System.err.println("\t" + change.getRightElement());
		} else {
			// TODO: add more sysouts here...
			System.err.println(diffElement.toString());
		}
	}
}
