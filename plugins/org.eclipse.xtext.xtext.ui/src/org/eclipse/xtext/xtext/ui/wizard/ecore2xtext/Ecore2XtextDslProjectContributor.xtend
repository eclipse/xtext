package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator
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
		var fileExtensions = "«projectInfo.firstFileExtension»"
		var projectName = "«projectInfo.projectName»"
		var runtimeProject = "../${projectName}"
		var generateXtendStub = true
		
		Workflow {
			bean = StandaloneSetup {
				scanClassPath  = true
				platformUri = "${runtimeProject}/.."
				«FOR ePackageInfo : projectInfo.EPackageInfos.map[EPackageJavaFQN].filterNull»
					registerGeneratedEPackage = "«ePackageInfo»"
				«ENDFOR»
				«FOR genmodelURI : projectInfo.EPackageInfos.map[genmodelURI.toString].toSet»
					registerGenModelFile = "«genmodelURI»"
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
				pathTestProject = "${runtimeProject}.tests"
				projectNameRt = projectName
				projectNameUi = "${projectName}.ui"
				language = auto-inject {
					uri = grammarURI
		
					// Java API to access grammar elements (required by several other fragments)
					fragment = grammarAccess.GrammarAccessFragment auto-inject {}
		
					// generates Java API for the generated EPackages
					// fragment = ecore.EcoreGeneratorFragment auto-inject {}
		
					// the Ecore2Xtext specific terminal converter
					fragment = ecore2xtext.Ecore2XtextValueConverterServiceFragment auto-inject {}
		
					// serializer 2.0
					fragment = serializer.SerializerFragment auto-inject {
						//generateStub = false
					}
		
					// the old serialization component
					// fragment = parseTreeConstructor.ParseTreeConstructorFragment auto-inject {}
		
					// a custom ResourceFactory for use with EMF 
					fragment = resourceFactory.ResourceFactoryFragment auto-inject {}
		
					// the Antlr parser
					fragment = parser.antlr.XtextAntlrGeneratorFragment auto-inject {
						options = {
							classSplitting = true
						}
					}
		
					// Xtend-based API for validation 
					fragment = validation.ValidatorFragment auto-inject {
					// composedCheck = "org.eclipse.xtext.validation.ImportUriValidator"
					// composedCheck = "org.eclipse.xtext.validation.NamesAreUniqueValidator"
					}
		
					// old scoping and exporting API 
					// fragment = scoping.ImportNamespacesScopingFragment auto-inject {}
					// fragment = exporting.QualifiedNamesFragment auto-inject {}

					// scoping and exporting API
					fragment = scoping.ImportURIScopingFragment auto-inject {}
					fragment = exporting.SimpleNamesFragment auto-inject {}
					fragment = builder.BuilderIntegrationFragment auto-inject {}		
		
					// generator API
					fragment = generator.GeneratorFragment auto-inject {}
		
					// formatter API 
					// fragment = formatting.FormatterFragment auto-inject {}
					fragment = ecore2xtext.FormatterFragment auto-inject {}
		
					// labeling API 
					fragment = labeling.LabelProviderFragment auto-inject {}
		
					// outline API 
		            fragment = outline.OutlineTreeProviderFragment auto-inject {}
		            fragment = outline.QuickOutlineFragment auto-inject {}

					// quickfix API
					fragment = quickfix.QuickfixProviderFragment auto-inject {}
		
					//content assist API 
					fragment = contentAssist.ContentAssistFragment auto-inject {}
		
					// antlr parser generator tailored for content assist 
					fragment = parser.antlr.XtextAntlrUiGeneratorFragment auto-inject {
						options = {
							classSplitting = true
						}
					}
					
					// generates junit test support classes into Generator#pathTestProject
					fragment = junit.Junit4Fragment auto-inject {}
		
					// project wizard (optional) 
					// fragment = projectWizard.SimpleProjectWizardFragment auto-inject {
					//		generatorProjectName = "${projectName}.generator" 
					// }
		
					// rename refactoring
					fragment = refactoring.RefactorElementNameFragment auto-inject {}

					// provides the necessary bindings for java types integration
					fragment = types.TypesGeneratorFragment auto-inject {}
					
					// generates the required bindings only if the grammar inherits from Xbase
					fragment = xbase.XbaseGeneratorFragment auto-inject {}
					
					// generates the required bindings only if the grammar inherits from Xtype
					fragment = xbase.XtypeGeneratorFragment auto-inject {}

					// provides a preference page for template proposals
					fragment = templates.CodetemplatesGeneratorFragment auto-inject {}

					// provides a compare view
		            fragment = compare.CompareFragment auto-inject {}
				}
			}
		}
		'''
	}
	
}