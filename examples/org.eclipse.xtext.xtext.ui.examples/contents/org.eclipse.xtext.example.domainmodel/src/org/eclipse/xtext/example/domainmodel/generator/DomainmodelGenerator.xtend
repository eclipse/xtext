/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.xbase.compiler.*
import org.eclipse.xtext.xbase.*
import org.eclipse.xtext.example.domainmodel.domainmodel.*
import org.eclipse.xtext.common.types.*
import java.util.*
import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*

class DomainmodelGenerator implements IGenerator {
	
	@Inject extension GeneratorExtensions 
	
	@Inject DomainmodelCompiler
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		// TODO: use filter
		for(element: resource.allContentsIterable) {
			if(element instanceof Entity) {
				val entity = element as Entity				
				fsa.generateFile(entity.fileName, entity.compile)
			}
		}
	}
	
	compile(Entity e) { 
		val importManager = new ImportManager(true);
		val body = body(e, importManager);
		'''
		package «e.packageName»;
		
		«FOR i:importManager.imports»
		import «i»;
		«ENDFOR»
		
		«body»
		'''
	}
	
	body(Entity e, ImportManager importManager) {
		'''
		public class «e.name» «e.superTypeClause(importManager)»{
			«FOR f:e.features»
			«feature(f, importManager)»
			
			«ENDFOR»
		}
		'''   
	}
	
	superTypeClause(Entity e, ImportManager importManager) {
		if(e.superType != null)
			(if ((e.superType.type as JvmGenericType).isInterface) 
				'implements ' 
			else 
				'extends ') + e.superType.shortName(importManager) + " "
		else ""    
	}
	
	dispatch feature(Property p, ImportManager importManager) {
		'''
		private «p.type.shortName(importManager)» «p.name»;
			
		public «p.type.shortName(importManager)» get«p.name.toFirstUpper»() {
			return «p.name»;
		}
		
		public void set«p.name.toFirstUpper»(«p.type.shortName(importManager)» «p.name») {
			this.«p.name» = «p.name»;
		}
		'''
	}

	dispatch feature(Operation o, ImportManager importManager) {
		'''
		public «o.type.shortName(importManager)» «o.name»(«o.parameterList(importManager)») {
			«domainmodelCompiler.compile(o, importManager)» 
		}
		'''
	}
	
}
