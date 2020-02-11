/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.annotations;

import com.google.inject.Singleton;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;

/**
 * A class annotation configuration for the <code>@Singleton</code> annotation.
 */
@SuppressWarnings("all")
public class SingletonClassAnnotation implements IClassAnnotation {
  @Override
  public CharSequence generate() {
    return "@Singleton";
  }
  
  @Override
  public boolean appliesTo(final JavaFileAccess javaFile) {
    return true;
  }
  
  @Override
  public TypeReference getAnnotationImport() {
    return new TypeReference(Singleton.class);
  }
  
  @Override
  public String toString() {
    return this.generate().toString();
  }
  
  @Override
  public boolean equals(final Object obj) {
    return (obj instanceof SingletonClassAnnotation);
  }
  
  @Override
  public int hashCode() {
    return this.getClass().getName().hashCode();
  }
}
