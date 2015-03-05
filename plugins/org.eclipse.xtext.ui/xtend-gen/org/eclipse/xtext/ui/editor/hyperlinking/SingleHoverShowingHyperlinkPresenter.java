/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hyperlinking;

import com.google.common.base.Objects;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.JFaceTextUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
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
@FinalFieldsConstructor
@SuppressWarnings("all")
public class SingleHoverShowingHyperlinkPresenter implements InvocationHandler {
  @Extension
  private ReflectExtensions reflect = new ReflectExtensions();
  
  /**
   * constant text needs to set into IHyperLink#getTypeLabel (which doesn't seem to be used otherwise)
   * if a hyperlink's label should be shown even if it's the only hyper link.
   */
  public final static String SHOW_ALWAYS = "SHOW_ALWAYS";
  
  private final MultipleHyperlinkPresenter delegate;
  
  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
    boolean _and = false;
    boolean _and_1 = false;
    String _name = method.getName();
    boolean _startsWith = _name.startsWith("showHyperlinks");
    if (!_startsWith) {
      _and_1 = false;
    } else {
      int _length = args.length;
      boolean _greaterEqualsThan = (_length >= 1);
      _and_1 = _greaterEqualsThan;
    }
    if (!_and_1) {
      _and = false;
    } else {
      Object _get = args[0];
      _and = (_get instanceof IHyperlink[]);
    }
    if (_and) {
      final Object result = method.invoke(this.delegate, args);
      Object _get_1 = args[0];
      final IHyperlink[] activeHyperlinks = ((IHyperlink[]) _get_1);
      int _length_1 = activeHyperlinks.length;
      boolean _equals = (_length_1 == 1);
      if (_equals) {
        final IHyperlink singleHyperlink = activeHyperlinks[0];
        String _typeLabel = singleHyperlink.getTypeLabel();
        boolean _equals_1 = Objects.equal(SingleHoverShowingHyperlinkPresenter.SHOW_ALWAYS, _typeLabel);
        if (_equals_1) {
          IRegion _hyperlinkRegion = singleHyperlink.getHyperlinkRegion();
          final int start = _hyperlinkRegion.getOffset();
          IRegion _hyperlinkRegion_1 = singleHyperlink.getHyperlinkRegion();
          int _length_2 = _hyperlinkRegion_1.getLength();
          final int end = (start + _length_2);
          Region _region = new Region(start, (end - start));
          this.reflect.set(this.delegate, "fSubjectRegion", _region);
          ITextViewer _get_2 = this.reflect.<ITextViewer>get(this.delegate, "fTextViewer");
          int _offsetForCursorLocation = JFaceTextUtil.getOffsetForCursorLocation(_get_2);
          this.reflect.set(this.delegate, "fCursorOffset", Integer.valueOf(_offsetForCursorLocation));
          Object _get_3 = this.reflect.<Object>get(this.delegate, "fManager");
          ((AbstractInformationControlManager) _get_3).showInformation();
        }
      }
      return result;
    }
    return method.invoke(this.delegate, args);
  }
  
  public SingleHoverShowingHyperlinkPresenter(final MultipleHyperlinkPresenter delegate) {
    super();
    this.delegate = delegate;
  }
}
