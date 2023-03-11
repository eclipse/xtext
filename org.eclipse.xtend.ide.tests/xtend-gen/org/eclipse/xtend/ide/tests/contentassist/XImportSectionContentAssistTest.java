/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XImportSectionContentAssistTest extends AbstractXtendContentAssistBugTest {
  @Test
  public void testMemberName() {
    try {
      final ContentAssistProcessorTestBuilder builder = this.newBuilder().append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.").assertTextAtCursorPosition("Foo.", "Foo.".length(), "publicStaticMethod", "publicStaticField");
      builder.applyProposal("publicStaticMethod").expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod");
      builder.applyProposal("publicStaticField").expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMemberName_2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticM");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {}");
      _newBuilder.append(_builder.toString()).assertTextAtCursorPosition("publicStaticM", "publicStaticM".length(), "publicStaticMethod");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMemberName_3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.");
      final ContentAssistProcessorTestBuilder builder = _newBuilder.append(_builder.toString()).assertText("publicStaticMethod", "defaultStaticMethod", "protectedStaticMethod", 
        "publicStaticField", "defaultStaticField", "protectedStaticField");
      ContentAssistProcessorTestBuilder _applyProposal = builder.applyProposal("publicStaticMethod");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod");
      _applyProposal.expectContent(_builder_1.toString());
      ContentAssistProcessorTestBuilder _applyProposal_1 = builder.applyProposal("defaultStaticMethod");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticMethod");
      _applyProposal_1.expectContent(_builder_2.toString());
      ContentAssistProcessorTestBuilder _applyProposal_2 = builder.applyProposal("protectedStaticMethod");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticMethod");
      _applyProposal_2.expectContent(_builder_3.toString());
      ContentAssistProcessorTestBuilder _applyProposal_3 = builder.applyProposal("publicStaticField");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField");
      _applyProposal_3.expectContent(_builder_4.toString());
      ContentAssistProcessorTestBuilder _applyProposal_4 = builder.applyProposal("defaultStaticField");
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_5.newLine();
      _builder_5.newLine();
      _builder_5.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticField");
      _applyProposal_4.expectContent(_builder_5.toString());
      ContentAssistProcessorTestBuilder _applyProposal_5 = builder.applyProposal("protectedStaticField");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_6.newLine();
      _builder_6.newLine();
      _builder_6.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticField");
      _applyProposal_5.expectContent(_builder_6.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMemberName_4() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.default");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {}");
      _newBuilder.append(_builder.toString()).assertTextAtCursorPosition("default", "default".length(), "defaultStaticMethod", "defaultStaticField");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_operation() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("staticMethod()");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("staticMethod()");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_operation_direct() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".staticMethod");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("staticMethod()");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("staticMethod()");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_operation_direct_extension() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".staticMethod");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\"foo\".");
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("staticMethod");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static extension org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"foo\".staticMethod");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_operation_extension() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\"foo\".");
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("staticMethod");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static extension org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"foo\".staticMethod");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_field() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("STATICFIELD");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.STATICFIELD");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("STATICFIELD");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_no_constructor() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<|>");
        _newBuilder.append(_builder.toString()).assertNoProposalAtCursor("StaticClassExample");
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_no_proposal_non_static_operation() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<|>");
        _newBuilder.append(_builder.toString()).assertNoProposalAtCursor("nonStaticMethod");
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_no_proposal_non_static_operation_extension() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\"FOO\".<|>");
        _newBuilder.append(_builder.toString()).assertNoProposalAtCursor("nonStaticMethod");
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_field_No_additional_import() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("STATICFIELD");
        _builder.newLine();
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("STATICFIELD");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.STATICFIELD");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("STATICFIELD");
        _builder_1.newLine();
        _builder_1.append("STATICFIELD");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticFavoriteImports_No_additional_import() {
    try {
      final String defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
      final IEclipsePreferences jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN);
      try {
        String _name = StaticClassExample.class.getName();
        String _plus = (_name + ".*");
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, _plus);
        ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package mypack");
        _builder.newLine();
        _builder.append("class Bar{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void foo(){");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("staticMethod()");
        _builder.newLine();
        ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("staticMethod()");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package mypack");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def void foo(){");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("staticMethod()");
        _builder_1.newLine();
        _builder_1.append("staticMethod()");
        _applyProposal.expectContent(_builder_1.toString());
      } finally {
        jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
