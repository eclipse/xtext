/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;

@SuppressWarnings("all")
public class GuiceModuleAccess extends JavaFileAccess {
  @Data
  public static class BindKey {
    private final String type;
    
    private final boolean singleton;
    
    private final boolean eagerSingleton;
    
    public BindKey(final String type, final boolean singleton, final boolean eagerSingleton) {
      super();
      this.type = type;
      this.singleton = singleton;
      this.eagerSingleton = eagerSingleton;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
      result = prime * result + (this.singleton ? 1231 : 1237);
      result = prime * result + (this.eagerSingleton ? 1231 : 1237);
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
      GuiceModuleAccess.BindKey other = (GuiceModuleAccess.BindKey) obj;
      if (this.type == null) {
        if (other.type != null)
          return false;
      } else if (!this.type.equals(other.type))
        return false;
      if (other.singleton != this.singleton)
        return false;
      if (other.eagerSingleton != this.eagerSingleton)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("type", this.type);
      b.add("singleton", this.singleton);
      b.add("eagerSingleton", this.eagerSingleton);
      return b.toString();
    }
    
    @Pure
    public String getType() {
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
    private final String expression;
    
    private final String typeName;
    
    private final boolean provider;
    
    private final List<CharSequence> statements;
    
    public BindValue(final String expression, final String typeName, final boolean provider, final List<CharSequence> statements) {
      super();
      this.expression = expression;
      this.typeName = typeName;
      this.provider = provider;
      this.statements = statements;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.expression== null) ? 0 : this.expression.hashCode());
      result = prime * result + ((this.typeName== null) ? 0 : this.typeName.hashCode());
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
      if (this.typeName == null) {
        if (other.typeName != null)
          return false;
      } else if (!this.typeName.equals(other.typeName))
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
      b.add("typeName", this.typeName);
      b.add("provider", this.provider);
      b.add("statements", this.statements);
      return b.toString();
    }
    
    @Pure
    public String getExpression() {
      return this.expression;
    }
    
    @Pure
    public String getTypeName() {
      return this.typeName;
    }
    
    @Pure
    public boolean isProvider() {
      return this.provider;
    }
    
    @Pure
    public List<CharSequence> getStatements() {
      return this.statements;
    }
  }
  
  @Data
  public static class Binding {
    private final GuiceModuleAccess.BindKey key;
    
    private final GuiceModuleAccess.BindValue value;
    
    private final String contributedBy;
    
    private final boolean isFinal;
    
    public Binding(final GuiceModuleAccess.BindKey key, final GuiceModuleAccess.BindValue value, final String contributedBy, final boolean isFinal) {
      super();
      this.key = key;
      this.value = value;
      this.contributedBy = contributedBy;
      this.isFinal = isFinal;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.key== null) ? 0 : this.key.hashCode());
      result = prime * result + ((this.value== null) ? 0 : this.value.hashCode());
      result = prime * result + ((this.contributedBy== null) ? 0 : this.contributedBy.hashCode());
      result = prime * result + (this.isFinal ? 1231 : 1237);
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
      GuiceModuleAccess.Binding other = (GuiceModuleAccess.Binding) obj;
      if (this.key == null) {
        if (other.key != null)
          return false;
      } else if (!this.key.equals(other.key))
        return false;
      if (this.value == null) {
        if (other.value != null)
          return false;
      } else if (!this.value.equals(other.value))
        return false;
      if (this.contributedBy == null) {
        if (other.contributedBy != null)
          return false;
      } else if (!this.contributedBy.equals(other.contributedBy))
        return false;
      if (other.isFinal != this.isFinal)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("key", this.key);
      b.add("value", this.value);
      b.add("contributedBy", this.contributedBy);
      b.add("isFinal", this.isFinal);
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
    public String getContributedBy() {
      return this.contributedBy;
    }
    
    @Pure
    public boolean isFinal() {
      return this.isFinal;
    }
  }
  
  @Accessors
  private final List<GuiceModuleAccess.Binding> bindings = CollectionLiterals.<GuiceModuleAccess.Binding>newArrayList();
  
  public GuiceModuleAccess(final String qualifiedName, final CodeConfig codeConfig) {
    super(qualifiedName, codeConfig);
  }
  
  @Pure
  public List<GuiceModuleAccess.Binding> getBindings() {
    return this.bindings;
  }
}
