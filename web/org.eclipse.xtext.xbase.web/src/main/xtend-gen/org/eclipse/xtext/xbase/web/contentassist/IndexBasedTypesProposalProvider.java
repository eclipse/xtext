package org.eclipse.xtext.xbase.web.contentassist;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.web.contentassist.ITypeFilter;
import org.eclipse.xtext.xbase.web.contentassist.ITypesProposalProvider;

@SuppressWarnings("all")
public class IndexBasedTypesProposalProvider implements ITypesProposalProvider {
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  private WebContentProposalPriorities proposalPriorities;
  
  @Override
  public void createTypeProposals(final ContentAssistContext context, final EReference typeReference, final IValueConverter<String> valueConverter, final ITypeFilter filter, final IWebContentProposaAcceptor acceptor) {
    XtextResource _resource = context.getResource();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(_resource);
    Iterable<IResourceDescription> _allResourceDescriptions = resourceDescriptions.getAllResourceDescriptions();
    for (final IResourceDescription resourceDesc : _allResourceDescriptions) {
      Iterable<IEObjectDescription> _exportedObjectsByType = resourceDesc.getExportedObjectsByType(TypesPackage.Literals.JVM_TYPE);
      for (final IEObjectDescription typeDesc : _exportedObjectsByType) {
        {
          final ContentAssistResult.Entry entry = this.createProposal(typeDesc, typeReference, context);
          int _crossRefPriority = this.proposalPriorities.getCrossRefPriority(typeDesc, entry);
          acceptor.accept(entry, _crossRefPriority);
        }
      }
    }
  }
  
  protected ContentAssistResult.Entry createProposal(final IEObjectDescription typeDesc, final EReference typeReference, final ContentAssistContext context) {
    String _prefix = context.getPrefix();
    ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
    final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        QualifiedName _name = typeDesc.getName();
        String _lastSegment = _name.getLastSegment();
        it.setProposal(_lastSegment);
        QualifiedName _qualifiedName = typeDesc.getQualifiedName();
        String _string = IndexBasedTypesProposalProvider.this.qualifiedNameConverter.toString(_qualifiedName);
        it.setDescription(_string);
      }
    };
    return ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
  }
}
