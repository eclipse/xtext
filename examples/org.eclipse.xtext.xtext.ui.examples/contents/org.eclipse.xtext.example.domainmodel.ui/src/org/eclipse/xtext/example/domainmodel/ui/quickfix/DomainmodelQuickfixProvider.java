package org.eclipse.xtext.example.domainmodel.ui.quickfix;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelFactory;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.validation.IssueCodes;
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

	@Fix(IssueCodes.INVALID_TYPE_NAME)
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

	@Fix(IssueCodes.INVALID_FEATURE_NAME)
	public void fixFeatureName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Uncapitalize name", "Uncapitalize name of '" + issue.getData()[0] + "'", "upcase.png",
		// exemplary semantic modification 
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) {
						((Feature) element).setName(Strings.toFirstLower(issue.getData()[0]));
					}
				});
	}

	@Fix(IssueCodes.MISSING_TYPE)
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
		return addEntityAsSibling(sibling, newEntity);
	}

	protected boolean addEntityAsSibling(Entity sibling, Entity newType) {
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
