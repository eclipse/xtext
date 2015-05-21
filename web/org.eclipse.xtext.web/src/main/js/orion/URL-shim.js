/*******************************************************************************
 * @license
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*eslint-env browser, amd*/
/*global StopIteration*/
// URL Shim -- see http://url.spec.whatwg.org/ and http://dvcs.w3.org/hg/url/raw-file/tip/Overview.html

(function() {
    try {
        var testURL;
        if (typeof window.URL === "function" && window.URL.length !== 0 &&
                (testURL = new window.URL("http://www.w3.org?q")).protocol === "http:" && testURL.query) {
            return;
        }
    } catch (e) {}

    //[1]scheme, [2]authority, [3]path, [4]query, [5]fragment
    var _URI_RE = /^(?:([^:\/?#]+):)?(?:\/\/([^\/?#]*))?([^?#]*)(?:\?([^#]*))?(?:#(.*))?$/;
    //[ userinfo "@" ] host [ ":" port ]
    var _AUTHORITY_RE = /^(?:(.*)@)?(\[[^\]]*\]|[^:]*)(?::(.*))?$/;

    var _NO_WS_RE = /^\S*$/;
    var _SCHEME_RE = /^([a-zA-Z](?:[a-zA-Z0-9+-.])*)$/;
    var _PORT_RE = /^\d*$/;
    var _HOST_RE = /^(\[[^\]\/?#\s]*\]|[^:\/?#\s]*)$/;
    var _HOSTPORT_RE = /^(\[[^\]\/?#\s]*\]|[^:\/?#\s]*)(?::(\d*))?$/;
    var _PATH_RE = /^([^?#\s]*)$/;
    var _QUERY_RE = /^([^\s]*)$/;
    var _FRAGMENT_RE = _NO_WS_RE;
    var _USERNAME_PASSWORD_RE = /([^:]*):?(.*)/;

    var STOP_ITERATION = typeof StopIteration !== "undefined" ? StopIteration : new Error("Stop Iteration");
    var DEFAULT_PORTS = {
        "ftp:": "21",
            "gopher:": "70",
            "http:": "80",
            "https:": "443",
            "ws:": "80",
            "wss:": "443"
    };

    function _checkString(txt) {
        if (typeof txt !== "string") {
            throw new TypeError();
        }
    }

    function _parseQuery(query) {
        return query ? query.split("&") : [];
    }

    function _stringifyQuery(pairs) {
        if (pairs.length === 0) {
            return "";
        }
        return pairs.join("&");
    }

    function _parsePair(pair) {
        var parsed = /([^=]*)(?:=?)(.*)/.exec(pair);
        var key = parsed[1] ? decodeURIComponent(parsed[1]) : "";
        var value = parsed[2] ? decodeURIComponent(parsed[2]) : "";
        return [key, value];
    }

    function _stringifyPair(entry) {
        var pair = encodeURIComponent(entry[0]);
        if (entry[1]) {
            pair += "=" + encodeURIComponent(entry[1]);
        }
        return pair;
    }

    function _createMapIterator(url, kind) {
        var query = "";
        var pairs = [];
        var index = 0;
        return {
            next: function() {
                if (query !== url.query) {
                    query = url.query;
                    pairs = _parseQuery(query);
                }
                if (index < pairs.length) {
                    var entry = _parsePair(pairs[index++]);
                    switch (kind) {
                        case "keys":
                            return entry[0];
                        case "values":
                            return entry[1];
                        case "keys+values":
                            return [entry[0], entry[1]];
                        default:
                            throw new TypeError();
                    }
                }
                throw STOP_ITERATION;
            }
        };
    }

    // See http://url.spec.whatwg.org/#interface-urlquery
    function URLQuery(url) {
        Object.defineProperty(this, "_url", {
            get: function() {
                return url._url;
            }
        });
    }

    Object.defineProperties(URLQuery.prototype, {
        get: {
            value: function(key) {
                _checkString(key);
                var result;
                var pairs = _parseQuery(this._url.query);
                pairs.some(function(pair) {
                    var entry = _parsePair(pair);
                    if (entry[0] === key) {
                        result = entry[1];
                        return true;
                    }
                });
                return result;
            },
            enumerable: true
        },
        set: {
            value: function(key, value) {
                _checkString(key);
                _checkString(value);
                var pairs = _parseQuery(this._url.query);
                var found = pairs.some(function(pair, i) {
                    var entry = _parsePair(pair);
                    if (entry[0] === key) {
                        entry[1] = value;
                        pairs[i] = _stringifyPair(entry);
                        return true;
                    }
                });
                if (!found) {
                    pairs.push(_stringifyPair([key, value]));
                }
                this._url.query = _stringifyQuery(pairs);
            },
            enumerable: true
        },
        has: {
            value: function(key) {
                _checkString(key);
                var pairs = _parseQuery(this._url.query);
                return pairs.some(function(pair) {
                    var entry = _parsePair(pair);
                    if (entry[0] === key) {
                        return true;
                    }
                });
            },
            enumerable: true
        },
            "delete": {
            value: function(key) {
                _checkString(key);
                var pairs = _parseQuery(this._url.query);
                var filtered = pairs.filter(function(pair) {
                    var entry = _parsePair(pair);
                    return entry[0] !== key;
                });
                if (filtered.length !== pairs.length) {
                    this._url.query = _stringifyQuery(filtered);
                    return true;
                }
                return false;
            },
            enumerable: true
        },
        clear: {
            value: function() {
                this._url.query = "";
            },
            enumerable: true
        },
        forEach: {
            value: function(callback, thisArg) {
                if (typeof callback !== "function") {
                    throw new TypeError();
                }
                var iterator = _createMapIterator(this._url, "keys+values");
                try {
                    while (true) {
                        var entry = iterator.next();
                        callback.call(thisArg, entry[1], entry[0], this);
                    }
                } catch (e) {
                    if (e !== STOP_ITERATION) {
                        throw e;
                    }
                }
            },
            enumerable: true
        },
        keys: {
            value: function() {
                return _createMapIterator(this._url, "keys");
            },
            enumerable: true
        },
        values: {
            value: function() {
                return _createMapIterator(this._url, "values");
            },
            enumerable: true
        },
        items: {
            value: function() {
                return _createMapIterator(this._url, "keys+values");
            }
        },
        size: {
            get: function() {
                return _parseQuery(this._url.query).length;
            },
            enumerable: true
        },
        getAll: {
            value: function(key) {
                _checkString(key);
                var result = [];
                var pairs = _parseQuery(this._url.query);
                pairs.forEach(function(pair) {
                    var entry = _parsePair(pair);
                    if (entry[0] === key) {
                        result.push(entry[1]);
                    }
                });
                return result;
            },
            enumerable: true
        },
        append: {
            value: function(key, value) {
                _checkString(key);
                _checkString(value);
                var pairs = _parseQuery(this._url.query);
                pairs.push(_stringifyPair([key, value]));
                this._url.query = _stringifyQuery(pairs);
            },
            enumerable: true
        }
    });

    function _makeAbsoluteURL(url, base) {
        if (!url.scheme && base) {
            url.scheme = base.scheme;
            if (!url.host && base.host) {
                url.userinfo = base.userinfo;
                url.host = base.host;
                url.port = base.port;
                url.pathRelative = true;
            }
        }
        if (url.pathRelative) {
            if (!url.path) {
                url.path = base.path;
            } else if (url.path[0] !== "/") {
                var basePath = /^(.*\/)[^\/]*$/.exec(base.path)[1] || "/";
                url.path = basePath + url.path;
            }
        }
    }

    function _normalizeScheme(scheme) {
        return scheme.toLowerCase();
    }

    function _normalizePort(port) {
        return port ? (/[1-9]\d*$/).exec(port)[0] : "";
    }

    function _normalizePath(path) {
        var result = [];
        path.split("/").forEach(function(segment) {
            if (segment === "..") {
                result.pop();
            } else if (segment !== ".") {
                result.push(segment);
            }
        });
        return result.join("/");
    }


    function _normalizeURL(url) {
        if (url.scheme) {
            url.scheme = _normalizeScheme(url.scheme);
        }
        if (url.port) {
            url.port = _normalizePort(url.port);
        }
        if (url.host && url.path) {
            url.path = _normalizePath(url.path);
        }
    }

    function _encodeWhitespace(text) {
        return text.replace(/\s/g, function(c) {
            return "%" + c.charCodeAt(0).toString(16);
        });
    }

    function _parseURL(input, base) {
        if (typeof input !== "string") {
            throw new TypeError();
        }

        input = _encodeWhitespace(input);

        var parsedURI = _URI_RE.exec(input);
        if (!parsedURI) {
            return null;
        }
        var url = {};
        url.scheme = parsedURI[1] || "";
        if (url.scheme && !_SCHEME_RE.test(url.scheme)) {
            return null;
        }
        var authority = parsedURI[2];
        if (authority) {
            var parsedAuthority = _AUTHORITY_RE.exec(authority);
            url.userinfo = parsedAuthority[1];
            url.host = parsedAuthority[2];
            url.port = parsedAuthority[3];
            if (url.port && !_PORT_RE.test(url.port)) {
                return null;
            }
        }
        url.path = parsedURI[3];
        url.query = parsedURI[4];
        url.fragment = parsedURI[5];

        _makeAbsoluteURL(url, base);
        _normalizeURL(url);
        return url;
    }

    function _serialize(url) {
        var result = (url.scheme ? url.scheme + ":" : "");
        if (url.host) {
            result += "//";
            if (url.userinfo) {
                result += url.userinfo + "@";
            }
            result += url.host;
            if (url.port) {
                result += ":" + url.port;
            }
        }
        result += url.path;
        if (url.query) {
            result += "?" + url.query;
        }
        if (url.fragment) {
            result += "#" + url.fragment;
        }
        return result;
    }

    // See http://url.spec.whatwg.org/#api
    function URL(input, base) {
        var baseURL;
        if (base) {
            base = base.href || base;
            baseURL = _parseURL(base);
            if (!baseURL || !baseURL.scheme) {
                throw new SyntaxError();
            }
            Object.defineProperty(this, "_baseURL", {
                value: baseURL
            });
        }

        var url = _parseURL(input, baseURL);
        if (!url) {
            throw new SyntaxError();
        }

        Object.defineProperty(this, "_input", {
            value: input,
            writable: true
        });

        Object.defineProperty(this, "_url", {
            value: url,
            writable: true
        });

        var query = new URLQuery(this);
        Object.defineProperty(this, "query", {
            get: function() {
                return this._url ? query : null;
            },
            enumerable: true
        });
    }

    Object.defineProperties(URL.prototype, {
        href: {
            get: function() {
                return this._url ? _serialize(this._url) : this._input;
            },
            set: function(value) {
                _checkString(value);
                this._input = value;
                this._url = _parseURL(this._input, this._baseURL);
            },
            enumerable: true
        },
        origin: {
            get: function() {
                return (this._url && this._url.host ? this.protocol + "//" + this.host : "");
            },
            enumerable: true
        },
        protocol: {
            get: function() {
                return this._url ? this._url.scheme + ":" : ":";
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var scheme = (value.slice(-1) === ":") ? value.substring(0, value.length - 1) : value;
                if (scheme === "" || _SCHEME_RE.test(scheme)) {
                    this._url.scheme = _normalizeScheme(scheme);
                }

            },
            enumerable: true
        },
        _userinfo: { // note: not part of spec so not enumerable
            get: function() {
                return this._url ? this._url.userinfo : "";
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                this._url.userinfo = value;
            }
        },
        username: {
            get: function() {
                if (!this._url) {
                    return "";
                }
                var parsed = _USERNAME_PASSWORD_RE.exec(this._userinfo);
                var username = decodeURIComponent(parsed[1] || "");
                return username;
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var parsed = _USERNAME_PASSWORD_RE.exec(this._userinfo);
                var userpass = [encodeURIComponent(value || "")];
                if (parsed[2]) {
                    userpass.push(parsed[2]);
                }
                this._userinfo = userpass.join(":");
            },
            enumerable: true
        },
        password: {
            get: function() {
                if (!this._url) {
                    return "";
                }
                var parsed = _USERNAME_PASSWORD_RE.exec(this._userinfo);
                var password = decodeURIComponent(parsed[2] || "");
                return password;
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var parsed = _USERNAME_PASSWORD_RE.exec(this._userinfo);
                var userpass = [parsed[1] || ""];
                if (value) {
                    userpass.push(encodeURIComponent(value));
                }
                this._userinfo = userpass.join(":");
            },
            enumerable: true
        },
        host: {
            get: function() {
                var result = "";
                if (this._url && this._url.host) {
                    result += this._url.host;
                    if (this._url.port) {
                        result += ":" + this._url.port;
                    }
                }
                return result;
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var result = _HOSTPORT_RE.exec(value);
                if (result) {
                    this._url.host = result[1];
                    this._url.port = _normalizePort(result[2]);
                }
            },
            enumerable: true
        },
        hostname: {
            get: function() {
                return this._url ? this._url.host : "";
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var result = _HOST_RE.exec(value);
                if (result) {
                    this._url.host = value;
                }
            },
            enumerable: true
        },
        port: {
            get: function() {
                var port = this._url ? this._url.port || "" : "";
                if (port && port === DEFAULT_PORTS[this.protocol]) {
                    port = "";
                }
                return port;
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var result = _PORT_RE.exec(value);
                if (result) {
                    this._url.port = _normalizePort(value);
                }
            },
            enumerable: true
        },
        pathname: {
            get: function() {
                return this._url ? this._url.path : "";
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                var result = _PATH_RE.exec(value);
                if (result) {
                    if (this._url.host && value && value[0] !== "/") {
                        value = "/" + value;
                    }
                    this._url.path = value ? _normalizePath(value) : "";
                }
            },
            enumerable: true
        },
        search: {
            get: function() {
                return (this._url && this._url.query ? "?" + this._url.query : "");
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                if (value && value[0] === "?") {
                    value = value.substring(1);
                }
                var result = _QUERY_RE.exec(value);
                if (result) {
                    this._url.query = value;
                }
            },
            enumerable: true
        },
        hash: {
            get: function() {
                return (this._url && this._url.fragment ? "#" + this._url.fragment : "");
            },
            set: function(value) {
                _checkString(value);
                if (!this._url) {
                    return;
                }
                if (value && value[0] === "#") {
                    value = value.substring(1);
                }
                var result = _FRAGMENT_RE.exec(value);
                if (result) {
                    this._url.fragment = value;
                }
            },
            enumerable: true
        }
    });

	var _URL = window.URL || window.webkitURL;
    if (_URL && _URL.createObjectURL) {
        Object.defineProperty(URL, "createObjectURL", {
            value: _URL.createObjectURL.bind(_URL),
            enumerable: false
        });

        Object.defineProperty(URL, "revokeObjectURL", {
            value: _URL.revokeObjectURL.bind(_URL),
            enumerable: false
        });
    }
    window.URL = URL;
}());