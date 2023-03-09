/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.resolvers;

import org.eclipse.jface.text.templates.SimpleTemplateVariableResolver;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.xtext.ui.editor.templates.CrossReferenceTemplateVariableResolver;
import org.eclipse.xtext.ui.editor.templates.EnumTemplateVariableResolver;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InspectableTemplateVariableResolverRegistry {

	public IInspectableTemplateVariableResolver toInspectableResolver(TemplateVariableResolver resolver) {
		if (resolver instanceof IInspectableTemplateVariableResolver)
			return (IInspectableTemplateVariableResolver) resolver;
		if (resolver instanceof SimpleTemplateVariableResolver) {
			return new InspectableSimpleTemplateVariableResolver((SimpleTemplateVariableResolver) resolver);
		}
		if ("CrossReference".equals(resolver.getType())) {
			return new InspectableCrossReferenceVariableResolver((CrossReferenceTemplateVariableResolver) resolver);
		}
		if ("Enum".equals(resolver.getType())) {
			return new InspectableEnumVariableResolver((EnumTemplateVariableResolver) resolver);
		}
		return null;
	}
	
}
