/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.config;

import com.google.common.base.Objects;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.jetbrains.plugins.gradle.util.GradleConstants;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;
import org.jetbrains.plugins.groovy.lang.psi.GroovyPsiElementFactory;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrStatement;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.blocks.GrClosableBlock;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrCall;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrExpression;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrMethodCall;
import org.jetbrains.plugins.groovy.lang.psi.api.util.GrStatementOwner;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class GradleBuildFileUtility {
  public final String xtendGradlePluginId = "0.4.7";
  
  public boolean isGradleedModule(final Module module) {
    return ExternalSystemApiUtil.isExternalSystemAwareModule(GradleConstants.SYSTEM_ID, module);
  }
  
  public void setupGradleBuild(final Module module) {
    final GroovyFile buildFile = this.locateBuildFile(module);
    if ((buildFile == null)) {
      return;
    }
    final GrClosableBlock buildScriptDeps = this.createOrGetBlock(buildFile, "buildscript");
    final boolean android = this.isAndroidGradleModule(module);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("classpath \'org.xtend:xtend");
    String _xifexpression = null;
    if (android) {
      _xifexpression = "-android";
    }
    _builder.append(_xifexpression, "");
    _builder.append("-gradle-plugin:");
    _builder.append(this.xtendGradlePluginId, "");
    _builder.append("\' ");
    this.addDependency(buildScriptDeps, _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("apply plugin: \'org.xtend.xtend");
    String _xifexpression_1 = null;
    if (android) {
      _xifexpression_1 = "-android";
    }
    _builder_1.append(_xifexpression_1, "");
    _builder_1.append("\' ");
    this.createStatementIfNotExists(buildFile, _builder_1.toString());
  }
  
  public GroovyFile locateBuildFile(final Module module) {
    final String modulePath = ExternalSystemApiUtil.getExternalProjectPath(module);
    if ((modulePath != null)) {
      String buildScriptPath = FileUtil.findFileInProvidedPath(modulePath, GradleConstants.DEFAULT_SCRIPT_NAME);
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(buildScriptPath);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        LocalFileSystem _instance = LocalFileSystem.getInstance();
        VirtualFile virtualFile = _instance.refreshAndFindFileByPath(buildScriptPath);
        if ((virtualFile != null)) {
          Project _project = module.getProject();
          PsiManager _instance_1 = PsiManager.getInstance(_project);
          final PsiFile psiFile = _instance_1.findFile(virtualFile);
          boolean _and = false;
          if (!(psiFile instanceof GroovyFile)) {
            _and = false;
          } else {
            boolean _isValid = psiFile.isValid();
            _and = _isValid;
          }
          if (_and) {
            return ((GroovyFile) psiFile);
          }
        }
      }
    }
    return null;
  }
  
  public void addDependency(final PsiElement parentElement, final String dependencyEntry) {
    GrClosableBlock _dependencies = this.dependencies(parentElement);
    this.createStatementIfNotExists(_dependencies, dependencyEntry);
  }
  
  private void createStatementIfNotExists(final GrStatementOwner statementOwner, final String statement) {
    GrStatement[] _statements = statementOwner.getStatements();
    final Function1<GrStatement, Boolean> _function = new Function1<GrStatement, Boolean>() {
      @Override
      public Boolean apply(final GrStatement it) {
        String _text = it.getText();
        return Boolean.valueOf(Objects.equal(statement, _text));
      }
    };
    GrStatement _findFirst = IterableExtensions.<GrStatement>findFirst(((Iterable<GrStatement>)Conversions.doWrapArray(_statements)), _function);
    boolean _tripleNotEquals = (_findFirst != null);
    if (_tripleNotEquals) {
      return;
    }
    Project _project = statementOwner.getProject();
    GroovyPsiElementFactory factory = GroovyPsiElementFactory.getInstance(_project);
    GrStatement _createStatementFromText = factory.createStatementFromText(statement);
    statementOwner.addStatementBefore(_createStatementFromText, null);
  }
  
  public GrClosableBlock dependencies(final PsiElement parent) {
    return this.createOrGetBlock(parent, "dependencies");
  }
  
  private GrClosableBlock createOrGetBlock(final PsiElement element, final String blockName) {
    List<GrMethodCall> closableBlocks = PsiTreeUtil.<GrMethodCall>getChildrenOfTypeAsList(element, GrMethodCall.class);
    final Function1<GrMethodCall, Boolean> _function = new Function1<GrMethodCall, Boolean>() {
      @Override
      public Boolean apply(final GrMethodCall it) {
        boolean _xblockexpression = false;
        {
          GrExpression expression = it.getInvokedExpression();
          boolean _and = false;
          if (!(expression != null)) {
            _and = false;
          } else {
            String _text = expression.getText();
            boolean _equals = blockName.equals(_text);
            _and = _equals;
          }
          _xblockexpression = _and;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    GrMethodCall block = IterableExtensions.<GrMethodCall>findFirst(closableBlocks, _function);
    if ((block == null)) {
      Project _project = element.getProject();
      GroovyPsiElementFactory factory = GroovyPsiElementFactory.getInstance(_project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(blockName, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      GrStatement _createStatementFromText = factory.createStatementFromText(_builder);
      block = ((GrMethodCall) _createStatementFromText);
      element.add(block);
    }
    return this.firstClosureArgument(block);
  }
  
  public GrClosableBlock firstClosureArgument(final GrCall call) {
    GrClosableBlock[] _closureArguments = call.getClosureArguments();
    return IterableExtensions.<GrClosableBlock>head(((Iterable<GrClosableBlock>)Conversions.doWrapArray(_closureArguments)));
  }
  
  public boolean isAndroidGradleModule(final Module module) {
    final FacetManager mnr = FacetManager.getInstance(module);
    Facet[] _allFacets = mnr.getAllFacets();
    final Function1<Facet<?>, Boolean> _function = new Function1<Facet<?>, Boolean>() {
      @Override
      public Boolean apply(final Facet<?> it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal("Android-Gradle", _name));
      }
    };
    final Iterable<Facet<?>> foo = IterableExtensions.<Facet<?>>filter(((Iterable<Facet<?>>)Conversions.doWrapArray(_allFacets)), _function);
    int _size = IterableExtensions.size(foo);
    return (_size > 0);
  }
}
