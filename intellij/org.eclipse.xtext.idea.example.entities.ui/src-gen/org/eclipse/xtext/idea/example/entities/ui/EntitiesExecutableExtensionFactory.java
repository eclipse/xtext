/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.idea.example.entities.ui.internal.EntitiesActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EntitiesExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return EntitiesActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return EntitiesActivator.getInstance().getInjector(EntitiesActivator.ORG_ECLIPSE_XTEXT_IDEA_EXAMPLE_ENTITIES_ENTITIES);
	}
	
}
