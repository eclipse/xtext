/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
 

public class XbaseWithAnnotationsJavaValidator extends XbaseJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
		final List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(XAnnotationsPackage.eINSTANCE);
		return ePackages;
	}

}
