/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeElementDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;

@SuppressWarnings("all")
public class MutableJvmAnnotationTypeElementDeclarationImpl extends JvmAnnotationTypeElementDeclarationImpl implements MutableAnnotationTypeElementDeclaration {
  public MutableAnnotationReference findAnnotation(final Type annotationType) {
    AnnotationReference _findAnnotation = super.findAnnotation(annotationType);
    return ((MutableAnnotationReference) _findAnnotation);
  }
  
  public Iterable<? extends MutableAnnotationReference> getAnnotations() {
    return this.<MutableAnnotationReference>getAnnotations(MutableAnnotationReference.class);
  }
  
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
}
