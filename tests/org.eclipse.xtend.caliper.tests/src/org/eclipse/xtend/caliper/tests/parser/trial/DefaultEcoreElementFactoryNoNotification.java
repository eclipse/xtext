/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.parser.trial;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultEcoreElementFactoryNoNotification extends DefaultEcoreElementFactory {

	@Override
	public EObject create(EClassifier classifier) {
		EObject result = super.create(classifier);
		result.eSetDeliver(false);
		return result;
	}

}
