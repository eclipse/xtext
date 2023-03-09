/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.LinkedHashSet;
import java.util.Set;

@Deprecated(forRemoval = true)
public class BindFactory {
	private String contributedBy;

	public BindFactory() {
		contributedBy = new Exception().getStackTrace()[1].getClassName();
	}
	public BindFactory(String contributedBy) {
		this.contributedBy = contributedBy;
	}

	public String getContributedBy() {
		return contributedBy;
	}

	private final Set<Binding> bindings = new LinkedHashSet<Binding>();

	public BindFactory addTypeToInstance(String s1, String s2) {
		bindings.add(binding(BindKey.type(s1), BindValue.expr(s2)));
		return this;
	}
	public BindFactory addTypeToProviderInstance(String s1, String s2) {
		bindings.add(binding(BindKey.type(s1), BindValue.providerExpr(s2)));
		return this;
	}
	public BindFactory addConfiguredBinding(String key, String... statements) {
		bindings.add(binding(BindKey.type(key), BindValue.statements(statements)));
		return this;
	}
	/**
	 * @param type
	 * @param expr
	 * @return
	 */
	private Binding binding(BindKey type, BindValue expr) {
		return binding(type, expr, false);
	}

	private Binding binding(BindKey type, BindValue expr, boolean isFinal) {
		return new Binding(type, expr, isFinal, getContributedBy());
	}

	/**
	 * @param binding
	 */
	private void add(Binding binding) {
		if (bindings.contains(binding))
			throw new IllegalArgumentException("Duplicate binding for "+binding.getKey()+" in "+getContributedBy());
		bindings.add(binding);
	}

	public BindFactory addTypeToType(String s1, String s2){
		add(binding(BindKey.type(s1), BindValue.type(s2)));
		return this;
	}
	public BindFactory addTypeToTypeSingleton(String s1, String s2){
		add(binding(BindKey.singleton(s1), BindValue.type(s2)));
		return this;
	}
	public BindFactory addTypeToTypeEagerSingleton(String s1, String s2){
		add(binding(BindKey.eagerSingleton(s1), BindValue.type(s2)));
		return this;
	}
	public BindFactory addTypeToProvider(String s1, String s2){
		add(binding(BindKey.type(s1), BindValue.provider(s2)));
		return this;
	}
	public BindFactory addTypeToProviderSingleton(String s1, String s2){
		add(binding(BindKey.singleton(s1), BindValue.provider(s2)));
		return this;
	}
	public BindFactory addTypeToProviderEagerSingleton(String s1, String s2){
		add(binding(BindKey.eagerSingleton(s1), BindValue.provider(s2)));
		return this;
	}
	public BindFactory addfinalTypeToType(String s1, String s2){
		add(binding(BindKey.type(s1), BindValue.type(s2),true));
		return this;
	}
	public BindFactory addfinalTypeToTypeSingleton(String s1, String s2){
		add(binding(BindKey.singleton(s1), BindValue.type(s2),true));
		return this;
	}
	public BindFactory addfinalTypeToTypeEagerSingleton(String s1, String s2){
		add(binding(BindKey.eagerSingleton(s1), BindValue.type(s2),true));
		return this;
	}
	public BindFactory addfinalTypeToProvider(String s1, String s2){
		add(binding(BindKey.type(s1), BindValue.provider(s2),true));
		return this;
	}
	public BindFactory addfinalTypeToProviderSingleton(String s1, String s2){
		add(binding(BindKey.singleton(s1), BindValue.provider(s2),true));
		return this;
	}
	public BindFactory addfinalTypeToProviderEagerSingleton(String s1, String s2){
		add(binding(BindKey.eagerSingleton(s1), BindValue.provider(s2),true));
		return this;
	}

	public Set<Binding> getBindings() {
		return bindings;
	}
}