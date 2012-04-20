package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator
import org.eclipse.xtext.xtext.ui.wizard.project.DefaultProjectFactoryContributor
import org.eclipse.xtext.xtext.ui.wizard.project.DslProjectContributor

class Ecore2XtextDslProjectContributor extends DefaultProjectFactoryContributor {
	
	Ecore2XtextProjectInfo projectInfo
	
	new(Ecore2XtextProjectInfo projectInfo) {
		this.projectInfo = projectInfo
	}

	override contributeFiles(IProject project, IFileCreator creator) {
		creator.writeToFile(workflow, projectInfo.basePackagePath+"/Generate"+projectInfo.languageNameAbbreviation+".mwe2")
		creator.writeToFile(grammar, DslProjectContributor::grammarFilePath(projectInfo))
	}
	
	def private workflow() {
		'''
		module «(projectInfo.basePackagePath+"/"+projectInfo.languageNameAbbreviation).replaceAll("/", ".")»
		
		import org.eclipse.emf.mwe.utils.*
		import org.eclipse.xtext.generator.*
		import org.eclipse.xtext.ui.generator.*
		
		var grammarURI = "classpath:/«projectInfo.basePackagePath»/«projectInfo.languageNameAbbreviation».xtext"
		var file.extensions = "«projectInfo.firstFileExtension»"
		var projectName = "«projectInfo.projectName»"
		var runtimeProject = "../${projectName}"
		
		Workflow {
			bean = StandaloneSetup {
				scanClassPath  = true
				platformUri = "${runtimeProject}/.."
			«FOR ePackageInfo : projectInfo.EPackageInfos»
				«IF ePackageInfo.EPackageJavaFQN!=null»
				registerGeneratedEPackage = "«ePackageInfo.EPackageJavaFQN»"
			«ENDIF»«ENDFOR»
			«FOR genmodelURI : projectInfo.EPackageInfos.map(e|e.genmodelURI).toSet»
				// registerGenModelFile = "«genmodelURI»"
			«ENDFOR»
			
			}
		
			component = DirectoryCleaner {
				directory = "${runtimeProject}/src-gen"
			}
		
			component = DirectoryCleaner {
				directory = "${runtimeProject}.ui/src-gen"
			}
		
			component = Generator {
				pathRtProject = runtimeProject
				pathUiProject = "${runtimeProject}.ui"
				projectNameRt = projectName
				projectNameUi = "${projectName}.ui"
				language = {
					uri = grammarURI
					fileExtensions = file.extensions
		
					// Java API to access grammar elements (required by several other fragments)
					fragment = grammarAccess.GrammarAccessFragment {}
		
					// generates Java API for the generated EPackages
					// fragment = ecore.EcoreGeneratorFragment {}
		
					// the serialization component
					fragment = parseTreeConstructor.ParseTreeConstructorFragment {}
		
					// a custom ResourceFactory for use with EMF 
					fragment = resourceFactory.ResourceFactoryFragment {
						fileExtensions = file.extensions
					}
		
					// the Antlr parser
					fragment = parser.antlr.XtextAntlrGeneratorFragment {
						options = {
							classSplitting = true
						}
					}
		
					// the Ecore2Xtext specific terminal converter
					fragment = ecore2xtext.Ecore2XtextValueConverterServiceFragment {}
		
					// java-based API for validation 
					fragment = validation.JavaValidatorFragment {
					// composedCheck = "org.eclipse.xtext.validation.ImportUriValidator"
					// composedCheck = "org.eclipse.xtext.validation.NamesAreUniqueValidator"
					}
		
					// scoping and exporting API
					fragment = scoping.ImportURIScopingFragment {}
					fragment = exporting.SimpleNamesFragment {}
		
					// scoping and exporting API 
		
					// fragment = scoping.ImportNamespacesScopingFragment {}
					// fragment = exporting.QualifiedNamesFragment {}
		
		
					// formatter API 
					fragment = ecore2xtext.FormatterFragment {}
		
					// labeling API 
					fragment = labeling.LabelProviderFragment {}
		
					// outline API 
		            fragment = outline.OutlineTreeProviderFragment {}
		            fragment = outline.QuickOutlineFragment {}
		
					// java-based API for content assistance 
					fragment = contentAssist.JavaBasedContentAssistFragment {}
		
					// antlr parser generator tailored for content assist 
					fragment = parser.antlr.XtextAntlrUiGeneratorFragment {
						options = {
							classSplitting = true
						}
					}
		
					// provides a compare view
		            fragment = compare.CompareFragment {
		                fileExtensions = file.extensions
		            }
		
					fragment = builder.BuilderIntegrationFragment {}
		
					// project wizard (optional) 
		
					// fragment = projectWizard.SimpleProjectWizardFragment {
					//		generatorProjectName = "${projectName}.generator" 
					//		modelFileExtension = file.extensions
					// }
		
					// quickfix API 
					fragment = quickfix.QuickfixProviderFragment {}
				}
			}
		}
		'''
	}
	
	def private grammar() {
		''''''
/*TODO		«resetUniqueNames(defaultEPackageInfo)-»
«FILE basePackagePath+"/"+languageNameAbbreviation+".xtext" -»
«EXPAND grammarDeclaration-»
«EXPAND metamodelImport FOREACH allReferencedEPackages()-»
«EXPAND rules FOR rootElementClass-»
«EXPAND subClassDispatcherRule FOREACH allDispatcherRuleClasses().remove(rootElementClass)-»
«EXPAND rule FOREACH allConcreteRuleClassifiers().remove(rootElementClass)-»
«ENDFILE»*/
	}
	
}