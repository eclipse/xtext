package org.eclipse.xtext.idea.lang;

import static org.eclipse.xtext.psi.PsiEObject.XTEXT_EREFERENCE_KEY;
import static org.eclipse.xtext.psi.PsiEObject.XTEXT_NODE_KEY;
import static org.eclipse.xtext.psi.PsiReferenceEObject.XTEXT_ECONTEXT_KEY;
import static org.eclipse.xtext.psi.PsiReferenceEObject.XTEXT_INDEX_KEY;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.idea.lang.CreateElementType.CreateCallback;
import org.eclipse.xtext.idea.resource.ResourceDescriptionAdapter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.psi.impl.source.resolve.FileContextUtil;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.tree.IElementType;

public class BaseXtextPsiParser implements PsiParser {
	
	@Inject
	private CompilerPhases compilerPhases;
	
	@Inject
	private IElementTypeProvider elementTypeProvider;
	
	protected static class CreateWithNodeAndReferenceCallback implements CreateCallback {

		private final INode node;
		private final EReference reference;
		
		private final Integer index;
		private final EObject context;
		
		private final EObject semanticElement;
		
		public CreateWithNodeAndReferenceCallback(INode node) {
			this(node, null, null, null, null);
		}
		
		public CreateWithNodeAndReferenceCallback(INode node, EReference reference, EObject semanticElement) {
			this(node, reference, null, null, semanticElement);
		}

		public CreateWithNodeAndReferenceCallback(INode node, EReference reference, Integer index, EObject context, EObject semanticElement) {
			this.node = node;
			this.reference = reference;
			
			this.index = index;
			this.context = context;
			
			this.semanticElement = semanticElement;
		}

		public void onCreate(CompositeElement composite) {
			composite.putUserData(XTEXT_NODE_KEY, node);
			composite.putUserData(XTEXT_EREFERENCE_KEY, reference);
			
			composite.putUserData(XTEXT_INDEX_KEY, index);
			composite.putUserData(XTEXT_ECONTEXT_KEY, context);
			
			if (semanticElement != null) {
				semanticElement.eAdapters().add(new PsiModelAssociations.PsiAdapter(composite));
			}
		}
		
	}
	
	public ASTNode parse(IElementType rootType, PsiBuilder psiBuilder) {
		PsiBuilder.Marker rootMarker = psiBuilder.mark();
		checkCanceled();
		BaseXtextFile containingFile = getContainingFile(psiBuilder);
		Resource resource = containingFile.createResource();
		checkCanceled();
		ICompositeNode rootNode = getRootNode(resource);
		if (rootNode != null) {
			parse(rootNode, new ParsingContext(psiBuilder, containingFile));
		}
		checkCanceled();
		while(!psiBuilder.eof()) {
			psiBuilder.advanceLexer();
		}
		
		rootMarker.done(rootType);
		
		try {
			return psiBuilder.getTreeBuilt();
		} finally {
			checkCanceled();
			installResourceDescription(resource);
		}
	}
	
	private void checkCanceled() {
		ProgressIndicatorProvider.checkCanceled();
	}

	protected void installResourceDescription(Resource resource) {
		try {
			compilerPhases.setIndexing(resource, true);
			ResourceDescriptionAdapter.install(resource);
		} finally {
			compilerPhases.setIndexing(resource, false);
		}
	}

	protected ICompositeNode getRootNode(Resource resource) {
		if (resource == null) {
			return null;
		}
        IParseResult parseResult = ((XtextResource) resource).getParseResult();
        if (parseResult == null) {
        	return null;
        }
        return parseResult.getRootNode();
	}
	
	protected void parse(INode node, ParsingContext context) {
		if (node instanceof ILeafNode) {
			parse((ILeafNode) node, context);
		} else if (node instanceof ICompositeNode) {
			parse((ICompositeNode) node, context);
		} else {
			throw new IllegalStateException("Unknown node: " + node);
		}
	}
	
	protected void parse(ILeafNode node, ParsingContext context) {
        if (node.isHidden()) {
        	return;
        }
        NodeMarker nodeMarker = mark(node, context);
        Marker errorMarker = null;
        SyntaxErrorMessage syntaxErrorMessage = node.getSyntaxErrorMessage();
        if (syntaxErrorMessage != null) {
        	errorMarker = context.builder.mark();
        }
        context.builder.advanceLexer();
        if (errorMarker != null) {
        	errorMarker.error(syntaxErrorMessage.getMessage());
        }
		if (nodeMarker != null) {
			nodeMarker.done();
		}
	}

