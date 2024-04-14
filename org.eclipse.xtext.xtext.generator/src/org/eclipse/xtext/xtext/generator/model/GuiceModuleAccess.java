/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Configuration object for Guice modules based on
 * {@link org.eclipse.xtext.service.AbstractGenericModule}.
 */
public class GuiceModuleAccess {

	private static final Logger LOG = Logger.getLogger(GuiceModuleAccess.class);

	public static class BindKey {
		private final String name;

		private final TypeReference type;

		private final boolean singleton;

		private final boolean eagerSingleton;

		@Override
		public boolean equals(Object other) {
			if (other instanceof GuiceModuleAccess.BindKey) {
				return Objects.equals(this.name, ((GuiceModuleAccess.BindKey) other).name)
						&& Objects.equals(this.type, ((GuiceModuleAccess.BindKey) other).type);
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			int h = 0;
			if (name != null) {
				h = h + name.hashCode();
			}
			if (type != null) {
				h = h + type.hashCode();
			}
			return h;
		}

		public BindKey(String name, TypeReference type, boolean singleton, boolean eagerSingleton) {
			this.name = name;
			this.type = type;
			this.singleton = singleton;
			this.eagerSingleton = eagerSingleton;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("name", name);
			b.add("type", type);
			b.add("singleton", singleton);
			b.add("eagerSingleton", eagerSingleton);
			return b.toString();
		}

		public String getName() {
			return name;
		}

		public TypeReference getType() {
			return type;
		}

		public boolean isSingleton() {
			return singleton;
		}

		public boolean isEagerSingleton() {
			return eagerSingleton;
		}
	}

	public static class BindValue {
		private final Object expression;

		private final TypeReference type;

		private final boolean provider;

		private final List<Object> statements;

		public BindValue(Object expression, TypeReference type, boolean provider, List<Object> statements) {
			this.expression = expression;
			this.type = type;
			this.provider = provider;
			this.statements = statements;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.expression == null) ? 0 : this.expression.hashCode());
			result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
			result = prime * result + (this.provider ? 1231 : 1237);
			return prime * result + ((this.statements == null) ? 0 : this.statements.hashCode());
		}

		@Override
		public boolean equals(Object obj) {
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
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("expression", expression);
			b.add("type", type);
			b.add("provider", provider);
			b.add("statements", statements);
			return b.toString();
		}

		public Object getExpression() {
			return expression;
		}

		public TypeReference getType() {
			return type;
		}

		public boolean isProvider() {
			return provider;
		}

