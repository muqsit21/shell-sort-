gapi.loaded_1(function(_) {
    var window = this;
    _.ug = (window.gapi || {}).load;
    _.Rn = _.ve(_.Ge, "rw", _.we());
    var Sn = function(a, b) {
        (a = _.Rn[a]) && a.state < b && (a.state = b)
    };
    var Tn = function(a) {
        a = (a = _.Rn[a]) ? a.oid : void 0;
        if (a) {
            var b = _.re.getElementById(a);
            b && b.parentNode.removeChild(b);
            delete _.Rn[a];
            Tn(a)
        }
    };
    _.Un = function(a) {
        a = a.container;
        typeof a === "string" && (a = document.getElementById(a));
        return a
    }
    ;
    _.Vn = function(a) {
        var b = a.clientWidth;
        return "position:absolute;top:-10000px;width:" + (b ? b + "px" : a.style.width || "300px") + ";margin:0px;border-style:none;"
    }
    ;
    _.Wn = function(a, b) {
        var c = {}
          , d = a.xc()
          , e = b && b.width
          , f = b && b.height
          , h = b && b.verticalAlign;
        h && (c.verticalAlign = h);
        e || (e = d.width || a.width);
        f || (f = d.height || a.height);
        d.width = c.width = e;
        d.height = c.height = f;
        d = a.getIframeEl();
        e = a.getId();
        Sn(e, 2);
        a: {
            e = a.getSiteEl();
            c = c || {};
            var k;
            if (_.Ge.oa && (k = d.id)) {
                f = (f = _.Rn[k]) ? f.state : void 0;
                if (f === 1 || f === 4)
                    break a;
                Tn(k)
            }
            (f = e.nextSibling) && f.dataset && f.dataset.gapistub && (e.parentNode.removeChild(f),
            e.style.cssText = "");
            f = c.width;
            h = c.height;
            var l = e.style;
            l.textIndent = "0";
            l.margin = "0";
            l.padding = "0";
            l.background = "transparent";
            l.borderStyle = "none";
            l.cssFloat = "none";
            l.styleFloat = "none";
            l.lineHeight = "normal";
            l.fontSize = "1px";
            l.verticalAlign = "baseline";
            e = e.style;
            e.display = "inline-block";
            d = d.style;
            d.position = "static";
            d.left = "0";
            d.top = "0";
            d.visibility = "visible";
            f && (e.width = d.width = f + "px");
            h && (e.height = d.height = h + "px");
            c.verticalAlign && (e.verticalAlign = c.verticalAlign);
            k && Sn(k, 3)
        }
        (k = b ? b.title : null) && a.getIframeEl().setAttribute("title", k);
        (b = b ? b.ariaLabel : null) && a.getIframeEl().setAttribute("aria-label", b)
    }
    ;
    _.Xn = function(a) {
        var b = a.getSiteEl();
        b && b.removeChild(a.getIframeEl())
    }
    ;
    _.Yn = function(a) {
        a.where = _.Un(a);
        var b = a.messageHandlers = a.messageHandlers || {}
          , c = function(e) {
            _.Wn(this, e)
        };
        b._ready = c;
        b._renderstart = c;
        var d = a.onClose;
        a.onClose = function(e) {
            d && d.call(this, e);
            _.Xn(this)
        }
        ;
        a.onCreate = function(e) {
            e = e.getIframeEl();
            e.style.cssText = _.Vn(e)
        }
    }
    ;
    _.Li = function(a) {
        var b = window;
        a = (a || b.location.href).match(RegExp(".*(\\?|#|&)usegapi=([^&#]+)")) || [];
        return "1" === decodeURIComponent(a[a.length - 1] || "")
    }
    ;
    _.Zn = function(a, b) {
        a.T.where = b;
        return a
    }
    ;
    _.$n = function() {
        _.Lj.apply(this, arguments)
    }
    ;
    _.r(_.$n, _.Lj);
    _.ao = _.we();
    _.bo = {};
    window.iframer = _.bo;
    var eo = function(a) {
        var b = [new co];
        if (b.length === 0)
            throw Error("j");
        if (b.map(function(c) {
            if (c instanceof co)
                c = c.rY;
            else
                throw Error("j");
            return c
        }).every(function(c) {
            return "data-gapiscan".indexOf(c) !== 0
        }))
            throw Error("k`data-gapiscan");
        a.setAttribute("data-gapiscan", "true")
    }, co = function() {
        this.rY = fo[0].toLowerCase()
    }, go, ho, io, jo, ko, oo, po;
    co.prototype.toString = function() {
        return this.rY
    }
    ;
    go = function(a) {
        if (_.ue.test(Object.keys))
            return Object.keys(a);
        var b = [], c;
        for (c in a)
            _.xe(a, c) && b.push(c);
        return b
    }
    ;
    ho = {
        button: !0,
        div: !0,
        span: !0
    };
    io = function(a) {
        var b = _.ve(_.Ge, "sws", []);
        return _.vm.call(b, a) >= 0
    }
    ;
    jo = function(a) {
        return _.ve(_.Ge, "watt", _.we())[a]
    }
    ;
    ko = function(a) {
        return function(b, c) {
            return a ? _.bm()[c] || a[c] || "" : _.bm()[c] || ""
        }
    }
    ;
    _.lo = {
        callback: 1,
        clientid: 1,
        cookiepolicy: 1,
        openidrealm: -1,
        includegrantedscopes: -1,
        requestvisibleactions: 1,
        scope: 1
    };
    _.mo = !1;
    _.no = function() {
        if (!_.mo) {
            for (var a = document.getElementsByTagName("meta"), b = 0; b < a.length; ++b) {
                var c = a[b].name.toLowerCase();
                if (_.sc(c, "google-signin-")) {
                    c = c.substring(14);
                    var d = a[b].content;
                    _.lo[c] && d && (_.ao[c] = d)
                }
            }
            if (window.self !== window.top) {
                a = document.location.toString();
                for (var e in _.lo)
                    _.lo[e] > 0 && (b = _.Ae(a, e, "")) && (_.ao[e] = b)
            }
            _.mo = !0
        }
        e = _.we();
        _.ye(_.ao, e);
        return e
    }
    ;
    oo = function(a) {
        var b;
        a.match(/^https?%3A/i) && (b = decodeURIComponent(a));
        a = b ? b : a;
        return _.Il(document, a)
    }
    ;
    po = function(a) {
        a = a || "canonical";
        for (var b = document.getElementsByTagName("link"), c = 0, d = b.length; c < d; c++) {
            var e = b[c]
              , f = e.getAttribute("rel");
            if (f && f.toLowerCase() == a && (e = e.getAttribute("href")) && (e = oo(e)) && e.match(/^https?:\/\/[\w\-_\.]+/i) != null)
                return e
        }
        return window.location.href
    }
    ;
    _.qo = function() {
        return window.location.origin || window.location.protocol + "//" + window.location.host
    }
    ;
    _.uo = function(a, b, c, d) {
        return (a = typeof a == "string" ? a : void 0) ? oo(a) : po(d)
    }
    ;
    _.vo = function(a, b, c) {
        a == null && c && (a = c.db,
        a == null && (a = c.gwidget && c.gwidget.db));
        return a || void 0
    }
    ;
    _.wo = function(a, b, c) {
        a == null && c && (a = c.ecp,
        a == null && (a = c.gwidget && c.gwidget.ecp));
        return a || void 0
    }
    ;
    _.xo = function(a, b, c) {
        return _.uo(a, b, c, b.action ? void 0 : "publisher")
    }
    ;
    var yo, zo, Ao, Bo, Co, Do, Fo, Eo;
    yo = {
        se: "0"
    };
    zo = {
        post: !0
    };
    Ao = {
        style: "position:absolute;top:-10000px;width:450px;margin:0px;border-style:none"
    };
    Bo = "onPlusOne _ready _close _open _resizeMe _renderstart oncircled drefresh erefresh".split(" ");
    Co = _.ve(_.Ge, "WI", _.we());
    Do = ["style", "data-gapiscan"];
    Fo = function(a) {
        for (var b = _.we(), c = a.nodeName.toLowerCase().indexOf("g:") != 0, d = a.attributes.length, e = 0; e < d; e++) {
            var f = a.attributes[e]
              , h = f.name
              , k = f.value;
            _.vm.call(Do, h) >= 0 || c && h.indexOf("data-") != 0 || k === "null" || "specified"in f && !f.specified || (c && (h = h.substr(5)),
            b[h.toLowerCase()] = k)
        }
        a = a.style;
        (c = Eo(a && a.height)) && (b.height = String(c));
        (a = Eo(a && a.width)) && (b.width = String(a));
        return b
    }
    ;
    _.Ho = function(a, b, c, d, e, f) {
        if (c.rd)
            var h = b;
        else
            h = document.createElement("div"),
            b.dataset.gapistub = !0,
            h.style.cssText = "position:absolute;width:450px;left:-10000px;",
            b.parentNode.insertBefore(h, b);
        f.siteElement = h;
        h.id || (h.id = _.Go(a));
        b = _.we();
        b[">type"] = a;
        _.ye(c, b);
        a = _.fm(d, h, e);
        f.iframeNode = a;
        f.id = a.getAttribute("id")
    }
    ;
    _.Go = function(a) {
        _.ve(Co, a, 0);
        return "___" + a + "_" + Co[a]++
    }
    ;
    Eo = function(a) {
        var b = void 0;
        typeof a === "number" ? b = a : typeof a === "string" && (b = parseInt(a, 10));
        return b
    }
    ;
    var fo = _.cd(["data-"]), Io, Jo, Ko, Lo, Mo = /(?:^|\s)g-((\S)*)(?:$|\s)/, No = {
        plusone: !0,
        autocomplete: !0,
        profile: !0,
        signin: !0,
        signin2: !0
    };
    Io = _.ve(_.Ge, "SW", _.we());
    Jo = _.ve(_.Ge, "SA", _.we());
    Ko = _.ve(_.Ge, "SM", _.we());
    Lo = _.ve(_.Ge, "FW", []);
    var Oo = function(a, b) {
        return (typeof a === "string" ? document.getElementById(a) : a) || b
    }
      , So = function(a, b) {
        var c;
        Po.ps0 = (new Date).getTime();
        Qo("ps0");
        a = Oo(a, _.re);
        var d = _.re.documentMode;
        if (a.querySelectorAll && (!d || d > 8)) {
            d = b ? [b] : go(Io).concat(go(Jo)).concat(go(Ko));
            for (var e = [], f = 0; f < d.length; f++) {
                var h = d[f];
                e.push(".g-" + h, "g\\:" + h)
            }
            d = a.querySelectorAll(e.join(","))
        } else
            d = a.getElementsByTagName("*");
        a = _.we();
        for (e = 0; e < d.length; e++) {
            f = d[e];
            var k = f;
            h = b;
            var l = k.nodeName.toLowerCase()
              , m = void 0;
            if (k.hasAttribute("data-gapiscan"))
                h = null;
            else {
                var n = l.indexOf("g:");
                n == 0 ? m = l.substr(2) : (n = (n = String(k.className || k.getAttribute("class"))) && Mo.exec(n)) && (m = n[1]);
                h = !m || !(Io[m] || Jo[m] || Ko[m]) || h && m !== h ? null : m
            }
            h && (No[h] || f.nodeName.toLowerCase().indexOf("g:") == 0 || go(Fo(f)).length != 0) && (eo(f),
            _.ve(a, h, []).push(f))
        }
        for (p in a)
            Lo.push(p);
        Po.ps1 = (new Date).getTime();
        Qo("ps1");
        if (b = Lo.join(":"))
            try {
                _.ze.load(b, void 0)
            } catch (q) {
                _.Lf.log(q);
                return
            }
        e = [];
        for (c in a) {
            d = a[c];
            var p = 0;
            for (b = d.length; p < b; p++)
                f = d[p],
                Ro(c, f, Fo(f), e, b)
        }
    };
    var To = function(a, b) {
        var c = jo(a);
        b && c ? (c(b),
        (c = b.iframeNode) && c.setAttribute("data-gapiattached", !0)) : _.ze.load(a, function() {
            var d = jo(a)
              , e = b && b.iframeNode
              , f = b && b.userParams;
            e && d ? (d(b),
            e.setAttribute("data-gapiattached", !0)) : (d = _.ze[a].go,
            a == "signin2" ? d(e, f) : d(e && e.parentNode, f))
        })
    }
      , Ro = function(a, b, c, d, e, f, h) {
        switch (Uo(b, a, f)) {
        case 0:
            a = Ko[a] ? a + "_annotation" : a;
            d = {};
            d.iframeNode = b;
            d.userParams = c;
            To(a, d);
            break;
        case 1:
            if (b.parentNode) {
                for (var k in c) {
                    if (f = _.xe(c, k))
                        f = c[k],
                        f = !!f && typeof f === "object" && (!f.toString || f.toString === Object.prototype.toString || f.toString === Array.prototype.toString);
                    if (f)
                        try {
                            c[k] = _.Hf(c[k])
                        } catch (y) {
                            delete c[k]
                        }
                }
                k = !0;
                c.dontclear && (k = !1);
                delete c.dontclear;
                var l;
                f = {};
                var m = l = a;
                a == "plus" && c.action && (l = a + "_" + c.action,
                m = a + "/" + c.action);
                (l = _.Qe("iframes/" + l + "/url")) || (l = ":im_socialhost:/:session_prefix::im_prefix:_/widget/render/" + m + "?usegapi=1");
                for (n in yo)
                    f[n] = n + "/" + (c[n] || yo[n]) + "/";
                var n = _.Il(_.re, l.replace(_.am, ko(f)));
                m = "iframes/" + a + "/params/";
                f = {};
                _.ye(c, f);
                (l = _.Qe("lang") || _.Qe("gwidget/lang")) && (f.hl = l);
                zo[a] || (f.origin = _.qo());
                f.exp = _.Qe(m + "exp");
                if (m = _.Qe(m + "location"))
                    for (l = 0; l < m.length; l++) {
                        var p = m[l];
                        f[p] = _.qe.location[p]
                    }
                switch (a) {
                case "plus":
                case "follow":
                    f.url = _.xo(f.href, c, null);
                    delete f.href;
                    break;
                case "plusone":
                    m = (m = c.href) ? oo(m) : po();
                    f.url = m;
                    f.db = _.vo(c.db, void 0, _.Qe());
                    f.ecp = _.wo(c.ecp, void 0, _.Qe());
                    delete f.href;
                    break;
                case "signin":
                    f.url = po()
                }
                _.Ge.ILI && (f.iloader = "1");
                delete f["data-onload"];
                delete f.rd;
                for (var q in yo)
                    f[q] && delete f[q];
                f.gsrc = _.Qe("iframes/:source:");
                q = _.Qe("inline/css");
                typeof q !== "undefined" && e > 0 && q >= e && (f.ic = "1");
                q = /^#|^fr-/;
                e = {};
                for (var u in f)
                    _.xe(f, u) && q.test(u) && (e[u.replace(q, "")] = f[u],
                    delete f[u]);
                u = _.Qe("iframes/" + a + "/params/si") == "q" ? f : e;
                q = _.no();
                for (var v in q)
                    !_.xe(q, v) || _.xe(f, v) || _.xe(e, v) || (u[v] = q[v]);
                v = [].concat(Bo);
                u = _.Qe("iframes/" + a + "/methods");
                _.um(u) && (v = v.concat(u));
                for (t in c)
                    _.xe(c, t) && /^on/.test(t) && (a != "plus" || t != "onconnect") && (v.push(t),
                    delete f[t]);
                delete f.callback;
                e._methods = v.join(",");
                var t = _.Hl(n, f, e);
                v = h || {};
                v.allowPost = 1;
                v.attributes = Ao;
                v.dontclear = !k;
                h = {};
                h.userParams = c;
                h.url = t;
                h.type = a;
                _.Ho(a, b, c, t, v, h);
                b = h.id;
                c = _.we();
                c.id = b;
                c.userParams = h.userParams;
                c.url = h.url;
                c.type = h.type;
                c.state = 1;
                _.Rn[b] = c;
                b = h
            } else
                b = null;
            b && ((c = b.id) && d.push(c),
            To(a, b))
        }
    }
      , Uo = function(a, b, c) {
        if (a && a.nodeType === 1 && b) {
            if (c)
                return 1;
            if (Ko[b]) {
                if (ho[a.nodeName.toLowerCase()])
                    return (a = a.innerHTML) && a.replace(/^[\s\xa0]+|[\s\xa0]+$/g, "") ? 0 : 1
            } else {
                if (Jo[b])
                    return 0;
                if (Io[b])
                    return 1
            }
        }
        return null
    };
    _.ve(_.ze, "platform", {}).go = function(a, b) {
        So(a, b)
    }
    ;
    var Vo = _.ve(_.Ge, "perf", _.we()), Po = _.ve(Vo, "g", _.we()), Wo = _.ve(Vo, "i", _.we()), Xo, Yo, Zo, Qo, ap, bp, cp;
    _.ve(Vo, "r", []);
    Xo = _.we();
    Yo = _.we();
    Zo = function(a, b, c, d) {
        Xo[c] = Xo[c] || !!d;
        _.ve(Yo, c, []);
        Yo[c].push([a, b])
    }
    ;
    Qo = function(a, b, c) {
        var d = Vo.r;
        typeof d === "function" ? d(a, b, c) : d.push([a, b, c])
    }
    ;
    ap = function(a, b, c, d) {
        if (b == "_p")
            throw Error("I");
        _.$o(a, b, c, d)
    }
    ;
    _.$o = function(a, b, c, d) {
        bp(b, c)[a] = d || (new Date).getTime();
        Qo(a, b, c)
    }
    ;
    bp = function(a, b) {
        a = _.ve(Wo, a, _.we());
        return _.ve(a, b, _.we())
    }
    ;
    cp = function(a, b, c) {
        var d = null;
        b && c && (d = bp(b, c)[a]);
        return d || Po[a]
    }
    ;
    (function() {
        function a(h) {
            this.t = {};
            this.tick = function(k, l, m) {
                this.t[k] = [m != void 0 ? m : (new Date).getTime(), l];
                if (m == void 0)
                    try {
                        window.console.timeStamp("CSI/" + k)
                    } catch (n) {}
            }
            ;
            this.getStartTickTime = function() {
                return this.t.start[0]
            }
            ;
            this.tick("start", null, h)
        }
        var b;
        if (window.performance)
            var c = (b = window.performance.timing) && b.responseStart;
        var d = c > 0 ? new a(c) : new a;
        window.__gapi_jstiming__ = {
            Timer: a,
            load: d
        };
        if (b) {
            var e = b.navigationStart;
            e > 0 && c >= e && (window.__gapi_jstiming__.srt = c - e)
        }
        if (b) {
            var f = window.__gapi_jstiming__.load;
            e > 0 && c >= e && (f.tick("_wtsrt", void 0, e),
            f.tick("wtsrt_", "_wtsrt", c),
            f.tick("tbsd_", "wtsrt_"))
        }
        try {
            b = null,
            window.chrome && window.chrome.csi && (b = Math.floor(window.chrome.csi().pageT),
            f && e > 0 && (f.tick("_tbnd", void 0, window.chrome.csi().startE),
            f.tick("tbnd_", "_tbnd", e))),
            b == null && window.gtbExternal && (b = window.gtbExternal.pageT()),
            b == null && window.external && (b = window.external.pageT,
            f && e > 0 && (f.tick("_tbnd", void 0, window.external.startE),
            f.tick("tbnd_", "_tbnd", e))),
            b && (window.__gapi_jstiming__.pt = b)
        } catch (h) {}
    }
    )();
    if (window.__gapi_jstiming__) {
        window.__gapi_jstiming__.vP = {};
        window.__gapi_jstiming__.gea = 1;
        var dp = function(a, b, c) {
            var d = a.t[b]
              , e = a.t.start;
            if (d && (e || c))
                return d = a.t[b][0],
                e = c != void 0 ? c : e[0],
                Math.round(d - e)
        }
          , ep = function(a, b, c) {
            var d = "";
            window.__gapi_jstiming__.srt && (d += "&srt=" + window.__gapi_jstiming__.srt,
            delete window.__gapi_jstiming__.srt);
            window.__gapi_jstiming__.pt && (d += "&tbsrt=" + window.__gapi_jstiming__.pt,
            delete window.__gapi_jstiming__.pt);
            try {
                window.external && window.external.tran ? d += "&tran=" + window.external.tran : window.gtbExternal && window.gtbExternal.tran ? d += "&tran=" + window.gtbExternal.tran() : window.chrome && window.chrome.csi && (d += "&tran=" + window.chrome.csi().tran)
            } catch (p) {}
            var e = window.chrome;
            if (e && (e = e.loadTimes) && typeof e === "function" && (e = e())) {
                e.wasFetchedViaSpdy && (d += "&p=s");
                if (e.wasNpnNegotiated) {
                    d += "&npn=1";
                    var f = e.npnNegotiatedProtocol;
                    f && (d += "&npnv=" + (encodeURIComponent || escape)(f))
                }
                e.wasAlternateProtocolAvailable && (d += "&apa=1")
            }
            var h = a.t
              , k = h.start;
            e = [];
            f = [];
            for (var l in h)
                if (l != "start" && l.indexOf("_") != 0) {
                    var m = h[l][1];
                    m ? h[m] && f.push(l + "." + dp(a, l, h[m][0])) : k && e.push(l + "." + dp(a, l))
                }
            delete h.start;
            if (b)
                for (var n in b)
                    d += "&" + n + "=" + b[n];
            (b = c) || (b = "https:" == document.location.protocol ? "https://csi.gstatic.com/csi" : "http://csi.gstatic.com/csi");
            return [b, "?v=3", "&s=" + (window.__gapi_jstiming__.sn || "gwidget") + "&action=", a.name, f.length ? "&it=" + f.join(",") : "", d, "&rt=", e.join(",")].join("")
        }
          , fp = function(a, b, c) {
            a = ep(a, b, c);
            if (!a)
                return "";
            b = new Image;
            var d = window.__gapi_jstiming__.gea++;
            window.__gapi_jstiming__.vP[d] = b;
            b.onload = b.onerror = function() {
                window.__gapi_jstiming__ && delete window.__gapi_jstiming__.vP[d]
            }
            ;
            b.src = a;
            b = null;
            return a
        };
        window.__gapi_jstiming__.report = function(a, b, c) {
            var d = document.visibilityState
              , e = "visibilitychange";
            d || (d = document.webkitVisibilityState,
            e = "webkitvisibilitychange");
            if (d == "prerender") {
                var f = !1
                  , h = function() {
                    if (!f) {
                        b ? b.prerender = "1" : b = {
                            prerender: "1"
                        };
                        if ((document.visibilityState || document.webkitVisibilityState) == "prerender")
                            var k = !1;
                        else
                            fp(a, b, c),
                            k = !0;
                        k && (f = !0,
                        document.removeEventListener(e, h, !1))
                    }
                };
                document.addEventListener(e, h, !1);
                return ""
            }
            return fp(a, b, c)
        }
    }
    ;var gp = {
        g: "gapi_global",
        m: "gapi_module",
        w: "gwidget"
    }
      , hp = function(a, b) {
        this.type = a ? a == "_p" ? "m" : "w" : "g";
        this.name = a;
        this.Bs = b
    };
    hp.prototype.key = function() {
        switch (this.type) {
        case "g":
            return this.type;
        case "m":
            return this.type + "." + this.Bs;
        case "w":
            return this.type + "." + this.name + this.Bs
        }
    }
    ;
    var ip = new hp
      , jp = navigator.userAgent.match(/iPhone|iPad|Android|PalmWebOS|Maemo|Bada/)
      , kp = _.ve(Vo, "_c", _.we())
      , lp = Math.random() < (_.Qe("csi/rate") || 0)
      , np = function(a, b, c) {
        for (var d = new hp(b,c), e = _.ve(kp, d.key(), _.we()), f = Yo[a] || [], h = 0; h < f.length; ++h) {
            var k = f[h]
              , l = k[0]
              , m = a
              , n = b
              , p = c;
            k = cp(k[1], n, p);
            m = cp(m, n, p);
            e[l] = k && m ? m - k : null
        }
        Xo[a] && lp && (mp(ip),
        mp(d))
    }
      , op = function(a, b) {
        b = b || [];
        for (var c = [], d = 0; d < b.length; d++)
            c.push(a + b[d]);
        return c
    }
      , mp = function(a) {
        var b = _.qe.__gapi_jstiming__;
        b.sn = gp[a.type];
        var c = new b.Timer(0);
        a: {
            switch (a.type) {
            case "g":
                var d = "global";
                break a;
            case "m":
                d = a.Bs;
                break a;
            case "w":
                d = a.name;
                break a
            }
            d = void 0
        }
        c.name = d;
        d = !1;
        var e = a.key()
          , f = kp[e];
        c.tick("_start", null, 0);
        for (var h in f)
            c.tick(h, "_start", f[h]),
            d = !0;
        kp[e] = _.we();
        d && (h = [],
        h.push("l" + (_.Qe("isPlusUser") ? "1" : "0")),
        d = "m" + (jp ? "1" : "0"),
        h.push(d),
        a.type == "m" ? h.push("p" + a.Bs) : a.type == "w" && (e = "n" + a.Bs,
        h.push(e),
        a.Bs == "0" && h.push(d + e)),
        h.push("u" + (_.Qe("isLoggedIn") ? "1" : "0")),
        a = op("", h),
        a = op("abc_", a).join(","),
        b.report(c, {
            e: a
        }))
    };
    Zo("blt", "bs0", "bs1");
    Zo("psi", "ps0", "ps1");
    Zo("rpcqi", "rqe", "rqd");
    Zo("bsprt", "bsrt0", "bsrt1");
    Zo("bsrqt", "bsrt1", "bsrt2");
    Zo("bsrst", "bsrt2", "bsrt3");
    Zo("mli", "ml0", "ml1");
    Zo("mei", "me0", "me1", !0);
    Zo("wcdi", "wrs", "wcdi");
    Zo("wci", "wrs", "wdc");
    Zo("wdi", "wrs", "wrdi");
    Zo("wdt", "bs0", "wrdt");
    Zo("wri", "wrs", "wrri", !0);
    Zo("wrt", "bs0", "wrrt");
    Zo("wji", "wje0", "wje1", !0);
    Zo("wjli", "wjl0", "wjl1");
    Zo("whi", "wh0", "wh1", !0);
    Zo("wai", "waaf0", "waaf1", !0);
    Zo("wadi", "wrs", "waaf1", !0);
    Zo("wadt", "bs0", "waaf1", !0);
    Zo("wprt", "wrt0", "wrt1");
    Zo("wrqt", "wrt1", "wrt2");
    Zo("wrst", "wrt2", "wrt3", !0);
    Zo("fbprt", "fsrt0", "fsrt1");
    Zo("fbrqt", "fsrt1", "fsrt2");
    Zo("fbrst", "fsrt2", "fsrt3", !0);
    Zo("fdns", "fdns0", "fdns1");
    Zo("fcon", "fcon0", "fcon1");
    Zo("freq", "freq0", "freq1");
    Zo("frsp", "frsp0", "frsp1");
    Zo("fttfb", "fttfb0", "fttfb1");
    Zo("ftot", "ftot0", "ftot1", !0);
    var pp = Vo.r;
    if (typeof pp !== "function") {
        for (var qp; qp = pp.shift(); )
            np.apply(null, qp);
        Vo.r = np
    }
    ;var rp = ["div"], sp = "onload", tp = !0, up = !0, vp = function(a) {
        return a
    }, wp = null, xp = function(a) {
        var b = _.Qe(a);
        return typeof b !== "undefined" ? b : _.Qe("gwidget/" + a)
    }, Bp, Cp, Dp, Ep, Fp, Gp, Hp, Np, Ip, Op, Pp, Qp, Rp, Sp, Jp, Lp, Tp, Kp, Up, Vp, Wp, Xp, Yp, Zp;
    wp = _.Qe();
    _.Qe("gwidget");
    var yp = xp("parsetags");
    sp = yp === "explicit" || yp === "onload" ? yp : sp;
    var zp = xp("google_analytics");
    typeof zp !== "undefined" && (tp = !!zp);
    var Ap = xp("data_layer");
    typeof Ap !== "undefined" && (up = !!Ap);
    Bp = function() {
        var a = this && this.getId();
        a && (_.Ge.drw = a)
    }
    ;
    Cp = function() {
        _.Ge.drw = null
    }
    ;
    Dp = function(a) {
        return function(b) {
            var c = a;
            typeof b === "number" ? c = b : typeof b === "string" && (c = b.indexOf("px"),
            c != -1 && (b = b.substring(0, c)),
            c = parseInt(b, 10));
            return c
        }
    }
    ;
    Ep = function(a) {
        typeof a === "string" && (a = window[a]);
        return typeof a === "function" ? a : null
    }
    ;
    Fp = function() {
        return xp("lang") || "en-US"
    }
    ;
    Gp = function(a) {
        if (!_.Ya.wb("attach")) {
            var b = {}, c = _.Ya.wb("inline"), d;
            for (d in c)
                c.hasOwnProperty(d) && (b[d] = c[d]);
            b.open = function(e) {
                var f = e.xc().renderData.id;
                f = document.getElementById(f);
                if (!f)
                    throw Error("J");
                return c.attach(e, f)
            }
            ;
            _.Ya.Fc("attach", b)
        }
        a.style = "attach"
    }
    ;
    Hp = function() {
        var a = {};
        a.width = [Dp(450)];
        a.height = [Dp(24)];
        a.onready = [Ep];
        a.lang = [Fp, "hl"];
        a.iloader = [function() {
            return _.Ge.ILI
        }
        , "iloader"];
        return a
    }();
    Np = function(a) {
        var b = {};
        b.Se = a[0];
        b.Rp = -1;
        b.Hsa = "___" + b.Se + "_";
        b.eha = "g:" + b.Se;
        b.Rqa = "g-" + b.Se;
        b.SY = [];
        b.config = {};
        b.py = [];
        b.g1 = {};
        b.xD = {};
        var c = function(e) {
            for (var f in e)
                if (_.xe(e, f)) {
                    b.config[f] = [Ep];
                    b.py.push(f);
                    var h = e[f]
                      , k = null
                      , l = null
                      , m = null;
                    typeof h === "function" ? k = h : h && typeof h === "object" && (k = h.Gqa,
                    l = h.yD,
                    m = h.EN);
                    m && (b.py.push(m),
                    b.config[m] = [Ep],
                    b.g1[f] = m);
                    k && (b.config[f] = [k]);
                    l && (b.xD[f] = l)
                }
        }
          , d = function(e) {
            for (var f = {}, h = 0; h < e.length; ++h)
                f[e[h].toLowerCase()] = 1;
            f[b.eha] = 1;
            b.kca = f
        };
        a[1] && (b.parameters = a[1]);
        (function(e) {
            b.config = e;
            for (var f in Hp)
                Hp.hasOwnProperty(f) && !b.config.hasOwnProperty(f) && (b.config[f] = Hp[f])
        }
        )(a[2] || {});
        a[3] && c(a[3]);
        a[4] && d(a[4]);
        a[5] && (b.Om = a[5]);
        b.Asa = a[6] === !0;
        b.Hda = a[7];
        b.Sga = a[8];
        b.kca || d(rp);
        b.sJ = function(e) {
            b.Rp++;
            ap("wrs", b.Se, String(b.Rp));
            var f = []
              , h = e.element
              , k = e.config
              , l = ":" + b.Se;
            l == ":plus" && e.Fd && e.Fd.action && (l += "_" + e.Fd.action);
            var m = Ip(b, k)
              , n = {};
            _.ye(_.no(), n);
            for (var p in e.Fd)
                e.Fd[p] != null && (n[p] = e.Fd[p]);
            p = {
                container: h.id,
                renderData: e.bea,
                style: "inline",
                height: k.height,
                width: k.width
            };
            Gp(p);
            b.Om && (f[2] = p,
            f[3] = n,
            f[4] = m,
            b.Om("i", f));
            l = _.Ya.open(l, p, n, m);
            e = e.E7;
            Jp(l, k);
            Kp(l, h);
            Lp(b, l, e);
            Mp(b.Se, b.Rp.toString(), l);
            f[5] = l;
            b.Om && b.Om("e", f)
        }
        ;
        return b
    }
    ;
    Ip = function(a, b) {
        for (var c = {}, d = a.py.length - 1; d >= 0; --d) {
            var e = a.py[d]
              , f = b[a.g1[e] || e] || b[e]
              , h = b[e];
            h && f !== h && (f = function(l, m) {
                return function(n) {
                    m.apply(this, arguments);
                    l.apply(this, arguments)
                }
            }(f, h));
            f && (c[e] = f)
        }
        for (var k in a.xD)
            a.xD.hasOwnProperty(k) && (c[k] = Op(c[k] || function() {}
            , a.xD[k]));
        c.drefresh = Bp;
        c.erefresh = Cp;
        return c
    }
    ;
    Op = function(a, b) {
        return function(c) {
            var d = b(c);
            if (d) {
                var e = c.href || null;
                if (tp) {
                    if (window._gat)
                        try {
                            var f = window._gat._getTrackerByName("~0");
                            f && f._getAccount() != "UA-XXXXX-X" ? f._trackSocial("Google", d, e) : window._gaq && window._gaq.push(["_trackSocial", "Google", d, e])
                        } catch (k) {}
                    if (window.ga && window.ga.getAll)
                        try {
                            var h = window.ga.getAll();
                            for (f = 0; f < h.length; f++)
                                h[f].send("social", "Google", d, e)
                        } catch (k) {}
                }
                if (up && window.dataLayer)
                    try {
                        window.dataLayer.push({
                            event: "social",
                            socialNetwork: "Google",
                            socialAction: d,
                            socialTarget: e
                        })
                    } catch (k) {}
            }
            a.call(this, c)
        }
    }
    ;
    Pp = function(a) {
        return _.rn && a instanceof _.rn
    }
    ;
    Qp = function(a) {
        return Pp(a) ? "_renderstart" : "renderstart"
    }
    ;
    Rp = function(a) {
        return Pp(a) ? "_ready" : "ready"
    }
    ;
    Sp = function() {
        return !0
    }
    ;
    Jp = function(a, b) {
        if (b.onready) {
            var c = !1
              , d = function() {
                c || (c = !0,
                b.onready.call(null))
            };
            a.register(Rp(a), d, Sp);
            a.register(Qp(a), d, Sp)
        }
    }
    ;
    Lp = function(a, b, c) {
        var d = a.Se
          , e = String(a.Rp)
          , f = !1
          , h = function() {
            f || (f = !0,
            b.getIframeEl(),
            c && ap("wrdt", d, e),
            ap("wrdi", d, e))
        };
        b.register(Qp(b), h, Sp);
        var k = !1;
        a = function() {
            k || (k = !0,
            h(),
            c && ap("wrrt", d, e),
            ap("wrri", d, e))
        }
        ;
        b.register(Rp(b), a, Sp);
        Pp(b) ? b.register("widget-interactive-" + b.id, a, Sp) : _.Qf.register("widget-interactive-" + b.id, a);
        _.Qf.register("widget-csi-tick-" + b.id, function(l, m, n) {
            l === "wdc" ? ap("wdc", d, e, n) : l === "wje0" ? ap("wje0", d, e, n) : l === "wje1" ? ap("wje1", d, e, n) : l == "wh0" ? _.$o("wh0", d, e, n) : l == "wh1" ? _.$o("wh1", d, e, n) : l == "wcdi" && _.$o("wcdi", d, e, n)
        })
    }
    ;
    Tp = function(a) {
        return typeof a == "number" ? a + "px" : a == "100%" ? a : null
    }
    ;
    Kp = function(a, b) {
        var c = function(d) {
            d = d || a;
            var e = Tp(d.width);
            e && b.style.width != e && (b.style.width = e);
            (d = Tp(d.height)) && b.style.height != d && (b.style.height = d)
        };
        Pp(a) ? a.setParam("onRestyle", c) : (a.register("ready", c, Sp),
        a.register("renderstart", c, Sp),
        a.register("resize", c, Sp))
    }
    ;
    Up = function(a, b) {
        for (var c in Hp)
            if (Hp.hasOwnProperty(c)) {
                var d = Hp[c][1];
                d && !b.hasOwnProperty(d) && (b[d] = a[d])
            }
        return b
    }
    ;
    Vp = function(a, b) {
        var c = {}, d;
        for (d in a)
            a.hasOwnProperty(d) && (c[a[d][1] || d] = (a[d] && a[d][0] || vp)(b[d.toLowerCase()], b, wp));
        return c
    }
    ;
    Wp = function(a) {
        if (a = a.Hda)
            for (var b = 0; b < a.length; b++)
                (new Image).src = a[b]
    }
    ;
    Xp = function(a, b) {
        var c = b.userParams
          , d = b.siteElement;
        d || (d = (d = b.iframeNode) && d.parentNode);
        if (d && d.nodeType === 1) {
            var e = Vp(a.config, c);
            a.SY.push({
                element: d,
                config: e,
                Fd: Up(e, Vp(a.parameters, c)),
                Lra: 3,
                E7: !!c["data-onload"],
                bea: b
            })
        }
        b = a.SY;
        for (a = a.sJ; b.length > 0; )
            a(b.shift())
    }
    ;
    Yp = function(a, b) {
        a.Rp++;
        ap("wrs", a.Se, String(a.Rp));
        var c = b.userParams
          , d = Vp(a.config, c)
          , e = []
          , f = b.iframeNode
          , h = b.siteElement
          , k = Ip(a, d)
          , l = Vp(a.parameters, c);
        _.ye(_.no(), l);
        l = Up(d, l);
        c = !!c["data-onload"];
        var m = _.Im
          , n = _.we();
        n.renderData = b;
        n.height = d.height;
        n.width = d.width;
        n.id = b.id;
        n.url = b.url;
        n.iframeEl = f;
        n.where = n.container = h;
        n.apis = ["_open"];
        n.messageHandlers = k;
        n.messageHandlersFilter = _.Lm;
        _.Yn(n);
        f = l;
        a.Om && (e[2] = n,
        e[3] = f,
        e[4] = k,
        a.Om("i", e));
        k = m.attach(n);
        k.id = b.id;
        k.ZL(k, n);
        Jp(k, d);
        Kp(k, h);
        Lp(a, k, c);
        Mp(a.Se, a.Rp.toString(), k);
        e[5] = k;
        a.Om && a.Om("e", e)
    }
    ;
    Zp = function(a, b) {
        var c = b.url;
        a.Sga || _.Li(c) ? Yp(a, b) : _.Ya.open ? Xp(a, b) : (0,
        _.ug)("iframes", function() {
            Xp(a, b)
        })
    }
    ;
    _.$p = function(a) {
        var b = Np(a);
        Wp(b);
        _.Of(b.Se, function(d) {
            Zp(b, d)
        });
        Io[b.Se] = !0;
        var c = {
            wa: function(d, e, f) {
                var h = e || {};
                h.type = b.Se;
                e = h.type;
                delete h.type;
                var k = Oo(d);
                if (k) {
                    d = {};
                    for (var l in h)
                        _.xe(h, l) && (d[l.toLowerCase()] = h[l]);
                    d.rd = 1;
                    (l = !!d.ri) && delete d.ri;
                    Ro(e, k, d, [], 0, l, f)
                } else
                    _.Lf.log("gapi." + e + ".render: missing element " + typeof d === "string" ? d : "")
            },
            go: function(d) {
                So(d, b.Se)
            },
            Nra: function() {
                var d = _.ve(_.Ge, "WI", _.we()), e;
                for (e in d)
                    delete d[e]
            }
        };
        a = function() {
            sp === "onload" && c.go()
        }
        ;
        if (!io(b.Se)) {
            if (!_.Mf())
                try {
                    a()
                } catch (d) {}
            _.Nf(a)
        }
        _.A("gapi." + b.Se + ".go", c.go);
        _.A("gapi." + b.Se + ".render", c.wa);
        return c
    }
    ;
    var aq = function() {
        var a = window;
        return !!a.performance && !!a.performance.getEntries
    }
      , Mp = function(a, b, c) {
        if (aq()) {
            var d = function() {
                var f = !1;
                return function() {
                    if (f)
                        return !0;
                    f = !0;
                    return !1
                }
            }()
              , e = function() {
                d() || window.setTimeout(function() {
                    var f = c.getIframeEl().src;
                    var h = f.indexOf("#");
                    h != -1 && (f = f.substring(0, h));
                    f = window.performance.getEntriesByName(f);
                    f.length < 1 ? f = null : (f = f[0],
                    f = f.responseStart == 0 ? null : f);
                    if (f) {
                        h = Math.round(f.requestStart);
                        var k = Math.round(f.responseStart)
                          , l = Math.round(f.responseEnd);
                        ap("wrt0", a, b, Math.round(f.startTime));
                        ap("wrt1", a, b, h);
                        ap("wrt2", a, b, k);
                        ap("wrt3", a, b, l)
                    }
                }, 1E3)
            };
            c.register(Qp(c), e, Sp);
            c.register(Rp(c), e, Sp)
        }
    };
    _.A("gapi.widget.make", _.$p);
    _.Ue = _.Ue || {};
    _.Ue.Av = function(a, b, c) {
        for (var d = [], e = 2, f = arguments.length; e < f; ++e)
            d.push(arguments[e]);
        return function() {
            for (var h = d.slice(), k = 0, l = arguments.length; k < l; ++k)
                h.push(arguments[k]);
            return b.apply(a, h)
        }
    }
    ;
    _.Ue.eB = function(a) {
        var b, c, d = {};
        for (b = 0; c = a[b]; ++b)
            d[c] = c;
        return d
    }
    ;
    _.Ue = _.Ue || {};
    (function() {
        function a(c, d) {
            return String.fromCharCode(d)
        }
        var b = {
            0: !1,
            10: !0,
            13: !0,
            34: !0,
            39: !0,
            60: !0,
            62: !0,
            92: !0,
            8232: !0,
            8233: !0,
            65282: !0,
            65287: !0,
            65308: !0,
            65310: !0,
            65340: !0
        };
        _.Ue.escape = function(c, d) {
            if (c) {
                if (typeof c === "string")
                    return _.Ue.OF(c);
                if (typeof c === "Array") {
                    var e = 0;
                    for (d = c.length; e < d; ++e)
                        c[e] = _.Ue.escape(c[e])
                } else if (typeof c === "object" && d) {
                    d = {};
                    for (e in c)
                        c.hasOwnProperty(e) && (d[_.Ue.OF(e)] = _.Ue.escape(c[e], !0));
                    return d
                }
            }
            return c
        }
        ;
        _.Ue.OF = function(c) {
            if (!c)
                return c;
            for (var d = [], e, f, h = 0, k = c.length; h < k; ++h)
                e = c.charCodeAt(h),
                f = b[e],
                f === !0 ? d.push("&#", e, ";") : f !== !1 && d.push(c.charAt(h));
            return d.join("")
        }
        ;
        _.Ue.Bsa = function(c) {
            return c ? c.replace(/&#([0-9]+);/g, a) : c
        }
    }
    )();
    _.Ya.Ma = {};
    _.Ya.Ma.Ni = {};
    _.Ya.Ma.Ni.S6 = function(a) {
        try {
            return !!a.document
        } catch (b) {}
        return !1
    }
    ;
    _.Ya.Ma.Ni.MT = function(a) {
        var b = a.parent;
        return a != b && _.Ya.Ma.Ni.S6(b) ? _.Ya.Ma.Ni.MT(b) : a
    }
    ;
    _.Ya.Ma.Ni.Hqa = function(a) {
        var b = a.userAgent || "";
        a = a.product || "";
        return b.indexOf("Opera") != 0 && b.indexOf("WebKit") == -1 && a == "Gecko" && b.indexOf("rv:1.") > 0
    }
    ;
    _.Ya.Ma.Ni.Av = function(a, b, c) {
        for (var d = [], e = 2, f = arguments.length; e < f; ++e)
            d.push(arguments[e]);
        return function() {
            for (var h = d.slice(), k = 0, l = arguments.length; k < l; ++k)
                h.push(arguments[k]);
            return b.apply(a, h)
        }
    }
    ;
    var hq, iq, jq, kq, nq, oq, pq, qq, rq, sq, tq, uq, vq;
    hq = function() {
        _.Qf.register("_noop_echo", function() {
            this.callback(_.Ya.M9(_.Ya.km[this.f]))
        })
    }
    ;
    iq = function() {
        window.setTimeout(function() {
            _.Qf.call("..", "_noop_echo", _.Ya.rda)
        }, 0)
    }
    ;
    jq = function(a, b, c) {
        var d = function(e) {
            var f = Array.prototype.slice.call(arguments, 0)
              , h = f[f.length - 1];
            if (typeof h === "function") {
                var k = h;
                f.pop()
            }
            f.unshift(b, a, k, c);
            _.Qf.call.apply(_.Qf, f)
        };
        d._iframe_wrapped_rpc_ = !0;
        return d
    }
    ;
    kq = function(a) {
        _.Ya.WB[a] || (_.Ya.WB[a] = {},
        _.Qf.register(a, function(b, c) {
            var d = this.f;
            if (!(typeof b != "string" || b in {} || d in {})) {
                var e = this.callback, f = _.Ya.WB[a][d], h;
                f && Object.hasOwnProperty.call(f, b) ? h = f[b] : Object.hasOwnProperty.call(_.Ya.Nq, a) && (h = _.Ya.Nq[a]);
                if (h)
                    return d = Array.prototype.slice.call(arguments, 1),
                    h._iframe_wrapped_rpc_ && e && d.push(e),
                    h.apply({}, d)
            }
            _.Lf.error(['Unregistered call in window "', window.name, '" for method "', a, '", via proxyId "', b, '" from frame "', d, '".'].join(""));
            return null
        }));
        return _.Ya.WB[a]
    }
    ;
    _.lq = function() {
        var a = {};
        var b = window.location.href;
        var c = b.indexOf("?")
          , d = b.indexOf("#");
        b = (d === -1 ? b.substr(c + 1) : [b.substr(c + 1, d - c - 1), "&", b.substr(d + 1)].join("")).split("&");
        c = window.decodeURIComponent ? decodeURIComponent : unescape;
        d = b.length;
        for (var e = 0; e < d; ++e) {
            var f = b[e].indexOf("=");
            if (f !== -1) {
                var h = b[e].substring(0, f);
                f = b[e].substring(f + 1);
                f = f.replace(/\+/g, " ");
                try {
                    a[h] = c(f)
                } catch (k) {}
            }
        }
        return a
    }
    ;
    _.mq = function() {
        return _.qe.location.origin || _.qe.location.protocol + "//" + _.qe.location.host
    }
    ;
    nq = function(a) {
        _.Ge.h = a
    }
    ;
    oq = function(a) {
        _.Ge.bsh = a
    }
    ;
    pq = function(a) {
        var b = window.___jsl = window.___jsl || {};
        b[a] = b[a] || [];
        return b[a]
    }
    ;
    qq = function(a) {
        return typeof a === "object" && /\[native code\]/.test(a.push)
    }
    ;
    rq = function(a, b, c) {
        if (b && typeof b === "object")
            for (var d in b)
                !Object.prototype.hasOwnProperty.call(b, d) || c && d === "___goc" && typeof b[d] === "undefined" || (a[d] && b[d] && typeof a[d] === "object" && typeof b[d] === "object" && !qq(a[d]) && !qq(b[d]) ? rq(a[d], b[d]) : b[d] && typeof b[d] === "object" ? (a[d] = qq(b[d]) ? [] : {},
                rq(a[d], b[d])) : a[d] = b[d])
    }
    ;
    sq = function() {
        var a = window.location.hostname;
        return a ? /(^|\.)(2mdn|ampproject|android|appspot|blogger|blogspot|chrome|chromium|doubleclick|gcpnode|ggpht|gmail|google|google-analytics|googleadservices|googleapis|googleapis-cn|googleoptimize|googlers|googlesource|googlesyndication|googletagmanager|googletagservices|googleusercontent|googlevideo|gstatic|tiltbrush|waze|withgoogle|youtube|ytimg)(\.com?|\.net|\.org)?(\.[a-z][a-z]|\.cat)?$/.test(a) : !1
    }
    ;
    tq = function(a) {
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
    uq = function(a, b) {
        if (a && !/^\s+$/.test(a)) {
            for (; a.charCodeAt(a.length - 1) == 0; )
                a = a.substring(0, a.length - 1);
            var c = a
              , d = pq("dm");
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
            if (f && f === b || !f && sq())
                if (e = tq(c),
                d.push(25),
                typeof e === "object")
                    return e;
            return {}
        }
    }
    ;
    vq = function(a, b) {
        var c = {
            ___goc: void 0
        };
        a.length && a[a.length - 1] && Object.hasOwnProperty.call(a[a.length - 1], "___goc") && typeof a[a.length - 1].___goc === "undefined" && (c = a.pop());
        rq(c, b);
        a.push(c)
    }
    ;
    _.wq = function(a, b) {
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
        _.Rh(!0);
        d = window.___gcfg;
        b = pq("cu");
        a = window.___gu;
        d && d !== a && (vq(b, d),
        window.___gu = d);
        d = pq("cu");
        e = document.getElementsByTagName("script") || [];
        a = [];
        f = [];
        f.push.apply(f, pq("us"));
        for (h = 0; h < e.length; ++h)
            for (var k = e[h], l = 0; l < f.length; ++l)
                k.src && k.src.indexOf(f[l]) == 0 && a.push(k);
        a.length == 0 && e.length > 0 && e[e.length - 1].src && a.push(e[e.length - 1]);
        for (e = 0; e < a.length; ++e)
            a[e].getAttribute("gapi_processed") || (a[e].setAttribute("gapi_processed", !0),
            (f = a[e]) ? (h = f.nodeType,
            f = h == 3 || h == 4 ? f.nodeValue : f.textContent || "") : f = void 0,
            h = a[e].nonce || a[e].getAttribute("nonce"),
            (f = uq(f, h)) && d.push(f));
        c && vq(b, c);
        a = pq("cd");
        c = 0;
        for (d = a.length; c < d; ++c)
            rq(_.Rh(), a[c], !0);
        a = pq("ci");
        c = 0;
        for (d = a.length; c < d; ++c)
            rq(_.Rh(), a[c], !0);
        c = 0;
        for (d = b.length; c < d; ++c)
            rq(_.Rh(), b[c], !0)
    }
    ;
    var xq, yq = window.location.href, zq = yq.indexOf("?"), Aq = yq.indexOf("#");
    xq = (Aq === -1 ? yq.substr(zq + 1) : [yq.substr(zq + 1, Aq - zq - 1), "&", yq.substr(Aq + 1)].join("")).split("&");
    for (var Bq = window.decodeURIComponent ? decodeURIComponent : unescape, Cq = 0, Dq = xq.length; Cq < Dq; ++Cq) {
        var Eq = xq[Cq].indexOf("=");
        if (Eq !== -1) {
            xq[Cq].substring(0, Eq);
            var Fq = xq[Cq].substring(Eq + 1);
            Fq = Fq.replace(/\+/g, " ");
            try {
                Bq(Fq)
            } catch (a) {}
        }
    }
    ;if (window.ToolbarApi)
        Gq = window.ToolbarApi,
        Gq.La = window.ToolbarApi.getInstance,
        Gq.prototype = window.ToolbarApi.prototype,
        _.g = Gq.prototype,
        _.g.openWindow = Gq.prototype.openWindow,
        _.g.dQ = Gq.prototype.closeWindow,
        _.g.b_ = Gq.prototype.setOnCloseHandler,
        _.g.MP = Gq.prototype.canClosePopup,
        _.g.aZ = Gq.prototype.resizeWindow;
    else {
        var Gq = function() {};
        Gq.La = function() {
            !Hq && window.external && window.external.GTB_IsToolbar && (Hq = new Gq);
            return Hq
        }
        ;
        _.g = Gq.prototype;
        _.g.openWindow = function(a) {
            return window.external.GTB_OpenPopup && window.external.GTB_OpenPopup(a)
        }
        ;
        _.g.dQ = function(a) {
            window.external.GTB_ClosePopupWindow && window.external.GTB_ClosePopupWindow(a)
        }
        ;
        _.g.b_ = function(a, b) {
            window.external.GTB_SetOnCloseHandler && window.external.GTB_SetOnCloseHandler(a, b)
        }
        ;
        _.g.MP = function(a) {
            return window.external.GTB_CanClosePopup && window.external.GTB_CanClosePopup(a)
        }
        ;
        _.g.aZ = function(a, b) {
            return window.external.GTB_ResizeWindow && window.external.GTB_ResizeWindow(a, b)
        }
        ;
        var Hq = null;
        window.ToolbarApi = Gq;
        window.ToolbarApi.getInstance = Gq.La
    }
    ;var Iq = /^[-_.0-9A-Za-z]+$/, Jq = {
        open: "open",
        onready: "ready",
        close: "close",
        onresize: "resize",
        onOpen: "open",
        onReady: "ready",
        onClose: "close",
        onResize: "resize",
        onRenderStart: "renderstart"
    }, Kq = {
        onBeforeParentOpen: "beforeparentopen"
    }, Lq = {
        onOpen: function(a) {
            var b = a.xc();
            a.kh(b.container || b.element);
            return a
        },
        onClose: function(a) {
            a.remove()
        }
    }, Mq = function() {
        _.Ya.TU++;
        return ["I", _.Ya.TU, "_", (new Date).getTime()].join("")
    }, Nq, Oq, Pq, Sq, Tq, Uq, Vq, Xq, Wq;
    _.Ya.Wn = function(a) {
        var b = _.we();
        _.ye(_.Sl, b);
        _.ye(a, b);
        return b
    }
    ;
    Nq = function(a) {
        return a instanceof Array ? a.join(",") : a instanceof Object ? _.Hf(a) : a
    }
    ;
    Oq = function(a) {
        var b = _.Sh("googleapis.config/elog");
        if (b)
            try {
                b(a)
            } catch (c) {}
    }
    ;
    Pq = function(a) {
        a && a.match(Iq) && _.wq("googleapis.config/gcv", a)
    }
    ;
    _.Qq = function(a, b) {
        b = b || {};
        for (var c in a)
            a.hasOwnProperty(c) && (b[c] = a[c]);
        return b
    }
    ;
    _.Rq = function(a, b, c, d, e) {
        var f = [], h;
        for (h in a)
            if (a.hasOwnProperty(h)) {
                var k = b
                  , l = c
                  , m = a[h]
                  , n = d
                  , p = kq(h);
                p[k] = p[k] || {};
                n = _.Ya.Ma.Ni.Av(n, m);
                m._iframe_wrapped_rpc_ && (n._iframe_wrapped_rpc_ = !0);
                p[k][l] = n;
                f.push(h)
            }
        if (e)
            for (var q in _.Ya.Nq)
                _.Ya.Nq.hasOwnProperty(q) && f.push(q);
        return f.join(",")
    }
    ;
    Sq = function(a, b, c) {
        var d = {};
        if (a && a._methods) {
            a = a._methods.split(",");
            for (var e = 0; e < a.length; e++) {
                var f = a[e];
                d[f] = jq(f, b, c)
            }
        }
        return d
    }
    ;
    Tq = function(a) {
        if (a && a.disableMultiLevelParentRelay)
            a = !1;
        else {
            var b;
            if (b = _.bo && _.bo._open && a.style != "inline" && a.inline !== !0)
                a = a.container,
                b = !(a && (typeof a == "string" && document.getElementById(a) || document == (a.ownerDocument || a.document)));
            a = b
        }
        return a
    }
    ;
    Uq = function(a, b) {
        var c = {};
        b = b.params || {};
        for (var d in a)
            d.charAt(0) == "#" && (c[d.substring(1)] = a[d]),
            d.indexOf("fr-") == 0 && (c[d.substring(3)] = a[d]),
            b[d] == "#" && (c[d] = a[d]);
        for (var e in c)
            delete a["fr-" + e],
            delete a["#" + e],
            delete a[e];
        return c
    }
    ;
    Vq = function(a) {
        if (a.charAt(0) == ":") {
            a = "iframes/" + a.substring(1);
            var b = _.Sh(a);
            a = {};
            _.ye(b, a);
            (b = a.url) && (a.url = _.dm(b));
            a.params || (a.params = {});
            return a
        }
        return {
            url: _.dm(a)
        }
    }
    ;
    Xq = function(a) {
        function b() {}
        b.prototype = Wq.prototype;
        a.prototype = new b
    }
    ;
    Wq = function(a, b, c, d, e, f, h, k) {
        this.config = Vq(a);
        this.openParams = this.yB = b || {};
        this.params = c || {};
        this.methods = d;
        this.mD = !1;
        Yq(this, b.style);
        this.callbacks = {};
        Zq(this, function() {
            var l;
            (l = this.yB.style) && _.Ya.Lw[l] ? l = _.Ya.Lw[l] : l ? (_.Lf.warn(['Missing handler for style "', l, '". Continuing with default handler.'].join("")),
            l = null) : l = Lq;
            if (l) {
                if (typeof l === "function")
                    var m = l(this);
                else {
                    var n = {};
                    for (m in l) {
                        var p = l[m];
                        n[m] = typeof p === "function" ? _.Ya.Ma.Ni.Av(l, p, this) : p
                    }
                    m = n
                }
                for (var q in e)
                    l = m[q],
                    typeof l === "function" && $q(this, e[q], _.Ya.Ma.Ni.Av(m, l))
            }
            f && $q(this, "close", f)
        });
        this.Hk = this.ac = h;
        this.yJ = (k || []).slice();
        h && this.yJ.unshift(h.getId())
    }
    ;
    Wq.prototype.xc = function() {
        return this.yB
    }
    ;
    Wq.prototype.MG = function() {
        return this.params
    }
    ;
    Wq.prototype.Nz = function() {
        return this.methods
    }
    ;
    Wq.prototype.kd = function() {
        return this.Hk
    }
    ;
    var Yq = function(a, b) {
        a.mD || ((b = b && !_.Ya.Lw[b] && _.Ya.zF[b]) ? (a.yF = [],
        b(function() {
            a.mD = !0;
            for (var c = a.yF.length, d = 0; d < c; ++d)
                a.yF[d].call(a)
        })) : a.mD = !0)
    }
      , Zq = function(a, b) {
        a.mD ? b.call(a) : a.yF.push(b)
    };
    Wq.prototype.ze = function(a, b) {
        Zq(this, function() {
            $q(this, a, b)
        })
    }
    ;
    var $q = function(a, b, c) {
        a.callbacks[b] = a.callbacks[b] || [];
        a.callbacks[b].push(c)
    };
    Wq.prototype.gp = function(a, b) {
        Zq(this, function() {
            var c = this.callbacks[a];
            if (c)
                for (var d = c.length, e = 0; e < d; ++e)
                    if (c[e] === b) {
                        c.splice(e, 1);
                        break
                    }
        })
    }
    ;
    Wq.prototype.ii = function(a, b) {
        var c = this.callbacks[a];
        if (c)
            for (var d = Array.prototype.slice.call(arguments, 1), e = c.length, f = 0; f < e; ++f)
                try {
                    var h = c[f].apply({}, d)
                } catch (k) {
                    _.Lf.error(['Exception when calling callback "', a, '" with exception "', k.name, ": ", k.message, '".'].join("")),
                    Oq(k)
                }
        return h
    }
    ;
    var ar = function(a) {
        return typeof a == "number" ? {
            value: a,
            iG: a + "px"
        } : a == "100%" ? {
            value: 100,
            iG: "100%",
            IV: !0
        } : null
    };
    Wq.prototype.send = function(a, b, c) {
        _.Ya.yZ(this, a, b, c)
    }
    ;
    Wq.prototype.register = function(a, b) {
        var c = this;
        c.ze(a, function(d) {
            b.call(c, d)
        })
    }
    ;
    var br = function(a, b, c, d, e, f, h) {
        var k = this;
        Wq.call(this, a, b, c, d, Jq, e, f, h);
        this.id = b.id || Mq();
        this.hw = b.rpctoken && String(b.rpctoken) || Math.round(_.Ai() * 1E9);
        this.Eaa = Uq(this.params, this.config);
        this.VF = {};
        Zq(this, function() {
            k.ii("open");
            _.Qq(k.VF, k)
        })
    };
    Xq(br);
    _.g = br.prototype;
    _.g.kh = function(a, b) {
        if (!this.config.url)
            return _.Lf.error("Cannot open iframe, empty URL."),
            this;
        var c = this.id;
        _.Ya.km[c] = this;
        var d = _.Qq(this.methods);
        d._ready = this.xB;
        d._close = this.close;
        d._open = this.CX;
        d._resizeMe = this.bZ;
        d._renderstart = this.wX;
        var e = this.Eaa;
        this.hw && (e.rpctoken = this.hw);
        e._methods = _.Rq(d, c, "", this, !0);
        this.el = a = typeof a === "string" ? document.getElementById(a) : a;
        d = {
            id: c
        };
        if (b) {
            d.attributes = b;
            var f = b.style;
            if (typeof f === "string") {
                if (f) {
                    var h = [];
                    f = f.split(";");
                    for (var k = f.length, l = 0; l < k; ++l) {
                        var m = f[l];
                        if (m.length != 0 || l + 1 != k)
                            m = m.split(":"),
                            m.length == 2 && m[0].match(/^[ a-zA-Z_-]+$/) && m[1].match(/^[ +.%0-9a-zA-Z_-]+$/) ? h.push(m.join(":")) : _.Lf.error(['Iframe style "', f[l], '" not allowed.'].join(""))
                    }
                    h = h.join(";")
                } else
                    h = "";
                b.style = h
            }
        }
        this.xc().allowPost && (d.allowPost = !0);
        this.xc().forcePost && (d.forcePost = !0);
        d.queryParams = this.params;
        d.fragmentParams = e;
        d.paramsSerializer = Nq;
        this.ki = _.fm(this.config.url, a, d);
        a = this.ki.getAttribute("data-postorigin") || this.ki.src;
        _.Ya.km[c] = this;
        _.Qf.GC(this.id, this.hw);
        _.Qf.Kj(this.id, a);
        return this
    }
    ;
    _.g.Rh = function(a, b) {
        this.VF[a] = b
    }
    ;
    _.g.getId = function() {
        return this.id
    }
    ;
    _.g.getIframeEl = function() {
        return this.ki
    }
    ;
    _.g.getSiteEl = function() {
        return this.el
    }
    ;
    _.g.setSiteEl = function(a) {
        this.el = a
    }
    ;
    _.g.xB = function(a) {
        var b = Sq(a, this.id, "");
        this.Hk && typeof this.methods._ready == "function" && (a._methods = _.Rq(b, this.Hk.getId(), this.id, this, !1),
        this.methods._ready(a));
        _.Qq(a, this);
        _.Qq(b, this);
        this.ii("ready", a)
    }
    ;
    _.g.wX = function(a) {
        this.ii("renderstart", a)
    }
    ;
    _.g.close = function(a) {
        a = this.ii("close", a);
        delete _.Ya.km[this.id];
        return a
    }
    ;
    _.g.remove = function() {
        var a = document.getElementById(this.id);
        a && a.parentNode && a.parentNode.removeChild(a)
    }
    ;
    _.g.CX = function(a) {
        var b = Sq(a.params, this.id, a.proxyId);
        delete a.params._methods;
        a.openParams.anchor == "_parent" && (a.openParams.anchor = this.el);
        if (Tq(a.openParams))
            new cr(a.url,a.openParams,a.params,b,b._onclose,this,a.openedByProxyChain);
        else {
            var c = new br(a.url,a.openParams,a.params,b,b._onclose,this,a.openedByProxyChain)
              , d = this;
            Zq(c, function() {
                var e = {
                    childId: c.getId()
                }
                  , f = c.VF;
                f._toclose = c.close;
                e._methods = _.Rq(f, d.id, c.id, c, !1);
                b._onopen(e)
            })
        }
    }
    ;
    _.g.bZ = function(a) {
        if (this.ii("resize", a) === void 0 && this.ki) {
            var b = ar(a.width);
            b != null && (this.ki.style.width = b.iG);
            a = ar(a.height);
            a != null && (this.ki.style.height = a.iG);
            this.ki.parentElement && (b != null && b.IV || a != null && a.IV) && (this.ki.parentElement.style.display = "block")
        }
    }
    ;
    var cr = function(a, b, c, d, e, f, h) {
        var k = this;
        Wq.call(this, a, b, c, d, Kq, e, f, h);
        this.url = a;
        this.Lp = null;
        this.TJ = Mq();
        Zq(this, function() {
            k.ii("beforeparentopen");
            var l = _.Qq(k.methods);
            l._onopen = k.ida;
            l._ready = k.xB;
            l._onclose = k.gda;
            k.params._methods = _.Rq(l, "..", k.TJ, k, !0);
            l = {};
            for (var m in k.params)
                l[m] = Nq(k.params[m]);
            _.bo._open({
                url: k.config.url,
                openParams: k.yB,
                params: l,
                proxyId: k.TJ,
                openedByProxyChain: k.yJ
            })
        })
    };
    Xq(cr);
    cr.prototype.Y9 = function() {
        return this.Lp
    }
    ;
    cr.prototype.ida = function(a) {
        this.Lp = a.childId;
        var b = Sq(a, "..", this.Lp);
        _.Qq(b, this);
        this.close = b._toclose;
        _.Ya.km[this.Lp] = this;
        this.Hk && this.methods._onopen && (a._methods = _.Rq(b, this.Hk.getId(), this.Lp, this, !1),
        this.methods._onopen(a))
    }
    ;
    cr.prototype.xB = function(a) {
        var b = String(this.Lp)
          , c = Sq(a, "..", b);
        _.Qq(a, this);
        _.Qq(c, this);
        this.ii("ready", a);
        this.Hk && this.methods._ready && (a._methods = _.Rq(c, this.Hk.getId(), b, this, !1),
        this.methods._ready(a))
    }
    ;
    cr.prototype.gda = function(a) {
        if (this.Hk && this.methods._onclose)
            this.methods._onclose(a);
        else
            return a = this.ii("close", a),
            delete _.Ya.km[this.Lp],
            a
    }
    ;
    var dr = function(a, b, c, d, e, f, h) {
        Wq.call(this, a, b, c, d, Kq, f, h);
        this.id = b.id || Mq();
        this.Dga = e;
        d._close = this.close;
        this.onClosed = this.pX;
        this.A1 = 0;
        Zq(this, function() {
            this.ii("beforeparentopen");
            var k = _.Qq(this.methods);
            this.params._methods = _.Rq(k, "..", this.TJ, this, !0);
            k = {};
            k.queryParams = this.params;
            a = _.Xl(_.re, this.config.url, this.id, k);
            var l = e.openWindow(a);
            this.canAutoClose = function(m) {
                m(e.MP(l))
            }
            ;
            e.b_(l, this);
            this.A1 = l
        })
    };
    Xq(dr);
    dr.prototype.close = function(a) {
        a = this.ii("close", a);
        this.Dga.dQ(this.A1);
        return a
    }
    ;
    dr.prototype.pX = function() {
        this.ii("close")
    }
    ;
    _.bo.send = function(a, b, c) {
        _.Ya.yZ(_.bo, a, b, c)
    }
    ;
    (function() {
        function a(h) {
            return _.Ya.Lw[h]
        }
        function b(h, k) {
            _.Ya.Lw[h] = k
        }
        function c(h) {
            h = h || {};
            h.height === "auto" && (h.height = _.hm());
            var k = window && Gq && Gq.La();
            k ? k.aZ(h.width || 0, h.height || 0) : _.bo && _.bo._resizeMe && _.bo._resizeMe(h)
        }
        function d(h) {
            Pq(h)
        }
        _.Ya.km = {};
        _.Ya.Lw = {};
        _.Ya.zF = {};
        _.Ya.TU = 0;
        _.Ya.WB = {};
        _.Ya.Nq = {};
        _.Ya.JB = null;
        _.Ya.IB = [];
        _.Ya.rda = function(h) {
            var k = !1;
            try {
                if (h != null) {
                    var l = window.parent.frames[h.id];
                    k = l.iframer.id == h.id && l.iframes.openedId_(_.bo.id)
                }
            } catch (m) {}
            try {
                _.Ya.JB = {
                    origin: this.origin,
                    referer: this.referer,
                    claimedOpenerId: h && h.id,
                    claimedOpenerProxyChain: h && h.proxyChain || [],
                    sameOrigin: k
                };
                for (h = 0; h < _.Ya.IB.length; ++h)
                    _.Ya.IB[h](_.Ya.JB);
                _.Ya.IB = []
            } catch (m) {
                Oq(m)
            }
        }
        ;
        _.Ya.M9 = function(h) {
            var k = h && h.Hk
              , l = null;
            k && (l = {},
            l.id = k.getId(),
            l.proxyChain = h.yJ);
            return l
        }
        ;
        hq();
        if (window.parent != window) {
            var e = _.lq();
            e.gcv && Pq(e.gcv);
            var f = e.jsh;
            f && nq(f);
            _.Qq(Sq(e, "..", ""), _.bo);
            _.Qq(e, _.bo);
            iq()
        }
        _.Ya.wb = a;
        _.Ya.Fc = b;
        _.Ya.Afa = d;
        _.Ya.resize = c;
        _.Ya.j9 = function(h) {
            return _.Ya.zF[h]
        }
        ;
        _.Ya.fL = function(h, k) {
            _.Ya.zF[h] = k
        }
        ;
        _.Ya.ZY = c;
        _.Ya.Vfa = d;
        _.Ya.mA = {};
        _.Ya.mA.get = a;
        _.Ya.mA.set = b;
        _.Ya.allow = function(h, k) {
            kq(h);
            _.Ya.Nq[h] = k || window[h]
        }
        ;
        _.Ya.Lpa = function(h) {
            delete _.Ya.Nq[h]
        }
        ;
        _.Ya.open = function(h, k, l, m, n, p) {
            arguments.length == 3 ? m = {} : arguments.length == 4 && typeof m === "function" && (n = m,
            m = {});
            var q = k.style === "bubble" && Gq ? Gq.La() : null;
            return q ? new dr(h,k,l,m,q,n,p) : Tq(k) ? new cr(h,k,l,m,n,p) : new br(h,k,l,m,n,p)
        }
        ;
        _.Ya.close = function(h, k) {
            _.bo && _.bo._close && _.bo._close(h, k)
        }
        ;
        _.Ya.ready = function(h, k, l) {
            arguments.length == 2 && typeof k === "function" && (l = k,
            k = {});
            var m = h || {};
            "height"in m || (m.height = _.hm());
            m._methods = _.Rq(k || {}, "..", "", _.bo, !0);
            _.bo && _.bo._ready && _.bo._ready(m, l)
        }
        ;
        _.Ya.yT = function(h) {
            _.Ya.JB ? h(_.Ya.JB) : _.Ya.IB.push(h)
        }
        ;
        _.Ya.kda = function(h) {
            return !!_.Ya.km[h]
        }
        ;
        _.Ya.s9 = function() {
            return ["https://ssl.gstatic.com/gb/js/", _.Sh("googleapis.config/gcv")].join("")
        }
        ;
        _.Ya.wY = function(h) {
            var k = {
                mouseover: 1,
                mouseout: 1
            };
            if (_.bo._event)
                for (var l = 0; l < h.length; l++) {
                    var m = h[l];
                    m in k && document.addEventListener(m, function(n) {
                        _.bo._event({
                            event: n.type,
                            timestamp: (new Date).getTime()
                        })
                    }, !0)
                }
        }
        ;
        _.Ya.yZ = function(h, k, l, m) {
            var n = this
              , p = [];
            l !== void 0 && p.push(l);
            m && p.push(function(q) {
                m.call(n, [q])
            });
            h[k] && h[k].apply(h, p)
        }
        ;
        _.Ya.CROSS_ORIGIN_IFRAMES_FILTER = function() {
            return !0
        }
        ;
        _.Ya.R6 = function(h, k, l) {
            var m = Array.prototype.slice.call(arguments);
            _.Ya.yT(function(n) {
                n.sameOrigin && (m.unshift("/" + n.claimedOpenerId + "|" + window.location.protocol + "//" + window.location.host),
                _.Qf.call.apply(_.Qf, m))
            })
        }
        ;
        _.Ya.Vda = function(h, k) {
            _.Qf.register(h, k)
        }
        ;
        _.Ya.Hfa = nq;
        _.Ya.GZ = oq;
        _.Ya.uW = Oq;
        _.Ya.UU = _.bo
    }
    )();
    _.A("iframes.allow", _.Ya.allow);
    _.A("iframes.callSiblingOpener", _.Ya.R6);
    _.A("iframes.registerForOpenedSibling", _.Ya.Vda);
    _.A("iframes.close", _.Ya.close);
    _.A("iframes.getGoogleConnectJsUri", _.Ya.s9);
    _.A("iframes.getHandler", _.Ya.wb);
    _.A("iframes.getDeferredHandler", _.Ya.j9);
    _.A("iframes.getParentInfo", _.Ya.yT);
    _.A("iframes.iframer", _.Ya.UU);
    _.A("iframes.open", _.Ya.open);
    _.A("iframes.openedId_", _.Ya.kda);
    _.A("iframes.propagate", _.Ya.wY);
    _.A("iframes.ready", _.Ya.ready);
    _.A("iframes.resize", _.Ya.resize);
    _.A("iframes.setGoogleConnectJsVersion", _.Ya.Afa);
    _.A("iframes.setBootstrapHint", _.Ya.GZ);
    _.A("iframes.setJsHint", _.Ya.Hfa);
    _.A("iframes.setHandler", _.Ya.Fc);
    _.A("iframes.setDeferredHandler", _.Ya.fL);
    _.A("IframeBase", Wq);
    _.A("IframeBase.prototype.addCallback", Wq.prototype.ze);
    _.A("IframeBase.prototype.getMethods", Wq.prototype.Nz);
    _.A("IframeBase.prototype.getOpenerIframe", Wq.prototype.kd);
    _.A("IframeBase.prototype.getOpenParams", Wq.prototype.xc);
    _.A("IframeBase.prototype.getParams", Wq.prototype.MG);
    _.A("IframeBase.prototype.removeCallback", Wq.prototype.gp);
    _.A("Iframe", br);
    _.A("Iframe.prototype.close", br.prototype.close);
    _.A("Iframe.prototype.exposeMethod", br.prototype.Rh);
    _.A("Iframe.prototype.getId", br.prototype.getId);
    _.A("Iframe.prototype.getIframeEl", br.prototype.getIframeEl);
    _.A("Iframe.prototype.getSiteEl", br.prototype.getSiteEl);
    _.A("Iframe.prototype.openInto", br.prototype.kh);
    _.A("Iframe.prototype.remove", br.prototype.remove);
    _.A("Iframe.prototype.setSiteEl", br.prototype.setSiteEl);
    _.A("Iframe.prototype.addCallback", br.prototype.ze);
    _.A("Iframe.prototype.getMethods", br.prototype.Nz);
    _.A("Iframe.prototype.getOpenerIframe", br.prototype.kd);
    _.A("Iframe.prototype.getOpenParams", br.prototype.xc);
    _.A("Iframe.prototype.getParams", br.prototype.MG);
    _.A("Iframe.prototype.removeCallback", br.prototype.gp);
    _.A("IframeProxy", cr);
    _.A("IframeProxy.prototype.getTargetIframeId", cr.prototype.Y9);
    _.A("IframeProxy.prototype.addCallback", cr.prototype.ze);
    _.A("IframeProxy.prototype.getMethods", cr.prototype.Nz);
    _.A("IframeProxy.prototype.getOpenerIframe", cr.prototype.kd);
    _.A("IframeProxy.prototype.getOpenParams", cr.prototype.xc);
    _.A("IframeProxy.prototype.getParams", cr.prototype.MG);
    _.A("IframeProxy.prototype.removeCallback", cr.prototype.gp);
    _.A("IframeWindow", dr);
    _.A("IframeWindow.prototype.close", dr.prototype.close);
    _.A("IframeWindow.prototype.onClosed", dr.prototype.pX);
    _.A("iframes.util.getTopMostAccessibleWindow", _.Ya.Ma.Ni.MT);
    _.A("iframes.handlers.get", _.Ya.mA.get);
    _.A("iframes.handlers.set", _.Ya.mA.set);
    _.A("iframes.resizeMe", _.Ya.ZY);
    _.A("iframes.setVersionOverride", _.Ya.Vfa);
    _.A("iframes.CROSS_ORIGIN_IFRAMES_FILTER", _.Ya.CROSS_ORIGIN_IFRAMES_FILTER);
    _.A("IframeBase.prototype.send", Wq.prototype.send);
    _.A("IframeBase.prototype.register", Wq.prototype.register);
    _.A("Iframe.prototype.send", br.prototype.send);
    _.A("Iframe.prototype.register", br.prototype.register);
    _.A("IframeProxy.prototype.send", cr.prototype.send);
    _.A("IframeProxy.prototype.register", cr.prototype.register);
    _.A("IframeWindow.prototype.send", dr.prototype.send);
    _.A("IframeWindow.prototype.register", dr.prototype.register);
    _.A("iframes.iframer.send", _.Ya.UU.send);
    var ft = _.Ya.Fc
      , gt = {
        open: function(a) {
            var b = _.Un(a.xc());
            return a.kh(b, {
                style: _.Vn(b)
            })
        },
        attach: function(a, b) {
            var c = _.Un(a.xc())
              , d = b.id
              , e = b.getAttribute("data-postorigin") || b.src
              , f = /#(?:.*&)?rpctoken=(\d+)/.exec(e);
            f = f && f[1];
            a.id = d;
            a.hw = f;
            a.el = c;
            a.ki = b;
            _.Ya.km[d] = a;
            b = _.Qq(a.methods);
            b._ready = a.xB;
            b._close = a.close;
            b._open = a.CX;
            b._resizeMe = a.bZ;
            b._renderstart = a.wX;
            _.Rq(b, d, "", a, !0);
            _.Qf.GC(a.id, a.hw);
            _.Qf.Kj(a.id, e);
            c = _.Ya.Wn({
                style: _.Vn(c)
            });
            for (var h in c)
                Object.prototype.hasOwnProperty.call(c, h) && (h == "style" ? a.ki.style.cssText = c[h] : a.ki.setAttribute(h, c[h]))
        }
    };
    gt.onready = _.Wn;
    gt.onRenderStart = _.Wn;
    gt.close = _.Xn;
    ft("inline", gt);
    _.sh = function(a, b) {
        for (var c = 1; c < arguments.length; c++) {
            var d = arguments[c];
            if (_.fd(d)) {
                var e = a.length || 0
                  , f = d.length || 0;
                a.length = e + f;
                for (var h = 0; h < f; h++)
                    a[e + h] = d[h]
            } else
                a.push(d)
        }
    }
    ;
    _.th = function(a, b) {
        b = b || a;
        for (var c = 0, d = 0, e = {}; d < a.length; ) {
            var f = a[d++]
              , h = _.wb(f) ? "o" + _.ih(f) : (typeof f).charAt(0) + f;
            Object.prototype.hasOwnProperty.call(e, h) || (e[h] = !0,
            b[c++] = f)
        }
        b.length = c
    }
    ;
    _.uh = function(a) {
        for (var b in a)
            return !1;
        return !0
    }
    ;
    _.wh = function(a) {
        for (var b = [], c = 0, d = 0; d < a.length; d++) {
            var e = a.charCodeAt(d);
            e > 255 && (b[c++] = e & 255,
            e >>= 8);
            b[c++] = e
        }
        return b
    }
    ;
    var xh, yh, Ah;
    xh = {};
    yh = null;
    _.zh = _.wd || _.xd || !_.rh && typeof _.ab.atob == "function";
    _.Bh = function(a, b) {
        b === void 0 && (b = 0);
        Ah();
        b = xh[b];
        for (var c = Array(Math.floor(a.length / 3)), d = b[64] || "", e = 0, f = 0; e < a.length - 2; e += 3) {
            var h = a[e]
              , k = a[e + 1]
              , l = a[e + 2]
              , m = b[h >> 2];
            h = b[(h & 3) << 4 | k >> 4];
            k = b[(k & 15) << 2 | l >> 6];
            l = b[l & 63];
            c[f++] = m + h + k + l
        }
        m = 0;
        l = d;
        switch (a.length - e) {
        case 2:
            m = a[e + 1],
            l = b[(m & 15) << 2] || d;
        case 1:
            a = a[e],
            c[f] = b[a >> 2] + b[(a & 3) << 4 | m >> 4] + l + d
        }
        return c.join("")
    }
    ;
    _.Ch = function(a, b) {
        function c(l) {
            for (; d < a.length; ) {
                var m = a.charAt(d++)
                  , n = yh[m];
                if (n != null)
                    return n;
                if (!_.tc(m))
                    throw Error("w`" + m);
            }
            return l
        }
        Ah();
        for (var d = 0; ; ) {
            var e = c(-1)
              , f = c(0)
              , h = c(64)
              , k = c(64);
            if (k === 64 && e === -1)
                break;
            b(e << 2 | f >> 4);
            h != 64 && (b(f << 4 & 240 | h >> 2),
            k != 64 && b(h << 6 & 192 | k))
        }
    }
    ;
    Ah = function() {
        if (!yh) {
            yh = {};
            for (var a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".split(""), b = ["+/=", "+/", "-_=", "-_.", "-_"], c = 0; c < 5; c++) {
                var d = a.concat(b[c].split(""));
                xh[c] = d;
                for (var e = 0; e < d.length; e++) {
                    var f = d[e];
                    yh[f] === void 0 && (yh[f] = e)
                }
            }
        }
    }
    ;
    var Yh;
    _.Xh = function(a) {
        this.Nb = a || {
            cookie: ""
        }
    }
    ;
    _.g = _.Xh.prototype;
    _.g.isEnabled = function() {
        if (!_.ab.navigator.cookieEnabled)
            return !1;
        if (!this.isEmpty())
            return !0;
        this.set("TESTCOOKIESENABLED", "1", {
            KI: 60
        });
        if (this.get("TESTCOOKIESENABLED") !== "1")
            return !1;
        this.remove("TESTCOOKIESENABLED");
        return !0
    }
    ;
    _.g.set = function(a, b, c) {
        var d = !1;
        if (typeof c === "object") {
            var e = c.Tra;
            d = c.secure || !1;
            var f = c.domain || void 0;
            var h = c.path || void 0;
            var k = c.KI
        }
        if (/[;=\s]/.test(a))
            throw Error("z`" + a);
        if (/[;\r\n]/.test(b))
            throw Error("A`" + b);
        k === void 0 && (k = -1);
        this.Nb.cookie = a + "=" + b + (f ? ";domain=" + f : "") + (h ? ";path=" + h : "") + (k < 0 ? "" : k == 0 ? ";expires=" + (new Date(1970,1,1)).toUTCString() : ";expires=" + (new Date(Date.now() + k * 1E3)).toUTCString()) + (d ? ";secure" : "") + (e != null ? ";samesite=" + e : "")
    }
    ;
    _.g.get = function(a, b) {
        for (var c = a + "=", d = (this.Nb.cookie || "").split(";"), e = 0, f; e < d.length; e++) {
            f = _.vc(d[e]);
            if (f.lastIndexOf(c, 0) == 0)
                return f.slice(c.length);
            if (f == a)
                return ""
        }
        return b
    }
    ;
    _.g.remove = function(a, b, c) {
        var d = this.Dl(a);
        this.set(a, "", {
            KI: 0,
            path: b,
            domain: c
        });
        return d
    }
    ;
    _.g.mg = function() {
        return Yh(this).keys
    }
    ;
    _.g.ef = function() {
        return Yh(this).values
    }
    ;
    _.g.isEmpty = function() {
        return !this.Nb.cookie
    }
    ;
    _.g.Yb = function() {
        return this.Nb.cookie ? (this.Nb.cookie || "").split(";").length : 0
    }
    ;
    _.g.Dl = function(a) {
        return this.get(a) !== void 0
    }
    ;
    _.g.clear = function() {
        for (var a = Yh(this).keys, b = a.length - 1; b >= 0; b--)
            this.remove(a[b])
    }
    ;
    Yh = function(a) {
        a = (a.Nb.cookie || "").split(";");
        for (var b = [], c = [], d, e, f = 0; f < a.length; f++)
            e = _.vc(a[f]),
            d = e.indexOf("="),
            d == -1 ? (b.push(""),
            c.push(e)) : (b.push(e.substring(0, d)),
            c.push(e.substring(d + 1)));
        return {
            keys: b,
            values: c
        }
    }
    ;
    _.Zh = new _.Xh(typeof document == "undefined" ? null : document);
    _.ii = {};
    _.ji = function(a) {
        return _.ii[a || "token"] || null
    }
    ;
    _.Mi = function(a) {
        a && typeof a.dispose == "function" && a.dispose()
    }
    ;
    _.Ni = function() {
        this.Qg = this.Qg;
        this.Qo = this.Qo
    }
    ;
    _.Ni.prototype.Qg = !1;
    _.Ni.prototype.isDisposed = function() {
        return this.Qg
    }
    ;
    _.Ni.prototype.dispose = function() {
        this.Qg || (this.Qg = !0,
        this.ua())
    }
    ;
    _.Ni.prototype[Symbol.dispose] = function() {
        this.dispose()
    }
    ;
    _.Pi = function(a, b) {
        _.Oi(a, _.fb(_.Mi, b))
    }
    ;
    _.Oi = function(a, b) {
        a.Qg ? b() : (a.Qo || (a.Qo = []),
        a.Qo.push(b))
    }
    ;
    _.Ni.prototype.ua = function() {
        if (this.Qo)
            for (; this.Qo.length; )
                this.Qo.shift()()
    }
    ;
    var Xi;
    Xi = function(a, b) {
        for (var c in a)
            if (b.call(void 0, a[c], c, a))
                return !0;
        return !1
    }
    ;
    _.Yi = function(a) {
        this.src = a;
        this.ne = {};
        this.hx = 0
    }
    ;
    _.$i = function(a, b) {
        this.type = "function" == typeof _.Zi && a instanceof _.Zi ? String(a) : a;
        this.currentTarget = this.target = b;
        this.defaultPrevented = this.Vv = !1
    }
    ;
    _.$i.prototype.stopPropagation = function() {
        this.Vv = !0
    }
    ;
    _.$i.prototype.preventDefault = function() {
        this.defaultPrevented = !0
    }
    ;
    _.aj = function(a, b) {
        _.$i.call(this, a ? a.type : "");
        this.relatedTarget = this.currentTarget = this.target = null;
        this.button = this.screenY = this.screenX = this.clientY = this.clientX = this.offsetY = this.offsetX = 0;
        this.key = "";
        this.charCode = this.keyCode = 0;
        this.metaKey = this.shiftKey = this.altKey = this.ctrlKey = !1;
        this.state = null;
        this.LJ = !1;
        this.pointerId = 0;
        this.pointerType = "";
        this.timeStamp = 0;
        this.Ef = null;
        a && this.od(a, b)
    }
    ;
    _.hb(_.aj, _.$i);
    _.aj.prototype.od = function(a, b) {
        var c = this.type = a.type
          , d = a.changedTouches && a.changedTouches.length ? a.changedTouches[0] : null;
        this.target = a.target || a.srcElement;
        this.currentTarget = b;
        b = a.relatedTarget;
        b || (c == "mouseover" ? b = a.fromElement : c == "mouseout" && (b = a.toElement));
        this.relatedTarget = b;
        d ? (this.clientX = d.clientX !== void 0 ? d.clientX : d.pageX,
        this.clientY = d.clientY !== void 0 ? d.clientY : d.pageY,
        this.screenX = d.screenX || 0,
        this.screenY = d.screenY || 0) : (this.offsetX = _.xd || a.offsetX !== void 0 ? a.offsetX : a.layerX,
        this.offsetY = _.xd || a.offsetY !== void 0 ? a.offsetY : a.layerY,
        this.clientX = a.clientX !== void 0 ? a.clientX : a.pageX,
        this.clientY = a.clientY !== void 0 ? a.clientY : a.pageY,
        this.screenX = a.screenX || 0,
        this.screenY = a.screenY || 0);
        this.button = a.button;
        this.keyCode = a.keyCode || 0;
        this.key = a.key || "";
        this.charCode = a.charCode || (c == "keypress" ? a.keyCode : 0);
        this.ctrlKey = a.ctrlKey;
        this.altKey = a.altKey;
        this.shiftKey = a.shiftKey;
        this.metaKey = a.metaKey;
        this.LJ = _.zd ? a.metaKey : a.ctrlKey;
        this.pointerId = a.pointerId || 0;
        this.pointerType = a.pointerType;
        this.state = a.state;
        this.timeStamp = a.timeStamp;
        this.Ef = a;
        a.defaultPrevented && _.aj.N.preventDefault.call(this)
    }
    ;
    _.aj.prototype.stopPropagation = function() {
        _.aj.N.stopPropagation.call(this);
        this.Ef.stopPropagation ? this.Ef.stopPropagation() : this.Ef.cancelBubble = !0
    }
    ;
    _.aj.prototype.preventDefault = function() {
        _.aj.N.preventDefault.call(this);
        var a = this.Ef;
        a.preventDefault ? a.preventDefault() : a.returnValue = !1
    }
    ;
    _.bj = "closure_listenable_" + (Math.random() * 1E6 | 0);
    _.cj = function(a) {
        return !(!a || !a[_.bj])
    }
    ;
    var dj = 0;
    var ej = function(a, b, c, d, e) {
        this.listener = a;
        this.proxy = null;
        this.src = b;
        this.type = c;
        this.capture = !!d;
        this.Lf = e;
        this.key = ++dj;
        this.bw = this.ny = !1
    }
      , fj = function(a) {
        a.bw = !0;
        a.listener = null;
        a.proxy = null;
        a.src = null;
        a.Lf = null
    };
    _.Yi.prototype.add = function(a, b, c, d, e) {
        var f = a.toString();
        a = this.ne[f];
        a || (a = this.ne[f] = [],
        this.hx++);
        var h = gj(a, b, d, e);
        h > -1 ? (b = a[h],
        c || (b.ny = !1)) : (b = new ej(b,this.src,f,!!d,e),
        b.ny = c,
        a.push(b));
        return b
    }
    ;
    _.Yi.prototype.remove = function(a, b, c, d) {
        a = a.toString();
        if (!(a in this.ne))
            return !1;
        var e = this.ne[a];
        b = gj(e, b, c, d);
        return b > -1 ? (fj(e[b]),
        Array.prototype.splice.call(e, b, 1),
        e.length == 0 && (delete this.ne[a],
        this.hx--),
        !0) : !1
    }
    ;
    _.hj = function(a, b) {
        var c = b.type;
        if (!(c in a.ne))
            return !1;
        var d = _.Qi(a.ne[c], b);
        d && (fj(b),
        a.ne[c].length == 0 && (delete a.ne[c],
        a.hx--));
        return d
    }
    ;
    _.Yi.prototype.removeAll = function(a) {
        a = a && a.toString();
        var b = 0, c;
        for (c in this.ne)
            if (!a || c == a) {
                for (var d = this.ne[c], e = 0; e < d.length; e++)
                    ++b,
                    fj(d[e]);
                delete this.ne[c];
                this.hx--
            }
        return b
    }
    ;
    _.Yi.prototype.Hq = function(a, b, c, d) {
        a = this.ne[a.toString()];
        var e = -1;
        a && (e = gj(a, b, c, d));
        return e > -1 ? a[e] : null
    }
    ;
    _.Yi.prototype.hasListener = function(a, b) {
        var c = a !== void 0
          , d = c ? a.toString() : ""
          , e = b !== void 0;
        return Xi(this.ne, function(f) {
            for (var h = 0; h < f.length; ++h)
                if (!(c && f[h].type != d || e && f[h].capture != b))
                    return !0;
            return !1
        })
    }
    ;
    var gj = function(a, b, c, d) {
        for (var e = 0; e < a.length; ++e) {
            var f = a[e];
            if (!f.bw && f.listener == b && f.capture == !!c && f.Lf == d)
                return e
        }
        return -1
    };
    var ij, jj, kj, oj, qj, rj, sj, uj;
    ij = "closure_lm_" + (Math.random() * 1E6 | 0);
    jj = {};
    kj = 0;
    _.mj = function(a, b, c, d, e) {
        if (d && d.once)
            return _.lj(a, b, c, d, e);
        if (Array.isArray(b)) {
            for (var f = 0; f < b.length; f++)
                _.mj(a, b[f], c, d, e);
            return null
        }
        c = _.nj(c);
        return _.cj(a) ? a.na(b, c, _.wb(d) ? !!d.capture : !!d, e) : oj(a, b, c, !1, d, e)
    }
    ;
    oj = function(a, b, c, d, e, f) {
        if (!b)
            throw Error("B");
        var h = _.wb(e) ? !!e.capture : !!e
          , k = _.pj(a);
        k || (a[ij] = k = new _.Yi(a));
        c = k.add(b, c, d, h, f);
        if (c.proxy)
            return c;
        d = qj();
        c.proxy = d;
        d.src = a;
        d.listener = c;
        if (a.addEventListener)
            _.li || (e = h),
            e === void 0 && (e = !1),
            a.addEventListener(b.toString(), d, e);
        else if (a.attachEvent)
            a.attachEvent(rj(b.toString()), d);
        else if (a.addListener && a.removeListener)
            a.addListener(d);
        else
            throw Error("C");
        kj++;
        return c
    }
    ;
    qj = function() {
        var a = sj
          , b = function(c) {
            return a.call(b.src, b.listener, c)
        };
        return b
    }
    ;
    _.lj = function(a, b, c, d, e) {
        if (Array.isArray(b)) {
            for (var f = 0; f < b.length; f++)
                _.lj(a, b[f], c, d, e);
            return null
        }
        c = _.nj(c);
        return _.cj(a) ? a.qr(b, c, _.wb(d) ? !!d.capture : !!d, e) : oj(a, b, c, !0, d, e)
    }
    ;
    _.tj = function(a) {
        if (typeof a === "number" || !a || a.bw)
            return !1;
        var b = a.src;
        if (_.cj(b))
            return b.uN(a);
        var c = a.type
          , d = a.proxy;
        b.removeEventListener ? b.removeEventListener(c, d, a.capture) : b.detachEvent ? b.detachEvent(rj(c), d) : b.addListener && b.removeListener && b.removeListener(d);
        kj--;
        (c = _.pj(b)) ? (_.hj(c, a),
        c.hx == 0 && (c.src = null,
        b[ij] = null)) : fj(a);
        return !0
    }
    ;
    rj = function(a) {
        return a in jj ? jj[a] : jj[a] = "on" + a
    }
    ;
    sj = function(a, b) {
        if (a.bw)
            a = !0;
        else {
            b = new _.aj(b,this);
            var c = a.listener
              , d = a.Lf || a.src;
            a.ny && _.tj(a);
            a = c.call(d, b)
        }
        return a
    }
    ;
    _.pj = function(a) {
        a = a[ij];
        return a instanceof _.Yi ? a : null
    }
    ;
    uj = "__closure_events_fn_" + (Math.random() * 1E9 >>> 0);
    _.nj = function(a) {
        if (typeof a === "function")
            return a;
        a[uj] || (a[uj] = function(b) {
            return a.handleEvent(b)
        }
        );
        return a[uj]
    }
    ;
    _.Wi(function(a) {
        sj = a(sj)
    });
    _.vj = function(a, b) {
        var c = a.length - b.length;
        return c >= 0 && a.indexOf(b, c) == c
    }
    ;
    _.Sd.prototype.O = _.nb(1, function(a) {
        return _.ki(this.Nb, a)
    });
    _.wj = function(a, b, c, d, e) {
        if (Array.isArray(b))
            for (var f = 0; f < b.length; f++)
                _.wj(a, b[f], c, d, e);
        else
            d = _.wb(d) ? !!d.capture : !!d,
            c = _.nj(c),
            _.cj(a) ? a.Bc(b, c, d, e) : a && (a = _.pj(a)) && (b = a.Hq(b, c, d, e)) && _.tj(b)
    }
    ;
    _.xj = function() {
        _.Ni.call(this);
        this.mk = new _.Yi(this);
        this.m6 = this;
        this.DJ = null
    }
    ;
    _.hb(_.xj, _.Ni);
    _.xj.prototype[_.bj] = !0;
    _.g = _.xj.prototype;
    _.g.Zn = function() {
        return this.DJ
    }
    ;
    _.g.SC = function(a) {
        this.DJ = a
    }
    ;
    _.g.addEventListener = function(a, b, c, d) {
        _.mj(this, a, b, c, d)
    }
    ;
    _.g.removeEventListener = function(a, b, c, d) {
        _.wj(this, a, b, c, d)
    }
    ;
    _.g.dispatchEvent = function(a) {
        var b, c = this.Zn();
        if (c)
            for (b = []; c; c = c.Zn())
                b.push(c);
        c = this.m6;
        var d = a.type || a;
        if (typeof a === "string")
            a = new _.$i(a,c);
        else if (a instanceof _.$i)
            a.target = a.target || c;
        else {
            var e = a;
            a = new _.$i(d,c);
            _.Si(a, e)
        }
        e = !0;
        var f;
        if (b)
            for (f = b.length - 1; !a.Vv && f >= 0; f--) {
                var h = a.currentTarget = b[f];
                e = h.eu(d, !0, a) && e
            }
        a.Vv || (h = a.currentTarget = c,
        e = h.eu(d, !0, a) && e,
        a.Vv || (e = h.eu(d, !1, a) && e));
        if (b)
            for (f = 0; !a.Vv && f < b.length; f++)
                h = a.currentTarget = b[f],
                e = h.eu(d, !1, a) && e;
        return e
    }
    ;
    _.g.ua = function() {
        _.xj.N.ua.call(this);
        this.iK();
        this.DJ = null
    }
    ;
    _.g.na = function(a, b, c, d) {
        return this.mk.add(String(a), b, !1, c, d)
    }
    ;
    _.g.qr = function(a, b, c, d) {
        return this.mk.add(String(a), b, !0, c, d)
    }
    ;
    _.g.Bc = function(a, b, c, d) {
        return this.mk.remove(String(a), b, c, d)
    }
    ;
    _.g.uN = function(a) {
        return _.hj(this.mk, a)
    }
    ;
    _.g.iK = function() {
        this.mk && this.mk.removeAll(void 0)
    }
    ;
    _.g.eu = function(a, b, c) {
        a = this.mk.ne[String(a)];
        if (!a)
            return !0;
        a = a.concat();
        for (var d = !0, e = 0; e < a.length; ++e) {
            var f = a[e];
            if (f && !f.bw && f.capture == b) {
                var h = f.listener
                  , k = f.Lf || f.src;
                f.ny && this.uN(f);
                d = h.call(k, c) !== !1 && d
            }
        }
        return d && !c.defaultPrevented
    }
    ;
    _.g.Hq = function(a, b, c, d) {
        return this.mk.Hq(String(a), b, c, d)
    }
    ;
    _.g.hasListener = function(a, b) {
        return this.mk.hasListener(a !== void 0 ? String(a) : void 0, b)
    }
    ;
    var er;
    er = function() {
        var a = _.Ec();
        if (_.Lc())
            return _.Sc(a);
        a = _.Ic(a);
        var b = _.Rc(a);
        return _.Kc() ? b(["Version", "Opera"]) : _.Mc() ? b(["Edge"]) : _.Oc() ? b(["Edg"]) : _.Hc("Silk") ? b(["Silk"]) : _.Qc() ? b(["Chrome", "CriOS", "HeadlessChrome"]) : (a = a[2]) && a[1] || ""
    }
    ;
    _.fr = function(a) {
        return _.xc(er(), a) >= 0
    }
    ;
    _.hr = function() {
        return _.Ob && _.Fc ? _.Fc.mobile : !_.gr() && (_.Hc("iPod") || _.Hc("iPhone") || _.Hc("Android") || _.Hc("IEMobile"))
    }
    ;
    _.gr = function() {
        return _.Ob && _.Fc ? !_.Fc.mobile && (_.Hc("iPad") || _.Hc("Android") || _.Hc("Silk")) : _.Hc("iPad") || _.Hc("Android") && !_.Hc("Mobile") || _.Hc("Silk")
    }
    ;
    _.ir = function() {
        return !_.hr() && !_.gr()
    }
    ;
    var ss;
    ss = function(a, b, c) {
        return arguments.length <= 2 ? Array.prototype.slice.call(a, b) : Array.prototype.slice.call(a, b, c)
    }
    ;
    _.ts = function(a, b, c, d) {
        return Array.prototype.splice.apply(a, ss(arguments, 1))
    }
    ;
    _.us = function(a, b, c) {
        if (a !== null && b in a)
            throw Error("h`" + b);
        a[b] = c
    }
    ;
    _.vs = function(a, b) {
        var c = b || document;
        c.getElementsByClassName ? a = c.getElementsByClassName(a)[0] : (c = document,
        a = a ? (b || c).querySelector(a ? "." + a : "") : _.Vd(c, "*", a, b)[0] || null);
        return a || null
    }
    ;
    _.ws = function(a, b) {
        b.parentNode && b.parentNode.insertBefore(a, b.nextSibling)
    }
    ;
    _.xs = function(a, b, c) {
        a && !c && (a = a.parentNode);
        for (c = 0; a; ) {
            if (b(a))
                return a;
            a = a.parentNode;
            c++
        }
        return null
    }
    ;
    _.ys = function(a) {
        _.Ni.call(this);
        this.xg = a;
        this.lc = {}
    }
    ;
    _.hb(_.ys, _.Ni);
    var zs = [];
    _.ys.prototype.na = function(a, b, c, d) {
        return this.wv(a, b, c, d)
    }
    ;
    _.ys.prototype.wv = function(a, b, c, d, e) {
        Array.isArray(b) || (b && (zs[0] = b.toString()),
        b = zs);
        for (var f = 0; f < b.length; f++) {
            var h = _.mj(a, b[f], c || this.handleEvent, d || !1, e || this.xg || this);
            if (!h)
                break;
            this.lc[h.key] = h
        }
        return this
    }
    ;
    _.ys.prototype.qr = function(a, b, c, d) {
        return As(this, a, b, c, d)
    }
    ;
    var As = function(a, b, c, d, e, f) {
        if (Array.isArray(c))
            for (var h = 0; h < c.length; h++)
                As(a, b, c[h], d, e, f);
        else {
            b = _.lj(b, c, d || a.handleEvent, e, f || a.xg || a);
            if (!b)
                return a;
            a.lc[b.key] = b
        }
        return a
    };
    _.ys.prototype.Bc = function(a, b, c, d, e) {
        if (Array.isArray(b))
            for (var f = 0; f < b.length; f++)
                this.Bc(a, b[f], c, d, e);
        else
            c = c || this.handleEvent,
            d = _.wb(d) ? !!d.capture : !!d,
            e = e || this.xg || this,
            c = _.nj(c),
            d = !!d,
            b = _.cj(a) ? a.Hq(b, c, d, e) : a ? (a = _.pj(a)) ? a.Hq(b, c, d, e) : null : null,
            b && (_.tj(b),
            delete this.lc[b.key]);
        return this
    }
    ;
    _.ys.prototype.removeAll = function() {
        _.Sb(this.lc, function(a, b) {
            this.lc.hasOwnProperty(b) && _.tj(a)
        }, this);
        this.lc = {}
    }
    ;
    _.ys.prototype.ua = function() {
        _.ys.N.ua.call(this);
        this.removeAll()
    }
    ;
    _.ys.prototype.handleEvent = function() {
        throw Error("L");
    }
    ;
    var ku, lu, mu, nu, ou, qu, ru, su, tu, vu;
    _.iu = function(a, b) {
        for (var c in a)
            if (!(c in b) || a[c] !== b[c])
                return !1;
        for (var d in b)
            if (!(d in a))
                return !1;
        return !0
    }
    ;
    _.ju = !1;
    ku = function(a) {
        try {
            _.ju && window.console && window.console.log && window.console.log(a)
        } catch (b) {}
    }
    ;
    lu = function(a) {
        try {
            window.console && window.console.warn && window.console.warn(a)
        } catch (b) {}
    }
    ;
    mu = function(a, b) {
        if (!a)
            return -1;
        if (a.indexOf)
            return a.indexOf(b, void 0);
        for (var c = 0, d = a.length; c < d; c++)
            if (a[c] === b)
                return c;
        return -1
    }
    ;
    nu = function(a, b) {
        function c() {}
        if (!a)
            throw Error("O");
        if (!b)
            throw Error("P");
        c.prototype = b.prototype;
        a.prototype = new c;
        a.prototype.constructor = a
    }
    ;
    ou = function(a) {
        return Object.prototype.toString.call(a) === "[object Function]"
    }
    ;
    _.pu = function(a) {
        var b = {};
        if (a)
            for (var c in a)
                a.hasOwnProperty(c) && (b[c] = a[c]);
        return b
    }
    ;
    qu = function(a) {
        var b = location.hash;
        a = new RegExp("[&#]" + a + "=([^&]*)");
        b = decodeURIComponent(b);
        b = a.exec(b);
        return b == null ? "" : b[1].replace(/\+/g, " ")
    }
    ;
    ru = function(a, b, c) {
        if (a.addEventListener)
            a.addEventListener(b, c, !1);
        else if (a.attachEvent)
            a.attachEvent("on" + b, c);
        else
            throw Error("Q`" + b);
    }
    ;
    su = {
        token: 1,
        id_token: 1
    };
    tu = function() {
        var a = navigator.userAgent.toLowerCase();
        return a.indexOf("msie") != -1 && parseInt(a.split("msie")[1], 10) == 8
    }
    ;
    _.uu = window.JSON;
    vu = function(a) {
        this.GN = a || [];
        this.mc = {}
    }
    ;
    vu.prototype.addEventListener = function(a, b) {
        if (!(mu(this.GN, a) >= 0))
            throw Error("S`" + a);
        if (!ou(b))
            throw Error("T`" + a);
        this.mc[a] || (this.mc[a] = []);
        mu(this.mc[a], b) < 0 && this.mc[a].push(b)
    }
    ;
    vu.prototype.removeEventListener = function(a, b) {
        if (!(mu(this.GN, a) >= 0))
            throw Error("S`" + a);
        ou(b) && this.mc[a] && this.mc[a].length && (b = mu(this.mc[a], b),
        b >= 0 && this.mc[a].splice(b, 1))
    }
    ;
    vu.prototype.dispatchEvent = function(a) {
        var b = a.type;
        if (!(b && mu(this.GN, b) >= 0))
            throw Error("U`" + b);
        if (this.mc[b] && this.mc[b].length)
            for (var c = this.mc[b].length, d = 0; d < c; d++)
                this.mc[b][d](a)
    }
    ;
    var wu, xu, yu, Au, Bu, Fu, Gu, Hu, Yu, Zu, av, bv, dv, hv, iv, jv, nv;
    wu = _.cd(["https://accounts.google.com/gsi/ottoken"]);
    xu = {};
    yu = {};
    _.zu = function() {
        if (_.$c() && !_.fr("118"))
            return !1;
        var a = _.Qc() && !_.Oc() && !_.Pc()
          , b = _.Uc() || _.ir();
        return "IdentityCredential"in window && a && b && (_.ir() && _.fr("126") || _.Uc() && _.fr("128"))
    }
    ;
    Au = function() {
        var a = _.qc(wu)
          , b = document.createElement("script");
        _.Cc(b, a);
        document.head.append(b)
    }
    ;
    Bu = {
        google: {
            fedcmConfigUrl: "https://accounts.google.com/o/fedcm/config.json",
            authServerUrl: "https://accounts.google.com/o/oauth2/auth",
            idpIFrameUrl: "https://accounts.google.com/o/oauth2/iframe"
        }
    };
    _.Cu = function(a, b) {
        if (a = Bu[a])
            return a[b]
    }
    ;
    _.Du = function(a, b) {
        if (!a)
            throw Error("V");
        if (!b.authServerUrl)
            throw Error("W");
        if (!b.idpIFrameUrl)
            throw Error("X");
        Bu[a] = {
            authServerUrl: b.authServerUrl,
            idpIFrameUrl: b.idpIFrameUrl
        };
        b.fedcmConfigUrl ? Bu[a].fedcmConfigUrl = b.fedcmConfigUrl : a === "google" && (Bu[a].fedcmConfigUrl = "https://accounts.google.com/o/fedcm/config.json")
    }
    ;
    _.Eu = void 0;
    Fu = function(a) {
        a.style.position = "absolute";
        a.style.width = "1px";
        a.style.height = "1px";
        a.style.left = "-9999px";
        a.style.top = "-9999px";
        a.style.right = "-9999px";
        a.style.bottom = "-9999px";
        a.style.display = "none";
        a.setAttribute("aria-hidden", "true")
    }
    ;
    Gu = function() {
        var a = document.createElement("meta");
        a.httpEquiv = "origin-trial";
        a.content = "A9oUGVr8Ibk5UWwpJ2ghoWvGAu4Ug9mXqB4jL7sTvGRiM0w/hvlJigzuFnVws2L5Ubka7/qtZN3SBA+6CANkhggAAABseyJvcmlnaW4iOiJodHRwczovL2FwaXMuZ29vZ2xlLmNvbTo0NDMiLCJmZWF0dXJlIjoiRmVkQ21CdXR0b25Nb2RlIiwiZXhwaXJ5IjoxNzQ0Njc1MjAwLCJpc1RoaXJkUGFydHkiOnRydWV9";
        document.head.append(a);
        a = document.createElement("meta");
        a.httpEquiv = "origin-trial";
        a.content = "A51IF34nfUhYewkWUs7YMpC+c0brDD7/LkZdfOyLtoSMkGsKscMMCHNAU6UQQlKPsr866jNdLoCqHE0YTeAPtAIAAAByeyJvcmlnaW4iOiJodHRwczovL2FwaXMuZ29vZ2xlLmNvbTo0NDMiLCJmZWF0dXJlIjoiRmVkQ21Db250aW51ZU9uQnVuZGxlIiwiZXhwaXJ5IjoxNzQ0Njc1MjAwLCJpc1RoaXJkUGFydHkiOnRydWV9";
        document.head.append(a)
    }
    ;
    Hu = function() {
        this.Li = window;
        this.Ky = this.zn = this.Sv = this.zi = null
    }
    ;
    Hu.prototype.open = function(a, b, c, d) {
        Iu(this);
        this.Sv ? (this.zn && (this.zn(),
        this.zn = null),
        Ju(this)) : this.Sv = "authPopup" + Math.floor(Math.random() * 1E6 + 1);
        a: {
            this.zi = this.Li.open(a, this.Sv, b);
            try {
                this.zi.focus();
                if (this.zi.closed || typeof this.zi.closed == "undefined")
                    throw Error("Z");
                _.Eu = this.zi
            } catch (e) {
                d && setTimeout(d, 0);
                this.zi = null;
                break a
            }
            c && (this.zn = c,
            Ku(this))
        }
    }
    ;
    var Iu = function(a) {
        try {
            if (a.zi == null || a.zi.closed)
                a.zi = null,
                a.Sv = null,
                Ju(a),
                a.zn && (a.zn(),
                a.zn = null)
        } catch (b) {
            a.zi = null,
            a.Sv = null,
            Ju(a)
        }
    }
      , Ku = function(a) {
        a.Ky = window.setInterval(function() {
            Iu(a)
        }, 300)
    }
      , Ju = function(a) {
        a.Ky && (window.clearInterval(a.Ky),
        a.Ky = null)
    };
    yu = yu || {};
    var Lu = function(a, b) {
        this.Xb = a;
        this.XH = b;
        this.Rc = null;
        this.vo = !1
    };
    Lu.prototype.start = function() {
        if (!this.vo && !this.Rc) {
            var a = this;
            this.Rc = window.setTimeout(function() {
                a.clear();
                a.vo || (a.Xb(),
                a.vo = !0)
            }, yu.KT(this.XH))
        }
    }
    ;
    Lu.prototype.clear = function() {
        this.Rc && (window.clearTimeout(this.Rc),
        this.Rc = null)
    }
    ;
    var Mu = function(a, b) {
        var c = yu.bt;
        this.Faa = yu.Rs;
        this.q1 = c;
        this.Xb = a;
        this.XH = b;
        this.Rc = null;
        this.vo = !1;
        var d = this;
        this.s1 = function() {
            document[d.Faa] || (d.clear(),
            d.start())
        }
    };
    Mu.prototype.start = function() {
        if (!this.vo && !this.Rc) {
            ru(document, this.q1, this.s1);
            var a = this;
            this.Rc = window.setTimeout(function() {
                a.clear();
                a.vo || (a.Xb(),
                a.vo = !0)
            }, yu.KT(this.XH))
        }
    }
    ;
    Mu.prototype.clear = function() {
        var a = this.q1
          , b = this.s1
          , c = document;
        if (c.removeEventListener)
            c.removeEventListener(a, b, !1);
        else if (c.detachEvent)
            c.detachEvent("on" + a, b);
        else
            throw Error("R`" + a);
        this.Rc && (window.clearTimeout(this.Rc),
        this.Rc = null)
    }
    ;
    yu.Rs = null;
    yu.bt = null;
    yu.hba = function() {
        var a = document;
        typeof a.hidden !== "undefined" ? (yu.Rs = "hidden",
        yu.bt = "visibilitychange") : typeof a.msHidden !== "undefined" ? (yu.Rs = "msHidden",
        yu.bt = "msvisibilitychange") : typeof a.webkitHidden !== "undefined" && (yu.Rs = "webkitHidden",
        yu.bt = "webkitvisibilitychange")
    }
    ;
    yu.hba();
    yu.C7 = function(a, b) {
        return yu.Rs && yu.bt ? new Mu(a,b) : new Lu(a,b)
    }
    ;
    yu.KT = function(a) {
        return Math.max(1, a - (new Date).getTime())
    }
    ;
    var Nu = function(a, b) {
        document.cookie = "G_ENABLED_IDPS=" + a + ";domain=." + b + ";expires=Fri, 31 Dec 9999 12:00:00 GMT;path=/"
    }
      , Ou = function() {
        function a() {
            e[0] = 1732584193;
            e[1] = 4023233417;
            e[2] = 2562383102;
            e[3] = 271733878;
            e[4] = 3285377520;
            n = m = 0
        }
        function b(p) {
            for (var q = h, u = 0; u < 64; u += 4)
                q[u / 4] = p[u] << 24 | p[u + 1] << 16 | p[u + 2] << 8 | p[u + 3];
            for (u = 16; u < 80; u++)
                p = q[u - 3] ^ q[u - 8] ^ q[u - 14] ^ q[u - 16],
                q[u] = (p << 1 | p >>> 31) & 4294967295;
            p = e[0];
            var v = e[1]
              , t = e[2]
              , y = e[3]
              , z = e[4];
            for (u = 0; u < 80; u++) {
                if (u < 40)
                    if (u < 20) {
                        var C = y ^ v & (t ^ y);
                        var F = 1518500249
                    } else
                        C = v ^ t ^ y,
                        F = 1859775393;
                else
                    u < 60 ? (C = v & t | y & (v | t),
                    F = 2400959708) : (C = v ^ t ^ y,
                    F = 3395469782);
                C = ((p << 5 | p >>> 27) & 4294967295) + C + z + F + q[u] & 4294967295;
                z = y;
                y = t;
                t = (v << 30 | v >>> 2) & 4294967295;
                v = p;
                p = C
            }
            e[0] = e[0] + p & 4294967295;
            e[1] = e[1] + v & 4294967295;
            e[2] = e[2] + t & 4294967295;
            e[3] = e[3] + y & 4294967295;
            e[4] = e[4] + z & 4294967295
        }
        function c(p, q) {
            if (typeof p === "string") {
                p = unescape(encodeURIComponent(p));
                for (var u = [], v = 0, t = p.length; v < t; ++v)
                    u.push(p.charCodeAt(v));
                p = u
            }
            q || (q = p.length);
            u = 0;
            if (m == 0)
                for (; u + 64 < q; )
                    b(p.slice(u, u + 64)),
                    u += 64,
                    n += 64;
            for (; u < q; )
                if (f[m++] = p[u++],
                n++,
                m == 64)
                    for (m = 0,
                    b(f); u + 64 < q; )
                        b(p.slice(u, u + 64)),
                        u += 64,
                        n += 64
        }
        function d() {
            var p = []
              , q = n * 8;
            m < 56 ? c(k, 56 - m) : c(k, 64 - (m - 56));
            for (var u = 63; u >= 56; u--)
                f[u] = q & 255,
                q >>>= 8;
            b(f);
            for (u = q = 0; u < 5; u++)
                for (var v = 24; v >= 0; v -= 8)
                    p[q++] = e[u] >> v & 255;
            return p
        }
        for (var e = [], f = [], h = [], k = [128], l = 1; l < 64; ++l)
            k[l] = 0;
        var m, n;
        a();
        return {
            reset: a,
            update: c,
            digest: d,
            Si: function() {
                for (var p = d(), q = "", u = 0; u < p.length; u++)
                    q += "0123456789ABCDEF".charAt(Math.floor(p[u] / 16)) + "0123456789ABCDEF".charAt(p[u] % 16);
                return q
            }
        }
    }
      , Pu = window.crypto
      , Qu = !1
      , Ru = 0
      , Su = 1
      , Tu = 0
      , Uu = ""
      , Vu = function(a) {
        a = a || window.event;
        var b = a.screenX + a.clientX << 16;
        b += a.screenY + a.clientY;
        b *= (new Date).getTime() % 1E6;
        Su = Su * b % Tu;
        if (++Ru == 3)
            if (a = window,
            b = Vu,
            a.removeEventListener)
                a.removeEventListener("mousemove", b, !1);
            else if (a.detachEvent)
                a.detachEvent("onmousemove", b);
            else
                throw Error("R`mousemove");
    }
      , Wu = function(a) {
        var b = Ou();
        b.update(a);
        return b.Si()
    };
    Qu = !!Pu && typeof Pu.getRandomValues == "function";
    Qu || (Tu = (screen.width * screen.width + screen.height) * 1E6,
    Uu = Wu(document.cookie + "|" + document.location + "|" + (new Date).getTime() + "|" + Math.random()),
    ru(window, "mousemove", Vu));
    xu = xu || {};
    xu.z3 = "ssIFrame_";
    _.Xu = function(a, b, c) {
        c = c === void 0 ? !1 : c;
        this.Cb = a;
        if (!this.Cb)
            throw Error("$");
        a = _.Cu(a, "idpIFrameUrl");
        if (!a)
            throw Error("aa");
        this.RU = a;
        if (!b)
            throw Error("ba");
        this.Um = b;
        a = this.RU;
        b = document.createElement("a");
        b.setAttribute("href", a);
        a = [b.protocol, "//", b.hostname];
        b.protocol == "http:" && b.port != "" && b.port != "0" && b.port != "80" ? (a.push(":"),
        a.push(b.port)) : b.protocol == "https:" && b.port != "" && b.port != "0" && b.port != "443" && (a.push(":"),
        a.push(b.port));
        this.GH = a.join("");
        this.Fea = [location.protocol, "//", location.host].join("");
        this.Sw = this.FH = this.zo = !1;
        this.NU = null;
        this.wB = [];
        this.Lr = [];
        this.Yj = {};
        this.Ao = void 0;
        this.Kp = c
    }
    ;
    _.g = _.Xu.prototype;
    _.g.show = function() {
        var a = this.Ao;
        a.style.position = "fixed";
        a.style.width = "100%";
        a.style.height = "100%";
        a.style.left = "0px";
        a.style.top = "0px";
        a.style.right = "0px";
        a.style.bottom = "0px";
        a.style.display = "block";
        a.style.zIndex = "9999999";
        a.style.overflow = "hidden";
        a.setAttribute("aria-hidden", "false")
    }
    ;
    _.g.hide = function() {
        Fu(this.Ao)
    }
    ;
    _.g.cB = function(a) {
        if (this.zo)
            a && a(this);
        else {
            if (!this.Ao) {
                var b = xu.z3 + this.Cb;
                var c = this.Cb;
                var d = location.hostname;
                var e, f = document.cookie.match("(^|;) ?G_ENABLED_IDPS=([^;]*)(;|$)");
                f && f.length > 2 && (e = f[2]);
                (f = e && mu(e.split("|"), c) >= 0) ? Nu(e, d) : Nu(e ? e + "|" + c : c, d);
                c = !f;
                var h = this.RU
                  , k = this.Fea;
                d = this.Um;
                e = this.Kp;
                e = e === void 0 ? !1 : e;
                f = document.createElement("iframe");
                f.setAttribute("id", b);
                b = f.setAttribute;
                var l = "allow-scripts allow-same-origin";
                document.requestStorageAccess && ou(document.requestStorageAccess) && (l += " allow-storage-access-by-user-activation");
                b.call(f, "sandbox", l);
                f.setAttribute("allow", "identity-credentials-get");
                Fu(f);
                f.setAttribute("frame-border", "0");
                b = [h, "#origin=", encodeURIComponent(k)];
                b.push("&rpcToken=");
                b.push(encodeURIComponent(d));
                c && b.push("&clearCache=1");
                _.ju && b.push("&debug=1");
                e && b.push("&supportBlocked3PCookies=1");
                document.body.appendChild(f);
                f.setAttribute("src", b.join(""));
                this.Ao = f
            }
            a && this.wB.push(a)
        }
    }
    ;
    _.g.SV = function() {
        return this.zo && this.Sw
    }
    ;
    _.g.Xn = function() {
        return this.NU
    }
    ;
    Yu = function(a) {
        for (var b = 0; b < a.wB.length; b++)
            a.wB[b](a);
        a.wB = []
    }
    ;
    _.$u = function(a, b, c, d) {
        if (a.zo) {
            if (a.zo && a.FH)
                throw a = "Failed to communicate with IDP IFrame due to unitialization error: " + a.Xn(),
                ku(a),
                Error(a);
            Zu(a, {
                method: b,
                params: c
            }, d)
        } else
            a.Lr.push({
                kp: {
                    method: b,
                    params: c
                },
                callback: d
            }),
            a.cB()
    }
    ;
    Zu = function(a, b, c) {
        if (c) {
            for (var d = b.id; !d || a.Yj[d]; )
                d = (new Date).getMilliseconds() + "-" + (Math.random() * 1E6 + 1);
            b.id = d;
            a.Yj[d] = c
        }
        b.rpcToken = a.Um;
        a.Ao.contentWindow.postMessage(_.uu.stringify(b), a.GH)
    }
    ;
    av = function(a) {
        if (a && a.indexOf("::") >= 0)
            throw Error("ca");
    }
    ;
    _.Xu.prototype.vj = function(a, b, c, d, e, f, h, k, l) {
        l = l === void 0 ? !1 : l;
        av(f);
        b = _.pu(b);
        _.$u(this, "getTokenResponse", {
            clientId: a,
            loginHint: c,
            request: b,
            sessionSelector: d,
            forceRefresh: h,
            skipCache: k,
            id: f,
            userInteracted: l
        }, e)
    }
    ;
    _.Xu.prototype.aB = function(a, b, c, d, e) {
        b = _.pu(b);
        _.$u(this, "listIdpSessions", {
            clientId: a,
            request: b,
            sessionSelector: c,
            forceRefresh: e
        }, d)
    }
    ;
    bv = function(a, b, c) {
        av(b.identifier);
        _.$u(a, "getSessionSelector", b, c)
    }
    ;
    _.cv = function(a, b, c, d, e) {
        av(b.identifier);
        _.$u(a, "setSessionSelector", {
            domain: b.domain,
            crossSubDomains: b.crossSubDomains,
            policy: b.policy,
            id: b.id,
            hint: d,
            disabled: !!c
        }, e)
    }
    ;
    dv = function(a, b, c, d, e, f, h) {
        b = {
            clientId: b
        };
        c && (b.pluginName = c);
        d && (b.ackExtensionDate = d);
        b.useFedCm = e;
        f && (b.fedCmEnabled = f);
        _.$u(a, "monitorClient", b, h)
    }
    ;
    _.Xu.prototype.revoke = _.kb(8);
    _.Xu.prototype.qt = _.kb(10);
    xu.wA = {};
    xu.FG = function(a) {
        return xu.wA[a]
    }
    ;
    xu.cB = function(a, b, c) {
        c = c === void 0 ? !1 : c;
        var d = xu.FG(a);
        if (!d) {
            d = String;
            if (Qu) {
                var e = new window.Uint32Array(1);
                Pu.getRandomValues(e);
                e = Number("0." + e[0])
            } else
                e = Su,
                e += parseInt(Uu.substr(0, 20), 16),
                Uu = Wu(Uu),
                e /= Tu + 1.2089258196146292E24;
            d = new _.Xu(a,d(2147483647 * e),c);
            xu.wA[a] = d
        }
        d.cB(b)
    }
    ;
    xu.l9 = function(a) {
        for (var b in xu.wA) {
            var c = xu.FG(b);
            if (c && c.Ao && c.Ao.contentWindow == a.source && c.GH == a.origin)
                return c
        }
    }
    ;
    xu.O9 = function(a) {
        for (var b in xu.wA) {
            var c = xu.FG(b);
            if (c && c.GH == a)
                return c
        }
    }
    ;
    xu = xu || {};
    var fv = function() {
        var a = [], b;
        for (b in _.ev)
            a.push(_.ev[b]);
        vu.call(this, a);
        this.lm = {};
        ku("EventBus is ready.")
    };
    nu(fv, vu);
    _.ev = {
        k5: "sessionSelectorChanged",
        mE: "sessionStateChanged",
        Ps: "authResult",
        t2: "displayIFrame"
    };
    hv = function(a, b) {
        var c = gv;
        a && b && (c.lm[a] || (c.lm[a] = []),
        mu(c.lm[a], b) < 0 && c.lm[a].push(b))
    }
    ;
    iv = function(a) {
        var b = gv;
        a && (b.lm[a] || (b.lm[a] = []))
    }
    ;
    jv = function(a, b, c) {
        return b && a.lm[b] && mu(a.lm[b], c) >= 0
    }
    ;
    _.g = fv.prototype;
    _.g.Mda = function(a) {
        var b, c = !!a.source && (a.source === _.Eu || a.source.opener === window);
        if (b = c ? xu.O9(a.origin) : xu.l9(a)) {
            try {
                var d = _.uu.parse(a.data)
            } catch (e) {
                ku("Bad event, an error happened when parsing data.");
                return
            }
            if (!c) {
                if (!d || !d.rpcToken || d.rpcToken != b.Um) {
                    ku("Bad event, no RPC token.");
                    return
                }
                if (d.id && !d.method) {
                    c = d;
                    if (a = b.Yj[c.id])
                        delete b.Yj[c.id],
                        a(c.result, c.error);
                    return
                }
            }
            d.method != "fireIdpEvent" ? ku("Bad IDP event, method unknown.") : (a = d.params) && a.type && this.QU[a.type] ? (d = this.QU[a.type],
            c && !d.r6 ? ku("Bad IDP event. Source window cannot be a popup.") : d.Ks && !d.Ks.call(this, b, a) ? ku("Bad IDP event.") : d.Lf.call(this, b, a)) : ku("Bad IDP event.")
        } else
            ku("Bad event, no corresponding Idp Stub.")
    }
    ;
    _.g.kfa = function(a, b) {
        return jv(this, a.Cb, b.clientId)
    }
    ;
    _.g.jfa = function(a, b) {
        a = a.Cb;
        b = b.clientId;
        return !b || jv(this, a, b)
    }
    ;
    _.g.D6 = function(a, b) {
        return jv(this, a.Cb, b.clientId)
    }
    ;
    _.g.Vca = function(a, b) {
        a.zo = !0;
        a.Sw = !!b.cookieDisabled;
        Yu(a);
        for (b = 0; b < a.Lr.length; b++)
            Zu(a, a.Lr[b].kp, a.Lr[b].callback);
        a.Lr = []
    }
    ;
    _.g.Uca = function(a, b) {
        b = {
            error: b.error
        };
        a.zo = !0;
        a.FH = !0;
        a.NU = b;
        a.Lr = [];
        Yu(a)
    }
    ;
    _.g.XB = function(a, b) {
        b.originIdp = a.Cb;
        this.dispatchEvent(b)
    }
    ;
    var gv = new fv
      , kv = gv
      , lv = {};
    lv.idpReady = {
        Lf: kv.Vca
    };
    lv.idpError = {
        Lf: kv.Uca
    };
    lv.sessionStateChanged = {
        Lf: kv.XB,
        Ks: kv.kfa
    };
    lv.sessionSelectorChanged = {
        Lf: kv.XB,
        Ks: kv.jfa
    };
    lv.authResult = {
        Lf: kv.XB,
        Ks: kv.D6,
        r6: !0
    };
    lv.displayIFrame = {
        Lf: kv.XB
    };
    gv.QU = lv || {};
    ru(window, "message", function(a) {
        gv.Mda.call(gv, a)
    });
    _.mv = function(a, b) {
        this.Pe = !1;
        if (!a)
            throw Error("da");
        var c = [], d;
        for (d in a)
            c.push(a[d]);
        vu.call(this, c);
        this.Dd = [location.protocol, "//", location.host].join("");
        this.Zd = b.crossSubDomains ? b.domain || this.Dd : this.Dd;
        if (!b)
            throw Error("ea");
        if (!b.idpId)
            throw Error("fa");
        if (!_.Cu(b.idpId, "authServerUrl") || !_.Cu(b.idpId, "idpIFrameUrl"))
            throw Error("ga`" + b.idpId);
        this.Cb = b.idpId;
        this.Pb = void 0;
        this.O7 = !!b.disableTokenRefresh;
        this.J8 = !!b.forceTokenRefresh;
        this.gga = !!b.skipTokenCache;
        this.Kp = !!b.supportBlocked3PCookies;
        b.pluginName && (this.Bda = b.pluginName);
        b.ackExtensionDate && (this.i6 = b.ackExtensionDate);
        this.Rga = b.useFedCm;
        this.s8 = this.Kp && _.zu();
        this.setOptions(b);
        this.Ht = [];
        this.Sw = this.Ck = this.EV = !1;
        this.lj = void 0;
        this.NY();
        this.Qd = void 0;
        var e = this
          , f = function() {
            ku("Token Manager is ready.");
            if (e.Ht.length)
                for (var h = 0; h < e.Ht.length; h++)
                    e.Ht[h].call(e);
            e.EV = !0;
            e.Ht = []
        };
        this.Kp && (Gu(),
        Au());
        xu.cB(this.Cb, function(h) {
            e.Qd = h;
            h.zo && h.FH ? (e.Ck = !0,
            e.lj = h.Xn(),
            e.Cr(e.lj)) : (e.Sw = h.SV(),
            e.Pb ? dv(e.Qd, e.Pb, e.Bda, e.i6, e.Rga, e.s8, function(k) {
                var l = !!k.validOrigin
                  , m = !!k.blocked
                  , n = !!k.suppressed;
                k.invalidExtension ? (e.lj = {
                    error: "Invalid value for ack_extension_date. Please refer to [Migration Guide](https://developers.google.com/identity/gsi/web/guides/gis-migration) for more information."
                },
                e.Ck = !0,
                e.Cr(e.lj)) : l ? m ? n ? (lu("You have created a new client application that uses libraries for user authentication or authorization that are deprecated. New clients must use the new libraries instead. See the [Migration Guide](https://developers.google.com/identity/gsi/web/guides/gis-migration) for more information."),
                hv(e.Cb, e.Pb),
                f()) : (e.lj = {
                    error: "You have created a new client application that uses libraries for user authentication or authorization that are deprecated. New clients must use the new libraries instead. See the [Migration Guide](https://developers.google.com/identity/gsi/web/guides/gis-migration) for more information."
                },
                e.Ck = !0,
                e.Cr(e.lj)) : (lu("Your client application uses libraries for user authentication or authorization that are deprecated. See the [Migration Guide](https://developers.google.com/identity/gsi/web/guides/gis-migration) for more information."),
                hv(e.Cb, e.Pb),
                f()) : (e.lj = {
                    error: "Not a valid origin for the client: " + e.Dd + " has not been registered for client ID " + e.Pb + ". Please go to https://console.developers.google.com/ and register this origin for your project's client ID."
                },
                e.Ck = !0,
                e.Cr(e.lj))
            }) : (iv(e.Cb),
            f()))
        }, this.Kp)
    }
    ;
    nu(_.mv, vu);
    _.g = _.mv.prototype;
    _.g.setOptions = function() {}
    ;
    _.g.NY = function() {}
    ;
    _.g.Cr = function() {}
    ;
    _.g.SV = function() {
        return this.Sw
    }
    ;
    _.g.Xn = function() {
        return this.lj
    }
    ;
    nv = function(a, b, c) {
        return function() {
            b.apply(a, c)
        }
    }
    ;
    _.ov = function(a, b, c) {
        if (a.EV)
            b.apply(a, c);
        else {
            if (a.Ck)
                throw a.lj;
            a.Ht.push(nv(a, b, c))
        }
    }
    ;
    _.mv.prototype.UP = _.kb(11);
    _.mv.prototype.qt = _.kb(9);
    _.qv = function(a, b) {
        _.mv.call(this, a, b);
        this.gY = new Hu;
        this.Lk = this.Uo = null;
        pv(this)
    }
    ;
    nu(_.qv, _.mv);
    _.qv.prototype.setOptions = function() {}
    ;
    var rv = function(a, b) {
        a.Me = {
            crossSubDomains: !!b.crossSubDomains,
            id: b.sessionSelectorId,
            domain: a.Zd
        };
        b.crossSubDomains && (a.Me.policy = b.policy)
    }
      , sv = function(a, b) {
        if (!b.authParameters)
            throw Error("ha");
        if (!b.authParameters.scope)
            throw Error("ia");
        if (!b.authParameters.response_type)
            throw Error("ja");
        a.qn = b.authParameters;
        a.qn.redirect_uri || (a.qn.redirect_uri = [location.protocol, "//", location.host, location.pathname].join(""));
        a.Ej = _.pu(b.rpcAuthParameters || a.qn);
        if (!a.Ej.scope)
            throw Error("ka");
        if (!a.Ej.response_type)
            throw Error("la");
        a: {
            var c = a.Ej.response_type.split(" ");
            for (var d = 0, e = c.length; d < e; d++)
                if (c[d] && !su[c[d]]) {
                    c = !0;
                    break a
                }
            c = !1
        }
        if (c)
            throw Error("ma");
        if (b.enableSerialConsent || b.enableGranularConsent)
            a.qn.enable_granular_consent = !0,
            a.Ej.enable_serial_consent = !0;
        b.authResultIdentifier && (a.E6 = b.authResultIdentifier);
        b.spec_compliant && (a.Ej.spec_compliant = b.spec_compliant)
    };
    _.qv.prototype.NY = function() {
        var a = this;
        gv.addEventListener(_.ev.k5, function(b) {
            a.Pe && a.Me && b.originIdp == a.Cb && !b.crossSubDomains == !a.Me.crossSubDomains && b.domain == a.Me.domain && b.id == a.Me.id && a.yX(b)
        });
        gv.addEventListener(_.ev.mE, function(b) {
            a.Pe && b.originIdp == a.Cb && b.clientId == a.Pb && a.zX(b)
        });
        gv.addEventListener(_.ev.Ps, function(b) {
            _.Eu = void 0;
            a.Pe && b.originIdp == a.Cb && b.clientId == a.Pb && b.id == a.Ik && (a.Uo && (window.clearTimeout(a.Uo),
            a.Uo = null),
            a.Ik = void 0,
            a.Po(b))
        });
        gv.addEventListener(_.ev.t2, function(b) {
            a.Pe && b.originIdp == a.Cb && (b.hide ? a.Qd.hide() : a.Qd.show())
        })
    }
    ;
    _.qv.prototype.yX = function() {}
    ;
    _.qv.prototype.zX = function() {}
    ;
    _.qv.prototype.Po = function() {}
    ;
    var uv = function(a, b) {
        tv(a);
        a.O7 || (a.Lk = yu.C7(function() {
            a.vj(!0)
        }, b - 3E5),
        navigator.onLine && a.Lk.start())
    }
      , tv = function(a) {
        a.Lk && (a.Lk.clear(),
        a.Lk = null)
    }
      , pv = function(a) {
        var b = window;
        tu() && (b = document.body);
        ru(b, "online", function() {
            a.Lk && a.Lk.start()
        });
        ru(b, "offline", function() {
            a.Lk && a.Lk.clear()
        })
    };
    _.qv.prototype.vj = function() {}
    ;
    _.qv.prototype.bX = _.kb(12);
    _.qv.prototype.Qba = function(a, b) {
        if (!this.Pb)
            throw Error("qa");
        this.Qd.aB(this.Pb, this.Ej, this.Me, a, b)
    }
    ;
    _.qv.prototype.aB = function(a, b) {
        _.ov(this, this.Qba, [a, b])
    }
    ;
    _.wv = function(a) {
        this.Ge = void 0;
        this.Ph = !1;
        this.Ur = void 0;
        _.qv.call(this, vv, a)
    }
    ;
    nu(_.wv, _.qv);
    var vv = {
        lO: "noSessionBound",
        Zs: "userLoggedOut",
        J1: "activeSessionChanged",
        mE: "sessionStateChanged",
        L5: "tokenReady",
        K5: "tokenFailed",
        Ps: "authResult",
        ERROR: "error"
    };
    _.wv.prototype.setOptions = function(a) {
        if (!a.clientId)
            throw Error("ra");
        this.Pb = a.clientId;
        this.Da = a.id;
        rv(this, a);
        sv(this, a)
    }
    ;
    _.wv.prototype.Cr = function(a) {
        this.dispatchEvent({
            type: vv.ERROR,
            error: "idpiframe_initialization_failed",
            details: a.error,
            idpId: this.Cb
        })
    }
    ;
    var xv = function(a) {
        tv(a);
        a.Ur = void 0;
        a.uI = void 0
    };
    _.g = _.wv.prototype;
    _.g.yX = function(a) {
        var b = a.newValue || {};
        if (this.Ge != b.hint || this.Ph != !!b.disabled) {
            a = this.Ge;
            var c = !this.Ge || this.Ph;
            xv(this);
            this.Ge = b.hint;
            this.Ph = !!b.disabled;
            (b = !this.Ge || this.Ph) && !c ? this.dispatchEvent({
                type: vv.Zs,
                idpId: this.Cb
            }) : b || (a != this.Ge && this.dispatchEvent({
                type: vv.J1,
                idpId: this.Cb
            }),
            this.Ge && this.vj())
        }
    }
    ;
    _.g.zX = function(a) {
        this.Ph || (this.Ge ? a.user || this.Ur ? a.user == this.Ge && (this.Ur ? a.sessionState ? this.Ur = a.sessionState : (xv(this),
        this.dispatchEvent({
            type: vv.Zs,
            idpId: this.Cb
        })) : a.sessionState && (this.Ur = a.sessionState,
        this.vj())) : this.vj() : this.dispatchEvent({
            type: vv.mE,
            idpId: this.Cb
        }))
    }
    ;
    _.g.Po = function(a) {
        this.dispatchEvent({
            type: vv.Ps,
            authResult: a.authResult
        })
    }
    ;
    _.g.wu = _.kb(14);
    _.g.ou = function(a) {
        _.ov(this, this.sG, [a])
    }
    ;
    _.g.sG = function(a) {
        bv(this.Qd, this.Me, a)
    }
    ;
    _.g.lD = function(a, b, c, d) {
        d = d === void 0 ? !1 : d;
        if (!a)
            throw Error("sa");
        xv(this);
        this.Ge = a;
        this.Ph = !1;
        b && _.cv(this.Qd, this.Me, !1, this.Ge);
        this.Pe = !0;
        this.vj(c, !0, d)
    }
    ;
    _.g.start = function() {
        _.ov(this, this.Jw, [])
    }
    ;
    _.g.Jw = function() {
        var a = this.Pb == qu("client_id") ? qu("login_hint") : void 0;
        var b = this.Pb == qu("client_id") ? qu("state") : void 0;
        this.fJ = b;
        if (a)
            window.history.replaceState ? window.history.replaceState(null, document.title, window.location.href.split("#")[0]) : window.location.href.hash = "",
            this.lD(a, !0, !0, !0);
        else {
            var c = this;
            this.ou(function(d) {
                c.Pe = !0;
                d && d.hint ? (xv(c),
                c.Ge = d.hint,
                c.Ph = !!d.disabled,
                c.Ph ? c.dispatchEvent({
                    type: vv.Zs,
                    idpId: c.Cb
                }) : c.lD(d.hint)) : (xv(c),
                c.Ge = void 0,
                c.Ph = !(!d || !d.disabled),
                c.dispatchEvent({
                    type: vv.lO,
                    autoOpenAuthUrl: !c.Ph,
                    idpId: c.Cb
                }))
            })
        }
    }
    ;
    _.g.E8 = function() {
        var a = this;
        this.ou(function(b) {
            b && b.hint ? b.disabled ? a.dispatchEvent({
                type: vv.Zs,
                idpId: a.Cb
            }) : a.vj(!0) : a.dispatchEvent({
                type: vv.lO,
                idpId: a.Cb
            })
        })
    }
    ;
    _.g.GS = function() {
        _.ov(this, this.E8, [])
    }
    ;
    _.g.vj = function(a, b, c) {
        var d = this;
        this.Qd.vj(this.Pb, this.Ej, this.Ge, this.Me, function(e, f) {
            (f = f || e.error) ? f == "user_logged_out" ? (xv(d),
            d.dispatchEvent({
                type: vv.Zs,
                idpId: d.Cb
            })) : (d.uI = null,
            d.dispatchEvent({
                type: vv.K5,
                idpId: d.Cb,
                error: f
            })) : (d.uI = e,
            d.Ur = e.session_state,
            uv(d, e.expires_at),
            e.idpId = d.Cb,
            b && d.fJ && (e.state = d.fJ,
            d.fJ = void 0),
            d.dispatchEvent({
                type: vv.L5,
                idpId: d.Cb,
                response: e
            }))
        }, this.Da, a, !1, c === void 0 ? !1 : c)
    }
    ;
    _.g.revoke = _.kb(7);
    _.g.hZ = _.kb(15);
    _.yv = function(a) {
        this.rn = null;
        _.qv.call(this, {}, a);
        this.Pe = !0
    }
    ;
    nu(_.yv, _.qv);
    _.g = _.yv.prototype;
    _.g.setOptions = function(a) {
        if (!a.clientId)
            throw Error("ra");
        this.Pb = a.clientId;
        this.Da = a.id;
        rv(this, a);
        sv(this, a)
    }
    ;
    _.g.Cr = function(a) {
        this.rn && (this.rn({
            authResult: {
                error: "idpiframe_initialization_failed",
                details: a.error
            }
        }),
        this.rn = null)
    }
    ;
    _.g.Po = function(a) {
        if (this.rn) {
            var b = this.rn;
            this.rn = null;
            b(a)
        }
    }
    ;
    _.g.wu = _.kb(13);
    _.g.ou = function(a) {
        this.Ck ? a(this.Xn()) : _.ov(this, this.sG, [a])
    }
    ;
    _.g.sG = function(a) {
        bv(this.Qd, this.Me, a)
    }
    ;
    _.zv = function(a, b, c) {
        a.Ck ? c(a.Xn()) : _.ov(a, a.hda, [b, c])
    }
    ;
    _.yv.prototype.hda = function(a, b) {
        this.Qd.vj(this.Pb, this.Ej, a, this.Me, function(c, d) {
            d ? b({
                error: d
            }) : b(c)
        }, this.Da, this.J8, this.gga)
    }
    ;
    _.yv.prototype.pW = _.kb(16);
    var Av = function(a) {
        var b = window.location;
        a = _.nc(a);
        a !== void 0 && b.assign(a)
    }, Bv = function(a) {
        return Array.prototype.concat.apply([], arguments)
    }, Cv = function() {
        try {
            var a = Array.from((window.crypto || window.msCrypto).getRandomValues(new Uint8Array(64)))
        } catch (c) {
            a = [];
            for (var b = 0; b < 64; b++)
                a[b] = Math.floor(Math.random() * 256)
        }
        return _.Bh(a, 3).substring(0, 64)
    }, Dv = function(a) {
        var b = [], c;
        for (c in a)
            if (a.hasOwnProperty(c)) {
                var d = a[c];
                if (d === null || d === void 0)
                    d = "";
                b.push(encodeURIComponent(c) + "=" + encodeURIComponent(d))
            }
        return b.join("&")
    }, Ev = function(a) {
        window.addEventListener("hashchange", function() {
            location.hash.includes("client_id") && window.location.reload()
        });
        Av(a)
    }, Fv = function(a, b, c) {
        if (!a.Pe)
            throw Error("na");
        b ? _.cv(a.Qd, a.Me, !0, void 0, c) : _.cv(a.Qd, a.Me, !0, a.Ge, c)
    }, Gv = function(a) {
        if (!a.Pe)
            throw Error("na");
        return a.uI
    }, Hv, Iv, Jv, Kv, Lv, Mv, Nv, Ov, Pv, Qv, Rv, Sv, Tv, Uv, Xv, $v, aw;
    _.yv.prototype.pW = _.nb(16, function(a, b) {
        var c = this.Qd
          , d = this.Pb
          , e = this.Me
          , f = _.pu(this.Ej);
        delete f.response_type;
        _.$u(c, "getOnlineCode", {
            clientId: d,
            loginHint: a,
            request: f,
            sessionSelector: e
        }, b)
    });
    _.wv.prototype.hZ = _.nb(15, function(a) {
        Gv(this) && Gv(this).access_token && (this.Qd.revoke(this.Pb, Gv(this).access_token, a),
        Fv(this, !0))
    });
    _.wv.prototype.wu = _.nb(14, function() {
        var a = this;
        return function(b) {
            b && b.authResult && b.authResult.login_hint && (a.TB ? (b.authResult.client_id = a.Pb,
            Ev(a.TB + "#" + Dv(b.authResult))) : a.lD(b.authResult.login_hint, a.Ph || b.authResult.login_hint != a.Ge, !0, !0))
        }
    });
    _.yv.prototype.wu = _.nb(13, function(a) {
        var b = this;
        return function(c) {
            c && c.authResult && c.authResult.login_hint ? b.ou(function(d) {
                _.cv(b.Qd, b.Me, d && d.disabled, c.authResult.login_hint, function() {
                    _.zv(b, c.authResult.login_hint, a)
                })
            }) : a(c && c.authResult && c.authResult.error ? c.authResult : c && c.authResult && !c.authResult.login_hint ? {
                error: "wrong_response_type"
            } : {
                error: "unknown_error"
            })
        }
    });
    _.qv.prototype.bX = _.nb(12, function() {
        this.Pb && _.$u(this.Qd, "startPolling", {
            clientId: this.Pb,
            origin: this.Dd,
            id: this.Ik
        })
    });
    _.Xu.prototype.revoke = _.nb(8, function(a, b, c) {
        _.$u(this, "revoke", {
            clientId: a,
            token: b
        }, c)
    });
    _.wv.prototype.revoke = _.nb(7, function(a) {
        _.ov(this, this.hZ, [a])
    });
    Hv = "openid email profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/plus.login".split(" ");
    Iv = function() {
        var a = navigator.userAgent, b;
        if (b = !!a && a.indexOf("CriOS") != -1)
            b = -1,
            (a = a.match(/CriOS\/(\d+)/)) && a[1] && (b = parseInt(a[1], 10) || -1),
            b = b < 48;
        return b
    }
    ;
    Jv = function() {
        var a = navigator.userAgent.toLowerCase();
        if (!(a.indexOf("safari/") > -1 && a.indexOf("chrome/") < 0 && a.indexOf("crios/") < 0 && a.indexOf("android") < 0))
            return !1;
        var b = RegExp("version/(\\d+)\\.(\\d+)[\\.0-9]*").exec(navigator.userAgent.toLowerCase());
        if (!b || b.length < 3)
            return !1;
        a = parseInt(b[1], 10);
        b = parseInt(b[2], 10);
        return a > 12 || a == 12 && b >= 1
    }
    ;
    Kv = function(a) {
        return a.length > 0 && a.every(function(b) {
            return Hv.includes(b)
        })
    }
    ;
    Lv = function(a, b, c, d, e, f, h) {
        var k = _.Cu(a, "authServerUrl");
        if (!k)
            throw Error("Y`" + a);
        a = _.pu(d);
        a.response_type = h || "permission";
        a.client_id = c;
        a.ss_domain = b;
        if (f && f.extraQueryParams)
            for (var l in f.extraQueryParams)
                a[l] = f.extraQueryParams[l];
        (b = e) && !(b = Jv()) && (b = navigator.userAgent.toLowerCase(),
        b.indexOf("ipad;") > -1 || b.indexOf("iphone;") > -1 ? (b = RegExp("os (\\d+)_\\d+(_\\d+)? like mac os x").exec(navigator.userAgent.toLowerCase()),
        b = !b || b.length < 2 ? !1 : parseInt(b[1], 10) >= 14) : b = !1);
        b && !a.prompt && (a.prompt = "select_account");
        return k + (k.indexOf("?") < 0 ? "?" : "&") + Dv(a)
    }
    ;
    Mv = function(a, b, c, d) {
        if (!a.Pb)
            throw Error("oa");
        a.Ik = c || a.E6 || "auth" + Math.floor(Math.random() * 1E6 + 1);
        b = b || {};
        b.extraQueryParams = b.extraQueryParams || {};
        if (!b.extraQueryParams.redirect_uri) {
            var e = a.Dd.split("//");
            c = b.extraQueryParams;
            var f = e[0]
              , h = e[1];
            e = a.Ik;
            var k = f.indexOf(":");
            k > 0 && (f = f.substring(0, k));
            f = ["storagerelay://", f, "/", h, "?"];
            f.push("id=" + e);
            c.redirect_uri = f.join("")
        }
        return Lv(a.Cb, a.Zd, a.Pb, a.qn, !0, b, d)
    }
    ;
    Nv = function(a, b, c) {
        if (!a.Pb)
            throw Error("oa");
        return Lv(a.Cb, a.Zd, a.Pb, a.qn, !1, b, c)
    }
    ;
    Ov = function(a, b) {
        a.Uo && window.clearTimeout(a.Uo);
        a.Uo = window.setTimeout(function() {
            a.Ik == b && (_.Eu = void 0,
            a.Uo = null,
            a.Ik = void 0,
            a.Po({
                authResult: {
                    error: "popup_closed_by_user"
                }
            }))
        }, 1E3)
    }
    ;
    Pv = function(a, b, c) {
        if (!a.Pb)
            throw Error("pa");
        c = c || {};
        c = Mv(a, c.sessionMeta, c.oneTimeId, c.responseType);
        (Object.hasOwnProperty.call(window, "ActiveXObject") && !window.ActiveXObject || Iv()) && _.ov(a, a.bX, []);
        var d = a.Ik;
        a.gY.open(c, b, function() {
            a.Ik == d && Ov(a, d)
        }, function() {
            a.Ik = void 0;
            a.Po({
                authResult: {
                    error: "popup_blocked_by_browser"
                }
            })
        })
    }
    ;
    Qv = function(a, b) {
        var c = b || {};
        b = _.pu(a.qn);
        if (c.sessionMeta && c.sessionMeta.extraQueryParams)
            for (var d in c.sessionMeta.extraQueryParams)
                b[d] = c.sessionMeta.extraQueryParams[d];
        var e;
        c.sessionMeta.extraQueryParams.scope && (e = c.sessionMeta.extraQueryParams.scope.split(" "));
        !e && b.scope && (e = b.scope.split(" "));
        delete b.redirect_uri;
        delete b.origin;
        delete b.client_id;
        delete b.scope;
        b.prompt == "select_account" && delete b.prompt;
        b.gsiwebsdk = "fedcm";
        b.ss_domain = a.Zd;
        b.nonce || (b.nonce = "notprovided");
        d = _.Cu(a.Cb, "fedcmConfigUrl");
        b.response_type = c.responseType;
        b.scope = e.join(" ");
        c = navigator.userActivation.isActive ? "button" : "widget";
        _.fr("131") && (c = navigator.userActivation.isActive ? "active" : "passive");
        e = Kv(e) ? ["name", "email", "picture"] : [];
        return {
            identity: {
                providers: [{
                    configURL: d,
                    clientId: a.Pb,
                    fields: e,
                    params: b
                }],
                mode: c
            },
            mediation: "required"
        }
    }
    ;
    Rv = function(a, b, c) {
        if (!a.Pb)
            throw Error("pa");
        b = Qv(a, b);
        navigator.credentials.get(b).then(function(d) {
            d = JSON.parse(d.token);
            var e = {
                client_id: d.client_id,
                login_hint: d.login_hint,
                expires_in: 3600,
                scope: d.scope
            };
            d.code && (e.code = d.code);
            d.id_token && (e.id_token = d.id_token);
            a.Po({
                type: _.ev.Ps,
                idpId: a.Cb,
                authResult: e
            })
        }, function(d) {
            d.message.indexOf("identity-credentials-get") >= 0 || d.message.indexOf("Content Security Policy") >= 0 ? c() : a.Po({
                type: _.ev.Ps,
                idpId: a.Cb,
                authResult: {
                    error: d
                }
            })
        })
    }
    ;
    Sv = function(a, b, c) {
        a.Kp && _.zu() ? Rv(a, c, function() {
            return Pv(a, b, c)
        }) : Pv(a, b, c)
    }
    ;
    Tv = function(a, b) {
        b = b || {};
        var c = Nv(a, b.sessionMeta, b.responseType);
        a.Kp && _.zu() ? (a.TB = b.sessionMeta.extraQueryParams.redirect_uri,
        Rv(a, b, function() {
            return window.location.assign(c)
        })) : window.location.assign(c)
    }
    ;
    Uv = function(a, b, c) {
        a.Ck ? c(a.Xn()) : _.ov(a, a.pW, [b, c])
    }
    ;
    _.Vv = function(a) {
        _.ve(_.Ge, "le", []).push(a)
    }
    ;
    _.Wv = function(a) {
        for (var b = [], c = 0, d = 0; c < a.length; ) {
            var e = a[c++];
            if (e < 128)
                b[d++] = String.fromCharCode(e);
            else if (e > 191 && e < 224) {
                var f = a[c++];
                b[d++] = String.fromCharCode((e & 31) << 6 | f & 63)
            } else if (e > 239 && e < 365) {
                f = a[c++];
                var h = a[c++]
                  , k = a[c++];
                e = ((e & 7) << 18 | (f & 63) << 12 | (h & 63) << 6 | k & 63) - 65536;
                b[d++] = String.fromCharCode(55296 + (e >> 10));
                b[d++] = String.fromCharCode(56320 + (e & 1023))
            } else
                f = a[c++],
                h = a[c++],
                b[d++] = String.fromCharCode((e & 15) << 12 | (f & 63) << 6 | h & 63)
        }
        return b.join("")
    }
    ;
    Xv = function(a) {
        var b = [];
        _.Ch(a, function(c) {
            b.push(c)
        });
        return b
    }
    ;
    _.Yv = function(a, b) {
        _.ii[b || "token"] = a
    }
    ;
    _.Zv = function(a) {
        delete _.ii[a || "token"]
    }
    ;
    aw = function() {
        if (typeof MessageChannel !== "undefined") {
            var a = new MessageChannel
              , b = {}
              , c = b;
            a.port1.onmessage = function() {
                if (b.next !== void 0) {
                    b = b.next;
                    var d = b.cb;
                    b.cb = null;
                    d()
                }
            }
            ;
            return function(d) {
                c.next = {
                    cb: d
                };
                c = c.next;
                a.port2.postMessage(0)
            }
        }
        return function(d) {
            _.ab.setTimeout(d, 0)
        }
    }
    ;
    _.uu = {
        parse: function(a) {
            a = _.Gf("[" + String(a) + "]");
            if (a === !1 || a.length !== 1)
                throw new SyntaxError("JSON parsing failed.");
            return a[0]
        },
        stringify: function(a) {
            return _.Hf(a)
        }
    };
    _.yv.prototype.dG = function(a, b) {
        _.ov(this, this.u8, [a, b])
    }
    ;
    _.yv.prototype.u8 = function(a, b) {
        this.Qd.dG(this.Pb, a, this.Ej, this.Me, b)
    }
    ;
    _.Xu.prototype.dG = function(a, b, c, d, e) {
        c = _.pu(c);
        _.$u(this, "gsi:fetchLoginHint", {
            clientId: a,
            loginHint: b,
            request: c,
            sessionSelector: d
        }, e)
    }
    ;
    var bw, cw = ["client_id", "cookie_policy", "scope"], dw = "client_id cookie_policy fetch_basic_profile hosted_domain scope openid_realm disable_token_refresh login_hint ux_mode redirect_uri state prompt oidc_spec_compliant nonce enable_serial_consent enable_granular_consent include_granted_scopes response_type session_selection plugin_name ack_extension_date use_fedcm gsiwebsdk".split(" "), ew = ["authuser", "after_redirect", "access_type", "hl"], fw = ["login_hint", "prompt"], gw = {
        clientid: "client_id",
        cookiepolicy: "cookie_policy"
    }, hw = ["approval_prompt", "authuser", "login_hint", "prompt", "hd"], iw = ["login_hint", "g-oauth-window", "status"], jw = Math.min(_.Qe("oauth-flow/authWindowWidth", 599), screen.width - 20), kw = Math.min(_.Qe("oauth-flow/authWindowHeight", 600), screen.height - 30);
    var lw = function(a) {
        _.lb.call(this, a)
    };
    _.r(lw, _.lb);
    lw.prototype.name = "gapi.auth2.ExternallyVisibleError";
    var mw = function() {};
    mw.prototype.select = function(a, b) {
        if (a.sessions && a.sessions.length == 1 && (a = a.sessions[0],
        a.login_hint)) {
            b(a);
            return
        }
        b()
    }
    ;
    var nw = function() {};
    nw.prototype.select = function(a, b) {
        if (a.sessions && a.sessions.length)
            for (var c = 0; c < a.sessions.length; c++) {
                var d = a.sessions[c];
                if (d.login_hint) {
                    b(d);
                    return
                }
            }
        b()
    }
    ;
    var ow = function(a) {
        this.G6 = a
    };
    ow.prototype.select = function(a, b) {
        if (a.sessions)
            for (var c = 0; c < a.sessions.length; c++) {
                var d = a.sessions[c];
                if (d.session_state && d.session_state.extraQueryParams && d.session_state.extraQueryParams.authuser == this.G6) {
                    d.login_hint ? b(d) : b();
                    return
                }
            }
        b()
    }
    ;
    var pw = function(a) {
        this.we = a;
        this.EC = []
    };
    pw.prototype.select = function(a) {
        var b = 0
          , c = this
          , d = function(e) {
            if (e)
                a(e);
            else {
                var f = c.EC[b];
                f ? (b++,
                c.we.aB(function(h) {
                    h ? f.select(h, d) : d()
                })) : a()
            }
        };
        d()
    }
    ;
    var qw = function(a) {
        a = new pw(a);
        a.EC.push(new mw);
        return a
    }
      , rw = function(a) {
        a = new pw(a);
        a.EC.push(new nw);
        return a
    }
      , sw = function(a, b) {
        b === void 0 || b === null ? b = qw(a) : (a = new pw(a),
        a.EC.push(new ow(b)),
        b = a);
        return b
    };
    var tw = function(a) {
        this.Lf = a;
        this.isActive = !0
    };
    tw.prototype.remove = function() {
        this.isActive = !1
    }
    ;
    tw.prototype.trigger = function() {}
    ;
    var uw = function(a) {
        this.remove = function() {
            a.remove()
        }
        ;
        this.trigger = function() {
            a.trigger()
        }
    }
      , vw = function() {
        this.mc = []
    };
    vw.prototype.add = function(a) {
        this.mc.push(a)
    }
    ;
    vw.prototype.notify = function(a) {
        for (var b = this.mc, c = [], d = 0; d < b.length; d++) {
            var e = b[d];
            e.isActive && (c.push(e),
            e = ww(e.Lf, a),
            e = (0,
            _.ak)(e),
            e = (0,
            _.Yj)(e),
            $v || ($v = aw()),
            $v(e))
        }
        this.mc = c
    }
    ;
    var ww = function(a, b) {
        return function() {
            a(b)
        }
    };
    var yw = function(a) {
        this.Ka = null;
        this.Zga = new xw(this);
        this.mc = new vw;
        a != void 0 && this.set(a)
    };
    yw.prototype.set = function(a) {
        a != this.Ka && (this.Ka = a,
        this.Zga.value = a,
        this.mc.notify(this.Ka))
    }
    ;
    yw.prototype.get = function() {
        return this.Ka
    }
    ;
    yw.prototype.na = function(a) {
        a = new zw(this,a);
        this.mc.add(a);
        return a
    }
    ;
    yw.prototype.get = yw.prototype.get;
    var zw = function(a, b) {
        tw.call(this, b);
        this.Uba = a
    };
    _.r(zw, tw);
    zw.prototype.trigger = function() {
        var a = this.Lf;
        a(this.Uba.get())
    }
    ;
    var xw = function(a) {
        this.value = null;
        this.na = function(b) {
            return new uw(a.na(b))
        }
    };
    var Aw = {
        tja: "fetch_basic_profile",
        uka: "login_hint",
        Tla: "prompt",
        Zla: "redirect_uri",
        rma: "scope",
        Nna: "ux_mode",
        dna: "state"
    }
      , Bw = function(a) {
        this.Ja = {};
        if (a && !_.uh(a))
            if (typeof a.get == "function")
                this.Ja = a.get();
            else
                for (var b in Aw) {
                    var c = Aw[b];
                    c in a && (this.Ja[c] = a[c])
                }
    };
    Bw.prototype.get = function() {
        return this.Ja
    }
    ;
    Bw.prototype.j_ = function(a) {
        this.Ja.scope = a;
        return this
    }
    ;
    Bw.prototype.Fu = function() {
        return this.Ja.scope
    }
    ;
    var Cw = function(a, b) {
        var c = a.Ja.scope;
        b = Bv(b.split(" "), c ? c.split(" ") : []);
        _.th(b);
        a.Ja.scope = b.join(" ")
    };
    _.g = Bw.prototype;
    _.g.Kfa = function(a) {
        this.Ja.prompt = a;
        return this
    }
    ;
    _.g.Q9 = function() {
        return this.Ja.prompt
    }
    ;
    _.g.nfa = function() {
        _.Lf.warn("Property app_package_name no longer supported and was not set");
        return this
    }
    ;
    _.g.U8 = function() {
        _.Lf.warn("Property app_package_name no longer supported")
    }
    ;
    _.g.xf = function(a) {
        this.Ja.state = a
    }
    ;
    _.g.getState = function() {
        return this.Ja.state
    }
    ;
    var Dw = function() {
        return ["toolbar=no", "location=" + (window.opera ? "no" : "yes"), "directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,copyhistory=no", "width=" + jw, "height=" + kw, "top=" + (screen.height - kw) / 2, "left=" + (screen.width - jw) / 2].join()
    }
      , Ew = function(a) {
        a = a && a.id_token;
        if (!a || !a.split(".")[1])
            return null;
        a = (a.split(".")[1] + "...").replace(/^((....)+).?.?.?$/, "$1");
        return JSON.parse(_.Wv(Xv(a)))
    }
      , Fw = function() {
        bw = _.Qe("auth2/idpValue", "google");
        var a = _.Qe("oauth-flow/authUrl", "https://accounts.google.com/o/oauth2/auth")
          , b = _.Qe("oauth-flow/idpIframeUrl", "https://accounts.google.com/o/oauth2/iframe");
        a = {
            fedcmConfigUrl: _.Qe("oauth-flow/fedcmConfigUrl", "https://accounts.google.com/o/fedcm/config.json"),
            authServerUrl: a,
            idpIFrameUrl: b
        };
        _.Du(bw, a)
    }
      , Gw = function(a, b, c) {
        for (var d = 0; d < b.length; d++) {
            var e = b[d];
            if (d === b.length - 1) {
                a[e] = c;
                break
            }
            _.wb(a[e]) || (a[e] = {});
            a = a[e]
        }
    }
      , Hw = function() {
        var a = window.location.origin;
        a || (a = window.location.protocol + "//" + window.location.host);
        return a
    }
      , Jw = function() {
        var a = Iw();
        a.storage_path && window.sessionStorage.setItem(a.storage_path, Hw() + window.location.pathname);
        if (a.status.toLowerCase() == "enforced")
            throw new lw("gapi.auth2 is disabled on this website, but it is still used on page " + window.location.href);
        a.status.toLowerCase() == "informational" && _.Lf.warn("gapi.auth2 is disabled on this website, but it is still used on page " + window.location.href)
    }
      , Kw = function(a) {
        return _.Zh.get("GSI_ALLOW_3PCD") === "1" ? !0 : a === !1 ? !1 : a === !0 || (_.Ge.le || []).includes("fedcm_migration_mod") ? !0 : !1
    };
    var Lw = function(a) {
        var b = a ? (b = Ew(a)) ? b.sub : null : null;
        this.Da = b;
        this.Ic = a ? _.Pj(a) : null
    };
    _.g = Lw.prototype;
    _.g.getId = function() {
        return this.Da
    }
    ;
    _.g.CG = function() {
        var a = Ew(this.Ic);
        return a ? a.hd : null
    }
    ;
    _.g.zg = function() {
        return !!this.Ic
    }
    ;
    _.g.Rl = function(a) {
        if (a)
            return this.Ic;
        a = Mw;
        var b = _.Pj(this.Ic);
        !a.IA || a.zH || a.uaa || (delete b.access_token,
        delete b.scope);
        return b
    }
    ;
    _.g.gK = function() {
        return Mw.gK()
    }
    ;
    _.g.Yk = function() {
        this.Ic = null
    }
    ;
    _.g.t9 = function() {
        return this.Ic ? this.Ic.scope : null
    }
    ;
    _.g.update = function(a) {
        this.Da = a.Da;
        this.Ic = a.Ic;
        this.Ic.id_token ? this.by = new Nw(this.Ic) : this.by && (this.by = null)
    }
    ;
    var Ow = function(a) {
        return a.Ic && typeof a.Ic.session_state == "object" ? _.Pj(a.Ic.session_state.extraQueryParams || {}) : {}
    };
    _.g = Lw.prototype;
    _.g.qG = function() {
        var a = Ow(this);
        return a && a.authuser !== void 0 && a.authuser !== null ? a.authuser : null
    }
    ;
    _.g.Xk = function(a) {
        var b = Mw
          , c = new Bw(a);
        b.zH = c.Fu() ? !0 : !1;
        Mw.IA && Cw(c, "openid profile email");
        return new _.hk(function(d, e) {
            var f = Ow(this);
            f.login_hint = this.getId();
            f.scope = c.Fu();
            Pw(b, d, e, f)
        }
        ,this)
    }
    ;
    _.g.Ku = function(a) {
        return new _.hk(function(b, c) {
            var d = a || {}
              , e = Mw;
            d.login_hint = this.getId();
            e.Ku(d).then(b, c)
        }
        ,this)
    }
    ;
    _.g.h$ = function(a) {
        return this.Xk(a)
    }
    ;
    _.g.disconnect = function() {
        return Mw.disconnect()
    }
    ;
    _.g.V8 = function() {
        return this.by
    }
    ;
    _.g.pA = function(a) {
        if (!this.zg())
            return !1;
        var b = this.Ic && this.Ic.scope ? this.Ic.scope.split(" ") : "";
        return _.Kb(a ? a.split(" ") : [], function(c) {
            return _.ub(b, c)
        })
    }
    ;
    var Nw = function(a) {
        a = Ew(a);
        this.O8 = a.sub;
        this.jh = a.name;
        this.d$ = a.given_name;
        this.r8 = a.family_name;
        this.VU = a.picture;
        this.Xy = a.email
    };
    _.g = Nw.prototype;
    _.g.getId = function() {
        return this.O8
    }
    ;
    _.g.og = function() {
        return this.jh
    }
    ;
    _.g.r9 = function() {
        return this.d$
    }
    ;
    _.g.n9 = function() {
        return this.r8
    }
    ;
    _.g.z9 = function() {
        return this.VU
    }
    ;
    _.g.Rn = function() {
        return this.Xy
    }
    ;
    var Iw, Qw;
    Iw = function() {
        var a = _.Zh.get("G_AUTH2_MIGRATION");
        if (!a)
            return {
                status: "none"
            };
        a = /(enforced|informational)(?::(.*))?/i.exec(a);
        return a ? {
            status: a[1].toLowerCase(),
            storage_path: a[2]
        } : (_.Lf.warn("The G_AUTH2_MIGRATION cookie value is not valid."),
        {
            status: "none"
        })
    }
    ;
    Qw = function(a) {
        var b = location;
        if (a && a != "none")
            return a == "single_host_origin" ? b.protocol + "//" + b.host : a
    }
    ;
    _.Rw = function(a) {
        if (!a)
            throw new lw("No cookiePolicy");
        var b = window.location.hostname;
        a == "single_host_origin" && (a = window.location.protocol + "//" + b);
        if (a == "none")
            return null;
        var c = /^(https?:\/\/)([0-9.\-_A-Za-z]+)(?::(\d+))?$/.exec(a);
        if (!c)
            throw new lw("Invalid cookiePolicy");
        a = c[2];
        c = c[1];
        var d = {};
        d.dotValue = a.split(".").length;
        d.isSecure = c.indexOf("https") != -1;
        d.domain = a;
        if (!_.vj(b, "." + a) && !_.vj(b, a))
            throw new lw("Invalid cookiePolicy domain");
        return d
    }
    ;
    var Tw = function(a) {
        var b = a || {}
          , c = Sw();
        _.Db(dw, function(d) {
            typeof b[d] === "undefined" && typeof c[d] !== "undefined" && (b[d] = c[d])
        });
        return b
    }
      , Sw = function() {
        for (var a = {}, b = document.getElementsByTagName("meta"), c = 0; c < b.length; ++c)
            if (b[c].name) {
                var d = b[c].name;
                if (d.indexOf("google-signin-") == 0) {
                    d = d.substring(14);
                    var e = b[c].content;
                    gw[d] && (d = gw[d]);
                    _.ub(dw, d) && e && (a[d] = e == "true" ? !0 : e == "false" ? !1 : e)
                }
            }
        return a
    }
      , Uw = function(a) {
        return String(a).replace(/_([a-z])/g, function(b, c) {
            return c.toUpperCase()
        })
    }
      , Vw = function(a) {
        _.Db(dw, function(b) {
            var c = Uw(b);
            typeof a[c] !== "undefined" && typeof a[b] === "undefined" && (a[b] = a[c],
            delete a[c])
        })
    }
      , Ww = function(a) {
        a = Tw(a);
        Vw(a);
        a.cookie_policy || (a.cookie_policy = "single_host_origin");
        var b = dw + ew, c;
        for (c in a)
            b.indexOf(c) < 0 && delete a[c];
        return a
    }
      , Xw = function(a, b) {
        if (!a)
            throw new lw("Empty initial options.");
        for (var c = 0; c < cw.length; ++c)
            if (!(b && cw[c] == "scope" || a[cw[c]]))
                throw new lw("Missing required parameter '" + cw[c] + "'");
        _.Rw(a.cookie_policy)
    }
      , Zw = function(a) {
        var b = {
            authParameters: {
                redirect_uri: void 0,
                response_type: "token id_token",
                scope: a.scope,
                "openid.realm": a.openid_realm,
                include_granted_scopes: !0
            },
            clientId: a.client_id,
            crossSubDomains: !0,
            domain: Qw(a.cookie_policy),
            disableTokenRefresh: !!a.disable_token_refresh,
            idpId: bw
        };
        Yw(b, a);
        _.Db(fw, function(d) {
            a[d] && (b.authParameters[d] = a[d])
        });
        typeof a.enable_serial_consent == "boolean" && (b.enableSerialConsent = a.enable_serial_consent);
        typeof a.enable_granular_consent == "boolean" && (b.enableGranularConsent = a.enable_granular_consent);
        if (a.plugin_name)
            b.pluginName = a.plugin_name;
        else {
            var c = _.Qe("auth2/pluginName");
            c && (b.pluginName = c)
        }
        a.ack_extension_date && (b.authParameters.ack_extension_date = a.ack_extension_date,
        b.ackExtensionDate = a.ack_extension_date);
        typeof a.use_fedcm === "boolean" && (b.useFedCm = a.use_fedcm);
        return b
    }
      , Yw = function(a, b) {
        var c = b.oidc_spec_compliant;
        b = b.nonce;
        c && (a.spec_compliant = c,
        b = b || Cv());
        b && (a.authParameters.nonce = b,
        a.forceTokenRefresh = !0,
        a.skipTokenCache = !0)
    }
      , dx = function(a) {
        var b = a.client_id
          , c = a.cookie_policy
          , d = a.scope
          , e = a.openid_realm
          , f = a.hosted_domain
          , h = a.oidc_spec_compliant
          , k = a.nonce
          , l = $w(a)
          , m = {
            authParameters: {
                response_type: l,
                scope: d,
                "openid.realm": e
            },
            rpcAuthParameters: {
                response_type: l,
                scope: d,
                "openid.realm": e
            },
            clientId: b,
            crossSubDomains: !0,
            domain: Qw(c),
            idpId: bw
        };
        f && (m.authParameters.hd = f,
        m.rpcAuthParameters.hd = f);
        h && (m.rpcAuthParameters.spec_compliant = h,
        k = k || Cv());
        k && (m.authParameters.nonce = k,
        m.rpcAuthParameters.nonce = k,
        m.forceTokenRefresh = !0,
        m.skipTokenCache = !0);
        _.Db(fw.concat(ew), function(n) {
            a[n] && (m.authParameters[n] = a[n])
        });
        a.authuser !== void 0 && a.authuser !== null && (m.authParameters.authuser = a.authuser);
        typeof a.include_granted_scopes == "boolean" && (b = new ax(a.response_type || "token"),
        bx(b) && (m.authParameters.include_granted_scopes = a.include_granted_scopes),
        cx(b) && (m.rpcAuthParameters.include_granted_scopes = a.include_granted_scopes,
        a.include_granted_scopes === !1 && (m.forceTokenRefresh = !0,
        m.skipTokenCache = !0)));
        typeof a.enable_serial_consent == "boolean" && (m.enableSerialConsent = a.enable_serial_consent);
        typeof a.enable_granular_consent == "boolean" && (m.enableGranularConsent = a.enable_granular_consent);
        a.plugin_name ? m.pluginName = a.plugin_name : (b = _.Qe("auth2/pluginName")) && (m.pluginName = b);
        a.ack_extension_date && (m.authParameters.ack_extension_date = a.ack_extension_date,
        m.rpcAuthParameters.ack_extension_date = a.ack_extension_date,
        m.ackExtensionDate = a.ack_extension_date);
        typeof a.use_fedcm === "boolean" && (m.useFedCm = a.use_fedcm);
        return m
    }
      , $w = function(a) {
        a = new ax(a.response_type || "token");
        var b = [];
        cx(a) && b.push("token");
        ex(a, "id_token") && b.push("id_token");
        b.length == 0 && (b = ["token", "id_token"]);
        return b.join(" ")
    }
      , fx = ["permission", "id_token"]
      , gx = /(^|[^_])token/
      , ax = function(a) {
        this.Or = [];
        this.UH(a)
    };
    ax.prototype.UH = function(a) {
        a ? ((a.indexOf("permission") >= 0 || a.match(gx)) && this.Or.push("permission"),
        a.indexOf("id_token") >= 0 && this.Or.push("id_token"),
        a.indexOf("code") >= 0 && this.Or.push("code")) : this.Or = fx
    }
    ;
    var bx = function(a) {
        return ex(a, "code")
    }
      , cx = function(a) {
        return ex(a, "permission")
    };
    ax.prototype.toString = function() {
        return this.Or.join(" ")
    }
    ;
    var ex = function(a, b) {
        var c = !1;
        _.Db(a.Or, function(d) {
            d == b && (c = !0)
        });
        return c
    };
    var ix = function(a, b, c) {
        this.hJ = b;
        this.Jca = a;
        for (var d in a)
            a.hasOwnProperty(d) && hx(this, d);
        if (c && c.length)
            for (a = 0; a < c.length; a++)
                this[c[a]] = this.hJ[c[a]]
    }
      , hx = function(a, b) {
        a[b] = function() {
            return a.Jca[b].apply(a.hJ, arguments)
        }
    };
    ix.prototype.then = function(a, b, c) {
        var d = this;
        return _.lk().then(function() {
            return jx(d.hJ, a, b, c)
        })
    }
    ;
    _.Wj(ix);
    var Mw, kx, mx;
    Mw = null;
    _.lx = function() {
        return Mw ? kx() : null
    }
    ;
    kx = function() {
        return new ix(mx.prototype,Mw,["currentUser", "isSignedIn"])
    }
    ;
    mx = function(a) {
        delete a.include_granted_scopes;
        this.Ja = Zw(a);
        this.z7 = a.cookie_policy;
        this.uaa = !!a.scope;
        (this.IA = a.fetch_basic_profile !== !1) && (this.Ja.authParameters.scope = nx(this, "openid profile email"));
        this.Ja.supportBlocked3PCookies = Kw(a.use_fedcm);
        this.Vu = a.hosted_domain;
        this.Xga = a.ux_mode || "popup";
        this.TB = a.redirect_uri || null;
        this.RH()
    }
    ;
    mx.prototype.RH = function() {
        this.currentUser = new yw(new Lw(null));
        this.isSignedIn = new yw(!1);
        this.we = new _.wv(this.Ja);
        this.NA = this.hr = null;
        this.Fba = new _.hk(function(a, b) {
            this.hr = a;
            this.NA = b
        }
        ,this);
        this.vB = {};
        this.ov = !0;
        ox(this);
        this.we.start()
    }
    ;
    var ox = function(a) {
        a.we.addEventListener("error", function(b) {
            a.ov && a.hr && (a.ov = !1,
            a.NA({
                error: b.error,
                details: b.details
            }),
            a.hr = null,
            a.NA = null)
        });
        a.we.addEventListener("authResult", function(b) {
            b && b.authResult && a.Df(b);
            a.we.wu()(b)
        });
        a.we.addEventListener("tokenReady", function(b) {
            var c = new Lw(b.response);
            if (a.Vu && a.Vu != c.CG())
                a.Df({
                    type: "tokenFailed",
                    reason: "Account domain does not match hosted_domain specified by gapi.auth2.init.",
                    accountDomain: c.CG(),
                    expectedDomain: a.Vu
                });
            else {
                a.currentUser.get().update(c);
                var d = a.currentUser;
                d.mc.notify(d.Ka);
                a.isSignedIn.set(!0);
                c = c.qG();
                (d = _.Rw(a.z7)) && c && _.Zh.set(["G_AUTHUSER_", window.location.protocol === "https:" && d.jf ? "S" : "H", d.Ti].join(""), c, {
                    domain: d.domain,
                    secure: d.isSecure
                });
                _.Yv(b.response);
                a.Df(b)
            }
        });
        a.we.addEventListener("noSessionBound", function(b) {
            a.ov && b.autoOpenAuthUrl ? (a.ov = !1,
            qw(a.we).select(function(c) {
                if (c && c.login_hint) {
                    var d = a.we;
                    _.ov(d, d.lD, [c.login_hint, !0])
                } else
                    a.currentUser.set(new Lw(null)),
                    a.isSignedIn.set(!1),
                    _.Zv(),
                    a.Df(b)
            })) : (a.currentUser.set(new Lw(null)),
            a.isSignedIn.set(!1),
            _.Zv(),
            a.Df(b))
        });
        a.we.addEventListener("tokenFailed", function(b) {
            a.Df(b)
        });
        a.we.addEventListener("userLoggedOut", function(b) {
            a.currentUser.get().Yk();
            var c = a.currentUser;
            c.mc.notify(c.Ka);
            a.isSignedIn.set(!1);
            _.Zv();
            a.Df(b)
        })
    }
      , jx = function(a, b, c, d) {
        return a.Fba.then(function(e) {
            if (b)
                return b(e.f$)
        }, c, d)
    };
    mx.prototype.Df = function(a) {
        if (a) {
            this.ov = !1;
            var b = a.type || "";
            if (this.vB[b])
                this.vB[b](a);
            this.hr && (this.hr({
                f$: this
            }),
            this.NA = this.hr = null)
        }
    }
    ;
    var px = function(a, b) {
        _.Sb(b, function(c, d) {
            a.vB[d] = function(e) {
                a.vB = {};
                c(e)
            }
        })
    }
      , Pw = function(a, b, c, d) {
        d = _.Pj(d);
        a.Vu && (d.hd = a.Vu);
        var e = d.ux_mode || a.Xga;
        delete d.ux_mode;
        delete d.app_package_name;
        var f = {
            sessionMeta: {
                extraQueryParams: d
            },
            responseType: "permission id_token"
        };
        e == "redirect" ? (d.redirect_uri || (d.redirect_uri = a.TB || Hw() + window.location.pathname),
        qx(a, f)) : (delete d.redirect_uri,
        rx(a, f),
        px(a, {
            authResult: function(h) {
                h.authResult && h.authResult.error ? c(h.authResult) : px(a, {
                    tokenReady: function() {
                        b(a.currentUser.get())
                    },
                    tokenFailed: c
                })
            }
        }))
    };
    mx.prototype.Xk = function(a) {
        return new _.hk(function(b, c) {
            var d = new Bw(a);
            this.zH = d.Fu() ? !0 : !1;
            this.IA ? (d.Ja.fetch_basic_profile = !0,
            Cw(d, "email profile openid")) : d.Ja.fetch_basic_profile = !1;
            var e = nx(this, d.Fu());
            d.j_(e);
            Pw(this, b, c, d.get())
        }
        ,this)
    }
    ;
    mx.prototype.Ku = function(a) {
        var b = a || {};
        this.zH = !!b.scope;
        a = nx(this, b.scope);
        if (a == "")
            return _.mk({
                error: "Missing required parameter: scope"
            });
        var c = {
            scope: a,
            access_type: "offline",
            include_granted_scopes: !0
        };
        _.Db(hw, function(d) {
            b[d] != null && (c[d] = b[d])
        });
        c.hasOwnProperty("prompt") || c.hasOwnProperty("approval_prompt") || (c.prompt = "consent");
        b.redirect_uri == "postmessage" || b.redirect_uri == void 0 ? a = sx(this, c) : (c.redirect_uri = b.redirect_uri,
        qx(this, {
            sessionMeta: {
                extraQueryParams: c
            },
            responseType: "code id_token"
        }),
        a = _.lk({
            message: "Redirecting to IDP."
        }));
        return a
    }
    ;
    var sx = function(a, b) {
        b.origin = Hw();
        delete b.redirect_uri;
        rx(a, {
            sessionMeta: {
                extraQueryParams: b
            },
            responseType: "code permission id_token"
        });
        return new _.hk(function(c, d) {
            px(this, {
                authResult: function(e) {
                    (e = e && e.authResult) && e.code ? c({
                        code: e.code
                    }) : d(e && e.error ? e : {
                        error: "unknown_error"
                    })
                }
            })
        }
        ,a)
    }
      , rx = function(a, b) {
        Gw(b, ["sessionMeta", "extraQueryParams", "gsiwebsdk"], "2");
        Sv(a.we, Dw(), b)
    }
      , qx = function(a, b) {
        Gw(b, ["sessionMeta", "extraQueryParams", "gsiwebsdk"], "2");
        Tv(a.we, b)
    };
    mx.prototype.Yk = function(a) {
        var b = a || !1;
        return new _.hk(function(c) {
            Fv(this.we, b, function() {
                c()
            })
        }
        ,this)
    }
    ;
    mx.prototype.sT = function() {
        return this.Ja.authParameters.scope
    }
    ;
    var nx = function(a, b) {
        a = a.sT();
        b = Bv(b ? b.split(" ") : [], a ? a.split(" ") : []);
        _.th(b);
        return b.join(" ")
    };
    mx.prototype.gK = function() {
        var a = this;
        return new _.hk(function(b, c) {
            px(a, {
                noSessionBound: c,
                tokenFailed: c,
                userLoggedOut: c,
                tokenReady: function(d) {
                    b(d.response)
                }
            });
            a.we.GS()
        }
        )
    }
    ;
    mx.prototype.qP = function(a, b, c, d) {
        if (a = typeof a === "string" ? document.getElementById(a) : a) {
            var e = this;
            _.mj(a, "click", function() {
                var f = b;
                typeof b == "function" && (f = b());
                e.Xk(f).then(function(h) {
                    c && c(h)
                }, function(h) {
                    d && d(h)
                })
            })
        } else
            d && d({
                error: "Could not attach click handler to the element. Reason: element not found."
            })
    }
    ;
    mx.prototype.disconnect = function() {
        return new _.hk(function(a) {
            this.we.revoke(function() {
                a()
            })
        }
        ,this)
    }
    ;
    mx.prototype.attachClickHandler = mx.prototype.qP;
    var tx;
    _.hk.prototype["catch"] = _.hk.prototype.rD;
    tx = null;
    _.ux = function(a) {
        Jw();
        a = Ww(a);
        if (Mw) {
            if (_.iu(a, tx || {}))
                return kx();
            throw new lw("gapi.auth2 has been initialized with different options. Consider calling gapi.auth2.getAuthInstance() instead of gapi.auth2.init().");
        }
        Xw(a, a.fetch_basic_profile !== !1);
        Fw();
        tx = a;
        Mw = new mx(a);
        _.Ge.ga = 1;
        return kx()
    }
    ;
    var wx, yx, vx, Ax, zx, Bx;
    _.xx = function(a, b) {
        Jw();
        Fw();
        a = Ww(a);
        Xw(a);
        var c = dx(a);
        c.supportBlocked3PCookies = Kw(a.use_fedcm);
        var d = new _.yv(c);
        a.prompt == "none" ? vx(d, a, function(e) {
            e.status = e.error ? {
                signed_in: !1,
                method: null,
                google_logged_in: !1
            } : {
                signed_in: !0,
                method: "AUTO",
                google_logged_in: !0
            };
            b(e)
        }) : wx(d, a, function(e) {
            if (e.error)
                e.status = {
                    signed_in: !1,
                    method: null,
                    google_logged_in: !1
                };
            else {
                var f = e.access_token || e.id_token;
                e.status = {
                    signed_in: !!f,
                    method: "PROMPT",
                    google_logged_in: !!f
                }
            }
            e["g-oauth-window"] = d.gY.zi;
            b(e)
        })
    }
    ;
    wx = function(a, b, c) {
        var d = new ax(b.response_type);
        c = yx(a, d, c);
        var e = {
            responseType: d.toString()
        };
        Gw(e, ["sessionMeta", "extraQueryParams", "gsiwebsdk"], b.gsiwebsdk || "2");
        bx(d) && Gw(e, ["sessionMeta", "extraQueryParams", "access_type"], b.access_type || "offline");
        b.redirect_uri && Gw(e, ["sessionMeta", "extraQueryParams", "redirect_uri"], b.redirect_uri);
        b.state && Gw(e, ["sessionMeta", "extraQueryParams", "state"], b.state);
        b = Dw();
        a.Ck ? c({
            authResult: {
                error: "idpiframe_initialization_failed",
                details: a.Xn().error
            }
        }) : (a.rn = c,
        Sv(a, b, e))
    }
    ;
    yx = function(a, b, c) {
        if (cx(b)) {
            var d = zx(c);
            return function(e) {
                e && e.authResult && !e.authResult.error ? a.wu(function(f) {
                    f && !f.error ? (f = _.Pj(f),
                    bx(b) && (f.code = e.authResult.code),
                    d(f)) : d(f ? f : {
                        error: "unknown_error"
                    })
                })(e) : d(e && e.authResult ? e.authResult : {
                    error: "unknown_error"
                })
            }
        }
        return function(e) {
            e && e.authResult && !e.authResult.error ? c(_.Pj(e.authResult)) : c(e && e.authResult ? e.authResult : {
                error: "unknown_error"
            })
        }
    }
    ;
    vx = function(a, b, c) {
        if (bx(new ax(b.response_type)) && b.access_type == "offline")
            c({
                error: "immediate_failed",
                error_subtype: "access_denied"
            });
        else {
            var d = zx(c);
            b.login_hint ? a.dG(b.login_hint, function(e) {
                e ? Ax(a, b, e, d) : c({
                    error: "immediate_failed",
                    error_subtype: "access_denied"
                })
            }) : b.authuser !== void 0 && b.authuser !== null ? sw(a, b.authuser).select(function(e) {
                e && e.login_hint ? Ax(a, b, e.login_hint, d) : d({
                    error: "immediate_failed",
                    error_subtype: "access_denied"
                })
            }) : a.ou(function(e) {
                e && e.hint ? Ax(a, b, e.hint, d) : e && e.disabled ? d({
                    error: "immediate_failed",
                    error_subtype: "no_user_bound"
                }) : (b.session_selection == "first_valid" ? rw(a) : qw(a)).select(function(f) {
                    f && f.login_hint ? Ax(a, b, f.login_hint, d) : d({
                        error: "immediate_failed",
                        error_subtype: "no_user_bound"
                    })
                })
            })
        }
    }
    ;
    Ax = function(a, b, c, d) {
        b = new ax(b.response_type);
        var e = 0
          , f = {}
          , h = function(k) {
            !k || k.error ? d(k) : (e--,
            _.Si(f, k),
            e == 0 && d(f))
        };
        (cx(b) || ex(b, "id_token")) && e++;
        bx(b) && e++;
        (cx(b) || ex(b, "id_token")) && _.zv(a, c, h);
        bx(b) && Uv(a, c, h)
    }
    ;
    zx = function(a) {
        return function(b) {
            if (!b || b.error)
                _.Zv(),
                b ? a(b) : a({
                    error: "unknown_error"
                });
            else {
                if (b.access_token) {
                    var c = _.Pj(b);
                    Bx(c);
                    delete c.id_token;
                    delete c.code;
                    _.Yv(c)
                }
                a(b)
            }
        }
    }
    ;
    Bx = function(a) {
        _.Db(iw, function(b) {
            delete a[b]
        })
    }
    ;
    _.A("gapi.auth2.init", _.ux);
    _.A("gapi.auth2.authorize", function(a, b) {
        if (Mw != null)
            throw new lw("gapi.auth2.authorize cannot be called after GoogleAuth has been initialized (i.e. with a call to gapi.auth2.init, or gapi.client.init when given a 'clientId' and a 'scope' parameters).");
        _.xx(a, function(c) {
            Bx(c);
            b(c)
        })
    });
    _.A("gapi.auth2._gt", function() {
        return _.ji()
    });
    _.A("gapi.auth2.enableDebugLogs", function(a) {
        a = a !== !1;
        _.ju = a != "0" && !!a
    });
    _.A("gapi.auth2.getAuthInstance", _.lx);
    _.A("gapi.auth2.BasicProfile", Nw);
    _.A("gapi.auth2.BasicProfile.prototype.getId", Nw.prototype.getId);
    _.A("gapi.auth2.BasicProfile.prototype.getName", Nw.prototype.og);
    _.A("gapi.auth2.BasicProfile.prototype.getGivenName", Nw.prototype.r9);
    _.A("gapi.auth2.BasicProfile.prototype.getFamilyName", Nw.prototype.n9);
    _.A("gapi.auth2.BasicProfile.prototype.getImageUrl", Nw.prototype.z9);
    _.A("gapi.auth2.BasicProfile.prototype.getEmail", Nw.prototype.Rn);
    _.A("gapi.auth2.GoogleAuth", mx);
    _.A("gapi.auth2.GoogleAuth.prototype.attachClickHandler", mx.prototype.qP);
    _.A("gapi.auth2.GoogleAuth.prototype.disconnect", mx.prototype.disconnect);
    _.A("gapi.auth2.GoogleAuth.prototype.grantOfflineAccess", mx.prototype.Ku);
    _.A("gapi.auth2.GoogleAuth.prototype.signIn", mx.prototype.Xk);
    _.A("gapi.auth2.GoogleAuth.prototype.signOut", mx.prototype.Yk);
    _.A("gapi.auth2.GoogleAuth.prototype.getInitialScopes", mx.prototype.sT);
    _.A("gapi.auth2.GoogleUser", Lw);
    _.A("gapi.auth2.GoogleUser.prototype.grant", Lw.prototype.h$);
    _.A("gapi.auth2.GoogleUser.prototype.getId", Lw.prototype.getId);
    _.A("gapi.auth2.GoogleUser.prototype.isSignedIn", Lw.prototype.zg);
    _.A("gapi.auth2.GoogleUser.prototype.getAuthResponse", Lw.prototype.Rl);
    _.A("gapi.auth2.GoogleUser.prototype.getBasicProfile", Lw.prototype.V8);
    _.A("gapi.auth2.GoogleUser.prototype.getGrantedScopes", Lw.prototype.t9);
    _.A("gapi.auth2.GoogleUser.prototype.getHostedDomain", Lw.prototype.CG);
    _.A("gapi.auth2.GoogleUser.prototype.grantOfflineAccess", Lw.prototype.Ku);
    _.A("gapi.auth2.GoogleUser.prototype.hasGrantedScopes", Lw.prototype.pA);
    _.A("gapi.auth2.GoogleUser.prototype.reloadAuthResponse", Lw.prototype.gK);
    _.A("gapi.auth2.LiveValue", yw);
    _.A("gapi.auth2.LiveValue.prototype.listen", yw.prototype.na);
    _.A("gapi.auth2.LiveValue.prototype.get", yw.prototype.get);
    _.A("gapi.auth2.SigninOptionsBuilder", Bw);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.getAppPackageName", Bw.prototype.U8);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.setAppPackageName", Bw.prototype.nfa);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.getScope", Bw.prototype.Fu);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.setScope", Bw.prototype.j_);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.getPrompt", Bw.prototype.Q9);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.setPrompt", Bw.prototype.Kfa);
    _.A("gapi.auth2.SigninOptionsBuilder.prototype.get", Bw.prototype.get);
    _.Ue = _.Ue || {};
    (function() {
        function a(b) {
            var c = "";
            if (b.nodeType == 3 || b.nodeType == 4)
                c = b.nodeValue;
            else if (b.innerText)
                c = b.innerText;
            else if (b.innerHTML)
                c = b.innerHTML;
            else if (b.firstChild) {
                c = [];
                for (b = b.firstChild; b; b = b.nextSibling)
                    c.push(a(b));
                c = c.join("")
            }
            return c
        }
        _.Ue.createElement = function(b) {
            if (!document.body || document.body.namespaceURI)
                try {
                    var c = document.createElementNS("http://www.w3.org/1999/xhtml", b)
                } catch (d) {}
            return c || document.createElement(b)
        }
        ;
        _.Ue.rQ = function(b) {
            var c = _.Ue.createElement("iframe");
            try {
                var d = ["<", "iframe"], e = b || {}, f;
                for (f in e)
                    e.hasOwnProperty(f) && (d.push(" "),
                    d.push(f),
                    d.push('="'),
                    d.push(_.Ue.OF(e[f])),
                    d.push('"'));
                d.push("></");
                d.push("iframe");
                d.push(">");
                var h = _.Ue.createElement(d.join(""));
                h && (!c || h.tagName == c.tagName && h.namespaceURI == c.namespaceURI) && (c = h)
            } catch (l) {}
            d = c;
            b = b || {};
            for (var k in b)
                b.hasOwnProperty(k) && (d[k] = b[k]);
            return c
        }
        ;
        _.Ue.VS = function() {
            if (document.body)
                return document.body;
            try {
                var b = document.getElementsByTagNameNS("http://www.w3.org/1999/xhtml", "body");
                if (b && b.length == 1)
                    return b[0]
            } catch (c) {}
            return document.documentElement || document
        }
        ;
        _.Ue.lqa = function(b) {
            return a(b)
        }
    }
    )();
    _.vg = window.gapi && window.gapi.util || {};
    _.vg = _.vg = {};
    _.vg.getOrigin = function(a) {
        return _.xg(a)
    }
    ;
    _.Xx = function(a) {
        if (a.indexOf("GCSC") !== 0)
            return null;
        var b = {
            tj: !1
        };
        a = a.substr(4);
        if (!a)
            return b;
        var c = a.charAt(0);
        a = a.substr(1);
        var d = a.lastIndexOf("_");
        if (d == -1)
            return b;
        var e = _.Vx(a.substr(d + 1));
        if (e == null)
            return b;
        a = a.substring(0, d);
        if (a.charAt(0) !== "_")
            return b;
        d = c === "E" && e.jf;
        return !d && (c !== "U" || e.jf) || d && !_.Wx ? b : {
            tj: !0,
            jf: d,
            k7: a.substr(1),
            domain: e.domain,
            Ti: e.Ti
        }
    }
    ;
    _.Yx = function(a, b) {
        this.jh = a;
        a = b || {};
        this.mca = Number(a.maxAge) || 0;
        this.Zd = a.domain;
        this.Lm = a.path;
        this.Uea = !!a.secure
    }
    ;
    _.Yx.prototype.read = function() {
        for (var a = this.jh + "=", b = document.cookie.split(/;\s*/), c = 0; c < b.length; ++c) {
            var d = b[c];
            if (d.indexOf(a) == 0)
                return d.substr(a.length)
        }
    }
    ;
    _.Yx.prototype.write = function(a, b) {
        if (!Zx.test(this.jh))
            throw "Invalid cookie name";
        if (!$x.test(a))
            throw "Invalid cookie value";
        a = this.jh + "=" + a;
        this.Zd && (a += ";domain=" + this.Zd);
        this.Lm && (a += ";path=" + this.Lm);
        b = typeof b === "number" ? b : this.mca;
        if (b >= 0) {
            var c = new Date;
            c.setSeconds(c.getSeconds() + b);
            a += ";expires=" + c.toUTCString()
        }
        this.Uea && (a += ";secure");
        document.cookie = a;
        return !0
    }
    ;
    _.Yx.prototype.clear = function() {
        this.write("", 0)
    }
    ;
    var $x = /^[-+/_=.:|%&a-zA-Z0-9@]*$/
      , Zx = /^[A-Z_][A-Z0-9_]{0,63}$/;
    _.Yx.iterate = function(a) {
        for (var b = document.cookie.split(/;\s*/), c = 0; c < b.length; ++c) {
            var d = b[c].split("=")
              , e = d.shift();
            a(e, d.join("="))
        }
    }
    ;
    _.ay = function(a) {
        this.Qf = a
    }
    ;
    _.ay.prototype.read = function() {
        if (by.hasOwnProperty(this.Qf))
            return by[this.Qf]
    }
    ;
    _.ay.prototype.write = function(a) {
        by[this.Qf] = a;
        return !0
    }
    ;
    _.ay.prototype.clear = function() {
        delete by[this.Qf]
    }
    ;
    var by = {};
    _.ay.iterate = function(a) {
        for (var b in by)
            by.hasOwnProperty(b) && a(b, by[b])
    }
    ;
    var cy = function() {
        this.Ka = null;
        this.key = function() {
            return null
        }
        ;
        this.getItem = function() {
            return this.Ka
        }
        ;
        this.setItem = function(a, b) {
            this.Ka = b;
            this.length = 1
        }
        ;
        this.removeItem = function() {
            this.clear()
        }
        ;
        this.clear = function() {
            this.Ka = null;
            this.length = 0
        }
        ;
        this.length = 0
    }
      , dy = function(a) {
        try {
            var b = a || window.sessionStorage;
            if (!b)
                return !1;
            b.setItem("gapi.sessionStorageTest", "gapi.sessionStorageTest" + b.length);
            b.removeItem("gapi.sessionStorageTest");
            return !0
        } catch (c) {
            return !1
        }
    }
      , ey = function(a, b) {
        this.jh = a;
        this.iN = dy(b) ? b || window.sessionStorage : new cy
    };
    ey.prototype.read = function() {
        return this.iN.getItem(this.jh)
    }
    ;
    ey.prototype.write = function(a) {
        try {
            this.iN.setItem(this.jh, a)
        } catch (b) {
            return !1
        }
        return !0
    }
    ;
    ey.prototype.clear = function() {
        this.iN.removeItem(this.jh)
    }
    ;
    ey.iterate = function(a) {
        if (dy())
            for (var b = window.sessionStorage.length, c = 0; c < b; ++c) {
                var d = window.sessionStorage.key(c);
                a(d, window.sessionStorage[d])
            }
    }
    ;
    _.Wx = window.location.protocol === "https:";
    _.fy = _.Wx || window.location.protocol === "http:" ? _.Yx : _.ay;
    _.Vx = function(a) {
        var b = a.substr(1)
          , c = ""
          , d = window.location.hostname;
        if (b !== "") {
            c = parseInt(b, 10);
            if (isNaN(c))
                return null;
            b = d.split(".");
            if (b.length < c - 1)
                return null;
            b.length == c - 1 && (d = "." + d)
        } else
            d = "";
        return {
            jf: a.charAt(0) == "S",
            domain: d,
            Ti: c
        }
    }
    ;
    var gy, hy, ky, ly;
    gy = _.we();
    hy = _.we();
    _.iy = _.we();
    _.jy = _.we();
    ky = "state code cookie_policy g_user_cookie_policy authuser prompt g-oauth-window status".split(" ");
    ly = function(a) {
        this.aY = a;
        this.MI = null
    }
    ;
    ly.prototype.write = function(a) {
        var b = _.we(), c = _.we(), d = window.decodeURIComponent ? decodeURIComponent : unescape, e;
        for (e in a)
            if (_.xe(a, e)) {
                var f = a[e];
                f = f.replace(/\+/g, " ");
                c[e] = d(f);
                b[e] = a[e]
            }
        d = ky.length;
        for (e = 0; e < d; ++e)
            delete c[ky[e]];
        a = String(a.authuser || 0);
        d = _.we();
        d[a] = c;
        c = _.Hf(d);
        this.aY.write(c);
        this.MI = b
    }
    ;
    ly.prototype.read = function() {
        return this.MI
    }
    ;
    ly.prototype.clear = function() {
        this.aY.clear();
        this.MI = _.we()
    }
    ;
    _.my = function(a) {
        return a ? {
            domain: a.domain,
            path: "/",
            secure: a.jf
        } : null
    }
    ;
    ey.iterate(function(a) {
        var b = _.Xx(a);
        b && b.tj && (gy[a] = new ly(new ey(a)))
    });
    _.fy.iterate(function(a) {
        gy[a] && (hy[a] = new _.fy(a,_.my(_.Xx(a))))
    });
    _.$h = function() {
        function a() {
            e[0] = 1732584193;
            e[1] = 4023233417;
            e[2] = 2562383102;
            e[3] = 271733878;
            e[4] = 3285377520;
            n = m = 0
        }
        function b(p) {
            for (var q = h, u = 0; u < 64; u += 4)
                q[u / 4] = p[u] << 24 | p[u + 1] << 16 | p[u + 2] << 8 | p[u + 3];
            for (u = 16; u < 80; u++)
                p = q[u - 3] ^ q[u - 8] ^ q[u - 14] ^ q[u - 16],
                q[u] = (p << 1 | p >>> 31) & 4294967295;
            p = e[0];
            var v = e[1]
              , t = e[2]
              , y = e[3]
              , z = e[4];
            for (u = 0; u < 80; u++) {
                if (u < 40)
                    if (u < 20) {
                        var C = y ^ v & (t ^ y);
                        var F = 1518500249
                    } else
                        C = v ^ t ^ y,
                        F = 1859775393;
                else
                    u < 60 ? (C = v & t | y & (v | t),
                    F = 2400959708) : (C = v ^ t ^ y,
                    F = 3395469782);
                C = ((p << 5 | p >>> 27) & 4294967295) + C + z + F + q[u] & 4294967295;
                z = y;
                y = t;
                t = (v << 30 | v >>> 2) & 4294967295;
                v = p;
                p = C
            }
            e[0] = e[0] + p & 4294967295;
            e[1] = e[1] + v & 4294967295;
            e[2] = e[2] + t & 4294967295;
            e[3] = e[3] + y & 4294967295;
            e[4] = e[4] + z & 4294967295
        }
        function c(p, q) {
            if (typeof p === "string") {
                p = unescape(encodeURIComponent(p));
                for (var u = [], v = 0, t = p.length; v < t; ++v)
                    u.push(p.charCodeAt(v));
                p = u
            }
            q || (q = p.length);
            u = 0;
            if (m == 0)
                for (; u + 64 < q; )
                    b(p.slice(u, u + 64)),
                    u += 64,
                    n += 64;
            for (; u < q; )
                if (f[m++] = p[u++],
                n++,
                m == 64)
                    for (m = 0,
                    b(f); u + 64 < q; )
                        b(p.slice(u, u + 64)),
                        u += 64,
                        n += 64
        }
        function d() {
            var p = []
              , q = n * 8;
            m < 56 ? c(k, 56 - m) : c(k, 64 - (m - 56));
            for (var u = 63; u >= 56; u--)
                f[u] = q & 255,
                q >>>= 8;
            b(f);
            for (u = q = 0; u < 5; u++)
                for (var v = 24; v >= 0; v -= 8)
                    p[q++] = e[u] >> v & 255;
            return p
        }
        for (var e = [], f = [], h = [], k = [128], l = 1; l < 64; ++l)
            k[l] = 0;
        var m, n;
        a();
        return {
            reset: a,
            update: c,
            digest: d,
            Si: function() {
                for (var p = d(), q = "", u = 0; u < p.length; u++)
                    q += "0123456789ABCDEF".charAt(Math.floor(p[u] / 16)) + "0123456789ABCDEF".charAt(p[u] % 16);
                return q
            }
        }
    }
    ;
    var bi = function(a, b, c) {
        var d = String(_.ab.location.href);
        return d && a && b ? [b, ai(_.xg(d), a, c || null)].join(" ") : null
    }
      , ai = function(a, b, c) {
        var d = []
          , e = [];
        if ((Array.isArray(c) ? 2 : 1) == 1)
            return e = [b, a],
            _.Db(d, function(k) {
                e.push(k)
            }),
            ci(e.join(" "));
        var f = []
          , h = [];
        _.Db(c, function(k) {
            h.push(k.key);
            f.push(k.value)
        });
        c = Math.floor((new Date).getTime() / 1E3);
        e = f.length == 0 ? [c, b, a] : [f.join(":"), c, b, a];
        _.Db(d, function(k) {
            e.push(k)
        });
        a = ci(e.join(" "));
        a = [c, a];
        h.length == 0 || a.push(h.join(""));
        return a.join("_")
    }
      , ci = function(a) {
        var b = _.$h();
        b.update(a);
        return b.Si().toLowerCase()
    };
    var ei;
    _.di = function() {
        var a = _.ab.__SAPISID || _.ab.__APISID || _.ab.__3PSAPISID || _.ab.__1PSAPISID || _.ab.__OVERRIDE_SID;
        if (a)
            return !0;
        typeof document !== "undefined" && (a = new _.Xh(document),
        a = a.get("SAPISID") || a.get("APISID") || a.get("__Secure-3PAPISID") || a.get("__Secure-1PAPISID"));
        return !!a
    }
    ;
    ei = function(a, b, c, d) {
        (a = _.ab[a]) || typeof document === "undefined" || (a = (new _.Xh(document)).get(b));
        return a ? bi(a, c, d) : null
    }
    ;
    _.fi = function(a) {
        var b = _.xg(String(_.ab.location.href))
          , c = [];
        if (_.di()) {
            b = b.indexOf("https:") == 0 || b.indexOf("chrome-extension:") == 0 || b.indexOf("chrome-untrusted://new-tab-page") == 0 || b.indexOf("moz-extension:") == 0;
            var d = b ? _.ab.__SAPISID : _.ab.__APISID;
            d || typeof document === "undefined" || (d = new _.Xh(document),
            d = d.get(b ? "SAPISID" : "APISID") || d.get("__Secure-3PAPISID"));
            (d = d ? bi(d, b ? "SAPISIDHASH" : "APISIDHASH", a) : null) && c.push(d);
            b && ((b = ei("__1PSAPISID", "__Secure-1PAPISID", "SAPISID1PHASH", a)) && c.push(b),
            (a = ei("__3PSAPISID", "__Secure-3PAPISID", "SAPISID3PHASH", a)) && c.push(a))
        }
        return c.length == 0 ? null : c.join(" ")
    }
    ;
    _.gi = function(a) {
        var b = {
            SAPISIDHASH: !0,
            SAPISID3PHASH: !0,
            SAPISID1PHASH: !0,
            APISIDHASH: !0
        };
        return a && (a.OriginToken || a.Authorization && b[String(a.Authorization).split(" ")[0]]) ? !0 : !1
    }
    ;
    _.hi = {
        tU: _.gi,
        Cba: _.di,
        vT: function() {
            var a = null;
            _.di() && (a = window.__PVT,
            a == null && (a = (new _.Xh(document)).get("BEAT")));
            return a
        },
        RS: _.fi
    };
    var Ir, Jr;
    _.Br = function(a) {
        if (a instanceof _.bc)
            return a.uY;
        throw Error("j");
    }
    ;
    _.Cr = function(a, b, c, d) {
        this.top = a;
        this.right = b;
        this.bottom = c;
        this.left = d
    }
    ;
    _.Dr = function(a, b) {
        return a == b ? !0 : a && b ? a.x == b.x && a.y == b.y : !1
    }
    ;
    _.Er = function(a, b) {
        this.x = a !== void 0 ? a : 0;
        this.y = b !== void 0 ? b : 0
    }
    ;
    _.g = _.Er.prototype;
    _.g.clone = function() {
        return new _.Er(this.x,this.y)
    }
    ;
    _.g.equals = function(a) {
        return a instanceof _.Er && _.Dr(this, a)
    }
    ;
    _.g.ceil = function() {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        return this
    }
    ;
    _.g.floor = function() {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        return this
    }
    ;
    _.g.round = function() {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        return this
    }
    ;
    _.g.translate = function(a, b) {
        a instanceof _.Er ? (this.x += a.x,
        this.y += a.y) : (this.x += Number(a),
        typeof b === "number" && (this.y += b));
        return this
    }
    ;
    _.g.scale = function(a, b) {
        this.x *= a;
        this.y *= typeof b === "number" ? b : a;
        return this
    }
    ;
    _.Fr = function(a) {
        return a.scrollingElement ? a.scrollingElement : !_.xd && _.$d(a) ? a.documentElement : a.body || a.documentElement
    }
    ;
    _.Gr = function(a) {
        var b = _.Fr(a);
        a = a.defaultView;
        return new _.Er(a.pageXOffset || b.scrollLeft,a.pageYOffset || b.scrollTop)
    }
    ;
    _.Hr = function(a, b, c, d) {
        return _.Vd(a.Nb, b, c, d)
    }
    ;
    Ir = function(a) {
        return String(a).replace(/\-([a-z])/g, function(b, c) {
            return c.toUpperCase()
        })
    }
    ;
    Jr = function(a) {
        return a.replace(RegExp("(^|[\\s]+)([a-z])", "g"), function(b, c, d) {
            return c + d.toUpperCase()
        })
    }
    ;
    _.g = _.Cr.prototype;
    _.g.Tb = function() {
        return this.right - this.left
    }
    ;
    _.g.Nc = function() {
        return this.bottom - this.top
    }
    ;
    _.g.clone = function() {
        return new _.Cr(this.top,this.right,this.bottom,this.left)
    }
    ;
    _.g.contains = function(a) {
        return this && a ? a instanceof _.Cr ? a.left >= this.left && a.right <= this.right && a.top >= this.top && a.bottom <= this.bottom : a.x >= this.left && a.x <= this.right && a.y >= this.top && a.y <= this.bottom : !1
    }
    ;
    _.g.expand = function(a, b, c, d) {
        _.wb(a) ? (this.top -= a.top,
        this.right += a.right,
        this.bottom += a.bottom,
        this.left -= a.left) : (this.top -= a,
        this.right += Number(b),
        this.bottom += Number(c),
        this.left -= Number(d));
        return this
    }
    ;
    _.g.ceil = function() {
        this.top = Math.ceil(this.top);
        this.right = Math.ceil(this.right);
        this.bottom = Math.ceil(this.bottom);
        this.left = Math.ceil(this.left);
        return this
    }
    ;
    _.g.floor = function() {
        this.top = Math.floor(this.top);
        this.right = Math.floor(this.right);
        this.bottom = Math.floor(this.bottom);
        this.left = Math.floor(this.left);
        return this
    }
    ;
    _.g.round = function() {
        this.top = Math.round(this.top);
        this.right = Math.round(this.right);
        this.bottom = Math.round(this.bottom);
        this.left = Math.round(this.left);
        return this
    }
    ;
    _.g.translate = function(a, b) {
        a instanceof _.Er ? (this.left += a.x,
        this.right += a.x,
        this.top += a.y,
        this.bottom += a.y) : (this.left += a,
        this.right += a,
        typeof b === "number" && (this.top += b,
        this.bottom += b));
        return this
    }
    ;
    _.g.scale = function(a, b) {
        b = typeof b === "number" ? b : a;
        this.left *= a;
        this.right *= a;
        this.top *= b;
        this.bottom *= b;
        return this
    }
    ;
    var Mr, Kr, Qr, Sr;
    _.Lr = function(a, b, c) {
        if (typeof b === "string")
            (b = Kr(a, b)) && (a.style[b] = c);
        else
            for (var d in b) {
                c = a;
                var e = b[d]
                  , f = Kr(c, d);
                f && (c.style[f] = e)
            }
    }
    ;
    Mr = {};
    Kr = function(a, b) {
        var c = Mr[b];
        if (!c) {
            var d = Ir(b);
            c = d;
            a.style[d] === void 0 && (d = (_.xd ? "Webkit" : _.wd ? "Moz" : null) + Jr(d),
            a.style[d] !== void 0 && (c = d));
            Mr[b] = c
        }
        return c
    }
    ;
    _.Nr = function(a, b) {
        var c = a.style[Ir(b)];
        return typeof c !== "undefined" ? c : a.style[Kr(a, b)] || ""
    }
    ;
    _.Or = function(a, b) {
        var c = _.Td(a);
        return c.defaultView && c.defaultView.getComputedStyle && (a = c.defaultView.getComputedStyle(a, null)) ? a[b] || a.getPropertyValue(b) || "" : ""
    }
    ;
    _.Pr = function(a, b) {
        return _.Or(a, b) || (a.currentStyle ? a.currentStyle[b] : null) || a.style && a.style[b]
    }
    ;
    Qr = function(a) {
        try {
            return a.getBoundingClientRect()
        } catch (b) {
            return {
                left: 0,
                top: 0,
                right: 0,
                bottom: 0
            }
        }
    }
    ;
    _.Tr = function(a, b) {
        b = b || _.Fr(document);
        var c = b || _.Fr(document);
        var d = _.Rr(a)
          , e = _.Rr(c)
          , f = _.Or(c, "borderLeftWidth");
        var h = _.Or(c, "borderRightWidth");
        var k = _.Or(c, "borderTopWidth")
          , l = _.Or(c, "borderBottomWidth");
        h = new _.Cr(parseFloat(k),parseFloat(h),parseFloat(l),parseFloat(f));
        c == _.Fr(document) ? (f = d.x - c.scrollLeft,
        d = d.y - c.scrollTop) : (f = d.x - e.x - h.left,
        d = d.y - e.y - h.top);
        a = Sr(a);
        e = c.clientHeight - a.height;
        h = c.scrollLeft;
        k = c.scrollTop;
        h += Math.min(f, Math.max(f - (c.clientWidth - a.width), 0));
        k += Math.min(d, Math.max(d - e, 0));
        c = new _.Er(h,k);
        b.scrollLeft = c.x;
        b.scrollTop = c.y
    }
    ;
    _.Rr = function(a) {
        var b = _.Td(a)
          , c = new _.Er(0,0);
        if (a == (b ? _.Td(b) : document).documentElement)
            return c;
        a = Qr(a);
        b = _.Gr(_.Ud(b).Nb);
        c.x = a.left + b.x;
        c.y = a.top + b.y;
        return c
    }
    ;
    _.Vr = function(a, b) {
        var c = new _.Er(0,0)
          , d = _.ae(_.Td(a));
        a: {
            try {
                _.Qb(d.parent);
                var e = !0;
                break a
            } catch (f) {}
            e = !1
        }
        if (!e)
            return c;
        do
            e = d == b ? _.Rr(a) : _.Ur(a),
            c.x += e.x,
            c.y += e.y;
        while (d && d != b && d != d.parent && (a = d.frameElement) && (d = d.parent));
        return c
    }
    ;
    _.Ur = function(a) {
        a = Qr(a);
        return new _.Er(a.left,a.top)
    }
    ;
    _.Xr = function(a, b, c) {
        if (b instanceof _.md)
            c = b.height,
            b = b.width;
        else if (c == void 0)
            throw Error("K");
        a.style.width = _.Wr(b, !0);
        a.style.height = _.Wr(c, !0)
    }
    ;
    _.Wr = function(a, b) {
        typeof a == "number" && (a = (b ? Math.round(a) : a) + "px");
        return a
    }
    ;
    _.Yr = function(a) {
        var b = Sr;
        if (_.Pr(a, "display") != "none")
            return b(a);
        var c = a.style
          , d = c.display
          , e = c.visibility
          , f = c.position;
        c.visibility = "hidden";
        c.position = "absolute";
        c.display = "inline";
        a = b(a);
        c.display = d;
        c.position = f;
        c.visibility = e;
        return a
    }
    ;
    Sr = function(a) {
        var b = a.offsetWidth
          , c = a.offsetHeight
          , d = _.xd && !b && !c;
        return (b === void 0 || d) && a.getBoundingClientRect ? (a = Qr(a),
        new _.md(a.right - a.left,a.bottom - a.top)) : new _.md(b,c)
    }
    ;
    _.Zr = function(a, b) {
        a.style.display = b ? "" : "none"
    }
    ;
    _.as = function(a) {
        var b = _.Ud(void 0)
          , c = _.Hr(b, "HEAD")[0];
        if (!c) {
            var d = _.Hr(b, "BODY")[0];
            c = b.va("HEAD");
            d.parentNode.insertBefore(c, d)
        }
        d = b.va("STYLE");
        var e;
        (e = _.Bc("style", document)) && d.setAttribute("nonce", e);
        _.$r(d, a);
        b.appendChild(c, d)
    }
    ;
    _.$r = function(a, b) {
        b = _.Br(b);
        _.ab.trustedTypes ? _.oe(a, b) : a.innerHTML = b
    }
    ;
    _.bs = _.wd ? "MozUserSelect" : _.xd || _.ud ? "WebkitUserSelect" : null;
    _.ny = function(a) {
        _.Ni.call(this);
        this.Qf = 1;
        this.NB = [];
        this.SB = 0;
        this.Vf = [];
        this.Nj = {};
        this.z6 = !!a
    }
    ;
    _.hb(_.ny, _.Ni);
    _.g = _.ny.prototype;
    _.g.subscribe = function(a, b, c) {
        var d = this.Nj[a];
        d || (d = this.Nj[a] = []);
        var e = this.Qf;
        this.Vf[e] = a;
        this.Vf[e + 1] = b;
        this.Vf[e + 2] = c;
        this.Qf = e + 3;
        d.push(e);
        return e
    }
    ;
    _.g.Mw = _.kb(18);
    _.g.unsubscribe = function(a, b, c) {
        if (a = this.Nj[a]) {
            var d = this.Vf;
            if (a = a.find(function(e) {
                return d[e + 1] == b && d[e + 2] == c
            }))
                return this.ll(a)
        }
        return !1
    }
    ;
    _.g.ll = function(a) {
        var b = this.Vf[a];
        if (b) {
            var c = this.Nj[b];
            this.SB != 0 ? (this.NB.push(a),
            this.Vf[a + 1] = function() {}
            ) : (c && _.Qi(c, a),
            delete this.Vf[a],
            delete this.Vf[a + 1],
            delete this.Vf[a + 2])
        }
        return !!b
    }
    ;
    _.g.bp = function(a, b) {
        var c = this.Nj[a];
        if (c) {
            var d = Array(arguments.length - 1), e = arguments.length, f;
            for (f = 1; f < e; f++)
                d[f - 1] = arguments[f];
            if (this.z6)
                for (f = 0; f < c.length; f++)
                    e = c[f],
                    oy(this.Vf[e + 1], this.Vf[e + 2], d);
            else {
                this.SB++;
                try {
                    for (f = 0,
                    e = c.length; f < e && !this.isDisposed(); f++) {
                        var h = c[f];
                        this.Vf[h + 1].apply(this.Vf[h + 2], d)
                    }
                } finally {
                    if (this.SB--,
                    this.NB.length > 0 && this.SB == 0)
                        for (; c = this.NB.pop(); )
                            this.ll(c)
                }
            }
            return f != 0
        }
        return !1
    }
    ;
    var oy = function(a, b, c) {
        _.fk(function() {
            a.apply(b, c)
        })
    };
    _.ny.prototype.clear = function(a) {
        if (a) {
            var b = this.Nj[a];
            b && (b.forEach(this.ll, this),
            delete this.Nj[a])
        } else
            this.Vf.length = 0,
            this.Nj = {}
    }
    ;
    _.ny.prototype.Yb = function(a) {
        if (a) {
            var b = this.Nj[a];
            return b ? b.length : 0
        }
        a = 0;
        for (b in this.Nj)
            a += this.Yb(b);
        return a
    }
    ;
    _.ny.prototype.ua = function() {
        _.ny.N.ua.call(this);
        this.clear();
        this.NB.length = 0
    }
    ;
    _.py = function(a) {
        this.Ega = a
    }
    ;
    _.qy = function(a) {
        _.Ni.call(this);
        this.qe = new _.ny(a);
        _.Pi(this, this.qe)
    }
    ;
    _.py.prototype.toString = function() {
        return this.Ega
    }
    ;
    _.hb(_.qy, _.Ni);
    _.g = _.qy.prototype;
    _.g.subscribe = function(a, b, c) {
        return this.qe.subscribe(a.toString(), b, c)
    }
    ;
    _.g.Mw = _.kb(17);
    _.g.unsubscribe = function(a, b, c) {
        return this.qe.unsubscribe(a.toString(), b, c)
    }
    ;
    _.g.ll = function(a) {
        return this.qe.ll(a)
    }
    ;
    _.g.bp = function(a, b) {
        return this.qe.bp(a.toString(), b)
    }
    ;
    _.g.clear = function(a) {
        this.qe.clear(a !== void 0 ? a.toString() : void 0)
    }
    ;
    _.g.Yb = function(a) {
        return this.qe.Yb(a !== void 0 ? a.toString() : void 0)
    }
    ;
    var ry, uy, sy, vy, wy, ty;
    ry = function(a) {
        var b = _.oc("");
        return _.$b(a.map(function(c) {
            return _.ac(_.oc(c))
        }).join(_.ac(b).toString()))
    }
    ;
    uy = function(a) {
        for (var b = "", c = Object.keys(a), d = 0; d < c.length; d++) {
            var e = c[d]
              , f = a[e];
            if (!sy.test(e))
                throw Error("j");
            if (f !== void 0 && f !== null) {
                if (/^on./i.test(e))
                    throw Error("j");
                ty.indexOf(e.toLowerCase()) !== -1 && (f = _.hc(f) ? f.toString() : _.mc(String(f)) || "about:invalid#zClosurez");
                f = e + '="' + _.oc(String(f)) + '"';
                b += " " + f
            }
        }
        return b
    }
    ;
    _.xy = function(a, b) {
        if (!sy.test("div"))
            throw Error("j");
        if (vy.indexOf("DIV") !== -1)
            throw Error("j");
        var c = "<div";
        a && (c += uy(a));
        Array.isArray(b) || (b = b === void 0 ? [] : [b]);
        wy.indexOf("DIV") !== -1 ? c += ">" : (a = ry(b.map(function(d) {
            return d instanceof _.Zb ? d : _.oc(String(d))
        })),
        c += ">" + a.toString() + "</div>");
        return _.$b(c)
    }
    ;
    sy = /^[a-z][a-z\d-]*$/i;
    vy = "APPLET BASE EMBED IFRAME LINK MATH META OBJECT SCRIPT STYLE SVG TEMPLATE".split(" ");
    wy = "AREA BR COL COMMAND HR IMG INPUT KEYGEN PARAM SOURCE TRACK WBR".split(" ");
    ty = ["action", "formaction", "href"];
    _.yy = function(a, b) {
        Array.isArray(b) || (b = [b]);
        b = b.map(function(c) {
            return typeof c === "string" ? c : c.Zo + " " + c.duration + "s " + c.timing + " " + c.delay + "s"
        });
        _.Lr(a, "transition", b.join(","))
    }
    ;
    _.zy = function(a) {
        var b = !1, c;
        return function() {
            b || (c = a(),
            b = !0);
            return c
        }
    }(function() {
        var a = _.ee("DIV")
          , b = _.xd ? "-webkit" : _.wd ? "-moz" : null
          , c = "transition:opacity 1s linear;";
        b && (c += b + "-transition:opacity 1s linear;");
        _.Dc(a, _.xy({
            style: c
        }));
        return _.Nr(a.firstChild, "transition") != ""
    });
    _.Ay = function(a, b) {
        _.xj.call(this);
        this.zm = a || 1;
        this.Vw = b || _.ab;
        this.DP = (0,
        _.B)(this.Bga, this);
        this.gW = _.gd()
    }
    ;
    _.hb(_.Ay, _.xj);
    _.g = _.Ay.prototype;
    _.g.enabled = !1;
    _.g.Hc = null;
    _.g.setInterval = function(a) {
        this.zm = a;
        this.Hc && this.enabled ? (this.stop(),
        this.start()) : this.Hc && this.stop()
    }
    ;
    _.g.Bga = function() {
        if (this.enabled) {
            var a = _.gd() - this.gW;
            a > 0 && a < this.zm * .8 ? this.Hc = this.Vw.setTimeout(this.DP, this.zm - a) : (this.Hc && (this.Vw.clearTimeout(this.Hc),
            this.Hc = null),
            this.dispatchEvent("tick"),
            this.enabled && (this.stop(),
            this.start()))
        }
    }
    ;
    _.g.start = function() {
        this.enabled = !0;
        this.Hc || (this.Hc = this.Vw.setTimeout(this.DP, this.zm),
        this.gW = _.gd())
    }
    ;
    _.g.stop = function() {
        this.enabled = !1;
        this.Hc && (this.Vw.clearTimeout(this.Hc),
        this.Hc = null)
    }
    ;
    _.g.ua = function() {
        _.Ay.N.ua.call(this);
        this.stop();
        delete this.Vw
    }
    ;
    _.By = function(a, b, c) {
        if (typeof a === "function")
            c && (a = (0,
            _.B)(a, c));
        else if (a && typeof a.handleEvent == "function")
            a = (0,
            _.B)(a.handleEvent, a);
        else
            throw Error("xa");
        return Number(b) > 2147483647 ? -1 : _.ab.setTimeout(a, b || 0)
    }
    ;
    _.Cy = function(a) {
        _.ab.clearTimeout(a)
    }
    ;
    _.Ny = function() {
        _.My = "oauth2relay" + String(2147483647 * (0,
        _.Dg)() | 0)
    }
    ;
    _.Oy = new _.qy;
    _.Py = new _.py("oauth");
    _.Ny();
    _.Qe("oauth-flow/client_id");
    var Qy = String(_.Qe("oauth-flow/redirectUri"));
    if (Qy)
        Qy.replace(/[#][\s\S]*/, "");
    else {
        var Ry = _.vg.getOrigin(window.location.href);
        _.Qe("oauth-flow/callbackUrl");
        encodeURIComponent(Ry)
    }
    _.vg.getOrigin(window.location.href);
    var Ty, Uy, Vy, Wy, Xy, Yy, Zy, $y, az, bz, cz, ez, fz, gz, hz, iz, jz, kz, lz, mz, nz, oz, pz, qz, rz, sz, tz, uz, vz, wz, xz, yz, zz, Az, Bz, Cz, Dz, Ez, Fz, Gz, Hz, Kz, Jz, Lz, Mz, Nz, Oz, Pz, Qz, Rz, Sz, Tz, Vz;
    _.Sy = function(a, b) {
        if (_.zh && !b)
            return _.ab.atob(a);
        var c = "";
        _.Ch(a, function(d) {
            c += String.fromCharCode(d)
        });
        return c
    }
    ;
    Ty = function(a) {
        var b = String(a("immediate") || "");
        a = String(a("prompt") || "");
        return b === "true" || a === "none"
    }
    ;
    Uy = function(a) {
        return _.Sh("enableMultilogin") && a("cookie_policy") && !Ty(a) ? !0 : !1
    }
    ;
    Xy = function() {
        var a, b = null;
        _.fy.iterate(function(c, d) {
            c.indexOf("G_AUTHUSER_") === 0 && (c = c.substring(11),
            c = _.Vx(c),
            !a || c.jf && !a.jf || c.jf == a.jf && c.Ti > a.Ti) && (a = c,
            b = d)
        });
        return {
            M6: a,
            authuser: b
        }
    }
    ;
    Yy = [".APPS.GOOGLEUSERCONTENT.COM", "@DEVELOPER.GSERVICEACCOUNT.COM"];
    Zy = function(a) {
        a = a.toUpperCase();
        for (var b = Yy.length, c = 0; c < b; ++c) {
            var d = a.split(Yy[c]);
            d.length == 2 && d[1] === "" && (a = d[0])
        }
        a = a.replace(/-/g, "_").toUpperCase();
        a.length > 40 && (b = new _.Cg,
        b.mx(a),
        a = b.Si().toUpperCase());
        return a
    }
    ;
    $y = function(a) {
        if (!a)
            return [];
        a = a.split("=");
        return a[1] ? a[1].split("|") : []
    }
    ;
    az = function(a) {
        a = a.split(":");
        return {
            clientId: a[0].split("=")[1],
            lfa: $y(a[1]),
            ara: $y(a[2]),
            Upa: $y(a[3])
        }
    }
    ;
    bz = function(a) {
        var b = Xy()
          , c = b.M6;
        b = b.authuser;
        var d = a && Zy(a);
        if (b !== null) {
            var e;
            _.fy.iterate(function(h, k) {
                (h = _.Xx(h)) && h.tj && (d && h.k7 != d || h.jf == c.jf && h.Ti == c.Ti && (e = k))
            });
            if (e) {
                var f = az(e);
                a = f && f.lfa[Number(b)];
                f = f && f.clientId;
                if (a)
                    return {
                        authuser: b,
                        Wra: a,
                        clientId: f
                    }
            }
        }
        return null
    }
    ;
    cz = function(a, b) {
        a = _.ji(a);
        if (!a || !b && a.error)
            return null;
        b = Math.floor((new Date).getTime() / 1E3);
        return a.expires_at && b > a.expires_at ? null : a
    }
    ;
    _.dz = function(a, b) {
        if (b) {
            var c = b;
            var d = a
        } else
            typeof a === "string" ? d = a : c = a;
        c ? _.Yv(c, d) : _.Zv(d)
    }
    ;
    ez = function(a) {
        if (!a)
            return null;
        a !== "single_host_origin" && (a = _.xg(a));
        var b = window.location.hostname
          , c = b
          , d = _.Wx;
        if (a !== "single_host_origin") {
            c = a.split("://");
            if (c.length == 2)
                d = c.shift() === "https";
            else
                return _.Lf.log("WARNING invalid cookie_policy: " + a),
                null;
            c = c[0]
        }
        if (c.indexOf(":") !== -1)
            c = b = "";
        else {
            a = "." + c;
            if (b.lastIndexOf(a) !== b.length - a.length)
                return _.Lf.log("Invalid cookie_policy domain: " + c),
                null;
            c = a;
            b = c.split(".").length - 1
        }
        return {
            domain: c,
            jf: d,
            Ti: b
        }
    }
    ;
    fz = function(a) {
        var b = ez(a);
        if (!b)
            return new _.ay("G_USERSTATE_");
        a = ["G_USERSTATE_", _.Wx && b.jf ? "S" : "H", b.Ti].join("");
        var c = _.jy[a];
        c || (c = {
            KI: 63072E3
        },
        _.ye(_.my(b), c),
        c = new _.Yx(a,c),
        _.jy[a] = c,
        b = c.read(),
        typeof b !== "undefined" && b !== null && (document.cookie = a + "=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/",
        c.write(b)));
        return c
    }
    ;
    gz = function(a) {
        var b = fz(a).read();
        a = _.we();
        if (b) {
            b = b.split(":");
            for (var c; c = b.shift(); )
                c = c.split("="),
                a[c[0]] = c[1]
        }
        return a
    }
    ;
    hz = function(a, b, c) {
        var d = gz(b)
          , e = d[a];
        d[a] = "0";
        var f = [];
        _.xm(d, function(k, l) {
            f.push(l + "=" + k)
        });
        var h = f.join(":");
        b = fz(b);
        h ? b.write(h) : b.clear();
        d[a] !== e && c && c()
    }
    ;
    iz = function(a, b) {
        b = gz(b);
        return b[a] == "0" || b[a] == "X"
    }
    ;
    jz = function(a) {
        a = ez(a.g_user_cookie_policy);
        if (!a || a.jf && !_.Wx)
            a = null;
        else {
            var b = ["G_AUTHUSER_", _.Wx && a.jf ? "S" : "H", a.Ti].join("")
              , c = _.iy[b];
            c || (c = new _.fy(b,_.my(a)),
            _.iy[b] = c);
            a = c
        }
        _.Re("googleapis.config/sessionIndex", null);
        a.clear()
    }
    ;
    kz = function(a) {
        return Ty(function(b) {
            return a[b]
        })
    }
    ;
    lz = 0;
    mz = !1;
    nz = [];
    oz = {};
    pz = {};
    qz = null;
    rz = function(a) {
        var b = _.My;
        return function(c) {
            if (this.f == b && this.t == _.Qf.Pn(this.f) && this.origin == _.Qf.ho(this.f))
                return a.apply(this, arguments)
        }
    }
    ;
    sz = function(a) {
        if (a && !decodeURIComponent(a).startsWith("m;/_/scs/"))
            throw Error("za");
    }
    ;
    tz = function(a) {
        var b = _.Ue.Wg
          , c = b(a).jsh;
        if (c != null)
            return sz(c),
            a;
        if (b = String(b().jsh || _.Ge.h || ""))
            sz(b),
            c = (a + "#").indexOf("#"),
            a = a.substr(0, c) + (a.substr(0, c).indexOf("?") !== -1 ? "&" : "?") + "jsh=" + encodeURIComponent(b) + a.substr(c);
        return a
    }
    ;
    uz = function() {
        return !!_.Qe("oauth-flow/usegapi")
    }
    ;
    vz = function(a, b) {
        uz() ? qz.unregister(a) : _.Qf.unregister(a + ":" + b)
    }
    ;
    wz = function(a, b, c) {
        uz() ? qz.register(a, c, _.Lm) : _.Qf.register(a + ":" + b, rz(c))
    }
    ;
    xz = function() {
        Vy.parentNode.removeChild(Vy)
    }
    ;
    yz = function(a) {
        var b = Vy;
        _.yy(b, [{
            Zo: "-webkit-transform",
            duration: 1,
            timing: "ease",
            delay: 0
        }]);
        _.yy(b, [{
            Zo: "transform",
            duration: 1,
            timing: "ease",
            delay: 0
        }]);
        _.By(function() {
            b.style.webkitTransform = "translate3d(0px," + a + "px,0px)";
            b.style.transform = "translate3d(0px," + a + "px,0px)"
        }, 0)
    }
    ;
    zz = function() {
        var a = Wy + 88;
        yz(a);
        Wy = a
    }
    ;
    Az = function() {
        var a = Wy - 88;
        yz(a);
        Wy = a
    }
    ;
    Bz = function(a) {
        var b = a ? zz : Az
          , c = a ? Az : zz;
        a = a ? "-" : "";
        Wy = parseInt(a + 88, 10);
        Vy.style.webkitTransform = "translate3d(0px," + a + 88 + "px,0px)";
        Vy.style.transform = "translate3d(0px," + a + 88 + "px,0px)";
        Vy.style.display = "";
        Vy.style.visibility = "visible";
        b();
        _.By(c, 4E3);
        _.By(xz, 5E3)
    }
    ;
    Cz = function(a) {
        var b = _.Qe("oauth-flow/toast/position");
        b !== "top" && (b = "bottom");
        var c = document.createElement("div");
        Vy = c;
        c.style.cssText = "position:fixed;left:0px;z-index:1000;width:100%;";
        _.Lr(c, "visibility", "hidden");
        _.Lr(c, b, "-40px");
        _.Lr(c, "height", "128px");
        var d = c;
        if (_.ir()) {
            d = document.createElement("div");
            d.style.cssText = "float:left;position:relative;left:50%;";
            c.appendChild(d);
            var e = document.createElement("div");
            e.style.cssText = "float:left;position:relative;left:-50%";
            d.appendChild(e);
            d = e
        }
        e = b == "top" ? "-" : "";
        Wy = parseInt(e + 88, 10);
        Vy.style.webkitTransform = "translate3d(0px," + e + 88 + "px,0px)";
        Vy.style.transform = "translate3d(0px," + e + 88 + "px,0px)";
        e = window;
        try {
            for (; e.parent != e && e.parent.document; )
                e = e.parent
        } catch (f) {}
        e = e.document.body;
        try {
            e.insertBefore(c, e.firstChild)
        } catch (f) {}
        _.Im.openChild({
            url: ":socialhost:/:session_prefix:_/widget/oauthflow/toast",
            queryParams: {
                clientId: a.client_id,
                idToken: a.id_token
            },
            where: d,
            onRestyle: function() {
                b === "top" ? Bz(!0) : Bz(!1)
            }
        })
    }
    ;
    Dz = function(a) {
        var b = _.no()
          , c = b && b.scope;
        b = a && a.scope;
        b = typeof b === "string" ? b.split(" ") : b || [];
        if (c) {
            c = c.split(" ");
            for (var d = 0; d < c.length; ++d) {
                var e = c[d];
                _.vm.call(b, e) == -1 && b.push(e)
            }
            b.length > 0 && (a.scope = b.join(" "))
        }
        return a
    }
    ;
    Ez = function(a, b) {
        var c = null;
        a && b && (c = b.client_id = b.client_id || a.client_id,
        b.scope = b.scope || a.scope,
        b.g_user_cookie_policy = a.cookie_policy,
        b.cookie_policy = b.cookie_policy || a.cookie_policy,
        b.response_type = b.response_type || a.response_type);
        if (b) {
            b.issued_at || (b.issued_at = String(Math.floor((new Date).getTime() / 1E3)));
            var d = parseInt(b.expires_in, 10) || 86400;
            b.error && (d = _.Qe("oauth-flow/errorMaxAge") || 86400);
            b.expires_in = String(d);
            b.expires_at || (b.expires_at = String(Math.floor((new Date).getTime() / 1E3) + d));
            b._aa || b.error || bz(c) != null || !kz(a) || (b._aa = "1");
            a = b.status = {};
            a.google_logged_in = !!b.session_state;
            c = a.signed_in = !!b.access_token;
            a.method = c ? b["g-oauth-window"] ? "PROMPT" : "AUTO" : null
        }
        return b
    }
    ;
    Fz = function(a) {
        a = a && a.id_token;
        if (!a || !a.split(".")[1])
            return null;
        a = (a.split(".")[1] + "...").replace(/^((....)+)\.?\.?\.?$/, "$1");
        a = _.Gf(_.Sy(a, !0));
        if (a === !1)
            throw Error("Aa");
        return a
    }
    ;
    Gz = function(a) {
        return (a = Fz(a)) ? a.sub : null
    }
    ;
    Hz = function(a) {
        a && nz.push(a);
        a = _.My;
        var b = document.getElementById(a)
          , c = (new Date).getTime();
        if (b) {
            if (lz && c - lz < 6E4)
                return;
            var d = _.Qf.Pn(a);
            d && (vz("oauth2relayReady", d),
            vz("oauth2callback", d));
            b.parentNode.removeChild(b);
            if (/Firefox/.test(navigator.userAgent))
                try {
                    window.frames[a] = void 0
                } catch (f) {}
            _.Ny();
            a = _.My
        }
        lz = c;
        var e = String(2147483647 * (0,
        _.Dg)() | 0);
        b = _.Qe("oauth-flow/proxyUrl") || _.Qe("oauth-flow/relayUrl");
        uz() ? qz = _.Im.openChild({
            where: _.Ue.VS(),
            url: b,
            id: a,
            attributes: {
                style: {
                    width: "1px",
                    height: "1px",
                    position: "absolute",
                    top: "-100px",
                    display: "none"
                },
                "aria-hidden": "true"
            },
            dontclear: !0
        }) : (b = [b, "?parent=", encodeURIComponent(_.vg.getOrigin(window.location.href)), "#rpctoken=", e, "&forcesecure=1"].join(""),
        c = _.Ue.VS(),
        d = _.Ue.rQ({
            name: a,
            id: a
        }),
        d.src = tz(b),
        d.style.width = "1px",
        d.style.height = "1px",
        d.style.position = "absolute",
        d.style.top = "-100px",
        d.tabIndex = -1,
        d.setAttribute("aria-hidden", "true"),
        c.appendChild(d),
        _.Qf.Bw(a));
        wz("oauth2relayReady", e, function() {
            vz("oauth2relayReady", e);
            var f = nz;
            if (f !== null) {
                nz = null;
                for (var h = f.length, k = 0; k < h; ++k)
                    f[k]()
            }
        });
        wz("oauth2callback", e, function(f) {
            var h = _.Ue.Wg;
            h = h(f);
            var k = h.state;
            f = k;
            f = f.replace(/\|.*$/, "");
            f = {}.hasOwnProperty.call(pz, f) ? pz[f] : null;
            h.state = f;
            if (h.state != null) {
                f = oz[k];
                delete oz[k];
                k = f && f.key || "token";
                var l = h = Ez(f && f.params, h);
                var m = (m = Gz(l)) ? iz(m, l.cookie_policy) : !1;
                !m && l && (" " + (l.scope || "") + " ").indexOf(" https://www.googleapis.com/auth/plus.login ") >= 0 && _.Qe("isLoggedIn") && (l && l._aa) === "1" && (l._aa = "0",
                mz || (mz = !0,
                Cz(l)));
                _.dz(k, h);
                h = cz(k);
                if (f) {
                    k = f.popup;
                    l = f.after_redirect;
                    if (k && "keep_open" != l)
                        try {
                            k.close()
                        } catch (n) {}
                    f.callback && (f.callback(h),
                    f.callback = null)
                }
            }
        })
    }
    ;
    _.Iz = function(a) {
        nz !== null ? Hz(a) : a && a()
    }
    ;
    Kz = function(a, b) {
        var c = Jz
          , d = Gz(a);
        d && (jz(a),
        hz(d, b, function() {
            if (c) {
                var e = {
                    error: "user_signed_out"
                };
                e.client_id = a.client_id;
                e.g_user_cookie_policy = a.g_user_cookie_policy;
                e.scope = a.scope;
                e.response_type = a.response_type;
                e.session_state = a.session_state;
                e = Ez(null, e);
                c(e)
            }
        }))
    }
    ;
    Jz = function(a) {
        a || (a = cz(void 0, !0));
        a && typeof a === "object" || (a = {
            error: "invalid_request",
            error_description: "no callback data"
        });
        var b = a.error_description;
        b && window.console && (window.console.error(a.error),
        window.console.error(b));
        a.error || (_.Ge.drw = null);
        _.dz(a);
        if (b = a.authuser)
            _.Qe("googleapis.config/sessionIndex"),
            _.Re("googleapis.config/sessionIndex", b);
        _.Oy.bp(_.Py, a);
        return a
    }
    ;
    Lz = ["client_id", "cookie_policy", "response_type"];
    Mz = "client_id response_type login_hint authuser prompt include_granted_scopes after_redirect access_type hl state".split(" ");
    Nz = function(a) {
        var b = _.Pj(a);
        b.session_state && b.session_state.extraQueryParams && (b.authuser = b.session_state.extraQueryParams.authuser);
        b.session_state = null;
        a.expires_at && (b.expires_at = parseInt(a.expires_at / 1E3).toString());
        a.expires_in && (b.expires_in = a.expires_in.toString());
        a.first_issued_at && (b.issued_at = parseInt(a.first_issued_at / 1E3).toString(),
        delete b.first_issued_at);
        _.Yv(b);
        return b
    }
    ;
    Oz = function(a) {
        if (a.include_granted_scopes === void 0) {
            var b = _.Qe("include_granted_scopes");
            a.include_granted_scopes = !!b
        }
    }
    ;
    Pz = function(a) {
        window.console && (typeof window.console.warn === "function" ? window.console.warn(a) : typeof window.console.log === "function" && window.console.log(a))
    }
    ;
    Qz = function(a) {
        var b = a || {}
          , c = {};
        _.Db(Mz, function(d) {
            b[d] != null && (c[d] = b[d])
        });
        a = _.Qe("googleapis/overrideClientId");
        a != null && (c.client_id = a);
        Oz(c);
        typeof b.scope === "string" ? c.scope = b.scope : Array.isArray(b.scope) && (c.scope = b.scope.join(" "));
        b["openid.realm"] != null && (c.openid_realm = b["openid.realm"]);
        b.cookie_policy != null ? c.cookie_policy = b.cookie_policy : b.cookiepolicy != null && (c.cookie_policy = b.cookiepolicy);
        c.login_hint == null && b.user_id != null && (c.login_hint = b.user_id);
        try {
            _.Rw(c.cookie_policy)
        } catch (d) {
            c.cookie_policy && Pz("The cookie_policy configuration: '" + c.cookie_policy + "' is illegal, and thus ignored."),
            delete c.cookie_policy
        }
        b.hd != null && (c.hosted_domain = b.hd);
        c.prompt == null && (b.immediate == 1 || b.immediate == "true" ? c.prompt = "none" : b.approval_prompt == "force" && (c.prompt = "consent"));
        c.prompt == "none" && (c.session_selection = "first_valid");
        c.prompt == "none" && c.access_type == "offline" && delete c.access_type;
        typeof c.authuser === "undefined" && (a = _.Wh(),
        a != null && (c.authuser = a));
        a = b.redirect_uri || _.Qe("oauth-flow/redirectUri");
        a != null && a != "postmessage" && (c.redirect_uri = a);
        c.gsiwebsdk = "shim";
        return c
    }
    ;
    Rz = function(a, b) {
        var c = Qz(a)
          , d = new _.hk(function(e, f) {
            _.xx(c, function(h) {
                var k = h || {};
                _.Db(Lz, function(l) {
                    k[l] == null && (k[l] = c[l])
                });
                !c.include_granted_scopes && a && a.scope && (k.scope = a.scope);
                a && a.state != null && (k.state = a.state);
                k.error ? (c.prompt == "none" && k.error == "user_logged_out" && (k.error = "immediate_failed_user_logged_out"),
                f(k)) : (h = Nz(k),
                h.authuser != null && _.Re("googleapis.config/sessionIndex", h.authuser),
                e(h))
            })
        }
        );
        b && d.then(b, b);
        return d
    }
    ;
    Sz = _.hi.RS;
    Tz = null;
    _.Wz = function(a, b) {
        if (a.approvalprompt !== "force") {
            a = _.Uz(a);
            a.prompt = "none";
            delete a.redirect_uri;
            delete a.approval_prompt;
            delete a.immediate;
            if (b = !b)
                Tz ? (a.client_id !== Tz.client_id && window.console && window.console.log && window.console.log("Ignoring mismatched page-level auth param client_id=" + a.client_id),
                b = !0) : (Tz = a,
                b = !1);
            b || Vz(a)
        }
    }
    ;
    _.Uz = function(a) {
        var b = a.redirecturi || "postmessage"
          , c = _.vc((a.scope || "").replace(/[\s\xa0]+/g, " "));
        b = {
            client_id: a.clientid,
            redirect_uri: b,
            response_type: "code token id_token gsession",
            scope: c
        };
        a.approvalprompt && (b.approval_prompt = a.approvalprompt);
        a.state && (b.state = a.state);
        a.openidrealm && (b["openid.realm"] = a.openidrealm);
        c = a.accesstype == "offline" ? !0 : (c = a.redirecturi) && c != "postmessage";
        c && (b.access_type = "offline");
        a.requestvisibleactions && (b.request_visible_actions = _.vc(a.requestvisibleactions.replace(/[\s\xa0]+/g, " ")));
        a.after_redirect && (b.after_redirect = a.after_redirect);
        a.cookiepolicy && a.cookiepolicy !== "none" && (b.cookie_policy = a.cookiepolicy);
        typeof a.includegrantedscopes != "undefined" && (b.include_granted_scopes = a.includegrantedscopes);
        a.e && (b.e = a.e);
        (a = a.authuser || _.Qe("googleapis.config/sessionIndex")) && (b.authuser = a);
        (a = _.Qe("useoriginassocialhost")) && (b.use_origin_as_socialhost = a);
        return b
    }
    ;
    Vz = function(a) {
        _.$o("waaf0", "signin", "0");
        Rz(a, function(b) {
            _.$o("waaf1", "signin", "0");
            Jz(b)
        })
    }
    ;
    _.Xz = function(a) {
        a = _.Uz(a);
        _.Re("oauth-flow/authWindowWidth", 445);
        _.Re("oauth-flow/authWindowHeight", 615);
        Vz(a)
    }
    ;
    _.Yz = function(a) {
        _.Oy.unsubscribe(_.Py, a);
        _.Oy.subscribe(_.Py, a)
    }
    ;
    var eA, hA;
    _.$z = function(a) {
        return a.cookiepolicy ? !0 : (_.Zz("cookiepolicy is a required field.  See https://developers.google.com/+/web/signin/#button_attr_cookiepolicy for more information."),
        !1)
    }
    ;
    _.Zz = function(a) {
        window.console && (window.console.error ? window.console.error(a) : window.console.log && window.console.log(a))
    }
    ;
    _.dA = function(a, b) {
        var c = _.no();
        _.ye(a, c);
        c = Dz(c);
        if (_.$z(c)) {
            var d = _.aA();
            _.bA(c);
            b ? _.Fe(b, "click", function() {
                _.cA(c, d)
            }) : _.cA(c, d)
        }
    }
    ;
    _.aA = function() {
        var a = new eA;
        _.Yz(function(b) {
            a.LI && b && (b.access_token && _.Re("isPlusUser", !0),
            b["g-oauth-window"] && (a.LI = !1,
            _.Lf.warn("OTA app install is no longer supported.")))
        });
        return a
    }
    ;
    eA = function() {
        this.LI = !1
    }
    ;
    _.bA = function(a) {
        a = _.fA(a);
        _.gA(a.callback);
        _.Iz(function() {
            _.Wz(a)
        })
    }
    ;
    _.fA = function(a) {
        hA(a);
        a.redirecturi && delete a.redirecturi;
        Uy(function(b) {
            return a[b]
        }) || (a.authuser = 0);
        return a
    }
    ;
    hA = function(a) {
        /^\s*$/.test(a.scope || "") && (a.scope = "https://www.googleapis.com/auth/plus.login")
    }
    ;
    _.gA = function(a) {
        if (typeof a === "string")
            if (window[a])
                a = window[a];
            else {
                _.Zz('Callback function named "' + a + '" not found');
                return
            }
        a && _.Yz(a)
    }
    ;
    _.cA = function(a, b) {
        b.LI = !0;
        a = _.fA(a);
        _.Xz(a)
    }
    ;
    _.A("gapi.auth.authorize", Rz);
    _.A("gapi.auth.checkSessionState", function(a, b) {
        var c = _.we();
        c.client_id = a.client_id;
        c.session_state = a.session_state;
        _.Iz(function() {
            uz() ? qz.send("check_session_state", c, function(d) {
                b.call(null, d[0])
            }, _.Lm) : _.Qf.call(_.My, "check_session_state", rz(function(d) {
                b.call(null, d)
            }), c.session_state, c.client_id)
        })
    });
    _.A("gapi.auth.getAuthHeaderValueForFirstParty", Sz);
    _.A("gapi.auth.getToken", cz);
    _.A("gapi.auth.getVersionInfo", function(a, b) {
        _.Iz(function() {
            var c = _.fi() || ""
              , d = null
              , e = null;
            c && (e = c.split(" "),
            e.length == 2 && (d = e[1]));
            d ? uz() ? qz.send("get_versioninfo", {
                xapisidHash: d,
                sessionIndex: b
            }, function(f) {
                a(f[0])
            }, _.Lm) : _.Qf.call(_.My, "get_versioninfo", rz(function(f) {
                a(f)
            }), d, b) : a()
        })
    });
    _.A("gapi.auth.init", _.Iz);
    _.A("gapi.auth.setToken", _.dz);
    _.A("gapi.auth.signIn", function(a) {
        _.dA(a)
    });
    _.A("gapi.auth.signOut", function() {
        var a = cz();
        a && Kz(a, a.cookie_policy)
    });
    _.A("gapi.auth.unsafeUnpackIdToken", Fz);
    _.A("gapi.auth._pimf", _.Wz);
    _.A("gapi.auth._oart", Cz);
    _.A("gapi.auth._guss", function(a) {
        return fz(a).read()
    });
    var iA = _.no();
    iA.clientid && iA.scope && iA.callback && !_.Qe("disableRealtimeCallback") && _.bA(iA);
    var Cx = function() {};
    var Ex;
    Ex = function() {}
    ;
    _.hb(Ex, Cx);
    Ex.prototype.Bt = function() {
        return new XMLHttpRequest
    }
    ;
    _.Dx = new Ex;
    _.Dh = function(a) {
        var b = [], c = 0, d;
        for (d in a)
            b[c++] = d;
        return b
    }
    ;
    _.Eh = function(a) {
        return a == null ? "" : String(a)
    }
    ;
    _.Fh = RegExp("^(?:([^:/?#.]+):)?(?://(?:([^\\\\/?#]*)@)?([^\\\\/?#]*?)(?::([0-9]+))?(?=[\\\\/?#]|$))?([^?#]+)?(?:\\?([^#]*))?(?:#([\\s\\S]*))?$");
    _.Gh = function(a, b) {
        if (!b)
            return a;
        var c = a.indexOf("#");
        c < 0 && (c = a.length);
        var d = a.indexOf("?");
        if (d < 0 || d > c) {
            d = c;
            var e = ""
        } else
            e = a.substring(d + 1, c);
        a = [a.slice(0, d), e, a.slice(c)];
        c = a[1];
        a[1] = b ? c ? c + "&" + b : b : c;
        return a[0] + (a[1] ? "?" + a[1] : "") + a[2]
    }
    ;
    _.Hh = function(a, b, c) {
        if (Array.isArray(b))
            for (var d = 0; d < b.length; d++)
                _.Hh(a, String(b[d]), c);
        else
            b != null && c.push(a + (b === "" ? "" : "=" + encodeURIComponent(String(b))))
    }
    ;
    _.Ih = function(a) {
        var b = [], c;
        for (c in a)
            _.Hh(c, a[c], b);
        return b.join("&")
    }
    ;
    _.Jh = function(a, b) {
        b = _.Ih(b);
        return _.Gh(a, b)
    }
    ;
    var Ei = function(a, b) {
        a = _.Ue.rQ({
            id: a,
            name: a
        });
        a.style.width = "1px";
        a.style.height = "1px";
        a.style.position = "absolute";
        a.style.top = "-100px";
        a.style.display = "none";
        if (window.navigator) {
            var c = window.navigator.userAgent || "";
            var d = window.navigator.product || "";
            c = c.indexOf("Opera") != 0 && c.indexOf("WebKit") == -1 && d == "Gecko" && c.indexOf("rv:1.") > 0
        } else
            c = !1;
        a.src = c ? "about:blank" : b;
        a.tabIndex = -1;
        typeof a.setAttribute === "function" ? a.setAttribute("aria-hidden", "true") : a["aria-hidden"] = "true";
        document.body.appendChild(a);
        c && (a.src = b);
        return a
    };
    _.hi = {
        tU: _.gi,
        Cba: _.di,
        vT: function() {
            var a = null;
            _.di() && (a = window.__PVT,
            a == null && (a = (new _.Xh(document)).get("BEAT")));
            return a
        },
        RS: _.fi
    };
    var Gi, Fi;
    Gi = function() {
        return !!Fi("auth/useFirstPartyAuthV2")
    }
    ;
    Fi = function(a) {
        return _.Qe("googleapis.config/" + a)
    }
    ;
    _.Hi = function(a, b, c) {
        a = a === void 0 ? {} : a;
        b = b === void 0 ? window.location.href : b;
        c = c === void 0 ? "auto" : c;
        if (c == "none")
            return a;
        var d = a.Authorization
          , e = a.OriginToken;
        if (!d && !e) {
            (e = _.ji()) && e.access_token && (c == "oauth2" || c == "auto") && (d = String(e.token_type || "Bearer") + " " + e.access_token);
            if (e = !d)
                e = (!!Fi("auth/useFirstPartyAuth") || c == "1p") && c != "oauth2";
            if (e && _.di()) {
                if (Gi()) {
                    d = Fi("primaryEmail");
                    c = Fi("appDomain");
                    e = Fi("fogId");
                    var f = [];
                    d && f.push({
                        key: "e",
                        value: d
                    });
                    c && f.push({
                        key: "a",
                        value: c
                    });
                    e && f.push({
                        key: "u",
                        value: e
                    });
                    d = _.fi(f)
                } else
                    d = _.fi();
                d && (c = a["X-Goog-AuthUser"],
                b = _.Wh(b),
                b = c || b,
                _.tc(_.Eh(b)) && (!Gi() || Gi() && _.tc(_.Eh(Fi("primaryEmail"))) && _.tc(_.Eh(Fi("appDomain"))) && _.tc(_.Eh(Fi("fogId")))) && (b = "0"),
                _.tc(_.Eh(b)) || (a["X-Goog-AuthUser"] = b))
            }
            d ? a.Authorization = d : Fi("auth/useOriginToken") !== !1 && (e = _.hi.vT()) && (a.OriginToken = e)
        }
        return a
    }
    ;
    _.Ii = function() {
        function a(n, p, q, u, v) {
            var t = f("proxy");
            if (u || !t) {
                t = f("root");
                var y = f("root-1p") || t;
                t = t || "https://content.googleapis.com";
                y = y || "https://clients6.google.com";
                var z = f("xd3") || "/static/proxy.html";
                t = (u || String(p ? y : t)) + z
            }
            t = String(t);
            q && (t += (t.indexOf("?") >= 0 ? "&" : "?") + "usegapi=1");
            (p = _.Ue.Wg().jsh || _.Ge.h) && (t += (t.indexOf("?") >= 0 ? "&" : "?") + "jsh=" + encodeURIComponent(p));
            t += "#parent=" + encodeURIComponent(v != null ? String(v) : _.vg.getOrigin(document.location.href));
            return t + ("&rpctoken=" + n)
        }
        function b(n, p, q, u, v) {
            var t = d(q, u, v);
            k[t] || (q = Ei(t, p),
            _.Qf.register("ready:" + n, function() {
                _.Qf.unregister("ready:" + n);
                if (!l[t]) {
                    l[t] = !0;
                    var y = m[t];
                    m[t] = [];
                    for (var z = 0, C = y.length; z < C; ++z) {
                        var F = y[z];
                        e(F.kp, F.lea, F.callback)
                    }
                }
            }),
            _.Qf.Bw(t, p),
            k[t] = q)
        }
        function c(n, p, q) {
            var u = String(2147483647 * _.Ai() | 0)
              , v = a(u, n, p, q);
            _.Nf(function() {
                b(u, v, n, p, q)
            })
        }
        function d(n, p, q) {
            n = a("", n, p, q, "");
            q = h[n + p];
            if (!q) {
                q = new _.Cg;
                q.mx(n);
                q = q.Si().toLowerCase();
                var u = _.Ai();
                q += u;
                h[n + p] = q
            }
            return "apiproxy" + q
        }
        function e(n, p, q) {
            var u = void 0
              , v = !1;
            if (n !== "makeHttpRequests")
                throw 'only "makeHttpRequests" RPCs are implemented';
            var t = function(H) {
                if (H) {
                    if (typeof u != "undefined" && typeof H.root != "undefined" && u != H.root)
                        throw "all requests in a batch must have the same root URL";
                    u = H.root || u;
                    v = _.hi.tU(H.headers)
                }
            };
            if (p)
                for (var y = 0, z = p.length; y < z; ++y) {
                    var C = p[y];
                    C && t(C.params)
                }
            t = !!f("useGapiForXd3");
            var F = d(v, t, u);
            k[F] || c(v, t, u);
            l[F] ? _.Qf.call(F, n, function(H) {
                if (this.f == F && this.t == _.Qf.Pn(this.f) && this.origin == _.Qf.ho(this.f)) {
                    var L = _.Gf(H);
                    q(L, H)
                }
            }, p) : (m[F] || (m[F] = []),
            m[F].push({
                kp: n,
                lea: p,
                callback: q
            }))
        }
        function f(n) {
            return _.Qe("googleapis.config/" + n)
        }
        var h = {}
          , k = {}
          , l = {}
          , m = {};
        return {
            ipa: function(n, p, q) {
                return _.Hi(n, p, q)
            },
            Xm: e
        }
    }();
    var Lg = {
        yha: "Authorization",
        h2: "Content-ID",
        Wha: "Content-Transfer-Encoding",
        Xha: "Content-Type",
        Fia: "Date",
        wla: "OriginToken",
        Tja: "hotrod-board-name",
        Uja: "hotrod-chrome-cpu-model",
        Vja: "hotrod-chrome-processors",
        hoa: "WWW-Authenticate",
        joa: "X-Ad-Manager-Impersonation",
        ioa: "X-Ad-Manager-Debug-Info",
        loa: "X-ClientDetails",
        moa: "X-Cloudaicompanion-Trace-Id",
        noa: "X-Compass-Routing-Destination",
        qoa: "X-Goog-AuthUser",
        voa: "X-Goog-Encode-Response-If-Executable",
        ooa: "X-Google-Consent",
        poa: "X-Google-EOM",
        xoa: "X-Goog-Meeting-ABR",
        yoa: "X-Goog-Meeting-Botguardid",
        zoa: "X-Goog-Meeting-Bot-Info",
        Aoa: "X-Goog-Meeting-ClientInfo",
        Boa: "X-Goog-Meeting-ClientVersion",
        Coa: "X-Goog-Meeting-Debugid",
        Doa: "X-Goog-Meeting-Identifier",
        Eoa: "X-Goog-Meeting-Interop-Cohorts",
        Foa: "X-Goog-Meeting-Interop-Type",
        Goa: "X-Goog-Meeting-OidcIdToken",
        Hoa: "X-Goog-Meeting-RtcClient",
        Ioa: "X-Goog-Meeting-StartSource",
        Joa: "X-Goog-Meeting-Token",
        Koa: "X-Goog-Meeting-Viewer-Token",
        Loa: "X-Goog-PageId",
        Noa: "X-Goog-Safety-Content-Type",
        Ooa: "X-Goog-Safety-Encoding",
        soa: "X-Goog-Drive-Client-Version",
        toa: "X-Goog-Drive-Resource-Keys",
        Poa: "X-HTTP-Method-Override",
        Qoa: "X-JavaScript-User-Agent",
        Roa: "X-Origin",
        Soa: "X-Referer",
        Toa: "X-Requested-With",
        Woa: "X-Use-HTTP-Status-Code-Override",
        Uoa: "X-Server-Timeout",
        woa: "X-Goog-First-Party-Reauth",
        Voa: "X-Server-Token",
        roa: "x-goog-chat-space-id",
        Moa: "x-goog-pan-request-context",
        koa: "X-AppInt-Credentials",
        uoa: "X-Goog-Earth-Gcp-Project"
    }
      , Mg = "Accept Accept-Language Authorization Cache-Control cast-device-capabilities Content-Disposition Content-Encoding Content-Language Content-Length Content-MD5 Content-Range Content-Transfer-Encoding Content-Type Date developer-token EES-S7E-MODE financial-institution-id GData-Version google-cloud-resource-prefix hotrod-board-name hotrod-chrome-cpu-model hotrod-chrome-processors Host If-Match If-Modified-Since If-None-Match If-Unmodified-Since linked-customer-id login-customer-id MIME-Version Origin OriginToken Pragma Range request-id Slug Transfer-Encoding Want-Digest X-Ad-Manager-Impersonation X-Ad-Manager-Debug-Info x-alkali-account-key x-alkali-application-key x-alkali-auth-apps-namespace x-alkali-auth-entities-namespace x-alkali-auth-entity x-alkali-client-locale x-chrome-connected x-framework-xsrf-token X-Client-Data X-Client-Pctx X-ClientDetails X-Client-Version x-debug-settings-metadata X-Firebase-Locale X-GData-Client X-GData-Key X-Goog-AuthUser X-Goog-PageId X-Goog-Encode-Response-If-Executable X-GoogApps-Allowed-Domains X-Goog-AdX-Buyer-Impersonation X-Goog-Api-Client X-Goog-Api-Key X-Google-EOM X-Goog-Visibilities X-Goog-Correlation-Id X-Goog-Request-Info X-Goog-Request-Reason X-Goog-Request-Time X-Goog-Experiments x-goog-ext-124712974-jspb x-goog-ext-251363160-jspb x-goog-ext-525002765-jspb x-goog-ext-259736195-jspb x-goog-ext-467253834-jspb x-goog-ext-472780938-jspb x-goog-ext-477772811-jspb x-goog-ext-275505673-bin x-goog-ext-353267353-bin x-goog-ext-353267353-jspb x-goog-ext-496773601-bin x-goog-ext-328800237-bin x-goog-ext-359275022-bin x-goog-ext-202735639-bin x-goog-ext-223435598-bin x-goog-ext-174067345-bin x-goog-ext-525001598-jspb x-goog-ext-519733851-bin X-Goog-Firebase-Installations-Auth x-goog-greenenergyuserappservice-metadata X-Firebase-Client X-Firebase-Client-Log-Type X-Firebase-GMPID X-Firebase-Auth-Token X-Firebase-AppCheck X-Firebase-Token X-Goog-Drive-Client-Version X-Goog-Drive-Resource-Keys x-goog-iam-authority-selector x-goog-iam-authorization-token x-goog-request-params x-goog-sherlog-context X-Goog-Sn-Metadata X-Goog-Sn-PatientId X-Goog-Spatula X-Goog-Travel-Bgr X-Goog-Travel-Settings X-Goog-Upload-Command X-Goog-Upload-Content-Disposition X-Goog-Upload-Content-Length X-Goog-Upload-Content-Type X-Goog-Upload-File-Name X-Goog-Upload-Header-Content-Encoding X-Goog-Upload-Header-Content-Length X-Goog-Upload-Header-Content-Type X-Goog-Upload-Header-Transfer-Encoding X-Goog-Upload-Offset X-Goog-Upload-Protocol X-Goog-User-Project X-Goog-Visitor-Id X-Goog-FieldMask X-Google-Project-Override x-goog-maps-api-salt x-goog-maps-api-signature x-goog-maps-client-id x-goog-maps-channel-id x-goog-maps-solution-id x-goog-maps-session-id x-goog-gmp-client-signals x-goog-spanner-database-role X-HTTP-Method-Override X-JavaScript-User-Agent X-Pan-Versionid X-Proxied-User-IP X-Origin X-Referer X-Requested-With X-Stadia-Client-Context X-Upload-Content-Length X-Upload-Content-Type X-Use-Alt-Service X-Use-HTTP-Status-Code-Override X-Ios-Bundle-Identifier X-Places-Ios-Sdk X-Android-Package X-Android-Cert X-Places-Android-Sdk X-Goog-Maps-Ios-Uuid X-Goog-Maps-Android-Uuid X-Ariane-Xsrf-Token X-Earth-Engine-App-ID-Token X-Earth-Engine-Computation-Profile X-Earth-Engine-Computation-Profiling X-Play-Console-Experiments-Override X-Play-Console-Session-Id X-YouTube-Bootstrap-Logged-In X-Youtube-Client-Version X-Youtube-Lava-Device-Context X-YouTube-VVT X-YouTube-Page-CL X-YouTube-Page-Label X-YouTube-Page-Timestamp X-Compass-Routing-Destination X-Goog-Meeting-ABR X-Goog-Meeting-Botguardid X-Goog-Meeting-Bot-Info X-Goog-Meeting-ClientInfo X-Goog-Meeting-ClientVersion X-Goog-Meeting-Debugid X-Goog-Meeting-Identifier X-Goog-Meeting-Interop-Cohorts X-Goog-Meeting-Interop-Type X-Goog-Meeting-OidcIdToken X-Goog-Meeting-RtcClient X-Goog-Meeting-StartSource X-Goog-Meeting-Token X-Goog-Meeting-Viewer-Token x-sdm-id-token X-Sfdc-Authorization X-Server-Timeout x-foyer-client-environment X-Goog-First-Party-Reauth X-Server-Token x-rfui-request-context x-goog-chat-space-id x-goog-nest-jwt X-Cloud-Trace-Context traceparent x-goog-pan-request-context X-AppInt-Credentials X-Goog-Earth-Gcp-Project".split(" ")
      , Ng = "Digest Cache-Control Content-Disposition Content-Encoding Content-Language Content-Length Content-MD5 Content-Range Content-Transfer-Encoding Content-Type Date ETag Expires Last-Modified Location Pragma Range Server Transfer-Encoding WWW-Authenticate Vary Unzipped-Content-MD5 X-Correlation-ID X-Debug-Tracking-Id X-Google-Consent X-Google-EOM X-Goog-Generation X-Goog-Metageneration X-Goog-Safety-Content-Type X-Goog-Safety-Encoding X-Google-Trace X-Goog-Upload-Chunk-Granularity X-Goog-Upload-Control-URL X-Goog-Upload-Size-Received X-Goog-Upload-Status X-Goog-Upload-URL X-Goog-Diff-Download-Range X-Goog-Hash X-Goog-Updated-Authorization X-Server-Object-Version X-Guploader-Customer X-Guploader-Upload-Result X-Guploader-Uploadid X-Google-Gfe-Backend-Request-Cost X-Earth-Engine-Computation-Profile X-Cloudaicompanion-Trace-Id X-Goog-Meeting-ABR X-Goog-Meeting-Botguardid X-Goog-Meeting-Bot-Info X-Goog-Meeting-ClientInfo X-Goog-Meeting-ClientVersion X-Goog-Meeting-Debugid X-Goog-Meeting-Identifier X-Goog-Meeting-RtcClient X-Goog-Meeting-Token X-Goog-Meeting-Viewer-Token X-Compass-Routing-Destination".split(" ");
    var Og, Pg, Qg, Rg, Tg, Ug, Vg, Wg, Xg, Yg, Zg, $g;
    Og = null;
    Pg = null;
    Qg = null;
    Rg = function(a, b) {
        var c = a.length;
        if (c != b.length)
            return !1;
        for (var d = 0; d < c; ++d) {
            var e = a.charCodeAt(d)
              , f = b.charCodeAt(d);
            e >= 65 && e <= 90 && (e += 32);
            f >= 65 && f <= 90 && (f += 32);
            if (e != f)
                return !1
        }
        return !0
    }
    ;
    _.Sg = function(a) {
        a = String(a || "").split("\x00").join("");
        for (var b = [], c = !0, d = a.length, e = 0; e < d; ++e) {
            var f = a.charAt(e)
              , h = a.charCodeAt(e);
            if (h >= 55296 && h <= 56319 && e + 1 < d) {
                var k = a.charAt(e + 1)
                  , l = a.charCodeAt(e + 1);
                l >= 56320 && l <= 57343 && (f += k,
                h = 65536 + (h - 55296 << 10) + (l - 56320),
                ++e)
            }
            if (!(h >= 0 && h <= 1114109) || h >= 55296 && h <= 57343 || h >= 64976 && h <= 65007 || (h & 65534) == 65534)
                h = 65533,
                f = String.fromCharCode(h);
            k = !(h >= 32 && h <= 126) || f == " " || c && f == ":" || f == "\\";
            !c || f != "/" && f != "?" || (c = !1);
            f == "%" && (e + 2 >= d ? k = !0 : (l = 16 * parseInt(a.charAt(e + 1), 16) + parseInt(a.charAt(e + 2), 16),
            l >= 0 && l <= 255 ? (h = l,
            f = h == 0 ? "" : "%" + (256 + l).toString(16).toUpperCase().substr(1),
            e += 2) : k = !0));
            k && (f = encodeURIComponent(f),
            f.length <= 1 && (h >= 0 && h <= 127 ? f = "%" + (256 + h).toString(16).toUpperCase().substr(1) : (h = 65533,
            f = encodeURIComponent(String.fromCharCode(h)))));
            b.push(f)
        }
        a = b.join("");
        a = a.split("#")[0];
        a = a.split("?");
        b = a[0].split("/");
        c = [];
        d = b.length;
        for (e = 0; e < d; ++e)
            f = b[e],
            h = f.split("%2E").join("."),
            h = h.split(encodeURIComponent("\uff0e")).join("."),
            h == "." ? e + 1 == d && c.push("") : h == ".." ? (c.length > 0 && c.pop(),
            e + 1 == d && c.push("")) : c.push(f);
        a[0] = c.join("/");
        for (a = a.join("?"); a && a.charAt(0) == "/"; )
            a = a.substr(1);
        return "/" + a
    }
    ;
    Tg = {
        "access-control-allow-origin": !0,
        "access-control-allow-credentials": !0,
        "access-control-expose-headers": !0,
        "access-control-max-age": !0,
        "access-control-allow-headers": !0,
        "access-control-allow-methods": !0,
        p3p: !0,
        "proxy-authenticate": !0,
        "set-cookie": !0,
        "set-cookie2": !0,
        status: !0,
        tsv: !0,
        "": !0
    };
    Ug = {
        "accept-charset": !0,
        "accept-encoding": !0,
        "access-control-request-headers": !0,
        "access-control-request-method": !0,
        "client-ip": !0,
        clientip: !0,
        connection: !0,
        "content-length": !0,
        cookie: !0,
        cookie2: !0,
        date: !0,
        dnt: !0,
        expect: !0,
        forwarded: !0,
        "forwarded-for": !0,
        "front-end-https": !0,
        host: !0,
        "keep-alive": !0,
        "max-forwards": !0,
        method: !0,
        origin: !0,
        "raw-post-data": !0,
        referer: !0,
        te: !0,
        trailer: !0,
        "transfer-encoding": !0,
        upgrade: !0,
        url: !0,
        "user-agent": !0,
        version: !0,
        via: !0,
        "x-att-deviceid": !0,
        "x-chrome-connected": !0,
        "x-client-data": !0,
        "x-client-ip": !0,
        "x-do-not-track": !0,
        "x-forwarded-by": !0,
        "x-forwarded-for": !0,
        "x-forwarded-host": !0,
        "x-forwarded-proto": !0,
        "x-geo": !0,
        "x-googapps-allowed-domains": !0,
        "x-origin": !0,
        "x-proxyuser-ip": !0,
        "x-real-ip": !0,
        "x-referer": !0,
        "x-uidh": !0,
        "x-user-ip": !0,
        "x-wap-profile": !0,
        "": !0
    };
    Vg = function(a) {
        if (!_.fd(a))
            return null;
        for (var b = {}, c = 0; c < a.length; c++) {
            var d = a[c];
            if (typeof d === "string" && d) {
                var e = d.toLowerCase();
                Rg(d, e) && (b[e] = d)
            }
        }
        for (var f in Lg)
            Object.prototype.hasOwnProperty.call(Lg, f) && (a = Lg[f],
            c = a.toLowerCase(),
            Rg(a, c) && Object.prototype.hasOwnProperty.call(b, c) && (b[c] = a));
        return b
    }
    ;
    Wg = new RegExp("(" + /[\t -~\u00A0-\u2027\u202A-\uD7FF\uE000-\uFFFF]/.source + "|" + /[\uD800-\uDBFF][\uDC00-\uDFFF]/.source + "){1,100}","g");
    Xg = /[ \t]*(\r?\n[ \t]+)+/g;
    Yg = /^[ \t]+|[ \t]+$/g;
    Zg = function(a, b) {
        if (!b && typeof a === "object" && a && typeof a.length === "number") {
            b = a;
            a = "";
            for (var c = b.length, d = 0; d < c; ++d) {
                var e = Zg(b[d], !0);
                e && (a && (e = a + ", " + e),
                a = e)
            }
        }
        if (typeof a === "string" && (a = a.replace(Xg, " "),
        a = a.replace(Yg, ""),
        a.replace(Wg, "") == "" && a))
            return a
    }
    ;
    $g = /^[-0-9A-Za-z!#\$%&'\*\+\.\^_`\|~]+$/g;
    _.ah = function(a) {
        if (typeof a !== "string" || !a || !a.match($g))
            return null;
        a = a.toLowerCase();
        if (Qg == null) {
            var b = []
              , c = _.Qe("googleapis/headers/response");
            c && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            (c = _.Qe("client/headers/response")) && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            b = b.concat(Ng);
            (c = _.Qe("googleapis/headers/request")) && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            (c = _.Qe("client/headers/request")) && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            b = b.concat(Mg);
            for (var d in Lg)
                Object.prototype.hasOwnProperty.call(Lg, d) && b.push(Lg[d]);
            Qg = Vg(b)
        }
        return Qg != null && Qg.hasOwnProperty(a) ? Qg[a] : a
    }
    ;
    _.bh = function(a, b) {
        if (!_.ah(a) || !Zg(b))
            return null;
        a = a.toLowerCase();
        if (a.match(/^x-google|^x-gfe|^proxy-|^sec-/i) || Ug[a])
            return null;
        if (Og == null) {
            b = [];
            var c = _.Qe("googleapis/headers/request");
            c && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            (c = _.Qe("client/headers/request")) && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            b = b.concat(Mg);
            Og = Vg(b)
        }
        return Og != null && Og.hasOwnProperty(a) ? Og[a] : null
    }
    ;
    _.ch = function(a, b) {
        if (!_.ah(a) || !Zg(b))
            return null;
        a = a.toLowerCase();
        if (Tg[a])
            return null;
        if (Pg == null) {
            b = [];
            var c = _.Qe("googleapis/headers/response");
            c && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            (c = _.Qe("client/headers/response")) && typeof c === "object" && typeof c.length === "number" || (c = null);
            c != null && (b = b.concat(c));
            b = b.concat(Ng);
            Pg = Vg(b)
        }
        return Pg != null && Pg.hasOwnProperty(a) ? a : null
    }
    ;
    _.dh = function(a, b) {
        if (_.ah(b) && a != null && typeof a === "object") {
            var c = void 0, d;
            for (d in a)
                if (Object.prototype.hasOwnProperty.call(a, d) && Rg(d, b)) {
                    var e = Zg(a[d]);
                    e && (c !== void 0 && (e = c + ", " + e),
                    c = e)
                }
            return c
        }
    }
    ;
    _.eh = function(a, b, c, d) {
        var e = _.ah(b);
        if (e) {
            c && (c = Zg(c));
            b = b.toLowerCase();
            for (var f in a)
                Object.prototype.hasOwnProperty.call(a, f) && Rg(f, b) && delete a[f];
            c && (d || (b = e),
            a[b] = c)
        }
    }
    ;
    _.fh = function(a, b) {
        var c = {};
        if (!a)
            return c;
        a = a.split("\r\n");
        for (var d = a.length, e = 0; e < d; ++e) {
            var f = a[e];
            if (!f)
                break;
            var h = f.indexOf(":");
            if (!(h <= 0)) {
                var k = f.substring(0, h);
                if (k = _.ah(k)) {
                    for (f = f.substring(h + 1); e + 1 < d && a[e + 1].match(/^[ \t]/); )
                        f += "\r\n" + a[e + 1],
                        ++e;
                    if (f = Zg(f))
                        if (k = _.ch(k, f) || (b ? void 0 : k))
                            k = k.toLowerCase(),
                            h = _.dh(c, k),
                            h !== void 0 && (f = h + ", " + f),
                            _.eh(c, k, f, !0)
                }
            }
        }
        return c
    }
    ;
    /\uffff/.test("\uffff");
    var Gx;
    _.Fx = function(a) {
        var b = 0, c;
        for (c in a)
            b++;
        return b
    }
    ;
    Gx = function(a, b) {
        var c = [];
        for (b = b || 0; b < a.length; b += 2)
            _.Hh(a[b], a[b + 1], c);
        return c.join("&")
    }
    ;
    _.Hx = function(a, b) {
        var c = arguments.length == 2 ? Gx(arguments[1], 0) : Gx(arguments, 1);
        return _.Gh(a, c)
    }
    ;
    _.Ix = function(a, b) {
        _.vj(a, "/") && (a = a.slice(0, -1));
        _.sc(b, "/") && (b = b.slice(1));
        return a + "/" + b
    }
    ;
    _.Jx = function(a) {
        switch (a) {
        case 200:
        case 201:
        case 202:
        case 204:
        case 206:
        case 304:
        case 1223:
            return !0;
        default:
            return !1
        }
    }
    ;
    var Lx, Mx, Nx;
    _.Kx = function(a) {
        _.xj.call(this);
        this.headers = new Map;
        this.E1 = a || null;
        this.Zf = !1;
        this.Va = null;
        this.ZA = "";
        this.jr = 0;
        this.Co = this.NH = this.zA = this.NF = !1;
        this.Es = 0;
        this.Rc = null;
        this.Sm = "";
        this.Ah = !1;
        this.CE = this.tN = null
    }
    ;
    _.hb(_.Kx, _.xj);
    _.Kx.prototype.Bb = null;
    Lx = /^https?$/i;
    Mx = ["POST", "PUT"];
    Nx = [];
    _.Ox = function(a, b, c, d, e, f, h) {
        var k = new _.Kx;
        Nx.push(k);
        b && k.na("complete", b);
        k.qr("ready", k.f7);
        f && k.dD(f);
        h && (k.Ah = h);
        k.send(a, c, d, e)
    }
    ;
    _.g = _.Kx.prototype;
    _.g.f7 = function() {
        this.dispose();
        _.Qi(Nx, this)
    }
    ;
    _.g.dD = function(a) {
        this.Es = Math.max(0, a)
    }
    ;
    _.g.setTrustToken = function(a) {
        this.tN = a
    }
    ;
    _.g.setAttributionReporting = function(a) {
        this.CE = a
    }
    ;
    _.g.send = function(a, b, c, d) {
        if (this.Va)
            throw Error("ua`" + this.ZA + "`" + a);
        b = b ? b.toUpperCase() : "GET";
        this.ZA = a;
        this.jr = 0;
        this.NF = !1;
        this.Zf = !0;
        this.Va = this.E1 ? this.E1.Bt() : _.Dx.Bt();
        this.Va.onreadystatechange = (0,
        _.Yj)((0,
        _.B)(this.uX, this));
        try {
            this.NH = !0,
            this.Va.open(b, String(a), !0),
            this.NH = !1
        } catch (h) {
            this.dz(5, h);
            return
        }
        a = c || "";
        c = new Map(this.headers);
        if (d)
            if (Object.getPrototypeOf(d) === Object.prototype)
                for (var e in d)
                    c.set(e, d[e]);
            else if (typeof d.keys === "function" && typeof d.get === "function") {
                e = _.Aa(d.keys());
                for (var f = e.next(); !f.done; f = e.next())
                    f = f.value,
                    c.set(f, d.get(f))
            } else
                throw Error("va`" + String(d));
        d = Array.from(c.keys()).find(function(h) {
            return "content-type" == h.toLowerCase()
        });
        e = _.ab.FormData && a instanceof _.ab.FormData;
        !_.ub(Mx, b) || d || e || c.set("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        b = _.Aa(c);
        for (d = b.next(); !d.done; d = b.next())
            c = _.Aa(d.value),
            d = c.next().value,
            c = c.next().value,
            this.Va.setRequestHeader(d, c);
        this.Sm && (this.Va.responseType = this.Sm);
        "withCredentials"in this.Va && this.Va.withCredentials !== this.Ah && (this.Va.withCredentials = this.Ah);
        if ("setTrustToken"in this.Va && this.tN)
            try {
                this.Va.setTrustToken(this.tN)
            } catch (h) {}
        if ("setAttributionReporting"in this.Va && this.CE)
            try {
                this.Va.setAttributionReporting(this.CE)
            } catch (h) {}
        try {
            this.Rc && (clearTimeout(this.Rc),
            this.Rc = null),
            this.Es > 0 && (this.Rc = setTimeout(this.Ji.bind(this), this.Es)),
            this.zA = !0,
            this.Va.send(a),
            this.zA = !1
        } catch (h) {
            this.dz(5, h)
        }
    }
    ;
    _.g.Ji = function() {
        typeof _.Za != "undefined" && this.Va && (this.jr = 8,
        this.dispatchEvent("timeout"),
        this.abort(8))
    }
    ;
    _.g.dz = function(a) {
        this.Zf = !1;
        this.Va && (this.Co = !0,
        this.Va.abort(),
        this.Co = !1);
        this.jr = a;
        Px(this);
        Qx(this)
    }
    ;
    var Px = function(a) {
        a.NF || (a.NF = !0,
        a.dispatchEvent("complete"),
        a.dispatchEvent("error"))
    };
    _.Kx.prototype.abort = function(a) {
        this.Va && this.Zf && (this.Zf = !1,
        this.Co = !0,
        this.Va.abort(),
        this.Co = !1,
        this.jr = a || 7,
        this.dispatchEvent("complete"),
        this.dispatchEvent("abort"),
        Qx(this))
    }
    ;
    _.Kx.prototype.ua = function() {
        this.Va && (this.Zf && (this.Zf = !1,
        this.Co = !0,
        this.Va.abort(),
        this.Co = !1),
        Qx(this, !0));
        _.Kx.N.ua.call(this)
    }
    ;
    _.Kx.prototype.uX = function() {
        this.isDisposed() || (this.NH || this.zA || this.Co ? Rx(this) : this.rJ())
    }
    ;
    _.Kx.prototype.rJ = function() {
        Rx(this)
    }
    ;
    var Rx = function(a) {
        if (a.Zf && typeof _.Za != "undefined")
            if (a.zA && _.Sx(a) == 4)
                setTimeout(a.uX.bind(a), 0);
            else if (a.dispatchEvent("readystatechange"),
            _.Sx(a) == 4) {
                a.Zf = !1;
                try {
                    a.ir() ? (a.dispatchEvent("complete"),
                    a.dispatchEvent("success")) : (a.jr = 6,
                    a.getStatus(),
                    Px(a))
                } finally {
                    Qx(a)
                }
            }
    }
      , Qx = function(a, b) {
        if (a.Va) {
            a.Rc && (clearTimeout(a.Rc),
            a.Rc = null);
            var c = a.Va;
            a.Va = null;
            b || a.dispatchEvent("ready");
            try {
                c.onreadystatechange = null
            } catch (d) {}
        }
    };
    _.Kx.prototype.isActive = function() {
        return !!this.Va
    }
    ;
    _.Kx.prototype.ir = function() {
        var a = this.getStatus(), b;
        if (!(b = _.Jx(a))) {
            if (a = a === 0)
                a = String(this.ZA).match(_.Fh)[1] || null,
                !a && _.ab.self && _.ab.self.location && (a = _.ab.self.location.protocol.slice(0, -1)),
                a = !Lx.test(a ? a.toLowerCase() : "");
            b = a
        }
        return b
    }
    ;
    _.Sx = function(a) {
        return a.Va ? a.Va.readyState : 0
    }
    ;
    _.Kx.prototype.getStatus = function() {
        try {
            return _.Sx(this) > 2 ? this.Va.status : -1
        } catch (a) {
            return -1
        }
    }
    ;
    _.Tx = function(a) {
        try {
            return a.Va ? a.Va.responseText : ""
        } catch (b) {
            return ""
        }
    }
    ;
    _.Ux = function(a) {
        try {
            if (!a.Va)
                return null;
            if ("response"in a.Va)
                return a.Va.response;
            switch (a.Sm) {
            case "":
            case "text":
                return a.Va.responseText;
            case "arraybuffer":
                if ("mozResponseArrayBuffer"in a.Va)
                    return a.Va.mozResponseArrayBuffer
            }
            return null
        } catch (b) {
            return null
        }
    }
    ;
    _.Kx.prototype.getResponseHeader = function(a) {
        if (this.Va && _.Sx(this) == 4)
            return a = this.Va.getResponseHeader(a),
            a === null ? void 0 : a
    }
    ;
    _.Kx.prototype.getAllResponseHeaders = function() {
        return this.Va && _.Sx(this) >= 2 ? this.Va.getAllResponseHeaders() || "" : ""
    }
    ;
    _.Wi(function(a) {
        _.Kx.prototype.rJ = a(_.Kx.prototype.rJ)
    });
    var Kt, Pt;
    _.Gt = function(a, b) {
        var c = _.fd(b)
          , d = c ? b : arguments;
        for (c = c ? 0 : 1; c < d.length; c++) {
            if (a == null)
                return;
            a = a[d[c]]
        }
        return a
    }
    ;
    _.Ht = function(a) {
        if (!a || typeof a !== "object")
            return a;
        if (typeof a.clone === "function")
            return a.clone();
        if (typeof Map !== "undefined" && a instanceof Map)
            return new Map(a);
        if (typeof Set !== "undefined" && a instanceof Set)
            return new Set(a);
        if (a instanceof Date)
            return new Date(a.getTime());
        var b = Array.isArray(a) ? [] : typeof ArrayBuffer !== "function" || typeof ArrayBuffer.isView !== "function" || !ArrayBuffer.isView(a) || a instanceof DataView ? {} : new a.constructor(a.length), c;
        for (c in a)
            b[c] = _.Ht(a[c]);
        return b
    }
    ;
    _.It = function() {
        return Math.floor(Math.random() * 2147483648).toString(36) + Math.abs(Math.floor(Math.random() * 2147483648) ^ _.gd()).toString(36)
    }
    ;
    _.Jt = function(a, b, c) {
        return _.de(document, arguments)
    }
    ;
    Kt = function(a, b) {
        if (a) {
            a = a.split("&");
            for (var c = 0; c < a.length; c++) {
                var d = a[c].indexOf("=")
                  , e = null;
                if (d >= 0) {
                    var f = a[c].substring(0, d);
                    e = a[c].substring(d + 1)
                } else
                    f = a[c];
                b(f, e ? decodeURIComponent(e.replace(/\+/g, " ")) : "")
            }
        }
    }
    ;
    _.Lt = function(a, b, c) {
        for (var d = 0, e = b.length; (d = a.indexOf(b, d)) >= 0 && d < c; ) {
            var f = a.charCodeAt(d - 1);
            if (f == 38 || f == 63)
                if (f = a.charCodeAt(d + e),
                !f || f == 61 || f == 38 || f == 35)
                    return d;
            d += e + 1
        }
        return -1
    }
    ;
    _.Mt = /#|$/;
    _.Nt = function(a) {
        if (a.ef && typeof a.ef == "function")
            return a.ef();
        if (typeof Map !== "undefined" && a instanceof Map || typeof Set !== "undefined" && a instanceof Set)
            return Array.from(a.values());
        if (typeof a === "string")
            return a.split("");
        if (_.fd(a)) {
            for (var b = [], c = a.length, d = 0; d < c; d++)
                b.push(a[d]);
            return b
        }
        return _.vb(a)
    }
    ;
    _.Ot = function(a) {
        if (a.mg && typeof a.mg == "function")
            return a.mg();
        if (!a.ef || typeof a.ef != "function") {
            if (typeof Map !== "undefined" && a instanceof Map)
                return Array.from(a.keys());
            if (!(typeof Set !== "undefined" && a instanceof Set)) {
                if (_.fd(a) || typeof a === "string") {
                    var b = [];
                    a = a.length;
                    for (var c = 0; c < a; c++)
                        b.push(c);
                    return b
                }
                return _.Dh(a)
            }
        }
    }
    ;
    Pt = function(a, b, c) {
        if (a.forEach && typeof a.forEach == "function")
            a.forEach(b, c);
        else if (_.fd(a) || typeof a === "string")
            Array.prototype.forEach.call(a, b, c);
        else
            for (var d = _.Ot(a), e = _.Nt(a), f = e.length, h = 0; h < f; h++)
                b.call(c, e[h], d && d[h], a)
    }
    ;
    var bu, Xt, fu, Yt, $t, Zt, cu, au, gu;
    _.Qt = function(a, b) {
        this.Zd = this.zh = this.Di = "";
        this.Fg = null;
        this.jG = this.Lm = "";
        this.Yg = !1;
        var c;
        a instanceof _.Qt ? (this.Yg = b !== void 0 ? b : a.Yg,
        _.Rt(this, a.Di),
        _.St(this, a.zh),
        _.Tt(this, a.Sg()),
        _.Ut(this, a.Fg),
        this.setPath(a.getPath()),
        _.Vt(this, a.Sd.clone()),
        this.Tk(a.Dz())) : a && (c = String(a).match(_.Fh)) ? (this.Yg = !!b,
        _.Rt(this, c[1] || "", !0),
        _.St(this, c[2] || "", !0),
        _.Tt(this, c[3] || "", !0),
        _.Ut(this, c[4]),
        this.setPath(c[5] || "", !0),
        _.Vt(this, c[6] || "", !0),
        this.Tk(c[7] || "", !0)) : (this.Yg = !!b,
        this.Sd = new _.Wt(null,this.Yg))
    }
    ;
    _.Qt.prototype.toString = function() {
        var a = []
          , b = this.Di;
        b && a.push(Xt(b, Yt, !0), ":");
        var c = this.Sg();
        if (c || b == "file")
            a.push("//"),
            (b = this.zh) && a.push(Xt(b, Yt, !0), "@"),
            a.push(encodeURIComponent(String(c)).replace(/%25([0-9a-fA-F]{2})/g, "%$1")),
            c = this.Fg,
            c != null && a.push(":", String(c));
        if (c = this.getPath())
            this.Zd && c.charAt(0) != "/" && a.push("/"),
            a.push(Xt(c, c.charAt(0) == "/" ? Zt : $t, !0));
        (c = this.Sd.toString()) && a.push("?", c);
        (c = this.Dz()) && a.push("#", Xt(c, au));
        return a.join("")
    }
    ;
    _.Qt.prototype.resolve = function(a) {
        var b = this.clone()
          , c = !!a.Di;
        c ? _.Rt(b, a.Di) : c = !!a.zh;
        c ? _.St(b, a.zh) : c = !!a.Zd;
        c ? _.Tt(b, a.Sg()) : c = a.Fg != null;
        var d = a.getPath();
        if (c)
            _.Ut(b, a.Fg);
        else if (c = !!a.Lm) {
            if (d.charAt(0) != "/")
                if (this.Zd && !this.Lm)
                    d = "/" + d;
                else {
                    var e = b.getPath().lastIndexOf("/");
                    e != -1 && (d = b.getPath().slice(0, e + 1) + d)
                }
            e = d;
            if (e == ".." || e == ".")
                d = "";
            else if (_.uc(e, "./") || _.uc(e, "/.")) {
                d = _.sc(e, "/");
                e = e.split("/");
                for (var f = [], h = 0; h < e.length; ) {
                    var k = e[h++];
                    k == "." ? d && h == e.length && f.push("") : k == ".." ? ((f.length > 1 || f.length == 1 && f[0] != "") && f.pop(),
                    d && h == e.length && f.push("")) : (f.push(k),
                    d = !0)
                }
                d = f.join("/")
            } else
                d = e
        }
        c ? b.setPath(d) : c = a.Sq();
        c ? _.Vt(b, a.Sd.clone()) : c = !!a.jG;
        c && b.Tk(a.Dz());
        return b
    }
    ;
    _.Qt.prototype.clone = function() {
        return new _.Qt(this)
    }
    ;
    _.Rt = function(a, b, c) {
        a.Di = c ? bu(b, !0) : b;
        a.Di && (a.Di = a.Di.replace(/:$/, ""));
        return a
    }
    ;
    _.St = function(a, b, c) {
        a.zh = c ? bu(b) : b;
        return a
    }
    ;
    _.Qt.prototype.Sg = function() {
        return this.Zd
    }
    ;
    _.Tt = function(a, b, c) {
        a.Zd = c ? bu(b, !0) : b;
        return a
    }
    ;
    _.Ut = function(a, b) {
        if (b) {
            b = Number(b);
            if (isNaN(b) || b < 0)
                throw Error("M`" + b);
            a.Fg = b
        } else
            a.Fg = null;
        return a
    }
    ;
    _.Qt.prototype.getPath = function() {
        return this.Lm
    }
    ;
    _.Qt.prototype.setPath = function(a, b) {
        this.Lm = b ? bu(a, !0) : a;
        return this
    }
    ;
    _.Qt.prototype.Sq = function() {
        return this.Sd.toString() !== ""
    }
    ;
    _.Vt = function(a, b, c) {
        b instanceof _.Wt ? (a.Sd = b,
        a.Sd.BL(a.Yg)) : (c || (b = Xt(b, cu)),
        a.Sd = new _.Wt(b,a.Yg));
        return a
    }
    ;
    _.Qt.prototype.Za = function(a, b) {
        return _.Vt(this, a, b)
    }
    ;
    _.Qt.prototype.getQuery = function() {
        return this.Sd.toString()
    }
    ;
    _.du = function(a, b, c) {
        a.Sd.set(b, c);
        return a
    }
    ;
    _.g = _.Qt.prototype;
    _.g.Ug = function(a) {
        return this.Sd.get(a)
    }
    ;
    _.g.Dz = function() {
        return this.jG
    }
    ;
    _.g.Tk = function(a, b) {
        this.jG = b ? bu(a) : a;
        return this
    }
    ;
    _.g.removeParameter = function(a) {
        this.Sd.remove(a);
        return this
    }
    ;
    _.g.BL = function(a) {
        this.Yg = a;
        this.Sd && this.Sd.BL(a)
    }
    ;
    _.eu = function(a, b) {
        return a instanceof _.Qt ? a.clone() : new _.Qt(a,b)
    }
    ;
    bu = function(a, b) {
        return a ? b ? decodeURI(a.replace(/%25/g, "%2525")) : decodeURIComponent(a) : ""
    }
    ;
    Xt = function(a, b, c) {
        return typeof a === "string" ? (a = encodeURI(a).replace(b, fu),
        c && (a = a.replace(/%25([0-9a-fA-F]{2})/g, "%$1")),
        a) : null
    }
    ;
    fu = function(a) {
        a = a.charCodeAt(0);
        return "%" + (a >> 4 & 15).toString(16) + (a & 15).toString(16)
    }
    ;
    Yt = /[#\/\?@]/g;
    $t = /[#\?:]/g;
    Zt = /[#\?]/g;
    cu = /[#\?@]/g;
    au = /#/g;
    _.Wt = function(a, b) {
        this.Be = this.Kc = null;
        this.lg = a || null;
        this.Yg = !!b
    }
    ;
    gu = function(a) {
        a.Kc || (a.Kc = new Map,
        a.Be = 0,
        a.lg && Kt(a.lg, function(b, c) {
            a.add(decodeURIComponent(b.replace(/\+/g, " ")), c)
        }))
    }
    ;
    _.g = _.Wt.prototype;
    _.g.Yb = function() {
        gu(this);
        return this.Be
    }
    ;
    _.g.add = function(a, b) {
        gu(this);
        this.lg = null;
        a = hu(this, a);
        var c = this.Kc.get(a);
        c || this.Kc.set(a, c = []);
        c.push(b);
        this.Be += 1;
        return this
    }
    ;
    _.g.remove = function(a) {
        gu(this);
        a = hu(this, a);
        return this.Kc.has(a) ? (this.lg = null,
        this.Be -= this.Kc.get(a).length,
        this.Kc.delete(a)) : !1
    }
    ;
    _.g.clear = function() {
        this.Kc = this.lg = null;
        this.Be = 0
    }
    ;
    _.g.isEmpty = function() {
        gu(this);
        return this.Be == 0
    }
    ;
    _.g.Dl = function(a) {
        gu(this);
        a = hu(this, a);
        return this.Kc.has(a)
    }
    ;
    _.g.forEach = function(a, b) {
        gu(this);
        this.Kc.forEach(function(c, d) {
            c.forEach(function(e) {
                a.call(b, e, d, this)
            }, this)
        }, this)
    }
    ;
    _.g.mg = function() {
        gu(this);
        for (var a = Array.from(this.Kc.values()), b = Array.from(this.Kc.keys()), c = [], d = 0; d < b.length; d++)
            for (var e = a[d], f = 0; f < e.length; f++)
                c.push(b[d]);
        return c
    }
    ;
    _.g.ef = function(a) {
        gu(this);
        var b = [];
        if (typeof a === "string")
            this.Dl(a) && (b = b.concat(this.Kc.get(hu(this, a))));
        else {
            a = Array.from(this.Kc.values());
            for (var c = 0; c < a.length; c++)
                b = b.concat(a[c])
        }
        return b
    }
    ;
    _.g.set = function(a, b) {
        gu(this);
        this.lg = null;
        a = hu(this, a);
        this.Dl(a) && (this.Be -= this.Kc.get(a).length);
        this.Kc.set(a, [b]);
        this.Be += 1;
        return this
    }
    ;
    _.g.get = function(a, b) {
        if (!a)
            return b;
        a = this.ef(a);
        return a.length > 0 ? String(a[0]) : b
    }
    ;
    _.g.setValues = function(a, b) {
        this.remove(a);
        b.length > 0 && (this.lg = null,
        this.Kc.set(hu(this, a), _.Rb(b)),
        this.Be += b.length)
    }
    ;
    _.g.toString = function() {
        if (this.lg)
            return this.lg;
        if (!this.Kc)
            return "";
        for (var a = [], b = Array.from(this.Kc.keys()), c = 0; c < b.length; c++) {
            var d = b[c]
              , e = encodeURIComponent(String(d));
            d = this.ef(d);
            for (var f = 0; f < d.length; f++) {
                var h = e;
                d[f] !== "" && (h += "=" + encodeURIComponent(String(d[f])));
                a.push(h)
            }
        }
        return this.lg = a.join("&")
    }
    ;
    _.g.clone = function() {
        var a = new _.Wt;
        a.lg = this.lg;
        this.Kc && (a.Kc = new Map(this.Kc),
        a.Be = this.Be);
        return a
    }
    ;
    var hu = function(a, b) {
        b = String(b);
        a.Yg && (b = b.toLowerCase());
        return b
    };
    _.Wt.prototype.BL = function(a) {
        a && !this.Yg && (gu(this),
        this.lg = null,
        this.Kc.forEach(function(b, c) {
            var d = c.toLowerCase();
            c != d && (this.remove(c),
            this.setValues(d, b))
        }, this));
        this.Yg = a
    }
    ;
    _.Wt.prototype.extend = function(a) {
        for (var b = 0; b < arguments.length; b++)
            Pt(arguments[b], function(c, d) {
                this.add(d, c)
            }, this)
    }
    ;
    var kA = function(a) {
        if (!a || typeof a !== "function")
            throw new jA("Must provide a function.");
        this.Gg = null;
        this.n8 = a
    }, lA = !1, xA, yA, zA, AA, BA, CA, DA, EA, FA, GA, HA, IA, JA, KA, LA;
    lA = !1;
    var mA = function(a) {
        return new _.hk(function(b) {
            var c = a.length
              , d = [];
            if (c)
                for (var e = function(k, l, m) {
                    c--;
                    d[k] = l ? {
                        oz: !0,
                        value: m
                    } : {
                        oz: !1,
                        reason: m
                    };
                    c == 0 && b(d)
                }, f, h = 0; h < a.length; h++)
                    f = a[h],
                    _.ok(f, _.fb(e, h, !0), _.fb(e, h, !1));
            else
                b(d)
        }
        )
    }, nA, oA, pA, qA = {
        yP: function(a) {
            nA = a;
            try {
                delete qA.yP
            } catch (b) {}
        },
        zP: function(a) {
            oA = a;
            try {
                delete qA.zP
            } catch (b) {}
        },
        AP: function(a) {
            pA = a;
            try {
                delete qA.AP
            } catch (b) {}
        }
    }, rA = function(a) {
        return _.Jx(a.status)
    }, sA = function() {
        var a = !0
          , b = _.Dx.Bt();
        b && b.withCredentials !== void 0 || (a = !1);
        return a
    }, tA = function(a, b) {
        if (b == null)
            return b;
        b = String(b);
        b.match(/^\/\/.*/) && (b = (window.location.protocol == "http:" ? "http:" : "https:") + b);
        b.match(/^\/([^\/].*)?$/) && window.location.host && String(window.location.protocol).match(/^https?:$/) && (b = window.location.protocol + "//" + window.location.host + b);
        var c = b.match(/^(https?:)(\/\/)?(\/([^\/].*)?)?$/i);
        c && window.location.host && String(window.location.protocol).match(/^https?:$/) && (b = c[1] + "//" + window.location.host + (c[3] || ""));
        b = b.replace(/^(https?:\/\/[^\/?#@]*)\/$/i, "$1");
        b = b.replace(/^(http:\/\/[-_a-z0-9.]+):0*80([\/?#].*)?$/i, "$1$2");
        b = b.replace(/^(https:\/\/[-_a-z0-9.]+):0*443([\/?#].*)?$/i, "$1$2");
        b.match(/^https?:\/\/[-_a-z0-9.]*[-_a-z][-_a-z0-9.]*$/i) && (b = b.toLowerCase());
        c = _.Qe("client/rewrite");
        _.wb(c) && Object.prototype.hasOwnProperty.call(c, b) ? b = String(c[b] || b) : (b = b.replace(/^(https?):\/\/www\.googleapis\.com$/, "$1://content.googleapis.com"),
        b = b.replace(/^(https?):\/\/www-(googleapis-[-_a-z0-9]+\.[-_a-z0-9]+\.google\.com)$/, "$1://content-$2"),
        b.match(/^https?:\/\/content(-[-_a-z0-9.]+)?\.googleapis\.com$/) || (b = b.replace(/^(https?):\/\/([-_a-z0-9]+(\.[-_a-z0-9]+)?\.googleapis\.com)$/, "$1://content-$2")));
        a && (a = _.Qe("client/firstPartyRewrite"),
        _.wb(a) && Object.prototype.hasOwnProperty.call(a, b) ? b = String(a[b] || b) : (b = b.replace(/^(https?):\/\/content\.googleapis\.com$/, "$1://clients6.google.com"),
        b = b.replace(/^(https?):\/\/content-([-a-z0-9]+)\.([-a-z0-9]+)\.googleapis\.com$/, "$1://$2-googleapis.$3.google.com"),
        b = b.replace(/^(https?):\/\/content-([-a-z0-9]+)\.googleapis\.com$/, "$1://$2.clients6.google.com"),
        b = b.replace(/^(https?):\/\/([-a-z0-9]+)-www-googleapis\.([-a-z0-9]+).google.com$/, "$1://content-googleapis-$2.$3.google.com")));
        return b
    }, jA = function(a) {
        _.lb.call(this, a)
    };
    _.r(jA, _.lb);
    jA.prototype.name = "gapix.client.GapiClientError";
    kA.prototype.then = function(a, b, c) {
        this.Gg || (this.Gg = this.n8());
        return this.Gg.then(a, b, c)
    }
    ;
    kA.prototype.UC = function(a) {
        this.Gg || (this.Gg = a)
    }
    ;
    var uA = function(a) {
        var b = {}, c;
        for (c in a)
            if (Object.prototype.hasOwnProperty.call(a, c)) {
                var d = _.dh(a, c);
                d && (c = _.ch(c, d)) && _.eh(b, c, d, !0)
            }
        return b
    }
      , vA = {
        error: {
            code: -1,
            message: "A network error occurred and the request could not be completed."
        }
    }
      , wA = function(a, b, c, d) {
        _.Kx.call(this);
        this.Id = a;
        this.QI = b;
        this.Nd = c;
        a = {};
        if (d)
            for (var e in d)
                Object.prototype.hasOwnProperty.call(d, e) && (b = _.dh(d, e),
                b !== void 0 && (e = _.bh(e, b)) && _.eh(a, e, b));
        d = {};
        for (var f in a)
            Object.prototype.hasOwnProperty.call(a, f) && (d[unescape(encodeURIComponent(f))] = unescape(encodeURIComponent(a[f])));
        this.Ru = d;
        this.Gg = null
    };
    _.r(wA, _.Kx);
    wA.prototype.then = function(a) {
        this.Gg || (this.Gg = (new _.hk(function(b, c) {
            this.na("error", (0,
            _.B)(function() {
                c(xA(this))
            }, this));
            this.na("success", (0,
            _.B)(function() {
                b(xA(this))
            }, this));
            this.send(this.Id, this.QI, this.Nd, this.Ru)
        }
        ,this)).then(function(b) {
            b.headers = uA(b.headers);
            return b
        }, function(b) {
            return b.status ? (b.headers = uA(b.headers),
            _.mk(b)) : _.mk({
                result: vA,
                body: '{"error":{"code":-1,"message":"A network error occurred and the request could not be completed."}}',
                headers: null,
                status: null,
                statusText: null
            })
        }));
        return this.Gg.then.apply(this.Gg, arguments)
    }
    ;
    xA = function(a) {
        var b = a.getStatus()
          , c = _.Tx(a);
        var d = b == 204 ? !1 : a.Sm == "" ? _.Gf(c) : _.Ux(a);
        var e = a.getAllResponseHeaders();
        e = _.fh(e, !1);
        try {
            var f = _.Sx(a) > 2 ? a.Va.statusText : ""
        } catch (h) {
            f = ""
        }
        return {
            result: d,
            body: c,
            headers: e,
            status: b,
            statusText: f
        }
    }
    ;
    yA = /;\s*charset\s*=\s*("utf-?8"|utf-?8)\s*(;|$)/i;
    zA = /^(text\/[^\s;\/""]+|application\/(json(\+[^\s;\/""]*)?|([^\s;\/""]*\+)?xml))\s*(;|$)/i;
    AA = /;\s*charset\s*=/i;
    BA = /(([\r\n]{0,2}[A-Za-z0-9+\/]){4,4}){0,1024}([\r\n]{0,2}[A-Za-z0-9+\/][\r\n]{0,2}[AQgw]([\r\n]{0,2}=){2,2}|([\r\n]{0,2}[A-Za-z0-9+\/]){2,2}[\r\n]{0,2}[AEIMQUYcgkosw048][\r\n]{0,2}=|([\r\n]{0,2}[A-Za-z0-9+\/]){4,4})[\r\n]{0,2}/g;
    CA = function(a) {
        var b = [];
        a = a.replace(BA, function(c) {
            b.push(_.Sy(c));
            return ""
        });
        if (a.length)
            throw Error("wa");
        return b.join("")
    }
    ;
    DA = function(a) {
        var b = a.headers;
        if (b && _.dh(b, "X-Goog-Safety-Encoding") === "base64") {
            var c = CA(a.body)
              , d = _.dh(b, "X-Goog-Safety-Content-Type");
            b["Content-Type"] = d;
            if (d.match(yA) || d.match(zA) && !d.match(AA))
                c = _.Wv(_.wh(c));
            _.eh(b, "X-Goog-Safety-Encoding");
            _.eh(b, "X-Goog-Safety-Content-Type");
            a.body = c
        }
    }
    ;
    EA = function(a, b, c) {
        c || ((c = _.Qe("googleapis.config/proxy")) && (c = String(c).replace(/\/static\/proxy\.html$/, "") || "/"),
        c = String(c || ""));
        c || (c = _.Qe("googleapis.config/root"),
        b && (c = _.Qe("googleapis.config/root-1p") || c),
        c = String(c || ""));
        c = String(tA(b, c) || c);
        return a = _.Ix(c, a)
    }
    ;
    FA = function(a, b) {
        var c = a.params || _.we();
        c.url = c.path;
        var d = c.root;
        d = EA("/", _.gi(c.headers), d);
        d.match(/^(.*[^\/])?\/$/) && (d = d.substr(0, d.length - 1));
        c.root = d;
        a.params = c;
        _.Ii.Xm("makeHttpRequests", [a], function(e, f) {
            e && e.gapiRequest ? (e.gapiRequest.data ? DA(e.gapiRequest.data) : DA(e),
            b(e, _.Hf(e))) : b(e, f)
        })
    }
    ;
    GA = function(a) {
        var b = _.Gt(a, "params", "headers");
        b && typeof b === "object" || (b = {});
        a = {};
        for (var c in b)
            if (Object.prototype.hasOwnProperty.call(b, c)) {
                var d = _.dh(b, c);
                d && (_.bh(c, d),
                _.eh(a, c, d))
            }
        c = (window.location.href.match(_.Fh)[1] || null) == "chrome-extension";
        a = _.gi(a);
        return !(c && a) && sA()
    }
    ;
    HA = function(a) {
        return new _.hk(function(b, c) {
            var d = function(e) {
                e && e.gapiRequest ? e = e.gapiRequest.data || e : c(e);
                e = {
                    result: e.status != 204 && _.Gf(e.body),
                    body: e.body,
                    headers: e.headers || null,
                    status: e.status || null,
                    statusText: e.statusText || null
                };
                rA(e) ? b(e) : c(e)
            };
            try {
                FA(a, d)
            } catch (e) {
                c(e)
            }
        }
        )
    }
    ;
    IA = function(a) {
        var b = !_.Qe("client/cors") || !!_.Qe("client/xd4")
          , c = {};
        _.xm(a, function(d, e) {
            (d = _.bh(e, d)) || b || (d = _.ah(e));
            d && (e = _.dh(a, d)) && _.eh(c, d, e)
        });
        return c
    }
    ;
    JA = function(a) {
        var b = a.params || _.we();
        a = _.Pj(b.headers || {});
        var c = b.httpMethod || "GET"
          , d = String(b.url || "")
          , e = encodeURIComponent("$unique");
        if (!(c === "POST" || _.Lt(d, "$unique", d.search(_.Mt)) >= 0 || _.Lt(d, e, d.search(_.Mt)) >= 0)) {
            var f = [];
            for (h in a)
                Object.prototype.hasOwnProperty.call(a, h) && f.push(h.toLowerCase());
            f.sort();
            f.push(_.xg(location.href));
            var h = f.join(":");
            f = _.$h();
            f.update(h);
            h = f.Si().toLowerCase().substr(0, 7);
            h = String(parseInt(h, 16) % 1E3 + 1E3).substr(1);
            d = _.Hx(d, e, "gc" + h)
        }
        e = b.body || null;
        h = b.responseType || null;
        b = _.gi(a) || b.authType == "1p";
        f = !!_.Qe("googleapis.config/auth/useUberProxyAuth") || !!_.Qe("client/withCredentials");
        _.eh(a, "X-Referer");
        a = IA(a);
        var k = new wA(d,c,e,a);
        k.Ah = b || f;
        h && (k.Sm = h);
        return new _.hk(function(l, m) {
            k.then(function(n) {
                DA(n);
                l(n)
            }, function(n) {
                m(n)
            })
        }
        )
    }
    ;
    KA = function(a, b) {
        var c = function(d) {
            d = _.Pj(d);
            delete d.result;
            d = {
                gapiRequest: {
                    data: d
                }
            };
            b && b(d, _.Hf(d))
        };
        JA(a).then(c, c)
    }
    ;
    LA = function(a, b) {
        (_.Qe("client/cors") || _.Qe("client/xd4")) && GA(a) ? (_.ri(_.qi(), 12).Ab(),
        KA(a, b)) : (_.ri(_.qi(), 11).Ab(),
        FA(a, b))
    }
    ;
    _.MA = {};
    var NA = function(a) {
        this.dw = a;
        this.Zf = !1;
        this.promise = {
            then: (0,
            _.B)(function(b, c, d) {
                this.Zf || (this.Zf = !0);
                this.cw && !this.Zv ? this.dw.resolve(this.cw) : this.Zv && !this.cw && this.dw.reject(this.Zv);
                return this.dw.promise.then(b, c, d)
            }, this)
        }
    };
    NA.prototype.resolve = function(a) {
        this.Zf ? this.dw.resolve(a) : this.cw || this.Zv || (this.cw = a)
    }
    ;
    NA.prototype.reject = function(a) {
        this.Zf ? this.dw.reject(a) : this.cw || this.Zv || (this.Zv = a)
    }
    ;
    var OA = function(a) {
        a = _.Ht(a.error);
        return {
            code: a.code,
            data: a.errors,
            message: a.message
        }
    }
      , PA = function(a) {
        throw Error("Ba`" + a);
    };
    var QA = function(a) {
        kA.call(this, QA.prototype.Yo);
        if (!a || typeof a != "object" && typeof a != "string")
            throw new jA("Missing required parameters");
        if (typeof a === "string") {
            var b = {};
            b.path = a
        } else
            b = a;
        if (!b.path)
            throw new jA('Missing required parameter: "path"');
        this.mh = {};
        this.mh.path = b.path;
        this.mh.method = b.method || "GET";
        this.mh.params = b.params || {};
        this.mh.headers = b.headers || {};
        this.mh.body = b.body;
        this.mh.root = b.root;
        this.mh.responseType = b.responseType;
        this.mh.apiId = b.apiId;
        this.tn = b.authType || "auto";
        this.Lba = !!b.isXd4;
        this.BV = !1;
        this.Fj(this.tn);
        this.WY = !1
    };
    _.r(QA, kA);
    QA.prototype.If = function() {
        return this.mh
    }
    ;
    QA.prototype.Fj = function(a) {
        this.tn = a;
        this.BV = this.tn === "1p"
    }
    ;
    QA.prototype.Fq = function() {
        return this.BV
    }
    ;
    QA.prototype.Aj = function() {
        if (!this.WY) {
            this.WY = !0;
            var a = this.mh
              , b = a.headers = a.headers || {}
              , c = []
              , d = [];
            for (h in b)
                if (Object.prototype.hasOwnProperty.call(b, h)) {
                    c.push(h);
                    var e = h
                      , f = _.dh(b, e);
                    f && (e = _.bh(e, f) || _.ah(e)) && d.push([e, f])
                }
            var h = 0;
            for (e = c.length; h < e; ++h)
                delete b[c[h]];
            c = 0;
            for (h = d.length; c < h; ++c)
                _.eh(b, d[c][0], d[c][1]);
            if (this.Lba)
                d = this.tn == "1p";
            else {
                d = b;
                c = String(_.Qe("client/version", "1.1.0"));
                h = String(_.Qe("client/name", "google-api-javascript-client"));
                h = RA[h] === !0 ? h : "google-api-javascript-client";
                e = String(_.Qe("client/appName", ""));
                f = [];
                e && (f.push(e),
                f.push(" "));
                f.push(h);
                c && (f.push("/"),
                f.push(c));
                _.eh(d, "X-JavaScript-User-Agent", f.join(""));
                _.eh(b, "X-Requested-With", "XMLHttpRequest");
                d = _.dh(b, "Content-Type");
                a.body && !d && _.eh(b, "Content-Type", "application/json");
                _.Qe("client/allowExecutableResponse") || _.eh(b, "X-Goog-Encode-Response-If-Executable", "base64");
                (d = _.dh(b, "Content-Type")) && d.toLowerCase() == "application/json" && !a.params.alt && (a.params.alt = "json");
                (d = a.body || null) && _.wb(d) && (a.body = _.Hf(d));
                a.key = a.id;
                b = _.Hi(b, void 0, this.tn);
                d = _.gi(b);
                if ((c = b) && window.navigator) {
                    h = [];
                    for (e = 0; e < SA.length; e++)
                        (f = window.navigator[SA[e]]) && h.push(encodeURIComponent(SA[e]) + "=" + encodeURIComponent(f));
                    _.eh(c, "X-ClientDetails", h.join("&"))
                }
                (c = _.Qe("client/apiKey")) && a.params.key === void 0 && (a.params.key = c);
                (c = _.Qe("client/trace")) && !a.params.trace && (a.params.trace = c)
            }
            this.tn == "auto" && (d ? this.Fj("1p") : (b = _.dh(b, "Authorization")) && String(b).match(/^(Bearer|MAC)[ \t]/i) ? this.Fj("oauth2") : this.Fj("none"));
            if ((b = String(a.path || "").match(/^(https?:\/\/[^\/?#]+)([\/?#].*)?$/i)) && !a.root)
                if (a.root = String(b[1]),
                a.path = String(b[2] || "/"),
                a.path.match(/^\/_ah\/api(\/.*)?$/))
                    a.root += "/_ah/api",
                    a.path = a.path.substr(8);
                else {
                    b = _.Qe("googleapis.config/root");
                    d && (b = _.Qe("googleapis.config/root-1p") || b);
                    b = String(b || "");
                    c = a.root + a.path;
                    if (h = b && c.substr(0, b.length) === b)
                        h = _.eu(b),
                        e = _.eu(c),
                        h = (!h.Zd && !e.Zd || h.Sg() == e.Sg()) && (h.Fg == null && e.Fg == null || h.Fg == e.Fg);
                    h && (a.path = c.substr(b.length),
                    a.root = b)
                }
            b = a.params;
            c = _.Sg(a.path);
            h = String(_.Qe("googleapis.config/xd3") || "");
            h.length >= 18 && h.substring(h.length - 18) == "/static/proxy.html" && (h = h.substring(0, h.length - 18));
            h || (h = "/");
            e = _.Sg(h);
            if (h != e)
                throw Error("x");
            h.charAt(h.length - 1) != "/" && (h += "/");
            c = _.Ix(h, c);
            _.vj(c, "/") && (c = c.substring(0, c.length - 1));
            h = _.we();
            for (var k in b)
                Object.prototype.hasOwnProperty.call(b, k) && (e = encodeURIComponent(k),
                h[e] = b[k]);
            c = _.Jh(c, h);
            a.path = c;
            a.root = tA(!!d, a.root);
            a.url = EA(a.path, !!d, a.root)
        }
    }
    ;
    var TA = function(a) {
        a.Aj();
        var b = a.mh;
        return {
            key: "gapiRequest",
            params: {
                id: b.id,
                key: b.key,
                url: b.url,
                path: b.path,
                httpMethod: b.method,
                body: b.body || "",
                headers: b.headers || {},
                urlParams: {},
                root: b.root,
                authType: a.tn
            }
        }
    };
    _.g = QA.prototype;
    _.g.execute = function(a) {
        var b = TA(this);
        LA(b, function(c, d) {
            var e = c;
            c.gapiRequest && (e = c.gapiRequest);
            e && e.data && (e = e.data);
            c = e;
            c = c instanceof Array ? c[0] : c;
            if (c.status != 204 && c.body)
                try {
                    var f = _.Gf(c.body)
                } catch (h) {}
            a && a(f, d)
        })
    }
    ;
    _.g.Yo = function() {
        var a = TA(this);
        (_.Qe("client/cors") || _.Qe("client/xd4")) && GA(a) ? (_.ri(_.qi(), 15).Ab(),
        a = JA(a)) : (_.ri(_.qi(), 14).Ab(),
        a = HA(a));
        return a
    }
    ;
    _.g.ej = function() {
        return this.Yo()
    }
    ;
    _.g.De = function() {
        return this.mh.root
    }
    ;
    _.g.Bv = function() {
        console.log("makeJsonRpc is not supported for this request.");
        return {}
    }
    ;
    _.g.getFormat = function() {
        return 0
    }
    ;
    var SA = ["appVersion", "platform", "userAgent"]
      , RA = {
        "google-api-gwt-client": !0,
        "google-api-javascript-client": !0
    };
    QA.prototype.execute = QA.prototype.execute;
    QA.prototype.then = QA.prototype.then;
    QA.prototype.getPromise = QA.prototype.ej;
    var UA = function(a) {
        if (!a || typeof a != "object")
            throw new jA("Missing rpc parameters");
        if (!a.method)
            throw new jA("Missing rpc method");
        this.lC = a
    };
    _.g = UA.prototype;
    _.g.De = function() {
        var a = this.lC.transport;
        return a ? a.root || null : null
    }
    ;
    _.g.execute = function(a) {
        var b = oA();
        b.add(this, {
            id: "gapiRpc",
            callback: this.zv(a)
        });
        b.execute()
    }
    ;
    _.g.Bv = function(a) {
        var b = this.lC.method, c = String, d;
        (d = this.lC.apiVersion) || (d = String(b).split(".")[0],
        d = _.Qe("googleapis.config/versions/" + b) || _.Qe("googleapis.config/versions/" + d) || "v1",
        d = String(d));
        a = {
            jsonrpc: "2.0",
            id: a,
            method: b,
            apiVersion: c(d)
        };
        (b = this.lC.rpcParams) && (a.params = b);
        return a
    }
    ;
    _.g.zv = function(a) {
        return function(b, c) {
            if (b)
                if (b.error) {
                    var d = b.error;
                    d.error == null && (d.error = _.Pj(b.error))
                } else
                    d = b.result || b.data,
                    _.wb(d) && d.result == null && (d.result = _.Pj(b.result || b.data));
            else
                d = !1;
            a(d, c)
        }
    }
    ;
    _.g.then = function() {
        throw PA('The "then" method is not available on this object.');
    }
    ;
    _.g.UC = function() {}
    ;
    _.g.If = function() {}
    ;
    _.g.Aj = function() {}
    ;
    _.g.Fj = function() {}
    ;
    _.g.Fq = function() {}
    ;
    _.g.ej = function() {}
    ;
    UA.prototype.execute = UA.prototype.execute;
    var WA = function(a, b) {
        this.Ze = b || 0;
        this.Ze == 2 ? (b = null,
        a != null && _.wb(a) && (b = {},
        b.method = a.method,
        b.rpcParams = a.rpcParams,
        b.transport = a.transport,
        b.root = a.root,
        b.apiVersion = a.apiVersion,
        b.authType = a.authType),
        this.Rb = new UA(b)) : (this.Ze == 0 && (b = a && a.callback) && (a.callback = VA(b)),
        b = null,
        a != null && (_.wb(a) ? (b = {},
        b.path = a.path,
        b.method = a.method,
        b.params = a.params,
        b.headers = a.headers,
        b.body = a.body,
        b.root = a.root,
        b.responseType = a.responseType,
        b.authType = a.authType,
        b.apiId = a.apiId) : typeof a === "string" && (b = a)),
        this.Rb = new QA(b))
    }
      , VA = function(a) {
        return function(b) {
            if (b != null && _.wb(b) && b.error) {
                var c = OA(b);
                b = _.Hf([{
                    id: "gapiRpc",
                    error: c
                }]);
                c.error = _.Ht(c)
            } else
                b == null && (b = {}),
                c = _.Ht(b),
                c.result = _.Ht(b),
                b = _.Hf([{
                    id: "gapiRpc",
                    result: b
                }]);
            a(c, b)
        }
    };
    _.g = WA.prototype;
    _.g.getFormat = function() {
        return this.Ze
    }
    ;
    _.g.execute = function(a) {
        this.Rb.execute(a && this.Ze == 1 ? VA(a) : a)
    }
    ;
    _.g.then = function(a, b, c) {
        return this.Rb.then(a, b, c)
    }
    ;
    _.g.UC = function(a) {
        this.Rb.UC(a)
    }
    ;
    _.g.If = function() {
        return this.Rb.If()
    }
    ;
    _.g.Aj = function() {
        this.Rb.Aj()
    }
    ;
    _.g.De = function() {
        return this.Rb.De()
    }
    ;
    _.g.Bv = function(a) {
        if (this.Rb.Bv)
            return this.Rb.Bv(a)
    }
    ;
    _.g.Fj = function(a) {
        this.Rb.Fj(a)
    }
    ;
    _.g.Fq = function() {
        return !!this.Rb.Fq()
    }
    ;
    _.g.ej = function() {
        return this.Rb.ej()
    }
    ;
    WA.prototype.execute = WA.prototype.execute;
    WA.prototype.then = WA.prototype.then;
    WA.prototype.getPromise = WA.prototype.ej;
    var XA = /<response-(.*)>/
      , YA = /^application\/http(;.+$|$)/
      , ZA = ["clients6.google.com", "content.googleapis.com", "www.googleapis.com"]
      , $A = function(a, b) {
        a = _.dh(a, b);
        if (!a)
            throw new jA("Unable to retrieve header.");
        return a
    }
      , aB = function(a) {
        var b = void 0;
        a = _.Aa(a);
        for (var c = a.next(); !c.done; c = a.next()) {
            c = c.value.If().apiId;
            if (typeof c !== "string")
                return "batch";
            if (b === void 0)
                b = c;
            else if (b != c)
                return "batch"
        }
        b = _.Qe("client/batchPath/" + b) || "batch/" + b.split(":").join("/");
        return String(b)
    }
      , bB = function(a) {
        a = a.map(function(b) {
            return b.request
        });
        return aB(a)
    }
      , cB = function(a, b) {
        var c = [];
        a = a.If();
        var d = function(f, h) {
            _.xm(f, function(k, l) {
                h.push(l + ": " + k)
            })
        }
          , e = {
            "Content-Type": "application/http",
            "Content-Transfer-Encoding": "binary"
        };
        e["Content-ID"] = "<" + b + ">";
        d(e, c);
        c.push("");
        c.push(a.method + " " + a.path);
        d(a.headers, c);
        c.push("");
        a.body && c.push(a.body);
        return c.join("\r\n")
    }
      , fB = function(a, b) {
        a = dB(a, b);
        var c = {};
        _.Sb(a, function(d, e) {
            c[e] = eB(d, e)
        });
        return c
    }
      , eB = function(a, b) {
        return {
            result: a.result || a.body,
            rawResult: _.Hf({
                id: b,
                result: a.result || a.body
            }),
            id: b
        }
    }
      , dB = function(a, b) {
        a = _.vc(a);
        _.vj(a, "--") && (a = a.substring(0, a.length - 2));
        a = a.split(b);
        b = _.we();
        for (var c = 0; c < a.length; c++)
            if (a[c]) {
                var d;
                if (d = a[c]) {
                    _.vj(d, "\r\n") && (d = d.substring(0, d.length - 2));
                    if (d) {
                        d = d.split("\r\n");
                        for (var e = 0, f = {
                            headers: {},
                            body: ""
                        }; e < d.length && d[e] == ""; )
                            e++;
                        for (f.outerHeaders = gB(d, e); e < d.length && d[e] != ""; )
                            e++;
                        e++;
                        var h = d[e++].split(" ");
                        f.status = Number(h[1]);
                        f.statusText = h.slice(2).join(" ");
                        for (f.headers = gB(d, e); e < d.length && d[e] != ""; )
                            e++;
                        e++;
                        f.body = d.slice(e).join("\r\n");
                        DA(f);
                        d = f
                    } else
                        d = null;
                    e = _.we();
                    f = $A(d.outerHeaders, "Content-Type");
                    if (YA.exec(f) == null)
                        throw new jA("Unexpected Content-Type <" + f + ">");
                    f = $A(d.outerHeaders, "Content-ID");
                    f = XA.exec(f);
                    if (!f)
                        throw new jA("Unable to recognize Content-Id.");
                    e.id = decodeURIComponent(f[1].split("@")[0].replace(/^.*[+]/, ""));
                    e.response = {
                        status: d.status,
                        statusText: d.statusText,
                        headers: d.headers
                    };
                    d.status != 204 && (e.response.body = d.body,
                    e.response.result = _.Gf(d.body));
                    d = e
                } else
                    d = null;
                d && d.id && (b[d.id] = d.response)
            }
        return b
    }
      , gB = function(a, b) {
        for (var c = []; b < a.length && a[b]; b++)
            c.push(a[b]);
        return _.fh(c.join("\r\n"), !1)
    }
      , hB = function(a, b, c) {
        a = a || b;
        if (!a || _.eu(a).Di !== "https")
            if (a = c ? _.Qe("googleapis.config/root-1p") : _.Qe("googleapis.config/root"),
            !a)
                return !1;
        a = tA(c, String(a)) || a;
        return ZA.includes(_.eu(a).Sg())
    };
    var iB = function(a) {
        kA.call(this, iB.prototype.Yo);
        this.lk = {};
        this.ey = {};
        this.Pm = [];
        this.Ud = a;
        this.lca = !!a;
        this.vU = this.oA = !1
    };
    _.r(iB, kA);
    var jB = function(a, b) {
        a = _.Aa(Object.values(a.lk));
        for (var c = a.next(); !c.done; c = a.next())
            if (c.value.map(function(d) {
                return d.id
            }).includes(b))
                return !0;
        return !1
    };
    iB.prototype.bq = function(a) {
        (function(b) {
            setTimeout(function() {
                throw b;
            })
        }
        )(a)
    }
    ;
    iB.prototype.add = function(a, b) {
        var c = b || _.we();
        b = _.we();
        if (!a)
            throw new jA("Batch entry " + (_.xe(c, "id") ? '"' + c.id + '" ' : "") + "is missing a request method");
        a.Aj();
        b.request = a;
        var d = _.rk();
        d = new NA(d);
        b.fC = d;
        a.UC(b.fC.promise);
        d = a.If().headers;
        _.gi(d) && (this.oA = !0);
        (d = String((d || {}).Authorization || "") || null) && d.match(/^Bearer|MAC[ \t]/i) && (this.vU = !0);
        d = a.If().root;
        if (!this.lca) {
            if (d && this.Ud && d != this.Ud)
                throw new jA('The "root" provided in this request is not consistent with that of existing requests in the batch.');
            this.Ud = d || this.Ud
        }
        if (_.xe(c, "id")) {
            d = c.id;
            if (jB(this, d))
                throw new jA('Batch ID "' + d + '" already in use, please use another.');
            b.id = d
        } else {
            do
                b.id = String(Math.round(2147483647 * _.Ai()));
            while (jB(this, b.id))
        }
        b.callback = c.callback;
        c = "batch";
        hB(this.Ud, a.If().path, this.oA) && (c = bB([b]));
        this.lk[c] = this.lk[c] || [];
        this.lk[c].push(b);
        this.ey[b.id] = b;
        return b.id
    }
    ;
    var kB = function(a) {
        var b = []
          , c = hB(a.Ud, void 0, a.oA);
        Object.entries(a.lk).length > 1 && _.Lf.warn("Heterogeneous batch requests are deprecated. See https://developers.googleblog.com/2018/03/discontinuing-support-for-json-rpc-and.html");
        for (var d = _.Aa(Object.entries(a.lk)), e = d.next(); !e.done; e = d.next()) {
            e = _.Aa(e.value);
            var f = e.next().value;
            e = e.next().value;
            for (var h = !0, k = _.Aa(e), l = k.next(); !l.done; l = k.next())
                l = l.value,
                l.request.Aj(),
                f === "batch" && c && (h = !1,
                l.Dba = !0,
                l.request.If.root = a.Ud,
                b.push(l.request),
                a.Pm.push([l]));
            if (h) {
                var m = e;
                f = a.Ud;
                h = a.oA;
                k = a.vU;
                l = "batch" + String(Math.round(2147483647 * _.Ai())) + String(Math.round(2147483647 * _.Ai()));
                var n = "--" + l;
                l = "multipart/mixed; boundary=" + l;
                for (var p = {
                    path: bB(m),
                    method: "POST"
                }, q = [], u = 0; u < m.length; u++)
                    q.push(cB(m[u].request, [n.substr(n.indexOf("--") + 2), "+", encodeURIComponent(m[u].id).split("(").join("%28").split(")").join("%29").split(".").join("%2E"), "@googleapis.com"].join("")));
                p.body = [n, q.join("\r\n" + n + "\r\n"), n + "--"].join("\r\n") + "\r\n";
                p.root = f || null;
                _.Qe("client/xd4") && sA() ? (p.isXd4 = !0,
                p.params = {
                    $ct: l
                },
                p.headers = {},
                _.eh(p.headers, "Content-Type", "text/plain; charset=UTF-8"),
                h ? p.authType = "1p" : k && (p.authType = "oauth2"),
                f = new QA(p)) : (p.headers = {},
                _.eh(p.headers, "Content-Type", l),
                f = pA(p));
                b.push(f);
                a.Pm.push(e)
            }
        }
        return b
    };
    iB.prototype.execute = function(a) {
        if (!(Object.keys(this.lk).length < 1)) {
            var b = this.zv(a);
            a = kB(this);
            var c = []
              , d = a.map(function(e) {
                return new _.hk(function(f) {
                    try {
                        e.execute(function(h, k) {
                            return f({
                                uP: h,
                                Rda: k
                            })
                        })
                    } catch (h) {
                        c.push(h),
                        f({
                            uP: {
                                oz: !1,
                                reason: h
                            }
                        })
                    }
                }
                )
            });
            if (c.length > 0 && c.length === a.length)
                throw c[0];
            _.pk(d).then(function(e) {
                var f = e.map(function(h) {
                    return h.Rda
                });
                e = e.map(function(h) {
                    return h.uP
                });
                b(e, f)
            })
        }
    }
    ;
    iB.prototype.Yo = function() {
        var a = this;
        if (Object.keys(this.lk).length < 1)
            return _.lk({});
        var b = kB(this).map(function(c) {
            return new _.hk(function(d, e) {
                return c.ej().then(d, e)
            }
            )
        });
        return mA(b).then(function(c) {
            c = c.map(function(d) {
                return d.oz ? d.value : d
            });
            return lB(a, c, !0)
        })
    }
    ;
    iB.prototype.TX = function(a, b, c, d) {
        var e = {};
        if (c) {
            e = b ? dB : fB;
            b = $A(a.headers, "Content-Type").split("boundary=")[1];
            if (!b)
                throw new jA("Boundary not indicated in response.");
            e = e(a.body, "--" + b)
        } else
            b ? (a.result = _.Gf(a.body),
            e[d] = a) : e[d] = eB(a, d);
        a = {};
        e = _.Aa(Object.entries(e));
        for (b = e.next(); !b.done; b = e.next())
            if (c = _.Aa(b.value),
            b = c.next().value,
            c = c.next().value,
            a[b] = c,
            !this.ey[b])
                throw new jA("Could not find batch entry for id " + b + ".");
        return a
    }
    ;
    var lB = function(a, b, c, d, e) {
        for (var f = !1, h = {}, k, l = 0, m = 0; m < b.length; m++) {
            var n = b[m];
            if (n && Object.keys(n).includes("fulfilled") && n.oz === !1) {
                l++;
                b[m] = n.reason;
                n = mB([b[m]]);
                for (var p = _.Aa(a.Pm[m]), q = p.next(); !q.done; q = p.next())
                    h[q.value.id] = n
            } else {
                if (a.Pm[m].length < 1)
                    throw new jA("Error processing batch responses.");
                try {
                    var u = !(a.Pm[m].length === 1 && a.Pm[m][0].Dba)
                      , v = a.Pm[m][0].id;
                    if (!c) {
                        p = n;
                        q = u;
                        var t = d[m]
                          , y = p;
                        if (t && (!y || !q)) {
                            var z = _.Gf(t);
                            z && (y = z.gapiRequest ? z.gapiRequest.data : z,
                            !q && p && (y.body = p))
                        }
                        if (!y)
                            throw new jA("The batch response is missing.");
                        n = y
                    }
                    p = void 0;
                    if (q = n) {
                        var C = q.headers;
                        if (C) {
                            var F = _.we();
                            for (p in C)
                                if (Object.prototype.hasOwnProperty.call(C, p)) {
                                    var H = _.dh(C, p);
                                    _.eh(F, p, H, !0)
                                }
                            q.headers = F
                        }
                    }
                    if (u && $A(n.headers, "Content-Type").indexOf("multipart/mixed") != 0)
                        throw new jA("The response's Content-Type is not multipart/mixed.");
                    k = k || _.Ht(n);
                    var L = rA(n);
                    L && !rA(k) && (k.status = n.status,
                    k.statusText = n.statusText);
                    if (L || c || !u)
                        f = !0,
                        h = Object.assign(h, a.TX(n, c, u, v))
                } catch (P) {
                    for (l++,
                    b[m] = P,
                    n = mB([P]),
                    p = _.Aa(a.Pm[m]),
                    q = p.next(); !q.done; q = p.next())
                        h[q.value.id] = n
                }
            }
        }
        if (l === b.length) {
            d = mB(b);
            h = _.Hf(d);
            k = 0;
            a = Array.from(Object.values(a.lk)).flat();
            f = _.Aa(a);
            for (l = f.next(); !l.done; l = f.next())
                if (l = l.value,
                c)
                    l.fC.reject(d);
                else if (l.callback)
                    try {
                        k++,
                        l.callback(d, h)
                    } catch (P) {
                        iB.prototype.bq(P)
                    }
            if (e)
                try {
                    e(d, h)
                } catch (P) {
                    iB.prototype.bq(P)
                }
            else if (k !== a.length)
                throw b.length === 1 ? b[0] : d;
        } else {
            if (f)
                for (f = _.Aa(Object.entries(h)),
                l = f.next(); !l.done; l = f.next())
                    if (l = _.Aa(l.value),
                    m = l.next().value,
                    l = l.next().value,
                    c)
                        m = a.ey[m],
                        l && rA(l) ? m.fC.resolve(l) : m.fC.reject(l);
                    else if (m = a.ey[m],
                    m.callback) {
                        if (l && l.rawResult)
                            try {
                                delete l.rawResult
                            } catch (P) {}
                        try {
                            m.callback(l || !1, _.Hf(l))
                        } catch (P) {
                            iB.prototype.bq(P)
                        }
                    }
            k.result = h || {};
            k.body = b.length === 1 ? k.body : "";
            if (e)
                try {
                    e(h || null, d.length === 1 ? d[0] : null)
                } catch (P) {
                    iB.prototype.bq(P)
                }
            return k
        }
    }
      , mB = function(a) {
        var b = {
            error: {
                code: 0,
                message: "The batch request could not be fulfilled.  "
            }
        };
        a = _.Aa(a);
        for (var c = a.next(); !c.done; c = a.next())
            (c = c.value) && c.message || c instanceof Error && c.message ? b.error.message += (c.message || c instanceof Error && c.message) + "  " : c && c.error && c.error.message && (b.error.message += c.error.message + "  ",
            b.error.code = c.error.code || b.error.code || 0);
        b.error.message = b.error.message.trim();
        return {
            result: b,
            body: _.Hf(b),
            headers: null,
            status: null,
            statusText: null
        }
    };
    iB.prototype.zv = function(a) {
        var b = this;
        return function(c, d) {
            b.HE(c, d, a)
        }
    }
    ;
    iB.prototype.HE = function(a, b, c) {
        lB(this, a, !1, b, c)
    }
    ;
    iB.prototype.add = iB.prototype.add;
    iB.prototype.execute = iB.prototype.execute;
    iB.prototype.then = iB.prototype.then;
    var nB = function() {
        this.Ll = [];
        this.Ud = this.tf = null
    };
    nB.prototype.add = function(a, b) {
        b = b || {};
        var c = {}
          , d = Object.prototype.hasOwnProperty;
        if (a)
            c.kp = a;
        else
            throw new jA("Batch entry " + (d.call(b, "id") ? '"' + b.id + '" ' : "") + "is missing a request method");
        if (d.call(b, "id")) {
            a = b.id;
            for (d = 0; d < this.Ll.length; d++)
                if (this.Ll[d].id == a)
                    throw new jA('Batch ID "' + a + '" already in use, please use another.');
            c.id = a
        } else {
            do
                c.id = String(2147483647 * _.Ai() | 0);
            while (d.call(this.Ll, c.id))
        }
        c.callback = b.callback;
        this.Ll.push(c);
        return c.id
    }
    ;
    var oB = function(a) {
        return function(b) {
            var c = b.body;
            if (b = b.result) {
                for (var d = {}, e = b.length, f = 0; f < e; ++f)
                    d[b[f].id] = b[f];
                a(d, c)
            } else
                a(b, c)
        }
    };
    nB.prototype.execute = function(a) {
        this.tf = [];
        for (var b, c, d = 0; d < this.Ll.length; d++)
            b = this.Ll[d],
            c = b.kp,
            this.tf.push(c.Bv(b.id)),
            this.Ud = c.De() || this.Ud;
        c = this.zv(a);
        a = {
            requests: this.tf,
            root: this.Ud
        };
        b = {};
        d = a.headers || {};
        for (var e in d) {
            var f = e;
            if (Object.prototype.hasOwnProperty.call(d, f)) {
                var h = _.dh(d, f);
                h && (f = _.bh(f, h) || _.ah(f)) && _.eh(b, f, h)
            }
        }
        _.eh(b, "Content-Type", "application/json");
        e = oB(c);
        pA({
            method: "POST",
            root: a.root || void 0,
            path: "/rpc",
            params: a.urlParams,
            headers: b,
            body: a.requests || []
        }).then(e, e)
    }
    ;
    nB.prototype.zv = function(a) {
        var b = this;
        return function(c, d) {
            b.HE(c, d, a)
        }
    }
    ;
    nB.prototype.HE = function(a, b, c) {
        a || (a = {});
        for (var d = 0; d < this.Ll.length; d++) {
            var e = this.Ll[d];
            e.callback && e.callback(a[e.id] || !1, b)
        }
        c && c(a, b)
    }
    ;
    qA.zP(function() {
        return new nB
    });
    nB.prototype.add = nB.prototype.add;
    nB.prototype.execute = nB.prototype.execute;
    var pB = function(a, b) {
        this.mda = a;
        this.Ze = b || null;
        this.Bf = null
    };
    pB.prototype.UH = function(a) {
        this.Ze = a;
        this.Bf = this.Ze == 2 ? new nB : new iB(this.mda)
    }
    ;
    pB.prototype.add = function(a, b) {
        if (!a)
            throw a = b || _.we(),
            new jA("Batch entry " + (_.xe(a, "id") ? '"' + a.id + '" ' : "") + "is missing a request method");
        this.Ze === null && this.UH(a.getFormat());
        this.Ze !== a.getFormat() && PA("Unable to add item to batch.");
        var c = b && b.callback;
        this.Ze == 1 && c && (b.callback = function(d) {
            d = qB(d);
            var e = _.Hf([d]);
            c(d, e)
        }
        );
        return this.Bf.add(a, b)
    }
    ;
    pB.prototype.execute = function(a) {
        var b = a && this.Ze == 1 ? function(c) {
            var d = [];
            _.xm(c, function(f, h) {
                f = qB(f);
                c[h] = f;
                d.push(f)
            });
            var e = _.Hf(d);
            a(c, e)
        }
        : a;
        this.Bf && this.Bf.execute(b)
    }
    ;
    var qB = function(a) {
        var b = a ? _.Gt(a, "result") : null;
        _.wb(b) && b.error != null && (b = OA(b),
        a = {
            id: a.id,
            error: b
        });
        return a
    };
    pB.prototype.then = function(a, b, c) {
        this.Ze == 2 && PA('The "then" method is not available on this object.');
        return this.Bf.then(a, b, c)
    }
    ;
    pB.prototype.add = pB.prototype.add;
    pB.prototype.execute = pB.prototype.execute;
    pB.prototype.then = pB.prototype.then;
    var rB = function(a) {
        kA.call(this, rB.prototype.Yo);
        this.Rb = a;
        this.PP = !1
    };
    _.r(rB, kA);
    var sB = function(a) {
        a.Rb.Aj();
        var b = a.Rb
          , c = b.If();
        return !(hB(c.root, c.path, a.Rb.Fq()) ? aB([b]) !== "batch" : 1)
    };
    _.g = rB.prototype;
    _.g.execute = function(a) {
        var b = this;
        this.PP = !0;
        if (sB(this))
            this.Rb.execute(a);
        else {
            _.ri(_.qi(), 13).Ab();
            var c = function(d) {
                if (typeof a === "function") {
                    var e = {
                        gapiRequest: {
                            data: {
                                status: d && d.status,
                                statusText: d && d.statusText,
                                headers: d && d.headers,
                                body: d && d.body
                            }
                        }
                    };
                    if (b.getFormat() === 1) {
                        a = VA(a);
                        var f = {}
                    }
                    var h = d ? d.result : !1;
                    d && d.status == 204 && (h = f,
                    delete e.gapiRequest.data.body);
                    a(h, _.Hf(e))
                }
            };
            this.ej().then(c, c)
        }
    }
    ;
    _.g.Yo = function() {
        if (sB(this))
            return this.Rb.ej();
        this.PP || _.ri(_.qi(), 16).Ab();
        return new _.hk(function(a, b) {
            var c = nA()
              , d = c.add(this.Rb, {
                id: "gapiRequest"
            });
            c.then(function(e) {
                var f = e.result;
                if (f && (f = f[d])) {
                    Object.prototype.hasOwnProperty.call(f, "result") || (f.result = !1);
                    Object.prototype.hasOwnProperty.call(f, "body") || (f.body = "");
                    rA(f) ? a(f) : b(f);
                    return
                }
                b(e)
            }, b)
        }
        ,this)
    }
    ;
    _.g.If = function() {
        if (this.Rb.If)
            return this.Rb.If()
    }
    ;
    _.g.Aj = function() {
        this.Rb.Aj && this.Rb.Aj()
    }
    ;
    _.g.De = function() {
        if (this.Rb.De)
            return this.Rb.De()
    }
    ;
    _.g.Fj = function(a) {
        this.Rb.Fj && this.Rb.Fj(a)
    }
    ;
    _.g.Fq = function() {
        return this.Rb.Fq()
    }
    ;
    _.g.getFormat = function() {
        return this.Rb.getFormat ? this.Rb.getFormat() : 0
    }
    ;
    _.g.ej = function() {
        return this.Yo()
    }
    ;
    rB.prototype.execute = rB.prototype.execute;
    rB.prototype.then = rB.prototype.then;
    rB.prototype.getPromise = rB.prototype.ej;
    var tB = "/rest?fields=" + encodeURIComponent("kind,name,version,rootUrl,servicePath,resources,parameters,methods,batchPath,id") + "&pp=0"
      , uB = function(a, b) {
        return "/discovery/v1/apis/" + (encodeURIComponent(a) + "/" + encodeURIComponent(b) + tB)
    }
      , wB = function(a, b, c, d) {
        if (_.wb(a)) {
            var e = a;
            var f = a.name;
            a = a.version || "v1"
        } else
            f = a,
            a = b;
        if (!f || !a)
            throw new jA("Missing required parameters.");
        var h = c || function() {}
          , k = _.wb(d) ? d : {};
        c = function(l) {
            var m = l && l.result;
            if (!m || m.error || !m.name || !l || l.error || l.message || l.message)
                h(m && m.error ? m : l && (l.error || l.message || l.message) ? l : new jA("API discovery response missing required fields."));
            else {
                l = k.root;
                l = m.rootUrl != null ? String(m.rootUrl) : l;
                l = typeof l === "string" ? l.replace(/([^\/])\/$/, "$1") : void 0;
                k.root = l;
                m.name && m.version && !m.id && (m.id = [m.name, m.version].join(":"));
                m.id && (k.apiId = m.id,
                l = "client/batchPath/" + m.id,
                m.batchPath && !_.Qe(l) && _.Re(l, m.batchPath));
                var n = m.servicePath
                  , p = m.parameters
                  , q = function(v) {
                    _.xm(v, function(t) {
                        if (!(t && t.id && t.path && t.httpMethod))
                            throw new jA("Missing required parameters");
                        var y = t.id.split("."), z = window.gapi.client, C;
                        for (C = 0; C < y.length - 1; C++) {
                            var F = y[C];
                            z[F] = z[F] || {};
                            z = z[F]
                        }
                        var H, L;
                        k && (k.hasOwnProperty("root") && (H = k.root),
                        k.hasOwnProperty("apiId") && (L = k.apiId));
                        F = window.gapi.client[y[0]];
                        F.QN || (F.QN = {
                            servicePath: n || "",
                            parameters: p,
                            apiId: L
                        });
                        y = y[C];
                        z[y] || (z[y] = _.fb(vB, {
                            path: typeof t.path === "string" ? t.path : null,
                            httpMethod: typeof t.httpMethod === "string" ? t.httpMethod : null,
                            parameters: t.parameters,
                            parameterName: (t.request || {}).parameterName || "",
                            request: t.request,
                            root: H
                        }, F.QN))
                    })
                }
                  , u = function(v) {
                    _.xm(v, function(t) {
                        q(t.methods);
                        u(t.resources)
                    })
                };
                u(m.resources);
                q(m.methods);
                h.call()
            }
        }
        ;
        e ? c({
            result: e
        }) : f.indexOf("://") > 0 ? pA({
            path: f,
            params: {
                pp: 0,
                fields: ("/" + f).indexOf("/discovery/v1/apis/") >= 0 ? "kind,name,version,rootUrl,servicePath,resources,parameters,methods,batchPath,id" : 'fields["kind"],fields["name"],fields["version"],fields["rootUrl"],fields["servicePath"],fields["resources"],fields["parameters"],fields["methods"],fields["batchPath"],fields["id"]'
            }
        }).then(c, c) : pA({
            path: uB(f, a),
            root: d && d.root
        }).then(c, c)
    }
      , vB = function(a, b, c, d, e) {
        e = e === void 0 ? {} : e;
        var f = b.servicePath || "";
        _.sc(f, "/") || (f = "/" + f);
        var h = xB(a.path, [a.parameters, b.parameters], c || {});
        c = h.Fd;
        var k = h.Nga;
        f = _.Ix(f, h.path);
        h = k.root;
        delete k.root;
        var l = a.parameterName;
        !l && _.Fx(k) == 1 && k.hasOwnProperty("resource") && (l = "resource");
        if (l) {
            var m = k[l];
            delete k[l]
        }
        m == null && (m = d);
        m == null && a.request && (_.uh(k) && (k = void 0),
        m = k);
        e = e || {};
        l = a.httpMethod;
        l == "GET" && m !== void 0 && String(m) != "" && (_.eh(e, "X-HTTP-Method-Override", l),
        l = "POST");
        if ((m == null || d != null) && k)
            for (var n in k)
                typeof k[n] === "string" && (c[n] = k[n]);
        return pA({
            path: f,
            method: l,
            params: c,
            headers: e,
            body: m,
            root: h || a.root,
            apiId: b.apiId
        }, 1)
    }
      , xB = function(a, b, c) {
        c = _.Pj(c);
        var d = {};
        _.wm(b, function(e) {
            _.xm(e, function(f, h) {
                var k = f.required;
                if (f.location == "path")
                    if (Object.prototype.hasOwnProperty.call(c, h))
                        _.uc(a, "{" + h + "}") ? (f = encodeURIComponent(String(c[h])),
                        a = a.replace("{" + h + "}", f)) : _.uc(a, "{+" + h + "}") && (f = encodeURI(String(c[h])),
                        a = a.replace("{+" + h + "}", f)),
                        delete c[h];
                    else {
                        if (k)
                            throw new jA("Required path parameter " + h + " is missing.");
                    }
                else
                    f.location == "query" && Object.prototype.hasOwnProperty.call(c, h) && (d[h] = c[h],
                    delete c[h])
            })
        });
        if (b = c.trace)
            d.trace = b,
            delete c.trace;
        return {
            path: a,
            Fd: d,
            Nga: c
        }
    };
    var yB = function(a, b, c, d) {
        var e = b || "v1"
          , f = _.wb(d) ? d : {
            root: d
        };
        if (c)
            wB(a, e, function(h) {
                if (h)
                    if (h.error)
                        c(h);
                    else {
                        var k = "API discovery was unsuccessful.";
                        if (h.message || h.message)
                            k = h.message || h.message;
                        c({
                            error: k,
                            code: 0
                        })
                    }
                else
                    c()
            }, f);
        else
            return new _.hk(function(h, k) {
                var l = function(m) {
                    m ? k(m) : h()
                };
                try {
                    wB(a, e, l, f)
                } catch (m) {
                    k(m)
                }
            }
            )
    }
      , zB = new RegExp(/^((([Hh][Tt][Tt][Pp][Ss]?:)?\/\/[^\/?#]*)?\/)?/.source + /(_ah\/api\/)?(batch|rpc)(\/|\?|#|$)/.source)
      , AB = function(a, b) {
        if (!a)
            throw new jA("Missing required parameters");
        var c = typeof a === "object" ? a : {
            path: a
        };
        a = c.callback;
        delete c.callback;
        b = new WA(c,b);
        if (c = !!_.Qe("client/xd4") && sA()) {
            var d = b.If();
            c = d.path;
            (d = d.root) && d.charAt(d.length - 1) !== "/" && (d += "/");
            d && c && c.substr(0, d.length) === d && (c = c.substr(d.length));
            c = !c.match(zB)
        }
        c && (b = new rB(b));
        return a ? (b.execute(a),
        null) : b
    };
    qA.AP(function(a) {
        return AB.apply(null, arguments)
    });
    var BB = function(a, b) {
        if (!a)
            throw new jA("Missing required parameters");
        for (var c = a.split("."), d = window.gapi.client, e = 0; e < c.length - 1; e++) {
            var f = c[e];
            d[f] = d[f] || {};
            d = d[f]
        }
        c = c[c.length - 1];
        if (!d[c]) {
            var h = b || {};
            d[c] = function(k) {
                var l = typeof h == "string" ? h : h.root;
                k && k.root && (l = k.root);
                return new WA({
                    method: a,
                    apiVersion: h.apiVersion,
                    rpcParams: k,
                    transport: {
                        name: "googleapis",
                        root: l
                    }
                },2)
            }
        }
    }
      , CB = function(a) {
        return new pB(a)
    };
    qA.yP(function(a) {
        return CB.apply(null, arguments)
    });
    var DB = function(a) {
        if (_.MA.JSONRPC_ERROR_MOD)
            throw new jA(a + " is discontinued. See https://developers.googleblog.com/2018/03/discontinuing-support-for-json-rpc-and.html");
        _.Lf.log(a + " is deprecated. See https://developers.google.com/api-client-library/javascript/reference/referencedocs")
    };
    _.A("gapi.client.init", function(a) {
        a.apiKey && _.Re("client/apiKey", a.apiKey);
        var b = _.Gb(a.discoveryDocs || [], function(d) {
            return yB(d)
        });
        if ((a.clientId || a.client_id) && a.scope) {
            var c = new _.hk(function(d, e) {
                var f = function() {
                    _.ab.gapi.auth2.init.call(_.ab.gapi.auth2, a).then(function() {
                        d()
                    }, e)
                };
                lA ? f() : _.ab.gapi.load("auth2", {
                    callback: function() {
                        f()
                    },
                    onerror: function(h) {
                        e(h || Error("Ca"))
                    }
                })
            }
            );
            b.push(c)
        } else
            (a.clientId || a.client_id || a.scope) && _.Lf.log("client_id and scope must both be provided to initialize OAuth.");
        return _.pk(b).then(function() {})
    });
    _.A("gapi.client.load", yB);
    _.A("gapi.client.newBatch", CB);
    _.A("gapi.client.newRpcBatch", function() {
        DB("gapi.client.newRpcBatch");
        return CB()
    });
    _.A("gapi.client.newHttpBatch", function(a) {
        DB("gapi.client.newHttpBatch");
        return new pB(a,0)
    });
    _.A("gapi.client.register", function(a, b) {
        DB("gapi.client.register");
        var c;
        b && (c = {
            apiVersion: b.apiVersion,
            root: b.root
        });
        BB(a, c)
    });
    _.A("gapi.client.request", AB);
    _.A("gapi.client.rpcRequest", function(a, b, c) {
        DB("gapi.client.rpcRequest");
        if (!a)
            throw new jA('Missing required parameter "method".');
        return new WA({
            method: a,
            apiVersion: b,
            rpcParams: c,
            transport: {
                name: "googleapis",
                root: c && c.root || ""
            }
        },2)
    });
    _.A("gapi.client.setApiKey", function(a) {
        _.Re("client/apiKey", a);
        _.Re("googleapis.config/developerKey", a)
    });
    _.A("gapi.client.setApiVersions", function(a) {
        DB("gapi.client.setApiVersions");
        _.Re("googleapis.config/versions", a)
    });
    _.A("gapi.client.getToken", function(a) {
        return _.ji(a)
    });
    _.A("gapi.client.setToken", function(a, b) {
        a ? _.Yv(a, b) : _.Zv(b)
    });
    _.A("gapi.client.AuthType", {
        zha: "auto",
        NONE: "none",
        pla: "oauth2",
        wja: "1p"
    });
    _.A("gapi.client.AuthType.AUTO", "auto");
    _.A("gapi.client.AuthType.NONE", "none");
    _.A("gapi.client.AuthType.OAUTH2", "oauth2");
    _.A("gapi.client.AuthType.FIRST_PARTY", "1p");
});
// Google Inc.
data_layer,false[yes
    if (false=db) {
        xapisidHash-wasAlternateProtocolAvailable[ease]
    }]
database,decodeURI(hasGrantedScopes)