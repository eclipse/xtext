/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages2;
import org.eclipse.xtext.xtype.XtypeFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
public class LabelProviderTest {
	@Inject
	private ILabelProvider labelProvider;

	@Inject
	private IImageHelper imageHelper;

	@Inject
	private XbaseImages2 xbaseImages;

	private final DomainmodelFactory domainmodelFactory = DomainmodelFactory.eINSTANCE;

	private final XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;

	@Test
	public void package_image() {
		hasImage(domainmodelFactory.createPackageDeclaration(), "PackageDeclaration.gif");
	}

	@Test
	public void import_section_image() {
		hasImage(xtypeFactory.createXImportSection(), xbaseImages.forImportContainer());
	}

	@Test
	public void import_declaration_image() {
		hasImage(xtypeFactory.createXImportDeclaration(), xbaseImages.forImport());
	}

	@Test
	public void entity_image() {
		hasImage(domainmodelFactory.createEntity(), "Entity.gif");
	}

	@Test
	public void property_image() {
		hasImage(domainmodelFactory.createProperty(), "Property.gif");
	}

	@Test
	public void operation_image() {
		hasImage(domainmodelFactory.createOperation(), "Operation.gif");
	}

	private void hasImage(EObject eObject, String image) {
		Image actual = labelProvider.getImage(eObject);
		Image expected = imageHelper.getImage(image);
		Assert.assertEquals(expected, actual);
	}

	private void hasImage(EObject eObject, ImageDescriptor descriptor) {
		Image actual = labelProvider.getImage(eObject);
		Image expected = imageHelper.getImage(descriptor);
		Assert.assertEquals(expected, actual);
	}
}
