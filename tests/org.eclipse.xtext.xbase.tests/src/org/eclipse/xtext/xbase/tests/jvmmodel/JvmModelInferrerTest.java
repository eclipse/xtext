/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel;

import static com.google.common.collect.Lists.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmModelInferrerTest {
	public static class MyOldInferrer extends AbstractModelInferrer {
		public final List<EObject> other = newArrayList();
		public void infer (EObject o, Object x, boolean s) {
			if (o instanceof EClass)
				throw new IllegalArgumentException();
			other.add(o);
		}
	}
	@Test
	public void testCompatibility() throws Exception {
		EClass clazz = EcorePackage.Literals.ECLASS;
		MyOldInferrer inferrer = new MyOldInferrer();
		inferrer.infer(clazz, new IJvmDeclaredTypeAcceptor() {
			public <T extends JvmDeclaredType> IPostIndexingInitializing<T> accept(T type) {
				return null;
			}
		}, false);
		assertFalse(inferrer.other.isEmpty());
		assertEquals(clazz.eContents().size(), inferrer.other.size());
		
	}
}
