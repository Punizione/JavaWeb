var _snma="_snma";var _snmaKeysArr=["constant","visitorid","firstViewTime","lastViewTime","thisViewTime","totalPvs","totalVisits"];var _snmb="_snmb";var _snmbKeysArr=["visitid","inTime","outTime","views"];var _snmc="_snmc";var _snmp="_snmp";var _snsr="_snsr";var _snsrKeysArr=["source","medium","content","campaign","theme"];var _snmz="_snmz";var _snmzKeysArr=["pvid","clickDots"];var _snck="_snck";var _snms="_snms";var _snml="_snml";var _snmx="_snmx";var _snmk="_snmk";var _snsd="_snsd";var _snmo="_snmo";var _snmt="_snmt";var _snmg="_snmg";var _snme="_snme";var sa_errorCode=document.getElementById("errorCode");var _saErrorCode=sa_errorCode?sa_errorCode.value:"";var sa_resourceType=document.getElementById("resourceType");var _resourceType=sa_resourceType?sa_resourceType.value:"";var _tag="|";var _no_data_tag="";var _splited="*:*";var expires_ms_2years=365*2*24*60*60*1000;var expires_ms_30mins=30*60*1000;var expires_ms_24hours=86400000;var _protocol=location.protocol;var _snProtocol=(("https:"==document.location.protocol)?"https://":"http://");var _saServer=_getSaServer(_samap.get("_isPrd"));var _toTitle=_no_data_tag;var _toUrl=_getToUrl();var _fromUrl=_getFromUrl();var _fromTitle=_no_data_tag;var _searchersArr=new Array(".google.com",".baidu.com",".soso.com",".bing.com",".yahoo.com",".sogou.com",".360.cn",".so.com",".youdao.com");var _sourceMediumArr=new Array("direct","referral","organic");var _inTime=_no_data_tag;var _pvFlag=0;var _crossDayFlag=0;var ua=navigator.userAgent,pf=navigator.platform,p="push",m="match",i="indexOf",npo="unknow but like Phone",npa="unknow but like Tablet",n="unknown",r,os=_getOSAndTer(),Bro=_getExplore(),OS,Ter;os.length==2?(OS=os[0],Ter=os[1]):!1;var IE=document.all?true:false;var tempX=0,tempY=0;_saStart();_samap.put=function(a,b){if(_samap.data[a]==null){_samap.keys.push(a)}_samap.data[a]=b;_saStart()};document.onclick=_globalClick;(function(){var c=frames.length;if(c>0){for(var a=0;a<c;a++){try{frames[a].document.onclick=_updateSnml}catch(b){}}}})();function _globalClick(a){_putMouseXY(a);_protocol=="https:"?_updateSnml():!1}function _putMouseXY(a){try{if(IE){tempX=event.clientX+(document.body.scrollLeft||document.documentElement.scrollTop);tempY=event.clientY+(document.body.scrollTop||document.documentElement.scrollTop)}else{tempX=a.pageX;tempY=a.pageY}if(tempX<0){tempX=0}if(tempY<0){tempY=0}var b="("+tempX+","+tempY+")";_putSnmz(b)}catch(a){}}function _updateSnml(){var a=_getCookie(_snml);!a||a!=_toUrl?_addCookie(_snml,_toUrl,"/","",""):!1}function _saStart(){if(_samap.get("_saPvDatas")!=null){var e=_samap.get("_saPvDatas");e[0]=_getCookie("logonUserIdLastTime")?_getCookie("logonUserIdLastTime"):"";if(e[0]!=""&&e[1]==""){e[1]="R"}else{if(e[1]==""){e[1]="G"}}var d=_arrayToString(e);_saInit(d);_samap.remove("_saPvDatas")}if(_samap.get("_saSearchDatas")!=null){var f=_samap.get("_saSearchDatas");var h=_arrayToString(f);_sendSearchDatas(h);_samap.remove("_saSearchDatas")}if(_samap.get("_saOrderDatas")!=null){var j=_samap.get("_saOrderDatas");var b=_arrayToString(j);_sendOrderDatas(b);_samap.remove("_saOrderDatas")}if(_samap.get("_saRegisterDatas")!=null){var k=_samap.get("_saRegisterDatas");var a=_arrayToString(k);_sendRegisterDatas(a);_samap.remove("_saRegisterDatas")}if(_samap.get("_saStorageDatas")!=null){var g=_samap.get("_saStorageDatas");var c=_arrayToString(g);_sendStorageDatas(c);_samap.remove("_saStorageDatas")}}function _getToUrl(){return document.location.href}function _getFromUrl(){var f=document.referrer;var d=_getCookie(_snml);if((_protocol=="https:"&&f!=""&&d&&d.substring(0,6)=="https:"&&d!=f)||(_protocol=="http:"&&f==""&&d&&d.substring(0,6)=="https:")||(_protocol=="https:"&&f==""&&d&&d.substring(0,6)=="https:")||(f!=""&&d&&d!=f)){f=d}if(d){_delCookie(_snml)}if(_toUrl!=""&&(_toUrl.indexOf("sourceUrl4Sa")!=-1)){var c=_toUrl.substring(_toUrl.indexOf("?")+1,_toUrl.length);var e=c.split("&");for(var b=0;b<e.length;b++){var a=e[b].split("=");if(a[0]=="sourceUrl4Sa"){f=decodeURIComponent(a[1])}}}else{if((!f||f==null||f=="")&&_toUrl!=""&&(_toUrl.indexOf("returnUrl")!=-1)){var c=_toUrl.substring(_toUrl.indexOf("?")+1,_toUrl.length);var e=c.split("&");for(var b=0;b<e.length;b++){var a=e[b].split("=");if(a[0]=="returnUrl"){f=a[1]}}}}return f}function _saInit(c){_putSnmaTimesAndViews();_checkSnmc();_putSnsr();_putSnmb();var f=_getCookie(_snma);var l=_getSnmbAndParam(c);var g=_getSnmx();var h=_getCookie(_snsr);var a=_getSnmzMapFromCookie();var k=_getStrFromKeysArrAndValuesStr(_snmzKeysArr,a);var d=_saErrorCode;if((typeof f=="undefined")&&(typeof h=="undefined")){var b=new Date();var e=_getOnlyId();var o=["1",e,b.getTime(),b.getTime(),b.getTime(),1,1];f=_arrayToString(o);l=l.substring(0,l.lastIndexOf(_tag)+1)+"1";var j=_getSnsrMapFromCookie();j=_checkSource(j);j=_checkSnsr(j);h=_getStrFromKeysArrAndValuesStr(_snsrKeysArr,j)}_sendInitData(f,l,g,h,k,d);_addCookie(_snmp,a.get("pvid"),"/","","");_delCookie(_snmz);_delCookie(_snck);_refreshSnmbInTime()}function _analyseExpoTags(b){var e=document.getElementsByTagName(b),g="",d=new RegExp("^baoguang_");for(var a=0,f=e.length;a<f;a++){var c=e[a].id;d.test(c)?(c=c.substring(9),g+=c+"#@#",g=g.replace(/\|/g," ")):!1}if(g!==""){g=g.substring(0,g.length-3),_sendExpoDatas(g)}}function _getSaServer(a){if(a=="true"){return"click.suning.cn/sa"}else{return"clicksit.suning.cn/sa"}}function _getSnmx(){var b=_getCookie(_snck);if(!b||b==null||b==""){b=_no_data_tag}var a=OS+_tag+Bro+_tag+_getSense()+_tag+_getPrinColor()+_tag+_getFlash()+_tag+_getJava()+_tag+b;return a}function _getOSAndTer(){var e=[];if(/AppleWebKit.*Mobile/i.test(ua)||(/Android|SymbianOS|Windows Phone|Tablet PC|NOKIA|Nokia|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|SonyEricsson|SIE-|Amoi|ZTE/i.test(ua))){if(r=ua[m](/(iPhone|iPod touch|iPad).*(OS [\d_]+)/i)){e[p](r[2]);e[p](r[1])}else{if(r=ua[m](/(Windows Phone( | OS )[\d\.]+).*; ([^;]+)\)$/i)){e[p](r[1]);e[p](r[3])}else{if(r=ua[m](/; (Windows NT [\d\.]+).*(Tablet PC [\d\.]+).*\)$/i)){e[p](r[1]);e[p](r[2])}else{if(ua[i]("Windows Phone")>-1){e[p]("Windows Phone");e[p](npo)}else{if(ua[i]("Windows NT")>-1){e[p]("windows NT");e[p](npa)}else{if(r=ua[m](/(Android [\d\.]+);[^;]*; ([^\)]*?)\)/i)){e[p](r[1]);e[p](r[2])}else{if(ua[i]("Android")>-1&&ua[i]("mobile")>-1){e[p]("Android");e[p](npo)}else{if(ua[i]("Andriod")>-1){e[p]("Android");e[p](npa)}else{e[p](n)[p](n)}}}}}}}}}else{var g=(pf=="Win32")||(pf=="Windows");var h=(pf=="Mac68K")||(pf=="MacPPC")||(pf=="Macintosh")||(pf=="MacIntel");if(h){e[p]("Mac")}var c=(pf=="X11")&&!g&&!h;if(c){e[p]("Unix")}var a=(pf[i]("Linux")>-1);if(a){e[p]("Linux")}if(g){var f=ua[i]("Windows NT 5.0")>-1||ua[i]("Windows 2000")>-1;if(f){e[p]("Win2000")}var k=ua[i]("Windows NT 5.1")>-1||ua[i]("Windows XP")>-1;if(k){e[p]("WinXP")}var b=ua[i]("Windows NT 5.2")>-1||ua[i]("Windows 2003")>-1;if(b){e[p]("Win2003")}var b=ua[i]("Windows NT 6.0")>-1||ua[i]("Windows Vista")>-1;if(b){e[p]("WinVista")}var b=ua[i]("Windows NT 6.1")>-1||ua[i]("Windows 7")>-1;if(b){e[p]("Win7")}var j=ua[i]("Windows NT 6.2")>-1;if(j){e[p]("Windows 8")}var d=ua[i]("Windows NT 6.3")>-1;if(d){e[p]("Windows 8.1")}}e[p]("PC")}e.length>2?e=e.slice(0,2):e.length==1?e[p](n):e.length==0?e[p](n)[p](n):e;return e}function _getExplore(){var b={};var c;(c=ua[m](/ucbrowser\/[\d\.]+/i))?b.uc=c[0]:(c=ua[m](/msie ([\d.]+)/i))?b.ie=c[1]:(c=ua[m](/firefox\/([\d.]+)/i))?b.firefox=c[1]:(c=ua[m](/chrome\/([\d.]+)/i))?b.chrome=c[1]:(c=ua[m](/opera.([\d.]+)/i))?b.opera=c[1]:(c=ua[m](/version\/([\d.]+).*safari/i))?b.safari=c[1]:0;var a="";if(b.uc){a=b.uc}else{if(b.ie){a="msie "+b.ie}else{if(b.firefox){a="firefox "+b.firefox}else{if(b.chrome){a="chrome "+b.chrome}else{if(b.opera){a="opera "+b.opera}else{if(b.safari){a="safari "+b.safari}else{a="unknown Browser"}}}}}}return a}function _getSense(){return window.screen.width+"x"+window.screen.height}function _getPrinColor(){return window.screen.colorDepth+"bit"}function _getFlash(){var f="";var n=navigator;if(n.plugins&&n.plugins.length){for(var ii=0;ii<n.plugins.length;ii++){if(n.plugins[ii].name.indexOf("Shockwave Flash")!=-1){f=n.plugins[ii].description.split("Shockwave Flash ")[1].split(" ")[0];break}}}else{if(window.ActiveXObject){for(var ii=10;ii>=2;ii--){try{var fl=eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."+ii+"');");if(fl){f=ii+".0";break}}catch(e){}}}}if(f!=""){return 1}return 0}function _getJava(){if(navigator.javaEnabled()){return 1}return 0}function _putSnmz(c){var a=_getSnmzMapFromCookie();a.put("clickDots",a.get("clickDots").replace(_no_data_tag,""));var b=_getStrFromKeysArrAndValuesStr(_snmzKeysArr,a);b=b+c;_addCookie(_snmz,b,"/","","")}function _putSnmaTimesAndViews(){var b=new Date();var a=_getSnmaMapFromCookie();a.put("lastViewTime",a.get("thisViewTime"));a.put("thisViewTime",b.getTime());a.put("totalPvs",Number(a.get("totalPvs"))+1);_setSnmaMapToCookie(a)}function _putSnsr(){var a=_getSnsrMapFromCookie();a=_checkSource(a);a=_checkSnsr(a);_setSnsrMapToCookie(a)}function _checkSource(e){var s=new Array("wd","q","w","query","p");var h=0;var f=0;if(_fromUrl!=""){for(var b=0;b<_searchersArr.length;b++){var q=_searchersArr[b];if(_fromUrl.indexOf(q)!=-1){e.put("source",q.substring(1,q.length));e.put("medium",_sourceMediumArr[1]);e.put("content",_no_data_tag);e.put("campaign",_no_data_tag);e.put("theme",_no_data_tag);var k=_fromUrl.substring(_fromUrl.indexOf("?")+1,_fromUrl.length);var c=k.split("&");for(var o=0;o<c.length;o++){var d=c[o].split("=");for(var a=0;a<s.length;a++){if(s[a]==d[0]){e.put("medium",_sourceMediumArr[2]);e.put("theme",d[1]+_splited);break}}f=a;if(f<s.length){break}}break}}h=b;if(h==_searchersArr.length||(h<_searchersArr.length&&f==s.length)){var g=_getDomainByUrl(location.href);var l=_getDomainByUrl(_fromUrl);if((l.indexOf(".suning.com")==-1&&l.indexOf(".suningpay.com")==-1)||l.indexOf("union.suning.com")!=-1){e.put("source",_getDomainByUrl(_fromUrl));e.put("medium",_sourceMediumArr[1]);e.put("content",_no_data_tag);e.put("campaign",_no_data_tag);e.put("theme",_no_data_tag);for(var b=0;b<_searchersArr.length;b++){var q=_searchersArr[b];if(_fromUrl.indexOf(q)!=-1){e.put("source",q.substring(1,q.length));break}}}}}return e}function _checkSnsr(f){if(_toUrl!=""&&(_toUrl.indexOf("utm_source")>0||_toUrl.indexOf("utm_medium")>0||_toUrl.indexOf("utm_content")>0||_toUrl.indexOf("utm_campaign")>0||_toUrl.indexOf("utm_term")>0)){var d=_toUrl.substring(_toUrl.indexOf("?")+1,_toUrl.length);var e=d.split("&");for(var b=0;b<e.length;b++){var a=e[b].split("=");if(a[0]=="utm_source"){f.put("source",a[1])}else{if(a[0]=="utm_medium"){f.put("medium",a[1])}else{if(a[0]=="utm_content"){f.put("content",a[1])}else{if(a[0]=="utm_campaign"){f.put("campaign",a[1])}else{if(a[0]=="utm_term"){var c=f.get("theme");fromUrl_utm_term=(c)?c:(_no_data_tag+_splited);f.put("theme",fromUrl_utm_term+a[1])}}}}}}}return f}function _checkSnmc(){var a=_getCookie(_snmc);if(!a||a==null||a==""){var b=_getCookie(_snmb);if(!b||b==null||b==""){_inTime=_no_data_tag}else{var c=_getSnmbMapFromCookie();_inTime=c.get("inTime");_delCookie(_snmb)}}_putSnmc()}function _getSnmbAndParam(f){var h=_getSnmbMapFromCookie();var b=_getStrFromKeysArrAndValuesStr(_snmbKeysArr,h);var e=_cutUrlToShort(_fromUrl);var a=_cutUrlToShort(_fromTitle);var g=_cutUrlToShort(_toUrl);var d=_cutUrlToShort(_toTitle);var c=f+_tag+e+_tag+a+_tag+g+_tag+d+_tag+b;return c}function _putSnmb(){var b=_getSnmbMapFromCookie();var a=new Date();b.put("outTime",a.getTime());b.put("views",Number(b.get("views"))+1);_setSnmbMapToCookie(b)}function _refreshSnmbInTime(){var a=_getSnmbMapFromCookie();a.put("inTime",new Date().getTime());_setSnmbMapToCookie(a)}function _putSnmc(){_addCookie(_snmc,"1","/",expires_ms_30mins,"")}function _updateSnml(){var a=_getCookie(_snml);if(!a||a!=_toUrl){_addCookie(_snml,_toUrl,"/","","")}}function _getSnmaMapFromCookie(){var b;var d=_getCookie(_snma);if(d&&d!=null&&d!=""){var e=d.split(_tag);b=_getMapFromKeyValueArrs(_snmaKeysArr,e);return b}else{var c=new Date();var a=_getOnlyId();var e=["1",a,c.getTime(),c.getTime(),c.getTime(),0,0];b=_getMapFromKeyValueArrs(_snmaKeysArr,e);return b}}function _setSnmaMapToCookie(b){var a=_getStrFromKeysArrAndValuesStr(_snmaKeysArr,b);_addCookie(_snma,a,"/",expires_ms_2years,"")}function _getSnmbMapFromCookie(){var e;var b=_getCookie(_snmb);if(b){var d=b.split(_tag);e=_getMapFromKeyValueArrs(_snmbKeysArr,d);if(_crossDayFlag===0){var c=e.get("inTime");if(c&&/\d/.test(c)){var a=new Date(Number(c)).getDate();if(new Date().getDate()==a+1){_inTime=c;_crossDayFlag++;return newSession()}}}return e}else{return newSession()}}function newSession(){if(_pvFlag===0){var b=_getSnmaMapFromCookie();b.put("totalVisits",Number(b.get("totalVisits"))+1);_setSnmaMapToCookie(b);_pvFlag++}var c=_getOnlyId(),a=[c,_inTime,_no_data_tag,0],d=_getMapFromKeyValueArrs(_snmbKeysArr,a);return d}function _setSnmbMapToCookie(b){var a=_getStrFromKeysArrAndValuesStr(_snmbKeysArr,b);_addCookie(_snmb,a,"/","","")}function _getSnmzMapFromCookie(){var a;var c=_getCookie(_snmz);if(c&&c!=null&&c!=""){var d=c.split(_tag);a=_getMapFromKeyValueArrs(_snmzKeysArr,d);return a}else{var b=_getOnlyId();var d=[b,_no_data_tag];a=_getMapFromKeyValueArrs(_snmzKeysArr,d);return a}}function _setSnmzMapToCookie(b){var a=_getStrFromKeysArrAndValuesStr(_snmzKeysArr,b);_addCookie(_snmz,a,"/","","")}function _getSnsrMapFromCookie(){var b;var c=_getCookie(_snsr);if(c&&c!=null&&c!=""){var a=c.split(_tag);b=_getMapFromKeyValueArrs(_snsrKeysArr,a);return b}else{var a=[_sourceMediumArr[0],_sourceMediumArr[0],_no_data_tag,_no_data_tag,_no_data_tag];b=_getMapFromKeyValueArrs(_snsrKeysArr,a);return b}}function _setSnsrMapToCookie(d){var e=_getSnsrMapFromCookie();var a=_getStrFromKeysArrAndValuesStr(_snsrKeysArr,e),c=_getStrFromKeysArrAndValuesStr(_snsrKeysArr,d);if(!_getCookie(_snsr)||a!=c){var f=_getStrFromKeysArrAndValuesStr(_snsrKeysArr,d);_addCookie(_snsr,f,"/",expires_ms_24hours,"");var b=_getSnmbMapFromCookie();_inTime=b.get("inTime");_delCookie(_snmb)}}function HashMap(){this.keys=new Array();this.data=new Object();this.put=function(a,b){if(this.data[a]==null){this.keys.push(a)}this.data[a]=b};this.get=function(a){return this.data[a]};this.remove=function(a){if(this.get(a)!=null){delete this.data[a]}}}function _addCookie(d,f,g,a,e){var h=d+"="+escape(f);if(a!=""){var c=new Date();c.setTime(c.getTime()+a);h+=";expires="+c.toGMTString()}if(g!=""){h+=";path="+g}var b=_getDomain();if(b.indexOf(".suning.com")!=-1){h+=";domain=.suning.com"}else{if(b.indexOf(".cnsuning.com")!=-1){h+=";domain=.cnsuning.com"}else{if(b.indexOf(".manzuo.com")!=-1){h+=";domain=.manzuo.com"}else{h+=";domain="+location.hostname}}}document.cookie=h}function _getCookie(b){var d=document.cookie.split("; ");for(var c=0;c<d.length;c++){var a=d[c].split("=");if(a[0]==b){return unescape(a[1])}}}function _delCookie(a){_addCookie(a,"","/",-10000,"")}function _getDomain(){var a=document.location.hostname;return a}function _getDomainByUrl(a){var b=a.substring(a.indexOf("/",a.indexOf("/")+1)+1);var c=b.substring(0,b.indexOf("/"));return c}function _getOnlyId(){var b=new Date();var a=Math.round(100000*Math.random());var c=b.getTime().toString().concat(a);return c}function _getMapFromKeyValueArrs(d,a){var c=new HashMap();for(var b=0;b<d.length;b++){c.put(d[b],a[b])}return c}function _getStrFromKeysArrAndValuesStr(c,b){var d="";for(var a=0;a<c.length;a++){d=d+b.get(c[a])+_tag}return d.substring(0,d.length-1)}function _arrayToString(a){var c="";for(var b=0;b<a.length;b++){c=c+a[b]+_tag}return c.substring(0,c.length-1)}function _cutUrlToShort(a){if(a.length>301){a=a.substring(0,300)}while(a.indexOf(_tag)!=-1){a=a.replace(_tag,"--")}return a}function _httpGifSend(c){var b="log_"+(new Date()).getTime();var a=window[b]=new Image();a.onload=(a.onerror=function(){window[b]=null});a.src=c+"&iId="+b;a=null}function _sendInitData(j,f,e,d,c,b){var h=_snProtocol+_saServer+"/ajaxInit.gif";var g=_snma+"="+_encode(j)+"&"+_snmb+"="+encodeURIComponent(f)+"&"+_snmx+"="+_encode(e)+"&"+_snsr+"="+d+"&"+_snmz+"="+_encode(c)+"&"+_snme+"="+_encode(b)+"&_type="+_resourceType+"&ter="+Ter;if(productId){g=g+"&productId="+productId}if(urlPattern){g=g+"&urlPattern="+urlPattern}var a=h+"?"+g;_httpGifSend(a)}function _sendSearchDatas(g){var h=_snProtocol+_saServer+"/ajaxSearch.gif";var b=new Date();var d=_cutUrlToShort(_fromUrl);var j=_cutUrlToShort(_fromTitle);var c=_getOnlyId();var f=_getCookie(_snmp);_addCookie(_snms,c,"/","","");var e=c+_tag+f+_tag+d+_tag+j+_tag+b.getTime()+_tag+g;var a=h+"?"+_snsd+"="+encodeURIComponent(e)+"&_type="+_resourceType;_httpGifSend(a)}function _sendOrderDatas(a){var d=_snProtocol+_saServer+"/ajaxOrder.gif";var c=new Date();var h=_getCookie(_snms);var f=_getCookie(_snmp);var g=_getOnlyId();if(!h&&h==null||h==""){h=_no_data_tag}var e=g+_tag+a+_tag+f+_tag+h+_tag+c.getTime();var b=d+"?"+_snmo+"="+e+"&_type="+_resourceType;_httpGifSend(b)}function _sendRegisterDatas(e){var f=_snProtocol+_saServer+"/ajaxRegister.gif";var d=_getOnlyId();var c=_getCookie(_snmp);var b=d+_tag+c+_tag+e;var a=f+"?"+_snmg+"="+b+"&_type="+_resourceType;_httpGifSend(a)}function _sendStorageDatas(a){var h=_snProtocol+_saServer+"/ajaxStorage.gif",k=new Date,e=_getOnlyId(),d=_getCookie(_snmp),g=_toUrl?_encode(_cutUrlToShort(_toUrl).replace(/\|/g," ")):"can not get url",f=document.getElementById("supplierID"),c=f?f.value.replace(/\|/g," "):"can not get supplierId",j=e+_tag+d+_tag+a+_tag+k.getTime()+_tag+g+_tag+c,b=h+"?"+_snmt+"="+j+"&_type="+_resourceType+"&ter="+Ter+"&os="+OS;_httpGifSend(b)}function _sendExpoDatas(a){var d=_snProtocol+_saServer+"/ajaxExpoDatas.gif",g=_getOnlyId(),e=_getCookie(_snmp),c=typeof sn=="object"?sn.cityId:"can not get cityId",b=(b=document.getElementById("resourceType"))?b.value:"web",f=g+_tag+e+_tag+a+_tag+c+_tag+b,d=d+"?_expo="+encodeURIComponent(f);_httpGifSend(d)}function _encode(a){return null!=a?encodeURIComponent(a):""};