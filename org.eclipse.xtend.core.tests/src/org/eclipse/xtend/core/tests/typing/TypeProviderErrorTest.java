/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typing;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeProviderErrorTest extends AbstractXtendTestCase {

	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private IResourceScopeCache cache;
	
	@Test public void testNoException_01() throws Exception {
		XtendFunction function = function(
				"def richStrings_04() {\n" + 
				"	'''«FORa:'1'.toCharArray»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''\n" + 
				"}\n");
		Iterator<Object> contents = EcoreUtil.getAllContents(function.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof JvmOperation) {
				// no exception
				getType((JvmIdentifiableElement) object);
			}
		}
	}
	
	private LightweightTypeReference getType(JvmIdentifiableElement identifiable) {
		return typeResolver.resolveTypes(identifiable).getActualType(identifiable);
	}
	private List<LightweightTypeReference> getThrownExceptionTypes(XExpression expression) {
		return typeResolver.resolveTypes(expression).getThrownExceptions(expression);
	}
	private LightweightTypeReference getReturnType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getReturnType(expression);
	}
	private LightweightTypeReference getExpectedType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedType(expression);
	}
	
	@Test public void testNoException_02() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.typing\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"class NoException {\n" + 
				"	def dispatch transform(EClass model) {\n" + 
				"		model.ETypeParameters.map(e|transform");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getExpectedType(expression);
			}
		}
	}
	
	@Test public void testNoException_03() throws Exception {
		XtendFile file = file(" \n" + 
				"import static java.util.Arrays.*\n" + 
				"import static extension java.util.Collections.*\n" + 
				"class NoException {\n" + 
				"	@com.google.inject.Inject\n" + 
				"	ArrayList myList\n" + 
				"	@com.google.inject.Inject extension String\n" + 
				"	def boolean something(int i) {\n" + 
				"	  if (i.indexOf() == 0) {\n" + 
				"	    return myList.contains(i)\n" + 
				"	  } \n" + 
				"	  asList(i)\n" + 
				"	  i.singletonList()\n" + 
				"	  false\n" + 
				"	}\n" + 
				"}");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getReturnType(expression);
			}
		}
	}
	
	@Test public void testNoException_04() throws Exception {
		XtendFile file = file("class NoException { dispatch");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof JvmIdentifiableElement) {
				JvmIdentifiableElement element = (JvmIdentifiableElement) object;
				getType(element);
			}
		}
	}
	
	@Test public void testNoException_05() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.typing\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"import org.eclipse.emf.ecore.EPackage\n" + 
				"import org.eclipse.emf.ecore.EStructuralFeature\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"class NoException {\n" + 
				"	def dispatchtransform(EClass model) {\n" + 
				"		model.ETypeParameters.map(e|transform(e))\n" + 
				"	}\n" + 
				"	def dispatch transform(EPackage packageDecl) {\n" + 
				"		packageDecl.eContents.map(e|transform(e))\n" + 
				"	}\n" + 
				"	def dispatch transform(EStructuralFeature entity) {\n" + 
				"		val inferredType = null\n" + 
				"		newArrayList(inferredType as EObject) 	 \n" + 
				"	}\n" + 
				"}");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getExpectedType(expression);
			}
		}
	}
	
	@Test public void testNoException_06() throws Exception {
		XtendFile file = file("package org.eclipse.xtend.core.tests.typing\n" + 
				"class NoException {\n" + 
				"	def recursive() {\n" + 
				"		indirection\n" + 
				"	}\n" +
				"   def indirection() {\n" +
				"       recursive()\n" +
				"   }\n" +
				"}");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getThrownExceptionTypes(expression);
			}
		}
	}
	
	@Test public void testNoException_07() throws Exception {
		XtendFile file = file("class foo  {\n" + 
							  "		def bar() {" + 
							  "			try catch()" +
		    				  "		}" +
							  "}");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getReturnType(expression);
			}
		}
	}
	
	@Test public void testNoException_08() throws Exception {
		XtendFile file = file(
				"import org.eclipse.emf.ecore.EReference\n" + 
				"import org.eclipse.emf.ecore.EPackage\n" +
				"import org.eclipse.emf.ecore.EObject\n" + 
				"import org.eclipse.xtext.resource.EObjectDescription\n" +
				"class Foo  {\n" + 
				"	def doStuff(EObject context, EReference reference) {\n" + 
				"		switch (context) {\n" + 
				"			EPackage: {\n" + 
				" 				val descriptions = (context as EPackage).EClassifiers.map(c|EObjectDescription::create(null, c))\n" + 
				" 			}\n" + 
				" 		}\n" + 
				"		return null\n" + 
				"	}" +
				"}");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getReturnType(expression);
			}
		}
	}
	
	@Test public void testNoException_09() throws Exception {
		XtendFile file = file(
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"class MyClass {\n" + 
				"}\n" + 
				"class X {\n" + 
				"	def <T extends Exception> m() {\n" + 
				"	}\n" + 
				"	\n" + 
				"	def Object bar(Object[] o) {\n" + 
				"	}\n" + 
				"}\n" + 
				"\n" + 
				"@Data\n" + 
				"class Case_0 extends X {\n" + 
				"	int id\n" + 
				"\n" + 
				"	def test() {\n" + 
				"	}\n" + 
				"\n" + 
				"	def returnInWhileLoop() {\n" + 
				"		while (false)\n" + 
				"			return 1\n" + 
				"	}\n" + 
				"\n" + 
				"	def String foo(String a, String b) {\n" + 
				"		var list = newArrayList()\n" + 
				"		for (i : 0 .. list.size - 1) {\n" + 
				"			println(i.toString + \" \" + list.get(i))\n" + 
				"		}\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a, b + 'holla')\n" + 
				"		} else {\n" + 
				"			var x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x =\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	def isUpper(String s) {\n" + 
				"		s.toUpperCase == s\n" + 
				"	}\n" + 
				"\n" + 
				"	def another(String x, String y) {\n" + 
				"		y + x\n" + 
				"	}\n" + 
				"\n" + 
				"}\n" + 
				"");
		{
			Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
			while(contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof XExpression) {
					XExpression expression = (XExpression) object;
					getExpectedType(expression);
				}
			}
		}
		cache.clear(file.eResource());
		{
			Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
			while(contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof XExpression) {
					XExpression expression = (XExpression) object;
					getExpectedType(expression);
				}
			}
		}
	}
	
	@Test public void testNoException_10() throws Exception {
		XtendFile file = file(
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import org.eclipse.emf.ecore.ENamedElement\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"import java.util.List\n" + 
				"\n" + 
				"class Case_9 extends Case_8 {\n" + 
				"	\n" + 
				"	def dispatch CharSequence generateTypeRef(ENamedElement c) {\n" + 
				"		  if (c.eContainer != null)\n" + 
				"		    c.eContainer.generateTypeRef\n" + 
				"		  else if (c.eIsProxy)\n" + 
				"		    '''«c.name»'''\n" + 
				"		  else\n" + 
				"		    ''''''\n" + 
				"		}\n" + 
				"\n" + 
				"	def dispatch  generateTypeRef(EObject o) {\n" + 
				"	  	o.eContainer.generateTypeRef\n" + 
				"	}  \n" + 
				"	\n" + 
				"	override <T1> /*List<List<T1>>*/ foo(T1 t) {\n" + 
				"        val List<List<T1>> x = super.foo(t)\n" + 
				"        return null\n" + 
				"    }\n" + 
				"		\n" + 
				"}");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				getExpectedType(expression);
			}
		}
	}
	
	@Override
	protected XtendFile file(String string, boolean validate) throws Exception {
		if (validate)
			return super.file(string, validate);
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
}

