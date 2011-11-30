/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.typing;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeProviderErrorTest extends AbstractXtend2TestCase {

	@Inject
	private ITypeProvider typeProvider;
	
	public void testNoException_01() throws Exception {
		XtendFunction function = function(
				"def richStrings_04() {\n" + 
				"	'''«FORa:'1'.toCharArray»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''\n" + 
				"}\n");
		Iterator<Object> contents = EcoreUtil.getAllContents(function.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof JvmOperation) {
				// no exception
				typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) object);
			}
		}
		
	}
	
	public void testNoException_02() throws Exception {
		XtendFile file = file("package org.eclipse.xtext.xtend2.tests.typing\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"class NoException {\n" + 
				"	def dispatch transform(EClass model) {\n" + 
				"		model.ETypeParameters.map(e|transform");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof XExpression) {
				XExpression expression = (XExpression) object;
				typeProvider.getExpectedType(expression);
			}
		}
	}
	
	public void testNoException_03() throws Exception {
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
				typeProvider.getCommonReturnType(expression, true);
			}
		}
	}
	
	public void testNoException_04() throws Exception {
		XtendFile file = file("class NoException { dispatch");
		Iterator<Object> contents = EcoreUtil.getAllContents(file.eResource(), true);
		while(contents.hasNext()) {
			EObject object = (EObject) contents.next();
			if (object instanceof JvmIdentifiableElement) {
				JvmIdentifiableElement element = (JvmIdentifiableElement) object;
				typeProvider.getTypeForIdentifiable(element);
			}
		}
	}
	
	public void testNoException_05() throws Exception {
		XtendFile file = file("package org.eclipse.xtext.xtend2.tests.typing\n" + 
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
				typeProvider.getExpectedType(expression);
			}
		}
	}
	
	public void testNoException_06() throws Exception {
		XtendFile file = file("package org.eclipse.xtext.xtend2.tests.typing\n" + 
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
				typeProvider.getThrownExceptionTypes(expression);
			}
		}
	}
	
	public void testNoException_07() throws Exception {
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
				typeProvider.getCommonReturnType(expression, true);
			}
		}
	}
	
	@Override
	protected XtendFile file(String string, boolean validate) throws Exception {
		if (validate)
			return super.file(string, validate);
		XtextResourceSet set = get(XtextResourceSet.class);
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
}

