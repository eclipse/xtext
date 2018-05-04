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
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ComposedChecks
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider
import org.eclipse.xtext.validation.SeverityConverter
import org.eclipse.xtext.xtext.AnnotationNames
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.preferences.PreferenceKey
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector

/**
 * By using this fragment validation gets enabled.
 * By using @Deprecated in the grammar on a ParserRule a validation gets generated that raises an issue for that.
 * In this way model evolution becomes possible.
 */
class ValidatorFragment2 extends AbstractInheritingFragment {

	@Inject extension ValidatorNaming
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	@Inject extension XbaseUsageDetector
	
	@Accessors
	boolean generateDeprecationValidation = true;

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
	 * @since 2.14
	 */
	protected def getConfigurableIssueCodesProviderClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.validation.' + grammar.simpleName + 'ConfigurableIssueCodesProvider')
	}
	
	/**
	 * @since 2.14
	 */
	protected def getValidatorConfigurationBlockClass(){
		return new TypeReference(grammar.runtimeBasePackage + '.validation.' + grammar.simpleName + 'ValidatorConfigurationBlock')
	}
	
	/**
	 * @since 2.14
	 */
	protected def getAbstractValidatorConfigurationBlockClass(){
		return new TypeReference("org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock")
	}
	
	/**
	 * @since 2.14
	 */
	protected def getXbaseValidationConfigurationBlockClass(){
		return new TypeReference("org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock");
	}

	/**
	 * @since 2.14
	 */
	protected def getSuperConfigurableIssueCodesProviderClass(){
		if(language.grammar.inheritsXbase){
			return new TypeReference("org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes")
		} else {
			return new TypeReference(ConfigurableIssueCodesProvider)	
		}
	}

	protected def TypeReference getGenValidatorSuperClass(Grammar grammar) {
		val superGrammar = grammar.nonTerminalsSuperGrammar
		if (inheritImplementation && superGrammar !== null)
			superGrammar.validatorClass
		else
			defaultValidatorSuperClass
	}

	protected def TypeReference getDefaultValidatorSuperClass() {
		new TypeReference(AbstractDeclarativeValidator)
	}
	
	/**
	 * @since 2.14
	 */
	protected def contributeRuntimeGuiceBindings() {
		val bindingFactory = new GuiceModuleAccess.BindingFactory
		bindingFactory.addTypeToTypeEagerSingleton(grammar.validatorClass, grammar.validatorClass)
		bindingFactory.addTypeToType(superConfigurableIssueCodesProviderClass,configurableIssueCodesProviderClass)
		bindingFactory.contributeTo(language.runtimeGenModule)
	}
	/**
	 * @since 2.14
	 */
	protected def contributePluginGuiceBindings() {
		val bindingFactory = new GuiceModuleAccess.BindingFactory
		bindingFactory.addTypeToType(abstractValidatorConfigurationBlockClass,validatorConfigurationBlockClass)
		bindingFactory.contributeTo(language.eclipsePluginGenModule)
	}

	override generate() {
		contributeRuntimeGuiceBindings
		contributePluginGuiceBindings
		
		if (isGenerateStub) {
			if (generateXtendStub)
				generateXtendValidatorStub()
			else
				generateJavaValidatorStub()
		}
		generateGenValidator().writeTo(projectConfig.runtime.srcGen)
		generateIssueProvider().writeTo(projectConfig.runtime.srcGen)
		generateValidationConfigurationBlock().writeTo(projectConfig.eclipsePlugin.srcGen)

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
				
			//	public static val INVALID_NAME = 'invalidName'
			//
			//	@Check
			//	def checkGreetingStartsWithCapital(Greeting greeting) {
			//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
			//			warning('Name should start with a capital', 
			//					«grammar.simpleName»Package.Literals.GREETING__NAME,
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
				
			//	public static final INVALID_NAME = 'invalidName'
			//
			//	@Check
			//	public void checkGreetingStartsWithCapital(Greeting greeting) {
			//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
			//			warning("Name should start with a capital",
			//					«grammar.simpleName»Package.Literals.GREETING__NAME,
			//					INVALID_NAME);
			//		}
			//	}
				
			}
		''').writeTo(projectConfig.runtime.src)
	}

	protected def generateGenValidator() {
		// take the non-abstract class signature for the src-gen class in case of !generateStub
		// as validators of sub languages refer to 'superGrammar.validatorClass',
		// see 'getGenValidatorSuperClass(...)'
		val genClass = if(isGenerateStub) grammar.abstractValidatorClass else grammar.validatorClass

		val javaFile = fileAccessFactory.createGeneratedJavaFile(genClass)
		javaFile.content = '''
			«IF !composedChecks.empty»
				@«ComposedChecks»(validators = {«FOR validator: composedChecks SEPARATOR ", "»«validator.typeRef».class«ENDFOR»})
			«ENDIF»
			public «IF isGenerateStub»abstract «ENDIF»class «genClass.simpleName» extends «grammar.genValidatorSuperClass» {
				
				@Override
				protected «List»<«EPackage»> getEPackages() {
					«List»<«EPackage»> result = new «ArrayList»<«EPackage»>(«IF inheritImplementation && grammar.nonTerminalsSuperGrammar !== null»super.getEPackages()«ENDIF»);
					«FOR e : generatedPackagesToValidate»
						result.add(«e.generatedEPackageName».eINSTANCE);
					«ENDFOR»
					«FOR e : registryPackagesToValidate»
						result.add(EPackage.Registry.INSTANCE.getEPackage("«e.nsURI»"));
					«ENDFOR»
					return result;
				}
				«generateValidationToDeprecateRules»
			}
		'''
		javaFile
	}
	
	/**
	 * @since 2.14
	 */
	protected def generateIssueProvider(){
		val javaFile = fileAccessFactory.createGeneratedJavaFile(configurableIssueCodesProviderClass)
		javaFile.content = '''
			@SuppressWarnings("restriction")
			public class «configurableIssueCodesProviderClass» extends «superConfigurableIssueCodesProviderClass» {
				protected static final String ISSUE_CODE_PREFIX = "«grammar.runtimeBasePackage».";
			
				«IF generateDeprecationValidation»
					public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + "deprecatedModelPart";
				«ENDIF»
			
				@Override
				protected void initialize(«IAcceptor»<«PreferenceKey»> acceptor) {
					super.initialize(acceptor);
					«IF generateDeprecationValidation»
						acceptor.accept(create(DEPRECATED_MODEL_PART, «SeverityConverter».SEVERITY_WARNING));
					«ENDIF»
				}
			}
		'''
		javaFile
	}
	
	protected def generateValidationConfigurationBlock() {
		val javaFile = fileAccessFactory.createGeneratedJavaFile(validatorConfigurationBlockClass)
		javaFile.content = '''
			@SuppressWarnings("restriction")
			public class «validatorConfigurationBlockClass» extends «if(language.grammar.inheritsXbase) xbaseValidationConfigurationBlockClass else abstractValidatorConfigurationBlockClass» {
			
				@Override
				protected void fillSettingsPage(«typeRef("org.eclipse.swt.widgets.Composite")» composite, int nColumns, int defaultIndent) {
					«IF generateDeprecationValidation»
						addComboBox(«getConfigurableIssueCodesProviderClass».DEPRECATED_MODEL_PART, "Deprecated Model Part", composite, defaultIndent);
					«ENDIF»
					«IF language.grammar.inheritsXbase»
						super.fillSettingsPage(composite, nColumns, defaultIndent);
					«ENDIF»
				}
			
				@Override
				protected «typeRef('org.eclipse.core.runtime.jobs.Job')» getBuildJob(«typeRef('org.eclipse.core.resources.IProject')» project) {
					«typeRef('org.eclipse.core.runtime.jobs.Job')» buildJob = new «typeRef('org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock')».BuildJob("Validation Settings Changed", project);
					buildJob.setRule(«typeRef('org.eclipse.core.resources.ResourcesPlugin')».getWorkspace().getRuleFactory().buildRule());
					buildJob.setUser(true);
					return buildJob;
				}
			
				@Override
				protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
					return new String[] { "Validation Settings Changed",
							"Validation settings have changed. A full rebuild is required for changes to take effect. Do the full build now?" };
				}
			
				@Override
				protected void validateSettings(String changedKey, String oldValue, String newValue) {
					«IF language.grammar.inheritsXbase»
						super.validateSettings(changedKey, oldValue, newValue);
					«ENDIF»
				}
			
				protected «typeRef('org.eclipse.swt.widgets.Combo')» addComboBox(String prefKey, String label, Composite parent, int indent) {
					String[] values = new String[] { «typeRef('org.eclipse.xtext.validation.SeverityConverter')».SEVERITY_ERROR, «typeRef('org.eclipse.xtext.validation.SeverityConverter')».SEVERITY_WARNING,
							«typeRef('org.eclipse.xtext.validation.SeverityConverter')».SEVERITY_INFO, «typeRef('org.eclipse.xtext.validation.SeverityConverter')».SEVERITY_IGNORE };
					String[] valueLabels = new String[] { "Error", "Warning", "Info", "Ignore" };
					«typeRef('org.eclipse.swt.widgets.Combo')» comboBox = addComboBox(parent, label, prefKey, indent, values, valueLabels);
					return comboBox;
				}
			
				@Override
				public void dispose() {
					storeSectionExpansionStates(getDialogSettings());
					super.dispose();
				}
			
				@Override
				protected «typeRef('org.eclipse.jface.dialogs.IDialogSettings')» getDialogSettings() {
					«typeRef('org.eclipse.jface.dialogs.IDialogSettings')» dialogSettings = super.getDialogSettings();
					«typeRef('org.eclipse.jface.dialogs.IDialogSettings')» section = dialogSettings.getSection("«grammar.simpleName»");
					if (section == null) {
						return dialogSettings.addNewSection("«grammar.simpleName»");
					}
					return section;
				}
			}
		'''
		javaFile
	}

	protected def StringConcatenationClient generateValidationToDeprecateRules() '''
		«IF generateDeprecationValidation»
			«FOR deprecatedRule : deprecatedRulesFromGrammar»
				«val elementType = new TypeReference(deprecatedRule.type.classifier as EClass, grammar.eResource.resourceSet)»
				
				@«Check»
				public void checkDeprecated«elementType.simpleName»(«elementType» element) {
					addIssue("This part of the language is marked as deprecated and might get removed in the future!", element, «configurableIssueCodesProviderClass».DEPRECATED_MODEL_PART);
				}
			«ENDFOR»
		«ENDIF»
	'''

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
			<extension point="org.eclipse.ui.preferencePages">
				<page
					category="«grammar.name»"
					class="«grammar.eclipsePluginExecutableExtensionFactory»:org.eclipse.xtext.ui.validation.ValidatorPreferencePage"
					id="«grammar.name».validator.preferencePage"
					name="Errors/Warnings">
					<keywordReference id="«grammar.eclipsePluginBasePackage».keyword_«simpleName»"/>
				</page>
			</extension>
		'''
	}

	/**
	 * @since 2.14
	 */
	protected def getDeprecatedRulesFromGrammar() {
		val alreadyCollected = newHashSet
		grammar.rules.filter[isDeprecated && alreadyCollected.add(it.type.classifier)].toList
	}
	
	/**
	 * @since 2.14
	 */
	protected def boolean isDeprecated(AbstractRule rule) {
		return rule.getAnnotations().exists[AnnotationNames.DEPRECATED.equals(name)];
	}

}
