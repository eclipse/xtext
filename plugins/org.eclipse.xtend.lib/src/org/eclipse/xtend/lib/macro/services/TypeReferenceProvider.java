package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.type.TypeReference;

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