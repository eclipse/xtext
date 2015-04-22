/*******************************************************************************
 * @license
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/
/*eslint-env browser, amd, node*/
(function(root, factory) { // UMD
    if (typeof define === "function" && define.amd) { //$NON-NLS-0$
        define(factory);
    } else if (typeof exports === "object") { //$NON-NLS-0$
        module.exports = factory();
    } else {
        root.orion = root.orion || {};
        root.orion.Deferred = factory();
    }
}(this, function() {
    var queue = [],
        running = false;

    function run() {
        var fn;
        while ((fn = queue.shift())) {
            fn();
        }
        running = false;
    }

	var runAsync = (function() {
		if (typeof process !== "undefined" && typeof process.nextTick === "function") {
			var nextTick = process.nextTick;
    		return function() {
    			nextTick(run);
    		};
		} else if (typeof MutationObserver === "function") {
			var div = document.createElement("div");
			var observer = new MutationObserver(run);
			observer.observe(div, {
            	attributes: true
        	});
        	return function() {
        		div.setAttribute("class", "_tick");
        	};
		}
		return function() {
			setTimeout(run, 0);
		};
	})();

    function enqueue(fn) {
        queue.push(fn);
        if (!running) {
            running = true;
            runAsync();
        }
    }

    function noReturn(fn) {
        return function(result) {
            fn(result);
        };
    }
    
    function settleDeferred(fn, result, deferred) {
    	try {
    		var listenerResult = fn(result);
    		var listenerThen = listenerResult && (typeof listenerResult === "object" || typeof listenerResult === "function") && listenerResult.then;
    		if (typeof listenerThen === "function") {
    			if (listenerResult === deferred.promise) {
    				deferred.reject(new TypeError());
    			} else {
    				var listenerResultCancel = listenerResult.cancel;
    				if (typeof listenerResultCancel === "function") {
    					deferred._parentCancel = listenerResultCancel.bind(listenerResult);
    				} else {
    					delete deferred._parentCancel;
    				}
    				listenerThen.call(listenerResult, noReturn(deferred.resolve), noReturn(deferred.reject), noReturn(deferred.progress));
    			}
    		} else {
    			deferred.resolve(listenerResult);
    		}
    	} catch (e) {
    		deferred.reject(e);
    	}
    }


    /**
     * @name orion.Promise
     * @class Interface representing an eventual value.
     * @description Promise is an interface that represents an eventual value returned from the single completion of an operation.
     *
     * <p>For a concrete class that implements Promise and provides additional API, see {@link orion.Deferred}.</p>
     * @see orion.Deferred
     * @see orion.Deferred#promise
     */
    /**
     * @name then
     * @function
     * @memberOf orion.Promise.prototype
     * @description Adds handlers to be called on fulfillment or progress of this promise.
     * @param {Function} [onResolve] Called when this promise is resolved.
     * @param {Function} [onReject] Called when this promise is rejected.
     * @param {Function} [onProgress] May be called to report progress events on this promise.
     * @returns {orion.Promise} A new promise that is fulfilled when the given <code>onResolve</code> or <code>onReject</code>
     * callback is finished. The callback's return value gives the fulfillment value of the returned promise.
     */
    /**
     * Cancels this promise.
     * @name cancel
     * @function
     * @memberOf orion.Promise.prototype
     * @param {Object} reason The reason for canceling this promise.
     * @param {Boolean} [strict]
     */

    /**
     * @name orion.Deferred
     * @borrows orion.Promise#then as #then
     * @borrows orion.Promise#cancel as #cancel
     * @class Provides abstraction over asynchronous operations.
     * @description Deferred provides abstraction over asynchronous operations.
     *
     * <p>Because Deferred implements the {@link orion.Promise} interface, a Deferred may be used anywhere a Promise is called for.
     * However, in most such cases it is recommended to use the Deferred's {@link #promise} field instead, which exposes a 
     * simplified, minimally <a href="https://github.com/promises-aplus/promises-spec">Promises/A+</a>-compliant interface to callers.</p>
     */
    function Deferred() {
        var result, state, listeners = [],
            _this = this;

        function notify() {
            var listener;
            while ((listener = listeners.shift())) {
                var deferred = listener.deferred;
                var methodName = state === "fulfilled" ? "resolve" : "reject"; //$NON-NLS-0$ //$NON-NLS-1$ //$NON-NLS-2$
                var fn = listener[methodName];
                if (typeof fn === "function") { //$NON-NLS-0$
                	settleDeferred(fn, result, deferred);
                } else {
                    deferred[methodName](result);
                }
            }
        }

        function _reject(error) {
            delete _this._parentCancel;
            state = "rejected";
            result = error;
            if (listeners.length) {
                enqueue(notify);
            }
        }

        function _resolve(value) {
            function once(fn) {
                return function(result) {
                    if (!state || state === "assumed") {
                          fn(result);
                    }
                };
            }
            delete _this._parentCancel;
            try {
                var valueThen = value && (typeof value === "object" || typeof value === "function") && value.then;
                if (typeof valueThen === "function") {
                    if (value === _this) {
                        _reject(new TypeError());
                    } else {
                        state = "assumed";
                        var valueCancel = value && value.cancel;
                        if (typeof valueCancel !== "function") {
                            var deferred = new Deferred();
                            value = deferred.promise;
                            try {
                                valueThen(deferred.resolve, deferred.reject, deferred.progress);
                            } catch (thenError) {
                                deferred.reject(thenError);
                            }
                            valueCancel = value.cancel;
                            valueThen = value.then;
                        }
                        result = value;
                        valueThen.call(value, once(_resolve), once(_reject));
                        _this._parentCancel = valueCancel.bind(value);
                    }
                } else {
                    state = "fulfilled";
                    result = value;
                    if (listeners.length) {
                        enqueue(notify);
                    }
                }
            } catch (error) {
                once(_reject)(error);
            }
        }

        function cancel() {
            var parentCancel = _this._parentCancel;
            if (parentCancel) {
                delete _this._parentCancel;
                parentCancel();
            } else if (!state) {
                var cancelError = new Error("Cancel");
                cancelError.name = "Cancel";
                _reject(cancelError);
            }
        }


        /**
         * Resolves this Deferred.
         * @name resolve
         * @function
         * @memberOf orion.Deferred.prototype
         * @param {Object} value
         * @returns {orion.Promise}
         */
        this.resolve = function(value) {
            if (!state) {
                _resolve(value);
            }
            return _this;
        };

        /**
         * Rejects this Deferred.
         * @name reject
         * @function
         * @memberOf orion.Deferred.prototype
         * @param {Object} error
         * @param {Boolean} [strict]
         * @returns {orion.Promise}
         */
        this.reject = function(error) {
            if (!state) {
                _reject(error);
            }
            return _this;
        };

        /**
         * Notifies listeners of progress on this Deferred.
         * @name progress
         * @function
         * @memberOf orion.Deferred.prototype
         * @param {Object} update The progress update.
         * @returns {orion.Promise}
         */
        this.progress = function(update) {
            if (!state) {
                listeners.forEach(function(listener) {
                    if (listener.progress) {
                        try {
                            listener.progress(update);
                        } catch (ignore) {
                            // ignore
                        }
                    }
                });
            }
            return _this.promise;
        };

        this.cancel = function() {
            if (_this._parentCancel) {
                setTimeout(cancel, 0);
            } else {
                cancel();
            }
            return _this;
        };

        // Note: "then" ALWAYS returns before having onResolve or onReject called as per http://promises-aplus.github.com/promises-spec/
        this.then = function(onFulfill, onReject, onProgress) {
        	var deferred = new Deferred();
            deferred._parentCancel = _this.promise.cancel;
            listeners.push({
                resolve: onFulfill,
                reject: onReject,
                progress: onProgress,
                deferred: deferred
            });
            if (state === "fulfilled" || state === "rejected") {
                enqueue(notify);
            }
            return deferred.promise;
        };

        /**
         * The promise exposed by this Deferred.
         * @name promise
         * @field
         * @memberOf orion.Deferred.prototype
         * @type orion.Promise
         */
        this.promise = {
            then: _this.then,
            cancel: _this.cancel
        };
    }

    /**
     * Returns a promise that represents the outcome of all the input promises.
     * <p>When <code>all</code> is called with a single parameter, the returned promise has <dfn>eager</dfn> semantics,
     * meaning that if any input promise rejects, the returned promise immediately rejects, without waiting for the rest of the
     * input promises to fulfill.</p>
     *
     * To obtain <dfn>lazy</dfn> semantics (meaning the returned promise waits for every input promise to fulfill), pass the
     * optional parameter <code>optOnError</code>.
     * @name all
     * @function
     * @memberOf orion.Deferred
     * @static
     * @param {orion.Promise[]} promises The input promises.
     * @param {Function} [optOnError] Handles a rejected input promise. <code>optOnError</code> is invoked for every rejected
     * input promise, and is passed the reason the input promise was rejected. <p><code>optOnError</code> can return a value, which
     * allows it to act as a transformer: the return value serves as the final fulfillment value of the rejected promise in the 
     * results array generated by <code>all</code>.
     * @returns {orion.Promise} A new promise. The returned promise is generally fulfilled to an <code>Array</code> whose elements
     * give the fulfillment values of the input promises. <p>However, if an input promise rejects and eager semantics is used, the 
     * returned promise will instead be fulfilled to a single error value.</p>
     */
    Deferred.all = function(promises, optOnError) {
        var count = promises.length,
            result = [],
            rejected = false,
            deferred = new Deferred();

        deferred.then(undefined, function() {
            rejected = true;
            promises.forEach(function(promise) {
                if (promise.cancel) {
                    promise.cancel();
                }
            });
        });

        function onResolve(i, value) {
            if (!rejected) {
                result[i] = value;
                if (--count === 0) {
                    deferred.resolve(result);
                }
            }
        }

        function onReject(i, error) {
            if (!rejected) {
                if (optOnError) {
                    try {
                        onResolve(i, optOnError(error));
                        return;
                    } catch (e) {
                        error = e;
                    }
                }
                deferred.reject(error);
            }
        }

        if (count === 0) {
            deferred.resolve(result);
        } else {
            promises.forEach(function(promise, i) {
                promise.then(onResolve.bind(undefined, i), onReject.bind(undefined, i));
            });
        }
        return deferred.promise;
    };

    /**
     * Applies callbacks to a promise or to a regular object.
     * @name when
     * @function
     * @memberOf orion.Deferred
     * @static
     * @param {Object|orion.Promise} value Either a {@link orion.Promise}, or a normal value.
     * @param {Function} onResolve Called when the <code>value</code> promise is resolved. If <code>value</code> is not a promise,
     * this function is called immediately.
     * @param {Function} onReject Called when the <code>value</code> promise is rejected. If <code>value</code> is not a promise, 
     * this function is never called.
     * @param {Function} onProgress Called when the <code>value</code> promise provides a progress update. If <code>value</code> is
     * not a promise, this function is never called.
     * @returns {orion.Promise} A new promise.
     */
    Deferred.when = function(value, onResolve, onReject, onProgress) {
        var promise, deferred;
        if (value && typeof value.then === "function") { //$NON-NLS-0$
            promise = value;
        } else {
            deferred = new Deferred();
            deferred.resolve(value);
            promise = deferred.promise;
        }
        return promise.then(onResolve, onReject, onProgress);
    };

    return Deferred;
}));