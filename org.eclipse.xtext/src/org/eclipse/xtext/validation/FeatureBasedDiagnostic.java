/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Lists;

/**
 * A diagnostic that is typically associated with a feature.
 */
public class FeatureBasedDiagnostic extends AbstractValidationDiagnostic {

	private final EStructuralFeature feature;
	private final int index;
	
	/**
	 * @param issueData optional user data. May not contain <code>null</code> entries.
	 */
	public FeatureBasedDiagnostic(int severity, String message, EObject source, EStructuralFeature feature, int index, CheckType checkType, String issueCode, String... issueData) {
		super(severity, message, source, checkType, issueCode, issueData);
		if (feature != null && source != null) {
			if (source.eClass().getEStructuralFeature(feature.getName()) != feature) {
				throw new IllegalArgumentException("The sources EClass '" + source.eClass().getName() + "' does not expose the feature '" + feature.getEContainingClass().getName() + "." + feature.getName() + "'");
			}
		}
		this.feature = feature;
		this.index = index;
	}

	@Override
	public List<?> getData() {
		List<Object> result = Lists.newArrayListWithExpectedSize(3);
		result.add(getSourceEObject());
		if (feature != null) {
			result.add(feature);
			result.add(index);
		}
		if(getIssueData() != null) {
			result.add(getIssueData());
		}
		return result;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getIndex() {
		return index;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		if (getSourceEObject() != null && feature != null) {
			result.append(".");
			result.append(feature.getName());
			if (!feature.isMany()) {
				if (feature instanceof EAttribute) {
					result.append("==\"");
					result.append(getSourceEObject().eGet(feature));
					result.append("\"");
				}
				else {
					EObject value = (EObject) getSourceEObject().eGet(feature);
					result.append("==(");
					if (value == null) {
						result.append("null");
					} else {
						result.append("(instanceof ");
						result.append(value.eClass().getName());
						result.append(": ").append(value);
					}
					result.append(")");
						
				}
			} else if (index != ValidationMessageAcceptor.INSIGNIFICANT_INDEX) {
				result.append("#").append(index);
				List<?> list = (List<?>) getSourceEObject().eGet(feature);
				Object value = list.get(index);
				if (feature instanceof EAttribute) {
					result.append("==\"");
					result.append(value);
					result.append("\"");
				} else {
					EObject eObject = (EObject) value;
					result.append("==(");
					if (value == null) {
						result.append("null");
					} else {
						result.append("(instanceof ");
						result.append(eObject.eClass().getName());
						result.append(": ").append(eObject);
					}
					result.append(")");
				}
		}
		}
		return result.toString();
	}

}