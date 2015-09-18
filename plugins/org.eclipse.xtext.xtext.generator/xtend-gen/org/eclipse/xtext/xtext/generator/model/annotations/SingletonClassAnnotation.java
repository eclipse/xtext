/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
    CharSequence _generate = this.generate();
    return _generate.toString();
  }
}
