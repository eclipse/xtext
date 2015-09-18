/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.config;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.config.GradleBuildFileUtility;
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jetbrains.idea.maven.model.MavenId;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrStatement;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.blocks.GrClosableBlock;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrApplicationStatement;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrCommandArgumentList;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrExpression;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.path.GrMethodCallExpression;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class GradleBuildFileUtilTest extends LightXtendTest {
  private final GradleBuildFileUtility util = new GradleBuildFileUtility();
  
  public void testSetupGradleBuildEmptyFile() {
    PsiFile _addFileToProject = this.myFixture.addFileToProject("build.gradle", "");
    final GroovyFile buildFile = ((GroovyFile) _addFileToProject);
    TestCase.assertNotNull(buildFile);
    Project _project = this.myFixture.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        GradleBuildFileUtilTest.this.util.setupGradleBuild(GradleBuildFileUtilTest.this.myModule, buildFile);
      }
    };
    WriteCommandAction.runWriteCommandAction(_project, _function);
    Project _project_1 = this.myFixture.getProject();
    final Runnable _function_1 = new Runnable() {
      @Override
      public void run() {
        GradleBuildFileUtilTest.this.util.setupGradleBuild(GradleBuildFileUtilTest.this.myModule, buildFile);
      }
    };
    WriteCommandAction.runWriteCommandAction(_project_1, _function_1);
    this.assertTree(buildFile);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("buildscript {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("repositories {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("jcenter()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("dependencies {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("classpath \'org.xtend:xtend-gradle-plugin:");
    _builder.append(this.util.xtendGradlePluginVersion, "        ");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("apply plugin: \'org.xtend.xtend\' ");
    String _string = _builder.toString();
    String _trim = _string.trim();
    String _text = buildFile.getText();
    TestCase.assertEquals(_trim, _text);
  }
  
  public void testSetupGradleBuildFileWithContent() {
    PsiFile _addFileToProject = this.myFixture.addFileToProject("build.gradle", "buildscript{dependencies{}}");
    final GroovyFile buildFile = ((GroovyFile) _addFileToProject);
    TestCase.assertNotNull(buildFile);
    Project _project = this.myFixture.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        GradleBuildFileUtilTest.this.util.setupGradleBuild(GradleBuildFileUtilTest.this.myModule, buildFile);
      }
    };
    WriteCommandAction.runWriteCommandAction(_project, _function);
    Project _project_1 = this.myFixture.getProject();
    final Runnable _function_1 = new Runnable() {
      @Override
      public void run() {
        GradleBuildFileUtilTest.this.util.setupGradleBuild(GradleBuildFileUtilTest.this.myModule, buildFile);
      }
    };
    WriteCommandAction.runWriteCommandAction(_project_1, _function_1);
    this.assertTree(buildFile);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("buildscript{dependencies{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("classpath \'org.xtend:xtend-gradle-plugin:");
    _builder.append(this.util.xtendGradlePluginVersion, "    ");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("repositories {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("jcenter()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("apply plugin: \'org.xtend.xtend\' ");
    String _string = _builder.toString();
    String _trim = _string.trim();
    String _text = buildFile.getText();
    TestCase.assertEquals(_trim, _text);
  }
  
  public void testAddDependencyEmptyFile() {
    PsiFile _addFileToProject = this.myFixture.addFileToProject("build.gradle", "");
    final GroovyFile buildFile = ((GroovyFile) _addFileToProject);
    TestCase.assertNotNull(buildFile);
    Project _project = this.myFixture.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        MavenId _xtendLibMavenId = XtendLibraryConfigurator.xtendLibMavenId();
        String _string = _xtendLibMavenId.toString();
        String _plus = ("compile \'" + _string);
        String _plus_1 = (_plus + "\'");
        GradleBuildFileUtilTest.this.util.addDependency(buildFile, _plus_1);
      }
    };
    WriteCommandAction.runWriteCommandAction(_project, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("dependencies {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("compile \'");
    MavenId _xtendLibMavenId = XtendLibraryConfigurator.xtendLibMavenId();
    String _string = _xtendLibMavenId.toString();
    _builder.append(_string, "    ");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    String _string_1 = _builder.toString();
    String _text = buildFile.getText();
    TestCase.assertEquals(_string_1, _text);
  }
  
  public void testAddDependencyFileWithContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("dependencies {}");
    PsiFile _addFileToProject = this.myFixture.addFileToProject("build.gradle", _builder.toString());
    final GroovyFile buildFile = ((GroovyFile) _addFileToProject);
    TestCase.assertNotNull(buildFile);
    Project _project = this.myFixture.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        MavenId _xtendLibMavenId = XtendLibraryConfigurator.xtendLibMavenId();
        String _string = _xtendLibMavenId.toString();
        String _plus = ("compile \'" + _string);
        String _plus_1 = (_plus + "\'");
        GradleBuildFileUtilTest.this.util.addDependency(buildFile, _plus_1);
      }
    };
    WriteCommandAction.runWriteCommandAction(_project, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("dependencies {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("compile \'");
    MavenId _xtendLibMavenId = XtendLibraryConfigurator.xtendLibMavenId();
    String _string = _xtendLibMavenId.toString();
    _builder_1.append(_string, "    ");
    _builder_1.append("\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    String _string_1 = _builder_1.toString();
    String _text = buildFile.getText();
    TestCase.assertEquals(_string_1, _text);
  }
  
  public void _testIsGradleModule() {
    this.myFixture.addFileToProject("build.gradle", "");
    Module _module = this.myFixture.getModule();
    boolean _isGradleedModule = this.util.isGradleedModule(_module);
    TestCase.assertTrue(_isGradleedModule);
  }
  
  public void assertTree(final GroovyFile buildFile) {
    GrStatement[] _statements = buildFile.getStatements();
    int _length = _statements.length;
    TestCase.assertEquals(2, _length);
    GrStatement[] _statements_1 = buildFile.getStatements();
    Iterable<GrMethodCallExpression> _filter = Iterables.<GrMethodCallExpression>filter(((Iterable<?>)Conversions.doWrapArray(_statements_1)), GrMethodCallExpression.class);
    final Function1<GrMethodCallExpression, Boolean> _function = new Function1<GrMethodCallExpression, Boolean>() {
      @Override
      public Boolean apply(final GrMethodCallExpression it) {
        GrExpression _invokedExpression = it.getInvokedExpression();
        String _text = _invokedExpression.getText();
        return Boolean.valueOf(Objects.equal(_text, "buildscript"));
      }
    };
    final Iterable<GrMethodCallExpression> bsCol = IterableExtensions.<GrMethodCallExpression>filter(_filter, _function);
    int _size = IterableExtensions.size(bsCol);
    TestCase.assertEquals(1, _size);
    final GrMethodCallExpression bs = IterableExtensions.<GrMethodCallExpression>head(bsCol);
    GrExpression _invokedExpression = bs.getInvokedExpression();
    String _text = _invokedExpression.getText();
    TestCase.assertEquals("buildscript", _text);
    GrClosableBlock[] _closureArguments = bs.getClosureArguments();
    GrClosableBlock _head = IterableExtensions.<GrClosableBlock>head(((Iterable<GrClosableBlock>)Conversions.doWrapArray(_closureArguments)));
    PsiElement[] _children = _head.getChildren();
    final Iterable<GrMethodCallExpression> children = Iterables.<GrMethodCallExpression>filter(((Iterable<?>)Conversions.doWrapArray(_children)), GrMethodCallExpression.class);
    int _size_1 = IterableExtensions.size(children);
    TestCase.assertEquals(2, _size_1);
    final Function1<GrMethodCallExpression, Boolean> _function_1 = new Function1<GrMethodCallExpression, Boolean>() {
      @Override
      public Boolean apply(final GrMethodCallExpression it) {
        GrExpression _invokedExpression = it.getInvokedExpression();
        String _text = _invokedExpression.getText();
        return Boolean.valueOf(Objects.equal(_text, "dependencies"));
      }
    };
    Iterable<GrMethodCallExpression> _filter_1 = IterableExtensions.<GrMethodCallExpression>filter(children, _function_1);
    final GrMethodCallExpression dps = IterableExtensions.<GrMethodCallExpression>head(_filter_1);
    TestCase.assertNotNull(dps);
    PsiElement[] _children_1 = dps.getChildren();
    int _length_1 = _children_1.length;
    TestCase.assertEquals(3, _length_1);
    GrClosableBlock[] _closureArguments_1 = dps.getClosureArguments();
    final GrClosableBlock closureBlock = IterableExtensions.<GrClosableBlock>head(((Iterable<GrClosableBlock>)Conversions.doWrapArray(_closureArguments_1)));
    GrStatement[] _statements_2 = closureBlock.getStatements();
    int _length_2 = _statements_2.length;
    TestCase.assertEquals(1, _length_2);
    GrStatement[] _statements_3 = closureBlock.getStatements();
    Iterable<GrApplicationStatement> _filter_2 = Iterables.<GrApplicationStatement>filter(((Iterable<?>)Conversions.doWrapArray(_statements_3)), GrApplicationStatement.class);
    final GrApplicationStatement clEntry = IterableExtensions.<GrApplicationStatement>head(_filter_2);
    TestCase.assertNotNull(clEntry);
    GrExpression _invokedExpression_1 = clEntry.getInvokedExpression();
    String _text_1 = _invokedExpression_1.getText();
    TestCase.assertEquals("classpath", _text_1);
    GrCommandArgumentList _argumentList = clEntry.getArgumentList();
    String _text_2 = _argumentList.getText();
    boolean _startsWith = _text_2.startsWith("\'org.xtend:xtend-gradle-plugin:");
    TestCase.assertTrue(_startsWith);
    final Function1<GrMethodCallExpression, Boolean> _function_2 = new Function1<GrMethodCallExpression, Boolean>() {
      @Override
      public Boolean apply(final GrMethodCallExpression it) {
        GrExpression _invokedExpression = it.getInvokedExpression();
        String _text = _invokedExpression.getText();
        return Boolean.valueOf(Objects.equal(_text, "repositories"));
      }
    };
    Iterable<GrMethodCallExpression> _filter_3 = IterableExtensions.<GrMethodCallExpression>filter(children, _function_2);
    final GrMethodCallExpression repos = IterableExtensions.<GrMethodCallExpression>head(_filter_3);
    TestCase.assertNotNull(repos);
    GrClosableBlock[] _closureArguments_2 = repos.getClosureArguments();
    GrClosableBlock _head_1 = IterableExtensions.<GrClosableBlock>head(((Iterable<GrClosableBlock>)Conversions.doWrapArray(_closureArguments_2)));
    GrStatement[] _statements_4 = _head_1.getStatements();
    Iterable<GrMethodCallExpression> _filter_4 = Iterables.<GrMethodCallExpression>filter(((Iterable<?>)Conversions.doWrapArray(_statements_4)), GrMethodCallExpression.class);
    final GrMethodCallExpression jcenterEntry = IterableExtensions.<GrMethodCallExpression>head(_filter_4);
    GrExpression _invokedExpression_2 = jcenterEntry.getInvokedExpression();
    String _text_3 = _invokedExpression_2.getText();
    TestCase.assertEquals("jcenter", _text_3);
  }
}
