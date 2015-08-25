/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Log
@SuppressWarnings("all")
public class GuiceModuleAccess {
  @Data
  public static class BindKey {
    private final String name;
    
    private final TypeReference type;
    
    private final boolean singleton;
    
    private final boolean eagerSingleton;
    
    @Override
    public boolean equals(final Object other) {
      boolean _xifexpression = false;
      if ((other instanceof GuiceModuleAccess.BindKey)) {
        boolean _and = false;
        boolean _equals = Objects.equal(this.name, ((GuiceModuleAccess.BindKey)other).name);
        if (!_equals) {
          _and = false;
        } else {
          boolean _equals_1 = Objects.equal(this.type, ((GuiceModuleAccess.BindKey)other).type);
          _and = _equals_1;
        }
        _xifexpression = _and;
      } else {
        _xifexpression = false;
      }
      return _xifexpression;
    }
    
    @Override
    public int hashCode() {
      int h = 0;
      if ((this.name != null)) {
        int _h = h;
        int _hashCode = this.name.hashCode();
        h = (_h + _hashCode);
      }
      if ((this.type != null)) {
        int _h_1 = h;
        int _hashCode_1 = this.type.hashCode();
        h = (_h_1 + _hashCode_1);
      }
      return h;
    }
    
    public BindKey(final String name, final TypeReference type, final boolean singleton, final boolean eagerSingleton) {
      super();
      this.name = name;
      this.type = type;
      this.singleton = singleton;
      this.eagerSingleton = eagerSingleton;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("type", this.type);
      b.add("singleton", this.singleton);
      b.add("eagerSingleton", this.eagerSingleton);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public TypeReference getType() {
      return this.type;
    }
    
    @Pure
    public boolean isSingleton() {
      return this.singleton;
    }
    
    @Pure
    public boolean isEagerSingleton() {
      return this.eagerSingleton;
    }
  }
  
  @Data
  public static class BindValue {
    private final Object expression;
    
    private final TypeReference type;
    
    private final boolean provider;
    
    private final List<Object> statements;
    
    public BindValue(final Object expression, final TypeReference type, final boolean provider, final List<Object> statements) {
      super();
      this.expression = expression;
      this.type = type;
      this.provider = provider;
      this.statements = statements;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.expression== null) ? 0 : this.expression.hashCode());
      result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
      result = prime * result + (this.provider ? 1231 : 1237);
      result = prime * result + ((this.statements== null) ? 0 : this.statements.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      GuiceModuleAccess.BindValue other = (GuiceModuleAccess.BindValue) obj;
      if (this.expression == null) {
        if (other.expression != null)
          return false;
      } else if (!this.expression.equals(other.expression))
        return false;
      if (this.type == null) {
        if (other.type != null)
          return false;
      } else if (!this.type.equals(other.type))
        return false;
      if (other.provider != this.provider)
        return false;
      if (this.statements == null) {
        if (other.statements != null)
          return false;
      } else if (!this.statements.equals(other.statements))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("expression", this.expression);
      b.add("type", this.type);
      b.add("provider", this.provider);
      b.add("statements", this.statements);
      return b.toString();
    }
    
    @Pure
    public Object getExpression() {
      return this.expression;
    }
    
    @Pure
    public TypeReference getType() {
      return this.type;
    }
    
    @Pure
    public boolean isProvider() {
      return this.provider;
    }
    
    @Pure
    public List<Object> getStatements() {
      return this.statements;
    }
  }
  
  @Data
  public static class Binding {
    private final GuiceModuleAccess.BindKey key;
    
    private final GuiceModuleAccess.BindValue value;
    
    private final boolean isFinal;
    
    private final String contributedBy;
    
    @Override
    public boolean equals(final Object other) {
      boolean _xifexpression = false;
      if ((other instanceof GuiceModuleAccess.Binding)) {
        _xifexpression = Objects.equal(this.key, ((GuiceModuleAccess.Binding)other).key);
      } else {
        _xifexpression = false;
      }
      return _xifexpression;
    }
    
    @Override
    public int hashCode() {
      return this.key.hashCode();
    }
    
    public Binding(final GuiceModuleAccess.BindKey key, final GuiceModuleAccess.BindValue value, final boolean isFinal, final String contributedBy) {
      super();
      this.key = key;
      this.value = value;
      this.isFinal = isFinal;
      this.contributedBy = contributedBy;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("key", this.key);
      b.add("value", this.value);
      b.add("isFinal", this.isFinal);
      b.add("contributedBy", this.contributedBy);
      return b.toString();
    }
    
