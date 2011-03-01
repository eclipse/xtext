package org.eclipse.xtext.example.domainmodel.compiler

import org.eclipse.xtext.xbase.compiler.*
import org.eclipse.xtext.xbase.*
import org.eclipse.xtext.example.domainmodel.domainmodel.*
import org.eclipse.xtext.common.types.*
import java.util.*

class DomainmodelCompiler {
	
	@Inject extension CompilerExtensions 
	
	@Inject XbaseCompiler
	
	compile(Entity e) { 
		val importManager = new ImportManager(true);
		val body = body(e, importManager);
		'''
		package «e.packageName()»;
		
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
			
		public «p.type.shortName(importManager)» get«p.name.toFirstUpper()»() {
			return «p.name»;
		}
		
		public void set«p.name.toFirstUpper()»(«p.type.shortName(importManager)» «p.name») {
			this.«p.name» = «p.name»;
		}
		'''
	}

	dispatch feature(Operation o, ImportManager importManager) {
		'''
		public «o.type.shortName(importManager)» «o.name»(
			«FOR p:o.params»«p.parameterType.shortName(importManager)» «p.name»«ENDFOR») {
			// now it becomes interesting
			«body(o, importManager)» 
		}
		'''
	}
	
	body(Operation o, ImportManager importManager) {
		val appendable = new StringBuilderBasedAppendable(importManager)
		xbaseCompiler.compile(o.body, appendable, o.type)
		appendable.toString()
	}
	
}  