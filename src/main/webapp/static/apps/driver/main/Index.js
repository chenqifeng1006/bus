define([
    'BasePage',
    'Util',
    'Menus',
    'json!../../../setting/driver/leftMenus.json',
    'text!../../../template/driver/main/headerTpl.html',
    'text!../../../template/driver/main/contentTpl.html'
],
function (BasePage,Util,Menus,leftMenusJson,headerTpl,contentTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.item = options.driver;
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
                otherData:that.item,
                methods:{
                	updateInfoHandler:$.proxy(that._updateInfoHandler,that),
                	logoutHandler:$.proxy(that._logoutHandler,that)
                }
            });
            that.pageContent({
                parent:$('#content'),
                template:contentTpl,
                callback:function(){
                    if(!that.item.busId){
                        leftMenusJson.splice(0,2);
                    }else if(!that.item.lineName){
                        leftMenusJson.splice(1,1);
                    }
                    Menus.init({
                        data:leftMenusJson,
                        parent:$('#leftContent')
                    });
                }
            });
        },
        _updateInfoHandler:function(){
            require(['driver/main/Info'],function(Page){
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
