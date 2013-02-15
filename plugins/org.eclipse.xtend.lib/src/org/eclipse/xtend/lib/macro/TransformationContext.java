/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend.lib.macro.services.Tracability;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;

import com.google.common.annotations.Beta;

/**
 * 
 * @author Sven Efftinge
 */
@Beta
public interface TransformationContext extends Tracability, ProblemSupport {
	
	MutableClassDeclaration findGeneratedClass(String name);
	
	TypeReferenceProvider getTypeReferenceProvider();
}
