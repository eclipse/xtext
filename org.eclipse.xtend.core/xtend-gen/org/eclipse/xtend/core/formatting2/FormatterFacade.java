/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.TypedPreferenceValues;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class FormatterFacade {
  @Inject
  private IResourceFactory resourceFactory;

  @Inject
  @FormatterPreferences
  private IPreferenceValuesProvider cfgProvider;

  @Inject
  private IFormatter2 formatter;

  @Inject
  private Provider<TextRegionAccessBuilder> regionAccessBuilder;

  public String format(final String xtendCode) {
    try {
      final XtextResourceSet resourceSet = new XtextResourceSet();
      Resource _createResource = this.resourceFactory.createResource(URI.createURI("synthetic://to-be-formatted.xtend"));
      final XtextResource resource = ((XtextResource) _createResource);
      EList<Resource> _resources = resourceSet.getResources();
      _resources.add(resource);
      StringInputStream _stringInputStream = new StringInputStream(xtendCode);
      resource.load(_stringInputStream, CollectionLiterals.<Object, Object>emptyMap());
      final ITextRegionAccess regionAccess = this.regionAccessBuilder.get().forNodeModel(resource).create();
      FormatterRequest _formatterRequest = new FormatterRequest();
      final Procedure1<FormatterRequest> _function = (FormatterRequest it) -> {
        it.setAllowIdentityEdits(false);
        it.setTextRegionAccess(regionAccess);
        it.setPreferences(TypedPreferenceValues.castOrWrap(this.cfgProvider.getPreferenceValues(resource)));
      };
      FormatterRequest request = ObjectExtensions.<FormatterRequest>operator_doubleArrow(_formatterRequest, _function);
      List<ITextReplacement> replacements = this.formatter.format(request);
      return regionAccess.getRewriter().renderToString(replacements);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
