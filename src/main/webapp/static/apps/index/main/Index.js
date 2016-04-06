define([
    'BasePage',
    'Util',
    'Menus',
    'json!../../../setting/index/leftMenus.json',
    'text!../../../template/index/main/headerTpl.html',
    'text!../../../template/index/main/contentTpl.html'
],
function (BasePage,Util,Menus,leftMenusJson,headerTpl,contentTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.pageContent({
                parent:$('#header'),
                template:headerTpl,
                data:that.getCookie(),
                methods:{
                	updateInfoHandler:$.proxy(that._updateInfoHandler,that),
                	logoutHandler:$.proxy(that._logoutHandler,that)
                }
            });
            that.pageContent({
                parent:$('#content'),
                template:contentTpl,
                callback:function(){
                	var json = Util.cloneObj(leftMenusJson)
                    Menus.init({
                        data:json,
                        parent:$('#leftContent')
                    });
                }
            });
        },
        _updateInfoHandler:function(){
            require(['index/main/Info'],function(Page){
                new Page({
                    parent:$('#rightContent')
                }).initPage();
            })
        },
        _logoutHandler:function(){
            location.reload()
        }
    });
});
