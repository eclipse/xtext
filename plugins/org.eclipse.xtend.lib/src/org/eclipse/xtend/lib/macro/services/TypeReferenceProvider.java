/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;

import com.google.common.annotations.Beta;

@Beta
public interface TypeReferenceProvider {
	TypeReference newArrayTypeReference(TypeReference componentType);
	TypeReference newTypeReference(String typeName, TypeReference... typeArguments);
	TypeReference newTypeReference(Type typeDeclaration, TypeReference... typeArguments);
	
	TypeReference newWildcardTypeReference();
	TypeReference newWildcardTypeReference(TypeReference upperBound);
	
	TypeReference getObject();
	TypeReference getString();
	TypeReference getList(TypeReference param);
	TypeReference getSet(TypeReference param);
	TypeReference getAnyType();
	TypeReference getPrimitiveVoid();
	TypeReference getPrimitiveBoolean();
	TypeReference getPrimitiveShort();
	TypeReference getPrimitiveInt();
	TypeReference getPrimitiveLong();
	TypeReference getPrimitiveFloat();
	TypeReference getPrimitiveDouble();
	TypeReference getPrimitiveChar();
	TypeReference getPrimitiveByte();
}