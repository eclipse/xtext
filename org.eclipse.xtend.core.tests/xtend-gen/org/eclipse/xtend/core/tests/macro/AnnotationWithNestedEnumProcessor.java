/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationWithNestedEnumProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, final RegisterGlobalsContext context) {
    context.registerInterface(this.getInterfaceName(annotatedClass));
  }

  public String getInterfaceName(final ClassDeclaration annotatedClass) {
    String _qualifiedName = annotatedClass.getQualifiedName();
    return (_qualifiedName + "Interface");
  }

  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final MutableInterfaceDeclaration interfaceType = context.findInterface(this.getInterfaceName(annotatedClass));
    context.setPrimarySourceElement(interfaceType, annotatedClass);
    try {
      final EnumerationValueDeclaration value = annotatedClass.findAnnotation(context.findTypeGlobally(AnnotationWithNestedEnum.class)).getEnumValue("value");
      final Procedure1<AnnotationReferenceBuildContext> _function = (AnnotationReferenceBuildContext it) -> {
        it.setEnumValue("value", value);
      };
      final AnnotationReference ref = context.newAnnotationReference(AnnotationWithNestedEnum.class, _function);
      interfaceType.addAnnotation(ref);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
        String _message = exc.getMessage();
        String _plus = ("failed: " + _message);
        context.addError(annotatedClass, _plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
