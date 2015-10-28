/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.parsing;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParserTest extends AbstractXtendTestCase {
	
	@Inject
	private InvariantChecker invariantChecker;
	
	@Inject
	private Provider<ResourceValidatorImpl> resourceValidatorProvider;
	
	@Test public void testBug440633_01() throws Exception {
		String model =
				"class C {\n" + 
				"	m(=>AB)\n" + 
				"	private \n" + 
				"}";
		doTestUpdateAtOffset(model, model.indexOf("B"), 1, "", "C.xtend");
	}
	
	@Test public void testBug440633_02() throws Exception {
		String model =
				"class C {\n" + 
				"	m(=>AB)\n" + 
				"	private \n" + 
				"}";
		doTestUpdateAtOffset(model, model.indexOf("B"), 0, "X", "C.xtend");
	}
	
	@Test public void testBug434727_01() throws Exception {
		String model =
				"import static\n" + 
				"class Foo {}";
		doTestUpdateAtOffset(model, "import static".length(), 0, " ", "Bug434727.xtend");
	}
	
	@Test public void testBug434727_02() throws Exception {
		String model =
				"import static  java.util.Collections.*\n" + 
				"class Foo {}";
		doTestUpdateAtOffset(model, "import static".length(), 0, " ", "Bug434727.xtend");
	}
	
	@Test public void testBug434727_03() throws Exception {
		String model =
				"package p\n" +
				"import static\n" + 
				"class Foo {}";
		doTestUpdateAtOffset(model, "package p\nimport static".length(), 0, " ", "Bug434727.xtend");
	}
	
	@Test public void testNoClassCastException() throws Exception {
		String model =
				"package org.eclipse.xtend.core.tests.parsing\n" + 
						"\n" + 
						"class NoClassCastException {\n" + 
						"\n" + 
						"	String foo(String a, String b) {\n" + 
						"		if (isUpper(a)) {\n" + 
						"			another(a,b+'holla')";
		doTestUpdateAtEnd(model, '\n', "NoClassCastException.xtend");
	}
	
	@Test public void testSyntaxErrorOnLeafNode_01() throws Exception {
		String model =
			"package org.eclipse.xtend.core.tests.parsing\n" + 
			"\n" + 
			"class SyntaxErrorOnLeafNode {\n" + 
			"\n" + 
			"	String foo(String a, String b) {\n" + 
			"		if (isUpper(a)) {\n" + 
			"			another(a,b+'holla')\n" + 
			"		} else {\n" + 
			"			val x = a;\n" + 
			"			for (y : b.toCharArray) {\n" + 
			"				x = x+";
		doTestUpdateAtEnd(model, 'y', "SyntaxErrorOnLeafNode.xtend");
	}
	
	@Test public void testSyntaxErrorOnLeafNode_02() throws Exception {
		String model =
			"package org.eclipse.xtend.core.tests.linking\n" + 
			"\n" + 
			"class SyntaxErrorOnLeafNode {\n" + 
			"\n" + 
			"	String foo(String a, String b) {\n" + 
			"		if (isUpper(a)) {\n" + 
			"			another(a,b+'holla')\n" + 
			"		} else {\n" + 
			"			val x = a;\n" + 
			"			for (y : b.toCharArray) {\n" + 
			"				x = x+y\n" + 
			"			}\n" + 
			"			x\n" + 
			"		}\n" + 
			"	}\n" + 
			"	\n" + 
			"	private isUpper(String s) \n" + 
			"		s.";
		doTestUpdateAtEnd(model, 't', "SyntaxErrorOnLeafNode.xtend");
	}

	@Test public void testErroneousModelRemoved() throws Exception {
		String model =
				"\n" + 
				"\n" + 
				"class ErroneousModelRemoved {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase == s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		XtextResource resource = doTestUpdateAtOffset(model, 0, 0, "g", "ErroneousModelRemoved.xtend");
		assertTrue(resource.getContents().isEmpty());
	}
	
	@Test public void testEqualNodeModels() throws Exception {
		String model =
				"package org.eclipse.xtend.core.tests.parsing\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')";
		doTestUpdateAtEnd(model, '\n', "EqualNodeModels.xtend");
	}
	
	@Test public void testEqualNodeModels_02() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.linking\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, Stringb) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase == s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		// offset's origin is the smoke test
		doTestUpdateAtOffset(model, 101, 1, " ", "EqualNodeModels.xtend");
	}
	
	@Test public void testEqualNodeModels_03() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.linking\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'olla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase == s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		
		doTestUpdateAtOffset(model, 143, 1, "h", "EqualNodeModels.xtend");
	}
	
	@Test public void testEqualNodeModels_04() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.linking\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"\n" + 
				"	String foo(String a, String b) {\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			val x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	private isUpper(String s) \n" + 
				"		s.toUpperCase== s\n" + 
				"		\n" + 
				"	private another(String x, String y) \n" + 
				"		y+x\n" + 
				"	\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 279, 1, " ", "EqualNodeModels.xtend");
	}
	
	@Test public void testEqualNodeModels_05() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"class EqualNodeModels {\n" + 
				"	testReturnExpression_06() {\n" + 
				"	    val closure = [Integer i| return i]\n" + 
				"	    for (x : 1..100) closure.(x)\n" + 
				"	}\n" + 
				"	testOverriddenLocalVariable() {\n" + 
				"	  val x = 3\n" + 
				"	  var y = 2\n" + 
				"	  {\n" + 
				"	    var x = y\n" + 
				"	    val y = 1\n" + 
				"	    x+y\n" + 
				"	  }\n" + 
				"	}\n" + 
				"	testFeatureCall_03() {\n" + 
				"		{ \n" + 
				"			var java.util.List<Character> this = ('abc'.toCharArray as Iterable<Character>).toList() \n" + 
				"			this \n" + 
				"		}\n" + 
				"	}\n" + 
				"}";
		doTestUpdateAtOffset(model, 170, 1, "apply", "EqualNodeModels.xtend");
	}
	
	@Test public void testEqualNodeModels_06() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"@Data\n" + 
				"class Case_0 {\n" + 
				"	int id\n" + 
				"\n" + 
				"	def String foo(String a, String b) {\n" + 
				"		var list = newArrayList()\n" + 
				"		for(i: 0..list.size - 1) {\n" + 
				"			println(i.toString + \" \" + list.get(i))\n" + 
				"		}\n" + 
				"		if (isUpper(a)) {\n" + 
				"			another(a,b+'holla')\n" + 
				"		} else {\n" + 
				"			var x = a;\n" + 
				"			for (y : b.toCharArray) {\n" + 
				"				x = x+y\n" + 
				"			}\n" + 
				"			x\n" + 
				"		}\n" + 
				"	}\n" + 
				"	\n" + 
				"	def isUpper(String s) {\n" + 
				"		s.toUpperCase== s\n" + 
				"	}\n" + 
				"		\n" + 
				"	def another(String x, String y) { \n" + 
				"		y+x\n" + 
				"	}\n" + 
				"	\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 385, 1, " ", "Case_0.xtend");
	}
	
	@Test public void testEqualNodeModels_07() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import .eclipse.xtend.lib.Property\n" + 
				"\n" + 
				"class Case_1 {\n" + 
				"	@Property\n" + 
				"	int id\n" + 
				"\n" + 
				"	def testFunction1() {\n" + 
				"		42\n" + 
				"	}\n" + 
				"	\n" + 
				"	def testFunction2() {\n" + 
				"		42\n" + 
				"	} \n" + 
				"		\n" + 
				"	def Integer testFunction3() {\n" + 
				"		42\n" + 
				"	} \n" + 
				"		\n" + 
				"}";
		doTestUpdateAtOffset(model, 51, 1, "org", "Case_1.xtend");
	}
	
	@Test public void testEqualModels_01() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import java.util.ArrayList\n" + 
				"import static java.util.Arrays.*\n" + 
				"import static extension java.util.Collections.*\n" + 
				"\n" + 
				"class Case_5 {\n" + 
				"\n" + 
				"	@Inject\n" + 
				"	ArrayList as myList\n" + 
				"//	ArrayList as list\n" + 
				"	\n" + 
				"	@Inject extension\n" + 
				"	String\n" + 
				"\n" + 
				"	boolean something(int i) {\n" + 
				"	  if (i.indexO() == 0) {\n" + 
				"//	    return list.contains(i)\n" + 
				"	    return myList.contains(i)\n" + 
				"	  } \n" + 
				"	  asList(i)\n" + 
				"	  i.singletonList()\n" + 
				"	  false\n" + 
				"	}\n" + 
				"	\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 295, 1, "f", "Case_5.xtend");
	}
	
	@Test public void testEqualModels_02() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"import org.eclipse.emf.ecore.EPackage\n" + 
				"import org.eclipse.emf.ecore.EStructuralFeature\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"\n" + 
				"class Case_6 {\n" + 
				"\n" + 
				"	dispatch transform(EClass model) {\n" + 
				"		model.ETypeParameters.map(e|transform(e))\n" + 
				"	}\n" + 
				"	 \n" + 
				"	dispatch transform(E";
		doTestUpdateAtOffset(model, 327, 0, "P", "Case_6.xtend");
	}
	
	@Test public void testEqualModels_03() throws Exception {
		String model = "package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"import org.eclipse.emf.ecore.EPackage\n" + 
				"import org.eclipse.emf.ecore.EStructuralFeature\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"\n" + 
				"class Case_6 {\n" + 
				"\n" + 
				"	dispatch transform(EClass model) {\n" + 
				"		model.ETypeParameters.map(|transform(e))\n" + 
				"	}\n" + 
				"	 \n" + 
				"	dispatch transform(EPackage packageDecl) {\n" + 
				"		packageDecl.eContents.map(e|transform(e))\n" + 
				"	}\n" + 
				"	\n" + 
				"	dispatch transform(EStructuralFeature entity) {\n" + 
				"		val inferredType = null\n" + 
				"		newArrayList(inferredType as EObject) 	 \n" + 
				"	}\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 286, 1, "e", "Case_6.xtend");
	}
	
	@Test public void testEqualModels_04() throws Exception {
		String model =
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"class Case_3 {\n" + 
				"	def testReturnExpression_06() {\n" + 
				"	    val closure = [Integer i| return i]\n" + 
				"	    for (x : 1..100) closure.apply(x)\n" + 
				"	}\n" + 
				"	def testReturnExpression_07() {\n" + 
				"		if (typeof(Case_3) != null) {\n" + 
				"		    val (int)=>int closure = [Integer i| return i]\n" + 
				"		    for (x : 1..100) closure.apply(x)\n" + 
				"		}\n" + 
				"	}\n" + 
				"	def testOverriddenLocalVariable() {\n" + 
				"	  val x = 3\n" + 
				"	  var y = 2\n" + 
				"	  {\n" + 
				"	    var x2 = y\n" + 
				"	    val y2 = 1\n" + 
				"	    x2+y2\n" + 
				"	  }\n" + 
				"	}\n" + 
				"	def testFeatureCall_03() {\n" + 
				"		{ \n" + 
				"			var java.util.List<Character> x = ('abc'.toCharArray as Iterable<Character>).toList() \n" + 
				"			x \n" + 
				"		}\n" + 
				"	}\n" + 
				"}";
		assertEquals(227, model.indexOf("typeof(Case_3") + "typeof(Case_3".length());
		XtextResource resource = doTestUpdateAtOffset(model, 229, 1, " ", "Case_3.xtend");
		compareWithNewResource(resource, model, 229, 1, ")", "Case_3.xtend");
		validateWithoutException(resource);
	}
	
	@Test public void testEqualModels_05() throws Exception {
		String model =
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import org.eclipse.emf.ecore.EClass\n" + 
				"import org.eclipse.emf.ecore.EPackage\n" + 
				"import org.eclipse.emf.ecore.EStructuralFeature\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"\n" + 
				"class Case_6 {\n" + 
				"\n" + 
				"	def dispatch transform(EClass model) {\n" + 
				"		model.ETypeParameters.map(e|transform(e))\n" + 
				"	}\n" + 
				"	 \n" + 
				"	def dispatch transform(EPackage packageDecl) {\n" + 
				"		packageDecl.eContents.map(e | transform(e as EStructuralFeature))\n" + 
				"	}\n" + 
				"	\n" + 
				"	def dispatch transform(EStructuralFeature entity) {\n" + 
				"		val inferredType = null\n" + 
				"		newArrayList";
		XtextResource resource = doTestUpdateAtOffset(model, 524, 0, "(i", "Case_6.xtend");
		compareWithNewResource(resource, model + "(", 525, 1, "i", "Case_6.xtend");
		validateWithoutException(resource);
	}
	
	@Test public void testInferredModelRemoved() throws Exception {
		String model =
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"classCase_1 {\n" + 
				"\n" + 
				"	testFunction1() {\n" + 
				"		42\n" + 
				"	}\n" + 
				"	\n" + 
				"	testFunction2() \n" + 
				"		42\n" + 
				"		\n" + 
				"	Integer testFunction3() \n" + 
				"		42\n" + 
				"		\n" + 
				"}";
		doTestUpdateAtOffset(model, 51, 6, " ", "InferredModelRemoved.xtend");
	}
	
	
	@Test public void testBug380290_0() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" +
						"\n" + 
				"import com.google.inject.Inject\n" +
				"import org.eclipse.xtext.common.types.util.TypeReferences\n" +
				"import org.eclipse.xtext.naming.IQualifiedNameProvider\n" +
				"import org.eclipse.xtext.xbase.XExpression\n" +
				"import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor\n" +
				"import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder\n" +
				"\n" +
				"class TestClass {\n" +
				"    @Inject extension JvmTypesBuilder\n" +
				"    @Inject extension IQualifiedNameProvider\n" +
				"\n" +
				"    def void infer(XExpression m, IJvmDeclaredTypeAcceptor acceptor) {\n" +
				"        acceptor.accept(m.toClass(m.fullyQualifiedName)).initializeLater[\n" +
				"            members += m.toMethod(\"m1\",m.newTypeRef(Void::TYPE),[\n" +
				"                    body = []\n" +
				"                ])\n" +
				"            members+= m.toMethod(\"m2\",m.newTypeRef(Void::TYPE),[\n" +
				"                body = [append(1'''stuff''')]\n" +
				"            ])\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		doTestUpdateAtOffset(model, model.indexOf("1'''stuff'''"), 1, "", "TestClass.xtend");
	}
	
	@Test public void testBug380290_1() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" +
						"\n" + 
				"import com.google.inject.Inject\n" +
				"import org.eclipse.xtext.common.types.util.TypeReferences\n" +
				"import org.eclipse.xtext.naming.IQualifiedNameProvider\n" +
				"import org.eclipse.xtext.xbase.XExpression\n" +
				"import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor\n" +
				"import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder\n" +
				"\n" +
				"class TestClass {\n" +
				"    @Inject extension JvmTypesBuilder\n" +
				"    @Inject extension IQualifiedNameProvider\n" +
				"\n" +
				"    def void infer(XExpression m, IJvmDeclaredTypeAcceptor acceptor) {\n" +
				"        acceptor.accept(m.toClass(m.fullyQualifiedName)).initializeLater[\n" +
				"            members += m.toMethod(\"m1\",m.newTypeRef(Void::TYPE),[\n" +
				"                    body = []\n" +
				"                ])\n" +
				"            members+= m.toMethod(\"m2\",m.newTypeRef(Void::TYPE),[\n" +
				"                body = [append('''stuff''')]\n" +
				"            ])\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		doTestUpdateAtOffset(model, model.indexOf("'''stuff'''"), 0, "1", "TestClass.xtend");
	}
	
	@Test public void testSmokeTestFailure_00() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"class Case_2 {\n" + 
				"\n" + 
				"	def aOrB(String a, String b) {\n" + 
				"		if (a.isNullOrEmpty()) \n" + 
				"			b\n" + 
				"		else\n" + 
				"			a \n" + 
				"	}\n" + 
				"	\n" + 
				"	def returnInIf() {\n" + 
				"		if ('x'!='x') return 'x' else return 'yy'\n" + 
				"	}\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 185, 1, "x", "Case_2.xtend");
	}
	
	@Test public void testSmokeTestFailure_01() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import com.google.inject.Inject\n" + 
				"import org.eclipse.emf.common.util.URI\n" + 
				"import org.eclipse.emf.ecore.EcoreFactory\n" + 
				"import org.eclipse.xtext.common.types.JvmConstructor\n" + 
				"import org.eclipse.xtext.common.types.JvmDeclaredType\n" + 
				"import org.eclipse.xtext.common.types.JvmGenericType\n" + 
				"import org.eclipse.xtext.resource.DerivedStateAwareResource\n" + 
				"import org.eclipse.xtext.resource.XtextResourceSet\n" + 
				"import org.eclipse.xtext.xbase.XbaseStandaloneSetup\n" + 
				"import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator\n" + 
				"import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder\n" + 
				"\n" + 
				"import static org.junit.Assert.*\n" + 
				"import org.eclipse.xtend.core.tests.AbstractXtendTestCase\n" + 
				"\n" + 
				"class Case_14 extends AbstractXtendTestCase {\n" + 
				"	\n" + 
				"	@Inject extension JvmTypesBuilder\n" + 
				"	@Inject JvmModelAssociator assoc\n" + 
				"	@Inject XtextResourceSet resourceSet\n" + 
				"	@Inject DerivedStateAwareResource resource\n" + 
				"	\n" + 
				"	def void testInference() {\n" + 
				"		assoc.inferrer = [obj, acceptor, preIndexing|\n" + 
				"			val firstType = obj.toClass('foo.Bar')\n" + 
				"			val secondType = obj.toClass('foo.Baz')\n" + 
				"			assertNull(secondType.eResource)\n" + 
				"			acceptor.accept(firstType).initializeLater[\n" + 
				"				^abstract = true\n" + 
				"				assertNotNull(firstType.eResource)\n" + 
				"				assertNotNull(secondType.eResource)\n" + 
				"			]\n" + 
				"			acceptor.accept(secondType).initializeLater[\n" + 
				"				^abstract = true\n" + 
				"				assertNotNull(firstType.eResource)\n" + 
				"			]\n" + 
				"		]\n" + 
				"		resource.setDerivedStateComputer(null)\n" + 
				"		resource.URI = URI::createURI('foo.txt')\n" + 
				"		resourceSet.classpathURIContext = getClass()\n" + 
				"		resourceSet.resources += resource\n" + 
				"		resource.contents += EcoreFactory::.createEClass\n" + 
				"		assoc.installDerivedState(resource,true)\n" + 
				"		assertFalse((resource.contents.get(1) as JvmDeclaredType).^abstract)\n" + 
				"		\n" + 
				"		resource.contents.clear\n" + 
				"		resource.contents += EcoreFactory::eINSTANCE.createEClass\n" + 
				"		assoc.installDerivedState(resource,false)\n" + 
				"		val type = (resource.contents.get(1) as JvmGenericType)\n" + 
				"		assertTrue(type.^abstract)\n" + 
				"		\n" + 
				"		// test extends object and default constructor\n" + 
				"		assertEquals(1, type.members.filter(typeof(JvmConstructor)).size)\n" + 
				"		assertEquals(\"java.lang.Object\", type.superTypes.head?.qualifiedName)\n" + 
				"	}\n" + 
				"	\n" + 
				"	\n" + 
				"}";
		doTestUpdateAtOffset(model, 1559, 1, "eINSTANCE", "Case_14.xtend");
	}
	
	@Test public void testSmokeTestFailure_02() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import com.google.inject.Inject\n" + 
				"import org.eclipse.emf.ecore.EcoreFactory\n" + 
				"import org.eclipse.xtend.core.tests.AbstractXtendTestCase\n" + 
				"import org.eclipse.xtext.resource.DerivedStateAwareResource\n" + 
				"import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator\n" + 
				"\n" + 
				"class Case_14 extends AbstractXtendTestCase {\n" + 
				"\n" + 
				"       @Inject JvmModelAssociator assoc\n" + 
				"       @Inject DerivedStateAwareResource resource\n" + 
				"\n" + 
				"       def void testInference() {\n" + 
				"               resource.contents += EcoreFactory::eINSTANC.createEClass\n" + 
				"               assoc.installDerivedState(resource,true)\n" + 
				"       }\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 526, 1, "E", "Case_14.xtend");
	}
	
	@Test public void testSmokeTestFailure_03() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"import com.google.inject.Inject\n" + 
				"import org.eclipse.emf.ecore.EcoreFactory\n" + 
				"import org.eclipse.xtend.core.tests.AbstractXtendTestCase\n" + 
				"import org.eclipse.xtext.resource.DerivedStateAwareResource\n" + 
				"import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator\n" + 
				"\n" + 
				"class Case_14 extends AbstractXtendTestCase {\n" + 
				"\n" + 
				"       @Inject JvmModelAssociator assoc\n" + 
				"       @Inject DerivedStateAwareResource resource\n" + 
				"\n" + 
				"       def void testInference() {\n" + 
				"               resource.contents += EcoreFactory::eINSTANCEcreateEClass\n" + 
				"               assoc.installDerivedState(resource,true)\n" + 
				"       }\n" + 
				"\n" + 
				"\n" + 
				"}";
		doTestUpdateAtOffset(model, 527, 1, ".", "Case_14.xtend");
	}
	
	@Test public void testSmokeTestFailure_04() throws Exception {
		String model = 
				"package org.eclipse.xtend.core.tests.smoke\n" + 
				"\n" + 
				"//interface HeaderAccess<T> {\n" + 
				"//   def T getHeader()\n" + 
				"//}\n" + 
				"//\n" + 
				"//interface IExpectationSetters<T> {\n" + 
				"//}\n" + 
				"//\n" + 
				"//class Y {\n" + 
				"// def public static <T> IExpectationSetters<T> expect(T value) {\n" + 
				"//     return null;\n" + 
				"// }\n" + 
				"//\n" + 
				"// private HeaderAccess<?> unboundedMockHeaderAccess;\n" + 
				"//\n" + 
				"// def public void test() {\n" + 
				"//   // no error:\n" + 
				"//   val Object header = unboundedMockHeaderAccess.getHeader();\n" + 
				"//   val IExpectationSetters<Object> exp1 = expect(header);\n" + 
				"//   val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader());\n" + 
				"// }\n" + 
				"//}\n" + 
				"\n" + 
				"class MyClass {\n" + 
				"\n" + 
				"}\n" + 
				"class X {\n" + 
				"	def <T ";
		doTestUpdateAtEnd(model, 'e', "Smoke.xtend");
	}
	
	@Test public void testSmokeTestFailure_05() throws Exception {
		String model = 
				"class C {\n" + 
				"	def m() {\n" + 
				"		val d = new D() {\n" + 
				"			/** comment */\n" + 
				"			final def op1() {\n" + 
				"			}\n" + 
				"			public def op2() {\n" + 
				"			}\n" + 
				"			private def op3() {\n" + 
				"			}\n" + 
				"			override toString() {\n" + 
				"			''\n" + 
				"			}\n" + 
				"		}\n" + 
				"		d.op1\n" + 
				"		d\n" + 
				"	}\n" + 
				"	static class D {\n" + 
				"	}\n" + 
				"}";
		doTestUpdateAtOffset(model, 168, 1, "\t", "Smoke.xtend");
	}
	
	@Test public void testSmokeTestFailure_06() throws Exception {
		String model = 
				"package generics class Bar {	def <T extends (Object)=>T> T bar(T t) { 		bar(apply(bar(t))	}}";
		doTestUpdateAtOffset(model, 76, 1, "t", "Smoke.xtend");
	}
	
	@Test public void testBug480818() throws Exception {
		String code = 
				"class Example {\n" + 
				" val greeting = 'hello world!'\n" +
				" def sayHello() {\n" +
				"   println(greeting)\n" +
				"   prinntln(greeting)\n" + 
				" }}";
		XtextResource resource = createResource(code, "Example.xtend");
		String before = EmfFormatter.listToStr(resource.getContents());
		resource.update(code.lastIndexOf("prinntln")+2, 1, "i");
		// here before bug 480818 was fixed a StackOverflowException occured 
		String after = EmfFormatter.listToStr(resource.getContents());
		assertEquals(before, after);
	}
	
	protected void validateWithoutException(XtextResource resource) {
		ResourceValidatorImpl validator = resourceValidatorProvider.get();
		assertNotSame(validator, resource.getResourceServiceProvider().getResourceValidator());
		validator.setDiagnosticConverter(new IDiagnosticConverter() {
			@Override
			public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof BasicDiagnostic) {
					List<?> data = diagnostic.getData();
					if (!data.isEmpty() && data.get(0) instanceof Throwable) {
						Throwable t = (Throwable) data.get(0);
						// the framework catches runtime exception
						// and AssertionError does not take a throwable as argument
						throw new Error(t);
					}
					if (EObjectValidator.DIAGNOSTIC_SOURCE.equals(diagnostic.getSource()) && diagnostic.getCode() == EObjectValidator.EOBJECT__EVERY_REFERENCE_IS_CONTAINED) {
						throw new Error(new RuntimeException("Dangling reference found."));
					}
				}
			}
			
			@Override
			public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof ExceptionDiagnostic) {
					Exception e = ((ExceptionDiagnostic) diagnostic).getException();
					// the framework catches runtime exception
					// and AssertionError does not take a throwable as argument
					throw new Error(new RuntimeException(e));
				}
			}
		});
		validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	protected XtextResource doTestUpdateAtEnd(String model, char character, String fileName) throws IOException {
		return doTestUpdateAtOffset(model, model.length(), 0, String.valueOf(character), fileName);
	}

	protected XtextResource doTestUpdateAtOffset(String model, int offset, int length, String newText, String fileName) throws IOException {
		XtextResource resource = createResource(model, fileName);
		compareWithNewResource(resource, model, offset, length, newText, fileName);
		return resource;
	}

	protected XtextResource createResource(String model, String fileName) throws IOException {
		XtextResourceSet resourceSet = getResourceSet();
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI(fileName));
		resource.load(new StringInputStream(model), null);
		return resource;
	}

	protected void compareWithNewResource(XtextResource resource, String model, int offset, int length, String newText,
			String fileName) throws IOException {
		resource.update(offset, length, newText);
		XtextResourceSet secondResourceSet = getResourceSet();
		XtextResource newResource = (XtextResource) secondResourceSet.createResource(URI.createURI(fileName));
		String newModel = new StringBuilder(model).replace(offset, offset + length, newText).toString();
		assertEquals(newModel, resource.getParseResult().getRootNode().getText());
		newResource.load(new StringInputStream(newModel), null);
		assertEquals(newResource.getContents().size(), resource.getContents().size());
		EcoreUtil.resolveAll(resource);
		EcoreUtil.resolveAll(newResource);
		for(int i = 0; i < resource.getContents().size(); i++) {
			assertEquals(EmfFormatter.objToStr(newResource.getContents().get(i)), EmfFormatter.objToStr(resource.getContents().get(i)));
		}
		assertEqualNodes(newResource, resource);
	}
	
	protected void assertEqualNodes(XtextResource expected, XtextResource actual) throws IOException {
		ICompositeNode expectedRoot = expected.getParseResult().getRootNode();
		invariantChecker.checkInvariant(expectedRoot);
		ICompositeNode actualRoot = actual.getParseResult().getRootNode();
		invariantChecker.checkInvariant(actualRoot);
		Iterator<INode> expectedIter = expectedRoot.getAsTreeIterable().iterator();
		Iterator<INode> actualIter = actualRoot.getAsTreeIterable().iterator();
		while(expectedIter.hasNext()) {
			assertTrue(actualIter.hasNext());
			assertEqualNodes(expectedIter.next(), actualIter.next());
		}
		assertFalse(actualIter.hasNext());
	}

	protected void assertEqualNodes(INode expected, INode actual) {
		assertEquals("class", expected.getClass(), actual.getClass());
		assertEquals("text", expected.getText(), actual.getText());
		assertEquals("total offset", expected.getTotalOffset(), actual.getTotalOffset());
		assertEquals("total length", expected.getTotalLength(), actual.getTotalLength());
		assertEquals("grammar element", expected.getGrammarElement(), actual.getGrammarElement());
		assertEquals("direct semantic element", expected.hasDirectSemanticElement(), actual.hasDirectSemanticElement());
//		assertTrue(EcoreUtil.equals(expected.getSemanticElement(), actual.getSemanticElement()));
		assertEquals("syntax error message", expected.getSyntaxErrorMessage(), actual.getSyntaxErrorMessage());
		if (expected instanceof ICompositeNode) {
			assertEquals("lookAhead", ((ICompositeNode) expected).getLookAhead(), ((ICompositeNode) actual).getLookAhead());
		}
	}
}
