/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.scoping;

import static com.google.common.collect.Iterables.*;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.ImportedURIPackage;
import org.eclipse.xtext.linking.importedURI.Main;
import org.eclipse.xtext.linking.importedURI.Type;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class URINormalizationTest extends AbstractXtextTests {

	@Test public void testGetElementByClasspathURIEObject() throws Exception {
		with(ImportUriTestLanguageStandaloneSetup.class);
		Main main = (Main) getModel("import 'classpath:/org/eclipse/xtext/linking/05.importuritestlanguage'\n"
				+ "type Bar extends Foo");
		Type bar = main.getTypes().get(0);
		Type foo = bar.getExtends();
		assertNotNull(foo);
		assertFalse(foo.eIsProxy());
		// we don't put contextual classpath:/ uris into the index thus
		// they are partially normalized
		if (Platform.isRunning()) {
			assertEquals("bundleresource", EcoreUtil.getURI(foo).scheme());
		} else {
			assertEquals("file", EcoreUtil.getURI(foo).scheme());
		}
		IScopeProvider scopeProvider = get(IScopeProvider.class);
		IScope scope = scopeProvider.getScope(bar, ImportedURIPackage.Literals.TYPE__EXTENDS);
		Iterable<IEObjectDescription> elements = scope.getElements(foo);
		assertEquals(1, size(elements));
		assertEquals(EcoreUtil2.getPlatformResourceOrNormalizedURI(foo), elements.iterator().next().getEObjectURI());
	}
	
}
