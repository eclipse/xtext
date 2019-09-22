/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelFactory;
import org.eclipse.xtext.example.domainmodel.ui.tests.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class LabelProviderTest {
  @Inject
  private ILabelProvider labelProvider;
  
  @Inject
  private IImageHelper imageHelper;
  
  @Extension
  private final DomainmodelFactory _domainmodelFactory = DomainmodelFactory.eINSTANCE;
  
  @Test
  public void package_image() {
    this.hasImage(this._domainmodelFactory.createPackageDeclaration(), "PackageDeclaration.gif");
  }
  
  @Test
  public void entity_image() {
    this.hasImage(this._domainmodelFactory.createEntity(), "Entity.gif");
  }
  
  @Test
  public void property_image() {
    this.hasImage(this._domainmodelFactory.createProperty(), "Property.gif");
  }
  
  @Test
  public void operation_image() {
    this.hasImage(this._domainmodelFactory.createOperation(), "Operation.gif");
  }
  
  private void hasImage(final EObject eObject, final String image) {
    final Image actual = this.labelProvider.getImage(eObject);
    final Image expected = this.imageHelper.getImage(image);
    Assert.assertEquals(expected, actual);
  }
}
