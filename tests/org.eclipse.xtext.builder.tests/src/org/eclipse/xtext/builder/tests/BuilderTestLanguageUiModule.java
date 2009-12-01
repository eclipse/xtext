/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import org.eclipse.xtext.resource.IContainer.Manager;
import org.eclipse.xtext.ui.core.scoping.namespaces.JavaProjectAwareContainerManager;

/**
 * Use this class to register components to be used within the IDE.
 */
public class BuilderTestLanguageUiModule extends org.eclipse.xtext.builder.tests.AbstractBuilderTestLanguageUiModule {
	@Override
	public Class<? extends Manager> bindIContainer$Manager() {
		return JavaProjectAwareContainerManager.class;
	}
}
