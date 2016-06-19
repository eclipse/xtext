/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.LiveContainerTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.liveContainerTestLanguage.LiveContainerTestLanguagePackage;
import org.eclipse.xtext.testing.InjectWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(LiveContainerTestLanguageInjectorProvider.class)
public class LiveContainerTest extends AbstractLiveContainerTest {

	@Override
	protected EClass getModelRootType() {
		return LiveContainerTestLanguagePackage.Literals.MODEL;
	}

}
