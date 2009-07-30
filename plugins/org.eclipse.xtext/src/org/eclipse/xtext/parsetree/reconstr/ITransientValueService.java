/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Implementations of this service are called when a model is serialized and can
 * decide whether a value needs to be serialized or not.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITransientValueService {

	/**
	 * For features with isMany() == true, isMixedList() has to return true when
	 * isTransient should be called for each element of the list instead of once
	 * for the whole list.
	 * 
	 * @param owner
	 * @param feature
	 * @return
	 */
	public boolean isMixedList(EObject owner, EStructuralFeature feature);

	/**
	 * Decides whether a value should be serialized.
	 * 
	 * If !feature.isMany() or !isMixedList(feature), this method is only called
	 * once for each feature. In this case, index is < 0.
	 * 
	 * If feature.isMany() and isMixedList(feature), this method is called for
	 * each of the feature's values.
	 * 
	 * Attention: Values marked transient are only not serialized when they are
	 * optional in the grammar. Example: Rule1: transientF=INT normalF=INT; In
	 * this case, the grammar requires to serialize transientF to produce a
	 * valid DSL-script.
	 * 
	 * Attention: Think of how many times the serializer calls this method and
	 * supply a fast implementation. The serializer tries to avoid multiple
	 * calls to this method using the same parameters, but depending on the
	 * grammar and the model, it may happen.
	 * 
	 * @param owner
	 *            The EObject holding the feature's value
	 * @param feature
	 * @param index
	 * @return true, if the feature's value(s) should NOT be serialized
	 */
	public boolean isTransient(EObject owner, EStructuralFeature feature,
			int index);

}
