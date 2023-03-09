/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ecore;

/**
 * Can be used to cause a side effect in workflow. As soon as this bean
 * is instantiated in a workflow, the {@link org.eclipse.xtext.resource.IResourceServiceProvider services}
 * for {@code *.ecore} files are registered. Existing services will not be replaced.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EcoreSupportStandaloneSetup {

	public static void setup() {
		new EcoreSupportStandaloneSetup();
	}
	
	public EcoreSupportStandaloneSetup() {
		new EcoreSupport().registerServices(false);
	}
	
}
