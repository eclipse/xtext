/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringReferenceQueryDataFactory;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceFilter;

import com.google.common.base.Predicate;

public class JvmModelFindRefsQueryDataFactory extends RefactoringReferenceQueryDataFactory {
	
	@Override
	protected Predicate<IReferenceDescription> createFilter(ElementRenameArguments args) {
		return new JvmModelReferenceFilter(args.getTargetElementURI());
	}
}