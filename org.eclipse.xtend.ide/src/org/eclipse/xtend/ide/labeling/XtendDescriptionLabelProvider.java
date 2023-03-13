/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.labeling;

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.xtend.core.resource.DescriptionFlags;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class XtendDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	@Inject
	private XtendImages images;

	@Inject
	private DescriptionFlags descriptionFlags;

	@Override
	public Object image(IEObjectDescription element) {
		EClass eClass = element.getEClass();
		int adornments = (descriptionFlags.isStatic(element)) ? JavaElementImageDescriptor.STATIC : 0;
		if (eClass == XTEND_FILE)
			return images.forFile();
		else if (eClass == XIMPORT_DECLARATION)
			return images.forImport();
		else if (eClass == XTEND_CLASS || eClass == TypesPackage.Literals.JVM_GENERIC_TYPE)
			return images.forClass(JvmVisibility.PUBLIC, adornments);
		else if (eClass == XTEND_FUNCTION)
			return images.forOperation(JvmVisibility.PUBLIC, adornments);
		else if (eClass == XTEND_FIELD)
			return images.forField(JvmVisibility.PUBLIC, adornments);
		else if (eClass == TypesPackage.Literals.JVM_OPERATION)
			return (descriptionFlags.isDispatcherOperation(element)) 
				? images.forDispatcherFunction(JvmVisibility.PUBLIC, adornments) 
				: images.forOperation(JvmVisibility.PUBLIC, adornments);
		else
			return super.image(element);
	}

}
