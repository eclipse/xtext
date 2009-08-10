///*******************************************************************************
// * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// *******************************************************************************/
//package org.eclipse.xtext.parsetree.reconstr;
//
//import org.apache.log4j.Logger;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.xtext.ParserRule;
//import org.eclipse.xtext.resource.XtextResourceSet;
//import org.eclipse.xtext.tests.AbstractGeneratorTest;
//import org.eclipse.xtext.tests.EmfAssert;
//import org.eclipse.xtext.util.EmfFormatter;
//
//public class ComplexReconstrTest extends AbstractGeneratorTest {
//
//	private static final Logger logger = Logger
//			.getLogger(ComplexReconstrTest.class);
//
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
////		with(ComplexReconstrTestLanguageStandaloneSetup.class);
//	}
//
//	public void testPrintGrammar() {
//		XtextResourceSet rs = get(XtextResourceSet.class);
//		rs.setClasspathURIContext(getClass());
//		URI u = URI
//				.createURI("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi");
//		EObject o = rs.getResource(u, true).getContents().get(0);
//		for (Object x : o.eContents())
//			if (x instanceof ParserRule) {
//				ParserRule pr = (ParserRule) x;
//				if (pr.getName().toLowerCase().contains("tricky")) {
//					if (logger.isTraceEnabled())
//						logger.trace(EmfFormatter.objToStr(pr));
//				}
//			}
//	}
//
//	public void testSimple() throws Exception {
//		String model = "( a + b - c ) !";
//		assertEquals(model, parseAndSerialize(model));
//	}
//
//	public void testComplex() throws Exception {
//		String model = "( ( a + b ) ! - c + d + e + f - ( ^x + s ) - ( ( a + b ) ! - c ) ! ) !";
//		assertEquals(model, parseAndSerialize(model));
//	}
//
//	private String parseAndSerialize(String model) throws Exception {
//		EObject result = getModel(model);
//		if (logger.isTraceEnabled())
//			logger.trace(EmfFormatter.objToStr(result));
//		return getSerializer().serialize(result, false);
//	}
//
//	public void testNormalizableCompositeNodesIncluded() throws Exception {
//		reconstructAndCompare("a");
//		reconstructAndCompare("a + b");
//	}
//
//	public void testTrickyGSimple() throws Exception {
//		String model = "TG [[2]]";
//		assertEquals(model, parseAndSerialize(model));
//	}
//
//	public void testTrickyGWithNull() throws Exception {
//		String model = "TG [0,[2,0],3,4,0]";
//		assertEquals(model, parseAndSerialize(model));
//	}
//
//	public void testTrickyGComplex() throws Exception {
//		String model = "TG [2, [2,3,45,6],242,[23423,[34,34,[242343],234]]]";
//		assertEquals(model, parseAndSerialize(model));
//	}
//
//	private void reconstructAndCompare(String mymodel) throws Exception,
//			InterruptedException {
//		EObject model = getModel(mymodel);
//		EObject model2 = getModel(parseAndSerialize(mymodel));
//		EmfAssert.assertEObjectsEqual(model, model2);
//	}
//
//}
