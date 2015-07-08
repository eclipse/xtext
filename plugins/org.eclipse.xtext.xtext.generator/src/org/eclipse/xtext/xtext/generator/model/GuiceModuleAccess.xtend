/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.util.internal.Log

@Log
class GuiceModuleAccess {
	
	@Data
	static class BindKey {
		TypeReference type
		boolean singleton
		boolean eagerSingleton
		
		override equals(Object other) {
			if (other instanceof BindKey)
				this.type == other.type
			else
				false
		}
		
		override hashCode() {
			type.hashCode
		}
	}
	
	@Data
	static class BindValue {
		Object expression
		TypeReference type
		boolean provider
		List<CharSequence> statements
	}
	
	@Data
	static class Binding {
		BindKey key
		BindValue value
		boolean isFinal
		String contributedBy
		
		override equals(Object other) {
			if (other instanceof Binding)
				this.key == other.key
			else
				false
		}
		
		override hashCode() {
			key.hashCode
		}
	}
	
	val Set<Binding> bindings = newLinkedHashSet
	
	@Accessors
	String superClassName
	
	def void add(Binding newBinding) {
		if (bindings.contains(newBinding)) {
			val iterator = bindings.iterator()
			var found = false
			while (iterator.hasNext && !found) {
				val oldBinding = iterator.next
				if (oldBinding == newBinding) {
					if (oldBinding.isFinal) {
						if (newBinding.isFinal) {
							throw new IllegalStateException("Conflicting final bindings for '" + oldBinding.key.type + "' from fragments "
									+ oldBinding.contributedBy + " and " + newBinding.contributedBy)
						} else {
							LOG.warn("Cannot override final binding '" + oldBinding + "'. "
									+ "Ignoring binding from fragment '" + newBinding.contributedBy + "'")
						}
					} else {
						LOG.debug("replacing binding : " + oldBinding)
						LOG.debug(" with new binding : " + newBinding)
						iterator.remove()
					}
					found = true
				}
			}
		}
		bindings.add(newBinding)
	}
	
	def void addAll(Iterable<Binding> bindings) {
		for (binding : bindings) {
			add(binding)
		}
	}
	
	def Set<Binding> getBindings() {
		Collections.unmodifiableSet(bindings)
	}
	
	
	static class BindingFactory {
		
		@Accessors
		val String contributedBy
		
		val Set<Binding> bindings = newLinkedHashSet
	
		new() {
			this.contributedBy = new Exception().stackTrace.get(1).className
		}
		
		new(String contributedBy) {
			this.contributedBy = contributedBy
		}
		
		private def add(BindKey type, BindValue expr) {
			add(type, expr, false);
		}
	
		private def add(BindKey type, BindValue expr, boolean isFinal) {
			add(new Binding(type, expr, isFinal, contributedBy))
		}
	
		private def add(Binding binding) {
			if (!bindings.add(binding))
				throw new IllegalArgumentException("Duplicate binding for " + binding.key + " in " + contributedBy)
		}
		
		private def key(TypeReference type) {
			return new BindKey(type, false, false)
		}
		
		private def eagerSingleton(TypeReference type) {
			return new BindKey(type, true, true)
		}
		
		private def singleton(TypeReference type) {
			return new BindKey(type, true, false)
		}
		
		private def value(TypeReference type) {
			return new BindValue(null, type, false, Collections.emptyList)
		}
	
		private def expr(Object expr) {
			return new BindValue(expr, null, false, Collections.emptyList)
		}
	
		private def provider(TypeReference type) {
			return new BindValue(null, type, true, Collections.emptyList)
		}
	
		private def providerExpr(Object expr) {
			return new BindValue(expr, null, true, Collections.emptyList)
		}
	
		private def statements(String[] statements) {
			return new BindValue(null, null, false, statements)
		}
	
		def BindingFactory addTypeToInstance(TypeReference s1, Object s2) {
			add(key(s1), expr(s2))
			return this
		}
		
		def BindingFactory addTypeToProviderInstance(TypeReference s1, Object s2) {
			add(key(s1), providerExpr(s2))
			return this
		}
		
		def BindingFactory addConfiguredBinding(TypeReference key, String... statements) {
			add(key(key), statements(statements))
			return this
		}
	
		def BindingFactory addTypeToType(TypeReference s1, TypeReference s2){
			add(key(s1), value(s2))
			return this
		}
		
		def BindingFactory addTypeToTypeSingleton(TypeReference s1, TypeReference s2){
			add(singleton(s1), value(s2))
			return this
		}
		
		def BindingFactory addTypeToTypeEagerSingleton(TypeReference s1, TypeReference s2){
			add(eagerSingleton(s1), value(s2))
			return this
		}
		
		def BindingFactory addTypeToProvider(TypeReference s1, TypeReference s2){
			add(key(s1), provider(s2))
			return this
		}
		
		def BindingFactory addTypeToProviderSingleton(TypeReference s1, TypeReference s2){
			add(singleton(s1), provider(s2))
			return this
		}
		
		def BindingFactory addTypeToProviderEagerSingleton(TypeReference s1, TypeReference s2){
			add(eagerSingleton(s1), provider(s2))
			return this
		}
		
		def BindingFactory addfinalTypeToType(TypeReference s1, TypeReference s2){
			add(key(s1), value(s2), true)
			return this
		}
		
		def BindingFactory addfinalTypeToTypeSingleton(TypeReference s1, TypeReference s2){
			add(singleton(s1), value(s2), true)
			return this
		}
		
		def BindingFactory addfinalTypeToTypeEagerSingleton(TypeReference s1, TypeReference s2){
			add(eagerSingleton(s1), value(s2), true)
			return this
		}
		
		def BindingFactory addfinalTypeToProvider(TypeReference s1, TypeReference s2){
			add(key(s1), provider(s2), true)
			return this
		}
		
		def BindingFactory addfinalTypeToProviderSingleton(TypeReference s1, TypeReference s2){
			add(singleton(s1), provider(s2), true)
			return this
		}
		
		def BindingFactory addfinalTypeToProviderEagerSingleton(TypeReference s1, TypeReference s2){
			add(eagerSingleton(s1), provider(s2), true)
			return this
		}
	
		def void contributeTo(GuiceModuleAccess module) {
			module.addAll(this.bindings)
		}
	}
	
}
