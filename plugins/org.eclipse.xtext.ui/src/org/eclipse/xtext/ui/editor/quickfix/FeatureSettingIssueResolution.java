/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.IssueResolution;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class FeatureSettingIssueResolution implements IssueResolution {

	final private EObject target;
	final private EStructuralFeature feature;
	final private String valueAsString;
	final private Object valueAsObject;

	public FeatureSettingIssueResolution(EObject target, EStructuralFeature feature, String valueAsString, Object valueAsObject) {
		this.target = target;
		this.feature = feature;
		this.valueAsString = valueAsString;
		this.valueAsObject = valueAsObject;
	}

	public String getDescription() {
		return null;
	}

	public String getImage() {
		return null;
	}

	public String getLabel() {
		return String.format("Change to '%s'", valueAsString);
	}

	public void run() {
		target.eSet(feature, valueAsObject);
	}

}

