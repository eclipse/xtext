package org.eclipse.xtext.xbase.web.contentassist

import com.google.inject.Inject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities

class IndexBasedTypesProposalProvider implements ITypesProposalProvider {
	
	@Inject ResourceDescriptionsProvider resourceDescriptionsProvider
	
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject WebContentProposalPriorities proposalPriorities
	
	override createTypeProposals(ContentAssistContext context, EReference typeReference,
			IValueConverter<String> valueConverter, ITypeFilter filter, IWebContentProposaAcceptor acceptor) {
		val resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(context.resource)
		for (resourceDesc : resourceDescriptions.allResourceDescriptions) {
			for (typeDesc : resourceDesc.getExportedObjectsByType(TypesPackage.Literals.JVM_TYPE)) {
				// TODO ask the type filter whether we should accept this type
				val entry = createProposal(typeDesc, typeReference, context)
				acceptor.accept(entry, proposalPriorities.getCrossRefPriority(typeDesc, entry))
			}
		}
	}
	
	protected def ContentAssistResult.Entry createProposal(IEObjectDescription typeDesc, EReference typeReference,
			ContentAssistContext context) {
		return new ContentAssistResult.Entry(context.prefix) => [
			proposal = typeDesc.name.lastSegment
			description = qualifiedNameConverter.toString(typeDesc.qualifiedName)
		]
	}
	
}