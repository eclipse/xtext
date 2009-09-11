/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.quickfix;

import junit.framework.TestCase;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.xtext.ui.core.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.core.editor.quickfix.Fix;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DeclarativeQuickfixProviderTest extends TestCase {

	private static final int DUMMY_CODE = 42;

	public void testHasResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider generator = new AbstractDeclarativeQuickfixProvider() {
			@Override
			protected EObject getContext(IMarker marker) {
				return ((MockMarker) marker).getContext();
			}

			@Fix(code = DUMMY_CODE)
			@SuppressWarnings("unused")
			public void fixError(EObject obj, IMarker marker) {
			}
		};
		IMarker marker = MockMarker.newFastErrorMarker(null, null, null);
		assertFalse(generator.hasResolutions(marker));
		marker = MockMarker.newFastErrorMarker(null, EcorePackage.eINSTANCE.getEClass(), DUMMY_CODE);
		assertTrue(generator.hasResolutions(marker));
		assertEquals(1, generator.getResolutions(marker).length);
	}

	public void testGetResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider generator = new AbstractDeclarativeQuickfixProvider() {
			@Override
			protected EObject getContext(IMarker marker) {
				return ((MockMarker) marker).getContext();
			}

			@Fix(code = DUMMY_CODE, label = "fixError1")
			@SuppressWarnings("unused")
			public void fixError1(EObject obj, IMarker marker) {
			}

			@Fix(code = DUMMY_CODE, label = "fixError2")
			@SuppressWarnings("unused")
			public void fixError2(EPackage obj, IMarker marker) {
			}

			@Fix(code = DUMMY_CODE, label = "fixError3")
			@SuppressWarnings("unused")
			public void fixError3(EClass obj, IMarker marker) {
			}
		};
		IMarker marker = MockMarker.newFastErrorMarker(null, null, null);
		IMarkerResolution[] resolutions = generator.getResolutions(marker);
		assertEquals(0, resolutions.length);
		marker = MockMarker.newFastErrorMarker(null, EcorePackage.eINSTANCE.getEClass(), DUMMY_CODE);
		resolutions = generator.getResolutions(marker);
		assertEquals(2, resolutions.length);
		assertEquals("fixError1", resolutions[0].getLabel());
		assertEquals("fixError3", resolutions[1].getLabel());
	}

}
