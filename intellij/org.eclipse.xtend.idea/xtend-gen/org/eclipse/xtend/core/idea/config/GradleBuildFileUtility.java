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
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.jetbrains.plugins.gradle.frameworkSupport.BuildScriptDataBuilder;
import org.jetbrains.plugins.gradle.service.project.wizard.GradleModuleBuilder;
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
  public final String xtendGradlePluginVersion = "0.4.8";
  
  public boolean isGradleedModule(final Module module) {
    boolean _or = false;
    boolean _isExternalSystemAwareModule = ExternalSystemApiUtil.isExternalSystemAwareModule(GradleConstants.SYSTEM_ID, module);
    if (_isExternalSystemAwareModule) {
      _or = true;
    } else {
      BuildScriptDataBuilder _buildScriptData = GradleModuleBuilder.getBuildScriptData(module);
      boolean _tripleNotEquals = (_buildScriptData != null);
      _or = _tripleNotEquals;
    }
    return _or;
  }
  
  public void setupGradleBuild(final Module module, final GroovyFile buildFile) {
    if ((buildFile == null)) {
      return;
    }
    final boolean android = this.isAndroidGradleModule(module);
    GrStatement[] _statements = buildFile.getStatements();
    final Function1<GrStatement, Boolean> _function = new Function1<GrStatement, Boolean>() {
      @Override
      public Boolean apply(final GrStatement it) {
        String _text = it.getText();
        String _trim = _text.trim();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("apply plugin:.*org\\\\.xtend\\\\.xtend");
        String _xifexpression = null;
        if (android) {
          _xifexpression = "-android";
        }
        _builder.append(_xifexpression, "");
        _builder.append(".*");
        return Boolean.valueOf(_trim.matches(_builder.toString()));
      }
    };
    GrStatement _findFirst = IterableExtensions.<GrStatement>findFirst(((Iterable<GrStatement>)Conversions.doWrapArray(_statements)), _function);
    boolean _tripleNotEquals = (_findFirst != null);
    if (_tripleNotEquals) {
      return;
    }
    final GrClosableBlock buildScript = this.createOrGetMethodCall(buildFile, "buildscript");
    GrClosableBlock _createOrGetMethodCall = this.createOrGetMethodCall(buildScript, "repositories");
    this.createStatementIfNotExists(_createOrGetMethodCall, "jcenter()");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("classpath \'org.xtend:xtend");
    String _xifexpression = null;
    if (android) {
      _xifexpression = "-android";
    }
    _builder.append(_xifexpression, "");
    _builder.append("-gradle-plugin:");
    _builder.append(this.xtendGradlePluginVersion, "");
    _builder.append("\' ");
    this.addDependency(buildScript, _builder.toString());
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
  
  public void addDependency(final GrStatementOwner parentElement, final String dependencyEntry) {
    GrClosableBlock _createOrGetMethodCall = this.createOrGetMethodCall(parentElement, "dependencies");
    this.createStatementIfNotExists(_createOrGetMethodCall, dependencyEntry);
  }
  
  private boolean createStatementIfNotExists(final GrStatementOwner statementOwner, final String statement) {
    GrStatement[] _statements = statementOwner.getStatements();
    final Function1<GrStatement, Boolean> _function = new Function1<GrStatement, Boolean>() {
      @Override
      public Boolean apply(final GrStatement it) {
        String _trim = statement.trim();
        String _text = it.getText();
        return Boolean.valueOf(Objects.equal(_trim, _text));
      }
    };
    GrStatement _findFirst = IterableExtensions.<GrStatement>findFirst(((Iterable<GrStatement>)Conversions.doWrapArray(_statements)), _function);
    boolean _tripleNotEquals = (_findFirst != null);
    if (_tripleNotEquals) {
      return false;
    }
    Project _project = statementOwner.getProject();
    GroovyPsiElementFactory factory = GroovyPsiElementFactory.getInstance(_project);
    final GrStatement entry = factory.createStatementFromText(statement);
    statementOwner.addStatementBefore(entry, null);
    return true;
  }
  
  private GrClosableBlock createOrGetMethodCall(final GrStatementOwner element, final String methodName) {
    List<GrMethodCall> methodCalls = PsiTreeUtil.<GrMethodCall>getChildrenOfTypeAsList(element, GrMethodCall.class);
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
            boolean _equals = methodName.equals(_text);
            _and = _equals;
          }
          _xblockexpression = _and;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    GrMethodCall methodCall = IterableExtensions.<GrMethodCall>findFirst(methodCalls, _function);
    if ((methodCall == null)) {
      Project _project = element.getProject();
      GroovyPsiElementFactory factory = GroovyPsiElementFactory.getInstance(_project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(methodName, "");
      _builder.append("{}");
      GrStatement _createStatementFromText = factory.createStatementFromText(_builder);
      GrStatement _addStatementBefore = element.addStatementBefore(_createStatementFromText, 
        null);
      methodCall = ((GrMethodCall) _addStatementBefore);
    }
    return this.firstClosureArgument(methodCall);
  }
  
  private GrClosableBlock firstClosureArgument(final GrCall call) {
    GrClosableBlock[] _closureArguments = call.getClosureArguments();
    return IterableExtensions.<GrClosableBlock>head(((Iterable<GrClosableBlock>)Conversions.doWrapArray(_closureArguments)));
  }
  
  public boolean isAndroidGradleModule(final Module module) {
    final FacetManager mnr = FacetManager.getInstance(module);
    Facet[] _allFacets = mnr.getAllFacets();
    final Function1<Facet<?>, Boolean> _function = new Function1<Facet<?>, Boolean>() {
      @Override
      public Boolean apply(final Facet<?> it) {
        FacetTypeId _typeId = it.getTypeId();
        String _string = _typeId.toString();
        return Boolean.valueOf(Objects.equal("android-gradle", _string));
      }
    };
    final Iterable<Facet<?>> foo = IterableExtensions.<Facet<?>>filter(((Iterable<Facet<?>>)Conversions.doWrapArray(_allFacets)), _function);
    int _size = IterableExtensions.size(foo);
    return (_size > 0);
  }
}
