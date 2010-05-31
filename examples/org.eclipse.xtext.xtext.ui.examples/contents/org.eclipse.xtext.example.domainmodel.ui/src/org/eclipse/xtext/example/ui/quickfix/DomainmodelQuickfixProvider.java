package org.eclipse.xtext.example.ui.quickfix;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.example.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.DataType;
import org.eclipse.xtext.example.domainmodel.DomainmodelFactory;
import org.eclipse.xtext.example.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.Type;
import org.eclipse.xtext.example.ui.linking.DomainmodelLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.example.validation.DomainmodelJavaValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

public class DomainmodelQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(DomainmodelJavaValidator.INVALID_TYPE_NAME)
	public void fixTypeName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Capitalize name", "Capitalize name  of '" + issue.getData()[0] + "'", "upcase.png",
		// exemplary textual modification 
				new IModification() {
					public void apply(IModificationContext context) throws BadLocationException {
						IXtextDocument xtextDocument = context.getXtextDocument();
						String firstLetter = xtextDocument.get(issue.getOffset(), 1);
						xtextDocument.replace(issue.getOffset(), 1, Strings.toFirstUpper(firstLetter));
					}
				});
	}

	@Fix(DomainmodelJavaValidator.INVALID_FEATURE_NAME)
	public void fixFeatureName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Uncapitalize name", "Uncapitalize name of '" + issue.getData()[0] + "'", "upcase.png",
		// exemplary semantic modification 
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) {
						((Feature) element).setName(Strings.toFirstLower(issue.getData()[0]));
					}
				});
	}

	@Fix(DomainmodelLinkingDiagnosticMessageProvider.MISSING_SUPERTYPE)
	public void createSupertype(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String linkText = issue.getData()[0];
		acceptor.accept(issue, "Create supertype '" + linkText + "'", "Create supertype '" + linkText + "'", null,
				new ISemanticModification() {
					public void apply(final EObject element, IModificationContext context) {
						createNewEntity((Entity) element, linkText);
					}
				});
		createLinkingIssueResolutions(issue, acceptor);
	}

	@Fix(DomainmodelLinkingDiagnosticMessageProvider.MISSING_ATTRIBUTE_TYPE)
	public void createAttributeType(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String linkText = issue.getData()[0];
		acceptor.accept(issue, "Create datatype '" + linkText + "'", "Create datatype '" + linkText + "'", null,
				new ISemanticModification() {
					public void apply(final EObject element, IModificationContext context) {
						createNewDatatype((Entity) element.eContainer().eContainer(), linkText);
					}
				});
		createLinkingIssueResolutions(issue, acceptor);
	}

	@Fix(DomainmodelLinkingDiagnosticMessageProvider.MISSING_REFERENCE_TYPE)
	public void createReferenceType(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String linkText = issue.getData()[0];
		acceptor.accept(issue, "Create entity '" + linkText + "'", "Create entity '" + linkText + "'", null,
				new ISemanticModification() {
					public void apply(final EObject element, IModificationContext context) {
						createNewEntity((Entity) element.eContainer().eContainer(), linkText);
					}
				});
		createLinkingIssueResolutions(issue, acceptor);
	}

	protected boolean createNewEntity(Entity sibling, String name) {
		Entity newEntity = DomainmodelFactory.eINSTANCE.createEntity();
		newEntity.setName(name);
		return addTypeAsSibling(sibling, newEntity);
	}

	protected boolean createNewDatatype(Entity sibling, String name) {
		DataType newDatatype = DomainmodelFactory.eINSTANCE.createDataType();
		newDatatype.setName(name);
		return addTypeAsSibling(sibling, newDatatype);
	}

	protected boolean addTypeAsSibling(Entity sibling, Type newType) {
		EObject container = sibling.eContainer();
		EList<AbstractElement> elements = null;
		if (container instanceof PackageDeclaration) {
			elements = ((PackageDeclaration) container).getElements();
		} else if (container instanceof DomainModel) {
			elements = ((DomainModel) container).getElements();
		} else {
			return false;
		}
		int index = elements.indexOf(sibling) + 1;
		elements.add(index, newType);
		return true;
	}
}
