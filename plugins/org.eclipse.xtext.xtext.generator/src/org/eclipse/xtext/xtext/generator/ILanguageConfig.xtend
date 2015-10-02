/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess

interface ILanguageConfig {
	
	def Grammar getGrammar()
	
	def List<String> getFileExtensions()
	
	def StandaloneSetupAccess getRuntimeGenSetup()
	
	def GuiceModuleAccess getRuntimeGenModule()
	
	def GuiceModuleAccess getEclipsePluginGenModule()
	
	def GuiceModuleAccess getIdeaGenModule()
	
	def GuiceModuleAccess getWebGenModule()
	
	def ResourceSet getResourceSet()
	
}