    @Pure
    public GuiceModuleAccess.BindKey getKey() {
      return this.key;
    }
    
    @Pure
    public GuiceModuleAccess.BindValue getValue() {
      return this.value;
    }
    
    @Pure
    public boolean isFinal() {
      return this.isFinal;
    }
    
    @Pure
    public String getContributedBy() {
      return this.contributedBy;
    }
  }
  
  public static class BindingFactory {
    @Accessors
    private final String contributedBy;
    
    private final Set<GuiceModuleAccess.Binding> bindings = CollectionLiterals.<GuiceModuleAccess.Binding>newLinkedHashSet();
    
    public BindingFactory() {
      Exception _exception = new Exception();
      StackTraceElement[] _stackTrace = _exception.getStackTrace();
      StackTraceElement _get = _stackTrace[1];
      String _className = _get.getClassName();
      this.contributedBy = _className;
    }
    
    public BindingFactory(final String contributedBy) {
      this.contributedBy = contributedBy;
    }
    
    private void add(final GuiceModuleAccess.BindKey type, final GuiceModuleAccess.BindValue expr) {
      this.add(type, expr, false);
    }
    
    private void add(final GuiceModuleAccess.BindKey type, final GuiceModuleAccess.BindValue expr, final boolean isFinal) {
      GuiceModuleAccess.Binding _binding = new GuiceModuleAccess.Binding(type, expr, isFinal, this.contributedBy);
      this.add(_binding);
    }
    
    private void add(final GuiceModuleAccess.Binding binding) {
      boolean _add = this.bindings.add(binding);
      boolean _not = (!_add);
      if (_not) {
        throw new IllegalArgumentException(((("Duplicate binding for " + binding.key) + " in ") + this.contributedBy));
      }
    }
    
    private GuiceModuleAccess.BindKey key(final TypeReference type) {
      return new GuiceModuleAccess.BindKey(null, type, false, false);
    }
    
    private GuiceModuleAccess.BindKey key(final String name) {
      return new GuiceModuleAccess.BindKey(name, null, false, false);
    }
    
    private GuiceModuleAccess.BindKey eagerSingleton(final TypeReference type) {
      return new GuiceModuleAccess.BindKey(null, type, true, true);
    }
    
    private GuiceModuleAccess.BindKey singleton(final TypeReference type) {
      return new GuiceModuleAccess.BindKey(null, type, true, false);
    }
    
    private GuiceModuleAccess.BindValue value(final TypeReference type) {
      List<Object> _emptyList = Collections.<Object>emptyList();
      return new GuiceModuleAccess.BindValue(null, type, false, _emptyList);
    }
    
    private GuiceModuleAccess.BindValue expr(final Object expr) {
      List<Object> _emptyList = Collections.<Object>emptyList();
      return new GuiceModuleAccess.BindValue(expr, null, false, _emptyList);
    }
    
    private GuiceModuleAccess.BindValue provider(final TypeReference type) {
      List<Object> _emptyList = Collections.<Object>emptyList();
      return new GuiceModuleAccess.BindValue(null, type, true, _emptyList);
    }
    
    private GuiceModuleAccess.BindValue providerExpr(final Object expr) {
      List<Object> _emptyList = Collections.<Object>emptyList();
      return new GuiceModuleAccess.BindValue(expr, null, true, _emptyList);
    }
    
