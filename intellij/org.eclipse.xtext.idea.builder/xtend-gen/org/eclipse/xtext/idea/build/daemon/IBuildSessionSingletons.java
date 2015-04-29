/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.build.net.ObjectChannel;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IBuildSessionSingletons.Impl.class)
@SuppressWarnings("all")
public interface IBuildSessionSingletons {
  @Singleton
  @Accessors
  public static class Impl implements IBuildSessionSingletons {
    private ObjectChannel objectChannel;
    
    private String moduleBaseURL;
    
    @Pure
    public ObjectChannel getObjectChannel() {
      return this.objectChannel;
    }
    
    public void setObjectChannel(final ObjectChannel objectChannel) {
      this.objectChannel = objectChannel;
    }
    
    @Pure
    public String getModuleBaseURL() {
      return this.moduleBaseURL;
    }
    
    public void setModuleBaseURL(final String moduleBaseURL) {
      this.moduleBaseURL = moduleBaseURL;
    }
  }
  
  public abstract ObjectChannel getObjectChannel();
  
  public abstract String getModuleBaseURL();
}
