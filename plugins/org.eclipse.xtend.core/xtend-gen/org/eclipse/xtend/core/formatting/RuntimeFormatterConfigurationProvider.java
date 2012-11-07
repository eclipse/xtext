/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.formatting;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.IFormatterConfigurationProvider;
import org.eclipse.xtend.core.formatting.MapBasedConfigurationValues;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Moritz Eysholdt
 */
@SuppressWarnings("all")
public class RuntimeFormatterConfigurationProvider implements IFormatterConfigurationProvider {
  @Inject
  private XtendFormatterConfigKeys keys;
  
  @Inject
  private IWhitespaceInformationProvider whitespaceInfo;
  
  public IConfigurationValues getFormatterConfiguration(final Resource resource) {
    MapBasedConfigurationValues<XtendFormatterConfigKeys> _xblockexpression = null;
    {
      MapBasedConfigurationValues<XtendFormatterConfigKeys> _mapBasedConfigurationValues = new MapBasedConfigurationValues<XtendFormatterConfigKeys>(this.keys);
      final MapBasedConfigurationValues<XtendFormatterConfigKeys> cfg = _mapBasedConfigurationValues;
      URI _uRI = resource.getURI();
      final IIndentationInformation indentationInfo = this.whitespaceInfo.getIndentationInformation(_uRI);
      URI _uRI_1 = resource.getURI();
      final ILineSeparatorInformation lineSeparatorInfo = this.whitespaceInfo.getLineSeparatorInformation(_uRI_1);
      String _lineSeparator = lineSeparatorInfo.getLineSeparator();
      cfg.<String>put(this.keys.lineSeparator, _lineSeparator);
      String _indentString = indentationInfo.getIndentString();
      cfg.<String>put(this.keys.indentation, _indentString);
      cfg.<Integer>put(this.keys.indentationLength, Integer.valueOf(4));
      _xblockexpression = (cfg);
    }
    return _xblockexpression;
  }
}