	protected void parse(ICompositeNode node, ParsingContext context) {
		Marker errorMarker = null;
        SyntaxErrorMessage syntaxErrorMessage = node.getSyntaxErrorMessage();
        if (syntaxErrorMessage != null) {
        	errorMarker = context.builder.mark();
        }
        Marker elementMarker = null;
		if (node.hasDirectSemanticElement()) {
			elementMarker = context.builder.mark();
			context = context.newContext(node.getSemanticElement());
		}
		NodeMarker nodeMarker = null;
		if (elementMarker == null) {
			nodeMarker = mark(node, context);
		}
		for (INode child : node.getChildren()) {
			parse(child, context);
		}
		if (elementMarker != null) {
			EObject semanticElement = node.getSemanticElement();
			final EReference reference = semanticElement.eContainmentFeature();
			
			CreateWithNodeAndReferenceCallback createCallback = new CreateWithNodeAndReferenceCallback(node, reference, null, null, context.semanticElement);
			if (context.namedElement) {
				elementMarker.done(new CreateElementType(elementTypeProvider.getNamedObjectType(), createCallback));
			} else {
				elementMarker.done(new CreateElementType(elementTypeProvider.getObjectType(), createCallback));
			}
		}
		if (errorMarker != null) {
        	errorMarker.error(syntaxErrorMessage.getMessage());
		}
		if (nodeMarker != null) {
			nodeMarker.done();
		}
	}

	protected NodeMarker mark(INode node, ParsingContext context) {
		NodeMarker nodeMarker = markCrossReference(node, context);
        if (nodeMarker == null) {
        	nodeMarker = markName(node, context);
        }
		return nodeMarker;
	}

	protected NodeMarker markName(INode node, ParsingContext context) {
        EObject grammarElement = node.getGrammarElement();
        if (!(grammarElement instanceof AbstractElement)) {
        	return null;
        }
        Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
		if (assignment == null) {
			return null;
		}
        if (context.semanticElement == null) {
        	return null;
        }
    	EAttribute attribute = SimpleAttributeResolver.NAME_RESOLVER.getAttribute(context.semanticElement);
		if (attribute == null) {
			return null;
		}
		EClass referenceOwner = context.semanticElement.eClass();
		String feature = assignment.getFeature();
		EStructuralFeature structuralFeature = ((EClass) referenceOwner).getEStructuralFeature(feature);
        if (attribute != structuralFeature) {
        	return null;
        }
        context.namedElement = true;
    	return context.mark(elementTypeProvider.getNameType(), new CreateWithNodeAndReferenceCallback(node));
	}
	
	protected NodeMarker markCrossReference(INode node, ParsingContext context) {
		EObject grammarElement = node.getGrammarElement();
		if (!(grammarElement instanceof CrossReference)) {
			return null;
		}
	    EReference reference = GrammarUtil.getReference((CrossReference) grammarElement);
		IElementType elementType = elementTypeProvider.getCrossReferenceType();
		Integer index = null;
		if (reference.isMany()) {
			index = context.getIndex(reference);
		}
		return context.mark(elementType, new CreateWithNodeAndReferenceCallback(node, reference, index, context.semanticElement, null));
	}

	protected BaseXtextFile getContainingFile(PsiBuilder builder) {
		return (BaseXtextFile) builder.getUserDataUnprotected(FileContextUtil.CONTAINING_FILE_KEY);
	}
	
	protected static class ParsingContext {
		
		public boolean namedElement = false;
		public EObject semanticElement;
		public Map<EReference, Integer> referenceToIndex;

		public final PsiBuilder builder;
		public final BaseXtextFile file;

		public ParsingContext(PsiBuilder builder, BaseXtextFile file) {
			this.file = file;
			this.builder = builder;
		}

		public NodeMarker mark(IElementType elementType, CreateCallback createCallback) {
			return new NodeMarker(builder.mark(), elementType, createCallback);
		}

		public Integer getIndex(EReference reference) {
			Integer index = referenceToIndex.get(reference);
            if (index == null) {
                index = 0;
            }
            referenceToIndex.put(reference, index + 1);
            return index;
		}

		public ParsingContext newContext(EObject semanticElement) {
			ParsingContext context = new ParsingContext(builder, file);
			context.semanticElement = semanticElement;
			context.referenceToIndex = Maps.newHashMap();
			return context;
		}
		
	}
	
	protected static class NodeMarker {

		private final Marker marker;
		private final IElementType elementType;
		private final CreateCallback createCallback;

		public NodeMarker(Marker marker, IElementType elementType, CreateCallback createCallback) {
			this.marker = marker;
			this.elementType = elementType;
			this.createCallback = createCallback;
		}

		public void done() {
        	marker.done(new CreateElementType(elementType, createCallback));
		}
		
	}

}

