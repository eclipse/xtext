/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions

import org.eclipse.xtext.naming.QualifiedName
import java.lang.reflect.Modifier

interface ITypeDescriptor {
	
	def String getName()
	
	def String getSimpleName()
	
	def QualifiedName getQualifiedName()
	
	/**
	 * @see Modifier
	 */
	def int getModifiers()
	
}
