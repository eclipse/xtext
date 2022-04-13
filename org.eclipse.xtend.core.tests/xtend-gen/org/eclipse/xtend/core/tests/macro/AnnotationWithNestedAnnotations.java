/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public interface AnnotationWithNestedAnnotations {
  @Target(ElementType.TYPE)
  @Active(AnnotationWithNestedAnnotationsProcessor.class)
  @Retention(RetentionPolicy.RUNTIME)
  @interface Annotation1 {
    public AnnotationWithNestedAnnotations.Annotation2[] ann2() default {};
  }

  @Target(ElementType.TYPE)
  @Active(AnnotationWithNestedAnnotationsProcessor.class)
  @Retention(RetentionPolicy.RUNTIME)
  @interface Annotation2 {
    public AnnotationWithNestedAnnotations.Annotation3[] ann3() default {};
  }

  @Target(ElementType.TYPE)
  @Active(AnnotationWithNestedAnnotationsProcessor.class)
  @Retention(RetentionPolicy.RUNTIME)
  @interface Annotation3 {
  }

  @ToString
  @Accessors
  class Annotation1Config {
    private final AnnotationWithNestedAnnotations.Annotation2Config[] ann2Configs;

    public Annotation1Config(final AnnotationReference ann) {
      final Function1<AnnotationReference, AnnotationWithNestedAnnotations.Annotation2Config> _function = (AnnotationReference it) -> {
        return new AnnotationWithNestedAnnotations.Annotation2Config(it);
      };
      this.ann2Configs = ((AnnotationWithNestedAnnotations.Annotation2Config[])Conversions.unwrapArray(ListExtensions.<AnnotationReference, AnnotationWithNestedAnnotations.Annotation2Config>map(((List<AnnotationReference>)Conversions.doWrapArray(ann.getAnnotationArrayValue("ann2"))), _function), AnnotationWithNestedAnnotations.Annotation2Config.class));
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("ann2Configs", this.ann2Configs);
      return b.toString();
    }

    @Pure
    public AnnotationWithNestedAnnotations.Annotation2Config[] getAnn2Configs() {
      return this.ann2Configs;
    }
  }

  @ToString
  @Accessors
  class Annotation2Config {
    private final AnnotationWithNestedAnnotations.Annotation3Config[] ann3Configs;

    public Annotation2Config(final AnnotationReference ann) {
      final Function1<AnnotationReference, AnnotationWithNestedAnnotations.Annotation3Config> _function = (AnnotationReference it) -> {
        return new AnnotationWithNestedAnnotations.Annotation3Config(it);
      };
      this.ann3Configs = ((AnnotationWithNestedAnnotations.Annotation3Config[])Conversions.unwrapArray(ListExtensions.<AnnotationReference, AnnotationWithNestedAnnotations.Annotation3Config>map(((List<AnnotationReference>)Conversions.doWrapArray(ann.getAnnotationArrayValue("ann3"))), _function), AnnotationWithNestedAnnotations.Annotation3Config.class));
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("ann3Configs", this.ann3Configs);
      return b.toString();
    }

    @Pure
    public AnnotationWithNestedAnnotations.Annotation3Config[] getAnn3Configs() {
      return this.ann3Configs;
    }
  }

  @ToString
  @Accessors
  class Annotation3Config {
    public Annotation3Config(final AnnotationReference ann) {
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      return b.toString();
    }
  }
}
