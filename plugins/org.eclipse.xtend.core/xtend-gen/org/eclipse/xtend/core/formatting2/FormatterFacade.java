/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.formatting2;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
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
      URI _createURI = URI.createURI("synthetic://to-be-formatted.xtend");
      Resource _createResource = this.resourceFactory.createResource(_createURI);
      final XtextResource resource = ((XtextResource) _createResource);
      EList<Resource> _resources = resourceSet.getResources();
      _resources.add(resource);
      StringInputStream _stringInputStream = new StringInputStream(xtendCode);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      resource.load(_stringInputStream, _emptyMap);
      TextRegionAccessBuilder _get = this.regionAccessBuilder.get();
      TextRegionAccessBuilder _forNodeModel = _get.forNodeModel(resource);
      final ITextRegionAccess regionAccess = _forNodeModel.create();
      FormatterRequest _formatterRequest = new FormatterRequest();
      final Procedure1<FormatterRequest> _function = new Procedure1<FormatterRequest>() {
        @Override
        public void apply(final FormatterRequest it) {
          it.setAllowIdentityEdits(false);
          it.setTextRegionAccess(regionAccess);
          IPreferenceValues _preferenceValues = FormatterFacade.this.cfgProvider.getPreferenceValues(resource);
          ITypedPreferenceValues _castOrWrap = TypedPreferenceValues.castOrWrap(_preferenceValues);
          it.setPreferences(_castOrWrap);
        }
      };
      FormatterRequest request = ObjectExtensions.<FormatterRequest>operator_doubleArrow(_formatterRequest, _function);
      List<ITextReplacement> replacements = this.formatter.format(request);
      ITextRegionRewriter _rewriter = regionAccess.getRewriter();
      return _rewriter.renderToString(replacements);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
