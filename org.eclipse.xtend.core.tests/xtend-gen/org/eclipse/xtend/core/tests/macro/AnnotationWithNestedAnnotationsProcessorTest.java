/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationWithNestedAnnotationsProcessorTest extends AbstractActiveAnnotationTest {
  @Test
  public void testIssue624() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation1(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ann2=@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation2(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ann3=#[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("class Entity {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation1(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ann2=@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation2(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ann3=#[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation3,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations$Annotation3");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("class Entity2 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : /myProject/xtend-gen/Entity.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@AnnotationWithNestedAnnotations.Annotation1(ann2 = @AnnotationWithNestedAnnotations.Annotation2(ann3 = {}))");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Entity {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : /myProject/xtend-gen/Entity2.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@AnnotationWithNestedAnnotations.Annotation1(ann2 = @AnnotationWithNestedAnnotations.Annotation2(ann3 = { @AnnotationWithNestedAnnotations.Annotation3, @AnnotationWithNestedAnnotations.Annotation3 }))");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Entity2 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
