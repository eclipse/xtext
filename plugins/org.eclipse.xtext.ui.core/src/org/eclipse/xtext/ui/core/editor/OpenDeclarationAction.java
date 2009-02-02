package org.eclipse.xtext.ui.core.editor;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelectionProvider;
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
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
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

	private LeafNode leafNode;

	public OpenDeclarationAction(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
	}

	public OpenDeclarationAction(LeafNode leafNode) {
		this.leafNode = leafNode;
		this.xtextEditor = (XtextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
	}

	@Override
	public void run() {
		LeafNode selectedNode = getSelectedNode();
		if (selectedNode != null) {
			List<EObject> linkedObjects = getLinkedObjects(selectedNode);
			if (!linkedObjects.isEmpty()) {
				EObject referenceEObject = linkedObjects.iterator().next();
				IFile targetFile = getContainingResourceSetFile(referenceEObject);
				openAndSelectDeclaration(referenceEObject, targetFile);
			}
		}
	}
	
	private LeafNode getSelectedNode() {
		LeafNode nodeToSelect = leafNode;
		if (leafNode == null) {
			nodeToSelect = getLeafNodeAtCaretOffset();
		} 
		return nodeToSelect;
	}
	
	private LeafNode getLeafNodeAtCaretOffset() {
		StyledText styledText = (StyledText) this.xtextEditor.getAdapter(Control.class);
		CompositeNode rootNode = getRootNode(this.xtextEditor.getDocument());
		AbstractNode currentOrFollowingNodeByOffset = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, styledText.getCaretOffset());
		return (LeafNode) (currentOrFollowingNodeByOffset instanceof LeafNode ? currentOrFollowingNodeByOffset :null);
	}
	
	private List<EObject> getLinkedObjects(LeafNode leafNode) {
		List<EObject> linkedObjects = Collections.emptyList();
		if (leafNode.getGrammarElement() instanceof CrossReference) {
			ILinkingService linkingService = ServiceRegistry.getInjector(this.xtextEditor.getScope()).getInstance(
					ILinkingService.class);
			EObject semanticModel = NodeUtil.getNearestSemanticObject(leafNode);
			EReference eReference = GrammarUtil.getReference((CrossReference) leafNode.getGrammarElement(),
					semanticModel.eClass());	
			linkedObjects = linkingService.getLinkedObjects(semanticModel, eReference, leafNode);
		}
		return linkedObjects;
	}
	
	private IFile getContainingResourceSetFile(EObject referenceEObject) {
		XtextResourceSet resourceSet = (XtextResourceSet) referenceEObject.eResource().getResourceSet();
		URI uri = referenceEObject.eResource().getURI();
		if (ClasspathUriUtil.isClasspathUri(uri)) {
			uri = resourceSet.getClasspathUriResolver().resolve(resourceSet.getClasspathURIContext(), uri);
		}
		IFile targetFile = uri.isPlatformResource() ? 
				ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(uri.toPlatformString(true)))
				: ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
						new Path(uri.toFileString()));
		return targetFile;
	}
	
	private void openAndSelectDeclaration(EObject referenceEObject, IFile targetFile) {
		if (targetFile != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				IEditorPart openEditor = IDE.openEditor(page, targetFile);
				if (openEditor instanceof ITextEditor) {

					NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(referenceEObject);
					((ITextEditor) openEditor).selectAndReveal(nodeAdapter.getParserNode().getOffset(),
							nodeAdapter.getParserNode().getLength());
				} else if (openEditor instanceof ISelectionProvider) {
					//TODO: use ISelectionProvider instead of ITextEditor
				}
			}
			catch (PartInitException partInitException) {
				logger.error("Error while opening editor part from workbench with file '" + targetFile + "'",
						partInitException);
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
