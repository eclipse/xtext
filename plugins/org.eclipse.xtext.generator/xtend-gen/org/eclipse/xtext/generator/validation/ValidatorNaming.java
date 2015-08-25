/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author Jan Koehnlein
 * @since 2.4
 */
@SuppressWarnings("all")
public class ValidatorNaming {
  @Inject
  private Grammar grammar;
  
  @Inject
  @Extension
  private Naming _naming;
  
  public String getValidatorName(final Grammar g) {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackageRuntime = this._naming.basePackageRuntime(g);
    _builder.append(_basePackageRuntime, "");
    _builder.append(".validation.");
    String _simpleName = GrammarUtil.getSimpleName(g);
    _builder.append(_simpleName, "");
    _builder.append("Validator");
    return _builder.toString();
  }
  
  public String getAbstractValidatorName() {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackageRuntime = this._naming.basePackageRuntime(this.grammar);
    _builder.append(_basePackageRuntime, "");
    _builder.append(".validation.Abstract");
    String _simpleName = GrammarUtil.getSimpleName(this.grammar);
    _builder.append(_simpleName, "");
    _builder.append("Validator");
    return _builder.toString();
  }
  
  public String getValidatorSuperClassName(final boolean isInheritImplementation) {
    String _xblockexpression = null;
    {
      final Grammar superGrammar = IInheriting.Util.getNonTerminalsSuperGrammar(this.grammar);
      String _xifexpression = null;
      boolean _and = false;
      if (!isInheritImplementation) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(superGrammar, null));
        _and = _notEquals;
      }
      if (_and) {
        _xifexpression = this.getValidatorName(superGrammar);
      } else {
        _xifexpression = "org.eclipse.xtext.validation.AbstractDeclarativeValidator";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getGeneratedEPackageName(final EPackage pack) {
    StringConcatenation _builder = new StringConcatenation();
    String _basePackageRuntime = this._naming.basePackageRuntime(this.grammar);
    _builder.append(_basePackageRuntime, "");
    _builder.append(".");
    String _name = pack.getName();
    _builder.append(_name, "");
    _builder.append(".");
    String _name_1 = pack.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("Package");
    return _builder.toString();
  }
}
