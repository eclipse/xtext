/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.refactoring;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.xtend2.ui.findrefs.Xtend2ReferenceFilter;

import com.google.common.base.Predicate;

public class Xtend2ReferenceFilterProvider implements IReferenceUpdater.IFilterProvider {
	public Predicate<IReferenceDescription> get(ElementRenameArguments elementRenameArguments,
			ResourceSet resourceSet) {
		return new Xtend2ReferenceFilter(elementRenameArguments.getTargetElementURI());
	}
}