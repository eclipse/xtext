package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.xbase.File;
import org.eclipse.xtext.xbase.Function;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xtype.FunctionTypeRef;
import org.eclipse.xtext.xtype.SimpleTypeRef;
import org.eclipse.xtext.xtype.TypeParamDeclaration;

public class LinkingTest extends AbstractXbaseTestCase {
	
	public void testTypeReference_0() throws Exception {
		File file = file("=>java.lang.Boolean foo() : |true;");
		Function func = file.getFunctions().get(0);
		FunctionTypeRef type = (FunctionTypeRef) func.getReturnType();
		SimpleTypeRef returnType = (SimpleTypeRef) type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getType().getCanonicalName());
	}
	
	public void testTypeReference_withImport() throws Exception {
		File file = file("import java.lang.* (String)=>Boolean foo() : |true;");
		Function func = file.getFunctions().get(0);
		FunctionTypeRef type = (FunctionTypeRef) func.getReturnType();
		SimpleTypeRef returnType = (SimpleTypeRef) type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getType().getCanonicalName());
		SimpleTypeRef paramType = (SimpleTypeRef) type.getParamTypes().get(0);
		assertEquals("java.lang.String", paramType.getType().getCanonicalName());
	}
	
	public void testTypeParameterReference() throws Exception {
		File file = file("<X> X foo(X x) : x;");
		Function func = file.getFunctions().get(0);
		SimpleTypeRef returnType = (SimpleTypeRef) func.getReturnType();
		TypeParamDeclaration typeParamDecl = (TypeParamDeclaration) returnType.getType();
		assertEquals("X", typeParamDecl.getCanonicalName());
		assertEquals("X", typeParamDecl.getName());
		
		SimpleTypeRef paramType = (SimpleTypeRef) func.getDeclaredParams().get(0).getType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_0() throws Exception {
		File file = file("import java.lang.* <String> String foo(String x) : x;");
		Function func = file.getFunctions().get(0);
		SimpleTypeRef returnType = (SimpleTypeRef) func.getReturnType();
		TypeParamDeclaration typeParamDecl = (TypeParamDeclaration) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		SimpleTypeRef paramType = (SimpleTypeRef) func.getDeclaredParams().get(0).getType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_1() throws Exception {
		File file = file("import java.lang.* <String> String foo(java.lang.String x) : x;");
		Function func = file.getFunctions().get(0);
		SimpleTypeRef returnType = (SimpleTypeRef) func.getReturnType();
		TypeParamDeclaration typeParamDecl = (TypeParamDeclaration) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		SimpleTypeRef paramType = (SimpleTypeRef) func.getDeclaredParams().get(0).getType();
		assertNotSame(typeParamDecl,paramType.getType());
	}
	
}
