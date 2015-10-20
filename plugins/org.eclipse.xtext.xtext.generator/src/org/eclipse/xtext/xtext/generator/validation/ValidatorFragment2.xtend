/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.validation

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.ComposedChecks
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static org.eclipse.xtext.GrammarUtil.*

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

class ValidatorFragment2 extends AbstractXtextGeneratorFragment {
	
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	@Inject CodeConfig codeConfig
	
	@Accessors
	boolean generateStub = true
	
	@Accessors
	boolean inheritImplementation = true
	
	val List<String> composedChecks = newArrayList
	
	/**
	 * Adds a validator that is to be executed additionally.
	 * 
	 * @param composedCheckValidator
	 *            name of a class extending {@link AbstractDeclarativeValidator}
	 */
	def void addComposedCheck(String composedCheckValidator) {
		composedChecks += composedCheckValidator
	}
	
	/**
	 * @return a {@link TypeReference} wrapping the desired validator class' simple name and package name
	 */
	public def TypeReference getValidatorClass(Grammar grammar) {
		// is public for being callable by QuickFixProviderFragement2
		new TypeReference(grammar.runtimeBasePackage + '.validation.' + getSimpleName(grammar) + 'Validator')
	}
	
	protected def TypeReference getAbstractValidatorClass(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage + '.validation.Abstract' + getSimpleName(grammar) + 'Validator')
	}
	
	protected def TypeReference getValidatorSuperClass(Grammar grammar) {
		val superGrammar = grammar.nonTerminalsSuperGrammar
		if (inheritImplementation && superGrammar !== null) 
			superGrammar.validatorClass
		else 
			defaultValidatorSuperClass
	}

	protected def TypeReference getDefaultValidatorSuperClass() {
		new TypeReference(AbstractDeclarativeValidator)
	}
	
	override generate() {
		val bindingFactory = new GuiceModuleAccess.BindingFactory()
		if (generateStub)
			bindingFactory.addTypeToTypeEagerSingleton(grammar.validatorClass, grammar.validatorClass)
		else
			bindingFactory.addTypeToTypeEagerSingleton(grammar.abstractValidatorClass, grammar.abstractValidatorClass)
		bindingFactory.contributeTo(language.runtimeGenModule)
		
		if (generateStub) {
			if (codeConfig.preferXtendStubs)
				generateXtendValidatorStub()
			else
				generateJavaValidatorStub()
		}
		generateAbstractValidator()
		
		if (projectConfig.runtime.manifest !== null)
			projectConfig.runtime.manifest.exportedPackages += grammar.validatorClass.packageName
		
		if (projectConfig.eclipsePlugin.pluginXml !== null)
			contributeEclipsePluginExtensions()
	}
	
	protected def generateXtendValidatorStub() {
		fileAccessFactory.createXtendFile(grammar.validatorClass, '''
			/**
			 * This class contains custom validation rules. 
			 *
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
			 */
			class «grammar.validatorClass.simpleName» extends «grammar.abstractValidatorClass» {
				
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
		''').writeTo(projectConfig.runtime.src)
	}
	
	protected def generateJavaValidatorStub() {
		fileAccessFactory.createJavaFile(grammar.validatorClass, '''
			/**
			 * This class contains custom validation rules. 
			 *
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
			 */
			public class «grammar.validatorClass.simpleName» extends «grammar.abstractValidatorClass» {
				
			//	@Check
			//	public void checkGreetingStartsWithCapital(Greeting greeting) {
			//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
			//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
			//		}
			//	}
				
			}
		''').writeTo(projectConfig.runtime.src)
	}
	
	protected def generateAbstractValidator() {
		val javaFile = fileAccessFactory.createGeneratedJavaFile(grammar.abstractValidatorClass)
		javaFile.content = '''
			«IF !composedChecks.empty»
			@«ComposedChecks»(validators = {«FOR validator: composedChecks SEPARATOR ", "»«validator.typeRef».class«ENDFOR»})
			«ENDIF»
			public «IF generateStub»abstract «ENDIF»class «grammar.abstractValidatorClass.simpleName» extends «grammar.validatorSuperClass» {
				
				@Override
				protected «List»<«EPackage»> getEPackages() {
				    «List»<«EPackage»> result = new «ArrayList»<«EPackage»>(«IF inheritImplementation && grammar.nonTerminalsSuperGrammar !== null»super.getEPackages()«ENDIF»);
				    «FOR e: generatedPackagesToValidate»
				    	result.add(«e.generatedEPackageName».eINSTANCE);
				    «ENDFOR»
				    «FOR e: registryPackagesToValidate»
				    	result.add(EPackage.Registry.INSTANCE.getEPackage("«e.nsURI»"));
				   	«ENDFOR»
					return result;
				}
				
			}
		'''
		javaFile.writeTo(projectConfig.runtime.srcGen)
	}
	
	protected def getGeneratedPackagesToValidate() {
		grammar.metamodelDeclarations.filter(GeneratedMetamodel).map[EPackage]
	}

	protected def getRegistryPackagesToValidate() {
		val packages = allEPackagesToValidate(grammar)
		packages.removeAll(allMetamodelDeclarations(grammar).filter(GeneratedMetamodel).map[EPackage].toList)
		return packages
	}
	
	protected def String getGeneratedEPackageName(EPackage pack) {
		'''«grammar.runtimeBasePackage».«pack.name».«pack.name.toFirstUpper»Package'''
	}
	
	protected def contributeEclipsePluginExtensions() {
		val simpleName = getSimpleName(grammar)
		projectConfig.eclipsePlugin.pluginXml.entries += '''
			<!-- marker definitions for «grammar.name» -->
			<extension
					id="«simpleName.toLowerCase».check.fast"
					name="«simpleName» Problem"
					point="org.eclipse.core.resources.markers">
				<super type="org.eclipse.xtext.ui.check.fast"/>
				<persistent value="true"/>
			</extension>
			<extension
					id="«simpleName.toLowerCase».check.normal"
					name="«simpleName» Problem"
					point="org.eclipse.core.resources.markers">
				<super type="org.eclipse.xtext.ui.check.normal"/>
				<persistent value="true"/>
			</extension>
			<extension
					id="«simpleName.toLowerCase».check.expensive"
					name="«simpleName» Problem"
					point="org.eclipse.core.resources.markers">
				<super type="org.eclipse.xtext.ui.check.expensive"/>
				<persistent value="true"/>
			</extension>
		'''
	}
	
}