/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegionToString;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TraceRegionToStringTester extends AbstractTraceRegionToString {
  public static class Location extends LocationData {
    public Location(final int offset, final int length, final SourceRelativeURI path) {
      super(offset, length, 0, 0, path);
    }
    
    public Location(final int offset, final int length) {
      this(offset, length, null);
    }
  }
  
  public static class Region extends TraceRegion {
    public Region(final int myOffset, final int myLength, final List<ILocationData> allLocationData, final AbstractTraceRegion parent) {
      super(myOffset, myLength, 0, 0, true, allLocationData, parent);
    }
    
    public Region(final int myOffset, final int myLength, final List<ILocationData> allLocationData) {
      super(myOffset, myLength, 0, 0, true, allLocationData, null);
    }
    
    public TraceRegionToStringTester.Region addChild(final int myOffset, final int myLength, final List<ILocationData> allLocationData) {
      final TraceRegionToStringTester.Region child = new TraceRegionToStringTester.Region(myOffset, myLength, allLocationData, this);
      return child;
    }
  }
  
  private final SourceRelativeURI uri1 = new SourceRelativeURI("remote1");
  
  private final SourceRelativeURI uri2 = new SourceRelativeURI("remote2");
  
  private String localText;
  
  private String remote1;
  
  private String remote2;
  
  private ITextRegion localFrame;
  
  private TraceRegionToStringTester.Region trace;
  
  public TraceRegionToStringTester() {
    this.setShowLegend(false);
  }
  
  @Override
  protected String getRemoteText(final SourceRelativeURI uri) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(uri, this.uri1)) {
        _matched=true;
        _switchResult = this.remote1;
      }
    }
    if (!_matched) {
      if (Objects.equal(uri, this.uri2)) {
        _matched=true;
        _switchResult = this.remote2;
      }
    }
    return _switchResult;
  }
  
  @Override
  protected String getLocalTitle() {
    return "local1";
  }
  
  @Pure
  public SourceRelativeURI getUri1() {
    return this.uri1;
  }
  
  @Pure
  public SourceRelativeURI getUri2() {
    return this.uri2;
  }
  
  @Pure
  public String getLocalText() {
    return this.localText;
  }
  
  public void setLocalText(final String localText) {
    this.localText = localText;
  }
  
  @Pure
  public String getRemote1() {
    return this.remote1;
  }
  
  public void setRemote1(final String remote1) {
    this.remote1 = remote1;
  }
  
  @Pure
  public String getRemote2() {
    return this.remote2;
  }
  
  public void setRemote2(final String remote2) {
    this.remote2 = remote2;
  }
  
  @Pure
  public ITextRegion getLocalFrame() {
    return this.localFrame;
  }
  
  public void setLocalFrame(final ITextRegion localFrame) {
    this.localFrame = localFrame;
  }
  
  @Pure
  public TraceRegionToStringTester.Region getTrace() {
    return this.trace;
  }
  
  public void setTrace(final TraceRegionToStringTester.Region trace) {
    this.trace = trace;
  }
}
