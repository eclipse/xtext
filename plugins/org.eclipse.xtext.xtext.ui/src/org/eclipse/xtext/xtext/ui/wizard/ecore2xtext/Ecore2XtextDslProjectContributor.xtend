package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator
import org.eclipse.xtext.xtext.ui.wizard.project.DefaultProjectFactoryContributor

/**
 * Contributes a workflow file and the grammar to the new Ecore2Xtext DSL project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class Ecore2XtextDslProjectContributor extends DefaultProjectFactoryContributor {
	
	Ecore2XtextProjectInfo projectInfo
	String modelFolder = ""
	
	new(Ecore2XtextProjectInfo projectInfo) {
		this.projectInfo = projectInfo
	}
	
	def void setModelFolder(String modelFolder) {
		this.modelFolder = modelFolder	
	}
	
	override contributeFiles(IProject project, IFileCreator creator) {
		createWorkflowFile(creator)
		createGrammarFile(creator)
	}
	
	def createWorkflowFile(IFileCreator creator) {
		creator.writeToFile(workflow, modelFolder+"/"+projectInfo.basePackagePath+"/Generate"+projectInfo.languageNameAbbreviation+".mwe2")
	}
	
	def createGrammarFile(IFileCreator creator) {
		creator.writeToFile(new Ecore2XtextGrammarCreator().grammar(projectInfo), modelFolder+"/"+ projectInfo.grammarFilePath)
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
	
}