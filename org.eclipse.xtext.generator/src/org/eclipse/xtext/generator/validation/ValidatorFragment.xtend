/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.IInheriting
import org.eclipse.xtext.generator.IStubGenerating
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

import static org.eclipse.xtext.GrammarUtil.*

import static extension org.eclipse.xtext.generator.IInheriting.Util.*

/**
 * Generates an Xtend-based model validator.
 * 
 * @author Jan Koehnlein
 * @since 2.4
 */
@Deprecated(forRemoval = true)
class ValidatorFragment extends Xtend2GeneratorFragment implements IInheriting, IStubGenerating {

	@Inject extension Naming
	
	@Inject extension ValidatorNaming
	
	@Accessors boolean inheritImplementation = true

	@Accessors boolean generateStub = true

	@Inject Grammar grammar
	
	val composedChecks = <String>newArrayList
	
	def addComposedCheck(String composedCheckValidator) {
		this.composedChecks.add(composedCheckValidator)
	}
	
	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
			val bindFactory = new BindFactory()
		if(generateStub) {
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
		ctx.writeFile(Generator.SRC_GEN, abstractValidatorName.asPath + ".java", '''
			«fileHeader»
			package «abstractValidatorName.packageName»;
			
			«annotationImports»
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			«IF !composedChecks.isEmpty»
			import org.eclipse.xtext.validation.ComposedChecks;
			«ENDIF»
			
			«IF !composedChecks.isEmpty»
			@ComposedChecks(validators= {«FOR validator: composedChecks SEPARATOR ", "»«validator».class«ENDFOR»})
			«ENDIF»
			«classAnnotations»public class «abstractValidatorName.toSimpleName» extends «getValidatorSuperClassName(isInheritImplementation)» {
			
				@Override
				protected List<EPackage> getEPackages() {
				    List<EPackage> result = new ArrayList<EPackage>(«IF isInheritImplementation && grammar.nonTerminalsSuperGrammar !== null»super.getEPackages()«ENDIF»);
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
		if(generateStub) {
			ctx.writeFile(Generator.SRC, grammar.validatorName.asPath + '.xtend', '''
				«fileHeader»
				package «grammar.validatorName.packageName»
				
				//import org.eclipse.xtext.validation.Check
				
				/**
				 * This class contains custom validation rules. 
				 *
				 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
				 */
				class «grammar.validatorName.toSimpleName» extends «abstractValidatorName.toSimpleName()» {

				//  public static val INVALID_NAME = 'invalidName'
				//
				//	@Check
				//	def checkGreetingStartsWithCapital(Greeting greeting) {
				//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
				//			warning('Name should start with a capital', 
				//					MyDslPackage.Literals.GREETING__NAME,
				//					INVALID_NAME)
				//		}
				//	}
				}
			''')
		}
	}

	def getGeneratedPackagesToValidate() {
		grammar.metamodelDeclarations.filter(GeneratedMetamodel).map[EPackage]
	}

	def protected getRegistryPackagesToValidate() {
		val packages = allEPackagesToValidate(grammar)
		packages.removeAll(
			allMetamodelDeclarations(grammar).filter(GeneratedMetamodel).map[EPackage].toList
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