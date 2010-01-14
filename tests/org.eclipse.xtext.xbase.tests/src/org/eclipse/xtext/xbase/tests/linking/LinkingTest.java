package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.xbase.File;
import org.eclipse.xtext.xbase.Function;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xtype.FunctionTypeRef;
import org.eclipse.xtext.xtype.SimpleTypeRef;

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
	
}
