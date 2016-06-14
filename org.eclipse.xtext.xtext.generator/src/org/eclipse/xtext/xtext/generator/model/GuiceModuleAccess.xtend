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
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.util.internal.Log

@Log
class GuiceModuleAccess {
	
	@Data
	static class BindKey {
		String name
		TypeReference type
		boolean singleton
		boolean eagerSingleton
		
		override equals(Object other) {
			if (other instanceof BindKey)
				this.name == other.name && this.type == other.type
			else
				false
		}
		
		override hashCode() {
			var h = 0
			if (name !== null) h += name.hashCode
			if (type !== null) h += type.hashCode
			return h
		}
	}
	
	@Data
	static class BindValue {
		Object expression
		TypeReference type
		boolean provider
		List<Object> statements
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
	TypeReference superClass
	
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
			return new BindKey(null, type, false, false)
		}
		
		private def key(String name) {
			return new BindKey(name, null, false, false)
		}
		
		private def eagerSingleton(TypeReference type) {
			return new BindKey(null, type, true, true)
		}
		
		private def singleton(TypeReference type) {
			return new BindKey(null, type, true, false)
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
	
		private def statements(Object[] statements) {
			return new BindValue(null, null, false, statements)
		}
	
		def BindingFactory addTypeToInstance(TypeReference type, StringConcatenationClient expression) {
			add(key(type), expr(expression))
			return this
		}
		
		def BindingFactory addTypeToProviderInstance(TypeReference type, StringConcatenationClient expression) {
			add(key(type), providerExpr(expression))
			return this
		}
		
		def BindingFactory addConfiguredBinding(String name, StringConcatenationClient statement) {
			add(key(name), statements(#[statement]))
			return this
		}
	
		def BindingFactory addTypeToType(TypeReference keyType, TypeReference valueType){
			add(key(keyType), value(valueType))
			return this
		}
		
		def BindingFactory addTypeToTypeSingleton(TypeReference keyType, TypeReference valueType){
			add(singleton(keyType), value(valueType))
			return this
		}
		
		def BindingFactory addTypeToTypeEagerSingleton(TypeReference keyType, TypeReference valueType){
			add(eagerSingleton(keyType), value(valueType))
			return this
		}
		
		def BindingFactory addTypeToProvider(TypeReference keyType, TypeReference valueType){
			add(key(keyType), provider(valueType))
			return this
		}
		
		def BindingFactory addTypeToProviderSingleton(TypeReference keyType, TypeReference valueType){
			add(singleton(keyType), provider(valueType))
			return this
		}
		
		def BindingFactory addTypeToProviderEagerSingleton(TypeReference keyType, TypeReference valueType){
			add(eagerSingleton(keyType), provider(valueType))
			return this
		}
		
		def BindingFactory addfinalTypeToType(TypeReference keyType, TypeReference valueType){
			add(key(keyType), value(valueType), true)
			return this
		}
		
		def BindingFactory addfinalTypeToTypeSingleton(TypeReference keyType, TypeReference valueType){
			add(singleton(keyType), value(valueType), true)
			return this
		}
		
		def BindingFactory addfinalTypeToTypeEagerSingleton(TypeReference keyType, TypeReference valueType){
			add(eagerSingleton(keyType), value(valueType), true)
			return this
		}
		
		def BindingFactory addfinalTypeToProvider(TypeReference keyType, TypeReference valueType){
			add(key(keyType), provider(valueType), true)
			return this
		}
		
		def BindingFactory addfinalTypeToProviderSingleton(TypeReference keyType, TypeReference valueType){
			add(singleton(keyType), provider(valueType), true)
			return this
		}
		
		def BindingFactory addfinalTypeToProviderEagerSingleton(TypeReference keyType, TypeReference valueType){
			add(eagerSingleton(keyType), provider(valueType), true)
			return this
		}
	
		def void contributeTo(GuiceModuleAccess module) {
			module.addAll(this.bindings)
		}
	}
	
}