		public List<Object> getStatements() {
			return statements;
		}
	}

	public static class Binding {
		private final GuiceModuleAccess.BindKey key;

		private final GuiceModuleAccess.BindValue value;

		private final boolean isFinal;

		private final String contributedBy;

		@Override
		public boolean equals(Object other) {
			if (other instanceof GuiceModuleAccess.Binding) {
				return Objects.equals(this.key, ((GuiceModuleAccess.Binding) other).key);
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			return key.hashCode();
		}

		public Binding(GuiceModuleAccess.BindKey key, GuiceModuleAccess.BindValue value, boolean isFinal,
				String contributedBy) {
			this.key = key;
			this.value = value;
			this.isFinal = isFinal;
			this.contributedBy = contributedBy;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("key", key);
			b.add("value", value);
			b.add("isFinal", isFinal);
			b.add("contributedBy", contributedBy);
			return b.toString();
		}

		public GuiceModuleAccess.BindKey getKey() {
			return key;
		}

		public GuiceModuleAccess.BindValue getValue() {
			return value;
		}

		public boolean isFinal() {
			return isFinal;
		}

		public String getContributedBy() {
			return contributedBy;
		}
	}

	public static class BindingFactory {
		private final String contributedBy;

		private final Set<GuiceModuleAccess.Binding> bindings = new LinkedHashSet<>();

		public BindingFactory() {
			this.contributedBy = new Exception().getStackTrace()[1].getClassName();
		}

		public BindingFactory(String contributedBy) {
			this.contributedBy = contributedBy;
		}

		private void add(GuiceModuleAccess.BindKey type, GuiceModuleAccess.BindValue expr) {
			add(type, expr, false);
		}

		private void add(GuiceModuleAccess.BindKey type, GuiceModuleAccess.BindValue expr, boolean isFinal) {
			add(new GuiceModuleAccess.Binding(type, expr, isFinal, contributedBy));
		}

		private void add(GuiceModuleAccess.Binding binding) {
			if (!bindings.add(binding)) {
				throw new IllegalArgumentException(
						"Duplicate binding for " + binding.key + " in " + this.contributedBy);
			}
		}

		private GuiceModuleAccess.BindKey key(TypeReference type) {
			return new GuiceModuleAccess.BindKey(null, type, false, false);
		}

		private GuiceModuleAccess.BindKey key(String name) {
			return new GuiceModuleAccess.BindKey(name, null, false, false);
		}

		private GuiceModuleAccess.BindKey eagerSingleton(TypeReference type) {
			return new GuiceModuleAccess.BindKey(null, type, true, true);
		}

		private GuiceModuleAccess.BindKey singleton(TypeReference type) {
			return new GuiceModuleAccess.BindKey(null, type, true, false);
		}

		private GuiceModuleAccess.BindValue value(TypeReference type) {
			return new GuiceModuleAccess.BindValue(null, type, false, Collections.emptyList());
		}

		private GuiceModuleAccess.BindValue expr(Object expr) {
			return new GuiceModuleAccess.BindValue(expr, null, false, Collections.emptyList());
		}

		private GuiceModuleAccess.BindValue provider(TypeReference type) {
			return new GuiceModuleAccess.BindValue(null, type, true, Collections.emptyList());
		}

		private GuiceModuleAccess.BindValue providerExpr(Object expr) {
			return new GuiceModuleAccess.BindValue(expr, null, true, Collections.emptyList());
		}

		private GuiceModuleAccess.BindValue statements(Object[] statements) {
			return new GuiceModuleAccess.BindValue(null, null, false, Arrays.asList(statements));
		}

		public GuiceModuleAccess.BindingFactory addTypeToInstance(TypeReference type,
				StringConcatenationClient expression) {
			add(key(type), expr(expression));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToProviderInstance(TypeReference type,
				StringConcatenationClient expression) {
			add(key(type), providerExpr(expression));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addConfiguredBinding(String name, StringConcatenationClient statement) {
			add(key(name), statements(new Object[] { statement }));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToType(TypeReference keyType, TypeReference valueType) {
			add(key(keyType), value(valueType));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToTypeSingleton(TypeReference keyType, TypeReference valueType) {
			add(singleton(keyType), value(valueType));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToTypeEagerSingleton(TypeReference keyType,
				TypeReference valueType) {
			add(eagerSingleton(keyType), value(valueType));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToProvider(TypeReference keyType, TypeReference valueType) {
			add(key(keyType), provider(valueType));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToProviderSingleton(TypeReference keyType,
				TypeReference valueType) {
			this.add(this.singleton(keyType), this.provider(valueType));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addTypeToProviderEagerSingleton(TypeReference keyType,
				TypeReference valueType) {
			add(eagerSingleton(keyType), provider(valueType));
			return this;
		}

		public GuiceModuleAccess.BindingFactory addfinalTypeToType(TypeReference keyType, TypeReference valueType) {
			add(key(keyType), value(valueType), true);
			return this;
		}

		public GuiceModuleAccess.BindingFactory addfinalTypeToTypeSingleton(TypeReference keyType,
				TypeReference valueType) {
			add(singleton(keyType), value(valueType), true);
			return this;
		}

		public GuiceModuleAccess.BindingFactory addfinalTypeToTypeEagerSingleton(TypeReference keyType,
				TypeReference valueType) {
			add(eagerSingleton(keyType), value(valueType), true);
			return this;
		}

		public GuiceModuleAccess.BindingFactory addfinalTypeToProvider(TypeReference keyType, TypeReference valueType) {
			add(key(keyType), provider(valueType), true);
			return this;
		}

		public GuiceModuleAccess.BindingFactory addfinalTypeToProviderSingleton(TypeReference keyType,
				TypeReference valueType) {
			add(singleton(keyType), provider(valueType), true);
			return this;
		}

		public GuiceModuleAccess.BindingFactory addfinalTypeToProviderEagerSingleton(TypeReference keyType,
				TypeReference valueType) {
			add(eagerSingleton(keyType), provider(valueType), true);
			return this;
		}

		public void contributeTo(GuiceModuleAccess module) {
			module.addAll(bindings);
		}

		public String getContributedBy() {
			return contributedBy;
		}
	}

	private final Set<GuiceModuleAccess.Binding> bindings = new LinkedHashSet<>();

	private TypeReference superClass;

	public void add(GuiceModuleAccess.Binding newBinding) {
		if (bindings.contains(newBinding)) {
			Iterator<GuiceModuleAccess.Binding> iterator = bindings.iterator();
			boolean found = false;
			while (iterator.hasNext() && !found) {
				GuiceModuleAccess.Binding oldBinding = iterator.next();
				if (Objects.equals(oldBinding, newBinding)) {
					if (oldBinding.isFinal) {
						if (newBinding.isFinal) {
							throw new IllegalStateException(
									"Conflicting final bindings for '" + oldBinding.key.type + "' from fragments "
											+ oldBinding.contributedBy + " and " + newBinding.contributedBy);
						} else {
							GuiceModuleAccess.LOG.warn("Cannot override final binding '" + oldBinding + "'. "
									+ "Ignoring binding from fragment '" + newBinding.contributedBy + "'");
						}
					} else {
						GuiceModuleAccess.LOG.debug("replacing binding : " + oldBinding);
						GuiceModuleAccess.LOG.debug(" with new binding : " + newBinding);
						iterator.remove();
					}
					found = true;
				}
			}
		}
		bindings.add(newBinding);
	}

	public void addAll(Iterable<GuiceModuleAccess.Binding> bindings) {
		for (GuiceModuleAccess.Binding binding : bindings) {
			add(binding);
		}
	}

	public Set<GuiceModuleAccess.Binding> getBindings() {
		return Collections.unmodifiableSet(bindings);
	}

	public TypeReference getSuperClass() {
		return superClass;
	}

	public void setSuperClass(TypeReference superClass) {
		this.superClass = superClass;
	}
}
