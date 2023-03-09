/**
 * Copyright (c) 2016, 2020 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.jvmmodel.JvmElementsProxifyingUnloader;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeChangeDispatcherNotLeakingTest extends AbstractJvmModelTest {
	@Inject
	private ReflectExtensions reflectExtensions;

	@Inject
	private JvmElementsProxifyingUnloader unloader;

	@Test
	public void testNoLeaking() throws Exception {
		String contents = "{val x = \"foo\" print(x)}";
		XtextResource resource = (XtextResource) newResource(contents);
		EcoreUtil.resolveAll(resource);
		JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(resource.getResourceSet());
		List<Runnable> listeners = reflectExtensions.get(dispatcher, "listeners");
		Assert.assertEquals(2, listeners.size());
		resource.reparse(contents);
		EcoreUtil.resolveAll(resource);
		listeners = reflectExtensions.get(dispatcher, "listeners");
		Assert.assertEquals(2, listeners.size());
		EObject jvmType = resource.getContents().get(1);
		unloader.unloadRoot(jvmType);
		resource.getContents().remove(jvmType);
		listeners = reflectExtensions.get(dispatcher, "listeners");
		Assert.assertEquals(0, listeners.size());
	}
}
