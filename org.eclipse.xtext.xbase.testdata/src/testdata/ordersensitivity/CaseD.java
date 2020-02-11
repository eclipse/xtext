/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata.ordersensitivity;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public class CaseD {

	public interface Runner {
        public void run();
    }

    public interface RunnerWithResult<T> {
        public T run();
    }

    public <T> T run(RunnerWithResult<T> runner) {
        return runner.run();
    }
    
    public void run(Runner runner) {
    	runner.run();
    }
	
}
