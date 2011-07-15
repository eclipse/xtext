/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.generator.GenModelAccess;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenModelAccessTestGenerator extends AbstractWorkflowComponent2 {

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String java = "platform:/resource/org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/ecore/genmodelaccess/root/AccessTest.java";
		String ecore = "platform:/resource/org.eclipse.xtext.tests/src/org/eclipse/xtext/generator/ecore/GenModelAccessTest.ecore";
		ResourceSet rs = new XtextResourceSet();
		EPackage root = (EPackage) rs.getResource(URI.createURI(ecore), true).getContents().get(0);
		try {
			PrintStream print = new PrintStream(URIConverter.INSTANCE.createOutputStream(URI.createURI(java)));
			print.println("package org.eclipse.xtext.generator.ecore.genmodelaccess.root;");
			print.println();
			print.println("import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package;");
			print.println("import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage;");
			print.println("import junit.framework.TestCase;");
			print.println("import junit.framework.Assert;");
			print.println();
			print.println("public abstract class AccessTest extends TestCase {");

			EClass rootClass = (EClass) root.getEClassifier("RootClass");
			EReference rootRef = (EReference) rootClass.getEStructuralFeature("reference1");
			EAttribute rootAttr = (EAttribute) rootClass.getEStructuralFeature("attribute1");
			EDataType rootDataType = (EDataType) root.getEClassifier("RootDataType");
			EEnum rootEnum = (EEnum) root.getEClassifier("RootEnum");
			print.println("	public void testRootPackage() {");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(root, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(rootClass, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(rootDataType, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(rootEnum, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(rootAttr, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(rootRef, rs) + ");");
			print.println("		Assert.assertEquals(0," + GenModelAccess.getGenIntLiteral(rootClass, rs) + ");");
			print.println("		Assert.assertEquals(2," + GenModelAccess.getGenIntLiteral(rootDataType, rs) + ");");
			print.println("		Assert.assertEquals(1," + GenModelAccess.getGenIntLiteral(rootEnum, rs) + ");");
			print.println("		Assert.assertEquals(0," + GenModelAccess.getGenIntLiteral(rootClass, rootAttr, rs) + ");");
			print.println("		Assert.assertEquals(1," + GenModelAccess.getGenIntLiteral(rootClass, rootRef, rs) + ");");
			print.println("	}\n");

			EPackage nested = root.getESubpackages().get(0);
			EClass nestedClass = (EClass) nested.getEClassifier("NestedClass1");
			print.println("	public void testNestedPackage() {");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(nested, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(nestedClass, rs) + ");");
			print.println("		Assert.assertEquals(0," + GenModelAccess.getGenIntLiteral(nestedClass, rs) + ");");
			print.println("	}\n");

			EPackage noLit = root.getESubpackages().get(1);
			EClass noLitClass = (EClass) noLit.getEClassifier("NoLitClass");
			EDataType noLitDataType = (EDataType) noLit.getEClassifier("NoLitDataType");
			EReference noLitRef = (EReference) noLitClass.getEStructuralFeature("reference2");
			EAttribute noLitAttr = (EAttribute) noLitClass.getEStructuralFeature("attribute2");
			EDataType noLitEnum = (EDataType) noLit.getEClassifier("NoLitEnum");
			print.println("	public void testNoLiteralPackage() {");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(noLit, rs) + ");");
			print.println("		Assert.assertFalse(" + GenModelAccess.getGenPackage(noLit, rs).isLiteralsInterface()
					+ ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(noLitClass, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(noLitDataType, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(noLitAttr, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(noLitRef, rs) + ");");
			print.println("		Assert.assertNotNull(" + GenModelAccess.getGenTypeLiteral(noLitEnum, rs) + ");");
			print.println("	}");
			print.println("}");

			print.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
