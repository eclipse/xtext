/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.util.formallang.INfaAdapter;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SemanticSequencerNfaProvider.class)
public interface ISemanticSequencerNfaProvider {

	public interface ISemState {
		AbstractElement getAssignedGrammarElement();

		EStructuralFeature getFeature();

		int getFeatureID();

		List<ISemState> getFollowers();

		List<AbstractElement> getToBeValidatedAssignedElements();
	}

	INfaAdapter<ISemState, List<ISemState>> getNFA(EObject context, EClass type);
}
