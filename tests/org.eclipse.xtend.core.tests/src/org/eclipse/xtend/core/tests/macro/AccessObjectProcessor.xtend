package org.eclipse.xtend.core.tests.macro

import java.io.Serializable
import java.util.LinkedList
import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test

class AccessObjectProcessorTest extends AbstractActiveAnnotationTest {
	@Test def void testWithoutPackage() {
		'''
			import org.eclipse.xtend.core.tests.macro.Accessors
			
			@org.eclipse.xtend.core.tests.macro.AccessObjectAnn
			class A {
				String field
			}
		'''.compile [
			val ctx = transformationContext
			val classA = ctx.findClass('A')
			assertNotNull(classA.findDeclaredMethod('getField'))
			val classPA = ctx.findClass('PA')
			assertNotNull(classPA.implementedInterfaces.findFirst[type == ctx.newTypeReference(typeof(Serializable)).type])
			val classGA = ctx.findClass('GA')
			assertNotNull(classGA.implementedInterfaces.findFirst[type == ctx.newTypeReference(typeof(Serializable)).type])
		]
	}
	@Test def void testWithPackage() {
		'''
			package my.pack
			import org.eclipse.xtend.core.tests.macro.Accessors
			
			@org.eclipse.xtend.core.tests.macro.AccessObjectAnn
			class A {
				String field
			}
		'''.compile [
			val ctx = transformationContext
			val classA = ctx.findClass('my.pack.A')
			assertNotNull(classA.findDeclaredMethod('getField'))
			val classPA = ctx.findClass('my.pack.PA')
			assertNotNull(classPA.implementedInterfaces.findFirst[type == ctx.newTypeReference(typeof(Serializable)).type])
			val classGA = ctx.findClass('my.pack.GA')
			assertNotNull(classGA.implementedInterfaces.findFirst[type == ctx.newTypeReference(typeof(Serializable)).type])
		]
	}
}


@Active(typeof(AccessObjectProcessor))
annotation AccessObjectAnn { }
class AccessObjectProcessor implements TransformationParticipant<MutableClassDeclaration>, RegisterGlobalsParticipant<ClassDeclaration> {
	
	override doTransform(List<? extends MutableClassDeclaration> annotatedSourceClasses, 
		extension TransformationContext ctx
	) {
		for (it : annotatedSourceClasses) {
			for (field : it.declaredFields) {
				field.declaringType.addMethod('get'+field.simpleName.toFirstUpper) [
					returnType = field.type 
					body = ['''
						return this.«field.simpleName»;
					''']
				]
			}
			
			val pkg = it.qualifiedName.substring(0, it.qualifiedName.length-it.simpleName.length)
			
			val ser = newTypeReference(typeof(Serializable))
			if ( ser === null )
				addError("Cannot find Serializable")
			
			val PVersionName = pkg+"P"+it.simpleName;
			val p = findClass(PVersionName)
			if ( p == null )
				addError("Class "+PVersionName+" not found")
			if ( p!=null && ser != null) {
				val pIfcs = new LinkedList
				pIfcs.add(ser)
				p.setImplementedInterfaces(pIfcs)
			}
			
			val GVersionName = pkg+"G"+it.simpleName;
			val g = findClass(GVersionName)
			if ( g == null )
				addError("Class "+GVersionName+" not found")
			if ( g!=null && ser != null) {
				val gIfcs = new LinkedList
				gIfcs.add(ser)
				g.setImplementedInterfaces(gIfcs)
			}
		}
	}
	
	override doRegisterGlobals(List<? extends ClassDeclaration> annotatedSourceElements, 
		extension RegisterGlobalsContext ctx
	) {
		for (it : annotatedSourceElements) {
			val pkg = it.qualifiedName.substring(0, it.qualifiedName.length-it.simpleName.length)
			val PVersionName = pkg+"P"+it.simpleName;
			val GVersionName = pkg+"G"+it.simpleName;
			ctx.registerClass(PVersionName)
			ctx.registerClass(GVersionName)
		}
	}
}