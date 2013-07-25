/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug410555Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface SAMInterface {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void test()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class BugSAM {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(SAMInterface e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// seems ok");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new BugSAM([|])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class BugSAM2 extends BugSAM {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super([|])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public interface SAMInterface {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public abstract void test();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class BugSAM2 extends BugSAM {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super([|])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface SAMInterface {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void test()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class BugSAM {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(SAMInterface e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// seems ok");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new BugSAM([|])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugSAM2 extends BugSAM {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugSAM2() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(new SAMInterface() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public void test() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class BugSAM {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(SAMInterface e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this [|]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new BugSAM([|])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface SAMInterface {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void test()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class BugSAM2 extends BugSAM {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super([|])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class BugSAM {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugSAM(final SAMInterface e) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public BugSAM() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this(new SAMInterface() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public void test() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final SAMInterface _function = new SAMInterface() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public void test() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("new BugSAM(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
