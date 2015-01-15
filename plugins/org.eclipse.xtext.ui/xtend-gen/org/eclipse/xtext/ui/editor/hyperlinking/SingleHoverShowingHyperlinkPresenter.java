/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hyperlinking;

import com.google.common.base.Objects;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.JFaceTextUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;

/**
 * The MultipleHyperLinkPresenter only shows the hyper link text when more then one hyper link exists.
 * This is not always desired as some hyperlinks might have special meaning, and without showing the user what the hyperlink does
 * only simple go to declaration hyperlinks should be treated like that.
 * 
 * Thus this class introduces a protocol for IHyperLinks to make sure their label is shown even if they are the only one.
 * To do so the property IHyperLink#getTypeLabel needs to be set to the constant SHOW_ALWAYS.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class SingleHoverShowingHyperlinkPresenter extends MultipleHyperlinkPresenter {
  @Extension
  private ReflectExtensions reflect = new ReflectExtensions();
  
  /**
   * constant text needs to set into IHyperLink#getTypeLabel (which doesn't seem to be used otherwise)
   * if a hyperlink's label should be shown even if it's the only hyper link.
   */
  public final static String SHOW_ALWAYS = "SHOW_ALWAYS";
  
  public SingleHoverShowingHyperlinkPresenter(final RGB color) {
    super(color);
  }
  
  public SingleHoverShowingHyperlinkPresenter(final IPreferenceStore store) {
    super(store);
  }
  
  @Override
  public void showHyperlinks(final IHyperlink[] activeHyperlinks) {
    try {
      super.showHyperlinks(activeHyperlinks);
      boolean _and = false;
      boolean _and_1 = false;
      int _length = activeHyperlinks.length;
      boolean _equals = (_length == 1);
      if (!_equals) {
        _and_1 = false;
      } else {
        IHyperlink _get = activeHyperlinks[0];
        String _typeLabel = _get.getTypeLabel();
        boolean _notEquals = (!Objects.equal(_typeLabel, null));
        _and_1 = _notEquals;
      }
      if (!_and_1) {
        _and = false;
      } else {
        IHyperlink _get_1 = activeHyperlinks[0];
        String _typeLabel_1 = _get_1.getTypeLabel();
        boolean _contains = _typeLabel_1.contains(SingleHoverShowingHyperlinkPresenter.SHOW_ALWAYS);
        _and = _contains;
      }
      if (_and) {
        IHyperlink _get_2 = activeHyperlinks[0];
        IRegion _hyperlinkRegion = _get_2.getHyperlinkRegion();
        final int start = _hyperlinkRegion.getOffset();
        IHyperlink _get_3 = activeHyperlinks[0];
        IRegion _hyperlinkRegion_1 = _get_3.getHyperlinkRegion();
        int _length_1 = _hyperlinkRegion_1.getLength();
        final int end = (start + _length_1);
        Region _region = new Region(start, (end - start));
        this.reflect.set(this, "fSubjectRegion", _region);
        ITextViewer _get_4 = this.reflect.<ITextViewer>get(this, "fTextViewer");
        int _offsetForCursorLocation = JFaceTextUtil.getOffsetForCursorLocation(_get_4);
        this.reflect.set(this, "fCursorOffset", Integer.valueOf(_offsetForCursorLocation));
        Object _get_5 = this.reflect.<Object>get(this, "fManager");
        this.reflect.invoke(_get_5, "showInformation");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
