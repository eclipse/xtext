/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.ecore;

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
