/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.facet;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.facet.Facet;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.EffectiveLanguageLevelUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Computable;
import com.intellij.pom.java.LanguageLevel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.FacetProvider;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JavaVersion;
import org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseGeneratorConfigProvider implements IGeneratorConfigProvider {
  @Inject
  private FacetProvider facetProvider;
  
  @Inject
  private LanguageInfo languageInfo;
  
  @Override
  public GeneratorConfig get(final EObject context) {
    Resource _eResource = context.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final Module module = ModuleProvider.findModule(_resourceSet);
    final Facet<? extends AbstractFacetConfiguration> facet = this.facetProvider.getFacet(module);
    AbstractFacetConfiguration _configuration = null;
    if (facet!=null) {
      _configuration=facet.getConfiguration();
    }
    final AbstractFacetConfiguration facetConfiguration = _configuration;
    if ((facetConfiguration instanceof XbaseFacetConfiguration)) {
      final XbaseGeneratorConfigurationState state = ((XbaseFacetConfiguration)facetConfiguration).getState();
      GeneratorConfig _generatorConfig = new GeneratorConfig();
      final Procedure1<GeneratorConfig> _function = new Procedure1<GeneratorConfig>() {
        @Override
        public void apply(final GeneratorConfig it) {
          String _generatedAnnotationComment = state.getGeneratedAnnotationComment();
          it.setGeneratedAnnotationComment(_generatedAnnotationComment);
          boolean _isGenerateGeneratedAnnotation = state.isGenerateGeneratedAnnotation();
          it.setGenerateGeneratedAnnotation(_isGenerateGeneratedAnnotation);
          boolean _isGenerateSuppressWarnings = state.isGenerateSuppressWarnings();
          it.setGenerateSyntheticSuppressWarnings(_isGenerateSuppressWarnings);
          boolean _isIncludeDateInGenerated = state.isIncludeDateInGenerated();
          it.setIncludeDateInGeneratedAnnotation(_isIncludeDateInGenerated);
          JavaVersion _targetJavaVersion = XbaseGeneratorConfigProvider.this.getTargetJavaVersion(state, module);
          it.setJavaSourceVersion(_targetJavaVersion);
        }
      };
      return ObjectExtensions.<GeneratorConfig>operator_doubleArrow(_generatorConfig, _function);
    }
    return new GeneratorConfig();
  }
  
  protected JavaVersion getTargetJavaVersion(final XbaseGeneratorConfigurationState state, final Module module) {
    JavaVersion _xblockexpression = null;
    {
      final String version = state.getTargetJavaVersion();
      LanguageLevel _xifexpression = null;
      boolean _or = false;
      boolean _equals = Objects.equal(version, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _equals_1 = version.equals("Module default");
        _or = _equals_1;
      }
      if (_or) {
        LanguageLevel _xblockexpression_1 = null;
        {
          final Computable<LanguageLevel> _function = new Computable<LanguageLevel>() {
            @Override
            public LanguageLevel compute() {
              return EffectiveLanguageLevelUtil.getEffectiveLanguageLevel(module);
            }
          };
          final Computable<LanguageLevel> action = _function;
          Application _application = ApplicationManager.getApplication();
          _xblockexpression_1 = _application.<LanguageLevel>runReadAction(action);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        LanguageLevel[] _values = LanguageLevel.values();
        final Function1<LanguageLevel, Boolean> _function = new Function1<LanguageLevel, Boolean>() {
          @Override
          public Boolean apply(final LanguageLevel it) {
            String _presentableText = it.getPresentableText();
            return Boolean.valueOf(Objects.equal(_presentableText, version));
          }
        };
        _xifexpression = IterableExtensions.<LanguageLevel>findFirst(((Iterable<LanguageLevel>)Conversions.doWrapArray(_values)), _function);
      }
      final LanguageLevel languageLevel = _xifexpression;
      JavaVersion _switchResult = null;
      if (languageLevel != null) {
        switch (languageLevel) {
          case JDK_1_3:
          case JDK_1_4:
            JavaVersion _xblockexpression_2 = null;
            {
              Class<? extends XbaseGeneratorConfigProvider> _class = this.getClass();
              Logger _instance = Logger.getInstance(_class);
              String _shortName = this.languageInfo.getShortName();
              String _plus = (_shortName + " requires Java language level 1.5 or higher. Using Java 1.5.");
              _instance.warn(_plus);
              _xblockexpression_2 = JavaVersion.JAVA5;
            }
            _switchResult = _xblockexpression_2;
            break;
          case JDK_1_5:
            _switchResult = JavaVersion.JAVA5;
            break;
          case JDK_1_6:
            _switchResult = JavaVersion.JAVA6;
            break;
          case JDK_1_7:
            _switchResult = JavaVersion.JAVA7;
            break;
          default:
            _switchResult = JavaVersion.JAVA8;
            break;
        }
      } else {
        _switchResult = JavaVersion.JAVA8;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
