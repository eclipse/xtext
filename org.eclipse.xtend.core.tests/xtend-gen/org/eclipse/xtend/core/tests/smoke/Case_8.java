/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.smoke;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class Case_8 {
  @Inject
  @Extension
  private ParseHelper<EObject> helper;

  @Inject
  @Extension
  private IQualifiedNameProvider qualifiedNameProvider;

  public EList<Resource.Diagnostic> getErrors(final EObject obj) {
    return obj.eResource().getErrors();
  }

  public void resolve(final EObject obj) {
    EcoreUtil.resolveAll(obj.eResource());
  }

  public EObject parseAcme(final CharSequence seq) {
    try {
      return IterableExtensions.<EObject>head(this.helper.parse(seq).eContents());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Inject
  public void explicitName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("com.acme.SimpleElement as FooBar {}");
    _builder.newLine();
    final EObject element = this.parseAcme(_builder);
    Assert.assertEquals("FooBar", this.qualifiedNameProvider.getFullyQualifiedName(element).toString());
  }

  public <T1 extends Object> List<List<T1>> foo(final T1 t) {
    return null;
  }
}
