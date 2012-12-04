/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IInheriting
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

import static org.eclipse.xtext.GrammarUtil.*
import javax.inject.Named

/**
 * Generates an Xtend-based model validator.
 * 
 * @author Jan Koehnlein
 * @since 2.4
 */
class ValidatorFragment extends Xtend2GeneratorFragment implements IInheriting {
	
	@Inject extension ValidatorNaming
	
	@Property boolean inheritImplementation

	@Property boolean generateXtendStub

	@Inject Grammar grammar
	
	@Inject@Named("fileHeader") String fileHeader
	
	val composedChecks = <String>newArrayList
	
	def addComposedCheck(String composedCheckValidator) {
		this.composedChecks.add(composedCheckValidator)
	}
	
	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
			val bindFactory = new BindFactory()
		if(generateXtendStub) {
			bindFactory.addTypeToTypeEagerSingleton(
					grammar.validatorName,
					grammar.validatorName)
		} else {
			bindFactory.addTypeToTypeEagerSingleton(
					abstractValidatorName,
					abstractValidatorName)
		}
		bindFactory.bindings
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		ctx.writeFile(Generator::SRC_GEN, abstractValidatorName.asPath + ".java", '''
			/*
			 «fileHeader»
			 */
			package «abstractValidatorName.packageName»;
			
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			import «getValidatorSuperClassName(isInheritImplementation)»;
			«IF !composedChecks.isEmpty»
			import org.eclipse.xtext.validation.ComposedChecks;
			«ENDIF»
			
			«IF !composedChecks.isEmpty»
			@ComposedChecks(validators= {«FOR validator: composedChecks SEPARATOR ", "»«validator».class«ENDFOR»})
			«ENDIF»
			public class «abstractValidatorName.toSimpleName» extends «getValidatorSuperClassName(isInheritImplementation).toSimpleName» {
			
				@Override
				protected List<EPackage> getEPackages() {
				    List<EPackage> result = new ArrayList<EPackage>();
				    «FOR e: generatedPackagesToValidate»
				    result.add(«e.generatedEPackageName».eINSTANCE);
				    «ENDFOR»
				    «FOR e: registryPackagesToValidate»
				    result.add(EPackage.Registry.INSTANCE.getEPackage("«e.nsURI»"));
				   	«ENDFOR»
					return result;
				}
			}
		''')
		if(generateXtendStub) {
			ctx.writeFile(Generator::SRC, grammar.validatorName.asPath + '.xtend', '''
				/*
				 «fileHeader»
				 */
				package «grammar.validatorName.packageName»
				//import org.eclipse.xtext.validation.Check
				
				/**
				 * Custom validation rules. 
				 *
				 * see http://www.eclipse.org/Xtext/documentation.html#validation
				 */
				class «grammar.validatorName.toSimpleName» extends «abstractValidatorName.toSimpleName()» {

				//  public static val INVALID_NAME = 'invalidName'

				//	@Check
				//	def checkGreetingStartsWithCapital(Greeting greeting) {
				//		if (!Character::isUpperCase(greeting.name.charAt(0))) {
				//			warning('Name should start with a capital', 
				//					MyDslPackage$Literals::GREETING__NAME,
				//					INVALID_NAME)
				//		}
				//	}
				}
			''')
		}
	}

	def getGeneratedPackagesToValidate() {
		grammar.metamodelDeclarations.filter(typeof(GeneratedMetamodel)).map[EPackage]
	}

	def protected getRegistryPackagesToValidate() {
		val packages = allEPackagesToValidate(grammar)
		packages.removeAll(
			allMetamodelDeclarations(grammar).filter(typeof(GeneratedMetamodel)).map[EPackage].toList
		)
		packages
	}
	
	override getExportedPackagesRtList(Grammar grammar) {
		return newArrayList(grammar.validatorName.packageName)
	}
	
	override addToPluginXmlUi(Xtend2ExecutionContext ctx) {
		ctx.append('''
			«»
				<!-- marker definitions for «grammar.name» -->
				<extension
				        id="«grammar.name.toSimpleName.toLowerCase».check.fast"
				        name="«grammar.name.toSimpleName» Problem"
				        point="org.eclipse.core.resources.markers">
				    <super type="org.eclipse.xtext.ui.check.fast"/>
				    <persistent value="true"/>
				</extension>
				<extension
				        id="«grammar.name.toSimpleName.toLowerCase».check.normal"
				        name="«grammar.name.toSimpleName» Problem"
				        point="org.eclipse.core.resources.markers">
				    <super type="org.eclipse.xtext.ui.check.normal"/>
				    <persistent value="true"/>
				</extension>
				<extension
				        id="«grammar.name.toSimpleName.toLowerCase».check.expensive"
				        name="«grammar.name.toSimpleName» Problem"
				        point="org.eclipse.core.resources.markers">
				    <super type="org.eclipse.xtext.ui.check.expensive"/>
				    <persistent value="true"/>
				</extension>
		''')
	}
	
}