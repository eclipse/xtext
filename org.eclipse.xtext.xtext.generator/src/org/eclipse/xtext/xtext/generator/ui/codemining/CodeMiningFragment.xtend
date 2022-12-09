/*******************************************************************************
 * Copyright (c) 2018, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.codemining

import com.google.common.annotations.Beta
import com.google.inject.Inject
import com.google.inject.name.Names
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

/**
 * This fragment activates code mining functionalities and generates the appropriate stubs.
 * 
 * @author René Purrio - Initial contribution and API
 * @author Karsten Thoms - Review and improvements on initial implementation
 * @since 2.14
 */
@Beta
class CodeMiningFragment extends AbstractStubGeneratingFragment {
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	@Inject extension IQualifiedNameConverter
	
	override generate() {
		if (projectConfig.eclipsePlugin.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.importedPackages += "org.eclipse.xtext.ui.codemining;resolution:=optional"
		}
		new GuiceModuleAccess.BindingFactory => [
			addConfiguredBinding("CodeMinding", '''
				binder.bind(«'org.eclipse.jface.text.codemining.ICodeMiningProvider'.typeRef».class)
					.to(«codeMiningProviderClass».class);
				binder.bind(«'org.eclipse.xtext.ui.editor.reconciler.IReconcileStrategyFactory'.typeRef».class).annotatedWith(«Names.typeRef».named("codeMinding"))
					.to(«"org.eclipse.xtext.ui.codemining.XtextCodeMiningReconcileStrategy".typeRef».Factory.class);
			''')
			contributeTo(language.eclipsePluginGenModule)
		]

		if (generateXtendStub) {
			generateXtendCodeMiningProvider
		} else {
			generateJavaCodeMiningProvider
		}
			
		if (projectConfig.eclipsePlugin.pluginXml !== null) {
			projectConfig.eclipsePlugin.pluginXml.entries += '''
				<!-- code mining -->
				<extension point="org.eclipse.ui.workbench.texteditor.codeMiningProviders">
					<codeMiningProvider
						class="«grammar.getEclipsePluginExecutableExtensionFactory»:org.eclipse.jface.text.codemining.ICodeMiningProvider"
						id="«grammar.name».CodeMiningProvider"
						label="«grammar.simpleName» Codemining">
						<enabledWhen>
							<with variable="editorInput">
								<adapt type="org.eclipse.core.resources.IFile">
									<test
										property="org.eclipse.core.resources.contentTypeId"
										value="«grammar.name».contenttype">
									</test>
								</adapt>
							</with>
						</enabledWhen>
					</codeMiningProvider>
				</extension>
			'''
		}
	}
	
	def protected TypeReference getCodeMiningProviderClass () {
		(grammar.eclipsePluginBasePackage+".codemining."+grammar.simpleName+"CodeMiningProvider").toQualifiedName.toString.typeRef
	}
	
	def protected TypeReference getCodeMiningProviderSuperClass() {
		"org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider".typeRef
	}
	
	def protected TypeReference getBadLocationException () {
		"org.eclipse.jface.text.BadLocationException".typeRef
	}
	
	def protected TypeReference getCancelIndicator () {
		"org.eclipse.xtext.util.CancelIndicator".typeRef
	}
	
	def protected TypeReference getIAcceptor () {
		"org.eclipse.xtext.util.IAcceptor".typeRef
	}

	def protected TypeReference getICodeMining () {
		"org.eclipse.jface.text.codemining.ICodeMining".typeRef
	}

	def protected TypeReference getIDocument () {
		"org.eclipse.jface.text.IDocument".typeRef
	}

	def protected TypeReference getXtextResource () {
		"org.eclipse.xtext.resource.XtextResource".typeRef
	}

	def protected generateXtendCodeMiningProvider() {
		fileAccessFactory.createXtendFile(codeMiningProviderClass.toString.typeRef, '''
			class «codeMiningProviderClass.simpleName» extends «codeMiningProviderSuperClass» {
				override void createCodeMinings(«getIDocument» document, «getXtextResource» resource, «getCancelIndicator» indicator,
					«getIAcceptor»<? super «getICodeMining»> acceptor) throws «getBadLocationException» {
					
					// TODO: implement me
					// use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list
					
					// example:
					// acceptor.accept(createNewLineHeaderCodeMining(1, document, "Header annotation"))
				}
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
	
	def protected generateJavaCodeMiningProvider() {
		fileAccessFactory.createJavaFile(codeMiningProviderClass.toString.typeRef, '''
			@SuppressWarnings("restriction")
			public class «codeMiningProviderClass.simpleName» extends «codeMiningProviderSuperClass» {
				@Override
				protected void createCodeMinings(«getIDocument» document, «getXtextResource» resource, «getCancelIndicator» indicator,
					«getIAcceptor»<? super «getICodeMining»> acceptor) throws «getBadLocationException» {
					
					// TODO: implement me
					// use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list
					
					// example:
					// acceptor.accept(createNewLineHeaderCodeMining(1, document, "Header annotation"));
				}
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
}