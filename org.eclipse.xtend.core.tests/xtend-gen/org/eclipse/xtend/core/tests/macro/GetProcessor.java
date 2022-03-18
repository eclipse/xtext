/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class GetProcessor implements TransformationParticipant<MutableMethodDeclaration> {
  @Override
  public void doTransform(final List<? extends MutableMethodDeclaration> methods, @Extension final TransformationContext context) {
    for (final MutableMethodDeclaration m : methods) {
      {
        final AnnotationReference annotation = m.findAnnotation(context.findTypeGlobally(Get.class));
        final Object pattern = annotation.getValue("value");
        if ((pattern == null)) {
          context.addError(annotation, "A URL pattern must be provided.");
        } else {
        }
      }
    }
  }
}
