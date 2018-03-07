/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.codemining

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

/**
 * This fragment activates code mining functionalities and generates the appropriate stubs.
 * @Beta
 * @since 2.14
 * @author René Purrio - Initial contribution and API
 */
class CodeMiningFragment extends AbstractStubGeneratingFragment {
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	@Inject extension IQualifiedNameConverter
	
	override generate() {
		if (projectConfig.eclipsePlugin.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui.codemining"
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.ui.workbench.texteditor"
			projectConfig.eclipsePlugin.manifest.importedPackages += "org.eclipse.xtext.ui.codemining"
		}
		if (projectConfig.genericIde.manifest !== null) {
			projectConfig.genericIde.manifest.exportedPackages += codeMiningStrategyClass.skipLast(1).toString
			projectConfig.genericIde.manifest.requiredBundles += "org.eclipse.jface.text"
			projectConfig.genericIde.manifest.requiredBundles += "org.eclipse.xtext.ui.codemining"
			projectConfig.genericIde.manifest.requiredBundles += "org.eclipse.core.runtime"
			projectConfig.genericIde.manifest.requiredBundles += "org.eclipse.swt"
			projectConfig.genericIde.manifest.requiredBundles += "org.eclipse.xtext.ui"
			projectConfig.genericIde.manifest.importedPackages += "org.eclipse.xtext.ui.codemining"
		}
		new GuiceModuleAccess.BindingFactory => [
			addTypeToType("org.eclipse.jface.text.codemining.ICodeMiningProvider".typeRef, codeMiningStrategyClass.toString.typeRef)
			addTypeToType("org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy".typeRef, "org.eclipse.xtext.ui.codemining.XtextCodeMiningReconcileStrategy".typeRef)
			contributeTo(language.eclipsePluginGenModule)
		]

		if (generateXtendStub) {
			generateXtendCodeMiningStrategy
		} else {
			generateJavaCodeMiningStrategy
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
	
	def protected QualifiedName getCodeMiningStrategyClass () {
		(grammar.genericIdeBasePackage+".codemining."+grammar.simpleName+"CodeMiningStrategy").toQualifiedName
	}
	
	def protected generateXtendCodeMiningStrategy() {
		fileAccessFactory.createXtendFile(codeMiningStrategyClass.toString.typeRef, '''
			import org.eclipse.jface.text.BadLocationException
			import org.eclipse.jface.text.IDocument
			import org.eclipse.jface.text.codemining.ICodeMining
			import org.eclipse.xtext.resource.XtextResource
			import org.eclipse.xtext.ui.codemining.XtextCodeMiningProvider
			import org.eclipse.xtext.util.CancelIndicator
			import org.eclipse.xtext.util.IAcceptor
			
			public class «codeMiningStrategyClass.lastSegment» extends XtextCodeMiningProvider {
				def override protected void createLineHeaderCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor) throws BadLocationException{
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list
					//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)
					
					//example:
					//acceptor.accept(createNewLineHeaderCodeMining(1, document, "Header annotation"))
					//if (indicator.isCanceled()) {
					//	return
					//}
				}
				
				def override protected void createLineContentCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor)  throws BadLocationException {
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineContentCodeMining(...)) to add a new code mining to the final list
					//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)
					
					//example:
					//acceptor.accept(createNewLineContentCodeMining(5, " Inline annotation "))
					//if (indicator.isCanceled()) {
					//	return
					//}
				}
			}
		''').writeTo(projectConfig.genericIde.src)
	}
	
	def protected generateJavaCodeMiningStrategy() {
		fileAccessFactory.createJavaFile(codeMiningStrategyClass.toString.typeRef, '''
			import org.eclipse.jface.text.BadLocationException;
			import org.eclipse.jface.text.IDocument;
			import org.eclipse.jface.text.codemining.ICodeMining;
			import org.eclipse.xtext.resource.XtextResource;
			import org.eclipse.xtext.ui.codemining.XtextCodeMiningProvider;
			import org.eclipse.xtext.util.CancelIndicator;
			import org.eclipse.xtext.util.IAcceptor;
			
			@SuppressWarnings("restriction")
			public class «codeMiningStrategyClass.lastSegment» extends XtextCodeMiningProvider {
				@Override
				protected void createLineHeaderCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor) throws BadLocationException{
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineHeaderCodeMining(...)) to add a new code mining to the final list
					//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)
					
					//example:
					//acceptor.accept(createNewLineHeaderCodeMining(1, document, "Header annotation"));
					//if (indicator.isCanceled()) {
					//	return;
					//}
				}
				
				@Override
				protected void createLineContentCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator, IAcceptor<ICodeMining> acceptor)  throws BadLocationException {
					
					//TODO: implement me
					//use acceptor.accept(super.createNewLineContentCodeMining(...)) to add a new code mining to the final list
					//use indicator.isCanceled() to check, if a new code mining was started (and then to cancel this code mining with return)
					
					//example:
					//acceptor.accept(createNewLineContentCodeMining(5, " Inline annotation "));
					//if (indicator.isCanceled()) {
					//	return;
					//}
				}
			}
		''').writeTo(projectConfig.genericIde.src)
	}
}