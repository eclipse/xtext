package org.eclipse.xtext.psi;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.linking.lazy.CrossReferenceDescription;
import org.eclipse.xtext.linking.lazy.ICrossReferenceDescription;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.XtextPsiElement;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XtextPsiReference /* implements PsiReferenceBase<XtextPsiElement>, PsiReference  */{
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  @Extension
  private IPsiModelAssociations psiModelAssociations;
  
  @Inject
  private CrossReferenceDescription.CrossReferenceDescriptionProvider crossReferenceDescriptionProvider;
  
  public XtextPsiReference(final XtextPsiElement element) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type XtextPsiReference"
      + "\nThe method language is undefined for the type XtextPsiReference"
      + "\ninjectMembers cannot be resolved");
  }
  
  protected Object getReferenceNode() {
    throw new Error("Unresolved compilation problems:"
      + "\nCompositeElement cannot be resolved to a type."
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nnode cannot be resolved"
      + "\nlastChildNode cannot be resolved");
  }
  
  protected Object calculateDefaultRangeInElement() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nTextRange cannot be resolved."
      + "\nnode cannot be resolved"
      + "\nstartOffset cannot be resolved"
      + "\n- cannot be resolved"
      + "\nstartOffset cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ntextLength cannot be resolved");
  }
  
  public /* PsiElement */Object handleElementRename(final String newElementName)/*  throws IncorrectOperationException */ {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nThe method or field ASTFactory is undefined for the type XtextPsiReference"
      + "\nThe method or field nodeGenerated is undefined for the type XtextPsiReference"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nnode cannot be resolved"
      + "\nleaf cannot be resolved"
      + "\nelementType cannot be resolved"
      + "\n=> cannot be resolved"
      + "\ntreeParent cannot be resolved"
      + "\nreplaceChild cannot be resolved"
      + "\n== cannot be resolved"
      + "\npsi cannot be resolved");
  }
  
  protected ICrossReferenceDescription getCrossReferenceDescription() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nThe method or field value is undefined for the type XtextPsiReference"
      + "\nThe method or field value is undefined for the type XtextPsiReference"
      + "\nnode cannot be resolved"
      + "\nelementType cannot be resolved"
      + "\ncontainingFile cannot be resolved"
      + "\ngetINode cannot be resolved"
      + "\nnode cannot be resolved"
      + "\nfindActualSemanticObjectFor cannot be resolved"
      + "\nfindNodesForFeature cannot be resolved"
      + "\nindexed cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\ntotalOffset cannot be resolved"
      + "\n<= cannot be resolved"
      + "\ntotalOffset cannot be resolved"
      + "\n&& cannot be resolved"
      + "\ntotalEndOffset cannot be resolved"
      + "\n>= cannot be resolved"
      + "\ntotalEndOffset cannot be resolved"
      + "\nkey cannot be resolved");
  }
  
  public List<Object> getVariants() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type XtextPsiReference"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type XtextPsiReference"
      + "\nThe method getPsiElement is undefined for the type XtextPsiReference"
      + "\nThe method or field myElement is undefined for the type XtextPsiReference"
      + "\nThe method or field LookupElementBuilder is undefined for the type XtextPsiReference"
      + "\ncheckCanceled cannot be resolved"
      + "\ncheckCanceled cannot be resolved"
      + "\ncontainingFile cannot be resolved"
      + "\nresource cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ncreate cannot be resolved"
      + "\nwithTypeText cannot be resolved"
      + "\nnavigationElement cannot be resolved"
      + "\ncontainingFile cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public Object resolve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type XtextPsiReference"
      + "\nThe method or field ProgressIndicatorProvider is undefined for the type XtextPsiReference"
      + "\nThe method psiElement is undefined for the type XtextPsiReference"
      + "\ncheckCanceled cannot be resolved"
      + "\ncheckCanceled cannot be resolved");
  }
}
