define([
    'BasePage',
    'Util',
    'Menus',
    'text!../../../template/admin/main/headerTpl.html',
    'text!../../../template/admin/main/contentTpl.html'
],
function (BasePage,Util,Menus,headerTpl,contentTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
            that._bindEvent();
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
                    Menus.init({
                        parent:$('#leftContent')
                    });
                }
            });
        },
        _updateInfoHandler:function(){
        	debugger
        },
        _logoutHandler:function(){
        	debugger
        },
        _bindEvent:function(){
        	var that = this;
        	$('#personalInfo').click(function(){
        		require(['login/PersonalInfo'],function(Page){
        			new Page({
        				parent:$('#rightContent')
        			}).initPage();
        			Menus.init({
                        parent:$('#leftContent')
                    });
        		})
        	})
        	$('#logout').click(function(){
        		that.removeCookie('loginId');
        		location.reload()
        	})
        }
    });
});
