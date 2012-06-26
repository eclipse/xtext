package org.eclipse.xpect.ui;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

public class FilteringResourceValidator extends ResourceValidatorImpl {

	@Override
	public List<Issue> validate(Resource resource, CheckMode mode,
			CancelIndicator indicator) {
		List<Issue> list = super.validate(resource, mode, indicator);
		for (Issue i : list)
			if (i instanceof IssueImpl)
				((IssueImpl) i).setMessage("Hello World! " + i.getMessage());
		return list;
	}

}
