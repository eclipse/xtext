/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.codemining

import com.google.common.annotations.Beta
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import com.google.inject.name.Names

/**
 * This fragment activates code mining functionalities and generates the appropriate stubs.
 * @since 2.14
 * @author René Purrio - Initial contribution and API
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
				try {
					Class.forName("org.eclipse.jface.text.codemining.ICodeMiningProvider");
					binder.bind(«'org.eclipse.jface.text.codemining.ICodeMiningProvider'.typeRef».class)
						.to(«codeMiningProviderClass.toString.typeRef».class);
					binder.bind(«'org.eclipse.xtext.ui.editor.reconciler.IReconcileStrategyFactory'.typeRef».class).annotatedWith(«Names.typeRef».named("codeMinding"))
						.to(«"org.eclipse.xtext.ui.codemining.XtextCodeMiningReconcileStrategy".typeRef».Factory.class);
				} catch(«ClassNotFoundException.typeRef» ignore) {
					// no bindings if code mining is not available at runtime
				}
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
	
	def protected QualifiedName getCodeMiningProviderClass () {
		(grammar.eclipsePluginBasePackage+".codemining."+grammar.simpleName+"CodeMiningProvider").toQualifiedName
	}
	
	def protected generateXtendCodeMiningProvider() {
		fileAccessFactory.createXtendFile(codeMiningProviderClass.toString.typeRef, '''
			import org.eclipse.jface.text.BadLocationException
			import org.eclipse.jface.text.IDocument
			import org.eclipse.jface.text.codemining.ICodeMining
			import org.eclipse.xtext.resource.XtextResource
			import org.eclipse.xtext.ui.codemining.XtextCodeMiningProvider
			import org.eclipse.xtext.util.CancelIndicator
			import org.eclipse.xtext.util.IAcceptor
			
			class «codeMiningProviderClass.lastSegment» extends XtextCodeMiningProvider {
				override void createLineHeaderCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor) throws BadLocationException{
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list
					
					//example:
					//acceptor.accept(createNewLineHeaderCodeMining(1, document, "Header annotation"))
				}
				
				override void createLineContentCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor)  throws BadLocationException {
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineContentCodeMining(...)) to add a new code mining to the final list
					
					//example:
					//acceptor.accept(createNewLineContentCodeMining(5, " Inline annotation "))
				}
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
	
	def protected generateJavaCodeMiningProvider() {
		fileAccessFactory.createJavaFile(codeMiningProviderClass.toString.typeRef, '''
			import org.eclipse.jface.text.BadLocationException;
			import org.eclipse.jface.text.IDocument;
			import org.eclipse.jface.text.codemining.ICodeMining;
			import org.eclipse.xtext.resource.XtextResource;
			import org.eclipse.xtext.ui.codemining.XtextCodeMiningProvider;
			import org.eclipse.xtext.util.CancelIndicator;
			import org.eclipse.xtext.util.IAcceptor;
			
			@SuppressWarnings("restriction")
			public class «codeMiningProviderClass.lastSegment» extends XtextCodeMiningProvider {
				@Override
				protected void createLineHeaderCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor) throws BadLocationException{
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list
					
					//example:
					//acceptor.accept(createNewLineHeaderCodeMining(1, document, "Header annotation"));
				}
				
				@Override
				protected void createLineContentCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor)  throws BadLocationException {
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineContentCodeMining(...)) to add a new code mining to the final list
					
					//example:
					//acceptor.accept(createNewLineContentCodeMining(5, " Inline annotation "));
				}
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
}