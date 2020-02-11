/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tests;

import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;

/**
 * @author spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestsEMFGeneratorFragment extends EMFGeneratorFragment2 {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String ecoreModel;
  
  private String genModel;
  
  public TestsEMFGeneratorFragment() {
    super();
    this.setUpdateBuildProperties(false);
  }
  
  @Override
  public void setGenModel(final String genModel) {
    this.genModel = genModel;
    super.setGenModel(genModel);
  }
  
  @Override
  protected String getEcoreFilePath(final Grammar grammar) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.ecoreModel);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = this.ecoreModel;
    } else {
      String _javaModelDirectory = this.getJavaModelDirectory();
      String _plus = (_javaModelDirectory + "/");
      String _replace = grammar.getName().substring(0, grammar.getName().lastIndexOf(".")).replace(".", "/");
      String _plus_1 = (_plus + _replace);
      String _plus_2 = (_plus_1 + "/");
      String _modelName = this.getModelName(grammar);
      String _plus_3 = (_plus_2 + _modelName);
      _xifexpression = (_plus_3 + ".ecore");
    }
    return _xifexpression;
  }
  
  @Override
  protected String getGenModelPath(final Grammar grammar) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.genModel);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = this.genModel;
    } else {
      String _javaModelDirectory = this.getJavaModelDirectory();
      String _plus = (_javaModelDirectory + "/");
      String _replace = grammar.getName().substring(0, grammar.getName().lastIndexOf(".")).replace(".", "/");
      String _plus_1 = (_plus + _replace);
      String _plus_2 = (_plus_1 + "/");
      String _modelName = this.getModelName(grammar);
      String _plus_3 = (_plus_2 + _modelName);
      _xifexpression = (_plus_3 + ".genmodel");
    }
    return _xifexpression;
  }
  
  public void setEcoreModel(final String ecoreModel) {
    this.ecoreModel = ecoreModel;
  }
}
