/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;

import com.google.common.annotations.Beta;

@Beta
public interface Tracability {
	
	boolean isSource(NamedElement element);
	boolean isGenerated(NamedElement element);
	boolean isExternal(NamedElement element);
	
	MutableNamedElement getGeneratedElement(NamedElement source);
	MutableClassDeclaration getGeneratedClass(ClassDeclaration source);
	MutableMethodDeclaration getGeneratedMethod(MethodDeclaration source);
	MutableConstructorDeclaration getGeneratedConstructor(ConstructorDeclaration source);
	MutableFieldDeclaration getGeneratedField(FieldDeclaration source);
}
