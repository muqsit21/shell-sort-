gapi.loaded_0(function(_) {
    var window = this;
    _._F_toggles_initialize = function(a) {
        (typeof globalThis !== "undefined" ? globalThis : typeof self !== "undefined" ? self : this)._F_toggles = a || []
    }
    ;
    (0,
    _._F_toggles_initialize)([]);
    var aa, ea, la, pa, za, Ea, Fa;
    aa = function(a) {
        var b = 0;
        return function() {
            return b < a.length ? {
                done: !1,
                value: a[b++]
            } : {
                done: !0
            }
        }
    }
    ;
    ea = typeof Object.defineProperties == "function" ? Object.defineProperty : function(a, b, c) {
        if (a == Array.prototype || a == Object.prototype)
            return a;
        a[b] = c.value;
        return a
    }
    ;
    la = function(a) {
        a = ["object" == typeof globalThis && globalThis, a, "object" == typeof window && window, "object" == typeof self && self, "object" == typeof global && global];
        for (var b = 0; b < a.length; ++b) {
            var c = a[b];
            if (c && c.Math == Math)
                return c
        }
        throw Error("a");
    }
    ;
    _.na = la(this);
    pa = function(a, b) {
        if (b)
            a: {
                var c = _.na;
                a = a.split(".");
                for (var d = 0; d < a.length - 1; d++) {
                    var e = a[d];
                    if (!(e in c))
                        break a;
                    c = c[e]
                }
                a = a[a.length - 1];
                d = c[a];
                b = b(d);
                b != d && b != null && ea(c, a, {
                    configurable: !0,
                    writable: !0,
                    value: b
                })
            }
    }
    ;
    pa("Symbol", function(a) {
        if (a)
            return a;
        var b = function(f, h) {
            this.I1 = f;
            ea(this, "description", {
                configurable: !0,
                writable: !0,
                value: h
            })
        };
        b.prototype.toString = function() {
            return this.I1
        }
        ;
        var c = "jscomp_symbol_" + (Math.random() * 1E9 >>> 0) + "_"
          , d = 0
          , e = function(f) {
            if (this instanceof e)
                throw new TypeError("Symbol is not a constructor");
            return new b(c + (f || "") + "_" + d++,f)
        };
        return e
    });
    pa("Symbol.iterator", function(a) {
        if (a)
            return a;
        a = Symbol("Symbol.iterator");
        for (var b = "Array Int8Array Uint8Array Uint8ClampedArray Int16Array Uint16Array Int32Array Uint32Array Float32Array Float64Array".split(" "), c = 0; c < b.length; c++) {
            var d = _.na[b[c]];
            typeof d === "function" && typeof d.prototype[a] != "function" && ea(d.prototype, a, {
                configurable: !0,
                writable: !0,
                value: function() {
                    return qa(aa(this))
                }
            })
        }
        return a
    });
    var qa = function(a) {
        a = {
            next: a
        };
        a[Symbol.iterator] = function() {
            return this
        }
        ;
        return a
    }, ra = typeof Object.create == "function" ? Object.create : function(a) {
        var b = function() {};
        b.prototype = a;
        return new b
    }
    , ta;
    if (typeof Object.setPrototypeOf == "function")
        ta = Object.setPrototypeOf;
    else {
        var va;
        a: {
            var wa = {
                a: !0
            }
              , ya = {};
            try {
                ya.__proto__ = wa;
                va = ya.a;
                break a
            } catch (a) {}
            va = !1
        }
        ta = va ? function(a, b) {
            a.__proto__ = b;
            if (a.__proto__ !== b)
                throw new TypeError(a + " is not extensible");
            return a
        }
        : null
    }
    za = ta;
    _.r = function(a, b) {
        a.prototype = ra(b.prototype);
        a.prototype.constructor = a;
        if (za)
            za(a, b);
        else
            for (var c in b)
                if (c != "prototype")
                    if (Object.defineProperties) {
                        var d = Object.getOwnPropertyDescriptor(b, c);
                        d && Object.defineProperty(a, c, d)
                    } else
                        a[c] = b[c];
        a.N = b.prototype
    }
    ;
    _.Aa = function(a) {
        var b = typeof Symbol != "undefined" && Symbol.iterator && a[Symbol.iterator];
        if (b)
            return b.call(a);
        if (typeof a.length == "number")
            return {
                next: aa(a)
            };
        throw Error("b`" + String(a));
    }
    ;
    Ea = function(a, b) {
        return Object.prototype.hasOwnProperty.call(a, b)
    }
    ;
    Fa = typeof Object.assign == "function" ? Object.assign : function(a, b) {
        for (var c = 1; c < arguments.length; c++) {
            var d = arguments[c];
            if (d)
                for (var e in d)
                    Ea(d, e) && (a[e] = d[e])
        }
        return a
    }
    ;
    pa("Object.assign", function(a) {
        return a || Fa
    });
    pa("globalThis", function(a) {
        return a || _.na
    });
    pa("Promise", function(a) {
        function b() {
            this.Bf = null
        }
        function c(h) {
            return h instanceof e ? h : new e(function(k) {
                k(h)
            }
            )
        }
        if (a)
            return a;
        b.prototype.oP = function(h) {
            if (this.Bf == null) {
                this.Bf = [];
                var k = this;
                this.pP(function() {
                    k.l8()
                })
            }
            this.Bf.push(h)
        }
        ;
        var d = _.na.setTimeout;
        b.prototype.pP = function(h) {
            d(h, 0)
        }
        ;
        b.prototype.l8 = function() {
            for (; this.Bf && this.Bf.length; ) {
                var h = this.Bf;
                this.Bf = [];
                for (var k = 0; k < h.length; ++k) {
                    var l = h[k];
                    h[k] = null;
                    try {
                        l()
                    } catch (m) {
                        this.bq(m)
                    }
                }
            }
            this.Bf = null
        }
        ;
        b.prototype.bq = function(h) {
            this.pP(function() {
                throw h;
            })
        }
        ;
        var e = function(h) {
            this.Ca = 0;
            this.uf = void 0;
            this.Er = [];
            this.KV = !1;
            var k = this.rF();
            try {
                h(k.resolve, k.reject)
            } catch (l) {
                k.reject(l)
            }
        };
        e.prototype.rF = function() {
            function h(m) {
                return function(n) {
                    l || (l = !0,
                    m.call(k, n))
                }
            }
            var k = this
              , l = !1;
            return {
                resolve: h(this.tea),
                reject: h(this.fK)
            }
        }
        ;
        e.prototype.tea = function(h) {
            if (h === this)
                this.fK(new TypeError("A Promise cannot resolve to itself"));
            else if (h instanceof e)
                this.Xfa(h);
            else {
                a: switch (typeof h) {
                case "object":
                    var k = h != null;
                    break a;
                case "function":
                    k = !0;
                    break a;
                default:
                    k = !1
                }
                k ? this.sea(h) : this.LS(h)
            }
        }
        ;
        e.prototype.sea = function(h) {
            var k = void 0;
            try {
                k = h.then
            } catch (l) {
                this.fK(l);
                return
            }
            typeof k == "function" ? this.Yfa(k, h) : this.LS(h)
        }
        ;
        e.prototype.fK = function(h) {
            this.x_(2, h)
        }
        ;
        e.prototype.LS = function(h) {
            this.x_(1, h)
        }
        ;
        e.prototype.x_ = function(h, k) {
            if (this.Ca != 0)
                throw Error("c`" + h + "`" + k + "`" + this.Ca);
            this.Ca = h;
            this.uf = k;
            this.Ca === 2 && this.Iea();
            this.m8()
        }
        ;
        e.prototype.Iea = function() {
            var h = this;
            d(function() {
                if (h.Gca()) {
                    var k = _.na.console;
                    typeof k !== "undefined" && k.error(h.uf)
                }
            }, 1)
        }
        ;
        e.prototype.Gca = function() {
            if (this.KV)
                return !1;
            var h = _.na.CustomEvent
              , k = _.na.Event
              , l = _.na.dispatchEvent;
            if (typeof l === "undefined")
                return !0;
            typeof h === "function" ? h = new h("unhandledrejection",{
                cancelable: !0
            }) : typeof k === "function" ? h = new k("unhandledrejection",{
                cancelable: !0
            }) : (h = _.na.document.createEvent("CustomEvent"),
            h.initCustomEvent("unhandledrejection", !1, !0, h));
            h.promise = this;
            h.reason = this.uf;
            return l(h)
        }
        ;
        e.prototype.m8 = function() {
            if (this.Er != null) {
                for (var h = 0; h < this.Er.length; ++h)
                    f.oP(this.Er[h]);
                this.Er = null
            }
        }
        ;
        var f = new b;
        e.prototype.Xfa = function(h) {
            var k = this.rF();
            h.oy(k.resolve, k.reject)
        }
        ;
        e.prototype.Yfa = function(h, k) {
            var l = this.rF();
            try {
                h.call(k, l.resolve, l.reject)
            } catch (m) {
                l.reject(m)
            }
        }
        ;
        e.prototype.then = function(h, k) {
            function l(q, u) {
                return typeof q == "function" ? function(v) {
                    try {
                        m(q(v))
                    } catch (t) {
                        n(t)
                    }
                }
                : u
            }
            var m, n, p = new e(function(q, u) {
                m = q;
                n = u
            }
            );
            this.oy(l(h, m), l(k, n));
            return p
        }
        ;
        e.prototype.catch = function(h) {
            return this.then(void 0, h)
        }
        ;
        e.prototype.oy = function(h, k) {
            function l() {
                switch (m.Ca) {
                case 1:
                    h(m.uf);
                    break;
                case 2:
                    k(m.uf);
                    break;
                default:
                    throw Error("d`" + m.Ca);
                }
            }
            var m = this;
            this.Er == null ? f.oP(l) : this.Er.push(l);
            this.KV = !0
        }
        ;
        e.resolve = c;
        e.reject = function(h) {
            return new e(function(k, l) {
                l(h)
            }
            )
        }
        ;
        e.race = function(h) {
            return new e(function(k, l) {
                for (var m = _.Aa(h), n = m.next(); !n.done; n = m.next())
                    c(n.value).oy(k, l)
            }
            )
        }
        ;
        e.all = function(h) {
            var k = _.Aa(h)
              , l = k.next();
            return l.done ? c([]) : new e(function(m, n) {
                function p(v) {
                    return function(t) {
                        q[v] = t;
                        u--;
                        u == 0 && m(q)
                    }
                }
                var q = []
                  , u = 0;
                do
                    q.push(void 0),
                    u++,
                    c(l.value).oy(p(q.length - 1), n),
                    l = k.next();
                while (!l.done)
            }
            )
        }
        ;
        return e
    });
    var Ga = function(a, b, c) {
        if (a == null)
            throw new TypeError("The 'this' value for String.prototype." + c + " must not be null or undefined");
        if (b instanceof RegExp)
            throw new TypeError("First argument to String.prototype." + c + " must not be a regular expression");
        return a + ""
    };
    pa("String.prototype.startsWith", function(a) {
        return a ? a : function(b, c) {
            var d = Ga(this, b, "startsWith")
              , e = d.length
              , f = b.length;
            c = Math.max(0, Math.min(c | 0, d.length));
            for (var h = 0; h < f && c < e; )
                if (d[c++] != b[h++])
                    return !1;
            return h >= f
        }
    });
    pa("Symbol.dispose", function(a) {
        return a ? a : Symbol("Symbol.dispose")
    });
    pa("SuppressedError", function(a) {
        function b(c, d, e) {
            if (!(this instanceof b))
                return new b(c,d,e);
            e = Error(e);
            "stack"in e && (this.stack = e.stack);
            this.message = e.message;
            this.error = c;
            this.suppressed = d
        }
        if (a)
            return a;
        _.r(b, Error);
        b.prototype.name = "SuppressedError";
        return b
    });
    pa("WeakMap", function(a) {
        function b() {}
        function c(l) {
            var m = typeof l;
            return m === "object" && l !== null || m === "function"
        }
        function d(l) {
            if (!Ea(l, f)) {
                var m = new b;
                ea(l, f, {
                    value: m
                })
            }
        }
        function e(l) {
            var m = Object[l];
            m && (Object[l] = function(n) {
                if (n instanceof b)
                    return n;
                Object.isExtensible(n) && d(n);
                return m(n)
            }
            )
        }
        if (function() {
            if (!a || !Object.seal)
                return !1;
            try {
                var l = Object.seal({})
                  , m = Object.seal({})
                  , n = new a([[l, 2], [m, 3]]);
                if (n.get(l) != 2 || n.get(m) != 3)
                    return !1;
                n.delete(l);
                n.set(m, 4);
                return !n.has(l) && n.get(m) == 4
            } catch (p) {
                return !1
            }
        }())
            return a;
        var f = "$jscomp_hidden_" + Math.random();
        e("freeze");
        e("preventExtensions");
        e("seal");
        var h = 0
          , k = function(l) {
            this.Da = (h += Math.random() + 1).toString();
            if (l) {
                l = _.Aa(l);
                for (var m; !(m = l.next()).done; )
                    m = m.value,
                    this.set(m[0], m[1])
            }
        };
        k.prototype.set = function(l, m) {
            if (!c(l))
                throw Error("e");
            d(l);
            if (!Ea(l, f))
                throw Error("f`" + l);
            l[f][this.Da] = m;
            return this
        }
        ;
        k.prototype.get = function(l) {
            return c(l) && Ea(l, f) ? l[f][this.Da] : void 0
        }
        ;
        k.prototype.has = function(l) {
            return c(l) && Ea(l, f) && Ea(l[f], this.Da)
        }
        ;
        k.prototype.delete = function(l) {
            return c(l) && Ea(l, f) && Ea(l[f], this.Da) ? delete l[f][this.Da] : !1
        }
        ;
        return k
    });
    pa("Map", function(a) {
        if (function() {
            if (!a || typeof a != "function" || !a.prototype.entries || typeof Object.seal != "function")
                return !1;
            try {
                var k = Object.seal({
                    x: 4
                })
                  , l = new a(_.Aa([[k, "s"]]));
                if (l.get(k) != "s" || l.size != 1 || l.get({
                    x: 4
                }) || l.set({
                    x: 4
                }, "t") != l || l.size != 2)
                    return !1;
                var m = l.entries()
                  , n = m.next();
                if (n.done || n.value[0] != k || n.value[1] != "s")
                    return !1;
                n = m.next();
                return n.done || n.value[0].x != 4 || n.value[1] != "t" || !m.next().done ? !1 : !0
            } catch (p) {
                return !1
            }
        }())
            return a;
        var b = new WeakMap
          , c = function(k) {
            this[0] = {};
            this[1] = f();
            this.size = 0;
            if (k) {
                k = _.Aa(k);
                for (var l; !(l = k.next()).done; )
                    l = l.value,
                    this.set(l[0], l[1])
            }
        };
        c.prototype.set = function(k, l) {
            k = k === 0 ? 0 : k;
            var m = d(this, k);
            m.list || (m.list = this[0][m.id] = []);
            m.Xe ? m.Xe.value = l : (m.Xe = {
                next: this[1],
                Kk: this[1].Kk,
                head: this[1],
                key: k,
                value: l
            },
            m.list.push(m.Xe),
            this[1].Kk.next = m.Xe,
            this[1].Kk = m.Xe,
            this.size++);
            return this
        }
        ;
        c.prototype.delete = function(k) {
            k = d(this, k);
            return k.Xe && k.list ? (k.list.splice(k.index, 1),
            k.list.length || delete this[0][k.id],
            k.Xe.Kk.next = k.Xe.next,
            k.Xe.next.Kk = k.Xe.Kk,
            k.Xe.head = null,
            this.size--,
            !0) : !1
        }
        ;
        c.prototype.clear = function() {
            this[0] = {};
            this[1] = this[1].Kk = f();
            this.size = 0
        }
        ;
        c.prototype.has = function(k) {
            return !!d(this, k).Xe
        }
        ;
        c.prototype.get = function(k) {
            return (k = d(this, k).Xe) && k.value
        }
        ;
        c.prototype.entries = function() {
            return e(this, function(k) {
                return [k.key, k.value]
            })
        }
        ;
        c.prototype.keys = function() {
            return e(this, function(k) {
                return k.key
            })
        }
        ;
        c.prototype.values = function() {
            return e(this, function(k) {
                return k.value
            })
        }
        ;
        c.prototype.forEach = function(k, l) {
            for (var m = this.entries(), n; !(n = m.next()).done; )
                n = n.value,
                k.call(l, n[1], n[0], this)
        }
        ;
        c.prototype[Symbol.iterator] = c.prototype.entries;
        var d = function(k, l) {
            var m = l && typeof l;
            m == "object" || m == "function" ? b.has(l) ? m = b.get(l) : (m = "" + ++h,
            b.set(l, m)) : m = "p_" + l;
            var n = k[0][m];
            if (n && Ea(k[0], m))
                for (k = 0; k < n.length; k++) {
                    var p = n[k];
                    if (l !== l && p.key !== p.key || l === p.key)
                        return {
                            id: m,
                            list: n,
                            index: k,
                            Xe: p
                        }
                }
            return {
                id: m,
                list: n,
                index: -1,
                Xe: void 0
            }
        }
          , e = function(k, l) {
            var m = k[1];
            return qa(function() {
                if (m) {
                    for (; m.head != k[1]; )
                        m = m.Kk;
                    for (; m.next != m.head; )
                        return m = m.next,
                        {
                            done: !1,
                            value: l(m)
                        };
                    m = null
                }
                return {
                    done: !0,
                    value: void 0
                }
            })
        }
          , f = function() {
            var k = {};
            return k.Kk = k.next = k.head = k
        }
          , h = 0;
        return c
    });
    pa("Set", function(a) {
        if (function() {
            if (!a || typeof a != "function" || !a.prototype.entries || typeof Object.seal != "function")
                return !1;
            try {
                var c = Object.seal({
                    x: 4
                })
                  , d = new a(_.Aa([c]));
                if (!d.has(c) || d.size != 1 || d.add(c) != d || d.size != 1 || d.add({
                    x: 4
                }) != d || d.size != 2)
                    return !1;
                var e = d.entries()
                  , f = e.next();
                if (f.done || f.value[0] != c || f.value[1] != c)
                    return !1;
                f = e.next();
                return f.done || f.value[0] == c || f.value[0].x != 4 || f.value[1] != f.value[0] ? !1 : e.next().done
            } catch (h) {
                return !1
            }
        }())
            return a;
        var b = function(c) {
            this.Ra = new Map;
            if (c) {
                c = _.Aa(c);
                for (var d; !(d = c.next()).done; )
                    this.add(d.value)
            }
            this.size = this.Ra.size
        };
        b.prototype.add = function(c) {
            c = c === 0 ? 0 : c;
            this.Ra.set(c, c);
            this.size = this.Ra.size;
            return this
        }
        ;
        b.prototype.delete = function(c) {
            c = this.Ra.delete(c);
            this.size = this.Ra.size;
            return c
        }
        ;
        b.prototype.clear = function() {
            this.Ra.clear();
            this.size = 0
        }
        ;
        b.prototype.has = function(c) {
            return this.Ra.has(c)
        }
        ;
        b.prototype.entries = function() {
            return this.Ra.entries()
        }
        ;
        b.prototype.values = function() {
            return this.Ra.values()
        }
        ;
        b.prototype.keys = b.prototype.values;
        b.prototype[Symbol.iterator] = b.prototype.values;
        b.prototype.forEach = function(c, d) {
            var e = this;
            this.Ra.forEach(function(f) {
                return c.call(d, f, f, e)
            })
        }
        ;
        return b
    });
    var Oa = function(a, b) {
        a instanceof String && (a += "");
        var c = 0
          , d = !1
          , e = {
            next: function() {
                if (!d && c < a.length) {
                    var f = c++;
                    return {
                        value: b(f, a[f]),
                        done: !1
                    }
                }
                d = !0;
                return {
                    done: !0,
                    value: void 0
                }
            }
        };
        e[Symbol.iterator] = function() {
            return e
        }
        ;
        return e
    };
    pa("Array.prototype.entries", function(a) {
        return a ? a : function() {
            return Oa(this, function(b, c) {
                return [b, c]
            })
        }
    });
    pa("Array.prototype.keys", function(a) {
        return a ? a : function() {
            return Oa(this, function(b) {
                return b
            })
        }
    });
    pa("String.prototype.codePointAt", function(a) {
        return a ? a : function(b) {
            var c = Ga(this, null, "codePointAt")
              , d = c.length;
            b = Number(b) || 0;
            if (b >= 0 && b < d) {
                b |= 0;
                var e = c.charCodeAt(b);
                if (e < 55296 || e > 56319 || b + 1 === d)
                    return e;
                b = c.charCodeAt(b + 1);
                return b < 56320 || b > 57343 ? e : (e - 55296) * 1024 + b + 9216
            }
        }
    });
    pa("String.fromCodePoint", function(a) {
        return a ? a : function(b) {
            for (var c = "", d = 0; d < arguments.length; d++) {
                var e = Number(arguments[d]);
                if (e < 0 || e > 1114111 || e !== Math.floor(e))
                    throw new RangeError("invalid_code_point " + e);
                e <= 65535 ? c += String.fromCharCode(e) : (e -= 65536,
                c += String.fromCharCode(e >>> 10 & 1023 | 55296),
                c += String.fromCharCode(e & 1023 | 56320))
            }
            return c
        }
    });
    pa("Object.entries", function(a) {
        return a ? a : function(b) {
            var c = [], d;
            for (d in b)
                Ea(b, d) && c.push([d, b[d]]);
            return c
        }
    });
    pa("String.prototype.endsWith", function(a) {
        return a ? a : function(b, c) {
            var d = Ga(this, b, "endsWith");
            c === void 0 && (c = d.length);
            c = Math.max(0, Math.min(c | 0, d.length));
            for (var e = b.length; e > 0 && c > 0; )
                if (d[--c] != b[--e])
                    return !1;
            return e <= 0
        }
    });
    pa("Number.isFinite", function(a) {
        return a ? a : function(b) {
            return typeof b !== "number" ? !1 : !isNaN(b) && b !== Infinity && b !== -Infinity
        }
    });
    var Pa = function(a, b, c) {
        a instanceof String && (a = String(a));
        for (var d = a.length, e = 0; e < d; e++) {
            var f = a[e];
            if (b.call(c, f, e, a))
                return {
                    MU: e,
                    KD: f
                }
        }
        return {
            MU: -1,
            KD: void 0
        }
    };
    pa("Array.prototype.find", function(a) {
        return a ? a : function(b, c) {
            return Pa(this, b, c).KD
        }
    });
    pa("Array.prototype.values", function(a) {
        return a ? a : function() {
            return Oa(this, function(b, c) {
                return c
            })
        }
    });
    pa("Promise.prototype.finally", function(a) {
        return a ? a : function(b) {
            return this.then(function(c) {
                return Promise.resolve(b()).then(function() {
                    return c
                })
            }, function(c) {
                return Promise.resolve(b()).then(function() {
                    throw c;
                })
            })
        }
    });
    pa("Object.is", function(a) {
        return a ? a : function(b, c) {
            return b === c ? b !== 0 || 1 / b === 1 / c : b !== b && c !== c
        }
    });
    pa("Array.prototype.includes", function(a) {
        return a ? a : function(b, c) {
            var d = this;
            d instanceof String && (d = String(d));
            var e = d.length;
            c = c || 0;
            for (c < 0 && (c = Math.max(c + e, 0)); c < e; c++) {
                var f = d[c];
                if (f === b || Object.is(f, b))
                    return !0
            }
            return !1
        }
    });
    pa("String.prototype.includes", function(a) {
        return a ? a : function(b, c) {
            return Ga(this, b, "includes").indexOf(b, c || 0) !== -1
        }
    });
    pa("Array.from", function(a) {
        return a ? a : function(b, c, d) {
            c = c != null ? c : function(k) {
                return k
            }
            ;
            var e = []
              , f = typeof Symbol != "undefined" && Symbol.iterator && b[Symbol.iterator];
            if (typeof f == "function") {
                b = f.call(b);
                for (var h = 0; !(f = b.next()).done; )
                    e.push(c.call(d, f.value, h++))
            } else
                for (f = b.length,
                h = 0; h < f; h++)
                    e.push(c.call(d, b[h], h));
            return e
        }
    });
    pa("Object.values", function(a) {
        return a ? a : function(b) {
            var c = [], d;
            for (d in b)
                Ea(b, d) && c.push(b[d]);
            return c
        }
    });
    pa("Array.prototype.flat", function(a) {
        return a ? a : function(b) {
            b = b === void 0 ? 1 : b;
            var c = [];
            Array.prototype.forEach.call(this, function(d) {
                Array.isArray(d) && b > 0 ? (d = Array.prototype.flat.call(d, b - 1),
                c.push.apply(c, d)) : c.push(d)
            });
            return c
        }
    });
    pa("Number.MAX_SAFE_INTEGER", function() {
        return 9007199254740991
    });
    pa("Number.MIN_SAFE_INTEGER", function() {
        return -9007199254740991
    });
    pa("Number.isInteger", function(a) {
        return a ? a : function(b) {
            return Number.isFinite(b) ? b === Math.floor(b) : !1
        }
    });
    pa("Number.isSafeInteger", function(a) {
        return a ? a : function(b) {
            return Number.isInteger(b) && Math.abs(b) <= Number.MAX_SAFE_INTEGER
        }
    });
    pa("Array.prototype.flatMap", function(a) {
        return a ? a : function(b, c) {
            var d = [];
            Array.prototype.forEach.call(this, function(e, f) {
                e = b.call(c, e, f, this);
                Array.isArray(e) ? d.push.apply(d, e) : d.push(e)
            });
            return d
        }
    });
    pa("Math.imul", function(a) {
        return a ? a : function(b, c) {
            b = Number(b);
            c = Number(c);
            var d = b & 65535
              , e = c & 65535;
            return d * e + ((b >>> 16 & 65535) * e + d * (c >>> 16 & 65535) << 16 >>> 0) | 0
        }
    });
    pa("Math.trunc", function(a) {
        return a ? a : function(b) {
            b = Number(b);
            if (isNaN(b) || b === Infinity || b === -Infinity || b === 0)
                return b;
            var c = Math.floor(Math.abs(b));
            return b < 0 ? -c : c
        }
    });
    pa("Number.isNaN", function(a) {
        return a ? a : function(b) {
            return typeof b === "number" && isNaN(b)
        }
    });
    pa("String.prototype.replaceAll", function(a) {
        return a ? a : function(b, c) {
            if (b instanceof RegExp && !b.global)
                throw new TypeError("String.prototype.replaceAll called with a non-global RegExp argument.");
            return b instanceof RegExp ? this.replace(b, c) : this.replace(new RegExp(String(b).replace(/([-()\[\]{}+?*.$\^|,:#<!\\])/g, "\\$1").replace(/\x08/g, "\\x08"),"g"), c)
        }
    });
    var Sa = function(a) {
        a = Math.trunc(a) || 0;
        a < 0 && (a += this.length);
        if (!(a < 0 || a >= this.length))
            return this[a]
    };
    pa("Array.prototype.at", function(a) {
        return a ? a : Sa
    });
    var Xa = function(a) {
        return a ? a : Sa
    };
    pa("Int8Array.prototype.at", Xa);
    pa("Uint8Array.prototype.at", Xa);
    pa("Uint8ClampedArray.prototype.at", Xa);
    pa("Int16Array.prototype.at", Xa);
    pa("Uint16Array.prototype.at", Xa);
    pa("Int32Array.prototype.at", Xa);
    pa("Uint32Array.prototype.at", Xa);
    pa("Float32Array.prototype.at", Xa);
    pa("Float64Array.prototype.at", Xa);
    pa("String.prototype.at", function(a) {
        return a ? a : Sa
    });
    pa("Array.prototype.findIndex", function(a) {
        return a ? a : function(b, c) {
            return Pa(this, b, c).MU
        }
    });
    _.Ya = {};
    /*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
    _.Za = _.Za || {};
    _.ab = this || self;
    _.bb = _.ab._F_toggles || [];
    _.cb = "closure_uid_" + (Math.random() * 1E9 >>> 0);
    _.fb = function(a, b) {
        var c = Array.prototype.slice.call(arguments, 1);
        return function() {
            var d = c.slice();
            d.push.apply(d, arguments);
            return a.apply(this, d)
        }
    }
    ;
    _.A = function(a, b) {
        a = a.split(".");
        for (var c = _.ab, d; a.length && (d = a.shift()); )
            a.length || b === void 0 ? c = c[d] && c[d] !== Object.prototype[d] ? c[d] : c[d] = {} : c[d] = b
    }
    ;
    _.hb = function(a, b) {
        function c() {}
        c.prototype = b.prototype;
        a.N = b.prototype;
        a.prototype = new c;
        a.prototype.constructor = a;
        a.it = function(d, e, f) {
            for (var h = Array(arguments.length - 2), k = 2; k < arguments.length; k++)
                h[k - 2] = arguments[k];
            return b.prototype[e].apply(d, h)
        }
    }
    ;
    _.ib = window.osapi = window.osapi || {};
    window.___jsl = window.___jsl || {};
    (window.___jsl.cd = window.___jsl.cd || []).push({
        gwidget: {
            parsetags: "explicit"
        },
        appsapi: {
            plus_one_service: "/plus/v1"
        },
        csi: {
            rate: .01
        },
        poshare: {
            hangoutContactPickerServer: "https://plus.google.com"
        },
        gappsutil: {
            required_scopes: ["https://www.googleapis.com/auth/plus.me", "https://www.googleapis.com/auth/plus.people.recommended"],
            display_on_page_ready: !1
        },
        appsutil: {
            required_scopes: ["https://www.googleapis.com/auth/plus.me", "https://www.googleapis.com/auth/plus.people.recommended"],
            display_on_page_ready: !1
        },
        "oauth-flow": {
            authUrl: "https://accounts.google.com/o/oauth2/auth",
            proxyUrl: "https://accounts.google.com/o/oauth2/postmessageRelay",
            redirectUri: "postmessage"
        },
        iframes: {
            sharebox: {
                params: {
                    json: "&"
                },
                url: ":socialhost:/:session_prefix:_/sharebox/dialog"
            },
            plus: {
                url: ":socialhost:/:session_prefix:_/widget/render/badge?usegapi=1"
            },
            ":socialhost:": "https://apis.google.com",
            ":im_socialhost:": "https://plus.googleapis.com",
            domains_suggest: {
                url: "https://domains.google.com/suggest/flow"
            },
            card: {
                params: {
                    s: "#",
                    userid: "&"
                },
                url: ":socialhost:/:session_prefix:_/hovercard/internalcard"
            },
            ":signuphost:": "https://plus.google.com",
            ":gplus_url:": "https://plus.google.com",
            plusone: {
                url: ":socialhost:/:session_prefix:_/+1/fastbutton?usegapi=1"
            },
            plus_share: {
                url: ":socialhost:/:session_prefix:_/+1/sharebutton?plusShare=true&usegapi=1"
            },
            plus_circle: {
                url: ":socialhost:/:session_prefix:_/widget/plus/circle?usegapi=1"
            },
            plus_followers: {
                url: ":socialhost:/_/im/_/widget/render/plus/followers?usegapi=1"
            },
            configurator: {
                url: ":socialhost:/:session_prefix:_/plusbuttonconfigurator?usegapi=1"
            },
            appcirclepicker: {
                url: ":socialhost:/:session_prefix:_/widget/render/appcirclepicker"
            },
            page: {
                url: ":socialhost:/:session_prefix:_/widget/render/page?usegapi=1"
            },
            person: {
                url: ":socialhost:/:session_prefix:_/widget/render/person?usegapi=1"
            },
            community: {
                url: ":ctx_socialhost:/:session_prefix::im_prefix:_/widget/render/community?usegapi=1"
            },
            follow: {
                url: ":socialhost:/:session_prefix:_/widget/render/follow?usegapi=1"
            },
            commentcount: {
                url: ":socialhost:/:session_prefix:_/widget/render/commentcount?usegapi=1"
            },
            comments: {
                url: ":socialhost:/:session_prefix:_/widget/render/comments?usegapi=1"
            },
            blogger: {
                url: ":socialhost:/:session_prefix:_/widget/render/blogger?usegapi=1"
            },
            youtube: {
                url: ":socialhost:/:session_prefix:_/widget/render/youtube?usegapi=1"
            },
            reportabuse: {
                url: ":socialhost:/:session_prefix:_/widget/render/reportabuse?usegapi=1"
            },
            additnow: {
                url: ":socialhost:/additnow/additnow.html"
            },
            appfinder: {
                url: "https://workspace.google.com/:session_prefix:marketplace/appfinder?usegapi=1"
            },
            ":source:": "1p"
        },
        poclient: {
            update_session: "google.updateSessionCallback"
        },
        "googleapis.config": {
            rpc: "/rpc",
            root: "https://content.googleapis.com",
            "root-1p": "https://clients6.google.com",
            useGapiForXd3: !0,
            xd3: "/static/proxy.html",
            auth: {
                useInterimAuth: !1
            }
        },
        report: {
            apis: ["iframes\\..*", "gadgets\\..*", "gapi\\.appcirclepicker\\..*", "gapi\\.client\\..*"],
            rate: 1E-4
        },
        client: {
            perApiBatch: !0
        },
        gen204logger: {
            interval: 3E4,
            rate: .001,
            batch: !1
        }
    });
    var mb;
    _.kb = function(a) {
        return function() {
            return _.jb[a].apply(this, arguments)
        }
    }
    ;
    _.lb = function(a, b) {
        if (Error.captureStackTrace)
            Error.captureStackTrace(this, _.lb);
        else {
            var c = Error().stack;
            c && (this.stack = c)
        }
        a && (this.message = String(a));
        b !== void 0 && (this.cause = b);
        this.TY = !0
    }
    ;
    mb = function(a, b) {
        a = a.split("%s");
        for (var c = "", d = a.length - 1, e = 0; e < d; e++)
            c += a[e] + (e < b.length ? b[e] : "%s");
        _.lb.call(this, c + a[d])
    }
    ;
    _.jb = [];
    _.hb(_.lb, Error);
    _.lb.prototype.name = "CustomError";
    _.hb(mb, _.lb);
    mb.prototype.name = "AssertionError";
    var yb, zb, Ab;
    _.nb = function(a, b) {
        return _.jb[a] = b
    }
    ;
    _.ob = function(a, b) {
        throw Error(b === void 0 ? "unexpected value " + a + "!" : b);
    }
    ;
    _.ub = function(a, b) {
        return (0,
        _.qb)(a, b) >= 0
    }
    ;
    _.vb = function(a) {
        var b = [], c = 0, d;
        for (d in a)
            b[c++] = a[d];
        return b
    }
    ;
    _.wb = function(a) {
        var b = typeof a;
        return b == "object" && a != null || b == "function"
    }
    ;
    _.xb = function(a, b) {
        a = a.split(".");
        b = b || _.ab;
        for (var c = 0; c < a.length; c++)
            if (b = b[a[c]],
            b == null)
                return null;
        return b
    }
    ;
    yb = function(a) {
        var b = _.xb("WIZ_global_data.oxN3nb");
        a = b && b[a];
        return a != null ? a : !1
    }
    ;
    zb = function(a, b, c) {
        return a.call.apply(a.bind, arguments)
    }
    ;
    Ab = function(a, b, c) {
        if (!a)
            throw Error();
        if (arguments.length > 2) {
            var d = Array.prototype.slice.call(arguments, 2);
            return function() {
                var e = Array.prototype.slice.call(arguments);
                Array.prototype.unshift.apply(e, d);
                return a.apply(b, e)
            }
        }
        return function() {
            return a.apply(b, arguments)
        }
    }
    ;
    _.B = function(a, b, c) {
        _.B = Function.prototype.bind && Function.prototype.bind.toString().indexOf("native code") != -1 ? zb : Ab;
        return _.B.apply(null, arguments)
    }
    ;
    _.qb = Array.prototype.indexOf ? function(a, b) {
        return Array.prototype.indexOf.call(a, b, void 0)
    }
    : function(a, b) {
        if (typeof a === "string")
            return typeof b !== "string" || b.length != 1 ? -1 : a.indexOf(b, 0);
        for (var c = 0; c < a.length; c++)
            if (c in a && a[c] === b)
                return c;
        return -1
    }
    ;
    _.Bb = Array.prototype.lastIndexOf ? function(a, b) {
        return Array.prototype.lastIndexOf.call(a, b, a.length - 1)
    }
    : function(a, b) {
        var c = a.length - 1;
        c < 0 && (c = Math.max(0, a.length + c));
        if (typeof a === "string")
            return typeof b !== "string" || b.length != 1 ? -1 : a.lastIndexOf(b, c);
        for (; c >= 0; c--)
            if (c in a && a[c] === b)
                return c;
        return -1
    }
    ;
    _.Db = Array.prototype.forEach ? function(a, b, c) {
        Array.prototype.forEach.call(a, b, c)
    }
    : function(a, b, c) {
        for (var d = a.length, e = typeof a === "string" ? a.split("") : a, f = 0; f < d; f++)
            f in e && b.call(c, e[f], f, a)
    }
    ;
    _.Fb = Array.prototype.filter ? function(a, b) {
        return Array.prototype.filter.call(a, b, void 0)
    }
    : function(a, b) {
        for (var c = a.length, d = [], e = 0, f = typeof a === "string" ? a.split("") : a, h = 0; h < c; h++)
            if (h in f) {
                var k = f[h];
                b.call(void 0, k, h, a) && (d[e++] = k)
            }
        return d
    }
    ;
    _.Gb = Array.prototype.map ? function(a, b, c) {
        return Array.prototype.map.call(a, b, c)
    }
    : function(a, b, c) {
        for (var d = a.length, e = Array(d), f = typeof a === "string" ? a.split("") : a, h = 0; h < d; h++)
            h in f && (e[h] = b.call(c, f[h], h, a));
        return e
    }
    ;
    _.Jb = Array.prototype.some ? function(a, b, c) {
        return Array.prototype.some.call(a, b, c)
    }
    : function(a, b, c) {
        for (var d = a.length, e = typeof a === "string" ? a.split("") : a, f = 0; f < d; f++)
            if (f in e && b.call(c, e[f], f, a))
                return !0;
        return !1
    }
    ;
    _.Kb = Array.prototype.every ? function(a, b, c) {
        return Array.prototype.every.call(a, b, c)
    }
    : function(a, b, c) {
        for (var d = a.length, e = typeof a === "string" ? a.split("") : a, f = 0; f < d; f++)
            if (f in e && !b.call(c, e[f], f, a))
                return !1;
        return !0
    }
    ;
    var Lb = !!(_.bb[0] & 512)
      , Mb = !!(_.bb[0] & 1024)
      , Nb = !!(_.bb[0] & 2048);
    _.Ob = Lb ? Mb : yb(610401301);
    _.Pb = Lb ? Nb : yb(651175828);
    _.Qb = function(a) {
        _.Qb[" "](a);
        return a
    }
    ;
    _.Qb[" "] = function() {}
    ;
    /*

 Copyright Google LLC
 SPDX-License-Identifier: Apache-2.0
*/
    var Wb, Yb, kc, wc, Gc, Tc, dd;
    _.Rb = function(a) {
        var b = a.length;
        if (b > 0) {
            for (var c = Array(b), d = 0; d < b; d++)
                c[d] = a[d];
            return c
        }
        return []
    }
    ;
    _.Sb = function(a, b, c) {
        for (var d in a)
            b.call(c, a[d], d, a)
    }
    ;
    Wb = function() {
        var a = null;
        if (!Vb)
            return a;
        try {
            var b = function(c) {
                return c
            };
            a = Vb.createPolicy("gapi#html", {
                createHTML: b,
                createScript: b,
                createScriptURL: b
            })
        } catch (c) {}
        return a
    }
    ;
    Yb = function() {
        Xb === void 0 && (Xb = Wb());
        return Xb
    }
    ;
    _.$b = function(a) {
        var b = Yb();
        return new _.Zb(b ? b.createHTML(a) : a)
    }
    ;
    _.ac = function(a) {
        if (a instanceof _.Zb)
            return a.sY;
        throw Error("j");
    }
    ;
    _.cc = function(a) {
        return new _.bc(a)
    }
    ;
    _.ec = function(a) {
        var b = Yb();
        return new _.dc(b ? b.createScriptURL(a) : a)
    }
    ;
    _.fc = function(a) {
        if (a instanceof _.dc)
            return a.tY;
        throw Error("j");
    }
    ;
    _.hc = function(a) {
        return a instanceof _.gc
    }
    ;
    _.ic = function(a) {
        if (_.hc(a))
            return a.vY;
        throw Error("j");
    }
    ;
    kc = function(a) {
        return new _.jc(function(b) {
            return b.substr(0, a.length + 1).toLowerCase() === a + ":"
        }
        )
    }
    ;
    _.mc = function(a) {
        if (lc.test(a))
            return a
    }
    ;
    _.nc = function(a) {
        return a instanceof _.gc ? _.ic(a) : _.mc(a)
    }
    ;
    _.oc = function(a, b) {
        if (a instanceof _.Zb)
            return a;
        a = String(a).replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&apos;");
        if (b == null ? 0 : b.Ara)
            a = a.replace(/(^|[\r\n\t ]) /g, "$1&#160;");
        if (b == null ? 0 : b.Ida)
            a = a.replace(/(\r\n|\n|\r)/g, "<br>");
        if (b == null ? 0 : b.Bra)
            a = a.replace(/(\t+)/g, '<span style="white-space:pre">$1</span>');
        return _.$b(a)
    }
    ;
    _.qc = function(a) {
        var b = _.pc.apply(1, arguments);
        if (b.length === 0)
            return _.ec(a[0]);
        for (var c = a[0], d = 0; d < b.length; d++)
            c += encodeURIComponent(b[d]) + a[d + 1];
        return _.ec(c)
    }
    ;
    _.sc = function(a, b) {
        return a.lastIndexOf(b, 0) == 0
    }
    ;
    _.tc = function(a) {
        return /^[\s\xa0]*$/.test(a)
    }
    ;
    _.uc = function(a, b) {
        return a.indexOf(b) != -1
    }
    ;
    _.xc = function(a, b) {
        var c = 0;
        a = (0,
        _.vc)(String(a)).split(".");
        b = (0,
        _.vc)(String(b)).split(".");
        for (var d = Math.max(a.length, b.length), e = 0; c == 0 && e < d; e++) {
            var f = a[e] || ""
              , h = b[e] || "";
            do {
                f = /(\d*)(\D*)(.*)/.exec(f) || ["", "", "", ""];
                h = /(\d*)(\D*)(.*)/.exec(h) || ["", "", "", ""];
                if (f[0].length == 0 && h[0].length == 0)
                    break;
                c = wc(f[1].length == 0 ? 0 : parseInt(f[1], 10), h[1].length == 0 ? 0 : parseInt(h[1], 10)) || wc(f[2].length == 0, h[2].length == 0) || wc(f[2], h[2]);
                f = f[3];
                h = h[3]
            } while (c == 0)
        }
        return c
    }
    ;
    wc = function(a, b) {
        return a < b ? -1 : a > b ? 1 : 0
    }
    ;
    _.yc = function(a, b) {
        b = _.nc(b);
        b !== void 0 && (a.href = b)
    }
    ;
    _.Ac = function(a, b, c, d) {
        b = _.nc(b);
        return b !== void 0 ? a.open(b, c, d) : null
    }
    ;
    _.Bc = function(a, b) {
        b = b === void 0 ? document : b;
        var c, d;
        b = (d = (c = b).querySelector) == null ? void 0 : d.call(c, a + "[nonce]");
        return b == null ? "" : b.nonce || b.getAttribute("nonce") || ""
    }
    ;
    _.Cc = function(a, b) {
        a.src = _.fc(b);
        (b = _.Bc("script", a.ownerDocument)) && a.setAttribute("nonce", b)
    }
    ;
    _.Dc = function(a, b) {
        if (a.nodeType === 1 && /^(script|style)$/i.test(a.tagName))
            throw Error("j");
        a.innerHTML = _.ac(b)
    }
    ;
    _.Ec = function() {
        var a = _.ab.navigator;
        return a && (a = a.userAgent) ? a : ""
    }
    ;
    Gc = function(a) {
        return _.Ob ? _.Fc ? _.Fc.brands.some(function(b) {
            return (b = b.brand) && _.uc(b, a)
        }) : !1 : !1
    }
    ;
    _.Hc = function(a) {
        return _.uc(_.Ec(), a)
    }
    ;
    _.Ic = function(a) {
        for (var b = RegExp("([A-Z][\\w ]+)/([^\\s]+)\\s*(?:\\((.*?)\\))?", "g"), c = [], d; d = b.exec(a); )
            c.push([d[1], d[2], d[3] || void 0]);
        return c
    }
    ;
    _.Jc = function() {
        return _.Ob ? !!_.Fc && _.Fc.brands.length > 0 : !1
    }
    ;
    _.Kc = function() {
        return _.Jc() ? !1 : _.Hc("Opera")
    }
    ;
    _.Lc = function() {
        return _.Jc() ? !1 : _.Hc("Trident") || _.Hc("MSIE")
    }
    ;
    _.Mc = function() {
        return _.Jc() ? !1 : _.Hc("Edge")
    }
    ;
    _.Oc = function() {
        return _.Jc() ? Gc("Microsoft Edge") : _.Hc("Edg/")
    }
    ;
    _.Pc = function() {
        return _.Jc() ? Gc("Opera") : _.Hc("OPR")
    }
    ;
    _.Qc = function() {
        return _.Jc() ? Gc("Chromium") : (_.Hc("Chrome") || _.Hc("CriOS")) && !_.Mc() || _.Hc("Silk")
    }
    ;
    _.Rc = function(a) {
        var b = {};
        a.forEach(function(c) {
            b[c[0]] = c[1]
        });
        return function(c) {
            return b[c.find(function(d) {
                return d in b
            })] || ""
        }
    }
    ;
    _.Sc = function(a) {
        var b = /rv: *([\d\.]*)/.exec(a);
        if (b && b[1])
            return b[1];
        b = "";
        var c = /MSIE +([\d\.]+)/.exec(a);
        if (c && c[1])
            if (a = /Trident\/(\d.\d)/.exec(a),
            c[1] == "7.0")
                if (a && a[1])
                    switch (a[1]) {
                    case "4.0":
                        b = "8.0";
                        break;
                    case "5.0":
                        b = "9.0";
                        break;
                    case "6.0":
                        b = "10.0";
                        break;
                    case "7.0":
                        b = "11.0"
                    }
                else
                    b = "7.0";
            else
                b = c[1];
        return b
    }
    ;
    Tc = function() {
        return _.Ob ? !!_.Fc && !!_.Fc.platform : !1
    }
    ;
    _.Uc = function() {
        return Tc() ? _.Fc.platform === "Android" : _.Hc("Android")
    }
    ;
    _.Wc = function() {
        return _.Hc("iPhone") && !_.Hc("iPod") && !_.Hc("iPad")
    }
    ;
    _.Xc = function() {
        return _.Wc() || _.Hc("iPad") || _.Hc("iPod")
    }
    ;
    _.Yc = function() {
        return Tc() ? _.Fc.platform === "macOS" : _.Hc("Macintosh")
    }
    ;
    _.Zc = function() {
        return Tc() ? _.Fc.platform === "Windows" : _.Hc("Windows")
    }
    ;
    _.$c = function() {
        return Tc() ? _.Fc.platform === "Chrome OS" : _.Hc("CrOS")
    }
    ;
    _.ad = function(a, b) {
        a.raw = b;
        Object.freeze && (Object.freeze(a),
        Object.freeze(b));
        return a
    }
    ;
    _.cd = function(a) {
        return _.ad(a, a)
    }
    ;
    _.pc = function() {
        for (var a = Number(this), b = [], c = a; c < arguments.length; c++)
            b[c - a] = arguments[c];
        return b
    }
    ;
    _.ed = function(a) {
        var b = typeof a;
        return b != "object" ? b : a ? Array.isArray(a) ? "array" : b : "null"
    }
    ;
    _.fd = function(a) {
        var b = _.ed(a);
        return b == "array" || b == "object" && typeof a.length == "number"
    }
    ;
    _.gd = function() {
        return Date.now()
    }
    ;
    var hd = globalThis.trustedTypes, Vb = hd, Xb;
    _.Zb = function(a) {
        this.sY = a
    }
    ;
    _.Zb.prototype.toString = function() {
        return this.sY + ""
    }
    ;
    _.id = function() {
        return new _.Zb(hd ? hd.emptyHTML : "")
    }();
    _.bc = function(a) {
        this.uY = a
    }
    ;
    _.bc.prototype.toString = function() {
        return this.uY
    }
    ;
    _.dc = function(a) {
        this.tY = a
    }
    ;
    _.dc.prototype.toString = function() {
        return this.tY + ""
    }
    ;
    _.gc = function(a) {
        this.vY = a
    }
    ;
    _.gc.prototype.toString = function() {
        return this.vY
    }
    ;
    _.jd = new _.gc("about:invalid#zClosurez");
    var lc;
    _.jc = function(a) {
        this.tj = a
    }
    ;
    _.kd = [kc("data"), kc("http"), kc("https"), kc("mailto"), kc("ftp"), new _.jc(function(a) {
        return /^[^:]*([/?#]|$)/.test(a)
    }
    )];
    _.ld = function() {
        return typeof URL === "function"
    }();
    lc = /^\s*(?!javascript:)(?:[\w+.-]+:|[^:/?#]*(?:[/?#]|$))/i;
    _.md = function(a, b) {
        this.width = a;
        this.height = b
    }
    ;
    _.nd = function(a, b) {
        return a == b ? !0 : a && b ? a.width == b.width && a.height == b.height : !1
    }
    ;
    _.g = _.md.prototype;
    _.g.clone = function() {
        return new _.md(this.width,this.height)
    }
    ;
    _.g.Tx = function() {
        return this.width * this.height
    }
    ;
    _.g.aspectRatio = function() {
        return this.width / this.height
    }
    ;
    _.g.isEmpty = function() {
        return !this.Tx()
    }
    ;
    _.g.ceil = function() {
        this.width = Math.ceil(this.width);
        this.height = Math.ceil(this.height);
        return this
    }
    ;
    _.g.floor = function() {
        this.width = Math.floor(this.width);
        this.height = Math.floor(this.height);
        return this
    }
    ;
    _.g.round = function() {
        this.width = Math.round(this.width);
        this.height = Math.round(this.height);
        return this
    }
    ;
    _.g.scale = function(a, b) {
        this.width *= a;
        this.height *= typeof b === "number" ? b : a;
        return this
    }
    ;
    _.vc = String.prototype.trim ? function(a) {
        return a.trim()
    }
    : function(a) {
        return /^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]
    }
    ;
    _.od = String.prototype.repeat ? function(a, b) {
        return a.repeat(b)
    }
    : function(a, b) {
        return Array(b + 1).join(a)
    }
    ;
    _.pd = Math.random() * 2147483648 | 0;
    var qd;
    qd = _.ab.navigator;
    _.Fc = qd ? qd.userAgentData || null : null;
    var Id, Jd, Pd;
    _.sd = _.Kc();
    _.td = _.Lc();
    _.ud = _.Hc("Edge");
    _.vd = _.ud || _.td;
    _.wd = _.Hc("Gecko") && !(_.uc(_.Ec().toLowerCase(), "webkit") && !_.Hc("Edge")) && !(_.Hc("Trident") || _.Hc("MSIE")) && !_.Hc("Edge");
    _.xd = _.uc(_.Ec().toLowerCase(), "webkit") && !_.Hc("Edge");
    _.yd = _.xd && _.Hc("Mobile");
    _.zd = _.Yc();
    _.Ad = _.Zc();
    _.Bd = (Tc() ? _.Fc.platform === "Linux" : _.Hc("Linux")) || _.$c();
    _.Cd = _.Uc();
    _.Ed = _.Wc();
    _.Fd = _.Hc("iPad");
    _.Gd = _.Hc("iPod");
    _.Hd = _.Xc();
    Id = function() {
        var a = _.ab.document;
        return a ? a.documentMode : void 0
    }
    ;
    a: {
        var Kd = ""
          , Ld = function() {
            var a = _.Ec();
            if (_.wd)
                return /rv:([^\);]+)(\)|;)/.exec(a);
            if (_.ud)
                return /Edge\/([\d\.]+)/.exec(a);
            if (_.td)
                return /\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);
            if (_.xd)
                return /WebKit\/(\S+)/.exec(a);
            if (_.sd)
                return /(?:Version)[ \/]?(\S+)/.exec(a)
        }();
        Ld && (Kd = Ld ? Ld[1] : "");
        if (_.td) {
            var Md = Id();
            if (Md != null && Md > parseFloat(Kd)) {
                Jd = String(Md);
                break a
            }
        }
        Jd = Kd
    }
    _.Od = Jd;
    if (_.ab.document && _.td) {
        var Qd = Id();
        Pd = Qd ? Qd : parseInt(_.Od, 10) || void 0
    } else
        Pd = void 0;
    _.Rd = Pd;
    var Wd, ce, be;
    _.Ud = function(a) {
        return a ? new _.Sd(_.Td(a)) : dd || (dd = new _.Sd)
    }
    ;
    _.Vd = function(a, b, c, d) {
        a = d || a;
        return (b = b && b != "*" ? String(b).toUpperCase() : "") || c ? a.querySelectorAll(b + (c ? "." + c : "")) : a.getElementsByTagName("*")
    }
    ;
    _.Xd = function(a, b) {
        _.Sb(b, function(c, d) {
            d == "style" ? a.style.cssText = c : d == "class" ? a.className = c : d == "for" ? a.htmlFor = c : Wd.hasOwnProperty(d) ? a.setAttribute(Wd[d], c) : _.sc(d, "aria-") || _.sc(d, "data-") ? a.setAttribute(d, c) : a[d] = c
        })
    }
    ;
    Wd = {
        cellpadding: "cellPadding",
        cellspacing: "cellSpacing",
        colspan: "colSpan",
        frameborder: "frameBorder",
        height: "height",
        maxlength: "maxLength",
        nonce: "nonce",
        role: "role",
        rowspan: "rowSpan",
        type: "type",
        usemap: "useMap",
        valign: "vAlign",
        width: "width"
    };
    _.Zd = function(a) {
        return _.Yd(a || window)
    }
    ;
    _.Yd = function(a) {
        a = a.document;
        a = _.$d(a) ? a.documentElement : a.body;
        return new _.md(a.clientWidth,a.clientHeight)
    }
    ;
    _.ae = function(a) {
        return a ? a.defaultView : window
    }
    ;
    _.de = function(a, b) {
        var c = b[1]
          , d = be(a, String(b[0]));
        c && (typeof c === "string" ? d.className = c : Array.isArray(c) ? d.className = c.join(" ") : _.Xd(d, c));
        b.length > 2 && ce(a, d, b, 2);
        return d
    }
    ;
    ce = function(a, b, c, d) {
        function e(k) {
            k && b.appendChild(typeof k === "string" ? a.createTextNode(k) : k)
        }
        for (; d < c.length; d++) {
            var f = c[d];
            if (!_.fd(f) || _.wb(f) && f.nodeType > 0)
                e(f);
            else {
                a: {
                    if (f && typeof f.length == "number") {
                        if (_.wb(f)) {
                            var h = typeof f.item == "function" || typeof f.item == "string";
                            break a
                        }
                        if (typeof f === "function") {
                            h = typeof f.item == "function";
                            break a
                        }
                    }
                    h = !1
                }
                _.Db(h ? _.Rb(f) : f, e)
            }
        }
    }
    ;
    _.ee = function(a) {
        return be(document, a)
    }
    ;
    be = function(a, b) {
        b = String(b);
        a.contentType === "application/xhtml+xml" && (b = b.toLowerCase());
        return a.createElement(b)
    }
    ;
    _.$d = function(a) {
        return a.compatMode == "CSS1Compat"
    }
    ;
    _.fe = function(a) {
        if (a.nodeType != 1)
            return !1;
        switch (a.tagName) {
        case "APPLET":
        case "AREA":
        case "BASE":
        case "BR":
        case "COL":
        case "COMMAND":
        case "EMBED":
        case "FRAME":
        case "HR":
        case "IMG":
        case "INPUT":
        case "IFRAME":
        case "ISINDEX":
        case "KEYGEN":
        case "LINK":
        case "NOFRAMES":
        case "NOSCRIPT":
        case "META":
        case "OBJECT":
        case "PARAM":
        case "SCRIPT":
        case "SOURCE":
        case "STYLE":
        case "TRACK":
        case "WBR":
            return !1
        }
        return !0
    }
    ;
    _.ge = function(a, b) {
        ce(_.Td(a), a, arguments, 1)
    }
    ;
    _.he = function(a) {
        for (var b; b = a.firstChild; )
            a.removeChild(b)
    }
    ;
    _.je = function(a, b) {
        b.parentNode && b.parentNode.insertBefore(a, b)
    }
    ;
    _.ke = function(a) {
        return a && a.parentNode ? a.parentNode.removeChild(a) : null
    }
    ;
    _.le = function(a) {
        return a.children != void 0 ? a.children : Array.prototype.filter.call(a.childNodes, function(b) {
            return b.nodeType == 1
        })
    }
    ;
    _.me = function(a) {
        return _.wb(a) && a.nodeType == 1
    }
    ;
    _.ne = function(a, b) {
        if (!a || !b)
            return !1;
        if (a.contains && b.nodeType == 1)
            return a == b || a.contains(b);
        if (typeof a.compareDocumentPosition != "undefined")
            return a == b || !!(a.compareDocumentPosition(b) & 16);
        for (; b && a != b; )
            b = b.parentNode;
        return b == a
    }
    ;
    _.Td = function(a) {
        return a.nodeType == 9 ? a : a.ownerDocument || a.document
    }
    ;
    _.oe = function(a, b) {
        if ("textContent"in a)
            a.textContent = b;
        else if (a.nodeType == 3)
            a.data = String(b);
        else if (a.firstChild && a.firstChild.nodeType == 3) {
            for (; a.lastChild != a.firstChild; )
                a.removeChild(a.lastChild);
            a.firstChild.data = String(b)
        } else
            _.he(a),
            a.appendChild(_.Td(a).createTextNode(String(b)))
    }
    ;
    _.Sd = function(a) {
        this.Nb = a || _.ab.document || document
    }
    ;
    _.g = _.Sd.prototype;
    _.g.Ga = _.Ud;
    _.g.kL = _.kb(0);
    _.g.ub = function() {
        return this.Nb
    }
    ;
    _.g.O = _.kb(1);
    _.g.getElementsByTagName = function(a, b) {
        return (b || this.Nb).getElementsByTagName(String(a))
    }
    ;
    _.g.iH = _.kb(2);
    _.g.va = function(a, b, c) {
        return _.de(this.Nb, arguments)
    }
    ;
    _.g.createElement = function(a) {
        return be(this.Nb, a)
    }
    ;
    _.g.createTextNode = function(a) {
        return this.Nb.createTextNode(String(a))
    }
    ;
    _.g.getWindow = function() {
        return this.Nb.defaultView
    }
    ;
    _.g.appendChild = function(a, b) {
        a.appendChild(b)
    }
    ;
    _.g.append = _.ge;
    _.g.canHaveChildren = _.fe;
    _.g.re = _.he;
    _.g.iV = _.je;
    _.g.removeNode = _.ke;
    _.g.tG = _.le;
    _.g.isElement = _.me;
    _.g.contains = _.ne;
    _.g.LG = _.Td;
    _.g.oj = _.kb(3);
    /*
 gapi.loader.OBJECT_CREATE_TEST_OVERRIDE &&*/
    _.pe = function(a) {
        return a === null ? "null" : a === void 0 ? "undefined" : a
    }
    ;
    _.qe = window;
    _.re = document;
    _.te = _.qe.location;
    _.ue = /\[native code\]/;
    _.ve = function(a, b, c) {
        return a[b] = a[b] || c
    }
    ;
    _.we = function() {
        var a;
        if ((a = Object.create) && _.ue.test(a))
            a = a(null);
        else {
            a = {};
            for (var b in a)
                a[b] = void 0
        }
        return a
    }
    ;
    _.xe = function(a, b) {
        return Object.prototype.hasOwnProperty.call(a, b)
    }
    ;
    _.ye = function(a, b) {
        a = a || {};
        for (var c in a)
            _.xe(a, c) && (b[c] = a[c])
    }
    ;
    _.ze = _.ve(_.qe, "gapi", {});
    _.Ae = function(a, b, c) {
        var d = new RegExp("([#].*&|[#])" + b + "=([^&#]*)","g");
        b = new RegExp("([?#].*&|[?#])" + b + "=([^&#]*)","g");
        if (a = a && (d.exec(a) || b.exec(a)))
            try {
                c = decodeURIComponent(a[2])
            } catch (e) {}
        return c
    }
    ;
    _.Be = new RegExp(/^/.source + /([a-zA-Z][-+.a-zA-Z0-9]*:)?/.source + /(\/\/[^\/?#]*)?/.source + /([^?#]*)?/.source + /(\?([^#]*))?/.source + /(#((#|[^#])*))?/.source + /$/.source);
    _.Ce = new RegExp(/(%([^0-9a-fA-F%]|[0-9a-fA-F]([^0-9a-fA-F%])?)?)*/.source + /%($|[^0-9a-fA-F]|[0-9a-fA-F]($|[^0-9a-fA-F]))/.source,"g");
    _.De = new RegExp(/\/?\??#?/.source + "(" + /[\/?#]/i.source + "|" + /[\uD800-\uDBFF]/i.source + "|" + /%[c-f][0-9a-f](%[89ab][0-9a-f]){0,2}(%[89ab]?)?/i.source + "|" + /%[0-9a-f]?/i.source + ")$","i");
    _.Fe = function(a, b, c) {
        _.Ee(a, b, c, "add", "at")
    }
    ;
    _.Ee = function(a, b, c, d, e) {
        if (a[d + "EventListener"])
            a[d + "EventListener"](b, c, !1);
        else if (a[e + "tachEvent"])
            a[e + "tachEvent"]("on" + b, c)
    }
    ;
    _.Ge = {};
    _.Ge = _.ve(_.qe, "___jsl", _.we());
    _.ve(_.Ge, "I", 0);
    _.ve(_.Ge, "hel", 10);
    var He, Ie, Je, Ke, Ne, Le, Me, Oe, Pe;
    He = function(a) {
        var b = window.___jsl = window.___jsl || {};
        b[a] = b[a] || [];
        return b[a]
    }
    ;
    Ie = function(a) {
        var b = window.___jsl = window.___jsl || {};
        b.cfg = !a && b.cfg || {};
        return b.cfg
    }
    ;
    Je = function(a) {
        return typeof a === "object" && /\[native code\]/.test(a.push)
    }
    ;
    Ke = function(a, b, c) {
        if (b && typeof b === "object")
            for (var d in b)
                !Object.prototype.hasOwnProperty.call(b, d) || c && d === "___goc" && typeof b[d] === "undefined" || (a[d] && b[d] && typeof a[d] === "object" && typeof b[d] === "object" && !Je(a[d]) && !Je(b[d]) ? Ke(a[d], b[d]) : b[d] && typeof b[d] === "object" ? (a[d] = Je(b[d]) ? [] : {},
                Ke(a[d], b[d])) : a[d] = b[d])
    }
    ;
    Ne = function(a, b) {
        if (a && !/^\s+$/.test(a)) {
            for (; a.charCodeAt(a.length - 1) == 0; )
                a = a.substring(0, a.length - 1);
            var c = a
              , d = He("dm");
            d.push(20);
            try {
                var e = window.JSON.parse(a)
            } catch (h) {}
            if (typeof e === "object")
                return d.push(21),
                e;
            try {
                e = window.JSON.parse("{" + a + "}")
            } catch (h) {}
            if (typeof e === "object")
                return d.push(22),
                e;
            a = a.replace(RegExp("([^\"',{}\\s]+?)\\s*:\\s*(.*?)[,}\\s]", "g"), function(h, k, l) {
                l = l.startsWith('"') ? "%DOUBLE_QUOTE%" + l.substring(1) : l;
                l = l.endsWith('"') ? l.slice(0, -1) + "%DOUBLE_QUOTE%" : l;
                return "%DOUBLE_QUOTE%" + k + "%DOUBLE_QUOTE%:" + l
            });
            a = a.replace(/\\'/g, "%SINGLE_QUOTE%");
            a = a.replace(/"/g, '\\"');
            a = a.replace(/'/g, '"');
            a = a.replace(/%SINGLE_QUOTE%/g, "'");
            a = a.replace(/%DOUBLE_QUOTE%/g, '"');
            try {
                e = window.JSON.parse(a)
            } catch (h) {}
            if (typeof e === "object")
                return d.push(23),
                e;
            try {
                e = window.JSON.parse("{" + a + "}")
            } catch (h) {}
            if (typeof e === "object")
                return d.push(24),
                e;
            a = document.getElementsByTagName("script") || [];
            var f;
            a.length > 0 && (f = a[0].nonce || a[0].getAttribute("nonce"));
            if (f && f === b || !f && Le())
                if (e = Me(c),
                d.push(25),
                typeof e === "object")
                    return e;
            return {}
        }
    }
    ;
    Le = function() {
        var a = window.location.hostname;
        return a ? /(^|\.)(2mdn|ampproject|android|appspot|blogger|blogspot|chrome|chromium|doubleclick|gcpnode|ggpht|gmail|google|google-analytics|googleadservices|googleapis|googleapis-cn|googleoptimize|googlers|googlesource|googlesyndication|googletagmanager|googletagservices|googleusercontent|googlevideo|gstatic|tiltbrush|waze|withgoogle|youtube|ytimg)(\.com?|\.net|\.org)?(\.[a-z][a-z]|\.cat)?$/.test(a) : !1
    }
    ;
    Me = function(a) {
        try {
            var b = (new Function("return (" + a + "\n)"))()
        } catch (c) {}
        if (typeof b === "object")
            return b;
        try {
            b = (new Function("return ({" + a + "\n})"))()
        } catch (c) {}
        return b
    }
    ;
    Oe = function(a, b) {
        var c = {
            ___goc: void 0
        };
        a.length && a[a.length - 1] && Object.hasOwnProperty.call(a[a.length - 1], "___goc") && typeof a[a.length - 1].___goc === "undefined" && (c = a.pop());
        Ke(c, b);
        a.push(c)
    }
    ;
    Pe = function(a) {
        Ie(!0);
        var b = window.___gcfg
          , c = He("cu")
          , d = window.___gu;
        b && b !== d && (Oe(c, b),
        window.___gu = b);
        b = He("cu");
        var e = document.getElementsByTagName("script") || [];
        d = [];
        var f = [];
        f.push.apply(f, He("us"));
        for (var h = 0; h < e.length; ++h)
            for (var k = e[h], l = 0; l < f.length; ++l)
                k.src && k.src.indexOf(f[l]) == 0 && d.push(k);
        d.length == 0 && e.length > 0 && e[e.length - 1].src && d.push(e[e.length - 1]);
        for (e = 0; e < d.length; ++e)
            d[e].getAttribute("gapi_processed") || (d[e].setAttribute("gapi_processed", !0),
            (f = d[e]) ? (h = f.nodeType,
            f = h == 3 || h == 4 ? f.nodeValue : f.textContent || "") : f = void 0,
            h = d[e].nonce || d[e].getAttribute("nonce"),
            (f = Ne(f, h)) && b.push(f));
        a && Oe(c, a);
        d = He("cd");
        a = 0;
        for (b = d.length; a < b; ++a)
            Ke(Ie(), d[a], !0);
        d = He("ci");
        a = 0;
        for (b = d.length; a < b; ++a)
            Ke(Ie(), d[a], !0);
        a = 0;
        for (b = c.length; a < b; ++a)
            Ke(Ie(), c[a], !0)
    }
    ;
    _.Qe = function(a, b) {
        var c = Ie();
        if (!a)
            return c;
        a = a.split("/");
        for (var d = 0, e = a.length; c && typeof c === "object" && d < e; ++d)
            c = c[a[d]];
        return d === a.length && c !== void 0 ? c : b
    }
    ;
    _.Re = function(a, b) {
        var c;
        if (typeof a === "string") {
            var d = c = {};
            a = a.split("/");
            for (var e = 0, f = a.length; e < f - 1; ++e) {
                var h = {};
                d = d[a[e]] = h
            }
            d[a[e]] = b
        } else
            c = a;
        Pe(c)
    }
    ;
    var Se = function() {
        var a = window.__GOOGLEAPIS;
        a && (a.googleapis && !a["googleapis.config"] && (a["googleapis.config"] = a.googleapis),
        _.ve(_.Ge, "ci", []).push(a),
        window.__GOOGLEAPIS = void 0)
    };
    Se && Se();
    Pe();
    _.A("gapi.config.get", _.Qe);
    _.A("gapi.config.update", _.Re);
    _.Te = function(a) {
        a = _.pe(a);
        return _.$b(a)
    }
    ;
    var Ze, $e, af, bf, cf, df, ef, ff, gf, hf, kf, mf, nf, of, pf, qf, rf, sf, tf, uf, vf, wf, xf, yf, zf, Af, Bf, Cf, Df, Ef, Ff, If, Jf;
    af = void 0;
    bf = function(a) {
        try {
            return _.ab.JSON.parse.call(_.ab.JSON, a)
        } catch (b) {
            return !1
        }
    }
    ;
    cf = function(a) {
        return Object.prototype.toString.call(a)
    }
    ;
    df = cf(0);
    ef = cf(new Date(0));
    ff = cf(!0);
    gf = cf("");
    hf = cf({});
    kf = cf([]);
    mf = function(a, b) {
        if (b)
            for (var c = 0, d = b.length; c < d; ++c)
                if (a === b[c])
                    throw new TypeError("Converting circular structure to JSON");
        d = typeof a;
        if (d !== "undefined") {
            c = Array.prototype.slice.call(b || [], 0);
            c[c.length] = a;
            b = [];
            var e = cf(a);
            if (a != null && typeof a.toJSON === "function" && (Object.prototype.hasOwnProperty.call(a, "toJSON") || (e !== kf || a.constructor !== Array && a.constructor !== Object) && (e !== hf || a.constructor !== Array && a.constructor !== Object) && e !== gf && e !== df && e !== ff && e !== ef))
                return mf(a.toJSON.call(a), c);
            if (a == null)
                b[b.length] = "null";
            else if (e === df)
                a = Number(a),
                isNaN(a) || isNaN(a - a) ? a = "null" : a === -0 && 1 / a < 0 && (a = "-0"),
                b[b.length] = String(a);
            else if (e === ff)
                b[b.length] = String(!!Number(a));
            else {
                if (e === ef)
                    return mf(a.toISOString.call(a), c);
                if (e === kf && cf(a.length) === df) {
                    b[b.length] = "[";
                    var f = 0;
                    for (d = Number(a.length) >> 0; f < d; ++f)
                        f && (b[b.length] = ","),
                        b[b.length] = mf(a[f], c) || "null";
                    b[b.length] = "]"
                } else if (e == gf && cf(a.length) === df) {
                    b[b.length] = '"';
                    f = 0;
                    for (c = Number(a.length) >> 0; f < c; ++f)
                        d = String.prototype.charAt.call(a, f),
                        e = String.prototype.charCodeAt.call(a, f),
                        b[b.length] = d === "\b" ? "\\b" : d === "\f" ? "\\f" : d === "\n" ? "\\n" : d === "\r" ? "\\r" : d === "\t" ? "\\t" : d === "\\" || d === '"' ? "\\" + d : e <= 31 ? "\\u" + (e + 65536).toString(16).substr(1) : e >= 32 && e <= 65535 ? d : "\ufffd";
                    b[b.length] = '"'
                } else if (d === "object") {
                    b[b.length] = "{";
                    d = 0;
                    for (f in a)
                        Object.prototype.hasOwnProperty.call(a, f) && (e = mf(a[f], c),
                        e !== void 0 && (d++ && (b[b.length] = ","),
                        b[b.length] = mf(f),
                        b[b.length] = ":",
                        b[b.length] = e));
                    b[b.length] = "}"
                } else
                    return
            }
            return b.join("")
        }
    }
    ;
    nf = /[\0-\x07\x0b\x0e-\x1f]/;
    of = /^([^"]*"([^\\"]|\\.)*")*[^"]*"([^"\\]|\\.)*[\0-\x1f]/;
    pf = /^([^"]*"([^\\"]|\\.)*")*[^"]*"([^"\\]|\\.)*\\[^\\\/"bfnrtu]/;
    qf = /^([^"]*"([^\\"]|\\.)*")*[^"]*"([^"\\]|\\.)*\\u([0-9a-fA-F]{0,3}[^0-9a-fA-F])/;
    rf = /"([^\0-\x1f\\"]|\\[\\\/"bfnrt]|\\u[0-9a-fA-F]{4})*"/g;
    sf = /-?(0|[1-9][0-9]*)(\.[0-9]+)?([eE][-+]?[0-9]+)?/g;
    tf = /[ \t\n\r]+/g;
    uf = /[^"]:/;
    vf = /""/g;
    wf = /true|false|null/g;
    xf = /00/;
    yf = /[\{]([^0\}]|0[^:])/;
    zf = /(^|\[)[,:]|[,:](\]|\}|[,:]|$)/;
    Af = /[^\[,:][\[\{]/;
    Bf = /^(\{|\}|\[|\]|,|:|0)+/;
    Cf = /\u2028/g;
    Df = /\u2029/g;
    Ef = function(a) {
        a = String(a);
        if (nf.test(a) || of.test(a) || pf.test(a) || qf.test(a))
            return !1;
        var b = a.replace(rf, '""');
        b = b.replace(sf, "0");
        b = b.replace(tf, "");
        if (uf.test(b))
            return !1;
        b = b.replace(vf, "0");
        b = b.replace(wf, "0");
        if (xf.test(b) || yf.test(b) || zf.test(b) || Af.test(b) || !b || (b = b.replace(Bf, "")))
            return !1;
        a = a.replace(Cf, "\\u2028").replace(Df, "\\u2029");
        b = void 0;
        try {
            b = af ? [bf(a)] : eval("(function (var_args) {\n  return Array.prototype.slice.call(arguments, 0);\n})(\n" + a + "\n)")
        } catch (c) {
            return !1
        }
        return b && b.length === 1 ? b[0] : !1
    }
    ;
    Ff = function() {
        var a = ((_.ab.document || {}).scripts || []).length;
        if ((Ze === void 0 || af === void 0 || $e !== a) && $e !== -1) {
            Ze = af = !1;
            $e = -1;
            try {
                try {
                    af = !!_.ab.JSON && _.ab.JSON.stringify.call(_.ab.JSON, {
                        a: [3, !0, new Date(0)],
                        c: function() {}
                    }) === '{"a":[3,true,"1970-01-01T00:00:00.000Z"]}' && bf("true") === !0 && bf('[{"a":3}]')[0].a === 3
                } catch (b) {}
                Ze = af && !bf("[00]") && !bf('"\u0007"') && !bf('"\\0"') && !bf('"\\v"')
            } finally {
                $e = a
            }
        }
    }
    ;
    _.Gf = function(a) {
        if ($e === -1)
            return !1;
        Ff();
        return (Ze ? bf : Ef)(a)
    }
    ;
    _.Hf = function(a) {
        if ($e !== -1)
            return Ff(),
            af ? _.ab.JSON.stringify.call(_.ab.JSON, a) : mf(a)
    }
    ;
    If = !Date.prototype.toISOString || typeof Date.prototype.toISOString !== "function" || (new Date(0)).toISOString() !== "1970-01-01T00:00:00.000Z";
    Jf = function() {
        var a = Date.prototype.getUTCFullYear.call(this);
        return [a < 0 ? "-" + String(1E6 - a).substr(1) : a <= 9999 ? String(1E4 + a).substr(1) : "+" + String(1E6 + a).substr(1), "-", String(101 + Date.prototype.getUTCMonth.call(this)).substr(1), "-", String(100 + Date.prototype.getUTCDate.call(this)).substr(1), "T", String(100 + Date.prototype.getUTCHours.call(this)).substr(1), ":", String(100 + Date.prototype.getUTCMinutes.call(this)).substr(1), ":", String(100 + Date.prototype.getUTCSeconds.call(this)).substr(1), ".", String(1E3 + Date.prototype.getUTCMilliseconds.call(this)).substr(1), "Z"].join("")
    }
    ;
    Date.prototype.toISOString = If ? Jf : Date.prototype.toISOString;
    var zg = function() {
        this.blockSize = -1
    }
      , Ag = function() {
        this.blockSize = -1;
        this.blockSize = 64;
        this.Sc = [];
        this.PE = [];
        this.X5 = [];
        this.HB = [];
        this.HB[0] = 128;
        for (var a = 1; a < this.blockSize; ++a)
            this.HB[a] = 0;
        this.wD = this.Zq = 0;
        this.reset()
    };
    _.hb(Ag, zg);
    Ag.prototype.reset = function() {
        this.Sc[0] = 1732584193;
        this.Sc[1] = 4023233417;
        this.Sc[2] = 2562383102;
        this.Sc[3] = 271733878;
        this.Sc[4] = 3285377520;
        this.wD = this.Zq = 0
    }
    ;
    var Bg = function(a, b, c) {
        c || (c = 0);
        var d = a.X5;
        if (typeof b === "string")
            for (var e = 0; e < 16; e++)
                d[e] = b.charCodeAt(c) << 24 | b.charCodeAt(c + 1) << 16 | b.charCodeAt(c + 2) << 8 | b.charCodeAt(c + 3),
                c += 4;
        else
            for (e = 0; e < 16; e++)
                d[e] = b[c] << 24 | b[c + 1] << 16 | b[c + 2] << 8 | b[c + 3],
                c += 4;
        for (b = 16; b < 80; b++)
            c = d[b - 3] ^ d[b - 8] ^ d[b - 14] ^ d[b - 16],
            d[b] = (c << 1 | c >>> 31) & 4294967295;
        b = a.Sc[0];
        c = a.Sc[1];
        e = a.Sc[2];
        for (var f = a.Sc[3], h = a.Sc[4], k, l, m = 0; m < 80; m++)
            m < 40 ? m < 20 ? (k = f ^ c & (e ^ f),
            l = 1518500249) : (k = c ^ e ^ f,
            l = 1859775393) : m < 60 ? (k = c & e | f & (c | e),
            l = 2400959708) : (k = c ^ e ^ f,
            l = 3395469782),
            k = (b << 5 | b >>> 27) + k + h + l + d[m] & 4294967295,
            h = f,
            f = e,
            e = (c << 30 | c >>> 2) & 4294967295,
            c = b,
            b = k;
        a.Sc[0] = a.Sc[0] + b & 4294967295;
        a.Sc[1] = a.Sc[1] + c & 4294967295;
        a.Sc[2] = a.Sc[2] + e & 4294967295;
        a.Sc[3] = a.Sc[3] + f & 4294967295;
        a.Sc[4] = a.Sc[4] + h & 4294967295
    };
    Ag.prototype.update = function(a, b) {
        if (a != null) {
            b === void 0 && (b = a.length);
            for (var c = b - this.blockSize, d = 0, e = this.PE, f = this.Zq; d < b; ) {
                if (f == 0)
                    for (; d <= c; )
                        Bg(this, a, d),
                        d += this.blockSize;
                if (typeof a === "string")
                    for (; d < b; ) {
                        if (e[f] = a.charCodeAt(d),
                        ++f,
                        ++d,
                        f == this.blockSize) {
                            Bg(this, e);
                            f = 0;
                            break
                        }
                    }
                else
                    for (; d < b; )
                        if (e[f] = a[d],
                        ++f,
                        ++d,
                        f == this.blockSize) {
                            Bg(this, e);
                            f = 0;
                            break
                        }
            }
            this.Zq = f;
            this.wD += b
        }
    }
    ;
    Ag.prototype.digest = function() {
        var a = []
          , b = this.wD * 8;
        this.Zq < 56 ? this.update(this.HB, 56 - this.Zq) : this.update(this.HB, this.blockSize - (this.Zq - 56));
        for (var c = this.blockSize - 1; c >= 56; c--)
            this.PE[c] = b & 255,
            b /= 256;
        Bg(this, this.PE);
        for (c = b = 0; c < 5; c++)
            for (var d = 24; d >= 0; d -= 8)
                a[b] = this.Sc[c] >> d & 255,
                ++b;
        return a
    }
    ;
    _.Cg = function() {
        this.SM = new Ag
    }
    ;
    _.g = _.Cg.prototype;
    _.g.reset = function() {
        this.SM.reset()
    }
    ;
    _.g.X0 = function(a) {
        this.SM.update(a)
    }
    ;
    _.g.NQ = function() {
        return this.SM.digest()
    }
    ;
    _.g.mx = function(a) {
        a = unescape(encodeURIComponent(a));
        for (var b = [], c = a.length, d = 0; d < c; ++d)
            b.push(a.charCodeAt(d));
        this.X0(b)
    }
    ;
    _.g.Si = function() {
        for (var a = this.NQ(), b = "", c = 0; c < a.length; c++)
            b += "0123456789ABCDEF".charAt(Math.floor(a[c] / 16)) + "0123456789ABCDEF".charAt(a[c] % 16);
        return b
    }
    ;
    _.Rh = function(a) {
        var b = window.___jsl = window.___jsl || {};
        b.cfg = !a && b.cfg || {};
        return b.cfg
    }
    ;
    _.Sh = function(a) {
        var b = _.Rh();
        if (!a)
            return b;
        a = a.split("/");
        for (var c = 0, d = a.length; b && typeof b === "object" && c < d; ++c)
            b = b[a[c]];
        return c === a.length && b !== void 0 ? b : void 0
    }
    ;
    _.Th = function(a, b, c, d) {
        for (var e = 0, f = a.length, h; e < f; ) {
            var k = e + (f - e >>> 1);
            var l = c ? b.call(void 0, a[k], k, a) : b(d, a[k]);
            l > 0 ? e = k + 1 : (f = k,
            h = !l)
        }
        return h ? e : -e - 1
    }
    ;
    _.Uh = function(a, b) {
        var c = {}, d;
        for (d in a)
            b.call(void 0, a[d], d, a) && (c[d] = a[d]);
        return c
    }
    ;
    var Vh;
    Vh = /^https?:\/\/(?:\w|[\-\.])+\.google\.(?:\w|[\-:\.])+(?:\/[^\?#]*)?\/u\/(\d)\//;
    _.Wh = function(a) {
        var b = _.Sh("googleapis.config/sessionIndex");
        "string" === typeof b && b.length > 254 && (b = null);
        b == null && (b = window.__X_GOOG_AUTHUSER);
        "string" === typeof b && b.length > 254 && (b = null);
        if (b == null) {
            var c = window.google;
            c && (b = c.authuser)
        }
        "string" === typeof b && b.length > 254 && (b = null);
        b == null && (a = a || window.location.href,
        b = _.Ae(a, "authuser") || null,
        b == null && (b = (b = a.match(Vh)) ? b[1] : null));
        if (b == null)
            return null;
        b = String(b);
        b.length > 254 && (b = null);
        return b
    }
    ;
    _.ki = function(a, b) {
        return typeof b === "string" ? a.getElementById(b) : b
    }
    ;
    _.li = function() {
        if (!_.ab.addEventListener || !Object.defineProperty)
            return !1;
        var a = !1
          , b = Object.defineProperty({}, "passive", {
            get: function() {
                a = !0
            }
        });
        try {
            var c = function() {};
            _.ab.addEventListener("test", c, b);
            _.ab.removeEventListener("test", c, b)
        } catch (d) {}
        return a
    }();
    var mi = function() {
        var a = _.Ge.ms || _.Ge.u;
        if (a)
            return (new URL(a)).origin
    };
    var ni = function(a) {
        this.xS = a;
        this.count = this.count = 0
    };
    ni.prototype.Ab = function(a, b) {
        a ? this.count += a : this.count++;
        this.xS && (b === void 0 || b) && this.xS()
    }
    ;
    ni.prototype.get = function() {
        return this.count
    }
    ;
    ni.prototype.reset = function() {
        this.count = 0
    }
    ;
    var pi, si;
    pi = function() {
        var a = !0
          , b = this;
        a = a === void 0 ? !0 : a;
        this.Gy = new Map;
        this.IE = !1;
        var c = mi();
        c && (this.url = c + "/js/gen_204",
        c = _.Sh("gen204logger") || {},
        this.gu = c.interval,
        this.yS = c.rate,
        this.IE = c.spa,
        a && this.url && oi(this),
        document.addEventListener("visibilitychange", this.flush),
        this.flush(),
        document.addEventListener("visibilitychange", function() {
            document.visibilityState === "hidden" && b.flush()
        }),
        document.addEventListener("pagehide", this.flush.bind(this)))
    }
    ;
    _.qi = function() {
        pi.vW || (pi.vW = new pi);
        return pi.vW
    }
    ;
    si = function(a) {
        var b = _.Ge.dm || [];
        if (b && b.length !== 0) {
            b = _.Aa(b);
            for (var c = b.next(); !c.done; c = b.next())
                _.ri(a, c.value).Ab(1, !1);
            delete _.Ge.dm;
            a.flush()
        }
    }
    ;
    _.ri = function(a, b) {
        a.Gy.has(b) || a.Gy.set(b, new ni(a.IE ? void 0 : function() {
            a.flush()
        }
        ));
        return a.Gy.get(b)
    }
    ;
    pi.prototype.flush = function() {
        var a = this;
        if (this.url && this.yS) {
            si(this);
            for (var b = "", c = _.Aa(this.Gy), d = c.next(); !d.done; d = c.next()) {
                var e = _.Aa(d.value);
                d = e.next().value;
                e = e.next().value;
                var f = e.get();
                f > 0 && (b += b.length > 0 ? "&" : "",
                b += "c=",
                b += encodeURIComponent(d + ":" + f),
                e.reset());
                if (b.length > 1E3)
                    break
            }
            if (b !== "" && Math.random() < this.yS) {
                try {
                    var h = AbortSignal.timeout(3E4)
                } catch (k) {
                    h = void 0
                }
                fetch(this.url + "?" + b, {
                    method: "GET",
                    mode: "no-cors",
                    signal: h
                }).catch(function() {}).finally(function() {
                    oi(a)
                })
            }
        }
    }
    ;
    pi.prototype.setInterval = function(a) {
        this.gu = a
    }
    ;
    var oi = function(a) {
        a.gu && a.IE && setTimeout(function() {
            a.flush()
        }, a.gu)
    };
    var ui, ti, Bi, Ci, vi, zi, xi, Di, yi;
    _.Ai = function() {
        _.ri(_.qi(), 50).Ab();
        if (ti) {
            var a = new _.qe.Uint32Array(1);
            ui.getRandomValues(a);
            a = Number("0." + a[0])
        } else
            a = vi,
            a += parseInt(xi.substr(0, 20), 16),
            xi = yi(xi),
            a /= zi + 1.2089258196146292E24;
        return a
    }
    ;
    ui = _.qe.crypto;
    ti = !1;
    Bi = 0;
    Ci = 0;
    vi = 1;
    zi = 0;
    xi = "";
    Di = function(a) {
        a = a || _.qe.event;
        var b = a.screenX + a.clientX << 16;
        b += a.screenY + a.clientY;
        b *= (new Date).getTime() % 1E6;
        vi = vi * b % zi;
        Bi > 0 && ++Ci == Bi && _.Ee(_.qe, "mousemove", Di, "remove", "de")
    }
    ;
    yi = function(a) {
        var b = new _.Cg;
        b.mx(a);
        return b.Si()
    }
    ;
    ti = !!ui && typeof ui.getRandomValues == "function";
    ti || (zi = (screen.width * screen.width + screen.height) * 1E6,
    xi = yi(_.re.cookie + "|" + _.re.location + "|" + (new Date).getTime() + "|" + Math.random()),
    Bi = _.Sh("random/maxObserveMousemove") || 0,
    Bi != 0 && _.Fe(_.qe, "mousemove", Di));
    var rl, sl, xl, yl, zl, Al, Bl, Cl, Dl, El, Fl, Gl, Kl, Ll, Ml, Nl, Ol, Pl, Ql, Rl;
    _.ql = function(a, b) {
        if (!a)
            throw Error(b || "");
    }
    ;
    rl = /&/g;
    sl = /</g;
    xl = />/g;
    yl = /"/g;
    zl = /'/g;
    Al = function(a) {
        return String(a).replace(rl, "&amp;").replace(sl, "&lt;").replace(xl, "&gt;").replace(yl, "&quot;").replace(zl, "&#39;")
    }
    ;
    Bl = /[\ud800-\udbff][\udc00-\udfff]|[^!-~]/g;
    Cl = /%([a-f]|[0-9a-fA-F][a-f])/g;
    Dl = /^(https?|ftp|file|chrome-extension):$/i;
    El = function(a) {
        a = String(a);
        a = a.replace(Bl, function(e) {
            try {
                return encodeURIComponent(e)
            } catch (f) {
                return encodeURIComponent(e.replace(/^[^%]+$/g, "\ufffd"))
            }
        }).replace(_.Ce, function(e) {
            return e.replace(/%/g, "%25")
        }).replace(Cl, function(e) {
            return e.toUpperCase()
        });
        a = a.match(_.Be) || [];
        var b = _.we()
          , c = function(e) {
            return e.replace(/\\/g, "%5C").replace(/\^/g, "%5E").replace(/`/g, "%60").replace(/\{/g, "%7B").replace(/\|/g, "%7C").replace(/\}/g, "%7D")
        }
          , d = !!(a[1] || "").match(Dl);
        b.it = c((a[1] || "") + (a[2] || "") + (a[3] || (a[2] && d ? "/" : "")));
        d = function(e) {
            return c(e.replace(/\?/g, "%3F").replace(/#/g, "%23"))
        }
        ;
        b.query = a[5] ? [d(a[5])] : [];
        b.Wi = a[7] ? [d(a[7])] : [];
        return b
    }
    ;
    Fl = function(a) {
        return a.it + (a.query.length > 0 ? "?" + a.query.join("&") : "") + (a.Wi.length > 0 ? "#" + a.Wi.join("&") : "")
    }
    ;
    Gl = function(a, b) {
        var c = [];
        if (a)
            for (var d in a)
                if (_.xe(a, d) && a[d] != null) {
                    var e = b ? b(a[d]) : a[d];
                    c.push(encodeURIComponent(d) + "=" + encodeURIComponent(e))
                }
        return c
    }
    ;
    _.Hl = function(a, b, c, d) {
        a = El(a);
        a.query.push.apply(a.query, Gl(b, d));
        a.Wi.push.apply(a.Wi, Gl(c, d));
        return Fl(a)
    }
    ;
    _.Il = function(a, b) {
        var c = El(b);
        b = c.it;
        c.query.length && (b += "?" + c.query.join(""));
        c.Wi.length && (b += "#" + c.Wi.join(""));
        var d = "";
        b.length > 2E3 && (c = b,
        b = b.substr(0, 2E3),
        b = b.replace(_.De, ""),
        d = c.substr(b.length));
        var e = a.createElement("div");
        a = a.createElement("a");
        c = El(b);
        b = c.it;
        c.query.length && (b += "?" + c.query.join(""));
        c.Wi.length && (b += "#" + c.Wi.join(""));
        _.yc(a, new _.gc(_.pe(b)));
        e.appendChild(a);
        _.Dc(e, _.$b(e.innerHTML));
        b = String(e.firstChild.href);
        e.parentNode && e.parentNode.removeChild(e);
        c = El(b + d);
        b = c.it;
        c.query.length && (b += "?" + c.query.join(""));
        c.Wi.length && (b += "#" + c.Wi.join(""));
        return b
    }
    ;
    _.Jl = /^https?:\/\/[^\/%\\?#\s]+\/[^\s]*$/i;
    Ll = function(a) {
        for (; a.firstChild; )
            a.removeChild(a.firstChild)
    }
    ;
    Ml = /^https?:\/\/(?:\w|[\-\.])+\.google\.(?:\w|[\-:\.])+(?:\/[^\?#]*)?\/b\/(\d{10,21})\//;
    Nl = function() {
        var a = _.Sh("googleapis.config/sessionDelegate");
        "string" === typeof a && a.length > 21 && (a = null);
        a == null && (a = (a = window.location.href.match(Ml)) ? a[1] : null);
        if (a == null)
            return null;
        a = String(a);
        a.length > 21 && (a = null);
        return a
    }
    ;
    Ol = function() {
        var a = _.Ge.onl;
        if (!a) {
            a = _.we();
            _.Ge.onl = a;
            var b = _.we();
            a.e = function(c) {
                var d = b[c];
                d && (delete b[c],
                d())
            }
            ;
            a.a = function(c, d) {
                b[c] = d
            }
            ;
            a.r = function(c) {
                delete b[c]
            }
        }
        return a
    }
    ;
    Pl = function(a, b) {
        b = b.onload;
        return typeof b === "function" ? (Ol().a(a, b),
        b) : null
    }
    ;
    Ql = function(a) {
        _.ql(/^\w+$/.test(a), "Unsupported id - " + a);
        return 'onload="window.___jsl.onl.e(&#34;' + a + '&#34;)"'
    }
    ;
    Rl = function(a) {
        Ol().r(a)
    }
    ;
    var Tl, Ul, Yl;
    _.Sl = {
        allowtransparency: "true",
        frameborder: "0",
        hspace: "0",
        marginheight: "0",
        marginwidth: "0",
        scrolling: "no",
        style: "",
        tabindex: "0",
        vspace: "0",
        width: "100%"
    };
    Tl = {
        allowtransparency: !0,
        onload: !0
    };
    Ul = 0;
    _.Vl = function(a, b) {
        var c = 0;
        do
            var d = b.id || ["I", Ul++, "_", (new Date).getTime()].join("");
        while (a.getElementById(d) && ++c < 5);
        _.ql(c < 5, "Error creating iframe id");
        return d
    }
    ;
    _.Wl = function(a, b) {
        return a ? b + "/" + a : ""
    }
    ;
    _.Xl = function(a, b, c, d) {
        var e = {}
          , f = {};
        a.documentMode && a.documentMode < 9 && (e.hostiemode = a.documentMode);
        _.ye(d.queryParams || {}, e);
        _.ye(d.fragmentParams || {}, f);
        var h = d.pfname;
        var k = _.we();
        _.Sh("iframes/dropLegacyIdParam") || (k.id = c);
        k._gfid = c;
        k.parent = a.location.protocol + "//" + a.location.host;
        c = _.Ae(a.location.href, "parent");
        h = h || "";
        !h && c && (h = _.Ae(a.location.href, "_gfid", "") || _.Ae(a.location.href, "id", ""),
        h = _.Wl(h, _.Ae(a.location.href, "pfname", "")));
        h || (c = _.Gf(_.Ae(a.location.href, "jcp", ""))) && typeof c == "object" && (h = _.Wl(c.id, c.pfname));
        k.pfname = h;
        d.connectWithJsonParam && (h = {},
        h.jcp = _.Hf(k),
        k = h);
        h = _.Ae(b, "rpctoken") || e.rpctoken || f.rpctoken;
        h || (h = d.rpctoken || String(Math.round(_.Ai() * 1E8)),
        k.rpctoken = h);
        d.rpctoken = h;
        _.ye(k, d.connectWithQueryParams ? e : f);
        k = a.location.href;
        a = _.we();
        (h = _.Ae(k, "_bsh", _.Ge.bsh)) && (a._bsh = h);
        (k = _.Ge.dpo ? _.Ge.h : _.Ae(k, "jsh", _.Ge.h)) && (a.jsh = k);
        d.hintInFragment ? _.ye(a, f) : _.ye(a, e);
        return _.Hl(b, e, f, d.paramsSerializer)
    }
    ;
    Yl = function(a) {
        _.ql(!a || _.Jl.test(a), "Illegal url for new iframe - " + a)
    }
    ;
    _.Zl = function(a, b, c, d, e) {
        Yl(c.src);
        var f, h = Pl(d, c), k = h ? Ql(d) : "";
        try {
            document.all && (f = a.createElement('<iframe frameborder="' + Al(String(c.frameborder)) + '" scrolling="' + Al(String(c.scrolling)) + '" ' + k + ' name="' + Al(String(c.name)) + '"/>'))
        } catch (m) {} finally {
            f || (f = _.Ud(a).createElement("IFRAME"),
            h && (f.onload = function() {
                f.onload = null;
                h.call(this)
            }
            ,
            Rl(d)))
        }
        f.setAttribute("ng-non-bindable", "");
        for (var l in c)
            a = c[l],
            l === "style" && typeof a === "object" ? _.ye(a, f.style) : Tl[l] || f.setAttribute(l, String(a));
        (l = e && e.beforeNode || null) || e && e.dontclear || Ll(b);
        b.insertBefore(f, l);
        f = l ? l.previousSibling : b.lastChild;
        c.allowtransparency && (f.allowTransparency = !0);
        return f
    }
    ;
    var $l, cm;
    $l = /^:[\w]+$/;
    _.am = /:([a-zA-Z_]+):/g;
    _.bm = function() {
        var a = _.Wh() || "0"
          , b = Nl();
        var c = _.Wh() || a;
        var d = Nl()
          , e = "";
        c && (e += "u/" + encodeURIComponent(String(c)) + "/");
        d && (e += "b/" + encodeURIComponent(String(d)) + "/");
        c = e || null;
        (e = (d = _.Sh("isLoggedIn") === !1) ? "_/im/" : "") && (c = "");
        var f = _.Sh("iframes/:socialhost:")
          , h = _.Sh("iframes/:im_socialhost:");
        return Kl = {
            socialhost: f,
            ctx_socialhost: d ? h : f,
            session_index: a,
            session_delegate: b,
            session_prefix: c,
            im_prefix: e
        }
    }
    ;
    cm = function(a, b) {
        return _.bm()[b] || ""
    }
    ;
    _.dm = function(a) {
        return _.Il(_.re, a.replace(_.am, cm))
    }
    ;
    _.em = function(a) {
        var b = a;
        $l.test(a) && (b = "iframes/" + b.substring(1) + "/url",
        b = _.Sh(b),
        _.ql(!!b, "Unknown iframe url config for - " + a));
        return _.dm(b)
    }
    ;
    _.fm = function(a, b, c) {
        c = c || {};
        var d = c.attributes || {};
        _.ql(!(c.allowPost || c.forcePost) || !d.onload, "onload is not supported by post iframe (allowPost or forcePost)");
        a = _.em(a);
        d = b.ownerDocument || _.re;
        var e = _.Vl(d, c);
        a = _.Xl(d, a, e, c);
        var f = c
          , h = _.we();
        _.ye(_.Sl, h);
        _.ye(f.attributes, h);
        h.name = h.id = e;
        h.src = a;
        c.eurl = a;
        c = (f = c) || {};
        var k = !!c.allowPost;
        if (c.forcePost || k && a.length > 2E3) {
            c = El(a);
            h.src = "";
            f.dropDataPostorigin || (h["data-postorigin"] = a);
            a = _.Zl(d, b, h, e);
            if (navigator.userAgent.indexOf("WebKit") != -1) {
                var l = a.contentWindow.document;
                l.open();
                h = l.createElement("div");
                k = {};
                var m = e + "_inner";
                k.name = m;
                k.src = "";
                k.style = "display:none";
                _.Zl(d, h, k, m, f)
            }
            h = (f = c.query[0]) ? f.split("&") : [];
            f = [];
            for (k = 0; k < h.length; k++)
                m = h[k].split("=", 2),
                f.push([decodeURIComponent(m[0]), decodeURIComponent(m[1])]);
            c.query = [];
            h = Fl(c);
            _.ql(_.Jl.test(h), "Invalid URL: " + h);
            c = d.createElement("form");
            c.method = "POST";
            c.target = e;
            c.style.display = "none";
            e = _.nc(h);
            e !== void 0 && (c.action = e);
            for (e = 0; e < f.length; e++)
                h = d.createElement("input"),
                h.type = "hidden",
                h.name = f[e][0],
                h.value = f[e][1],
                c.appendChild(h);
            b.appendChild(c);
            c.submit();
            c.parentNode.removeChild(c);
            l && l.close();
            b = a
        } else
            b = _.Zl(d, b, h, e, f);
        return b
    }
    ;
    var Kf = function() {
        this.Ig = window.console
    };
    Kf.prototype.log = function(a) {
        this.Ig && this.Ig.log && this.Ig.log(a)
    }
    ;
    Kf.prototype.error = function(a) {
        this.Ig && (this.Ig.error ? this.Ig.error(a) : this.Ig.log && this.Ig.log(a))
    }
    ;
    Kf.prototype.warn = function(a) {
        this.Ig && (this.Ig.warn ? this.Ig.warn(a) : this.Ig.log && this.Ig.log(a))
    }
    ;
    Kf.prototype.debug = function() {}
    ;
    _.Lf = new Kf;
    _.xg = function(a) {
        if (!a)
            return "";
        if (/^about:(?:blank|srcdoc)$/.test(a))
            return window.origin || "";
        a.indexOf("blob:") === 0 && (a = a.substring(5));
        a = a.split("#")[0].split("?")[0];
        a = a.toLowerCase();
        a.indexOf("//") == 0 && (a = window.location.protocol + a);
        /^[\w\-]*:\/\//.test(a) || (a = window.location.href);
        var b = a.substring(a.indexOf("://") + 3)
          , c = b.indexOf("/");
        c != -1 && (b = b.substring(0, c));
        c = a.substring(0, a.indexOf("://"));
        if (!c)
            throw Error("s`" + a);
        if (c !== "http" && c !== "https" && c !== "chrome-extension" && c !== "moz-extension" && c !== "file" && c !== "android-app" && c !== "chrome-search" && c !== "chrome-untrusted" && c !== "chrome" && c !== "app" && c !== "devtools")
            throw Error("t`" + c);
        a = "";
        var d = b.indexOf(":");
        if (d != -1) {
            var e = b.substring(d + 1);
            b = b.substring(0, d);
            if (c === "http" && e !== "80" || c === "https" && e !== "443")
                a = ":" + e
        }
        return c + "://" + b + a
    }
    ;
    var hh;
    _.gh = function(a) {
        _.ab.setTimeout(function() {
            throw a;
        }, 0)
    }
    ;
    hh = 0;
    _.ih = function(a) {
        return Object.prototype.hasOwnProperty.call(a, _.cb) && a[_.cb] || (a[_.cb] = ++hh)
    }
    ;
    _.jh = function() {
        return _.Hc("Firefox") || _.Hc("FxiOS")
    }
    ;
    _.kh = function() {
        return _.Hc("Safari") && !(_.Qc() || (_.Jc() ? 0 : _.Hc("Coast")) || _.Kc() || _.Mc() || _.Oc() || _.Pc() || _.jh() || _.Hc("Silk") || _.Hc("Android"))
    }
    ;
    _.lh = function() {
        return _.Hc("Android") && !(_.Qc() || _.jh() || _.Kc() || _.Hc("Silk"))
    }
    ;
    _.mh = _.jh();
    _.nh = _.Wc() || _.Hc("iPod");
    _.oh = _.Hc("iPad");
    _.ph = _.lh();
    _.qh = _.Qc();
    _.rh = _.kh() && !_.Xc();
    var Ri;
    _.Qi = function(a, b) {
        b = (0,
        _.qb)(a, b);
        var c;
        (c = b >= 0) && Array.prototype.splice.call(a, b, 1);
        return c
    }
    ;
    _.Si = function(a, b) {
        for (var c, d, e = 1; e < arguments.length; e++) {
            d = arguments[e];
            for (c in d)
                a[c] = d[c];
            for (var f = 0; f < Ri.length; f++)
                c = Ri[f],
                Object.prototype.hasOwnProperty.call(d, c) && (a[c] = d[c])
        }
    }
    ;
    Ri = "constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");
    _.Ti = [];
    _.Ui = [];
    _.Vi = !1;
    _.Wi = function(a) {
        _.Ti[_.Ti.length] = a;
        if (_.Vi)
            for (var b = 0; b < _.Ui.length; b++)
                a((0,
                _.B)(_.Ui[b].wrap, _.Ui[b]))
    }
    ;
    _.Ij = function(a) {
        a.Uqa = !0;
        return a
    }
    ;
    _.Jj = _.Ij(function(a) {
        return a !== null && a !== void 0
    });
    var Kj = function(a) {
        this.T = a
    };
    _.g = Kj.prototype;
    _.g.value = function() {
        return this.T
    }
    ;
    _.g.Oe = function(a) {
        this.T.width = a;
        return this
    }
    ;
    _.g.Tb = function() {
        return this.T.width
    }
    ;
    _.g.Vd = function(a) {
        this.T.height = a;
        return this
    }
    ;
    _.g.Nc = function() {
        return this.T.height
    }
    ;
    _.g.Fi = function(a) {
        this.T.style = a;
        return this
    }
    ;
    _.g.getStyle = function() {
        return this.T.style
    }
    ;
    _.Lj = function(a) {
        this.T = a || {}
    }
    ;
    _.g = _.Lj.prototype;
    _.g.value = function() {
        return this.T
    }
    ;
    _.g.setUrl = function(a) {
        this.T.url = a;
        return this
    }
    ;
    _.g.getUrl = function() {
        return this.T.url
    }
    ;
    _.g.Fi = function(a) {
        this.T.style = a;
        return this
    }
    ;
    _.g.getStyle = function() {
        return this.T.style
    }
    ;
    _.g.Ne = function(a) {
        this.T.id = a;
        return this
    }
    ;
    _.g.getId = function() {
        return this.T.id
    }
    ;
    _.g.Zm = function(a) {
        this.T.rpctoken = a;
        return this
    }
    ;
    _.Mj = function(a, b) {
        a.T.messageHandlers = b;
        return a
    }
    ;
    _.Nj = function(a, b) {
        a.T.messageHandlersFilter = b;
        return a
    }
    ;
    _.g = _.Lj.prototype;
    _.g.Vr = _.kb(4);
    _.g.getContext = function() {
        return this.T.context
    }
    ;
    _.g.kd = function() {
        return this.T.openerIframe
    }
    ;
    _.g.Wn = function() {
        this.T.attributes = this.T.attributes || {};
        return new Kj(this.T.attributes)
    }
    ;
    _.g.su = _.kb(5);
    var Tj;
    _.Pj = function(a) {
        var b = {}, c;
        for (c in a)
            b[c] = a[c];
        return b
    }
    ;
    Tj = function() {
        for (var a; a = Qj.remove(); ) {
            try {
                a.Sh.call(a.scope)
            } catch (b) {
                _.gh(b)
            }
            Rj.put(a)
        }
        Sj = !1
    }
    ;
    _.Uj = function(a) {
        if (!(a instanceof Array)) {
            a = _.Aa(a);
            for (var b, c = []; !(b = a.next()).done; )
                c.push(b.value);
            a = c
        }
        return a
    }
    ;
    _.Vj = function() {}
    ;
    _.Wj = function(a) {
        a.prototype.$goog_Thenable = !0
    }
    ;
    _.Xj = function(a) {
        if (!a)
            return !1;
        try {
            return !!a.$goog_Thenable
        } catch (b) {
            return !1
        }
    }
    ;
    _.Yj = typeof AsyncContext !== "undefined" && typeof AsyncContext.Snapshot === "function" ? function(a) {
        return a && AsyncContext.Snapshot.wrap(a)
    }
    : function(a) {
        return a
    }
    ;
    var Zj = function(a, b) {
        this.D7 = a;
        this.qea = b;
        this.sB = 0;
        this.sA = null
    };
    Zj.prototype.get = function() {
        if (this.sB > 0) {
            this.sB--;
            var a = this.sA;
            this.sA = a.next;
            a.next = null
        } else
            a = this.D7();
        return a
    }
    ;
    Zj.prototype.put = function(a) {
        this.qea(a);
        this.sB < 100 && (this.sB++,
        a.next = this.sA,
        this.sA = a)
    }
    ;
    _.ak = function(a) {
        return a
    }
    ;
    _.Wi(function(a) {
        _.ak = a
    });
    var bk = function() {
        this.OD = this.Ms = null
    };
    bk.prototype.add = function(a, b) {
        var c = Rj.get();
        c.set(a, b);
        this.OD ? this.OD.next = c : this.Ms = c;
        this.OD = c
    }
    ;
    bk.prototype.remove = function() {
        var a = null;
        this.Ms && (a = this.Ms,
        this.Ms = this.Ms.next,
        this.Ms || (this.OD = null),
        a.next = null);
        return a
    }
    ;
    var Rj = new Zj(function() {
        return new ck
    }
    ,function(a) {
        return a.reset()
    }
    )
      , ck = function() {
        this.next = this.scope = this.Sh = null
    };
    ck.prototype.set = function(a, b) {
        this.Sh = a;
        this.scope = b;
        this.next = null
    }
    ;
    ck.prototype.reset = function() {
        this.next = this.scope = this.Sh = null
    }
    ;
    var dk, Sj, Qj, ek;
    Sj = !1;
    Qj = new bk;
    _.fk = function(a, b) {
        dk || ek();
        Sj || (dk(),
        Sj = !0);
        Qj.add(a, b)
    }
    ;
    ek = function() {
        var a = Promise.resolve(void 0);
        dk = function() {
            a.then(Tj)
        }
    }
    ;
    var ik, jk, kk, yk, Ck, Ak, Dk;
    _.hk = function(a, b) {
        this.Ca = 0;
        this.uf = void 0;
        this.gq = this.zl = this.Hb = null;
        this.iA = this.TF = !1;
        if (a != _.Vj)
            try {
                var c = this;
                a.call(b, function(d) {
                    gk(c, 2, d)
                }, function(d) {
                    gk(c, 3, d)
                })
            } catch (d) {
                gk(this, 3, d)
            }
    }
    ;
    ik = function() {
        this.next = this.context = this.Dr = this.Hv = this.wn = null;
        this.Nx = !1
    }
    ;
    ik.prototype.reset = function() {
        this.context = this.Dr = this.Hv = this.wn = null;
        this.Nx = !1
    }
    ;
    jk = new Zj(function() {
        return new ik
    }
    ,function(a) {
        a.reset()
    }
    );
    kk = function(a, b, c) {
        var d = jk.get();
        d.Hv = a;
        d.Dr = b;
        d.context = c;
        return d
    }
    ;
    _.lk = function(a) {
        if (a instanceof _.hk)
            return a;
        var b = new _.hk(_.Vj);
        gk(b, 2, a);
        return b
    }
    ;
    _.mk = function(a) {
        return new _.hk(function(b, c) {
            c(a)
        }
        )
    }
    ;
    _.ok = function(a, b, c) {
        nk(a, b, c, null) || _.fk(_.fb(b, a))
    }
    ;
    _.pk = function(a) {
        return new _.hk(function(b, c) {
            var d = a.length
              , e = [];
            if (d)
                for (var f = function(m, n) {
                    d--;
                    e[m] = n;
                    d == 0 && b(e)
                }, h = function(m) {
                    c(m)
                }, k, l = 0; l < a.length; l++)
                    k = a[l],
                    _.ok(k, _.fb(f, l), h);
            else
                b(e)
        }
        )
    }
    ;
    _.rk = function() {
        var a, b, c = new _.hk(function(d, e) {
            a = d;
            b = e
        }
        );
        return new qk(c,a,b)
    }
    ;
    _.hk.prototype.then = function(a, b, c) {
        return sk(this, (0,
        _.Yj)(typeof a === "function" ? a : null), (0,
        _.Yj)(typeof b === "function" ? b : null), c)
    }
    ;
    _.Wj(_.hk);
    var uk = function(a, b, c, d) {
        tk(a, kk(b || _.Vj, c || null, d))
    };
    _.hk.prototype.finally = function(a) {
        var b = this;
        a = (0,
        _.Yj)(a);
        return new Promise(function(c, d) {
            uk(b, function(e) {
                a();
                c(e)
            }, function(e) {
                a();
                d(e)
            })
        }
        )
    }
    ;
    _.hk.prototype.rD = function(a, b) {
        return sk(this, null, (0,
        _.Yj)(a), b)
    }
    ;
    _.hk.prototype.catch = _.hk.prototype.rD;
    _.hk.prototype.cancel = function(a) {
        if (this.Ca == 0) {
            var b = new _.vk(a);
            _.fk(function() {
                wk(this, b)
            }, this)
        }
    }
    ;
    var wk = function(a, b) {
        if (a.Ca == 0)
            if (a.Hb) {
                var c = a.Hb;
                if (c.zl) {
                    for (var d = 0, e = null, f = null, h = c.zl; h && (h.Nx || (d++,
                    h.wn == a && (e = h),
                    !(e && d > 1))); h = h.next)
                        e || (f = h);
                    e && (c.Ca == 0 && d == 1 ? wk(c, b) : (f ? (d = f,
                    d.next == c.gq && (c.gq = d),
                    d.next = d.next.next) : xk(c),
                    yk(c, e, 3, b)))
                }
                a.Hb = null
            } else
                gk(a, 3, b)
    }
      , tk = function(a, b) {
        a.zl || a.Ca != 2 && a.Ca != 3 || zk(a);
        a.gq ? a.gq.next = b : a.zl = b;
        a.gq = b
    }
      , sk = function(a, b, c, d) {
        var e = kk(null, null, null);
        e.wn = new _.hk(function(f, h) {
            e.Hv = b ? function(k) {
                try {
                    var l = b.call(d, k);
                    f(l)
                } catch (m) {
                    h(m)
                }
            }
            : f;
            e.Dr = c ? function(k) {
                try {
                    var l = c.call(d, k);
                    l === void 0 && k instanceof _.vk ? h(k) : f(l)
                } catch (m) {
                    h(m)
                }
            }
            : h
        }
        );
        e.wn.Hb = a;
        tk(a, e);
        return e.wn
    };
    _.hk.prototype.Iga = function(a) {
        this.Ca = 0;
        gk(this, 2, a)
    }
    ;
    _.hk.prototype.Jga = function(a) {
        this.Ca = 0;
        gk(this, 3, a)
    }
    ;
    var gk = function(a, b, c) {
        a.Ca == 0 && (a === c && (b = 3,
        c = new TypeError("Promise cannot resolve to itself")),
        a.Ca = 1,
        nk(c, a.Iga, a.Jga, a) || (a.uf = c,
        a.Ca = b,
        a.Hb = null,
        zk(a),
        b != 3 || c instanceof _.vk || Ak(a, c)))
    }
      , nk = function(a, b, c, d) {
        if (a instanceof _.hk)
            return uk(a, b, c, d),
            !0;
        if (_.Xj(a))
            return a.then(b, c, d),
            !0;
        if (_.wb(a))
            try {
                var e = a.then;
                if (typeof e === "function")
                    return Bk(a, e, b, c, d),
                    !0
            } catch (f) {
                return c.call(d, f),
                !0
            }
        return !1
    }
      , Bk = function(a, b, c, d, e) {
        var f = !1
          , h = function(l) {
            f || (f = !0,
            c.call(e, l))
        }
          , k = function(l) {
            f || (f = !0,
            d.call(e, l))
        };
        try {
            b.call(a, h, k)
        } catch (l) {
            k(l)
        }
    }
      , zk = function(a) {
        a.TF || (a.TF = !0,
        _.fk(a.fz, a))
    }
      , xk = function(a) {
        var b = null;
        a.zl && (b = a.zl,
        a.zl = b.next,
        b.next = null);
        a.zl || (a.gq = null);
        return b
    };
    _.hk.prototype.fz = function() {
        for (var a; a = xk(this); )
            yk(this, a, this.Ca, this.uf);
        this.TF = !1
    }
    ;
    yk = function(a, b, c, d) {
        if (c == 3 && b.Dr && !b.Nx)
            for (; a && a.iA; a = a.Hb)
                a.iA = !1;
        if (b.wn)
            b.wn.Hb = null,
            Ck(b, c, d);
        else
            try {
                b.Nx ? b.Hv.call(b.context) : Ck(b, c, d)
            } catch (e) {
                Dk.call(null, e)
            }
        jk.put(b)
    }
    ;
    Ck = function(a, b, c) {
        b == 2 ? a.Hv.call(a.context, c) : a.Dr && a.Dr.call(a.context, c)
    }
    ;
    Ak = function(a, b) {
        a.iA = !0;
        _.fk(function() {
            a.iA && Dk.call(null, b)
        })
    }
    ;
    Dk = _.gh;
    _.vk = function(a) {
        _.lb.call(this, a);
        this.TY = !1
    }
    ;
    _.hb(_.vk, _.lb);
    _.vk.prototype.name = "cancel";
    var qk = function(a, b, c) {
        this.promise = a;
        this.resolve = b;
        this.reject = c
    };
    _.Ek = function(a) {
        return new _.hk(a)
    }
    ;
    var Mk = function() {
        this.gx = {
            OY: Fk ? "../" + Fk : null,
            Qy: Gk,
            PT: Hk,
            mra: Ik,
            jo: Jk,
            csa: Kk
        };
        this.Xf = _.qe;
        this.hY = this.M7;
        this.C8 = /MSIE\s*[0-8](\D|$)/.test(window.navigator.userAgent);
        if (this.gx.OY) {
            this.Xf = this.gx.PT(this.Xf, this.gx.OY);
            var a = this.Xf.document
              , b = a.createElement("script");
            b.setAttribute("type", "text/javascript");
            b.text = "window.doPostMsg=function(w,s,o) {window.setTimeout(function(){w.postMessage(s,o);},0);};";
            a.body.appendChild(b);
            this.hY = this.Xf.doPostMsg
        }
        this.TM = {};
        this.wN = {};
        a = (0,
        _.B)(this.qH, this);
        _.Fe(this.Xf, "message", a);
        _.ve(_.Ge, "RPMQ", []).push(a);
        this.Xf != this.Xf.parent && Lk(this, this.Xf.parent, this.HI(this.Xf.name), "*")
    };
    Mk.prototype.HI = function(a) {
        return '{"h":"' + escape(a) + '"}'
    }
    ;
    var Nk = function(a) {
        var b = null;
        a.indexOf('{"h":"') === 0 && a.indexOf('"}') === a.length - 2 && (b = unescape(a.substring(6, a.length - 2)));
        return b
    }
      , Ok = function(a) {
        if (!/^\s*{/.test(a))
            return !1;
        a = _.Gf(a);
        return a !== null && typeof a === "object" && !!a.g
    };
    Mk.prototype.qH = function(a) {
        var b = String(a.data);
        _.Lf.debug("gapix.rpc.receive(" + Ik + "): " + (!b || b.length <= 512 ? b : b.substr(0, 512) + "... (" + b.length + " bytes)"));
        var c = b.indexOf("!_") !== 0;
        c || (b = b.substring(2));
        var d = Ok(b);
        if (!c && !d) {
            if (!d && (c = Nk(b))) {
                if (this.TM[c])
                    this.TM[c]();
                else
                    this.wN[c] = 1;
                return
            }
            var e = a.origin
              , f = this.gx.Qy;
            this.C8 ? _.qe.setTimeout(function() {
                f(b, e)
            }, 0) : f(b, e)
        }
    }
    ;
    Mk.prototype.Jb = function(a, b) {
        a === ".." || this.wN[a] ? (b(),
        delete this.wN[a]) : this.TM[a] = b
    }
    ;
    var Lk = function(a, b, c, d) {
        var e = Ok(c) ? "" : "!_";
        _.Lf.debug("gapix.rpc.send(" + Ik + "): " + (!c || c.length <= 512 ? c : c.substr(0, 512) + "... (" + c.length + " bytes)"));
        a.hY(b, e + c, d)
    };
    Mk.prototype.M7 = function(a, b, c) {
        a.postMessage(b, c)
    }
    ;
    Mk.prototype.send = function(a, b, c) {
        (a = this.gx.PT(this.Xf, a)) && !a.closed && Lk(this, a, b, c)
    }
    ;
    var Pk, Qk, Rk, Sk, Tk, Uk, Vk, Fk, Ik, Wk, Xk, Yk, Hk, Jk, $k, al, fl, gl, il, Kk, kl, jl, bl, cl, ll, Gk, ml, ol;
    Pk = 0;
    Qk = [];
    Rk = {};
    Sk = {};
    Tk = _.qe.location.href;
    Uk = _.Ae(Tk, "rpctoken");
    Vk = _.Ae(Tk, "parent") || _.re.referrer;
    Fk = _.Ae(Tk, "rly");
    Ik = Fk || (_.qe !== _.qe.top || _.qe.opener) && _.qe.name || "..";
    Wk = null;
    Xk = {};
    Yk = function() {}
    ;
    _.Zk = {
        send: Yk,
        Jb: Yk,
        HI: Yk
    };
    Hk = function(a, b) {
        var c = a;
        b.charAt(0) == "/" && (b = b.substring(1),
        c = _.qe.top);
        if (b.length === 0)
            return c;
        for (b = b.split("/"); b.length; ) {
            a = b.shift();
            a.charAt(0) == "{" && a.charAt(a.length - 1) == "}" && (a = a.substring(1, a.length - 1));
            var d = a;
            if (d === "..")
                c = c == c.parent ? c.opener : c.parent;
            else if (d !== ".." && c.frames[d]) {
                var e = c;
                a = d;
                c = c.frames[d];
                if (!("postMessage"in c))
                    if (c instanceof HTMLIFrameElement && "contentWindow"in c)
                        c = c.contentWindow != null && "postMessage"in c.contentWindow ? c.contentWindow : null;
                    else {
                        d = null;
                        e = _.Aa(e.document.getElementsByTagName("iframe"));
                        for (var f = e.next(); !f.done; f = e.next())
                            if (f = f.value,
                            f.getAttribute("id") == a || f.getAttribute("name") == a)
                                d = f;
                        if (d && "contentWindow"in d)
                            c = d.contentWindow != null ? d.contentWindow : null;
                        else
                            throw Error("G`" + c + "`" + a);
                    }
            } else
                return null
        }
        return c
    }
    ;
    Jk = function(a) {
        return (a = Rk[a]) && a.token
    }
    ;
    $k = function(a) {
        if (a.f in {})
            return !1;
        var b = a.t
          , c = Rk[a.r];
        a = a.origin;
        return c && (c.token === b || !c.token && !b) && (a === c.origin || c.origin === "*")
    }
    ;
    al = function(a) {
        var b = a.id.split("/")
          , c = b[b.length - 1]
          , d = a.origin;
        return function(e) {
            var f = e.origin;
            return e.f == c && (d == f || d == "*")
        }
    }
    ;
    _.dl = function(a, b, c) {
        a = bl(a);
        Sk[a.name] = {
            Sh: b,
            vv: a.vv,
            Ks: c || $k
        };
        cl()
    }
    ;
    _.el = function(a) {
        a = bl(a);
        delete Sk[a.name]
    }
    ;
    fl = {};
    gl = function(a, b) {
        (a = fl["_" + a]) && a[1](this) && a[0].call(this, b)
    }
    ;
    il = function(a) {
        var b = a.c;
        if (!b)
            return Yk;
        var c = a.r
          , d = a.g ? "legacy__" : "";
        return function() {
            var e = [].slice.call(arguments, 0);
            e.unshift(c, d + "__cb", null, b);
            _.hl.apply(null, e)
        }
    }
    ;
    Kk = function(a) {
        Wk = a
    }
    ;
    kl = function(a) {
        Xk[a] || (Xk[a] = _.qe.setTimeout(function() {
            Xk[a] = !1;
            jl(a)
        }, 0))
    }
    ;
    jl = function(a) {
        var b = Rk[a];
        if (b && b.ready) {
            var c = b.XJ;
            for (b.XJ = []; c.length; )
                _.Zk.send(a, _.Hf(c.shift()), b.origin)
        }
    }
    ;
    bl = function(a) {
        return a.indexOf("legacy__") === 0 ? {
            name: a.substring(8),
            vv: !0
        } : {
            name: a,
            vv: !1
        }
    }
    ;
    cl = function() {
        for (var a = _.Sh("rpc/residenceSec") || 60, b = (new Date).getTime() / 1E3, c, d = 0; c = Qk[d]; ++d) {
            var e = c.kp;
            if (!e || a > 0 && b - c.timestamp > a)
                Qk.splice(d, 1),
                --d;
            else {
                var f = e.s
                  , h = Sk[f] || Sk["*"];
                if (h)
                    if (Qk.splice(d, 1),
                    --d,
                    e.origin = c.origin,
                    c = il(e),
                    e.callback = c,
                    h.Ks(e)) {
                        if (f !== "__cb" && !!h.vv != !!e.g)
                            break;
                        e = h.Sh.apply(e, e.a);
                        e !== void 0 && c(e)
                    } else
                        _.Lf.debug("gapix.rpc.rejected(" + Ik + "): " + f)
            }
        }
    }
    ;
    ll = function(a, b, c) {
        Qk.push({
            kp: a,
            origin: b,
            timestamp: (new Date).getTime() / 1E3
        });
        c || cl()
    }
    ;
    Gk = function(a, b) {
        a = _.Gf(a);
        ll(a, b, !1)
    }
    ;
    ml = function(a) {
        for (; a.length; )
            ll(a.shift(), this.origin, !0);
        cl()
    }
    ;
    ol = function(a) {
        var b = !1;
        a = a.split("|");
        var c = a[0];
        c.indexOf("/") >= 0 && (b = !0);
        return {
            id: c,
            origin: a[1] || "*",
            eI: b
        }
    }
    ;
    _.pl = function(a, b, c, d) {
        var e = ol(a);
        d && (_.qe.frames[e.id] = _.qe.frames[e.id] || d);
        a = e.id;
        if (!Rk.hasOwnProperty(a)) {
            c = c || null;
            d = e.origin;
            if (a === "..")
                d = _.xg(Vk),
                c = c || Uk;
            else if (!e.eI) {
                var f = _.re.getElementById(a);
                f && (f = f.src,
                d = _.xg(f),
                c = c || _.Ae(f, "rpctoken"))
            }
            e.origin === "*" && d || (d = e.origin);
            Rk[a] = {
                token: c,
                XJ: [],
                origin: d,
                Cea: b,
                HY: function() {
                    var h = a;
                    Rk[h].ready = 1;
                    jl(h)
                }
            };
            _.Zk.Jb(a, Rk[a].HY)
        }
        return Rk[a].HY
    }
    ;
    _.hl = function(a, b, c, d) {
        a = a || "..";
        _.pl(a);
        a = a.split("|", 1)[0];
        var e = b
          , f = a
          , h = [].slice.call(arguments, 3)
          , k = c
          , l = Ik
          , m = Uk
          , n = Rk[f]
          , p = l
          , q = ol(f);
        if (n && f !== "..") {
            if (q.eI) {
                if (!(m = Rk[f].Cea)) {
                    m = Wk ? Wk.substring(1).split("/") : [Ik];
                    p = m.length - 1;
                    for (f = _.qe.parent; f !== _.qe.top; ) {
                        var u = f.parent;
                        if (!p--) {
                            for (var v = null, t = u.frames.length, y = 0; y < t; ++y)
                                u.frames[y] == f && (v = y);
                            m.unshift("{" + v + "}")
                        }
                        f = u
                    }
                    m = "/" + m.join("/")
                }
                p = m
            } else
                p = l = "..";
            m = n.token
        }
        k && q ? (n = $k,
        q.eI && (n = al(q)),
        fl["_" + ++Pk] = [k, n],
        k = Pk) : k = null;
        h = {
            s: e,
            f: l,
            r: p,
            t: m,
            c: k,
            a: h
        };
        e = bl(e);
        h.s = e.name;
        h.g = e.vv;
        Rk[a].XJ.push(h);
        kl(a)
    }
    ;
    if (typeof _.qe.postMessage === "function" || typeof _.qe.postMessage === "object")
        _.Zk = new Mk,
        _.dl("__cb", gl, function() {
            return !0
        }),
        _.dl("_processBatch", ml, function() {
            return !0
        }),
        _.pl("..");
    var gm;
    gm = function() {
        function a(k, l) {
            k = window.getComputedStyle(k, "").getPropertyValue(l).match(/^([0-9]+)/);
            return parseInt(k[0], 10)
        }
        for (var b = 0, c = [document.body]; c.length > 0; ) {
            var d = c.shift()
              , e = d.childNodes;
            if (typeof d.style !== "undefined") {
                var f = d.style.overflowY;
                f || (f = (f = document.defaultView.getComputedStyle(d, null)) ? f.overflowY : null);
                if (f != "visible" && f != "inherit" && (f = d.style.height,
                f || (f = (f = document.defaultView.getComputedStyle(d, null)) ? f.height : ""),
                f.length > 0 && f != "auto"))
                    continue
            }
            for (d = 0; d < e.length; d++) {
                f = e[d];
                if (typeof f.offsetTop !== "undefined" && typeof f.offsetHeight !== "undefined") {
                    var h = f.offsetTop + f.offsetHeight + a(f, "margin-bottom");
                    b = Math.max(b, h)
                }
                c.push(f)
            }
        }
        return b + a(document.body, "border-bottom") + a(document.body, "margin-bottom") + a(document.body, "padding-bottom")
    }
    ;
    _.hm = function() {
        var a = 0;
        self.innerHeight ? a = self.innerHeight : document.documentElement && document.documentElement.clientHeight ? a = document.documentElement.clientHeight : document.body && (a = document.body.clientHeight);
        var b = document.body
          , c = document.documentElement;
        if (document.compatMode === "CSS1Compat" && c.scrollHeight)
            return c.scrollHeight !== a ? c.scrollHeight : c.offsetHeight;
        if (navigator.userAgent.indexOf("AppleWebKit") >= 0)
            return gm();
        if (b && c) {
            var d = c.scrollHeight
              , e = c.offsetHeight;
            c.clientHeight !== e && (d = b.scrollHeight,
            e = b.offsetHeight);
            return d > a ? d > e ? d : e : d < e ? d : e
        }
    }
    ;
    var im = function(a, b) {
        return _.Th(a, b, !0)
    }, jm = function(a) {
        this.T = a || {}
    }, km = function(a) {
        var b = function(c) {
            return new (a().Context)(c)
        };
        b.prototype.addOnConnectHandler = function(c, d, e, f) {
            return a().Context.prototype.addOnConnectHandler.apply(this, [c, d, e, f])
        }
        ;
        b.prototype.addOnOpenerHandler = function(c, d, e) {
            return a().Context.prototype.addOnOpenerHandler.apply(this, [c, d, e])
        }
        ;
        b.prototype.closeSelf = function(c, d, e) {
            return a().Context.prototype.closeSelf.apply(this, [c, d, e])
        }
        ;
        b.prototype.connectIframes = function(c, d) {
            a().Context.prototype.connectIframes.apply(this, [c, d])
        }
        ;
        b.prototype.getFrameName = function() {
            return a().Context.prototype.getFrameName.apply(this)
        }
        ;
        b.prototype.getGlobalParam = function(c) {
            a().Context.prototype.getGlobalParam.apply(this, [c])
        }
        ;
        b.prototype.getParentIframe = function() {
            return a().Context.prototype.getParentIframe.apply(this)
        }
        ;
        b.prototype.getWindow = function() {
            return a().Context.prototype.getWindow.apply(this)
        }
        ;
        b.prototype.isDisposed = function() {
            return a().Context.prototype.isDisposed.apply(this)
        }
        ;
        b.prototype.open = function(c, d) {
            return a().Context.prototype.open.apply(this, [c, d])
        }
        ;
        b.prototype.openChild = function(c) {
            return a().Context.prototype.openChild.apply(this, [c])
        }
        ;
        b.prototype.ready = function(c, d, e, f) {
            a().Context.prototype.ready.apply(this, [c, d, e, f])
        }
        ;
        b.prototype.removeOnConnectHandler = function(c) {
            a().Context.prototype.removeOnConnectHandler.apply(this, [c])
        }
        ;
        b.prototype.restyleSelf = function(c, d, e) {
            return a().Context.prototype.restyleSelf.apply(this, [c, d, e])
        }
        ;
        b.prototype.setCloseSelfFilter = function(c) {
            a().Context.prototype.setCloseSelfFilter.apply(this, [c])
        }
        ;
        b.prototype.setGlobalParam = function(c, d) {
            a().Context.prototype.setGlobalParam.apply(this, [c, d])
        }
        ;
        b.prototype.setRestyleSelfFilter = function(c) {
            a().Context.prototype.setRestyleSelfFilter.apply(this, [c])
        }
        ;
        return b
    }, lm = function(a) {
        var b = function(c, d, e, f) {
            return new (a().Iframe)(c,d,e,f)
        };
        b.prototype.applyIframesApi = function(c) {
            a().Iframe.prototype.applyIframesApi(c)
        }
        ;
        b.prototype.close = function(c, d) {
            return a().Iframe.prototype.close.apply(this, [c, d])
        }
        ;
        b.prototype.getContext = function() {
            return a().Iframe.prototype.getContext.apply(this, [])
        }
        ;
        b.prototype.getFrameName = function() {
            return a().Iframe.prototype.getFrameName.apply(this, [])
        }
        ;
        b.prototype.getId = function() {
            return a().Iframe.prototype.getId.apply(this, [])
        }
        ;
        b.prototype.getIframeEl = function() {
            return a().Iframe.prototype.getIframeEl.apply(this, [])
        }
        ;
        b.prototype.getOrigin = function() {
            return a().Iframe.prototype.getOrigin.apply(this, [])
        }
        ;
        b.prototype.getParam = function(c) {
            a().Iframe.prototype.getParam.apply(this, [c])
        }
        ;
        b.prototype.getSiteEl = function() {
            return a().Iframe.prototype.getSiteEl.apply(this, [])
        }
        ;
        b.prototype.getWindow = function() {
            return a().Iframe.prototype.getWindow.apply(this, [])
        }
        ;
        b.prototype.isDisposed = function() {
            return a().Iframe.prototype.isDisposed.apply(this, [])
        }
        ;
        b.prototype.ping = function(c, d) {
            return a().Iframe.prototype.ping.apply(this, [c, d])
        }
        ;
        b.prototype.register = function(c, d, e) {
            a().Iframe.prototype.register.apply(this, [c, d, e])
        }
        ;
        b.prototype.registerWasClosed = function(c, d) {
            a().Iframe.prototype.registerWasClosed.apply(this, [c, d])
        }
        ;
        b.prototype.registerWasRestyled = function(c, d) {
            a().Iframe.prototype.registerWasRestyled.apply(this, [c, d])
        }
        ;
        b.prototype.restyle = function(c, d) {
            return a().Iframe.prototype.restyle.apply(this, [c, d])
        }
        ;
        b.prototype.send = function(c, d, e, f) {
            return a().Iframe.prototype.send.apply(this, [c, d, e, f])
        }
        ;
        b.prototype.setParam = function(c, d) {
            a().Iframe.prototype.setParam.apply(this, [c, d])
        }
        ;
        b.prototype.setSiteEl = function(c) {
            a().Iframe.prototype.setSiteEl.apply(this, [c])
        }
        ;
        b.prototype.unregister = function(c, d) {
            a().Iframe.prototype.unregister.apply(this, [c, d])
        }
        ;
        return b
    }, mm, nm, rm, tm, ym, Gm, Hm, Jm, Nm, Om, Rm, Tm, Um, Wm, Vm, Xm;
    _.Lj.prototype.su = _.nb(5, function() {
        return this.T.controller
    });
    _.Lj.prototype.Vr = _.nb(4, function(a) {
        this.T.apis = a;
        return this
    });
    mm = function(a, b) {
        a.T.onload = b
    }
    ;
    nm = function(a) {
        return a.T.rpctoken
    }
    ;
    _.om = function(a, b) {
        a.T.queryParams = b;
        return a
    }
    ;
    _.pm = function(a, b) {
        a.T.relayOpen = b;
        return a
    }
    ;
    _.qm = function(a, b) {
        a.T.onClose = b;
        return a
    }
    ;
    rm = function(a, b) {
        a.T.controllerData = b
    }
    ;
    _.sm = function(a) {
        a.T.waitForOnload = !0
    }
    ;
    tm = function(a) {
        return (a = a.T.timeout) ? a : null
    }
    ;
    _.um = function(a) {
        return !!a && typeof a === "object" && _.ue.test(a.push)
    }
    ;
    _.vm = function(a) {
        for (var b = 0; b < this.length; b++)
            if (this[b] === a)
                return b;
        return -1
    }
    ;
    _.wm = function(a, b, c) {
        if (a) {
            _.ql(_.um(a), "arrayForEach was called with a non array value");
            for (var d = 0; d < a.length; d++)
                b.call(c, a[d], d)
        }
    }
    ;
    _.xm = function(a, b, c) {
        if (a)
            if (_.um(a))
                _.wm(a, b, c);
            else {
                _.ql(typeof a === "object", "objectForEach was called with a non object value");
                c = c || a;
                for (var d in a)
                    _.xe(a, d) && a[d] !== void 0 && b.call(c, a[d], d)
            }
    }
    ;
    ym = function(a) {
        this.T = a || {}
    }
    ;
    ym.prototype.value = function() {
        return this.T
    }
    ;
    ym.prototype.getIframe = function() {
        return this.T.iframe
    }
    ;
    var zm = function(a, b) {
        a.T.role = b;
        return a
    }
      , Am = function(a, b) {
        a.T.data = b;
        return a
    };
    ym.prototype.Uk = function(a) {
        this.T.setRpcReady = a;
        return this
    }
    ;
    var Bm = function(a) {
        return a.T.setRpcReady
    };
    ym.prototype.Zm = function(a) {
        this.T.rpctoken = a;
        return this
    }
    ;
    var Cm = function(a) {
        a.T.selfConnect = !0;
        return a
    };
    jm.prototype.value = function() {
        return this.T
    }
    ;
    var Em = function(a) {
        var b = new Dm;
        b.T.role = a;
        return b
    };
    jm.prototype.ET = function() {
        return this.T.role
    }
    ;
    jm.prototype.Fc = function(a) {
        this.T.handler = a;
        return this
    }
    ;
    jm.prototype.wb = function() {
        return this.T.handler
    }
    ;
    var Fm = function(a, b) {
        a.T.filter = b;
        return a
    };
    jm.prototype.Vr = function(a) {
        this.T.apis = a;
        return this
    }
    ;
    Jm = /^[\w\.\-]*$/;
    _.Km = function(a) {
        return a.getOrigin() === a.getContext().getOrigin()
    }
    ;
    _.Lm = function() {
        return !0
    }
    ;
    _.Mm = function(a) {
        for (var b = _.we(), c = 0; c < a.length; c++)
            b[a[c]] = !0;
        return function(d) {
            return !!b[d.Dd]
        }
    }
    ;
    Nm = function(a, b, c) {
        a = Gm[a];
        if (!a)
            return [];
        for (var d = [], e = 0; e < a.length; e++)
            d.push(_.lk(a[e].call(c, b, c)));
        return d
    }
    ;
    Om = function(a, b, c) {
        return function(d) {
            if (!b.isDisposed()) {
                var e = this.origin
                  , f = b.getOrigin();
                _.ql(e === f, "Wrong origin " + e + " != " + f);
                e = this.callback;
                d = Nm(a, d, b);
                !c && d.length > 0 && _.pk(d).then(e)
            }
        }
    }
    ;
    _.Pm = function(a, b, c) {
        _.ql(a != "_default", "Cannot update default api");
        Hm[a] = {
            map: b,
            filter: c
        }
    }
    ;
    _.Qm = function(a, b, c) {
        _.ql(a != "_default", "Cannot update default api");
        _.ve(Hm, a, {
            map: {},
            filter: _.Km
        }).map[b] = c
    }
    ;
    Rm = function(a, b) {
        _.ve(Hm, "_default", {
            map: {},
            filter: _.Lm
        }).map[a] = b;
        _.xm(_.Im.hg, function(c) {
            c.register(a, b, _.Lm)
        })
    }
    ;
    _.Sm = function() {
        return _.Im
    }
    ;
    Tm = /^https?:\/\/[^\/%\\?#\s]+$/i;
    Um = {
        longdesc: !0,
        name: !0,
        src: !0,
        frameborder: !0,
        marginwidth: !0,
        marginheight: !0,
        scrolling: !0,
        align: !0,
        height: !0,
        width: !0,
        id: !0,
        "class": !0,
        title: !0,
        tabindex: !0,
        hspace: !0,
        vspace: !0,
        allowtransparency: !0
    };
    Wm = function(a) {
        this.resolve = this.reject = null;
        this.promise = _.Ek((0,
        _.B)(function(b, c) {
            this.resolve = b;
            this.reject = c
        }, this));
        a && (this.promise = Vm(this.promise, a))
    }
    ;
    Vm = function(a, b) {
        return a.then(function(c) {
            try {
                b(c)
            } catch (d) {}
            return c
        })
    }
    ;
    Xm = function(a) {
        this.kg = a;
        this.Context = km(a);
        this.Iframe = lm(a)
    }
    ;
    _.g = Xm.prototype;
    _.g.CROSS_ORIGIN_IFRAMES_FILTER = function(a) {
        return this.kg().CROSS_ORIGIN_IFRAMES_FILTER(a)
    }
    ;
    _.g.SAME_ORIGIN_IFRAMES_FILTER = function(a) {
        return this.kg().SAME_ORIGIN_IFRAMES_FILTER(a)
    }
    ;
    _.g.create = function(a, b, c) {
        return this.kg().create(a, b, c)
    }
    ;
    _.g.getBeforeOpenStyle = function(a) {
        return this.kg().getBeforeOpenStyle(a)
    }
    ;
    _.g.getContext = function() {
        return this.kg().getContext()
    }
    ;
    _.g.getStyle = function(a) {
        return this.kg().getStyle(a)
    }
    ;
    _.g.makeWhiteListIframesFilter = function(a) {
        return this.kg().makeWhiteListIframesFilter(a)
    }
    ;
    _.g.registerBeforeOpenStyle = function(a, b) {
        return this.kg().registerBeforeOpenStyle(a, b)
    }
    ;
    _.g.registerIframesApi = function(a, b, c) {
        return this.kg().registerIframesApi(a, b, c)
    }
    ;
    _.g.registerIframesApiHandler = function(a, b, c) {
        return this.kg().registerIframesApiHandler(a, b, c)
    }
    ;
    _.g.registerStyle = function(a, b) {
        return this.kg().registerStyle(a, b)
    }
    ;
    var Ym = function() {
        this.Ai = []
    };
    Ym.prototype.kg = function(a) {
        return this.Ai.length ? Zm(this.Ai[0], a) : void 0
    }
    ;
    var Zm = function(a, b) {
        b = b === void 0 ? function(c) {
            return new c
        }
        : b;
        return a.ctor ? b(a.ctor) : a.instance
    }
      , $m = function() {
        Ym.apply(this, arguments)
    };
    _.r($m, Ym);
    var bn = function(a) {
        var b = an.HQ
          , c = a.priority
          , d = ~im(b.Ai, function(e) {
            return e.priority < c ? -1 : 1
        });
        b.Ai.splice(d, 0, a)
    };
    var an = new function() {
        var a = this;
        this.HQ = new $m;
        this.instance = new Xm(function() {
            return a.HQ.kg()()
        }
        )
    }
    ;
    bn({
        instance: function() {
            return window.gapi.iframes
        },
        priority: 1
    });
    _.cn = an.instance;
    var dn, en;
    dn = {
        height: !0,
        width: !0
    };
    en = /^(?!-*(?:expression|(?:moz-)?binding))(?:[.#]?-?(?:[_a-z0-9-]+)(?:-[_a-z0-9-]+)*-?|-?(?:[0-9]+(?:\.[0-9]*)?|\.[0-9]+)(?:[a-z]{1,2}|%)?|!important|)$/i;
    _.fn = function(a) {
        typeof a === "number" && (a = String(a) + "px");
        return a
    }
    ;
    var gn = function() {
        ym.apply(this, arguments)
    };
    _.r(gn, ym);
    var Dm = function() {
        jm.apply(this, arguments)
    };
    _.r(Dm, jm);
    var hn = function() {
        _.Lj.apply(this, arguments)
    };
    _.r(hn, _.Lj);
    var jn = function(a) {
        hn.call(this, a)
    };
    _.r(jn, hn);
    var kn = function(a, b) {
        a.T.frameName = b;
        return a
    };
    jn.prototype.getFrameName = function() {
        return this.T.frameName
    }
    ;
    var ln = function(a, b) {
        a.T.rpcAddr = b;
        return a
    };
    jn.prototype.ug = function() {
        return this.T.rpcAddr
    }
    ;
    var mn = function(a, b) {
        a.T.retAddr = b;
        return a
    };
    _.g = jn.prototype;
    _.g.bi = function() {
        return this.T.retAddr
    }
    ;
    _.g.Ij = function(a) {
        this.T.origin = a;
        return this
    }
    ;
    _.g.getOrigin = function() {
        return this.T.origin
    }
    ;
    _.g.Uk = function(a) {
        this.T.setRpcReady = a;
        return this
    }
    ;
    _.g.wp = function(a) {
        this.T.context = a
    }
    ;
    var nn = function(a, b) {
        a.T._rpcReadyFn = b
    };
    jn.prototype.getIframeEl = function() {
        return this.T.iframeEl
    }
    ;
    var on = function(a, b, c) {
        var d = a.ug()
          , e = b.bi();
        mn(ln(c, a.bi() + "/" + b.ug()), e + "/" + d);
        kn(c, b.getFrameName()).Ij(b.getOrigin())
    };
    var qn = function(a, b, c) {
        a.setTimeout(function() {
            b.closed || c == 5 ? pn(b) : (b.close(),
            c++,
            qn(a, b, c))
        }, 1E3)
    }
      , pn = function(a) {
        a.closed || a.document && a.document.body && _.oe(a.document.body, "Please close this window.")
    };
    _.rn = function(a, b, c, d) {
        this.Qg = !1;
        this.qb = a;
        this.tK = b;
        this.wq = c;
        this.Ja = d;
        this.fZ = this.Ja.bi();
        this.Dd = this.Ja.getOrigin();
        this.Saa = this.Ja.getIframeEl();
        this.S_ = this.Ja.T.where;
        this.Ai = [];
        this.applyIframesApi("_default");
        a = this.Ja.T.apis || [];
        for (b = 0; b < a.length; b++)
            this.applyIframesApi(a[b]);
        this.qb.hg[c] = this
    }
    ;
    _.g = _.rn.prototype;
    _.g.isDisposed = function() {
        return this.Qg
    }
    ;
    _.g.dispose = function() {
        if (!this.isDisposed()) {
            for (var a = 0; a < this.Ai.length; a++)
                this.unregister(this.Ai[a]);
            delete _.Im.hg[this.getFrameName()];
            this.Qg = !0
        }
    }
    ;
    _.g.getContext = function() {
        return this.qb
    }
    ;
    _.g.getOptions = function() {
        return this.Ja
    }
    ;
    _.g.ug = function() {
        return this.tK
    }
    ;
    _.g.bi = function() {
        return this.fZ
    }
    ;
    _.g.getFrameName = function() {
        return this.wq
    }
    ;
    _.g.getIframeEl = function() {
        return this.Saa
    }
    ;
    _.g.getSiteEl = function() {
        return this.S_
    }
    ;
    _.g.setSiteEl = function(a) {
        this.S_ = a
    }
    ;
    _.g.Uk = function() {
        (0,
        this.Ja.T._rpcReadyFn)()
    }
    ;
    _.g.setParam = function(a, b) {
        this.Ja.value()[a] = b
    }
    ;
    _.g.getParam = function(a) {
        return this.Ja.value()[a]
    }
    ;
    _.g.xc = function() {
        return this.Ja.value()
    }
    ;
    _.g.getId = function() {
        return this.Ja.getId()
    }
    ;
    _.g.getOrigin = function() {
        return this.Dd
    }
    ;
    var sn = function(a, b) {
        var c = a.wq;
        a = a.qb.getFrameName();
        return c + ":" + a + ":" + b
    };
    _.g = _.rn.prototype;
    _.g.register = function(a, b, c) {
        _.ql(!this.isDisposed(), "Cannot register handler on disposed iframe " + a);
        _.ql((c || _.Km)(this), "Rejecting untrusted message " + a);
        c = sn(this, a);
        _.ve(Gm, c, []).push(b) == 1 && (this.Ai.push(a),
        _.dl(c, Om(c, this, a === "_g_wasClosed")))
    }
    ;
    _.g.unregister = function(a, b) {
        var c = sn(this, a)
          , d = Gm[c];
        d && (b ? (b = _.vm.call(d, b),
        b >= 0 && d.splice(b, 1)) : d.splice(0, d.length),
        d.length == 0 && (b = _.vm.call(this.Ai, a),
        b >= 0 && this.Ai.splice(b, 1),
        _.el(c)))
    }
    ;
    _.g.R9 = function() {
        return this.Ai
    }
    ;
    _.g.applyIframesApi = function(a) {
        this.zE = this.zE || [];
        if (!(_.vm.call(this.zE, a) >= 0)) {
            this.zE.push(a);
            a = Hm[a] || {
                map: {}
            };
            for (var b in a.map)
                _.xe(a.map, b) && this.register(b, a.map[b], a.filter)
        }
    }
    ;
    _.g.getWindow = function() {
        if (!_.Km(this))
            return null;
        var a = this.Ja.T._popupWindow;
        if (a)
            return a;
        var b = this.tK.split("/");
        a = this.getContext().getWindow();
        for (var c = 0; c < b.length && a; c++) {
            var d = b[c];
            a = ".." === d ? a == a.parent ? a.opener : a.parent : a.frames[d]
        }
        return a
    }
    ;
    var tn = function(a) {
        var b = {};
        if (a)
            for (var c in a)
                _.xe(a, c) && _.xe(dn, c) && en.test(a[c]) && (b[c] = a[c]);
        return b
    };
    _.g = _.rn.prototype;
    _.g.close = function(a, b) {
        return un(this, "_g_close", a, b)
    }
    ;
    _.g.restyle = function(a, b) {
        return un(this, "_g_restyle", a, b)
    }
    ;
    _.g.Pr = function(a, b) {
        return un(this, "_g_restyleDone", a, b)
    }
    ;
    _.g.o7 = function(a) {
        return this.getContext().closeSelf(a, void 0, this)
    }
    ;
    _.g.yea = function(a) {
        if (a && typeof a === "object")
            return this.getContext().restyleSelf(a, void 0, this)
    }
    ;
    _.g.zea = function(a) {
        var b = this.Ja.T.onRestyle;
        b && b.call(this, a, this);
        a = a && typeof a === "object" ? tn(a) : {};
        (b = this.getIframeEl()) && a && typeof a === "object" && (_.xe(a, "height") && (a.height = _.fn(a.height)),
        _.xe(a, "width") && (a.width = _.fn(a.width)),
        _.ye(a, b.style))
    }
    ;
    _.g.p7 = function(a) {
        var b = this.Ja.T.onClose;
        b && b.call(this, a, this);
        if (b = this.getOptions().T._popupWindow) {
            var c = this.getContext().getWindow().document.getElementById(this.getId());
            c && c.parentNode && c.parentNode.removeChild(c);
            c = this.getContext().getWindow();
            _.yd && _.rh && c ? (c.focus(),
            qn(c, b, 0)) : (b.close(),
            pn(b))
        }
        b || (b = this.getIframeEl()) && b.parentNode && b.parentNode.removeChild(b);
        if (b = this.Ja.su())
            c = {},
            c.frameName = this.getFrameName(),
            un(b, "_g_disposeControl", c);
        b = sn(this, "_g_wasClosed");
        Nm(b, a, this)
    }
    ;
    _.g.registerWasRestyled = function(a, b) {
        this.register("_g_wasRestyled", a, b)
    }
    ;
    _.g.registerWasClosed = function(a, b) {
        this.register("_g_wasClosed", a, b)
    }
    ;
    _.g.dha = function() {
        delete this.getContext().hg[this.getFrameName()];
        this.getContext().getWindow().setTimeout((0,
        _.B)(function() {
            this.dispose()
        }, this), 0)
    }
    ;
    _.g.send = function(a, b, c, d) {
        _.ql(!this.isDisposed(), "Cannot send message to disposed iframe - " + a);
        _.ql((d || _.Km)(this), "Wrong target for message " + a);
        c = new Wm(c);
        a = this.qb.getFrameName() + ":" + this.wq + ":" + a;
        _.hl(this.tK, a, c.resolve, b);
        return c.promise
    }
    ;
    var un = function(a, b, c, d) {
        return a.send(b, c, d, _.Lm)
    };
    _.g = _.rn.prototype;
    _.g.zda = function(a) {
        return a
    }
    ;
    _.g.ping = function(a, b) {
        return un(this, "_g_ping", b, a)
    }
    ;
    _.g.y7 = function(a) {
        a = a && typeof a === "object" ? a : {};
        for (var b = a.rpcAddr, c = (this.ug() + "/" + b).split("/"), d = this.getContext().getWindow(), e; (e = c.shift()) && d; )
            d = e == ".." ? d.parent : d.frames[e];
        _.ql(!!d, "Bad rpc address " + b);
        a._window = d;
        a._parentRpcAddr = this.ug();
        a._parentRetAddr = this.bi();
        this.getContext();
        b = new _.vn(a);
        this.Nca && this.Nca(b, a.controllerData);
        this.kF = this.kF || [];
        this.kF.push(b, a.controllerData)
    }
    ;
    _.g.Q7 = function(a) {
        a = (a || {}).frameName;
        for (var b = this.kF || [], c = 0; c < b.length; c++)
            if (b[c].getFrameName() === a) {
                a = b.splice(c, 1)[0];
                a.dispose();
                this.Rca && this.Rca(a);
                return
            }
        _.ql(!1, "Unknown contolled iframe to dispose - " + a)
    }
    ;
    _.g.v7 = function(a) {
        var b = new jn(a);
        a = new gn(b.value());
        if (a.T.selfConnect)
            var c = this;
        else
            (_.ql(Tm.test(b.getOrigin()), "Illegal origin for connected iframe - " + b.getOrigin()),
            c = this.getContext().hg[b.getFrameName()],
            c) ? Bm(b) && (c.Uk(),
            un(c, "_g_rpcReady")) : (b = kn(mn(ln(new jn, b.ug()), b.bi()).Ij(b.getOrigin()), b.getFrameName()).Uk(Bm(b)).Zm(nm(b)),
            c = this.getContext().attach(b.value()));
        b = this.getContext();
        var d = a.T.role;
        a = a.T.data;
        wn(b);
        d = d || "";
        _.ve(b.iF, d, []).push({
            hf: c,
            data: a
        });
        xn(c, a, b.kJ[d])
    }
    ;
    _.g.ZL = function(a, b) {
        (new jn(b)).T._relayedDepth || (b = {},
        Cm(zm(new gn(b), "_opener")),
        un(a, "_g_connect", b))
    }
    ;
    _.g.BX = function(a) {
        var b = this
          , c = a.T.messageHandlers
          , d = a.T.messageHandlersFilter
          , e = a.T.onClose;
        _.qm(_.Nj(_.Mj(a, null), null), null);
        return un(this, "_g_open", a.value()).then(function(f) {
            var h = new jn(f[0])
              , k = h.getFrameName();
            f = new jn;
            var l = b.bi()
              , m = h.bi();
            mn(ln(f, b.ug() + "/" + h.ug()), m + "/" + l);
            kn(f, k);
            f.Ij(h.getOrigin());
            f.Vr(h.T.apis);
            f.Zm(nm(a));
            _.Mj(f, c);
            _.Nj(f, d);
            _.qm(f, e);
            (h = b.getContext().hg[k]) || (h = b.getContext().attach(f.value()));
            return h
        })
    }
    ;
    _.g.wK = function(a) {
        var b = a.getUrl();
        _.ql(!b || _.Jl.test(b), "Illegal url for new iframe - " + b);
        var c = a.Wn().value();
        b = {};
        for (var d in c)
            _.xe(c, d) && _.xe(Um, d) && (b[d] = c[d]);
        _.xe(c, "style") && (d = c.style,
        typeof d === "object" && (b.style = tn(d)));
        a.value().attributes = b
    }
    ;
    _.g.jda = function(a) {
        a = new jn(a);
        this.wK(a);
        var b = a.T._relayedDepth || 0;
        a.T._relayedDepth = b + 1;
        a.T.openerIframe = this;
        var c = nm(a);
        a.Zm(null);
        var d = this;
        return this.getContext().open(a.value()).then(function(e) {
            var f = (new jn(e.xc())).T.apis
              , h = new jn;
            on(e, d, h);
            b == 0 && zm(new gn(h.value()), "_opener");
            h.Uk(!0);
            h.Zm(c);
            un(e, "_g_connect", h.value());
            h = new jn;
            kn(mn(ln(h, e.ug()), e.fZ), e.getFrameName()).Ij(e.getOrigin()).Vr(f);
            return h.value()
        })
    }
    ;
    _.g.xea = function(a) {
        this.getContext().addOnOpenerHandler(function(b) {
            b.send("_g_wasRestyled", a, void 0, _.Lm)
        }, null, _.Lm)
    }
    ;
    var Cn;
    _.yn = _.we();
    _.zn = _.we();
    _.An = function(a, b) {
        _.yn[a] = b
    }
    ;
    _.Bn = function(a) {
        return _.yn[a]
    }
    ;
    Cn = function(a, b) {
        _.ze.load("gapi.iframes.style." + a, b)
    }
    ;
    _.Dn = function(a, b) {
        _.zn[a] = b
    }
    ;
    _.En = function(a) {
        return _.zn[a]
    }
    ;
    _.vn = function(a) {
        a = a || {};
        this.Qg = !1;
        this.yi = _.we();
        this.hg = _.we();
        this.Xf = a._window || _.qe;
        this.Id = this.Xf.location.href;
        this.SX = (this.EJ = Fn(this.Id, "parent")) ? Fn(this.Id, "pfname") : "";
        this.Da = this.EJ ? Fn(this.Id, "_gfid") || Fn(this.Id, "id") : "";
        this.wq = _.Wl(this.Da, this.SX);
        this.Dd = _.xg(this.Id);
        if (this.Da) {
            var b = new jn;
            ln(b, a._parentRpcAddr || "..");
            mn(b, a._parentRetAddr || this.Da);
            b.Ij(_.xg(this.EJ || this.Id));
            kn(b, this.SX);
            this.Hb = this.attach(b.value())
        } else
            this.Hb = null
    }
    ;
    _.g = _.vn.prototype;
    _.g.isDisposed = function() {
        return this.Qg
    }
    ;
    _.g.dispose = function() {
        if (!this.isDisposed()) {
            for (var a = _.Aa(Object.values(this.hg)), b = a.next(); !b.done; b = a.next())
                b.value.dispose();
            this.Qg = !0
        }
    }
    ;
    _.g.getFrameName = function() {
        return this.wq
    }
    ;
    _.g.getOrigin = function() {
        return this.Dd
    }
    ;
    _.g.getWindow = function() {
        return this.Xf
    }
    ;
    _.g.ub = function() {
        return this.Xf.document
    }
    ;
    _.g.setGlobalParam = function(a, b) {
        this.yi[a] = b
    }
    ;
    _.g.getGlobalParam = function(a) {
        return this.yi[a]
    }
    ;
    _.g.attach = function(a) {
        _.ql(!this.isDisposed(), "Cannot attach iframe in disposed context");
        a = new jn(a);
        a.ug() || ln(a, a.getId());
        a.bi() || mn(a, "..");
        a.getOrigin() || a.Ij(_.xg(a.getUrl()));
        a.getFrameName() || kn(a, _.Wl(a.getId(), this.wq));
        var b = a.getFrameName();
        if (this.hg[b])
            return this.hg[b];
        var c = a.ug()
          , d = c;
        a.getOrigin() && (d = c + "|" + a.getOrigin());
        var e = a.bi()
          , f = nm(a);
        f || (f = (f = a.getIframeEl()) && (f.getAttribute("data-postorigin") || f.src) || a.getUrl(),
        f = _.Ae(f, "rpctoken"));
        nn(a, _.pl(d, e, f, a.T._popupWindow));
        d = ((window.gadgets || {}).rpc || {}).setAuthToken;
        f && d && d(c, f);
        var h = new _.rn(this,c,b,a)
          , k = a.T.messageHandlersFilter;
        _.xm(a.T.messageHandlers, function(l, m) {
            h.register(m, l, k)
        });
        Bm(a) && h.Uk();
        un(h, "_g_rpcReady");
        return h
    }
    ;
    _.g.wK = function(a) {
        kn(a, null);
        var b = a.getId();
        !b || Jm.test(b) && !this.getWindow().document.getElementById(b) || (_.Lf.log("Ignoring requested iframe ID - " + b),
        a.Ne(null))
    }
    ;
    var Fn = function(a, b) {
        var c = _.Ae(a, b);
        c || (c = _.Gf(_.Ae(a, "jcp", ""))[b]);
        return c || ""
    };
    _.vn.prototype.openChild = function(a) {
        _.ql(!this.isDisposed(), "Cannot open iframe in disposed context");
        var b = new jn(a);
        Gn(this, b);
        var c = b.getFrameName();
        if (c && this.hg[c])
            return this.hg[c];
        this.wK(b);
        c = b.getUrl();
        _.ql(c, "No url for new iframe");
        var d = b.T.queryParams || {};
        d.usegapi = "1";
        _.om(b, d);
        d = this.sU && this.sU(c, b);
        d || (d = b.T.where,
        _.ql(!!d, "No location for new iframe"),
        c = _.fm(c, d, a),
        b.T.iframeEl = c,
        d = c.getAttribute("id"));
        ln(b, d).Ne(d);
        b.Ij(_.xg(b.T.eurl || ""));
        this.AW && this.AW(b, b.getIframeEl());
        c = this.attach(a);
        c.ZL && c.ZL(c, a);
        (a = b.T.onCreate) && a(c);
        b.T.disableRelayOpen || c.applyIframesApi("_open");
        return c
    }
    ;
    var Hn = function(a, b, c) {
        var d = b.T.canvasUrl;
        if (!d)
            return c;
        _.ql(!b.T.allowPost && !b.T.forcePost, "Post is not supported when using canvas url");
        var e = b.getUrl();
        _.ql(e && _.xg(e) === a.Dd && _.xg(d) === a.Dd, "Wrong origin for canvas or hidden url " + d);
        b.setUrl(d);
        _.sm(b);
        b.T.canvasUrl = null;
        return function(f) {
            var h = f.getWindow()
              , k = h.location.hash;
            k = _.em(e) + (/#/.test(e) ? k.replace(/^#/, "&") : k);
            h.location.replace(k);
            c && c(f)
        }
    }
      , In = function(a, b, c) {
        var d = b.T.relayOpen;
        if (d) {
            var e = a.getParentIframe();
            d instanceof _.rn ? (e = d,
            _.pm(b, 0)) : Number(d) > 0 && _.pm(b, Number(d) - 1);
            if (e) {
                _.ql(!!e.BX, "Relaying iframe open is disabled");
                if (d = b.getStyle())
                    if (d = _.zn[d])
                        b.wp(a),
                        d(b.value()),
                        b.wp(null);
                b.T.openerIframe = null;
                c.resolve(e.BX(b));
                return !0
            }
        }
        return !1
    }
      , Jn = function(a, b, c) {
        var d = b.getStyle();
        if (d)
            if (_.ql(!!_.Bn, "Defer style is disabled, when requesting style " + d),
            _.yn[d])
                Gn(a, b);
            else
                return Cn(d, function() {
                    _.ql(!!_.yn[d], "Fail to load style - " + d);
                    c.resolve(a.open(b.value()))
                }),
                !0;
        return !1
    };
    _.vn.prototype.open = function(a, b) {
        _.ql(!this.isDisposed(), "Cannot open iframe in disposed context");
        var c = new jn(a);
        b = Hn(this, c, b);
        var d = new Wm(b);
        (b = c.getUrl()) && c.setUrl(_.em(b));
        if (In(this, c, d) || Jn(this, c, d) || In(this, c, d))
            return d.promise;
        if (tm(c) != null) {
            var e = setTimeout(function() {
                h.getIframeEl().src = "about:blank";
                d.reject({
                    timeout: "Exceeded time limit of :" + tm(c) + "milliseconds"
                })
            }, tm(c))
              , f = d.resolve;
            d.resolve = function(k) {
                clearTimeout(e);
                f(k)
            }
        }
        c.T.waitForOnload && mm(c.Wn(), function() {
            d.resolve(h)
        });
        var h = this.openChild(a);
        c.T.waitForOnload || d.resolve(h);
        return d.promise
    }
    ;
    _.vn.prototype.getParentIframe = function() {
        return this.Hb
    }
    ;
    var Kn = function(a, b) {
        var c = a.getParentIframe()
          , d = !0;
        b.filter && (d = b.filter.call(b.hf, b.params));
        return _.lk(d).then(function(e) {
            return e && c ? (b.QX && b.QX.call(a, b.params),
            e = b.sender ? b.sender(b.params) : un(c, b.message, b.params),
            b.bha ? e.then(function() {
                return !0
            }) : !0) : !1
        })
    };
    _.g = _.vn.prototype;
    _.g.closeSelf = function(a, b, c) {
        a = Kn(this, {
            sender: function(d) {
                var e = _.Im.getParentIframe();
                _.xm(_.Im.hg, function(f) {
                    f !== e && un(f, "_g_wasClosed", d)
                });
                return un(e, "_g_closeMe", d)
            },
            message: "_g_closeMe",
            params: a,
            hf: c,
            filter: this.getGlobalParam("onCloseSelfFilter")
        });
        b = new Wm(b);
        b.resolve(a);
        return b.promise
    }
    ;
    _.g.restyleSelf = function(a, b, c) {
        a = a || {};
        b = new Wm(b);
        b.resolve(Kn(this, {
            message: "_g_restyleMe",
            params: a,
            hf: c,
            filter: this.getGlobalParam("onRestyleSelfFilter"),
            bha: !0,
            QX: this.W0
        }));
        return b.promise
    }
    ;
    _.g.W0 = function(a) {
        a.height === "auto" && (a.height = _.hm())
    }
    ;
    _.g.setCloseSelfFilter = function(a) {
        this.setGlobalParam("onCloseSelfFilter", a)
    }
    ;
    _.g.setRestyleSelfFilter = function(a) {
        this.setGlobalParam("onRestyleSelfFilter", a)
    }
    ;
    var Gn = function(a, b) {
        var c = b.getStyle();
        if (c) {
            b.Fi(null);
            var d = _.yn[c];
            _.ql(d, "No such style: " + c);
            b.wp(a);
            d(b.value());
            b.wp(null)
        }
    };
    _.vn.prototype.ready = function(a, b, c, d) {
        var e = b || {}
          , f = this.getParentIframe();
        this.addOnOpenerHandler(function(k) {
            _.xm(e, function(l, m) {
                k.register(m, l, d)
            }, this);
            k !== f && k.send("_ready", h, void 0, d)
        }, void 0, d);
        var h = a || {};
        h.height = h.height || "auto";
        this.W0(h);
        f && f.send("_ready", h, c, _.Lm)
    }
    ;
    _.vn.prototype.connectIframes = function(a, b) {
        a = new gn(a);
        var c = new gn(b)
          , d = Bm(a);
        b = a.getIframe();
        var e = c.getIframe();
        if (e) {
            var f = nm(a)
              , h = new jn;
            on(b, e, h);
            Am(zm((new gn(h.value())).Zm(f), a.T.role), a.T.data).Uk(d);
            var k = new jn;
            on(e, b, k);
            Am(zm((new gn(k.value())).Zm(f), c.T.role), c.T.data).Uk(!0);
            un(b, "_g_connect", h.value(), function() {
                d || un(e, "_g_connect", k.value())
            });
            d && un(e, "_g_connect", k.value())
        } else
            c = {},
            Am(zm(Cm(new gn(c)), a.T.role), a.T.data),
            un(b, "_g_connect", c)
    }
    ;
    var wn = function(a) {
        a.iF || (a.iF = _.we(),
        a.kJ = _.we())
    };
    _.vn.prototype.addOnConnectHandler = function(a, b, c, d) {
        wn(this);
        typeof a === "object" ? (b = new Dm(a),
        c = b.ET() || "") : (b = Fm(Em(a).Fc(b).Vr(c), d),
        c = a);
        d = this.iF[c] || [];
        a = !1;
        for (var e = 0; e < d.length && !a; e++)
            xn(this.hg[d[e].hf.getFrameName()], d[e].data, [b]),
            a = b.T.runOnce;
        c = _.ve(this.kJ, c, []);
        a || b.T.dontWait || c.push(b)
    }
    ;
    _.vn.prototype.removeOnConnectHandler = function(a, b) {
        a = _.ve(this.kJ, a, []);
        if (b)
            for (var c = !1, d = 0; !c && d < a.length; d++)
                a[d].wb() === b && (c = !0,
                a.splice(d, 1));
        else
            a.splice(0, a.length)
    }
    ;
    var xn = function(a, b, c) {
        c = c || [];
        for (var d = 0; d < c.length; d++) {
            var e = c[d];
            if (e && a) {
                var f = e.T.filter || _.Km;
                if (a && f(a)) {
                    f = e.T.apis || [];
                    for (var h = 0; h < f.length; h++)
                        a.applyIframesApi(f[h]);
                    e.wb() && e.wb()(a, b);
                    e.T.runOnce && (c.splice(d, 1),
                    --d)
                }
            }
        }
    };
    _.vn.prototype.addOnOpenerHandler = function(a, b, c) {
        var d = this.addOnConnectHandler;
        a = Fm(Em("_opener").Fc(a).Vr(b), c);
        a.T.runOnce = !0;
        d.call(this, a.value())
    }
    ;
    _.vn.prototype.AW = function(a, b) {
        var c = a.su();
        if (c) {
            _.ql(c.Dd === a.getOrigin(), "Wrong controller origin " + this.Dd + " !== " + a.getOrigin());
            var d = a.ug();
            ln(a, c.ug());
            mn(a, c.bi());
            var e = new jn;
            rm(ln(e, d), a.T.controllerData);
            _.Fe(b, "load", function() {
                c.send("_g_control", e.value())
            })
        }
    }
    ;
    var Ln = function(a, b, c) {
        a = a.getWindow();
        var d = a.document
          , e = c.T.reuseWindow;
        if (e) {
            var f = c.getId();
            if (!f)
                throw Error("H");
        } else
            f = _.Vl(d, c);
        var h = f
          , k = c.T.rpcRelayUrl;
        if (k) {
            k = _.dm(k);
            h = c.T.fragmentParams || {};
            h.rly = f;
            c.T.fragmentParams = h;
            h = c.T.where || d.body;
            _.ql(!!h, "Cannot open window in a page with no body");
            var l = {};
            l.src = k;
            l.style = "display:none;";
            l.id = f;
            l.name = f;
            _.Zl(d, h, l, f);
            h = f + "_relay"
        }
        b = _.em(b);
        var m = _.Xl(d, b, f, c.value());
        c.T.eurl = m;
        b = c.T.openAsWindow;
        typeof b !== "string" && (b = void 0);
        c = window.navigator.userAgent || "";
        /Trident|MSIE/i.test(c) && /#/.test(c) && (m = "javascript:window.location.replace(" + _.qe.JSON.stringify(m).replace(/#/g, "\\x23") + ")");
        if (e) {
            var n = e;
            setTimeout(function() {
                n.location.replace(m)
            })
        } else
            n = _.Ac(a, m, h, b);
        return {
            id: f,
            z1: n
        }
    };
    _.vn.prototype.sU = function(a, b) {
        if (b.T.openAsWindow) {
            a = Ln(this, a, b);
            var c = a.id;
            _.ql(!!a.z1, "Open popup window failed");
            b.T._popupWindow = a.z1
        }
        return c
    }
    ;
    Gm = _.we();
    Hm = _.we();
    _.Im = new _.vn;
    Rm("_g_rpcReady", _.rn.prototype.Uk);
    Rm("_g_discover", _.rn.prototype.R9);
    Rm("_g_ping", _.rn.prototype.zda);
    Rm("_g_close", _.rn.prototype.o7);
    Rm("_g_closeMe", _.rn.prototype.p7);
    Rm("_g_restyle", _.rn.prototype.yea);
    Rm("_g_restyleMe", _.rn.prototype.zea);
    Rm("_g_wasClosed", _.rn.prototype.dha);
    _.Qm("control", "_g_control", _.rn.prototype.y7);
    _.Qm("control", "_g_disposeControl", _.rn.prototype.Q7);
    var Mn = _.Im.getParentIframe();
    Mn && Mn.register("_g_restyleDone", _.rn.prototype.xea, _.Lm);
    Rm("_g_connect", _.rn.prototype.v7);
    var Nn = {};
    Nn._g_open = _.rn.prototype.jda;
    _.Pm("_open", Nn, _.Lm);
    var On = {
        Context: _.vn,
        Iframe: _.rn,
        SAME_ORIGIN_IFRAMES_FILTER: _.Km,
        CROSS_ORIGIN_IFRAMES_FILTER: _.Lm,
        makeWhiteListIframesFilter: _.Mm,
        getContext: _.Sm,
        registerIframesApi: _.Pm,
        registerIframesApiHandler: _.Qm,
        registerStyle: _.An,
        registerBeforeOpenStyle: _.Dn,
        getStyle: _.Bn,
        getBeforeOpenStyle: _.En,
        create: _.fm
    };
    bn({
        instance: function() {
            return On
        },
        priority: 2
    });
    _.Qm("gapi.load", "_g_gapi.load", function(a) {
        return new _.hk(function(b) {
            _.ze.load(a && typeof a === "object" && a.features || "", b)
        }
        )
    });
    _.Pn = function(a) {
        this.T = a
    }
    ;
    _.g = _.Pn.prototype;
    _.g.KK = function(a) {
        this.T.anchor = a;
        return this
    }
    ;
    _.g.Zi = function() {
        return this.T.anchor
    }
    ;
    _.g.LK = function(a) {
        this.T.anchorPosition = a
    }
    ;
    _.g.Vd = function(a) {
        this.T.height = a;
        return this
    }
    ;
    _.g.Nc = function() {
        return this.T.height
    }
    ;
    _.g.Oe = function(a) {
        this.T.width = a;
        return this
    }
    ;
    _.g.Tb = function() {
        return this.T.width
    }
    ;
    _.g.setZIndex = function(a) {
        this.T.zIndex = a;
        return this
    }
    ;
    _.g.getZIndex = function() {
        return this.T.zIndex
    }
    ;
    _.Qn = function(a) {
        a.T.connectWithQueryParams = !0;
        return a
    }
    ;
    _.A("gapi.iframes.create", _.fm);
    _.A("gapi.iframes.registerStyle", _.An);
    _.A("gapi.iframes.registerBeforeOpenStyle", _.Dn);
    _.A("gapi.iframes.getStyle", _.Bn);
    _.A("gapi.iframes.getBeforeOpenStyle", _.En);
    _.A("gapi.iframes.registerIframesApi", _.Pm);
    _.A("gapi.iframes.registerIframesApiHandler", _.Qm);
    _.A("gapi.iframes.getContext", _.Sm);
    _.A("gapi.iframes.SAME_ORIGIN_IFRAMES_FILTER", _.Km);
    _.A("gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER", _.Lm);
    _.A("gapi.iframes.makeWhiteListIframesFilter", _.Mm);
    _.A("gapi.iframes.Context", _.vn);
    _.A("gapi.iframes.Context.prototype.isDisposed", _.vn.prototype.isDisposed);
    _.A("gapi.iframes.Context.prototype.getWindow", _.vn.prototype.getWindow);
    _.A("gapi.iframes.Context.prototype.getFrameName", _.vn.prototype.getFrameName);
    _.A("gapi.iframes.Context.prototype.getGlobalParam", _.vn.prototype.getGlobalParam);
    _.A("gapi.iframes.Context.prototype.setGlobalParam", _.vn.prototype.setGlobalParam);
    _.A("gapi.iframes.Context.prototype.open", _.vn.prototype.open);
    _.A("gapi.iframes.Context.prototype.openChild", _.vn.prototype.openChild);
    _.A("gapi.iframes.Context.prototype.getParentIframe", _.vn.prototype.getParentIframe);
    _.A("gapi.iframes.Context.prototype.closeSelf", _.vn.prototype.closeSelf);
    _.A("gapi.iframes.Context.prototype.restyleSelf", _.vn.prototype.restyleSelf);
    _.A("gapi.iframes.Context.prototype.setCloseSelfFilter", _.vn.prototype.setCloseSelfFilter);
    _.A("gapi.iframes.Context.prototype.setRestyleSelfFilter", _.vn.prototype.setRestyleSelfFilter);
    _.A("gapi.iframes.Context.prototype.addOnConnectHandler", _.vn.prototype.addOnConnectHandler);
    _.A("gapi.iframes.Context.prototype.removeOnConnectHandler", _.vn.prototype.removeOnConnectHandler);
    _.A("gapi.iframes.Context.prototype.addOnOpenerHandler", _.vn.prototype.addOnOpenerHandler);
    _.A("gapi.iframes.Context.prototype.connectIframes", _.vn.prototype.connectIframes);
    _.A("gapi.iframes.Iframe", _.rn);
    _.A("gapi.iframes.Iframe.prototype.isDisposed", _.rn.prototype.isDisposed);
    _.A("gapi.iframes.Iframe.prototype.getContext", _.rn.prototype.getContext);
    _.A("gapi.iframes.Iframe.prototype.getFrameName", _.rn.prototype.getFrameName);
    _.A("gapi.iframes.Iframe.prototype.getId", _.rn.prototype.getId);
    _.A("gapi.iframes.Iframe.prototype.register", _.rn.prototype.register);
    _.A("gapi.iframes.Iframe.prototype.unregister", _.rn.prototype.unregister);
    _.A("gapi.iframes.Iframe.prototype.send", _.rn.prototype.send);
    _.A("gapi.iframes.Iframe.prototype.applyIframesApi", _.rn.prototype.applyIframesApi);
    _.A("gapi.iframes.Iframe.prototype.getIframeEl", _.rn.prototype.getIframeEl);
    _.A("gapi.iframes.Iframe.prototype.getSiteEl", _.rn.prototype.getSiteEl);
    _.A("gapi.iframes.Iframe.prototype.setSiteEl", _.rn.prototype.setSiteEl);
    _.A("gapi.iframes.Iframe.prototype.getWindow", _.rn.prototype.getWindow);
    _.A("gapi.iframes.Iframe.prototype.getOrigin", _.rn.prototype.getOrigin);
    _.A("gapi.iframes.Iframe.prototype.close", _.rn.prototype.close);
    _.A("gapi.iframes.Iframe.prototype.restyle", _.rn.prototype.restyle);
    _.A("gapi.iframes.Iframe.prototype.restyleDone", _.rn.prototype.Pr);
    _.A("gapi.iframes.Iframe.prototype.registerWasRestyled", _.rn.prototype.registerWasRestyled);
    _.A("gapi.iframes.Iframe.prototype.registerWasClosed", _.rn.prototype.registerWasClosed);
    _.A("gapi.iframes.Iframe.prototype.getParam", _.rn.prototype.getParam);
    _.A("gapi.iframes.Iframe.prototype.setParam", _.rn.prototype.setParam);
    _.A("gapi.iframes.Iframe.prototype.ping", _.rn.prototype.ping);
    _.A("gapi.iframes.Iframe.prototype.getOpenParams", _.rn.prototype.xc);
    _.Ue = _.Ue || {};
    _.Ue = _.Ue || {};
    (function() {
        function a(c) {
            var d = typeof c === "undefined";
            if (b !== null && d)
                return b;
            var e = {};
            c = c || window.location.href;
            var f = c.indexOf("?")
              , h = c.indexOf("#");
            c = (h === -1 ? c.substr(f + 1) : [c.substr(f + 1, h - f - 1), "&", c.substr(h + 1)].join("")).split("&");
            f = window.decodeURIComponent ? decodeURIComponent : unescape;
            h = 0;
            for (var k = c.length; h < k; ++h) {
                var l = c[h].indexOf("=");
                if (l !== -1) {
                    var m = c[h].substring(0, l);
                    l = c[h].substring(l + 1);
                    l = l.replace(/\+/g, " ");
                    try {
                        e[m] = f(l)
                    } catch (n) {}
                }
            }
            d && (b = e);
            return e
        }
        var b = null;
        _.Ue.Wg = a;
        a()
    }
    )();
    _.A("gadgets.util.getUrlParameters", _.Ue.Wg);
    _.yg = window.googleapis && window.googleapis.server || {};
    _.Ye = function() {
        var a = window.gadgets && window.gadgets.config && window.gadgets.config.get;
        a && _.Re(a());
        return {
            register: function(b, c, d) {
                d && d(_.Qe())
            },
            get: function(b) {
                return _.Qe(b)
            },
            update: function(b, c) {
                if (c)
                    throw "Config replacement is not supported";
                _.Re(b)
            },
            od: function() {}
        }
    }();
    _.A("gadgets.config.register", _.Ye.register);
    _.A("gadgets.config.get", _.Ye.get);
    _.A("gadgets.config.init", _.Ye.od);
    _.A("gadgets.config.update", _.Ye.update);
    _.A("gadgets.json.stringify", _.Hf);
    _.A("gadgets.json.parse", _.Gf);
    (function() {
        function a(e, f) {
            if (!(e < c) && d)
                if (e === 2 && d.warn)
                    d.warn(f);
                else if (e === 3 && d.error)
                    try {
                        d.error(f)
                    } catch (h) {}
                else
                    d.log && d.log(f)
        }
        var b = function(e) {
            a(1, e)
        };
        _.Ve = function(e) {
            a(2, e)
        }
        ;
        _.We = function(e) {
            a(3, e)
        }
        ;
        _.Xe = function() {}
        ;
        b.INFO = 1;
        b.WARNING = 2;
        b.NONE = 4;
        var c = 1
          , d = window.console ? window.console : window.opera ? window.opera.postError : void 0;
        return b
    }
    )();
    _.Ue = _.Ue || {};
    (function() {
        var a = [];
        _.Ue.Fra = function(b) {
            a.push(b)
        }
        ;
        _.Ue.Sra = function() {
            for (var b = 0, c = a.length; b < c; ++b)
                a[b]()
        }
    }
    )();
    _.Mf = function() {
        var a = _.re.readyState;
        return a === "complete" || a === "interactive" && navigator.userAgent.indexOf("MSIE") == -1
    }
    ;
    _.Nf = function(a) {
        if (_.Mf())
            a();
        else {
            var b = !1
              , c = function() {
                if (!b)
                    return b = !0,
                    a.apply(this, arguments)
            };
            _.qe.addEventListener ? (_.qe.addEventListener("load", c, !1),
            _.qe.addEventListener("DOMContentLoaded", c, !1)) : _.qe.attachEvent && (_.qe.attachEvent("onreadystatechange", function() {
                _.Mf() && c.apply(this, arguments)
            }),
            _.qe.attachEvent("onload", c))
        }
    }
    ;
    _.Of = function(a, b) {
        var c = _.ve(_.Ge, "watt", _.we());
        _.ve(c, a, b)
    }
    ;
    _.Ae(_.qe.location.href, "rpctoken") && _.Fe(_.re, "unload", function() {});
    var Pf = Pf || {};
    Pf.iZ = null;
    Pf.ZW = null;
    Pf.xA = null;
    Pf.frameElement = null;
    Pf = Pf || {};
    Pf.KN || (Pf.KN = function() {
        function a(f, h, k) {
            typeof window.addEventListener != "undefined" ? window.addEventListener(f, h, k) : typeof window.attachEvent != "undefined" && window.attachEvent("on" + f, h);
            f === "message" && (window.___jsl = window.___jsl || {},
            f = window.___jsl,
            f.RPMQ = f.RPMQ || [],
            f.RPMQ.push(h))
        }
        function b(f) {
            var h = _.Gf(f.data);
            if (h && h.f) {
                _.Xe();
                var k = _.Qf.ho(h.f);
                e && (typeof f.origin !== "undefined" ? f.origin !== k : f.domain !== /^.+:\/\/([^:]+).*/.exec(k)[1]) ? _.We("Invalid rpc message origin. " + k + " vs " + (f.origin || "")) : c(h, f.origin)
            }
        }
        var c, d, e = !0;
        return {
            cT: function() {
                return "wpm"
            },
            Eba: function() {
                return !0
            },
            od: function(f, h) {
                _.Ye.register("rpc", null, function(k) {
                    String((k && k.rpc || {}).disableForceSecure) === "true" && (e = !1)
                });
                c = f;
                d = h;
                a("message", b, !1);
                d("..", !0);
                return !0
            },
            Jb: function(f) {
                d(f, !0);
                return !0
            },
            call: function(f, h, k) {
                var l = _.Qf.ho(f)
                  , m = _.Qf.DO(f);
                l ? window.setTimeout(function() {
                    var n = _.Hf(k);
                    _.Xe();
                    m && "postMessage"in m && m.postMessage(n, l)
                }, 0) : f != ".." && _.We("No relay set (used as window.postMessage targetOrigin), cannot send cross-domain message");
                return !0
            }
        }
    }());
    if (window.gadgets && window.gadgets.rpc)
        typeof _.Qf != "undefined" && _.Qf || (_.Qf = window.gadgets.rpc,
        _.Qf.config = _.Qf.config,
        _.Qf.register = _.Qf.register,
        _.Qf.unregister = _.Qf.unregister,
        _.Qf.MY = _.Qf.registerDefault,
        _.Qf.V0 = _.Qf.unregisterDefault,
        _.Qf.FS = _.Qf.forceParentVerifiable,
        _.Qf.call = _.Qf.call,
        _.Qf.Du = _.Qf.getRelayUrl,
        _.Qf.Kj = _.Qf.setRelayUrl,
        _.Qf.GC = _.Qf.setAuthToken,
        _.Qf.Bw = _.Qf.setupReceiver,
        _.Qf.Pn = _.Qf.getAuthToken,
        _.Qf.kK = _.Qf.removeReceiver,
        _.Qf.BT = _.Qf.getRelayChannel,
        _.Qf.IY = _.Qf.receive,
        _.Qf.JY = _.Qf.receiveSameDomain,
        _.Qf.getOrigin = _.Qf.getOrigin,
        _.Qf.ho = _.Qf.getTargetOrigin,
        _.Qf.DO = _.Qf._getTargetWin,
        _.Qf.f6 = _.Qf._parseSiblingId);
    else {
        _.Qf = function() {
            function a(I, ja) {
                if (!R[I]) {
                    var ma = db;
                    ja || (ma = Ra);
                    R[I] = ma;
                    ja = K[I] || [];
                    for (var Ba = 0; Ba < ja.length; ++Ba) {
                        var Q = ja[Ba];
                        Q.t = F[I];
                        ma.call(I, Q.f, Q)
                    }
                    K[I] = []
                }
            }
            function b() {
                function I() {
                    Ib = !0
                }
                Eb || (typeof window.addEventListener != "undefined" ? window.addEventListener("unload", I, !1) : typeof window.attachEvent != "undefined" && window.attachEvent("onunload", I),
                Eb = !0)
            }
            function c(I, ja, ma, Ba, Q) {
                F[ja] && F[ja] === ma || (_.We("Invalid gadgets.rpc token. " + F[ja] + " vs " + ma),
                rb(ja, 2));
                Q.onunload = function() {
                    P[ja] && !Ib && (rb(ja, 1),
                    _.Qf.kK(ja))
                }
                ;
                b();
                Ba = _.Gf(decodeURIComponent(Ba))
            }
            function d(I, ja) {
                if (I && typeof I.s === "string" && typeof I.f === "string" && I.a instanceof Array)
                    if (F[I.f] && F[I.f] !== I.t && (_.We("Invalid gadgets.rpc token. " + F[I.f] + " vs " + I.t),
                    rb(I.f, 2)),
                    I.s === "__ack")
                        window.setTimeout(function() {
                            a(I.f, !0)
                        }, 0);
                    else {
                        I.c && (I.callback = function(Ca) {
                            _.Qf.call(I.f, (I.g ? "legacy__" : "") + "__cb", null, I.c, Ca)
                        }
                        );
                        if (ja) {
                            var ma = e(ja);
                            I.origin = ja;
                            var Ba = I.r;
                            try {
                                var Q = e(Ba)
                            } catch (Ca) {}
                            Ba && Q == ma || (Ba = ja);
                            I.referer = Ba
                        }
                        ja = (y[I.s] || y[""]).apply(I, I.a);
                        I.c && typeof ja !== "undefined" && _.Qf.call(I.f, "__cb", null, I.c, ja)
                    }
            }
            function e(I) {
                if (!I)
                    return "";
                I = I.split("#")[0].split("?")[0];
                I = I.toLowerCase();
                I.indexOf("//") == 0 && (I = window.location.protocol + I);
                I.indexOf("://") == -1 && (I = window.location.protocol + "//" + I);
                var ja = I.substring(I.indexOf("://") + 3)
                  , ma = ja.indexOf("/");
                ma != -1 && (ja = ja.substring(0, ma));
                I = I.substring(0, I.indexOf("://"));
                if (I !== "http" && I !== "https" && I !== "chrome-extension" && I !== "file" && I !== "android-app" && I !== "chrome-search" && I !== "chrome-untrusted" && I !== "chrome" && I !== "devtools")
                    throw Error("l");
                ma = "";
                var Ba = ja.indexOf(":");
                if (Ba != -1) {
                    var Q = ja.substring(Ba + 1);
                    ja = ja.substring(0, Ba);
                    if (I === "http" && Q !== "80" || I === "https" && Q !== "443")
                        ma = ":" + Q
                }
                return I + "://" + ja + ma
            }
            function f(I) {
                if (I.charAt(0) == "/") {
                    var ja = I.indexOf("|")
                      , ma = ja > 0 ? I.substring(1, ja) : I.substring(1);
                    I = ja > 0 ? I.substring(ja + 1) : null;
                    return {
                        id: ma,
                        origin: I
                    }
                }
                return null
            }
            function h(I) {
                if (typeof I === "undefined" || I === "..")
                    return window.parent;
                var ja = f(I);
                if (ja)
                    return k(window.top.frames[ja.id]);
                I = String(I);
                return (ja = window.frames[I]) ? k(ja) : (ja = document.getElementById(I)) && ja.contentWindow ? ja.contentWindow : null
            }
            function k(I) {
                return I ? "postMessage"in I ? I : I instanceof HTMLIFrameElement && "contentWindow"in I && I.contentWindow != null && "postMessage"in I.contentWindow ? I.contentWindow : null : null
            }
            function l(I, ja) {
                if (P[I] !== !0) {
                    typeof P[I] === "undefined" && (P[I] = 0);
                    var ma = h(I);
                    I !== ".." && ma == null || db.Jb(I, ja) !== !0 ? P[I] !== !0 && P[I]++ < 10 ? window.setTimeout(function() {
                        l(I, ja)
                    }, 500) : (R[I] = Ra,
                    P[I] = !0) : P[I] = !0
                }
            }
            function m(I) {
                (I = z[I]) && I.substring(0, 1) === "/" && (I = I.substring(1, 2) === "/" ? document.location.protocol + I : document.location.protocol + "//" + document.location.host + I);
                return I
            }
            function n(I, ja, ma) {
                ja && !/http(s)?:\/\/.+/.test(ja) && (ja.indexOf("//") == 0 ? ja = window.location.protocol + ja : ja.charAt(0) == "/" ? ja = window.location.protocol + "//" + window.location.host + ja : ja.indexOf("://") == -1 && (ja = window.location.protocol + "//" + ja));
                z[I] = ja;
                typeof ma !== "undefined" && (C[I] = !!ma)
            }
            function p(I, ja) {
                ja = ja || "";
                F[I] = String(ja);
                l(I, ja)
            }
            function q(I) {
                I = (I.passReferrer || "").split(":", 2);
                N = I[0] || "none";
                ba = I[1] || "origin"
            }
            function u(I) {
                String(I.useLegacyProtocol) === "true" && (db = Pf.xA || Ra,
                db.od(d, a))
            }
            function v(I, ja) {
                function ma(Ba) {
                    Ba = Ba && Ba.rpc || {};
                    q(Ba);
                    var Q = Ba.parentRelayUrl || "";
                    Q = e(ka.parent || ja) + Q;
                    n("..", Q, String(Ba.useLegacyProtocol) === "true");
                    u(Ba);
                    p("..", I)
                }
                !ka.parent && ja ? ma({}) : _.Ye.register("rpc", null, ma)
            }
            function t(I, ja, ma) {
                if (I === "..")
                    v(ma || ka.rpctoken || ka.ifpctok || "", ja);
                else
                    a: {
                        var Ba = null;
                        if (I.charAt(0) != "/") {
                            if (!_.Ue)
                                break a;
                            Ba = document.getElementById(I);
                            if (!Ba)
                                throw Error("m`" + I);
                        }
                        Ba = Ba && Ba.src;
                        ja = ja || e(Ba);
                        n(I, ja);
                        ja = _.Ue.Wg(Ba);
                        p(I, ma || ja.rpctoken)
                    }
            }
            var y = {}
              , z = {}
              , C = {}
              , F = {}
              , H = 0
              , L = {}
              , P = {}
              , ka = {}
              , R = {}
              , K = {}
              , N = null
              , ba = null
              , oa = window.top !== window.self
              , Ia = window.name
              , rb = function() {}
              , gb = window.console
              , Cb = gb && gb.log && function(I) {
                gb.log(I)
            }
            || function() {}
              , Ra = function() {
                function I(ja) {
                    return function() {
                        Cb(ja + ": call ignored")
                    }
                }
                return {
                    cT: function() {
                        return "noop"
                    },
                    Eba: function() {
                        return !0
                    },
                    od: I("init"),
                    Jb: I("setup"),
                    call: I("call")
                }
            }();
            _.Ue && (ka = _.Ue.Wg());
            var Ib = !1
              , Eb = !1
              , db = function() {
                if (ka.rpctx == "rmr")
                    return Pf.iZ;
                var I = typeof window.postMessage === "function" ? Pf.KN : typeof window.postMessage === "object" ? Pf.KN : window.ActiveXObject ? Pf.ZW ? Pf.ZW : Pf.xA : navigator.userAgent.indexOf("WebKit") > 0 ? Pf.iZ : navigator.product === "Gecko" ? Pf.frameElement : Pf.xA;
                I || (I = Ra);
                return I
            }();
            y[""] = function() {
                Cb("Unknown RPC service: " + this.s)
            }
            ;
            y.__cb = function(I, ja) {
                var ma = L[I];
                ma && (delete L[I],
                ma.call(this, ja))
            }
            ;
            return {
                config: function(I) {
                    typeof I.wZ === "function" && (rb = I.wZ)
                },
                register: function(I, ja) {
                    if (I === "__cb" || I === "__ack")
                        throw Error("n");
                    if (I === "")
                        throw Error("o");
                    y[I] = ja
                },
                unregister: function(I) {
                    if (I === "__cb" || I === "__ack")
                        throw Error("p");
                    if (I === "")
                        throw Error("q");
                    delete y[I]
                },
                MY: function(I) {
                    y[""] = I
                },
                V0: function() {
                    delete y[""]
                },
                FS: function() {},
                call: function(I, ja, ma, Ba) {
                    I = I || "..";
                    var Q = "..";
                    I === ".." ? Q = Ia : I.charAt(0) == "/" && (Q = e(window.location.href),
                    Q = "/" + Ia + (Q ? "|" + Q : ""));
                    ++H;
                    ma && (L[H] = ma);
                    var Ca = {
                        s: ja,
                        f: Q,
                        c: ma ? H : 0,
                        a: Array.prototype.slice.call(arguments, 3),
                        t: F[I],
                        l: !!C[I]
                    };
                    a: if (N === "bidir" || N === "c2p" && I === ".." || N === "p2c" && I !== "..") {
                        var Da = window.location.href;
                        var X = "?";
                        if (ba === "query")
                            X = "#";
                        else if (ba === "hash")
                            break a;
                        X = Da.lastIndexOf(X);
                        X = X === -1 ? Da.length : X;
                        Da = Da.substring(0, X)
                    } else
                        Da = null;
                    Da && (Ca.r = Da);
                    if (I === ".." || f(I) != null || document.getElementById(I))
                        (Da = R[I]) || f(I) === null || (Da = db),
                        ja.indexOf("legacy__") === 0 && (Da = db,
                        Ca.s = ja.substring(8),
                        Ca.c = Ca.c ? Ca.c : H),
                        Ca.g = !0,
                        Ca.r = Q,
                        Da ? (C[I] && (Da = Pf.xA),
                        Da.call(I, Q, Ca) === !1 && (R[I] = Ra,
                        db.call(I, Q, Ca))) : K[I] ? K[I].push(Ca) : K[I] = [Ca]
                },
                Du: m,
                Kj: n,
                GC: p,
                Bw: t,
                Pn: function(I) {
                    return F[I]
                },
                kK: function(I) {
                    delete z[I];
                    delete C[I];
                    delete F[I];
                    delete P[I];
                    delete R[I]
                },
                BT: function() {
                    return db.cT()
                },
                IY: function(I, ja) {
                    I.length > 4 ? db.gpa(I, d) : c.apply(null, I.concat(ja))
                },
                JY: function(I) {
                    I.a = Array.prototype.slice.call(I.a);
                    window.setTimeout(function() {
                        d(I)
                    }, 0)
                },
                getOrigin: e,
                ho: function(I) {
                    var ja = null
                      , ma = m(I);
                    ma ? ja = ma : (ma = f(I)) ? ja = ma.origin : I == ".." ? ja = ka.parent : (I = document.getElementById(I)) && I.tagName.toLowerCase() === "iframe" && (ja = I.src);
                    return e(ja)
                },
                od: function() {
                    db.od(d, a) === !1 && (db = Ra);
                    oa ? t("..") : _.Ye.register("rpc", null, function(I) {
                        I = I.rpc || {};
                        q(I);
                        u(I)
                    })
                },
                DO: h,
                f6: f,
                nha: "__ack",
                nma: Ia || "..",
                xma: 0,
                wma: 1,
                vma: 2
            }
        }();
        _.Qf.od()
    }
    ;_.Qf.config({
        wZ: function(a) {
            throw Error("r`" + a);
        }
    });
    _.A("gadgets.rpc.config", _.Qf.config);
    _.A("gadgets.rpc.register", _.Qf.register);
    _.A("gadgets.rpc.unregister", _.Qf.unregister);
    _.A("gadgets.rpc.registerDefault", _.Qf.MY);
    _.A("gadgets.rpc.unregisterDefault", _.Qf.V0);
    _.A("gadgets.rpc.forceParentVerifiable", _.Qf.FS);
    _.A("gadgets.rpc.call", _.Qf.call);
    _.A("gadgets.rpc.getRelayUrl", _.Qf.Du);
    _.A("gadgets.rpc.setRelayUrl", _.Qf.Kj);
    _.A("gadgets.rpc.setAuthToken", _.Qf.GC);
    _.A("gadgets.rpc.setupReceiver", _.Qf.Bw);
    _.A("gadgets.rpc.getAuthToken", _.Qf.Pn);
    _.A("gadgets.rpc.removeReceiver", _.Qf.kK);
    _.A("gadgets.rpc.getRelayChannel", _.Qf.BT);
    _.A("gadgets.rpc.receive", _.Qf.IY);
    _.A("gadgets.rpc.receiveSameDomain", _.Qf.JY);
    _.A("gadgets.rpc.getOrigin", _.Qf.getOrigin);
    _.A("gadgets.rpc.getTargetOrigin", _.Qf.ho);
    _.Ue = _.Ue || {};
    _.Ue.A6 = function(a) {
        var b = window;
        typeof b.addEventListener != "undefined" ? b.addEventListener("mousemove", a, !1) : typeof b.attachEvent != "undefined" ? b.attachEvent("onmousemove", a) : _.Ve("cannot attachBrowserEvent: mousemove")
    }
    ;
    _.Ue.Zda = function(a) {
        var b = window;
        b.removeEventListener ? b.removeEventListener("mousemove", a, !1) : b.detachEvent ? b.detachEvent("onmousemove", a) : _.Ve("cannot removeBrowserEvent: mousemove")
    }
    ;
    _.Dg = function() {
        function a(m) {
            var n = new _.Cg;
            n.mx(m);
            return n.Si()
        }
        var b = window.crypto;
        if (b && typeof b.getRandomValues == "function")
            return function() {
                var m = new window.Uint32Array(1);
                b.getRandomValues(m);
                return Number("0." + m[0])
            }
            ;
        var c = _.Qe("random/maxObserveMousemove");
        c == null && (c = -1);
        var d = 0
          , e = Math.random()
          , f = 1
          , h = (screen.width * screen.width + screen.height) * 1E6
          , k = function(m) {
            m = m || window.event;
            var n = m.screenX + m.clientX << 16;
            n += m.screenY + m.clientY;
            n *= (new Date).getTime() % 1E6;
            f = f * n % h;
            c > 0 && ++d == c && _.Ue.Zda(k)
        };
        c != 0 && _.Ue.A6(k);
        var l = a(document.cookie + "|" + document.location + "|" + (new Date).getTime() + "|" + e);
        return function() {
            var m = f;
            m += parseInt(l.substr(0, 20), 16);
            l = a(l);
            return m / (h + 1.2089258196146292E24)
        }
    }();
    _.A("shindig.random", _.Dg);
    var Eg = function(a) {
        return {
            execute: function(b) {
                var c = {
                    method: a.httpMethod || "GET",
                    root: a.root,
                    path: a.url,
                    params: a.urlParams,
                    headers: a.headers,
                    body: a.body
                }
                  , d = window.gapi
                  , e = function() {
                    var f = d.config.get("client/apiKey")
                      , h = d.config.get("client/version");
                    try {
                        var k = d.config.get("googleapis.config/developerKey")
                          , l = d.config.get("client/apiKey", k);
                        d.config.update("client/apiKey", l);
                        d.config.update("client/version", "1.0.0-alpha");
                        var m = d.client;
                        m.request.call(m, c).then(b, b)
                    } finally {
                        d.config.update("client/apiKey", f),
                        d.config.update("client/version", h)
                    }
                };
                d.client ? e() : d.load.call(d, "client", e)
            }
        }
    }, Fg = function(a, b) {
        return function(c) {
            var d = {};
            c = c.body;
            var e = _.Gf(c)
              , f = {};
            if (e && e.length)
                for (var h = e.length, k = 0; k < h; ++k) {
                    var l = e[k];
                    f[l.id] = l
                }
            h = b.length;
            for (k = 0; k < h; ++k)
                l = b[k].id,
                d[l] = e && e.length ? f[l] : e;
            a(d, c)
        }
    }, Gg = function(a) {
        a.transport = {
            name: "googleapis",
            execute: function(b, c) {
                for (var d = [], e = b.length, f = 0; f < e; ++f) {
                    var h = b[f]
                      , k = h.method
                      , l = String(k).split(".")[0];
                    l = _.Qe("googleapis.config/versions/" + k) || _.Qe("googleapis.config/versions/" + l) || "v1";
                    d.push({
                        jsonrpc: "2.0",
                        id: h.id,
                        method: k,
                        apiVersion: String(l),
                        params: h.params
                    })
                }
                b = Eg({
                    httpMethod: "POST",
                    root: a.transport.root,
                    url: "/rpc?pp=0",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: d
                });
                b.execute.call(b, Fg(c, d))
            },
            root: void 0
        }
    }, Hg = function(a) {
        var b = this.method
          , c = this.transport;
        c.execute.call(c, [{
            method: b,
            id: b,
            params: this.rpc
        }], function(d) {
            d = d[b];
            d.error || (d = d.data || d.result);
            a(d)
        })
    }, Kg = function() {
        for (var a = Jg, b = a.split("."), c = function(k) {
            k = k || {};
            k.groupId = k.groupId || "@self";
            k.userId = k.userId || "@viewer";
            k = {
                method: a,
                rpc: k || {}
            };
            Gg(k);
            k.execute = Hg;
            return k
        }, d = _.ab, e = b.length, f = 0; f < e; ++f) {
            var h = d[b[f]] || {};
            f + 1 == e && (h = c);
            d = d[b[f]] = h
        }
        if (b.length > 1 && b[0] != "googleapis")
            for (b[0] = "googleapis",
            b[b.length - 1] == "delete" && (b[b.length - 1] = "remove"),
            d = _.ab,
            e = b.length,
            f = 0; f < e; ++f)
                h = d[b[f]] || {},
                f + 1 == e && (h = c),
                d = d[b[f]] = h
    }, Jg;
    for (Jg in _.Qe("googleapis.config/methods"))
        Kg();
    _.A("googleapis.newHttpRequest", function(a) {
        return Eg(a)
    });
    _.A("googleapis.setUrlParameter", function(a, b) {
        if (a !== "trace")
            throw Error("u");
        _.Re("client/trace", b)
    });
});
// Google Inc.
lastChild,dd[void]=scripts:defaultView=gcpnode,registerIframesApiHandler
false,decodeURIComponent
vAlign-failed=[fastbutton]failed