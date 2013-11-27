/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared;

import org.eclipse.xtext.ui.resource.IResourceSetInitializer;
import org.eclipse.xtext.ui.resource.JavaProjectResourceSetInitializer;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow
 */
public class CommonTypesContribution implements Module {

	public void configure(Binder binder) {
		binder.bind(IResourceSetInitializer.class).to(JavaProjectResourceSetInitializer.class);
	}

}
