package org.eclipse.xtext.ui.core.editor;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * This action opens a <code>XtextEditor</code> on a selected <code>CrossReference</code> element.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see org.eclipse.jface.action.Action
 */
public class OpenDeclarationAction extends Action {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	private XtextEditor xtextEditor;

	private LeafNode currentNode;

	public OpenDeclarationAction(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
	}

	public OpenDeclarationAction(LeafNode currentNode) {
		this.currentNode = currentNode;
		this.xtextEditor = (XtextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
	}

	@Override
	public void run() {

		if (currentNode == null) {

			StyledText styledText = (StyledText) this.xtextEditor.getAdapter(Control.class);

			int caretOffset = styledText.getCaretOffset();

			IXtextDocument document = this.xtextEditor.getDocument();

			CompositeNode rootNode = getRootNode(document);

			this.currentNode = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, caretOffset);
		}

		if (currentNode != null && currentNode.getGrammarElement() instanceof CrossReference) {

			ILinkingService linkingService = ServiceRegistry.getService(this.xtextEditor.getScope(),
					ILinkingService.class);

			EObject semanticModel = NodeUtil.getNearestSemanticObject(currentNode);

			EReference eReference = GrammarUtil.getReference((CrossReference) currentNode.getGrammarElement(),
					semanticModel.eClass());

			List<EObject> linkedObjects = linkingService.getLinkedObjects(semanticModel, eReference, currentNode);

			if (!linkedObjects.isEmpty()) {

				EObject referenceEObject = linkedObjects.iterator().next();

				IFile targetFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(referenceEObject.eResource().getURI().toPlatformString(true)));

				if (targetFile != null) {

					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

					try {
						IEditorPart openEditor = IDE.openEditor(page, targetFile);

						if (openEditor instanceof ITextEditor) {

							NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(referenceEObject);
							((ITextEditor) openEditor).selectAndReveal(nodeAdapter.getParserNode().getOffset(),
									nodeAdapter.getParserNode().getLength());
						}
					}
					catch (PartInitException partInitException) {
						logger.error("Error while opening editor part from workbench with file '" + targetFile + "'",
								partInitException);
					}
				}
			}

		}

	}

	private CompositeNode getRootNode(IDocument document) {

		CompositeNode rootNode = ((IXtextDocument) document).readOnly(new UnitOfWork<CompositeNode>() {
			public CompositeNode exec(XtextResource resource) throws Exception {
				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				return parseResult.getRootNode();
			}
		});

		return rootNode;
	}
}
