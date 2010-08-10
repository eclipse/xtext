/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AllContentsPerformanceTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	private static int LOOPS = 50 /* 000 */;
	
	public void testDummy() {
		EcorePackage.eINSTANCE.getEAnnotation();
		XtextPackage.eINSTANCE.getEAnnotations();
	}
	
	public void testEcore() {
		doTest(EcorePackage.eINSTANCE);
	}
	
	public void testEcoreUoW() throws Exception {
		doTestUoW(EcorePackage.eINSTANCE);
	}
	
	public void testXtext() {
		doTest(XtextPackage.eINSTANCE);
	}
	
	public void testXtextUoW() throws Exception {
		doTestUoW(XtextPackage.eINSTANCE);
	}
	
	public void testXtextGrammar() {
		doTest(getGrammarAccess().getGrammar());
	}
	
	public void testXtextGrammarUoW() throws Exception {
		doTestUoW(getGrammarAccess().getGrammar());
	}
	
	
	private void doTest(EObject object) {
		int callCount = 0;
		for(int i = 0; i < LOOPS; i++) {
			TreeIterator<Object> iterator = EcoreUtil.getAllContents(object, true);
			callCount++;
			while(iterator.hasNext()) {
				iterator.next();
				callCount++;
			}
		}
		System.out.println(callCount);
	}
	
	private void doTestUoW(EObject object) throws Exception {
		final int callCount[] = new int[]{0};
		IUnitOfWork<Boolean, EObject> uow = new IUnitOfWork<Boolean, EObject>(){
			public Boolean exec(EObject state) throws Exception {
				callCount[0]++;
				return false;
			}
		};
		for(int i = 0; i < LOOPS; i++) {
			doTestUoWImpl(object, uow);
		}
		System.out.println(callCount[0]);
	}
		

	private void doTestUoWImpl(EObject object, IUnitOfWork<Boolean, EObject> uow) throws Exception {
		if (object == null)
			return;
		if (!uow.exec(object).booleanValue()) {
			EClass clazz = object.eClass();
			for(EReference reference: clazz.getEAllContainments()) {
				// object.eIsSet(..) decreased performance - TODO: investigate the reason
				// TODO: handle feature maps 
				// TODO: What's FeatureListIterator#useIsSet about?
				if (reference.isMany()) {
					@SuppressWarnings("unchecked")
					List<EObject> values = (List<EObject>) object.eGet(reference);
					for(int i = 0; i<values.size(); i++) {
						doTestUoWImpl(values.get(i), uow);
					}
				} else {
					doTestUoWImpl((EObject) object.eGet(reference), uow);
				}
			}
		}
	}

}