    private GuiceModuleAccess.BindValue statements(final Object[] statements) {
      return new GuiceModuleAccess.BindValue(null, null, false, (List<Object>)Conversions.doWrapArray(statements));
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToInstance(final TypeReference type, final StringConcatenationClient expression) {
      GuiceModuleAccess.BindKey _key = this.key(type);
      GuiceModuleAccess.BindValue _expr = this.expr(expression);
      this.add(_key, _expr);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToProviderInstance(final TypeReference type, final StringConcatenationClient expression) {
      GuiceModuleAccess.BindKey _key = this.key(type);
      GuiceModuleAccess.BindValue _providerExpr = this.providerExpr(expression);
      this.add(_key, _providerExpr);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addConfiguredBinding(final String name, final StringConcatenationClient statement) {
      GuiceModuleAccess.BindKey _key = this.key(name);
      GuiceModuleAccess.BindValue _statements = this.statements(new Object[] { statement });
      this.add(_key, _statements);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToType(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _key = this.key(keyType);
      GuiceModuleAccess.BindValue _value = this.value(valueType);
      this.add(_key, _value);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToTypeSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _singleton = this.singleton(keyType);
      GuiceModuleAccess.BindValue _value = this.value(valueType);
      this.add(_singleton, _value);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToTypeEagerSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _eagerSingleton = this.eagerSingleton(keyType);
      GuiceModuleAccess.BindValue _value = this.value(valueType);
      this.add(_eagerSingleton, _value);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToProvider(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _key = this.key(keyType);
      GuiceModuleAccess.BindValue _provider = this.provider(valueType);
      this.add(_key, _provider);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToProviderSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _singleton = this.singleton(keyType);
      GuiceModuleAccess.BindValue _provider = this.provider(valueType);
      this.add(_singleton, _provider);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addTypeToProviderEagerSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _eagerSingleton = this.eagerSingleton(keyType);
      GuiceModuleAccess.BindValue _provider = this.provider(valueType);
      this.add(_eagerSingleton, _provider);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addfinalTypeToType(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _key = this.key(keyType);
      GuiceModuleAccess.BindValue _value = this.value(valueType);
      this.add(_key, _value, true);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addfinalTypeToTypeSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _singleton = this.singleton(keyType);
      GuiceModuleAccess.BindValue _value = this.value(valueType);
      this.add(_singleton, _value, true);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addfinalTypeToTypeEagerSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _eagerSingleton = this.eagerSingleton(keyType);
      GuiceModuleAccess.BindValue _value = this.value(valueType);
      this.add(_eagerSingleton, _value, true);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addfinalTypeToProvider(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _key = this.key(keyType);
      GuiceModuleAccess.BindValue _provider = this.provider(valueType);
      this.add(_key, _provider, true);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addfinalTypeToProviderSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _singleton = this.singleton(keyType);
      GuiceModuleAccess.BindValue _provider = this.provider(valueType);
      this.add(_singleton, _provider, true);
      return this;
    }
    
    public GuiceModuleAccess.BindingFactory addfinalTypeToProviderEagerSingleton(final TypeReference keyType, final TypeReference valueType) {
      GuiceModuleAccess.BindKey _eagerSingleton = this.eagerSingleton(keyType);
      GuiceModuleAccess.BindValue _provider = this.provider(valueType);
      this.add(_eagerSingleton, _provider, true);
      return this;
    }
    
    public void contributeTo(final GuiceModuleAccess module) {
      module.addAll(this.bindings);
    }
    
    @Pure
    public String getContributedBy() {
      return this.contributedBy;
    }
  }
  
  private final Set<GuiceModuleAccess.Binding> bindings = CollectionLiterals.<GuiceModuleAccess.Binding>newLinkedHashSet();
  
  @Accessors
  private TypeReference superClass;
  
  public void add(final GuiceModuleAccess.Binding newBinding) {
    boolean _contains = this.bindings.contains(newBinding);
    if (_contains) {
      final Iterator<GuiceModuleAccess.Binding> iterator = this.bindings.iterator();
      boolean found = false;
      while ((iterator.hasNext() && (!found))) {
        {
          final GuiceModuleAccess.Binding oldBinding = iterator.next();
          boolean _equals = Objects.equal(oldBinding, newBinding);
          if (_equals) {
            if (oldBinding.isFinal) {
              if (newBinding.isFinal) {
                throw new IllegalStateException(((((("Conflicting final bindings for \'" + oldBinding.key.type) + "\' from fragments ") + oldBinding.contributedBy) + " and ") + newBinding.contributedBy));
              } else {
                GuiceModuleAccess.LOG.warn(((((("Cannot override final binding \'" + oldBinding) + "\'. ") + "Ignoring binding from fragment \'") + newBinding.contributedBy) + "\'"));
              }
            } else {
              GuiceModuleAccess.LOG.debug(("replacing binding : " + oldBinding));
              GuiceModuleAccess.LOG.debug((" with new binding : " + newBinding));
              iterator.remove();
            }
            found = true;
          }
        }
      }
    }
    this.bindings.add(newBinding);
  }
  
  public void addAll(final Iterable<GuiceModuleAccess.Binding> bindings) {
    for (final GuiceModuleAccess.Binding binding : bindings) {
      this.add(binding);
    }
  }
  
  public Set<GuiceModuleAccess.Binding> getBindings() {
    return Collections.<GuiceModuleAccess.Binding>unmodifiableSet(this.bindings);
  }
  
  private final static Logger LOG = Logger.getLogger(GuiceModuleAccess.class);
  
  @Pure
  public TypeReference getSuperClass() {
    return this.superClass;
  }
  
  public void setSuperClass(final TypeReference superClass) {
    this.superClass = superClass;
  }
}
