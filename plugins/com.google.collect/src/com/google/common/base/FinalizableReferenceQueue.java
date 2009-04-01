/*
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.base;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Starts a background thread that cleans up after reclaimed referents.
 *
 * @author Bob Lee
 */
class FinalizableReferenceQueue extends ReferenceQueue<Object> {

  private static final Logger logger =
      Logger.getLogger(FinalizableReferenceQueue.class.getName());

  /**
   * Returns the singleton instance.
   */
  public static ReferenceQueue<Object> getInstance() {
    return LazyInstanceHolder.queue;
  }

  private static class LazyInstanceHolder {
    static final ReferenceQueue<Object> queue = new FinalizableReferenceQueue();
  }

  private FinalizableReferenceQueue() {
    start();
  }

  void start() {
    Thread thread = new Thread(getClass().getSimpleName()) {
      @Override public void run() {
        while (true) {
          try {
            cleanUp(remove());
          } catch (InterruptedException e) { /* ignore */ }
        }
      }
    };
    thread.setDaemon(true);
    thread.start();
  }

  void cleanUp(Reference<?> reference) {
    try {
      ((FinalizableReference) reference).finalizeReferent();
    } catch (Throwable t) {
      logger.log(Level.SEVERE, "Error cleaning up after reference.", t);
    }
  }
}
