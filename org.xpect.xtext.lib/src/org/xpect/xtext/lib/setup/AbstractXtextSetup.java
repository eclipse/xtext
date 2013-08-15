package org.xpect.xtext.lib.setup;

import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.xpect.expectation.ITargetSyntaxSupport;
import org.xpect.parameter.ParameterProvider;
import org.xpect.setup.AbstractXpectSetup;
import org.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.xpect.xtext.lib.setup.generic.GenericResource;
import org.xpect.xtext.lib.util.XtextTargetSyntaxSupport;

import com.google.common.collect.Lists;

public class AbstractXtextSetup<T, K, V, X> extends AbstractXpectSetup<T, K, V, X> {
	public static class AbstractConfig {

		private List<GenericResource> genericResources = Lists.newArrayList();

		private AssertingValidator validate;

		public void add(GenericResource file) {
			this.genericResources.add(file);
		}

		public List<GenericResource> getGenericResources() {
			return genericResources;
		}

		public AssertingValidator getValidate() {
			if (validate == null)
				validate = new AssertingValidator();
			return validate;
		}

		public void setValidate(AssertingValidator validate) {
			this.validate = validate;
		}
	}

	protected void installResourceParameterValues(ITestSetupContext ctx, XtextResource res) {
		ctx.installParameterValue(ITargetSyntaxSupport.Annotation.class, new ParameterProvider(new XtextTargetSyntaxSupport(res)));
		ctx.installParameterValue(ThisResource.class, new ParameterProvider(res));
		ctx.installParameterValue(ThisOffset.class, new ThisOffsetProvider(ctx.getXpectInvocation(), res));
		ctx.installParameterValue(ThisModel.class, new ParameterProvider(res.getContents().isEmpty() ? null : res.getContents().get(0)));
	}
}
