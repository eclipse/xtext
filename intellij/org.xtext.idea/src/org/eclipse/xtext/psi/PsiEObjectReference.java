package org.eclipse.xtext.psi;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.linking.lazy.ICrossReferenceDescription;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.inject.Inject;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.util.IncorrectOperationException;

public class PsiEObjectReference extends PsiReferenceBase<PsiReferenceEObject> implements PsiReference {

    @Inject
    private IPsiModelAssociations psiModelAssociations;
    
    @Inject
    private IQualifiedNameConverter qualifiedNameConverter;

	public PsiEObjectReference(PsiReferenceEObject element, TextRange range) {
		super(element, range);
		Language language = element.getLanguage();
		if (language instanceof IXtextLanguage) {
			((IXtextLanguage) language).injectMembers(this);
		}
	}

	public Object[] getVariants() {
		ProgressIndicatorProvider.checkCanceled();
        ICrossReferenceDescription crossReferenceDescription = myElement.getCrossReferenceDescription();
        if (crossReferenceDescription == null) {
            return new Object[0];
        }
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (IEObjectDescription objectDescription : crossReferenceDescription.getVariants()) {
        	String name = qualifiedNameConverter.toString(objectDescription.getName());
            PsiElement element = psiModelAssociations.getPsiElement(objectDescription, myElement.getEObject());
            if (element != null) {
            	variants.add(LookupElementBuilder.create(name).withTypeText(element.getNavigationElement().getContainingFile().getName()));
            }
        }
        return variants.toArray();
	}

	public PsiElement resolve() {
		ProgressIndicatorProvider.checkCanceled();
        ICrossReferenceDescription crossReferenceDescription = myElement.getCrossReferenceDescription();
        if (crossReferenceDescription == null) {
            return null;
        }
        EObject object = crossReferenceDescription.resolve();
        ProgressIndicatorProvider.checkCanceled();
        return psiModelAssociations.getPsiElement(object);
	}
	
	@Override
	public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
		PsiReferenceEObject element = getElement();
		ASTNode referenceNode = element.getNode();
		ASTNode oldNode = referenceNode.getLastChildNode();
		LeafElement newChild = ASTFactory.leaf(oldNode.getElementType(), newElementName);
		CodeEditUtil.setNodeGenerated(newChild, true);
		referenceNode.replaceChild(oldNode, newChild);
		return element;
	}

}