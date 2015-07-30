/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug473721 extends LightXtendTest {
  public void testBug473721() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package somePackage;");
    _builder.newLine();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("somePackage/Foo.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package otherPackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import somePackage.Foo");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Data class Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Foo myFoo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile file = this.myFixture.addFileToProject("otherPackage/Bar.xtend", _builder_1.toString());
    VirtualFile _findFileInTempDir = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Bar.java");
    boolean _exists = _findFileInTempDir.exists();
    TestCase.assertTrue(_exists);
    VirtualFile _virtualFile = file.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
}
